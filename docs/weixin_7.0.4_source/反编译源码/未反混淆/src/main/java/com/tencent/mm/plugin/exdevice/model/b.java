package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class b implements f {
    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(19089);
        ab.i("MicroMsg.exdevice.ExDeviceMessageService", "onScenend, errType = %d, errCode = %d, errMsg = ", Integer.valueOf(i), Integer.valueOf(i2), str);
        AppMethodBeat.o(19089);
    }
}
