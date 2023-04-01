import java.util.Scanner;

public class jogoDaVelha {
    public static void main(String[] args) {
    
        campo[][] velha = new campo[3][3];
        char simboloAtual='X';
        boolean game= true;
        String vitoria="";
        Scanner scan=new Scanner(System.in);

        iniciarJogo(velha);

        while(game){
            desenhaJogo(velha);
            vitoria= verificaVitoria(velha);
            if(!vitoria.equals("")){
                System.out.printf("Jogador %s venceu%n", vitoria);
                break;
            }
            try{
                if(verificarJogada(velha, jogar(scan, simboloAtual), simboloAtual)){
                    if(simboloAtual=='X'){
                        simboloAtual='O';
                    }else{
                        simboloAtual='X';
                    }
                }

            }catch(Exception e){
                System.out.printf("Erro");
            }
        }
        System.out.printf("Fim do jogo");
    }

    public static void desenhaJogo(campo[][] velha){
        limparTela();
        System.out.println("   0    1    2");
        System.out.printf("0   %c | %c | %c %n", velha[0][0].getSimbolo(), velha[0][1].getSimbolo(), velha[0][2].getSimbolo());
        System.out.println("   ------------");
        System.out.printf("1   %c | %c | %c %n", velha[1][0].getSimbolo(), velha[1][1].getSimbolo(), velha[1][2].getSimbolo());
        System.out.println("   ------------");
        System.out.printf("2   %c | %c | %c %n", velha[2][0].getSimbolo(), velha[2][1].getSimbolo(), velha[2][2].getSimbolo());  
    }

    public static void limparTela(){
        for(int cont=0; cont<200; cont++){
            System.out.println("");
        }
    }

    public static int[] jogar(Scanner scan, char sa){
        int p[]= new int[2];
        System.out.printf("%s %c%n", "Quem Joga: ", sa);
        System.out.print("Informe a linha: ");
        p[0]= scan.nextInt();
        System.out.print("Informe a coluna: ");
        p[1]= scan.nextInt();
        return p;
    }

    public static boolean verificarJogada(campo[][] velha, int p[], char simboloAtual){
        if(velha[p[0]][p[1]].getSimbolo()== ' '){
            velha[p[0]][p[1]].setSimbolo(simboloAtual);
            return true;
        }else{
            return false;
        }
    }

    public static void iniciarJogo(campo[][] velha){
        for(int l=0;l<3;l++){
            for(int c=0;c<3;c++){
                velha[l][c]= new campo();
            }
        }
    }

    public static String verificaVitoria(campo[][] velha){
        for(int i=0;i<3;i++){
            if((velha[i][0].getSimbolo()=='X' && velha[i][1].getSimbolo()=='X' && velha[i][2].getSimbolo()=='X')||(velha[i][0].getSimbolo()=='O' && velha[i][1].getSimbolo()=='O' && velha[i][2].getSimbolo()=='O')){
                return String.valueOf(velha[i][0].getSimbolo());
            }
        }
        for(int i=0;i<3;i++){
            if((velha[0][i].getSimbolo()=='X' && velha[1][i].getSimbolo()=='X' && velha[2][i].getSimbolo()=='X')||(velha[0][i].getSimbolo()=='O' && velha[1][i].getSimbolo()=='O' && velha[2][i].getSimbolo()=='O')){
                return String.valueOf(velha[0][i].getSimbolo());
            }
        }
        if((velha[0][0].getSimbolo()=='X' && velha[1][1].getSimbolo()=='X' && velha[2][2].getSimbolo()=='X')||(velha[0][2].getSimbolo()=='X' && velha[1][1].getSimbolo()=='X' && velha[2][0].getSimbolo()=='X')){
            return String.valueOf(velha[0][0].getSimbolo());
        }
        return "";
    }
    
    

}
