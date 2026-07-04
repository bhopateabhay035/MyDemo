package runnable;

public class CountDownTimer implements Runnable {

	private int startFrom;
    // Constructor to set the starting number for the countdown
    public CountDownTimer(int startFrom) {
        this.startFrom = startFrom;
    }

    @Override
    public void run() {
        try {
            while (startFrom > 0) {
                System.out.println("Countdown: " + startFrom);
                startFrom--;
                // Pause for 1 second between each number
                Thread.sleep(1000);
            }
            System.out.println("Countdown finished!");
        } catch (InterruptedException e) {
            System.out.println("Countdown was interrupted.");
        }
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Runnable countdown = new CountDownTimer(10);

        // Create a new Thread object with the countdown timer
        Thread thread = new Thread(countdown);

        // Start the countdown in a new thread
        thread.start();

	}

}
