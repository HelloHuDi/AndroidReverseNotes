package com.tencent.p177mm.plugin.appbrand;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.soter.core.biometric.FaceManager;

/* renamed from: com.tencent.mm.plugin.appbrand.ah */
public final class C24681ah extends C18997aj {
    /* Access modifiers changed, original: protected|final */
    /* renamed from: dx */
    public final void mo34255dx(boolean z) {
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: y */
    public final int mo34257y(Intent intent) {
        AppMethodBeat.m2504i(129170);
        int intExtra = intent.getIntExtra("SCENE", -1);
        if (intExtra == 2) {
            AppMethodBeat.m2505o(129170);
            return FaceManager.FACE_ACQUIRED_RIGHT;
        } else if (intExtra == 1) {
            AppMethodBeat.m2505o(129170);
            return FaceManager.FACE_ACQUIRED_LEFT;
        } else {
            AppMethodBeat.m2505o(129170);
            return -1;
        }
    }

    public final int getType() {
        return 3;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: z */
    public final boolean mo34258z(Intent intent) {
        boolean z;
        AppMethodBeat.m2504i(129171);
        boolean z2 = super.mo34258z(intent);
        if (mo34257y(intent) == -1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            C4990ab.m7416i("MiroMsg.WxaManufacturerShortcutEntry", "invalid scene ");
        }
        if (z || !z2) {
            AppMethodBeat.m2505o(129171);
            return false;
        }
        AppMethodBeat.m2505o(129171);
        return true;
    }
}
