import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        //Исходные данные к 1 задаче:
        String[] array = {"Санкт-Петербург", "Москва", "Тула", "Рязань", "Казань"};
        createString(array);
        //Исходные данные ко 2 задаче:
        float number = 31;
        roundingNumber(number);
        //Исходные данные к 3 задаче:
        int computers = 54;
        countingComputers(computers);
        //Исходные данные к 4 задаче:
        int firstNumber = 1;
        primeOrComplex(firstNumber);
        //Исходные данные к 5 задаче:
        int[] firstArray = {4, 4, 6, 8, 9, 1, 9, 0, 9, 2, 7};
        int[] secondArray = {3, 3, 2, 4, 9, 1, 4, 9, 9, 5, 7};
        searchNumbers(firstArray, secondArray);
    }

    //Здача 1, время выполнения 12 минут
    public static String createString(String[] array){
        String cities = "";
        int count = 1;
        for (int i = 0; i < array.length ; i++) {
        cities = cities + array[i];
        if(count < array.length){
            cities = cities + ", ";
            count++;
        } else{
            cities = cities + ".";
        }
        }
        return cities;
    }

    //Задача 2, время выполнения 19 минут
    public static int roundingNumber(float number){
        float newNumber = (int)number % 5;
        int backNumber;
        if((5 - newNumber) < 2.5){
            backNumber = (int) number/5 * 5 + 5;
            return backNumber;
        } else{
            backNumber = (int) number/5 * 5;
            return backNumber;
        }
    }

    //Задача 3, время выполнения 8 минут
    public static String countingComputers(int computers){
        int remains = computers%10;
        String result = "";
        if(remains == 1){
            result = result + computers + " компьютер";
        } else if(remains >= 2 && remains <=4 ){
            result = result + computers + " компьютера";
        }
        else if(remains >= 5 && remains<= 9 || remains == 0){
            result = result + computers + " компьютеров";

        }
        return result;
    }

    //Задача 4, время выполнения 5 минут
    public static boolean primeOrComplex(int firstNumber){
        for(int i = 2; i < firstNumber; i++){
            if(firstNumber%i == 0)
                return false;
        }
        return true;
    }

    //Задача 5, время выполнения 47 минут
    public static List<Integer> searchNumbers(int[] firstArray, int [] secondArray){
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> firstMap = new HashMap<>();
        for(int i = 0; i < firstArray.length; i++){
            if(firstMap.get(firstArray[i]) != null){
                firstMap.put(firstArray[i], firstMap.get(firstArray[i]) + 1);
            }else{
                firstMap.put(firstArray[i],1);
            }
        }

        Map<Integer,Integer> secondMap = new HashMap<>();
        for(int i = 0; i < firstArray.length; i++){
            if(secondMap.get(secondArray[i]) != null){
                secondMap.put(secondArray[i], secondMap.get(secondArray[i]) + 1);
            }else{
                secondMap.put(secondArray[i],1);
            }
        }

        for (Map.Entry<Integer, Integer> pair: firstMap.entrySet()){
            if(pair.getValue() >= 2){
                if(secondMap.get(pair.getKey()) >= 2){
                    list.add(pair.getKey());
                }
            }
        }

        return list;
    }
}
