package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.aj;

public final class h {
    public static boolean fR(final Context context) {
        AppMethodBeat.i(79947);
        if (aj.amA("network_doctor_shown")) {
            com.tencent.mm.ui.base.h.a(context, (int) R.string.d5w, (int) R.string.tz, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(79946);
                    context.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                    AppMethodBeat.o(79946);
                }
            }, null);
            AppMethodBeat.o(79947);
            return true;
        }
        AppMethodBeat.o(79947);
        return false;
    }
}
