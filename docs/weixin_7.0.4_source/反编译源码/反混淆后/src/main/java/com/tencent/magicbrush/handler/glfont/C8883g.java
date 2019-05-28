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

/* renamed from: com.tencent.magicbrush.handler.glfont.g */
final class C8883g {
    private List<C32200j> bTb = new ArrayList();
    private C8882f bTf;
    private C45130d bTg;
    private Canvas bTh;
    Paint bTi;
    private char[] bTj = new char[1];
    private Rect bTk = new Rect();
    private Rect bTl = new Rect();
    FontMetrics bTm = new FontMetrics();

    C8883g(C45130d c45130d, C8882f c8882f) {
        AppMethodBeat.m2504i(115931);
        this.bTg = c45130d;
        this.bTh = new Canvas(this.bTg.bSR);
        this.bTf = c8882f;
        this.bTi = new Paint(1);
        this.bTi.setTextAlign(Align.LEFT);
        this.bTi.setColor(-1);
        AppMethodBeat.m2505o(115931);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: o */
    public final C32200j mo20103o(char c) {
        AppMethodBeat.m2504i(115932);
        C32200j yH = this.bTf.bSZ.mo4023yH();
        yH.bTG = false;
        m15869a(yH, (int) Math.ceil((double) m15871p(c)), (int) Math.ceil((double) (this.bTm.descent - this.bTm.ascent)));
        if (this.bTg.mo72944b((int) Math.ceil((double) yH.width), (int) Math.ceil((double) yH.height), this.bTk)) {
            m15870a(yH, this.bTk);
            m15868a(c, this.bTk, yH, this.bTi);
            AppMethodBeat.m2505o(115932);
            return yH;
        }
        AppMethodBeat.m2505o(115932);
        return null;
    }

    /* renamed from: p */
    private float m15871p(char c) {
        AppMethodBeat.m2504i(115933);
        this.bTj[0] = c;
        this.bTi.getTextBounds(this.bTj, 0, 1, this.bTk);
        float max = Math.max((float) this.bTk.width(), this.bTi.measureText(this.bTj, 0, 1)) + 1.0f;
        AppMethodBeat.m2505o(115933);
        return max;
    }

    /* renamed from: a */
    private void m15869a(C32200j c32200j, int i, int i2) {
        AppMethodBeat.m2504i(115934);
        if (c32200j == null) {
            AppMethodBeat.m2505o(115934);
            return;
        }
        c32200j.bTA = (float) i;
        if (m15872yI()) {
            c32200j.bTB = (-this.bTi.getStrokeWidth()) / 2.0f;
            c32200j.mo52867z(((float) i) + this.bTi.getStrokeWidth(), (float) i2);
            AppMethodBeat.m2505o(115934);
            return;
        }
        c32200j.bTB = 0.0f;
        c32200j.mo52867z((float) i, (float) i2);
        AppMethodBeat.m2505o(115934);
    }

    /* renamed from: a */
    private void m15870a(C32200j c32200j, Rect rect) {
        AppMethodBeat.m2504i(115935);
        c32200j.mo52865f(((float) rect.left) / ((float) this.bTg.width()), ((float) rect.top) / ((float) this.bTg.height()), ((float) rect.right) / ((float) this.bTg.width()), ((float) rect.bottom) / ((float) this.bTg.height()));
        AppMethodBeat.m2505o(115935);
    }

    /* renamed from: a */
    private void m15868a(char c, Rect rect, C32200j c32200j, Paint paint) {
        AppMethodBeat.m2504i(115936);
        if (paint == null || c32200j == null || rect == null) {
            AppMethodBeat.m2505o(115936);
            return;
        }
        this.bTj[0] = c;
        this.bTh.save();
        this.bTh.clipRect(rect);
        this.bTh.drawText(this.bTj, 0, 1, ((float) rect.left) - c32200j.bTB, ((((float) rect.top) + c32200j.height) - this.bTm.descent) - 1.0f, paint);
        this.bTh.restore();
        AppMethodBeat.m2505o(115936);
    }

    /* renamed from: yI */
    private boolean m15872yI() {
        AppMethodBeat.m2504i(115937);
        Paint paint = this.bTi;
        if (paint == null) {
            AppMethodBeat.m2505o(115937);
            return false;
        } else if (paint.getStyle() == Style.STROKE || paint.getStyle() == Style.FILL_AND_STROKE) {
            AppMethodBeat.m2505o(115937);
            return true;
        } else {
            AppMethodBeat.m2505o(115937);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C32200j mo20102a(Drawable drawable, int i, int i2) {
        AppMethodBeat.m2504i(115938);
        if (i <= 0 || i2 <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("width or height unexpected");
            AppMethodBeat.m2505o(115938);
            throw illegalArgumentException;
        }
        C32200j yH = this.bTf.bSZ.mo4023yH();
        yH.bTA = (float) i;
        yH.bTB = 0.0f;
        this.bTg.mo72944b(i, i2, this.bTk);
        Rect rect = this.bTk;
        if (rect.left < 0 || rect.right < 0 || rect.width() <= 0 || rect.height() <= 0) {
            AppMethodBeat.m2505o(115938);
            return null;
        }
        yH.mo52867z((float) i, (float) i2);
        yH.mo52865f(((float) rect.left) / ((float) this.bTg.width()), ((float) rect.top) / ((float) this.bTg.height()), ((float) rect.right) / ((float) this.bTg.width()), ((float) rect.bottom) / ((float) this.bTg.height()));
        yH.bTG = true;
        this.bTh.save();
        this.bTh.clipRect(rect);
        drawable.setBounds(rect);
        drawable.draw(this.bTh);
        this.bTh.restore();
        AppMethodBeat.m2505o(115938);
        return yH;
    }

    /* renamed from: E */
    static float m15867E(List<C32200j> list) {
        AppMethodBeat.m2504i(115939);
        if (list == null || list.size() == 0) {
            AppMethodBeat.m2505o(115939);
            return 0.0f;
        }
        float f = 0.0f;
        for (C32200j c32200j : list) {
            if (c32200j != null) {
                f = c32200j.bTA + f;
            }
        }
        AppMethodBeat.m2505o(115939);
        return f;
    }
}
