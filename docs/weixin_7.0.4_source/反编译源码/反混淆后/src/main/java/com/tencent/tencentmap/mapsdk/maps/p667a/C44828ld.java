package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16287jk.C16288a;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ld */
public class C44828ld implements C44533le {
    /* renamed from: a */
    private Context f17583a;
    /* renamed from: b */
    private TextView f17584b = new TextView(this.f17583a);
    /* renamed from: c */
    private C16288a f17585c;

    public C44828ld(Context context) {
        AppMethodBeat.m2504i(100325);
        this.f17583a = context;
        AppMethodBeat.m2505o(100325);
    }

    /* renamed from: a */
    public void mo40422a(int i, int i2) {
    }

    /* renamed from: a */
    public void mo40698a() {
    }

    /* renamed from: a */
    public boolean mo40708a(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(100326);
        if (viewGroup == null || this.f17584b == null) {
            AppMethodBeat.m2505o(100326);
            return false;
        }
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f17584b.setLayoutParams(layoutParams);
        int measuredWidth = viewGroup.getMeasuredWidth();
        int measuredHeight = viewGroup.getMeasuredHeight();
        Bitmap b = m82003b();
        viewGroup.addView(this.f17584b);
        if (this.f17585c != null) {
            this.f17585c.mo29535a(b, measuredWidth, measuredHeight);
        }
        AppMethodBeat.m2505o(100326);
        return true;
    }

    /* renamed from: b */
    private Bitmap m82003b() {
        AppMethodBeat.m2504i(100327);
        this.f17584b.setTextSize(18.0f);
        this.f17584b.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.f17584b.setText("鉴权失败,请检查你的key");
        Bitmap a = C24388ht.m37844a(this.f17584b);
        AppMethodBeat.m2505o(100327);
        return a;
    }

    /* renamed from: a */
    public void mo72029a(C16288a c16288a) {
        this.f17585c = c16288a;
    }
}
