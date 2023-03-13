<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="zxx" class="no-js">

<head>
	<!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicon-->
	<link rel="shortcut icon" href="img/zero.jpg">
	<!-- Author Meta -->
	<meta name="author" content="CodePixar">
	<!-- Meta Description -->
	<meta name="description" content="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>Zero Sneaker</title>
	<!--
		CSS
		============================================= -->
	<link rel="stylesheet" href="css/linearicons.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/themify-icons.css">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/owl.carousel.css">
	<link rel="stylesheet" href="css/nice-select.css">
	<link rel="stylesheet" href="css/nouislider.min.css">
	<link rel="stylesheet" href="css/ion.rangeSlider.css" />
	<link rel="stylesheet" href="css/ion.rangeSlider.skinFlat.css" />
	<link rel="stylesheet" href="css/magnific-popup.css">
	<link rel="stylesheet" href="css/main.css">
</head>

<body>

	<!-- Start Header Area -->
<jsp:include page="menu.jsp"></jsp:include>
	<!-- End Header Area -->

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Product Details</h1>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Single Product Area =================-->
	<div class="product_image_area">
		<div class="container">
			<div class="row s_product_inner">
				<div class="col-lg-6">

						<div class="single-prd-item">
							<img class="img-fluid" src="${detail.image}" alt="">
						</div>
				</div>
				<div class="col-lg-5 offset-lg-1">
					<div class="s_product_text">
						<h3>${detail.name}</h3>
                                                <h2>$<fmt:formatNumber value="${detail.price}"/></h2>
						<ul class="list">
							<li><a href="#"><span>Availibility</span> : In Stock (${detail.quantity})</a></li>
						</ul>
						<p>${detail.description}</p>
<!--						<div class="product_count">
							<label for="qty">Quantity:</label>
                                                        
							<input type="number" name="num" id="sst" maxlength="12" value="1" title="Quantity:" class="input-text qty">
							<button onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst )) result.value++;return false;"
							 class="increase items-count" type="button"><i class="lnr lnr-chevron-up"></i></button>
							<button onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst ) &amp;&amp; sst > 0 ) result.value--;return false;"
							 class="reduced items-count" type="button"><i class="lnr lnr-chevron-down"></i></button>
						</div>-->
						<div class="card_area d-flex align-items-center">
							<a class="primary-btn" href="buy?id=${id}&num=1">Add to Cart</a>
                                                        
						</div>
                                                        <a class="social-info" ><input type="hidden" name="num" value="1"> </a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--================End Single Product Area =================-->
        <section class="product_description_area">
		<div class="container">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item">
					<a class="nav-link" 
					 aria-selected="true">Feedbacks</a>
				</li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="" id="contact" role="tabpanel" >
					<div class="row">
                                            
						<div class="col-lg-6">
                                                    <c:forEach items="${requestScope.listF}" var="o">
							<div class="comment_list">
								<div class="review_item">
									<div class="media">
                                                                            <div class="d-flex">
                                                                                <img src="img/avt.jpg" alt="" height="70px" width="70px">
										</div>
                                                                            <div class="media-body">
                                                                                <h4><strong>${o.name}</strong></h4><a>${o.date}</a>	
										</div>
									</div>
									<p>${o.comment}</p>
								</div>
							</div>
                                                        </br>
                                                        </c:forEach>
						</div>
                                                
						<div class="col-lg-6">
							<div class="review_box">
								<h4>Post a comment</h4>
								<form class="row contact_form" action="feedback" method="post" id="contactForm" novalidate="novalidate">
									<div class="col-md-12">
										<div class="form-group">
											<input type="text" class="form-control" id="name" name="name" placeholder="Your Full name">
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<textarea class="form-control" name="comment" id="comment" rows="1" placeholder="Comment"></textarea>
										</div>
									</div>
									<div class="col-md-12 text-right">
										<button type="submit" value="submit" class="btn primary-btn">Submit Now</button>
									</div>
                                                                    <div class="form-group">
                                                                        <input type="hidden" class="form-control" id="pid" name="pid" value="${detail.id}" >
										</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
<!--        </br> </br> </br>-->



	<!-- Start related-product Area -->
	<section class="related-product-area section_gap_bottom">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-6 text-center">
					<div class="section-title">
						<h1>You Might Also Like</h1>
						
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="row">
                                            <c:forEach items="${requestScope.listC}" var="o">
						<div class="col-lg-4 col-md-4 col-sm-6 mb-20">
							<div class="single-related-product d-flex ">
                                                            <a href="detail?pid=${o.id}"><img class="photo2" src=${o.image} alt="" height="70px" width="70px"></a>
								<div class="desc">
									<a href="detail?pid=${o.id}" class="title">${o.name}</a>
									<div class="price">
										<h6>$${o.price}</h6>
<!--										<h6 class="l-through">${o.promotion}</h6>-->
									</div>
								</div>
							</div>
						</div>
                                            </c:forEach>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End related-product Area -->

	<!-- start footer Area -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- End footer Area -->

	<script src="js/vendor/jquery-2.2.4.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	 crossorigin="anonymous"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery.sticky.js"></script>
	<script src="js/nouislider.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<!--gmaps Js-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="js/gmaps.min.js"></script>
	<script src="js/main.js"></script>

</body>

</html>