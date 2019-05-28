package com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.GregorianCalendar;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.a */
public final class C27376a {
    private C10973b iYV;
    private C27377a iYW;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.a$b */
    public class C10973b {
        public float[] iZb;
        public float[] iZc;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.a$a */
    public class C27377a {
        public C10973b iYX;
        public C10973b iYY;
        public C10973b iYZ;

        C27377a() {
            AppMethodBeat.m2504i(133961);
            this.iYX = new C10973b();
            this.iYY = new C10973b();
            this.iYZ = new C10973b();
            AppMethodBeat.m2505o(133961);
        }
    }

    C27376a() {
        AppMethodBeat.m2504i(133962);
        this.iYV = new C10973b();
        this.iYW = new C27377a();
        this.iYV.iZb = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.iYV.iZc = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.iYW.iYX.iZb = C27376a.m43455qo(11064532);
        this.iYW.iYX.iZc = C27376a.m43455qo(2770276);
        this.iYW.iYY.iZb = C27376a.m43455qo(8553090);
        this.iYW.iYY.iZc = C27376a.m43455qo(0);
        this.iYW.iYZ.iZb = C27376a.m43455qo(5260629);
        this.iYW.iYZ.iZc = C27376a.m43455qo(0);
        AppMethodBeat.m2505o(133962);
    }

    public final C10973b aPx() {
        return this.iYV;
    }

    public final void aPy() {
        C10973b c10973b;
        C10973b c10973b2;
        AppMethodBeat.m2504i(133963);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        float f = (float) (currentTimeMillis - ((currentTimeMillis - ((long) (gregorianCalendar.get(13) + (((gregorianCalendar.get(11) * 60) * 60) + (gregorianCalendar.get(12) * 60))))) + 36000));
        if (f < 0.0f) {
            f += 86400.0f;
        }
        float f2 = (f * 1.0f) / 28800.0f;
        if (f2 > 2.0f) {
            f2 -= 2.0f;
            c10973b = this.iYW.iYZ;
            c10973b2 = this.iYW.iYX;
        } else if (f2 > 1.0f) {
            f2 -= 1.0f;
            c10973b = this.iYW.iYY;
            c10973b2 = this.iYW.iYZ;
        } else {
            c10973b = this.iYW.iYX;
            c10973b2 = this.iYW.iYY;
        }
        C27376a.m43452a(this.iYV.iZb, c10973b, c10973b2, 0, f2);
        C27376a.m43452a(this.iYV.iZc, c10973b, c10973b2, 1, f2);
        AppMethodBeat.m2505o(133963);
    }

    /* renamed from: i */
    public static int m43454i(float[] fArr) {
        return ((((((int) (fArr[0] * 255.0f)) & 255) << 16) + ((((int) (fArr[3] * 255.0f)) & 255) << 24)) + ((((int) (fArr[1] * 255.0f)) & 255) << 8)) + (((int) (fArr[2] * 255.0f)) & 255);
    }

    /* renamed from: a */
    private static void m43452a(float[] fArr, C10973b c10973b, C10973b c10973b2, int i, float f) {
        AppMethodBeat.m2504i(133964);
        if (i == 0) {
            C27376a.m43453a(fArr, c10973b.iZb, c10973b2.iZb, f);
            AppMethodBeat.m2505o(133964);
            return;
        }
        if (i == 1) {
            C27376a.m43453a(fArr, c10973b.iZc, c10973b2.iZc, f);
        }
        AppMethodBeat.m2505o(133964);
    }

    /* renamed from: qo */
    private static float[] m43455qo(int i) {
        float f = ((float) ((65280 & i) >> 8)) / 255.0f;
        float f2 = ((float) ((i & 255) >> 0)) / 255.0f;
        return new float[]{((float) ((16711680 & i) >> 16)) / 255.0f, f, f2, 1.0f};
    }

    /* renamed from: a */
    private static void m43453a(float[] fArr, float[] fArr2, float[] fArr3, float f) {
        fArr[0] = (fArr3[0] * f) + (fArr2[0] * (1.0f - f));
        fArr[1] = (fArr3[1] * f) + (fArr2[1] * (1.0f - f));
        fArr[2] = (fArr3[2] * f) + (fArr2[2] * (1.0f - f));
        fArr[3] = (fArr3[3] * f) + (fArr2[3] * (1.0f - f));
    }
}
