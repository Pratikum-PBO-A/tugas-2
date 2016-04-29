package Modul1_Bab2;
/**
 *
 * @author abdu_
 */
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class ATM {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yy HH:mm");
    String date1 = date.format(cal.getTime());
    Scanner input = new Scanner(System.in);
    private static final String nameOfBank = "BANK KRUT";
    private static long totalCustomer = 1234567890;
    private final long customerId = ++totalCustomer;
    private String name;
    private int pin;
    private double balance, choiceBalance;
    private long choiceId;

    ATM() {
        System.out.print("-----------------------------------------\n"
                + "\n\tMENU PENDAFTARAN AKUN BARU\n"
                + "\t    MASUKKAN DATA ANDA\n\n"
                + " NAMA \t\t: ");
        this.name = inputStringLine();
        System.out.print(" PIN \t\t: ");
        this.pin = input.nextInt();
        System.out.print(" SETORAN TUNAI \t: ");
        this.balance = input.nextDouble();
        System.out.println("");
        displayCustomer();
    }

    void displayCustomer() {
        System.out.println("-----------------------------------------\n"
                + "\t       BANK KRUT\n"
                + "       BUKTI STRUK PENDAFTARAN ANDA\n"
                + "\t      " + date1
                + "\n\n BANK \t\t: " + nameOfBank
                + "\n NO REKENING \t: " + customerId
                + "\n NAMA \t\t: " + name.toUpperCase()
                + "\n PIN \t\t: " + pin
                + "\n SALDO \t\t: " + balance
                + "\n\n\t  HARAP JAGA KERAHASIAAN"
                + "\n\t\t PIN ANDA");
    }

    void atm() {
        System.out.print("-----------------------------------------\n\n"
                + "\t   PILIH TRANSAKSI YANG\n"
                + "\t      ANDA INGINKAN\n"
                + "\n 1 <- GANTI PIN      PENARIKAN TUNAI -> 3"
                + "\n 2 <- TRANSFER       INFORMASI SALDO -> 4"
                + "\n\n 0 <- MENU SEBELUMNYA"
                + "\n\n\t\tPILIHAN : ");
        int choice = input.nextInt();
        System.out.println("");
        switch (choice) {
            case 1:
                setPin();
                break;
            case 2:
                transfer();
                break;
            case 3:
                cashWithdrawal();
                break;
            case 4:
                checkBalance();
                break;
            case 0:;
                break;
            default:
                System.out.println("       PILIHAN ANDA TIDAK TERSEDIA");
        }
    }

    void setPin() {
        System.out.print("-----------------------------------------\n\n"
                + "\t\t\tMASUKKAN\n\t\t\tPIN\n\t\t\tBARU ANDA\n\n\t\t\t");
        this.pin = input.nextInt();
        System.out.println("\n\n\t    PIN SUKSES DIGANTI\n\n");
    }

    void transfer() {
        System.out.print("-----------------------------------------\n"
                + "\n\t   PILIH TUJUAN TRANSFER\n"
                + "\t    YANG ANDA INGINKAN\n"
                + "\n\n\t\t  KE REKENING SESAMA -> 1"
                + "\n\t       KE REKENING BANK LAIN -> 2"
                + "\n\n\t\tPILIHAN : ");
        int choice = input.nextInt();
        if (choice == 1) {
            transferTo();
        } else if (choice == 2) {
            transferToOther();
        }
        System.out.println();
    }

    void transferTo() {
        System.out.print("-----------------------------------------\n"
                + "\n\t  SILAKAN MASUKKAN NOMOR\n"
                + "     REKENING TUJUAN PEMINDAHBUKUAN\n\n\t\t");
        choiceId = input.nextLong();
        System.out.print("\n\t\t    PILIH JIKA BENAR -> 1"
                + "\n\t\t    PILIH JIKA SALAH -> 2"
                + "\n\n\t\tPILIHAN : ");
        int choice = input.nextInt();
        if (choice == 1) {
            nominal();
        } else {
            transferTo();
        }
    }

    void transferToOther() {
        System.out.println("-----------------------------------------\n"
                + "\n\t   TRANSFER ANTAR BANK\n");
        System.out.print(" BANK TUJUAN\t: ");
        String otherBank = inputStringLine();
        System.out.print(" NO REKENING\t: ");
        choiceId = input.nextLong();
        System.out.print(" NAMA\t\t: ");
        String otherName = inputStringLine();
        System.out.print(" JUMLAH\t\t: ");
        choiceBalance = input.nextDouble();
        System.out.print("\n\t\t    PILIH JIKA BENAR -> 1"
                + "\n\t\t    PILIH JIKA SALAH -> 2"
                + "\n\n\t\tPILIHAN : ");
        int choice = input.nextInt();
        if (choice == 1 && choiceBalance <= balance) {
            System.out.println("-----------------------------------------\n"
                    + "\t INFORMASI PEMINDAHBUKUAN"
                    + "\n\t      " + date1
                    + "\n\n DARI BANK\t: " + nameOfBank
                    + "\n NO REKENING\t: " + customerId
                    + "\n NAMA\t\t: " + name
                    + "\n KE BANK\t: " + otherBank
                    + "\n NO REKENING\t: " + choiceId
                    + "\n NAMA\t\t: " + otherName
                    + "\n JUMLAH\t\t: " + choiceBalance
                    + "\n\t    TRANSAKSI DIPROSES");
            balance -= choiceBalance;
        } else if (choice == 1 && choiceBalance > balance) {
            System.out.println("     MAAF SALDO ANDA TIDAK MENCUKUPI");
        } else {
            transferToOther();
        }
    }

    void nominal() {
        System.out.print("-----------------------------------------\n"
                + "\n      MASUKKAN JUMLAH UANG YANG AKAN\n"
                + "\t     DIPINDAHBUKUKAN\n\n\t\t");
        choiceBalance = input.nextDouble();
        System.out.print("\n\t\t    PILIH JIKA BENAR -> 1"
                + "\n\t\t    PILIH JIKA SALAH -> 2"
                + "\n\n\t\tPILIHAN : ");
        int choice = input.nextInt();
        if (choice == 1 && choiceBalance <= balance) {
        } else if (choice == 1 && choiceBalance > balance) {
            System.out.println("     MAAF SALDO ANDA TIDAK MENCUKUPI\n");
        } else {
            nominal();
        }
    }

    void cashWithdrawal() {
        System.out.print("-----------------------------------------\n"
                + "\n      SILAKAN MEMASUKKAN JUMLAH UANG"
                + "\n\t      YANG DIINGINKAN\n\n\t\t");
        choiceBalance = input.nextDouble();
        System.out.print("\n\t\t    PILIH JIKA BENAR -> 1"
                + "\n\t\t    PILIH JIKA SALAH -> 2"
                + "\n\n\t\tPILIHAN : ");
        int choice = input.nextInt();
        if (choice == 1 && choiceBalance <= balance) {
            balance -= choiceBalance;
            System.out.println("-----------------------------------------\n"
                    + "\t       BANK KRUT\n"
                    + "\tBUKTI STRUK PENARIKAN TUNAI\n"
                    + "\t      " + date1
                    + "\n\n NO REKENING\t: " + customerId
                    + "\n NAMA\t\t: " + name
                    + "\n JUMLAH\t\t: RP " + choiceBalance
                    + "\n SISA SALDO\t: RP " + balance
                    + "\n\n\t TINGKATKAN TRANSAKSI ANDA\n");
        } else if (choice == 1 && choiceBalance > balance) {
            System.out.println("     MAAF SALDO ANDA TIDAK MENCUKUPI\n");
        } else {
            cashWithdrawal();
        }
        choiceId = 0;
    }

    void checkBalance() {
        System.out.println("-----------------------------------------\n"
                + "\t       BANK KRUT\n"
                + "\t   INFORMASI SALDO ANDA\n"
                + "\t      " + date1
                + "\n\n BANK \t\t: " + nameOfBank
                + "\n NO REKENING \t: " + customerId
                + "\n NAMA \t\t: " + name.toUpperCase()
                + "\n SALDO \t\t: " + balance
                + "\n\n\t  HARAP JAGA KERAHASIAAN"
                + "\n\t\t PIN ANDA");
        choiceId = 0;
    }

    public int getPin() {
        return pin;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public double getChoiceBalance() {
        return choiceBalance;
    }

    public long getChoiceId() {
        return choiceId;
    }

    public static String inputStringLine() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}