package photofall.wanderlust.buckbeak;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundedProfileImageView extends ImageView {

    Drawable drawable;
    Bitmap bitmap;
    Canvas c;

    public RoundedProfileImageView(Context context) {
        super(context);
    }

    public RoundedProfileImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundedProfileImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Drawable drawable = getDrawable();

        if (drawable == null) {
            return;
        }

        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }

        Bitmap b;
        if (drawable instanceof BitmapDrawable) {
            b = ((BitmapDrawable) drawable).getBitmap();
        } else {
            drawable.setBounds(0, 0, c.getWidth(), c.getHeight());
            drawable.draw(c);
            b = bitmap;
        }

        Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);

        int w = getWidth(), h = getHeight();

        Bitmap roundedBitmap = getCroppedBitmap(bitmap, h,w);
        canvas.drawBitmap(roundedBitmap, 0, 0, null);

    }

    public static Bitmap getCroppedBitmap(Bitmap bmp, int height,int width) {


        Bitmap sbmp;

        if (bmp.getWidth() != width || bmp.getHeight() != height) {
            float widthfactor = bmp.getWidth()/width;
            float heightfactor = bmp.getHeight()/height;
            sbmp = Bitmap.createScaledBitmap(bmp,
                    (int) (bmp.getWidth() / widthfactor),
                    (int) (bmp.getHeight() / heightfactor), false);
        } else {
            sbmp = bmp;
        }

        Bitmap output = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, width, height);

        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.parseColor("#BAB399"));
        RectF rectF = new RectF(0,0,(float)width,(float)height);
        canvas.drawRoundRect(rectF,100f,100f,paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(sbmp, rect, rectF, paint);

        return output;
    }
}