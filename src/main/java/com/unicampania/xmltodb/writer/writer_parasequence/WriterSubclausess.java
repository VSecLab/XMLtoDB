package com.unicampania.xmltodb.writer.writer_parasequence;

import com.unicampania.xmltodb.config.preparedstatementsetter_parasequence.SubclausessPreparedStatementSetter;
import com.unicampania.xmltodb.config.preparedstatementsetter_parasequence.XrefPreparedStatmentSetter;
import com.unicampania.xmltodb.model.parasequence.Subclause;
import com.unicampania.xmltodb.model.parasequence.Xref;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class WriterSubclausess {
    public JdbcBatchItemWriter<Subclause> writerSubclausess(DataSource dataSource) {
        JdbcBatchItemWriter<Subclause> writer = new JdbcBatchItemWriter<Subclause>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO subclausess(id_subclausess, title, testo) VALUES (?,?,?) ON DUPLICATE KEY UPDATE id_subclausess = ?");
        writer.setItemPreparedStatementSetter(new SubclausessPreparedStatementSetter());
        return writer;
    }
}
