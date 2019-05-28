package com.tencent.mm.plugin.appbrand.widget.e;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends FrameLayout {
    public static final int jjZ = Color.parseColor("#000000");
    public static final int jka = Color.parseColor("#000000");
    public static final int jkk = Color.parseColor("#000000");
    private float bDv = 0.0f;
    private float bDw = 0.0f;
    private TextView jkj;
    private int jkl;
    private int jkm;
    private int jkn;
    private int jko;
    public int x = 0;
    public int y = 0;

    static {
        AppMethodBeat.i(51274);
        AppMethodBeat.o(51274);
    }

    public d(Context context) {
        super(context);
        AppMethodBeat.i(51265);
        setLayoutParams(new LayoutParams(-2, -2));
        this.jkj = new TextView(context);
        this.jkj.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.jkj);
        AppMethodBeat.o(51265);
    }

    public final void x(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(51266);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) i);
        gradientDrawable.setStroke(i2, i3);
        gradientDrawable.setColor(i4);
        this.jkj.setBackgroundDrawable(gradientDrawable);
        AppMethodBeat.o(51266);
    }

    public final void setText(String str) {
        AppMethodBeat.i(51267);
        this.jkj.setText(str);
        AppMethodBeat.o(51267);
    }

    public final void setTextSize(int i) {
        AppMethodBeat.i(51268);
        this.jkj.setTextSize((float) i);
        AppMethodBeat.o(51268);
    }

    public final void setTextColor(int i) {
        AppMethodBeat.i(51269);
        this.jkj.setTextColor(i);
        AppMethodBeat.o(51269);
    }

    public final void setTextPadding(int i) {
        AppMethodBeat.i(51270);
        this.jkj.setPadding(i, i, i, i);
        AppMethodBeat.o(51270);
    }

    public final void setGravity(String str) {
        AppMethodBeat.i(51271);
        if (str.equals("left")) {
            this.jkj.setGravity(3);
            AppMethodBeat.o(51271);
        } else if (str.equals("right")) {
            this.jkj.setGravity(5);
            AppMethodBeat.o(51271);
        } else {
            str.equals("center");
            this.jkj.setGravity(17);
            AppMethodBeat.o(51271);
        }
    }

    public final void setX(int i) {
        this.x = i;
    }

    public final void setY(int i) {
        this.y = i;
    }

    public final float getAnchorX() {
        return this.bDv;
    }

    public final float getAnchorY() {
        return this.bDw;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.i(51272);
        super.onMeasure(i, i2);
        this.jkl = getMeasuredWidth();
        this.jkm = getMeasuredHeight();
        if ((-this.jkl) < this.x && this.x < 0) {
            this.jkn = this.jkl;
            this.bDv = ((float) Math.abs(this.x)) / (((float) this.jkl) * 1.0f);
        } else if (this.x >= 0) {
            this.jkn = this.jkl + Math.abs(this.x);
            this.bDv = 0.0f;
        } else {
            this.jkn = Math.abs(this.x);
            this.bDv = 1.0f;
        }
        if ((-this.jkm) < this.y && this.y < 0) {
            this.jko = this.jkm;
            this.bDw = ((float) Math.abs(this.y)) / (((float) this.jkm) * 1.0f);
        } else if (this.y >= 0) {
            this.jko = this.jkm + Math.abs(this.y);
            this.bDw = 0.0f;
        } else {
            this.jko = Math.abs(this.y);
            this.bDw = 1.0f;
        }
        setMeasuredDimension(this.jkn, this.jko);
        AppMethodBeat.o(51272);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(51273);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getChildAt(0).getLayoutParams();
        if (this.x >= 0 && this.y >= 0) {
            layoutParams.gravity = 85;
        } else if (this.x >= 0 && this.y <= 0) {
            layoutParams.gravity = 53;
        } else if (this.x <= 0 && this.y >= 0) {
            layoutParams.gravity = 83;
        } else if (this.x <= 0 && this.y <= 0) {
            layoutParams.gravity = 51;
        }
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.o(51273);
    }
}
