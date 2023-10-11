import java.time.LocalTime;

public class ConsoleClock extends Thread{
    static ConsoleClock consoleClock = new ConsoleClock();

    public static void main(String[] args) throws InterruptedException {
        consoleClock.start(); //метод запускает поток
        Thread.sleep(3000); // блокирует основной поток (метод main) на 3 секунды, поток длиться 3 секунды
        consoleClock.interrupt(); // Останавливает поток после его завершения
    }
    @Override
    public void run() {
        while(!isInterrupted()) { // цикл выполняется пока поток не завершён
            LocalTime time = LocalTime.of(
                    LocalTime.now().getHour(),
                    LocalTime.now().getMinute(),
                    LocalTime.now().getSecond());
            System.out.println(time);
            try {
                Thread.sleep(1000); // задержка 1 секунда между циклами
            } catch (InterruptedException e) {
                System.out.println("The clock stopped");
                break;
            }
        }
    }
}
