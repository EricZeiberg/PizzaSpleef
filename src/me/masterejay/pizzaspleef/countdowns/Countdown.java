package me.masterejay.pizzaspleef.countdowns;

/**
 * @author Jake0oo0
 */
public abstract class Countdown {

       /**
         * Event called when countdown starts
         *
         * @param sec
         */
        public void onStart(int sec) {

        }

        /**
         * Event called when a countdown ends
         *
         */
        public abstract void onEnd();

        /**
         * Event called when a countdown ticks
         * down one second
         *
         * @param secs
         */
        public void tick(int secs) {

        }

        /**
         * Event called when a countdown is cancelled
         *
         */
        public void onCancel() {

        }
    }
