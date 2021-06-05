/*Tabela de Usuarios */
Create table Usuario (
idUsuario int NOT NULL AUTO_INCREMENT,
login varchar(20) null default '',
senha varchar(20) null default '',
idNivelUsuario int not null,
primary key (idUsuario)
);

/*Tabela de Nível Usuarios */
Create table NivelUsuario (
idNivel int not null auto_increment,
nivel varchar (50) null default '',
primary key (idNivel)
);

/*Tabela de Clientes */
Create table Cliente (
idCliente int not null auto_increment,
rg varchar (15) null default '',
cpf varchar (15) not null,
nome varchar (100) null default '',
dataCadastro datetime,
idEnderecoCliente int,
telefone varchar (20) null default '',
email varchar (100) null default '',
primary key (idCliente)
);

/*Tabela de Endereços*/
Create table Endereco (
idEnd int not null auto_increment,
logradouro varchar (20) null default '',
rua varchar (100) null default '',
numero varchar (10) null default '',
bairro varchar (100) null default '',
cidade varchar (100) null default '',
cep varchar (15) null default '',
primary key (idEnd)
);

/*Tabela de Produtos*/
Create table Produto (
codigoBarras int not null auto_increment,
nomeProduto varchar (100) null default '',
idCategoria int not null,
fabricante varchar (100) null default '',
quantidade numeric (9,0),
preco decimal (10,2) not null,
plataforma varchar(100) null default '',
garantia varchar(20) null default '',
primary key (codigoBarras)
);

/*Tabela de Categorias*/
Create table Categoria (
idCat int not null auto_increment,
categoria varchar (100) null default '',
primary key (idCat)
);

/*Tabela de Vendas*/
Create table Venda (
idVenda int not null auto_increment,
idItemVenda int not null,
dataVenda date not null,
produto varchar(100) null default '',
quantidade int not null,
preco real not null,
totalVenda real not null,
idFormaPgto int not null,
idCliente int not null,
primary key (idVenda)
);

/*Tabela de Vendas*/
Create table FormaPagamento (
idFormaPgto int not null auto_increment,
formaPgto varchar (100) null default '',
primary key (idFormaPgto)
);

/*Criação das foreign key nas tabelas*/
alter table usuario add constraint fk_idNivelUsuario foreign key (idNivelUsuario) references NivelUsuario (idNivel);
alter table produto add constraint fk_idCategoria foreign key (idCategoria) references categoria (idCat);
alter table cliente add constraint fk_idEnderecoCliente foreign key (idEnderecoCliente) references Endereco (idEnd);
alter table venda add constraint fk_idItemVenda foreign key (idItemVenda) references produto (codigoBarras);
alter table venda add constraint fk_idFormaPgto foreign key (idFormaPgto) references FormaPagamento (idFormaPgto);
alter table venda add constraint fk_idCliente foreign key (idCliente) references cliente (idCliente);