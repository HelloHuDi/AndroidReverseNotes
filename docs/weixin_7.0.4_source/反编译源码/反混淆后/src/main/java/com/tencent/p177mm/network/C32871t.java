package com.tencent.p177mm.network;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.magicbox.IPxxLogic;
import com.tencent.mars.p150mm.MMLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C1818ay;
import com.tencent.p177mm.network.C1903f.C1904a;
import com.tencent.p177mm.network.C1915j.C1916a;
import com.tencent.p177mm.network.C1930r.C1931a;
import com.tencent.p177mm.network.C37970a.C37971a;
import com.tencent.p177mm.network.p265a.C1889b;
import com.tencent.p177mm.p188an.C41753a;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.protocal.C4787a;
import com.tencent.p177mm.protocal.C4816h;
import com.tencent.p177mm.protocal.C4838o;
import com.tencent.p177mm.protocal.C4845x.C4846a;
import com.tencent.p177mm.protocal.C4848y;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.p177mm.storage.C5144y;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.network.t */
public final class C32871t extends C1904a implements C37971a, C1902e {
    byte[] eJt;
    int fPj = 0;
    int gcP = 0;
    private long gcQ = 0;
    private long gcR = 0;
    private long gcS = 0;
    private WakerLock gcT = null;
    public C37970a gcU;
    C32867a gcV;
    C32869b gcW;
    long gcX = 0;
    int gcY = -1;
    private C5144y gcZ;
    private C1933s gda;
    private C1906g gdb;
    C1909h gdc;
    public C7306ak handler;

    /* renamed from: com.tencent.mm.network.t$12 */
    public class C2650912 extends C5039bj<Object> {
        final /* synthetic */ String gdv;
        final /* synthetic */ String gdx;

        public C2650912(String str, String str2) {
            this.gdx = str;
            this.gdv = str2;
            super(1000, null, (byte) 0);
        }

        public final Object run() {
            AppMethodBeat.m2504i(58563);
            StnLogic.setDebugIP(this.gdx, this.gdv);
            AppMethodBeat.m2505o(58563);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.network.t$3 */
    class C328633 implements Runnable {
        C328633() {
        }

        public final void run() {
            AppMethodBeat.m2504i(58553);
            C4990ab.m7416i("MicroMsg.MMAutoAuth", "makeSureAuth AUTH_HOLD_KEY hold  clearTaskAndCallback");
            C1892aa.anp().mo60745i(4, -100, C4996ah.getContext().getString(C25738R.string.cvx));
            AppMethodBeat.m2505o(58553);
        }
    }

    /* renamed from: com.tencent.mm.network.t$6 */
    class C328656 extends C5039bj<Object> {
        C328656() {
            super(1000, null, (byte) 0);
        }

        public final Object run() {
            AppMethodBeat.m2504i(58556);
            C32871t.m53768a(C32871t.this);
            AppMethodBeat.m2505o(58556);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.network.t$a */
    static class C32867a extends C1916a implements C1919l {
        private C32871t ebz;
        private WakerLock gdy;
        private int gdz = 0;

        public C32867a(C32871t c32871t, WakerLock wakerLock) {
            this.ebz = c32871t;
            this.gdy = wakerLock;
        }

        /* renamed from: a */
        public final void mo5602a(C1930r c1930r, int i, int i2, String str) {
            AppMethodBeat.m2504i(58566);
            this.gdy.lock(1000, "MMAutoAuth.IOnAutoAuth.onAutoAuth");
            final C1930r c1930r2 = c1930r;
            final int i3 = i;
            final int i4 = i2;
            final String str2 = str;
            new C5039bj<Object>() {
                public final Object run() {
                    AppMethodBeat.m2504i(58565);
                    try {
                        C32871t.m53770a(C32867a.this.ebz, c1930r2, str2);
                    } catch (RemoteException e) {
                        C4990ab.m7413e("MicroMsg.MMAutoAuth", "exception:%s", C5046bo.m7574l(e));
                    }
                    AppMethodBeat.m2505o(58565);
                    return null;
                }
            }.mo10372b(this.ebz.handler);
            AppMethodBeat.m2505o(58566);
        }

        /* renamed from: a */
        public final void mo5606a(int i, int i2, int i3, String str, C1930r c1930r, byte[] bArr) {
            AppMethodBeat.m2504i(58567);
            if (c1930r.getType() == 252 || c1930r.getType() == 701) {
                C4990ab.m7410d("MicroMsg.MMAutoAuth", "summerauth IOnAutoAuth onGYNetEnd manual auth");
                if (c1930r.adu().ady() != 0 || i2 != 0) {
                    C7053e.pXa.mo8378a(148, ZipJNI.UNZ_PARAMERROR == i3 ? 30 : 29, 1, false);
                } else if (c1930r.adv() == 2) {
                    C7053e.pXa.mo8378a(148, 28, 1, false);
                    this.gdz++;
                    if (this.gdz > 1) {
                        C4990ab.m7420w("MicroMsg.MMAutoAuth", "summerauth manualLoginDecodeFailedTry beyond 1 no more try!");
                        this.ebz.mo53438h(i2, i3, "auth_decode_failed_" + C5046bo.m7532bc(str, ""));
                    } else {
                        c1930r.mo5627a(this, 0, 0);
                    }
                } else {
                    this.gdz = 0;
                    c1930r.mo5628a((C1915j) this, i2, i3, str);
                }
            }
            if (c1930r.adu().ady() == 0 && i2 == 0) {
                c1930r.mo5628a((C1915j) this, i2, i3, str);
                AppMethodBeat.m2505o(58567);
            } else if (ZipJNI.UNZ_PARAMERROR == i3) {
                this.ebz.gcY = i;
                c1930r.mo5626a(this.ebz.gcU, this.ebz.gcW, 0, 0);
                AppMethodBeat.m2505o(58567);
            } else {
                if (-301 == i3) {
                    c1930r.mo5628a((C1915j) this, i2, i3, str);
                } else if (ZipJNI.UNZ_CRCERROR == i3) {
                    c1930r.mo5628a((C1915j) this, i2, i3, str);
                } else if (-17 == i3) {
                    c1930r.mo5628a((C1915j) this, i2, i3, str);
                }
                this.ebz.mo53438h(i2, i3, "autoauth_errmsg_" + C5046bo.m7532bc(str, ""));
                AppMethodBeat.m2505o(58567);
            }
        }
    }

    /* renamed from: com.tencent.mm.network.t$b */
    static class C32869b extends C1916a implements C1919l {
        private C32871t ebz;
        private WakerLock gdy;

        public C32869b(C32871t c32871t, WakerLock wakerLock) {
            this.ebz = c32871t;
            this.gdy = wakerLock;
        }

        /* renamed from: a */
        public final void mo5602a(final C1930r c1930r, final int i, final int i2, String str) {
            AppMethodBeat.m2504i(58569);
            this.gdy.lock(1000, "MMAutoAuth.IOnGetCert.onAutoAuth");
            new C5039bj<Object>() {
                public final Object run() {
                    AppMethodBeat.m2504i(58568);
                    try {
                        C32871t.m53769a(C32869b.this.ebz, c1930r);
                    } catch (RemoteException e) {
                        C4990ab.m7413e("MicroMsg.MMAutoAuth", "exception:%s", C5046bo.m7574l(e));
                    }
                    AppMethodBeat.m2505o(58568);
                    return null;
                }
            }.mo10372b(this.ebz.handler);
            AppMethodBeat.m2505o(58569);
        }

        /* renamed from: a */
        public final void mo5606a(int i, int i2, int i3, String str, C1930r c1930r, byte[] bArr) {
        }
    }

    public C32871t(C7306ak c7306ak) {
        AppMethodBeat.m2504i(58570);
        if (c7306ak == null) {
            c7306ak = new C7306ak();
        }
        this.handler = c7306ak;
        this.gcU = new C37970a(this);
        this.gcT = new WakerLock(C1892aa.getContext(), "MicroMsg.MMAutoAuth");
        this.gcV = new C32867a(this, this.gcT);
        this.gcW = new C32869b(this, this.gcT);
        this.gcZ = new C5144y(C5128ac.eSj + "autoauth.cfg");
        AppMethodBeat.m2505o(58570);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(58571);
        reset();
        super.finalize();
        AppMethodBeat.m2505o(58571);
    }

    public final void cancel(final int i) {
        AppMethodBeat.m2504i(58572);
        this.gcT.lock(1000, String.format("MMAutoAuth.cancel,%d", new Object[]{Integer.valueOf(i)}));
        new C5039bj<Object>() {
            public final Object run() {
                AppMethodBeat.m2504i(58551);
                try {
                    C32871t.m53772mA(i);
                } catch (RemoteException e) {
                    C4990ab.m7413e("MicroMsg.MMAutoAuth", "exception:%s", C5046bo.m7574l(e));
                }
                AppMethodBeat.m2505o(58551);
                return null;
            }
        }.mo10372b(this.handler);
        AppMethodBeat.m2505o(58572);
    }

    public final boolean acT() {
        return this.gcP < 5;
    }

    public final String getNetworkServerIp() {
        AppMethodBeat.m2504i(58573);
        String networkServerIp = MMLogic.getNetworkServerIp();
        AppMethodBeat.m2505o(58573);
        return networkServerIp;
    }

    public final String[] getIPsString(boolean z) {
        AppMethodBeat.m2504i(58574);
        String[] iPsString = MMLogic.getIPsString(z);
        AppMethodBeat.m2505o(58574);
        return iPsString;
    }

    public final void reset() {
        AppMethodBeat.m2504i(58575);
        this.gcT.lock(1000, "MMAutoAuth.reset");
        new C328656().mo10372b(this.handler);
        AppMethodBeat.m2505o(58575);
    }

    /* renamed from: a */
    public final synchronized int mo5548a(final C1930r c1930r, final C1919l c1919l) {
        int intValue;
        AppMethodBeat.m2504i(58576);
        this.gcT.lock(1000, "MMAutoAuth.send");
        intValue = ((Integer) new C5039bj<Integer>(Integer.valueOf(-1)) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(58558);
                Integer amW = amW();
                AppMethodBeat.m2505o(58558);
                return amW;
            }

            private Integer amW() {
                AppMethodBeat.m2504i(58557);
                Integer valueOf;
                try {
                    valueOf = Integer.valueOf(C32871t.m53767a(C32871t.this, c1930r, c1919l));
                    AppMethodBeat.m2505o(58557);
                    return valueOf;
                } catch (RemoteException e) {
                    C4990ab.m7413e("MicroMsg.MMAutoAuth", "exception:%s", C5046bo.m7574l(e));
                    C32871t.m53768a(C32871t.this);
                    valueOf = Integer.valueOf(-1);
                    AppMethodBeat.m2505o(58557);
                    return valueOf;
                }
            }
        }.mo10372b(this.handler)).intValue();
        AppMethodBeat.m2505o(58576);
        return intValue;
    }

    /* renamed from: b */
    private int m53771b(C1930r c1930r, C1919l c1919l) {
        AppMethodBeat.m2504i(58577);
        if (C1892aa.anp().anc()) {
            AppMethodBeat.m2505o(58577);
            return -1;
        }
        C4816h adt = c1930r.adt();
        C1898c c37970a = new C37970a(this);
        c37970a.setUsername(adt.getUserName());
        int a = C1892aa.anp().mo60738a(c1930r, c1919l, c37970a, 0);
        if (a < 0) {
            C4990ab.m7412e("MicroMsg.MMAutoAuth", "auth: net.send err");
        } else {
            C4990ab.m7416i("MicroMsg.MMAutoAuth", "auth: netid=".concat(String.valueOf(a)));
        }
        AppMethodBeat.m2505o(58577);
        return a;
    }

    public final boolean amS() {
        AppMethodBeat.m2504i(58578);
        if (90000 >= SystemClock.elapsedRealtime() - this.gcR) {
            C4990ab.m7421w("MicroMsg.MMAutoAuth", "auto limit lastSessionTimeout=%d, curtime=%d", Long.valueOf(this.gcR), Long.valueOf(SystemClock.elapsedRealtime()));
            AppMethodBeat.m2505o(58578);
            return false;
        }
        this.gcR = SystemClock.elapsedRealtime();
        this.gcU.mo5497a(new byte[0], new byte[0], new byte[0], this.gcU.mo5495QF());
        AppMethodBeat.m2505o(58578);
        return true;
    }

    /* renamed from: cF */
    public final void mo5565cF(final boolean z) {
        AppMethodBeat.m2504i(58579);
        new C5039bj<Object>(Integer.valueOf(-1)) {
            public final Object run() {
                AppMethodBeat.m2504i(58559);
                BaseEvent.onForeground(z);
                C41753a.m73603cL(z);
                C4872b.m7236cE(z);
                AppMethodBeat.m2505o(58559);
                return null;
            }
        }.mo10372b(this.handler);
        AppMethodBeat.m2505o(58579);
    }

    /* renamed from: a */
    public final void mo5558a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4) {
        ArrayList arrayList;
        AppMethodBeat.m2504i(58580);
        this.gcT.lock(1000, "MMAutoAuth.setIDCHostInfo");
        List<C4838o> akF = C4838o.akF(str2);
        List<C4838o> akF2 = C4838o.akF(str);
        String str5 = "MicroMsg.MMAutoAuth";
        String str6 = "dkidc setIDCHostInfo short:[%s][%s](%d) long:[%s][%s](%d) reset:%s";
        Object[] objArr = new Object[7];
        objArr[0] = str3;
        objArr[1] = str;
        objArr[2] = Integer.valueOf(akF2.size());
        objArr[3] = str4;
        objArr[4] = str2;
        objArr[5] = Integer.valueOf(akF.size());
        objArr[6] = z ? "!!!!!CHANGE IDC NOW" : "false";
        C4990ab.m7411d(str5, str6, objArr);
        final HashMap hashMap = new HashMap();
        for (C4838o c4838o : akF) {
            arrayList = (ArrayList) hashMap.get(c4838o.host);
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(c4838o.host, arrayList);
            }
            arrayList.add(c4838o.nJq);
        }
        final HashMap hashMap2 = new HashMap();
        for (C4838o c4838o2 : akF2) {
            arrayList = (ArrayList) hashMap2.get(c4838o2.host);
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap2.put(c4838o2.host, arrayList);
            }
            arrayList.add(c4838o2.nJq);
        }
        final int[] iArr3 = iArr2;
        final int[] iArr4 = iArr;
        new C5039bj<Object>(Integer.valueOf(-1)) {
            public final Object run() {
                AppMethodBeat.m2504i(58560);
                for (Entry entry : hashMap.entrySet()) {
                    try {
                        MMLogic.saveAuthLongIPs((String) entry.getKey(), (String[]) ((ArrayList) entry.getValue()).toArray(new String[0]));
                    } catch (Throwable th) {
                        MMLogic.saveAuthLongIPs((String) entry.getKey(), (String[]) ((ArrayList) entry.getValue()).toArray(new String[0]));
                    }
                }
                for (Entry entry2 : hashMap2.entrySet()) {
                    MMLogic.saveAuthShortIPs((String) entry2.getKey(), (String[]) ((ArrayList) entry2.getValue()).toArray(new String[0]));
                }
                MMLogic.saveAuthPorts(iArr3, iArr4);
                BaseEvent.onNetworkChange();
                AppMethodBeat.m2505o(58560);
                return null;
            }
        }.mo10372b(this.handler);
        AppMethodBeat.m2505o(58580);
    }

    /* renamed from: d */
    public final void mo5570d(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(58581);
        this.gcT.lock(1000, "MMAutoAuth.setFixedHost");
        C4990ab.m7417i("MicroMsg.MMAutoAuth", "dkidc setFixedHost debug short:%s:%s long:%s:%s", str, str2, str3, str4);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str3)) {
            C4990ab.m7420w("MicroMsg.MMAutoAuth", "dkidc setFixedHost FAILED ! check assist");
            AppMethodBeat.m2505o(58581);
            return;
        }
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        new C5039bj<Object>(Integer.valueOf(-1)) {
            public final Object run() {
                AppMethodBeat.m2504i(58561);
                MMLogic.setDebugIP(str5, str6, str7, str8);
                BaseEvent.onNetworkChange();
                AppMethodBeat.m2505o(58561);
                return null;
            }
        }.mo10372b(this.handler);
        AppMethodBeat.m2505o(58581);
    }

    public final void setNewDnsDebugHost(final String str, final String str2) {
        AppMethodBeat.m2504i(58582);
        if (C5046bo.isNullOrNil(str) && C5046bo.isNullOrNil(str2)) {
            C4990ab.m7410d("MicroMsg.MMAutoAuth", "setNewDnsDebugHost FAILED ! check assist");
            AppMethodBeat.m2505o(58582);
            return;
        }
        new C5039bj<Object>() {
            public final Object run() {
                AppMethodBeat.m2504i(58562);
                MMLogic.setNewDnsDebugHost(str, str2);
                AppMethodBeat.m2505o(58562);
                return null;
            }
        }.mo10372b(this.handler);
        AppMethodBeat.m2505o(58582);
    }

    public final void amN() {
        AppMethodBeat.m2504i(58583);
        this.gcT.lock(1000, "MMAutoAuth.forceUpdateHostCache");
        new C5039bj<Object>(Integer.valueOf(-1)) {
            public final Object run() {
                AppMethodBeat.m2504i(58564);
                BaseEvent.onNetworkChange();
                AppMethodBeat.m2505o(58564);
                return null;
            }
        }.mo10372b(this.handler);
        AppMethodBeat.m2505o(58583);
    }

    /* renamed from: qs */
    public final void mo5577qs(final String str) {
        AppMethodBeat.m2504i(58584);
        this.gcT.lock(1000, "MMAutoAuth.ipxxStatistics");
        new C5039bj<Object>() {
            public final Object run() {
                AppMethodBeat.m2504i(58552);
                C4990ab.dot();
                IPxxLogic.onIPxx(str, 0);
                AppMethodBeat.m2505o(58552);
                return null;
            }
        }.mo10372b(this.handler);
        AppMethodBeat.m2505o(58584);
    }

    /* renamed from: a */
    public final void mo5552a(C1889b c1889b) {
        AppMethodBeat.m2504i(58585);
        C1892aa.ank().geg = c1889b;
        AppMethodBeat.m2505o(58585);
    }

    public final C1912i amO() {
        AppMethodBeat.m2504i(58586);
        C32858ac anl = C1892aa.anl();
        AppMethodBeat.m2505o(58586);
        return anl;
    }

    /* Access modifiers changed, original: final */
    public final boolean amT() {
        AppMethodBeat.m2504i(58587);
        if (10001 == C1947ae.giz && C1947ae.giA > 0) {
            C1947ae.giA = 0;
            amS();
        }
        if (this.gcU.adb()) {
            AppMethodBeat.m2505o(58587);
            return true;
        } else if (C1892aa.anp().anc()) {
            C4990ab.m7416i("MicroMsg.MMAutoAuth", "makeSureAuth hasAuthCmd ret false");
            AppMethodBeat.m2505o(58587);
            return false;
        } else if (this.gcY != -1) {
            C4990ab.m7420w("MicroMsg.MMAutoAuth", "makeSureAuth auto limit now is getting cert, ret false");
            AppMethodBeat.m2505o(58587);
            return false;
        } else {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (60000 >= elapsedRealtime - this.gcQ && this.gcQ > 0) {
                C4990ab.m7421w("MicroMsg.MMAutoAuth", "makeSureAuth auto limit lastAutoAuthtime=%d, curtime=%d, return false", Long.valueOf(this.gcQ), Long.valueOf(elapsedRealtime));
                AppMethodBeat.m2505o(58587);
                return false;
            } else if (C4996ah.getContext().getSharedPreferences("auth_hold_prefs", 0).getBoolean("auth_ishold", false)) {
                C4990ab.m7416i("MicroMsg.MMAutoAuth", "makeSureAuth AUTH_HOLD_KEY hold ret false");
                if (!C1892aa.anp().and()) {
                    C4990ab.m7413e("MicroMsg.MMAutoAuth", "sendImp hit push hold, pid:%d, stack[%s]", Integer.valueOf(Process.myPid()), C5046bo.dpG());
                    C1892aa.anm().post(new C328633());
                }
                AppMethodBeat.m2505o(58587);
                return false;
            } else {
                C1930r de = C1892aa.anp().mo60743de(amV());
                if (de != null) {
                    try {
                        if (!(de instanceof C1931a)) {
                            this.gcQ = SystemClock.elapsedRealtime();
                            C4990ab.m7417i("MicroMsg.MMAutoAuth", "makeSureAuth rest lastAutoAuthTime[%d]", Long.valueOf(this.gcQ));
                            mo53431a(de, 3, 3);
                        } else if (30000 < elapsedRealtime - this.gcS || this.gcS <= 0) {
                            C4990ab.m7416i("MicroMsg.MMAutoAuth", "makeSureAuth session time out in push_notify mode, send broast to mm");
                            this.gcS = SystemClock.elapsedRealtime();
                            C1892aa.anq().onPush(5, null);
                        } else {
                            C4990ab.m7416i("MicroMsg.MMAutoAuth", "makeSureAuth session time out in push_notify mode, but hit limit");
                            AppMethodBeat.m2505o(58587);
                            return false;
                        }
                    } catch (RemoteException e) {
                        C4990ab.m7413e("MicroMsg.MMAutoAuth", "makeSureAuth exception:%s", C5046bo.m7574l(e));
                    }
                } else {
                    C4990ab.m7416i("MicroMsg.MMAutoAuth", "makeSureAuth getAutoAuthRR is null");
                }
                C4990ab.m7416i("MicroMsg.MMAutoAuth", "makeSureAuth at last ret false");
                AppMethodBeat.m2505o(58587);
                return false;
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: h */
    public final void mo53438h(int i, int i2, String str) {
        int i3;
        AppMethodBeat.m2504i(58588);
        C4990ab.m7416i("MicroMsg.MMAutoAuth", "summerauth handleAutoAuthFail inErrType=" + i + ", inErrCode=" + i2 + ", errMsg=" + str + " stack=" + C5046bo.dpG());
        if (i == 4 && i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
            C4990ab.m7412e("MicroMsg.MMAutoAuth", "summerauth handleAutoAuthFail autoauth should not be return MM_ERR_BLOCK_BY_SPAM trans to MM_ERR_AUTH_ANOTHERPLACE");
            i3 = -100;
        } else {
            i3 = i2;
        }
        if (i == 5 && i2 == -13) {
            C4990ab.m7412e("MicroMsg.MMAutoAuth", "summerauth handleAutoAuthFail autoauth should not be return MM_ERR_SESSIONTIMEOUT trans to MM_ERR_PASSWORD");
            i = 4;
            i3 = -3;
            C7053e.pXa.mo8378a(148, 42, 1, false);
        }
        int i4 = i;
        if ((i4 == 6 && i2 == -10001) || (i4 == 5 && i2 != -13)) {
            C4990ab.m7412e("MicroMsg.MMAutoAuth", "summerauth handleAutoAuthFail autoauth ENCODE ERROR check sp");
            SharedPreferences ZQ = C1818ay.m3737ZQ();
            String string = ZQ.getString("_auth_key", "");
            String string2 = ZQ.getString("server_id", "");
            if (C5046bo.isNullOrNil(string) && C5046bo.isNullOrNil(string2)) {
                C4990ab.m7412e("MicroMsg.MMAutoAuth", "summerauth handleAutoAuthFail autoauth ENCODE ERROR check sp aak and cookie null logout");
                i3 = ZipJNI.UNZ_INTERNALERROR;
                C7053e.pXa.mo8378a(148, 52, 1, false);
                i4 = 4;
            }
        }
        C1892aa.anp().mo60745i(i4, i3, str);
        if (i4 == 4 && (i3 == -100 || i3 == -205 || i3 == -213)) {
            C4996ah.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().putBoolean("auth_ishold", true).commit();
            reset();
        }
        AppMethodBeat.m2505o(58588);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: g */
    public final boolean mo53437g(String str, String str2, int i) {
        boolean z;
        int i2;
        int i3;
        String string;
        AppMethodBeat.m2504i(58589);
        String str3 = "MicroMsg.MMAutoAuth";
        String str4 = "summerauths saveAAKAndCookieToSp aak[%s] uin[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(str == null ? -1 : str.length());
        objArr[1] = Integer.valueOf(i);
        C4990ab.m7417i(str3, str4, objArr);
        C4996ah.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().remove("auth_ishold").commit();
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("auth_info_key_prefs", C1448h.m3078Mu());
        boolean z2 = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
        int i4 = sharedPreferences.getInt("key_auth_update_version", 0);
        int i5 = sharedPreferences.getInt("_auth_uin", 0);
        String string2 = sharedPreferences.getString("_auth_key", "");
        String string3 = sharedPreferences.getString("server_id", "");
        Editor edit = sharedPreferences.edit();
        edit.putBoolean("key_auth_info_prefs_created", true);
        edit.putInt("key_auth_update_version", C7243d.vxo);
        edit.putInt("_auth_uin", i);
        edit.putString("_auth_key", str);
        edit.putString("server_id", str2);
        if (!edit.commit()) {
            C4990ab.m7412e("MicroMsg.MMAutoAuth", "summerauth save aak & id commit failed 1th!");
            C7053e.pXa.mo8378a(148, 36, 1, false);
            if (!edit.commit()) {
                C4990ab.m7412e("MicroMsg.MMAutoAuth", "summerauth save aak & id commit failed 2nd!");
                C7053e.pXa.mo8378a(148, 37, 1, false);
                z = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
                i2 = sharedPreferences.getInt("key_auth_update_version", 0);
                i3 = sharedPreferences.getInt("_auth_uin", 0);
                string = sharedPreferences.getString("_auth_key", "");
                String string4 = sharedPreferences.getString("server_id", "");
                C4990ab.m7413e("MicroMsg.MMAutoAuth", "summerauth save aak & id commit failed 2th so ret false old vs new vs input create[%b, %b, %b] version[%d, %d, %d], uin[%d, %d, %d], aak[%s, %s, %s], cookie[%s, %s, %s]", Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.TRUE, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(C7243d.vxo), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i), string2, string, str, string3, string4, str2);
                C4990ab.dot();
                AppMethodBeat.m2505o(58589);
                return false;
            }
        }
        z = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
        i2 = sharedPreferences.getInt("key_auth_update_version", 0);
        i3 = sharedPreferences.getInt("_auth_uin", 0);
        string = sharedPreferences.getString("_auth_key", "");
        String string5 = sharedPreferences.getString("server_id", "");
        if (z && i2 == C7243d.vxo && i3 == i && string.equals(str) && string5.equals(str2)) {
            this.gcZ.doc();
            this.gcZ.set(1, Integer.valueOf(C7243d.vxo));
            this.gcZ.set(2, Integer.valueOf(i));
            this.gcZ.set(3, str);
            this.gcZ.set(4, str2);
            this.gcZ.drZ();
            String str5 = "MicroMsg.MMAutoAuth";
            String str6 = "summerauth save aak & id ok old vs new vs input[%b, %b, %b, %b] version[%d, %d, %d. %d], uin[%d, %d, %d, %d], aak[%s, %s, %s, %s], cookie[%s, %s, %s, %s]";
            Object[] objArr2 = new Object[20];
            objArr2[0] = Boolean.valueOf(z2);
            objArr2[1] = Boolean.valueOf(z);
            objArr2[2] = Boolean.TRUE;
            objArr2[3] = Boolean.valueOf(!this.gcZ.xIs);
            objArr2[4] = Integer.valueOf(i4);
            objArr2[5] = Integer.valueOf(i2);
            objArr2[6] = Integer.valueOf(C7243d.vxo);
            objArr2[7] = (Integer) this.gcZ.get(1);
            objArr2[8] = Integer.valueOf(i5);
            objArr2[9] = Integer.valueOf(i3);
            objArr2[10] = Integer.valueOf(i);
            objArr2[11] = (Integer) this.gcZ.get(2);
            objArr2[12] = string2;
            objArr2[13] = string;
            objArr2[14] = str;
            objArr2[15] = (String) this.gcZ.get(3);
            objArr2[16] = string3;
            objArr2[17] = string5;
            objArr2[18] = str2;
            objArr2[19] = (String) this.gcZ.get(4);
            C4990ab.m7417i(str5, str6, objArr2);
            AppMethodBeat.m2505o(58589);
            return true;
        }
        C4990ab.m7413e("MicroMsg.MMAutoAuth", "summerauth save aak & id commit failed check not equal so ret false old vs new vs input create[%b, %b, %b] version[%d, %d, %d], uin[%d, %d, %d], aak[%s, %s, %s], cookie[%s, %s, %s]", Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.TRUE, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(C7243d.vxo), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i), string2, string, str, string3, string5, str2);
        C4990ab.dot();
        AppMethodBeat.m2505o(58589);
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo53431a(C1930r c1930r, int i, int i2) {
        AppMethodBeat.m2504i(58590);
        c1930r.mo5627a(this.gcV, i, i2);
        AppMethodBeat.m2505o(58590);
    }

    /* renamed from: a */
    public final void mo5557a(C4848y c4848y) {
        AppMethodBeat.m2504i(58591);
        C1892aa.anp().ane();
        AppMethodBeat.m2505o(58591);
    }

    public final byte[] amU() {
        AppMethodBeat.m2504i(58592);
        if (this.gcU.adb()) {
            C4846a c4846a = new C4846a();
            c4846a.uin = this.gcU.mo5495QF();
            c4846a.fIi = C5046bo.anf(C4996ah.getContext().getSharedPreferences("notify_sync_pref", C1448h.m3078Mu()).getString("notify_sync_key_keybuf", ""));
            c4846a.netType = C4787a.getNetType(C4996ah.getContext());
            c4846a.vyo = C4787a.dlZ();
            try {
                byte[] ZT = c4846a.mo5742ZT();
                this.eJt = c4846a.eJt;
                AppMethodBeat.m2505o(58592);
                return ZT;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MMAutoAuth", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(58592);
                return null;
            }
        }
        AppMethodBeat.m2505o(58592);
        return null;
    }

    public final int getHostByName(String str, List<String> list) {
        AppMethodBeat.m2504i(58593);
        int hostByName = MMLogic.getHostByName(str, list);
        AppMethodBeat.m2505o(58593);
        return hostByName;
    }

    /* renamed from: a */
    public final int mo5550a(boolean z, List<String> list) {
        AppMethodBeat.m2504i(58594);
        int snsIpsForScene = MMLogic.getSnsIpsForScene(list, z);
        AppMethodBeat.m2505o(58594);
        return snsIpsForScene;
    }

    /* renamed from: a */
    public final int mo5549a(String str, boolean z, List<String> list) {
        AppMethodBeat.m2504i(58595);
        int snsIpsForSceneWithHostName = MMLogic.getSnsIpsForSceneWithHostName(list, str, z);
        AppMethodBeat.m2505o(58595);
        return snsIpsForSceneWithHostName;
    }

    public final String getIspId() {
        AppMethodBeat.m2504i(58596);
        String ispId = MMLogic.getIspId();
        AppMethodBeat.m2505o(58596);
        return ispId;
    }

    public final void setHostInfo(final String[] strArr, final String[] strArr2, final int[] iArr) {
        AppMethodBeat.m2504i(58597);
        this.gcT.lock(1000, "MMAutoAuth.setHostInfo");
        new C5039bj<Object>() {
            public final Object run() {
                AppMethodBeat.m2504i(58554);
                MMLogic.setHostInfo(strArr, strArr2, iArr);
                AppMethodBeat.m2505o(58554);
                return null;
            }
        }.mo10372b(this.handler);
        AppMethodBeat.m2505o(58597);
    }

    /* renamed from: g */
    public final int mo5571g(int i, byte[] bArr) {
        AppMethodBeat.m2504i(58598);
        int h = C32859ae.anu().mo53428h(i, bArr);
        AppMethodBeat.m2505o(58598);
        return h;
    }

    /* renamed from: a */
    public final void mo5551a(int i, String str, int i2, boolean z) {
        AppMethodBeat.m2504i(58599);
        this.gcT.lock(1000, "MMAutoAuth.logUtil");
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        final boolean z2 = z;
        new C5039bj<Object>() {
            public final Object run() {
                AppMethodBeat.m2504i(58555);
                if (i3 == 3) {
                    Date date = new Date();
                    date.setTime(C5046bo.anU() - (86400000 * ((long) i4)));
                    MMLogic.uploadFile(C6457e.eSo + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(date) + ".txt", str2, "");
                } else if (i3 == 2) {
                    C4990ab.dot();
                    MMLogic.uploadLog(new int[]{i4}, z2, str2, "");
                } else {
                    C4990ab.dot();
                }
                AppMethodBeat.m2505o(58555);
                return null;
            }
        }.mo10372b(this.handler);
        AppMethodBeat.m2505o(58599);
    }

    public final void setSignallingStrategy(long j, long j2) {
        AppMethodBeat.m2504i(58600);
        StnLogic.setSignallingStrategy(j, j2);
        AppMethodBeat.m2505o(58600);
    }

    public final void keepSignalling() {
        AppMethodBeat.m2504i(58601);
        StnLogic.keepSignalling();
        AppMethodBeat.m2505o(58601);
    }

    public final void stopSignalling() {
        AppMethodBeat.m2504i(58602);
        StnLogic.stopSignalling();
        AppMethodBeat.m2505o(58602);
    }

    /* renamed from: a */
    public final void mo5555a(C1926o c1926o) {
        AppMethodBeat.m2504i(58603);
        C1892aa.ans().gdH = c1926o;
        AppMethodBeat.m2505o(58603);
    }

    /* renamed from: a */
    public final void mo5556a(C1933s c1933s) {
        this.gda = c1933s;
    }

    public final boolean amV() {
        boolean z = false;
        AppMethodBeat.m2504i(58604);
        if (this.gda == null) {
            AppMethodBeat.m2505o(58604);
        } else {
            try {
                z = this.gda.check();
                AppMethodBeat.m2505o(58604);
            } catch (RemoteException e) {
                AppMethodBeat.m2505o(58604);
            }
        }
        return z;
    }

    /* renamed from: a */
    public final void mo5553a(C1906g c1906g) {
        this.gdb = c1906g;
    }

    /* renamed from: mz */
    public final void mo53439mz(int i) {
        AppMethodBeat.m2504i(58605);
        if (this.gdb == null) {
            AppMethodBeat.m2505o(58605);
            return;
        }
        try {
            this.gdb.mo4533gi(i);
            AppMethodBeat.m2505o(58605);
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.MMAutoAuth", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58605);
        }
    }

    public final void reportFailIp(String str) {
        AppMethodBeat.m2504i(58606);
        MMLogic.reportFailIp(str);
        AppMethodBeat.m2505o(58606);
    }

    /* renamed from: qt */
    public final void mo5578qt(String str) {
        AppMethodBeat.m2504i(58607);
        C4990ab.m7413e("MicroMsg.MMAutoAuth", "killPush %s", str);
        AppMethodBeat.m2505o(58607);
    }

    /* renamed from: cG */
    public final void mo5566cG(boolean z) {
        AppMethodBeat.m2504i(58608);
        if (C4879a.xxA == null) {
            C4990ab.m7420w("MicroMsg.MMAutoAuth", "loginevent but eventpool null, event:".concat(String.valueOf(z)));
            AppMethodBeat.m2505o(58608);
            return;
        }
        AppMethodBeat.m2505o(58608);
    }

    public final C1912i adh() {
        return null;
    }

    /* renamed from: cH */
    public final void mo5567cH(boolean z) {
        AppMethodBeat.m2504i(58609);
        C4988aa.initLanguage(C4996ah.getContext());
        AppMethodBeat.m2505o(58609);
    }

    /* renamed from: cI */
    public final void mo5568cI(boolean z) {
        AppMethodBeat.m2504i(58610);
        C4990ab.m7411d("MicroMsg.MMAutoAuth", "summer setMMTLS enable[%b]", Boolean.valueOf(z));
        MMLogic.setMmtlsCtrlInfo(z);
        AppMethodBeat.m2505o(58610);
    }

    public final void adi() {
        AppMethodBeat.m2504i(58611);
        StnLogic.makesureLongLinkConnected();
        AppMethodBeat.m2505o(58611);
    }

    public final void adj() {
        AppMethodBeat.m2504i(58612);
        StnLogic.startNetworkAnalysis();
        AppMethodBeat.m2505o(58612);
    }

    /* renamed from: a */
    public final void mo5554a(C1909h c1909h) {
        this.gdc = c1909h;
    }

    public final /* bridge */ /* synthetic */ C1899d amM() {
        return this.gcU;
    }

    public final /* bridge */ /* synthetic */ C1898c adg() {
        return this.gcU;
    }

    /* renamed from: mA */
    static /* synthetic */ void m53772mA(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(58615);
        C4990ab.m7416i("MicroMsg.MMAutoAuth", "cancel: netid=".concat(String.valueOf(i)));
        if (i < 0) {
            C4990ab.m7412e("MicroMsg.MMAutoAuth", "error netid < 0, ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(58615);
            return;
        }
        C37973z anp = C1892aa.anp();
        C4990ab.m7416i("MicroMsg.MMNativeNetTaskAdapter", "stopTask netId=".concat(String.valueOf(i)));
        if (i < 0 || i >= 100) {
            AppMethodBeat.m2505o(58615);
            return;
        }
        synchronized (anp.gdP) {
            try {
                if (anp.gdP[i] != null) {
                    i2 = anp.gdP[i].taskId;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(58615);
            }
        }
        if (i2 != 0) {
            StnLogic.stopTask(i2);
        }
        synchronized (anp.gdP) {
            try {
                if (anp.gdP[i] != null) {
                    C4990ab.m7417i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi stopTask outQueue: netId:%d hash:%d type:%d", Integer.valueOf(i2), Integer.valueOf(anp.gdP[i].gdT.getType()), Integer.valueOf(anp.gdP[i].gdT.acO()));
                    anp.gdP[i] = null;
                }
            } catch (RemoteException e) {
                C4990ab.m7413e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", C5046bo.m7574l(e));
            } catch (Throwable th) {
                AppMethodBeat.m2505o(58615);
            }
        }
    }
}
