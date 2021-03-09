# must be executed manually once to bootstrap the service.

INSERT INTO directory (name) value('default', 'idStorage');

INSERT INTO system_properties (config, val) value('storage.bucket', 'npcdatamanager');
