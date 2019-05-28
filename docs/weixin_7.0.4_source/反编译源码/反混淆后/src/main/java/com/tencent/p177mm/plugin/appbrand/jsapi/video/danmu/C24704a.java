package com.tencent.p177mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a */
public final class C24704a implements C19516d {
    private static int iaK;
    private static int iaL;
    /* renamed from: MW */
    private int f4953MW = -1;
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

    public C24704a(Context context, SpannableString spannableString, int i, int i2) {
        AppMethodBeat.m2504i(126593);
        this.mContext = context;
        this.iaM = spannableString;
        this.iaQ = C19514b.m30235E(this.mContext, C19514b.iaT);
        this.f4953MW = i;
        this.iaS = 3.0f;
        this.iaR = i2;
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(this.f4953MW);
        textPaint.setTextSize((float) this.iaQ);
        FontMetrics fontMetrics = textPaint.getFontMetrics();
        this.acy = ((int) Math.ceil((double) (fontMetrics.descent - fontMetrics.top))) + 2;
        this.eNO = new StaticLayout(this.iaM, textPaint, ((int) Layout.getDesiredWidth(this.iaM, 0, this.iaM.length(), textPaint)) + 1, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.acq = this.eNO.getWidth();
        AppMethodBeat.m2505o(126593);
    }

    /* renamed from: b */
    public final void mo34706b(Canvas canvas, boolean z) {
        AppMethodBeat.m2504i(126594);
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
            this.iaN = (int) (((float) this.iaN) - (((float) C19514b.aGd()) * this.iaS));
        }
        AppMethodBeat.m2505o(126594);
    }

    /* renamed from: dg */
    public final void mo34707dg(int i, int i2) {
        this.iaN = i;
        this.iaO = i2;
    }

    public final float aGa() {
        return this.iaS;
    }

    public final boolean aGb() {
        AppMethodBeat.m2504i(126595);
        if (this.iaN >= 0 || Math.abs(this.iaN) <= this.acq) {
            AppMethodBeat.m2505o(126595);
            return false;
        }
        AppMethodBeat.m2505o(126595);
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

    /* renamed from: oB */
    public final boolean mo34710oB(int i) {
        if (i >= this.iaR && i - this.iaR <= C19514b.iaU) {
            return true;
        }
        return false;
    }

    /* renamed from: oC */
    public final boolean mo34711oC(int i) {
        return i - this.iaR > C19514b.iaU;
    }

    /* renamed from: a */
    public final boolean mo34702a(C19516d c19516d) {
        AppMethodBeat.m2504i(126596);
        if (c19516d.getWidth() + c19516d.getCurrX() > iaK) {
            AppMethodBeat.m2505o(126596);
            return true;
        }
        if (this.iaP < 0) {
            this.iaP = C19514b.m30235E(this.mContext, 20);
        }
        if (c19516d.aGa() >= this.iaS) {
            if (c19516d.aGa() != this.iaS || ((float) (iaK - (c19516d.getCurrX() + c19516d.getWidth()))) >= ((float) this.iaP)) {
                AppMethodBeat.m2505o(126596);
                return false;
            }
            AppMethodBeat.m2505o(126596);
            return true;
        } else if (((double) (((((float) (c19516d.getCurrX() + c19516d.getWidth())) / (c19516d.aGa() * ((float) C19514b.aGd()))) * this.iaS) * ((float) C19514b.aGd()))) > ((double) iaK) - (((double) this.iaP) * 1.5d)) {
            AppMethodBeat.m2505o(126596);
            return true;
        } else {
            AppMethodBeat.m2505o(126596);
            return false;
        }
    }
}
