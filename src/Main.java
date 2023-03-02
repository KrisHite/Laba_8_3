import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        char[] symbols = new char[]{'Б','В','Г','Д','Ж','З','Й','К','Л','М','Н','П','Р','С','Т','Ф','Х','Ц','Ч','Ш','Щ','б','в','г','д','ж','з','й','к','л','м','н','п','р','с','т','ф','х','ц','ч','ш','щ'};
        File fileToRead = new File("Text.txt");//Создаю объект для уже существующего файла
        File fileToWrite = new File("Result.txt");
        fileToWrite.createNewFile();//Создал файл для записи
        if(fileToRead.exists()){//Проверка на то что файл с текстом существует
            BufferedReader in = null;
            BufferedWriter out = null;
            Integer countLines = 1;//Счетчик строк для записи
            int countWords = 0;//Счетчик слов начинающихся с согласной
            String bufferString = null;
            String text = null;
            try {
                in = new BufferedReader(new FileReader("Text.txt"));
                out = new BufferedWriter(new FileWriter("Result.txt"));
                while (true) {
                    countWords = 0;//Обнуляю счетчик слов
                    bufferString = "Строка " + countLines.toString() + ": ";//Назначаю номер строки
                    text = in.readLine();//Считываю строку
                    if(text == null){//Когда текст кончится выйти из цикла
                        break;
                    }
                    String[] arr = text.split(" ");//Разделяю на слова
                    for(int i = 0; i < arr.length; i++){//прохожусь по массиву слов
                        char[] firstSym = arr[i].toCharArray();//Разделяю на буквы
                        for(int k = 0; k < symbols.length; k++){//Пробегаюсь по массиву гласных букв
                            if(firstSym[0] == symbols[k]){//Если первый символ согласный
                               bufferString = bufferString + " " + arr[i];
                               countWords++;
                               break;
                            }
                        }
                    }
                    out.write(bufferString + " " + countWords + " слов\n");//Записываю получившуюся строку в файл
                    System.out.print(bufferString + " " + countWords + " слов\n");//Вывожу результат в консоль
                    countLines++;
                }
            }catch(IOException e ){
                System.out.printf("Ошибка!" + e);
            }finally {//Закрываю потоки чтения и записи
                in.close();
                out.flush();
                out.close();
            }

        }else{
            System.out.printf("Ошибка! Файл не найден!");
            System.exit(1);
        }
    }
}
//Задание 3. Создать проект, позволяющий из одного текстового файла,
//        содержащего несколько строк (тип String) заранее подготовленного текста
//        на русском языке (Пушкин, Лермонтов или другой российсмки классик на
//        Ваш вкус), построчно переписать в другой текстовый файл слова
//        начинающиеся с согласных букв..
//        Требования:
//        – слова из предложения выделять методом split();
//        – в новом файле следует указать номер строки, в которой иско- мые
//        слова находились в исходном файле;
//        – для каждой строки указать количество выбранных слов.

//            try{
//                in = new BufferedReader(new FileReader("Text.txt"));
//                String buff;
//                while (true) {
//                    buff = in.readLine();
//                    if(buff == null){
//                        break;
//                    }
//                    System.out.printf(buff + "\n");
//                }
//            }catch (IOException e){
//                System.out.printf("Ошибка!");
//            }