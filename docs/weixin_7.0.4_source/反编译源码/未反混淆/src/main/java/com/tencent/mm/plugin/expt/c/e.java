package com.tencent.mm.plugin.expt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.plugin.expt.a.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class e {
    private static e lOg;

    private e() {
    }

    public static e brf() {
        AppMethodBeat.i(73555);
        if (lOg == null) {
            lOg = new e();
        }
        e eVar = lOg;
        AppMethodBeat.o(73555);
        return eVar;
    }

    public final void a(w wVar) {
        AppMethodBeat.i(73556);
        if (wVar == null) {
            AppMethodBeat.o(73556);
            return;
        }
        int i = (int) wVar.cWS;
        if (i == a.MMAppMgr_Activated.value || i == a.MMAppMgr_Deactivated.value) {
            a(com.tencent.mm.plugin.expt.a.a.a.clicfg_weixin_mm_app_mgr, wVar);
            if (a.bqW()) {
                wVar.ajK();
            }
        }
        if (i == a.MMLifeCall_OnResume.value || i == a.MMLifeCall_OnPause.value) {
            a(com.tencent.mm.plugin.expt.a.a.a.clicfg_weixin_mm_life_call, wVar);
            if (a.bqX()) {
                wVar.ajK();
            }
        }
        if ((i == a.MMActivity_Back2Front.value || i == a.MMActivity_Front2Back.value) && com.tencent.mm.plugin.expt.hellhound.a.bqj() && com.tencent.mm.plugin.expt.hellhound.a.bqk()) {
            a(com.tencent.mm.plugin.expt.a.a.a.clicfg_weixin_mm_hell_hound, wVar);
            if (a.bqY()) {
                wVar.ajK();
            }
        }
        AppMethodBeat.o(73556);
    }

    private void a(com.tencent.mm.plugin.expt.a.a.a aVar, w wVar) {
        AppMethodBeat.i(73557);
        if (ah.bqo()) {
            long yz = bo.yz();
            int b = a.b(aVar);
            if (b <= 0) {
                AppMethodBeat.o(73557);
                return;
            }
            as bra = bra();
            if (bra == null) {
                AppMethodBeat.o(73557);
                return;
            }
            String str = bra.getString(aVar.name(), "") + "|" + wVar.eU(";");
            long j = bra.getLong(aVar.name() + "_rpttime", 0);
            if ((str.length() >= b || bo.fp(j) > 3600) && wVar.cWS % 2 == 0) {
                bra.putLong(aVar.name() + "_rpttime", bo.anT());
                bra.putString(aVar.name(), "");
                h.pYm.X(16562, str);
                if (aVar == com.tencent.mm.plugin.expt.a.a.a.clicfg_weixin_mm_hell_hound) {
                    KZ(str);
                }
            } else {
                bra.putString(aVar.name(), str);
            }
            ab.v("MicroMsg.MMPageReporter", "handle merge cost[%d]", Long.valueOf(bo.az(yz)));
            AppMethodBeat.o(73557);
            return;
        }
        AppMethodBeat.o(73557);
    }

    private static as bra() {
        AppMethodBeat.i(73558);
        int Ra = com.tencent.mm.kernel.a.Ra();
        if (Ra == 0) {
            AppMethodBeat.o(73558);
            return null;
        }
        as amF = as.amF(Ra + "_WxPageFlowMerge");
        AppMethodBeat.o(73558);
        return amF;
    }

    private void KZ(final String str) {
        AppMethodBeat.i(73559);
        d.post(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:45:0x011c  */
            /* JADX WARNING: Removed duplicated region for block: B:45:0x011c  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                Throwable e;
                AppMethodBeat.i(73554);
                e eVar = e.this;
                String str = str;
                if (!bo.isNullOrNil(str)) {
                    long yz = bo.yz();
                    String[] split = str.split("\\|");
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : split) {
                        if (!bo.isNullOrNil(str2)) {
                            w wVar = new w(str2.replace(';', ','));
                            if (wVar.cWT > 0 && wVar.cWS > 0) {
                                arrayList.add(wVar);
                            }
                        }
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    int i = 0;
                    if (!arrayList.isEmpty()) {
                        Collections.sort(arrayList, new Comparator<w>() {
                            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                                return (int) (((w) obj).cWT - ((w) obj2).cWT);
                            }
                        });
                        try {
                            int size = arrayList.size();
                            w wVar2 = null;
                            long j = 0;
                            int i2 = 0;
                            int i3 = 0;
                            while (i2 < size) {
                                try {
                                    long j2;
                                    w wVar3 = (w) arrayList.get(i2);
                                    if (i2 + 1 < size) {
                                        wVar2 = (w) arrayList.get(i2 + 1);
                                    }
                                    if (!(wVar3 == null || wVar2 == null)) {
                                        if (wVar3.cWS == 7 && wVar2.cWS == 8 && wVar3.cWT < wVar2.cWT && wVar3.cWc == wVar2.cWc) {
                                            j = j > 0 ? wVar3.cWT - j : 0;
                                            stringBuffer.append(String.format("{\"tbe\":%d.\"ten\":%d.\"in\":%d.\"inbg\":%d}", new Object[]{Long.valueOf(wVar3.cWT), Long.valueOf(wVar2.cWT), Long.valueOf(wVar2.cWT - wVar3.cWT), Long.valueOf(j)})).append(";");
                                            j = wVar2.cWT;
                                            i3++;
                                            i2 += 2;
                                        } else if (wVar3.cWS == 8) {
                                            j2 = wVar3.cWT;
                                            i2++;
                                            j = j2;
                                        }
                                    }
                                    j2 = j;
                                    i2++;
                                    j = j2;
                                } catch (Exception e2) {
                                    e = e2;
                                    i = i3;
                                    ab.printErrStackTrace("MicroMsg.MMPageReporter", e, "reportWeixinAppTime error", new Object[0]);
                                    if (!bo.isNullOrNil(stringBuffer.toString())) {
                                    }
                                    ab.i("MicroMsg.MMPageReporter", "reportWeixinAppTime cost[%d] count[%d]", Long.valueOf(bo.az(yz)), Integer.valueOf(i));
                                    AppMethodBeat.o(73554);
                                }
                            }
                            i = i3;
                        } catch (Exception e3) {
                            e = e3;
                            ab.printErrStackTrace("MicroMsg.MMPageReporter", e, "reportWeixinAppTime error", new Object[0]);
                            if (bo.isNullOrNil(stringBuffer.toString())) {
                            }
                            ab.i("MicroMsg.MMPageReporter", "reportWeixinAppTime cost[%d] count[%d]", Long.valueOf(bo.az(yz)), Integer.valueOf(i));
                            AppMethodBeat.o(73554);
                        }
                    }
                    if (bo.isNullOrNil(stringBuffer.toString())) {
                        h.pYm.e(16563, stringBuffer.toString(), Long.valueOf(bo.az(yz)), Integer.valueOf(i));
                        ab.i("MicroMsg.MMPageReporter", "reportWeixinAppTime [%s]", r3);
                    }
                    ab.i("MicroMsg.MMPageReporter", "reportWeixinAppTime cost[%d] count[%d]", Long.valueOf(bo.az(yz)), Integer.valueOf(i));
                }
                AppMethodBeat.o(73554);
            }
        }, "report_weixin_app_time");
        AppMethodBeat.o(73559);
    }
}
