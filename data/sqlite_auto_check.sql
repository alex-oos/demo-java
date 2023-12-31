CREATE TABLE `auto_check`
(
    `id`            INTEGER PRIMARY KEY AUTOINCREMENT,
    `layer_name`    TEXT    NOT NULL,
    `field_name`    TEXT    NOT NULL,
    `actual_name`   TEXT    NOT NULL,
    `feature_id`    BIGINT  NOT NULL,
    `assist_name`   TEXT    NOT NULL,
    `assist_id`     BIGINT  NOT NULL,
    `check_id`      TEXT    NOT NULL,
    `check_name`    TEXT    NOT NULL,
    `err_code`      TEXT    NOT NULL,
    `err_desc`      TEXT    NOT NULL,
    `misinfo`       TEXT    NOT NULL,
    `imp_level`     TEXT    NOT NULL,
    `para_value`    REAL    NOT NULL,
    `task_id`       TEXT    NOT NULL,
    `sub_task_id`   TEXT    NOT NULL,
    `task_type`     INTEGER NOT NULL,
    `step`          INTEGER NOT NULL,
    `tile`          INTEGER NOT NULL,
    `assist_tile`   INTEGER NOT NULL,
    `manual_mis`    INTEGER NOT NULL,
    `date_time`     TEXT    NOT NULL,
    `uuid`          TEXT    NOT NULL,
    `diff_flag`     INTEGER NOT NULL,
    `mis_flag`      INTEGER NOT NULL,
    `check_version` TEXT    NOT NULL,
    `log_source`    INTEGER NOT NULL,
    `feedback`      INTEGER NOT NULL,
    `updateuser`    TEXT    NOT NULL,
    `updatetime`    TEXT    NOT NULL,
    `geotext`       TEXT    NOT NULL,
    `geometry`      BLOB    NOT NULL
);
