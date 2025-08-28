<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Survey Result</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/survey.css">
</head>
<body>
  <h1>Thank you for submitting the survey!</h1>

  <p>Name: ${result.firstName} ${result.lastName}</p>
  <p>Email: ${result.email}</p>
  <p>Date of Birth: ${result.dob}</p>
  <p>Heard from: ${result.heardFrom}</p>
  <p>Wants Updates: ${result.wantsUpdates ? 'Yes' : 'No'}</p>
  <p>Email Announcements: ${result.emailOK ? 'Yes' : 'No'}</p>
  <p>Contact via: ${result.contactViaText}</p>

  <p><a href="${pageContext.request.contextPath}/index.html">Back to form</a></p>
</body>
</html>
