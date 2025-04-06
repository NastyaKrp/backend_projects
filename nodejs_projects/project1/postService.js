import Post from "./post.js";

class postService{
    async create(post){
        const createdPost = await Post.create(post);
        return;
    }
}

export default postService();