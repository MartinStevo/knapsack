import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/data.txt")));
        String line;

        int[][] data = new int[1000][4];

        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] arry = line.split(",");
            for (int j = 0; j < arry.length; j++) {
                data[i][j] = Integer.parseInt(arry[j]);
            }
            i++;
        }

        int[][] finalArray = new int[data.length + 1][2001];

        for(i = 1; i < finalArray.length; i++) {
            for(int j = 1; j < finalArray[i].length; j++) {

                int akt_weight_first = data[i - 1][1];
                int akt_weight_second = data[i - 1][3];

                finalArray[i][j] = finalArray[i - 1][j];

                if(j >= akt_weight_first){
                    int temp_weight = finalArray[i - 1][j - akt_weight_first] + data[i - 1][0];
                    if(temp_weight > finalArray[i][j])
                        finalArray[i][j] = temp_weight;
                }
                if(j >= akt_weight_second){
                    int temp_weight = finalArray[i - 1][j - akt_weight_second] + data[i - 1][2];
                    if(temp_weight > finalArray[i][j])
                        finalArray[i][j] = temp_weight;
                }
            }
        }
        System.out.println(finalArray[1000][2000]);
    }
}