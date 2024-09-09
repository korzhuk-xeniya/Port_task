package korzhuk.xeny;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        String[] array = {"1,3-5", "2", "3-4,5"};// пример из задания создание массива строк
        Port port = new Port(array);
        System.out.println(Arrays.toString(port.getArrayOfNumbers()));
        System.out.println(port.getUniqueGroupsElements());

//    }
//    public static void openWindowWithSwing(){
        JFrame frame = new JFrame("Окно пользователя");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        JButton buttonOne = new JButton("Преобразовать в массив чисел");
        frame.add(buttonOne, BorderLayout.SOUTH);
        buttonOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                JOptionPane.showMessageDialog(frame,
                        "Массив строк преобразован в массив чисел! " +
                                Arrays.toString(port.getArrayOfNumbers()));
            }
        });

        JButton buttonTwo = new JButton("Вернуть всевозможные уникальные группы элементов");
        frame.add(buttonTwo, BorderLayout.NORTH);
        buttonTwo.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Всевозможные уникальные упорядоченные группы элементов"
                        + port.getUniqueGroupsElements());
            }
        }));
        frame.setVisible(true);
    }
}