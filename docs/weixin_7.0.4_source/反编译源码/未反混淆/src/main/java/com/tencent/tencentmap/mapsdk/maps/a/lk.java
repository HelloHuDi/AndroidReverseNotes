package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class lk extends ImageView {
    public lk(Context context) {
        super(context);
        AppMethodBeat.i(100428);
        setClickable(true);
        AppMethodBeat.o(100428);
    }

    public void a(Context context, Bitmap bitmap, Bitmap bitmap2) {
        AppMethodBeat.i(100429);
        StateListDrawable stateListDrawable = new StateListDrawable();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, new BitmapDrawable(context.getResources(), bitmap2));
        stateListDrawable.addState(View.ENABLED_STATE_SET, bitmapDrawable);
        setBackgroundDrawable(stateListDrawable);
        AppMethodBeat.o(100429);
    }

    public void a() {
        AppMethodBeat.i(100430);
        setClickable(false);
        Drawable background = getBackground();
        if (background != null) {
            background.setCallback(null);
        }
        setBackgroundDrawable(null);
        AppMethodBeat.o(100430);
    }
}
