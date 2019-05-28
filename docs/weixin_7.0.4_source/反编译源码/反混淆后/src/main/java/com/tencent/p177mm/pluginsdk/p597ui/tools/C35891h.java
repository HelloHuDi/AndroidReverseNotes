package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.sdk.platformtools.C4997aj;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.h */
public final class C35891h {
    /* renamed from: fR */
    public static boolean m58839fR(final Context context) {
        AppMethodBeat.m2504i(79947);
        if (C4997aj.amA("network_doctor_shown")) {
            C30379h.m48432a(context, (int) C25738R.string.d5w, (int) C25738R.string.f9238tz, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(79946);
                    context.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                    AppMethodBeat.m2505o(79946);
                }
            }, null);
            AppMethodBeat.m2505o(79947);
            return true;
        }
        AppMethodBeat.m2505o(79947);
        return false;
    }
}
