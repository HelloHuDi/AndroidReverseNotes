package com.tencent.p177mm.p651y;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.y.a */
public final class C24186a implements Cloneable {
    private static int eGR = ((int) C4996ah.getResources().getDimension(C25738R.dimen.f10227v2));
    private static int eGS = ((int) C4996ah.getResources().getDimension(C25738R.dimen.f10226v1));
    public static float eGT = C4996ah.getResources().getDimension(C25738R.dimen.f10328y3);
    public static float eGU = C4996ah.getResources().getDimension(C25738R.dimen.f10327y2);
    public static Path eGV = new Path();
    public static Path eGW = new Path();
    public static Paint eGX = new Paint();
    public static Paint eGY = new Paint();
    public static Paint eGZ = new Paint();
    public static Paint eHa = new Paint();
    public static Paint eHb = new Paint();
    /* renamed from: oT */
    public static Rect f4451oT = new Rect();
    public Rect cch;
    public Rect eHc = new Rect();
    public Rect eHd = new Rect();
    public Matrix mMatrix = new Matrix();

    static {
        AppMethodBeat.m2504i(116269);
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
        AppMethodBeat.m2505o(116269);
    }

    public C24186a(Rect rect) {
        AppMethodBeat.m2504i(116264);
        this.cch = rect;
        AppMethodBeat.m2505o(116264);
    }

    public C24186a() {
        AppMethodBeat.m2504i(116265);
        AppMethodBeat.m2505o(116265);
    }

    /* renamed from: jz */
    public static void m37171jz(int i) {
        AppMethodBeat.m2504i(116266);
        eHb.setAlpha(i);
        eGX.setAlpha(i);
        eHa.setAlpha((int) (0.7058824f * ((float) i)));
        AppMethodBeat.m2505o(116266);
    }

    /* renamed from: jA */
    public static void m37170jA(int i) {
        AppMethodBeat.m2504i(116267);
        eGZ.setAlpha((int) (0.9019608f * ((float) i)));
        AppMethodBeat.m2505o(116267);
    }

    public final Object clone() {
        AppMethodBeat.m2504i(116268);
        Object clone = super.clone();
        AppMethodBeat.m2505o(116268);
        return clone;
    }
}
