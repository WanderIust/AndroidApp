package photofall.wanderlust.buckbeak;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TheMagicListGenerator<T> extends ArrayAdapter<String>{

//##################DO NOT TOUCH THE MAGIC MAN, DO NOT TRY UNDERSTAND, DO NOT LOOK##################
    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;

    public TheMagicListGenerator(Activity context,String[] web, Integer[] imageId,String[] test) {
        super(context, R.layout.list_item, test);
        this.context = context;
        this.web = web;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        position*=2;
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_item, null, false);
        if(imageId.length > position) {
            //gettings the image views
            RoundedProfileImageView imageView = (RoundedProfileImageView)rowView.findViewById(R.id.listImageLeft);
            RoundedProfileImageView imageView1 = (RoundedProfileImageView)rowView.findViewById(R.id.listImageRight);
            //gettings the text views
            TextView txtTitle = (TextView) rowView.findViewById(R.id.listTxtLeft);
            TextView txtTitle1 = (TextView) rowView.findViewById(R.id.listTxtRight);
            //setting left view
            txtTitle.setText(web[position]);
            Drawable drawable = context.getResources().getDrawable(imageId[position]);
            imageView.setImageDrawable(drawable);
            //setting right view
             position+= 1;
            if (imageId.length > position) {
                txtTitle1.setText(web[position]);
                drawable = context.getResources().getDrawable(imageId[position]);
                imageView1.setImageDrawable(drawable);
            }
            else{
                txtTitle1.setVisibility(View.INVISIBLE);
                imageView1.setVisibility(View.INVISIBLE);
            }
            return rowView;
        }
        //Fin.
        return rowView;
    }
}
