package com.patryk.app.input;

import com.patryk.app.output.OutputAPI;

import java.io.InputStream;

/**
 * provides scanner and validation methods
 *
 * @author Patryk Kucharski
 */
public class InputAPI {

    private ScannerWrapper scannerWrapper;
    private InputValidator inputValidator;

    public InputAPI(InputStream inputStream, OutputAPI outputAPI) {
        scannerWrapper = new ScannerWrapper(inputStream);
        inputValidator = new InputValidator(outputAPI);
    }

    public String getInputFromUser() {
        return scannerWrapper.returnNextLine();
    }

    public boolean validateRow(String row, int rows) {
        return inputValidator.validateRow(row, rows);
    }

    public boolean validateColumn(String column, int columns) {
        return inputValidator.validateColumn(column, columns);
    }

}
