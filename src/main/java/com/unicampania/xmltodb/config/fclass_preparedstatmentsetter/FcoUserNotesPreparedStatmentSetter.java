package com.unicampania.xmltodb.config.fclass_preparedstatmentsetter;

import com.unicampania.xmltodb.model.fclass.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FcoUserNotesPreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {
    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        for (int i = 0; i < item.getFfamilyList().size(); i++) {
            for (int j = 0; j < item.getFfamilyList().get(i).getFComponentList().size(); j++) {

                for (int k = 0; k < item.getFfamilyList().get(i).getFComponentList().get(j).getFcoUserNotes().getP().size(); k++) {

                    if (item.getFfamilyList().get(i).getFComponentList().get(j).getFcoUserNotes().getP().get(k).getId_para().equals("")) {
                        ps.setString(2, item.getFfamilyList().get(i).getFComponentList().get(j).getId().concat(String.valueOf(k)));
                        ps.setString(5, item.getFfamilyList().get(i).getFComponentList().get(j).getId().concat(String.valueOf(k)));
                    } else {
                        ps.setString(2, item.getFfamilyList().get(i).getFComponentList().get(j).getFcoUserNotes().getP().get(k).getId_para().toUpperCase());
                        ps.setString(5, item.getFfamilyList().get(i).getFComponentList().get(j).getFcoUserNotes().getP().get(k).getId_para().toUpperCase());
                    }
                    ps.setString(1, item.getFfamilyList().get(i).getFComponentList().get(j).getFcoUserNotes().getP().get(k).getType());
                    ps.setString(3, String.valueOf(item.getFfamilyList().get(i).getFComponentList().get(j).getFcoUserNotes().getP().get(k).getCombo()).replace("[", "").replace("]", "").replaceAll("\r\n", " ").trim());
                    ps.setString(4, item.getFfamilyList().get(i).getFComponentList().get(j).getId().toUpperCase());
                    ps.addBatch();
                }

            }
        }
    }
}
