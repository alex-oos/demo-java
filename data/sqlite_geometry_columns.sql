CREATE TABLE if not exists geometry_columns
(
    f_table_name          TEXT,
    f_geometry_column     TEXT,
    geometry_type         INTEGER,
    coord_dimension       INTEGER,
    srid                  INTEGER,
    geometry_format       TEXT,
    spatial_index_enabled INTEGER
)
