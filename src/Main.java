import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        try {
            //Відкриємо текстовий файл
            File file = new File("textForTest.txt");
            Scanner myReader = new Scanner(file);

            //Колекція для зберігання слів із вхідного файлу
            ArrayList<String> words = new ArrayList<>();

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                //Розбиваємо рядок на слова. Роздільник - будь-який
                //символ, окрім букв або цифр
                String[] line = data.split("[^a-zA-Z0-9\"'-]");
                subString(line);
                words.addAll(Arrays.asList(line));
            }
            myReader.close();

            //Знайдемо слова, що задовольняють
            //умову роботи
            ArrayList<String> result = getLongestWord(words);
            for (String word : result)
            {
                System.out.print(word + " ");
            }


        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено");
            e.printStackTrace();
        }
    }

    //Функція пошуку слів за умовою роботи
    private static ArrayList<String> getLongestWord(ArrayList<String> words)
    {
        ArrayList<String> arrayListLongWords = new ArrayList<>();
        String longestWord = words.get(0);

        for (String word : words)
        {
           if(word.length() > longestWord.length()) {
               longestWord = word;
           }
        }
        for (String word : words)
        {
            if(word.length() == longestWord.length()) {
                arrayListLongWords.add(word);
            }
        }

        return  arrayListLongWords;
    }

    //Функція скорочення слів масиву
    private static  void subString(String[] words)
    {
        for (int i = 0; i < words.length; ++i)
        {
            words[i] = words[i].length() > 30 ? words[i].substring(0, 30) : words[i];
        }
    }
}