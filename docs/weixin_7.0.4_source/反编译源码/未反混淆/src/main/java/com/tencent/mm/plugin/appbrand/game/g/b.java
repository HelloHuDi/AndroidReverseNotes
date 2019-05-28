package com.tencent.mm.plugin.appbrand.game.g;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class b {
    private static boolean hrA = false;

    public static void cH(Context context) {
        AppMethodBeat.i(130340);
        String str = q.etl.epF;
        if (hrA) {
            ab.i("MicroMsg.WAGameShowFailDialogUtil", "hy: already shown");
            AppMethodBeat.o(130340);
            return;
        }
        String string = ah.getResources().getString(R.string.ux);
        String string2 = ah.getResources().getString(R.string.tz);
        if (bo.isNullOrNil(str)) {
            str = string;
        }
        a.a(context, str, string2, ah.getResources().getString(R.string.s6), "", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(130337);
                b.hrA = false;
                AppMethodBeat.o(130337);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(130338);
                b.hrA = false;
                AppMethodBeat.o(130338);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(130339);
                b.hrA = false;
                AppMethodBeat.o(130339);
            }
        });
        hrA = true;
        AppMethodBeat.o(130340);
    }
}
