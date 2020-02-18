package com.unicampania.xmltodb.writer.writer_assurance_elements;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_elements.AeEvaluatorPreparedStatementSetter;
import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterAeEvaluator {
    public JdbcBatchItemWriter<AClass> writerAeEvaluator(DataSource dataSource) {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO aeevaluator(id_aeevaluator, testo, ida, idf, id_acomponent) VALUES (?,?,?,?,?) ON DUPLICATE KEY UPDATE id_aeevaluator = ?");
        writer.setItemPreparedStatementSetter(new AeEvaluatorPreparedStatementSetter());
        return writer;
    }
}
