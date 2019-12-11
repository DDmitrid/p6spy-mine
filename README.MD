Scroll down to see [English version](#unpredictable-interaction-crashing-your-app)

#### Как непредвиденое взаимодействие валит приложение

**Как положить приложение?**

0. Запустите `FileCreator`: это создаст файл, забитый случайными данными нужного объёма 
1. Запустите `ReportRepositoryTest` со следующими настройками ВМ: `-Xmx1g -XX:+HeapDumpOnOutOfMemoryError`
2. Объяснение см. в [статье на Хабре](https://habr.com/ru/post/457776/) или попробуйте догадаться самостоятельно.

В качестве подсказки см. содержимое `spy.log`, который появится в корне проекта после запуска теста. 

Чтобы исправить положение, откройте файл `spy.properties` и раскройте последнюю строку.

----------------------------------------------------------------------------------------------------------

#### Unpredictable interaction crashing your app

**How to crash the application?**

0. Run `FileCreator`: it creates a text file stuffed with random bytes
1. Run `ReportRepositoryTest` with these VM options: `-Xmx1g -XX:+HeapDumpOnOutOfMemoryError`
2. See explanation in [my article](https://habr.com/ru/post/457776/) or detect it yourself.

For a clue see the contents of `spy.log` which appears in project root when the test is run.

To fix this open `spy.properties` and uncomment the last line.
