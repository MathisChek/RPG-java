public class ShopActions {
    public boolean purchaseElixir(Player player) {
        int price = 10;
        if (player.getCoins() >= price) {
            player.setCoins(player.getCoins() - price);
//                player.addElixir(); TODO : implementer l(ajout d'elixir au character
            System.out.println("🛒 Vous avez acheté un élixir ! Il vous reste " + player.getCoins() + " coins.");
            return true;
        } else {
            System.out.println("❌ Vous n'avez pas assez de coins pour acheter un élixir.");
            return false;
        }
    }
}

