CREATE TABLE if not exists `aff_udf` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `unique_id` bigint(20) unsigned DEFAULT NULL,
  `func_name` varchar(64) NOT NULL,
  `return_type` varchar(64) NOT NULL,
  `script_id` bigint(20) unsigned DEFAULT NULL,
  `func_params` varchar(1024) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `memo` varchar(512) NOT NULL,
  `creator` varchar(64) NOT NULL,
  `modifier` varchar(64) NOT NULL,
  `func_example` varchar(255) DEFAULT NULL,
  `descption` varchar(512) DEFAULT NULL,
  `scenes_type` varchar(16) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL DEFAULT 0,
  `script` text,
  `func_imports` text,
  `l1_domain_code` varchar(128) NOT NULL DEFAULT 'security',
  `env_flag` varchar(32) DEFAULT NULL COMMENT 'env_flag',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;


