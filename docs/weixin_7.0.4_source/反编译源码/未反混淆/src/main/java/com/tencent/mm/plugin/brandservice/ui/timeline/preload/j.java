package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bp;

public final class j {
    public static void FQ(String str) {
        AppMethodBeat.i(14391);
        de("MicroMsg.PreloadUtil", str);
        AppMethodBeat.o(14391);
    }

    public static void de(String str, final String str2) {
        AppMethodBeat.i(14392);
        if (ab.getLogLevel() == 0 && bp.dpL()) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(14390);
                    Toast.makeText(ah.getContext(), str2, 0).show();
                    AppMethodBeat.o(14390);
                }
            });
        }
        ab.i(str, str2);
        AppMethodBeat.o(14392);
    }
}
