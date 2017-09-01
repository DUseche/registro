package edu.eci.is.registro.services;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by David Useche on 24/08/2017.
 */
@Service
public class MailService implements IMailService {


    /**
     * Obtener la session del correo
     *
     * @param userName nombre de usuario
     * @param password contrasena
     * @return {@link Session}
     */
    private Session getSession(String userName, String password){
        // create properties field
        Properties properties = new Properties();

        properties.put("mail.pop3s.host", "outlook.office365.com");
        properties.put("mail.pop3s.port", 995);
        properties.put("mail.pop3s.starttls.enable", true);

        properties.put("mail.smtp.host", "smtp.office365.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.auth", true);

        // Setup authentication, get session
        MailAuthenticatorWrapper mailAuthenticatorWrapper = new MailAuthenticatorWrapper(userName, password);

        Session emailSession = Session.getInstance(properties, mailAuthenticatorWrapper);

        return emailSession;
    }

    @Override
    public boolean check(String userName, String password) throws Exception{
        boolean isAuthorized = true;

        try {
            //validate data
            validateECIMail(userName);
            Session emailSession = this.getSession(userName, password);

            Store store = emailSession.getStore("pop3s");
            store.connect();
        } catch (Exception e) {
            isAuthorized = false;
            e.printStackTrace();
            throw new BadCredentialsException(e.getMessage());
        }

        return isAuthorized;
    }

    @Override
    public boolean validateECIMail(String mail) throws Exception{
        if (mail != null) {
            String auxiliar = mail.substring(mail.indexOf("@"), mail.length());
            if (auxiliar.equals(MailService.STUDENT_MAIL) || auxiliar.equals(MailService.NORMAL_MAIL)) {
                return Boolean.TRUE;
            } else {
                throw new Exception("Invalid mail");
            }
        } else {
            throw new Exception("Invalid parameter");
        }
    }

    /**
     * Clase que encapsula la logica para comprobar las credenciales
     */
    public class MailAuthenticatorWrapper extends Authenticator {

        /**
         * Nombre de usuario
         */
        private String userName;

        /**
         * Contraseña
         */
        private String password;

        /**
         * Constructor
         *
         * @param userName nombre de usuario
         * @param password contraseña
         */
        public MailAuthenticatorWrapper(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        /**
         * Verifica las credenciales
         *
         * @return
         */
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(userName, password);
        }
    }
}
