package com.unicampania.xmltodb.config.aclass_preparedstatmentsetter;

import com.unicampania.xmltodb.model.aclass.AClass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AcOverviewPreparedStatmentSetter implements ItemPreparedStatementSetter<AClass> {

    @Override
    public void setValues(AClass item, PreparedStatement ps) throws SQLException {
        for (int i = 0; i < item.getAcOverview().getP().size(); i++) {

            ps.setString(1, item.getAcOverview().getP().get(i).getType().toUpperCase());
            ps.setString(2, item.getId().concat(Integer.toString(i)));
            ps.setString(3, String.valueOf(item.getAcOverview()
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

