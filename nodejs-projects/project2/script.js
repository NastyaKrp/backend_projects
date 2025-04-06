const mongoose = require('mongoose');
const express = require('express');
const authRouter = require('./authRouter.js');

const PORT = process.env.PORT || 8080;
const DB_URL = 'mongodb://nastya:nastya@127.0.0.1:27017/admin';

const app = express();
app.use(express.json());
app.use("/auth", authRouter);

async function startApp() {
    try{
        await mongoose.connect(DB_URL);
        app.listen(PORT, () => console.log('SERVER STARTED ON PORT ' + PORT));
    }catch(e){
        console.log(e);
    }
}

startApp();

//нужно создать две роли после запуска
//docker exec -it mongo mongosh --username nastya --password nastya --authenticationDatabase admin
//use admin
//db.roles.insertMany([{value: "USER"}, {value: "ADMIN"}])
