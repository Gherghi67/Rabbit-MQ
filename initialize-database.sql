CREATE TABLE IF NOT EXISTS produs(id_produs INTEGER PRIMARY KEY, nume_produs TEXT, stoc INTEGER);
CREATE TABLE IF NOT EXISTS comanda(id_comanda INTEGER PRIMARY KEY, status_comanda TEXT, nume_client TEXT, id_produs INTEGER,
FOREIGN KEY(id_produs) REFERENCES produs(id_produs));

-- INSERT INTO produs VALUES(1, 'Miere', 20);
-- INSERT INTO produs VALUES(2, 'Cafea', 30);