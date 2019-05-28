package com.tencent.p177mm.plugin.clean.p362c;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.p398f.C45913b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.clean.c.j */
public final class C6826j implements C1816at {
    private static C6826j kwJ;
    public long kvV;
    public long kvW;
    public long kvX;
    public HashMap<String, Long> kwI;
    public HashSet<String> kww;

    public static C6826j bgd() {
        AppMethodBeat.m2504i(18718);
        if (kwJ == null) {
            kwJ = new C6826j();
        }
        C6826j c6826j = kwJ;
        AppMethodBeat.m2505o(18718);
        return c6826j;
    }

    private C6826j() {
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
        AppMethodBeat.m2504i(18719);
        C27642d.bfX();
        AppMethodBeat.m2505o(18719);
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(18720);
        C4990ab.m7417i("MicroMsg.SubCoreClean", "summerclean onAccountPostReset updated[%b]", Boolean.valueOf(z));
        C45913b.aZc().onAccountInitialized(null);
        AppMethodBeat.m2505o(18720);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
        AppMethodBeat.m2504i(18721);
        C4990ab.m7417i("MicroMsg.SubCoreClean", "summerclean onSdcardMount mounted[%b]", Boolean.valueOf(z));
        AppMethodBeat.m2505o(18721);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(18722);
        C4990ab.m7416i("MicroMsg.SubCoreClean", "summerclean onAccountRelease");
        this.kvV = 0;
        this.kvW = 0;
        this.kvX = 0;
        if (this.kwI != null) {
            this.kwI.clear();
        }
        if (this.kww != null) {
            this.kww.clear();
        }
        C27642d.bfX();
        C45913b.aZc().onAccountRelease();
        AppMethodBeat.m2505o(18722);
    }

    public static long bfL() {
        long blockSize;
        AppMethodBeat.m2504i(18723);
        try {
            StatFs statFs = new StatFs(C6457e.eSl);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Exception e) {
            blockSize = 0;
        }
        if (blockSize <= 0) {
            AppMethodBeat.m2505o(18723);
            return 1;
        }
        AppMethodBeat.m2505o(18723);
        return blockSize;
    }

    public static long bfM() {
        long blockSize;
        AppMethodBeat.m2504i(18724);
        try {
            StatFs statFs = new StatFs(C6457e.eSl);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Exception e) {
            blockSize = 0;
        }
        if (blockSize <= 0) {
            AppMethodBeat.m2505o(18724);
            return 1;
        }
        AppMethodBeat.m2505o(18724);
        return blockSize;
    }

    public static void bge() {
        AppMethodBeat.m2504i(18725);
        C45913b.aZc().aZe();
        AppMethodBeat.m2505o(18725);
    }
}
