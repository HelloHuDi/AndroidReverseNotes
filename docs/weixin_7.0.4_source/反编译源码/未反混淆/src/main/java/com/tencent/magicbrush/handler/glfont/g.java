package com.tencent.magicbrush.handler.glfont;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class g {
    private List<j> bTb = new ArrayList();
    private f bTf;
    private d bTg;
    private Canvas bTh;
    Paint bTi;
    private char[] bTj = new char[1];
    private Rect bTk = new Rect();
    private Rect bTl = new Rect();
    FontMetrics bTm = new FontMetrics();

    g(d dVar, f fVar) {
        AppMethodBeat.i(115931);
        this.bTg = dVar;
        this.bTh = new Canvas(this.bTg.bSR);
        this.bTf = fVar;
        this.bTi = new Paint(1);
        this.bTi.setTextAlign(Align.LEFT);
        this.bTi.setColor(-1);
        AppMethodBeat.o(115931);
    }

    /* Access modifiers changed, original: final */
    public final j o(char c) {
        AppMethodBeat.i(115932);
        j yH = this.bTf.bSZ.yH();
        yH.bTG = false;
        a(yH, (int) Math.ceil((double) p(c)), (int) Math.ceil((double) (this.bTm.descent - this.bTm.ascent)));
        if (this.bTg.b((int) Math.ceil((double) yH.width), (int) Math.ceil((double) yH.height), this.bTk)) {
            a(yH, this.bTk);
            a(c, this.bTk, yH, this.bTi);
            AppMethodBeat.o(115932);
            return yH;
        }
        AppMethodBeat.o(115932);
        return null;
    }

    private float p(char c) {
        AppMethodBeat.i(115933);
        this.bTj[0] = c;
        this.bTi.getTextBounds(this.bTj, 0, 1, this.bTk);
        float max = Math.max((float) this.bTk.width(), this.bTi.measureText(this.bTj, 0, 1)) + 1.0f;
        AppMethodBeat.o(115933);
        return max;
    }

    private void a(j jVar, int i, int i2) {
        AppMethodBeat.i(115934);
        if (jVar == null) {
            AppMethodBeat.o(115934);
            return;
        }
        jVar.bTA = (float) i;
        if (yI()) {
            jVar.bTB = (-this.bTi.getStrokeWidth()) / 2.0f;
            jVar.z(((float) i) + this.bTi.getStrokeWidth(), (float) i2);
            AppMethodBeat.o(115934);
            return;
        }
        jVar.bTB = 0.0f;
        jVar.z((float) i, (float) i2);
        AppMethodBeat.o(115934);
    }

    private void a(j jVar, Rect rect) {
        AppMethodBeat.i(115935);
        jVar.f(((float) rect.left) / ((float) this.bTg.width()), ((float) rect.top) / ((float) this.bTg.height()), ((float) rect.right) / ((float) this.bTg.width()), ((float) rect.bottom) / ((float) this.bTg.height()));
        AppMethodBeat.o(115935);
    }

    private void a(char c, Rect rect, j jVar, Paint paint) {
        AppMethodBeat.i(115936);
        if (paint == null || jVar == null || rect == null) {
            AppMethodBeat.o(115936);
            return;
        }
        this.bTj[0] = c;
        this.bTh.save();
        this.bTh.clipRect(rect);
        this.bTh.drawText(this.bTj, 0, 1, ((float) rect.left) - jVar.bTB, ((((float) rect.top) + jVar.height) - this.bTm.descent) - 1.0f, paint);
        this.bTh.restore();
        AppMethodBeat.o(115936);
    }

    private boolean yI() {
        AppMethodBeat.i(115937);
        Paint paint = this.bTi;
        if (paint == null) {
            AppMethodBeat.o(115937);
            return false;
        } else if (paint.getStyle() == Style.STROKE || paint.getStyle() == Style.FILL_AND_STROKE) {
            AppMethodBeat.o(115937);
            return true;
        } else {
            AppMethodBeat.o(115937);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final j a(Drawable drawable, int i, int i2) {
        AppMethodBeat.i(115938);
        if (i <= 0 || i2 <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("width or height unexpected");
            AppMethodBeat.o(115938);
            throw illegalArgumentException;
        }
        j yH = this.bTf.bSZ.yH();
        yH.bTA = (float) i;
        yH.bTB = 0.0f;
        this.bTg.b(i, i2, this.bTk);
        Rect rect = this.bTk;
        if (rect.left < 0 || rect.right < 0 || rect.width() <= 0 || rect.height() <= 0) {
            AppMethodBeat.o(115938);
            return null;
        }
        yH.z((float) i, (float) i2);
        yH.f(((float) rect.left) / ((float) this.bTg.width()), ((float) rect.top) / ((float) this.bTg.height()), ((float) rect.right) / ((float) this.bTg.width()), ((float) rect.bottom) / ((float) this.bTg.height()));
        yH.bTG = true;
        this.bTh.save();
        this.bTh.clipRect(rect);
        drawable.setBounds(rect);
        drawable.draw(this.bTh);
        this.bTh.restore();
        AppMethodBeat.o(115938);
        return yH;
    }

    static float E(List<j> list) {
        AppMethodBeat.i(115939);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(115939);
            return 0.0f;
        }
        float f = 0.0f;
        for (j jVar : list) {
            if (jVar != null) {
                f = jVar.bTA + f;
            }
        }
        AppMethodBeat.o(115939);
        return f;
    }
}
