package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.c.c.a;
import com.tencent.mm.plugin.d.a.c.c.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class b {
    public BluetoothDevice hGa;
    public long jIC;
    public a jID = null;
    public com.tencent.mm.plugin.d.a.c.c.b jIE = null;
    public c jIF = null;
    public long mSessionId;
    public int mState = 0;

    public b(long j) {
        AppMethodBeat.i(18483);
        this.jIC = j;
        this.mSessionId = j;
        this.hGa = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(com.tencent.mm.plugin.d.a.e.a.gC(j));
        AppMethodBeat.o(18483);
    }

    public final void disconnect() {
        AppMethodBeat.i(18484);
        ab.i("MicroMsg.exdevice.BluetoothChatSession", "disconnect");
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
        AppMethodBeat.o(18484);
    }
}
