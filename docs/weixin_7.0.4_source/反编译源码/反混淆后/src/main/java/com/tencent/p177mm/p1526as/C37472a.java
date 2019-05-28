package com.tencent.p177mm.p1526as;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashMap;

/* renamed from: com.tencent.mm.as.a */
public class C37472a implements C1816at {
    private static HandlerThread fCS = null;
    private static C7306ak fCT = null;

    /* renamed from: h */
    public static boolean m63215h(Runnable runnable, long j) {
        boolean z = false;
        AppMethodBeat.m2504i(62297);
        if (runnable == null) {
            AppMethodBeat.m2505o(62297);
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
            objArr[2] = C5046bo.dpG();
            C4990ab.m7421w(str, str2, objArr);
            if (fCT != null) {
                fCT.removeCallbacksAndMessages(null);
            }
            if (fCS != null) {
                fCS.quit();
            }
            HandlerThread anM = C7305d.anM("GIF-Decoder");
            fCS = anM;
            anM.start();
            fCT = new C7306ak(fCS.getLooper());
        }
        if (j > 0) {
            fCT.postDelayed(runnable, j);
        } else {
            fCT.post(runnable);
        }
        AppMethodBeat.m2505o(62297);
        return true;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(62298);
        if (fCT != null) {
            fCT.removeCallbacksAndMessages(null);
        }
        AppMethodBeat.m2505o(62298);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(62299);
        if (fCT != null) {
            fCT.removeCallbacksAndMessages(null);
        }
        AppMethodBeat.m2505o(62299);
    }
}
