CREATE TABLE Tb_usuarios (

    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    nome VARCHAR (200) NOT NULL,
    email VARCHAR (200) NOT NULL UNIQUE,
    senha VARCHAR (200) NOT NULL,
    data_criacao datetime DEFAULT GETDATE()
);

CREATE TABLE Tb_tarefas (


    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    titulo VARCHAR (300) NOT NULL,
    descricao VARCHAR (MAX),
    status VARCHAR (50),
    data_criacao datetime DEFAULT GETDATE(),
    usuario_id BIGINT NOT NULL,


    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES Tb_usuarios(id)

);
