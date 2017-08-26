package edu.eci.is.registro.services;

import java.util.Date;

public interface IMailService {
    /**
     * Correo de estudiantes
     */
    public static final String STUDENT_MAIL = "@mail.escuelaing.edu.co";

    /**
     * Correo general
     */
    public static final String NORMAL_MAIL = "@escuelaing.edu.co";

    /**
     * Permite saber si las credenciales de un correo electrónico son correctas
     * @param userName nombre de usuario
     * @param password contraseña
     * @return True si son correctas
     */
    boolean check(String userName, String password) throws Exception;

    /**
     * Validar que el correo ingresado sea de la Escuela Colombiana de Ingenieros
     * @return True si pertenece
     */
    boolean validateECIMail(String mail) throws Exception;


}
