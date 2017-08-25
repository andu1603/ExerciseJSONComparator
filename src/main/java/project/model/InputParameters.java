package project.model;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.converters.FileConverter;
import lombok.Getter;
import lombok.Setter;
import project.validators.FileNamesValidator;

import java.io.File;

@Getter
@Setter
public class InputParameters {
    @Parameter(names = {"--firstFile", "-ff"}
            , description = "Name of the first file for comparison."
            , validateWith = FileNamesValidator.class
            , converter = com.beust.jcommander.converters.FileConverter.class
            , required = true
    )
    private File firstFile;

    @Parameter(names = {"--secondFile", "-sf"}
            , description = "Name of the second file for comparison."
            , validateWith = FileNamesValidator.class
            , converter = FileConverter.class
            , required = true
    )
    private File secondFile;

    @Parameter(names = {"--idForComparison", "-ifc"}
            , description = "JSON parameter name to be compared.")
    private String idForComparing;

    @Parameter(names = {"-outputFile", "-of"}
            , description = "Name of the file for output result.")
    private String fileName;

   /* @Parameter(names={"--help", "-h"},//TODO:think about help case
            help = true)
    private boolean help;*/
}
