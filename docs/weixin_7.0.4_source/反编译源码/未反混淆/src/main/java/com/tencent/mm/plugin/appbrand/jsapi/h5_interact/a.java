package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class a extends p {
    private static final int CTRL_INDEX = 460;
    private static final String NAME = "onH5Data";

    public static void k(o oVar) {
        AppMethodBeat.i(131087);
        String str = oVar.mAppId;
        final AnonymousClass1 anonymousClass1 = new c() {
            public final void bk(Object obj) {
                AppMethodBeat.i(131085);
                if (obj instanceof SendDataToMiniProgramFromH5Event) {
                    SendDataToMiniProgramFromH5Event sendDataToMiniProgramFromH5Event = (SendDataToMiniProgramFromH5Event) obj;
                    String str = sendDataToMiniProgramFromH5Event.hJW;
                    String str2 = sendDataToMiniProgramFromH5Event.data;
                    int i = sendDataToMiniProgramFromH5Event.hJX;
                    if (!bo.isNullOrNil(str)) {
                        o wI = com.tencent.mm.plugin.appbrand.a.wI(str);
                        if (wI == null || !wI.eMP) {
                            AppMethodBeat.o(131085);
                            return;
                        }
                        try {
                            JSONObject put = new JSONObject().put("data", str2).put("webviewId", String.valueOf(i));
                            a aVar = new a();
                            aVar.i(wI.atK()).AL(put.toString());
                            aVar.aCj();
                            AppMethodBeat.o(131085);
                            return;
                        } catch (Exception e) {
                            ab.e("MicroMsg.AppBrand.EventOnH5Data", "dispatch ex = %s", e);
                        }
                    }
                }
                AppMethodBeat.o(131085);
            }
        };
        MMToClientEvent.a(str, anonymousClass1);
        oVar.gNN.a(new com.tencent.mm.plugin.appbrand.b.c.a() {
            public final void a(String str, b bVar) {
                AppMethodBeat.i(131086);
                if (bVar == b.DESTROYED) {
                    MMToClientEvent.b(str, anonymousClass1);
                }
                AppMethodBeat.o(131086);
            }
        });
        AppMethodBeat.o(131087);
    }
}
