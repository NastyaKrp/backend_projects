package org.example;

import javax.swing.*;
import java.awt.*;

public class UI {
    private Shop shop;
    private static JTextField textField = new JTextField();

    public UI(Shop shop) {
        this.shop = shop;
    }

    public void init() {
        JFrame frame = new JFrame("Test shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel context = new JPanel();
        context.setLayout(new BoxLayout(context, BoxLayout.Y_AXIS));
        frame.getContentPane().add(context);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        context.add(textField);
        context.add(buttons);


        JButton start = new JButton("Start");
        start.addActionListener(e -> textField.setText(shop.getState().onStartShopping()));
        JButton buy = new JButton("Buy");
        buy.addActionListener(e -> textField.setText(shop.getState().onBuy()));
        JButton stop = new JButton("Leave");
        stop.addActionListener(e -> textField.setText(shop.getState().onLeave()));
        JButton next = new JButton("Next");
        next.addActionListener(e -> textField.setText(shop.getState().onNext()));
        JButton prev = new JButton("Prev");
        prev.addActionListener(e -> textField.setText(shop.getState().onPrevious()));
        JButton take = new JButton("Take");
        take.addActionListener(e -> textField.setText(shop.getState().onTake()));
        JButton put = new JButton("Put");
        put.addActionListener(e -> textField.setText(shop.getState().onPut()));
        frame.setVisible(true);
        frame.setSize(600, 100);
        buttons.add(start);
        buttons.add(buy);
        buttons.add(stop);
        buttons.add(next);
        buttons.add(prev);
        buttons.add(take);
        buttons.add(put);
    }
}
