package com.unicampania.xmltodb.writer.writer_assurance_elements;

import com.unicampania.xmltodb.config.preparedstatementsetter_assurance.preparedstatementsetter_assurance_elements.MWorkunitPreparedStatementSetter;
import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterMWorkunit {
    public JdbcBatchItemWriter<AClass> writerMWorkunit(DataSource dataSource) {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO mworkunit(id_mworkunit, testo, ida, idf, id_acomponent, id_aeevaluator) VALUES (?,?,?,?,?,?) ON DUPLICATE KEY UPDATE id_mworkunit = ?");
        writer.setItemPreparedStatementSetter(new MWorkunitPreparedStatementSetter());
        return writer;
    }
}
