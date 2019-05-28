package com.tencent.p177mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wear.model.C22742f.C22743a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.wear.model.g */
public final class C22745g {
    private static int tYj = 0;
    private HashMap<String, C22742f> tYk = new HashMap();

    public C22745g() {
        AppMethodBeat.m2504i(26332);
        AppMethodBeat.m2505o(26332);
    }

    public final synchronized C22742f adr(String str) {
        C22742f c22742f;
        AppMethodBeat.m2504i(26333);
        if (this.tYk.containsKey(str)) {
            c22742f = (C22742f) ((C22742f) this.tYk.get(str)).clone();
            AppMethodBeat.m2505o(26333);
        } else {
            tYj++;
            c22742f = new C22742f();
            c22742f.talker = str;
            c22742f.f4403id = tYj;
            c22742f.tYd = C22743a.INIT;
            this.tYk.put(str, c22742f);
            c22742f = (C22742f) c22742f.clone();
            AppMethodBeat.m2505o(26333);
        }
        return c22742f;
    }

    public final synchronized void ads(String str) {
        AppMethodBeat.m2504i(26334);
        C4990ab.m7417i("MicroMsg.Wear.WearNotificationMap", "reset notification talker=%s", str);
        if (this.tYk.containsKey(str)) {
            ((C22742f) this.tYk.get(str)).tYd = C22743a.INIT;
            ((C22742f) this.tYk.get(str)).tYc = 0;
        }
        AppMethodBeat.m2505o(26334);
    }

    /* renamed from: a */
    public final synchronized void mo38312a(C22742f c22742f) {
        AppMethodBeat.m2504i(26335);
        C4990ab.m7417i("MicroMsg.Wear.WearNotificationMap", "update notification=%s", c22742f);
        this.tYk.put(c22742f.talker, c22742f);
        AppMethodBeat.m2505o(26335);
    }

    public final synchronized void adt(String str) {
        AppMethodBeat.m2504i(26336);
        if (this.tYk.containsKey(str)) {
            C22742f c22742f = (C22742f) this.tYk.get(str);
            c22742f.tYd = C22743a.REPLY;
            c22742f.tYc = 0;
            C4990ab.m7417i("MicroMsg.Wear.WearNotificationMap", "Update reply success, notification=%s", c22742f);
        }
        AppMethodBeat.m2505o(26336);
    }

    /* renamed from: dv */
    public final synchronized void mo38317dv(String str, int i) {
        AppMethodBeat.m2504i(26337);
        if (this.tYk.containsKey(str)) {
            C22742f c22742f = (C22742f) this.tYk.get(str);
            c22742f.tYd = C22743a.IGNORE;
            c22742f.tYc = i;
            C4990ab.m7417i("MicroMsg.Wear.WearNotificationMap", "Update ignore success, notification=%s", c22742f);
        }
        AppMethodBeat.m2505o(26337);
    }

    public final synchronized void adu(String str) {
        AppMethodBeat.m2504i(26338);
        if (this.tYk.containsKey(str)) {
            ((C22742f) this.tYk.get(str)).tYd = C22743a.SHOWING;
            C4990ab.m7417i("MicroMsg.Wear.WearNotificationMap", "Update showing success, notification=%s", r0);
        }
        AppMethodBeat.m2505o(26338);
    }
}
