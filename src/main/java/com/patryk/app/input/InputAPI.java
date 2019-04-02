package com.patryk.app.input;


import java.io.InputStream;

/**
 * @author Patryk Kucharski
 */
public class InputAPI {

    private ScannerWrapper scannerWrapper;

    public InputAPI(InputStream inputStream){
        scannerWrapper = new ScannerWrapper(inputStream);
    }

    public String getInputFromUser(){
        return scannerWrapper.returnNextLine();
    }



}
