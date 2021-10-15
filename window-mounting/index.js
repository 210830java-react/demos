function goTo() {
    console.log('Do something with internal JS variables');
}

function mountToWindow(functions = {}) {

    window.userInteractions = {
        ...functions,
    }

    // delete window.userInteractions.goTo;
}

mountToWindow({
    goTo,
    // Ay other functions you want
});