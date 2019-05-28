package com.tencent.p177mm.roomsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.roomsdk.PluginRoomSdk */
public class PluginRoomSdk extends C7597f implements C9562c {
    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(80236);
        C4990ab.m7416i("MicroMsg.PluginRoomSdk", "onAccountInitialized");
        AppMethodBeat.m2505o(80236);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(80237);
        C4990ab.m7416i("MicroMsg.PluginRoomSdk", "onAccountRelease");
        AppMethodBeat.m2505o(80237);
    }

    public void execute(C1681g c1681g) {
    }

    public void configure(C1681g c1681g) {
    }
}
