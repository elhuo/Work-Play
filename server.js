const express = require('express')
const server = require('http').Server(app)
const io = require('socket.io')(server)
var socket = io.onconnection ('http://localhost')
const {v4: uuidV4} = require('uuid')

app.set('view engine', 'ejs')
app.use(express.static('public'))



app.get('/', (req, res) => {
    res.redirect(`/${uuidV4()}`)
})

app.get('/room', (req, res) => {
    res.render('room', {rooId: req.params.room})

})


io.on('connection', socket => {

    socket.on('join-room', (roomId, userId) => {
        socket.join(roomId)
        socket.to(roomId).broadcast.emit('user-connected', userId)

        socket.on('disconnect', () => {
            socket.to(roomId).broadcast.emit('user-dicsonnected', userId)
        })
    })

})




server.listen(3000)
 
