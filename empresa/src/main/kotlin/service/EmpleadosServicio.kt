package service

import model.empleado.Empleado
import model.empleado.EmpleadoDAOImpl
import model.user.UserDAOImpl

class EmpleadosServicio {
    constructor()
    var emple = EmpleadoDAOImpl()

    fun eliminar(Id:Int):Boolean{
        return emple.deleteEmpleado(Id)
    }

    fun selecionarEmpleados():List<Empleado>{
        return emple.getEmpleados()
    }
    fun login(email:String, password:String):Boolean{
        return emple.login(email, password)
    }

    fun esJefe(email:String):Boolean{
        return emple.esJefe(email)
    }

    fun searchEmpleado(email:String): Empleado? {
        return emple.getEmpleadoByEmail(email)
    }

    fun darAlta(empleado: Empleado):Boolean{
        return emple.insertEmpleado(empleado)
    }



}