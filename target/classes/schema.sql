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

) ;
CREATE TABLE ffbehaviour(

    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    idf VARCHAR(12),
    FOREIGN KEY (idf) REFERENCES ffamily(id) on update cascade

) ;
CREATE TABLE ffusernotes(

    type VARCHAR(10),
    id VARCHAR(12) UNIQUE KEY,
    para VARCHAR(10000),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES ffamily(id) on update cascade

) ;
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
) ;
CREATE TABLE fcomponent(

    id VARCHAR(10)  PRIMARY KEY,
    name VARCHAR(100),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES ffamily(id)
) ;
CREATE TABLE fcohierarchical(

    fcomponent VARCHAR(10) UNIQUE KEY,
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES fcomponent(id)
) ;
CREATE TABLE fcodependencies(

    id VARCHAR(30) PRIMARY KEY,
    fcomponent VARCHAR(10),
    idf VARCHAR(10) ,
    FOREIGN KEY (idf) REFERENCES fcomponent(id)
) ;
CREATE TABLE fcousernotes(

    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES fcomponent(id) on update cascade
) ;
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
SET FOREIGN_KEY_CHECKS = 1;








CREATE TABLE figure(
    id_figure VARCHAR(100) NOT NULL PRIMARY KEY,
    entity VARCHAR(100),
    title VARCHAR(100),
    width VARCHAR(10),
    height VARCHAR(10)
);

CREATE TABLE acronym(
    id_acronym VARCHAR(100) NOT NULL PRIMARY KEY,
    id_acronymterm VARCHAR(100),
    id_acronymdef VARCHAR(100)
);
CREATE TABLE acronymterm(
    id_acronymterm VARCHAR(100) NOT NULL PRIMARY KEY,
    testo VARCHAR(1000),
    id_xref VARCHAR(100),
    id_list VARCHAR(100),
    id_bold INT,
    id_italic INT
);
CREATE TABLE acronymdef(
    id_acronymdef VARCHAR(100) NOT NULL PRIMARY KEY,
    testo VARCHAR(1000),
    id_xref VARCHAR(100),
    id_list VARCHAR(100),
    id_bold INT,
    id_italic INT
);

CREATE TABLE biblioentry(
    id_biblioentry VARCHAR(100) NOT NULL PRIMARY KEY,
    id_biblioterm VARCHAR(100),
    id_bibliodef VARCHAR(100)
);
CREATE TABLE biblioterm(
    id_biblioterm VARCHAR(100) NOT NULL PRIMARY KEY,
    testo VARCHAR(1000),
    id_xref VARCHAR(100),
    id_list VARCHAR(100),
    id_bold INT,
    id_italic INT
);
CREATE TABLE bibliodef(
    id_bibliodef VARCHAR(100) NOT NULL PRIMARY KEY,
    testo VARCHAR(1000),
    id_xref VARCHAR(100),
    id_list VARCHAR(100),
    id_bold INT,
    id_italic INT
);

CREATE TABLE glossentry(
    id_glossentry VARCHAR(100) NOT NULL PRIMARY KEY,
    id_glossterm VARCHAR(100),
    id_glossalt VARCHAR(100),
    id_glossdef VARCHAR(100),
    id_glosssource VARCHAR(100),
    id_glossnote VARCHAR(100)
);
CREATE TABLE glossterm(
    id_glossterm VARCHAR(100) NOT NULL PRIMARY KEY,
    testo VARCHAR(1000),
    id_xref VARCHAR(100),
    id_list VARCHAR(100),
    id_bold INT,
    id_italic INT
);
CREATE TABLE glossalt(
    id_glossalt VARCHAR(100) NOT NULL PRIMARY KEY,
    testo VARCHAR(1000),
    id_bold INT
);
CREATE TABLE glossdef(
    id_glossdef VARCHAR(100) NOT NULL PRIMARY KEY,
    testo VARCHAR(1000),
    id_para VARCHAR(100),
    id_xref VARCHAR(100),
    id_list VARCHAR(100),
    id_bold INT,
    id_italic INT
);
CREATE TABLE glosssource(
    id_glosssource VARCHAR(100) NOT NULL PRIMARY KEY,
    testo VARCHAR(1000),
    id_para VARCHAR(100),
    id_xref VARCHAR(100),
    id_list VARCHAR(100),
    id_bold INT,
    id_italic INT
);
CREATE TABLE glossnote(
    id_glossnote VARCHAR(100) NOT NULL PRIMARY KEY,
    testo VARCHAR(1000),
    id_para VARCHAR(100),
    id_xref VARCHAR(100),
    id_list VARCHAR(100),
    id_bold INT,
    id_italic INT
);

CREATE TABLE xref(
    id_xref VARCHAR(100) NOT NULL PRIMARY KEY,
    showw VARCHAR(100),
    ida VARCHAR (100)
);


CREATE TABLE url(
    id_url VARCHAR(100) NOT NULL PRIMARY KEY

);

CREATE TABLE bold(
    id_bold INT NOT NULL AUTO_INCREMENT,
    testo VARCHAR(1000),
    PRIMARY KEY (id_bold)

);

CREATE TABLE italic(
    id_italic INT NOT NULL AUTO_INCREMENT,
    testo VARCHAR(1000),
    PRIMARY KEY (id_italic)
);

CREATE TABLE para(
    id_para VARCHAR(100) NOT NULL PRIMARY KEY,
    type VARCHAR(100),
    testo VARCHAR(1000),
    id_xref VARCHAR(100),
    id_url VARCHAR(100),
    id_list VARCHAR(100),
    id_bold INT,
    id_italic INT
);

CREATE TABLE item(
    id_item VARCHAR(100) NOT NULL PRIMARY KEY,
    id_para VARCHAR(100),
    id_xref VARCHAR(100),
    id_url VARCHAR(100),
    id_list VARCHAR(100),
    id_bold INT,
    id_italic INT,
    id_selection VARCHAR(100)
);

CREATE TABLE selection(
    id_selection VARCHAR(100) NOT NULL PRIMARY KEY,
    testo VARCHAR(10000),
    id_xref VARCHAR(100),
    id_italic INT
);

CREATE TABLE assignment(
    id_assignment VARCHAR(100) NOT NULL PRIMARY KEY,
    testo VARCHAR(10000),
    id_xref VARCHAR(100),
    id_italic INT
);

CREATE TABLE list(
    id_list VARCHAR(100) NOT NULL PRIMARY KEY,
    id_item VARCHAR(100)
);

CREATE TABLE example(
    id_example VARCHAR(100) NOT NULL PRIMARY KEY,
    id_exampleterm VARCHAR(100),
    id_exampledef VARCHAR(100)
);
CREATE TABLE exampleterm(
    id_exampleterm VARCHAR(100) NOT NULL PRIMARY KEY,
    testo VARCHAR(1000),
    id_xref VARCHAR(100),
    id_list VARCHAR(100),
    id_bold INT,
    id_italic INT
);
CREATE TABLE exampledef(
    id_exampledef VARCHAR(100) NOT NULL PRIMARY KEY,
    testo VARCHAR(1000),
    id_xref VARCHAR(100),
    id_list VARCHAR(100),
    id_bold INT,
    id_italic INT
);

CREATE TABLE tablee(
    id_table VARCHAR(100) NOT NULL PRIMARY KEY,
    width VARCHAR(10)
);

CREATE TABLE subclausess(
    id_subclausess VARCHAR(100) NOT NULL PRIMARY KEY,
    title VARCHAR(100),
    id_subclausess_ext VARCHAR(100),
    id_para VARCHAR(100),
    id_figure VARCHAR(100),
    id_acronym VARCHAR(100),
    id_biblioentry VARCHAR(100),
    id_glossentry VARCHAR(100),
    id_table VARCHAR(100),
    id_example VARCHAR(100)
);


























CREATE TABLE aclass(
    id VARCHAR(4) NOT NULL PRIMARY KEY,
    name VARCHAR(100)
) ;

CREATE TABLE acintroduction(
    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    ida VARCHAR(4),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE acoverview(
    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    ida VARCHAR(4),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE maintroduction(
    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    ida VARCHAR(4),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE acapplicationnotes(
    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    ida VARCHAR(4),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE maobjectives(
    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    ida VARCHAR(4),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);


CREATE TABLE maapplicationnotes(
    id_maapplicationnotes VARCHAR(100) PRIMARY KEY,
    id_subclausess VARCHAR(100),
    id_para VARCHAR(100),
    id_figure VARCHAR(100),
    id_acronym VARCHAR(100),
    id_biblioentry VARCHAR(100),
    id_glossentry VARCHAR(100),
    id_table VARCHAR(100),
    id_example VARCHAR(100),
    ida VARCHAR(4),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);

CREATE TABLE afamily(
    id_afamily VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(100),
    id_afobjectives VARCHAR(100),
    id_afoverview VARCHAR(100),
    id_aflevellingcriteria VARCHAR(100),
    id_afapplicationnotes VARCHAR(100),
    ida VARCHAR(4),
    FOREIGN KEY (ida) REFERENCES aclass(id)
);


CREATE TABLE afobjectives(
    id_afobjectives VARCHAR (12) PRIMARY KEY,
    id_subclausess VARCHAR(100),
    id_para VARCHAR(100),
    id_figure VARCHAR(100),
    id_acronym VARCHAR(100),
    id_biblioentry VARCHAR(100),
    id_glossentry VARCHAR(100),
    id_table VARCHAR(100),
    id_example VARCHAR(100)
);

CREATE TABLE afoverview(
    id_afoverview VARCHAR (12) PRIMARY KEY,
    id_subclausess VARCHAR(100),
    id_para VARCHAR(100),
    id_figure VARCHAR(100),
    id_acronym VARCHAR(100),
    id_biblioentry VARCHAR(100),
    id_glossentry VARCHAR(100),
    id_table VARCHAR(100),
    id_example VARCHAR(100)
);

CREATE TABLE aflevellingcriteria(
    id_aflevellingcriteria VARCHAR (12) PRIMARY KEY,
    id_subclausess VARCHAR(100),
    id_para VARCHAR(100),
    id_figure VARCHAR(100),
    id_acronym VARCHAR(100),
    id_biblioentry VARCHAR(100),
    id_glossentry VARCHAR(100),
    id_table VARCHAR(100),
    id_example VARCHAR(100)
);

CREATE TABLE afapplicationnotes(
    id_afapplicationnotes VARCHAR (12) PRIMARY KEY,
    id_subclausess VARCHAR(100),
    id_para VARCHAR(100),
    id_figure VARCHAR(100),
    id_acronym VARCHAR(100),
    id_biblioentry VARCHAR(100),
    id_glossentry VARCHAR(100),
    id_table VARCHAR(100),
    id_example VARCHAR(100)
);

CREATE TABLE acomponent(
    id_acomponent VARCHAR(100) PRIMARY KEY,
    name VARCHAR(100),
    id_acohierarchical VARCHAR(100),
    id_acodependsoncomponent VARCHAR(100),
    id_acoobjectives VARCHAR(100),
    id_acoapplicationnotes VARCHAR(100),
    id_msaobjectives VARCHAR(100),
    id_msaapplicationnotes VARCHAR(100),
    id_msainput VARCHAR(100),
    id_aeevaluator VARCHAR(100),
    id_aecontent VARCHAR(100),
    id_aedeveloper VARCHAR(100)
);

CREATE TABLE acohierarchical(
    id_acohierarchical VARCHAR(100) PRIMARY KEY,
    acomponent VARCHAR(100)

);

CREATE TABLE acodependsoncomponent(
    id_acodependsoncomponent VARCHAR(100) PRIMARY KEY,
    acomponent VARCHAR(100)
);

CREATE TABLE acoobjectives(
    id_acoobjectives VARCHAR(100) PRIMARY KEY,
    id_subclausess VARCHAR(100),
    id_para VARCHAR(100),
    id_figure VARCHAR(100),
    id_acronym VARCHAR(100),
    id_biblioentry VARCHAR(100),
    id_glossentry VARCHAR(100),
    id_table VARCHAR(100),
    id_example VARCHAR(100)
);


CREATE TABLE acoapplicationnotes(
    id_acoapplicationnotes VARCHAR(100) PRIMARY KEY,
    id_subclausess VARCHAR(100),
    id_para VARCHAR(100),
    id_figure VARCHAR(100),
    id_acronym VARCHAR(100),
    id_biblioentry VARCHAR(100),
    id_glossentry VARCHAR(100),
    id_table VARCHAR(100),
    id_example VARCHAR(100)
);

CREATE TABLE msaobjectives(
    id_msaobjectives VARCHAR(100) PRIMARY KEY,
    id_subclausess VARCHAR(100),
    id_para VARCHAR(100),
    id_figure VARCHAR(100),
    id_acronym VARCHAR(100),
    id_biblioentry VARCHAR(100),
    id_glossentry VARCHAR(100),
    id_table VARCHAR(100),
    id_example VARCHAR(100)
);

CREATE TABLE msaapplicationnotes(
    id_msaapplicationnotes VARCHAR(100) PRIMARY KEY,
    id_subclausess VARCHAR(100),
    id_para VARCHAR(100),
    id_figure VARCHAR(100),
    id_acronym VARCHAR(100),
    id_biblioentry VARCHAR(100),
    id_glossentry VARCHAR(100),
    id_table VARCHAR(100),
    id_example VARCHAR(100)
);

CREATE TABLE msainput(
    id_msainput VARCHAR(100) PRIMARY KEY,
    id_subclausess VARCHAR(100),
    id_para VARCHAR(100),
    id_figure VARCHAR(100),
    id_acronym VARCHAR(100),
    id_biblioentry VARCHAR(100),
    id_glossentry VARCHAR(100),
    id_table VARCHAR(100),
    id_example VARCHAR(100)
);


CREATE TABLE aeevaluator(
    id_aeevaluator VARCHAR(100) NOT NULL PRIMARY KEY,
    id_list VARCHAR(100),
    id_assignment VARCHAR(100),
    id_selection VARCHAR(100),
    id_xref VARCHAR(100),
    id_mworkunit VARCHAR(100)
);

CREATE TABLE aedeveloper(
    id_aedeveloper VARCHAR(100) NOT NULL PRIMARY KEY,
    id_list VARCHAR(100),
    id_assignment VARCHAR(100),
    id_selection VARCHAR(100),
    id_xref VARCHAR(100),
    id_mworkunit VARCHAR(100)
);

CREATE TABLE aecontent(
    id_aecontent VARCHAR(100) NOT NULL PRIMARY KEY,
    id_list VARCHAR(100),
    id_assignment VARCHAR(100),
    id_selection VARCHAR(100),
    id_xref VARCHAR(100)
);

CREATE TABLE mworkunit(
    id_mworkunit VARCHAR(100) NOT NULL PRIMARY KEY,
    id_aedcelement VARCHAR(100),
    id_subclausess VARCHAR(100),
    id_para VARCHAR(100),
    id_figure VARCHAR(100),
    id_acronym VARCHAR(100),
    id_biblioentry VARCHAR(100),
    id_glossentry VARCHAR(100),
    id_table VARCHAR(100),
    id_example VARCHAR(100)
);

CREATE TABLE aedcelement(
    id_aedcelement VARCHAR(100) NOT NULL PRIMARY KEY
);


ALTER TABLE acronym
ADD FOREIGN KEY (id_acronymterm) REFERENCES acronymterm(id_acronymterm) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acronym
ADD FOREIGN KEY (id_acronymdef) REFERENCES acronymdef(id_acronymdef) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE acronymterm
ADD FOREIGN KEY (id_xref) REFERENCES xref(id_xref) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acronymterm
ADD FOREIGN KEY (id_list) REFERENCES list(id_list) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acronymterm
ADD FOREIGN KEY (id_bold) REFERENCES bold(id_bold) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acronymterm
ADD FOREIGN KEY (id_italic) REFERENCES italic(id_italic) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE acronymdef
ADD FOREIGN KEY (id_xref) REFERENCES xref(id_xref) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acronymdef
ADD FOREIGN KEY (id_list) REFERENCES list(id_list) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acronymdef
ADD FOREIGN KEY (id_bold) REFERENCES bold(id_bold) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acronymdef
ADD FOREIGN KEY (id_italic) REFERENCES italic(id_italic) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE biblioentry
ADD FOREIGN KEY (id_biblioterm) REFERENCES biblioterm(id_biblioterm) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE biblioentry
ADD FOREIGN KEY (id_bibliodef) REFERENCES bibliodef(id_bibliodef) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE biblioterm

ADD FOREIGN KEY (id_xref) REFERENCES xref(id_xref) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE biblioterm
ADD FOREIGN KEY (id_list) REFERENCES list(id_list) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE biblioterm
ADD FOREIGN KEY (id_bold) REFERENCES bold(id_bold) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE biblioterm
ADD FOREIGN KEY (id_italic) REFERENCES italic(id_italic) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE bibliodef
ADD FOREIGN KEY (id_xref) REFERENCES xref(id_xref) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE bibliodef
ADD FOREIGN KEY (id_list) REFERENCES list(id_list) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE bibliodef
ADD FOREIGN KEY (id_bold) REFERENCES bold(id_bold) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE bibliodef
ADD FOREIGN KEY (id_italic) REFERENCES italic(id_italic) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE glossentry
ADD FOREIGN KEY (id_glossterm) REFERENCES glossterm(id_glossterm) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE glossentry
ADD FOREIGN KEY (id_glossalt) REFERENCES glossalt(id_glossalt) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE glossentry
ADD FOREIGN KEY (id_glossdef) REFERENCES glossdef(id_glossdef) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE glossentry
ADD FOREIGN KEY (id_glosssource) REFERENCES glosssource(id_glosssource) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE glossentry
ADD FOREIGN KEY (id_glossnote) REFERENCES glossnote(id_glossnote) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE glossterm
ADD FOREIGN KEY (id_xref) REFERENCES xref(id_xref) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE glossterm
ADD FOREIGN KEY (id_list) REFERENCES list(id_list) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE glossterm
ADD FOREIGN KEY (id_bold) REFERENCES bold(id_bold) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE glossterm
ADD FOREIGN KEY (id_italic) REFERENCES italic(id_italic) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE glossalt
ADD FOREIGN KEY (id_bold) REFERENCES bold(id_bold) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE glossdef
ADD FOREIGN KEY (id_para) REFERENCES para(id_para) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE glossdef
ADD FOREIGN KEY (id_xref) REFERENCES xref(id_xref) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE glossdef
ADD FOREIGN KEY (id_list) REFERENCES list(id_list) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE glossdef
ADD FOREIGN KEY (id_bold) REFERENCES bold(id_bold) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE glossdef
ADD FOREIGN KEY (id_italic) REFERENCES italic(id_italic) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE glosssource
ADD FOREIGN KEY (id_para) REFERENCES para(id_para) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE glosssource
ADD FOREIGN KEY (id_xref) REFERENCES xref(id_xref) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE glosssource
ADD FOREIGN KEY (id_list) REFERENCES list(id_list) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE glosssource
ADD FOREIGN KEY (id_bold) REFERENCES bold(id_bold) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE glosssource
ADD FOREIGN KEY (id_italic) REFERENCES italic(id_italic) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE glossnote
ADD FOREIGN KEY (id_para) REFERENCES para(id_para) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE glossnote
ADD FOREIGN KEY (id_xref) REFERENCES xref(id_xref) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE glossnote
ADD FOREIGN KEY (id_list) REFERENCES list(id_list) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE glossnote
ADD FOREIGN KEY (id_bold) REFERENCES bold(id_bold) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE glossnote
ADD FOREIGN KEY (id_italic) REFERENCES italic(id_italic) ON UPDATE CASCADE ON DELETE CASCADE;








ALTER TABLE para
ADD FOREIGN KEY (id_xref) REFERENCES xref(id_xref) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE para
ADD FOREIGN KEY (id_url) REFERENCES url(id_url) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE para
ADD FOREIGN KEY (id_list) REFERENCES list(id_list) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE para
ADD FOREIGN KEY (id_bold) REFERENCES bold(id_bold) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE para
ADD FOREIGN KEY (id_italic) REFERENCES italic(id_italic) ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE item
ADD FOREIGN KEY (id_para) REFERENCES para(id_para) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE item
ADD FOREIGN KEY (id_xref) REFERENCES xref(id_xref)ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE item
ADD FOREIGN KEY (id_url) REFERENCES url(id_url) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE item
ADD FOREIGN KEY (id_list) REFERENCES list(id_list) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE item
ADD FOREIGN KEY (id_bold) REFERENCES bold(id_bold) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE item
ADD FOREIGN KEY (id_italic) REFERENCES italic(id_italic) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE item
ADD FOREIGN KEY (id_selection) REFERENCES selection(id_selection) ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE selection
ADD FOREIGN KEY (id_xref) REFERENCES xref(id_xref) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE selection
ADD FOREIGN KEY (id_italic) REFERENCES italic(id_italic) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE assignment
ADD FOREIGN KEY (id_xref) REFERENCES xref(id_xref) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE assignment
ADD FOREIGN KEY (id_italic) REFERENCES italic(id_italic) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE list
ADD FOREIGN KEY (id_item) REFERENCES item(id_item) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE example
ADD FOREIGN KEY (id_exampleterm) REFERENCES exampleterm(id_exampleterm) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE example
ADD FOREIGN KEY (id_exampledef) REFERENCES exampledef(id_exampledef) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE exampleterm
ADD FOREIGN KEY (id_xref) REFERENCES xref(id_xref) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE exampleterm
ADD FOREIGN KEY (id_list) REFERENCES list(id_list) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE exampleterm
ADD FOREIGN KEY (id_bold) REFERENCES bold(id_bold) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE exampleterm
ADD FOREIGN KEY (id_italic) REFERENCES italic(id_italic) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE exampledef
ADD FOREIGN KEY (id_xref) REFERENCES xref(id_xref) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE exampledef
ADD FOREIGN KEY (id_list) REFERENCES list(id_list) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE exampledef
ADD FOREIGN KEY (id_bold) REFERENCES bold(id_bold) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE exampledef
ADD FOREIGN KEY (id_italic) REFERENCES italic(id_italic) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE subclausess
ADD FOREIGN KEY (id_subclausess_ext) REFERENCES subclausess(id_subclausess) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE subclausess
ADD FOREIGN KEY (id_para) REFERENCES para(id_para) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE subclausess
ADD FOREIGN KEY (id_figure) REFERENCES figure(id_figure) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE subclausess
ADD FOREIGN KEY (id_acronym) REFERENCES acronym(id_acronym) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE subclausess
ADD FOREIGN KEY (id_biblioentry) REFERENCES biblioentry(id_biblioentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE subclausess
ADD FOREIGN KEY (id_glossentry) REFERENCES glossentry(id_glossentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE subclausess
ADD FOREIGN KEY (id_table) REFERENCES tablee(id_table) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE subclausess
ADD FOREIGN KEY (id_example) REFERENCES example(id_example) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE acoobjectives
ADD FOREIGN KEY (id_subclausess) REFERENCES subclausess(id_subclausess) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acoobjectives
ADD FOREIGN KEY (id_para) REFERENCES para(id_para) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acoobjectives
ADD FOREIGN KEY (id_figure) REFERENCES figure(id_figure) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acoobjectives
ADD FOREIGN KEY (id_acronym) REFERENCES acronym(id_acronym) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acoobjectives
ADD FOREIGN KEY (id_biblioentry) REFERENCES biblioentry(id_biblioentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acoobjectives
ADD FOREIGN KEY (id_glossentry) REFERENCES glossentry(id_glossentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acoobjectives
ADD FOREIGN KEY (id_table) REFERENCES tablee(id_table) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acoobjectives
ADD FOREIGN KEY (id_example) REFERENCES example(id_example) ON UPDATE CASCADE ON DELETE CASCADE;



ALTER TABLE acoapplicationnotes
ADD FOREIGN KEY (id_subclausess) REFERENCES subclausess(id_subclausess) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acoapplicationnotes
ADD FOREIGN KEY (id_para) REFERENCES para(id_para) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acoapplicationnotes
ADD FOREIGN KEY (id_figure) REFERENCES figure(id_figure) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acoapplicationnotes
ADD FOREIGN KEY (id_acronym) REFERENCES acronym(id_acronym) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acoapplicationnotes
ADD FOREIGN KEY (id_biblioentry) REFERENCES biblioentry(id_biblioentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acoapplicationnotes
ADD FOREIGN KEY (id_glossentry) REFERENCES glossentry(id_glossentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acoapplicationnotes
ADD FOREIGN KEY (id_table) REFERENCES tablee(id_table) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acoapplicationnotes
ADD FOREIGN KEY (id_example) REFERENCES example(id_example) ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE msaobjectives
ADD FOREIGN KEY (id_subclausess) REFERENCES subclausess(id_subclausess) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msaobjectives
ADD FOREIGN KEY (id_para) REFERENCES para(id_para) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msaobjectives
ADD FOREIGN KEY (id_figure) REFERENCES figure(id_figure) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msaobjectives
ADD FOREIGN KEY (id_acronym) REFERENCES acronym(id_acronym) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msaobjectives
ADD FOREIGN KEY (id_biblioentry) REFERENCES biblioentry(id_biblioentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msaobjectives
ADD FOREIGN KEY (id_glossentry) REFERENCES glossentry(id_glossentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msaobjectives
ADD FOREIGN KEY (id_table) REFERENCES tablee(id_table) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msaobjectives
ADD FOREIGN KEY (id_example) REFERENCES example(id_example) ON UPDATE CASCADE ON DELETE CASCADE;



ALTER TABLE msaapplicationnotes
ADD FOREIGN KEY (id_subclausess) REFERENCES subclausess(id_subclausess) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msaapplicationnotes
ADD FOREIGN KEY (id_para) REFERENCES para(id_para) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msaapplicationnotes
ADD FOREIGN KEY (id_figure) REFERENCES figure(id_figure) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msaapplicationnotes
ADD FOREIGN KEY (id_acronym) REFERENCES acronym(id_acronym) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msaapplicationnotes
ADD FOREIGN KEY (id_biblioentry) REFERENCES biblioentry(id_biblioentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msaapplicationnotes
ADD FOREIGN KEY (id_glossentry) REFERENCES glossentry(id_glossentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msaapplicationnotes
ADD FOREIGN KEY (id_table) REFERENCES tablee(id_table) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msaapplicationnotes
ADD FOREIGN KEY (id_example) REFERENCES example(id_example) ON UPDATE CASCADE ON DELETE CASCADE;




ALTER TABLE msainput
ADD FOREIGN KEY (id_subclausess) REFERENCES subclausess(id_subclausess) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msainput
ADD FOREIGN KEY (id_para) REFERENCES para(id_para) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msainput
ADD FOREIGN KEY (id_figure) REFERENCES figure(id_figure) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msainput
ADD FOREIGN KEY (id_acronym) REFERENCES acronym(id_acronym) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msainput
ADD FOREIGN KEY (id_biblioentry) REFERENCES biblioentry(id_biblioentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msainput
ADD FOREIGN KEY (id_glossentry) REFERENCES glossentry(id_glossentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msainput
ADD FOREIGN KEY (id_table) REFERENCES tablee(id_table) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE msainput
ADD FOREIGN KEY (id_example) REFERENCES example(id_example) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE aeevaluator
ADD FOREIGN KEY (id_list) REFERENCES list(id_list) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aeevaluator
ADD FOREIGN KEY (id_assignment) REFERENCES assignment(id_assignment) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aeevaluator
ADD FOREIGN KEY (id_selection) REFERENCES selection(id_selection) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aeevaluator
ADD FOREIGN KEY (id_xref) REFERENCES xref(id_xref) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aeevaluator
ADD FOREIGN KEY (id_mworkunit) REFERENCES mworkunit(id_mworkunit) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE aedeveloper
ADD FOREIGN KEY (id_list) REFERENCES list(id_list) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aedeveloper
ADD FOREIGN KEY (id_assignment) REFERENCES assignment(id_assignment) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aedeveloper
ADD FOREIGN KEY (id_selection) REFERENCES selection(id_selection) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aedeveloper
ADD FOREIGN KEY (id_xref) REFERENCES xref(id_xref) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aedeveloper
ADD FOREIGN KEY (id_mworkunit) REFERENCES mworkunit(id_mworkunit) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE aecontent
ADD FOREIGN KEY (id_list) REFERENCES list(id_list) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aecontent
ADD FOREIGN KEY (id_assignment) REFERENCES assignment(id_assignment) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aecontent
ADD FOREIGN KEY (id_selection) REFERENCES selection(id_selection) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aecontent
ADD FOREIGN KEY (id_xref) REFERENCES xref(id_xref) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE mworkunit
ADD FOREIGN KEY (id_aedcelement) REFERENCES aedcelement(id_aedcelement) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE mworkunit
ADD FOREIGN KEY (id_subclausess) REFERENCES subclausess(id_subclausess) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE mworkunit
ADD FOREIGN KEY (id_para) REFERENCES para(id_para) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE mworkunit
ADD FOREIGN KEY (id_figure) REFERENCES figure(id_figure) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE mworkunit
ADD FOREIGN KEY (id_acronym) REFERENCES acronym(id_acronym) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE mworkunit
ADD FOREIGN KEY (id_biblioentry) REFERENCES biblioentry(id_biblioentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE mworkunit
ADD FOREIGN KEY (id_glossentry) REFERENCES glossentry(id_glossentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE mworkunit
ADD FOREIGN KEY (id_table) REFERENCES tablee(id_table) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE mworkunit
ADD FOREIGN KEY (id_example) REFERENCES example(id_example) ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE acomponent
ADD FOREIGN KEY (id_acohierarchical) REFERENCES acohierarchical(id_acohierarchical) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acomponent
ADD FOREIGN KEY (id_acodependsoncomponent) REFERENCES acodependsoncomponent(id_acodependsoncomponent) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acomponent
ADD FOREIGN KEY (id_acoobjectives) REFERENCES acoobjectives(id_acoobjectives) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acomponent
ADD FOREIGN KEY (id_acoapplicationnotes) REFERENCES acoapplicationnotes(id_acoapplicationnotes) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acomponent
ADD FOREIGN KEY (id_msaobjectives) REFERENCES msaobjectives(id_msaobjectives) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acomponent
ADD FOREIGN KEY (id_msaapplicationnotes) REFERENCES msaapplicationnotes(id_msaapplicationnotes) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acomponent
ADD FOREIGN KEY (id_msainput) REFERENCES msainput(id_msainput) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acomponent
ADD FOREIGN KEY (id_aeevaluator) REFERENCES aeevaluator(id_aeevaluator) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acomponent
ADD FOREIGN KEY (id_aecontent) REFERENCES aecontent(id_aecontent) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE acomponent
ADD FOREIGN KEY (id_aedeveloper) REFERENCES aedeveloper(id_aedeveloper) ON UPDATE CASCADE ON DELETE CASCADE;



ALTER TABLE maapplicationnotes
ADD FOREIGN KEY (id_para) REFERENCES para(id_para) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE maapplicationnotes
ADD FOREIGN KEY (id_figure) REFERENCES figure(id_figure) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE maapplicationnotes
ADD FOREIGN KEY (id_acronym) REFERENCES acronym(id_acronym) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE maapplicationnotes
ADD FOREIGN KEY (id_biblioentry) REFERENCES biblioentry(id_biblioentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE maapplicationnotes
ADD FOREIGN KEY (id_glossentry) REFERENCES glossentry(id_glossentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE maapplicationnotes
ADD FOREIGN KEY (id_table) REFERENCES tablee(id_table) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE maapplicationnotes
ADD FOREIGN KEY (id_example) REFERENCES example(id_example) ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE afobjectives
ADD FOREIGN KEY (id_subclausess) REFERENCES subclausess(id_subclausess) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afobjectives
ADD FOREIGN KEY (id_para) REFERENCES para(id_para) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afobjectives
ADD FOREIGN KEY (id_figure) REFERENCES figure(id_figure) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afobjectives
ADD FOREIGN KEY (id_acronym) REFERENCES acronym(id_acronym) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afobjectives
ADD FOREIGN KEY (id_biblioentry) REFERENCES biblioentry(id_biblioentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afobjectives
ADD FOREIGN KEY (id_glossentry) REFERENCES glossentry(id_glossentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afobjectives
ADD FOREIGN KEY (id_table) REFERENCES tablee(id_table) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afobjectives
ADD FOREIGN KEY (id_example) REFERENCES example(id_example) ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE afoverview
ADD FOREIGN KEY (id_subclausess) REFERENCES subclausess(id_subclausess) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afoverview
ADD FOREIGN KEY (id_para) REFERENCES para(id_para) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afoverview
ADD FOREIGN KEY (id_figure) REFERENCES figure(id_figure) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afoverview
ADD FOREIGN KEY (id_acronym) REFERENCES acronym(id_acronym) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afoverview
ADD FOREIGN KEY (id_biblioentry) REFERENCES biblioentry(id_biblioentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afoverview
ADD FOREIGN KEY (id_glossentry) REFERENCES glossentry(id_glossentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afoverview
ADD FOREIGN KEY (id_table) REFERENCES tablee(id_table) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afoverview
ADD FOREIGN KEY (id_example) REFERENCES example(id_example) ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE aflevellingcriteria
ADD FOREIGN KEY (id_subclausess) REFERENCES subclausess(id_subclausess) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aflevellingcriteria
ADD FOREIGN KEY (id_para) REFERENCES para(id_para) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aflevellingcriteria
ADD FOREIGN KEY (id_figure) REFERENCES figure(id_figure) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aflevellingcriteria
ADD FOREIGN KEY (id_acronym) REFERENCES acronym(id_acronym) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aflevellingcriteria
ADD FOREIGN KEY (id_biblioentry) REFERENCES biblioentry(id_biblioentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aflevellingcriteria
ADD FOREIGN KEY (id_glossentry) REFERENCES glossentry(id_glossentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aflevellingcriteria
ADD FOREIGN KEY (id_table) REFERENCES tablee(id_table) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE aflevellingcriteria
ADD FOREIGN KEY (id_example) REFERENCES example(id_example) ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE afapplicationnotes
ADD FOREIGN KEY (id_subclausess) REFERENCES subclausess(id_subclausess) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afapplicationnotes
ADD FOREIGN KEY (id_para) REFERENCES para(id_para) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afapplicationnotes
ADD FOREIGN KEY (id_figure) REFERENCES figure(id_figure) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afapplicationnotes
ADD FOREIGN KEY (id_acronym) REFERENCES acronym(id_acronym) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afapplicationnotes
ADD FOREIGN KEY (id_biblioentry) REFERENCES biblioentry(id_biblioentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afapplicationnotes
ADD FOREIGN KEY (id_glossentry) REFERENCES glossentry(id_glossentry) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afapplicationnotes
ADD FOREIGN KEY (id_table) REFERENCES tablee(id_table) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afapplicationnotes
ADD FOREIGN KEY (id_example) REFERENCES example(id_example) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE afamily
ADD FOREIGN KEY (id_afobjectives) REFERENCES afobjectives(id_afobjectives) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afamily
ADD FOREIGN KEY (id_afoverview) REFERENCES afoverview(id_afoverview) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afamily
ADD FOREIGN KEY (id_aflevellingcriteria) REFERENCES aflevellingcriteria(id_aflevellingcriteria) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE afamily
ADD FOREIGN KEY (id_afapplicationnotes) REFERENCES afapplicationnotes(id_afapplicationnotes) ON UPDATE CASCADE ON DELETE CASCADE;


