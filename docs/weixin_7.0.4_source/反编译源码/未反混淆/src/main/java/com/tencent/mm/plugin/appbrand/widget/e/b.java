package com.tencent.mm.plugin.appbrand.widget.e;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends LinearLayout {
    public static final int jjZ = Color.parseColor("#000000");
    public static final int jka = Color.parseColor("#000000");
    private TextView gsf;

    static {
        AppMethodBeat.i(51259);
        AppMethodBeat.o(51259);
    }

    public b(Context context) {
        super(context);
        AppMethodBeat.i(51251);
        setLayoutParams(new LayoutParams(-2, -2));
        setOrientation(1);
        setGravity(17);
        this.gsf = new TextView(context);
        this.gsf.setLayoutParams(new LayoutParams(-2, -2));
        addView(this.gsf);
        AppMethodBeat.o(51251);
    }

    public final void setText(String str) {
        AppMethodBeat.i(51252);
        this.gsf.setText(str);
        AppMethodBeat.o(51252);
    }

    public final void setTextSize(int i) {
        AppMethodBeat.i(51253);
        this.gsf.setTextSize((float) i);
        AppMethodBeat.o(51253);
    }

    public final void setTextColor(int i) {
        AppMethodBeat.i(51254);
        this.gsf.setTextColor(i);
        AppMethodBeat.o(51254);
    }

    public final void setTitlePadding(int i) {
        AppMethodBeat.i(51255);
        this.gsf.setPadding(i, i, i, i);
        AppMethodBeat.o(51255);
    }

    public final void setGravity(String str) {
        AppMethodBeat.i(51256);
        if (str.equals("left")) {
            this.gsf.setGravity(3);
            AppMethodBeat.o(51256);
        } else if (str.equals("right")) {
            this.gsf.setGravity(5);
            AppMethodBeat.o(51256);
        } else {
            str.equals("center");
            this.gsf.setGravity(17);
            AppMethodBeat.o(51256);
        }
    }

    public final void x(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(51257);
        qO(i2);
        a aVar = new a();
        aVar.borderRadius = (float) i;
        aVar.setColor(i4);
        aVar.setStroke(i2, i3);
        setBackgroundDrawable(aVar);
        AppMethodBeat.o(51257);
    }

    private void qO(int i) {
        AppMethodBeat.i(51258);
        setPadding(i, i, i, i);
        AppMethodBeat.o(51258);
    }
}
