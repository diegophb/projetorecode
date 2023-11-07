create database entrega;
use entrega;
CREATE TABLE Cliente (
    IdNome int primary key not null auto_increment,
	Nome VARCHAR(50),
    Telefone VARCHAR(50),
	Email VARCHAR(50)
);

CREATE TABLE Reserva (
    IdReserva int primary key not null auto_increment,
    fk_Cliente_IdNome int,
    fk_Destino_IdDestino int,
    fk_Pacote_IdPacote int,
    dataReserva varchar(50),
    Valor decimal(10,2)
);

alter table reserva modify dataReserva varchar(50);

CREATE TABLE Destino (
    IdDestino int primary key not null auto_increment,
    NomeDestino VARCHAR(50),
    ValorDestino decimal(10,2)
  
);

CREATE TABLE Pacote (
    IdPacote int primary key not null auto_increment,
    Nome VARCHAR(50),
    ValorPacote decimal(10,2)
);
 
ALTER TABLE Reserva ADD CONSTRAINT FK_Reserva_2
    FOREIGN KEY (fk_Cliente_IdNome)
    REFERENCES Cliente (IdNome)
    ON DELETE RESTRICT;
 
ALTER TABLE Reserva ADD CONSTRAINT FK_Reserva_3
    FOREIGN KEY (fk_Destino_IdDestino)
    REFERENCES Destino (IdDestino)
    ON DELETE CASCADE;
 
ALTER TABLE Reserva ADD CONSTRAINT FK_Reserva_4
    FOREIGN KEY (fk_Pacote_IdPacote)
    REFERENCES Pacote (IdPacote)
    ON DELETE CASCADE;
    
 
select * from ReservaGlobal;
create view ReservaGlobal as  SELECT Reserva.IdReserva, Reserva.dataReserva as Data_Reserva, cliente.IdNome as Id_Cliente, cliente.Nome as 
Nome_Cliente,Cliente.Telefone as telefone,Cliente.Email as email,Destino.IdDestino as Id_Destino,Destino.NomeDestino 
as Nome_Destino,Destino.ValorDestino as Valor_Destino, Pacote.IdPacote as Id_Pacote, Pacote.Nome as Nome_Pacote,
Pacote.ValorPacote AS Valor_Pacote, reserva.valor as Valor_R$_total FROM cliente 
JOIN reserva ON cliente.IdNome = reserva.fk_Cliente_IdNome
JOIN destino ON destino.IdDestino = reserva.fk_Destino_IdDestino
JOIN pacote ON pacote.IdPacote = reserva.fk_Pacote_IdPacote;
 
INSERT INTO cliente(Nome,Telefone, Email) VALUES ("Diego", "(55)1234-5678", "Diego@email");
INSERT INTO cliente(Nome,Telefone, Email) VALUES ("Ana", "(52)****-****", "Ana@email");
INSERT INTO cliente(Nome,Telefone, Email) VALUES ("Bia", "(00)9876-5432", "Bia@email");

INSERT INTO destino(NomeDestino, ValorDestino) VALUES ("João Pessoa", "1000.00");
INSERT INTO destino(NomeDestino, ValorDestino) VALUES ("Paris", "32000.00");
INSERT INTO destino(NomeDestino, ValorDestino) VALUES ("parnaiba", "1000.00");
INSERT INTO destino(NomeDestino, ValorDestino) VALUES ("ba", "3200.00");

INSERT INTO Pacote(nome, valorPacote) VALUES ("VIP", 1500.23);
INSERT INTO Pacote(nome, valorPacote) VALUES ("ECONOMICA", 450.25);
INSERT INTO Pacote(nome, valorPacote) VALUES ("Ouro", 1500.23);
INSERT INTO Pacote(nome, valorPacote) VALUES ("classe media", 450.25);


INSERT INTO reserva (fk_Cliente_IdNome ,fk_Destino_IdDestino ,
fk_Pacote_IdPacote,dataReserva,Valor ) values (1,2,2,"25 de Feveiro","339.01");

select * from reserva ;
select * from ReservaGeral;


select * from cliente;
select * from destino;
select * from pacote;
select * from reserva;
drop table Reserva;
drop table cliente;
drop table Destino;
drop table Pacote;

