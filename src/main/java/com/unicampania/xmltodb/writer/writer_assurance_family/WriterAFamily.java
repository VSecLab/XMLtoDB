package com.unicampania.xmltodb.writer.writer_assurance_family;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_family.AFamilyPreparedStatementSetter;
import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterAFamily {
    public JdbcBatchItemWriter<AClass> writerAFamily(DataSource dataSource) {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO afamily(id_afamily, name, ida) VALUES (?,?,?) ON DUPLICATE KEY UPDATE id_afamily = ?");
        writer.setItemPreparedStatementSetter(new AFamilyPreparedStatementSetter());
        return writer;
    }
}
