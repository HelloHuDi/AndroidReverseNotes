package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lk */
public class C31078lk extends ImageView {
    public C31078lk(Context context) {
        super(context);
        AppMethodBeat.m2504i(100428);
        setClickable(true);
        AppMethodBeat.m2505o(100428);
    }

    /* renamed from: a */
    public void mo50531a(Context context, Bitmap bitmap, Bitmap bitmap2) {
        AppMethodBeat.m2504i(100429);
        StateListDrawable stateListDrawable = new StateListDrawable();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, new BitmapDrawable(context.getResources(), bitmap2));
        stateListDrawable.addState(View.ENABLED_STATE_SET, bitmapDrawable);
        setBackgroundDrawable(stateListDrawable);
        AppMethodBeat.m2505o(100429);
    }

    /* renamed from: a */
    public void mo50530a() {
        AppMethodBeat.m2504i(100430);
        setClickable(false);
        Drawable background = getBackground();
        if (background != null) {
            background.setCallback(null);
        }
        setBackgroundDrawable(null);
        AppMethodBeat.m2505o(100430);
    }
}
