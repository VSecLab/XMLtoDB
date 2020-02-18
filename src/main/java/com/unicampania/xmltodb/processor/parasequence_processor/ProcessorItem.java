package com.unicampania.xmltodb.processor.parasequence_processor;


import com.unicampania.xmltodb.model.parasequence.Item;
import org.springframework.batch.item.ItemProcessor;

public class ProcessorItem implements ItemProcessor<Item, Item> {

    @Override
    public Item process(Item item) throws Exception {

        return item;

    }
}
