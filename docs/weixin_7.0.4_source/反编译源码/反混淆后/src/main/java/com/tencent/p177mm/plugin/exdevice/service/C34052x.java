package com.tencent.p177mm.plugin.exdevice.service;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.service.x */
public final class C34052x implements C27865m {
    private C45893h lwT;

    public C34052x(C45893h c45893h) {
        this.lwT = c45893h;
    }

    /* renamed from: b */
    public final boolean mo45756b(int i, C43000j c43000j) {
        boolean z = false;
        AppMethodBeat.m2504i(19633);
        try {
            z = this.lwT.mo45736b(i, c43000j);
            AppMethodBeat.m2505o(19633);
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.exdevice.RDeviceTaskDispatcher", "scan failed!!! %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.m2505o(19633);
        }
        return z;
    }

    /* renamed from: c */
    public final boolean mo45760c(int i, C43000j c43000j) {
        boolean z = false;
        AppMethodBeat.m2504i(19634);
        try {
            z = this.lwT.mo45741c(i, c43000j);
            AppMethodBeat.m2505o(19634);
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.exdevice.RDeviceTaskDispatcher", "stopScan failed!!! %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.m2505o(19634);
        }
        return z;
    }

    public final long[] bpl() {
        AppMethodBeat.m2504i(19635);
        try {
            long[] bpl = this.lwT.bpl();
            AppMethodBeat.m2505o(19635);
            return bpl;
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.exdevice.RDeviceTaskDispatcher", "getDeviceList failed!!! %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            AppMethodBeat.m2505o(19635);
            return null;
        }
    }

    /* renamed from: a */
    public final boolean mo45752a(long j, int i, C38959k c38959k) {
        boolean z = false;
        AppMethodBeat.m2504i(19636);
        C20548u.bpx().mo45724hW(j);
        try {
            z = this.lwT.mo45731a(j, i, c38959k);
            AppMethodBeat.m2505o(19636);
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.exdevice.RDeviceTaskDispatcher", "startChannel failed!!! %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.m2505o(19636);
        }
        return z;
    }

    /* renamed from: hZ */
    public final boolean mo45761hZ(long j) {
        boolean z = false;
        AppMethodBeat.m2504i(19637);
        C20548u.bpx().mo45724hW(j);
        try {
            z = this.lwT.mo45744hZ(j);
            AppMethodBeat.m2505o(19637);
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.exdevice.RDeviceTaskDispatcher", "stopChannel failed!!! %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.m2505o(19637);
        }
        return z;
    }

    /* renamed from: a */
    public final long mo45751a(C11661p c11661p) {
        AppMethodBeat.m2504i(19638);
        try {
            long a = this.lwT.mo45729a(c11661p);
            AppMethodBeat.m2505o(19638);
            return a;
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.exdevice.RDeviceTaskDispatcher", "startTask failed!!! %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            AppMethodBeat.m2505o(19638);
            return -1;
        }
    }

    /* renamed from: a */
    public final boolean mo54588a(C38958i c38958i) {
        boolean z = false;
        AppMethodBeat.m2504i(19639);
        try {
            z = this.lwT.mo45732a(c38958i);
            AppMethodBeat.m2505o(19639);
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.exdevice.RDeviceTaskDispatcher", "registOnDeviceRequest failed!!! %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.m2505o(19639);
        }
        return z;
    }

    public final void setChannelSessionKey(long j, byte[] bArr) {
        AppMethodBeat.m2504i(19640);
        C4990ab.m7417i("MicroMsg.exdevice.RDeviceTaskDispatcher", "------setChannelSessionKey------ deviceId = %d", Long.valueOf(j));
        try {
            this.lwT.setChannelSessionKey(j, bArr);
            AppMethodBeat.m2505o(19640);
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            AppMethodBeat.m2505o(19640);
        }
    }

    /* renamed from: a */
    public final boolean mo45755a(String str, boolean z, C45894q c45894q) {
        boolean z2 = false;
        AppMethodBeat.m2504i(19641);
        C4990ab.m7417i("MicroMsg.exdevice.RDeviceTaskDispatcher", "ranging, uuid = %s, op = %s", str, String.valueOf(z));
        try {
            z2 = this.lwT.mo45734a(str, z, c45894q);
            AppMethodBeat.m2505o(19641);
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.exdevice.RDeviceTaskDispatcher", "mDispatcher.ranging failed!!!(%s)", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z2]);
            AppMethodBeat.m2505o(19641);
        }
        return z2;
    }

    /* renamed from: b */
    public final boolean mo54590b(C11658n c11658n) {
        AppMethodBeat.m2504i(19642);
        try {
            this.lwT.mo45730a(c11658n);
            AppMethodBeat.m2505o(19642);
            return true;
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.exdevice.RDeviceTaskDispatcher", "mDispatcher.registExDeviceInvokerHandler failed!!, %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            AppMethodBeat.m2505o(19642);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo45754a(C43000j c43000j) {
        boolean z = false;
        AppMethodBeat.m2504i(19643);
        try {
            z = this.lwT.mo45742d(0, c43000j);
            AppMethodBeat.m2505o(19643);
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.m2505o(19643);
        }
        return z;
    }

    /* renamed from: b */
    public final boolean mo45758b(C43000j c43000j) {
        boolean z = false;
        AppMethodBeat.m2504i(19644);
        try {
            z = this.lwT.mo45743e(0, c43000j);
            AppMethodBeat.m2505o(19644);
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.m2505o(19644);
        }
        return z;
    }

    /* renamed from: a */
    public final boolean mo45753a(long j, C38959k c38959k) {
        boolean z = false;
        AppMethodBeat.m2504i(19645);
        try {
            z = this.lwT.mo45737b(j, 0, c38959k);
            AppMethodBeat.m2505o(19645);
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.m2505o(19645);
        }
        return z;
    }

    /* renamed from: ic */
    public final boolean mo45762ic(long j) {
        boolean z = false;
        AppMethodBeat.m2504i(19646);
        try {
            z = this.lwT.mo45747ic(j);
            AppMethodBeat.m2505o(19646);
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.m2505o(19646);
        }
        return z;
    }

    /* renamed from: a */
    public final boolean mo54589a(C43003s c43003s) {
        boolean z = false;
        AppMethodBeat.m2504i(19647);
        try {
            z = this.lwT.mo45733a(c43003s);
            AppMethodBeat.m2505o(19647);
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.m2505o(19647);
        }
        return z;
    }

    /* renamed from: b */
    public final boolean mo45757b(long j, byte[] bArr, C43005t c43005t) {
        boolean z = false;
        AppMethodBeat.m2504i(19648);
        try {
            z = this.lwT.mo45738b(j, bArr, c43005t);
            AppMethodBeat.m2505o(19648);
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            AppMethodBeat.m2505o(19648);
        }
        return z;
    }
}
