package photofall.wanderlust.buckbeak;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Profile extends Fragment{
    TheMagicListGenerator adapter;
    ListView listView;
    View v;
    //this two arrays are for test purposes only
    String[] web = {
            "19:00 \n Dublin \n Grand canal docks",
            "07:00 \n Wexford \n The middle of nowhere",
            "00:00 \n Meath \n And you thought this was africa",
            "19:00 \n Dublin \n Grand canal docks",
            "07:00 \n Wexford \n The middle of nowhere",
            "00:00 \n Meath \n And you thought this was africa",
            "19:00 \n Dublin \n Grand canal docks",
            "07:00 \n Wexford \n The middle of nowhere  ",
            "00:00 \n Meath \n And you thought this was africa",
            "00:00 \n THE-END \n I feel they used a filter",
            "13:37 \n HOT HOT HOT \n HEWT HEWT HEWT HEWT",
    } ;
    Integer[] imageId = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        v =  inflater.inflate(R.layout.activity_profile, container, false);
        if(web.length%2==0)
            adapter = new TheMagicListGenerator(this.getActivity(), web, imageId,Arrays.copyOfRange(web, 0, web.length/2));
        else
            adapter = new TheMagicListGenerator(this.getActivity(), web, imageId,Arrays.copyOfRange(web, 0, (web.length/2)+1));
        listView=(ListView)v.findViewById(R.id.mainListView);
        listView.setDivider(null);
        listView.setDividerHeight(0);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Toast.makeText(v.getContext(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}
