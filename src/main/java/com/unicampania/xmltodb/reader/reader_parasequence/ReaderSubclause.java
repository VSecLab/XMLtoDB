package com.unicampania.xmltodb.reader.reader_parasequence;

import com.unicampania.xmltodb.model.parasequence.Subclause;
import com.unicampania.xmltodb.model.parasequence.Xref;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class ReaderSubclause {

    public ItemReader<Subclause> readerSubclause() {
        StaxEventItemReader<Subclause> reader = new StaxEventItemReader<Subclause>();
        reader.setResource(new ClassPathResource("aclass2.xml"));
        reader.setFragmentRootElementName("subclause");
        Jaxb2Marshaller publicFigMarshaller = new Jaxb2Marshaller();
        publicFigMarshaller.setClassesToBeBound(Subclause.class);
        reader.setUnmarshaller(publicFigMarshaller);
        return reader;
    }
}

