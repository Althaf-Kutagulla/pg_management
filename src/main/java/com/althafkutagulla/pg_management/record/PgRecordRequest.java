package com.althafkutagulla.pg_management.record;


import com.althafkutagulla.pg_management.validations.PgId;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PgRecordRequest(
        @NotNull(groups = PgId.class, message = "id can't be null") Integer id,
        @NotEmpty(message = "pg name shouldn't be empty")
        @NotBlank(message = "pg name shouldn't be blank")
        String name
) {
}
