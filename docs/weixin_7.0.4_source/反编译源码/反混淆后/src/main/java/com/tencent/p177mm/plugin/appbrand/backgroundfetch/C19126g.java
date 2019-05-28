package com.tencent.p177mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.ipc.C10276d;
import com.tencent.p177mm.protocal.protobuf.C23392gk;
import com.tencent.p177mm.protocal.protobuf.C23393gl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.g */
public final class C19126g implements C38140i {
    /* renamed from: e */
    public final void mo34337e(List<C23393gl> list, List<C23392gk> list2) {
        AppMethodBeat.m2504i(129809);
        if (!(list == null || list.isEmpty())) {
            for (C23393gl c23393gl : list) {
                C23392gk c23392gk;
                if (!(c23393gl == null || C5046bo.isNullOrNil(c23393gl.username) || list2 == null || list2.isEmpty())) {
                    for (C23392gk c23392gk2 : list2) {
                        if (c23393gl.username.equalsIgnoreCase(c23392gk2.username)) {
                            c23392gk = c23392gk2;
                            break;
                        }
                    }
                }
                c23392gk = null;
                if (c23393gl.cyE != 0 || c23392gk == null) {
                    C4990ab.m7421w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "cgi success, but app(%s) failed to fetch data", c23393gl.username);
                } else if (c23392gk == null || c23393gl == null) {
                    C4990ab.m7420w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, request item or response item is null");
                } else if (C5046bo.isNullOrNil(c23393gl.username) || C5046bo.isNullOrNil(c23393gl.data)) {
                    C4990ab.m7420w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, no username or data in response");
                } else {
                    long anU = C5046bo.anU();
                    String str = c23393gl.username;
                    String str2 = c23393gl.data;
                    int i = c23392gk.vIG;
                    String str3 = c23392gk.vIH != null ? c23392gk.vIH.path : null;
                    String str4 = c23392gk.vIH != null ? c23392gk.vIH.query : null;
                    int i2 = c23392gk.vIH != null ? c23392gk.vIH.scene : 1000;
                    if (!((C26798h) C1720g.m3528K(C26798h.class)).mo21499a(str, i, str2, str3, str4, i2, anU)) {
                        C4990ab.m7412e("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, save data fail");
                    } else if (!C5046bo.isNullOrNil(c23392gk.csB)) {
                        AppBrandBackgroundFetchDataParcel appBrandBackgroundFetchDataParcel = new AppBrandBackgroundFetchDataParcel();
                        appBrandBackgroundFetchDataParcel.username = str;
                        appBrandBackgroundFetchDataParcel.hca = i;
                        appBrandBackgroundFetchDataParcel.data = str2;
                        appBrandBackgroundFetchDataParcel.path = str3;
                        appBrandBackgroundFetchDataParcel.query = str4;
                        appBrandBackgroundFetchDataParcel.scene = i2;
                        appBrandBackgroundFetchDataParcel.updateTime = anU;
                        C4990ab.m7417i("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData success, send data event to app(%s), appId:%s", c23392gk.username, c23392gk.csB);
                        C10276d.m17931a(c23392gk.csB, appBrandBackgroundFetchDataParcel);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(129809);
    }

    public final void onFail(int i) {
        AppMethodBeat.m2504i(129810);
        C4990ab.m7413e("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "cgi fail, type(%d)", Integer.valueOf(i));
        AppMethodBeat.m2505o(129810);
    }
}
