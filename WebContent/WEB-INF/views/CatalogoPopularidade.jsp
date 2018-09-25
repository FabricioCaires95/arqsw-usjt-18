<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Popularidade</title>

    <link href="/pipoca/css/bootstrap.min.css" rel="stylesheet">
    <link href="/pipoca/css/style.css" rel="stylesheet">
</head>
<body>
<c:import url="Menu.jsp"/>
								
<div id="main" class="container">
 <!--de 81 a  100  -->
 
	<h3 class="page-header">De 81 a 100</h3>
		<div class="row">
            <div class="span12">
                <div class="well">
                    <div id="myCarousel" class="carousel fdi-Carousel slide">
                     <!-- Carousel items -->
                     
                        <div class="carousel fdi-Carousel slide" id="eventCarousel" data-interval="0">
                            <div class="carousel-inner onebyone-carosel">
                            <c:forEach var="filme" items="${filmes5}" varStatus="loop">        	
                            	<c:choose>
								<c:when test="${loop.index==0}">
									<div class="item active">
								</c:when>
								<c:otherwise>
									<div class="item">
								</c:otherwise>
							</c:choose> 	
                                    <div class="col-md-4">
                                        <a href="#"><img src="http://placehold.it/250x250" class="img-responsive center-block"></a>
                                        <div class="text-center">${filme.titulo}</div>
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
        	 <!--de 81 a  100  fim  -->
        	 
       <!--de 61 a  80  -->
        	<h3 class="page-header">De 61 a 80</h3>
		<div class="row">
            <div class="span12">
                <div class="well">
                    <div id="myCarousel" class="carousel fdi-Carousel slide">
                     <!-- Carousel items -->
                     
                        <div class="carousel fdi-Carousel slide" id="eventCarousel" data-interval="0">
                            <div class="carousel-inner onebyone-carosel">
                            <c:forEach var="filme" items="${filmes4}" varStatus="loop">        	
                            	<c:choose>
								<c:when test="${loop.index==0}">
									<div class="item active">
								</c:when>
								<c:otherwise>
									<div class="item">
								</c:otherwise>
							</c:choose> 	
                                    <div class="col-md-4">
                                        <a href="#"><img src="http://placehold.it/250x250" class="img-responsive center-block"></a>
                                        <div class="text-center">${filme.titulo}</div>
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
        	 <!--fim -->
        	 
     <!--de  51 a  60  -->
        	<h3 class="page-header">De 51 a 60</h3>
		<div class="row">
            <div class="span12">
                <div class="well">
                    <div id="myCarousel" class="carousel fdi-Carousel slide">
                     <!-- Carousel items -->
                     
                        <div class="carousel fdi-Carousel slide" id="eventCarousel" data-interval="0">
                            <div class="carousel-inner onebyone-carosel">
                            <c:forEach var="filme" items="${filmes3}" varStatus="loop">        	
                            	<c:choose>
								<c:when test="${loop.index==0}">
									<div class="item active">
								</c:when>
								<c:otherwise>
									<div class="item">
								</c:otherwise>
							</c:choose> 	
                                    <div class="col-md-4">
                                        <a href="#"><img src="http://placehold.it/250x250" class="img-responsive center-block"></a>
                                        <div class="text-center">${filme.titulo}</div>
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
        	 <!--fim -->
        <!--de 31 a  50  --> 	
        	<h3 class="page-header">De 31 a 50</h3>
		<div class="row">
            <div class="span12">
                <div class="well">
                    <div id="myCarousel" class="carousel fdi-Carousel slide">
                     <!-- Carousel items -->
                     
                        <div class="carousel fdi-Carousel slide" id="eventCarousel" data-interval="0">
                            <div class="carousel-inner onebyone-carosel">
                            <c:forEach var="filme" items="${filmes2}" varStatus="loop">        	
                            	<c:choose>
								<c:when test="${loop.index==0}">
									<div class="item active">
								</c:when>
								<c:otherwise>
									<div class="item">
								</c:otherwise>
							</c:choose> 	
                                    <div class="col-md-4">
                                        <a href="#"><img src="http://placehold.it/250x250" class="img-responsive center-block"></a>
                                        <div class="text-center">${filme.titulo}</div>
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
        	 <!--fim -->
        	 <!--de 0 a  30  -->
        	<h3 class="page-header">De 0 a 31</h3>
		<div class="row">
            <div class="span12">
                <div class="well">
                    <div id="myCarousel" class="carousel fdi-Carousel slide">
                     <!-- Carousel items -->
                     
                        <div class="carousel fdi-Carousel slide" id="eventCarousel" data-interval="0">
                            <div class="carousel-inner onebyone-carosel">
                            <c:forEach var="filme" items="${filmes1}" varStatus="loop">        	
                            	<c:choose>
								<c:when test="${loop.index==0}">
									<div class="item active">
								</c:when>
								<c:otherwise>
									<div class="item">
								</c:otherwise>
							</c:choose> 	
                                    <div class="col-md-4">
                                        <a href="#"><img src="http://placehold.it/250x250" class="img-responsive center-block"></a>
                                        <div class="text-center">${filme.titulo}</div>
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
        	 <!--fim -->
        	
	</div>	
			
<script src="/pipoca/js/jquery.min.js"></script>
<script src="/pipoca/js/bootstrap.min.js"></script>
<script src="/pipoca/js/custom.js"></script> 
</body>
</html>