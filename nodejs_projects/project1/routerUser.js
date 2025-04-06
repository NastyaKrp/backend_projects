import Router from 'express';
import userController from './userController.js';

const routerUser = new Router();

routerUser.post('/users', userController.create);

routerUser.get('/users', userController.get);

routerUser.get('/users/:id', userController.getById);

routerUser.put('/users/:id', userController.put);

routerUser.delete('/users/:id', userController.delete);

export default routerUser;