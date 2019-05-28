package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.model.g.AnonymousClass2;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    SparseArray<Long> mvy = new SparseArray();
    private g mvz = new g();

    public a() {
        AppMethodBeat.i(20684);
        AppMethodBeat.o(20684);
    }

    public final void a(String str, b bVar, int i, Intent intent) {
        AppMethodBeat.i(20685);
        j.byZ().byI().post(new com.tencent.mm.plugin.freewifi.model.g.AnonymousClass1(str, intent, bVar, i));
        AppMethodBeat.o(20685);
    }

    public final synchronized void byF() {
        AppMethodBeat.i(20687);
        ab.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "ap check for bar.");
        String byO = d.byO();
        ab.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "autuApAuth, get ssid is %s ", byO);
        if (bo.isNullOrNil(byO)) {
            AppMethodBeat.o(20687);
        } else if (j.byW().MK(byO) != null) {
            AppMethodBeat.o(20687);
        } else {
            int i;
            String byK = d.byK();
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
            ab.i(str, str2, objArr);
            if (bo.isNullOrNil(byK)) {
                AppMethodBeat.o(20687);
            } else {
                boolean z;
                c ML = j.byW().ML(byO);
                str2 = "MicroMsg.FreeWifi.FreeWifiAuthManager";
                String str3 = "now mac is : %s, loacal mac is : %s";
                Object[] objArr2 = new Object[2];
                objArr2[0] = byK;
                objArr2[1] = ML == null ? "null free wifiinfo" : ML.field_mac;
                ab.i(str2, str3, objArr2);
                if (ML != null) {
                    ab.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "freewifi is not null, expired time = %d", Long.valueOf(ML.field_expiredTime));
                    if (!byK.equalsIgnoreCase(ML.field_mac) || ML.field_expiredTime - bo.anT() < 0) {
                        ab.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has expierd time or mac has changed");
                        z = true;
                    }
                    z = false;
                } else if (this.mvy.indexOfKey(byK.hashCode()) >= 0) {
                    ab.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has checked this mac, now time - last check time = %d", Long.valueOf(bo.anU() - ((Long) this.mvy.get(byK.hashCode())).longValue()));
                    if (bo.anU() - ((Long) this.mvy.get(byK.hashCode())).longValue() > 43200000) {
                        z = true;
                    }
                    z = false;
                } else {
                    ab.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has not checked this mac, try to check from server");
                    z = true;
                }
                ab.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "Should request bar from back end = %b", Boolean.valueOf(z));
                if (z) {
                    ab.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "now should do ap check, rssi is :  %d, mac : %s, mac hashcode : %d", Integer.valueOf(d.byL()), byK, Integer.valueOf(byK.hashCode()));
                    if (System.currentTimeMillis() - com.tencent.mm.plugin.freewifi.i.a.mtZ.lb("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS") > ((long) ((((com.tencent.mm.plugin.freewifi.i.a.mtZ.getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7) * 24) * 60) * 60) * 1000))) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (com.tencent.mm.plugin.freewifi.i.a.mtZ.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 0) == 1) {
                        i |= 2;
                    }
                    if (com.tencent.mm.plugin.freewifi.i.a.mtZ.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0) == 1) {
                        i |= 4;
                    }
                    if (com.tencent.mm.plugin.freewifi.i.a.mtZ.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0) == 1) {
                        i |= 8;
                    }
                    ab.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "features : ".concat(String.valueOf(i)));
                    new com.tencent.mm.plugin.freewifi.d.b(byK, byO, r5, i).c(new f() {
                        public final void onSceneEnd(int i, int i2, String str, m mVar) {
                            AppMethodBeat.i(20683);
                            String str2 = ((com.tencent.mm.plugin.freewifi.d.b) mVar).mac;
                            if (com.tencent.mm.plugin.freewifi.m.isEmpty(str2)) {
                                AppMethodBeat.o(20683);
                            } else if (i2 == -30011) {
                                a.this.mvy.put(str2.hashCode(), Long.valueOf(bo.anU()));
                                AppMethodBeat.o(20683);
                            } else {
                                a.this.mvy.remove(str2.hashCode());
                                AppMethodBeat.o(20683);
                            }
                        }
                    });
                }
                AppMethodBeat.o(20687);
            }
        }
    }

    public final void a(String str, String str2, Intent intent) {
        AppMethodBeat.i(20686);
        j.byZ().byI().post(new AnonymousClass2(str2, str, intent));
        AppMethodBeat.o(20686);
    }
}
