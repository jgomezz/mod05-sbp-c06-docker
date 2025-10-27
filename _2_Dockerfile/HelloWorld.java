public class HelloWorld {
    public static void main(String[] args) {
        //System.out.println("Hello, World!");

        int cont = 0;
        while(true) {
            try {
                Thread.sleep(1000);
                cont++;
                System.out.println("Mensaje #" + cont + ": Hello, World!");
            } catch (InterruptedException e) {
                System.out.println("Se interrumpió el hilo");
                // Handle exception
            }
        }

    }
}