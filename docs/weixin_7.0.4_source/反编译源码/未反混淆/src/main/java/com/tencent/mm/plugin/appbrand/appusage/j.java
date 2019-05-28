package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class j extends k {
    private static volatile j gZd = null;

    private j() {
    }

    public static j axh() {
        AppMethodBeat.i(129551);
        if (gZd == null) {
            synchronized (j.class) {
                try {
                    if (gZd == null) {
                        gZd = new j();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(129551);
                    }
                }
            }
        }
        j jVar = gZd;
        AppMethodBeat.o(129551);
        return jVar;
    }

    public static void release() {
        gZd = null;
    }

    public final void a(long j, boolean z, Bundle bundle, int i, int i2) {
        AppMethodBeat.i(129552);
        final int i3 = i;
        final int i4 = i2;
        final boolean z2 = z;
        final long j2 = j;
        final Bundle bundle2 = bundle;
        m.aNS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(129549);
                j.a(j.this, i3, i4, ((z2 & t.axG()) != 0 ? 2 : 0) | 1, j2, z2, bundle2);
                AppMethodBeat.o(129549);
            }
        });
        AppMethodBeat.o(129552);
    }

    public static boolean axi() {
        AppMethodBeat.i(129553);
        if (g.RK()) {
            boolean booleanValue = ((Boolean) g.RP().Ry().get(a.USERINFO_APP_BRAND_HISTORY_HAS_MORE_BOOLEAN, Boolean.FALSE)).booleanValue();
            AppMethodBeat.o(129553);
            return booleanValue;
        }
        AppMethodBeat.o(129553);
        return false;
    }

    static /* synthetic */ void a(j jVar, int i, int i2, int i3, long j, boolean z, Bundle bundle) {
        AppMethodBeat.i(129554);
        if (g.RK()) {
            Object obj;
            if (2 == i) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                int i4;
                long longValue = ((Long) g.RP().Ry().get(a.USERINFO_APP_BRAND_HISTORY_LIST_PAGING_LAST_SERVER_MIN_UPDATE_TIME_LONG, Long.valueOf(-1))).longValue();
                if (z || longValue <= 0) {
                    i4 = BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i4 = (int) longValue;
                }
                final int i5 = i3;
                final int i6 = i;
                final Bundle bundle2 = bundle;
                final long j2 = j;
                new y(i, i2, i3, i4) {
                    public final /* synthetic */ void a(int i, int i2, String str, btd btd, com.tencent.mm.ai.m mVar) {
                        AppMethodBeat.i(129550);
                        ark ark = (ark) btd;
                        if (g.RK()) {
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
                            ab.i("MicroMsg.AppBrandHistoryLogic[collection]", "onCgiBack, errType %d, errCode %d, errMsg %s, resp %s", Integer.valueOf(i), Integer.valueOf(i2), str, str2);
                            if (ark != null && i == 0 && i2 == 0) {
                                if ((i5 & 4) > 0 && !q.axo() && (ark.status & 8) > 0) {
                                    q.axp();
                                }
                                g.RP().Ry().set(a.USERINFO_APP_BRAND_HISTORY_HAS_MORE_BOOLEAN, Boolean.valueOf((ark.status & 4) > 0));
                                i.nx(ark.status);
                                if (!bo.ek(ark.wvw)) {
                                    w auT = f.auT();
                                    LinkedList<cwq> linkedList = ark.wvw;
                                    a aVar = new a();
                                    LinkedList linkedList2 = new LinkedList();
                                    LinkedList linkedList3 = new LinkedList();
                                    long iV = auT.hae.iV(Thread.currentThread().getId());
                                    for (cwq cwq : linkedList) {
                                        if (!bo.isNullOrNil(cwq.username)) {
                                            aVar.field_brandId = cwq.username;
                                            aVar.field_versionType = cwq.vOO;
                                            aVar.field_scene = 2;
                                            if (auT.hao.b((c) aVar, new String[0])) {
                                                aVar.field_updateTime = Math.max((long) cwq.vWx, aVar.field_updateTime);
                                                if (auT.hao.c(aVar, new String[0])) {
                                                    linkedList3.add(String.valueOf(aVar.field_recordId));
                                                }
                                            } else {
                                                aVar.field_updateTime = (long) cwq.vWx;
                                                if (auT.a(aVar)) {
                                                    linkedList2.add(String.valueOf(aVar.field_recordId));
                                                }
                                            }
                                        }
                                    }
                                    auT.hae.mB(iV);
                                    if (!bo.ek(linkedList2)) {
                                        auT.b("batch", 2, linkedList2);
                                    }
                                    if (!bo.ek(linkedList3)) {
                                        auT.b("batch", 3, linkedList3);
                                    }
                                    if (!bo.ek(ark.wvw)) {
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
                                            g.RP().Ry().set(a.USERINFO_APP_BRAND_HISTORY_LIST_PAGING_LAST_SERVER_MIN_UPDATE_TIME_LONG, Long.valueOf((long) i4));
                                        }
                                    }
                                    u.a(i6, ark.wvw);
                                }
                                t.a(i6, i, i2, str, (b) mVar.ftl, Long.valueOf(j2));
                            }
                            j.this.b("batch", 3, Long.valueOf(j2));
                        }
                        AppMethodBeat.o(129550);
                    }
                }.acy();
            }
        }
        AppMethodBeat.o(129554);
    }
}
