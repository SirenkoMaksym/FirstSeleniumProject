/*
 * created by max$
 */


package com.ait.utils;

import com.ait.models.UserRegistred;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> AddNewAccountFromCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/accout.csv")));
        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(",");
            list.add(new Object[]{new UserRegistred()
                    .setFirstname(split[0])
                    .setLastName(split[1])
                    .setEmail(split[2])
                    .setPassword(split[3])
                    .setConfirmPasswor(split[4])});
            line = reader.readLine();
        }


        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> AddNewAccount(){

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"Bob", "Sholz", "scholz@mail.ru", "Password1", "Password1"});
        list.add(new Object[]{"Bobi", "Shulz", "schulz@gmail.com", "Password2", "Password2"});
        list.add(new Object[]{"Bobik", "Shilz", "schilz@gmail.com", "Password3", "Password3"});


        return list.iterator();
    }
}
