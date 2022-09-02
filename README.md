# Evil Bo
Hello, this is the repository of the best cart bot! :heart_eyes:
The bot is multifunctional and can work in multiple chats at the same time! :yum:
You can add [@zloychatbot](https://t.me/zloychatbot) to your chat or clone the repository to create his!:star_struck

## Evil Bot Features
At the moment, the bot has the following features in it's arsenal.
### Captcha :astonished:
*The bot needs administrator rights in the chat to work!*

The bot has a built-in captcha for new users in the chat and a welcome message.
It also checks if the user is in the CAS list. :cop:

### Speech recognition :speaking_head:
С помощью [VK Cloud Solutions](https://mcs.mail.ru). Бот может распознавать голосовые сообщения.

### Teams :monocle_face:
* */statistic* - статистика сообщений юзера в чате;
* */top10* - топ 10 спамеров в чате;
* */me* - бот будет писать за тебя;
* */ktozloy* - находит злого юзера в чате;
* */f* - отдать честь;
* */resolve* или */r* - решает сложные вопросы;
* */currency* или */cur* - перевод валюты;
* */time* - текущее время;
* */sed* - работа со строкой с помощью sed;
* */switch_gender* - сменить пол юзера;
* */continue* - продолжить текст с помощью [GPT-3](https://ru.wikipedia.org/wiki/GPT-3);
* */cat* - сгенерировать котика;

*Для работы следующих команд нужно быть администратором чата и боту необходимы права администратора:*
* */block_stickerpack* - заблокировать стикерпак в чате;
* */unblock_stickerpack* - разблокировать стикерпак в чате;
### Triggers :sunglasses:
У бота есть обширный список слов тригеров на которые он реагирует и отвечает.
### Webhook :yum:
Также бот умеет в [webhook](https://core.telegram.org/bots/api#setwebhook):
>```properties
>   telegram.bot.webhook.url = ""
>   telegram.bot.webhook.port = 8080
>```
## Launching your bot :nerd_face:
Можно запустить бота напрямую на [Heroku](https://heroku.com/) или самостоятельно!
### Deploy on Heroku :dancer:
Нажимаем на кнопку и переходим к настройкам  
[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)
### Setting up Heroku :mechanic:
<details>
<summary>Подробнее</summary>

#### Устанавливаем Config Vars
Ключ API полученный от [Fixer.io](https://fixer.io/)
>```
>   FIXER_API_KEY
>```
Ключ API полученный от [LocationiQ.com](https://locationiq.com/)
>```
>   LOCATIONIQ_API_KEY
>```
Токен телеграм бота полученный от [BotFather](https://t.me/BotFather)
>```
>   TELEGRAM_BOT_TOKEN
>```
API полученный от [VK Cloud Solutions](https://mcs.mail.ru).
>```
>   VK_API_KEY
>```
Адрес вашего приложения Heroku: «https:// ```app-name``` .herokuapp.com/».
>```
>   TELEGRAM_BOT_WEBHOOK_URL
>```
### Вот и всё ваш бот готов!
</details>

### Самостоятельный запуск :man_technologist:
<details>
<summary>Подробнее</summary>

### Загрузка :chart_with_upwards_trend:
Устанавливаем [JDK](https://www.oracle.com/java/technologies/javase-downloads.html) если ее нет, минимальная версия: 8.  
Клонируем репозиторий с [GitHub](https://github.com/Djaler/evil-bot).

### Запуск бота с помощью docker-compose :godmode:
Бота и БД можно запустить в контейнерах с помощью Docker и docker-compose. Для этого необходимо заполнить файл `bot.env`. (см пример в `sample_bot.env`, описание полей ниже)

После этого стартуем бота с помощью `docker-compose up -d`

### Настройка :suspect:
Для запуска необходимо заполнить следующие поля в *application.properties* или задать переменные окружения:
#### Токен телеграм бота :rage1:
Токен телеграм бота полученный от [BotFather](https://t.me/BotFather)
>application.properties:
>```properties
>   telegram.bot.token =
>```
>Окружение:
>```bash
>   export TELEGRAM_BOT_TOKEN=
>```
#### Ключ сервиса для конвертации валют :goberserk:
Ключ API полученный от [Fixer.io](https://fixer.io/)
>application.properties:
>```properties
>   fixer.api.key =
>```
>Окружение:
>```bash
>   export FIXER_API_KEY=
>```
#### Ключ сервиса для определения времени :finnadie:
Ключ API полученный от [LocationiQ.com](https://locationiq.com/)
>application.properties:
>```properties
>   locationiq.api.key =
>```
>Окружение:
>```bash
>   export LOCATIONIQ_API_KEY=
>```

#### Ключ сервиса для распознавания речи :feelsgood:
Ключ API полученный от [VK Cloud Solutions](https://mcs.mail.ru).

В разделе "Машинное обучение"->"Cloud Voice" и генерируем сервисный токен.
>application.properties:
>```properties
>   vk.api.key =
>```
>Окружение:
>```bash
>   export VK_API_KEY=
>```

#### Настройка базы данных :hurtrealbad:
Данную операцию можно пропустить если производить запуск с помощью docker-compose.
<details>
<summary>Подробнее</summary>

Настройка базы данных, используется СУБД [PostgreSQL](https://www.postgresql.org/)
>application.properties:
>```properties
>   spring.datasource.url =
>   spring.datasource.username =
>   spring.datasource.password =
>```
>Окружение:
>```bash
>   export SPRING_DATASOURCE_URL=
>   export SPRING_DATASOURCE_USERNAME=
>   export SPRING_DATASOURCE_PASSWORD=
>```
>
> Например:
>
> Пример **docker-compose** для создания базы данных
> ```dockerfile
>   version: '3.8'
>   services:
>       evil_bot_db:
>           container_name: evil_bot_db_container
>           image: postgres:13-alpine
>           restart: always
>           environment:
>               POSTGRES_USER: evil_bot
>               POSTGRES_PASSWORD: evil_bot_pass
>               POSTGRES_DB: evil_bot_db
>           ports:
>               - "5432:5432"
>           volumes:
>               - pg_data:/var/lib/postgresql/data/
>   volumes:
>       pg_data:
> ```
>Соответственное заполнение полей для этого примера:
> ```properties
>   spring.datasource.url = jdbc:postgresql://localhost:5432/evil_bot_db
>   spring.datasource.username = evil_bot
>   spring.datasource.password = evil_bot_pass
>```
> или
>```bash
>   export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/evil_bot_db
>   export SPRING_DATASOURCE_USERNAME=evil_bot
>   export SPRING_DATASOURCE_PASSWORD=evil_bot_pass
>```
</details>

### Запуск :rocket:
После всех настроек приступим к запуску!

#### Тестовый запуск :snail:
> для Unix
> ```bash
>   ./gradlew bootRun 
> ```
> для Windows
> ```powershell
>   ./gradlew.bat bootRun
> ```
#### Если все прошло успешно, то можно приступить к сборке! :yum:
> для Unix
> ```bash
>   ./gradlew bootJar
> ```
> для Windows
> ```powershell
>   ./gradlew.bat bootJar
> ```
#### А теперь запускаем в ./build/libs! :man_technologist:
> для Unix
> ```bash
>   cd ./build/libs
>   java -jar evil-bot-1.0-SNAPSHOT.jar
> ```
> для Windows
> ```powershell
>   cd ./build/libs
>   java.exe -jar evil-bot-1.0-SNAPSHOT.jar
> ```
</details>

## Лицензия :speech_balloon:
MIT License
