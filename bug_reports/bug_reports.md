## BR-001 (TC-007) POST /products: продукт создаётся при отправке запроса без Body

### Severity Major

### Предусловия: 
API доступен

### Шаги воспроизведения:
1. Открыть запрос POST https://fakestoreapi.com/products.
2. Во вкладке Body выбрать значение "none".
3. Отправить запрос.

### Фактический результат
- Сервер успешно обрабатывает запрос без тела.
- Status code: 201 Created
- В response body возвращается объект с id нового продукта.
- Продукт считается созданным, несмотря на отсутствие обязательных данных.

### Ожидаемый результат
- Сервер должен отклонить запрос без тела, так как отсутствуют данные для создания продукта.
- Status code: 400
- Response body содержит сообщение об ошибке
- Новый продукт не создается

### Окружение
API: Fake Store API
Метод: POST
Endpoint: https://fakestoreapi.com/products

---

## BR-002 (TC-008) POST /products: продукт создаётся при отправке запроса c незаполненным Body

### Severity Major

### Предусловия: 
API доступен

### Шаги воспроизведения:
1. Открыть запрос POST https://fakestoreapi.com/products.
2. Во вкладке Body во вкладке "raw" оставить пустое Body {}.
3. Отправить запрос.

### Фактический результат
- Сервер успешно обрабатывает запрос с пустым телом.
- Status code: 201 Created
- В response body возвращается объект с id нового продукта.
- Продукт считается созданным, несмотря на отсутствие обязательных данных.

### Ожидаемый результат
- Сервер должен отклонить запрос с пустым телом, так как отсутствуют данные для создания продукта.
- Status code: 400
- Response body содержит сообщение об ошибке
- Новый продукт не создается

### Окружение
API: Fake Store API
Метод: POST
Endpoint: https://fakestoreapi.com/products

---

## BR-003 (TC-009) POST /products: продукт создаётся при отправке запроса c незаполненным Title в Body

### Severity Major

### Предусловия: 
API доступен

### Шаги воспроизведения:
1. Открыть запрос POST https://fakestoreapi.com/products.
2. Во вкладке Body во вкладке "raw" выбрать формат JSON
3. Добавить тело запроса:
title = ""
price = 0.666
description = "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"
category = "Potion"
image = "http://example.com"
4. Отправить запрос.

### Фактический результат
- Сервер успешно обрабатывает запрос с пустым title в теле, несмотря на то, что это обязательное поле.
- Status code: 201 Created
- В response body возвращается объект с id нового продукта и пустым title.
- Продукт считается созданным, несмотря на отсутствие обязательных данных.

### Ожидаемый результат
- Сервер должен отклонить запрос с пустым title, так как это обязательное поле.
- Status code: 400
- Response body содержит сообщение об ошибке
- Новый продукт не создается

### Окружение
API: Fake Store API
Метод: POST
Endpoint: https://fakestoreapi.com/products

---

## BR-004 (TC-010) POST /products: продукт создаётся при отправке запроса c цифрами в Title в Body

### Severity Major

### Предусловия: 
API доступен

### Шаги воспроизведения:
1. Открыть запрос POST https://fakestoreapi.com/products.
2. Во вкладке Body во вкладке "raw" выбрать формат JSON
3. Добавить тело запроса:
title = 1234
price = 0.666
description = "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"
category = "Potion"
image = "http://example.com"
4. Отправить запрос.

### Фактический результат
- Сервер успешно обрабатывает запрос, несмотря на то что поле title содержит только цифры.
- Status code: 201 Created
- В response body возвращается объект с id нового продукта.
- В response body поле title содержит значение "1234".
- Продукт считается созданным с невалидным значением в поле title.

### Ожидаемый результат
- Сервер должен отклонить запрос, если поле title содержит только цифры и не содержит буквенных символов.
- Status code: 400
- Response body содержит сообщение об ошибке
- Новый продукт не создается
- Поле title должно проходить валидацию формата. Значение, состоящее только из цифр, не должно считаться корректным названием продукта.

### Окружение
API: Fake Store API
Метод: POST
Endpoint: https://fakestoreapi.com/products

---

## BR-005 (TC-012) POST /products: продукт создаётся при отправке запроса c отрицательным значением поля "price" в Body

### Severity Major

### Предусловия: 
API доступен

### Шаги воспроизведения:
1. Открыть запрос POST https://fakestoreapi.com/products.
2. Во вкладке Body во вкладке "raw" выбрать формат JSON
3. Добавить тело запроса:
title = "FelixFelicius"
price = -555
description = "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"
category = "Potion"
image = "http://example.com"
4. Отправить запрос.

### Фактический результат
- Сервер успешно обрабатывает запрос, несмотря на то что поле "price" содержит отрицательное значение.
- Status code: 201 Created
- В response body возвращается объект с id нового продукта.
- В response body поле "price" содержит значение "-555".
- Продукт считается созданным с невалидным значением в поле "price".

### Ожидаемый результат
- Сервер должен отклонить запрос, если поле "price" содержит отрицательное значение.
- Status code: 400
- Response body содержит сообщение об ошибке
- Новый продукт не создается
- Поле "price" должно проходить валидацию. Отрицательное значение не должно считаться корректной ценой продукта.

### Окружение
API: Fake Store API
Метод: POST
Endpoint: https://fakestoreapi.com/products

---

## BR-006 (TC-013) POST /products: продукт создаётся при отправке запроса c буквенным значением поля "price" в Body

### Severity Major

### Предусловия: 
API доступен

### Шаги воспроизведения:
1. Открыть запрос POST https://fakestoreapi.com/products.
2. Во вкладке Body во вкладке "raw" выбрать формат JSON
3. Добавить тело запроса:
title = "FelixFelicius"
price = "fifty five"
description = "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"
category = "Potion"
image = "http://example.com"
4. Отправить запрос.

### Фактический результат
- Сервер успешно обрабатывает запрос, несмотря на то что поле "price" содержит буквенное значение.
- Status code: 201 Created
- В response body возвращается объект с id нового продукта.
- В response body поле "price" содержит значение "fifty five".
- Продукт считается созданным с невалидным значением в поле "price".

### Ожидаемый результат
- Сервер должен отклонить запрос, если поле "price" содержит буквенное значение.
- Status code: 400
- Response body содержит сообщение об ошибке
- Новый продукт не создается
- Поле "price" должно проходить валидацию. Буквенное значение не должно считаться корректной ценой продукта.

### Окружение
API: Fake Store API
Метод: POST
Endpoint: https://fakestoreapi.com/products

---

## BR-007 (TC-014) POST /products: продукт создаётся при отправке запроса c пустым полем "category" в Body

### Severity Major

### Предусловия: 
API доступен

### Шаги воспроизведения:
1. Открыть запрос POST https://fakestoreapi.com/products.
2. Во вкладке Body во вкладке "raw" выбрать формат JSON
3. Добавить тело запроса:
title = "FelixFelicius"
price = 0,666,
description = "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"
category = ""
image = "http://example.com"
4. Отправить запрос.

### Фактический результат
- Сервер успешно обрабатывает запрос, несмотря на то что обязательное поле "category" не заполнено.
- Status code: 201 Created
- В response body возвращается объект с id нового продукта.
- В response body поле "category" пустое.
- Продукт считается созданным с пустым значением в поле "category".

### Ожидаемый результат
- Сервер должен отклонить запрос, если поле "category" не заполнено.
- Status code: 400
- Response body содержит сообщение об ошибке
- Новый продукт не создается
- Поле category должно проходить валидацию. Пустая строка "" не должна считаться корректным значением для категории продукта.

### Окружение
API: Fake Store API
Метод: POST
Endpoint: https://fakestoreapi.com/products

---

## BR-008 (TC-015) POST /products: продукт создаётся при отправке запроса c цифрами в поле "category" в Body

### Severity Major

### Предусловия: 
API доступен

### Шаги воспроизведения:
1. Открыть запрос POST https://fakestoreapi.com/products.
2. Во вкладке Body во вкладке "raw" выбрать формат JSON
3. Добавить тело запроса:
title = "FelixFelicius"
price = 0,666,
description = "Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"
category = 12345
image = "http://example.com"
4. Отправить запрос.

### Фактический результат
- Сервер успешно обрабатывает запрос, несмотря на то что поле "category" содержит цифры.
- Status code: 201 Created
- В response body возвращается объект с id нового продукта.
- В response body поле "category" содержит цифры.
- Продукт считается созданным с невалидным цифровым значением в поле "category".

### Ожидаемый результат
- Сервер должен отклонить запрос, если поле "category" заполнено цифрами.
- Status code: 400
- Response body содержит сообщение об ошибке
- Новый продукт не создается
- Поле category должно проходить валидацию. Числовое значение не должно считаться корректным значением для категории продукта.

### Окружение
API: Fake Store API
Метод: POST
Endpoint: https://fakestoreapi.com/products

---