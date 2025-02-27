# Predavanja AIV

## **1. Kaj so VAO in DAO?**

- **VAO (Value Access Object)**: Struktura, ki predstavlja podatkovni objekt (npr. entiteto) in vsebuje samo podatke brez poslovne logike.
- **DAO (Data Access Object)**: Vzorec, ki omogoča dostop do podatkov (ponavadi iz baze) na način, ki loči logiko dostopa do podatkov od poslovne logike aplikacije.

## **2. Razlaga koncepta**

- **Zakaj VAO?**
    - Preprosti prenosni objekti, ki vsebujejo podatke.
    - Ločitev od podatkovne logike.
- **Zakaj DAO?**
    - Omogoča izolacijo podatkovne plasti.
    - Poenostavi testiranje.
    - Omogoča enostavno zamenjavo implementacije podatkovnega shranjevanja (npr. prehod iz in-memory baze v pravo SQL bazo).

### **Preprost primer**

1. **User** (uporabnik)
2. **Contact** (kontakt uporabnika) – vsak uporabnik ima svojo listo kontaktov.

V tem primeru bo:

- **UserDAO** skrbel za uporabnike.
- **ContactDAO** skrbel za kontakte, ki pripadajo določenemu uporabniku.
- **Seznami (`List<User>` in `List<Contact>`)** bodo služili kot "baza".

### Struktura projekta

```bash
📦 src/main/java/com/example/project
 ┣ 📂 vao                # VAO (Entity) razredi
 ┃ ┣ 📜 User.java
 ┃ ┣ 📜 Contact.java
 ┃
 ┣ 📂 dao     # Podatkovni sloj (Data Access Layer)
 ┃ ┣ 📂 interfaces         # DAO vmesniki
 ┃ ┃ ┣ 📜 UserDAOInterface.java
 ┃ ┃ ┣ 📜 ContactDAOInterface.java
 ┃ ┣ 📜 UserDAO.java
 ┃ ┣ 📜 ContactDAO.java
 ┃
 ┣ 📜 Main.java             # Glavni program

```

## Dodajanje vmesnika za DAO

### **Zakaj uporabiti interface za DAO?**

✅ **Ločitev implementacije od abstrakcije** – Omogoča enostavno zamenjavo podatkovne plasti (lahko imamo eno implementacijo za `List<>`, drugo pa za pravo SQL bazo).

✅ **Lažje testiranje** – Možno je preprosto mockati DAO v testih brez potrebe po dejanski bazi.

✅ **Podpora za več podatkovnih virov** – Enostavno dodamo podporo za **različne podatkovne shrambe** (npr. MySQL, MongoDB, datoteke itd.).

✅ **Skalabilnost** – Ko projekt raste, se različne implementacije DAO lahko prilagajajo brez poseganja v poslovno logiko.

# **Povzetek - Uvod v DAO in VAO v Javi**

## **1. Kaj je DAO (Data Access Object)?**

DAO (Data Access Object) je **objekt**, ki ločuje logiko dostopa do podatkov od preostale poslovne logike aplikacije.

Njegova glavna naloga je **upravljanje trajnosti podatkov** – to pomeni, da omogoča shranjevanje, iskanje, posodabljanje in brisanje podatkov.

### **Zakaj uporabljamo DAO?**

✅ **Ločevanje logike** – Koda za dostop do podatkov je ločena od poslovne logike aplikacije.

✅ **Boljša modularnost** – Če spremenimo način shranjevanja podatkov (npr. prehod iz seznama na SQL bazo), se spremeni samo DAO, ne pa celotna aplikacija.

✅ **Testabilnost** – Z uporabo vmesnikov (`interface`) lahko enostavno **mockamo DAO** in testiramo aplikacijo brez povezave z bazo.

✅ **Ponovna uporabnost** – DAO se lahko uporablja v različnih delih aplikacije brez podvajanja kode.

---

## **2. Kaj je VAO (Value Access Object)?**

VAO (včasih imenovan tudi POJO - Plain Old Java Object) je **preprost razred**, ki predstavlja **entiteto** in hrani podatke.

VAO **nima poslovne logike** – vsebuje samo **atribute, getterje in setterje**.

### **Primer VAO vloge**

- **VAO** = Samo shranjuje podatke (`User`, `Contact`)
- **DAO** = Skrbi za dostop do podatkov (`UserDAO`, `ContactDAO`)

---

## **3. Struktura**

### **Glavni deli arhitekture:**

1️⃣ **Value Access Object (VAO)** → Reprezentira entiteto (npr. `User`, `Contact`).

2️⃣ **DAO Interface** → Definira metode za delo s podatki (`UserDAOInterface`, `ContactDAOInterface`).

4️⃣ **Glavna aplikacija (Main)** → Uporablja DAO za upravljanje podatkov.

### **Kako to deluje?**

📌 **DAO implementira interface**, kar omogoča enostavno **zamenjavo podatkovne plasti** brez sprememb v preostali aplikaciji.

📌 **Singleton vzorec v DAO** zagotavlja, da imamo **eno samo instanco**, kar preprečuje podvajanje objektov in optimizira pomnilnik.