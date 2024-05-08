package com.company.diamonds.logic;

import com.company.diamonds.ui.OutputInterface;

public class Logic implements LogicInterface {

    public static final String TAG = Logic.class.getName();

    private OutputInterface mOut;

    public Logic(OutputInterface out) {
        mOut = out;
    }

    public void process(int size) {
        if (size < 1) {
            mOut.println("Invalid size. Size should be 1 or greater.");
            return;
        }

        drawFrame(size);

        // Draw the upper half of the diamond
        for (int i = 1; i <= size; i++) {
            drawLine(size, i, true);
        }

        // Draw the lower half of the diamond
        for (int i = size - 1; i > 0; i--) {
            drawLine(size, i, false);
        }

        drawFrame(size);
    }

    private void drawLine(int size, int lineNumber, boolean isUpper) {
        int spaces = size - lineNumber;
        int dashes = 2 * lineNumber - 1;

        // Draw left part of the frame
        mOut.print("|");

        // Draw spaces to the left of the diamond
        for (int i = 0; i < spaces; i++) {
            mOut.print(" ");
        }

        // Draw the left side of the diamond
        if (lineNumber == size) {
            mOut.print("<");
        } else {
            mOut.print(isUpper ? "/" : "\\");
        }

        // Draw dashes
        for (int i = 2; i < dashes + 1; i++) {
            if (lineNumber % 2 == 0) {
                mOut.print("-");
            } else {
                mOut.print("=");
            }
        }

        // Draw the right side of the diamond
        if (lineNumber == size) {
            mOut.print(">");
        } else {
            mOut.print(isUpper ? "\\" : "/");
        }

        // Draw spaces to the right of the diamond
        for (int i = 0; i < spaces; i++) {
            mOut.print(" ");
        }

        // Draw right part of the frame
        mOut.println("|");
    }

    private void drawFrame(int size) {
        // Draw the top part of the frame
        mOut.print("+");
        for (int i = 2; i < size * 2 + 2; i++) {
            mOut.print("-");
        }
        mOut.println("+");
    }
}
