package com.tencent.p177mm.plugin.freewifi.model;

import android.content.Intent;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.freewifi.C11963i.C11964a;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.model.C39113g.C20800b;
import com.tencent.p177mm.plugin.freewifi.model.C39113g.C391142;
import com.tencent.p177mm.plugin.freewifi.model.C39113g.C391151;
import com.tencent.p177mm.plugin.freewifi.p416d.C44737b;
import com.tencent.p177mm.plugin.freewifi.p417g.C3137c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.freewifi.model.a */
public final class C3139a {
    SparseArray<Long> mvy = new SparseArray();
    private C39113g mvz = new C39113g();

    /* renamed from: com.tencent.mm.plugin.freewifi.model.a$1 */
    class C31401 implements C1202f {
        C31401() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(20683);
            String str2 = ((C44737b) c1207m).mac;
            if (C34189m.isEmpty(str2)) {
                AppMethodBeat.m2505o(20683);
            } else if (i2 == -30011) {
                C3139a.this.mvy.put(str2.hashCode(), Long.valueOf(C5046bo.anU()));
                AppMethodBeat.m2505o(20683);
            } else {
                C3139a.this.mvy.remove(str2.hashCode());
                AppMethodBeat.m2505o(20683);
            }
        }
    }

    public C3139a() {
        AppMethodBeat.m2504i(20684);
        AppMethodBeat.m2505o(20684);
    }

    /* renamed from: a */
    public final void mo7393a(String str, C20800b c20800b, int i, Intent intent) {
        AppMethodBeat.m2504i(20685);
        C11976j.byZ().byI().post(new C391151(str, intent, c20800b, i));
        AppMethodBeat.m2505o(20685);
    }

    public final synchronized void byF() {
        AppMethodBeat.m2504i(20687);
        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiAuthManager", "ap check for bar.");
        String byO = C45957d.byO();
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiAuthManager", "autuApAuth, get ssid is %s ", byO);
        if (C5046bo.isNullOrNil(byO)) {
            AppMethodBeat.m2505o(20687);
        } else if (C11976j.byW().mo17044MK(byO) != null) {
            AppMethodBeat.m2505o(20687);
        } else {
            int i;
            String byK = C45957d.byK();
            String str = "MicroMsg.FreeWifi.FreeWifiAuthManager";
            String str2 = "freewifi info is null, now try to check is the wechat wifi fromserver, ssid is : %s, mac is : %s, nowmac hashcode : %d";
            Object[] objArr = new Object[3];
            objArr[0] = byO;
            objArr[1] = byK;
            if (byK == null) {
                i = 0;
            } else {
                i = byK.hashCode();
            }
            objArr[2] = Integer.valueOf(i);
            C4990ab.m7417i(str, str2, objArr);
            if (C5046bo.isNullOrNil(byK)) {
                AppMethodBeat.m2505o(20687);
            } else {
                boolean z;
                C3137c ML = C11976j.byW().mo17045ML(byO);
                str2 = "MicroMsg.FreeWifi.FreeWifiAuthManager";
                String str3 = "now mac is : %s, loacal mac is : %s";
                Object[] objArr2 = new Object[2];
                objArr2[0] = byK;
                objArr2[1] = ML == null ? "null free wifiinfo" : ML.field_mac;
                C4990ab.m7417i(str2, str3, objArr2);
                if (ML != null) {
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiAuthManager", "freewifi is not null, expired time = %d", Long.valueOf(ML.field_expiredTime));
                    if (!byK.equalsIgnoreCase(ML.field_mac) || ML.field_expiredTime - C5046bo.anT() < 0) {
                        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has expierd time or mac has changed");
                        z = true;
                    }
                    z = false;
                } else if (this.mvy.indexOfKey(byK.hashCode()) >= 0) {
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has checked this mac, now time - last check time = %d", Long.valueOf(C5046bo.anU() - ((Long) this.mvy.get(byK.hashCode())).longValue()));
                    if (C5046bo.anU() - ((Long) this.mvy.get(byK.hashCode())).longValue() > 43200000) {
                        z = true;
                    }
                    z = false;
                } else {
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has not checked this mac, try to check from server");
                    z = true;
                }
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiAuthManager", "Should request bar from back end = %b", Boolean.valueOf(z));
                if (z) {
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiAuthManager", "now should do ap check, rssi is :  %d, mac : %s, mac hashcode : %d", Integer.valueOf(C45957d.byL()), byK, Integer.valueOf(byK.hashCode()));
                    if (System.currentTimeMillis() - C11964a.mtZ.mo23808lb("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS") > ((long) ((((C11964a.mtZ.getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7) * 24) * 60) * 60) * 1000))) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (C11964a.mtZ.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 0) == 1) {
                        i |= 2;
                    }
                    if (C11964a.mtZ.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0) == 1) {
                        i |= 4;
                    }
                    if (C11964a.mtZ.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0) == 1) {
                        i |= 8;
                    }
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiAuthManager", "features : ".concat(String.valueOf(i)));
                    new C44737b(byK, byO, r5, i).mo68619c(new C31401());
                }
                AppMethodBeat.m2505o(20687);
            }
        }
    }

    /* renamed from: a */
    public final void mo7394a(String str, String str2, Intent intent) {
        AppMethodBeat.m2504i(20686);
        C11976j.byZ().byI().post(new C391142(str2, str, intent));
        AppMethodBeat.m2505o(20686);
    }
}
