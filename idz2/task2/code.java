package com.tasks3.fibonacci;

public class Fibonacci {
    public long getNumber(int position) {
        if (position <= 0) {
            return -1; // якщо позиція виходить за межі допустимого діапазону
        } else if (position == 1 || position == 2) {
            return 1; // базовий випадок, коли позиція дорівнює 1 або 2
        } else {
            return getNumber(position - 1) + getNumber(position - 2); // рекурсивний виклик
        }
    }
}

