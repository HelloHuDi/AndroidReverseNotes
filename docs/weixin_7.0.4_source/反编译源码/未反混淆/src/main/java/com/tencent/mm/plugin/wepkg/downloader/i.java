package com.tencent.mm.plugin.wepkg.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class i {
    private static int kNC = -1;
    private static a uWA;

    static class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(63453);
            if (!g.RK() || com.tencent.mm.kernel.a.QT()) {
                ab.e("MicroMsg.Wepkg.WepkgAutoDownloader", "acc has not ready");
                AppMethodBeat.o(63453);
                return;
            }
            int netType = at.getNetType(ah.getContext());
            if (netType == i.kNC) {
                AppMethodBeat.o(63453);
                return;
            }
            i.kNC = netType;
            ab.i("MicroMsg.Wepkg.WepkgAutoDownloader", "onNetStateChange, netState = ".concat(String.valueOf(netType)));
            if (netType == 0) {
                boolean Ni = com.tencent.mm.m.g.Nv().Ni();
                if (bo.fp(bo.c((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WEPKG_CHECK_DOWNLOAD_TIME_LONG, Long.valueOf(0)))) > 1800) {
                    netType = 1;
                } else {
                    netType = 0;
                }
                if (netType == 0) {
                    ab.i("MicroMsg.Wepkg.WepkgAutoDownloader", "dont auto download in wifi, because from the last time is not enough for %s s", Long.valueOf(1800));
                }
                if (!(Ni || netType == 0)) {
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WEPKG_CHECK_DOWNLOAD_TIME_LONG, Long.valueOf(bo.anT()));
                    vv vvVar = new vv();
                    vvVar.cSX.cuy = 0;
                    com.tencent.mm.sdk.b.a.xxA.m(vvVar);
                }
                AppMethodBeat.o(63453);
                return;
            }
            d dgw = d.dgw();
            if (dgw.uVY == null || dgw.uVY.size() == 0) {
                AppMethodBeat.o(63453);
                return;
            }
            c cVar;
            Collection<c> values = dgw.uVY.values();
            ArrayList arrayList = new ArrayList();
            for (c cVar2 : values) {
                arrayList.add(cVar2);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                cVar2 = (c) it.next();
                if (cVar2.uVO.uWt) {
                    dgw.a(cVar2);
                }
            }
            arrayList.clear();
            AppMethodBeat.o(63453);
        }
    }

    public static void bie() {
        AppMethodBeat.i(63454);
        if (uWA == null) {
            uWA = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            ah.getContext().registerReceiver(uWA, intentFilter);
        } catch (Exception e) {
        }
        ab.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader startListen");
        AppMethodBeat.o(63454);
    }

    public static void bgr() {
        AppMethodBeat.i(63455);
        if (uWA != null) {
            try {
                ah.getContext().unregisterReceiver(uWA);
            } catch (Exception e) {
            }
        }
        uWA = null;
        ab.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader stopListen");
        AppMethodBeat.o(63455);
    }
}
