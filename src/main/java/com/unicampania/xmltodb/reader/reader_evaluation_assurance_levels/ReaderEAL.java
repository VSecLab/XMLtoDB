package com.unicampania.xmltodb.reader.reader_evaluation_assurance_levels;

import com.unicampania.xmltodb.model.evaluation_assurance_levels.Eal;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class ReaderEAL {
    public ItemReader<Eal> readerEAL() {
        StaxEventItemReader<Eal> reader = new StaxEventItemReader<Eal>();
        reader.setResource(new ClassPathResource("aclass2.xml"));
        reader.setFragmentRootElementName("eal");
        Jaxb2Marshaller publicFigMarshaller = new Jaxb2Marshaller();
        publicFigMarshaller.setClassesToBeBound(Eal.class);
        reader.setUnmarshaller(publicFigMarshaller);
        return reader;
    }
}
