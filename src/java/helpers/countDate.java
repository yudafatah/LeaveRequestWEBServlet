/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author yudafatah
 */
public class countDate {
    
    public static int countDays(String startDate, String endDate) throws Exception {
    int workingDays = 0;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    Calendar startdate = Calendar.getInstance();
    startdate.setTime(sdf.parse(startDate));
    Calendar enddate = Calendar.getInstance();
    enddate.setTime(sdf.parse(endDate));

    while (!startdate.after(enddate)) {
        int day = startdate.get(Calendar.DAY_OF_WEEK);
        System.out.println(day);
        if ((day != Calendar.SATURDAY) && (day != Calendar.SUNDAY)) {
            workingDays++;
        }

        // increment start date, otherwise while will give infinite loop
        startdate.add(Calendar.DATE, 1);
    }

    return workingDays;
}
}
