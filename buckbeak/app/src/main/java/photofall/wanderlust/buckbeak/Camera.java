package photofall.wanderlust.buckbeak;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Camera extends Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View camera = inflater.inflate(R.layout.activity_camera, container, false);
        return camera;
    }
}