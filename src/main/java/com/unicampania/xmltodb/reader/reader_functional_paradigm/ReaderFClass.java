package com.unicampania.xmltodb.reader.reader_functional_paradigm;

import com.unicampania.xmltodb.model.fclass.Fclass;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class ReaderFClass {
    public ItemReader<Fclass> readerFClass() {
        StaxEventItemReader<Fclass> reader = new StaxEventItemReader<Fclass>();
        reader.setResource(new ClassPathResource("fclass.xml"));
        reader.setFragmentRootElementName("f-class");
        Jaxb2Marshaller publicFigMarshaller = new Jaxb2Marshaller();
        publicFigMarshaller.setClassesToBeBound(Fclass.class);
        reader.setUnmarshaller(publicFigMarshaller);
        return reader;
    }
}
