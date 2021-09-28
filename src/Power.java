import java.util.ArrayList;
import java.util.List;

public class Power {

    public Power(){
        double[] baseInputs = new double[]{1.2, 0.89, 1.7, 2};
        int[] powerInputs = new int[]{11, 29, 8, 19};

        for (int i=0; i<baseInputs.length; i++){
            Power1(baseInputs[i], powerInputs[i]);
        }
    }

    double Power1(double x, int n){
        double result = 1;
        for(int i=0; i<n; i++){
            result *= x;
        }
        return result;
    }
}
