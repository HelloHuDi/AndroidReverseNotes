package com.tencent.p177mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appusage.C45522w.C26785a;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.protocal.protobuf.ark;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.protocal.protobuf.cwq;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.j */
public final class C26769j extends C7296k {
    private static volatile C26769j gZd = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.j$2 */
    public class C267702 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(129548);
            if (!C1720g.m3531RK()) {
                AppMethodBeat.m2505o(129548);
            } else if (C19104i.axg()) {
                AppMethodBeat.m2505o(129548);
            } else {
                C26769j c26769j = C26769j.this;
                C26783t.axG();
                C26769j.m42601a(c26769j, 2, 0, 7, 0, true, null);
                AppMethodBeat.m2505o(129548);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.j$1 */
    public class C267711 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(129547);
            C26769j.m42601a(C26769j.this, 1, 0, 7, 0, true, null);
            AppMethodBeat.m2505o(129547);
        }
    }

    private C26769j() {
    }

    public static C26769j axh() {
        AppMethodBeat.m2504i(129551);
        if (gZd == null) {
            synchronized (C26769j.class) {
                try {
                    if (gZd == null) {
                        gZd = new C26769j();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(129551);
                    }
                }
            }
        }
        C26769j c26769j = gZd;
        AppMethodBeat.m2505o(129551);
        return c26769j;
    }

    public static void release() {
        gZd = null;
    }

    /* renamed from: a */
    public final void mo44541a(long j, boolean z, Bundle bundle, int i, int i2) {
        AppMethodBeat.m2504i(129552);
        final int i3 = i;
        final int i4 = i2;
        final boolean z2 = z;
        final long j2 = j;
        final Bundle bundle2 = bundle;
        C45673m.aNS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(129549);
                C26769j.m42601a(C26769j.this, i3, i4, ((z2 & C26783t.axG()) != 0 ? 2 : 0) | 1, j2, z2, bundle2);
                AppMethodBeat.m2505o(129549);
            }
        });
        AppMethodBeat.m2505o(129552);
    }

    public static boolean axi() {
        AppMethodBeat.m2504i(129553);
        if (C1720g.m3531RK()) {
            boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_HISTORY_HAS_MORE_BOOLEAN, Boolean.FALSE)).booleanValue();
            AppMethodBeat.m2505o(129553);
            return booleanValue;
        }
        AppMethodBeat.m2505o(129553);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m42601a(C26769j c26769j, int i, int i2, int i3, long j, boolean z, Bundle bundle) {
        AppMethodBeat.m2504i(129554);
        if (C1720g.m3531RK()) {
            Object obj;
            if (2 == i) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                int i4;
                long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_HISTORY_LIST_PAGING_LAST_SERVER_MIN_UPDATE_TIME_LONG, Long.valueOf(-1))).longValue();
                if (z || longValue <= 0) {
                    i4 = BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i4 = (int) longValue;
                }
                final int i5 = i3;
                final int i6 = i;
                final Bundle bundle2 = bundle;
                final long j2 = j;
                new C45523y(i, i2, i3, i4) {
                    /* renamed from: a */
                    public final /* synthetic */ void mo21469a(int i, int i2, String str, btd btd, C1207m c1207m) {
                        AppMethodBeat.m2504i(129550);
                        ark ark = (ark) btd;
                        if (C1720g.m3531RK()) {
                            String str2;
                            int i3;
                            if (ark == null) {
                                str2 = BuildConfig.COMMAND;
                            } else {
                                Locale locale = Locale.US;
                                String str3 = "%d %d %d";
                                Object[] objArr = new Object[3];
                                if (ark.wvv == null) {
                                    i3 = -1;
                                } else {
                                    i3 = ark.wvv.size();
                                }
                                objArr[0] = Integer.valueOf(i3);
                                if (ark.wvw == null) {
                                    i3 = -1;
                                } else {
                                    i3 = ark.wvw.size();
                                }
                                objArr[1] = Integer.valueOf(i3);
                                objArr[2] = Integer.valueOf(ark.status);
                                str2 = String.format(locale, str3, objArr);
                            }
                            C4990ab.m7417i("MicroMsg.AppBrandHistoryLogic[collection]", "onCgiBack, errType %d, errCode %d, errMsg %s, resp %s", Integer.valueOf(i), Integer.valueOf(i2), str, str2);
                            if (ark != null && i == 0 && i2 == 0) {
                                if ((i5 & 4) > 0 && !C42382q.axo() && (ark.status & 8) > 0) {
                                    C42382q.axp();
                                }
                                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_HISTORY_HAS_MORE_BOOLEAN, Boolean.valueOf((ark.status & 4) > 0));
                                C19104i.m29720nx(ark.status);
                                if (!C5046bo.m7548ek(ark.wvw)) {
                                    C45522w auT = C42340f.auT();
                                    LinkedList<cwq> linkedList = ark.wvw;
                                    C26785a c26785a = new C26785a();
                                    LinkedList linkedList2 = new LinkedList();
                                    LinkedList linkedList3 = new LinkedList();
                                    long iV = auT.hae.mo15639iV(Thread.currentThread().getId());
                                    for (cwq cwq : linkedList) {
                                        if (!C5046bo.isNullOrNil(cwq.username)) {
                                            c26785a.field_brandId = cwq.username;
                                            c26785a.field_versionType = cwq.vOO;
                                            c26785a.field_scene = 2;
                                            if (auT.hao.mo10102b((C4925c) c26785a, new String[0])) {
                                                c26785a.field_updateTime = Math.max((long) cwq.vWx, c26785a.field_updateTime);
                                                if (auT.hao.mo10103c(c26785a, new String[0])) {
                                                    linkedList3.add(String.valueOf(c26785a.field_recordId));
                                                }
                                            } else {
                                                c26785a.field_updateTime = (long) cwq.vWx;
                                                if (auT.mo73329a(c26785a)) {
                                                    linkedList2.add(String.valueOf(c26785a.field_recordId));
                                                }
                                            }
                                        }
                                    }
                                    auT.hae.mo15640mB(iV);
                                    if (!C5046bo.m7548ek(linkedList2)) {
                                        auT.mo15641b("batch", 2, linkedList2);
                                    }
                                    if (!C5046bo.m7548ek(linkedList3)) {
                                        auT.mo15641b("batch", 3, linkedList3);
                                    }
                                    if (!C5046bo.m7548ek(ark.wvw)) {
                                        int i4;
                                        i3 = ((cwq) ark.wvw.getFirst()).vWx;
                                        Iterator it = ark.wvw.iterator();
                                        while (true) {
                                            i4 = i3;
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            i3 = Math.min(i4, ((cwq) it.next()).vWx);
                                        }
                                        if (i4 > 0) {
                                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_HISTORY_LIST_PAGING_LAST_SERVER_MIN_UPDATE_TIME_LONG, Long.valueOf((long) i4));
                                        }
                                    }
                                    C26784u.m42629a(i6, ark.wvw);
                                }
                                C26783t.m42627a(i6, i, i2, str, (C7472b) c1207m.ftl, Long.valueOf(j2));
                            }
                            C26769j.this.mo15641b("batch", 3, Long.valueOf(j2));
                        }
                        AppMethodBeat.m2505o(129550);
                    }
                }.acy();
            }
        }
        AppMethodBeat.m2505o(129554);
    }
}
