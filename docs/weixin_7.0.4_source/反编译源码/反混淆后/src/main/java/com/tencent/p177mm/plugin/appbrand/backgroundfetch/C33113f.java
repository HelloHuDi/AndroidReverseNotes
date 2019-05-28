package com.tencent.p177mm.plugin.appbrand.backgroundfetch;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C10048a;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.p177mm.plugin.appbrand.ipc.MMToClientEvent.C38244c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.p281b.C10136c.C10137a;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.f */
public final class C33113f extends C38369p {
    private static final int CTRL_INDEX = 523;
    private static final String NAME = "onBackgroundFetchData";

    /* renamed from: k */
    public static void m54128k(C41243o c41243o) {
        AppMethodBeat.m2504i(129808);
        final String str = c41243o.mAppId;
        final C331141 c331141 = new C38244c() {
            /* renamed from: bk */
            public final void mo22088bk(Object obj) {
                AppMethodBeat.m2504i(129806);
                if (obj instanceof AppBrandBackgroundFetchDataParcel) {
                    C4990ab.m7417i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "app received data, appId:%s", str);
                    String str = str;
                    AppBrandBackgroundFetchDataParcel appBrandBackgroundFetchDataParcel = (AppBrandBackgroundFetchDataParcel) obj;
                    if (appBrandBackgroundFetchDataParcel == null || C5046bo.isNullOrNil(str)) {
                        C4990ab.m7420w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "dispatch, parcel is null or appid is null");
                        AppMethodBeat.m2505o(129806);
                        return;
                    }
                    String str2 = appBrandBackgroundFetchDataParcel.username;
                    int i = appBrandBackgroundFetchDataParcel.hca;
                    String str3 = appBrandBackgroundFetchDataParcel.data;
                    String str4 = appBrandBackgroundFetchDataParcel.path;
                    String str5 = appBrandBackgroundFetchDataParcel.query;
                    int i2 = appBrandBackgroundFetchDataParcel.scene;
                    long j = appBrandBackgroundFetchDataParcel.updateTime;
                    if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3)) {
                        C4990ab.m7420w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "username or data is null");
                        AppMethodBeat.m2505o(129806);
                        return;
                    }
                    C41243o wI = C10048a.m17635wI(str);
                    if (wI == null || !wI.eMP) {
                        C4990ab.m7421w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "app(%s) runtime is null or not initialized, appId:%s", str2, str);
                        AppMethodBeat.m2505o(129806);
                        return;
                    }
                    C38492q xT = wI.mo15032xT();
                    if (xT == null || xT.asD() == C45524b.DESTROYED) {
                        C4990ab.m7421w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "app(%s) service is null or has destroyed, appId:%s", str2, str);
                        AppMethodBeat.m2505o(129806);
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("timeStamp", Long.valueOf(j));
                    hashMap.put("path", str4);
                    hashMap.put(SearchIntents.EXTRA_QUERY, str5);
                    hashMap.put("scene", Integer.valueOf(i2));
                    hashMap.put("fetchedData", str3);
                    hashMap.put("fetchType", i == 0 ? "pre" : "peroid");
                    C4990ab.m7417i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "AppBrandOnBackgroundFetchDataEvent dispatch to app(%s), appId:%s, fetch type:%d", str2, str, Integer.valueOf(i));
                    new C33113f().mo34958t(hashMap).mo61031i(xT).aCj();
                }
                AppMethodBeat.m2505o(129806);
            }
        };
        MMToClientEvent.m75199a(str, c331141);
        C4990ab.m7417i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "app start listening, appId:%s", str);
        c41243o.gNN.mo21486a(new C10137a() {
            /* renamed from: a */
            public final void mo6006a(String str, C45524b c45524b) {
                AppMethodBeat.m2504i(129807);
                if (c45524b == C45524b.DESTROYED) {
                    MMToClientEvent.m75200b(str, c331141);
                    C4990ab.m7417i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "app stop listening, appId:%s", str);
                }
                AppMethodBeat.m2505o(129807);
            }
        });
        AppMethodBeat.m2505o(129808);
    }
}
