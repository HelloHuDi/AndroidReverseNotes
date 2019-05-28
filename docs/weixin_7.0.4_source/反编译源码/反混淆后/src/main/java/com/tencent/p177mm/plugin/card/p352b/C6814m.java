package com.tencent.p177mm.plugin.card.p352b;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.card.model.C45787v;
import com.tencent.p177mm.protocal.protobuf.C23422od;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.card.b.m */
public final class C6814m implements C1202f, C42206a {
    private C7306ak handler;
    public Map<String, Set<C6815a>> kbO = new HashMap();
    public HashMap<String, String> kbP = new HashMap();
    private String kbQ;
    public C45787v kbR;

    /* renamed from: com.tencent.mm.plugin.card.b.m$a */
    public interface C6815a {
        /* renamed from: a */
        void mo15085a(boolean z, ArrayList<C23422od> arrayList);
    }

    public C6814m() {
        AppMethodBeat.m2504i(87760);
        C1720g.m3535RO().eJo.mo14539a(563, (C1202f) this);
        this.handler = new C7306ak(Looper.getMainLooper());
        AppMethodBeat.m2505o(87760);
    }

    /* renamed from: a */
    public final void mo15083a(String str, C6815a c6815a) {
        AppMethodBeat.m2504i(87761);
        synchronized (this.kbO) {
            try {
                if (this.kbO.get(str) != null) {
                    ((Set) this.kbO.get(str)).remove(c6815a);
                }
            } catch (Exception e) {
            }
            try {
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(87761);
            }
        }
        synchronized (this.kbP) {
            try {
                this.kbP.remove(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(87761);
                }
            }
        }
    }

    /* renamed from: a */
    private void m11257a(final String str, final boolean z, final ArrayList<C23422od> arrayList) {
        AppMethodBeat.m2504i(87762);
        this.handler.post(new Runnable() {
            public final void run() {
                Set set;
                AppMethodBeat.m2504i(87759);
                synchronized (C6814m.this.kbO) {
                    try {
                        set = (Set) C6814m.this.kbO.get(str);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(87759);
                        }
                    }
                }
                if (set != null && set.size() > 0) {
                    HashSet<C6815a> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (C6815a c6815a : hashSet) {
                        if (c6815a != null) {
                            c6815a.mo15085a(z, arrayList);
                        }
                    }
                }
                AppMethodBeat.m2505o(87759);
            }
        });
        AppMethodBeat.m2505o(87762);
    }

    /* renamed from: a */
    public final boolean mo15084a(String str, String str2, C6815a c6815a) {
        int i;
        AppMethodBeat.m2504i(87763);
        C4990ab.m7411d("MicroMsg.CardShopLBSManager", "getShopList, cardTpId = %s, card_id = %s", str, str2);
        this.kbQ = str;
        synchronized (this.kbO) {
            try {
                if (!this.kbO.containsKey(str)) {
                    this.kbO.put(str, new HashSet());
                }
                if (!((Set) this.kbO.get(str)).contains(c6815a)) {
                    ((Set) this.kbO.get(str)).add(c6815a);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(87763);
            }
        }
        synchronized (this.kbP) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    this.kbP.put(str, str2);
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(87763);
                }
            }
        }
        C26443d agz = C26443d.agz();
        if (agz == null) {
            C4990ab.m7412e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
            i = 0;
        } else {
            agz.mo44206b(this);
            i = 1;
        }
        if (i == 0) {
            boolean z = "MicroMsg.CardShopLBSManager";
            C4990ab.m7412e(z, "getShopList fail, get IGetLocation fail, plugin no loaded?");
            return z;
        }
        if (this.kbR != null) {
            C1720g.m3535RO().eJo.mo14547c(this.kbR);
        }
        AppMethodBeat.m2505o(87763);
        return true;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(87764);
        this.kbR = null;
        String str2 = ((C45787v) c1207m).kea;
        C4990ab.m7417i("MicroMsg.CardShopLBSManager", "onSceneEnd, reqCardTpId = %s, errType = %d, errCode = %d", str2, Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            ArrayList arrayList = ((C45787v) c1207m).keb;
            String str3 = "MicroMsg.CardShopLBSManager";
            String str4 = "onSceneEnd, respShopList size = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
            C4990ab.m7411d(str3, str4, objArr);
            m11257a(str2, true, arrayList);
            AppMethodBeat.m2505o(87764);
            return;
        }
        C4990ab.m7412e("MicroMsg.CardShopLBSManager", "onSceneEnd, cardshoplbs fail");
        m11257a(str2, false, null);
        AppMethodBeat.m2505o(87764);
    }

    /* renamed from: a */
    public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        AppMethodBeat.m2504i(87765);
        if (z) {
            Set set;
            C26443d agz = C26443d.agz();
            if (agz != null) {
                agz.mo44208c(this);
            }
            C4990ab.m7411d("MicroMsg.CardShopLBSManager", "onGetLocation, fLongitude = %f, fLatitude = %f, locType = %d, speed = %f, accuracy = %f", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2));
            synchronized (this.kbO) {
                try {
                    set = (Set) this.kbO.get(this.kbQ);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(87765);
                    }
                }
            }
            if (set == null || set.size() == 0) {
                C4990ab.m7412e("MicroMsg.CardShopLBSManager", "onGetLocation, already cancelled, no need to doScene");
                AppMethodBeat.m2505o(87765);
                return false;
            }
            String str;
            synchronized (this.kbP) {
                try {
                    str = (String) this.kbP.get(this.kbQ);
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.m2505o(87765);
                    }
                }
            }
            C1207m c45787v = new C45787v(this.kbQ, f, f2, str);
            if (C1720g.m3535RO().eJo.mo14541a(c45787v, 0)) {
                this.kbR = c45787v;
            } else {
                C4990ab.m7412e("MicroMsg.CardShopLBSManager", "doScene fail, callback immediate");
                m11257a(this.kbQ, false, null);
            }
            AppMethodBeat.m2505o(87765);
            return true;
        }
        AppMethodBeat.m2505o(87765);
        return true;
    }
}
