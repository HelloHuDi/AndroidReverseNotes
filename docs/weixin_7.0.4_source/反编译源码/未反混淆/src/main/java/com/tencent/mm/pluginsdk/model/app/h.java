package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class h implements f, b, t {
    Map<String, Integer> hoQ;
    private List<String> qoT;
    private List<String> vbN;
    private ap vbO;
    private List<String> vbY;
    private List<String> vbZ;
    private volatile boolean vca;

    public h() {
        AppMethodBeat.i(79300);
        this.vbN = null;
        this.qoT = null;
        this.hoQ = null;
        this.vca = false;
        this.vbO = new ap(Looper.getMainLooper(), new a() {
            public final boolean BI() {
                AppMethodBeat.i(79299);
                h.this.hoQ.clear();
                AppMethodBeat.o(79299);
                return false;
            }
        }, false);
        this.vbN = new ArrayList();
        this.qoT = new ArrayList();
        this.hoQ = new HashMap();
        this.vbY = new Vector();
        this.vbZ = new ArrayList();
        this.vbO.ae(600000, 600000);
        g.RO().eJo.a(231, (f) this);
        com.tencent.mm.plugin.s.a.bYM().a(7, (t) this);
        AppMethodBeat.o(79300);
    }

    public final String t(Context context, String str) {
        AppMethodBeat.i(79301);
        String t = g.t(context, str);
        AppMethodBeat.o(79301);
        return t;
    }

    public final void aC(LinkedList<String> linkedList) {
        AppMethodBeat.i(79302);
        if (linkedList == null || linkedList.size() == 0) {
            ab.e("MicroMsg.AppInfoService", "batch push appinfo err: null or nil applist");
            AppMethodBeat.o(79302);
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            Iz((String) it.next());
        }
        dhC();
        AppMethodBeat.o(79302);
    }

    private synchronized void Iz(String str) {
        AppMethodBeat.i(79303);
        if (bo.isNullOrNil(str) || this.vbY.contains(str)) {
            ab.i("MicroMsg.AppInfoService", "should not add this appid:[%s], it is already runing", str);
            AppMethodBeat.o(79303);
        } else if (aiI(str)) {
            ab.i("MicroMsg.AppInfoService", "add appid:[%s]", str);
            this.vbY.add(str);
            AppMethodBeat.o(79303);
        } else {
            ab.e("MicroMsg.AppInfoService", "this app has reach the max retry count, appid is %s", str);
            AppMethodBeat.o(79303);
        }
    }

    public final void aiH(String str) {
        AppMethodBeat.i(79304);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.AppInfoService", "push fail, appId is null");
            AppMethodBeat.o(79304);
            return;
        }
        ab.i("MicroMsg.AppInfoService", "push appid : ".concat(String.valueOf(str)));
        Iz(str);
        dhC();
        AppMethodBeat.o(79304);
    }

    private void dhC() {
        int i = 20;
        AppMethodBeat.i(79305);
        if (this.vca) {
            ab.d("MicroMsg.AppInfoService", " batch get appinfo doing now");
            AppMethodBeat.o(79305);
        } else if (this.vbY == null || this.vbY.isEmpty()) {
            ab.d("MicroMsg.AppInfoService", "batchwaitinglist is empty, no need to doscene");
            AppMethodBeat.o(79305);
        } else {
            int size = this.vbY.size();
            if (size <= 20) {
                i = size;
            }
            synchronized (this) {
                try {
                    this.vbZ.addAll(this.vbY.subList(0, i));
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(79305);
                    }
                }
            }
            if (!(this.vbZ == null || this.vbZ.isEmpty())) {
                this.vca = true;
                g.RO().eJo.a(new y(7, new ab(this.vbZ)), 0);
            }
            AppMethodBeat.o(79305);
        }
    }

    private boolean aiI(String str) {
        AppMethodBeat.i(79306);
        if (str == null) {
            ab.e("MicroMsg.AppInfoService", "increaseCounter fail, appId is null");
            AppMethodBeat.o(79306);
            return false;
        }
        Integer valueOf = Integer.valueOf(bo.a((Integer) this.hoQ.get(str), 0));
        if (valueOf.intValue() >= 5) {
            ab.e("MicroMsg.AppInfoService", "increaseCounter fail, has reached the max try count");
            AppMethodBeat.o(79306);
            return false;
        }
        this.hoQ.put(str, Integer.valueOf(valueOf.intValue() + 1));
        AppMethodBeat.o(79306);
        return true;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(79307);
        int type = mVar.getType();
        switch (type) {
            case 231:
                String str2 = ((aa) mVar).appId;
                if (this.vbN.contains(str2)) {
                    this.vbN.remove(str2);
                }
                while (this.qoT.size() > 0) {
                    int i3;
                    str2 = (String) this.qoT.remove(0);
                    if (str2 == null || str2.length() == 0) {
                        ab.e("MicroMsg.AppInfoService", "startDownload fail, appId is null");
                        i3 = 0;
                        continue;
                    } else if (aiI(str2)) {
                        g.RO().eJo.a(new aa(str2), 0);
                        i3 = 1;
                        continue;
                    } else {
                        ab.e("MicroMsg.AppInfoService", "increaseCounter fail");
                        i3 = 0;
                        continue;
                    }
                    if (i3 != 0) {
                        this.vbN.add(str2);
                        AppMethodBeat.o(79307);
                        return;
                    }
                }
                break;
            case 451:
                synchronized (this) {
                    try {
                        if (!(this.vbZ == null || this.vbZ.isEmpty())) {
                            this.vbY.removeAll(this.vbZ);
                            this.vbZ.clear();
                        }
                    } finally {
                        while (true) {
                            AppMethodBeat.o(79307);
                            break;
                        }
                    }
                }
                this.vca = false;
                dhC();
                return;
            default:
                ab.e("MicroMsg.AppInfoService", "error type: ".concat(String.valueOf(type)));
                break;
        }
        AppMethodBeat.o(79307);
    }

    public final void a(int i, int i2, String str, x xVar) {
        AppMethodBeat.i(79308);
        if (xVar.getType() != 7) {
            ab.d("MicroMsg.AppInfoService", "not the getappinfolist scene, ignore");
            AppMethodBeat.o(79308);
            return;
        }
        synchronized (this) {
            try {
                if (!(this.vbZ == null || this.vbZ.isEmpty())) {
                    this.vbY.removeAll(this.vbZ);
                    this.vbZ.clear();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(79308);
            }
        }
        this.vca = false;
        dhC();
    }
}
