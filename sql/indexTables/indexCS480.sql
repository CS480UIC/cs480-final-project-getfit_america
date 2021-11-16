-- SELECT * from manager;

-- manager
CREATE INDEX department_id_index
ON manager(department_id);

-- appointment
CREATE INDEX appointment_index
ON appointment(selected_prog);

-- client
CREATE INDEX client_index
ON client(client_id);

-- department
CREATE INDEX department_index
ON department(manager_id);

-- receptionist
CREATE INDEX receptionist_index
ON receptionist(employee_id);

-- trainer
CREATE INDEX trainer_index
ON trainer(employee_id);

-- program
CREATE INDEX program_index
ON program(program_id);