create table if not exists MuscleGroup (
  id identity,
  name varchar(25) not null
);

create table if not exists Exercise (
  id identity,
  name varchar(25) not null
);

create table if not exists Workout (
  id identity,
  name varchar(25) not null
);

create table if not exists Exercise_MuscleGroup (
  id identity,
  exerciseId bigint not null,
  muscleGroupID bigint not null
);

ALTER TABLE Exercise_MuscleGroup
ADD FOREIGN KEY (exerciseId) REFERENCES Exercise(id);
ALTER TABLE Exercise_MuscleGroup
ADD FOREIGN KEY (muscleGroupID) REFERENCES MuscleGroup(id);

create table if not exists Workout_Exercise (
  workoutId bigint not null,
  exerciseId bigint not null
);

ALTER TABLE Workout_Exercise
ADD FOREIGN KEY (workoutID) REFERENCES Workout(id);
ALTER TABLE Workout_Exercise
ADD FOREIGN KEY (exerciseId) REFERENCES Exercise(id);

create table if not exists Workout_Data (
	id bigint not null,
	rounds bigint,
	exerciserest bigint,
	setrest bigint
);

ALTER TABLE Workout_Data
ADD FOREIGN KEY (id) REFERENCES Workout(id);
