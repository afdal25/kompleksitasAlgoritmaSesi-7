import java.util.Scanner;

public class main {

    public static int penukaranKoin(int[] coins, int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        // Iterasi untuk setiap jumlah dari 1 hingga target
        for (int amount = 1; amount <= target; amount++) {
            for (int coin : coins) {
                if (amount >= coin && dp[amount - coin] != Integer.MAX_VALUE) {
                    dp[amount] = Math.min(dp[amount], dp[amount - coin] + 1);
                }
            }
        }

        return dp[target] == Integer.MAX_VALUE ? -1 : dp[target];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Denominasi koin
        int[] coins = {2, 3, 5, 10, 15};

        // Menginput target dari pengguna
        System.out.print("Masukkan jumlah target: ");
        int target = scanner.nextInt();

        // Menghitung jumlah minimum koin
        int result = penukaranKoin(coins, target);
        if (result != -1) {
            System.out.println("Jumlah minimum koin yang diperlukan untuk mencapai " + target + " adalah " + result + ".");
        } else {
            System.out.println("Tidak mungkin mencapai jumlah " + target + " dengan koin yang tersedia.");
        }

        scanner.close();
    }
}
