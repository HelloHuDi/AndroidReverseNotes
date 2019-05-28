package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5047bp;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.j */
public final class C38710j {
    /* renamed from: FQ */
    public static void m65657FQ(String str) {
        AppMethodBeat.m2504i(14391);
        C38710j.m65658de("MicroMsg.PreloadUtil", str);
        AppMethodBeat.m2505o(14391);
    }

    /* renamed from: de */
    public static void m65658de(String str, final String str2) {
        AppMethodBeat.m2504i(14392);
        if (C4990ab.getLogLevel() == 0 && C5047bp.dpL()) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(14390);
                    Toast.makeText(C4996ah.getContext(), str2, 0).show();
                    AppMethodBeat.m2505o(14390);
                }
            });
        }
        C4990ab.m7416i(str, str2);
        AppMethodBeat.m2505o(14392);
    }
}
