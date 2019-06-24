Scroll down to see [English version](#unpredictable-interaction-crashing-your-app)

#### Как непредвиденое взаимодействие валит приложение

**Как положить приложение?**

1. Откройте `ReportRepositoryTest` и откройте первую строчку в методе `test` (закрыв 2-ю)
2. Укажите путь к файлу размером не менее 70-72 Мб (проверено на JDK 11).
3. Запустите тест с аргументом ВМ -Xmx1g (размер кучи ограничен 1 Гб).
4. Объяснение см. в статье на Хабре (ссылка будет добавлена) или попробуйте догадаться самостоятельно.

В качестве подсказки см. содержимое `spy.log`, который появится в корне проекта после запуска теста. 

Чтобы исправить положение, откройте файл `spy.properties` и раскройте последнюю строку.

#### Unpredictable interaction crashing your app

**How to crash your application?**

1. Open `ReportRepositoryTest` and uncomment the first line in method `test` (comment the 2nd one)
2. Specify path to file of about 70-72 Mb (tested on JDK 11).
3. Run the test with -Xmx1g (max heap size is limited up to 1 Gb).
4. See explanation on [habr.com](habr.com) (the link will be added later) or detect it yourself.

For a clue see the contents `spy.log` which appears in project root when the test is run.

To fix this open `spy.properties` and uncomment the last line.
