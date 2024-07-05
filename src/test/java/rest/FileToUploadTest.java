package rest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class FileToUploadTest {

    @Test
    public void validateEmptyConstructor() {
        FileToUpload fileToUpload = new FileToUpload();
        assertNull(fileToUpload.getMultipartName());
        assertNull(fileToUpload.getFilePath());
    }

    @Test
    public void validateConstructorWithParams() {
        FileToUpload fileToUpload = new FileToUpload("multipartName", "filepath");
        assertEquals("multipartName", fileToUpload.getMultipartName());
        assertEquals("filepath", fileToUpload.getFilePath());
    }

    @Test
    public void validateSetters() {
        FileToUpload fileToUpload = new FileToUpload();
        fileToUpload.setMultipartName("multipartName");
        fileToUpload.setFilePath("filepath");
        assertEquals("multipartName", fileToUpload.getMultipartName());
        assertEquals("filepath", fileToUpload.getFilePath());
    }
}
