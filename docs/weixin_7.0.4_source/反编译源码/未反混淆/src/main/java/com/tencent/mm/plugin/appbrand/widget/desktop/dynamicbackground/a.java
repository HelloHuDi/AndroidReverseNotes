package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.GregorianCalendar;

public final class a {
    private b iYV;
    private a iYW;

    public class b {
        public float[] iZb;
        public float[] iZc;
    }

    public class a {
        public b iYX;
        public b iYY;
        public b iYZ;

        a() {
            AppMethodBeat.i(133961);
            this.iYX = new b();
            this.iYY = new b();
            this.iYZ = new b();
            AppMethodBeat.o(133961);
        }
    }

    a() {
        AppMethodBeat.i(133962);
        this.iYV = new b();
        this.iYW = new a();
        this.iYV.iZb = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.iYV.iZc = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.iYW.iYX.iZb = qo(11064532);
        this.iYW.iYX.iZc = qo(2770276);
        this.iYW.iYY.iZb = qo(8553090);
        this.iYW.iYY.iZc = qo(0);
        this.iYW.iYZ.iZb = qo(5260629);
        this.iYW.iYZ.iZc = qo(0);
        AppMethodBeat.o(133962);
    }

    public final b aPx() {
        return this.iYV;
    }

    public final void aPy() {
        b bVar;
        b bVar2;
        AppMethodBeat.i(133963);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        float f = (float) (currentTimeMillis - ((currentTimeMillis - ((long) (gregorianCalendar.get(13) + (((gregorianCalendar.get(11) * 60) * 60) + (gregorianCalendar.get(12) * 60))))) + 36000));
        if (f < 0.0f) {
            f += 86400.0f;
        }
        float f2 = (f * 1.0f) / 28800.0f;
        if (f2 > 2.0f) {
            f2 -= 2.0f;
            bVar = this.iYW.iYZ;
            bVar2 = this.iYW.iYX;
        } else if (f2 > 1.0f) {
            f2 -= 1.0f;
            bVar = this.iYW.iYY;
            bVar2 = this.iYW.iYZ;
        } else {
            bVar = this.iYW.iYX;
            bVar2 = this.iYW.iYY;
        }
        a(this.iYV.iZb, bVar, bVar2, 0, f2);
        a(this.iYV.iZc, bVar, bVar2, 1, f2);
        AppMethodBeat.o(133963);
    }

    public static int i(float[] fArr) {
        return ((((((int) (fArr[0] * 255.0f)) & 255) << 16) + ((((int) (fArr[3] * 255.0f)) & 255) << 24)) + ((((int) (fArr[1] * 255.0f)) & 255) << 8)) + (((int) (fArr[2] * 255.0f)) & 255);
    }

    private static void a(float[] fArr, b bVar, b bVar2, int i, float f) {
        AppMethodBeat.i(133964);
        if (i == 0) {
            a(fArr, bVar.iZb, bVar2.iZb, f);
            AppMethodBeat.o(133964);
            return;
        }
        if (i == 1) {
            a(fArr, bVar.iZc, bVar2.iZc, f);
        }
        AppMethodBeat.o(133964);
    }

    private static float[] qo(int i) {
        float f = ((float) ((65280 & i) >> 8)) / 255.0f;
        float f2 = ((float) ((i & 255) >> 0)) / 255.0f;
        return new float[]{((float) ((16711680 & i) >> 16)) / 255.0f, f, f2, 1.0f};
    }

    private static void a(float[] fArr, float[] fArr2, float[] fArr3, float f) {
        fArr[0] = (fArr3[0] * f) + (fArr2[0] * (1.0f - f));
        fArr[1] = (fArr3[1] * f) + (fArr2[1] * (1.0f - f));
        fArr[2] = (fArr3[2] * f) + (fArr2[2] * (1.0f - f));
        fArr[3] = (fArr3[3] * f) + (fArr2[3] * (1.0f - f));
    }
}
