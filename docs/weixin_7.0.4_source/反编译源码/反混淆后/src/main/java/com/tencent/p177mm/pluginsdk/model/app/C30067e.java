package com.tencent.p177mm.pluginsdk.model.app;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.pluginsdk.model.app.e */
public final class C30067e {
    private C7306ak handler;
    public Map<String, Integer> hoQ;
    public List<C40441r> qoT;
    public List<C40441r> vbN;
    private C7564ap vbO;

    /* renamed from: com.tencent.mm.pluginsdk.model.app.e$1 */
    class C300681 implements C5015a {
        C300681() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(79242);
            C30067e.this.hoQ.clear();
            AppMethodBeat.m2505o(79242);
            return false;
        }
    }

    public C30067e() {
        AppMethodBeat.m2504i(79244);
        this.vbN = null;
        this.qoT = null;
        this.hoQ = null;
        this.vbO = new C7564ap(new C300681(), false);
        this.handler = new C7306ak(C1720g.m3539RS().oAl.getLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(79243);
                C23247v c23247v = (C23247v) message.obj;
                C40441r c40441r = new C40441r(c23247v.appId, c23247v.fOZ);
                if (C30067e.this.vbN.contains(c40441r)) {
                    C30067e.this.vbN.remove(c40441r);
                    if (!C34832a.bYJ().mo56571e(c23247v.appId, c23247v.data, c23247v.fOZ)) {
                        C4990ab.m7412e("MicroMsg.AppIconService", "handleMessage, saveIcon fail");
                    }
                }
                while (C30067e.this.qoT.size() > 0) {
                    C40441r c40441r2 = (C40441r) C30067e.this.qoT.remove(0);
                    if (C30067e.this.mo48330a(c40441r2)) {
                        C30067e.this.vbN.add(c40441r2);
                        AppMethodBeat.m2505o(79243);
                        return;
                    }
                }
                AppMethodBeat.m2505o(79243);
            }
        };
        this.vbN = new ArrayList();
        this.qoT = new ArrayList();
        this.hoQ = new HashMap();
        this.vbO.mo16770ae(600000, 600000);
        AppMethodBeat.m2505o(79244);
    }

    /* renamed from: dW */
    public final void mo48331dW(String str, int i) {
        AppMethodBeat.m2504i(79245);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppIconService", "push fail, appId is null");
            AppMethodBeat.m2505o(79245);
            return;
        }
        C40441r c40441r = new C40441r(str, i);
        if (this.vbN.contains(c40441r)) {
            C4990ab.m7416i("MicroMsg.AppIconService", "push, appId = " + str + ", iconType = " + i + " already in running list");
            AppMethodBeat.m2505o(79245);
        } else if (this.vbN.size() >= 5) {
            C4990ab.m7416i("MicroMsg.AppIconService", "running list has reached the max count");
            if (!this.qoT.contains(c40441r)) {
                this.qoT.add(c40441r);
            }
            AppMethodBeat.m2505o(79245);
        } else {
            if (mo48330a(c40441r)) {
                this.vbN.add(c40441r);
            }
            AppMethodBeat.m2505o(79245);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo48330a(C40441r c40441r) {
        AppMethodBeat.m2504i(79246);
        if (c40441r == null) {
            C4990ab.m7412e("MicroMsg.AppIconService", "startDownload fail, geticoninfo is null");
            AppMethodBeat.m2505o(79246);
            return false;
        } else if (m47615b(c40441r)) {
            C40439f aiJ = C34832a.bYJ().aiJ(c40441r.appId);
            if (aiJ == null) {
                C4990ab.m7412e("MicroMsg.AppIconService", "push, appinfo does not exist, appId = " + c40441r.appId);
                AppMethodBeat.m2505o(79246);
                return false;
            }
            Object obj;
            switch (c40441r.fOZ) {
                case 1:
                    if (aiJ.field_appIconUrl != null && aiJ.field_appIconUrl.length() != 0) {
                        obj = aiJ.field_appIconUrl;
                        break;
                    }
                    C4990ab.m7412e("MicroMsg.AppIconService", "push, appIconUrl is null, appId = " + c40441r.appId);
                    AppMethodBeat.m2505o(79246);
                    return false;
                    break;
                case 2:
                    if (aiJ.field_appWatermarkUrl != null && aiJ.field_appWatermarkUrl.length() != 0) {
                        obj = aiJ.field_appWatermarkUrl;
                        break;
                    }
                    C4990ab.m7412e("MicroMsg.AppIconService", "push, appWatermarkUrl is null, appId = " + c40441r.appId);
                    AppMethodBeat.m2505o(79246);
                    return false;
                    break;
                case 3:
                    if (aiJ.dnh != null && aiJ.dnh.length() != 0) {
                        obj = aiJ.dnh;
                        break;
                    }
                    C4990ab.m7412e("MicroMsg.AppIconService", "push, appSuggestionIconUrl is null, appId = " + c40441r.appId);
                    AppMethodBeat.m2505o(79246);
                    return false;
                    break;
                case 4:
                    if (aiJ.dns != null && aiJ.dns.length() != 0) {
                        obj = aiJ.dns;
                        break;
                    }
                    C4990ab.m7412e("MicroMsg.AppIconService", "push, servicePanelIconUrl is null, appId = " + c40441r.appId);
                    AppMethodBeat.m2505o(79246);
                    return false;
                case 5:
                    if (aiJ.dnt != null && aiJ.dnt.length() != 0) {
                        obj = aiJ.dnt;
                        break;
                    }
                    C4990ab.m7412e("MicroMsg.AppIconService", "push, serviceListIconUrl is null, appId = " + c40441r.appId);
                    AppMethodBeat.m2505o(79246);
                    return false;
                default:
                    C4990ab.m7412e("MicroMsg.AppIconService", "push, unknown iconType = " + c40441r.fOZ);
                    AppMethodBeat.m2505o(79246);
                    return false;
            }
            C4990ab.m7416i("MicroMsg.AppIconService", "appIconUrl = ".concat(String.valueOf(obj)));
            C7305d.post(new C14886s(this.handler, c40441r.appId, c40441r.fOZ, obj), "AppIconService_getIcon");
            AppMethodBeat.m2505o(79246);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.AppIconService", "increaseCounter fail");
            AppMethodBeat.m2505o(79246);
            return false;
        }
    }

    /* renamed from: b */
    private boolean m47615b(C40441r c40441r) {
        AppMethodBeat.m2504i(79247);
        if (c40441r == null) {
            C4990ab.m7412e("MicroMsg.AppIconService", "increaseCounter fail, info is null");
            AppMethodBeat.m2505o(79247);
            return false;
        }
        Integer valueOf = Integer.valueOf(C5046bo.m7512a((Integer) this.hoQ.get(c40441r.toString()), 0));
        if (valueOf.intValue() >= 5) {
            C4990ab.m7412e("MicroMsg.AppIconService", "increaseCounter fail, has reached the max try count");
            AppMethodBeat.m2505o(79247);
            return false;
        }
        this.hoQ.put(c40441r.toString(), Integer.valueOf(valueOf.intValue() + 1));
        AppMethodBeat.m2505o(79247);
        return true;
    }
}
