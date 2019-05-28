package com.tencent.p177mm.pluginsdk.model.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26408ad.C26409b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/* renamed from: com.tencent.mm.pluginsdk.model.app.h */
public final class C41337h implements C1202f, C26409b, C14887t {
    Map<String, Integer> hoQ;
    private List<String> qoT;
    private List<String> vbN;
    private C7564ap vbO;
    private List<String> vbY;
    private List<String> vbZ;
    private volatile boolean vca;

    /* renamed from: com.tencent.mm.pluginsdk.model.app.h$1 */
    class C232461 implements C5015a {
        C232461() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(79299);
            C41337h.this.hoQ.clear();
            AppMethodBeat.m2505o(79299);
            return false;
        }
    }

    public C41337h() {
        AppMethodBeat.m2504i(79300);
        this.vbN = null;
        this.qoT = null;
        this.hoQ = null;
        this.vca = false;
        this.vbO = new C7564ap(Looper.getMainLooper(), new C232461(), false);
        this.vbN = new ArrayList();
        this.qoT = new ArrayList();
        this.hoQ = new HashMap();
        this.vbY = new Vector();
        this.vbZ = new ArrayList();
        this.vbO.mo16770ae(600000, 600000);
        C1720g.m3535RO().eJo.mo14539a(231, (C1202f) this);
        C34832a.bYM().mo27202a(7, (C14887t) this);
        AppMethodBeat.m2505o(79300);
    }

    /* renamed from: t */
    public final String mo44181t(Context context, String str) {
        AppMethodBeat.m2504i(79301);
        String t = C46494g.m87756t(context, str);
        AppMethodBeat.m2505o(79301);
        return t;
    }

    /* renamed from: aC */
    public final void mo65992aC(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(79302);
        if (linkedList == null || linkedList.size() == 0) {
            C4990ab.m7412e("MicroMsg.AppInfoService", "batch push appinfo err: null or nil applist");
            AppMethodBeat.m2505o(79302);
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            m72095Iz((String) it.next());
        }
        dhC();
        AppMethodBeat.m2505o(79302);
    }

    /* renamed from: Iz */
    private synchronized void m72095Iz(String str) {
        AppMethodBeat.m2504i(79303);
        if (C5046bo.isNullOrNil(str) || this.vbY.contains(str)) {
            C4990ab.m7417i("MicroMsg.AppInfoService", "should not add this appid:[%s], it is already runing", str);
            AppMethodBeat.m2505o(79303);
        } else if (aiI(str)) {
            C4990ab.m7417i("MicroMsg.AppInfoService", "add appid:[%s]", str);
            this.vbY.add(str);
            AppMethodBeat.m2505o(79303);
        } else {
            C4990ab.m7413e("MicroMsg.AppInfoService", "this app has reach the max retry count, appid is %s", str);
            AppMethodBeat.m2505o(79303);
        }
    }

    public final void aiH(String str) {
        AppMethodBeat.m2504i(79304);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppInfoService", "push fail, appId is null");
            AppMethodBeat.m2505o(79304);
            return;
        }
        C4990ab.m7416i("MicroMsg.AppInfoService", "push appid : ".concat(String.valueOf(str)));
        m72095Iz(str);
        dhC();
        AppMethodBeat.m2505o(79304);
    }

    private void dhC() {
        int i = 20;
        AppMethodBeat.m2504i(79305);
        if (this.vca) {
            C4990ab.m7410d("MicroMsg.AppInfoService", " batch get appinfo doing now");
            AppMethodBeat.m2505o(79305);
        } else if (this.vbY == null || this.vbY.isEmpty()) {
            C4990ab.m7410d("MicroMsg.AppInfoService", "batchwaitinglist is empty, no need to doscene");
            AppMethodBeat.m2505o(79305);
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
                        AppMethodBeat.m2505o(79305);
                    }
                }
            }
            if (!(this.vbZ == null || this.vbZ.isEmpty())) {
                this.vca = true;
                C1720g.m3535RO().eJo.mo14541a(new C44061y(7, new C4730ab(this.vbZ)), 0);
            }
            AppMethodBeat.m2505o(79305);
        }
    }

    private boolean aiI(String str) {
        AppMethodBeat.m2504i(79306);
        if (str == null) {
            C4990ab.m7412e("MicroMsg.AppInfoService", "increaseCounter fail, appId is null");
            AppMethodBeat.m2505o(79306);
            return false;
        }
        Integer valueOf = Integer.valueOf(C5046bo.m7512a((Integer) this.hoQ.get(str), 0));
        if (valueOf.intValue() >= 5) {
            C4990ab.m7412e("MicroMsg.AppInfoService", "increaseCounter fail, has reached the max try count");
            AppMethodBeat.m2505o(79306);
            return false;
        }
        this.hoQ.put(str, Integer.valueOf(valueOf.intValue() + 1));
        AppMethodBeat.m2505o(79306);
        return true;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(79307);
        int type = c1207m.getType();
        switch (type) {
            case 231:
                String str2 = ((C7236aa) c1207m).appId;
                if (this.vbN.contains(str2)) {
                    this.vbN.remove(str2);
                }
                while (this.qoT.size() > 0) {
                    int i3;
                    str2 = (String) this.qoT.remove(0);
                    if (str2 == null || str2.length() == 0) {
                        C4990ab.m7412e("MicroMsg.AppInfoService", "startDownload fail, appId is null");
                        i3 = 0;
                        continue;
                    } else if (aiI(str2)) {
                        C1720g.m3535RO().eJo.mo14541a(new C7236aa(str2), 0);
                        i3 = 1;
                        continue;
                    } else {
                        C4990ab.m7412e("MicroMsg.AppInfoService", "increaseCounter fail");
                        i3 = 0;
                        continue;
                    }
                    if (i3 != 0) {
                        this.vbN.add(str2);
                        AppMethodBeat.m2505o(79307);
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
                            AppMethodBeat.m2505o(79307);
                            break;
                        }
                    }
                }
                this.vca = false;
                dhC();
                return;
            default:
                C4990ab.m7412e("MicroMsg.AppInfoService", "error type: ".concat(String.valueOf(type)));
                break;
        }
        AppMethodBeat.m2505o(79307);
    }

    /* renamed from: a */
    public final void mo9876a(int i, int i2, String str, C40442x c40442x) {
        AppMethodBeat.m2504i(79308);
        if (c40442x.getType() != 7) {
            C4990ab.m7410d("MicroMsg.AppInfoService", "not the getappinfolist scene, ignore");
            AppMethodBeat.m2505o(79308);
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
                AppMethodBeat.m2505o(79308);
            }
        }
        this.vca = false;
        dhC();
    }
}
