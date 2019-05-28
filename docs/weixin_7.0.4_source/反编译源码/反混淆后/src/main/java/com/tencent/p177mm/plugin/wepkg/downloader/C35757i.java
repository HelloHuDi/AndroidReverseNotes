package com.tencent.p177mm.plugin.wepkg.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C9497vv;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.wepkg.downloader.i */
public final class C35757i {
    private static int kNC = -1;
    private static C23200a uWA;

    /* renamed from: com.tencent.mm.plugin.wepkg.downloader.i$a */
    static class C23200a extends BroadcastReceiver {
        private C23200a() {
        }

        /* synthetic */ C23200a(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(63453);
            if (!C1720g.m3531RK() || C1668a.m3393QT()) {
                C4990ab.m7412e("MicroMsg.Wepkg.WepkgAutoDownloader", "acc has not ready");
                AppMethodBeat.m2505o(63453);
                return;
            }
            int netType = C5023at.getNetType(C4996ah.getContext());
            if (netType == C35757i.kNC) {
                AppMethodBeat.m2505o(63453);
                return;
            }
            C35757i.kNC = netType;
            C4990ab.m7416i("MicroMsg.Wepkg.WepkgAutoDownloader", "onNetStateChange, netState = ".concat(String.valueOf(netType)));
            if (netType == 0) {
                boolean Ni = C26373g.m41965Nv().mo5296Ni();
                if (C5046bo.m7549fp(C5046bo.m7534c((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WEPKG_CHECK_DOWNLOAD_TIME_LONG, Long.valueOf(0)))) > 1800) {
                    netType = 1;
                } else {
                    netType = 0;
                }
                if (netType == 0) {
                    C4990ab.m7417i("MicroMsg.Wepkg.WepkgAutoDownloader", "dont auto download in wifi, because from the last time is not enough for %s s", Long.valueOf(1800));
                }
                if (!(Ni || netType == 0)) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WEPKG_CHECK_DOWNLOAD_TIME_LONG, Long.valueOf(C5046bo.anT()));
                    C9497vv c9497vv = new C9497vv();
                    c9497vv.cSX.cuy = 0;
                    C4879a.xxA.mo10055m(c9497vv);
                }
                AppMethodBeat.m2505o(63453);
                return;
            }
            C35755d dgw = C35755d.dgw();
            if (dgw.uVY == null || dgw.uVY.size() == 0) {
                AppMethodBeat.m2505o(63453);
                return;
            }
            C14800c c14800c;
            Collection<C14800c> values = dgw.uVY.values();
            ArrayList arrayList = new ArrayList();
            for (C14800c c14800c2 : values) {
                arrayList.add(c14800c2);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                c14800c2 = (C14800c) it.next();
                if (c14800c2.uVO.uWt) {
                    dgw.mo56538a(c14800c2);
                }
            }
            arrayList.clear();
            AppMethodBeat.m2505o(63453);
        }
    }

    public static void bie() {
        AppMethodBeat.m2504i(63454);
        if (uWA == null) {
            uWA = new C23200a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            C4996ah.getContext().registerReceiver(uWA, intentFilter);
        } catch (Exception e) {
        }
        C4990ab.m7416i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader startListen");
        AppMethodBeat.m2505o(63454);
    }

    public static void bgr() {
        AppMethodBeat.m2504i(63455);
        if (uWA != null) {
            try {
                C4996ah.getContext().unregisterReceiver(uWA);
            } catch (Exception e) {
            }
        }
        uWA = null;
        C4990ab.m7416i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader stopListen");
        AppMethodBeat.m2505o(63455);
    }
}
