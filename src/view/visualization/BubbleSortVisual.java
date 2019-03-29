package view.visualization;

import javafx.animation.AnimationTimer;

public class BubbleSortVisual extends SortVisual {

    public BubbleSortVisual(double width, double height) {
        super(width, height);
        animationTimer = new AnimationTimer() {
            long lastAnimationTime  = System.nanoTime();
            int i = 0;
            int j = 0;
            int outerLoopBound = list.size()-1;
            int swaps = 0;
            int previousSwaps = 0;
            long animationDelay = 20000000; // 0.02 seconds
            @Override
            public void handle(long now) {
                System.out.println(i + "\t" + j);
                long currentDelay = now - lastAnimationTime;
                // check if animation delay passed to make sure animation is observed
                if (currentDelay >= animationDelay) {
                    lastAnimationTime = now;
                    // compare current element with next to swap if needed
                    highlightElement(j);
                    if (swapPerformed(j)) {
                        swaps++;
                    }
                    visualize();
                    dimElement(j);
                    // check condition for inner loop
                    if (j < outerLoopBound - i - 1) {
                        j++;
                    }
                    // else jump to the next iteration in the outer loop
                    else {
                        if (previousSwaps == swaps){
                            animationTimer.stop();
                            return;
                        }
                        setElementSorted(j+1);
                        previousSwaps = swaps;
                        i++;
                        j=0;
                    }
                }
                // check condition for outer loop
                if (i == outerLoopBound){
                    animationTimer.stop();
                }
            }
        };
        animationTimer.start();
    }

    private boolean swapPerformed(int index){
        if (index<list.size()) {
            if (list.get(index).getHeight() < list.get(index + 1).getHeight()) {
                swap(index, index + 1);
                return true;
            }
        }
        return false;
    }

    private void swap(int a, int b) {
        // swap the x coordinate of the 2 elements
        double x = list.get(a).getX();
        list.get(a).setX(list.get(b).getX());
        list.get(b).setX(x);
        // swap the positions of the 2 elements in the array
        VisualElement v = list.get(a);
        list.set(a, list.get(b));
        list.set(b, v);
    }
}
