package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.l;
import java.io.Serializable;

public final class a extends Paint implements Serializable {
    public a hdH = a.NORMAL;
    private float hdI;
    private String hdJ;
    private int hdK;
    private float hdL = Float.MAX_VALUE;
    private int hdM = BaseClientBuilder.API_PRIORITY_OTHER;
    private int mColor;

    public enum a {
        NORMAL,
        TOP,
        BOTTOM,
        MIDDLE;

        static {
            AppMethodBeat.o(103652);
        }
    }

    public a() {
        AppMethodBeat.i(103653);
        init();
        AppMethodBeat.o(103653);
    }

    private void init() {
        AppMethodBeat.i(103654);
        this.hdI = 0.0f;
        this.mColor = 0;
        this.hdJ = null;
        this.hdK = 0;
        if (this.hdL == Float.MAX_VALUE) {
            this.hdI = ((float) getAlpha()) / 255.0f;
            this.hdL = this.hdI;
        } else {
            this.hdI = this.hdL;
        }
        if (this.hdM == BaseClientBuilder.API_PRIORITY_OTHER) {
            this.mColor = getColor();
            this.hdM = this.mColor;
            AppMethodBeat.o(103654);
            return;
        }
        this.mColor = this.hdM;
        AppMethodBeat.o(103654);
    }

    /* Access modifiers changed, original: protected|final */
    public final Object clone() {
        AppMethodBeat.i(103655);
        Object clone = super.clone();
        AppMethodBeat.o(103655);
        return clone;
    }

    public final a ayq() {
        AppMethodBeat.i(103656);
        a aVar = new a();
        aVar.setColor(getColor());
        aVar.setFlags(getFlags());
        aVar.setDither(isDither());
        Shader shader = getShader();
        if (shader != null) {
            Shader shader2;
            Object a = l.a(Shader.class, "copy", shader, new Class[0], new Object[0]);
            if (a == null || !(a instanceof Shader)) {
                shader2 = shader;
            } else {
                shader2 = (Shader) a;
            }
            aVar.setShader(shader2);
        }
        aVar.setStrokeJoin(getStrokeJoin());
        aVar.setStrokeMiter(getStrokeMiter());
        aVar.setStrokeWidth(getStrokeWidth());
        aVar.setStrokeCap(getStrokeCap());
        aVar.setStyle(getStyle());
        aVar.setTextSize(getTextSize());
        aVar.setTextAlign(getTextAlign());
        aVar.setTypeface(getTypeface());
        aVar.hdH = this.hdH;
        AppMethodBeat.o(103656);
        return aVar;
    }

    public final a b(a aVar) {
        AppMethodBeat.i(103657);
        aVar.setColor(getColor());
        aVar.setFlags(getFlags());
        aVar.setDither(isDither());
        Shader shader = getShader();
        if (shader != null) {
            Shader shader2;
            Object a = l.a(Shader.class, "copy", shader, new Class[0], new Object[0]);
            if (a == null || !(a instanceof Shader)) {
                shader2 = shader;
            } else {
                shader2 = (Shader) a;
            }
            aVar.setShader(shader2);
        }
        aVar.setStrokeJoin(getStrokeJoin());
        aVar.setStrokeMiter(getStrokeMiter());
        aVar.setStrokeWidth(getStrokeWidth());
        aVar.setStrokeCap(getStrokeCap());
        aVar.setStyle(getStyle());
        aVar.setTextSize(getTextSize());
        aVar.setTextAlign(getTextAlign());
        aVar.setTypeface(getTypeface());
        aVar.hdH = this.hdH;
        AppMethodBeat.o(103657);
        return aVar;
    }

    public final void ai(float f) {
        AppMethodBeat.i(103658);
        this.hdI = f;
        setColor(this.mColor);
        AppMethodBeat.o(103658);
    }

    public final void setColor(int i) {
        AppMethodBeat.i(103659);
        this.mColor = i;
        super.setColor(((((int) (((float) Color.alpha(i)) * this.hdI)) & 255) << 24) | (16777215 & i));
        AppMethodBeat.o(103659);
    }

    public final void reset() {
        AppMethodBeat.i(103660);
        super.reset();
        this.hdH = a.NORMAL;
        AppMethodBeat.o(103660);
    }

    public final void release() {
        AppMethodBeat.i(103661);
        reset();
        init();
        AppMethodBeat.o(103661);
    }

    public final void yB(String str) {
        AppMethodBeat.i(103662);
        this.hdJ = str;
        setTypeface(Typeface.create(str, this.hdK));
        AppMethodBeat.o(103662);
    }

    public final void nE(int i) {
        AppMethodBeat.i(103663);
        this.hdK = i;
        setTypeface(Typeface.create(this.hdJ, i));
        AppMethodBeat.o(103663);
    }
}
