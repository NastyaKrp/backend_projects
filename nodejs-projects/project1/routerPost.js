import Router from 'express';
import postController from './postController.js';

const routerPost = new Router();

routerPost.post('/posts', postController.create);

routerPost.get('/posts', postController.get);

routerPost.get('/posts/:id', postController.getById);

routerPost.put('/posts/:id', postController.put);

routerPost.delete('/posts/:id', postController.delete);

export default routerPost;