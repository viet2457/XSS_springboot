window.onload = function() {
    let urlParams = new URLSearchParams(window.location.search);
    let name = urlParams.get('name');

    // Bypass escape bằng cách dùng document.write()
    document.write("Hello, " + name);
};
