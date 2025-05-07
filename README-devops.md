# DevOps Setup – MM SkillLaunch

Acest fișier descrie modul de rulare locală al aplicației backend + MySQL folosind `podman-compose`.

---

## 🔧 Cerințe

- [Podman](https://podman.io/)
- `podman-compose` (`pip install podman-compose`)
- JDK 17+
- Maven

---

## 📁 Structura proiectului

```
MM-SkillLaunch/
├── compose.yml
├── backend/
│   ├── Dockerfile
│   ├── target/app.jar
```

---

## 🚀 Pași pentru rulare locală

### 1. Build .jar

Intră în folderul `backend/` și build-uiește aplicația:

```bash
cd backend
mvn clean package
```

---

### 2. Creează fișierul `Dockerfile` (dacă nu există)

```Dockerfile
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

### 3. Rulează containerele

Din root:

```bash
podman-compose -f compose.yml up --build
```

---

### 4. Test

Backend-ul ar trebui să fie disponibil pe:

```
http://localhost:3307
```

---

### 5. Oprire containere

```bash
podman-compose -f compose.yml down
