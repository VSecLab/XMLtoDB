package com.unicampania.xmltodb.config.fclass_preparedstatmentsetter;

import com.unicampania.xmltodb.model.fclass.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FfUserNotesPreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {

    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        for (int i = 0; i < item.getFfamilyList().size(); i++) {

            for (int j = 0; j < item.getFfamilyList().get(i).getFfUserNotes().getP().size(); j++) {

                ps.setString(1, item.getFfamilyList().get(i).getFfUserNotes().getP().get(j).getType());
                ps.setString(2, item.getFfamilyList().get(i).getFfUserNotes().getP().get(j).getId().toUpperCase());
                ps.setString(3, String.valueOf(item.getFfamilyList().get(i).getFfUserNotes().getP().get(j).getCombo()).replace("[", "").replace("]", "").replaceAll("\r\n", " ").trim());
                ps.setString(4, item.getFfamilyList().get(i).getId().toUpperCase());
                ps.setString(5, item.getFfamilyList().get(i).getFfUserNotes().getP().get(j).getId().toUpperCase());
                ps.addBatch();

            }

        }

    }
}
