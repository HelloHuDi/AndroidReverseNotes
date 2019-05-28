package com.tencent.p177mm.plugin.appbrand.backgroundfetch;

import android.database.Cursor;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b.C9557a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af.C10117a;
import com.tencent.p177mm.plugin.appbrand.appusage.C45522w;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.protocal.protobuf.C23392gk;
import com.tencent.p177mm.protocal.protobuf.ble;
import com.tencent.p177mm.protocal.protobuf.cxb;
import com.tencent.p177mm.protocal.protobuf.cxc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p644j.C5710a;
import com.tencent.p177mm.vending.p644j.C7583c;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.b */
public final class C42385b {

    /* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.b$1 */
    public static class C423861 implements Runnable {
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0129  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00f4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.m2504i(129759);
            List<LocalUsageInfo> a = ((C10118af) C1720g.m3528K(C10118af.class)).mo21470a(BaseClientBuilder.API_PRIORITY_OTHER, C10117a.UPATE_TIME_DESC);
            if (a == null || a.isEmpty()) {
                C4990ab.m7416i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:peroidFetchDataWhenAppEnterForground, no star apps");
                AppMethodBeat.m2505o(129759);
                return;
            }
            C4990ab.m7417i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:peroidFetchDataWhenAppEnterForground, star list size:%d", Integer.valueOf(a.size()));
            HashMap hashMap = new HashMap();
            for (LocalUsageInfo localUsageInfo : a) {
                if (!hashMap.containsKey(localUsageInfo.username)) {
                    Object obj;
                    String str = localUsageInfo.username;
                    int i = localUsageInfo.har;
                    C42384a zi = C26842p.m42736zi(str);
                    if (zi == null || !zi.hbW) {
                        C4990ab.m7417i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "canPeriodFetchData, app(%s_v%d) can not period fetch data", str, Integer.valueOf(i));
                        obj = null;
                    } else if (C42385b.m75000aO(str, i)) {
                        int i2 = zi.hbX;
                        if (i2 >= 2) {
                            long aQ = ((C26798h) C1720g.m3528K(C26798h.class)).mo21500aQ(str, 1);
                            if (aQ <= 0) {
                                obj = 1;
                            } else if (C5046bo.anU() - aQ >= ((long) i2) * 3600000) {
                                obj = 1;
                            }
                            if (obj != null) {
                                C4990ab.m7417i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "canPeriodFetchData, app(%s_v%d) interval(%d) not ok", str, Integer.valueOf(i), Integer.valueOf(zi.hbX));
                                obj = null;
                            } else {
                                long j;
                                C45522w auT = C42340f.auT();
                                if (C5046bo.isNullOrNil(str)) {
                                    j = -1;
                                } else {
                                    Cursor query = auT.hae.query("AppBrandLauncherLayoutItem", new String[]{"updateTime"}, String.format(Locale.US, "%s=? and %s=? and %s=?", new Object[]{"brandId", "versionType", "scene"}), new String[]{str, String.valueOf(i), "2"}, null, null, String.format(Locale.US, " %s desc ", new Object[]{"updateTime"}));
                                    if (query == null) {
                                        j = -1;
                                    } else {
                                        if (query.moveToFirst()) {
                                            j = query.getLong(0);
                                        } else {
                                            j = -1;
                                        }
                                        query.close();
                                    }
                                }
                                if (j <= 0 || C5046bo.anU() - (j * 1000) > 604800000) {
                                    obj = null;
                                } else {
                                    obj = 1;
                                }
                                if (obj == null) {
                                    C4990ab.m7417i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "canPeriodFetchData, app(%s_v%d) recently not used", str, Integer.valueOf(i));
                                    obj = null;
                                } else {
                                    C4990ab.m7417i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "canPeriodFetchData, app(%s_v%d) can period fetch data", str, Integer.valueOf(i));
                                    obj = 1;
                                }
                            }
                        }
                        obj = null;
                        if (obj != null) {
                        }
                    } else {
                        C4990ab.m7417i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "canPeriodFetchData, app(%s_v%d) is not star app", str, Integer.valueOf(i));
                        obj = null;
                    }
                    if (obj != null) {
                        hashMap.put(localUsageInfo.username, localUsageInfo.appId);
                        if (hashMap.size() >= 10) {
                            C4990ab.m7416i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:peroidFetchDataWhenAppEnterForground, batch list full");
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            if (hashMap.isEmpty()) {
                C4990ab.m7416i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:peroidFetchDataWhenAppEnterForground, currently no app needs to update period data");
                AppMethodBeat.m2505o(129759);
                return;
            }
            C42385b.m74998a(hashMap, new C19126g());
            AppMethodBeat.m2505o(129759);
        }
    }

    /* renamed from: a */
    public static void m74997a(String str, String str2, int i, String str3, int i2, C19126g c19126g) {
        AppMethodBeat.m2504i(129761);
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7416i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchData, username is null");
            AppMethodBeat.m2505o(129761);
            return;
        }
        C42384a zi = C26842p.m42736zi(str2);
        if (zi != null && !zi.hbV) {
            C4990ab.m7417i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchData, app(%s_v%d) can not pre fetch data", str2, Integer.valueOf(i));
            AppMethodBeat.m2505o(129761);
        } else if (C42385b.m75000aO(str2, i)) {
            Object obj;
            Object str32;
            if (C5046bo.isNullOrNil(str32)) {
                obj = null;
                str32 = null;
            } else {
                int lastIndexOf = str32.lastIndexOf(63);
                if (lastIndexOf > 0) {
                    String substring = str32.substring(0, lastIndexOf);
                    if (lastIndexOf < str32.length() - 1) {
                        obj = str32.substring(lastIndexOf + 1);
                        str32 = substring;
                    } else {
                        obj = null;
                        str32 = substring;
                    }
                } else {
                    obj = null;
                }
            }
            C7583c F = C5710a.m8574F(str32, obj);
            String str4 = (String) F.get(0);
            String str5 = (String) F.get(1);
            C4990ab.m7417i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchDataInternal, app(%s) pre fetch data start, path:%s, query:%s, scene:%d", str2, str4, str5, Integer.valueOf(i2));
            C23392gk c23392gk = new C23392gk();
            c23392gk.csB = str;
            c23392gk.username = str2;
            c23392gk.vIG = 0;
            c23392gk.vIH = new ble();
            c23392gk.vIH.scene = i2;
            if (!C5046bo.isNullOrNil(str4)) {
                c23392gk.vIH.path = str4;
            }
            if (!C5046bo.isNullOrNil(str5)) {
                c23392gk.vIH.query = str5;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(c23392gk);
            C42385b.m74996a(0, linkedList, c19126g);
            AppMethodBeat.m2505o(129761);
        } else {
            C4990ab.m7417i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchData, app(%s_v%d) is not star app", str2, Integer.valueOf(i));
            AppMethodBeat.m2505o(129761);
        }
    }

    /* renamed from: a */
    private static void m74996a(final int i, List<C23392gk> list, final C38140i c38140i) {
        AppMethodBeat.m2504i(129762);
        if (list.isEmpty() || c38140i == null) {
            C4990ab.m7416i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, requestList or callback is null");
            AppMethodBeat.m2505o(129762);
            return;
        }
        C4990ab.m7417i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, size:%d", Integer.valueOf(list.size()));
        final cxb cxb = new cxb();
        cxb.xsC.addAll(list);
        C1196a c1196a = new C1196a();
        c1196a.fsI = 1733;
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxabusiness/fetchdata";
        c1196a.fsJ = cxb;
        c1196a.fsK = new cxc();
        C42146b.m74301a(c1196a.acD(), new C9557a() {
            /* renamed from: a */
            public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
                AppMethodBeat.m2504i(129760);
                if (i == 0 && i2 == 0 && c7472b != null && c7472b.fsH.fsP != null && (c7472b.fsH.fsP instanceof cxc)) {
                    cxc cxc = (cxc) c7472b.fsH.fsP;
                    if (cxc.xsD == null || cxc.xsD.isEmpty()) {
                        C4990ab.m7412e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data fail:data is null");
                        c38140i.onFail(i);
                        AppMethodBeat.m2505o(129760);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data success");
                    c38140i.mo34337e(cxc.xsD, cxb.xsC);
                    AppMethodBeat.m2505o(129760);
                    return;
                }
                C4990ab.m7412e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data fail:request fail");
                c38140i.onFail(i);
                AppMethodBeat.m2505o(129760);
            }
        });
        AppMethodBeat.m2505o(129762);
    }

    /* renamed from: aO */
    static boolean m75000aO(String str, int i) {
        AppMethodBeat.m2504i(129763);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129763);
            return false;
        }
        boolean aB = ((C10118af) C1720g.m3528K(C10118af.class)).mo21471aB(str, i);
        AppMethodBeat.m2505o(129763);
        return aB;
    }

    /* renamed from: a */
    public static boolean m74999a(AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.m2504i(129764);
        if (appBrandInitConfigWC == null || C5046bo.isNullOrNil(appBrandInitConfigWC.appId) || C45694h.m84416DS(appBrandInitConfigWC.appId)) {
            AppMethodBeat.m2505o(129764);
            return false;
        }
        AppMethodBeat.m2505o(129764);
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ void m74998a(Map map, C38140i c38140i) {
        AppMethodBeat.m2504i(129765);
        if (map.isEmpty()) {
            C4990ab.m7416i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "periodFetchDataInternal, no starAppMap or no callback");
            AppMethodBeat.m2505o(129765);
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (Entry entry : map.entrySet()) {
            C23392gk c23392gk = new C23392gk();
            c23392gk.username = (String) entry.getKey();
            c23392gk.csB = (String) entry.getValue();
            c23392gk.vIG = 1;
            linkedList.add(c23392gk);
        }
        C42385b.m74996a(1, linkedList, c38140i);
        AppMethodBeat.m2505o(129765);
    }
}
