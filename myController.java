/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSAproject.praktek02;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author lenovo
 */


@Controller
public class myController {
    
    @RequestMapping("/nexthalaman")
    public String next(
            @RequestParam(value = "nama") String isipertama,
            @RequestParam(value= "nim") String isikedua,
            @RequestParam(value= "email") String isiketiga,
            @RequestParam(value= "foto") MultipartFile foto,
            Model kurir
    )throws IOException{
        byte[] img = foto.getBytes();
        
        String image = Base64.encodeBase64String(img);  
        String imglink = "data:image/png;base64,".concat(image);
        kurir.addAttribute("paket1", isipertama);
        kurir.addAttribute("paket2", isikedua);
        kurir.addAttribute("paket3", isiketiga);
        kurir.addAttribute("foto1", imglink);
        
        return "viewpage";
    }
}


/*
@Controller
public class myController {
    
    @RequestMapping("/sayank")
    @ResponseBody
    public String getData(
            @RequestParam("nama") String text,
            @RequestParam(value = "img") MultipartFile file,
            @RequestParam("date")
            @DateTimeFormat(pattern="yyy-MM-dd") Date date
    ) throws IOException{
        SimpleDateFormat newTanggal = new SimpleDateFormat("EE-dd-MMMM-yyyy");
        String tanggal = newTanggal.format(date);
        String blob = Base64.encodeBase64String(file.getBytes());
        text = textProcess(text);
        return text+"<br><img src='data:image/jpeg;base64, "+blob+" ' style=\"width:55%; display:block; margin-left:auto; margin-right:auto;\" /><br>"+tanggal;
    }
    
    private String textProcess (String nama){
        String result="";
        if (nama.equals("Asroni")){
            result= nama + "Asoi";
        }
        else if (nama.equals("Haris")){
            result= nama + "Senyum dong";
        }
        else {
            result= nama + "Cakep amat";
        }
        return result;
    }
}*/