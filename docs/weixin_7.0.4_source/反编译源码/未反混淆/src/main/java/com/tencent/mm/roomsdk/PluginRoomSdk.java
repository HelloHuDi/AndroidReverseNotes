package com.tencent.mm.roomsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ab;

public class PluginRoomSdk extends f implements c {
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(80236);
        ab.i("MicroMsg.PluginRoomSdk", "onAccountInitialized");
        AppMethodBeat.o(80236);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(80237);
        ab.i("MicroMsg.PluginRoomSdk", "onAccountRelease");
        AppMethodBeat.o(80237);
    }

    public void execute(g gVar) {
    }

    public void configure(g gVar) {
    }
}
