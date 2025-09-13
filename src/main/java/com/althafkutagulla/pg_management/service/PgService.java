package com.althafkutagulla.pg_management.service;

import com.althafkutagulla.pg_management.record.PgRecordRequest;
import com.althafkutagulla.pg_management.record.PgRecordResponse;

import java.util.List;

public interface PgService {

    public PgRecordResponse createPg(PgRecordRequest pgRecord);

    public List<PgRecordResponse> getAllPg();

    public PgRecordResponse updatePg(PgRecordRequest pgRecord);
    public Boolean deletePg(Integer pgId);
}
