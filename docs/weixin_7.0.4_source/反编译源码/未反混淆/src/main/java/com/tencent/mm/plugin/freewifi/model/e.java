package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.freewifi.c.a;
import com.tencent.mm.plugin.freewifi.d.d;
import com.tencent.mm.plugin.freewifi.e.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.rf;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e {
    public String mvK = "";

    /* renamed from: com.tencent.mm.plugin.freewifi.model.e$1 */
    class AnonymousClass1 implements f {
        final /* synthetic */ cm jEi;

        AnonymousClass1(cm cmVar) {
            this.jEi = cmVar;
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(20717);
            ab.i("MicroMsg.FreeWifi.FreeWifiMessageService", "desc=net request [NetSceneCheckIfCallUp] returns. errType=%d, errCode=%d, errMsg=%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (com.tencent.mm.plugin.freewifi.m.eg(i, i2)) {
                long j = ((d) mVar).bzk().vYv;
                if (j == 0) {
                    ab.e("MicroMsg.FreeWifi.FreeWifiMessageService", "It cannot get time from server.");
                    AppMethodBeat.o(20717);
                    return;
                }
                e eVar = e.this;
                cm cmVar = this.jEi;
                rf bzk = ((d) mVar).bzk();
                if (cmVar == null || cmVar.vED == null) {
                    ab.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
                    AppMethodBeat.o(20717);
                    return;
                }
                String a = aa.a(cmVar.vED);
                ab.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", Long.valueOf(cmVar.ptF), a);
                if (com.tencent.mm.plugin.freewifi.m.isEmpty(a)) {
                    ab.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
                    AppMethodBeat.o(20717);
                    return;
                }
                a MB = a.MB(a);
                if (MB == null) {
                    ab.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
                    AppMethodBeat.o(20717);
                    return;
                }
                int i3;
                Matcher matcher;
                com.tencent.mm.plugin.freewifi.f.a aVar = new com.tencent.mm.plugin.freewifi.f.a();
                aVar.mxo = MB.mvu;
                aVar.mxq = MB.mvv;
                aVar.mxp = MB.bssid;
                aVar.mxu = MB.ssid;
                aVar.mxy = MB.mvx;
                aVar.mxs = MB.mvt;
                aVar.mxr = MB.mvw;
                String Mz = com.tencent.mm.plugin.freewifi.m.Mz("MicroMsg.FreeWifi.FreeWifiMessageService");
                aVar.cuI = Mz;
                if (Mz.equals(MB.mvt)) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                aVar.mxt = i3;
                String Mx = com.tencent.mm.plugin.freewifi.m.Mx("MicroMsg.FreeWifi.FreeWifiMessageService");
                aVar.mxv = Mx;
                if (Mx.equals(MB.ssid)) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                aVar.mxw = i3;
                aVar.mxx = j;
                aVar.mxy = MB.mvx;
                int i4 = j > MB.mvx ? 1 : 0;
                if (i4 == 1) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                aVar.mxz = i3;
                aVar.mxD = bzk.vYm;
                aVar.mxE = Mx;
                boolean equals = Mx.equals(bzk.vYm);
                if (equals) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                aVar.mxF = i3;
                aVar.mxA = 1;
                aVar.mxB = bzk.vYu;
                String str2 = MB.mvw;
                if (!com.tencent.mm.plugin.freewifi.m.isEmpty(str2)) {
                    matcher = Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher(str2);
                    if (matcher.find()) {
                        aVar.mxC = matcher.group(2);
                    }
                }
                e.a(aVar);
                if (!equals) {
                    ab.e("MicroMsg.FreeWifi.FreeWifiMessageService", "ssid has changed ! svr back ssid is not equal client ssid. ");
                    AppMethodBeat.o(20717);
                    return;
                } else if (i4 != 0) {
                    ab.e("MicroMsg.FreeWifi.FreeWifiMessageService", "Msg time expired. return.");
                    AppMethodBeat.o(20717);
                    return;
                } else {
                    if (bzk.vYu == 0 && !com.tencent.mm.plugin.freewifi.m.isEmpty(str2)) {
                        matcher = Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher(str2);
                        if (matcher.find()) {
                            Object group = matcher.group(1);
                            try {
                                a = URLDecoder.decode(group, "utf8");
                                Mz = matcher.group(2);
                                Intent intent = new Intent();
                                intent.putExtra("free_wifi_ap_key", a);
                                intent.putExtra("free_wifi_source", 5);
                                intent.putExtra("free_wifi_threeone_startup_type", 3);
                                intent.putExtra("free_wifi_schema_ticket", Mz);
                                intent.putExtra("free_wifi_sessionkey", Mz);
                                if (!eVar.mvK.equals(Mz)) {
                                    eVar.mvK = Mz;
                                    b.bzr();
                                    b.aa(intent);
                                }
                            } catch (UnsupportedEncodingException e) {
                                ab.i("MicroMsg.FreeWifi.FreeWifiMessageService", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=Exception happens when decoding apkey. schemaUrl=%s, apkey=%s, e.getMessage()=%s", "", Integer.valueOf(0), str2, group, e.getMessage());
                                AppMethodBeat.o(20717);
                                return;
                            }
                        }
                    }
                    AppMethodBeat.o(20717);
                    return;
                }
            }
            com.tencent.mm.plugin.freewifi.f.a aVar2 = new com.tencent.mm.plugin.freewifi.f.a();
            aVar2.mxn = i2;
            aVar2.mxm = i;
            e.a(aVar2);
            AppMethodBeat.o(20717);
        }
    }

    static void a(com.tencent.mm.plugin.freewifi.f.a aVar) {
        AppMethodBeat.i(20718);
        h.pYm.e(13493, Integer.valueOf(aVar.mxm), Integer.valueOf(aVar.mxn), com.tencent.mm.plugin.freewifi.m.Mw(aVar.mxo), com.tencent.mm.plugin.freewifi.m.Mw(aVar.mxp), Long.valueOf(aVar.mxq), com.tencent.mm.plugin.freewifi.m.Mw(aVar.mxr), com.tencent.mm.plugin.freewifi.m.Mw(aVar.mxs), com.tencent.mm.plugin.freewifi.m.Mw(aVar.cuI), Integer.valueOf(aVar.mxt), com.tencent.mm.plugin.freewifi.m.Mw(aVar.mxu), com.tencent.mm.plugin.freewifi.m.Mw(aVar.mxv), Integer.valueOf(aVar.mxw), Long.valueOf(aVar.mxx), Long.valueOf(aVar.mxy), Integer.valueOf(aVar.mxz), Integer.valueOf(aVar.mxA), Integer.valueOf(aVar.mxB), com.tencent.mm.plugin.freewifi.m.Mw(aVar.mxC), com.tencent.mm.plugin.freewifi.m.Mw(aVar.mxD), com.tencent.mm.plugin.freewifi.m.Mw(aVar.mxE), Integer.valueOf(aVar.mxF));
        AppMethodBeat.o(20718);
    }
}
