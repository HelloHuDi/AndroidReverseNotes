package com.tencent.mm.ui.widget.b;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.aj;

public final class b {
    private static DisplayMetrics yHR = null;

    public static class a {
        public int jiU;
        public int jiV;
        public int rDO;
        public int zSf;

        public final String toString() {
            AppMethodBeat.i(112779);
            String str = " marginLeft:" + this.jiU + " marginRight:" + this.jiV;
            AppMethodBeat.o(112779);
            return str;
        }
    }

    public static a a(Context context, int i, int i2, int i3, int i4, int i5, boolean z) {
        int i6;
        int i7;
        int i8;
        AppMethodBeat.i(112780);
        a aVar = new a();
        if (yHR == null) {
            yHR = context.getResources().getDisplayMetrics();
        }
        DisplayMetrics displayMetrics = yHR;
        int fromDPToPix = aj.fromDPToPix(context, 95);
        if (i < fromDPToPix) {
            i = fromDPToPix;
        }
        if (i2 < 0) {
            aVar.jiU = 0;
            aVar.jiV = displayMetrics.widthPixels - ((i5 * 2) + i);
            i6 = 0;
            i7 = 1;
        } else if (displayMetrics.widthPixels - ((i2 + i) + (i5 * 2)) < 0) {
            aVar.jiU = (i2 - i) - i5;
            aVar.jiV = (displayMetrics.widthPixels - i2) - i5;
            i6 = 1;
            i7 = 0;
        } else {
            aVar.jiU = i2;
            aVar.jiV = displayMetrics.widthPixels - (i2 + i);
            i6 = 0;
            i7 = 1;
        }
        if (i3 < 0 || i3 > displayMetrics.heightPixels) {
            i3 = (int) (((float) displayMetrics.heightPixels) / 2.0f);
        }
        if (z) {
            if (i3 >= i4 + i5) {
                aVar.rDO = (i3 - i5) - i4;
                fromDPToPix = 0;
                i8 = 1;
            }
            aVar.rDO = i3 - i5;
            fromDPToPix = 1;
            i8 = 0;
        } else {
            if (displayMetrics.heightPixels - i3 < (i5 * 3) + i4) {
                aVar.rDO = (i3 - i5) - i4;
                fromDPToPix = 0;
                i8 = 1;
            }
            aVar.rDO = i3 - i5;
            fromDPToPix = 1;
            i8 = 0;
        }
        if (i8 != 0) {
            aVar.rDO -= i5 * 2;
        } else if (fromDPToPix != 0) {
            aVar.rDO += i5 * 2;
        }
        if (i7 == 0 || fromDPToPix == 0) {
            if (i6 != 0 && fromDPToPix != 0) {
                aVar.zSf = R.style.q0;
                AppMethodBeat.o(112780);
                return aVar;
            } else if (i7 != 0 && i8 != 0) {
                aVar.zSf = R.style.px;
                AppMethodBeat.o(112780);
                return aVar;
            } else if (!(i6 == 0 || i8 == 0)) {
                aVar.zSf = R.style.pz;
                AppMethodBeat.o(112780);
                return aVar;
            }
        }
        aVar.zSf = R.style.py;
        AppMethodBeat.o(112780);
        return aVar;
    }
}
