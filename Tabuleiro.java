import java.util.Scanner;

public class Tabuleiro {
    private String[][] mapa = new String[3][3];
    private Scanner in = new Scanner(System.in);

    public void jogar(){
        int jogador = 1;
        while(true){
            System.out.printf("Vertical: ");
            int x = in.nextInt();
            System.out.printf("Horizontal: ");
            int y = in.nextInt();
            if(validaJogada(x, y)){
                mapa[x-1][y-1] = jogador % 2 == 0 ? "O" : "X";
                jogador++;
            }
            mostraTabuleiro();
            if(validaGanhador()){
                System.out.println("Ganhou!!!!");
                break;
            }
        }
    }

    public boolean validaJogada(int x, int y){
        if(x > 3 || x < 1 || y > 3 || y < 1){
            System.out.println("Endereço inválido");
            return false;
        }
        else if(mapa[x-1][y-1] != null){
            System.out.println("Endereço em uso");
            return false;
        }
        else{
            return true;
        }
    }

    public boolean validaGanhador(){
        //Horizontal
        int contador = 0;
        for(int x = 0;x < 3;x++){
            for(int y = 0;y < 3;y++){
                if(mapa[x][y] == "X"){
                    contador++;
                }
                if(mapa[x][y] == "O"){
                    contador += 10;
                }
            }
            if(contador == 3 || contador == 30){
                return true;
            }
            contador = 0;
        }

        //Vertical
        for(int x = 0;x < 3;x++){
            for(int y = 0;y < 3;y++){
                if(mapa[y][x] == "X"){
                    contador++;
                }
                if(mapa[y][x] == "O"){
                    contador += 10;
                }
            }
            if(contador == 3 || contador == 30){
                return true;
            }
            contador = 0;
        }

        //Diagonal
        for(int x = 0;x < 3;x++){
            if(mapa[x][x] == "X"){
                contador++;
            }
            if(mapa[x][x] == "O"){
                contador += 10;
            }
        }
        if(contador == 3 || contador == 30){
            return true;
        }
        contador = 0;

        for(int x = 2;x >= 0;x--){
            if(mapa[x][2-x] == "X"){
                contador++;
            }
            if(mapa[x][2-x] == "O"){
                contador += 10;
            }
        }
        if(contador == 3 || contador == 30){
            return true;
        }
        return false;
    }

    public void mostraTabuleiro(){
        for(int x = 0;x < 3;x++){
            for(int y = 0;y < 3;y++){
                System.out.print(mapa[x][y] == null ? " |" : mapa[x][y] + "|");
            }
            System.out.println();
        }
    }
}
