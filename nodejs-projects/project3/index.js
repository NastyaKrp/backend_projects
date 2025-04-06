const express = require('express');
const cors = require('cors');
const cookieParser = require('cookie-parser');
require('dotenv').config();
const mongoose = require('mongoose');
const router = require('./router/index.js');
const errorMiddleware = require('./middlewares/error-middleware.js');

const PORT = process.env.PORT || 5000;
const DB_URL = process.env.DB_URL;

const app = express();
app.use(express.json());
app.use(cookieParser());
app.use(cors());
app.use('/api', router);
app.use(errorMiddleware);

app.get('/', (req, res) => {
    console.log(req.body);
    res.status(200).json('Сервер работает');
})

const start = async () => {
    try{
        await mongoose.connect(DB_URL);
        app.listen(PORT, () => console.log(`Server started on PORT = ${PORT}`));
    }catch(e){
        console.log(e);
    }
}

start();
