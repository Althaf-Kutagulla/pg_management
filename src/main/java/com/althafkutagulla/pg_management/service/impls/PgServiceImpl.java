package com.althafkutagulla.pg_management.service.impls;

import com.althafkutagulla.pg_management.entity.Pg;
import com.althafkutagulla.pg_management.mapper.PgMapper;
import com.althafkutagulla.pg_management.record.PgRecordRequest;
import com.althafkutagulla.pg_management.record.PgRecordResponse;
import com.althafkutagulla.pg_management.repository.PgRepository;
import com.althafkutagulla.pg_management.service.PgService;
import com.althafkutagulla.pg_management.validations.PgId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PgServiceImpl implements PgService {

    private final PgRepository pgRepository;
    private final PgMapper pgMapper;

    @Override
    public PgRecordResponse createPg(PgRecordRequest pgRecord) {
        Pg pg = pgMapper.toPg(pgRecord);
        return pgMapper.toPgRecordResponse(pgRepository.save(pg));
    }

    @Override
    public List<PgRecordResponse> getAllPg() {
        List<Pg> pgs = pgRepository.findAll();
        return pgs.stream().map(pg -> new PgRecordResponse(pg.getId(),pg.getName())).toList();
    }

    @Override
    public PgRecordResponse updatePg(PgRecordRequest pgRecord) {
        Pg pg = pgRepository.findById(pgRecord.id()).orElseThrow(()->new RuntimeException("Pg Not Found with id: " + pgRecord.id()));
        pg.setName(pgRecord.name());
        return pgMapper.toPgRecordResponse(pgRepository.save(pg));
    }

    @Override
    public Boolean deletePg(Integer pgId) {
        Pg pg = pgRepository.findById(pgId).orElseThrow(()->new RuntimeException("Pg Not Found with id: " + pgId));
        pgRepository.delete(pg);
        return true;
    }


}
