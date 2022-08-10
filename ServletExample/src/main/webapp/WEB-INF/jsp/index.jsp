<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>

    <head>
        <title>black_pink_white</title>
        <meta name="description" content="website description" />
        <meta name="keywords" content="website keywords, website keywords" />
        <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css" title="style" />
    </head>

    <body>
        <div id="main">
            <div id="header">
                <div id="logo">
                    <div id="logo_text">
                        <!-- class="logo_colour", allows you to change the colour of the text -->
                        <h1><a href="index.html">black<span class="logo_colour">_pink</span><span class="logo_colour2">_white</span></a></h1>
                        <h2>Simple. Contemporary. Website Template.</h2>
                    </div>
                </div>
                <div id="menubar">
                    <ul id="menu">
                        <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
                        <li class="selected"><a href="index.html">Home</a></li>
                        <li><a href="pages/examples.html">Examples</a></li>
                        <li><a href="pages/page.html">A Page</a></li>
                        <li><a href="pages/another_page.html">Another Page</a></li>
                        <li><a href="${pageContext.request.contextPath}/main?command=AboutUs">Contact Us</a></li>
                    </ul>
                </div>
            </div>
            <div id="site_content">
                <div class="sidebar">
                    <!-- insert your sidebar items here -->
                    <h3>Latest News</h3>
                    <h4>New Website Launched</h4>
                    <h5>August 1st, 2014</h5>
                    <p>2014 sees the redesign of our website. Take a look around and let us know what you think.<br /><a href="#">Read more</a></p>
                    <p></p>
                    <h4>New Website Launched</h4>
                    <h5>August 1st, 2014</h5>
                    <p>2014 sees the redesign of our website. Take a look around and let us know what you think.<br /><a href="#">Read more</a></p>
                    <h3>Useful Links</h3>
                    <ul>
                        <li><a href="#">link 1</a></li>
                        <li><a href="#">link 2</a></li>
                        <li><a href="#">link 3</a></li>
                        <li><a href="#">link 4</a></li>
                    </ul>
                    <h3>Search</h3>
                    <form method="post" action="#" id="search_form">
                        <p>
                            <input class="search" type="text" name="search_field" value="Enter keywords....." />
                            <input name="search" type="image" style="border: 0; margin: 0 0 -9px 5px;" src="${pageContext.request.contextPath}/style/search.png" alt="Search" title="Search" />
                        </p>
                    </form>
                </div>
                <div id="content">
                    <!-- insert the page content here -->
                    <h1>Welcome to the black_pink_white template</h1>
                    <p>This standards compliant, simple, fixed width website template is released as an 'open source' design (under a <a href="http://creativecommons.org/licenses/by/3.0">Creative Commons Attribution 3.0 Licence</a>), which means that you are free to download and use it for anything you want (including modifying and amending it). All I ask is that you leave the 'design from HTML5webtemplates.co.uk' link in the footer of the template, but other than that...</p>
                    <p>This template is written entirely in <strong>HTML5</strong> and <strong>CSS</strong>, and can be validated using the links in the footer.</p>
                    <p>You can view more free HTML5 web templates <a href="http://www.html5webtemplates.co.uk">here</a>.</p>
                    <p>This template is a fully functional 5 page website, with an <a href="examples.html">examples</a> page that gives examples of all the styles available with this design.</p>
                    <h2>Browser Compatibility</h2>
                    <p>This template has been tested in the following browsers:</p>
                    <ul>
                        <li>Internet Explorer 9</li>
                        <li>FireFox 25</li>
                        <li>Google Chrome 31</li>
                    </ul>
                </div>
            </div>
            <div id="footer">
                Copyright &copy;
            </div>
        </div>
    </body>
</html>
