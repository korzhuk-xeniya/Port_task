package korzhuk.xeny;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] array = {"1,3-5", "2", "3-4,5"};// пример из задания
        Port port = new Port(array);
        Port port2 = new Port(array);
        JFrame frame = new JFrame("Окно пользователя");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MeKeyListener listener = new MeKeyListener();
        frame.addKeyListener(listener);
        frame.setSize(800, 600);
        JButton buttonOne = new JButton("Преобразовать в массив чисел");
        frame.add(buttonOne, BorderLayout.SOUTH);
        buttonOne.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Массив строк преобразован в массив чисел: " +
                        Arrays.toString(port2.getArrayOfNumbers())));

        JButton buttonTwo = new JButton("Вернуть всевозможные уникальные группы элементов");
        frame.add(buttonTwo, BorderLayout.NORTH);
        buttonTwo.addActionListener((e -> JOptionPane.showMessageDialog(frame,
                "Всевозможные уникальные упорядоченные группы элементов: "
                + port.getUniqueGroupsElements())));
        frame.setVisible(true);
    }
}