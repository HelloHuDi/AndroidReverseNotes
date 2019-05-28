package com.tencent.mm.as;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.model.at;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public class a implements at {
    private static HandlerThread fCS = null;
    private static ak fCT = null;

    public static boolean h(Runnable runnable, long j) {
        boolean z = false;
        AppMethodBeat.i(62297);
        if (runnable == null) {
            AppMethodBeat.o(62297);
            return false;
        }
        if (fCT == null || fCS == null) {
            String str = "MicroMsg.GIF.SubCoreGIF";
            String str2 = "check decoder thread available fail, handler[%B] thread[%B] stack[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(fCT != null);
            if (fCS != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = bo.dpG();
            ab.w(str, str2, objArr);
            if (fCT != null) {
                fCT.removeCallbacksAndMessages(null);
            }
            if (fCS != null) {
                fCS.quit();
            }
            HandlerThread anM = d.anM("GIF-Decoder");
            fCS = anM;
            anM.start();
            fCT = new ak(fCS.getLooper());
        }
        if (j > 0) {
            fCT.postDelayed(runnable, j);
        } else {
            fCT.post(runnable);
        }
        AppMethodBeat.o(62297);
        return true;
    }

    public final HashMap<Integer, h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(62298);
        if (fCT != null) {
            fCT.removeCallbacksAndMessages(null);
        }
        AppMethodBeat.o(62298);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(62299);
        if (fCT != null) {
            fCT.removeCallbacksAndMessages(null);
        }
        AppMethodBeat.o(62299);
    }
}
