package dev_reza.spring_webmvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Files;
import java.nio.file.Path;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UploadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUpload() throws Exception {
        // Ensure the directory exists
        Path uploadDir = Path.of("upload");
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }

        mockMvc.perform(
                multipart("/upload/profile")
                        .file(new MockMultipartFile("profile", "profile.png", "image/png",
                                getClass().getResourceAsStream("/images/profile.png")))
                        .param("name", "Reza")
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString(
                                "Success save Reza to upload\\profile.png")));

        // Cleanup uploaded file after test
        Files.deleteIfExists(uploadDir.resolve("profile.png"));
    }
}
