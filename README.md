# demo

План работы с запросами:

1)  Создание нового запроса:
    - Откройте Postman.
    - Нажмите кнопку New в верхнем левом углу.
    - Выберите HTTP Request.
    - Введите имя запроса, например, Create Task.

2) Настройка POST-запроса:
    - В выпадающем списке выберите метод POST.
    - В поле URL введите адрес вашего API:
      http://localhost:8080/tasks
    - Перейдите на вкладку Body.
    - Выберите опцию raw.
    - В выпадающем списке справа выберите JSON.

3) Добавление JSON-тела запроса:
    - В поле для ввода тела запроса добавьте JSON-объект, описывающий новую задачу. Например:
    -     {
          "title": "Изучить Spring Boot",
          "description": "Освоить основы Spring Boot",
          "completed": false
          }

    - Убедитесь, что заголовок Content-Type установлен на application/json. Postman обычно добавляет его автоматически, но если его нет, перейдите на вкладку Headers и добавьте вручную:
    -       Key: Content-Type  Value: application/json

4) Отправка запроса:
     - Нажмите кнопку Send.
     - В нижней части экрана вы увидите ответ от сервера. Например:
     - {
  "id": 1,
  "title": "Изучить Spring Boot",
  "description": "Освоить основы Spring Boot",
  "completed": false
}
