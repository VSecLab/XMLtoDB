package com.unicampania.xmltodb.config.aclass_preparedstatmentsetter;

import com.unicampania.xmltodb.model.aclass.AClass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaObjectivesPreparedStatmentSetter implements ItemPreparedStatementSetter<AClass> {
    @Override
    public void setValues(AClass item, PreparedStatement ps) throws SQLException {
        if (item.getMaObjectives().getP().size() == 0) {
            ps.setString(1, "");
            ps.setString(2, "");
            ps.setString(3, "");
            ps.setString(4, item.getId().toUpperCase());
            ps.setString(5, "");
        } else {
            for (int i = 0; i < item.getMaObjectives().getP().size(); i++) {

                ps.setString(1, item.getMaObjectives().getP().get(i).getType().toUpperCase());
                ps.setString(2, item.getId().concat(Integer.toString(i)).toUpperCase());
                ps.setString(3, String.valueOf(item.getMaObjectives()
                        .getP()
                        .get(i)
                        .getCombo())
                        .replace("[", "")
                        .replace("]", ""));
                ps.setString(4, item.getId().toUpperCase());
                ps.setString(5, item.getId().concat(Integer.toString(i)).toUpperCase());
                ps.addBatch();
            }
        }
    }
}
