package com.tencent.mm.wallet_core.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.r;

public final class ae {
    public static int dOc() {
        AppMethodBeat.i(49102);
        if (r.YM()) {
            AppMethodBeat.o(49102);
            return R.string.fpv;
        }
        AppMethodBeat.o(49102);
        return R.string.fpw;
    }

    public static String dOd() {
        AppMethodBeat.i(49103);
        String str;
        if (r.YM()) {
            str = "R";
            AppMethodBeat.o(49103);
            return str;
        } else if (r.YN()) {
            str = "HK$";
            AppMethodBeat.o(49103);
            return str;
        } else {
            str = "¥";
            AppMethodBeat.o(49103);
            return str;
        }
    }

    public static String iq(Context context) {
        AppMethodBeat.i(49104);
        String string;
        if (r.YM()) {
            string = context.getString(R.string.fuc);
            AppMethodBeat.o(49104);
            return string;
        }
        string = context.getString(R.string.fub);
        AppMethodBeat.o(49104);
        return string;
    }

    public static int dOe() {
        AppMethodBeat.i(49105);
        if (r.YM()) {
            AppMethodBeat.o(49105);
            return R.layout.b5o;
        }
        AppMethodBeat.o(49105);
        return R.layout.b3y;
    }

    public static int dOf() {
        AppMethodBeat.i(49106);
        if (r.YM()) {
            AppMethodBeat.o(49106);
            return R.string.fb3;
        }
        AppMethodBeat.o(49106);
        return R.string.fb0;
    }

    public static int dOg() {
        AppMethodBeat.i(49107);
        if (r.YM()) {
            AppMethodBeat.o(49107);
            return R.layout.rq;
        }
        AppMethodBeat.o(49107);
        return R.layout.rp;
    }

    public static String ir(Context context) {
        AppMethodBeat.i(49108);
        String string;
        if (r.YM()) {
            string = context.getString(R.string.fq5);
            AppMethodBeat.o(49108);
            return string;
        }
        string = context.getString(R.string.fq4);
        AppMethodBeat.o(49108);
        return string;
    }

    public static String is(Context context) {
        AppMethodBeat.i(49109);
        String string;
        if (r.YM()) {
            string = context.getString(R.string.fno);
            AppMethodBeat.o(49109);
            return string;
        }
        string = context.getString(R.string.fnn);
        AppMethodBeat.o(49109);
        return string;
    }

    public static String it(Context context) {
        AppMethodBeat.i(49110);
        String string;
        if (r.YM()) {
            string = context.getString(R.string.ftc);
            AppMethodBeat.o(49110);
            return string;
        }
        string = context.getString(R.string.ftb);
        AppMethodBeat.o(49110);
        return string;
    }

    public static int dOh() {
        AppMethodBeat.i(49111);
        if (r.YM()) {
            AppMethodBeat.o(49111);
            return R.string.fcx;
        }
        AppMethodBeat.o(49111);
        return R.string.fcw;
    }
}
