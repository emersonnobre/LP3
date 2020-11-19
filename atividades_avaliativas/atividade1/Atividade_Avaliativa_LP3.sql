create table ingrediente(
	nome varchar, 
	peso float, 
	id serial, 
	primary key(id)
);

insert into ingrediente values('chocolate', 10);
insert into ingrediente values('leite condensado', 20);
insert into ingrediente values('açúcar', 30);

create table instituicao(
	nome varchar,
	id serial, 
	primary key(id)
);

insert into instituicao values('Mundo dos Doces');
insert into instituicao values('Doces mania');

create table curso(
	nome varchar, 
	modalidade varchar, 
	duracao int, --tempo em horas
	idinstituicao int references instituicao(id),
	id serial, 
	primary key(id)
);

insert into curso values('Bolos para casamento', 'Bolos em camadas', 30, 1);
insert into curso values('Tortas para festas', 'Tortas doces', 50, 2);
insert into curso values('Sobremesas para casamento', 'Sobremesas', 40, 2);

create table confeiteiro(
	nome varchar, 
	especialidade varchar,
	id serial, 
	primary key(id)
);

insert into confeiteiro values('Jorge Amado', 'Bolos');
insert into confeiteiro values('Jorge Paulo Ramos', 'Tortas');
insert into confeiteiro values('Jorge Ricardo', 'Docinhos de festa');

create table doce(
	nome varchar, 
	pesomedio float, 
	valor float,
	idconfeiteiro int references confeiteiro(id),
	id serial, 
	primary key(id)
);

insert into doce values('Trufado de natal', 20, 137, 1);
insert into doce values('Floresta negra ', 10, 320, 2);

create table doceingrediente(
	iddoce int references doce(id), 
	idingrediente int references ingrediente(id),
	id serial, 
	primary key(id)
);

insert into doceingrediente values(1, 1);
insert into doceingrediente values(1, 2);
insert into doceingrediente values(2, 2);
insert into doceingrediente values(2, 3);

create table cursoconfeiteiro(
	idcurso int references curso(id), 
	idconfeiteiro int references confeiteiro(id),
	id serial, 
	primary key(id)
);

insert into cursoconfeiteiro values(1, 1);
insert into cursoconfeiteiro values(2, 2);
insert into cursoconfeiteiro values(3, 3);
