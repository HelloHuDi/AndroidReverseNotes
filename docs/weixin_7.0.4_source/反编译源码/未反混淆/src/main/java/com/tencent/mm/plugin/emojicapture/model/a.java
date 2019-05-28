package com.tencent.mm.plugin.emojicapture.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.ResourcePathMapper;
import java.io.IOException;

public final class a {
    public static final String lhq = (e.eSk + "bgcut/");

    static {
        AppMethodBeat.i(2559);
        AppMethodBeat.o(2559);
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
        AppMethodBeat.i(2554);
        try {
            if (com.tencent.mm.vfs.e.ct("assets:///bgcut/version.txt")) {
                ank = bo.ank(com.tencent.mm.vfs.e.cy("assets:///bgcut/version.txt"));
            } else {
                ank = 0;
            }
            try {
                if (com.tencent.mm.vfs.e.ct(lhq + "version.txt")) {
                    i = bo.ank(com.tencent.mm.vfs.e.cy(lhq + "version.txt"));
                }
            } catch (IOException e2) {
                e = e2;
                ab.printErrStackTrace("MicroMsg.BgCutSoLogic", e, "", new Object[0]);
                if (ank > i) {
                }
                if (!com.tencent.mm.vfs.e.ct(lhq + "libsegmentern.so")) {
                }
                if (!com.tencent.mm.vfs.e.ct(lhq + "libsegmentero.so")) {
                }
                ResourcePathMapper.setResPath("so3", lhq);
                ResourcePathMapper.setResPath("so4", lhq);
                ResourcePathMapper.setResPath("model5", "assets://");
                AppMethodBeat.o(2554);
            }
        } catch (IOException e3) {
            e = e3;
            ank = 0;
            ab.printErrStackTrace("MicroMsg.BgCutSoLogic", e, "", new Object[0]);
            if (ank > i) {
            }
            if (com.tencent.mm.vfs.e.ct(lhq + "libsegmentern.so")) {
            }
            if (com.tencent.mm.vfs.e.ct(lhq + "libsegmentero.so")) {
            }
            ResourcePathMapper.setResPath("so3", lhq);
            ResourcePathMapper.setResPath("so4", lhq);
            ResourcePathMapper.setResPath("model5", "assets://");
            AppMethodBeat.o(2554);
        }
        if (ank > i) {
            ab.i("MicroMsg.BgCutSoLogic", "checkFile: version upgrade");
            com.tencent.mm.vfs.e.N(lhq, true);
            com.tencent.mm.vfs.e.tf(lhq);
            com.tencent.mm.vfs.e.y("assets:///bgcut/version.txt", lhq + "version.txt");
        }
        if (com.tencent.mm.vfs.e.ct(lhq + "libsegmentern.so")) {
            com.tencent.mm.vfs.e.y("assets:///bgcut/libsegmentern.so", lhq + "libsegmentern.so");
        }
        if (com.tencent.mm.vfs.e.ct(lhq + "libsegmentero.so")) {
            com.tencent.mm.vfs.e.y("assets:///bgcut/libsegmentero.so", lhq + "libsegmentero.so");
        }
        ResourcePathMapper.setResPath("so3", lhq);
        ResourcePathMapper.setResPath("so4", lhq);
        ResourcePathMapper.setResPath("model5", "assets://");
        AppMethodBeat.o(2554);
    }

    public static void bmG() {
        AppMethodBeat.i(2555);
        ResourcePathMapper.setResPath("so3", null);
        ResourcePathMapper.setResPath("so4", null);
        ResourcePathMapper.setResPath("model5", null);
        AppMethodBeat.o(2555);
    }

    public static void bmH() {
        AppMethodBeat.i(2556);
        as.amF("emoji_segment_so").putInt("load_start", as.amF("emoji_segment_so").getInt("load_start", 0) + 1);
        as.amF("emoji_segment_so").commit();
        ab.i("MicroMsg.BgCutSoLogic", "markStart:%s", Integer.valueOf(r0 + 1));
        AppMethodBeat.o(2556);
    }

    public static void bmI() {
        AppMethodBeat.i(2557);
        as.amF("emoji_segment_so").putInt("load_end", as.amF("emoji_segment_so").getInt("load_start", 0));
        as.amF("emoji_segment_so").commit();
        ab.i("MicroMsg.BgCutSoLogic", "markEnd:%s", Integer.valueOf(r0));
        AppMethodBeat.o(2557);
    }

    public static boolean bmJ() {
        int i = 5;
        AppMethodBeat.i(2558);
        int i2 = as.amF("emoji_segment_so").getInt("load_start", 0);
        int i3 = as.amF("emoji_segment_so").getInt("load_end", 0);
        try {
            i = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_emoji_segment_crash_manual_count, 5);
        } catch (Exception e) {
        }
        boolean z = i2 - i3 <= i;
        ab.i("MicroMsg.BgCutSoLogic", "checkManualStart: %s, %s", Boolean.valueOf(z), Integer.valueOf(i));
        if (!z) {
            d dVar = d.lhz;
            d.bnq();
        }
        AppMethodBeat.o(2558);
        return z;
    }
}
