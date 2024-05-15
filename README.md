<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Безопасность Spring Boot 3.0 с реализацией JWT</title>
    <style>
        /* Стили CSS */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        h1, h2 {
            color: #333;
        }
        ul {
            list-style-type: disc;
            margin-left: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Безопасность Spring Boot 3.0 с реализацией JWT</h1>
        <p>Этот проект демонстрирует реализацию безопасности с помощью Spring Boot 3.0 и JSON Web Tokens (JWT). Он включает в себя следующие функции:</p>
        
        <h2>Функции</h2>
        <ul>
            <li>Регистрация и вход пользователей с аутентификацией JWT</li>
            <li>Шифрование паролей с помощью BCrypt</li>
            <li>Авторизация на основе ролей с помощью Spring Security</li>
            <li>Настраиваемая обработка отказа в доступе</li>
            <li>Механизм выхода из системы</li>
            <li>Маркер обновления</li>
        </ul>

        <h2>Технологии</h2>
        <ul>
            <li>Spring Boot 3.0</li>
            <li>Spring Security</li>
            <li>JSON Web Tokens (JWT)</li>
            <li>BCrypt</li>
            <li>Maven</li>
        </ul>

        <h2>Начало работы</h2>
        <p>Чтобы начать работу с этим проектом, на локальном компьютере должно быть установлено следующее:</p>
        <ul>
            <li>JDK 17+</li>
            <li>Maven 3+</li>
        </ul>
        <p>Чтобы выполнить сборку и запуск проекта, выполните следующие действия:</p>
        <ol>
            <li>Клонируйте репозиторий: <code>git clone https://github.com/ali-bouali/spring-boot-3-jwt-security.git</code></li>
            <li>Перейдите в каталог проекта: <code>cd spring-boot-security-jwt</code></li>
            <li>Добавление базы данных "jwt_security" в postgres</li>
            <li>Соберите проект: <code>mvn clean install</code></li>
            <li>Запускаем проект: <code>mvn spring-boot:run</code></li>
        </ol>
        <p>Приложение будет доступно по адресу <a href="http://localhost:8080">http://localhost:8080</a>.</p>
    </div>
</body>
</html>
