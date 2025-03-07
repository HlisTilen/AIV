# **Vaje AIV – Singleton vzorec, Service Layer in DAO**

## **1. Kaj je Singleton vzorec?**
**Singleton (Edinec)** je načrtovalski vzorec, ki zagotavlja, da v aplikaciji obstaja **samo ena instanca določenega razreda**.  
To je uporabno, kadar potrebujemo **centraliziran dostop do virov**, kot je **podatkovna shramba (DAO)**.

### **🔹 Ključne lastnosti Singletona**
✅ **Ena sama instanca** – Ves čas delovanja aplikacije obstaja samo en objekt.  
✅ **Centraliziran dostop** – Vsi deli aplikacije uporabljajo isto instanco.  
✅ **Nadzirano ustvarjanje objektov** – Objekt se ustvari **le ob prvem klicu** in nato znova uporabi.  

---

## **2. Struktura projekta**
V tej nalogi bomo uporabili **Singleton vzorec v DAO sloju** in **Service Layer**, ki bo skrbel za poslovno logiko.

```bash
📦 src/main/java/com/example/project
 ┣ 📂 vao              # VAO (Entity) razredi (podatkovni objekti)
 ┃ ┣ 📜 User.java
 ┃
 ┣ 📂 dao              # Podatkovni sloj (Data Access Layer)
 ┃ ┣ 📂 interfaces     # DAO vmesniki
 ┃ ┃ ┣ 📜 UserDAOInterface.java
 ┃ ┣ 📜 UserDAO.java   # Implementacija DAO s Singleton vzorcem
 ┃
 ┣ 📂 service          # Poslovni sloj (Business Logic Layer)
 ┃ ┣ 📜 UserService.java
 ┃
 ┣ 📜 Main.java        # Glavni program
```

### **🔹 Pojasnilo**
- **VAO (Value Access Object)**  
  - Preprost objekt (`User`), ki hrani podatke in ne vsebuje logike.  
- **DAO (Data Access Object)**  
  - Omogoča dostop do podatkov (`UserDAO`).  
  - **Uporablja Singleton vzorec**, da zagotovi **eno instanco** v aplikaciji.  
- **Service Layer (`UserService`)**  
  - Loči **poslovno logiko** od DAO sloja.  
  - Preprečuje neposredne klice DAO v `Main.java`.  
- **Main (`Main.java`)**  
  - Glavna aplikacija, ki uporablja `UserService` za upravljanje podatkov.  

---

## **3. Implementacija Singletona v DAO**
### **📜 `UserDAO.java` – Implementacija Singletona (podpora za večnitno okolje)**

---

## **4. Uporaba Service Layerja (`UserService`)**
### **📜 `UserService.java`**

---

## **5. Glavna aplikacija (`Main.java`)**
### **📜 `Main.java`**

---

## **6. Zaključek**
✔ **Implementacija Singleton vzorec v `UserDAO`.**  
✔ **Dodan Service Layer (`UserService`) za ločevanje poslovne logike.**  
✔ **Zagotovitev večnitne varnosti (`synchronized`).**  
✔ **Ustvarjena modularna in razširljiva arhitektura.**
