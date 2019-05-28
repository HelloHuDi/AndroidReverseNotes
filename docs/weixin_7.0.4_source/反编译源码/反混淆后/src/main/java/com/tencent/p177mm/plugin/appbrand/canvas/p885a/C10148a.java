package com.tencent.p177mm.plugin.appbrand.canvas.p885a;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C38495l;
import java.io.Serializable;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.a.a */
public final class C10148a extends Paint implements Serializable {
    public C10149a hdH = C10149a.NORMAL;
    private float hdI;
    private String hdJ;
    private int hdK;
    private float hdL = Float.MAX_VALUE;
    private int hdM = BaseClientBuilder.API_PRIORITY_OTHER;
    private int mColor;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.a.a$a */
    public enum C10149a {
        NORMAL,
        TOP,
        BOTTOM,
        MIDDLE;

        static {
            AppMethodBeat.m2505o(103652);
        }
    }

    public C10148a() {
        AppMethodBeat.m2504i(103653);
        init();
        AppMethodBeat.m2505o(103653);
    }

    private void init() {
        AppMethodBeat.m2504i(103654);
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
            AppMethodBeat.m2505o(103654);
            return;
        }
        this.mColor = this.hdM;
        AppMethodBeat.m2505o(103654);
    }

    /* Access modifiers changed, original: protected|final */
    public final Object clone() {
        AppMethodBeat.m2504i(103655);
        Object clone = super.clone();
        AppMethodBeat.m2505o(103655);
        return clone;
    }

    public final C10148a ayq() {
        AppMethodBeat.m2504i(103656);
        C10148a c10148a = new C10148a();
        c10148a.setColor(getColor());
        c10148a.setFlags(getFlags());
        c10148a.setDither(isDither());
        Shader shader = getShader();
        if (shader != null) {
            Shader shader2;
            Object a = C38495l.m65145a(Shader.class, "copy", shader, new Class[0], new Object[0]);
            if (a == null || !(a instanceof Shader)) {
                shader2 = shader;
            } else {
                shader2 = (Shader) a;
            }
            c10148a.setShader(shader2);
        }
        c10148a.setStrokeJoin(getStrokeJoin());
        c10148a.setStrokeMiter(getStrokeMiter());
        c10148a.setStrokeWidth(getStrokeWidth());
        c10148a.setStrokeCap(getStrokeCap());
        c10148a.setStyle(getStyle());
        c10148a.setTextSize(getTextSize());
        c10148a.setTextAlign(getTextAlign());
        c10148a.setTypeface(getTypeface());
        c10148a.hdH = this.hdH;
        AppMethodBeat.m2505o(103656);
        return c10148a;
    }

    /* renamed from: b */
    public final C10148a mo21505b(C10148a c10148a) {
        AppMethodBeat.m2504i(103657);
        c10148a.setColor(getColor());
        c10148a.setFlags(getFlags());
        c10148a.setDither(isDither());
        Shader shader = getShader();
        if (shader != null) {
            Shader shader2;
            Object a = C38495l.m65145a(Shader.class, "copy", shader, new Class[0], new Object[0]);
            if (a == null || !(a instanceof Shader)) {
                shader2 = shader;
            } else {
                shader2 = (Shader) a;
            }
            c10148a.setShader(shader2);
        }
        c10148a.setStrokeJoin(getStrokeJoin());
        c10148a.setStrokeMiter(getStrokeMiter());
        c10148a.setStrokeWidth(getStrokeWidth());
        c10148a.setStrokeCap(getStrokeCap());
        c10148a.setStyle(getStyle());
        c10148a.setTextSize(getTextSize());
        c10148a.setTextAlign(getTextAlign());
        c10148a.setTypeface(getTypeface());
        c10148a.hdH = this.hdH;
        AppMethodBeat.m2505o(103657);
        return c10148a;
    }

    /* renamed from: ai */
    public final void mo21503ai(float f) {
        AppMethodBeat.m2504i(103658);
        this.hdI = f;
        setColor(this.mColor);
        AppMethodBeat.m2505o(103658);
    }

    public final void setColor(int i) {
        AppMethodBeat.m2504i(103659);
        this.mColor = i;
        super.setColor(((((int) (((float) Color.alpha(i)) * this.hdI)) & 255) << 24) | (16777215 & i));
        AppMethodBeat.m2505o(103659);
    }

    public final void reset() {
        AppMethodBeat.m2504i(103660);
        super.reset();
        this.hdH = C10149a.NORMAL;
        AppMethodBeat.m2505o(103660);
    }

    public final void release() {
        AppMethodBeat.m2504i(103661);
        reset();
        init();
        AppMethodBeat.m2505o(103661);
    }

    /* renamed from: yB */
    public final void mo21511yB(String str) {
        AppMethodBeat.m2504i(103662);
        this.hdJ = str;
        setTypeface(Typeface.create(str, this.hdK));
        AppMethodBeat.m2505o(103662);
    }

    /* renamed from: nE */
    public final void mo21507nE(int i) {
        AppMethodBeat.m2504i(103663);
        this.hdK = i;
        setTypeface(Typeface.create(this.hdJ, i));
        AppMethodBeat.m2505o(103663);
    }
}
