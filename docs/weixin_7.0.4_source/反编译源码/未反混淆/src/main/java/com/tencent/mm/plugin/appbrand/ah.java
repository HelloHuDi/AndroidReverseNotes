package com.tencent.mm.plugin.appbrand;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.core.biometric.FaceManager;

public final class ah extends aj {
    /* Access modifiers changed, original: protected|final */
    public final void dx(boolean z) {
    }

    /* Access modifiers changed, original: protected|final */
    public final int y(Intent intent) {
        AppMethodBeat.i(129170);
        int intExtra = intent.getIntExtra("SCENE", -1);
        if (intExtra == 2) {
            AppMethodBeat.o(129170);
            return FaceManager.FACE_ACQUIRED_RIGHT;
        } else if (intExtra == 1) {
            AppMethodBeat.o(129170);
            return FaceManager.FACE_ACQUIRED_LEFT;
        } else {
            AppMethodBeat.o(129170);
            return -1;
        }
    }

    public final int getType() {
        return 3;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean z(Intent intent) {
        boolean z;
        AppMethodBeat.i(129171);
        boolean z2 = super.z(intent);
        if (y(intent) == -1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ab.i("MiroMsg.WxaManufacturerShortcutEntry", "invalid scene ");
        }
        if (z || !z2) {
            AppMethodBeat.o(129171);
            return false;
        }
        AppMethodBeat.o(129171);
        return true;
    }
}
