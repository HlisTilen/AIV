# **Vaje AIV – Vzorec Opazovalec (Observer)**

## **1. Kaj je vzorec Opazovalec (Observer)?**
**Opazovalec (Observer)** je načrtovalski vzorec, ki omogoča, da en objekt (**"Subject"**) obvesti več objektov (**"Observers"**) o spremembah, ne da bi bil tesno povezan z njimi.

👀 **Kdaj uporabiti vzorec Observer?**
✅ Kadar želimo, da se več objektov (npr. uporabniški vmesnik, beleženje v bazo, e-mail obvestila) odzove na spremembo v enem objektu.
✅ Kadar želimo **ohlapno povezavo** med objekti → **Opazovalec ne pozna podrobnosti o subjektu**.

### **🔹 Kako to deluje?**
- **Subjekt (User)** hrani seznam opazovalcev (`List<ContactObserver>`).
- **Ko se zgodi sprememba (dodajanje/brisanje kontakta)**, subjekt **obvesti vse opazovalce**.
- **Opazovalci** nato izvedejo svojo logiko (npr. izpišejo obvestilo, shranijo podatek v bazo, pošljejo e-mail ipd.).

---

## **2. Struktura projekta**
V tej nalogi bomo uporabili **vzorec Observer**, ki bo omogočal beleženje sprememb pri dodajanju in brisanju kontaktov.

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
 ┣ 📜 Main.java          # Glavni program
```

---

## **3. Implementacija Observerja**
### **📜 `ContactObserver.java` – Opazovalec**

✅ **Le ena metoda `update()`, ki obvesti opazovalca o spremembi**.
✅ **Vsak opazovalec se lahko odloči, na katere spremembe se odzove**.

---

### **📜 `User.java` – Subjekt**

✅ **Obvesti vse opazovalce vsakič, ko dodamo ali odstranimo kontakt**.

---

### **📜 `ContactAddedNotifier.java` – Obvešča ob dodajanju kontakta**

✅ **Reagira samo na dodajanje kontaktov**.

---

### **📜 `ContactRemovedNotifier.java` – Obvešča ob brisanju kontakta**

✅ **Reagira samo na odstranjevanje kontaktov**.

---

## **4. Glavna aplikacija (`Main.java`)**

---

## **5. Pričakovan izpis**
```
Contact Added Notification: New contact added for tilen@example.com: +386 41 123 456
Contact Removed Notification: Contact removed for tilen@example.com: +386 41 123 456
```

---

## **6. Zaključek**
✔ **Implementiran vzorec Observer** za beleženje sprememb kontaktov.
✔ **Uporabljena enotna metoda `update()` v `ContactObserver`**.
✔ **Obvestila so ločena (`ContactAddedNotifier`, `ContactRemovedNotifier`)**.
✔ **Zagotavlja ohlapno povezavo med `User` in opazovalci**.
