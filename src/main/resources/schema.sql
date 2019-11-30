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



SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS figure;
DROP TABLE IF EXISTS acronym;
DROP TABLE IF EXISTS biblioentry;
DROP TABLE IF EXISTS glossentry;
DROP TABLE IF EXISTS url;
DROP TABLE IF EXISTS italic;
DROP TABLE IF EXISTS bold;
DROP TABLE IF EXISTS selection;
DROP TABLE IF EXISTS list;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS para;
DROP TABLE IF EXISTS selection;
DROP TABLE IF EXISTS example;
DROP TABLE IF EXISTS tablee;
DROP TABLE IF EXISTS subclausess;
DROP TABLE IF EXISTS xref;
SET FOREIGN_KEY_CHECKS = 1;






DROP TABLE IF EXISTS maapplicationnotes;
DROP TABLE IF EXISTS maobjectives;
DROP TABLE IF EXISTS acapplicationnotes;
DROP TABLE IF EXISTS maintroduction;
DROP TABLE IF EXISTS acoverview;
DROP TABLE IF EXISTS acintroduction;
DROP TABLE IF EXISTS aclass;


CREATE TABLE figure(
    id_figure VARCHAR(100) NOT NULL PRIMARY KEY,
    entity VARCHAR(100),
    title VARCHAR(100),
    width VARCHAR(10),
    height VARCHAR(10)
);

CREATE TABLE acronym(
    id_acronym VARCHAR(100) NOT NULL PRIMARY KEY
);

CREATE TABLE biblioentry(
    id_biblioentry VARCHAR(100) NOT NULL PRIMARY KEY
);

CREATE TABLE glossentry(
    id_glossentry VARCHAR(100) NOT NULL PRIMARY KEY
);

CREATE TABLE xref(
    id_xref VARCHAR(100) NOT NULL PRIMARY KEY,
    showw VARCHAR(100)
);

CREATE TABLE url(
    id_url VARCHAR(100) NOT NULL PRIMARY KEY
);

CREATE TABLE bold(
    id_bold VARCHAR(100) NOT NULL PRIMARY KEY,
    testo VARCHAR(1000),
    id_xref VARCHAR(100),
    id_italic VARCHAR(100)
);

CREATE TABLE italic(
    id_italic VARCHAR(100) NOT NULL PRIMARY KEY,
    testo VARCHAR(1000),
    id_xref VARCHAR(100),
    id_bold VARCHAR(100)
);


CREATE TABLE para(
    id_para VARCHAR(100) NOT NULL PRIMARY KEY,
    type VARCHAR(100),
    testo VARCHAR(1000),
    id_xref VARCHAR(100),
    id_url VARCHAR(100),
    id_list VARCHAR(100),
    id_bold VARCHAR(100),
    id_italic VARCHAR(100)
);

CREATE TABLE item(
    id_item VARCHAR(100) NOT NULL PRIMARY KEY,
    id_para VARCHAR(100),
    id_xref VARCHAR(100),
    id_url VARCHAR(100),
    id_list VARCHAR(100),
    id_bold VARCHAR(100),
    id_italic VARCHAR(100),
    id_selection VARCHAR(100)
);

CREATE TABLE selection(
    id_selection VARCHAR(100) NOT NULL PRIMARY KEY,
    id_xref VARCHAR(100),
    id_italic VARCHAR(100)
);

CREATE TABLE list(
    id_list VARCHAR(100) NOT NULL PRIMARY KEY,
    id_item VARCHAR(100)
);


CREATE TABLE example(
    id_example VARCHAR(100) NOT NULL PRIMARY KEY
);

CREATE TABLE tablee(
    id_table VARCHAR(100) NOT NULL PRIMARY KEY,
    width VARCHAR(10)
);


CREATE TABLE subclausess(
    id_subclausess VARCHAR(100) NOT NULL PRIMARY KEY,
    id_subclausess_ext VARCHAR(100),
    id_para VARCHAR(100),
    id_figure VARCHAR(100),
    id_acronym VARCHAR(100),
    id_biblioentry VARCHAR(100),
    id_glossentry VARCHAR(100),
    id_table VARCHAR(100),
    id_example VARCHAR(100)
);



ALTER TABLE bold
ADD FOREIGN KEY (id_italic) REFERENCES italic(id_italic) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE bold
ADD FOREIGN KEY (id_xref) REFERENCES xref(id_xref) ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE italic
ADD FOREIGN KEY (id_xref) REFERENCES xref(id_xref) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE italic
ADD FOREIGN KEY (id_bold) REFERENCES bold(id_bold) ON UPDATE CASCADE ON DELETE CASCADE;


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

ALTER TABLE list
ADD FOREIGN KEY (id_item) REFERENCES item(id_item) ON UPDATE CASCADE ON DELETE CASCADE;


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






