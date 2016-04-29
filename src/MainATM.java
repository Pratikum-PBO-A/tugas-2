package Modul1_Bab2;
/**
 *
 * @author abdu_
 */
import java.util.Scanner;

public class MainATM {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ATM atm[] = new ATM[100];
        int choice, x = 0, pin;
        do {
            System.out.print("-----------------------------------------"
                    + "\n\t  SELAMAT DATANG DI MENU\n"
                    + "\t       BANK KRUT\n\n"
                    + " 1 <- DAFTAR BARU \t TRANSAKSI -> 2\n"
                    + " 0 <- KELUAR\n\n"
                    + "\t   MASUKKAN PILIHAN : ");
            choice = input.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    atm[x] = new ATM();
                    x++;
                    break;
                case 2:
                    double send = 0,
                     from = 0;
                    for (int i = 0; i < x; i++) {
                        System.out.print("-----------------------------------------\n\n"
                                + "\t\t\tSILAHKAN \n\t\t\tMEMASUKKAN\n"
                                + "\t\t\tPIN ANDA \n\n\t\t\t");
                        pin = input.nextInt();
                        if (pin == atm[i].getPin()) {
                            System.out.println("\n\t\t\tPIN SUKSES!\n");
                            atm[i].atm();
                            for (int j = 0; j < x; j++) {
                                if (atm[i].getChoiceId() == atm[j].getCustomerId()) {
                                    System.out.println("-----------------------------------------\n"
                                            + "\n\t INFORMASI PEMINDAHBUKUAN\n"
                                            + "\n DARI\t\t: " + atm[i].getCustomerId()
                                            + "\n NAMA\t\t: " + atm[i].getName()
                                            + "\n KE\t\t: " + atm[i].getChoiceId()
                                            + "\n NAMA\t\t: " + atm[j].getName()
                                            + "\n JUMLAH\t\t: " + atm[i].getChoiceBalance()
                                            + "\n\n\t  TRANSAKSI DIPROSES\n");
                                    send = atm[i].getBalance() - atm[i].getChoiceBalance();
                                    from = atm[j].getBalance() + atm[i].getChoiceBalance();
                                    atm[j].setBalance(from);
                                    atm[i].setBalance(send);
                                }
                            }
                        } else {
                            System.out.println("\n\n\t   MAAF PIN ANDA SALAH!!\n\n");
                        }
                        i = x;
                    }
                case 0:
                    System.out.println("-----------------------------------------");
                    System.err.println("\t     Terima Kasih!");
                    break;
                default:
                    System.out.println("       PILIHAN ANDA TIDAK TERSEDIA");
            }
        } while (choice != 0);
    }
}