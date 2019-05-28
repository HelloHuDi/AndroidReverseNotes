package com.tencent.p177mm.wallet_core.p649c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;

/* renamed from: com.tencent.mm.wallet_core.c.ae */
public final class C44423ae {
    public static int dOc() {
        AppMethodBeat.m2504i(49102);
        if (C1853r.m3831YM()) {
            AppMethodBeat.m2505o(49102);
            return C25738R.string.fpv;
        }
        AppMethodBeat.m2505o(49102);
        return C25738R.string.fpw;
    }

    public static String dOd() {
        AppMethodBeat.m2504i(49103);
        String str;
        if (C1853r.m3831YM()) {
            str = "R";
            AppMethodBeat.m2505o(49103);
            return str;
        } else if (C1853r.m3832YN()) {
            str = "HK$";
            AppMethodBeat.m2505o(49103);
            return str;
        } else {
            str = "¥";
            AppMethodBeat.m2505o(49103);
            return str;
        }
    }

    /* renamed from: iq */
    public static String m80308iq(Context context) {
        AppMethodBeat.m2504i(49104);
        String string;
        if (C1853r.m3831YM()) {
            string = context.getString(C25738R.string.fuc);
            AppMethodBeat.m2505o(49104);
            return string;
        }
        string = context.getString(C25738R.string.fub);
        AppMethodBeat.m2505o(49104);
        return string;
    }

    public static int dOe() {
        AppMethodBeat.m2504i(49105);
        if (C1853r.m3831YM()) {
            AppMethodBeat.m2505o(49105);
            return 2130971151;
        }
        AppMethodBeat.m2505o(49105);
        return 2130971087;
    }

    public static int dOf() {
        AppMethodBeat.m2504i(49106);
        if (C1853r.m3831YM()) {
            AppMethodBeat.m2505o(49106);
            return C25738R.string.fb3;
        }
        AppMethodBeat.m2505o(49106);
        return C25738R.string.fb0;
    }

    public static int dOg() {
        AppMethodBeat.m2504i(49107);
        if (C1853r.m3831YM()) {
            AppMethodBeat.m2505o(49107);
            return 2130969260;
        }
        AppMethodBeat.m2505o(49107);
        return 2130969259;
    }

    /* renamed from: ir */
    public static String m80309ir(Context context) {
        AppMethodBeat.m2504i(49108);
        String string;
        if (C1853r.m3831YM()) {
            string = context.getString(C25738R.string.fq5);
            AppMethodBeat.m2505o(49108);
            return string;
        }
        string = context.getString(C25738R.string.fq4);
        AppMethodBeat.m2505o(49108);
        return string;
    }

    /* renamed from: is */
    public static String m80310is(Context context) {
        AppMethodBeat.m2504i(49109);
        String string;
        if (C1853r.m3831YM()) {
            string = context.getString(C25738R.string.fno);
            AppMethodBeat.m2505o(49109);
            return string;
        }
        string = context.getString(C25738R.string.fnn);
        AppMethodBeat.m2505o(49109);
        return string;
    }

    /* renamed from: it */
    public static String m80311it(Context context) {
        AppMethodBeat.m2504i(49110);
        String string;
        if (C1853r.m3831YM()) {
            string = context.getString(C25738R.string.ftc);
            AppMethodBeat.m2505o(49110);
            return string;
        }
        string = context.getString(C25738R.string.ftb);
        AppMethodBeat.m2505o(49110);
        return string;
    }

    public static int dOh() {
        AppMethodBeat.m2504i(49111);
        if (C1853r.m3831YM()) {
            AppMethodBeat.m2505o(49111);
            return C25738R.string.fcx;
        }
        AppMethodBeat.m2505o(49111);
        return C25738R.string.fcw;
    }
}
