package com.unicampania.xmltodb.processor.parasequence_processor;

import com.unicampania.xmltodb.model.parasequence.Url;
import org.springframework.batch.item.ItemProcessor;

public class ProcessorUrl implements ItemProcessor<Url, Url> {

    @Override
    public Url process(Url url) throws Exception {

        return url;

    }


}