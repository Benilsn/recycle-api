const express = require('express');
const app = express();

app.set('view engine', 'ejs');
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(express.static(__dirname));

app.listen(4567);

app.get('/', function (req, res) {
    return res.render('index', { title: 'Home' });
});

app.get('/login', function (req, res) {
    return res.render('login', { title: 'Login' });
});

app.get('/register', function (req, res) {
    return res.render('register', { title: 'Register' });
});


app.post('/register', function (req, res) {

    var data = {
        client_id: req.client_id,
        first_name: req.first_name,
        last_name: req.last_name,
        age: req.age,
        email: req.email,
        user_name: req.user_name,
        user_password: req.user_password
    }
    console.log(data);
    res.send(data);
})

app.get('/database', function (req, res) {
    return res.render('database', { title: 'Database' })
});