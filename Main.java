import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int t;
        Scanner s = new Scanner(System.in);
        t = Integer.parseInt(s.nextLine());
        int[] res = new int[t];
        for(int i = 0; i < t; i ++)
        {
            String RCD = s.nextLine();
            String[] x = RCD.split(" ");
            int R = Integer.parseInt(x[0]);
            int C = Integer.parseInt(x[1]);
            int D = Integer.parseInt(x[2]);
            RCD = s.nextLine();
            x = RCD.split(" ");
            int Nr = Integer.parseInt(x[0]);
            int Nc = Integer.parseInt(x[1]);
            int Nd = Integer.parseInt(x[2]);
            RCD = s.nextLine();
            x = RCD.split(" ");
            int Pr = Integer.parseInt(x[0]);
            int Pc = Integer.parseInt(x[1]);
            int Pd = Integer.parseInt(x[2]);
            int N = Integer.parseInt(s.nextLine());
            Boolean terminate = false;
            while ((!terminate)) {
                char flag = 'X';
                int min = (int)Double.POSITIVE_INFINITY;
                int tempR = Nr / R;
                int tempC = Nc / C;
                int tempD = Nd / D;
                if (tempR < min) {
                    min = tempR;
                    flag = 'R';
                }
                if (tempC <= min) {
                    min = tempC;
                    flag = 'C';
                }
                if (tempD <= min) {
                    min = tempD;
                    flag = 'D';
                }
                switch(flag)
                {
                    case 'R':
                        if(N < (R*Pr))
                        {
                            terminate = true;
                            res[i] = min;
                        }
                        else
                        {
                            int reqR = R - (Nr%R);
                            N = N - (reqR*Pr);
                            Nr = Nr + reqR;
                        }
                        break;
                    case 'D':
                        if(N < (D*Pd))
                        {
                            terminate = true;
                            res[i] = min;
                        }
                        else
                        {
                            int reqD = D - (Nd%D);
                            N = N - (reqD*Pd);
                            Nd = Nd + reqD;
                        }
                        break;
                    case 'C':
                        if(N < (C*Pc))
                        {
                            terminate = true;
                            res[i] = min;
                        }
                        else
                        {
                            int reqC = C - (Nc%C);
                            N = N - (reqC*Pc);
                            Nc = Nc + reqC;
                        }
                        break;
                }
            }
        }
        for(int i = 0; i < res.length; i ++)
        {
            System.out.println(res[i]);
        }
    }
}