package com.tencent.mm.pluginsdk.model.app;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e {
    private ak handler;
    public Map<String, Integer> hoQ;
    public List<r> qoT;
    public List<r> vbN;
    private ap vbO;

    public e() {
        AppMethodBeat.i(79244);
        this.vbN = null;
        this.qoT = null;
        this.hoQ = null;
        this.vbO = new ap(new a() {
            public final boolean BI() {
                AppMethodBeat.i(79242);
                e.this.hoQ.clear();
                AppMethodBeat.o(79242);
                return false;
            }
        }, false);
        this.handler = new ak(g.RS().oAl.getLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(79243);
                v vVar = (v) message.obj;
                r rVar = new r(vVar.appId, vVar.fOZ);
                if (e.this.vbN.contains(rVar)) {
                    e.this.vbN.remove(rVar);
                    if (!com.tencent.mm.plugin.s.a.bYJ().e(vVar.appId, vVar.data, vVar.fOZ)) {
                        ab.e("MicroMsg.AppIconService", "handleMessage, saveIcon fail");
                    }
                }
                while (e.this.qoT.size() > 0) {
                    r rVar2 = (r) e.this.qoT.remove(0);
                    if (e.this.a(rVar2)) {
                        e.this.vbN.add(rVar2);
                        AppMethodBeat.o(79243);
                        return;
                    }
                }
                AppMethodBeat.o(79243);
            }
        };
        this.vbN = new ArrayList();
        this.qoT = new ArrayList();
        this.hoQ = new HashMap();
        this.vbO.ae(600000, 600000);
        AppMethodBeat.o(79244);
    }

    public final void dW(String str, int i) {
        AppMethodBeat.i(79245);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.AppIconService", "push fail, appId is null");
            AppMethodBeat.o(79245);
            return;
        }
        r rVar = new r(str, i);
        if (this.vbN.contains(rVar)) {
            ab.i("MicroMsg.AppIconService", "push, appId = " + str + ", iconType = " + i + " already in running list");
            AppMethodBeat.o(79245);
        } else if (this.vbN.size() >= 5) {
            ab.i("MicroMsg.AppIconService", "running list has reached the max count");
            if (!this.qoT.contains(rVar)) {
                this.qoT.add(rVar);
            }
            AppMethodBeat.o(79245);
        } else {
            if (a(rVar)) {
                this.vbN.add(rVar);
            }
            AppMethodBeat.o(79245);
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean a(r rVar) {
        AppMethodBeat.i(79246);
        if (rVar == null) {
            ab.e("MicroMsg.AppIconService", "startDownload fail, geticoninfo is null");
            AppMethodBeat.o(79246);
            return false;
        } else if (b(rVar)) {
            f aiJ = com.tencent.mm.plugin.s.a.bYJ().aiJ(rVar.appId);
            if (aiJ == null) {
                ab.e("MicroMsg.AppIconService", "push, appinfo does not exist, appId = " + rVar.appId);
                AppMethodBeat.o(79246);
                return false;
            }
            Object obj;
            switch (rVar.fOZ) {
                case 1:
                    if (aiJ.field_appIconUrl != null && aiJ.field_appIconUrl.length() != 0) {
                        obj = aiJ.field_appIconUrl;
                        break;
                    }
                    ab.e("MicroMsg.AppIconService", "push, appIconUrl is null, appId = " + rVar.appId);
                    AppMethodBeat.o(79246);
                    return false;
                    break;
                case 2:
                    if (aiJ.field_appWatermarkUrl != null && aiJ.field_appWatermarkUrl.length() != 0) {
                        obj = aiJ.field_appWatermarkUrl;
                        break;
                    }
                    ab.e("MicroMsg.AppIconService", "push, appWatermarkUrl is null, appId = " + rVar.appId);
                    AppMethodBeat.o(79246);
                    return false;
                    break;
                case 3:
                    if (aiJ.dnh != null && aiJ.dnh.length() != 0) {
                        obj = aiJ.dnh;
                        break;
                    }
                    ab.e("MicroMsg.AppIconService", "push, appSuggestionIconUrl is null, appId = " + rVar.appId);
                    AppMethodBeat.o(79246);
                    return false;
                    break;
                case 4:
                    if (aiJ.dns != null && aiJ.dns.length() != 0) {
                        obj = aiJ.dns;
                        break;
                    }
                    ab.e("MicroMsg.AppIconService", "push, servicePanelIconUrl is null, appId = " + rVar.appId);
                    AppMethodBeat.o(79246);
                    return false;
                case 5:
                    if (aiJ.dnt != null && aiJ.dnt.length() != 0) {
                        obj = aiJ.dnt;
                        break;
                    }
                    ab.e("MicroMsg.AppIconService", "push, serviceListIconUrl is null, appId = " + rVar.appId);
                    AppMethodBeat.o(79246);
                    return false;
                default:
                    ab.e("MicroMsg.AppIconService", "push, unknown iconType = " + rVar.fOZ);
                    AppMethodBeat.o(79246);
                    return false;
            }
            ab.i("MicroMsg.AppIconService", "appIconUrl = ".concat(String.valueOf(obj)));
            d.post(new s(this.handler, rVar.appId, rVar.fOZ, obj), "AppIconService_getIcon");
            AppMethodBeat.o(79246);
            return true;
        } else {
            ab.e("MicroMsg.AppIconService", "increaseCounter fail");
            AppMethodBeat.o(79246);
            return false;
        }
    }

    private boolean b(r rVar) {
        AppMethodBeat.i(79247);
        if (rVar == null) {
            ab.e("MicroMsg.AppIconService", "increaseCounter fail, info is null");
            AppMethodBeat.o(79247);
            return false;
        }
        Integer valueOf = Integer.valueOf(bo.a((Integer) this.hoQ.get(rVar.toString()), 0));
        if (valueOf.intValue() >= 5) {
            ab.e("MicroMsg.AppIconService", "increaseCounter fail, has reached the max try count");
            AppMethodBeat.o(79247);
            return false;
        }
        this.hoQ.put(rVar.toString(), Integer.valueOf(valueOf.intValue() + 1));
        AppMethodBeat.o(79247);
        return true;
    }
}
