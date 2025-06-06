package com.vts.pfms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;

public class Zipper
{

    public void pack(String filePath,InputStream IS,String FullPath,String FileName,String Pass) throws ZipException
    {
        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setFileNameInZip(filePath);
        zipParameters.setCompressionMethod(CompressionMethod.STORE);
        zipParameters.setEncryptFiles(true);
        zipParameters.setEncryptionMethod(EncryptionMethod.AES);
        // Below line is optional. AES 256 is used by default. You can override it to use AES 128. AES 192 is supported only for extracting.
        zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);
        Path docPath = Paths.get(FullPath,FileName);
        new ZipFile(docPath.toString()+".zip",Pass.toCharArray()).addStream(IS, zipParameters);
    }

    public void unpack(String sourceZipFilePath, String extractedZipFilePath,String Pass) throws ZipException
    {
    	new ZipFile(sourceZipFilePath, Pass.toCharArray()).extractAll(extractedZipFilePath);
    }
    public void extractWithZipInputStream(File zipFile, char[] password) throws IOException {
        LocalFileHeader localFileHeader;
        int readLen;
        byte[] readBuffer = new byte[256];

        InputStream inputStream = new FileInputStream(zipFile);
        try (ZipInputStream zipInputStream = new ZipInputStream(inputStream, password)) {
          while ((localFileHeader = zipInputStream.getNextEntry()) != null) {
            File extractedFile = new File(localFileHeader.getFileName());
            try (OutputStream outputStream = new FileOutputStream(extractedFile)) {
              while ((readLen = zipInputStream.read(readBuffer)) != -1) {
                outputStream.write(readBuffer, 0, readLen);
                outputStream.close();
              }
            }
          }
        }
      }
  
}