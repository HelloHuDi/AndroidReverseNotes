package com.tencent.p177mm.plugin.p369d.p370a.p374c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p369d.p370a.p1606e.C42904a;
import com.tencent.p177mm.plugin.p369d.p370a.p374c.C38834c.C38833a;
import com.tencent.p177mm.plugin.p369d.p370a.p374c.C38834c.C38835c;
import com.tencent.p177mm.plugin.p369d.p370a.p374c.C38834c.C38836b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.d.a.c.b */
public final class C27699b {
    public BluetoothDevice hGa;
    public long jIC;
    public C38833a jID = null;
    public C38836b jIE = null;
    public C38835c jIF = null;
    public long mSessionId;
    public int mState = 0;

    public C27699b(long j) {
        AppMethodBeat.m2504i(18483);
        this.jIC = j;
        this.mSessionId = j;
        this.hGa = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(C42904a.m76179gC(j));
        AppMethodBeat.m2505o(18483);
    }

    public final void disconnect() {
        AppMethodBeat.m2504i(18484);
        C4990ab.m7416i("MicroMsg.exdevice.BluetoothChatSession", "disconnect");
        this.mState = 0;
        if (this.jID != null) {
            this.jID.disconnect();
            this.jID = null;
        }
        if (this.jIE != null) {
            this.jIE.cancel();
            this.jIE = null;
        }
        if (this.jIF != null) {
            this.jIF.cancel();
            this.jIF = null;
        }
        AppMethodBeat.m2505o(18484);
    }
}
