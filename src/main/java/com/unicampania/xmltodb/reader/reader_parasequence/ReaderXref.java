package com.unicampania.xmltodb.reader.reader_parasequence;

import com.unicampania.xmltodb.model.parasequence.Xref;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class ReaderXref {

    public ItemReader<Xref> readerXref() {
        StaxEventItemReader<Xref> reader = new StaxEventItemReader<Xref>();
        reader.setResource(new ClassPathResource("aclass.xml"));
        reader.setFragmentRootElementName("xref");
        Jaxb2Marshaller publicFigMarshaller = new Jaxb2Marshaller();
        publicFigMarshaller.setClassesToBeBound(Xref.class);
        reader.setUnmarshaller(publicFigMarshaller);
        return reader;
    }
}
