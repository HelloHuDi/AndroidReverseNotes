package com.tencent.p177mm.p612ui.widget.p1095b;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5229aj;

/* renamed from: com.tencent.mm.ui.widget.b.b */
public final class C24092b {
    private static DisplayMetrics yHR = null;

    /* renamed from: com.tencent.mm.ui.widget.b.b$a */
    public static class C24093a {
        public int jiU;
        public int jiV;
        public int rDO;
        public int zSf;

        public final String toString() {
            AppMethodBeat.m2504i(112779);
            String str = " marginLeft:" + this.jiU + " marginRight:" + this.jiV;
            AppMethodBeat.m2505o(112779);
            return str;
        }
    }

    /* renamed from: a */
    public static C24093a m37058a(Context context, int i, int i2, int i3, int i4, int i5, boolean z) {
        int i6;
        int i7;
        int i8;
        AppMethodBeat.m2504i(112780);
        C24093a c24093a = new C24093a();
        if (yHR == null) {
            yHR = context.getResources().getDisplayMetrics();
        }
        DisplayMetrics displayMetrics = yHR;
        int fromDPToPix = C5229aj.fromDPToPix(context, 95);
        if (i < fromDPToPix) {
            i = fromDPToPix;
        }
        if (i2 < 0) {
            c24093a.jiU = 0;
            c24093a.jiV = displayMetrics.widthPixels - ((i5 * 2) + i);
            i6 = 0;
            i7 = 1;
        } else if (displayMetrics.widthPixels - ((i2 + i) + (i5 * 2)) < 0) {
            c24093a.jiU = (i2 - i) - i5;
            c24093a.jiV = (displayMetrics.widthPixels - i2) - i5;
            i6 = 1;
            i7 = 0;
        } else {
            c24093a.jiU = i2;
            c24093a.jiV = displayMetrics.widthPixels - (i2 + i);
            i6 = 0;
            i7 = 1;
        }
        if (i3 < 0 || i3 > displayMetrics.heightPixels) {
            i3 = (int) (((float) displayMetrics.heightPixels) / 2.0f);
        }
        if (z) {
            if (i3 >= i4 + i5) {
                c24093a.rDO = (i3 - i5) - i4;
                fromDPToPix = 0;
                i8 = 1;
            }
            c24093a.rDO = i3 - i5;
            fromDPToPix = 1;
            i8 = 0;
        } else {
            if (displayMetrics.heightPixels - i3 < (i5 * 3) + i4) {
                c24093a.rDO = (i3 - i5) - i4;
                fromDPToPix = 0;
                i8 = 1;
            }
            c24093a.rDO = i3 - i5;
            fromDPToPix = 1;
            i8 = 0;
        }
        if (i8 != 0) {
            c24093a.rDO -= i5 * 2;
        } else if (fromDPToPix != 0) {
            c24093a.rDO += i5 * 2;
        }
        if (i7 == 0 || fromDPToPix == 0) {
            if (i6 != 0 && fromDPToPix != 0) {
                c24093a.zSf = C25738R.style.f11136q0;
                AppMethodBeat.m2505o(112780);
                return c24093a;
            } else if (i7 != 0 && i8 != 0) {
                c24093a.zSf = C25738R.style.f11133px;
                AppMethodBeat.m2505o(112780);
                return c24093a;
            } else if (!(i6 == 0 || i8 == 0)) {
                c24093a.zSf = C25738R.style.f11135pz;
                AppMethodBeat.m2505o(112780);
                return c24093a;
            }
        }
        c24093a.zSf = C25738R.style.f11134py;
        AppMethodBeat.m2505o(112780);
        return c24093a;
    }
}
