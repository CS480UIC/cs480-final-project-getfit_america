Entity 1: 
  Document Name: Manager
  Synonym: n/a
  Desc   : In charge of overseeing all departments within the 
  
Entity 2: 
  Document Name: Department
  Synonym: branch, division
  Desc   : Each department is specialized in accomodating a particular type of fitness program.
  Relationship: Manager-Manages-Department; one-many
  
Entity 3: 
  Document Name: Trainer
  Synonym: coach, mentor, nutrionist, adviser
  Desc   : Every trainer is certified in leading a fitness program
  Relationship: Trainer-Teaches-Program; many-many
  
Entity 4: 
  Document Name: Program
  Synonym: curriculum
  Desc   : Each program is designed to tackle specific needs of the client. 
           These programs includes cardio, strength training, yoga, sports.  
  Relationship: Program-LeadBy-Trainer; many-many
  
Entity 5: 
  Document Name: Client
  Synonym: customer, applicant, consumer
  Desc   : These are people who signs up for programs that would help them
           improve their wellness.
  Relationship: Client-makes-Appointment; one-one
                Client-enrolledTo-Program; many-many
                
Entity 6: 
  Document Name: Appointment
  Synonym: assignment, consultation
  Desc   : Each appointment descibes what program the client signed up for and date of enrollment.
  Relationship: Client-makes-Appointment; one-one
  
Entity 7: 
  Document Name: Receptionist
  Synonym: front desk, assistant
  Desc   : employee of keeping track of clients' and employees' attendance, 
           receiving potential clients, etc.
  Relationship: Receptionist-schedules-Client; one-many
           
           
       
