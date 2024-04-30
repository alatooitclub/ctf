
// Shows the loader
function showLoader() {
    document.querySelector('.container').style.display = 'block';
}

// Hides the loader
function hideLoader() {
    document.querySelector('.container').style.display = 'none';
}

// Event to show loader on link click
document.querySelectorAll('a').forEach(link => {
    link.addEventListener('click', function() {
        showLoader();
    });
});

// Hide the loader once the page has loaded
window.addEventListener('load', hideLoader);
