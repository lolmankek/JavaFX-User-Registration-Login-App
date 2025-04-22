# 💻 JavaFX User Registration & Login App

This is a **JavaFX desktop application** built with the help of **SceneBuilder**. It provides a graphical interface for
**user registration and login**, with data stored locally in an **H2 embedded database**.

---

## 🧰 Technologies Used

| Technology   | Description                         |
|--------------|-------------------------------------|
| JavaFX       | UI framework for building the app   |
| SceneBuilder | Drag-and-drop UI designer           |
| H2 Database  | Embedded database (version 2.3.232) |
| Maven        | Build and dependency management     |
| FXML         | Declarative UI structure            |

---

## 🔧 Technologies Used

- Java 17+

- JavaFX + FXML

- SceneBuilder – for GUI design

- H2 Database (version 2.3.232)

- Maven – for dependency management

---

## 📦 Maven Dependency

To use H2 in your project, include this in your `pom.xml`:

```xml
<!-- https://mvnrepository.com/artifact/com.h2database/h2 -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <version>2.3.232</version>
</dependency>
```

---

## 🎯 Application Features

- 📝 User registration (stores data such as name, gender, and password).

- 🔐 User login with credential verification.

- 🏠 Redirect to the homepage after successful login.

- 🧾 Checks for existing users in the database.

- 💾 All data is stored in an embedded H2 database.

---

## 🚀 How to Run the Project

1. Make sure you have:

- Java 17+ installed

- Maven installed

2. Clone the repository:

`git clone https://github.com/your-username/your-repo.git`

3. Build the project:

`mvn clean install`

4. Run Main.java from your IDE (e.g., IntelliJ IDEA).

---

## 🌐 Accessing the H2 Console (optional)

If you'd like to explore or query the database manually:

1. Download and launch the H2 Console:
   `java -jar h2-2.3.232.jar`
2. Open your browser: http://localhost:8082
3. Use the following settings:

   |         Field       |       Value       |
   |---------------|-------------------------|
   | JDBC URL      | jdbc:h2:~/test          |
   | User Name     | sa                      |
   | Password      | (leave empty)           |

---

## 🙌 Credits

- Created by **lolmankek**
- UI built using JavaFX + SceneBuilder.
- Database powered by H2.

---
## 📸 Screenshots

![Login Screen](https://github.com/lolmankek/javaFX-H2---RegistrtaionForm/blob/master/src/main/resources/styles/Authorization.png?raw=true)
![Registration Screen](https://github.com/lolmankek/javaFX-H2---RegistrtaionForm/blob/master/src/main/resources/styles/Registration.png?raw=true)

---
## 📎 License
This project is open source and available under the MIT License.