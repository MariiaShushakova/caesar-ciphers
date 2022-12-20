# caesar-ciphers
JavaRush mentoring program

## Run
Java 17

###Console:
1. Main.java - run
2. Choose mode: 
   1. 1 - "Encryption mode" requires to type the path to the file with normal (not encrypted) text. Project has already contained such a file - `text.txt` OR you can create your own and type absolute path to it. Then you should type path to result file and shift key. In the result file you will find encrypted line.
   2. 2 - "Decryption mode" requires to type the path to the file with encrypted text. Project has already contained such a file - `text2.txt` OR you can create your own and type absolute path to it. Then you should type directory for result file and shift key. In the result file you will find decrypted line.
   3. 3 - "brute force" requires  the path to the file with encrypted text. Project has already contained such a file - `text2.txt` OR you can create your own and type absolute path to it. Then you should type directory for result file and shift key. In the result file you will find decrypted line.
   4. 0 - exit from application

###GUI:
1. Gui.java  - run
2. Fill in text and key fields 
3. Click "Encrypt" / "Decrypt"

**Note:** application works only with russian words.

## Обязательные требования
У программы должно быть 2 режима:

1. **Шифрование / расшифровка.** Программа должна зашифровывать и расшифровывать текст, используя заданный криптографический ключ.

    Программа должна получать путь к текстовому файлу с исходным текстом и на его основе создавать файл с зашифрованным текстом.


3. **Криптоанализ методом brute force**

    Программа должна взламывать зашифрованный текст, переданный в виде текстового файла.

    Если пользователь выбирает brute force (брутфорс, поиск грубой силой), программа должна самостоятельно, путем перебора, подобрать ключ и расшифровать текст.

    Подумай, какой критерий программа должна воспринимать как сигнал успешного подбора ключа. Возможно, нужно обратить внимание на пробелы между словами или правильность использования знаков пунктуации.

## Дополнительные требования
1. Криптоанализ методом статистического анализа

    У пользователя программы должна быть возможность выбрать один из двух методов криптоанализа. Если пользователь выбирает метод статистического анализа, ему нужно предложить загрузить еще один дополнительный файл с текстом, желательно— того же автора и той же стилистики. На основе загруженного файла программа должна составить статистику вхождения символов и после этого попытаться использовать полученную статистику для криптоанализа зашифрованного текста.


2. User Interface

    Все диалоговые окна с пользователем делай на свое усмотрение. При желании можно использовать графические фреймворки Swing, JavaFX.