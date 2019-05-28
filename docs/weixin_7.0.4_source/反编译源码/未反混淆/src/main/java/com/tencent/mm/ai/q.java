package com.tencent.mm.ai;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.c;
import com.tencent.mm.network.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;

public final class q implements c {
    private final d ftQ;

    public q(d dVar) {
        this.ftQ = dVar;
    }

    public final byte[] ada() {
        AppMethodBeat.i(58211);
        try {
            byte[] ada = this.ftQ.ada();
            AppMethodBeat.o(58211);
            return ada;
        } catch (RemoteException e) {
            ab.e("MicroMsg.RAccInfo", "exception:%s", bo.l(e));
            AppMethodBeat.o(58211);
            return null;
        }
    }

    public final byte[] jQ(int i) {
        AppMethodBeat.i(58212);
        try {
            byte[] jQ = this.ftQ.jQ(i);
            AppMethodBeat.o(58212);
            return jQ;
        } catch (RemoteException e) {
            ab.e("MicroMsg.RAccInfo", "exception:%s", bo.l(e));
            AppMethodBeat.o(58212);
            return null;
        }
    }

    public final int QF() {
        int i = 0;
        AppMethodBeat.i(58213);
        try {
            i = this.ftQ.QF();
            AppMethodBeat.o(58213);
        } catch (RemoteException e) {
            ab.e("MicroMsg.RAccInfo", "exception:%s", bo.l(e));
            AppMethodBeat.o(58213);
        }
        return i;
    }

    private String getUsername() {
        AppMethodBeat.i(58214);
        try {
            String username = this.ftQ.getUsername();
            AppMethodBeat.o(58214);
            return username;
        } catch (RemoteException e) {
            ab.e("MicroMsg.RAccInfo", "exception:%s", bo.l(e));
            AppMethodBeat.o(58214);
            return null;
        }
    }

    public final boolean adb() {
        boolean z = false;
        AppMethodBeat.i(58215);
        try {
            z = this.ftQ.adb();
            AppMethodBeat.o(58215);
        } catch (Exception e) {
            ab.e("MicroMsg.RAccInfo", "exception:%s", bo.l(e));
            AppMethodBeat.o(58215);
        }
        return z;
    }

    public final void setUsername(String str) {
        AppMethodBeat.i(58216);
        try {
            this.ftQ.setUsername(str);
            AppMethodBeat.o(58216);
        } catch (RemoteException e) {
            ab.e("MicroMsg.RAccInfo", "exception:%s", bo.l(e));
            AppMethodBeat.o(58216);
        }
    }

    public final void a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        AppMethodBeat.i(58217);
        try {
            this.ftQ.a(bArr, bArr2, bArr3, i);
            AppMethodBeat.o(58217);
        } catch (RemoteException e) {
            ab.e("MicroMsg.RAccInfo", "exception:%s", bo.l(e));
            AppMethodBeat.o(58217);
        }
    }

    public final void reset() {
        AppMethodBeat.i(58218);
        try {
            this.ftQ.reset();
            AppMethodBeat.o(58218);
        } catch (RemoteException e) {
            ab.e("MicroMsg.RAccInfo", "exception:%s", bo.l(e));
            AppMethodBeat.o(58218);
        }
    }

    public final String toString() {
        AppMethodBeat.i(58219);
        String str = (((((("RAccInfo:\n" + "|-uin     =" + QF() + IOUtils.LINE_SEPARATOR_UNIX) + "|-user    =" + getUsername() + IOUtils.LINE_SEPARATOR_UNIX) + "|-singlesession =" + bo.ca(jQ(1)) + IOUtils.LINE_SEPARATOR_UNIX) + "|-clientsession =" + bo.ca(jQ(2)) + IOUtils.LINE_SEPARATOR_UNIX) + "|-serversession =" + bo.ca(jQ(3)) + IOUtils.LINE_SEPARATOR_UNIX) + "|-ecdhkey =" + bo.ca(adc()) + IOUtils.LINE_SEPARATOR_UNIX) + "`-cookie  =" + bo.ca(ada());
        AppMethodBeat.o(58219);
        return str;
    }

    public final void o(String str, byte[] bArr) {
        AppMethodBeat.i(58220);
        try {
            this.ftQ.o(str, bArr);
            AppMethodBeat.o(58220);
        } catch (RemoteException e) {
            ab.e("MicroMsg.RAccInfo", "exception:%s", bo.l(e));
            AppMethodBeat.o(58220);
        }
    }

    public final byte[] qr(String str) {
        AppMethodBeat.i(58221);
        try {
            byte[] qr = this.ftQ.qr(str);
            AppMethodBeat.o(58221);
            return qr;
        } catch (RemoteException e) {
            ab.e("MicroMsg.RAccInfo", "exception:%s", bo.l(e));
            AppMethodBeat.o(58221);
            return null;
        }
    }

    public final byte[] adc() {
        AppMethodBeat.i(58222);
        try {
            byte[] adc = this.ftQ.adc();
            AppMethodBeat.o(58222);
            return adc;
        } catch (RemoteException e) {
            ab.e("MicroMsg.RAccInfo", "exception:%s", bo.l(e));
            AppMethodBeat.o(58222);
            return null;
        }
    }

    public final void cE(boolean z) {
        AppMethodBeat.i(58223);
        try {
            this.ftQ.cE(z);
            AppMethodBeat.o(58223);
        } catch (RemoteException e) {
            ab.e("MicroMsg.RAccInfo", "exception:%s", bo.l(e));
            AppMethodBeat.o(58223);
        }
    }

    public final boolean ade() {
        boolean z = true;
        AppMethodBeat.i(58224);
        try {
            z = this.ftQ.ade();
            AppMethodBeat.o(58224);
        } catch (RemoteException e) {
            Object[] objArr = new Object[z];
            objArr[0] = bo.l(e);
            ab.e("MicroMsg.RAccInfo", "exception:%s", objArr);
            AppMethodBeat.o(58224);
        }
        return z;
    }

    public final byte[] adf() {
        AppMethodBeat.i(58225);
        try {
            byte[] adf = this.ftQ.adf();
            AppMethodBeat.o(58225);
            return adf;
        } catch (Exception e) {
            ab.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", bo.l(e));
            AppMethodBeat.o(58225);
            return null;
        }
    }

    public final int S(byte[] bArr) {
        AppMethodBeat.i(58226);
        try {
            int S = this.ftQ.S(bArr);
            AppMethodBeat.o(58226);
            return S;
        } catch (Exception e) {
            ab.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker parseBuf exception:%s", bo.l(e));
            AppMethodBeat.o(58226);
            return -6;
        }
    }

    public final void hB(int i) {
        AppMethodBeat.i(58227);
        try {
            this.ftQ.hB(i);
            AppMethodBeat.o(58227);
        } catch (Exception e) {
            ab.e("MicroMsg.RAccInfo", "exception:%s", bo.l(e));
            AppMethodBeat.o(58227);
        }
    }
}
