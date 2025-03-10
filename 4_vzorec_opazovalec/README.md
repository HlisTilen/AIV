# **Vaje AIV – Iterator vzorec**

## **1. Kaj je Iterator vzorec?**
**Iterator** je načrtovalski vzorec, ki omogoča **postopen dostop do elementov zbirke (kolekcije), ne da bi razkrivali njeno notranjo implementacijo**.  
Uporablja se za **iteracijo skozi podatke** v strukturiran način, kar omogoča **boljšo ločenost kode** in **fleksibilnost** pri filtriranju podatkov.

### **🔹 Ključne lastnosti Iteratorja**
✅ **Enostavna iteracija** – Omogoča **enoten način** za prehod skozi različne zbirke.  
✅ **Ločitev logike** – Iteracijska logika ni del osnovnih podatkovnih razredov (VAO), ampak se izvaja ločeno.  
✅ **Podpora za filtriranje** – Iterator omogoča **iteracijo samo skozi določene elemente** (npr. samo aktivne entitete).  

---

## **2. Struktura projekta**
V tej nalogi bomo uporabili **Iterator vzorec**, ki bo omogočal različne načine iteracije skozi podatke. 

```bash
📦 src/main/java/com/example/project
 ┣ 📂 vao              # VAO (Entity) razredi (podatkovni objekti)
 ┃ ┣ 📜 User.java
 ┃ ┣ 📜 Contact.java
 ┃
 ┣ 📂 dao              # Podatkovni sloj (Data Access Layer)
 ┃ ┣ 📂 interfaces     # DAO vmesniki
 ┃ ┃ ┣ 📜 UserDAOInterface.java
 ┃ ┃ ┣ 📜 ContactDAOInterface.java
 ┃ ┣ 📜 UserDAO.java   # Implementacija DAO s Singleton vzorcem
 ┃ ┣ 📜 ContactDAO.java
 ┃
 ┣ 📂 service          # Poslovni sloj (Business Logic Layer)
 ┃ ┣ 📜 UserService.java
 ┃ ┣ 📜 ContactService.java
 ┃
 ┣ 📂 iterators        # Iteratorji za prehod skozi podatke
 ┃ ┣ 📜 ContactIterator.java              # Iterira skozi vse kontakte določenega uporabnika
 ┃ ┣ 📜 ContactByTypeIterator.java        # Iterira samo kontakte določenega tipa (npr. mobile)
 ┃ ┣ 📜 AllContactsIterator.java          # Iterira skozi vse kontakte vseh uporabnikov
 ┃
 ┣ 📜 Main.java        # Glavni program
```

### **🔹 Pojasnilo**
- **VAO (Value Access Object)**  
  - Preprosti objekti (`User`, `Contact`), ki hranijo podatke in ne vsebujejo poslovne logike.  
- **DAO (Data Access Object)**  
  - Omogoča dostop do podatkov (`UserDAO`, `ContactDAO`).  
  - **Uporablja Singleton vzorec**, da zagotovi **eno instanco** v aplikaciji.  
- **Service Layer (`UserService`, `ContactService`)**  
  - Loči **poslovno logiko** od DAO sloja.  
  - Preprečuje neposredne klice DAO v `Main.java`.  
- **Iteratorji (`ContactIterator`, `ContactByTypeIterator`, `AllContactsIterator`)**  
  - Omogočajo iteracijo skozi podatke na različne načine.  
- **Main (`Main.java`)**  
  - Glavna aplikacija, ki uporablja `UserService`, `ContactService` in **Iteratorje** za delo s podatki.  

---

## **3. Implementacija Iteratorja**
### **📜 `ContactIterator.java` – Iteracija skozi vse kontakte določenega uporabnika**

### **📜 `ContactByTypeIterator.java` – Iteracija samo po kontaktih določenega tipa**

### **📜 `AllContactsIterator.java` – Iteracija skozi vse kontakte vseh uporabnikov**

---

## **4. Zaključek** 
✔ **Dodani iteratorji za različne načine prehoda skozi podatke.** 
✔ **Ustvarjena modularna in razširljiva arhitektura.**  
