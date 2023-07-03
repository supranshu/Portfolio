// Smooth scrolling for anchor links
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
  anchor.addEventListener('click', function (e) {
    e.preventDefault();

    document.querySelector(this.getAttribute('href')).scrollIntoView({
      behavior: 'smooth'
    });
  });
});
	
document.getElementById('skills-link').addEventListener('click', function(event) {
  event.preventDefault(); // Prevent default link behavior
  var skillsSection = document.getElementById('skills'); // Get the skills section
  skillsSection.scrollIntoView({ behavior: 'smooth' }); // Scroll to the skills section smoothly
});

