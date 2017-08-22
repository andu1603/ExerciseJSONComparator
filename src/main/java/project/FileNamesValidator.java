package project;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import java.io.File;
import java.io.FileReader;

public class FileNamesValidator implements IParameterValidator {
    public void validate(String parameterName, String fileName) throws ParameterException {
        if (!new File(fileName).exists())
            throw new ParameterException("File " + fileName + " doesn't exist");
    }
}
