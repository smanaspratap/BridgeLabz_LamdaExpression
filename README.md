# LambdaExpression – User Registration Validation (Lambda + JUnit)

This project validates **User Registration fields** using **Functional Interface + Lambda Expressions** and verifies them using **JUnit 5** test cases (Happy + Sad + Parameterized Email Tests).

---

## Features Covered

### Validations (Lambda Based)
- **UC1 First Name**: Starts with Capital, minimum 3 characters
- **UC2 Last Name**: Starts with Capital, minimum 3 characters
- **UC9 Email**: Valid/Invalid samples validation using regex
- **UC4 Mobile**: Format `CC XXXXXXXXXX` (Example: `91 9919819801`)
- **UC5–UC8 Password** (All rules must pass):
    - UC5: Minimum 8 characters
    - UC6: At least 1 uppercase
    - UC7: At least 1 digit
    - UC8: Exactly 1 special character

### Testing (JUnit 5)
- Happy test cases (valid input passes)
- Sad test cases (invalid input fails)
- **Parameterized tests** for multiple email samples

---

## Project Structure
LambdaExpression/        
├── src/                         
│ ├── main/           
│ │ └── java/       
│ │ └── LambdaExpression.java           
│ └── test/          
│ └── java/      
│ └── LambdaExpressionTest.java       
└── pom.xml (if using Maven)


---

## Dependencies (JUnit 5)

### Maven (pom.xml)
```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.2.5</version>
        </plugin>
    </plugins>
</build>
