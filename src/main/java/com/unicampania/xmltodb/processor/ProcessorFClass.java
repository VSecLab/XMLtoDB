package com.unicampania.xmltodb.processor;

import com.unicampania.xmltodb.model.fclass.Fclass;
import org.springframework.batch.item.ItemProcessor;

public class ProcessorFClass implements ItemProcessor<Fclass, Fclass> {

    @Override
    public Fclass process(Fclass fClass) throws Exception {

        return fClass;

    }


}