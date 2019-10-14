package com.unicampania.xmltodb.processor;

import com.unicampania.xmltodb.model.aclass.AClass;
import org.springframework.batch.item.ItemProcessor;

public class ProcessorAClass implements ItemProcessor<AClass, AClass> {

    @Override
    public AClass process(AClass aClass) throws Exception {

        return aClass;

    }


}