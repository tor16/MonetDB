START TRANSACTION;

CREATE USER "voc" WITH PASSWORD 'voc' NAME 'VOC_EXPLORER' SCHEMA "sys";
CREATE SCHEMA "voc" AUTHORIZATION "voc";
ALTER USER "voc" SET SCHEMA "voc";

commit;
