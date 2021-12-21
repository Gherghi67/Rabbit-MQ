CREATE TABLE IF NOT EXISTS produs(id_produs INTEGER PRIMARY KEY, nume_produs TEXT, stoc INTEGER);
CREATE TABLE IF NOT EXISTS comanda(id_comanda INTEGER PRIMARY KEY, status_comanda TEXT, nume_client TEXT);

INSERT INTO produs VALUES(1, 'Cafea', 10);
INSERT INTO produs VALUES(2, 'Miere', 20);