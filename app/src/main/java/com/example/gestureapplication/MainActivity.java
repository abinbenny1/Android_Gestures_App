package com.example.gestureapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize gesture detector with a custom listener
        gestureDetector = new GestureDetector(this, new GestureListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float diffX = e2.getX() - e1.getX();
            float diffY = e2.getY() - e1.getY();

            if (Math.abs(diffX) > Math.abs(diffY)) {
                // Detecting left and right swipes
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        onSwipeRight();
                    } else {
                        onSwipeLeft();
                    }
                }
            } else {
                // Detecting up and down swipes
                if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        onSwipeDown();
                    } else {
                        onSwipeUp();
                    }
                }
            }
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            // Detecting double tap
            onDoubleTapDetected();
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            // Detecting long press
            onLongPressDetected();
        }
    }

    // Handle left swipe
    private void onSwipeLeft() {
        Toast.makeText(MainActivity.this, "Left Swipe Detected", Toast.LENGTH_SHORT).show();
    }

    // Handle right swipe
    private void onSwipeRight() {
        Toast.makeText(MainActivity.this, "Right Swipe Detected", Toast.LENGTH_SHORT).show();
    }

    // Handle swipe up
    private void onSwipeUp() {
        Toast.makeText(MainActivity.this, "Up Swipe Detected", Toast.LENGTH_SHORT).show();
    }

    // Handle swipe down
    private void onSwipeDown() {
        Toast.makeText(MainActivity.this, "Down Swipe Detected", Toast.LENGTH_SHORT).show();
    }

    // Handle double tap
    private void onDoubleTapDetected() {
        Toast.makeText(MainActivity.this, "Double Tap Detected", Toast.LENGTH_SHORT).show();
    }

    // Handle long press
    private void onLongPressDetected() {
        Toast.makeText(MainActivity.this, "Long Press Detected", Toast.LENGTH_SHORT).show();
    }
}

