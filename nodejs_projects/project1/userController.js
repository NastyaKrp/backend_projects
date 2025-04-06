import User from "./user.js";

class userController{
    async create(req, res){
        try{
            const {name, email, age} = req.body;
            const newUser = new User({ name, email, age});
            await newUser.save();
            res.status(201).json({message: 'Пользователь создан', user: newUser});
        } catch(e){
            console.error(e);
            res.status(500).json({error: 'Ошибка при создании пользователя'});
        }
    }

    async get(req, res){
        try {
            const users = await User.find();
            res.status(200).json(users);
        } catch (e) {
            console.error(e);
            res.status(500).json({ error: 'Ошибка при получении пользователей' });
        }
    }

    async getById(req, res){
        try {
            const user = await User.findById(req.params.id);
            if (!user) {
                return res.status(404).json({ error: 'Пользователь не найден' });
            }
            res.status(200).json(user);
        } catch (e) {
            console.error(e);
            res.status(500).json({ error: 'Ошибка при получении пользователя' });
        }
    }

    async put(req, res){
        try {
            const { name, email, age } = req.body;
    
            const updatedUser = await User.findByIdAndUpdate(
                req.params.id,
                { name, email, age },
                { new: true }
            );
    
            if (!updatedUser) {
                return res.status(404).json({ error: 'Пользователь не найден' });
            }
    
            res.status(200).json({ message: 'Пользователь обновлен', user: updatedUser });
        } catch (e) {
            console.error(e);
            res.status(500).json({ error: 'Ошибка при обновлении пользователя' });
        }
    }

    async delete(req, res){
        try {
            const deletedUser = await User.findByIdAndDelete(req.params.id);
    
            if (!deletedUser) {
                return res.status(404).json({ error: 'Пользователь не найден' });
            }
    
            res.status(200).json({ message: 'Пользователь удален', user: deletedUser });
        } catch (e) {
            console.error(e);
            res.status(500).json({ error: 'Ошибка при удалении пользователя' });
        }
    }
}

export default new userController();