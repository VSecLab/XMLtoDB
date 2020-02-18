package com.unicampania.xmltodb.reader.reader_parasequence;

import com.unicampania.xmltodb.model.parasequence.Lists;
import com.unicampania.xmltodb.model.parasequence.Xref;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class ReaderList {

    public ItemReader<Lists> readerList() {
        StaxEventItemReader<Lists> reader = new StaxEventItemReader<Lists>();
        reader.setResource(new ClassPathResource("aclass.xml"));
        reader.setFragmentRootElementName("list");
        Jaxb2Marshaller publicFigMarshaller = new Jaxb2Marshaller();
        publicFigMarshaller.setClassesToBeBound(Lists.class);
        reader.setUnmarshaller(publicFigMarshaller);
        return reader;
    }
}
