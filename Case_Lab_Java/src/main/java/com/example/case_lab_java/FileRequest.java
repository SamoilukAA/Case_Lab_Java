package com.example.case_lab_java;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record FileRequest(
        @NotNull
        String file_base64,
        @NotNull
        String description
) {
}
