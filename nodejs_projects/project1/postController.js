import Post from "./post.js";
import fileService from "./fileService.js";

class postController{
    async create(req, res){
        try{
            const fileName = fileService.saveFile(req.files.picture);
            const {author, title, content, picture} = req.body;
            const newPost = new Post({ author, title, content, picture: fileName});
            await newPost.save();
            res.status(201).json({message: 'Пост создан', post: newPost});
        } catch(e){
            console.error(e);
            res.status(500).json({error: 'Ошибка при создании поста'});
        }
    }

    async get(req, res){
        try {
            const posts = await Post.find();
            res.status(200).json(posts);
        } catch (e) {
            console.error(e);
            res.status(500).json({ error: 'Ошибка при получении постов' });
        }
    }

    async getById(req, res){
        try {
            const post = await Post.findById(req.params.id);
            if (!post) {
                return res.status(404).json({ error: 'Пост не найден' });
            }
            res.status(200).json(post);
        } catch (e) {
            console.error(e);
            res.status(500).json({ error: 'Ошибка при получении поста' });
        }
    }

    async put(req, res){
        try {
            const {author, title, content, picture} = req.body;
    
            const updatedPost = await Post.findByIdAndUpdate(
                req.params.id,
                {author, title, content, picture},
                { new: true }
            );
    
            if (!updatedPost) {
                return res.status(404).json({ error: 'Пост не найден' });
            }
    
            res.status(200).json({ message: 'Пост обновлен', user: updatedPost });
        } catch (e) {
            console.error(e);
            res.status(500).json({ error: 'Ошибка при обновлении поста' });
        }
    }

    async delete(req, res){
        try {
            const deletedPost = await Post.findByIdAndDelete(req.params.id);
    
            if (!deletedPost) {
                return res.status(404).json({ error: 'Пост не найден' });
            }
    
            res.status(200).json({ message: 'Пост удален', post: deletedPost });
        } catch (e) {
            console.error(e);
            res.status(500).json({ error: 'Ошибка при удалении поста' });
        }
    }
}

export default new postController();