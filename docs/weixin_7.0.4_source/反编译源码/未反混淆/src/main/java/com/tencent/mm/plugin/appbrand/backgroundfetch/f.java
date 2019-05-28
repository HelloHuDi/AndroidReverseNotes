package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class f extends p {
    private static final int CTRL_INDEX = 523;
    private static final String NAME = "onBackgroundFetchData";

    public static void k(o oVar) {
        AppMethodBeat.i(129808);
        final String str = oVar.mAppId;
        final AnonymousClass1 anonymousClass1 = new c() {
            public final void bk(Object obj) {
                AppMethodBeat.i(129806);
                if (obj instanceof AppBrandBackgroundFetchDataParcel) {
                    ab.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "app received data, appId:%s", str);
                    String str = str;
                    AppBrandBackgroundFetchDataParcel appBrandBackgroundFetchDataParcel = (AppBrandBackgroundFetchDataParcel) obj;
                    if (appBrandBackgroundFetchDataParcel == null || bo.isNullOrNil(str)) {
                        ab.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "dispatch, parcel is null or appid is null");
                        AppMethodBeat.o(129806);
                        return;
                    }
                    String str2 = appBrandBackgroundFetchDataParcel.username;
                    int i = appBrandBackgroundFetchDataParcel.hca;
                    String str3 = appBrandBackgroundFetchDataParcel.data;
                    String str4 = appBrandBackgroundFetchDataParcel.path;
                    String str5 = appBrandBackgroundFetchDataParcel.query;
                    int i2 = appBrandBackgroundFetchDataParcel.scene;
                    long j = appBrandBackgroundFetchDataParcel.updateTime;
                    if (bo.isNullOrNil(str2) || bo.isNullOrNil(str3)) {
                        ab.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "username or data is null");
                        AppMethodBeat.o(129806);
                        return;
                    }
                    o wI = a.wI(str);
                    if (wI == null || !wI.eMP) {
                        ab.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "app(%s) runtime is null or not initialized, appId:%s", str2, str);
                        AppMethodBeat.o(129806);
                        return;
                    }
                    q xT = wI.xT();
                    if (xT == null || xT.asD() == b.DESTROYED) {
                        ab.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "app(%s) service is null or has destroyed, appId:%s", str2, str);
                        AppMethodBeat.o(129806);
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("timeStamp", Long.valueOf(j));
                    hashMap.put("path", str4);
                    hashMap.put(SearchIntents.EXTRA_QUERY, str5);
                    hashMap.put("scene", Integer.valueOf(i2));
                    hashMap.put("fetchedData", str3);
                    hashMap.put("fetchType", i == 0 ? "pre" : "peroid");
                    ab.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "AppBrandOnBackgroundFetchDataEvent dispatch to app(%s), appId:%s, fetch type:%d", str2, str, Integer.valueOf(i));
                    new f().t(hashMap).i(xT).aCj();
                }
                AppMethodBeat.o(129806);
            }
        };
        MMToClientEvent.a(str, anonymousClass1);
        ab.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "app start listening, appId:%s", str);
        oVar.gNN.a(new com.tencent.mm.plugin.appbrand.b.c.a() {
            public final void a(String str, b bVar) {
                AppMethodBeat.i(129807);
                if (bVar == b.DESTROYED) {
                    MMToClientEvent.b(str, anonymousClass1);
                    ab.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent.javayhu", "app stop listening, appId:%s", str);
                }
                AppMethodBeat.o(129807);
            }
        });
        AppMethodBeat.o(129808);
    }
}
