window.addEventListener('DOMContentLoaded', (event) => {
    document.getElementById('view-btn').addEventListener('click', loadBooks);
    document.getElementById('add').addEventListener('click', addBook);
    document.getElementById('delete').addEventListener('click', deleteBookByIsbn);
    document.getElementById('search-btn').addEventListener('click', searchBookByIsbn);
});

function loadBooks() {
    fetch('http://localhost:8080/books')
        .then(response => response.json())
        .then(books => displayBooks(books))
        .catch(error => console.error('Error:', error));
}

function addBook(event) {
    event.preventDefault();

    const title = document.getElementById('title').value;
    const author = document.getElementById('author').value;
    const isbn = document.getElementById('isbn').value;
    const publicationDate = document.getElementById('publicationDate').value;

    const book = {
        title,
        author,
        isbn,
        publicationDate
    };

    fetch('http://localhost:8080/books', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(book)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            loadBooks(); // Reload the list of books
        })
        .catch(error => console.error('Error:', error));
}

function deleteBookByIsbn(event) {
    event.preventDefault();

    const isbn = document.getElementById('isbn-delete').value;

    fetch(`http://localhost:8080/books/isbn/${isbn}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (response.ok) {
                console.log('Book deleted successfully');
                loadBooks(); // Reload the list of books
            } else {
                console.error('Error:', response.statusText);
            }
        })
        .catch(error => console.error('Error:', error));
}

function searchBookByIsbn(event) {
    event.preventDefault();

    const isbn = document.getElementById('isbn-search-bar').value;

    fetch(`http://localhost:8080/books/isbn/${isbn}`)
        .then(response => response.json())
        .then(book => {
            console.log(book); // Log the book data
            displayBooks([book]); // Ensure it is in an array
        })
        .catch(error => {
            console.error('Error:', error);
            displayBooks([]); // Clear the books display on error
        });
}

function displayBooks(books) {
    const booksDiv = document.getElementById('books');
    booksDiv.innerHTML = '';
    books.forEach(book => {
        const bookDiv = document.createElement('div');
        bookDiv.className = 'box';
        bookDiv.innerHTML = `
            <h3 class="title is-5">${book.title}</h3>
            <p class="subtitle is-6">Author: ${book.author}</p>
            <p>ISBN: ${book.isbn}</p>
            <p>Publication Date: ${book.publicationDate}</p>
        `;
        booksDiv.appendChild(bookDiv);
    });
}
