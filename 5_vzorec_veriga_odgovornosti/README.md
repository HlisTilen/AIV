# **Vaje AIV – Vzorec Veriga Odgovornosti (Chain of Responsibility)**

## **1. Kaj je vzorec Veriga Odgovornosti (Chain of Responsibility)?**
**Veriga odgovornosti (Chain of Responsibility, CoR)** omogoča, da zahteva potuje skozi **zaporedje obdelovalcev**, pri čemer vsak preveri določene pogoje in se odloči, ali jo obdela ali posreduje naprej.  

✅ Omogoča **modularno preverjanje** (npr. validacija, preverjanje omejitev).  
✅ Preprečuje dolge **"if-else" bloke** in izboljša berljivost kode.  
✅ Omogoča enostavno dodajanje novih pravil **brez spreminjanja obstoječega kode**.  

### **🔹 Kako deluje v tej nalogi?**
💡 **Ko uporabnik želi dodati kontakt, sistem preveri naslednje korake:**  
1️⃣ **Ali ima telefonska številka veljavno obliko?**  
2️⃣ **Ali kontakt že obstaja v seznamu uporabnika?**  
3️⃣ **Ali uporabnik ni presegel maksimalnega števila kontaktov?**  

Če **vsi koraki uspejo**, se kontakt shrani v bazo. Če **katerikoli pogoj ni izpolnjen**, se postopek ustavi in kontakt ni dodan.

---

## **2. Struktura projekta**
V tej nalogi smo implementirali **Chain of Responsibility**, ki omogoča modularno preverjanje pred dodajanjem kontaktov.
```bash
📦 src/main/java/com/example/project
 ┣ 📂 vao                # VAO (Entity) razredi (podatkovni objekti)
 ┃ ┣ 📜 User.java
 ┃ ┣ 📜 Contact.java
 ┃
 ┣ 📂 dao                # Podatkovni sloj (Data Access Layer)
 ┃ ┣ 📂 interfaces       # DAO vmesniki
 ┃ ┃ ┣ 📜 UserDAOInterface.java
 ┃ ┃ ┣ 📜 ContactDAOInterface.java
 ┃ ┣ 📜 UserDAO.java     # Implementacija DAO s Singleton vzorcem
 ┃ ┣ 📜 ContactDAO.java  # Implementacija DAO s Singleton vzorcem
 ┃
 ┣ 📂 service            # Poslovni sloj (Business Logic Layer)
 ┃ ┣ 📜 UserService.java
 ┃ ┣ 📜 ContactService.java
 ┃
 ┣ 📂 iterators        # Iteratorji za prehod skozi podatke
 ┃ ┣ 📜 ContactIterator.java              # Iterira skozi vse kontakte določenega uporabnika
 ┃ ┣ 📜 ContactByTypeIterator.java        # Iterira samo kontakte določenega tipa (npr. mobile)
 ┃ ┣ 📜 AllContactsIterator.java          # Iterira skozi vse kontakte vseh uporabnikov
 ┃
 ┣ 📂 observers          # Vzorec opazovalec (Observer Pattern)
 ┃ ┣ 📜 ContactObserver.java
 ┃ ┣ 📜 ContactAddedNotifier.java
 ┃ ┣ 📜 ContactRemovedNotifier.java
 ┃
 ┣ 📂 chainofresponsibility     # Veriga odgovornosti (Chain of Responsibility)
 ┃ ┣ 📜 ContactHandler.java            # Osnovni vmesnik za obdelavo zahtev
 ┃ ┣ 📜 PhoneNumberValidationCheck.java # Preverjanje formata telefonske številke
 ┃ ┣ 📜 DuplicateContactCheck.java      # Preverjanje, ali kontakt že obstaja
 ┃ ┣ 📜 MaxContactsCheck.java           # Preverjanje, ali uporabnik ni presegel omejitve
 ┃
 ┣ 📜 Main.java          # Glavni program
```

---

## **3. Implementacija Verige odgovornosti**
### **📜 `ContactHandler.java` – Osnovni razred za obdelavo zahtev**

✅ Vsak obdelovalec pokliče **naslednjega v verigi**, če preverjanje uspe.  

---

### **📜 `PhoneNumberValidationCheck.java` – Preverjanje formata telefonske številke**

✅ Če telefonska številka ni pravilna, se postopek **ustavi**.  

---

### **📜 `DuplicateContactCheck.java` – Preverjanje, ali kontakt že obstaja**

✅ Če kontakt že obstaja, se **postopek prekine**.  

---

### **📜 `MaxContactsCheck.java` – Preverjanje omejitve kontaktov**

✅ Če uporabnik že ima največje dovoljeno število kontaktov, se **postopek prekine**.  

---

## **4. Zaključek**
✔ **Vzorec Chain of Responsibility omogoča modularno preverjanje.**  
✔ **Vsako preverjanje je ločen razred, ki ne vpliva na druge dele kode.**  
✔ **Glavna logika v `Main.java` ostaja čista in berljiva.**  
✔ **Enostavno dodajanje novih pravil v prihodnosti.**  
