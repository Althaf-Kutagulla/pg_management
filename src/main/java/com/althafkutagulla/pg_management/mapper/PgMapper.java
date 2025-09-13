package com.althafkutagulla.pg_management.mapper;

import com.althafkutagulla.pg_management.entity.Pg;
import com.althafkutagulla.pg_management.record.PgRecordRequest;
import com.althafkutagulla.pg_management.record.PgRecordResponse;
import org.springframework.stereotype.Component;

@Component
public class PgMapper {
    public Pg toPg(PgRecordRequest pgRecord) {
        return Pg.builder()
                .name(pgRecord.name())
                .build();
    }

    public PgRecordResponse toPgRecordResponse(Pg pg) {
        return new PgRecordResponse(pg.getId(), pg.getName());
    }
}
