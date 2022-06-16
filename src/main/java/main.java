import java.util.*;


public class main {

    public static void main(String[] args) {

        int opt;
        String startUser;
        Scanner sc = new Scanner(System.in);  // Creación del objeto scanner

        System.out.println("Registrar como: ");
        startUser = sc.nextLine();
        do {
            System.out.println("### Dobble ###");
            System.out.println("## Registrado como: " + startUser);
            System.out.println("1. Crear un juego");
            System.out.println("2. Registrar jugador");
            System.out.println("3. Jugar");
            System.out.println("4. Visualizar el estado del juego completo");
            System.out.println("Introduzca su opción");
            opt = sc.nextInt();
        } while (opt != 1 && opt != 2 && opt != 3 && opt != 4);

        int n = 7;

        ArrayList<Integer> card = new ArrayList();
        Dobble mazo = new Dobble();

        for (int i = 1; i <= n + 1; i++) {
            card.add(i);
        }
        mazo.addCard(card);
        for (int j = 1; j <= n; j++) {
            card.clear();
            card.add(1);
            for (int k = 1; k <= n; k++) {
                card.add(n * j + (k + 1));
            }
            mazo.addCard(card);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                card.clear();
                card.add(i + 1);

                for (int k = 1; k <= n; k++) {
                    card.add(n + 2 + n * (k - 1) + (((i - 1) * (k - 1) + j - 1) % n));
                }
                mazo.addCard(card);
            }
        }

        ArrayList cardsSet = mazo.getCardsDeck();

        int index = 3;

        Card nthCard = mazo.nthCard(cardsSet,  index);

        System.out.println(nthCard.getListElements());

        System.out.println(mazo.findTotalCards(nthCard));
        System.out.println(mazo.requiredElements(nthCard));

    }

}