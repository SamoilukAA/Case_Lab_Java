CREATE TABLE IF NOT EXISTS public.files_info
(
    id            serial PRIMARY KEY,
    file_base64   text NOT NULL,
    creation_date character varying(32) NOT NULL,
    description   character varying(255) NOT NULL
);