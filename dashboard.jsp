<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
      <link rel="shortcut icon" href="img/zero.jpg">
    <meta name="description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <!-- Twitter meta-->
    <meta property="twitter:card" content="summary_large_image">
    <meta property="twitter:site" content="@pratikborsadiya">
    <meta property="twitter:creator" content="@pratikborsadiya">
    <!-- Open Graph Meta-->
    <meta property="og:type" content="website">
    <meta property="og:site_name" content="Vali Admin">
    <meta property="og:title" content="Vali - Free Bootstrap 4 admin theme">
    <meta property="og:url" content="http://pratikborsadiya.in/blog/vali-admin">
    <meta property="og:image" content="http://pratikborsadiya.in/blog/vali-admin/hero-social.png">
    <meta property="og:description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <title>Zero Sneaker</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="csss/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
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
  <style>
      .center-me {
  margin: 0 auto;}
  
  </style>
  
  <body class="app sidebar-mini" style="background-color: #f5f5f5">
    <!-- Navbar-->
    	<!-- Start Header Area -->
	<header class="header_area sticky-header">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light main_box">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
                                        <a class="navbar-brand logo_h"style="color: orange;font-family:Poppins;font-size: 22px " href="home"><img src="img/zero.jpg" alt="" width="80" height="80">ZERO SNEAKER</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
					 aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
						<ul class="nav navbar-nav menu_nav ml-auto">
							<li class="nav-item"><a class="nav-link" href="home">Home</a></li>
							<li class="nav-item submenu dropdown">
								<a href="category" class="nav-link dropdown-toggle" role="button" aria-haspopup="true"
								 aria-expanded="false">Shoes</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="product?id=1">Nike</a></li>
									<li class="nav-item"><a class="nav-link" href="product?id=2">Jordan</a></li>
									<li class="nav-item"><a class="nav-link" href="product?id=3">Adidas</a></li>
									<li class="nav-item"><a class="nav-link" href="product?id=4">Vans</a></li>
									<li class="nav-item"><a class="nav-link" href="product?id=5">Puma</a></li>
								</ul>
							</li>
                                                        <li class="nav-item submenu dropdown">
								<a href="category" class="nav-link dropdown-toggle" role="button" aria-haspopup="true"
                                                                   aria-expanded="false" >Accessory</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="product?id=6">Socks</a></li>
									<li class="nav-item"><a class="nav-link" href="product?id=7">Bags</a></li>
                                                                        <li class="nav-item"><a class="nav-link" href="product?id=8">Glasses</a></li>
								</ul>
							</li>
                                                        <c:if test="${sessionScope.acc == null}">
							<li class="nav-item">
								<a href="login.jsp" class="nav-link dropdown-toggle" role="button" aria-haspopup="true"
								 aria-expanded="false">Login</a>
							</li></c:if>
                                                        <c:if test="${sessionScope.acc != null}">
                                                            <li class="nav-item submenu dropdown">
								<a href="#" class="nav-link dropdown-toggle" role="button" aria-haspopup="true"
                                                                   aria-expanded="false" >Hello ${sessionScope.acc.name} </a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="logout">Log out</a></li>
								</ul>
							</li>
                                                        </c:if>
                                                        <c:if test="${sessionScope.acc.isAdmin == 1}">
                                                            <li class="nav-item"><a class="nav-link" href="dashboard">Dashboard</a></li>
                                                        </c:if>
							<li class="nav-item"><a class="nav-link" href="contact.jsp">Contact</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li class="nav-item"><a href="show" class="cart"><span class="ti-bag"></span> <span class="count">${requestScope.size}</span></a></li>
							<li class="nav-item">
								<button class="search"><span class="lnr lnr-magnifier" id="search"></span></button>
							</li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<!-- End Header Area -->
    <section class="banner-area organic-breadcrumb">
                <div class="container">
                    <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                        <div class="col-first">
                            <h1>DASHBOARD</h1>
                            <!--					<nav class="d-flex align-items-center">
                                                                            <a href="home">Home<span class="lnr lnr-arrow-right"></span></a>
                                                                            <a href="category">Category</a>
                                                                    </nav>-->
                        </div>
                    </div>
                </div>
            </section>
    <!-- Sidebar menu-->
    <div class="app-sidebar__overlay " style="background-color: orange" data-toggle="sidebar"></div>
    <aside class="app-sidebar" style="padding-top:130px; width: 159px; background-color: #222222">
      </div>
      <ul  class="app-menu"  >
        <li><a class="app-menu__item active" href="home"><i class="app-menu__icon fa fa-home"></i><span class="app-menu__label">Home</span></a></li>
        <li><a class="app-menu__item active" href="dashboard"><i class="app-menu__icon fa fa-dashboard"></i><span class="app-menu__label">Dashboard</span></a></li>
        <li><a class="app-menu__item active" href="muser"><i class="app-menu__icon fa fa-users"></i><span class="app-menu__label">Users</span></a></li>
        <li><a class="app-menu__item active" href="invoice"><i class="app-menu__icon fa fa-files-o "></i><span class="app-menu__label">Invoices</span></a></li>
        <li><a class="app-menu__item active" href="manager"><i class="app-menu__icon fa  fa-archive "></i><span class="app-menu__label">Products</span></a></li>
      </ul>
    </aside>
    <main class="app-content" style="margin-top: 0px; min-height:0px;background-color: #f5f5f5">
      <div class="row">
        <div class="col-md-6 col-lg-3" >
            <div class="widget-small primary coloured-icon"><a href="muser"><i class="icon fa fa-users fa-3x"></i></a>
            <div class="info">
              <h4>Users</h4>
              <p><b>${requestScope.user.getTotal()}</b></p>
            </div>
          </div>
        </div>
        <div class="col-md-6 col-lg-3">
          <div class="widget-small info coloured-icon"><i class="icon fa fa-money" aria-hidden="true"></i>
            <div class="info">
              <h4>Total Revenue</h4>
              <p><b>$${requestScope.total.getTotal()}</b></p>
            </div>
          </div>
        </div>
        <div class="col-md-6 col-lg-3">
          <div class="widget-small warning coloured-icon"><a href="invoice"><i class="icon fa fa-files-o fa-3x"></i></a>
            <div class="info">
              <h4>Total Invoices</h4>
              <p><b>${requestScope.order.getTotal()}</b></p>
            </div>
          </div>
        </div>
        <div class="col-md-6 col-lg-3">
          <div class="widget-small danger coloured-icon"><a href="manager"><i class="icon fa  fa-archive fa-3x"></i></a>
            <div class="info">
              <h4>Products</h4>
              <p><b>${requestScope.pro.getTotal()}</b></p>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
<!--        <div class="col-md-6  ">
          <div class="tile">
              <h3 class="tile-title" style="text-align: center">Sales By Day</h3>
            <div class="embed-responsive embed-responsive-16by9">
              <canvas class="embed-responsive-item" id="lineChartDemo"></canvas>
            </div>
          </div>
        </div>-->
        <div class="col-md-11 center-me">
          <div class="tile">
            <h3 class="tile-title">Daily Invoices & Revenue</h3>
            <div class="embed-responsive embed-responsive-16by9">
              <canvas class="embed-responsive-item" id="myChart"></canvas>
            </div>
          </div>
        </div>
      </div>
    </main>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@4.2.1/dist/chart.umd.min.js"></script>
    <script type="text/javascript">
  const ctx = document.getElementById('myChart');
const labels = ${requestScope.listDate};
new Chart(ctx, {
    type: 'line',
    data: {
      labels: labels,
  datasets: [
    {
      label: 'Daily Revenue',
      data: ${requestScope.listTotal},
      borderColor: 'rgb(255, 99, 132)',
      backgroundColor: 'rgb(201, 203, 207)',
      yAxisID: 'y'
    },
    {
      label: 'Daily Invoices',
      data: ${requestScope.listTotalOr},
      borderColor: 'rgb(54, 162, 235)',
      backgroundColor: 'rgb(201, 203, 207)',
      yAxisID: 'y1'
    }
  ]
    },
    options: {
      scales: {
      y: {
        type: 'linear',
        display: true,
        position: 'left'
      },
      y1: {
        type: 'linear',
        display: true,
        position: 'right',
        beginAtZero: true,

        // grid line settings
        grid: {
          drawOnChartArea: false // only want the grid lines for one axis to show up
        }
      }
    }
    }
  });


</script>
    <!-- Google analytics script-->
    <script type="text/javascript">
      if(document.location.hostname == 'pratikborsadiya.in') {
      	(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      	(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      	m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      	})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
      	ga('create', 'UA-72504830-1', 'auto');
      	ga('send', 'pageview');
      }
    </script>
    <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>