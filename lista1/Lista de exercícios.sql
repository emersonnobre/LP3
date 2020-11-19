create table grupodeciclistas(
	nome varchar, 
	id serial primary key
);

insert into grupodeciclistas values('Feras do pedal');
insert into grupodeciclistas values('Grupo dos caras');
insert into grupodeciclistas values('Grupo dos feras'); 

create table ciclista(
	nome varchar, 
	cpf varchar,
	idgrupo int references grupodeciclistas(id), 
	id serial primary key
);

insert into ciclista values('Pedro Rocha', '143', 1);
insert into ciclista values('Pedro Ricardo', '126', 1);
insert into ciclista values('Pedro Ribeiro', '124', 2);

create table bicicleta(
	modelo varchar, 
	valor float, 
	id serial primary key
);

insert into bicicleta values('Pivot Vault Ciclocross', 10000);
insert into bicicleta values('Mtb Scott Scale 900 Premium', 38000);
insert into bicicleta values('Bmc Tean Elite 02 Slx/xt Aro 29', 12000);
insert into bicicleta values('Pivot Vault Ciclocross', 20000);

create table acessorio(
	nome varchar, 
	valor float, 
	caracteristica varchar, 
	id serial primary key
);

insert into acessorio values('Lanterna frontal', 30, 'Resistente a água');
insert into acessorio values('Sapatilha', 200, 'Produto leve e confortável');
insert into acessorio values('Luva com gel', 240, 'Possui a palma revestida com uam fina camada de gel');

create table treino(
	roteiro varchar, 
	id serial primary key
);

insert into treino values('Treino noturno na avenida X');
insert into treino values('Treino em trilhas');
insert into treino values('Treino diário');

create table treinociclista(
	idtreino int references treino(id), 
	idciclista int references ciclista(id), 
	id serial primary key
);

insert into treinociclista values(1, 1);
insert into treinociclista values(3, 2);
insert into treinociclista values(2, 1);


create table bicicletaciclista(
	idbicicleta int references bicicleta(id), 
	idciclista int references ciclista(id), 
	id serial primary key
);

insert into bicicletaciclista values(1, 1);
insert into bicicletaciclista values(2, 1);
insert into bicicletaciclista values(2, 2);
insert into bicicletaciclista values(3, 3);


create table bicicletaacessorio( 
	idbicicleta int references bicicleta(id), 
	idacessorio int references acessorio(id), 
	id serial primary key
);

insert into bicicletaacessorio values(2, 2);
insert into bicicletaacessorio values(2, 3);
insert into bicicletaacessorio values(1, 1);
insert into bicicletaacessorio values(3, 3);
