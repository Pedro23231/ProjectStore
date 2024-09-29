// main.js

// Menu de Hambúrguer
const hamburger = document.querySelector('.hamburger');
const navLinks = document.querySelector('.nav-links');

hamburger.addEventListener('click', () => {
    hamburger.classList.toggle('active');
    navLinks.classList.toggle('active');
});

// Fechar o menu quando clicar em um link (opcional)
navLinks.querySelectorAll('a').forEach(link => {
    link.addEventListener('click', () => {
        hamburger.classList.remove('active');
        navLinks.classList.remove('active');
    });
});

// Botão de Voltar ao Topo
const backToTopButton = document.getElementById('back-to-top');

window.addEventListener('scroll', () => {
    if (window.scrollY > 300) {
        backToTopButton.classList.add('show');
    } else {
        backToTopButton.classList.remove('show');
    }
});

backToTopButton.addEventListener('click', () => {
    window.scrollTo({
        top: 0,
        behavior: 'smooth'
    });
});

// Modal Functionality
const modal = document.getElementById('download-modal');
const closeButton = document.querySelector('.close-button');
const downloadButtons = document.querySelectorAll('.download-button');
const modalTitle = modal.querySelector('h2');
const modalDescription = modal.querySelector('p');
const modalDownloadLink = modal.querySelector('.download-button');

downloadButtons.forEach(button => {
    button.addEventListener('click', (e) => {
        e.preventDefault();
        const title = button.getAttribute('data-title');
        const description = button.getAttribute('data-description');
        const file = button.getAttribute('data-file');
        
        modalTitle.textContent = title;
        modalDescription.textContent = description;
        modalDownloadLink.href = file;
        
        modal.style.display = 'block';
    });
});

closeButton.addEventListener('click', () => {
    modal.style.display = 'none';
});

window.addEventListener('click', (event) => {
    if (event.target == modal) {
        modal.style.display = 'none';
    }
});
