package com.tencent.magicbrush.handler.glfont;

import android.annotation.SuppressLint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressLint({"LongLogTag"})
final class f {
    g bSX;
    private HashMap<String, j> bSY;
    a bSZ;
    private FloatBuffer bTa;
    private List<j> bTb;
    private i bTc;
    private StringBuilder bTd = new StringBuilder();

    static class a {
        Queue<j> bTe = new LinkedList();

        a() {
            AppMethodBeat.i(115918);
            AppMethodBeat.o(115918);
        }

        /* Access modifiers changed, original: final */
        public final j yH() {
            AppMethodBeat.i(115919);
            j jVar = (j) this.bTe.poll();
            if (jVar == null) {
                jVar = new j();
                AppMethodBeat.o(115919);
                return jVar;
            }
            AppMethodBeat.o(115919);
            return jVar;
        }
    }

    f(d dVar) {
        AppMethodBeat.i(115920);
        this.bSX = new g(dVar, this);
        this.bSY = new HashMap();
        this.bSZ = new a();
        this.bTb = new ArrayList();
        AppMethodBeat.o(115920);
    }

    /* Access modifiers changed, original: final */
    public final FloatBuffer bW(String str) {
        AppMethodBeat.i(115921);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(115921);
            return null;
        }
        List bX = bX(str);
        if (bX == null || bX.size() == 0) {
            AppMethodBeat.o(115921);
            return null;
        }
        int max = (Math.max(str.length(), 10) * 36) + 16;
        if (this.bTa == null || this.bTa.capacity() * 4 < max) {
            this.bTa = ByteBuffer.allocateDirect(max).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.bTa.clear();
        FloatBuffer floatBuffer = this.bTa;
        float E = g.E(bX);
        FontMetrics fontMetrics = this.bSX.bTm;
        floatBuffer.put(E).put(fontMetrics.ascent).put(fontMetrics.descent).put(fontMetrics.descent - fontMetrics.ascent);
        j.a(floatBuffer, bX);
        floatBuffer.flip();
        this.bTb.clear();
        AppMethodBeat.o(115921);
        return floatBuffer;
    }

    private List<j> bX(String str) {
        AppMethodBeat.i(115922);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(115922);
            return null;
        }
        this.bTb.clear();
        int i = 0;
        while (i < str.length()) {
            Object c;
            int p = p(str, i);
            if (p > 0) {
                c = c(str, i, p);
                i += p;
            } else {
                c = m(str.charAt(i));
                i++;
            }
            if (c == null) {
                this.bTb.clear();
                AppMethodBeat.o(115922);
                return null;
            }
            this.bTb.add(c);
        }
        List<j> list = this.bTb;
        AppMethodBeat.o(115922);
        return list;
    }

    private j m(char c) {
        AppMethodBeat.i(115923);
        if (this.bTc == null) {
            AppMethodBeat.o(115923);
            return null;
        }
        String n = n(c);
        j jVar = (j) this.bSY.get(n);
        if (jVar != null) {
            AppMethodBeat.o(115923);
            return jVar;
        }
        jVar = this.bSX.o(c);
        if (jVar == null) {
            new StringBuilder("Load glyph failed. glyph == null [").append(c).append("]");
            AppMethodBeat.o(115923);
            return null;
        }
        this.bSY.put(n, jVar);
        AppMethodBeat.o(115923);
        return jVar;
    }

    private j c(String str, int i, int i2) {
        AppMethodBeat.i(115924);
        String d = d(str, i, i2);
        j jVar = (j) this.bSY.get(d);
        if (jVar != null) {
            AppMethodBeat.o(115924);
            return jVar;
        } else if (com.tencent.magicbrush.a.a.yA() == null) {
            IllegalStateException illegalStateException = new IllegalStateException("FontDrawableProvider must support");
            AppMethodBeat.o(115924);
            throw illegalStateException;
        } else {
            Drawable o = com.tencent.magicbrush.a.a.yA().o(str, i);
            if (o == null) {
                jVar = j.bTz;
                AppMethodBeat.o(115924);
                return jVar;
            }
            int i3 = (int) this.bTc.fontSize;
            int i4 = (int) this.bTc.fontSize;
            if (i3 <= 0 || i4 <= 0) {
                jVar = j.bTz;
                AppMethodBeat.o(115924);
                return jVar;
            }
            jVar = this.bSX.a(o, i3, i4);
            if (jVar == null) {
                AppMethodBeat.o(115924);
                return null;
            }
            this.bSY.put(d, jVar);
            AppMethodBeat.o(115924);
            return jVar;
        }
    }

    private static int p(String str, int i) {
        AppMethodBeat.i(115925);
        if (com.tencent.magicbrush.a.a.yA() == null) {
            AppMethodBeat.o(115925);
            return 0;
        }
        int n = com.tencent.magicbrush.a.a.yA().n(str, i);
        AppMethodBeat.o(115925);
        return n;
    }

    private String d(String str, int i, int i2) {
        AppMethodBeat.i(115926);
        if (i2 <= 0) {
            IllegalStateException illegalStateException = new IllegalStateException("There is no font drawable");
            AppMethodBeat.o(115926);
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
        AppMethodBeat.o(115926);
        return stringBuilder;
    }

    private String n(char c) {
        AppMethodBeat.i(115927);
        if (this.bTc == null) {
            AppMethodBeat.o(115927);
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
        AppMethodBeat.o(115927);
        return stringBuilder;
    }

    /* Access modifiers changed, original: final */
    public final void a(i iVar) {
        boolean z = false;
        AppMethodBeat.i(115928);
        this.bTc = iVar;
        g gVar = this.bSX;
        gVar.bTi.setTypeface(iVar.bTq);
        gVar.bTi.setTextSize(iVar.fontSize);
        if (iVar.bTr) {
            gVar.bTi.setStyle(Style.STROKE);
            gVar.bTi.setStrokeWidth(iVar.strokeWidth);
        } else {
            gVar.bTi.setStyle(Style.FILL);
        }
        gVar.bTi.setTextSkewX(0.0f);
        gVar.bTi.setFakeBoldText(false);
        if (iVar.bTs != null) {
            if (iVar.bTq == null || iVar.bTq.getStyle() != iVar.bTs.bTx) {
                if (iVar.bTs == com.tencent.magicbrush.handler.glfont.i.a.ITALIC || iVar.bTs == com.tencent.magicbrush.handler.glfont.i.a.BOLD_ITALIC) {
                    gVar.bTi.setTextSkewX(-0.25f);
                }
                if (iVar.bTs == com.tencent.magicbrush.handler.glfont.i.a.BOLD || iVar.bTs == com.tencent.magicbrush.handler.glfont.i.a.BOLD_ITALIC) {
                    gVar.bTi.setFakeBoldText(true);
                }
            }
            com.tencent.magicbrush.handler.glfont.i.a aVar = iVar.bTs;
            if (aVar == com.tencent.magicbrush.handler.glfont.i.a.BOLD || aVar == com.tencent.magicbrush.handler.glfont.i.a.BOLD_ITALIC) {
                z = true;
            }
            if (z) {
                gVar.bTi.setFakeBoldText(true);
            }
        }
        gVar.bTi.getFontMetrics(gVar.bTm);
        AppMethodBeat.o(115928);
    }

    /* Access modifiers changed, original: final */
    public final float bY(String str) {
        AppMethodBeat.i(115929);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(115929);
            return 0.0f;
        }
        List bX = bX(str);
        if (bX == null || bX.size() == 0) {
            AppMethodBeat.o(115929);
            return -1.0f;
        }
        float E = g.E(bX);
        AppMethodBeat.o(115929);
        return E;
    }

    /* Access modifiers changed, original: final */
    public final void clear() {
        AppMethodBeat.i(115930);
        if (this.bSY != null) {
            for (j offer : this.bSY.values()) {
                this.bSZ.bTe.offer(offer);
            }
            this.bSY.clear();
        }
        AppMethodBeat.o(115930);
    }
}
