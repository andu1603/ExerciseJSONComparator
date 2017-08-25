package project.validators;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;
import project.exceptions.IncorrectInputParametersException;

import java.io.File;

public class FileNamesValidator implements IParameterValidator {
    public void validate(String parameterName, String fileName) throws ParameterException {
        if (!new File(fileName).exists())
            throw new IncorrectInputParametersException(String.format("File %s doesn't exist", fileName));
    }
}
