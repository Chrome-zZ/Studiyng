$(function(){

    var userName = 'Юзер';

    let initChat = function() {
        loadCounter();
    };

    initChat();

    // let loadUsers = function() {
    //     $.get('/api/users', function(response){
    //         let users = response.users;
    //         let usersList = $('.users-list');
    //         for(let i in users) {
    //             let userItem = $('<div class="user-item"></div>');
    //             userItem.text(users[i].name);
    //             usersList.append(userItem);
    //         }
    //     });
    // };

    let loadCounter = function() {
        let click = $('.message-text');
        $.get('/', function(response) {
            let counter = response.clicks;

                // let messageItem = $('<div class="message"><b>' +
                //     counter.counter);
                    // '</b> ' + messages[i].text + '</div>');
                click.append(counter);

        });
    };

    // let authUser = function() {
    //     let name = prompt('Введите имя пользователя:');
    //     userName = name;
    //     $.post('/api/users', {'name': name}, function(response){
    //         if(response.result) {
    //             initChat();
    //         } else {
    //             alert('Что-то пошло не так :(');
    //         }
    //     });
    // };

    // let checkAuthStatus = function() {
    //     $.get('/api/auth', function(response){
    //         if(response.result) {
    //             userName = response.name;
    //             initChat();
    //         } else {
    //             authUser();
    //         }
    //     });
    // };

    // checkAuthStatus();

    $('.send-message').on('click', function(){
        let click = $('.message-text');
        // let messagesList = $('.messages-list');
        $.post('/', {'count': click}, function(response){
                let click1 = $('<div class="button"><b>' +
                    response.count);
                click1.append(click);
                // $('.message-text').val('');

        });
    });
});