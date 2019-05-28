package com.tencent.mm.network;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.magicbox.IPxxLogic;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.ay;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.o;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.y;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;

public final class t extends com.tencent.mm.network.f.a implements com.tencent.mm.network.a.a, e {
    byte[] eJt;
    int fPj = 0;
    int gcP = 0;
    private long gcQ = 0;
    private long gcR = 0;
    private long gcS = 0;
    private WakerLock gcT = null;
    public a gcU;
    a gcV;
    b gcW;
    long gcX = 0;
    int gcY = -1;
    private y gcZ;
    private s gda;
    private g gdb;
    h gdc;
    public ak handler;

    /* renamed from: com.tencent.mm.network.t$12 */
    public class AnonymousClass12 extends bj<Object> {
        final /* synthetic */ String gdv;
        final /* synthetic */ String gdx;

        public AnonymousClass12(String str, String str2) {
            this.gdx = str;
            this.gdv = str2;
            super(1000, null, (byte) 0);
        }

        public final Object run() {
            AppMethodBeat.i(58563);
            StnLogic.setDebugIP(this.gdx, this.gdv);
            AppMethodBeat.o(58563);
            return null;
        }
    }

    static class a extends com.tencent.mm.network.j.a implements l {
        private t ebz;
        private WakerLock gdy;
        private int gdz = 0;

        public a(t tVar, WakerLock wakerLock) {
            this.ebz = tVar;
            this.gdy = wakerLock;
        }

        public final void a(r rVar, int i, int i2, String str) {
            AppMethodBeat.i(58566);
            this.gdy.lock(1000, "MMAutoAuth.IOnAutoAuth.onAutoAuth");
            final r rVar2 = rVar;
            final int i3 = i;
            final int i4 = i2;
            final String str2 = str;
            new bj<Object>() {
                public final Object run() {
                    AppMethodBeat.i(58565);
                    try {
                        t.a(a.this.ebz, rVar2, str2);
                    } catch (RemoteException e) {
                        ab.e("MicroMsg.MMAutoAuth", "exception:%s", bo.l(e));
                    }
                    AppMethodBeat.o(58565);
                    return null;
                }
            }.b(this.ebz.handler);
            AppMethodBeat.o(58566);
        }

        public final void a(int i, int i2, int i3, String str, r rVar, byte[] bArr) {
            AppMethodBeat.i(58567);
            if (rVar.getType() == 252 || rVar.getType() == 701) {
                ab.d("MicroMsg.MMAutoAuth", "summerauth IOnAutoAuth onGYNetEnd manual auth");
                if (rVar.adu().ady() != 0 || i2 != 0) {
                    e.pXa.a(148, ZipJNI.UNZ_PARAMERROR == i3 ? 30 : 29, 1, false);
                } else if (rVar.adv() == 2) {
                    e.pXa.a(148, 28, 1, false);
                    this.gdz++;
                    if (this.gdz > 1) {
                        ab.w("MicroMsg.MMAutoAuth", "summerauth manualLoginDecodeFailedTry beyond 1 no more try!");
                        this.ebz.h(i2, i3, "auth_decode_failed_" + bo.bc(str, ""));
                    } else {
                        rVar.a(this, 0, 0);
                    }
                } else {
                    this.gdz = 0;
                    rVar.a((j) this, i2, i3, str);
                }
            }
            if (rVar.adu().ady() == 0 && i2 == 0) {
                rVar.a((j) this, i2, i3, str);
                AppMethodBeat.o(58567);
            } else if (ZipJNI.UNZ_PARAMERROR == i3) {
                this.ebz.gcY = i;
                rVar.a(this.ebz.gcU, this.ebz.gcW, 0, 0);
                AppMethodBeat.o(58567);
            } else {
                if (-301 == i3) {
                    rVar.a((j) this, i2, i3, str);
                } else if (ZipJNI.UNZ_CRCERROR == i3) {
                    rVar.a((j) this, i2, i3, str);
                } else if (-17 == i3) {
                    rVar.a((j) this, i2, i3, str);
                }
                this.ebz.h(i2, i3, "autoauth_errmsg_" + bo.bc(str, ""));
                AppMethodBeat.o(58567);
            }
        }
    }

    static class b extends com.tencent.mm.network.j.a implements l {
        private t ebz;
        private WakerLock gdy;

        public b(t tVar, WakerLock wakerLock) {
            this.ebz = tVar;
            this.gdy = wakerLock;
        }

        public final void a(final r rVar, final int i, final int i2, String str) {
            AppMethodBeat.i(58569);
            this.gdy.lock(1000, "MMAutoAuth.IOnGetCert.onAutoAuth");
            new bj<Object>() {
                public final Object run() {
                    AppMethodBeat.i(58568);
                    try {
                        t.a(b.this.ebz, rVar);
                    } catch (RemoteException e) {
                        ab.e("MicroMsg.MMAutoAuth", "exception:%s", bo.l(e));
                    }
                    AppMethodBeat.o(58568);
                    return null;
                }
            }.b(this.ebz.handler);
            AppMethodBeat.o(58569);
        }

        public final void a(int i, int i2, int i3, String str, r rVar, byte[] bArr) {
        }
    }

    public t(ak akVar) {
        AppMethodBeat.i(58570);
        if (akVar == null) {
            akVar = new ak();
        }
        this.handler = akVar;
        this.gcU = new a(this);
        this.gcT = new WakerLock(aa.getContext(), "MicroMsg.MMAutoAuth");
        this.gcV = new a(this, this.gcT);
        this.gcW = new b(this, this.gcT);
        this.gcZ = new y(ac.eSj + "autoauth.cfg");
        AppMethodBeat.o(58570);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(58571);
        reset();
        super.finalize();
        AppMethodBeat.o(58571);
    }

    public final void cancel(final int i) {
        AppMethodBeat.i(58572);
        this.gcT.lock(1000, String.format("MMAutoAuth.cancel,%d", new Object[]{Integer.valueOf(i)}));
        new bj<Object>() {
            public final Object run() {
                AppMethodBeat.i(58551);
                try {
                    t.mA(i);
                } catch (RemoteException e) {
                    ab.e("MicroMsg.MMAutoAuth", "exception:%s", bo.l(e));
                }
                AppMethodBeat.o(58551);
                return null;
            }
        }.b(this.handler);
        AppMethodBeat.o(58572);
    }

    public final boolean acT() {
        return this.gcP < 5;
    }

    public final String getNetworkServerIp() {
        AppMethodBeat.i(58573);
        String networkServerIp = MMLogic.getNetworkServerIp();
        AppMethodBeat.o(58573);
        return networkServerIp;
    }

    public final String[] getIPsString(boolean z) {
        AppMethodBeat.i(58574);
        String[] iPsString = MMLogic.getIPsString(z);
        AppMethodBeat.o(58574);
        return iPsString;
    }

    public final void reset() {
        AppMethodBeat.i(58575);
        this.gcT.lock(1000, "MMAutoAuth.reset");
        new bj<Object>() {
            public final Object run() {
                AppMethodBeat.i(58556);
                t.a(t.this);
                AppMethodBeat.o(58556);
                return null;
            }
        }.b(this.handler);
        AppMethodBeat.o(58575);
    }

    public final synchronized int a(final r rVar, final l lVar) {
        int intValue;
        AppMethodBeat.i(58576);
        this.gcT.lock(1000, "MMAutoAuth.send");
        intValue = ((Integer) new bj<Integer>(Integer.valueOf(-1)) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(58558);
                Integer amW = amW();
                AppMethodBeat.o(58558);
                return amW;
            }

            private Integer amW() {
                AppMethodBeat.i(58557);
                Integer valueOf;
                try {
                    valueOf = Integer.valueOf(t.a(t.this, rVar, lVar));
                    AppMethodBeat.o(58557);
                    return valueOf;
                } catch (RemoteException e) {
                    ab.e("MicroMsg.MMAutoAuth", "exception:%s", bo.l(e));
                    t.a(t.this);
                    valueOf = Integer.valueOf(-1);
                    AppMethodBeat.o(58557);
                    return valueOf;
                }
            }
        }.b(this.handler)).intValue();
        AppMethodBeat.o(58576);
        return intValue;
    }

    private int b(r rVar, l lVar) {
        AppMethodBeat.i(58577);
        if (aa.anp().anc()) {
            AppMethodBeat.o(58577);
            return -1;
        }
        h adt = rVar.adt();
        c aVar = new a(this);
        aVar.setUsername(adt.getUserName());
        int a = aa.anp().a(rVar, lVar, aVar, 0);
        if (a < 0) {
            ab.e("MicroMsg.MMAutoAuth", "auth: net.send err");
        } else {
            ab.i("MicroMsg.MMAutoAuth", "auth: netid=".concat(String.valueOf(a)));
        }
        AppMethodBeat.o(58577);
        return a;
    }

    public final boolean amS() {
        AppMethodBeat.i(58578);
        if (90000 >= SystemClock.elapsedRealtime() - this.gcR) {
            ab.w("MicroMsg.MMAutoAuth", "auto limit lastSessionTimeout=%d, curtime=%d", Long.valueOf(this.gcR), Long.valueOf(SystemClock.elapsedRealtime()));
            AppMethodBeat.o(58578);
            return false;
        }
        this.gcR = SystemClock.elapsedRealtime();
        this.gcU.a(new byte[0], new byte[0], new byte[0], this.gcU.QF());
        AppMethodBeat.o(58578);
        return true;
    }

    public final void cF(final boolean z) {
        AppMethodBeat.i(58579);
        new bj<Object>(Integer.valueOf(-1)) {
            public final Object run() {
                AppMethodBeat.i(58559);
                BaseEvent.onForeground(z);
                com.tencent.mm.an.a.cL(z);
                com.tencent.mm.sdk.a.b.cE(z);
                AppMethodBeat.o(58559);
                return null;
            }
        }.b(this.handler);
        AppMethodBeat.o(58579);
    }

    public final void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4) {
        ArrayList arrayList;
        AppMethodBeat.i(58580);
        this.gcT.lock(1000, "MMAutoAuth.setIDCHostInfo");
        List<o> akF = o.akF(str2);
        List<o> akF2 = o.akF(str);
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
        ab.d(str5, str6, objArr);
        final HashMap hashMap = new HashMap();
        for (o oVar : akF) {
            arrayList = (ArrayList) hashMap.get(oVar.host);
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(oVar.host, arrayList);
            }
            arrayList.add(oVar.nJq);
        }
        final HashMap hashMap2 = new HashMap();
        for (o oVar2 : akF2) {
            arrayList = (ArrayList) hashMap2.get(oVar2.host);
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap2.put(oVar2.host, arrayList);
            }
            arrayList.add(oVar2.nJq);
        }
        final int[] iArr3 = iArr2;
        final int[] iArr4 = iArr;
        new bj<Object>(Integer.valueOf(-1)) {
            public final Object run() {
                AppMethodBeat.i(58560);
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
                AppMethodBeat.o(58560);
                return null;
            }
        }.b(this.handler);
        AppMethodBeat.o(58580);
    }

    public final void d(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(58581);
        this.gcT.lock(1000, "MMAutoAuth.setFixedHost");
        ab.i("MicroMsg.MMAutoAuth", "dkidc setFixedHost debug short:%s:%s long:%s:%s", str, str2, str3, str4);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str3)) {
            ab.w("MicroMsg.MMAutoAuth", "dkidc setFixedHost FAILED ! check assist");
            AppMethodBeat.o(58581);
            return;
        }
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        new bj<Object>(Integer.valueOf(-1)) {
            public final Object run() {
                AppMethodBeat.i(58561);
                MMLogic.setDebugIP(str5, str6, str7, str8);
                BaseEvent.onNetworkChange();
                AppMethodBeat.o(58561);
                return null;
            }
        }.b(this.handler);
        AppMethodBeat.o(58581);
    }

    public final void setNewDnsDebugHost(final String str, final String str2) {
        AppMethodBeat.i(58582);
        if (bo.isNullOrNil(str) && bo.isNullOrNil(str2)) {
            ab.d("MicroMsg.MMAutoAuth", "setNewDnsDebugHost FAILED ! check assist");
            AppMethodBeat.o(58582);
            return;
        }
        new bj<Object>() {
            public final Object run() {
                AppMethodBeat.i(58562);
                MMLogic.setNewDnsDebugHost(str, str2);
                AppMethodBeat.o(58562);
                return null;
            }
        }.b(this.handler);
        AppMethodBeat.o(58582);
    }

    public final void amN() {
        AppMethodBeat.i(58583);
        this.gcT.lock(1000, "MMAutoAuth.forceUpdateHostCache");
        new bj<Object>(Integer.valueOf(-1)) {
            public final Object run() {
                AppMethodBeat.i(58564);
                BaseEvent.onNetworkChange();
                AppMethodBeat.o(58564);
                return null;
            }
        }.b(this.handler);
        AppMethodBeat.o(58583);
    }

    public final void qs(final String str) {
        AppMethodBeat.i(58584);
        this.gcT.lock(1000, "MMAutoAuth.ipxxStatistics");
        new bj<Object>() {
            public final Object run() {
                AppMethodBeat.i(58552);
                ab.dot();
                IPxxLogic.onIPxx(str, 0);
                AppMethodBeat.o(58552);
                return null;
            }
        }.b(this.handler);
        AppMethodBeat.o(58584);
    }

    public final void a(com.tencent.mm.network.a.b bVar) {
        AppMethodBeat.i(58585);
        aa.ank().geg = bVar;
        AppMethodBeat.o(58585);
    }

    public final i amO() {
        AppMethodBeat.i(58586);
        ac anl = aa.anl();
        AppMethodBeat.o(58586);
        return anl;
    }

    /* Access modifiers changed, original: final */
    public final boolean amT() {
        AppMethodBeat.i(58587);
        if (10001 == ae.giz && ae.giA > 0) {
            ae.giA = 0;
            amS();
        }
        if (this.gcU.adb()) {
            AppMethodBeat.o(58587);
            return true;
        } else if (aa.anp().anc()) {
            ab.i("MicroMsg.MMAutoAuth", "makeSureAuth hasAuthCmd ret false");
            AppMethodBeat.o(58587);
            return false;
        } else if (this.gcY != -1) {
            ab.w("MicroMsg.MMAutoAuth", "makeSureAuth auto limit now is getting cert, ret false");
            AppMethodBeat.o(58587);
            return false;
        } else {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (60000 >= elapsedRealtime - this.gcQ && this.gcQ > 0) {
                ab.w("MicroMsg.MMAutoAuth", "makeSureAuth auto limit lastAutoAuthtime=%d, curtime=%d, return false", Long.valueOf(this.gcQ), Long.valueOf(elapsedRealtime));
                AppMethodBeat.o(58587);
                return false;
            } else if (ah.getContext().getSharedPreferences("auth_hold_prefs", 0).getBoolean("auth_ishold", false)) {
                ab.i("MicroMsg.MMAutoAuth", "makeSureAuth AUTH_HOLD_KEY hold ret false");
                if (!aa.anp().and()) {
                    ab.e("MicroMsg.MMAutoAuth", "sendImp hit push hold, pid:%d, stack[%s]", Integer.valueOf(Process.myPid()), bo.dpG());
                    aa.anm().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(58553);
                            ab.i("MicroMsg.MMAutoAuth", "makeSureAuth AUTH_HOLD_KEY hold  clearTaskAndCallback");
                            aa.anp().i(4, -100, ah.getContext().getString(R.string.cvx));
                            AppMethodBeat.o(58553);
                        }
                    });
                }
                AppMethodBeat.o(58587);
                return false;
            } else {
                r de = aa.anp().de(amV());
                if (de != null) {
                    try {
                        if (!(de instanceof com.tencent.mm.network.r.a)) {
                            this.gcQ = SystemClock.elapsedRealtime();
                            ab.i("MicroMsg.MMAutoAuth", "makeSureAuth rest lastAutoAuthTime[%d]", Long.valueOf(this.gcQ));
                            a(de, 3, 3);
                        } else if (30000 < elapsedRealtime - this.gcS || this.gcS <= 0) {
                            ab.i("MicroMsg.MMAutoAuth", "makeSureAuth session time out in push_notify mode, send broast to mm");
                            this.gcS = SystemClock.elapsedRealtime();
                            aa.anq().onPush(5, null);
                        } else {
                            ab.i("MicroMsg.MMAutoAuth", "makeSureAuth session time out in push_notify mode, but hit limit");
                            AppMethodBeat.o(58587);
                            return false;
                        }
                    } catch (RemoteException e) {
                        ab.e("MicroMsg.MMAutoAuth", "makeSureAuth exception:%s", bo.l(e));
                    }
                } else {
                    ab.i("MicroMsg.MMAutoAuth", "makeSureAuth getAutoAuthRR is null");
                }
                ab.i("MicroMsg.MMAutoAuth", "makeSureAuth at last ret false");
                AppMethodBeat.o(58587);
                return false;
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void h(int i, int i2, String str) {
        int i3;
        AppMethodBeat.i(58588);
        ab.i("MicroMsg.MMAutoAuth", "summerauth handleAutoAuthFail inErrType=" + i + ", inErrCode=" + i2 + ", errMsg=" + str + " stack=" + bo.dpG());
        if (i == 4 && i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
            ab.e("MicroMsg.MMAutoAuth", "summerauth handleAutoAuthFail autoauth should not be return MM_ERR_BLOCK_BY_SPAM trans to MM_ERR_AUTH_ANOTHERPLACE");
            i3 = -100;
        } else {
            i3 = i2;
        }
        if (i == 5 && i2 == -13) {
            ab.e("MicroMsg.MMAutoAuth", "summerauth handleAutoAuthFail autoauth should not be return MM_ERR_SESSIONTIMEOUT trans to MM_ERR_PASSWORD");
            i = 4;
            i3 = -3;
            e.pXa.a(148, 42, 1, false);
        }
        int i4 = i;
        if ((i4 == 6 && i2 == -10001) || (i4 == 5 && i2 != -13)) {
            ab.e("MicroMsg.MMAutoAuth", "summerauth handleAutoAuthFail autoauth ENCODE ERROR check sp");
            SharedPreferences ZQ = ay.ZQ();
            String string = ZQ.getString("_auth_key", "");
            String string2 = ZQ.getString("server_id", "");
            if (bo.isNullOrNil(string) && bo.isNullOrNil(string2)) {
                ab.e("MicroMsg.MMAutoAuth", "summerauth handleAutoAuthFail autoauth ENCODE ERROR check sp aak and cookie null logout");
                i3 = ZipJNI.UNZ_INTERNALERROR;
                e.pXa.a(148, 52, 1, false);
                i4 = 4;
            }
        }
        aa.anp().i(i4, i3, str);
        if (i4 == 4 && (i3 == -100 || i3 == -205 || i3 == -213)) {
            ah.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().putBoolean("auth_ishold", true).commit();
            reset();
        }
        AppMethodBeat.o(58588);
    }

    /* Access modifiers changed, original: final */
    public final boolean g(String str, String str2, int i) {
        boolean z;
        int i2;
        int i3;
        String string;
        AppMethodBeat.i(58589);
        String str3 = "MicroMsg.MMAutoAuth";
        String str4 = "summerauths saveAAKAndCookieToSp aak[%s] uin[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(str == null ? -1 : str.length());
        objArr[1] = Integer.valueOf(i);
        ab.i(str3, str4, objArr);
        ah.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().remove("auth_ishold").commit();
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.h.Mu());
        boolean z2 = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
        int i4 = sharedPreferences.getInt("key_auth_update_version", 0);
        int i5 = sharedPreferences.getInt("_auth_uin", 0);
        String string2 = sharedPreferences.getString("_auth_key", "");
        String string3 = sharedPreferences.getString("server_id", "");
        Editor edit = sharedPreferences.edit();
        edit.putBoolean("key_auth_info_prefs_created", true);
        edit.putInt("key_auth_update_version", d.vxo);
        edit.putInt("_auth_uin", i);
        edit.putString("_auth_key", str);
        edit.putString("server_id", str2);
        if (!edit.commit()) {
            ab.e("MicroMsg.MMAutoAuth", "summerauth save aak & id commit failed 1th!");
            e.pXa.a(148, 36, 1, false);
            if (!edit.commit()) {
                ab.e("MicroMsg.MMAutoAuth", "summerauth save aak & id commit failed 2nd!");
                e.pXa.a(148, 37, 1, false);
                z = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
                i2 = sharedPreferences.getInt("key_auth_update_version", 0);
                i3 = sharedPreferences.getInt("_auth_uin", 0);
                string = sharedPreferences.getString("_auth_key", "");
                String string4 = sharedPreferences.getString("server_id", "");
                ab.e("MicroMsg.MMAutoAuth", "summerauth save aak & id commit failed 2th so ret false old vs new vs input create[%b, %b, %b] version[%d, %d, %d], uin[%d, %d, %d], aak[%s, %s, %s], cookie[%s, %s, %s]", Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.TRUE, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(d.vxo), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i), string2, string, str, string3, string4, str2);
                ab.dot();
                AppMethodBeat.o(58589);
                return false;
            }
        }
        z = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
        i2 = sharedPreferences.getInt("key_auth_update_version", 0);
        i3 = sharedPreferences.getInt("_auth_uin", 0);
        string = sharedPreferences.getString("_auth_key", "");
        String string5 = sharedPreferences.getString("server_id", "");
        if (z && i2 == d.vxo && i3 == i && string.equals(str) && string5.equals(str2)) {
            this.gcZ.doc();
            this.gcZ.set(1, Integer.valueOf(d.vxo));
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
            objArr2[6] = Integer.valueOf(d.vxo);
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
            ab.i(str5, str6, objArr2);
            AppMethodBeat.o(58589);
            return true;
        }
        ab.e("MicroMsg.MMAutoAuth", "summerauth save aak & id commit failed check not equal so ret false old vs new vs input create[%b, %b, %b] version[%d, %d, %d], uin[%d, %d, %d], aak[%s, %s, %s], cookie[%s, %s, %s]", Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.TRUE, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(d.vxo), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i), string2, string, str, string3, string5, str2);
        ab.dot();
        AppMethodBeat.o(58589);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void a(r rVar, int i, int i2) {
        AppMethodBeat.i(58590);
        rVar.a(this.gcV, i, i2);
        AppMethodBeat.o(58590);
    }

    public final void a(com.tencent.mm.protocal.y yVar) {
        AppMethodBeat.i(58591);
        aa.anp().ane();
        AppMethodBeat.o(58591);
    }

    public final byte[] amU() {
        AppMethodBeat.i(58592);
        if (this.gcU.adb()) {
            com.tencent.mm.protocal.x.a aVar = new com.tencent.mm.protocal.x.a();
            aVar.uin = this.gcU.QF();
            aVar.fIi = bo.anf(ah.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.h.Mu()).getString("notify_sync_key_keybuf", ""));
            aVar.netType = com.tencent.mm.protocal.a.getNetType(ah.getContext());
            aVar.vyo = com.tencent.mm.protocal.a.dlZ();
            try {
                byte[] ZT = aVar.ZT();
                this.eJt = aVar.eJt;
                AppMethodBeat.o(58592);
                return ZT;
            } catch (Exception e) {
                ab.e("MicroMsg.MMAutoAuth", "exception:%s", bo.l(e));
                AppMethodBeat.o(58592);
                return null;
            }
        }
        AppMethodBeat.o(58592);
        return null;
    }

    public final int getHostByName(String str, List<String> list) {
        AppMethodBeat.i(58593);
        int hostByName = MMLogic.getHostByName(str, list);
        AppMethodBeat.o(58593);
        return hostByName;
    }

    public final int a(boolean z, List<String> list) {
        AppMethodBeat.i(58594);
        int snsIpsForScene = MMLogic.getSnsIpsForScene(list, z);
        AppMethodBeat.o(58594);
        return snsIpsForScene;
    }

    public final int a(String str, boolean z, List<String> list) {
        AppMethodBeat.i(58595);
        int snsIpsForSceneWithHostName = MMLogic.getSnsIpsForSceneWithHostName(list, str, z);
        AppMethodBeat.o(58595);
        return snsIpsForSceneWithHostName;
    }

    public final String getIspId() {
        AppMethodBeat.i(58596);
        String ispId = MMLogic.getIspId();
        AppMethodBeat.o(58596);
        return ispId;
    }

    public final void setHostInfo(final String[] strArr, final String[] strArr2, final int[] iArr) {
        AppMethodBeat.i(58597);
        this.gcT.lock(1000, "MMAutoAuth.setHostInfo");
        new bj<Object>() {
            public final Object run() {
                AppMethodBeat.i(58554);
                MMLogic.setHostInfo(strArr, strArr2, iArr);
                AppMethodBeat.o(58554);
                return null;
            }
        }.b(this.handler);
        AppMethodBeat.o(58597);
    }

    public final int g(int i, byte[] bArr) {
        AppMethodBeat.i(58598);
        int h = ae.anu().h(i, bArr);
        AppMethodBeat.o(58598);
        return h;
    }

    public final void a(int i, String str, int i2, boolean z) {
        AppMethodBeat.i(58599);
        this.gcT.lock(1000, "MMAutoAuth.logUtil");
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        final boolean z2 = z;
        new bj<Object>() {
            public final Object run() {
                AppMethodBeat.i(58555);
                if (i3 == 3) {
                    Date date = new Date();
                    date.setTime(bo.anU() - (86400000 * ((long) i4)));
                    MMLogic.uploadFile(com.tencent.mm.compatible.util.e.eSo + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(date) + ".txt", str2, "");
                } else if (i3 == 2) {
                    ab.dot();
                    MMLogic.uploadLog(new int[]{i4}, z2, str2, "");
                } else {
                    ab.dot();
                }
                AppMethodBeat.o(58555);
                return null;
            }
        }.b(this.handler);
        AppMethodBeat.o(58599);
    }

    public final void setSignallingStrategy(long j, long j2) {
        AppMethodBeat.i(58600);
        StnLogic.setSignallingStrategy(j, j2);
        AppMethodBeat.o(58600);
    }

    public final void keepSignalling() {
        AppMethodBeat.i(58601);
        StnLogic.keepSignalling();
        AppMethodBeat.o(58601);
    }

    public final void stopSignalling() {
        AppMethodBeat.i(58602);
        StnLogic.stopSignalling();
        AppMethodBeat.o(58602);
    }

    public final void a(o oVar) {
        AppMethodBeat.i(58603);
        aa.ans().gdH = oVar;
        AppMethodBeat.o(58603);
    }

    public final void a(s sVar) {
        this.gda = sVar;
    }

    public final boolean amV() {
        boolean z = false;
        AppMethodBeat.i(58604);
        if (this.gda == null) {
            AppMethodBeat.o(58604);
        } else {
            try {
                z = this.gda.check();
                AppMethodBeat.o(58604);
            } catch (RemoteException e) {
                AppMethodBeat.o(58604);
            }
        }
        return z;
    }

    public final void a(g gVar) {
        this.gdb = gVar;
    }

    public final void mz(int i) {
        AppMethodBeat.i(58605);
        if (this.gdb == null) {
            AppMethodBeat.o(58605);
            return;
        }
        try {
            this.gdb.gi(i);
            AppMethodBeat.o(58605);
        } catch (RemoteException e) {
            ab.e("MicroMsg.MMAutoAuth", "exception:%s", bo.l(e));
            AppMethodBeat.o(58605);
        }
    }

    public final void reportFailIp(String str) {
        AppMethodBeat.i(58606);
        MMLogic.reportFailIp(str);
        AppMethodBeat.o(58606);
    }

    public final void qt(String str) {
        AppMethodBeat.i(58607);
        ab.e("MicroMsg.MMAutoAuth", "killPush %s", str);
        AppMethodBeat.o(58607);
    }

    public final void cG(boolean z) {
        AppMethodBeat.i(58608);
        if (com.tencent.mm.sdk.b.a.xxA == null) {
            ab.w("MicroMsg.MMAutoAuth", "loginevent but eventpool null, event:".concat(String.valueOf(z)));
            AppMethodBeat.o(58608);
            return;
        }
        AppMethodBeat.o(58608);
    }

    public final i adh() {
        return null;
    }

    public final void cH(boolean z) {
        AppMethodBeat.i(58609);
        aa.initLanguage(ah.getContext());
        AppMethodBeat.o(58609);
    }

    public final void cI(boolean z) {
        AppMethodBeat.i(58610);
        ab.d("MicroMsg.MMAutoAuth", "summer setMMTLS enable[%b]", Boolean.valueOf(z));
        MMLogic.setMmtlsCtrlInfo(z);
        AppMethodBeat.o(58610);
    }

    public final void adi() {
        AppMethodBeat.i(58611);
        StnLogic.makesureLongLinkConnected();
        AppMethodBeat.o(58611);
    }

    public final void adj() {
        AppMethodBeat.i(58612);
        StnLogic.startNetworkAnalysis();
        AppMethodBeat.o(58612);
    }

    public final void a(h hVar) {
        this.gdc = hVar;
    }

    public final /* bridge */ /* synthetic */ d amM() {
        return this.gcU;
    }

    public final /* bridge */ /* synthetic */ c adg() {
        return this.gcU;
    }

    static /* synthetic */ void mA(int i) {
        int i2 = 0;
        AppMethodBeat.i(58615);
        ab.i("MicroMsg.MMAutoAuth", "cancel: netid=".concat(String.valueOf(i)));
        if (i < 0) {
            ab.e("MicroMsg.MMAutoAuth", "error netid < 0, ".concat(String.valueOf(i)));
            AppMethodBeat.o(58615);
            return;
        }
        z anp = aa.anp();
        ab.i("MicroMsg.MMNativeNetTaskAdapter", "stopTask netId=".concat(String.valueOf(i)));
        if (i < 0 || i >= 100) {
            AppMethodBeat.o(58615);
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
                AppMethodBeat.o(58615);
            }
        }
        if (i2 != 0) {
            StnLogic.stopTask(i2);
        }
        synchronized (anp.gdP) {
            try {
                if (anp.gdP[i] != null) {
                    ab.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi stopTask outQueue: netId:%d hash:%d type:%d", Integer.valueOf(i2), Integer.valueOf(anp.gdP[i].gdT.getType()), Integer.valueOf(anp.gdP[i].gdT.acO()));
                    anp.gdP[i] = null;
                }
            } catch (RemoteException e) {
                ab.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bo.l(e));
            } catch (Throwable th) {
                AppMethodBeat.o(58615);
            }
        }
    }
}
