package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.protocal.protobuf.gk;
import com.tencent.mm.protocal.protobuf.gl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class g implements i {
    public final void e(List<gl> list, List<gk> list2) {
        AppMethodBeat.i(129809);
        if (!(list == null || list.isEmpty())) {
            for (gl glVar : list) {
                gk gkVar;
                if (!(glVar == null || bo.isNullOrNil(glVar.username) || list2 == null || list2.isEmpty())) {
                    for (gk gkVar2 : list2) {
                        if (glVar.username.equalsIgnoreCase(gkVar2.username)) {
                            gkVar = gkVar2;
                            break;
                        }
                    }
                }
                gkVar = null;
                if (glVar.cyE != 0 || gkVar == null) {
                    ab.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "cgi success, but app(%s) failed to fetch data", glVar.username);
                } else if (gkVar == null || glVar == null) {
                    ab.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, request item or response item is null");
                } else if (bo.isNullOrNil(glVar.username) || bo.isNullOrNil(glVar.data)) {
                    ab.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, no username or data in response");
                } else {
                    long anU = bo.anU();
                    String str = glVar.username;
                    String str2 = glVar.data;
                    int i = gkVar.vIG;
                    String str3 = gkVar.vIH != null ? gkVar.vIH.path : null;
                    String str4 = gkVar.vIH != null ? gkVar.vIH.query : null;
                    int i2 = gkVar.vIH != null ? gkVar.vIH.scene : 1000;
                    if (!((h) com.tencent.mm.kernel.g.K(h.class)).a(str, i, str2, str3, str4, i2, anU)) {
                        ab.e("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, save data fail");
                    } else if (!bo.isNullOrNil(gkVar.csB)) {
                        AppBrandBackgroundFetchDataParcel appBrandBackgroundFetchDataParcel = new AppBrandBackgroundFetchDataParcel();
                        appBrandBackgroundFetchDataParcel.username = str;
                        appBrandBackgroundFetchDataParcel.hca = i;
                        appBrandBackgroundFetchDataParcel.data = str2;
                        appBrandBackgroundFetchDataParcel.path = str3;
                        appBrandBackgroundFetchDataParcel.query = str4;
                        appBrandBackgroundFetchDataParcel.scene = i2;
                        appBrandBackgroundFetchDataParcel.updateTime = anU;
                        ab.i("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData success, send data event to app(%s), appId:%s", gkVar.username, gkVar.csB);
                        d.a(gkVar.csB, appBrandBackgroundFetchDataParcel);
                    }
                }
            }
        }
        AppMethodBeat.o(129809);
    }

    public final void onFail(int i) {
        AppMethodBeat.i(129810);
        ab.e("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "cgi fail, type(%d)", Integer.valueOf(i));
        AppMethodBeat.o(129810);
    }
}
