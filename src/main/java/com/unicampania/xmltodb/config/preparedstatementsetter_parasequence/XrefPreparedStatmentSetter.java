package com.unicampania.xmltodb.config.preparedstatementsetter_parasequence;

import com.unicampania.xmltodb.model.parasequence.Xref;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class XrefPreparedStatmentSetter implements ItemPreparedStatementSetter<Xref> {
    @Override
    public void setValues(Xref xref, PreparedStatement preparedStatement) throws SQLException {
       preparedStatement.setString(1, xref.getId_xref());
       preparedStatement.setString(2, xref.getShow());
       preparedStatement.setString(3, xref.getIda());
       preparedStatement.setString(4, xref.getId_xref());
    }
}
