DROP TABLE IF EXISTS listitemsfcousernotes;
DROP TABLE IF EXISTS feassignmentnotes;
DROP TABLE IF EXISTS feassignmentitem;
DROP TABLE IF EXISTS felement;
DROP TABLE IF EXISTS fcorationale;
DROP TABLE IF EXISTS fcoaudit;
DROP TABLE IF EXISTS fcomanagement;
DROP TABLE IF EXISTS fcolevelling;
DROP TABLE IF EXISTS fcoevaluatornotes;
DROP TABLE IF EXISTS fcousernotes;
DROP TABLE IF EXISTS fcodependencies;
DROP TABLE IF EXISTS fcohierarchical;
DROP TABLE IF EXISTS fcomponent;
DROP TABLE IF EXISTS ffevaluatornotes;
DROP TABLE IF EXISTS listitemsffusernotes;
DROP TABLE IF EXISTS ffusernotes;
DROP TABLE IF EXISTS ffbehaviour;
DROP TABLE IF EXISTS ffamily;
DROP TABLE IF EXISTS listitems;
DROP TABLE IF EXISTS subclausepara;
DROP TABLE IF EXISTS subclause;
DROP TABLE IF EXISTS fcinformativenotes;
DROP TABLE IF EXISTS fcintroduction;
DROP TABLE IF EXISTS fclass;


CREATE TABLE fclass(
    id VARCHAR(4) NOT NULL PRIMARY KEY,
    name VARCHAR(40)
);

CREATE TABLE fcintroduction(
    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    idf VARCHAR(4),
    FOREIGN KEY (idf) REFERENCES fclass(id)
);

CREATE TABLE fcinformativenotes(
    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    idf VARCHAR(4),
    FOREIGN KEY (idf) REFERENCES fclass(id)
);

CREATE TABLE subclause(
    title VARCHAR(100),
    id VARCHAR(100) PRIMARY KEY,
    idf VARCHAR(4),
    FOREIGN KEY (idf) REFERENCES fclass(id)
);

CREATE TABLE subclausepara(
    type VARCHAR(10),
    id VARCHAR(12) UNIQUE KEY,
    para VARCHAR(10000),
    idf VARCHAR(100),
    FOREIGN KEY (idf) REFERENCES subclause(id) on update cascade
);

CREATE TABLE listitems(
    task_id VARCHAR(2),
    id VARCHAR(12) UNIQUE KEY,
    text VARCHAR(10000),
    idf VARCHAR(100),
    FOREIGN KEY (idf) REFERENCES fcinformativenotes(id) on update cascade
);

CREATE TABLE ffamily(
    id VARCHAR(10) NOT NULL PRIMARY KEY,
    name VARCHAR(100),
    idf VARCHAR(4),
    FOREIGN KEY (idf) REFERENCES fclass(id) on update cascade
);

CREATE TABLE ffbehaviour(
    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    idf VARCHAR(12),
    FOREIGN KEY (idf) REFERENCES ffamily(id) on update cascade
);

CREATE TABLE ffusernotes(
    type VARCHAR(10),
    id VARCHAR(12) UNIQUE KEY,
    para VARCHAR(10000),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES ffamily(id) on update cascade
);

CREATE TABLE listitemsffusernotes(
    task_id VARCHAR(2),
    id VARCHAR(12) UNIQUE KEY,
    text VARCHAR(10000),
    idf VARCHAR(100),
    FOREIGN KEY (idf) REFERENCES ffusernotes(id) on update cascade
);

CREATE TABLE ffevaluatornotes(
    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES ffamily(id) on update cascade
);

CREATE TABLE fcomponent(
    id VARCHAR(10)  PRIMARY KEY,
    name VARCHAR(100),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES ffamily(id)
);

CREATE TABLE fcohierarchical(
    fcomponent VARCHAR(10) UNIQUE KEY,
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES fcomponent(id)
);

CREATE TABLE fcodependencies(
    id VARCHAR(30) PRIMARY KEY,
    fcomponent VARCHAR(10),
    idf VARCHAR(10) ,
    FOREIGN KEY (idf) REFERENCES fcomponent(id)
);

CREATE TABLE fcousernotes(
    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES fcomponent(id) on update cascade
);

CREATE TABLE listitemsfcousernotes(
    task_id VARCHAR(2),
    id VARCHAR(12) UNIQUE KEY,
    text VARCHAR(10000),
    idf VARCHAR(100),
    FOREIGN KEY (idf) REFERENCES fcousernotes(id) on update cascade
);

CREATE TABLE fcoevaluatornotes(
    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES fcomponent(id) on update cascade
);

CREATE TABLE fcolevelling(
    type VARCHAR(10),
    id VARCHAR(12) UNIQUE KEY,
    para VARCHAR(10000),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES fcomponent(id) on update cascade
);

CREATE TABLE fcomanagement(
    num VARCHAR(2),
    id VARCHAR(20)PRIMARY KEY,
    equal VARCHAR(50),
    text VARCHAR(500) ,
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES fcomponent(id) on update cascade
);

CREATE TABLE fcoaudit(
    num VARCHAR (2),
    id VARCHAR (20) PRIMARY KEY,
    level VARCHAR(10),
    equal VARCHAR(12),
    text VARCHAR(500),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES fcomponent(id) on update cascade
);

CREATE TABLE fcorationale(
    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES fcomponent(id) on update cascade
);

CREATE TABLE felement(
    num VARCHAR(2),
    idr VARCHAR(20)PRIMARY KEY,
    id VARCHAR(20),
    text VARCHAR(500),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES fcomponent(id) on update cascade
);

CREATE TABLE feassignmentitem(
    idr VARCHAR(20) ,
    text VARCHAR(500),
    idf VARCHAR(20),
     FOREIGN KEY (idf) REFERENCES felement(idr) on update cascade
);

CREATE TABLE feassignmentnotes(
    type VARCHAR(10),
    id VARCHAR(20) PRIMARY KEY,
    para VARCHAR(10000),
    idf VARCHAR(20),
    FOREIGN KEY (idf) REFERENCES felement(idr) on update cascade
);










SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS afobjectives;
DROP TABLE IF EXISTS afoverview;
DROP TABLE IF EXISTS aflevellingcriteria;
DROP TABLE IF EXISTS afapplicationnotes;
DROP TABLE IF EXISTS acohierarchical;
DROP TABLE IF EXISTS acodependsoncomponent;
DROP TABLE IF EXISTS acoobjectives;
DROP TABLE IF EXISTS acoapplicationnotes;
DROP TABLE IF EXISTS msaobjectives;
DROP TABLE IF EXISTS msaapplicationnotes;
DROP TABLE IF EXISTS msainput;
DROP TABLE IF EXISTS acomponent;
DROP TABLE IF EXISTS aedcelement;
DROP TABLE IF EXISTS aecontent;
DROP TABLE IF EXISTS aeevaluator;
DROP TABLE IF EXISTS aedeveloper;
DROP TABLE IF EXISTS afamily;
DROP TABLE IF EXISTS mworkunit;

DROP TABLE IF EXISTS maapplicationnotes;
DROP TABLE IF EXISTS maobjectives;
DROP TABLE IF EXISTS acapplicationnotes;
DROP TABLE IF EXISTS maintroduction;
DROP TABLE IF EXISTS acoverview;
DROP TABLE IF EXISTS acintroduction;
DROP TABLE IF EXISTS aclass;


DROP TABLE IF EXISTS figure;
DROP TABLE IF EXISTS acronym;
DROP TABLE IF EXISTS acronymterm;
DROP TABLE IF EXISTS acronymdef;
DROP TABLE IF EXISTS biblioentry;
DROP TABLE IF EXISTS biblioterm;
DROP TABLE IF EXISTS bibliodef;
DROP TABLE IF EXISTS glossentry;
DROP TABLE IF EXISTS glossterm;
DROP TABLE IF EXISTS glossalt;
DROP TABLE IF EXISTS glossdef;
DROP TABLE IF EXISTS glosssource;
DROP TABLE IF EXISTS glossnote;
DROP TABLE IF EXISTS url;
DROP TABLE IF EXISTS italic;
DROP TABLE IF EXISTS bold;
DROP TABLE IF EXISTS selection;
DROP TABLE IF EXISTS list;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS para;
DROP TABLE IF EXISTS selection;
DROP TABLE IF EXISTS assignment;
DROP TABLE IF EXISTS example;
DROP TABLE IF EXISTS exampleterm;
DROP TABLE IF EXISTS exampledef;
DROP TABLE IF EXISTS tablee;
DROP TABLE IF EXISTS subclausess;
DROP TABLE IF EXISTS xref;


DROP TABLE IF EXISTS eal;
DROP TABLE IF EXISTS ealobjectives;
DROP TABLE IF EXISTS ealassurancecomponents;
DROP TABLE IF EXISTS ealcomponent;
SET FOREIGN_KEY_CHECKS = 1;




CREATE TABLE xref(
    id_xref VARCHAR(100) NOT NULL PRIMARY KEY,
    showw VARCHAR(100),
    ida VARCHAR (4)
);

CREATE TABLE url(
    id_url VARCHAR(100) NOT NULL PRIMARY KEY

);

CREATE TABLE bold(
    id_bold INT NOT NULL AUTO_INCREMENT,
    testo VARCHAR(1000),
    PRIMARY KEY (id_bold)

);


CREATE TABLE para(
    id_para VARCHAR(100) NOT NULL PRIMARY KEY,
    type VARCHAR(100),
    testo VARCHAR(1000),
    id_xref VARCHAR(100),
    id_url VARCHAR(100),
    id_list INT,
    id_bold INT,
    id_italic INT
);

CREATE TABLE item(
    id_item INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    testo VARCHAR (10000),
    id_para VARCHAR(100),
    id_xref VARCHAR(100),
    id_url VARCHAR(100),
    id_list INT,
    id_bold INT,
    id_italic INT,
    id_selection VARCHAR(100)
);

CREATE TABLE list(
    id_list VARCHAR(100),
    id_item VARCHAR(100),
    testo_item VARCHAR(10000),
    ida VARCHAR(4),
    PRIMARY KEY (id_list)
);

CREATE TABLE subclausess(
    id_subclausess VARCHAR(100) NOT NULL PRIMARY KEY,
    title VARCHAR(100),
    testo VARCHAR(60000)
);






















/* ----------------------------- ASSURANCE PARADIGM ------------------------- */
CREATE TABLE aclass(
    id VARCHAR(4) NOT NULL PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE acintroduction(
    id VARCHAR(1000),
    testo VARCHAR(60000),
    ida VARCHAR(4),
    PRIMARY KEY (id),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE acoverview(
    id VARCHAR(1000) PRIMARY KEY,
    testo VARCHAR(60000),
    ida VARCHAR(4),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE maintroduction(
    id VARCHAR(1000) PRIMARY KEY,
    testo VARCHAR(60000),
    ida VARCHAR(4),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE acapplicationnotes(
    id VARCHAR(1000) PRIMARY KEY,
    testo VARCHAR(60000),
    ida VARCHAR(4),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE maapplicationnotes(
    id VARCHAR(1000) PRIMARY KEY,
    testo VARCHAR(60000),
    ida VARCHAR(4),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE maobjectives(
    id VARCHAR(1000) PRIMARY KEY,
    testo VARCHAR(60000),
    ida VARCHAR(4),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);
/* -------------------------------------------------------------------------- */



/* ----------------------------- ASSURANCE FAMILY --------------------------- */
CREATE TABLE afamily(
    id_afamily VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(100),
    ida VARCHAR(4),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE afapplicationnotes(
    id VARCHAR(1000) PRIMARY KEY,
    testo VARCHAR(60000),
    ida VARCHAR(4),
    idf VARCHAR(100),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE afobjectives(
    id VARCHAR(1000) PRIMARY KEY,
    testo VARCHAR(60000),
    ida VARCHAR(4),
    idf VARCHAR(100),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE afoverview(
    id VARCHAR(1000) PRIMARY KEY,
    testo VARCHAR(60000),
    ida VARCHAR(4),
    idf VARCHAR(100),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE aflevellingcriteria(
    id VARCHAR(1000) PRIMARY KEY,
    testo VARCHAR(60000),
    ida VARCHAR(4),
    idf VARCHAR(100),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);
/* -------------------------------------------------------------------------- */



/* ----------------------------- ASSURANCE COMPONENT ------------------------ */
CREATE TABLE acomponent(
    id_acomponent VARCHAR(100) PRIMARY KEY,
    name VARCHAR(100),
    ida VARCHAR(10),
    idf VARCHAR(100),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE acohierarchical(
    id_acohierarchical VARCHAR(100) PRIMARY KEY,
    acomponent VARCHAR(100),
    ida VARCHAR(10),
    idf VARCHAR(100),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE acodependsoncomponent(
    id_acodependsoncomponent VARCHAR(100) PRIMARY KEY,
    acomponent VARCHAR(100),
    ida VARCHAR(10),
    idf VARCHAR(100),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE acoobjectives(
    id_acoobjectives VARCHAR(100) PRIMARY KEY,
    testo VARCHAR(60000),
    ida VARCHAR(10),
    idf VARCHAR(100),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE acoapplicationnotes(
    id_acoapplicationnotes VARCHAR(100) PRIMARY KEY,
    testo VARCHAR(60000),
    ida VARCHAR(10),
    idf VARCHAR(100),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE msaobjectives(
    id_msaobjectives VARCHAR(100) PRIMARY KEY,
    testo VARCHAR(60000),
    ida VARCHAR(10),
    idf VARCHAR(100),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE msaapplicationnotes(
    id_msaapplicationnotes VARCHAR(100) PRIMARY KEY,
    testo VARCHAR(60000),
    ida VARCHAR(10),
    idf VARCHAR(100),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE msainput(
    id_msainput VARCHAR(100) PRIMARY KEY,
    testo VARCHAR(60000),
    ida VARCHAR(10),
    idf VARCHAR(100),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);
/* -------------------------------------------------------------------------- */



/* ----------------------------- ASSURANCE ELEMENTS ------------------------- */
CREATE TABLE aedeveloper(
    id_aedeveloper VARCHAR(100) NOT NULL PRIMARY KEY,
    testo VARCHAR (60000),
    ida VARCHAR(4),
    idf VARCHAR(100),
    id_acomponent VARCHAR (100),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE aecontent(
    id_aecontent VARCHAR(100) NOT NULL PRIMARY KEY,
         testo VARCHAR (60000),
         ida VARCHAR(4),
         idf VARCHAR(100),
         id_acomponent VARCHAR (100),
         FOREIGN KEY (ida) REFERENCES aclass(id)
     );

CREATE TABLE aeevaluator(
    id_aeevaluator VARCHAR(100) NOT NULL PRIMARY KEY,
             testo VARCHAR (60000),
             ida VARCHAR(4),
             idf VARCHAR(100),
             id_acomponent VARCHAR (100),
             FOREIGN KEY (ida) REFERENCES aclass(id)
         );
CREATE TABLE mworkunit(
       id_mworkunit VARCHAR(100) NOT NULL PRIMARY KEY,
                testo VARCHAR (60000),
                ida VARCHAR(4),
                idf VARCHAR(100),
                id_acomponent VARCHAR (100),
                id_aeevaluator VARCHAR(100),
                FOREIGN KEY (ida) REFERENCES aclass(id)
            );

CREATE TABLE aedcelement(
    id_aedcelement VARCHAR(100) NOT NULL PRIMARY KEY
);
/* -------------------------------------------------------------------------- */


/* ------------------------ EVALUATION ASSURANCE LEVELS -------------------- */
CREATE TABLE eal(
    id_eal VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE ealobjectives(
    id_ealobjectives VARCHAR(100) NOT NULL PRIMARY KEY,
    testo VARCHAR(60000),
    id_eal VARCHAR (100),
    FOREIGN KEY (id_eal) REFERENCES eal(id_eal)
);

CREATE TABLE ealassurancecomponents(
    id_ealassurancecomponents VARCHAR(100) NOT NULL PRIMARY KEY,
    testo VARCHAR(60000),
    id_eal VARCHAR (100),
    FOREIGN KEY (id_eal) REFERENCES eal(id_eal)
);

CREATE TABLE ealcomponent(
    acomponent VARCHAR(100) NOT NULL PRIMARY KEY,
    id_eal VARCHAR (100),
    FOREIGN KEY (id_eal) REFERENCES eal(id_eal)
    );
/* ------------------------------- FOREIGN KEY ----------------------------- */
ALTER TABLE xref
ADD FOREIGN KEY (ida) REFERENCES aclass(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE list
ADD FOREIGN KEY (ida) REFERENCES aclass(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE afobjectives
ADD FOREIGN KEY (idf) REFERENCES afamily(id_afamily) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE afoverview
ADD FOREIGN KEY (idf) REFERENCES afamily(id_afamily) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE aflevellingcriteria
ADD FOREIGN KEY (idf) REFERENCES afamily(id_afamily) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE afapplicationnotes
ADD FOREIGN KEY (idf) REFERENCES afamily(id_afamily) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE acomponent
ADD FOREIGN KEY (idf) REFERENCES afamily(id_afamily) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE acodependsoncomponent
ADD FOREIGN KEY (idf) REFERENCES afamily(id_afamily) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE acohierarchical
ADD FOREIGN KEY (idf) REFERENCES afamily(id_afamily) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE acoobjectives
ADD FOREIGN KEY (idf) REFERENCES afamily(id_afamily) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE acoapplicationnotes
ADD FOREIGN KEY (idf) REFERENCES afamily(id_afamily) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE msaobjectives
ADD FOREIGN KEY (idf) REFERENCES afamily(id_afamily) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE msaapplicationnotes
ADD FOREIGN KEY (idf) REFERENCES afamily(id_afamily) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE msainput
ADD FOREIGN KEY (idf) REFERENCES afamily(id_afamily) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE aedeveloper
ADD FOREIGN KEY (idf) REFERENCES afamily(id_afamily) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aedeveloper
ADD FOREIGN KEY (id_acomponent) REFERENCES acomponent(id_acomponent) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE aecontent
ADD FOREIGN KEY (idf) REFERENCES afamily(id_afamily) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aecontent
ADD FOREIGN KEY (id_acomponent) REFERENCES acomponent(id_acomponent) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE aeevaluator
ADD FOREIGN KEY (idf) REFERENCES afamily(id_afamily) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aeevaluator
ADD FOREIGN KEY (id_acomponent) REFERENCES acomponent(id_acomponent) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE mworkunit
ADD FOREIGN KEY (idf) REFERENCES afamily(id_afamily) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE mworkunit
ADD FOREIGN KEY (id_acomponent) REFERENCES acomponent(id_acomponent) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE mworkunit
ADD FOREIGN KEY (id_aeevaluator) REFERENCES aeevaluator(id_aeevaluator) ON UPDATE CASCADE ON DELETE CASCADE;
/* -------------------------------------------------------------------------- */








