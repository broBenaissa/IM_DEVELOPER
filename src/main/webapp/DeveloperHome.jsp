<%
if(session.getAttribute("name")==null)
	response.sendRedirect("login.jsp");
%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/style.css">
  <title>ImDevelopper</title>
</head>

<body>
  <!-- Header -->
  <section id="header">
    <div class="header container">
      <div class="nav-bar">
        <div class="brand">
          <a href="#hero">
            <h1><span>I</span>M <span>D</span>EVELOPER</h1>
          </a>
        </div>
        <div class="nav-list">
          <div class="hamburger" >
            <div class="bar"></div>
          </div>
          <ul>
            <li><a href="#hero" data-after="Home">Home</a></li>
            <li><a href="service-list.jsp" data-after="Service">Services</a></li>
            <li><a href="projet-list.jsp" data-after="Projects">Projects</a></li>
            <li><a href="#about" data-after="About">About</a></li>
            <li class="nav-item mx-0 mx-lg-1 bg-danger"><a
			class="nav-link py-3 px-0 px-lg-3 rounded" href="Logout"><%= session.getAttribute("name") %><span></span></a></li>
            
          </ul>
        </div>
      </div>
    </div>
  </section>
  <!-- End Header -->


  <!-- Hero Section  -->
  <section id="hero">
    <div class="hero container">
      <div>
        <h1>Hello, <span></span></h1>
        <h1>My Name is <span></span></h1>
        <h1><%= session.getAttribute("name") %><span></span></h1>
        <a href="#about" type="button" class="cta">About me</a>
      </div>
    </div>
  </section>
  <!-- End Hero Section  -->

  <!-- Service Section -->
  <section id="services">
    <div class="services container">
      <div class="service-top">
        <h1 class="section-title">Serv<span>i</span>ces</h1>
        <h2>From boosting page speed to creating seamless user experiences, your website s infrastructure must
         be ready to perform. We complement your in-house development teams with the expertise and perspective
          to create high-quality, marketing-driven websites and web apps, providing the necessary maintenance
           to help optimize your digital presence!</h2>
      </div>
      <!-- services item -->
      
      <div class="service-bottom">
        <div class="service-item">
          <div class="icon"><img src="https://img.icons8.com/bubbles/100/000000/services.png" /></div>
          <h2>Site Speed Optimization</h2>
          <p> will take a look at a variety of elements such as browser caching, image compression,
           server response time, 3rd party scripts, and CWV scores to implement changes that will lead 
           to better rankings,  engagement, and conversion rates for your organization.</p>
         <a href="#contact" class="cta">aply now</a>
        </div>
        <div class="service-item">
          <div class="icon"><img src="https://img.icons8.com/bubbles/100/000000/services.png" /></div>
          <h2>Web Development</h2>
          <p>Whether you manage content on WordPress, Drupal, or Magento, or code with PHP, JavaScript, 
          or Python, we have you covered; we act as an extension of your team and help you create a fast,
           mobile-friendly site with accessibility in mind.</p>
            <a href="#contact" class="cta">aply now</a>
        </div>
        <div class="service-item">
          <div class="icon"><img src="https://img.icons8.com/bubbles/100/000000/services.png" /></div>
          <h2>Progressive Web Apps</h2>
          <p>We work with your team to establish the necessary app requirements and develop an interface
           that creates a native experience for your users; complete with saved customizations, background updating,
            and offline content and functionality. The result is a reliable web application that delivers a seamless 
            experience to your customers regardless of how they are accessing it.</p>
        	 <a href="#contact" class="cta">aply now</a>
        </div>
        <div class="service-item">
          <div class="icon"><img src="https://img.icons8.com/bubbles/100/000000/services.png" /></div>
          <h2>Development Consultation</h2>
          <p>We use our diverse experience working in a variety of verticals, arming your team with the tools 
          needed to tackle future development challenges. We’ll help you identify and triage issues on your site, 
          and teach you how to resolve them should they arise again.</p>
           <a href="#contact" class="cta">aply now</a>
        </div>
      </div>
    </div>
  </section>
  <!-- End Service Section -->

  <!-- Projects Section -->
  <section id="projects">
    <div class="projects container">
      <div class="projects-header">
        <h1 class="section-title">Recent <span>Projects</span></h1>
      </div>
      <div class="all-projects">
        <div class="project-item">
          <div class="project-info">
            <h1>IM DEVELOPPER</h1>
            <h2>Provide your skills</h2>
            <p>This Application represents the portfolio and the
				services of a developer.
				the portfolio is a tool used to present
				achievements, skills and experience
				professional to an employer or clients
				potentials.
				It presents the design projects of the designer,
				with a brief description of each project, the
				technologies used and images or videos
				of the final product. It can also include
				testimonials from satisfied customers.</p>
          </div>
          <div class="project-img">
            <img src="./img/img-1.png" alt="img">
          </div>
        </div>
        <div class="project-item">
          <div class="project-info">
            <h1>Build a one-page resume</h1>
            <h2>Coding is Love</h2>
            <p>you may need it anyway! Link it to your social media and 
            add your other web development projects as you go.
             Your one-page resume can eventually become a repository for 
             your portfolio.

             As you design your one-page resume, think about how you 
             would extend it if you needed to. What about an introductory
              video? What about a “contact me” page for employers interested 
              in learning more?</p>
          </div>
          <div class="project-img">
            <img src="./img/img-1.png" alt="img">
          </div>
        </div>
        <div class="project-item">
          <div class="project-info">
            <h1>Make an e-commerce landing page</h1>
            <h2>Coding is Love</h2>
            <p>This web project will show you how to create a marketing e-commerce page, which is a page
             that collects some basic data about a potential customer. </p>
          </div>
          <div class="project-img">
            <img src="./img/img-1.png" alt="img">
          </div>
        </div>
        <div class="project-item">
          <div class="project-info">
            <h1>JavaScript quiz game</h1>
            <h2>Coding is Love</h2>
            <p> You can find questions online or just ask questions about something you love,
             such as a movie that’s your favorite, or a television show. 
             This JavaScript quiz can be as complex as you make it.</p>
          </div>
          <div class="project-img">
            <img src="./img/img-1.png" alt="img">
          </div>
        </div>
        <div class="project-item">
          <div class="project-info">
            <h1>media delivery service</h1>
            <h2>Coding is Love</h2>
            <p>Want to build your own YouTube? Netflix? Spotify? That’s a media delivery 
            service, and it’s more complicated than you think. As you build this web development
             project, you’ll need to think about things like quality and compression. 
             You’ll have to figure out how you want to archive and classify content.</p>
          </div>
          <div class="project-img">
            <img src="./img/img-1.png" alt="img">
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- End Projects Section -->

  <!-- About Section -->
  <section id="about">
    <div class="about container">
      <div class="col-left">
        <div class="about-img">
          <img src="./img/img-2.png" alt="img">
        </div>
      </div>
      <div class="col-right">
        <h1 class="section-title">About <span>me</span></h1>
        <h2>Front End Developer</h2>
        <p>Front-End Developer with proven experience at Zillow and HubSpot in helping companies
         create and maintain a better code base for reusability. Passionate about learning and
          development with a desire to apply skills on a larger development team at Redfin.
           Eager to tackle more complex problems and continue to find ways to maximize user efficiency.</p>
        <a href="#projects" class="cta">SKILLS</a>
      </div>
    </div>
  </section>
  <!-- End About Section -->

  <!-- Contact Section -->
  <section id="contact">
    <div class="contact container">
      <div>
        <h1 class="section-title">Contact <span>info</span></h1>
      </div>
      <div class="contact-items">
        <div class="contact-item">
          <div class="icon"><img src="https://img.icons8.com/bubbles/100/000000/phone.png" /></div>
          <div class="contact-info">
            <h1>Phone</h1>
            <h2>+212 64 123 1234</h2>
            <h2>+212 64 123 1234</h2>
          </div>
        </div>
        <div class="contact-item">
          <div class="icon"><img src="https://img.icons8.com/bubbles/100/000000/new-post.png" /></div>
          <div class="contact-info">
            <h1>Email</h1>
            <h2>info@gmail.com</h2>
            <h2>developer@gmail.com</h2>
          </div>
        </div>
        <div class="contact-item">
          <div class="icon"><img src="https://img.icons8.com/bubbles/100/000000/map-marker.png" /></div>
          <div class="contact-info">
            <h1>Address</h1>
            <h2>Lastah TAROUDANT</h2>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- End Contact Section -->

  <!-- Footer -->
  <section id="footer">
    <div class="footer container">
      <div class="brand">
        <h1><span>I</span>M <span>D</span>EVELOPER</h1>
      </div>
      <h2>SOCIAL MEDIA</h2>
      <div class="social-icon">
        <div class="social-item">
          <a href=" "><img src="https://img.icons8.com/bubbles/100/000000/facebook-new.png" /></a>
        </div>
        <div class="social-item">
          <a href=" "><img src="https://img.icons8.com/bubbles/100/000000/instagram-new.png" /></a>
        </div>
        <div class="social-item">
          <a href=" "><img src="https://img.icons8.com/bubbles/100/000000/behance.png" /></a>
        </div>
      </div>
    </div>
  </section>
  <!-- End Footer -->
  
  
  
  
  
  <script src="./app.js"></script>
</body>

</html>