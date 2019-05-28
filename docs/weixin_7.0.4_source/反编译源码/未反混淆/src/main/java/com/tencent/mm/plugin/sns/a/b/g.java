package com.tencent.mm.plugin.sns.a.b;

import android.app.Activity;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.bt.b;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ae;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public final class g implements b {
    public static Map<String, Integer> qDT = new HashMap();
    private Activity activity;
    public int cvd = 0;
    public HashMap<String, Long> qDJ = new HashMap();
    public HashSet<Long> qDK = new HashSet();
    private Map<String, Long> qDL = new HashMap();
    private Map<String, Integer> qDM = new HashMap();
    private Map<String, a> qDN = new HashMap();
    public HashSet<Long> qDO = new HashSet();
    public Map<Long, h> qDP = new HashMap();
    public Map<Long, h> qDQ = new HashMap();
    public Map<String, a> qDR = new HashMap();
    private Map<String, Integer> qDS = new HashMap();
    private int qDU = 0;
    private View qDV = null;
    public Map<Long, Integer> qDW = new HashMap();
    public Map<Long, Integer> qDX = new HashMap();
    private int qDY = -1;
    private int qDc = 0;

    static class a {
        public String cOc;
        public int fPY;
        public int klY;
        public int position;
        public long qDh;
        public long qEe;
        public long qEf;
        public String qEg;
        public long qEh;
        public long qEi;
        public long qEj;

        public a(long j, String str, int i, String str2, int i2, long j2, int i3) {
            this.qEe = j;
            this.qEf = j;
            this.cOc = str;
            this.position = i;
            this.qEg = str2;
            this.qDh = j2;
            this.klY = i2;
            this.fPY = i3;
        }
    }

    static {
        AppMethodBeat.i(35743);
        AppMethodBeat.o(35743);
    }

    public final boolean jN(long j) {
        AppMethodBeat.i(35720);
        boolean contains = this.qDK.contains(Long.valueOf(j));
        AppMethodBeat.o(35720);
        return contains;
    }

    public final void a(int i, View view, Activity activity) {
        this.qDc = i;
        this.qDV = view;
        this.activity = activity;
    }

    public g(int i) {
        AppMethodBeat.i(35721);
        this.cvd = i;
        AppMethodBeat.o(35721);
    }

    public final void onResume() {
        a aVar;
        AppMethodBeat.i(35722);
        long yz = bo.yz();
        for (String str : this.qDR.keySet()) {
            aVar = (a) this.qDR.get(str);
            ab.i("MicroMsg.SnsAdStatistic", "onResume Key ".concat(String.valueOf(str)));
            aVar.qEf = yz;
            h hVar = (h) this.qDP.get(Long.valueOf(aVar.qDh));
            if (hVar != null) {
                hVar.onResume();
            }
            hVar = (h) this.qDQ.get(Long.valueOf(aVar.qDh));
            if (hVar != null) {
                hVar.onResume();
            }
        }
        for (Entry value : this.qDN.entrySet()) {
            a aVar2 = (a) value.getValue();
            if (aVar2 != null && af.qKD) {
                aVar2.kG(false);
                if (!(bo.isNullOrNil(aVar2.czD) || this.qDR.get(aVar2.czD) == null)) {
                    aVar = (a) this.qDR.get(aVar2.czD);
                    if (aVar2.cme()) {
                        aVar.qEh = bo.yz();
                    }
                }
            }
        }
        AppMethodBeat.o(35722);
    }

    public final void u(final long j, final boolean z) {
        AppMethodBeat.i(35723);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(35716);
                if (g.this.jN(j)) {
                    h hVar;
                    g gVar = g.this;
                    long j = j;
                    boolean z = z;
                    if (z) {
                        if (gVar.qDQ.containsKey(Long.valueOf(j))) {
                            hVar = (h) gVar.qDQ.get(Long.valueOf(j));
                        } else {
                            hVar = new h("timeline");
                        }
                    } else if (gVar.qDP.containsKey(Long.valueOf(j))) {
                        hVar = (h) gVar.qDP.get(Long.valueOf(j));
                    } else {
                        hVar = new h("timeline");
                    }
                    hVar.qEk = 1;
                    hVar.qEs.qFp++;
                    if (z) {
                        gVar.qDQ.put(Long.valueOf(j), hVar);
                        AppMethodBeat.o(35716);
                        return;
                    }
                    gVar.qDP.put(Long.valueOf(j), hVar);
                }
                AppMethodBeat.o(35716);
            }
        });
        AppMethodBeat.o(35723);
    }

    public final void f(long j, int i, boolean z) {
        AppMethodBeat.i(35724);
        final long j2 = j;
        final int i2 = i;
        final boolean z2 = z;
        al.d(new Runnable() {
            final /* synthetic */ boolean qEc = true;

            public final void run() {
                AppMethodBeat.i(35717);
                g.this.a(j2, i2, this.qEc, z2);
                AppMethodBeat.o(35717);
            }
        });
        AppMethodBeat.o(35724);
    }

    public final void v(long j, boolean z) {
        AppMethodBeat.i(35725);
        a(j, 0, z, false);
        AppMethodBeat.o(35725);
    }

    public final void a(long j, int i, boolean z, boolean z2) {
        h hVar;
        AppMethodBeat.i(35726);
        if (z2) {
            if (this.qDQ.containsKey(Long.valueOf(j))) {
                hVar = (h) this.qDQ.get(Long.valueOf(j));
            } else {
                hVar = new h("timeline");
            }
        } else if (this.qDP.containsKey(Long.valueOf(j))) {
            hVar = (h) this.qDP.get(Long.valueOf(j));
        } else {
            hVar = new h("timeline");
        }
        if (i > 0) {
            hVar.setDuration(i);
        }
        hVar.qEk = z ? 1 : 0;
        if (z2) {
            this.qDQ.put(Long.valueOf(j), hVar);
            AppMethodBeat.o(35726);
            return;
        }
        this.qDP.put(Long.valueOf(j), hVar);
        AppMethodBeat.o(35726);
    }

    public final void w(long j, boolean z) {
        AppMethodBeat.i(35727);
        c(j, z, false);
        AppMethodBeat.o(35727);
    }

    public final void c(long j, boolean z, boolean z2) {
        h hVar;
        AppMethodBeat.i(35728);
        if (z2) {
            if (this.qDQ.containsKey(Long.valueOf(j))) {
                hVar = (h) this.qDQ.get(Long.valueOf(j));
            } else {
                hVar = new h("timeline");
            }
        } else if (this.qDP.containsKey(Long.valueOf(j))) {
            hVar = (h) this.qDP.get(Long.valueOf(j));
        } else {
            hVar = new h("timeline");
        }
        if (z) {
            hVar.qEs.qFs = 2;
        } else {
            hVar.qEs.qFs = 1;
        }
        hVar.qEs.qFt = 1;
        if (z2) {
            this.qDQ.put(Long.valueOf(j), hVar);
            AppMethodBeat.o(35728);
            return;
        }
        this.qDP.put(Long.valueOf(j), hVar);
        AppMethodBeat.o(35728);
    }

    public final void T(long j, long j2) {
        AppMethodBeat.i(35729);
        final long j3 = j;
        final long j4 = j2;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(35718);
                if (g.this.jN(j3)) {
                    g gVar = g.this;
                    long j = j4;
                    if (!gVar.qDO.contains(Long.valueOf(j))) {
                        gVar.qDO.add(Long.valueOf(j));
                    }
                }
                AppMethodBeat.o(35718);
            }
        });
        AppMethodBeat.o(35729);
    }

    public final boolean jO(long j) {
        AppMethodBeat.i(35730);
        if (this.qDO.contains(Long.valueOf(j))) {
            AppMethodBeat.o(35730);
            return true;
        }
        AppMethodBeat.o(35730);
        return false;
    }

    public final void c(long j, long j2, boolean z) {
        AppMethodBeat.i(35731);
        final long j3 = j;
        final long j4 = j2;
        final boolean z2 = z;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(35719);
                if (g.this.jN(j3)) {
                    h hVar;
                    g gVar = g.this;
                    long j = j3;
                    long j2 = j4;
                    boolean z = z2;
                    if (z) {
                        if (gVar.qDQ.containsKey(Long.valueOf(j))) {
                            hVar = (h) gVar.qDQ.get(Long.valueOf(j));
                        } else {
                            hVar = new h("timeline");
                        }
                    } else if (gVar.qDP.containsKey(Long.valueOf(j))) {
                        hVar = (h) gVar.qDP.get(Long.valueOf(j));
                    } else {
                        hVar = new h("timeline");
                    }
                    if (hVar.qEs.qFu == 0) {
                        hVar.qEs.qFu = j2;
                    }
                    if (z) {
                        gVar.qDQ.put(Long.valueOf(j), hVar);
                        AppMethodBeat.o(35719);
                        return;
                    }
                    gVar.qDP.put(Long.valueOf(j), hVar);
                }
                AppMethodBeat.o(35719);
            }
        });
        AppMethodBeat.o(35731);
    }

    public final void x(long j, boolean z) {
        AppMethodBeat.i(35732);
        Object obj;
        if (z) {
            if (this.qDQ.containsKey(Long.valueOf(j))) {
                obj = (h) this.qDQ.get(Long.valueOf(j));
                obj.CI(0);
            } else {
                obj = new h("timeline");
            }
            this.qDQ.put(Long.valueOf(j), obj);
            AppMethodBeat.o(35732);
            return;
        }
        if (this.qDP.containsKey(Long.valueOf(j))) {
            obj = (h) this.qDP.get(Long.valueOf(j));
            obj.CI(0);
        } else {
            obj = new h("timeline");
        }
        this.qDP.put(Long.valueOf(j), obj);
        AppMethodBeat.o(35732);
    }

    public final void onPause() {
        AppMethodBeat.i(35733);
        for (String str : this.qDR.keySet()) {
            a aVar = (a) this.qDR.get(str);
            ab.i("MicroMsg.SnsAdStatistic", "onPause Key ".concat(String.valueOf(str)));
            aVar.qEi += bo.az(aVar.qEf);
            aVar.qEf = 0;
            h hVar = (h) this.qDP.get(Long.valueOf(aVar.qDh));
            if (hVar != null) {
                hVar.fQd = bo.yz();
            }
            hVar = (h) this.qDQ.get(Long.valueOf(aVar.qDh));
            if (hVar != null) {
                hVar.fQd = bo.yz();
            }
        }
        for (Entry value : this.qDN.entrySet()) {
            a aVar2 = (a) value.getValue();
            if (aVar2 != null && af.qKD) {
                aVar2.kG(false);
                if (!(bo.isNullOrNil(aVar2.czD) || this.qDR.get(aVar2.czD) == null)) {
                    a aVar3 = (a) this.qDR.get(aVar2.czD);
                    if (aVar3.qEh > 0) {
                        aVar3.qEj += bo.az(aVar3.qEh);
                        aVar3.qEh = 0;
                    }
                }
            }
        }
        AppMethodBeat.o(35733);
    }

    private com.tencent.mm.plugin.sns.storage.a f(n nVar) {
        AppMethodBeat.i(35734);
        com.tencent.mm.plugin.sns.storage.a cqr;
        if (nVar == null) {
            AppMethodBeat.o(35734);
            return null;
        } else if (this.cvd == 2) {
            cqr = nVar.cqr();
            AppMethodBeat.o(35734);
            return cqr;
        } else {
            cqr = nVar.cqq();
            AppMethodBeat.o(35734);
            return cqr;
        }
    }

    private b g(n nVar) {
        AppMethodBeat.i(35735);
        b cqy;
        if (nVar == null) {
            AppMethodBeat.o(35735);
            return null;
        } else if (this.cvd == 2) {
            cqy = nVar.crd().cqy();
            AppMethodBeat.o(35735);
            return cqy;
        } else {
            cqy = nVar.crd().cqw();
            AppMethodBeat.o(35735);
            return cqy;
        }
    }

    private b h(n nVar) {
        AppMethodBeat.i(35736);
        b cqz;
        if (nVar == null) {
            AppMethodBeat.o(35736);
            return null;
        } else if (this.cvd == 2) {
            cqz = nVar.crd().cqz();
            AppMethodBeat.o(35736);
            return cqz;
        } else {
            cqz = nVar.crd().cqx();
            AppMethodBeat.o(35736);
            return cqz;
        }
    }

    public final void a(int i, String str, boolean z, View view, long j, cbf cbf, int i2, int i3) {
        int i4;
        AppMethodBeat.i(35737);
        this.qDK.add(Long.valueOf(j));
        this.qDJ.put(str, Long.valueOf(j));
        if (this.qDY == -1) {
            if (this.activity == null) {
                i4 = -1;
            } else {
                i4 = ae.hA(this.activity);
            }
            this.qDY = i4;
        }
        n YT = af.cnF().YT(str);
        if (YT == null) {
            ab.w("MicroMsg.SnsAdStatistic", "snsinfo not found! skip onAdAdded logic!");
            AppMethodBeat.o(35737);
            return;
        }
        String str2;
        a aVar;
        h hVar;
        a aVar2 = (a) this.qDN.get(str);
        com.tencent.mm.plugin.sns.storage.a f = f(YT);
        String str3 = "";
        if (f != null) {
            str2 = f.hnw;
        } else {
            str2 = str3;
        }
        if (aVar2 == null && view != null && af.qKD) {
            a aVar3 = new a(f, str, j, view, this.qDc, this.qDV, this.qDY, i3, cbf, i, YT.cqo());
            aVar3.qDo = System.currentTimeMillis();
            af.bCo().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(35700);
                    if (!a.this.qCW) {
                        a.this.kG(false);
                    }
                    AppMethodBeat.o(35700);
                }
            });
            this.qDN.put(str, aVar3);
            if (!this.qDW.containsKey(Long.valueOf(j))) {
                this.qDW.put(Long.valueOf(j), Integer.valueOf(YT.field_likeFlag == 1 ? 1 : 0));
            }
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        if (i2 == 11 && YT.cqu().xfI.wbK.size() > 1) {
            if (this.qDQ.containsKey(Long.valueOf(j))) {
                hVar = (h) this.qDQ.get(Long.valueOf(j));
            } else {
                hVar = new h("timeline");
            }
            hVar.qEm = bo.yz();
            this.qDQ.put(Long.valueOf(j), hVar);
        }
        if (this.qDL.containsKey(str)) {
            long az = bo.az(((Long) this.qDL.get(str)).longValue());
            if (az < 1200000) {
                i4 = this.qDM.containsKey(str) ? ((Integer) this.qDM.get(str)).intValue() : 0;
                if (i4 >= 2) {
                    ab.i("MicroMsg.SnsAdStatistic", "passed localid " + str + " viewid " + str2 + " passedTime: " + az);
                    AppMethodBeat.o(35737);
                    return;
                }
                this.qDM.put(str, Integer.valueOf(i4 + 1));
            } else {
                this.qDL.put(str, Long.valueOf(bo.yz()));
                this.qDM.put(str, Integer.valueOf(0));
            }
        }
        if (!this.qDR.containsKey(str)) {
            m dVar;
            this.qDR.put(str, new a(bo.yz(), str, i, str2, i2, j, i3));
            ab.i("MicroMsg.SnsAdStatistic", "onAdAdded " + i + " " + str + "  isExposure: " + z);
            if (i2 == 9) {
                if (this.qDP.containsKey(Long.valueOf(j))) {
                    hVar = (h) this.qDP.get(Long.valueOf(j));
                } else {
                    hVar = new h("timeline");
                }
                hVar.qEm = bo.yz();
                this.qDP.put(Long.valueOf(j), hVar);
            } else if (i2 == 11 && YT.cqu().xfI.wbK.size() > 0 && ((bau) YT.cqu().xfI.wbK.get(0)).jCt == 6) {
                if (this.qDP.containsKey(Long.valueOf(j))) {
                    hVar = (h) this.qDP.get(Long.valueOf(j));
                } else {
                    hVar = new h("timeline");
                }
                hVar.qEm = bo.yz();
                hVar.qEr = true;
                this.qDP.put(Long.valueOf(j), hVar);
            }
            if (!this.qDS.containsKey(str)) {
                ab.i("MicroMsg.SnsAdStatistic", "exposures item ".concat(String.valueOf(str)));
                this.qDS.put(str, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
            }
            com.tencent.mm.plugin.sns.storage.b cqo = YT.cqo();
            TimeLineObject cqu = YT.cqu();
            com.tencent.mm.protocal.protobuf.bo boVar = null;
            if (aVar != null && af.qKD) {
                boVar = aVar.cmd();
            }
            e crd = YT.crd();
            int i5 = 0;
            if (this.cvd == 0) {
                i5 = crd.field_exposureCount + 1;
                crd.field_exposureCount = i5;
                af.cnI().c(crd, new String[0]);
            }
            if (cqo.coO()) {
                dVar = new d(str2, i3, boVar, 3, i5, YT.cre(), g(YT), h(YT));
            } else if (YT.crg()) {
                dVar = new d(str2, i3, 1, 0, null, boVar, 6, "", i5, YT.cre(), 0, 0, YT.field_likeFlag == 1 ? 2 : 1, g(YT), h(YT));
            } else if (YT.coP() || YT.coQ()) {
                if (cqu == null || cqu.xfI.wbJ != 15 || cqu.xfP == 1) {
                    dVar = new d(str2, i3, boVar, 4, i5, YT.cre(), g(YT), h(YT));
                } else {
                    dVar = new d(str2, i3, boVar, 5, i5, YT.cre(), g(YT), h(YT));
                }
            } else if (i2 == 9) {
                dVar = new d(str2, i3, boVar, 2, i5, YT.cre(), g(YT), h(YT));
            } else {
                dVar = new d(str2, i3, boVar, 1, i5, YT.cre(), g(YT), h(YT));
            }
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.a(dVar, 0);
        }
        AppMethodBeat.o(35737);
    }

    public final void j(int i, String str, int i2) {
        int nextInt;
        int i3;
        long j;
        h hVar;
        String cmf;
        AppMethodBeat.i(35738);
        if (this.qDJ.containsKey(str)) {
            this.qDK.remove(Long.valueOf(((Long) this.qDJ.remove(str)).longValue()));
        }
        bl blVar = null;
        com.tencent.mm.protocal.protobuf.bo boVar = null;
        a aVar = (a) this.qDN.get(str);
        if (aVar != null && af.qKD) {
            aVar.eTf = true;
            aVar.qDp = System.currentTimeMillis();
            aVar.qDH = 0;
            kH(false);
            if (aVar.qDk < 0) {
                aVar.qDF = 2;
            } else {
                aVar.qDF = 1;
            }
            if (aVar.qDm < 0) {
                aVar.qDG = 2;
            } else {
                aVar.qDG = 1;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i.jV(aVar.qDh) + ",");
            stringBuilder.append(aVar.qDg + ",");
            stringBuilder.append(aVar.qDF + ",");
            stringBuilder.append(aVar.qDG + ",");
            stringBuilder.append(aVar.qDC + ",");
            stringBuilder.append(aVar.qDD + ",");
            stringBuilder.append(aVar.qDE + ",");
            stringBuilder.append(aVar.qDo + ",");
            stringBuilder.append(aVar.qDp + ",");
            if (aVar.qDs > 0 && aVar.qDv == 0) {
                aVar.qDv = System.currentTimeMillis();
            }
            stringBuilder.append(aVar.qDs + ",");
            stringBuilder.append(aVar.qDv + ",");
            if (aVar.qDy > 0 && aVar.qDB == 0) {
                aVar.qDB = System.currentTimeMillis();
            }
            stringBuilder.append(aVar.qDy + ",");
            stringBuilder.append(aVar.qDB);
            f.a(aVar.qDh, stringBuilder);
            ab.i("MicroMsg.AdViewStatic", "report " + stringBuilder.toString());
            blVar = new bl();
            blVar.vDI = aVar.qDy;
            blVar.vDJ = aVar.qDB;
            blVar.qDF = aVar.qDF;
            blVar.qDG = aVar.qDG;
            blVar.vDD = (float) aVar.qDC;
            blVar.vDE = (float) aVar.qDD;
            blVar.vDF = (float) aVar.qDE;
            blVar.vDG = aVar.qDs;
            blVar.vDH = aVar.qDv;
            blVar.startTime = aVar.qDo;
            blVar.endTime = aVar.qDp;
            if (aVar.qDj == null || !aVar.qDj.coX()) {
                af.cnz().e(12010, stringBuilder.toString());
            } else {
                af.cnz().e(14648, stringBuilder.toString());
            }
            com.tencent.mm.modelsns.b lY = com.tencent.mm.modelsns.b.lY(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH);
            lY.tx(i.jV(aVar.qDh)).tx(aVar.qDg).mb(aVar.qDF).mb(aVar.qDG).mb(aVar.qDC).mb(aVar.qDD).mb(aVar.qDE).tx(aVar.qDo).tx(aVar.qDp).tx(aVar.qDs).tx(aVar.qDv).tx(aVar.qDy).tx(aVar.qDB);
            lY.ajK();
            kw kwVar = new kw();
            kwVar.cGO.position = aVar.position;
            com.tencent.mm.sdk.b.a.xxA.m(kwVar);
            if (com.tencent.mm.platformtools.ae.gje) {
                nextInt = new Random(System.currentTimeMillis()).nextInt(2000) + 10;
                ab.i("MicroMsg.AdViewStatic", "run on test kv ".concat(String.valueOf(nextInt)));
                for (i3 = 0; i3 < nextInt; i3++) {
                    if (aVar.qDj == null || !aVar.qDj.coX()) {
                        af.cnz().e(12010, stringBuilder.toString());
                    } else {
                        af.cnz().e(14648, stringBuilder.toString());
                    }
                }
            }
            boVar = aVar.cmd();
            this.qDN.remove(str);
        }
        i3 = 0;
        n YT = af.cnF().YT(str);
        if (YT != null) {
            if (this.qDQ.containsKey(Long.valueOf(YT.field_snsId)) && YT.cqu().xfI.wbJ == 27) {
                i3 = YT.field_likeFlag == 1 ? 2 : 1;
                int intValue = this.qDX.containsKey(Long.valueOf(YT.field_snsId)) ? ((Integer) this.qDX.get(Long.valueOf(YT.field_snsId))).intValue() : 0;
                if (this.qDW.containsKey(Long.valueOf(YT.field_snsId))) {
                    nextInt = ((Integer) this.qDW.get(Long.valueOf(YT.field_snsId))).intValue();
                } else {
                    nextInt = 0;
                }
                long j2 = 0;
                j = 0;
                long j3 = 0;
                hVar = (h) this.qDQ.remove(Long.valueOf(YT.field_snsId));
                if (hVar != null) {
                    hVar.CI(0);
                    hVar.cmg();
                    j2 = (long) hVar.qEq;
                    j = (long) hVar.qEp;
                    j3 = hVar.qEu * 1000;
                }
                String str2 = "%s,%s,%s,%s,%s,%s,%s,%s,%s";
                r9 = new Object[9];
                r9[0] = YT.cqu().Id;
                r9[1] = YT.crc();
                r9[2] = String.valueOf(i2);
                r9[3] = String.valueOf(intValue);
                r9[4] = String.valueOf(nextInt);
                r9[5] = String.valueOf(j2);
                r9[6] = String.valueOf(j);
                r9[7] = String.valueOf(j3);
                r9[8] = YT.field_likeFlag == 1 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                h.pYm.X(15155, String.format(str2, r9));
                ab.i("MicroMsg.SnsAdStatistic", "15155, %s", cmf);
                this.qDO.remove(Long.valueOf(YT.field_snsId));
                this.qDO.remove(Long.valueOf(YT.field_snsId + 1));
            }
            this.qDX.remove(Long.valueOf(YT.field_snsId));
            this.qDW.remove(Long.valueOf(YT.field_snsId));
        }
        int i4 = i3;
        if (this.qDR.containsKey(str)) {
            String str3 = "";
            if (f(YT) != null) {
                str3 = f(YT).hnw;
            }
            a aVar2 = (a) this.qDR.remove(str);
            this.qDL.put(str, Long.valueOf(bo.yz()));
            if (aVar2 == null) {
                AppMethodBeat.o(35738);
                return;
            }
            j = bo.az(aVar2.qEe);
            if (aVar2.qEf > 0) {
                aVar2.qEi += bo.az(aVar2.qEf);
            }
            ab.i("MicroMsg.SnsAdStatistic", "onAdRemoved " + i + " " + str + " " + j + " ");
            if (YT == null) {
                AppMethodBeat.o(35738);
                return;
            }
            int i5;
            String str4;
            String str5 = "";
            TimeLineObject cqu = YT.cqu();
            if (YT.cqo().coO()) {
                i5 = 3;
                str4 = str5;
            } else if (YT.crg()) {
                i5 = 6;
                hVar = (h) this.qDP.remove(Long.valueOf(aVar2.qDh));
                if (hVar != null) {
                    if (YT.field_likeFlag == 0) {
                        hVar.CI(0);
                    }
                    cmf = hVar.cmf();
                } else {
                    cmf = str5;
                }
                str4 = cmf;
            } else if (YT.coP() || YT.coQ()) {
                if (cqu == null || cqu.xfI.wbJ != 15 || cqu.xfP == 1) {
                    i5 = 4;
                    str4 = str5;
                } else {
                    i5 = 5;
                    hVar = (h) this.qDP.remove(Long.valueOf(aVar2.qDh));
                    if (hVar != null) {
                        hVar.CI(0);
                        str5 = hVar.cmf();
                    }
                    this.qDO.remove(Long.valueOf(aVar2.qDh));
                    str4 = str5;
                }
            } else if (aVar2.klY == 9) {
                i5 = 2;
                hVar = (h) this.qDP.remove(Long.valueOf(aVar2.qDh));
                if (hVar != null) {
                    hVar.CI(0);
                    str5 = hVar.cmf();
                }
                this.qDO.remove(Long.valueOf(aVar2.qDh));
                str4 = str5;
            } else {
                i5 = 1;
                str4 = str5;
            }
            m dVar = new d(str3, i2, 2, (int) j, blVar, boVar, i5, str4, -1, YT.cre(), (int) aVar2.qEi, (int) aVar2.qEj, i4, g(YT), h(YT));
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.a(dVar, 0);
            AppMethodBeat.o(35738);
            return;
        }
        ab.w("MicroMsg.SnsAdStatistic", "can not find onAdRemoved " + i + " " + str);
        AppMethodBeat.o(35738);
    }

    public final void kH(boolean z) {
        AppMethodBeat.i(35739);
        ab.i("MicroMsg.SnsAdStatistic", "checkAd %s", Boolean.valueOf(z));
        for (Entry value : this.qDN.entrySet()) {
            a aVar = (a) value.getValue();
            if (aVar != null && af.qKD) {
                aVar.kG(z);
                if (!(bo.isNullOrNil(aVar.czD) || this.qDR.get(aVar.czD) == null)) {
                    a aVar2 = (a) this.qDR.get(aVar.czD);
                    boolean cme = aVar.cme();
                    if (cme && aVar2.qEh == 0) {
                        aVar2.qEh = bo.yz();
                    } else if (!cme && aVar2.qEh > 0) {
                        aVar2.qEj += bo.az(aVar2.qEh);
                        aVar2.qEh = 0;
                    }
                }
            }
        }
        AppMethodBeat.o(35739);
    }

    public final void clear() {
        AppMethodBeat.i(35740);
        ab.i("MicroMsg.SnsAdStatistic", "clean the adRemove");
        for (String str : new HashSet(this.qDR.keySet())) {
            a aVar = (a) this.qDR.get(str);
            j(aVar.position, aVar.cOc, aVar.fPY);
        }
        for (String str2 : this.qDS.keySet()) {
            e DG = af.cnI().DG(v.Zn(str2));
            if (DG != null) {
                int intValue;
                n cqB = DG.cqB();
                DG.field_localFlag |= 128;
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (this.qDS.containsKey(str2)) {
                    intValue = ((Integer) this.qDS.get(str2)).intValue();
                } else {
                    intValue = currentTimeMillis;
                }
                if (DG.field_exposureTime <= 0) {
                    DG.field_exposureTime = intValue;
                }
                cqB.field_localFlag |= 128;
                af.cnF().b(cqB.field_snsId, cqB);
                af.cnI().b(DG.field_snsId, DG);
            }
        }
        this.qDR.clear();
        this.qDS.clear();
        AppMethodBeat.o(35740);
    }

    public final void jP(long j) {
        AppMethodBeat.i(35741);
        int i = 0;
        if (this.qDW.containsKey(Long.valueOf(j))) {
            i = ((Integer) this.qDW.get(Long.valueOf(j))).intValue();
        }
        this.qDW.put(Long.valueOf(j), Integer.valueOf(i + 1));
        AppMethodBeat.o(35741);
    }

    public final void jQ(long j) {
        AppMethodBeat.i(35742);
        int i = 0;
        if (this.qDX.containsKey(Long.valueOf(j))) {
            i = ((Integer) this.qDX.get(Long.valueOf(j))).intValue();
        }
        this.qDX.put(Long.valueOf(j), Integer.valueOf(i + 1));
        AppMethodBeat.o(35742);
    }
}
