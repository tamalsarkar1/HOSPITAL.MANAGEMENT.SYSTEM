package com.hospitalmanagementsystem;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HospitalMain {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
// Main loop for the menu
        while (true) {
            System.out.println("Hospital Management System Menu:");
            System.out.println("1. Add new Doctor");
            System.out.println("2. Add new Nurse");
            System.out.println("3. Add new Patient");
            System.out.println("4. Delete Doctor");
            System.out.println("5. Delete Nurse");
            System.out.println("6. Delete Patient");
            System.out.println("7. Assign Patient to Doctor");
            System.out.println("8. Show all Doctors");
            System.out.println("9. Show all Nurses");
            System.out.println("10. Show all Patients");
            System.out.println("11. update Doctor");
            System.out.println("12. update Nurse");
            System.out.println("13. update Patient");
            System.out.println("14. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

// Switch case for menu selection
            switch (choice) {
                case 1:
                    addNewDoctor(scanner);
                    break;
                case 2:
                    addNewNurse(scanner);
                    break;
                case 3:
                    addNewPatient(scanner);
                    break;
                    
                case 4:
                    deleteDoctor(scanner);
                    break;
                case 5:
                    deleteNurse(scanner);
                    break;
                case 6:
                    deletePatient(scanner);
                    break;
                case 7:
                    assignPatientToDoctor(scanner);
                    break;
                case 8:
                    showAllDoctors();
                    break;
                case 9:
                    showAllNurses();
                    break;
                case 10:
                    showAllPatients();
                    break;
                case 11:
                    updateDoctor(scanner);
                    break;
                case 12:
                    updateNurse(scanner);
                    break;
                case 13:
                    updatePatient(scanner);
                    break;
                case 14:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

// Method to add a new Doctor
        private static void addNewDoctor(Scanner scanner) {
    	  
    	System.out.print("Doctor id: ");
        int doctorid = scanner.nextInt();
        scanner.nextLine();// consume the newline character
        
 // Input for Doctor details
        System.out.println("Enter Doctor details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Degree: ");
        String degree = scanner.nextLine();

        System.out.print("Consultant Charges: ");
        int consultantCharges = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Address: ");
        String address = scanner.nextLine();
        
// Create a new Doctor instance and set its properties
        Doctor doctor = new Doctor();
        doctor.setId(doctorid);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setDegree(degree);
        doctor.setConsultantCharges(consultantCharges);
        doctor.setAddress(address);
 // Save the Doctor instance
        saveEntity(doctor);
        System.out.println("Doctor added successfully.");
    }
    
// Method to add a new Nurse   
    private static void addNewNurse(Scanner scanner) {
    	System.out.print("Nurse id: ");
        int nurseid = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        
        System.out.println("Enter Nurse details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Gender: ");
        String gender = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("Doctor id : ");
        int doctorid = scanner.nextInt();
        
        Doctor doctor = new Doctor();
        doctor.setId(doctorid);
        
        Nurse nurse = new Nurse();
        nurse.setId(nurseid);
        nurse.setName(name);
        nurse.setAge(age);
        nurse.setGender(gender);
        nurse.setAddress(address);
        nurse.setDoctor(doctor);

        saveEntity(nurse);
        System.out.println("Nurse added successfully.");
    }
    
 // Method to add a new Patient    
    private static void addNewPatient(Scanner scanner) {
    	System.out.print("Patient id: ");
        int patientid = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Patient details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Disease: ");
        String disease = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();
        
        System.out.print("Doctor id : ");
        int doctorid = scanner.nextInt();
        
        Doctor doctor = new Doctor();
        doctor.setId(doctorid);
        Patient patient = new Patient();
        patient.setId(patientid);
        patient.setName(name);
        patient.setAge(age);
        patient.setDisease(disease);
        patient.setAddress(address);
        patient.setDoctor(doctor);
        saveEntity(patient);
        System.out.println("Patient added successfully.");
        
    }
    
  // Method to update a new Doctor 
        private static void updateDoctor(Scanner scanner) {
        System.out.print("Doctor id: ");
        int doctorid = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.println("Enter Doctor details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Degree: ");
        String degree = scanner.nextLine();

        System.out.print("Consultant Charges: ");
        int consultantCharges = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Address: ");
        String address = scanner.nextLine();

        Doctor doctor = new Doctor();
        doctor.setId(doctorid);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setDegree(degree);
        doctor.setConsultantCharges(consultantCharges);
        doctor.setAddress(address);

        updateEntity(doctor);
        System.out.println("Doctor updated successfully.");
    }
        
   // Method to update a new Nurse    
    private static void updateNurse(Scanner scanner) {
        System.out.print("Nurse id: ");
        int nurseid = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        
        System.out.println("Enter Nurse details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Gender: ");
        String gender = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("Doctor id : ");
        int doctorid = scanner.nextInt();
        
        Doctor doctor = new Doctor();
        doctor.setId(doctorid);
        
        Nurse nurse = new Nurse();
        nurse.setId(nurseid);
        nurse.setName(name);
        nurse.setAge(age);
        nurse.setGender(gender);
        nurse.setAddress(address);
        nurse.setDoctor(doctor);

       updateEntity(nurse);
        System.out.println("Nurse update successfully.");
    }

 // Method to update a new Patient 
    private static void updatePatient(Scanner scanner) {
    	System.out.print("Patient id: ");
        int patientid = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        
        System.out.println("Enter Patient details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Disease: ");
        String disease = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();
        
        System.out.print("Doctor id : ");
        int doctorid = scanner.nextInt();
        
        Doctor doctor = new Doctor();
        doctor.setId(doctorid);
        
        Patient patient = new Patient();
        patient.setId(patientid);
        patient.setName(name);
        patient.setAge(age);
        patient.setDisease(disease);
        patient.setAddress(address);
        patient.setDoctor(doctor);
        updateEntity(patient);
        System.out.println("Patient update successfully.");
    }
    
 // Method to delete a Doctor entity based on the provided ID
    private static void deleteDoctor(Scanner scanner) {
        System.out.print("Enter Doctor ID to delete: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        Doctor doctor = getEntityById(Doctor.class, doctorId);
        if (doctor != null) {
            deleteEntity(doctor);
            System.out.println("Doctor deleted successfully.");
        } else {
            System.out.println("Doctor not found with ID: " + doctorId);
        }
    }
   
 // Method to delete a Nurse entity based on the provided ID
    private static void deleteNurse(Scanner scanner) {
        System.out.print("Enter Nurse ID to delete: ");
        int nurseId = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        Nurse nurse = getEntityById(Nurse.class, nurseId);
        if (nurse != null) {
            deleteEntity(nurse);
            System.out.println("Nurse deleted successfully.");
        } else {
            System.out.println("Nurse not found with ID: " + nurseId);
        }
    }

 // Method to delete a Patient entity based on the provided ID
    private static void deletePatient(Scanner scanner) {
        System.out.print("Enter Patient ID to delete: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        Patient patient = getEntityById(Patient.class, patientId);
        if (patient != null) {
            deleteEntity(patient);
            System.out.println("Patient deleted successfully.");
        } else {
            System.out.println("Patient not found with ID: " + patientId);
        }
    }
 // Method to assign a Patient to a Doctor based on the provided IDs
    private static void assignPatientToDoctor(Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        Patient patient = getEntityById(Patient.class, patientId);
        if (patient == null) {
            System.out.println("Patient not found with ID: " + patientId);
            return;
        }

        System.out.print("Enter Doctor ID to assign the patient: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        Doctor doctor = getEntityById(Doctor.class, doctorId);
        if (doctor == null) {
            System.out.println("Doctor not found with ID: " + doctorId);
            return;
        }

        patient.setDoctor(doctor);
        saveEntity(patient);
        System.out.println("Patient assigned to Doctor successfully.");
    }
    
 // Method to display all Doctor entities
    private static void showAllDoctors() {
        List<Doctor> doctors = getAllEntities(Doctor.class);
        if (doctors.isEmpty()) {
            System.out.println("No Doctors found.");
        } else {
            System.out.println("List of Doctors:");
            for (Doctor doctor : doctors) {
                System.out.println(doctor);
            }
        }
    }
    
 // Method to display all Nurse entities
    private static void showAllNurses() {
        List<Nurse> nurses = getAllEntities(Nurse.class);
        if (nurses.isEmpty()) {
            System.out.println("No Nurses found.");
        } else {
            System.out.println("List of Nurses:");
            for (Nurse nurse : nurses) {
                System.out.println(nurse);
            }
        }
    }
    
 // Method to display all Patient entities
    private static void showAllPatients() {
        List<Patient> patients = getAllEntities(Patient.class);
        if (patients.isEmpty()) {
            System.out.println("No Patients found.");
        } else {
            System.out.println("List of Patients:");
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }
    
 // Method to save an entity to the database
    private static void saveEntity(Object entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
     //   SessionFactory factory = null;
 
        try {
     //   	factory = new Configuration().configure("connection.xml").buildSessionFactory();
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
 // Method to update an entity in the database
    private static void updateEntity(Object entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
     //   SessionFactory factory = null;
 
        try {
     //   	factory = new Configuration().configure("connection.xml").buildSessionFactory();
            transaction = session.beginTransaction();
            session.saveOrUpdate(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    
 // Method to delete an entity from the database
    private static void deleteEntity(Object entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

 // Method to retrieve an entity from the database based on its class and ID
    private static <T> T getEntityById(Class<T> entityClass, int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        T entity = session.get(entityClass, id);
        session.close();
        return entity;
    }

 // Method to retrieve all entities of a particular class from the database
    private static <T> List<T> getAllEntities(Class<T> entityClass) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<T> entities = session.createQuery("FROM " + entityClass.getSimpleName(), entityClass).list();
        session.close();
        return entities;
    }
}


