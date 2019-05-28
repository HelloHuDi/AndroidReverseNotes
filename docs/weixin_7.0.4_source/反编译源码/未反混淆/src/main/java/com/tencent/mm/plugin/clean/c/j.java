package com.tencent.mm.plugin.clean.c;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.HashSet;

public final class j implements at {
    private static j kwJ;
    public long kvV;
    public long kvW;
    public long kvX;
    public HashMap<String, Long> kwI;
    public HashSet<String> kww;

    public static j bgd() {
        AppMethodBeat.i(18718);
        if (kwJ == null) {
            kwJ = new j();
        }
        j jVar = kwJ;
        AppMethodBeat.o(18718);
        return jVar;
    }

    private j() {
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
        AppMethodBeat.i(18719);
        d.bfX();
        AppMethodBeat.o(18719);
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(18720);
        ab.i("MicroMsg.SubCoreClean", "summerclean onAccountPostReset updated[%b]", Boolean.valueOf(z));
        b.aZc().onAccountInitialized(null);
        AppMethodBeat.o(18720);
    }

    public final void bA(boolean z) {
        AppMethodBeat.i(18721);
        ab.i("MicroMsg.SubCoreClean", "summerclean onSdcardMount mounted[%b]", Boolean.valueOf(z));
        AppMethodBeat.o(18721);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(18722);
        ab.i("MicroMsg.SubCoreClean", "summerclean onAccountRelease");
        this.kvV = 0;
        this.kvW = 0;
        this.kvX = 0;
        if (this.kwI != null) {
            this.kwI.clear();
        }
        if (this.kww != null) {
            this.kww.clear();
        }
        d.bfX();
        b.aZc().onAccountRelease();
        AppMethodBeat.o(18722);
    }

    public static long bfL() {
        long blockSize;
        AppMethodBeat.i(18723);
        try {
            StatFs statFs = new StatFs(e.eSl);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Exception e) {
            blockSize = 0;
        }
        if (blockSize <= 0) {
            AppMethodBeat.o(18723);
            return 1;
        }
        AppMethodBeat.o(18723);
        return blockSize;
    }

    public static long bfM() {
        long blockSize;
        AppMethodBeat.i(18724);
        try {
            StatFs statFs = new StatFs(e.eSl);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Exception e) {
            blockSize = 0;
        }
        if (blockSize <= 0) {
            AppMethodBeat.o(18724);
            return 1;
        }
        AppMethodBeat.o(18724);
        return blockSize;
    }

    public static void bge() {
        AppMethodBeat.i(18725);
        b.aZc().aZe();
        AppMethodBeat.o(18725);
    }
}
