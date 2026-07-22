CREATE TABLE IF NOT EXISTS usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    data_cadastro TIMESTAMP
);

CREATE TABLE IF NOT EXISTS canais_comunicacao (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    ativo BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS usuario_canal (
    usuario_id INT REFERENCES usuarios(id),
    canal_id INT REFERENCES canais_comunicacao(id),
    PRIMARY KEY (usuario_id, canal_id)
);

CREATE TABLE IF NOT EXISTS recibos_notificacao (
    id SERIAL PRIMARY KEY,
    usuario_id INT REFERENCES usuarios(id),
    destinatario VARCHAR(255),
    canal VARCHAR(100),
    mensagem VARCHAR(255),
    sucesso BOOLEAN,
    data_envio TIMESTAMP
);