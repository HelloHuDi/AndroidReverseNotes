package com.tencent.p177mm.plugin.appbrand.jsapi.h5_interact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C10048a;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.p177mm.plugin.appbrand.ipc.MMToClientEvent.C38244c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.p281b.C10136c.C10137a;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a */
public final class C41232a extends C38369p {
    private static final int CTRL_INDEX = 460;
    private static final String NAME = "onH5Data";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a$1 */
    static class C412331 implements C38244c {
        C412331() {
        }

        /* renamed from: bk */
        public final void mo22088bk(Object obj) {
            AppMethodBeat.m2504i(131085);
            if (obj instanceof SendDataToMiniProgramFromH5Event) {
                SendDataToMiniProgramFromH5Event sendDataToMiniProgramFromH5Event = (SendDataToMiniProgramFromH5Event) obj;
                String str = sendDataToMiniProgramFromH5Event.hJW;
                String str2 = sendDataToMiniProgramFromH5Event.data;
                int i = sendDataToMiniProgramFromH5Event.hJX;
                if (!C5046bo.isNullOrNil(str)) {
                    C41243o wI = C10048a.m17635wI(str);
                    if (wI == null || !wI.eMP) {
                        AppMethodBeat.m2505o(131085);
                        return;
                    }
                    try {
                        JSONObject put = new JSONObject().put("data", str2).put("webviewId", String.valueOf(i));
                        C41232a c41232a = new C41232a();
                        c41232a.mo61031i(wI.atK()).mo61027AL(put.toString());
                        c41232a.aCj();
                        AppMethodBeat.m2505o(131085);
                        return;
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.AppBrand.EventOnH5Data", "dispatch ex = %s", e);
                    }
                }
            }
            AppMethodBeat.m2505o(131085);
        }
    }

    /* renamed from: k */
    public static void m71771k(C41243o c41243o) {
        AppMethodBeat.m2504i(131087);
        String str = c41243o.mAppId;
        final C412331 c412331 = new C412331();
        MMToClientEvent.m75199a(str, c412331);
        c41243o.gNN.mo21486a(new C10137a() {
            /* renamed from: a */
            public final void mo6006a(String str, C45524b c45524b) {
                AppMethodBeat.m2504i(131086);
                if (c45524b == C45524b.DESTROYED) {
                    MMToClientEvent.m75200b(str, c412331);
                }
                AppMethodBeat.m2505o(131086);
            }
        });
        AppMethodBeat.m2505o(131087);
    }
}
