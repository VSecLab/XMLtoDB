package com.unicampania.xmltodb.processor.parasequence_processor;

import com.unicampania.xmltodb.model.parasequence.Url;
import com.unicampania.xmltodb.model.parasequence.Xref;
import org.springframework.batch.item.ItemProcessor;

public class ProcessorXref implements ItemProcessor<Xref, Xref> {

    @Override
    public Xref process(Xref xref) throws Exception {

        return xref;

    }


}