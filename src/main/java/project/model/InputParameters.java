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
            , description = ""
            , validateWith = FileNamesValidator.class
            , converter = com.beust.jcommander.converters.FileConverter.class
            , required = true
    )
    private File firstFile;

    @Parameter(names = {"--secondFile", "-sf"}
            , description = ""
            , validateWith = FileNamesValidator.class
            , converter = FileConverter.class
            , required = true
    )
    private File secondFile;

    @Parameter(names = {"--idForComparing", "-ifc"})
    private String idForComparing;

    @Parameter(names = {"-outputFile","-of"})
    private String fileName;

   /* @Parameter(names={"--help", "-h"},
            help = true)
    private boolean help;*/
}
