package com.unicampania.xmltodb.config.preparedstatementsetter_fclass;

import com.unicampania.xmltodb.model.fclass.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FcInformativeNotesPreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {


    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        if(item.getFcInformativeNotes() == null){
            ps.clearBatch();
        }else{
            for (int i = 0; i < item.getFcInformativeNotes().getP().size(); i++) {

                ps.setString(1, item.getFcInformativeNotes().getP().get(i).getType());
                if(item.getFcInformativeNotes().getP().get(i).getId_para()== null){
                    ps.setString(2, String.valueOf(i));
                }else {
                    ps.setString(2, item.getFcInformativeNotes().getP().get(i).getId_para().toUpperCase());
                }
                ps.setString(3, String.valueOf(item.getFcInformativeNotes().getP().get(i).getCombo()).replace("[", "").replace("]", "").replaceAll("\r\n", " ").trim());
                ps.setString(4, item.getId().toUpperCase());
                ps.setString(5, item.getFcInformativeNotes().getP().get(i).getId_para().toUpperCase());
                ps.addBatch();

            }
        }
    }
}
