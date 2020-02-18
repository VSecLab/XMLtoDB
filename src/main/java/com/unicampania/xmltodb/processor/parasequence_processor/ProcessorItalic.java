package com.unicampania.xmltodb.processor.parasequence_processor;

import com.unicampania.xmltodb.model.parasequence.Italic;
import org.springframework.batch.item.ItemProcessor;

public class ProcessorItalic implements ItemProcessor<Italic, Italic> {

    @Override
    public Italic process(Italic italic) throws Exception {

        return italic;

    }


}