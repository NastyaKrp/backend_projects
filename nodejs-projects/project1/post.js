import mongoose from 'mongoose';

const postSchema = new mongoose.Schema({
    author: {
        type: String,
        required: true
    },
    title: {
        type: String,
        required: true
    },
    content: {
        type: String,
        required: true
    },
    picture: {
        type: String
    }
});

const Post = mongoose.model('Post', postSchema);

export default Post;