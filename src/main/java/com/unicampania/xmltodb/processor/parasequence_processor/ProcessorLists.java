package com.unicampania.xmltodb.processor.parasequence_processor;

import com.unicampania.xmltodb.model.parasequence.Lists;

import org.springframework.batch.item.ItemProcessor;

public class ProcessorLists implements ItemProcessor<Lists, Lists> {

        @Override
        public Lists process(Lists lists) throws Exception {

            return lists;

        }
}
