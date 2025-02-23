public class ShopActions {
    public boolean purchase(Player player) {
        int price = 10;
        System.out.println("Un combattant avisé sait toujours quand reprendre des forces avec un bon élixir.\n");

        if (player.getCoins() >= price) {
            player.setCoins(player.getCoins() - price);
                player.addElixir();
            System.out.println("🛒 Vous avez acheté un élixir ! Il vous reste " + player.getCoins() + " coins.");
            return true;
        } else {
            System.out.println("❌ Vous n'avez pas assez de coins pour acheter un élixir !");
            return false;
        }
    }
}

