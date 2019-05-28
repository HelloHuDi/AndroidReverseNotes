package com.tencent.p177mm.plugin.appbrand.widget.p1235e;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.e.b */
public final class C42724b extends LinearLayout {
    public static final int jjZ = Color.parseColor("#000000");
    public static final int jka = Color.parseColor("#000000");
    private TextView gsf;

    static {
        AppMethodBeat.m2504i(51259);
        AppMethodBeat.m2505o(51259);
    }

    public C42724b(Context context) {
        super(context);
        AppMethodBeat.m2504i(51251);
        setLayoutParams(new LayoutParams(-2, -2));
        setOrientation(1);
        setGravity(17);
        this.gsf = new TextView(context);
        this.gsf.setLayoutParams(new LayoutParams(-2, -2));
        addView(this.gsf);
        AppMethodBeat.m2505o(51251);
    }

    public final void setText(String str) {
        AppMethodBeat.m2504i(51252);
        this.gsf.setText(str);
        AppMethodBeat.m2505o(51252);
    }

    public final void setTextSize(int i) {
        AppMethodBeat.m2504i(51253);
        this.gsf.setTextSize((float) i);
        AppMethodBeat.m2505o(51253);
    }

    public final void setTextColor(int i) {
        AppMethodBeat.m2504i(51254);
        this.gsf.setTextColor(i);
        AppMethodBeat.m2505o(51254);
    }

    public final void setTitlePadding(int i) {
        AppMethodBeat.m2504i(51255);
        this.gsf.setPadding(i, i, i, i);
        AppMethodBeat.m2505o(51255);
    }

    public final void setGravity(String str) {
        AppMethodBeat.m2504i(51256);
        if (str.equals("left")) {
            this.gsf.setGravity(3);
            AppMethodBeat.m2505o(51256);
        } else if (str.equals("right")) {
            this.gsf.setGravity(5);
            AppMethodBeat.m2505o(51256);
        } else {
            str.equals("center");
            this.gsf.setGravity(17);
            AppMethodBeat.m2505o(51256);
        }
    }

    /* renamed from: x */
    public final void mo68162x(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(51257);
        m75715qO(i2);
        C42723a c42723a = new C42723a();
        c42723a.borderRadius = (float) i;
        c42723a.setColor(i4);
        c42723a.setStroke(i2, i3);
        setBackgroundDrawable(c42723a);
        AppMethodBeat.m2505o(51257);
    }

    /* renamed from: qO */
    private void m75715qO(int i) {
        AppMethodBeat.m2504i(51258);
        setPadding(i, i, i, i);
        AppMethodBeat.m2505o(51258);
    }
}
