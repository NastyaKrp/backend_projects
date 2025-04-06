import express from 'express'
import mongoose from 'mongoose'
import routerPost from './routerPost.js';
import routerUser from './routerUser.js';
import fileUpload from 'express-fileupload';

const PORT = 5000;
const DB_URL = 'mongodb://admin:admin@127.0.0.1:27017/admin'

const app = express();

app.use(express.json());
app.use(fileUpload({}));
app.use(express.static('static'));
app.use('/api', routerPost);
app.use('/api', routerUser);

app.post('/', (req, res) => {
    console.log(req.body);
    res.status(200).json('Сервер работает');
})

app.get('/', (req, res) => {
    console.log(req.body);
    res.status(200).json('Сервер работает');
})

async function startApp(){
    try{
        await mongoose.connect(DB_URL);
        app.listen(PORT, () => console.log('SERVER STARTED ON PORT ' + PORT));
    } catch(e){
        console.log(e);
    }
}

startApp();