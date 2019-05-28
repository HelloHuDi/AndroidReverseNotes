package com.tencent.p177mm.p183ai;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1898c;
import com.tencent.p177mm.network.C1899d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.ai.q */
public final class C17896q implements C1898c {
    private final C1899d ftQ;

    public C17896q(C1899d c1899d) {
        this.ftQ = c1899d;
    }

    public final byte[] ada() {
        AppMethodBeat.m2504i(58211);
        try {
            byte[] ada = this.ftQ.ada();
            AppMethodBeat.m2505o(58211);
            return ada;
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.RAccInfo", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58211);
            return null;
        }
    }

    /* renamed from: jQ */
    public final byte[] mo5490jQ(int i) {
        AppMethodBeat.m2504i(58212);
        try {
            byte[] jQ = this.ftQ.mo5509jQ(i);
            AppMethodBeat.m2505o(58212);
            return jQ;
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.RAccInfo", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58212);
            return null;
        }
    }

    /* renamed from: QF */
    public final int mo5480QF() {
        int i = 0;
        AppMethodBeat.m2504i(58213);
        try {
            i = this.ftQ.mo5495QF();
            AppMethodBeat.m2505o(58213);
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.RAccInfo", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58213);
        }
        return i;
    }

    private String getUsername() {
        AppMethodBeat.m2504i(58214);
        try {
            String username = this.ftQ.getUsername();
            AppMethodBeat.m2505o(58214);
            return username;
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.RAccInfo", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58214);
            return null;
        }
    }

    public final boolean adb() {
        boolean z = false;
        AppMethodBeat.m2504i(58215);
        try {
            z = this.ftQ.adb();
            AppMethodBeat.m2505o(58215);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RAccInfo", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58215);
        }
        return z;
    }

    public final void setUsername(String str) {
        AppMethodBeat.m2504i(58216);
        try {
            this.ftQ.setUsername(str);
            AppMethodBeat.m2505o(58216);
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.RAccInfo", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58216);
        }
    }

    /* renamed from: a */
    public final void mo5482a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        AppMethodBeat.m2504i(58217);
        try {
            this.ftQ.mo5497a(bArr, bArr2, bArr3, i);
            AppMethodBeat.m2505o(58217);
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.RAccInfo", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58217);
        }
    }

    public final void reset() {
        AppMethodBeat.m2504i(58218);
        try {
            this.ftQ.reset();
            AppMethodBeat.m2505o(58218);
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.RAccInfo", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58218);
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(58219);
        String str = (((((("RAccInfo:\n" + "|-uin     =" + mo5480QF() + IOUtils.LINE_SEPARATOR_UNIX) + "|-user    =" + getUsername() + IOUtils.LINE_SEPARATOR_UNIX) + "|-singlesession =" + C5046bo.m7539ca(mo5490jQ(1)) + IOUtils.LINE_SEPARATOR_UNIX) + "|-clientsession =" + C5046bo.m7539ca(mo5490jQ(2)) + IOUtils.LINE_SEPARATOR_UNIX) + "|-serversession =" + C5046bo.m7539ca(mo5490jQ(3)) + IOUtils.LINE_SEPARATOR_UNIX) + "|-ecdhkey =" + C5046bo.m7539ca(adc()) + IOUtils.LINE_SEPARATOR_UNIX) + "`-cookie  =" + C5046bo.m7539ca(ada());
        AppMethodBeat.m2505o(58219);
        return str;
    }

    /* renamed from: o */
    public final void mo5491o(String str, byte[] bArr) {
        AppMethodBeat.m2504i(58220);
        try {
            this.ftQ.mo5510o(str, bArr);
            AppMethodBeat.m2505o(58220);
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.RAccInfo", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58220);
        }
    }

    /* renamed from: qr */
    public final byte[] mo5492qr(String str) {
        AppMethodBeat.m2504i(58221);
        try {
            byte[] qr = this.ftQ.mo5511qr(str);
            AppMethodBeat.m2505o(58221);
            return qr;
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.RAccInfo", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58221);
            return null;
        }
    }

    public final byte[] adc() {
        AppMethodBeat.m2504i(58222);
        try {
            byte[] adc = this.ftQ.adc();
            AppMethodBeat.m2505o(58222);
            return adc;
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.RAccInfo", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58222);
            return null;
        }
    }

    /* renamed from: cE */
    public final void mo5488cE(boolean z) {
        AppMethodBeat.m2504i(58223);
        try {
            this.ftQ.mo5506cE(z);
            AppMethodBeat.m2505o(58223);
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.RAccInfo", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58223);
        }
    }

    public final boolean ade() {
        boolean z = true;
        AppMethodBeat.m2504i(58224);
        try {
            z = this.ftQ.ade();
            AppMethodBeat.m2505o(58224);
        } catch (RemoteException e) {
            Object[] objArr = new Object[z];
            objArr[0] = C5046bo.m7574l(e);
            C4990ab.m7413e("MicroMsg.RAccInfo", "exception:%s", objArr);
            AppMethodBeat.m2505o(58224);
        }
        return z;
    }

    public final byte[] adf() {
        AppMethodBeat.m2504i(58225);
        try {
            byte[] adf = this.ftQ.adf();
            AppMethodBeat.m2505o(58225);
            return adf;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RAccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58225);
            return null;
        }
    }

    /* renamed from: S */
    public final int mo5481S(byte[] bArr) {
        AppMethodBeat.m2504i(58226);
        try {
            int S = this.ftQ.mo5496S(bArr);
            AppMethodBeat.m2505o(58226);
            return S;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RAccInfo", "AccInfoCacheInWorker parseBuf exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58226);
            return -6;
        }
    }

    /* renamed from: hB */
    public final void mo5489hB(int i) {
        AppMethodBeat.m2504i(58227);
        try {
            this.ftQ.mo5508hB(i);
            AppMethodBeat.m2505o(58227);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RAccInfo", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58227);
        }
    }
}
