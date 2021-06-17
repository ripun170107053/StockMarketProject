package userAuth.controller;

import com.project.ripunjoy.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import userAuth.dao.UserRepository;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

@RestController
public class  UserController
{
    @Autowired
    UserRepository userrepo;

    @RequestMapping(value="/allUsers", method= RequestMethod.GET)
    public List<UserEntity> x()
    {
        return userrepo.findAll();
    }
    @CrossOrigin(origins ="http://localhost:3000", allowedHeaders = "*")
    @RequestMapping(value = "/setuserapi",method=RequestMethod.GET)
    public String Stringreactuserapi(@RequestParam Map<String, String> userobj)
    {
        UserEntity usr = new UserEntity();

        usr.setUsername(userobj.get("username")+"from api1");
        usr.setPassword(userobj.get("password"));
        usr.setEmail(userobj.get("email"));
        //usr.setUserType(userobj.get("usertype"));

        userrepo.saveAndFlush(usr);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "UserController");
        headers.add("Access-Control-Allow-Origin", "*");
        sendemail(usr.getId()) ;
        return userobj.toString();
    }

    @CrossOrigin(origins ="http://localhost:3001", allowedHeaders = "*")
    @RequestMapping(value = "/setuserapi2",method=RequestMethod.POST, headers = "Accept=application/json"  )
    public  ResponseEntity<Object> reactuserapi2(@RequestBody UserEntity user) throws ClassNotFoundException, IOException {


        UserEntity usrsaved = userrepo.save(user);
        // make sure your entity class properties of user are in lower case and match the json,to avoid errors
        System.out.println(user +"check this " +usrsaved.getUsername());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usrsaved.getId())
                .toUri();
        sendemail(usrsaved.getId()) ;

        return ResponseEntity.created(location).build();
    }



    @RequestMapping(value = "/settestuser",method=RequestMethod.GET)
    public ResponseEntity<UserEntity> getUser()
    {
        UserEntity usr = new UserEntity();

        usr.setUsername("Ripunjoy");
        usr.setPassword("password");
        usr.setEmail("cricketripunjoy@gmail.com");

        userrepo.save(usr);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "UserController");
        sendemail(usr.getId()) ;
        return ResponseEntity.accepted().headers(headers).body(usr);
    }




    public void sendemail(Long userid)
    {


        final String username = "cheggexpert1337@gmail.com";
        final String password = "LetsLearn@123";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("cricketripunjoy@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("cricketripunjoy@gmail.com")
            );
            message.setSubject("User Registration confirmation email");
            //     message.setText("Dear Mail Crawler,"
            //           + "\n\n Please do not spam my email!");
            message.setContent(
                    "<h1><a href =\"http://127.0.0.1:8080/confirmuser/"+userid+"/\"> Click to confirm </a></h1>",
                    "text/html");
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(value="/confirmuser/{userid}", method=RequestMethod.GET)
    public String welcomepage(@PathVariable Long userid) throws EntityNotFoundException {
        Optional<UserEntity> userlist =   userrepo.findById(userid);
        //do a null check for home work
        UserEntity usr = new UserEntity();
        usr = userrepo.getById(userid);
        usr.setConfirmed(true);
        userrepo.save(usr);
        return "User confirmed " +usr.getUsername();
    }

}
