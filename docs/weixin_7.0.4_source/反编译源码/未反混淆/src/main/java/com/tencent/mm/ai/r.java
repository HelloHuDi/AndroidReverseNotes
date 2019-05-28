package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.b;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.f;
import com.tencent.mm.network.h;
import com.tencent.mm.network.i;
import com.tencent.mm.network.l;
import com.tencent.mm.network.o;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class r implements e {
    public final f ftR;
    private q ftS;

    public r(f fVar) {
        this.ftR = fVar;
    }

    public final int a(com.tencent.mm.network.r rVar, l lVar) {
        AppMethodBeat.i(58228);
        try {
            int a = this.ftR.a(rVar, lVar);
            AppMethodBeat.o(58228);
            return a;
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "remote dispatcher lost, send failed, %s", e);
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58228);
            return -1;
        }
    }

    public final String getNetworkServerIp() {
        AppMethodBeat.i(58229);
        try {
            String networkServerIp = this.ftR.getNetworkServerIp();
            AppMethodBeat.o(58229);
            return networkServerIp;
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", e);
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58229);
            return null;
        }
    }

    public final String[] getIPsString(boolean z) {
        AppMethodBeat.i(58230);
        try {
            String[] iPsString = this.ftR.getIPsString(z);
            AppMethodBeat.o(58230);
            return iPsString;
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", e);
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58230);
            return null;
        }
    }

    public final void cancel(int i) {
        AppMethodBeat.i(58231);
        try {
            this.ftR.cancel(i);
            AppMethodBeat.o(58231);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "cancel remote rr failed, netid=%d, %s", Integer.valueOf(i), e);
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58231);
        }
    }

    public final void reset() {
        AppMethodBeat.i(58232);
        try {
            this.ftR.reset();
            AppMethodBeat.o(58232);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "reset failed, core service down, %s", e);
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58232);
        }
    }

    public final void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4) {
        AppMethodBeat.i(58233);
        try {
            this.ftR.a(z, str, str2, iArr, iArr2, i, i2, str3, str4);
            AppMethodBeat.o(58233);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "dkidc setIDCHostInfo ip failed, core service down, %s", e);
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58233);
        }
    }

    public final c adg() {
        AppMethodBeat.i(58234);
        try {
            if (this.ftS == null) {
                this.ftS = new q(this.ftR.amM());
            }
            q qVar = this.ftS;
            AppMethodBeat.o(58234);
            return qVar;
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "getAccInfo failed, core service down, %s", e);
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58234);
            return null;
        }
    }

    public final void a(b bVar) {
        AppMethodBeat.i(58235);
        try {
            this.ftR.a(bVar);
            AppMethodBeat.o(58235);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58235);
        }
    }

    public final void cF(boolean z) {
        AppMethodBeat.i(58236);
        try {
            this.ftR.cF(z);
            AppMethodBeat.o(58236);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "change active status failed, core service down, %s", e);
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58236);
        }
    }

    public final boolean acT() {
        boolean z = true;
        AppMethodBeat.i(58237);
        try {
            z = this.ftR.acT();
            AppMethodBeat.o(58237);
        } catch (Exception e) {
            Object[] objArr = new Object[z];
            objArr[0] = e;
            ab.e("MicroMsg.RDispatcher", "core service down, guess network stable, %s", objArr);
            objArr = new Object[z];
            objArr[0] = bo.l(e);
            ab.e("MicroMsg.RDispatcher", "exception:%s", objArr);
            AppMethodBeat.o(58237);
        }
        return z;
    }

    public final i adh() {
        AppMethodBeat.i(58238);
        try {
            i amO = this.ftR.amO();
            AppMethodBeat.o(58238);
            return amO;
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58238);
            return null;
        }
    }

    public final void a(y yVar) {
        AppMethodBeat.i(58239);
        try {
            this.ftR.a(yVar);
            AppMethodBeat.o(58239);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58239);
        }
    }

    public final void qs(String str) {
        AppMethodBeat.i(58240);
        try {
            this.ftR.qs(str);
            AppMethodBeat.o(58240);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "ipxxStatistics remote call error, %s", e);
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58240);
        }
    }

    public final int getHostByName(String str, List<String> list) {
        AppMethodBeat.i(58241);
        try {
            int hostByName = this.ftR.getHostByName(str, list);
            AppMethodBeat.o(58241);
            return hostByName;
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58241);
            return -1;
        }
    }

    public final int a(String str, boolean z, List<String> list) {
        AppMethodBeat.i(58242);
        try {
            int a = this.ftR.a(str, z, list);
            AppMethodBeat.o(58242);
            return a;
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58242);
            return -1;
        }
    }

    public final void setHostInfo(String[] strArr, String[] strArr2, int[] iArr) {
        AppMethodBeat.i(58243);
        try {
            this.ftR.setHostInfo(strArr, strArr2, iArr);
            AppMethodBeat.o(58243);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58243);
        }
    }

    public final void a(int i, String str, int i2, boolean z) {
        AppMethodBeat.i(58244);
        try {
            this.ftR.a(i, str, i2, z);
            AppMethodBeat.o(58244);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58244);
        }
    }

    public final String getIspId() {
        AppMethodBeat.i(58245);
        try {
            String ispId = this.ftR.getIspId();
            AppMethodBeat.o(58245);
            return ispId;
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58245);
            return null;
        }
    }

    public final void setSignallingStrategy(long j, long j2) {
        AppMethodBeat.i(58246);
        try {
            this.ftR.setSignallingStrategy(j, j2);
            AppMethodBeat.o(58246);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58246);
        }
    }

    public final void keepSignalling() {
        AppMethodBeat.i(58247);
        try {
            this.ftR.keepSignalling();
            AppMethodBeat.o(58247);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58247);
        }
    }

    public final void stopSignalling() {
        AppMethodBeat.i(58248);
        try {
            this.ftR.stopSignalling();
            AppMethodBeat.o(58248);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58248);
        }
    }

    public final void a(o oVar) {
        AppMethodBeat.i(58249);
        try {
            this.ftR.a(oVar);
            AppMethodBeat.o(58249);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58249);
        }
    }

    public final void reportFailIp(String str) {
        AppMethodBeat.i(58250);
        try {
            this.ftR.reportFailIp(str);
            AppMethodBeat.o(58250);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58250);
        }
    }

    public final void qt(String str) {
        AppMethodBeat.i(58251);
        try {
            this.ftR.qt(str);
            AppMethodBeat.o(58251);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58251);
        }
    }

    public final void cG(boolean z) {
        AppMethodBeat.i(58252);
        try {
            this.ftR.cG(z);
            AppMethodBeat.o(58252);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58252);
        }
    }

    public final void cH(boolean z) {
        AppMethodBeat.i(58253);
        try {
            this.ftR.cH(z);
            AppMethodBeat.o(58253);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58253);
        }
    }

    public final void cI(boolean z) {
        AppMethodBeat.i(58254);
        try {
            this.ftR.cI(z);
            AppMethodBeat.o(58254);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58254);
        }
    }

    public final void adi() {
        AppMethodBeat.i(58255);
        try {
            this.ftR.adi();
            AppMethodBeat.o(58255);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58255);
        }
    }

    public final void a(h hVar) {
        AppMethodBeat.i(58256);
        try {
            this.ftR.a(hVar);
            AppMethodBeat.o(58256);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58256);
        }
    }

    public final void adj() {
        AppMethodBeat.i(58257);
        try {
            this.ftR.adj();
            AppMethodBeat.o(58257);
        } catch (Exception e) {
            ab.e("MicroMsg.RDispatcher", "exception:%s", bo.l(e));
            AppMethodBeat.o(58257);
        }
    }
}
