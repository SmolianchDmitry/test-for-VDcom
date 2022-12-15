package vdcomtest.converter;

import java.util.List;

import static vdcomtest.converter.dataInput.DataInput.inputStrings;
import static vdcomtest.converter.services.ConversionService.dataProcessing;

public class Conversion {
    public static void main(String[] args) {
        List<String> stringsForRatio;
        List<String> stringsForConversion;
        System.out.println("Введите соотношения между величинами в формате a W = b V. \n" +
                "Где a, b - числа, а W, V - названия величин.\n" +
                "После окончания ввода - введите пустую строку (два раза нажмите ввод)\n");
        stringsForRatio = inputStrings();
        System.out.println("Введите условия для конвертации в формате a W = ? V\n" +
                "После окончания ввода - введите пустую строку (два раза нажмите ввод)\n");
        stringsForConversion = inputStrings();
        dataProcessing(stringsForRatio, stringsForConversion).forEach(System.out::println);
    }
}
