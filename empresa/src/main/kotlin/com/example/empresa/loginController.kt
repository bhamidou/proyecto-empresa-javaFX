package com.example.empresa

import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.TextField
import service.EmpleadosServicio
import service.UsuariosServicio

class loginController {
    @FXML
    private lateinit var TFemail: TextField

    @FXML
    private lateinit var TFpassword: TextField

    @FXML
    private lateinit var lbError: Label

    @FXML

    private fun login() {
        var EmpleadosServicio = EmpleadosServicio()
        var UserServicio = UsuariosServicio()

        var email = TFemail.text
        var password = TFpassword.text

        if (UserServicio.login(email, password)) {
            if (EmpleadosServicio.esJefe(email)) {
                try {
                    var constantesController = ConstantesController()
                    constantesController.view("admin-view.fxml")

                } catch (e: Exception) {
                    var constantesController = ConstantesController()
                    constantesController.alertError(e.toString())
                }
            } else {
                try {
                    var constantesController = ConstantesController()
                    var emple = EmpleadosServicio.searchEmpleado(email)
                    if (emple != null) {
                        constantesController.empleado(emple)
                    }

                } catch (e: Exception) {
                    var constantesController = ConstantesController()
                    constantesController.alertError(e.toString())
                }
            }
        } else
            lbError.isVisible = true
            lbError.text = "Inicio de sesión incorrecto"
    }

    @FXML
    private fun signup() {
        var constantesController = ConstantesController()

        try {
            constantesController.view("signup-view.fxml")
        } catch (e: Exception) {
            constantesController.alertError(e.toString())
        }

    }
}