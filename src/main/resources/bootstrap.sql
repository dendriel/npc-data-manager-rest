-- must be executed manually once to bootstrap the service.

INSERT INTO system_properties (config, val) value('storage.bucket', 'npcdatamanager');

INSERT INTO directory (name, storage_id) values ("default", "images");
INSERT INTO resource (name, storage_id, type, directory_id) values ("Iron Dagger", "images/icon_iron_dagger.png", 1, 1);
INSERT INTO resource (name, storage_id, type, directory_id) values ("Merchant 01", "images/merchant01.png", 1, 1);
INSERT INTO resource (name, storage_id, type, directory_id) values ("Bandit 01", "images/bandit01.png", 1, 1);
