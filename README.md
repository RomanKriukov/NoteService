Взаємодія з REST контроллерами
Усі контроллери мають доступи до сервісів які обслуговують,
сервіси мають crud на об'єкти які обслуговують
приклади взаємодії

1.  реєстрація користувача
    POST
    server:port/userAdd
    body
    {
    "name": "Viktor",
    "login": "viktorlog",
    "password": "67676767"
    }
2.  Отримання списку користувачів
    GET
    server:port/getAllUsers
3.  Отримання юзера по id
    GET
    server:port/getUserById/63f6791029ec3316d19cffb1
4.  Оновлення даних юзера
    PUT
    server:port/updateUser
    body
    {
    "id": "63f663b5621d6c0c806d51f3",
    "name": "Змінюємо дані",
    "login": "Змінюємо дані",
    "password": "Змінюємо дані",
    "dateCreation": "2023-02-22T18:49:25.729+00:00"
    }
5.  Видалення юзера
    DELETE
    server:port/deleteUser/63f6791029ec3316d19cffb1 

6.  Створення нотаток
    POST
    server:port/createNote
    body
    {
    "content": "16 тестова нотатка",
    "authorId": "63f663b5621d6c0c806d51f3" -id зареєстрованого користувача, або пусте значення
    } 
7.  Отримання списку нотаток
    GET
    server:port/getAllNotes 
8.  Отримання нотатки по id
    GET
    server:port/getNoteById/63f6791029ec3316d19cffb1 
9.  Оновлення даних нотатки
    PUT
    server:port/updateNote
    body
    {
    "id": "63f68432c438bb2eca90b773",
    "content": "Змінюємо дані",
    "authorId": "63f663b5621d6c0c806d51f3",
    "dateCreation": "2023-02-22T21:08:02.107+00:00",
    "lastUpdateDate": null,
    "likes": 0
    } 
10. Видалення нотатки
    DELETE
    server:port/deleteNote/63f6791029ec3316d19cffb1

11. Лайки можуть ставити і знімати тільки зареєстровані юзери
    POST
    server:port/likeDislike
    body
    {
    "noteId": "63f667dc026bb75c0ea77c57",
    "authorId": "63f663de621d6c0c806d51f4"
    }