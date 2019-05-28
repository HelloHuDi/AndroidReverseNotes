package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tencentmap.mapsdk.maps.a.jk.a;

public class ld implements le {
    private Context a;
    private TextView b = new TextView(this.a);
    private a c;

    public ld(Context context) {
        AppMethodBeat.i(100325);
        this.a = context;
        AppMethodBeat.o(100325);
    }

    public void a(int i, int i2) {
    }

    public void a() {
    }

    public boolean a(ViewGroup viewGroup) {
        AppMethodBeat.i(100326);
        if (viewGroup == null || this.b == null) {
            AppMethodBeat.o(100326);
            return false;
        }
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.b.setLayoutParams(layoutParams);
        int measuredWidth = viewGroup.getMeasuredWidth();
        int measuredHeight = viewGroup.getMeasuredHeight();
        Bitmap b = b();
        viewGroup.addView(this.b);
        if (this.c != null) {
            this.c.a(b, measuredWidth, measuredHeight);
        }
        AppMethodBeat.o(100326);
        return true;
    }

    private Bitmap b() {
        AppMethodBeat.i(100327);
        this.b.setTextSize(18.0f);
        this.b.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.b.setText("鉴权失败,请检查你的key");
        Bitmap a = ht.a(this.b);
        AppMethodBeat.o(100327);
        return a;
    }

    public void a(a aVar) {
        this.c = aVar;
    }
}
