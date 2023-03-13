<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi" class="no-js">

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

    <body id="category">

        <!-- Start Header Area -->
        <jsp:include page="menu.jsp"></jsp:include>
            <!-- End Header Area -->

            <!-- Start Banner Area -->
            <section class="banner-area organic-breadcrumb">
                <div class="container">
                    <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                        <div class="col-first">
                            <h1>Shop Products</h1>
                            <!--					<nav class="d-flex align-items-center">
                                                                            <a href="home">Home<span class="lnr lnr-arrow-right"></span></a>
                                                                            <a href="category">Category</a>
                                                                    </nav>-->
                        </div>
                    </div>
                </div>
            </section>
            <!-- End Banner Area -->
            <script type="text/javascript"> function setCheck(obj) {
                    var fries = document.getElementsByName('cidd');
                    if ((obj.id == 'c0') && (fries[0].checked == true))
                    {
                        for (var i = 1; i < fries.length; i++)
                            fries[i].checked = false;
                    } else {
                        for (var i = 1; i < fries.length; i++) {
                            if (fries[i].checked == true) {
                                fries[0].checked = false;
                                break;
                            }
                        }
                    }
                    document.getElementById('f1').submit();
                }
            function setCheck1(obj){
                var fries = document.getElementsByName('price');
                if ((obj.id=='g0') && (fries[0].checked==true))
                {
                    for (var i = 1; i < fries.length; i++)
                        fries[i].checked = false;
                } else{
                    for (var i = 1; i < fries.length; i++) {
                        if (fries[i].checked==true) {
                            fries[0].checked=false;
                            break;
                        }
                    }
                }
                document.getElementById('f2').submit();
            }    
            </script>

            <div class="container">
                <c:set var="cid" value="${requestScope.cid}"/>

                <div class="row">
                    <div class="col-xl-3 col-lg-4 col-md-5">
                        <div class="sidebar-categories">
                            <div class="head" style="background-color: #5d5f66 " ><a href="category" style="color: #FFFFFF">Category</a></div>
                            <ul class="main-categories">
                            <c:forEach items="${listCa}" var="o" >
                                <li class="main-nav-list" ><a  href="product?id=${o.categoryid}" > ${o.name}</a></li>
                                </c:forEach>
                        </ul>
                    </div>
                    <div class="sidebar-filter mt-50">
                        <div class="head" style="background-color: #5d5f66 " ><a href="category" style="color: #FFFFFF">Filters</a></div>
                        <div class="common-filter">
                            <c:set var="pp" value="${requestScope.color}"/>
                            <c:set var="pb" value="${requestScope.cl}"/>
                            <div class="head">Color</div>
                            <form id="f1" action="filter">
                                <ul>
                                    <li class="filter-list"><input class="pixel-radio" type="checkbox" id="c0" name="cidd" 
                                                                   ${cl[0]?"checked":""} value="${0}" onclick="setCheck(this)"/>All</li>
                                         <c:forEach begin="0" end="${4}"  var="i">
                                        <li class="filter-list"><input class="pixel-radio" type="checkbox" " id="cm" name="cidd" 
                                                                       ${cl[i+1]?"checked":""}
                                                                       value="${(i+1)}" onclick="setCheck(this)"/>${color[i]}</li>
                                        </c:forEach>
                                </ul>
                            </form>
                        </div>
                        <div class="common-filter">
                            <c:set var="pp" value="${requestScope.pp}"/>
                            <c:set var="pb" value="${requestScope.pb}"/>
                            <div class="head">Price</div>
                            <form id="f2" action="filter">
                                <ul>
                                    <li class="filter-list"><input class="pixel-radio" type="checkbox" id="g0" name="price" 
                                                                   ${pb[0]?"checked":""}                            
                                                                   value="0" onclick="setCheck1(this)"/>All</li>
                                        <c:forEach begin="0" end="${4}"  var="i">
                                        <li class="filter-list"><input class="pixel-radio" type="checkbox" " id="g1" name="price" 
                                                                       ${pb[i+1]?"checked":""}
                                                                       value="${(i+1)}" onclick="setCheck1(this)"/>${pp[i]}</li>
                                        </c:forEach>

                                </ul>
                            </form>
                        </div>
                    </div>
                </div>




                <div class="col-xl-9 col-lg-8 col-md-7">
                    <!--				 Start Filter Bar 
                    -->				<div class="filter-bar d-flex flex-wrap align-items-center">
                        <c:set var="page" value="${requestScope.page}"/>
                        <div class="pagination">
                            <c:forEach begin="${1}" end="${requestScope.num}" var="i" >
                                <!--<a href="#" class="prev-arrow"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a>-->
                                <a class="${i==page?"active":""}" href="category?page=${i}" >${i}</a>
                                <!--<a href="#" class="next-arrow"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>-->
                            </c:forEach>
                        </div>
                    </div><!--
                     End Filter Bar -->
                    <!-- Start Best Seller -->
                    <section class="lattest-product-area pb-40 category-list">
                        <div class="row">
                            <c:forEach items="${requestScope.listC}" var="o">
                                <div class="col-lg-4 col-md-6">
                                    <div class="single-product photo">
                                        <a href="detail?pid=${o.id}"><img class="photo" src=${o.image} alt="" ></a>
                                        <div class="product-details">
                                            <a href="detail?pid=${o.id}"><h6>${o.name}</h6></a>
                                            <div class="price">
                                                <h6>$<fmt:formatNumber value="${o.price}"/></h6>        
                                            </div>
                                            <div class="prd-bottom " >
                                                <a href="buy?id=${o.id}&num=1" class="social-info">
                                                    <span class="ti-bag"></span>
                                                </a>
                                                <a class="social-info" ><input type="hidden" name="num" value="1"> 
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                            <c:set var="list" value="${requestScope.products}"/>
                    <c:if test="${list!=null}">
                            <c:forEach items="${list}" var="o">
                                <div class="col-lg-4 col-md-6">
                                    <div class="single-product photo">
                                        <a href="detail?pid=${o.id}"><img class="photo" src=${o.image} alt="" ></a>
                                        <div class="product-details">
                                            <a href="detail?pid=${o.id}"><h6>${o.name}</h6></a>
                                            <div class="price">
                                                <h6>$<fmt:formatNumber value="${o.price}"/></h6>        
                                            </div>
                                            <div class="prd-bottom " >
                                                <a href="buy?id=${o.id}&num=1" class="social-info">
                                                    <span class="ti-bag"></span>
                                                </a>
                                                <a class="social-info" ><input type="hidden" name="num" value="1"> 
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                    </c:if>
                        </div>
                    </section>
                    <!-- End Best Seller -->
                    <!--				 Start Filter Bar -->
                    <div class="filter-bar d-flex flex-wrap align-items-center">
                        <c:set var="page" value="${requestScope.page}"/>
                        <div class="pagination">
                            <c:forEach begin="${1}" end="${requestScope.num}" var="i" >
                                <!--<a href="#" class="prev-arrow"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a>-->
                                <a class="${i==page?"active":""}" href="category?page=${i}" >${i}</a>
                                <!--<a href="#" class="next-arrow"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>-->
                            </c:forEach>
                        </div>
                    </div>
                    <!--				 End Filter Bar -->
                </div>
            </div>
        </div>
        <div> </br> </br> </br> </div>

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