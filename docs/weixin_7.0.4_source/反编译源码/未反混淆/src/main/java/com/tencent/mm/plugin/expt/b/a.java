package com.tencent.mm.plugin.expt.b;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.b.a.ct;
import com.tencent.mm.g.b.a.cu;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.expt.e.b;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.plugin.expt.ui.ExptDebugUI;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.dq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a implements c, com.tencent.mm.plugin.expt.a.a {
    private static a lNE;
    private int eCL = 0;
    private int frU = 0;
    public d lNF;
    public b lNG;
    private f<Integer, com.tencent.mm.plugin.expt.d.a> lNH = new com.tencent.mm.memory.a.c(100);
    private f<String, Integer> lNI = new com.tencent.mm.memory.a.c(100);
    private int lNJ = 0;
    private com.tencent.mm.sdk.b.c lNK = new com.tencent.mm.sdk.b.c<mp>() {
        {
            AppMethodBeat.i(73485);
            this.xxI = mp.class.getName().hashCode();
            AppMethodBeat.o(73485);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(73486);
            a.this.lNJ = a.this.lNJ + 1;
            ab.d("MicroMsg.ExptService", "got post sync event [%d]", Integer.valueOf(a.this.lNJ));
            a.c(a.this);
            AppMethodBeat.o(73486);
            return false;
        }
    };
    private n lNL = new n() {
        public final e.b a(String str, Map<String, String> map, com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(73487);
            if (!"expt".equals(str)) {
                ab.w("MicroMsg.ExptService", "receive expt xml but subtype[%s] is error", str);
                AppMethodBeat.o(73487);
            } else if (map == null || map.size() <= 0) {
                ab.w("MicroMsg.ExptService", "receive expt xml but map is null");
                AppMethodBeat.o(73487);
            } else {
                a.this.KY((String) map.get(".sysmsg.content"));
                AppMethodBeat.o(73487);
            }
            return null;
        }
    };
    private com.tencent.mm.ai.f lNM = new com.tencent.mm.ai.f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(73488);
            ab.i("MicroMsg.ExptService", "scene[%d] errType[%d] errCode[%d] errMsg[%s]", Integer.valueOf(mVar.hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str);
            if (mVar instanceof b) {
                a.d(a.this);
            }
            AppMethodBeat.o(73488);
        }
    };
    private com.tencent.mm.sdk.b.c<jt> lNN = new com.tencent.mm.sdk.b.c<jt>() {
        {
            AppMethodBeat.i(73490);
            this.xxI = jt.class.getName().hashCode();
            AppMethodBeat.o(73490);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(73491);
            com.tencent.mm.sdk.g.d.xDG.b(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(73489);
                    a.va(2);
                    AppMethodBeat.o(73489);
                }
            }, "manual_get_expt", 60000);
            AppMethodBeat.o(73491);
            return false;
        }
    };

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void bqQ() {
        AppMethodBeat.i(73492);
        this.lNH.clear();
        this.lNI.clear();
        AppMethodBeat.o(73492);
    }

    public static a bqR() {
        AppMethodBeat.i(73493);
        if (lNE == null) {
            lNE = new a();
        }
        a aVar = lNE;
        AppMethodBeat.o(73493);
        return aVar;
    }

    private a() {
        AppMethodBeat.i(73494);
        AppMethodBeat.o(73494);
    }

    public final void t(Context context, Intent intent) {
        AppMethodBeat.i(73495);
        intent.setClass(context, ExptDebugUI.class);
        context.startActivity(intent);
        AppMethodBeat.o(73495);
    }

    public final boolean a(com.tencent.mm.plugin.expt.a.a.a aVar, boolean z) {
        AppMethodBeat.i(73496);
        String a = a(aVar, "");
        if (bo.isNullOrNil(a)) {
            AppMethodBeat.o(73496);
            return z;
        }
        int i;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        if (bo.getInt(a, i) != 0) {
            AppMethodBeat.o(73496);
            return true;
        }
        AppMethodBeat.o(73496);
        return false;
    }

    public final float a(com.tencent.mm.plugin.expt.a.a.a aVar, float f) {
        AppMethodBeat.i(73497);
        String a = a(aVar, "");
        if (bo.isNullOrNil(a)) {
            AppMethodBeat.o(73497);
            return f;
        }
        f = bo.getFloat(a, f);
        AppMethodBeat.o(73497);
        return f;
    }

    public final int a(com.tencent.mm.plugin.expt.a.a.a aVar, int i) {
        AppMethodBeat.i(73498);
        String a = a(aVar, "");
        if (bo.isNullOrNil(a)) {
            AppMethodBeat.o(73498);
            return i;
        }
        i = bo.getInt(a, i);
        AppMethodBeat.o(73498);
        return i;
    }

    public final long a(com.tencent.mm.plugin.expt.a.a.a aVar, long j) {
        AppMethodBeat.i(73499);
        String a = a(aVar, "");
        if (bo.isNullOrNil(a)) {
            AppMethodBeat.o(73499);
            return j;
        }
        j = bo.getLong(a, j);
        AppMethodBeat.o(73499);
        return j;
    }

    public final String a(com.tencent.mm.plugin.expt.a.a.a aVar, String str) {
        AppMethodBeat.i(73500);
        if (aVar == null) {
            AppMethodBeat.o(73500);
            return str;
        } else if (bqU()) {
            com.tencent.mm.plugin.expt.e.c.bru();
            ab.i("MicroMsg.ExptService", "API check Expt from mmkv result[%s] key[%s] def[%s]", com.tencent.mm.plugin.expt.e.c.a(aVar, str, true), aVar, str);
            AppMethodBeat.o(73500);
            return com.tencent.mm.plugin.expt.e.c.a(aVar, str, true);
        } else {
            long yz = bo.yz();
            String name = aVar.name();
            int KX = KX(name);
            cu cuVar = new cu();
            PBool pBool = new PBool();
            HashMap a = a(KX, true, cuVar, pBool);
            if (a == null || a.size() <= 0) {
                AppMethodBeat.o(73500);
                return str;
            }
            String str2 = (String) a.get(name);
            if (!bo.isNullOrNil(str2) && pBool.value) {
                cuVar.hJ(name).hK(str2).ajK();
            }
            ab.i("MicroMsg.ExptService", "API Got Expt result[%s] exptId[%d] key[%s %s] defStr[%s] cost[%d]", str2, Integer.valueOf(KX), aVar, name, str, Long.valueOf(bo.az(yz)));
            if (bo.isNullOrNil(str2)) {
                AppMethodBeat.o(73500);
                return str;
            }
            AppMethodBeat.o(73500);
            return str2;
        }
    }

    public final com.tencent.mm.plugin.expt.d.a uZ(int i) {
        AppMethodBeat.i(73501);
        com.tencent.mm.plugin.expt.d.a aVar = (com.tencent.mm.plugin.expt.d.a) this.lNH.get(Integer.valueOf(i));
        if (aVar != null) {
            AppMethodBeat.o(73501);
        } else {
            aVar = this.lNF.vd(i);
            if (aVar != null) {
                this.lNH.put(Integer.valueOf(i), aVar);
            }
            AppMethodBeat.o(73501);
        }
        return aVar;
    }

    private int KX(String str) {
        AppMethodBeat.i(73502);
        Integer num = (Integer) this.lNI.get(str);
        int intValue;
        if (num != null) {
            intValue = num.intValue();
            AppMethodBeat.o(73502);
            return intValue;
        }
        intValue = this.lNG.KX(str);
        if (intValue > 0) {
            this.lNI.put(str, Integer.valueOf(intValue));
        }
        AppMethodBeat.o(73502);
        return intValue;
    }

    public final HashMap<String, String> a(int i, boolean z, cu cuVar, PBool pBool) {
        AppMethodBeat.i(73503);
        if (this.lNF == null) {
            ab.e("MicroMsg.ExptService", "Expt service is not init here! exptId[%d]", Integer.valueOf(i));
            AppMethodBeat.o(73503);
            return null;
        } else if (i <= 0) {
            AppMethodBeat.o(73503);
            return null;
        } else {
            long yz = bo.yz();
            HashMap<String, String> hashMap = null;
            String str = null;
            com.tencent.mm.plugin.expt.d.a uZ = uZ(i);
            if (uZ == null || bo.isNullOrNil(uZ.field_exptContent)) {
                ab.w("MicroMsg.ExptService", "expt item is null or expt content is null.");
            } else {
                str = uZ.field_exptContent;
                if (!z || uZ.isReady()) {
                    hashMap = uZ.brq();
                    if (uZ.brp()) {
                        pBool.value = true;
                        if (cuVar != null) {
                            cuVar.dig = (long) uZ.field_exptId;
                            cuVar.dih = (long) uZ.field_groupId;
                            cuVar.dii = (long) uZ.field_exptSeq;
                            cuVar.cYo = uZ.field_startTime;
                            cuVar.dij = uZ.field_endTime;
                        }
                    }
                } else {
                    ab.w("MicroMsg.ExptService", "expt time is invalid time[%d %d] seq[%d]", Long.valueOf(uZ.field_startTime), Long.valueOf(uZ.field_endTime), Integer.valueOf(uZ.field_exptSeq));
                }
            }
            String str2 = "MicroMsg.ExptService";
            String str3 = "get expt [%d] map[%s] expt[%s] cost[%d]";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = hashMap != null ? hashMap : Integer.valueOf(0);
            objArr[2] = str;
            objArr[3] = Long.valueOf(bo.az(yz));
            ab.i(str2, str3, objArr);
            AppMethodBeat.o(73503);
            return hashMap;
        }
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(73504);
        ab.i("MicroMsg.ExptService", "onAccountInitialized, %d", Integer.valueOf(hashCode()));
        ab.v("MicroMsg.ExptService", "add listener ");
        if (ah.bqo()) {
            com.tencent.mm.sdk.b.a.xxA.b(this.lNK);
            com.tencent.mm.sdk.b.a.xxA.b(this.lNN);
            g.Rg().a(2738, this.lNM);
            ((p) g.M(p.class)).getSysCmdMsgExtension().a("expt", this.lNL);
        }
        if (cVar != null) {
            try {
                if (cVar.eKe) {
                    ab.i("MicroMsg.ExptService", "client upgrade now, reset last update time. previous version [%d]", Integer.valueOf(cVar.eKf));
                    this.frU = 0;
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_GET_EXPT_LAST_TIME_SEC_INT, Integer.valueOf(0));
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.ExptService", e, "onAccountInitialized error[%s]", e.toString());
                AppMethodBeat.o(73504);
                return;
            }
        }
        AppMethodBeat.o(73504);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(73505);
        ab.i("MicroMsg.ExptService", "onAccountRelease");
        bqQ();
        com.tencent.mm.sdk.b.a.xxA.d(this.lNK);
        com.tencent.mm.sdk.b.a.xxA.d(this.lNN);
        g.Rg().b(2738, this.lNM);
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("expt", this.lNL);
        com.tencent.mm.sdk.g.d.xDG.remove("manual_get_expt");
        AppMethodBeat.o(73505);
    }

    public final void KY(String str) {
        AppMethodBeat.i(73506);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.ExptService", "receive expt xml but content is null");
            AppMethodBeat.o(73506);
            return;
        }
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        com.tencent.mm.plugin.expt.d.a aVar = new com.tencent.mm.plugin.expt.d.a();
        if (aVar.La(str)) {
            ArrayList arrayList;
            if (aVar.field_exptSeq < 0) {
                h.pYm.a(863, 3, 1, false);
                com.tencent.mm.plugin.expt.d.a uZ = uZ(aVar.field_exptId);
                if (uZ != null && uZ.bro()) {
                    linkedList.add(Integer.valueOf(aVar.field_exptId));
                }
                arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(aVar.field_exptId));
                if (bB(arrayList) > 0) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                h.pYm.a(863, 4, 1, false);
                arrayList = new ArrayList();
                arrayList.add(aVar);
                z = bA(arrayList) > 0;
                if (aVar.bro()) {
                    linkedList2.add(aVar);
                }
                ct ctVar = new ct();
                ctVar.dig = (long) aVar.field_exptId;
                ctVar.dih = (long) aVar.field_groupId;
                ctVar.dii = (long) aVar.field_exptSeq;
                ctVar.ajK();
            }
            bqS();
        } else {
            z = false;
        }
        if (linkedList2.size() > 0 || linkedList.size() > 0) {
            a(linkedList2, null, linkedList);
        }
        ab.i("MicroMsg.ExptService", "received expt xml dbFlag[%b] [%s] ", Boolean.valueOf(z), str);
        AppMethodBeat.o(73506);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bqS() {
        AppMethodBeat.i(73507);
        com.tencent.mm.sdk.b.a.xxA.m(new fa());
        SharedPreferences Mz = com.tencent.mm.kernel.a.Mz();
        Mz.edit().putBoolean("keepaliveserviceswitch", a(com.tencent.mm.plugin.expt.a.a.a.clicfg_keepaliveserviceswitch, false)).commit();
        d(Mz);
        bqV();
        bqT();
        AppMethodBeat.o(73507);
    }

    private void bqT() {
        AppMethodBeat.i(73508);
        int a = a(com.tencent.mm.plugin.expt.a.a.a.clicfg_target26_start_service_switch, -1);
        if (!bo.gW(a, 0)) {
            String a2;
            String[] split;
            if (bo.gW(a, 2)) {
                a2 = a(com.tencent.mm.plugin.expt.a.a.a.clicfg_target26_start_service_manu_exclusive, "");
                ab.i("MicroMsg.ExptService", "manufacturers:%s", bo.bc(a2, BuildConfig.COMMAND));
                if (bo.isNullOrNil(a2)) {
                    com.tencent.mm.booter.c.bu(true);
                } else {
                    split = a2.split(",");
                    for (Object valueOf : split) {
                        if (String.valueOf(valueOf).equalsIgnoreCase(Build.MANUFACTURER)) {
                            com.tencent.mm.booter.c.bu(false);
                            a = 1;
                            break;
                        }
                    }
                    a = 0;
                    if (a == 0) {
                        com.tencent.mm.booter.c.bu(true);
                    }
                }
            } else if (bo.gW(a, 1)) {
                a2 = a(com.tencent.mm.plugin.expt.a.a.a.clicfg_target26_start_service_manufacturer, "");
                ab.i("MicroMsg.ExptService", "manufacturers:%s", bo.bc(a2, BuildConfig.COMMAND));
                if (!bo.isNullOrNil(a2)) {
                    split = a2.split(",");
                    for (Object valueOf2 : split) {
                        if (String.valueOf(valueOf2).equalsIgnoreCase(Build.MANUFACTURER)) {
                            com.tencent.mm.booter.c.bu(true);
                            a = 1;
                            break;
                        }
                    }
                    a = 0;
                    if (a == 0) {
                        com.tencent.mm.booter.c.bu(false);
                    }
                }
            }
            a = a(com.tencent.mm.plugin.expt.a.a.a.clicfg_target26_start_service_switch_huawei, 0);
            if (!com.tencent.mm.compatible.util.d.iW(26) && bo.gW(a, 0) && com.tencent.mm.sdk.h.a.dqu()) {
                a2 = a(com.tencent.mm.plugin.expt.a.a.a.clicfg_target26_start_service_huawei_info, "");
                ab.i("MicroMsg.ExptService", "model:%s startServiceHuaweiInfo:%s", Build.MODEL.toLowerCase(), bo.bc(a2, BuildConfig.COMMAND));
                try {
                    if (bo.isNullOrNil(a2)) {
                        com.tencent.mm.booter.c.ii(0);
                        AppMethodBeat.o(73508);
                        return;
                    }
                    String[] split2 = a2.split(",");
                    for (String toLowerCase : split2) {
                        if (r3.startsWith(toLowerCase.toLowerCase())) {
                            com.tencent.mm.booter.c.ii(1);
                            a = 1;
                            break;
                        }
                    }
                    a = 0;
                    if (a == 0) {
                        com.tencent.mm.booter.c.ii(0);
                    }
                    AppMethodBeat.o(73508);
                    return;
                } catch (Exception e) {
                    ab.i("MicroMsg.ExptService", "startServiceHuaweiInfo Exception:%s %s", e.getClass().getSimpleName(), e.getMessage());
                    com.tencent.mm.booter.c.ii(0);
                    AppMethodBeat.o(73508);
                    return;
                }
            }
            com.tencent.mm.booter.c.ii(1);
            AppMethodBeat.o(73508);
        }
        com.tencent.mm.booter.c.bu(false);
        a = a(com.tencent.mm.plugin.expt.a.a.a.clicfg_target26_start_service_switch_huawei, 0);
        if (!com.tencent.mm.compatible.util.d.iW(26)) {
        }
        com.tencent.mm.booter.c.ii(1);
        AppMethodBeat.o(73508);
    }

    private static void d(SharedPreferences sharedPreferences) {
        boolean z = false;
        AppMethodBeat.i(73509);
        int a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_specialscenesetingsswitch, -1);
        ab.i("MicroMsg.ExptService", "iniNotificationSpecialSceneSwitchEnable() enable:%s", Integer.valueOf(a));
        if (bo.gW(a, 1)) {
            String a2 = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_specialscenesetingsswitchdetail, "");
            ab.i("MicroMsg.ExptService", "specialSceneDetail %s", a2);
            if (!bo.isNullOrNil(a2)) {
                Map z2 = br.z(a2, "manufacturerlist");
                if (z2 != null) {
                    int i;
                    if (z2.containsKey(".manufacturerlist.size")) {
                        i = bo.getInt((String) z2.get(".manufacturerlist.size"), 0);
                    } else {
                        boolean i2 = false;
                    }
                    int i3 = VERSION.SDK_INT;
                    for (int i4 = 0; i4 < i2; i4++) {
                        if (i4 == 0) {
                            if (String.valueOf(bo.nullAsNil((String) z2.get(".manufacturerlist.manufacturer.name"))).equalsIgnoreCase(Build.MANUFACTURER)) {
                                z = com.tencent.mm.sdk.h.b.g(i3, bo.nullAsNil((String) z2.get(".manufacturerlist.manufacturer.sdkversionmin")), bo.nullAsNil((String) z2.get(".manufacturerlist.manufacturer.sdkversionmax")), bo.nullAsNil((String) z2.get(".manufacturerlist.manufacturer.versintime")));
                                break;
                            }
                        } else if (String.valueOf(bo.nullAsNil((String) z2.get(".manufacturerlist.manufacturer" + i4 + ".name"))).equalsIgnoreCase(Build.MANUFACTURER)) {
                            z = com.tencent.mm.sdk.h.b.g(i3, bo.nullAsNil((String) z2.get(".manufacturerlist.manufacturer" + i4 + ".sdkversionmin")), bo.nullAsNil((String) z2.get(".manufacturerlist.manufacturer" + i4 + ".sdkversionmax")), bo.nullAsNil((String) z2.get(".manufacturerlist.manufacturer" + i4 + ".versintime")));
                            break;
                        }
                    }
                }
            }
            a(sharedPreferences, z);
            AppMethodBeat.o(73509);
        } else if (bo.gW(a, 0)) {
            a(sharedPreferences, false);
            AppMethodBeat.o(73509);
        } else {
            if (bo.gW(a, 2)) {
                a(sharedPreferences, true);
            }
            AppMethodBeat.o(73509);
        }
    }

    private static void a(SharedPreferences sharedPreferences, boolean z) {
        int i;
        AppMethodBeat.i(73510);
        Editor edit = sharedPreferences.edit();
        String str = "special_scene_enable";
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        edit.putInt(str, i).commit();
        ab.i("MicroMsg.ExptService", "setSpecialSceneEnable() enable: %s", Boolean.valueOf(z));
        AppMethodBeat.o(73510);
    }

    public final int bA(List<com.tencent.mm.plugin.expt.d.a> list) {
        AppMethodBeat.i(73511);
        if (list.size() <= 0) {
            AppMethodBeat.o(73511);
            return 0;
        }
        int bC;
        int bD;
        int i;
        List<com.tencent.mm.plugin.expt.d.a> bH = this.lNF.bH(list);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        if (bH != null) {
            int size = bH.size();
            for (com.tencent.mm.plugin.expt.d.a aVar : bH) {
                this.lNH.put(Integer.valueOf(aVar.field_exptId), aVar);
                HashMap brq = aVar.brq();
                if (brq != null) {
                    for (String str : brq.keySet()) {
                        com.tencent.mm.plugin.expt.e.a Lc = this.lNG.Lc(str);
                        if (Lc == null) {
                            Lc = new com.tencent.mm.plugin.expt.e.a();
                            Lc.field_exptId = aVar.field_exptId;
                            Lc.field_exptKey = str;
                            linkedList2.add(Lc);
                        } else if (Lc.field_exptId != aVar.field_exptId) {
                            Lc.field_exptId = aVar.field_exptId;
                            linkedList.add(Lc);
                        }
                        com.tencent.mm.plugin.expt.e.a aVar2 = Lc;
                        this.lNI.put(aVar2.field_exptKey, Integer.valueOf(aVar2.field_exptId));
                    }
                }
            }
            bC = this.lNG.bC(linkedList2);
            bD = this.lNG.bD(linkedList);
            com.tencent.mm.plugin.expt.e.c.bru().bF(bH);
            i = size;
        } else {
            bD = 0;
            bC = 0;
            i = 0;
        }
        ab.i("MicroMsg.ExptService", "replace ExptIds args[%d] db[%d] exptMap insert[list:%d  db:%d], update[list:%d db:%d]", Integer.valueOf(list.size()), Integer.valueOf(i), Integer.valueOf(linkedList2.size()), Integer.valueOf(bC), Integer.valueOf(linkedList.size()), Integer.valueOf(bD));
        AppMethodBeat.o(73511);
        return i;
    }

    private boolean bqU() {
        if (this.lNF == null || this.lNG == null) {
            return true;
        }
        return false;
    }

    public static void va(int i) {
        AppMethodBeat.i(73513);
        g.Rg().a(new b(i), 0);
        AppMethodBeat.o(73513);
    }

    public static void a(List<com.tencent.mm.plugin.expt.d.a> list, List<dq> list2, List<Integer> list3) {
        AppMethodBeat.i(73514);
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            for (com.tencent.mm.plugin.expt.d.a aVar : list) {
                if (aVar != null && aVar.bro()) {
                    com.tencent.mm.plugin.welab.b.c cVar = new com.tencent.mm.plugin.welab.b.c();
                    cVar.uMa = aVar.field_exptId;
                    cVar.Zb = aVar.field_groupId;
                    cVar.startTime = aVar.field_startTime;
                    cVar.endTime = aVar.field_endTime;
                    cVar.uMc = aVar.field_exptContent;
                    cVar.uMb = aVar.field_exptSeq;
                    cVar.cag = aVar.brq();
                    linkedList.add(cVar);
                }
            }
        }
        LinkedList linkedList2 = new LinkedList();
        if (list2 != null) {
            for (dq dqVar : list2) {
                com.tencent.mm.plugin.welab.b.d dVar = new com.tencent.mm.plugin.welab.b.d();
                dVar.appId = dqVar.csB;
                dVar.status = dqVar.status;
                linkedList2.add(dVar);
            }
        }
        ((com.tencent.mm.plugin.welab.b.a) g.K(com.tencent.mm.plugin.welab.b.a.class)).e(linkedList, linkedList2, list3);
        AppMethodBeat.o(73514);
    }

    private void bqV() {
        AppMethodBeat.i(73515);
        if (a(com.tencent.mm.plugin.expt.a.a.a.clicfg_story_sns_story_open, -1) != -1) {
            h.pYm.k(1006, 200, 1);
            ab.i("MicroMsg.ExptService", "snsStoryReport config[%d]", Integer.valueOf(r0));
        }
        AppMethodBeat.o(73515);
    }

    public final int bB(List<Integer> list) {
        AppMethodBeat.i(73512);
        int bB = this.lNF.bB(list);
        int bE = this.lNG.bE(list);
        ab.i("MicroMsg.ExptService", "delete expt ids deleteCount[%d] deleteMapCount[%d]", Integer.valueOf(bB), Integer.valueOf(bE));
        bqQ();
        com.tencent.mm.plugin.expt.e.c.bru().bG(list);
        AppMethodBeat.o(73512);
        return bB;
    }

    static /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(73516);
        if (!g.RK()) {
            ab.w("MicroMsg.ExptService", "account is not ready, don't get expt config");
            AppMethodBeat.o(73516);
        } else if (ah.bqo()) {
            if (aVar.frU <= 0) {
                aVar.frU = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_GET_EXPT_LAST_TIME_SEC_INT, Integer.valueOf(0))).intValue();
            }
            if (aVar.eCL <= 0) {
                aVar.eCL = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_GET_EXPT_INTERVAL_SEC_INT, Integer.valueOf(86400))).intValue();
                if (aVar.eCL <= 3600) {
                    ab.w("MicroMsg.ExptService", "interval is less than 1 hour, something warn here!!!");
                    aVar.eCL = 3600;
                }
            }
            if (bo.fp((long) aVar.frU) >= ((long) aVar.eCL)) {
                va(1);
            }
            AppMethodBeat.o(73516);
        } else {
            ab.w("MicroMsg.ExptService", "it is not mm process, why you call update expt?");
            AppMethodBeat.o(73516);
        }
    }
}
