<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Por Genero</title>

    <link href="/pipoca/css/bootstrap.min.css" rel="stylesheet">
    <link href="/pipoca/css/style.css" rel="stylesheet">
</head>
<body>
<c:import url="Menu.jsp"/>
				
				
<div id="main" class="container">
	<c:forEach var="genero" items="${porGeneros}">
		<h3 class="page-header">${genero.nome}</h3>
		<div class="row">
            <div class="span12">
                <div class="well">
                    <div id="myCarousel" class="carousel fdi-Carousel slide">
                     <!-- Carousel items -->
                     
                        <div class="carousel fdi-Carousel slide" id="eventCarousel" data-interval="0">
                            <div class="carousel-inner onebyone-carosel">
                            
                            
                            
                            <c:forEach var="filmes" items="${genero.filmes}" varStatus="loop">
                            	
                            	<c:choose>
								<c:when test="${loop.index == 0}">
									<div class="item active">
								</c:when>
								<c:otherwise>
									<div class="item">
								</c:otherwise>
							</c:choose> 	
                                    <div class="col-md-4">
                                        <a href="#"><img src="http://placehold.it/250x250" class="img-responsive center-block"></a>
                                        <div class="text-center">${filmes.titulo}</div>
                                    </div>
                                </div>
                            </c:forEach>     
                            
                            </div>
                            <a class="left carousel-control" href="#eventCarousel" data-slide="prev"></a>
                            <a class="right carousel-control" href="#eventCarousel" data-slide="next"></a>
                        </div>
                      
                        <!--/carousel-inner-->
                    </div><!--/myCarousel-->
                </div><!--/well-->
            </div>
        	</div>
       </c:forEach>
	</div>	
			
<script src="/pipoca/js/jquery.min.js"></script>
<script src="/pipoca/js/bootstrap.min.js"></script>
<script src="/pipoca/js/custom.js"></script> 
</body>
</html>