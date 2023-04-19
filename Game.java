package a2048;
import java.util.Random;
public class Game {
    private int[][] arr;
    public Game() {
        arr=new int[6][6];
        for(int i=0;i<6;i++) {
            for(int j=0;j<6;j++) {
                arr[i][j]=-1;
            }
        }
        for(int i=1;i<5;i++) {
            for(int j=1;j<5;j++) {
                arr[i][j]=0;
            }
        }
        while(true) {
            Random ran = new Random();
            int a=ran.nextInt(4)+1;
            int b=ran.nextInt(4)+1;
            int c=ran.nextInt(2)+1;
            if(arr[a][b]==0) {
                arr[a][b]=2*c;
                break;
            }
        }
        while(true) {
            Random ran = new Random();
            int a=ran.nextInt(4)+1;
            int b=ran.nextInt(4)+1;
            int c=ran.nextInt(2)+1;
            if(arr[a][b]==0) {
                arr[a][b]=2*c;
                break;
            }
        }
    }
    public void getnewindex() {
        while(true) {
            Random ran = new Random();
            int a=ran.nextInt(4)+1;
            int b=ran.nextInt(4)+1;
            int c=ran.nextInt(2)+1;
            if(arr[a][b]==0) {
                arr[a][b]=2*c;
                break;
            }
        }
    }
    public int checklose() {
        int jud=0;
        for(int i=1;i<5;i++) {
            for(int j=1;j<5;j++) {
                if(arr[i][j]==arr[i+1][j]) {
                    jud=1;
                }
                else if(arr[i][j]==arr[i-1][j]) {
                    jud=1;
                }
                else if(arr[i][j]==arr[i][j+1]) {
                    jud=1;
                }
                else if(arr[i][j]==arr[i][j-1]) {
                    jud=1;
                }
            }
        }
        return jud;//如果jud是0 gameover,如果jud是1 還沒輸
    }
    public void right() {
        for(int i=1;i<5;i++) {
            for(int j=4;j>0;j--) {
                if(arr[i][j]!=0) {
                    for(int k=j-1;k>0;k--) {
                        if(arr[i][k]!=0) {
                            if(arr[i][k]!=arr[i][j]) {
                                break;
                            }
                            else {
                                arr[i][k]=0;
                                arr[i][j]*=2;
                                break;
                            }
                        }
                    }
                }
            }
            for(int j=4;j>0;j--) {
                if(arr[i][j]==0) {
                    for(int k=j-1;k>0;k--) {
                        if(arr[i][k]!=0) {
                            arr[i][j]=arr[i][k];
                            arr[i][k]=0;
                            break;
                        }
                    }
                }
            }
        }
    }
    public void left() {
        for(int i=1;i<5;i++) {
            for(int j=1;j<5;j++) {
                if(arr[i][j]!=0) {
                    for(int k=j+1;k<5;k++) {
                        if(arr[i][k]!=0) {
                            if(arr[i][k]!=arr[i][j]) {
                                break;
                            }
                            else {
                                arr[i][k]=0;
                                arr[i][j]*=2;
                                break;
                            }
                        }
                    }
                }
            }
            for(int j=1;j<5;j++) {
                if(arr[i][j]==0) {
                    for(int k=j+1;k<5;k++) {
                        if(arr[i][k]!=0) {
                            arr[i][j]=arr[i][k];
                            arr[i][k]=0;
                            break;
                        }
                    }
                }
            }
        }
    }
    public void up() {
        for(int j=1;j<5;j++) {
            for(int i=1;i<5;i++) {
                if(arr[i][j]!=0) {
                    for(int k=i+1;k<5;k++) {
                        if(arr[k][j]!=0) {
                            if(arr[k][j]!=arr[i][j]) {
                                break;
                            }
                            else {
                                arr[k][j]=0;
                                arr[i][j]*=2;
                                break;
                            }
                        }
                    }
                }
            }
            for(int i=1;i<5;i++) {
                if(arr[i][j]==0) {
                    for(int k=i+1;k<5;k++) {
                        if(arr[k][j]!=0) {
                            arr[i][j]=arr[k][j];
                            arr[k][j]=0;
                            break;
                        }
                    }
                }
            }
        }
    }
    public void down() {
        for(int j=1;j<5;j++) {
            for(int i=4;i>0;i--) {
                if(arr[i][j]!=0) {
                    for(int k=i-1;k>0;k--) {
                        if(arr[k][j]!=0) {
                            if(arr[k][j]!=arr[i][j]) {
                                break;
                            }
                            else {
                                arr[k][j]=0;
                                arr[i][j]*=2;
                                break;
                            }
                        }
                    }
                }
            }
            for(int i=4;i>0;i--) {
                if(arr[i][j]==0) {
                    for(int k=i-1;k>0;k--) {
                        if(arr[k][j]!=0) {
                            arr[i][j]=arr[k][j];
                            arr[k][j]=0;
                            break;
                        }
                    }
                }
            }
        }
    }
    public int getmax() {
        int max=0;
        for(int i=1;i<5;i++) {
            for(int j=1;j<5;j++) {
                if(arr[i][j]>max) {
                    max=arr[i][j];
                }
            }
        }
        return max;
    }
    public int numamount() {
        int cnt=0;
        for(int i=1;i<5;i++) {
            for(int j=1;j<5;j++) {
                if(arr[i][j]!=0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void copy(Game x) {
        for(int i=1;i<5;i++) {
            for(int j=1;j<5;j++) {
                arr[i][j]=x.arr[i][j];
            }
        }
    }
    public int compare(Game x) {
        int jud=0;
        for(int i=1;i<5;i++) {
            for(int j=1;j<5;j++) {
                if(arr[i][j]!=x.arr[i][j]) {
                    jud=1;
                }
            }
        }
        return jud;//如果return 1代表有更動 0代表沒更動
    }
    public int getarr(int x,int y){
        return arr[x][y];
    }
    public void restart(){
        for(int i=1;i<5;i++) {
            for(int j=1;j<5;j++) {
                arr[i][j]=0;
            }
        }
        while(true) {
            Random ran = new Random();
            int a=ran.nextInt(4)+1;
            int b=ran.nextInt(4)+1;
            int c=ran.nextInt(2)+1;
            if(arr[a][b]==0) {
                arr[a][b]=2*c;
                break;
            }
        }
        while(true) {
            Random ran = new Random();
            int a=ran.nextInt(4)+1;
            int b=ran.nextInt(4)+1;
            int c=ran.nextInt(2)+1;
            if(arr[a][b]==0) {
                arr[a][b]=2*c;
                break;
            }
        }
    }
}