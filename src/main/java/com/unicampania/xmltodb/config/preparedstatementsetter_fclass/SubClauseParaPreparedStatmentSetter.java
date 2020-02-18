package com.unicampania.xmltodb.config.preparedstatementsetter_fclass;

import com.unicampania.xmltodb.model.fclass.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubClauseParaPreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {
    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        if (item.getFcInformativeNotes().getSubClause().getId() != null) {
            for (int i = 0; i < item.getFcInformativeNotes().getSubClause().getP().size(); i++) {

                ps.setString(1, item.getFcInformativeNotes().getSubClause().getP().get(i).getType());
                ps.setString(2, item.getFcInformativeNotes().getSubClause().getP().get(i).getId_para().toUpperCase());
                ps.setString(3, String.valueOf(item.getFcInformativeNotes().getSubClause().getP().get(i).getTesto()));
                ps.setString(4, item.getFcInformativeNotes().getSubClause().getId().toUpperCase());
                ps.setString(5, item.getFcInformativeNotes().getSubClause().getP().get(i).getId_para().toUpperCase());
                ps.addBatch();
            }
        }
    }
}
