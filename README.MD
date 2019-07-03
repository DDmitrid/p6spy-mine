Scroll down to see [English version](#unpredictable-interaction-crashing-your-app)

#### Как непредвиденое взаимодействие валит приложение

**Как положить приложение?**

0. Запустите `FileCreator`: то создаст файл, забитый случайными данными нужного объёма 
1. Запустите `ReportRepositoryTest` со следующими настройками ВМ: `-Xmx1g -XX:+HeapDumpOnOutOfMemoryError`
2. Объяснение см. в статье на Хабре (ссылка будет добавлена) или попробуйте догадаться самостоятельно.

В качестве подсказки см. содержимое `spy.log`, который появится в корне проекта после запуска теста. 

Чтобы исправить положение, откройте файл `spy.properties` и раскройте последнюю строку.

----------------------------------------------------------------------------------------------------------

#### Unpredictable interaction crashing your app

**How to crash your application?**

0. Run `FileCreator`: it creates a text file stuffed with random bytes
1. Run `ReportRepositoryTest` with these VM options: `-Xmx1g -XX:+HeapDumpOnOutOfMemoryError`
2. See explanation on [habr.com](habr.com) (the link will be added later) or detect it yourself.

For a clue see the contents of `spy.log` which appears in project root when the test is run.

To fix this open `spy.properties` and uncomment the last line.
