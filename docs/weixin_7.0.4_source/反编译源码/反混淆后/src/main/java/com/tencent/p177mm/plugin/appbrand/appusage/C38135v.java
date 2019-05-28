package com.tencent.p177mm.plugin.appbrand.appusage;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.v */
public final class C38135v {

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.v$a */
    public static final class C10131a implements C1837a {
        private static final C10131a ham = new C10131a();

        static {
            AppMethodBeat.m2504i(129671);
            AppMethodBeat.m2505o(129671);
        }

        public static void axy() {
            AppMethodBeat.m2504i(129667);
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("UpdateWxaUsageListNotify", ham, true);
            AppMethodBeat.m2505o(129667);
        }

        public static void unregister() {
            AppMethodBeat.m2504i(129668);
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("UpdateWxaUsageListNotify", ham, true);
            AppMethodBeat.m2505o(129668);
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(129669);
            final String a = C1946aa.m4148a(c1197a.eAB.vED);
            if (C5046bo.isNullOrNil(a)) {
                AppMethodBeat.m2505o(129669);
                return;
            }
            C42677e.aNS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(129666);
                    C10131a.m17743yv(a);
                    AppMethodBeat.m2505o(129666);
                }
            });
            AppMethodBeat.m2505o(129669);
        }

        /* renamed from: yv */
        static /* synthetic */ void m17743yv(String str) {
            int i = 0;
            AppMethodBeat.m2504i(129670);
            C4990ab.m7417i("MicroMsg.AppBrandUsagePushingUpdateLogic", "parseThenProcess, accReady %b, received xml %s", Boolean.valueOf(C1720g.m3531RK()), str);
            if (C1720g.m3531RK()) {
                Map z = C5049br.m7595z(str, "sysmsg");
                if (z != null && z.size() > 0) {
                    List arrayList;
                    ArrayList arrayList2;
                    ArrayList arrayList3;
                    int i2;
                    int i3 = C5046bo.getInt((String) z.get(".sysmsg.UpdateWxaUsageListNotify.Type"), 0);
                    int i4 = C5046bo.getInt((String) z.get(".sysmsg.UpdateWxaUsageListNotify.DeleteCount"), 0);
                    if (i4 > 0) {
                        arrayList = new ArrayList();
                        arrayList2 = new ArrayList();
                        arrayList3 = new ArrayList();
                        int i5 = 0;
                        while (i5 < i4) {
                            String str2 = ".sysmsg.UpdateWxaUsageListNotify.DeleteList.DeleteAppInfo" + (i5 == 0 ? "" : Integer.valueOf(i5));
                            String str3 = (String) z.get(str2 + ".UserName");
                            String str4 = (String) z.get(str2 + ".AppID");
                            i2 = C5046bo.getInt((String) z.get(str2 + ".AppType"), 0);
                            if (!(C5046bo.isNullOrNil(str3) || C5046bo.isNullOrNil(str4))) {
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
                            new C45523y(1, BaseClientBuilder.API_PRIORITY_OTHER, 30).acy();
                            AppMethodBeat.m2505o(129670);
                            return;
                        case 2:
                            new C45523y(2, 0, 0).acy();
                            AppMethodBeat.m2505o(129670);
                            return;
                        case 3:
                            if (!C5046bo.m7548ek(arrayList)) {
                                while (i < arrayList.size()) {
                                    C42374al.m74967j((String) arrayList.get(i), (String) arrayList2.get(i), ((Integer) arrayList3.get(i)).intValue());
                                    i++;
                                }
                                AppMethodBeat.m2505o(129670);
                                return;
                            }
                            break;
                        case 4:
                            if (!C5046bo.m7548ek(arrayList)) {
                                for (i2 = 0; i2 < arrayList.size(); i2++) {
                                    C42340f.auU().mo44556j((String) arrayList.get(i2), ((Integer) arrayList3.get(i2)).intValue(), false);
                                }
                                break;
                            }
                            break;
                    }
                }
                AppMethodBeat.m2505o(129670);
                return;
            }
            AppMethodBeat.m2505o(129670);
        }
    }
}
