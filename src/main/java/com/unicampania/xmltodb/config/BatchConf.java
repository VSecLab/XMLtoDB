package com.unicampania.xmltodb.config;

import com.unicampania.xmltodb.config.aclass_preparedstatmentsetter.*;
import com.unicampania.xmltodb.config.fclass_preparedstatmentsetter.*;
import com.unicampania.xmltodb.config.parasequence_preparedstatmentsetter.*;
import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import com.unicampania.xmltodb.model.fclass.Fclass;
import com.unicampania.xmltodb.model.parasequence.*;
import com.unicampania.xmltodb.model.parasequence.table.Table;
import com.unicampania.xmltodb.processor.ProcessorFClass;
import com.unicampania.xmltodb.processor.ProcessorAClass;
import com.unicampania.xmltodb.processor.parasequence_processor.*;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
@EnableBatchProcessing
public class BatchConf {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private DataSource dataSource;


    @Bean
    public ProcessorFClass processorFClass() {
        return new ProcessorFClass();
    }
    @Bean
    public ProcessorAClass processorAClass() { return new ProcessorAClass(); }


    @Bean
    public ProcessorItalic processorItalic() { return new ProcessorItalic(); }
    @Bean
    public ProcessorUrl processorUrl() { return new ProcessorUrl(); }
    @Bean
    public ProcessorBold processorBold() { return new ProcessorBold(); }
    @Bean
    public ProcessorXref processorXref() { return new ProcessorXref(); }
    @Bean
    public ProcessorFigure processorFigure() { return new ProcessorFigure(); }
    @Bean
    public ProcessorTable processorTable() { return new ProcessorTable(); }




    @Bean
    ItemReader<Fclass> readerFClass() {
        StaxEventItemReader<Fclass> reader = new StaxEventItemReader<Fclass>();
        reader.setResource(new ClassPathResource("fclass.xml"));
        reader.setFragmentRootElementName("f-class");
        Jaxb2Marshaller publicFigMarshaller = new Jaxb2Marshaller();
        publicFigMarshaller.setClassesToBeBound(Fclass.class);
        reader.setUnmarshaller(publicFigMarshaller);
        return reader;
    }
    @Bean
    ItemReader<AClass> readerAClass() {
        StaxEventItemReader<AClass> reader = new StaxEventItemReader<AClass>();
        reader.setResource(new ClassPathResource("aclass.xml"));
        reader.setFragmentRootElementName("a-class");
        Jaxb2Marshaller publicFigMarshaller = new Jaxb2Marshaller();
        publicFigMarshaller.setClassesToBeBound(AClass.class);
        reader.setUnmarshaller(publicFigMarshaller);
        return reader;
    }


    @Bean
    ItemReader<Italic> readerItalic() {
        StaxEventItemReader<Italic> reader = new StaxEventItemReader<Italic>();
        reader.setResource(new ClassPathResource("aclass.xml"));
        reader.setFragmentRootElementName("italic");
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setClassesToBeBound(Italic.class);
        reader.setUnmarshaller(jaxb2Marshaller);
        return reader;
    }
    @Bean
    ItemReader<Url> readerUrl() {
        StaxEventItemReader<Url> reader = new StaxEventItemReader<Url>();
        reader.setResource(new ClassPathResource("aclass.xml"));
        reader.setFragmentRootElementName("url");
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setClassesToBeBound(Url.class);
        reader.setUnmarshaller(jaxb2Marshaller);
        return reader;
    }
    @Bean
    ItemReader<Bold> readerBold() {
        StaxEventItemReader<Bold> reader = new StaxEventItemReader<Bold>();
        reader.setResource(new ClassPathResource("aclass.xml"));
        reader.setFragmentRootElementName("bold");
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setClassesToBeBound(Bold.class);
        reader.setUnmarshaller(jaxb2Marshaller);
        return reader;
    }
    @Bean
    ItemReader<Xref> readerXref() {
        StaxEventItemReader<Xref> reader = new StaxEventItemReader<Xref>();
        reader.setResource(new ClassPathResource("aclass.xml"));
        reader.setFragmentRootElementName("xref");
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setClassesToBeBound(Xref.class);
        reader.setUnmarshaller(jaxb2Marshaller);
        return reader;
    }
    @Bean
    ItemReader<Figure> readerFigure() {
        StaxEventItemReader<Figure> reader = new StaxEventItemReader<Figure>();
        reader.setResource(new ClassPathResource("aclass.xml"));
        reader.setFragmentRootElementName("figure");
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setClassesToBeBound(Figure.class);
        reader.setUnmarshaller(jaxb2Marshaller);
        return reader;
    }
    @Bean
    ItemReader<Table> readerTable() {
        StaxEventItemReader<Table> reader = new StaxEventItemReader<Table>();
        reader.setResource(new ClassPathResource("aclass.xml"));
        reader.setFragmentRootElementName("table");
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setClassesToBeBound(Table.class);
        reader.setUnmarshaller(jaxb2Marshaller);
        return reader;
    }


    @Bean
    public JdbcBatchItemWriter<AClass> writerAClass() {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO aclass(id, name) VALUES(?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new AClassPreparedStatmentSetter());
        return writer;
    }
    @Bean
    public JdbcBatchItemWriter<AClass> writerAcIntroduction() {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO acintroduction(type, id, para, ida) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new AcIntroductionPreparedStatmentSetter());
        return writer;
    }
    @Bean
    public JdbcBatchItemWriter<AClass> writerAcOverview() {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO acoverview(type, id, para, ida) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new AcOverviewPreparedStatmentSetter());
        return writer;
    }
    @Bean
    public JdbcBatchItemWriter<AClass> writerMaIntroduction() {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO maintroduction(type, id, para, ida) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new MaIntroductionPreparedStatmentSetter());
        return writer;
    }
    @Bean
    public JdbcBatchItemWriter<AClass> writerAcApplicationNotes() {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO acapplicationnotes(type, id, para, ida) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new AcApplicationNotesPreparedStatmentSetter());
        return writer;
    }
    @Bean
    public JdbcBatchItemWriter<AClass> writerMaObjectives() {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO maobjectives(type, id, para, ida) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new MaObjectivesPreparedStatmentSetter());
        return writer;
    }
    @Bean
    public JdbcBatchItemWriter<AClass> writerMaApplicationNotes() {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO maapplicationnotes(id_maapplicationnotes, id_subclausess, id_para, id_figure, id_acronym, id_biblioentry, id_glossentry, id_table, id_example, ida) VALUES (?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE id_maapplicationnotes = ?");
        writer.setItemPreparedStatementSetter(new MaApplicationNotesPreparedStatmentSetter());
        return writer;
    }
    @Bean
    public JdbcBatchItemWriter<AClass> writerAFamily() {
        JdbcBatchItemWriter<AClass> writer = new JdbcBatchItemWriter<AClass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO afamily(id_afamily, id_afobjectives, id_afoverview, id_aflevellingcriteria, id_afapplicationnotes, ida) VALUES(?,?,?,?,?,?) ON DUPLICATE KEY UPDATE id_afamily = ?");
        writer.setItemPreparedStatementSetter(new AFamilyPreparedStatmentSetter());
        return writer;
    }







    @Bean
    public JdbcBatchItemWriter<Url> writerUrl() {
        JdbcBatchItemWriter<Url> writer = new JdbcBatchItemWriter<Url>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO url(id_url) VALUES (?) ON DUPLICATE KEY UPDATE id_url = ?");
        writer.setItemPreparedStatementSetter(new UrlPreparedStatmentSetter());
        return writer;
    }
    @Bean
    public JdbcBatchItemWriter<Bold> writerBold() {
        JdbcBatchItemWriter<Bold> writer = new JdbcBatchItemWriter<Bold>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO bold(id_bold, testo) VALUES (?,?) ON DUPLICATE KEY UPDATE id_bold = ?");
        writer.setItemPreparedStatementSetter(new BoldPreparedStatmentSetter());
        return writer;
    }
    @Bean
    public JdbcBatchItemWriter<Xref> writerXref() {
        JdbcBatchItemWriter<Xref> writer = new JdbcBatchItemWriter<Xref>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO xref(id_xref, showw) VALUES (?,?) ON DUPLICATE KEY UPDATE id_xref = ?");
        writer.setItemPreparedStatementSetter(new XrefPreparedStatmentSetter());
        return writer;
    }
    @Bean
    public JdbcBatchItemWriter<Figure> writerFigure() {
        JdbcBatchItemWriter<Figure> writer = new JdbcBatchItemWriter<Figure>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO figure(id_figure, entity, title, width, height) VALUES (?,?,?,?,?) ON DUPLICATE KEY UPDATE id_figure = ?");
        writer.setItemPreparedStatementSetter(new FigurePrepareStatmentSetter());
        return writer;
    }
    @Bean
    public JdbcBatchItemWriter<Table> writerTable() {
        JdbcBatchItemWriter<Table> writer = new JdbcBatchItemWriter<Table>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO tablee(id_table, width) VALUES (?,?) ON DUPLICATE KEY UPDATE id_table = ?");
        writer.setItemPreparedStatementSetter(new TablePreparedStatmentSetter());
        return writer;
    }
    @Bean
    public JdbcBatchItemWriter<Italic> writerItalic() {
        JdbcBatchItemWriter<Italic> writer = new JdbcBatchItemWriter<Italic>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO italic(id_italic, testo) VALUES (?,?) ON DUPLICATE KEY UPDATE id_italic = ?");
        writer.setItemPreparedStatementSetter(new ItalicPrepareStatmentSetter());
        return writer;
    }




    @Bean
    public JdbcBatchItemWriter<Fclass> writerFclass() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fclass(id,name) VALUES(?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FclassPreparedStatmentSetter());
        return writer;
    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcIntroduction() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcintroduction(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FcIntroductionPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcInformativeNotes() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcinformativenotes(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FcInformativeNotesPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerSubClause() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO subclause(title,id,idf) VALUES(?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new SubClausePreparedStatmentSetter());
        return writer;
    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerSubClausePara() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO subclausepara(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new SubClauseParaPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerListItem() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO listitems(task_id,id,text,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new ListItemPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerFfamily() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO ffamily(id,name,idf) VALUES(?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FfamilyPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerFfBehaviour() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO ffbehaviour(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FfBehaviourPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerFfUserNotes() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO ffusernotes(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FfUserNotesPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerListItemFfUsertNotes() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO listitemsffusernotes(task_id,id,text,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new ListItemFfUsertNotesPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerFfEvaluatorNotes() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO ffevaluatornotes(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FfEvaluatorNotesPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerFComponent() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcomponent(id,name,idf) VALUES(?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FComponentPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcoHierarchical() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcohierarchical(fcomponent,idf) VALUES(?,?) ON DUPLICATE KEY UPDATE fcomponent = ?");
        writer.setItemPreparedStatementSetter(new FcoHierarchicalPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcoDependencies() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcodependencies(id, fcomponent,idf) VALUES(?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FcoDependenciesPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcoUserNotes() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcousernotes(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FcoUserNotesPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcoEvaluatorNotes() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcoevaluatornotes(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FcoEvaluatorNotesPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerListItemFcoUsertNotes() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO listitemsfcousernotes(task_id,id,text,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new ItemBoldPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcoLevelling() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcolevelling(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FcoLevellingPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcoManagament() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcomanagement(num,id,equal,text,idf) VALUES(?,?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FcoManagementPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcoAudit() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcoaudit(num,id,level,equal,text,idf) VALUES(?,?,?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FcoAuditPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcoRationale() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcorationale(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FcoRationalePreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerFElement() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO felement(num,idr,id,text,idf) VALUES(?,?,?,?,?) ON DUPLICATE KEY UPDATE idr = ?");
        writer.setItemPreparedStatementSetter(new FEelementPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerFeAssignmentitem() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO feassignmentitem(idr,text,idf) VALUES(?,?,?) ON DUPLICATE KEY UPDATE idr = ?");
        writer.setItemPreparedStatementSetter(new FeAssignmentitemPreparedStatmentSetter());
        return writer;
    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerFeAssignmentNotes() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO feassignmentnotes(type, id, para, idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FeAssignmentNotesPreparedStatmentSetter());
        return writer;

    }


    @Bean
    public Step step1() {
        return stepBuilderFactory.get("FClass writing").<Fclass, Fclass>chunk(100)
                .reader(readerFClass())
                .processor(processorFClass())
                .writer(compositeItemWriterFClass())
                .build();
    }
    @Bean
    public Step step2() {
        return stepBuilderFactory.get("AClass writing").<AClass, AClass>chunk(100)
                .reader(readerAClass())
                .processor(processorAClass())
                .writer(compositeItemWriterAClass())
                .build();
    }
    @Bean
    public Step step3() {
        return stepBuilderFactory.get("Xref writing").<Xref, Xref>chunk(100)
                .reader(readerXref())
                .processor(processorXref())
                .writer(writerXref())
                .build();
    }
    @Bean
    public Step step4() {
        return stepBuilderFactory.get("Url writing").<Url, Url>chunk(100)
                .reader(readerUrl())
                .processor(processorUrl())
                .writer(writerUrl())
                .build();
    }
    @Bean
    public Step step5() {
        return stepBuilderFactory.get("Bold writing").<Bold, Bold>chunk(100)
                .reader(readerBold())
                .processor(processorBold())
                .writer(writerBold())
                .build();
    }
    @Bean
    public Step step6() {
        return stepBuilderFactory.get("Figure writing").<Figure, Figure>chunk(100)
                .reader(readerFigure())
                .processor(processorFigure())
                .writer(writerFigure())
                .build();
    }
    @Bean
    public Step step7() {
        return stepBuilderFactory.get("Table writing").<Table, Table>chunk(100)
                .reader(readerTable())
                .processor(processorTable())
                .writer(writerTable())
                .build();
    }
    @Bean
    public Step step8() {
        return stepBuilderFactory.get("Italic writing").<Italic, Italic>chunk(100)
                .reader(readerItalic())
                .processor(processorItalic())
                .writer(writerItalic())
                .build();
    }


    @Bean
    public Job exportFClassJob() {
        return jobBuilderFactory.get("importFClassJob").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
    }
    @Bean
    public Job exportAClassJob() {
        return jobBuilderFactory.get("importAClassJob").incrementer(new RunIdIncrementer()).flow(step2()).end().build();
    }
    @Bean
    public Job exportXrefJob() {
        return jobBuilderFactory.get("importXrefJob").incrementer(new RunIdIncrementer()).flow(step3()).end().build();
    }
    @Bean
    public Job exportUrlJob() {
        return jobBuilderFactory.get("importUrlJob").incrementer(new RunIdIncrementer()).flow(step4()).end().build();
    }
    @Bean
    public Job exportBoldJob() {
        return jobBuilderFactory.get("importUrlJob").incrementer(new RunIdIncrementer()).flow(step5()).end().build();
    }
    @Bean
    public Job exportFigureJob() {
        return jobBuilderFactory.get("importFigureJob").incrementer(new RunIdIncrementer()).flow(step6()).end().build();
    }
    @Bean
    public Job exportTableJob() {
        return jobBuilderFactory.get("importTableJob").incrementer(new RunIdIncrementer()).flow(step7()).end().build();
    }
    @Bean
    public Job exportItalicJob() {
        return  jobBuilderFactory.get("importItalicJob").incrementer(new RunIdIncrementer()).flow(step8()).end().build();
    }




    public CompositeItemWriter<AClass> compositeItemWriterAClass() {
        CompositeItemWriter writer = new CompositeItemWriter();
        writer.setDelegates(Arrays.asList(
                writerAClass(),
                writerAcIntroduction(),
                writerAcOverview(),
                writerMaIntroduction(),
                writerAcApplicationNotes(),
                writerMaObjectives(),
         //       writerMaApplicationNotes(),
                writerAFamily()
                )
        );

        return writer;
    }
    public CompositeItemWriter<Fclass> compositeItemWriterFClass() {
        CompositeItemWriter writer = new CompositeItemWriter();
        writer.setDelegates(Arrays.asList(
                writerFclass(),
                writerFcIntroduction(),
                writerFcInformativeNotes(),
                writerSubClause(),
                writerSubClausePara(),
                writerListItem(),
                writerFfamily(),
                writerFfBehaviour(),
                writerFfUserNotes(),
                writerListItemFfUsertNotes(),
                writerFfEvaluatorNotes(),
                writerFComponent(),
                writerFcoHierarchical(),
                writerFcoDependencies(),
                writerFcoUserNotes(),
                writerListItemFcoUsertNotes(),
                writerFcoEvaluatorNotes(),
                writerFcoLevelling(),
                writerFcoManagament(),
                writerFcoAudit(),
                writerFcoRationale(),
                writerFElement(),
                writerFeAssignmentitem(),
                writerFeAssignmentNotes()));
        return writer;
    }
}

