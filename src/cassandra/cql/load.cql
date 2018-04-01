CREATE KEYSPACE IF NOT EXISTS starwars
     WITH REPLICATION = {'class' : 'SimpleStrategy', 'replication_factor' : 1 } 
     AND DURABLE_WRITES =  true;

CREATE TABLE IF NOT EXISTS starwars.planets ( 
   id text,
   nome text,
   clima text,
   terreno text,
   aparicoes int,
   PRIMARY KEY (id)
);
   
BEGIN BATCH
INSERT INTO starwars.planets (id, nome, clima, terreno, aparicoes) VALUES ('089FA20042F0CF749A3618C884A924E6', 'Alderaan', 'temperate', 'grasslands, mountains', 2)
INSERT INTO starwars.planets (id, nome, clima, terreno, aparicoes) VALUES ('574EFAB1D9234AB58D0F1FD417514146', 'Yavin IV', 'temperate, tropical', 'jungle, rainforests', 1)
INSERT INTO starwars.planets (id, nome, clima, terreno, aparicoes) VALUES ('3231755FC6967979AF517ACAB025780E', 'Hoth', 'frozen', 'tundra, ice caves, mountain ranges', 1)
INSERT INTO starwars.planets (id, nome, clima, terreno, aparicoes) VALUES ('7AD568C481F5D069741FCB9EBF805007', 'Dagobah', 'murky', 'swamp, jungles', 3)
INSERT INTO starwars.planets (id, nome, clima, terreno, aparicoes) VALUES ('F79060D7E7E668686C18FAC210BAC028', 'Bespin', 'temperate', 'gas giant', 1)
INSERT INTO starwars.planets (id, nome, clima, terreno, aparicoes) VALUES ('CF27E328850EFAC58326429A6C831183', 'Endor', 'temperate', 'forests, mountains, lakes', 1)
INSERT INTO starwars.planets (id, nome, clima, terreno, aparicoes) VALUES ('80B88138A52118F4B9D93EBC7C941E11', 'Naboo', 'temperate', 'grassy hills, swamps, forests, mountains', 4)
INSERT INTO starwars.planets (id, nome, clima, terreno, aparicoes) VALUES ('05D38A22612952565CA228C8C15A048A', 'Coruscant', 'temperate', 'cityscape, mountains', 4)
INSERT INTO starwars.planets (id, nome, clima, terreno, aparicoes) VALUES ('226C18534A6F5AB117F6B2835CEAC493', 'Kamino', 'temperate', 'ocean', 1)
INSERT INTO starwars.planets (id, nome, clima, terreno, aparicoes) VALUES ('4F44A51623E5F5B1F59418DFD3D7F261', 'Geonosis', 'temperate, arid', 'rock, desert, mountain, barren', 1)
APPLY BATCH;