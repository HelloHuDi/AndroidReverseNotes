package com.tencent.p177mm.plugin.emojicapture.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.ResourcePathMapper;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.emojicapture.model.a */
public final class C2958a {
    public static final String lhq = (C6457e.eSk + "bgcut/");

    static {
        AppMethodBeat.m2504i(2559);
        AppMethodBeat.m2505o(2559);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void bmF() {
        int ank;
        Throwable e;
        int i = 0;
        AppMethodBeat.m2504i(2554);
        try {
            if (C5730e.m8628ct("assets:///bgcut/version.txt")) {
                ank = C5046bo.ank(C5730e.m8631cy("assets:///bgcut/version.txt"));
            } else {
                ank = 0;
            }
            try {
                if (C5730e.m8628ct(lhq + "version.txt")) {
                    i = C5046bo.ank(C5730e.m8631cy(lhq + "version.txt"));
                }
            } catch (IOException e2) {
                e = e2;
                C4990ab.printErrStackTrace("MicroMsg.BgCutSoLogic", e, "", new Object[0]);
                if (ank > i) {
                }
                if (!C5730e.m8628ct(lhq + "libsegmentern.so")) {
                }
                if (!C5730e.m8628ct(lhq + "libsegmentero.so")) {
                }
                ResourcePathMapper.setResPath("so3", lhq);
                ResourcePathMapper.setResPath("so4", lhq);
                ResourcePathMapper.setResPath("model5", "assets://");
                AppMethodBeat.m2505o(2554);
            }
        } catch (IOException e3) {
            e = e3;
            ank = 0;
            C4990ab.printErrStackTrace("MicroMsg.BgCutSoLogic", e, "", new Object[0]);
            if (ank > i) {
            }
            if (C5730e.m8628ct(lhq + "libsegmentern.so")) {
            }
            if (C5730e.m8628ct(lhq + "libsegmentero.so")) {
            }
            ResourcePathMapper.setResPath("so3", lhq);
            ResourcePathMapper.setResPath("so4", lhq);
            ResourcePathMapper.setResPath("model5", "assets://");
            AppMethodBeat.m2505o(2554);
        }
        if (ank > i) {
            C4990ab.m7416i("MicroMsg.BgCutSoLogic", "checkFile: version upgrade");
            C5730e.m8618N(lhq, true);
            C5730e.m8643tf(lhq);
            C5730e.m8644y("assets:///bgcut/version.txt", lhq + "version.txt");
        }
        if (C5730e.m8628ct(lhq + "libsegmentern.so")) {
            C5730e.m8644y("assets:///bgcut/libsegmentern.so", lhq + "libsegmentern.so");
        }
        if (C5730e.m8628ct(lhq + "libsegmentero.so")) {
            C5730e.m8644y("assets:///bgcut/libsegmentero.so", lhq + "libsegmentero.so");
        }
        ResourcePathMapper.setResPath("so3", lhq);
        ResourcePathMapper.setResPath("so4", lhq);
        ResourcePathMapper.setResPath("model5", "assets://");
        AppMethodBeat.m2505o(2554);
    }

    public static void bmG() {
        AppMethodBeat.m2504i(2555);
        ResourcePathMapper.setResPath("so3", null);
        ResourcePathMapper.setResPath("so4", null);
        ResourcePathMapper.setResPath("model5", null);
        AppMethodBeat.m2505o(2555);
    }

    public static void bmH() {
        AppMethodBeat.m2504i(2556);
        C5018as.amF("emoji_segment_so").putInt("load_start", C5018as.amF("emoji_segment_so").getInt("load_start", 0) + 1);
        C5018as.amF("emoji_segment_so").commit();
        C4990ab.m7417i("MicroMsg.BgCutSoLogic", "markStart:%s", Integer.valueOf(r0 + 1));
        AppMethodBeat.m2505o(2556);
    }

    public static void bmI() {
        AppMethodBeat.m2504i(2557);
        C5018as.amF("emoji_segment_so").putInt("load_end", C5018as.amF("emoji_segment_so").getInt("load_start", 0));
        C5018as.amF("emoji_segment_so").commit();
        C4990ab.m7417i("MicroMsg.BgCutSoLogic", "markEnd:%s", Integer.valueOf(r0));
        AppMethodBeat.m2505o(2557);
    }

    public static boolean bmJ() {
        int i = 5;
        AppMethodBeat.m2504i(2558);
        int i2 = C5018as.amF("emoji_segment_so").getInt("load_start", 0);
        int i3 = C5018as.amF("emoji_segment_so").getInt("load_end", 0);
        try {
            i = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_emoji_segment_crash_manual_count, 5);
        } catch (Exception e) {
        }
        boolean z = i2 - i3 <= i;
        C4990ab.m7417i("MicroMsg.BgCutSoLogic", "checkManualStart: %s, %s", Boolean.valueOf(z), Integer.valueOf(i));
        if (!z) {
            C34007d c34007d = C34007d.lhz;
            C34007d.bnq();
        }
        AppMethodBeat.m2505o(2558);
        return z;
    }
}
