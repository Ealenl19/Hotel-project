const form = document.querySelector('#inquiry-form');

form.addEventListener('submit', (event) => {
    event.preventDefault();

    const name = form.elements['name'].value;
    const email = form.elements['email'].value;
    const checkIn = form.elements['check-in'].value;
    const checkOut = form.elements['check-out'].value;
    const roomType = form.elements['room-type'].value;
    const comments = form.elements['comments'].value;

    const data = {
        name,
        email,
        checkIn,
        checkOut,
        roomType,
        comments
    };

    fetch('https://example.com/inquiry', {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (response.ok) {
            alert('Inquiry submitted successfully!');
            form.reset();
        } else {
            alert('An error occurred. Please try again later.');
        }
    })
    .catch(error => {
        alert('An error occurred. Please try again later.');
        console.error(error);
    });
});
