package com.tencent.mm.plugin.card.b;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class m implements f, com.tencent.mm.modelgeo.b.a {
    private ak handler;
    public Map<String, Set<a>> kbO = new HashMap();
    public HashMap<String, String> kbP = new HashMap();
    private String kbQ;
    public v kbR;

    public interface a {
        void a(boolean z, ArrayList<od> arrayList);
    }

    public m() {
        AppMethodBeat.i(87760);
        g.RO().eJo.a(563, (f) this);
        this.handler = new ak(Looper.getMainLooper());
        AppMethodBeat.o(87760);
    }

    public final void a(String str, a aVar) {
        AppMethodBeat.i(87761);
        synchronized (this.kbO) {
            try {
                if (this.kbO.get(str) != null) {
                    ((Set) this.kbO.get(str)).remove(aVar);
                }
            } catch (Exception e) {
            }
            try {
            } finally {
                while (true) {
                }
                AppMethodBeat.o(87761);
            }
        }
        synchronized (this.kbP) {
            try {
                this.kbP.remove(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(87761);
                }
            }
        }
    }

    private void a(final String str, final boolean z, final ArrayList<od> arrayList) {
        AppMethodBeat.i(87762);
        this.handler.post(new Runnable() {
            public final void run() {
                Set set;
                AppMethodBeat.i(87759);
                synchronized (m.this.kbO) {
                    try {
                        set = (Set) m.this.kbO.get(str);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(87759);
                        }
                    }
                }
                if (set != null && set.size() > 0) {
                    HashSet<a> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (a aVar : hashSet) {
                        if (aVar != null) {
                            aVar.a(z, arrayList);
                        }
                    }
                }
                AppMethodBeat.o(87759);
            }
        });
        AppMethodBeat.o(87762);
    }

    public final boolean a(String str, String str2, a aVar) {
        int i;
        AppMethodBeat.i(87763);
        ab.d("MicroMsg.CardShopLBSManager", "getShopList, cardTpId = %s, card_id = %s", str, str2);
        this.kbQ = str;
        synchronized (this.kbO) {
            try {
                if (!this.kbO.containsKey(str)) {
                    this.kbO.put(str, new HashSet());
                }
                if (!((Set) this.kbO.get(str)).contains(aVar)) {
                    ((Set) this.kbO.get(str)).add(aVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(87763);
            }
        }
        synchronized (this.kbP) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    this.kbP.put(str, str2);
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(87763);
                }
            }
        }
        d agz = d.agz();
        if (agz == null) {
            ab.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
            i = 0;
        } else {
            agz.b(this);
            i = 1;
        }
        if (i == 0) {
            boolean z = "MicroMsg.CardShopLBSManager";
            ab.e(z, "getShopList fail, get IGetLocation fail, plugin no loaded?");
            return z;
        }
        if (this.kbR != null) {
            g.RO().eJo.c(this.kbR);
        }
        AppMethodBeat.o(87763);
        return true;
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(87764);
        this.kbR = null;
        String str2 = ((v) mVar).kea;
        ab.i("MicroMsg.CardShopLBSManager", "onSceneEnd, reqCardTpId = %s, errType = %d, errCode = %d", str2, Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            ArrayList arrayList = ((v) mVar).keb;
            String str3 = "MicroMsg.CardShopLBSManager";
            String str4 = "onSceneEnd, respShopList size = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
            ab.d(str3, str4, objArr);
            a(str2, true, arrayList);
            AppMethodBeat.o(87764);
            return;
        }
        ab.e("MicroMsg.CardShopLBSManager", "onSceneEnd, cardshoplbs fail");
        a(str2, false, null);
        AppMethodBeat.o(87764);
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        AppMethodBeat.i(87765);
        if (z) {
            Set set;
            d agz = d.agz();
            if (agz != null) {
                agz.c(this);
            }
            ab.d("MicroMsg.CardShopLBSManager", "onGetLocation, fLongitude = %f, fLatitude = %f, locType = %d, speed = %f, accuracy = %f", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2));
            synchronized (this.kbO) {
                try {
                    set = (Set) this.kbO.get(this.kbQ);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(87765);
                    }
                }
            }
            if (set == null || set.size() == 0) {
                ab.e("MicroMsg.CardShopLBSManager", "onGetLocation, already cancelled, no need to doScene");
                AppMethodBeat.o(87765);
                return false;
            }
            String str;
            synchronized (this.kbP) {
                try {
                    str = (String) this.kbP.get(this.kbQ);
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.o(87765);
                    }
                }
            }
            com.tencent.mm.ai.m vVar = new v(this.kbQ, f, f2, str);
            if (g.RO().eJo.a(vVar, 0)) {
                this.kbR = vVar;
            } else {
                ab.e("MicroMsg.CardShopLBSManager", "doScene fail, callback immediate");
                a(this.kbQ, false, null);
            }
            AppMethodBeat.o(87765);
            return true;
        }
        AppMethodBeat.o(87765);
        return true;
    }
}
