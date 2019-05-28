package com.tencent.magicbrush.handler.glfont;

import android.annotation.SuppressLint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import com.tencent.magicbrush.handler.glfont.C32199i.C25716a;
import com.tencent.magicbrush.p1173a.C37409a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressLint({"LongLogTag"})
/* renamed from: com.tencent.magicbrush.handler.glfont.f */
final class C8882f {
    C8883g bSX;
    private HashMap<String, C32200j> bSY;
    C1012a bSZ;
    private FloatBuffer bTa;
    private List<C32200j> bTb;
    private C32199i bTc;
    private StringBuilder bTd = new StringBuilder();

    /* renamed from: com.tencent.magicbrush.handler.glfont.f$a */
    static class C1012a {
        Queue<C32200j> bTe = new LinkedList();

        C1012a() {
            AppMethodBeat.m2504i(115918);
            AppMethodBeat.m2505o(115918);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: yH */
        public final C32200j mo4023yH() {
            AppMethodBeat.m2504i(115919);
            C32200j c32200j = (C32200j) this.bTe.poll();
            if (c32200j == null) {
                c32200j = new C32200j();
                AppMethodBeat.m2505o(115919);
                return c32200j;
            }
            AppMethodBeat.m2505o(115919);
            return c32200j;
        }
    }

    C8882f(C45130d c45130d) {
        AppMethodBeat.m2504i(115920);
        this.bSX = new C8883g(c45130d, this);
        this.bSY = new HashMap();
        this.bSZ = new C1012a();
        this.bTb = new ArrayList();
        AppMethodBeat.m2505o(115920);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bW */
    public final FloatBuffer mo20099bW(String str) {
        AppMethodBeat.m2504i(115921);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(115921);
            return null;
        }
        List bX = m15858bX(str);
        if (bX == null || bX.size() == 0) {
            AppMethodBeat.m2505o(115921);
            return null;
        }
        int max = (Math.max(str.length(), 10) * 36) + 16;
        if (this.bTa == null || this.bTa.capacity() * 4 < max) {
            this.bTa = ByteBuffer.allocateDirect(max).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.bTa.clear();
        FloatBuffer floatBuffer = this.bTa;
        float E = C8883g.m15867E(bX);
        FontMetrics fontMetrics = this.bSX.bTm;
        floatBuffer.put(E).put(fontMetrics.ascent).put(fontMetrics.descent).put(fontMetrics.descent - fontMetrics.ascent);
        C32200j.m52524a(floatBuffer, bX);
        floatBuffer.flip();
        this.bTb.clear();
        AppMethodBeat.m2505o(115921);
        return floatBuffer;
    }

    /* renamed from: bX */
    private List<C32200j> m15858bX(String str) {
        AppMethodBeat.m2504i(115922);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(115922);
            return null;
        }
        this.bTb.clear();
        int i = 0;
        while (i < str.length()) {
            Object c;
            int p = C8882f.m15863p(str, i);
            if (p > 0) {
                c = m15859c(str, i, p);
                i += p;
            } else {
                c = m15861m(str.charAt(i));
                i++;
            }
            if (c == null) {
                this.bTb.clear();
                AppMethodBeat.m2505o(115922);
                return null;
            }
            this.bTb.add(c);
        }
        List<C32200j> list = this.bTb;
        AppMethodBeat.m2505o(115922);
        return list;
    }

    /* renamed from: m */
    private C32200j m15861m(char c) {
        AppMethodBeat.m2504i(115923);
        if (this.bTc == null) {
            AppMethodBeat.m2505o(115923);
            return null;
        }
        String n = m15862n(c);
        C32200j c32200j = (C32200j) this.bSY.get(n);
        if (c32200j != null) {
            AppMethodBeat.m2505o(115923);
            return c32200j;
        }
        c32200j = this.bSX.mo20103o(c);
        if (c32200j == null) {
            new StringBuilder("Load glyph failed. glyph == null [").append(c).append("]");
            AppMethodBeat.m2505o(115923);
            return null;
        }
        this.bSY.put(n, c32200j);
        AppMethodBeat.m2505o(115923);
        return c32200j;
    }

    /* renamed from: c */
    private C32200j m15859c(String str, int i, int i2) {
        AppMethodBeat.m2504i(115924);
        String d = m15860d(str, i, i2);
        C32200j c32200j = (C32200j) this.bSY.get(d);
        if (c32200j != null) {
            AppMethodBeat.m2505o(115924);
            return c32200j;
        } else if (C37409a.m63028yA() == null) {
            IllegalStateException illegalStateException = new IllegalStateException("FontDrawableProvider must support");
            AppMethodBeat.m2505o(115924);
            throw illegalStateException;
        } else {
            Drawable o = C37409a.m63028yA().mo33010o(str, i);
            if (o == null) {
                c32200j = C32200j.bTz;
                AppMethodBeat.m2505o(115924);
                return c32200j;
            }
            int i3 = (int) this.bTc.fontSize;
            int i4 = (int) this.bTc.fontSize;
            if (i3 <= 0 || i4 <= 0) {
                c32200j = C32200j.bTz;
                AppMethodBeat.m2505o(115924);
                return c32200j;
            }
            c32200j = this.bSX.mo20102a(o, i3, i4);
            if (c32200j == null) {
                AppMethodBeat.m2505o(115924);
                return null;
            }
            this.bSY.put(d, c32200j);
            AppMethodBeat.m2505o(115924);
            return c32200j;
        }
    }

    /* renamed from: p */
    private static int m15863p(String str, int i) {
        AppMethodBeat.m2504i(115925);
        if (C37409a.m63028yA() == null) {
            AppMethodBeat.m2505o(115925);
            return 0;
        }
        int n = C37409a.m63028yA().mo33009n(str, i);
        AppMethodBeat.m2505o(115925);
        return n;
    }

    /* renamed from: d */
    private String m15860d(String str, int i, int i2) {
        AppMethodBeat.m2504i(115926);
        if (i2 <= 0) {
            IllegalStateException illegalStateException = new IllegalStateException("There is no font drawable");
            AppMethodBeat.m2505o(115926);
            throw illegalStateException;
        }
        this.bTd.setLength(0);
        while (i2 > 0) {
            this.bTd.append(str.charAt(i));
            i++;
            i2--;
        }
        this.bTd.append("|").append(this.bTc.fontSize);
        String stringBuilder = this.bTd.toString();
        AppMethodBeat.m2505o(115926);
        return stringBuilder;
    }

    /* renamed from: n */
    private String m15862n(char c) {
        AppMethodBeat.m2504i(115927);
        if (this.bTc == null) {
            AppMethodBeat.m2505o(115927);
            return null;
        }
        this.bTd.setLength(0);
        StringBuilder append = this.bTd.append(c).append("|").append(this.bTc.fontSize).append("|").append(this.bTc.bTq == null ? BuildConfig.COMMAND : Integer.valueOf(this.bTc.bTq.hashCode()));
        if (this.bTc.bTr) {
            append.append("|").append(this.bTc.strokeWidth);
        }
        if (this.bTc.bTs != null) {
            append.append("|").append(this.bTc.bTs.bTx);
        }
        String stringBuilder = append.toString();
        AppMethodBeat.m2505o(115927);
        return stringBuilder;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo20098a(C32199i c32199i) {
        boolean z = false;
        AppMethodBeat.m2504i(115928);
        this.bTc = c32199i;
        C8883g c8883g = this.bSX;
        c8883g.bTi.setTypeface(c32199i.bTq);
        c8883g.bTi.setTextSize(c32199i.fontSize);
        if (c32199i.bTr) {
            c8883g.bTi.setStyle(Style.STROKE);
            c8883g.bTi.setStrokeWidth(c32199i.strokeWidth);
        } else {
            c8883g.bTi.setStyle(Style.FILL);
        }
        c8883g.bTi.setTextSkewX(0.0f);
        c8883g.bTi.setFakeBoldText(false);
        if (c32199i.bTs != null) {
            if (c32199i.bTq == null || c32199i.bTq.getStyle() != c32199i.bTs.bTx) {
                if (c32199i.bTs == C25716a.ITALIC || c32199i.bTs == C25716a.BOLD_ITALIC) {
                    c8883g.bTi.setTextSkewX(-0.25f);
                }
                if (c32199i.bTs == C25716a.BOLD || c32199i.bTs == C25716a.BOLD_ITALIC) {
                    c8883g.bTi.setFakeBoldText(true);
                }
            }
            C25716a c25716a = c32199i.bTs;
            if (c25716a == C25716a.BOLD || c25716a == C25716a.BOLD_ITALIC) {
                z = true;
            }
            if (z) {
                c8883g.bTi.setFakeBoldText(true);
            }
        }
        c8883g.bTi.getFontMetrics(c8883g.bTm);
        AppMethodBeat.m2505o(115928);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bY */
    public final float mo20100bY(String str) {
        AppMethodBeat.m2504i(115929);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(115929);
            return 0.0f;
        }
        List bX = m15858bX(str);
        if (bX == null || bX.size() == 0) {
            AppMethodBeat.m2505o(115929);
            return -1.0f;
        }
        float E = C8883g.m15867E(bX);
        AppMethodBeat.m2505o(115929);
        return E;
    }

    /* Access modifiers changed, original: final */
    public final void clear() {
        AppMethodBeat.m2504i(115930);
        if (this.bSY != null) {
            for (C32200j offer : this.bSY.values()) {
                this.bSZ.bTe.offer(offer);
            }
            this.bSY.clear();
        }
        AppMethodBeat.m2505o(115930);
    }
}
