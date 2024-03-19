import java.util.Scanner;

public class Main {

    public static void ogrenciListele (int ogrenciSayisi, int[] ogrenciID, String[] ogrenciAd, int[] vizeSinav, int[] finalSinav) {
        System.out.println("\n\tÖğrenci Bilgileri:\n");
        System.out.println("No\t\t\t\tAd\t\t\t\t\tVize Notu\t\tFinal Notu");
        for(int i=0; i<ogrenciSayisi; i++) {
            System.out.printf("%-16d%-24s%-16d%-16d\n", ogrenciID[i], ogrenciAd[i], vizeSinav[i], finalSinav[i]);
        }
        System.out.println();
        System.out.println();
    }
    public static float[] donemSonuNotlari (int ogrenciSayisi, int[] ogrenciID, String[] ogrenciAd, int[] vizeSinav, int[] finalSinav){
        float[] donemSonu = new float[ogrenciSayisi];
        for(int i=0; i<ogrenciSayisi; i++){
            donemSonu[i] = (float) ((vizeSinav[i]*0.4) + (finalSinav[i]*0.6));
        }
        return donemSonu;
    }
    public static void donemSonuListele (int ogrenciSayisi, int[] ogrenciID, String[] ogrenciAd, float[] donemSonuNotlari){
        System.out.println("\n\tDönem Sonu Notları:\n");
        System.out.println("No\t\t\t\tAd\t\t\t\t\tDönem Sonu Notu");
        for(int i=0; i<ogrenciSayisi; i++){
            System.out.printf("%-16d%-24s%-16f\n", ogrenciID[i], ogrenciAd[i], donemSonuNotlari[i]);
        }
    }

    public static void finaldenDusukAlanlar (int ogrenciSayisi, int[] ogrenciID, String[] ogrenciAd, int[] finalSinav){
        System.out.println("\n\tFinal Notu 60'ın Altında Olan Öğrenciler:");
        System.out.println("No\t\t\t\tAd\t\t\t\t\tFinal Notu");
        for(int i=0; i<ogrenciSayisi; i++){
            if(finalSinav[i]<60){
                System.out.printf("%-16d%-24s%-16d\n", ogrenciID[i], ogrenciAd[i], finalSinav[i]);
            }
        }
    }

    public static void yuksekDonemSonlari (int ogrenciSayisi, int[] ogrenciID, String[] ogrenciAd, float[] donemSonuNotlari){
        float sinifNotlari = 0;
        for (int i = 0; i < ogrenciSayisi; i++) {
            sinifNotlari += donemSonuNotlari[i];
        }
        float sinifOrtalamasi = sinifNotlari/ogrenciSayisi;
        System.out.println("\nSınıf Ortalaması: " + sinifOrtalamasi);
        System.out.println("\nNo\t\t\t\tAd\t\t\t\t\tDönem Sonu Notu");
        for(int i=0; i<ogrenciSayisi; i++){
            if(donemSonuNotlari[i]>=sinifOrtalamasi){
                System.out.printf("%-16d%-24s%-16f\n", ogrenciID[i], ogrenciAd[i], donemSonuNotlari[i]);
            }
        }
    }

    public static void minVize(int[] vizeSinav){
        int minimumVize = vizeSinav[0];
        for(int i=0; i<vizeSinav.length; i++){
            if (vizeSinav[i]<minimumVize)
                minimumVize=vizeSinav[i];
        }
        System.out.println("\nMinimum Vize Notu: " + minimumVize);
    }

    public static void maksFinal(int[] finalSinav){
        int maksimumFinal = 0;
        for(int i=0; i<finalSinav.length; i++){
            if (finalSinav[i]>maksimumFinal)
                maksimumFinal=finalSinav[i];
        }
        System.out.println("\nMaksimum Final Notu: " + maksimumFinal);
    }

    public static void main(String[] args) {
        System.out.println("Hoş geldiniz...");
        System.out.print("Sınıftaki öğrenci sayısını girin: ");
        Scanner scanner = new Scanner(System.in);
        int ogrenciSayisi = scanner.nextInt();

        int[] ogrenciID = new int[ogrenciSayisi];
        String[] ogrenciAd = new String[ogrenciSayisi];
        int[] vizeSinav = new int[ogrenciSayisi];
        int[] finalSinav = new int[ogrenciSayisi];

//        for(int i = 0; i < ogrenciSayisi; i++){
//            System.out.print("\n"+ (i+1)+"." + " öğrencinin numarasını girin: ");
//            ogrenciID[i] = scanner.nextInt();
//            System.out.print((i+1)+"." + " öğrencinin adını girin: ");
//            scanner.nextLine();
//            ogrenciAd[i] = scanner.nextLine();
//            System.out.print((i+1)+"." + " öğrencinin vize notunu girin: ");
//            vizeSinav[i] = scanner.nextInt();
//            System.out.print((i+1)+"." + " öğrencinin final notunu girin: ");
//            finalSinav[i] = scanner.nextInt();
//        }
        int choice;
        do{
            System.out.println("\n-----------------------------------------------------");
            System.out.println("1. Öğrenci Bilgilerini Ekleme");
            System.out.println("2. Öğrenci Bilgilerini Listele");
            System.out.println("3. Dönem Sonu Notları Listele");
            System.out.println("4. 60'ın Altında Final Notu Olanları Listele");
            System.out.println("5. Dönem Sonu Notu Ortalamadan Yüksek Olan Öğrenciler");
            System.out.println("6. Minimum Vize Notu");
            System.out.println("7. Maksimum Final Notu");
            System.out.println("0. Çıkış");
            System.out.println("-----------------------------------------------------");
            System.out.print("Seçiminizi girin: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    for(int i = 0; i < ogrenciSayisi; i++){
                        System.out.print("\n"+ (i+1)+"." + " öğrencinin numarasını girin: ");
                        ogrenciID[i] = scanner.nextInt();
                        System.out.print((i+1)+"." + " öğrencinin adını girin: ");
                        scanner.nextLine();
                        ogrenciAd[i] = scanner.nextLine();
                        git:
                        System.out.print((i+1)+"." + " öğrencinin vize notunu girin: ");
                        vizeSinav[i] = scanner.nextInt();
//                        if(0>vizeSinav[i] || vizeSinav[i]>100){
//                            System.out.println("Geçerli bir not girin!");
//                        }
                        System.out.print((i+1)+"." + " öğrencinin final notunu girin: ");
                        finalSinav[i] = scanner.nextInt();
                    }
                    break;
                case 2:
                    ogrenciListele(ogrenciSayisi, ogrenciID, ogrenciAd, vizeSinav, finalSinav);
                    break;
                case 3:
                    donemSonuListele(ogrenciSayisi, ogrenciID, ogrenciAd, donemSonuNotlari(ogrenciSayisi, ogrenciID, ogrenciAd, vizeSinav, finalSinav));
                    break;
                case 4:
                    finaldenDusukAlanlar(ogrenciSayisi, ogrenciID, ogrenciAd, finalSinav);
                    break;
                case 5:
                    yuksekDonemSonlari(ogrenciSayisi, ogrenciID, ogrenciAd, donemSonuNotlari(ogrenciSayisi, ogrenciID, ogrenciAd, vizeSinav, finalSinav));
                    break;
                case 6:
                    minVize(vizeSinav);
                    break;
                case 7:
                    maksFinal(finalSinav);
                    break;
                case 0:
                    System.out.println("Çıkış Yapılıyor...");
                    break;
                default:
                    System.out.println("Geçerli bir seçim yapınız!");
            }
        }while(choice!=0);
    }
}