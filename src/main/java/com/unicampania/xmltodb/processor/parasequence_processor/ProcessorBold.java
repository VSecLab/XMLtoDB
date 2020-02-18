package com.unicampania.xmltodb.processor.parasequence_processor;

import com.unicampania.xmltodb.model.parasequence.Bold;
import org.springframework.batch.item.ItemProcessor;

public class ProcessorBold implements ItemProcessor<Bold, Bold> {

    @Override
    public Bold process(Bold bold) throws Exception {

        return bold;

    }


}