# Products API Test Cases

Base URL: https://fakestoreapi.com/products

---

## TC-001 Получить список всех продуктов (вызов метода Get)

**Приоритет** Hight 
 
### Предусловия
API доступен
В системе есть хотя бы один зарегистрированный продукт.

### Тестовые данные

### Шаги
1. Отправить GET-запрос https://fakestoreapi.com/products

### Ожидаемый результат
- Status code: 200
- Response body вернулся в формате JSON
- Response body содержит массив товаров
- Каждый товар содержит поля:
  - id
  - title
  - price
  - description
  - category
  - image
- Время выполнения запроса не больше 1000мсек

---
  
## TC-002 Получить список с ограниченным количеством продуктов (limit=4)

**Приоритет** Medium

### Предусловия
API доступен
В системе есть хотя бы один зарегистрированный продукт.

### Тестовые данные

### Шаги
1. Добавить во вкладке "Params" параметр: "key" : limit  "value" : "4"
2. Отправить GET-запрос https://fakestoreapi.com/products?limit=3

### Ожидаемый результат
- Status code: 200
- Response body содержит массив из 4 товаров
- Каждый товар содержит поля:
  - id
  - title
  - price
  - description
  - category
  - image
- Время выполнения запроса не больше 1000мсек

---

## TC-003 Получить список продуктов, используя URL с ошибкой

**Приоритет** Low

### Предусловия
API доступен

### Тестовые данные

### Шаги
1. Изменить Base URL, дописав в конце лишние символы, например sssssss
2. Отправить GET-запрос https://fakestoreapi.com/productssssssss

### Ожидаемый результат
- Status code: 404 Not found
- Response body содержит сообщение об ошибке
- Сервер не возвращает список продуктов
- Время выполнения запроса не больше 1000мсек

---

## TC-004 Получить список продуктов, используя некорректный параметр limit

**Приоритет** Low

### Предусловия
API доступен
В системе есть хотя бы один зарегистрированный продукт.

### Тестовые данные

### Шаги
1. Добавить во вкладке "Params" параметр: "key" : limit  "value" : "abc"
2. Отправить GET-запрос https://fakestoreapi.com/products?limit=abc

### Ожидаемый результат
- Status code: 200
- API игнорирует некорректный параметр limit
- Response body содержит массив товаров
- Каждый товар содержит поля:
  - id
  - title
  - price
  - description
  - category
  - image
- Время выполнения запроса не больше 1000мсек

---

## TC-005 Добавить новый продукт (вызов метода POST)

**Приоритет** Hight

### Предусловия
API доступен

### Тестовые данные
title = "FelixFelicius"
price = 0.666
description = "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"
category = "Potion"
image = "http://example.com"

### Шаги
1. Во вкладке Body/raw ввести:
{
"title": "FelixFelicius",
"price": 0.666,
"description": "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed",
"category": "Potion",
"image": "http://example.com"
}
2. Отправить POST запрос https://fakestoreapi.com/products

### Ожидаемый результат
- Status code: 201
- Response body вернулся в формате JSON
- Response body содержит созданный товар с:
  - title = "FelixFelicius"
  - description = "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"
  - category = "Potion"
  - image = "http://example.com"
  - Время выполнения запроса не больше 1000мсек

---

## TC-006 Добавить новый продукт с вручную вписанным Id

**Приоритет** Hight

### Предусловия
API доступен

### Тестовые данные
id = 77
title = "FelixFelicius"
price = 0.666
description = "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"
category = "Potion"
image = "http://example.com"

### Шаги
1. Во вкладке Body/raw ввести:
{
"id": 77,
"title": "FelixFelicius",
"price": 0.666,
"description": "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed",
"category": "Potion",
"image": "http://example.com"
}
2. Отправить POST запрос https://fakestoreapi.com/products

### Ожидаемый результат
- Status code: 201
- Response body вернулся в формате JSON
- Response body содержит созданный товар с:
  - id, созданным на сервере (id не равен 77)
  - title = "FelixFelicius"
  - description = "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"
  - category = "Potion"
  - image = "http://example.com"
  - Время выполнения запроса не больше 1000мсек

---

## TC-007 Добавить новый продукт, body=none 

**Приоритет** Hight

### Предусловия
API доступен

### Тестовые данные

### Шаги
1. Во вкладке Body выбрать none
2. Отправить POST запрос https://fakestoreapi.com/products

### Ожидаемый результат
- Status code: 400
- Response body содержит сообщение об ошибке
- Время выполнения запроса не больше 1000мсек

---

## TC-008 Добавить новый продукт с пустым body 

**Приоритет** Hight

### Предусловия
API доступен

### Тестовые данные

### Шаги
1. Во вкладке Body выбрать raw
2. Ввести в поле: {}
3. Отправить POST запрос https://fakestoreapi.com/products

### Ожидаемый результат
- Status code: 400
- Response body содержит сообщение об ошибке
- Сервер не возвращает список продуктов
- Время выполнения запроса не больше 1000мсек

---

## TC-009 Добавить новый продукт с пустым полем "title" 

**Приоритет** Hight

### Предусловия
API доступен

### Тестовые данные
title = ""
price = 0.666
description = "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"
category = "Potion"
image = "http://example.com"

### Шаги
1. Во вкладке Body\raw ввести:
{
"title": "",
"price": 0.666,
"description": "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed",
"category": "Potion",
"image": "http://example.com"
}
2. Отправить POST запрос https://fakestoreapi.com/products

### Ожидаемый результат
- Status code: 400
- Response body содержит сообщение об ошибке
- Сервер не возвращает список продуктов
- Время выполнения запроса не больше 1000мсек

---

## TC-010 Добавить новый продукт с числом в поле "title" 

**Приоритет** Hight

### Предусловия
API доступен

### Тестовые данные
title = 1234
price = 0.666
description = "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"
category = "Potion"
image = "http://example.com"

### Шаги
1. Во вкладке Body\raw ввести:
{
"title": 1234,
"price": 0.666,
"description": "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed",
"category": "Potion",
"image": "http://example.com"
}
2. Отправить POST запрос https://fakestoreapi.com/products

### Ожидаемый результат
- Status code: 400
- Response body содержит сообщение об ошибке
- Сервер не возвращает список продуктов
- Время выполнения запроса не больше 1000мсек

---

## TC-011 Добавить новый продукт с пустым полем "price" 

**Приоритет** Hight

### Предусловия
API доступен

### Тестовые данные
title = "FelixFelicius"
price = 
description = "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"
category = "Potion"
image = "http://example.com"

### Шаги
1. Во вкладке Body\raw ввести:
{
"title": FelixFelicius,
"price": ,
"description": "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed",
"category": "Potion",
"image": "http://example.com"
}
2. Отправить POST запрос https://fakestoreapi.com/products

### Ожидаемый результат
- Status code: 400
- Response body содержит сообщение об ошибке
- Сервер не возвращает список продуктов
- Время выполнения запроса не больше 1000мсек

---

## TC-012 Добавить новый продукт с отрицательным значением "price" 

**Приоритет** Hight

### Предусловия
API доступен

### Тестовые данные
title = "FelixFelicius"
price = -555
description = "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"
category = "Potion"
image = "http://example.com"

### Шаги
1. Во вкладке Body\raw ввести:
{
"title": FelixFelicius,
"price": -555,
"description": "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed",
"category": "Potion",
"image": "http://example.com"
}
2. Отправить POST запрос https://fakestoreapi.com/products

### Ожидаемый результат
- Status code: 400
- Response body содержит сообщение об ошибке
- Сервер не возвращает список продуктов
- Время выполнения запроса не больше 1000мсек

---

## TC-013 Добавить новый продукт с буквенным значением "price" 

**Приоритет** Hight

### Предусловия
API доступен

### Тестовые данные
title = "FelixFelicius"
price = "fifty five"
description = "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"
category = "Potion"
image = "http://example.com"

### Шаги
1. Во вкладке Body\raw ввести:
{
"title": FelixFelicius,
"price": "fifty five",
"description": "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed",
"category": "Potion",
"image": "http://example.com"
}
2. Отправить POST запрос https://fakestoreapi.com/products

### Ожидаемый результат
- Status code: 400
- Response body содержит сообщение об ошибке
- Сервер не возвращает список продуктов
- Время выполнения запроса не больше 1000мсек

---

## TC-014 Добавить новый продукт с пустым полем "category" 

**Приоритет** Hight

### Предусловия
API доступен

### Тестовые данные
title = "FelixFelicius"
price = 0.666,
description = "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"
category = ""
image = "http://example.com"

### Шаги
1. Во вкладке Body\raw ввести:
{
"title": FelixFelicius,
"price": 0.666,
"description": "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed",
"category": "",
"image": "http://example.com"
}
2. Отправить POST запрос https://fakestoreapi.com/products

### Ожидаемый результат
- Status code: 400
- Response body содержит сообщение об ошибке
- Сервер не возвращает список продуктов
- Время выполнения запроса не больше 1000мсек

---

## TC-015 Добавить новый продукт с цифрами в поле "category" 

**Приоритет** Hight

### Предусловия
API доступен

### Тестовые данные
title = "FelixFelicius"
price = 0.666,
description = "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"
category = 12345
image = "http://example.com"

### Шаги
1. Во вкладке Body\raw ввести:
{
"title": FelixFelicius,
"price": 0.666,
"description": "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed",
"category": 12345,
"image": "http://example.com"
}
2. Отправить POST запрос https://fakestoreapi.com/products

### Ожидаемый результат
- Status code: 400
- Response body содержит сообщение об ошибке
- Сервер не возвращает список продуктов
- Время выполнения запроса не больше 1000мсек

---

## TC-016 Добавить новый продукт с новым полем "random_field"

**Приоритет** Hight

### Предусловия
API доступен

### Тестовые данные
title = "FelixFelicius"
price = 0.666,
description = "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"
category = "Potion"
image = "http://example.com"
random_field = "blablabla"

### Шаги
1. Во вкладке Body\raw ввести:
{
"title": FelixFelicius,
"price": 0.666,
"description": "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed",
"category": 12345,
"image": "http://example.com",
"random_field" = blablabla
}
2. Отправить POST запрос https://fakestoreapi.com/products

### Ожидаемый результат
- Status code: 201
- Response body вернулся в формате JSON
- Response body содержит созданный товар с:
  - id
  - title = "FelixFelicius"
  - description = "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"
  - category = "Potion"
  - image = "http://example.com"
- Response body не содержит поле "random_field"
- Время выполнения запроса не больше 1000мсек

---
