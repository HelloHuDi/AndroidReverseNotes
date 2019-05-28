package com.tencent.mm.r;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.model.ae;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    private static ae cfL;

    public static boolean bH(Context context) {
        AppMethodBeat.i(77695);
        if (Oo()) {
            ab.i("MicroMsg.DeviceOccupy", "isMultiTalking");
            Toast.makeText(context, R.string.d2p, 0).show();
            AppMethodBeat.o(77695);
            return true;
        }
        AppMethodBeat.o(77695);
        return false;
    }

    public static boolean Oo() {
        AppMethodBeat.i(77696);
        kc kcVar = new kc();
        kcVar.cFw.action = 1;
        com.tencent.mm.sdk.b.a.xxA.m(kcVar);
        boolean z = kcVar.cFx.cFy;
        AppMethodBeat.o(77696);
        return z;
    }

    public static boolean bI(Context context) {
        AppMethodBeat.i(77697);
        uh uhVar = new uh();
        com.tencent.mm.sdk.b.a.xxA.m(uhVar);
        if (uhVar.cQt.cQv) {
            ab.i("MicroMsg.DeviceOccupy", "isCameraUsing");
            Toast.makeText(context, l(context, uhVar.cQt.cQu), 0).show();
        }
        boolean z = uhVar.cQt.cQv;
        AppMethodBeat.o(77697);
        return z;
    }

    public static boolean bJ(Context context) {
        AppMethodBeat.i(77698);
        uh uhVar = new uh();
        com.tencent.mm.sdk.b.a.xxA.m(uhVar);
        if (uhVar.cQt.cQw) {
            ab.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
            Toast.makeText(context, l(context, uhVar.cQt.cQu), 0).show();
        }
        boolean z = uhVar.cQt.cQw;
        AppMethodBeat.o(77698);
        return z;
    }

    private static String l(Context context, boolean z) {
        AppMethodBeat.i(77699);
        String string;
        if (z) {
            string = context.getString(R.string.ac4);
            AppMethodBeat.o(77699);
            return string;
        }
        string = context.getString(R.string.ac5);
        AppMethodBeat.o(77699);
        return string;
    }

    public static ae Cc() {
        AppMethodBeat.i(77700);
        if (cfL == null) {
            cfL = com.tencent.mm.booter.a.Ib();
        }
        ae aeVar = cfL;
        AppMethodBeat.o(77700);
        return aeVar;
    }
}
