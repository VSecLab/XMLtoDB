package com.unicampania.xmltodb.reader.reader_assurance_paradigm;

import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class ReaderAClass {

    public ItemReader<AClass> readerAClass() {
        StaxEventItemReader<AClass> reader = new StaxEventItemReader<AClass>();
        reader.setResource(new ClassPathResource("aclass2.xml"));
        reader.setFragmentRootElementName("a-class");
        Jaxb2Marshaller publicFigMarshaller = new Jaxb2Marshaller();
        publicFigMarshaller.setClassesToBeBound(AClass.class);
        reader.setUnmarshaller(publicFigMarshaller);
        return reader;
    }
}
