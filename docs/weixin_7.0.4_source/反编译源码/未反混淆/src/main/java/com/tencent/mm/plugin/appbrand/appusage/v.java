package com.tencent.mm.plugin.appbrand.appusage;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class v {

    public static final class a implements com.tencent.mm.model.bz.a {
        private static final a ham = new a();

        static {
            AppMethodBeat.i(129671);
            AppMethodBeat.o(129671);
        }

        public static void axy() {
            AppMethodBeat.i(129667);
            ((p) g.M(p.class)).getSysCmdMsgExtension().a("UpdateWxaUsageListNotify", ham, true);
            AppMethodBeat.o(129667);
        }

        public static void unregister() {
            AppMethodBeat.i(129668);
            ((p) g.M(p.class)).getSysCmdMsgExtension().b("UpdateWxaUsageListNotify", ham, true);
            AppMethodBeat.o(129668);
        }

        public final void a(com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(129669);
            final String a = aa.a(aVar.eAB.vED);
            if (bo.isNullOrNil(a)) {
                AppMethodBeat.o(129669);
                return;
            }
            e.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(129666);
                    a.yv(a);
                    AppMethodBeat.o(129666);
                }
            });
            AppMethodBeat.o(129669);
        }

        static /* synthetic */ void yv(String str) {
            int i = 0;
            AppMethodBeat.i(129670);
            ab.i("MicroMsg.AppBrandUsagePushingUpdateLogic", "parseThenProcess, accReady %b, received xml %s", Boolean.valueOf(g.RK()), str);
            if (g.RK()) {
                Map z = br.z(str, "sysmsg");
                if (z != null && z.size() > 0) {
                    List arrayList;
                    ArrayList arrayList2;
                    ArrayList arrayList3;
                    int i2;
                    int i3 = bo.getInt((String) z.get(".sysmsg.UpdateWxaUsageListNotify.Type"), 0);
                    int i4 = bo.getInt((String) z.get(".sysmsg.UpdateWxaUsageListNotify.DeleteCount"), 0);
                    if (i4 > 0) {
                        arrayList = new ArrayList();
                        arrayList2 = new ArrayList();
                        arrayList3 = new ArrayList();
                        int i5 = 0;
                        while (i5 < i4) {
                            String str2 = ".sysmsg.UpdateWxaUsageListNotify.DeleteList.DeleteAppInfo" + (i5 == 0 ? "" : Integer.valueOf(i5));
                            String str3 = (String) z.get(str2 + ".UserName");
                            String str4 = (String) z.get(str2 + ".AppID");
                            i2 = bo.getInt((String) z.get(str2 + ".AppType"), 0);
                            if (!(bo.isNullOrNil(str3) || bo.isNullOrNil(str4))) {
                                arrayList.add(str3);
                                arrayList2.add(str4);
                                arrayList3.add(Integer.valueOf(i2));
                            }
                            i5++;
                        }
                    } else {
                        arrayList3 = null;
                        arrayList2 = null;
                        arrayList = null;
                    }
                    switch (i3) {
                        case 1:
                            new y(1, BaseClientBuilder.API_PRIORITY_OTHER, 30).acy();
                            AppMethodBeat.o(129670);
                            return;
                        case 2:
                            new y(2, 0, 0).acy();
                            AppMethodBeat.o(129670);
                            return;
                        case 3:
                            if (!bo.ek(arrayList)) {
                                while (i < arrayList.size()) {
                                    al.j((String) arrayList.get(i), (String) arrayList2.get(i), ((Integer) arrayList3.get(i)).intValue());
                                    i++;
                                }
                                AppMethodBeat.o(129670);
                                return;
                            }
                            break;
                        case 4:
                            if (!bo.ek(arrayList)) {
                                for (i2 = 0; i2 < arrayList.size(); i2++) {
                                    f.auU().j((String) arrayList.get(i2), ((Integer) arrayList3.get(i2)).intValue(), false);
                                }
                                break;
                            }
                            break;
                    }
                }
                AppMethodBeat.o(129670);
                return;
            }
            AppMethodBeat.o(129670);
        }
    }
}
