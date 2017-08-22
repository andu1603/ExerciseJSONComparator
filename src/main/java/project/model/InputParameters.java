package project.model;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.converters.FileConverter;
import project.FileNamesValidator;

import java.io.File;

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

    @Parameter(names = {"--idForOutput -ifo"})
    private String idForOutput;

    @Parameter(names = {"--idForComparing -ifc"})
    private String idForComparing;

   /* @Parameter(names={"--help", "-h"},
            help = true)
    private boolean help;*/

    public File getFirstFile() {
        return firstFile;
    }

    public void setFirstFile(File firstFile) {
        this.firstFile = firstFile;
    }

    public File getSecondFile() {
        return secondFile;
    }

    public void setSecondFile(File secondFile) {
        this.secondFile = secondFile;
    }

    public String getIdForOutput() {
        return idForOutput;
    }

    public void setIdForOutput(String idForOutput) {
        this.idForOutput = idForOutput;
    }

    public String getIdForComparing() {
        return idForComparing;
    }

    public void setIdForComparing(String idForComparing) {
        this.idForComparing = idForComparing;
    }
}
