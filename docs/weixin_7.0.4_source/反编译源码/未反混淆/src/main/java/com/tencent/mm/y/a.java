package com.tencent.mm.y;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.smtt.sdk.WebView;

public final class a implements Cloneable {
    private static int eGR = ((int) ah.getResources().getDimension(R.dimen.v2));
    private static int eGS = ((int) ah.getResources().getDimension(R.dimen.v1));
    public static float eGT = ah.getResources().getDimension(R.dimen.y3);
    public static float eGU = ah.getResources().getDimension(R.dimen.y2);
    public static Path eGV = new Path();
    public static Path eGW = new Path();
    public static Paint eGX = new Paint();
    public static Paint eGY = new Paint();
    public static Paint eGZ = new Paint();
    public static Paint eHa = new Paint();
    public static Paint eHb = new Paint();
    public static Rect oT = new Rect();
    public Rect cch;
    public Rect eHc = new Rect();
    public Rect eHd = new Rect();
    public Matrix mMatrix = new Matrix();

    static {
        AppMethodBeat.i(116269);
        eGZ.setColor(WebView.NIGHT_MODE_COLOR);
        eGX.setColor(-1);
        eGX.setStrokeWidth((float) eGR);
        eGX.setStyle(Style.STROKE);
        eGX.setAntiAlias(true);
        eHa.set(eGX);
        eHa.setStrokeWidth((float) eGS);
        eHb.set(eGX);
        eHb.setStrokeWidth(eGT);
        eGY.set(eGX);
        eGY.setStrokeWidth((float) (eGR * 7));
        eGY.setColor(549174203);
        AppMethodBeat.o(116269);
    }

    public a(Rect rect) {
        AppMethodBeat.i(116264);
        this.cch = rect;
        AppMethodBeat.o(116264);
    }

    public a() {
        AppMethodBeat.i(116265);
        AppMethodBeat.o(116265);
    }

    public static void jz(int i) {
        AppMethodBeat.i(116266);
        eHb.setAlpha(i);
        eGX.setAlpha(i);
        eHa.setAlpha((int) (0.7058824f * ((float) i)));
        AppMethodBeat.o(116266);
    }

    public static void jA(int i) {
        AppMethodBeat.i(116267);
        eGZ.setAlpha((int) (0.9019608f * ((float) i)));
        AppMethodBeat.o(116267);
    }

    public final Object clone() {
        AppMethodBeat.i(116268);
        Object clone = super.clone();
        AppMethodBeat.o(116268);
        return clone;
    }
}
