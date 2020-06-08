<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    />
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/error.css" type="text/css" />
    <title>Error</title>
  </head>
  <body>
    <section class="bg-image fullscreen">
      <div class="overlay"></div>
      <div class="container align-left text-white">
        <h1 class="py-3 subtitle">
          <span style="font-style: normal;">ERROR PAGE</span>
        </h1>
        <h2 class="py-3 display-1 title">Oops! Something went wrong....</h2>
        <p class="py-3 display-5">
          The page you are looking for is not available. Please check the URL.
        </p>
      </div>
    </section>

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
  </body>
</html>
