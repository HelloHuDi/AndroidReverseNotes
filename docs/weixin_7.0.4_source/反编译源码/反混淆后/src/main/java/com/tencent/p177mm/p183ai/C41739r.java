package com.tencent.p177mm.p183ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1898c;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1903f;
import com.tencent.p177mm.network.C1909h;
import com.tencent.p177mm.network.C1912i;
import com.tencent.p177mm.network.C1919l;
import com.tencent.p177mm.network.C1926o;
import com.tencent.p177mm.network.C1930r;
import com.tencent.p177mm.network.p265a.C1889b;
import com.tencent.p177mm.protocal.C4848y;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.ai.r */
public final class C41739r implements C1902e {
    public final C1903f ftR;
    private C17896q ftS;

    public C41739r(C1903f c1903f) {
        this.ftR = c1903f;
    }

    /* renamed from: a */
    public final int mo5518a(C1930r c1930r, C1919l c1919l) {
        AppMethodBeat.m2504i(58228);
        try {
            int a = this.ftR.mo5548a(c1930r, c1919l);
            AppMethodBeat.m2505o(58228);
            return a;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "remote dispatcher lost, send failed, %s", e);
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58228);
            return -1;
        }
    }

    public final String getNetworkServerIp() {
        AppMethodBeat.m2504i(58229);
        try {
            String networkServerIp = this.ftR.getNetworkServerIp();
            AppMethodBeat.m2505o(58229);
            return networkServerIp;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", e);
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58229);
            return null;
        }
    }

    public final String[] getIPsString(boolean z) {
        AppMethodBeat.m2504i(58230);
        try {
            String[] iPsString = this.ftR.getIPsString(z);
            AppMethodBeat.m2505o(58230);
            return iPsString;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", e);
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58230);
            return null;
        }
    }

    public final void cancel(int i) {
        AppMethodBeat.m2504i(58231);
        try {
            this.ftR.cancel(i);
            AppMethodBeat.m2505o(58231);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "cancel remote rr failed, netid=%d, %s", Integer.valueOf(i), e);
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58231);
        }
    }

    public final void reset() {
        AppMethodBeat.m2504i(58232);
        try {
            this.ftR.reset();
            AppMethodBeat.m2505o(58232);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "reset failed, core service down, %s", e);
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58232);
        }
    }

    /* renamed from: a */
    public final void mo5525a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4) {
        AppMethodBeat.m2504i(58233);
        try {
            this.ftR.mo5558a(z, str, str2, iArr, iArr2, i, i2, str3, str4);
            AppMethodBeat.m2505o(58233);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "dkidc setIDCHostInfo ip failed, core service down, %s", e);
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58233);
        }
    }

    public final C1898c adg() {
        AppMethodBeat.m2504i(58234);
        try {
            if (this.ftS == null) {
                this.ftS = new C17896q(this.ftR.amM());
            }
            C17896q c17896q = this.ftS;
            AppMethodBeat.m2505o(58234);
            return c17896q;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "getAccInfo failed, core service down, %s", e);
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58234);
            return null;
        }
    }

    /* renamed from: a */
    public final void mo5521a(C1889b c1889b) {
        AppMethodBeat.m2504i(58235);
        try {
            this.ftR.mo5552a(c1889b);
            AppMethodBeat.m2505o(58235);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58235);
        }
    }

    /* renamed from: cF */
    public final void mo5531cF(boolean z) {
        AppMethodBeat.m2504i(58236);
        try {
            this.ftR.mo5565cF(z);
            AppMethodBeat.m2505o(58236);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "change active status failed, core service down, %s", e);
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58236);
        }
    }

    public final boolean acT() {
        boolean z = true;
        AppMethodBeat.m2504i(58237);
        try {
            z = this.ftR.acT();
            AppMethodBeat.m2505o(58237);
        } catch (Exception e) {
            Object[] objArr = new Object[z];
            objArr[0] = e;
            C4990ab.m7413e("MicroMsg.RDispatcher", "core service down, guess network stable, %s", objArr);
            objArr = new Object[z];
            objArr[0] = C5046bo.m7574l(e);
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", objArr);
            AppMethodBeat.m2505o(58237);
        }
        return z;
    }

    public final C1912i adh() {
        AppMethodBeat.m2504i(58238);
        try {
            C1912i amO = this.ftR.amO();
            AppMethodBeat.m2505o(58238);
            return amO;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58238);
            return null;
        }
    }

    /* renamed from: a */
    public final void mo5524a(C4848y c4848y) {
        AppMethodBeat.m2504i(58239);
        try {
            this.ftR.mo5557a(c4848y);
            AppMethodBeat.m2505o(58239);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58239);
        }
    }

    /* renamed from: qs */
    public final void mo5541qs(String str) {
        AppMethodBeat.m2504i(58240);
        try {
            this.ftR.mo5577qs(str);
            AppMethodBeat.m2505o(58240);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "ipxxStatistics remote call error, %s", e);
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58240);
        }
    }

    public final int getHostByName(String str, List<String> list) {
        AppMethodBeat.m2504i(58241);
        try {
            int hostByName = this.ftR.getHostByName(str, list);
            AppMethodBeat.m2505o(58241);
            return hostByName;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58241);
            return -1;
        }
    }

    /* renamed from: a */
    public final int mo5519a(String str, boolean z, List<String> list) {
        AppMethodBeat.m2504i(58242);
        try {
            int a = this.ftR.mo5549a(str, z, list);
            AppMethodBeat.m2505o(58242);
            return a;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58242);
            return -1;
        }
    }

    public final void setHostInfo(String[] strArr, String[] strArr2, int[] iArr) {
        AppMethodBeat.m2504i(58243);
        try {
            this.ftR.setHostInfo(strArr, strArr2, iArr);
            AppMethodBeat.m2505o(58243);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58243);
        }
    }

    /* renamed from: a */
    public final void mo5520a(int i, String str, int i2, boolean z) {
        AppMethodBeat.m2504i(58244);
        try {
            this.ftR.mo5551a(i, str, i2, z);
            AppMethodBeat.m2505o(58244);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58244);
        }
    }

    public final String getIspId() {
        AppMethodBeat.m2504i(58245);
        try {
            String ispId = this.ftR.getIspId();
            AppMethodBeat.m2505o(58245);
            return ispId;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58245);
            return null;
        }
    }

    public final void setSignallingStrategy(long j, long j2) {
        AppMethodBeat.m2504i(58246);
        try {
            this.ftR.setSignallingStrategy(j, j2);
            AppMethodBeat.m2505o(58246);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58246);
        }
    }

    public final void keepSignalling() {
        AppMethodBeat.m2504i(58247);
        try {
            this.ftR.keepSignalling();
            AppMethodBeat.m2505o(58247);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58247);
        }
    }

    public final void stopSignalling() {
        AppMethodBeat.m2504i(58248);
        try {
            this.ftR.stopSignalling();
            AppMethodBeat.m2505o(58248);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58248);
        }
    }

    /* renamed from: a */
    public final void mo5523a(C1926o c1926o) {
        AppMethodBeat.m2504i(58249);
        try {
            this.ftR.mo5555a(c1926o);
            AppMethodBeat.m2505o(58249);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58249);
        }
    }

    public final void reportFailIp(String str) {
        AppMethodBeat.m2504i(58250);
        try {
            this.ftR.reportFailIp(str);
            AppMethodBeat.m2505o(58250);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58250);
        }
    }

    /* renamed from: qt */
    public final void mo5542qt(String str) {
        AppMethodBeat.m2504i(58251);
        try {
            this.ftR.mo5578qt(str);
            AppMethodBeat.m2505o(58251);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58251);
        }
    }

    /* renamed from: cG */
    public final void mo5532cG(boolean z) {
        AppMethodBeat.m2504i(58252);
        try {
            this.ftR.mo5566cG(z);
            AppMethodBeat.m2505o(58252);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58252);
        }
    }

    /* renamed from: cH */
    public final void mo5533cH(boolean z) {
        AppMethodBeat.m2504i(58253);
        try {
            this.ftR.mo5567cH(z);
            AppMethodBeat.m2505o(58253);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58253);
        }
    }

    /* renamed from: cI */
    public final void mo5534cI(boolean z) {
        AppMethodBeat.m2504i(58254);
        try {
            this.ftR.mo5568cI(z);
            AppMethodBeat.m2505o(58254);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58254);
        }
    }

    public final void adi() {
        AppMethodBeat.m2504i(58255);
        try {
            this.ftR.adi();
            AppMethodBeat.m2505o(58255);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58255);
        }
    }

    /* renamed from: a */
    public final void mo5522a(C1909h c1909h) {
        AppMethodBeat.m2504i(58256);
        try {
            this.ftR.mo5554a(c1909h);
            AppMethodBeat.m2505o(58256);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58256);
        }
    }

    public final void adj() {
        AppMethodBeat.m2504i(58257);
        try {
            this.ftR.adj();
            AppMethodBeat.m2505o(58257);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.RDispatcher", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58257);
        }
    }
}
