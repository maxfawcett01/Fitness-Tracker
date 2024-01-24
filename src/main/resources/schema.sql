CREATE TABLE IF NOT EXISTS  PERSON (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250),
    username VARCHAR(250) NOT NULL unique,
    password VARCHAR(250)
    );

CREATE TABLE IF NOT EXISTS  MEAL(
    id INT AUTO_INCREMENT  PRIMARY KEY,
    mealDate DATE,
    mealName VARCHAR(250),
    mealType VARCHAR(250),
    calories INT,
    cookingInstructions VARCHAR(250),
    ingredientList TEXT,
    personId INT,
    foreign key (personId) references PERSON (id)
    );

CREATE TABLE IF NOT EXISTS INGREDIENT (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ingredientName VARCHAR(250),
    mealId INT,
    FOREIGN KEY (mealId) REFERENCES MEAL(id)
);

CREATE TABLE IF NOT EXISTS  HEALTHSTATISTIC (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    healthDate DATE,
    sleep DOUBLE PRECISION,
    weight DOUBLE PRECISION,
    bloodPressure DOUBLE PRECISION,
    hydration DOUBLE PRECISION,
    calorieIn INT,
    calorieOut INT,
    heartRate DOUBLE PRECISION,
    stress DOUBLE PRECISION,
    peronId INT,
    foreign key (peronId) references PERSON(id)
);

CREATE TABLE IF NOT EXISTS  EXERCISE (
    dtype VARCHAR(31),
    calories_burned INT,
    description VARCHAR(255),
    end_exclusive DATETIME(6),
    end_time DATETIME(6),
    equipment_required VARCHAR(255),
    exercise_name VARCHAR(255),
    start_inclusive DATETIME(6),
    start_time DATETIME(6),
    reps INT,
    sets INT,
    target_muscle VARCHAR(255),
    distance_in_km DOUBLE PRECISION,
    weight_in_kg DOUBLE PRECISION,
    peronId INT,
    foreign key (peronId) references PERSON(id)
);
