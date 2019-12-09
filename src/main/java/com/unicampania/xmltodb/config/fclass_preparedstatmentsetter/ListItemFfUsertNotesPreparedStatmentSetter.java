package com.unicampania.xmltodb.config.fclass_preparedstatmentsetter;

import com.unicampania.xmltodb.model.fclass.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ListItemFfUsertNotesPreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {

    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        for (int i = 0; i < item.getFfamilyList().size(); i++) {
            for (int j = 0; j < item.getFfamilyList().get(i).getFfUserNotes().getP().size(); j++) {
                if (item.getFfamilyList().get(i).getFfUserNotes().getP().get(j).getLists().size() == 0) {

                } else {
                    for (int k = 0; k < item.getFfamilyList().get(i).getFfUserNotes().getP().get(j).getLists().size(); k++) {
                        for (int z = 0; z < item.getFfamilyList().get(i).getFfUserNotes().getP().get(j).getLists().get(k).getItems().size(); z++) {

                            ps.setString(1, String.valueOf(z));

                            if (item.getFfamilyList().get(i).getFfUserNotes().getP().get(j).getLists().get(k).getItems().get(z).getId_item() == null) {
                                ps.setString(2, String.valueOf(z));
                                ps.setString(5, String.valueOf(z));

                            } else {
                                ps.setString(2, String.valueOf(item.getFfamilyList().get(i).getFfUserNotes().getP().get(j).getLists().get(k).getItems().get(z).getId_item()).toUpperCase());
                                ps.setString(5, String.valueOf(item.getFfamilyList().get(i).getFfUserNotes().getP().get(j).getLists().get(k).getItems().get(z).getId_item()).toUpperCase());
                            }
                            ps.setString(3, String.valueOf(item.getFfamilyList().get(i).getFfUserNotes().getP().get(j).getLists().get(k).getItems().get(z).getCombo()).replace("[", "").replace("]", "").replaceAll("\r\n", " ").trim());

                            ps.setString(4, item.getFfamilyList().get(i).getFfUserNotes().getP().get(j).getId_para());
                            ps.addBatch();
                        }
                    }
                }
            }
        }

    }
}
