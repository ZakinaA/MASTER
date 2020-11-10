/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author Zakina
 */
public class ClientTest {
    
    public static void main(String[] args) throws ParseException {
        
           
            final String gameDate = "2020-11-09 19:45:00";
            final SimpleDateFormat apiFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.FRENCH);
            apiFormat.setTimeZone(TimeZone.getTimeZone("UTC+1"));
            final Date dateOfGame = apiFormat.parse(gameDate);
            final long millis = dateOfGame.getTime() - System.currentTimeMillis();
            System.out.println(dateOfGame.getTime() - System.currentTimeMillis());

            final String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                            TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                            TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            System.out.println(hms);
            
            
    }
    
}
