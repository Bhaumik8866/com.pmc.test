package org.example.zip4j;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ExcludeFileFilter;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import org.openqa.selenium.io.Zip;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zip4jTest {

    private final String basePath="C:\\Users\\patelbha\\Downloads\\";

    @Test
    public void createZipFile() throws ZipException {
        //Creating a zip file by adding a folder to it / Adding a folder to an existing zip
        new ZipFile("FolderZip.zip").addFolder(new File(basePath+"New Starter_Forms and Documents"));

        //Creating a zip file with single file in it / Adding single file to an existing zip
        new ZipFile("SingleFile.zip").addFile(basePath+"sampleJSON.json");
        new ZipFile("SingleFile.zip").addFile(new File(basePath+"Address.xlsx"));

        //Creating a zip file with multiple files / Adding multiple files to an existing zip
        new ZipFile("MultipleFile.zip").addFiles(Arrays.asList(new File(basePath+"Shipment Data Export.xlsx"),
                new File(basePath+"jdk-18_windows-x64_bin.exe"),
                new File(basePath+"Git-2.37.1-64-bit.exe"),new File(basePath+"IT-185499674-260722-1231.pdf")));

        //Creating a password protected zip file / Adding files to an existing zip with password protection
        ZipParameters zipParameters =new ZipParameters();
        zipParameters.setEncryptFiles(true);
        zipParameters.setEncryptionMethod(EncryptionMethod.AES);
        List<File> files=new ArrayList<>();
        files.add(new File(basePath+"Shipment Data Export.xlsx"));
        files.add(new File(basePath+"IT-185499674-260722-1231.pdf"));
        ZipFile zipFile=new ZipFile("PasswordFile.zip","password".toCharArray());
        zipFile.addFiles(files,zipParameters);

    }

    @Test
    public void extractZipFile() throws ZipException {
        createZipFile();

        //Extracting all files from a zip
        new ZipFile("SingleFile.zip").extractAll(basePath+"ExtractedFiles");
        new ZipFile("MultipleFile.zip").extractAll(
                basePath+"ExtractedFiles\\multipleFile");

        //Extracting all files from a password protected zip

        new ZipFile("PasswordFile.zip","password".toCharArray()).extractAll(basePath+"ExtractedFiles\\passwordFiles");

        //Extracting a single file from zip

        new ZipFile("MultipleFile.zip").extractFile("jdk-18_windows-x64_bin.exe",
                basePath+"ExtractedFiles\\singleExtractedFile");

        //Extracting a folder from zip (since v2.6.0)
        new ZipFile("FolderZip.zip").extractFile("New Starter_Forms and Documents/",
                basePath+"ExtractedFiles\\FolderExtracted");
    }

    @Test
    public void removeFilesFromZip() throws ZipException {
        extractZipFile();
        new ZipFile("MultipleFile.zip").removeFile("jdk-18_windows-x64_bin.exe");
    }
}
