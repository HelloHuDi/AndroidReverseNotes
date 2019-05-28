package com.tencent.mm.plugin.exdevice.service;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class x implements m {
    private h lwT;

    public x(h hVar) {
        this.lwT = hVar;
    }

    public final boolean b(int i, j jVar) {
        boolean z = false;
        AppMethodBeat.i(19633);
        try {
            z = this.lwT.b(i, jVar);
            AppMethodBeat.o(19633);
        } catch (RemoteException e) {
            ab.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "scan failed!!! %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.o(19633);
        }
        return z;
    }

    public final boolean c(int i, j jVar) {
        boolean z = false;
        AppMethodBeat.i(19634);
        try {
            z = this.lwT.c(i, jVar);
            AppMethodBeat.o(19634);
        } catch (RemoteException e) {
            ab.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "stopScan failed!!! %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.o(19634);
        }
        return z;
    }

    public final long[] bpl() {
        AppMethodBeat.i(19635);
        try {
            long[] bpl = this.lwT.bpl();
            AppMethodBeat.o(19635);
            return bpl;
        } catch (RemoteException e) {
            ab.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "getDeviceList failed!!! %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            AppMethodBeat.o(19635);
            return null;
        }
    }

    public final boolean a(long j, int i, k kVar) {
        boolean z = false;
        AppMethodBeat.i(19636);
        u.bpx().hW(j);
        try {
            z = this.lwT.a(j, i, kVar);
            AppMethodBeat.o(19636);
        } catch (RemoteException e) {
            ab.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "startChannel failed!!! %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.o(19636);
        }
        return z;
    }

    public final boolean hZ(long j) {
        boolean z = false;
        AppMethodBeat.i(19637);
        u.bpx().hW(j);
        try {
            z = this.lwT.hZ(j);
            AppMethodBeat.o(19637);
        } catch (RemoteException e) {
            ab.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "stopChannel failed!!! %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.o(19637);
        }
        return z;
    }

    public final long a(p pVar) {
        AppMethodBeat.i(19638);
        try {
            long a = this.lwT.a(pVar);
            AppMethodBeat.o(19638);
            return a;
        } catch (RemoteException e) {
            ab.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "startTask failed!!! %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            AppMethodBeat.o(19638);
            return -1;
        }
    }

    public final boolean a(i iVar) {
        boolean z = false;
        AppMethodBeat.i(19639);
        try {
            z = this.lwT.a(iVar);
            AppMethodBeat.o(19639);
        } catch (RemoteException e) {
            ab.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "registOnDeviceRequest failed!!! %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.o(19639);
        }
        return z;
    }

    public final void setChannelSessionKey(long j, byte[] bArr) {
        AppMethodBeat.i(19640);
        ab.i("MicroMsg.exdevice.RDeviceTaskDispatcher", "------setChannelSessionKey------ deviceId = %d", Long.valueOf(j));
        try {
            this.lwT.setChannelSessionKey(j, bArr);
            AppMethodBeat.o(19640);
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            AppMethodBeat.o(19640);
        }
    }

    public final boolean a(String str, boolean z, q qVar) {
        boolean z2 = false;
        AppMethodBeat.i(19641);
        ab.i("MicroMsg.exdevice.RDeviceTaskDispatcher", "ranging, uuid = %s, op = %s", str, String.valueOf(z));
        try {
            z2 = this.lwT.a(str, z, qVar);
            AppMethodBeat.o(19641);
        } catch (RemoteException e) {
            ab.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "mDispatcher.ranging failed!!!(%s)", e.getMessage());
            ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z2]);
            AppMethodBeat.o(19641);
        }
        return z2;
    }

    public final boolean b(n nVar) {
        AppMethodBeat.i(19642);
        try {
            this.lwT.a(nVar);
            AppMethodBeat.o(19642);
            return true;
        } catch (RemoteException e) {
            ab.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "mDispatcher.registExDeviceInvokerHandler failed!!, %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            AppMethodBeat.o(19642);
            return false;
        }
    }

    public final boolean a(j jVar) {
        boolean z = false;
        AppMethodBeat.i(19643);
        try {
            z = this.lwT.d(0, jVar);
            AppMethodBeat.o(19643);
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.o(19643);
        }
        return z;
    }

    public final boolean b(j jVar) {
        boolean z = false;
        AppMethodBeat.i(19644);
        try {
            z = this.lwT.e(0, jVar);
            AppMethodBeat.o(19644);
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.o(19644);
        }
        return z;
    }

    public final boolean a(long j, k kVar) {
        boolean z = false;
        AppMethodBeat.i(19645);
        try {
            z = this.lwT.b(j, 0, kVar);
            AppMethodBeat.o(19645);
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.o(19645);
        }
        return z;
    }

    public final boolean ic(long j) {
        boolean z = false;
        AppMethodBeat.i(19646);
        try {
            z = this.lwT.ic(j);
            AppMethodBeat.o(19646);
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.o(19646);
        }
        return z;
    }

    public final boolean a(s sVar) {
        boolean z = false;
        AppMethodBeat.i(19647);
        try {
            z = this.lwT.a(sVar);
            AppMethodBeat.o(19647);
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.o(19647);
        }
        return z;
    }

    public final boolean b(long j, byte[] bArr, t tVar) {
        boolean z = false;
        AppMethodBeat.i(19648);
        try {
            z = this.lwT.b(j, bArr, tVar);
            AppMethodBeat.o(19648);
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.o(19648);
        }
        return z;
    }
}
