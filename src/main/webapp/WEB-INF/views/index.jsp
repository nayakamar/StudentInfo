<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Student</title>
</head>
<body>
    <h1>Create Student</h1>
    <form action="${pageContext.request.contextPath}/api/students" method="post">
        <label for="rollNo">Roll No:</label>
        <input type="text" id="rollNo" name="rollNo" required><br><br>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br><br>

        <label for="phoneNum">Phone Number:</label>
        <input type="text" id="phoneNum" name="phoneNum" required><br><br>

        <label for="emailId">Email:</label>
        <input type="email" id="emailId" name="emailId" required><br><br>

        <label for="gender">Gender:</label>
        <select id="gender" name="gender" required>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
        </select><br><br>

        <label for="totalMarks">Total Marks:</label>
        <input type="number" id="totalMarks" name="totalMarks" required><br><br>

        <input type="submit" value="Create">
    </form>

    <h1>Student List</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Roll No</th>
                <th>Name</th>
                <th>Age</th>
                <th>Phone Number</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Total Marks</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.rollNo}</td>
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                    <td>${student.phoneNum}</td>
                    <td>${student.emailId}</td>
                    <td>${student.gender}</td>
                    <td>${student.totalMarks}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
