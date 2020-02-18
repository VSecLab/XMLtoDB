package com.unicampania.xmltodb.config;


import com.unicampania.xmltodb.model.evaluation_assurance_levels.Eal;
import com.unicampania.xmltodb.reader.reader_evaluation_assurance_levels.ReaderEAL;
import com.unicampania.xmltodb.reader.reader_functional_paradigm.ReaderFClass;
import com.unicampania.xmltodb.reader.reader_assurance_paradigm.ReaderAClass;
import com.unicampania.xmltodb.reader.reader_parasequence.ReaderList;
import com.unicampania.xmltodb.model.assurance_paradigm.AClass;
import com.unicampania.xmltodb.model.fclass.Fclass;
import com.unicampania.xmltodb.model.parasequence.*;
import com.unicampania.xmltodb.processor.ProcessorAClass;
import com.unicampania.xmltodb.processor.ProcessorFClass;
import com.unicampania.xmltodb.reader.reader_parasequence.ReaderSubclause;
import com.unicampania.xmltodb.reader.reader_parasequence.ReaderXref;
import com.unicampania.xmltodb.writer.writer_assurance_component.*;
import com.unicampania.xmltodb.writer.writer_assurance_elements.WriterAeContent;
import com.unicampania.xmltodb.writer.writer_assurance_elements.WriterAeDeveloper;
import com.unicampania.xmltodb.writer.writer_assurance_elements.WriterAeEvaluator;
import com.unicampania.xmltodb.writer.writer_assurance_elements.WriterMWorkunit;
import com.unicampania.xmltodb.writer.writer_assurance_family.*;
import com.unicampania.xmltodb.writer.writer_assurance_paradigm.*;
import com.unicampania.xmltodb.writer.writer_evaluation_assurance_levels.WriterEAL;
import com.unicampania.xmltodb.writer.writer_evaluation_assurance_levels.WriterEalAssuranceComponents;
import com.unicampania.xmltodb.writer.writer_evaluation_assurance_levels.WriterEalComponent;
import com.unicampania.xmltodb.writer.writer_evaluation_assurance_levels.WriterEalObjectives;
import com.unicampania.xmltodb.writer.writer_functional_paradigm.*;
import com.unicampania.xmltodb.writer.writer_parasequence.WriterSubclausess;
import com.unicampania.xmltodb.writer.writer_parasequence.WriterXref;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
;
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
    public ProcessorAClass processorAClass() {
        return new ProcessorAClass();
    }
    @Bean
    public ReaderFClass readerFClass() {
        return new ReaderFClass();
    }
    @Bean
    public ReaderAClass readerAClass() {
        return new ReaderAClass();
    }
    @Bean
    public ReaderEAL readerEAL() { return new ReaderEAL(); }
    @Bean
    public ReaderList readerList() {
        return new ReaderList();
    }
    @Bean
    public ReaderXref readerXref() {
        return new ReaderXref();
    }
    @Bean
    public ReaderSubclause readerSubclause() { return new ReaderSubclause(); }
    @Bean
    public WriterAClass writerAClass() {
        return new WriterAClass();
    }
    @Bean
    public WriterFClass writerFClass() {
        return new WriterFClass();
    }
    @Bean
    public WriterFcIntroduction writerFcIntroduction() { return new WriterFcIntroduction(); }
    @Bean
    public WriterFcInformativeNotes writerFcInformativeNotes() { return new WriterFcInformativeNotes(); }
    @Bean
    public WriterSubClause writerSubClause() { return new WriterSubClause(); }
    @Bean
    public WriterSubClausePara writerSubClausePara() {return new WriterSubClausePara(); }
    @Bean
    public WriterListItem writerListItem() { return new WriterListItem(); }
    @Bean
    public WriterFfamily writerFfamily() { return new WriterFfamily(); }
    @Bean
    public WriterFfBehaviour writerFfBehaviour() { return new WriterFfBehaviour(); }
    @Bean
    public WriterFfUserNotes writerFfUserNotes() { return new WriterFfUserNotes(); }
    @Bean
    public WriterListItemFfUserNotes writerListItemFfUserNotes() { return new WriterListItemFfUserNotes(); }
    @Bean
    public WriterFfEvaluatorNotes writerFfEvaluatorNotes() { return new WriterFfEvaluatorNotes(); }
    @Bean
    public WriterFComponent writerFComponent() { return new WriterFComponent(); }
    @Bean
    public WriterFcoHierarchical writerFcoHierarchical() { return new WriterFcoHierarchical(); }
    @Bean
    public WriterFcoDependencies writerFcoDependencies() { return new WriterFcoDependencies(); }
    @Bean
    public WriterFcoUserNotes writerFcoUserNotes() { return new WriterFcoUserNotes(); }
    @Bean
    public WriterListItemFcoUserNotes writerListItemFcoUserNotes() { return new WriterListItemFcoUserNotes(); }
    @Bean
    public WriterFcoEvaluatorNotes writerFcoEvaluatorNotes() { return new WriterFcoEvaluatorNotes(); }
    @Bean
    public WriterFcoLevelling writerFcoLevelling() { return new WriterFcoLevelling(); }
    @Bean
    public WriterFcoManagement writerFcoManagement() { return new WriterFcoManagement(); }
    @Bean
    public WriterFcoAudit writerFcoAudit() { return new WriterFcoAudit(); }
    @Bean
    public WriterFcoRationale writerFcoRationale() { return new WriterFcoRationale(); }
    @Bean
    public WriterFElement writerFElement() { return new WriterFElement(); }
    @Bean
    public WriterFeAssignmentItem writerFeAssignmentItem() { return new WriterFeAssignmentItem(); }
    @Bean
    public WriterFeAssignmentNotes writerFeAssignmentNotes() { return new WriterFeAssignmentNotes(); }

    @Bean
    public WriterXref writerXref() { return new WriterXref(); }
  //  @Bean
  //  public WriterList writerList() { return new WriterList(); }
    @Bean
    public WriterSubclausess writerSubclausess() { return new WriterSubclausess(); }

    @Bean
    public WriterAcIntroduction writerAcIntroduction() { return new WriterAcIntroduction(); }
    @Bean
    public WriterAcOverview writerAcOverview() { return new WriterAcOverview(); }
    @Bean
    public WriterAcApplicationNotes writerAcApplicationNotes() { return new WriterAcApplicationNotes(); }
    @Bean
    public WriterMaIntroduction writerMaIntroduction() { return new WriterMaIntroduction(); }
    @Bean
    public WriterMaObjectives writerMaObjectives() { return new WriterMaObjectives(); }
    @Bean
    public WriterMaApplicationNotes writerMaApplicationNotes() { return new WriterMaApplicationNotes(); }


    @Bean
    public WriterAFamily writerAFamily() { return new WriterAFamily(); }
    @Bean
    public WriterAfObjectives writerAfObjectives() { return new WriterAfObjectives(); }
    @Bean
    public WriterAfOverview writerAfOverview() { return new WriterAfOverview(); }
    @Bean
    public WriterAfLevellingCriteria writerAfLevellingCriteria() { return new WriterAfLevellingCriteria(); }
    @Bean
    public WriterAfApplicationNotes writerAfApplicationNotes() { return new WriterAfApplicationNotes(); }


    @Bean
    public WriterAComponent writerAComponent() { return new WriterAComponent(); }
    @Bean
    public WriterAcoDependsOnComponent writerAcoDependsOnComponent() { return new WriterAcoDependsOnComponent(); }
    @Bean
    public WriterAcoHierarchical writerAcoHierarchical() { return new WriterAcoHierarchical(); }
    @Bean
    public WriterAcoObjectives writerAcoObjectives() { return new WriterAcoObjectives(); }
    @Bean
    public WriterAcoApplicationNotes writerAcoApplicationNotes() { return new WriterAcoApplicationNotes(); }
    @Bean
    public WriterMsaObjectives writerMsaObjectives() { return new WriterMsaObjectives(); }
    @Bean
    public WriterMsaApplicationNotes writerMsaApplicationNotes() { return new WriterMsaApplicationNotes(); }
    @Bean
    public WriterMsaInput writerMsaInput() { return new WriterMsaInput(); }

    @Bean
    public WriterAeDeveloper writerAeDeveloper() { return new WriterAeDeveloper(); }
    @Bean
    public WriterAeContent writerAeContent() { return new WriterAeContent(); }
    @Bean
    public WriterAeEvaluator writerAeEvaluator() { return new WriterAeEvaluator(); }
    @Bean
    public WriterMWorkunit writerMWorkunit() { return new WriterMWorkunit(); }

    @Bean
    public WriterEAL writerEAL() { return new WriterEAL(); }
    @Bean
    public WriterEalObjectives writerEalObjectives() { return new WriterEalObjectives(); }
    @Bean
    public WriterEalAssuranceComponents writerEalAssuranceComponents() { return new WriterEalAssuranceComponents(); }
    @Bean
    public WriterEalComponent writerEalComponent() { return new WriterEalComponent(); }










































    @Bean
    public Step stepFClass() {
        return stepBuilderFactory.get("FClass writing").<Fclass, Fclass>chunk(100)
                .reader(readerFClass().readerFClass())
                .processor(processorFClass())
                .writer(compositeItemWriterFClass())
                .build();
    }

    @Bean
    public Step stepAClass() {
        return stepBuilderFactory.get("AClass writing").<AClass, AClass>chunk(100)
                .reader(readerAClass().readerAClass())
                .processor(processorAClass())
                .writer(compositeItemWriterAClass())
                .build();
    }


    @Bean
    public Step stepEAL() {
        return stepBuilderFactory.get("EAL writing").<Eal, Eal>chunk(100)
                .reader(readerEAL().readerEAL())
                .writer(compositeItemWriterEAL())
                .build();
    }


    @Bean
    public Step stepXref() {
        return stepBuilderFactory.get("Xref writing").<Xref, Xref>chunk(100)
                .reader(readerXref().readerXref())
                .writer(writerXref().writerXref(dataSource))
                .build();
    }

    /*@Bean
    public Step stepLists() {
        return stepBuilderFactory.get("Lists writing").<Lists, Lists>chunk(100)
                .reader(readerList().readerList())
                .writer(writerList().writerList(dataSource))
                .build();
    }
     */
    @Bean
    public Step stepSubclause() {
        return stepBuilderFactory.get("Subclause writing").<Subclause, Subclause>chunk(100)
                .reader(readerSubclause().readerSubclause())
                .writer(writerSubclausess().writerSubclausess(dataSource))
                .build();
    }

    @Bean
    public Job exportFClassJob() {
        return jobBuilderFactory.get("importFClassJob")
                .incrementer(new RunIdIncrementer())
                .flow(stepFClass())
                .end()
                .build();
    }

    @Bean
    public Job exportAClassJob() {
        return jobBuilderFactory.get("importAClassJob")
                .incrementer(new RunIdIncrementer())
                .flow(stepAClass())
                .next(stepXref())
              //  .next(stepLists())
                .next(stepSubclause())
                .end()
                .build();
    }

    @Bean
    public Job exportEALJob() {
        return jobBuilderFactory.get("importEALJob")
                .incrementer(new RunIdIncrementer())
                .flow(stepEAL())
                .end()
                .build();
    }

    public CompositeItemWriter<Eal> compositeItemWriterEAL() {
        CompositeItemWriter writer = new CompositeItemWriter();
        writer.setDelegates(Arrays.asList(
                writerEAL().writerEAL(dataSource),
                writerEalObjectives().writerEAL(dataSource),
                writerEalAssuranceComponents().writerEalAssuranceComponents(dataSource),
                writerEalComponent().writerEalComponent(dataSource)
        ));

        return writer;
    }

    public CompositeItemWriter<AClass> compositeItemWriterAClass() {
        CompositeItemWriter writer = new CompositeItemWriter();
        writer.setDelegates(Arrays.asList(
                writerAClass().writerAClass(dataSource),
                writerAcIntroduction().writerAcIntroduction(dataSource),
                writerAcOverview().writerAcOverview(dataSource),
                writerAcApplicationNotes().writerAcApplicationNotes(dataSource),
                writerMaIntroduction().writerMaIntroduction(dataSource),
                writerMaObjectives().writerMaObjectives(dataSource),
                writerMaApplicationNotes().writerMaApplicationNotes(dataSource),
                writerAFamily().writerAFamily(dataSource),
                writerAfObjectives().writerAfObjectives(dataSource),
                writerAfOverview().writerAfOverview(dataSource),
                writerAfLevellingCriteria().writerAfLevellingCriteria(dataSource),
                writerAfApplicationNotes().writerAfApplicationNotes(dataSource),
                writerAComponent().writerAComponent(dataSource),
                writerAcoDependsOnComponent().writerAcoDependsOnComponent(dataSource),
                writerAcoHierarchical().writerAcoHierarchical(dataSource),
                writerAcoObjectives().writerAcoObjectives(dataSource),
                writerAcoApplicationNotes().writerAcoObjectives(dataSource),
                writerMsaObjectives().writerMsaObjectives(dataSource),
                writerMsaApplicationNotes().writerMsaApplicationNotes(dataSource),
                writerMsaInput().writerMsaInput(dataSource),
                writerAeDeveloper().writerAeDeveloper(dataSource),
                writerAeContent().writerAeContent(dataSource),
                writerAeEvaluator().writerAeEvaluator(dataSource),
                writerMWorkunit().writerMWorkunit(dataSource)


                )
        );

        return writer;
    }

    public CompositeItemWriter<Fclass> compositeItemWriterFClass() {
        CompositeItemWriter writer = new CompositeItemWriter();
        writer.setDelegates(Arrays.asList
                        (
                                writerFClass().writerFclass(dataSource),
                                writerFcIntroduction().writerFcIntroduction(dataSource),
                                writerFcInformativeNotes().writerFcInformativeNotes(dataSource),
                                writerSubClause().writerSubClause(dataSource),
                                writerSubClausePara().writerSubClausePara(dataSource),
                                writerListItem().writerListItem(dataSource),
                                writerFfamily().writerFfamily(dataSource),
                                writerFfBehaviour().writerFfBehaviour(dataSource),
                                writerFfUserNotes().writerFfUserNotes(dataSource),
                                writerListItemFfUserNotes().writerListItemFfUsertNotes(dataSource),
                                writerFfEvaluatorNotes().writerFfEvaluatorNotes(dataSource),
                                writerFComponent().writerFComponent(dataSource),
                                writerFcoHierarchical().writerFcoHierarchical(dataSource),
                                writerFcoDependencies().writerFcoDependencies(dataSource),
                                writerFcoUserNotes().writerFcoUserNotes(dataSource),
                                writerListItemFcoUserNotes().writerListItemFcoUsertNotes(dataSource),
                                writerFcoEvaluatorNotes().writerFcoEvaluatorNotes(dataSource),
                                writerFcoLevelling().writerFcoLevelling(dataSource),
                                writerFcoManagement().writerFcoManagement(dataSource),
                                writerFcoAudit().writerFcoAudit(dataSource),
                                writerFcoRationale().writerFcoRationale(dataSource),
                                writerFElement().writerFElement(dataSource),
                                writerFeAssignmentItem().writerFeAssignmentItem(dataSource),
                                writerFeAssignmentNotes().writerFeAssignmentNotes(dataSource)
                        )
        );
        return writer;
    }
}











