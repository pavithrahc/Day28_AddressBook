package com.bridgelabz;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.*;

public class AddressBookFileIO {
    public void writeData(ArrayList<AddressBook> addressBook){
        StringBuffer addressBookBuffer = new StringBuffer();
        addressBook.forEach(employee ->{
            String empDataString = employee.toString().concat("\n");
            addressBookBuffer.append(empDataString);
        });
        try {
            write(Paths.get("AddressBook.txt"),addressBookBuffer.toString().getBytes());
        }catch (IOException x){
            x.printStackTrace();
        }
    }

    public List<AddressBook> readData() {

        List<AddressBook> addressBookList = new ArrayList<>();
        try {
            lines(new File("AddressBook.txt").toPath())
                    .map(line -> line.trim())
                    .forEach(line -> System.out.println(line));
        }catch (IOException x){
            x.printStackTrace();
        }
        return addressBookList;
    }
}