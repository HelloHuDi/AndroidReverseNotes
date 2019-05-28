package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements d {
    private static int iaK;
    private static int iaL;
    private int MW = -1;
    private int acq;
    private int acy;
    private StaticLayout eNO;
    private SpannableString iaM;
    private int iaN;
    private int iaO;
    private int iaP = -1;
    private int iaQ;
    private int iaR;
    private float iaS;
    private Context mContext;

    public a(Context context, SpannableString spannableString, int i, int i2) {
        AppMethodBeat.i(126593);
        this.mContext = context;
        this.iaM = spannableString;
        this.iaQ = b.E(this.mContext, b.iaT);
        this.MW = i;
        this.iaS = 3.0f;
        this.iaR = i2;
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(this.MW);
        textPaint.setTextSize((float) this.iaQ);
        FontMetrics fontMetrics = textPaint.getFontMetrics();
        this.acy = ((int) Math.ceil((double) (fontMetrics.descent - fontMetrics.top))) + 2;
        this.eNO = new StaticLayout(this.iaM, textPaint, ((int) Layout.getDesiredWidth(this.iaM, 0, this.iaM.length(), textPaint)) + 1, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.acq = this.eNO.getWidth();
        AppMethodBeat.o(126593);
    }

    public final void b(Canvas canvas, boolean z) {
        AppMethodBeat.i(126594);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (!(width == iaK && height == iaL)) {
            iaK = width;
            iaL = height;
        }
        canvas.save();
        canvas.translate((float) this.iaN, (float) this.iaO);
        this.eNO.draw(canvas);
        canvas.restore();
        if (!z) {
            this.iaN = (int) (((float) this.iaN) - (((float) b.aGd()) * this.iaS));
        }
        AppMethodBeat.o(126594);
    }

    public final void dg(int i, int i2) {
        this.iaN = i;
        this.iaO = i2;
    }

    public final float aGa() {
        return this.iaS;
    }

    public final boolean aGb() {
        AppMethodBeat.i(126595);
        if (this.iaN >= 0 || Math.abs(this.iaN) <= this.acq) {
            AppMethodBeat.o(126595);
            return false;
        }
        AppMethodBeat.o(126595);
        return true;
    }

    public final int getWidth() {
        return this.acq;
    }

    public final int getCurrX() {
        return this.iaN;
    }

    public final int aGc() {
        return this.iaR;
    }

    public final boolean oB(int i) {
        if (i >= this.iaR && i - this.iaR <= b.iaU) {
            return true;
        }
        return false;
    }

    public final boolean oC(int i) {
        return i - this.iaR > b.iaU;
    }

    public final boolean a(d dVar) {
        AppMethodBeat.i(126596);
        if (dVar.getWidth() + dVar.getCurrX() > iaK) {
            AppMethodBeat.o(126596);
            return true;
        }
        if (this.iaP < 0) {
            this.iaP = b.E(this.mContext, 20);
        }
        if (dVar.aGa() >= this.iaS) {
            if (dVar.aGa() != this.iaS || ((float) (iaK - (dVar.getCurrX() + dVar.getWidth()))) >= ((float) this.iaP)) {
                AppMethodBeat.o(126596);
                return false;
            }
            AppMethodBeat.o(126596);
            return true;
        } else if (((double) (((((float) (dVar.getCurrX() + dVar.getWidth())) / (dVar.aGa() * ((float) b.aGd()))) * this.iaS) * ((float) b.aGd()))) > ((double) iaK) - (((double) this.iaP) * 1.5d)) {
            AppMethodBeat.o(126596);
            return true;
        } else {
            AppMethodBeat.o(126596);
            return false;
        }
    }
}
