-- Conformance Item T20
SELECT ST_IsRing(ST_LineFromWKB(ST_AsBinary(ST_Boundary(ST_WKBToSQL(boundary))),ST_SRID(boundary))) FROM named_places WHERE name = 'Goose Island';
