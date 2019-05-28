package com.tencent.p177mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.p1264c.C20780a;
import com.tencent.p177mm.plugin.freewifi.p1401f.C34186a;
import com.tencent.p177mm.plugin.freewifi.p416d.C39101d;
import com.tencent.p177mm.plugin.freewifi.p974e.C39103b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C30219rf;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.freewifi.model.e */
public final class C43113e {
    public String mvK = "";

    /* renamed from: com.tencent.mm.plugin.freewifi.model.e$1 */
    class C207981 implements C1202f {
        final /* synthetic */ C7254cm jEi;

        C207981(C7254cm c7254cm) {
            this.jEi = c7254cm;
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(20717);
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiMessageService", "desc=net request [NetSceneCheckIfCallUp] returns. errType=%d, errCode=%d, errMsg=%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (C34189m.m56074eg(i, i2)) {
                long j = ((C39101d) c1207m).bzk().vYv;
                if (j == 0) {
                    C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiMessageService", "It cannot get time from server.");
                    AppMethodBeat.m2505o(20717);
                    return;
                }
                C43113e c43113e = C43113e.this;
                C7254cm c7254cm = this.jEi;
                C30219rf bzk = ((C39101d) c1207m).bzk();
                if (c7254cm == null || c7254cm.vED == null) {
                    C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
                    AppMethodBeat.m2505o(20717);
                    return;
                }
                String a = C1946aa.m4148a(c7254cm.vED);
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", Long.valueOf(c7254cm.ptF), a);
                if (C34189m.isEmpty(a)) {
                    C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
                    AppMethodBeat.m2505o(20717);
                    return;
                }
                C20780a MB = C20780a.m32008MB(a);
                if (MB == null) {
                    C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
                    AppMethodBeat.m2505o(20717);
                    return;
                }
                int i3;
                Matcher matcher;
                C34186a c34186a = new C34186a();
                c34186a.mxo = MB.mvu;
                c34186a.mxq = MB.mvv;
                c34186a.mxp = MB.bssid;
                c34186a.mxu = MB.ssid;
                c34186a.mxy = MB.mvx;
                c34186a.mxs = MB.mvt;
                c34186a.mxr = MB.mvw;
                String Mz = C34189m.m56061Mz("MicroMsg.FreeWifi.FreeWifiMessageService");
                c34186a.cuI = Mz;
                if (Mz.equals(MB.mvt)) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                c34186a.mxt = i3;
                String Mx = C34189m.m56059Mx("MicroMsg.FreeWifi.FreeWifiMessageService");
                c34186a.mxv = Mx;
                if (Mx.equals(MB.ssid)) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                c34186a.mxw = i3;
                c34186a.mxx = j;
                c34186a.mxy = MB.mvx;
                int i4 = j > MB.mvx ? 1 : 0;
                if (i4 == 1) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                c34186a.mxz = i3;
                c34186a.mxD = bzk.vYm;
                c34186a.mxE = Mx;
                boolean equals = Mx.equals(bzk.vYm);
                if (equals) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                c34186a.mxF = i3;
                c34186a.mxA = 1;
                c34186a.mxB = bzk.vYu;
                String str2 = MB.mvw;
                if (!C34189m.isEmpty(str2)) {
                    matcher = Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher(str2);
                    if (matcher.find()) {
                        c34186a.mxC = matcher.group(2);
                    }
                }
                C43113e.m76647a(c34186a);
                if (!equals) {
                    C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiMessageService", "ssid has changed ! svr back ssid is not equal client ssid. ");
                    AppMethodBeat.m2505o(20717);
                    return;
                } else if (i4 != 0) {
                    C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiMessageService", "Msg time expired. return.");
                    AppMethodBeat.m2505o(20717);
                    return;
                } else {
                    if (bzk.vYu == 0 && !C34189m.isEmpty(str2)) {
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
                                if (!c43113e.mvK.equals(Mz)) {
                                    c43113e.mvK = Mz;
                                    C39103b.bzr();
                                    C39103b.m66544aa(intent);
                                }
                            } catch (UnsupportedEncodingException e) {
                                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiMessageService", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=Exception happens when decoding apkey. schemaUrl=%s, apkey=%s, e.getMessage()=%s", "", Integer.valueOf(0), str2, group, e.getMessage());
                                AppMethodBeat.m2505o(20717);
                                return;
                            }
                        }
                    }
                    AppMethodBeat.m2505o(20717);
                    return;
                }
            }
            C34186a c34186a2 = new C34186a();
            c34186a2.mxn = i2;
            c34186a2.mxm = i;
            C43113e.m76647a(c34186a2);
            AppMethodBeat.m2505o(20717);
        }
    }

    /* renamed from: a */
    static void m76647a(C34186a c34186a) {
        AppMethodBeat.m2504i(20718);
        C7060h.pYm.mo8381e(13493, Integer.valueOf(c34186a.mxm), Integer.valueOf(c34186a.mxn), C34189m.m56058Mw(c34186a.mxo), C34189m.m56058Mw(c34186a.mxp), Long.valueOf(c34186a.mxq), C34189m.m56058Mw(c34186a.mxr), C34189m.m56058Mw(c34186a.mxs), C34189m.m56058Mw(c34186a.cuI), Integer.valueOf(c34186a.mxt), C34189m.m56058Mw(c34186a.mxu), C34189m.m56058Mw(c34186a.mxv), Integer.valueOf(c34186a.mxw), Long.valueOf(c34186a.mxx), Long.valueOf(c34186a.mxy), Integer.valueOf(c34186a.mxz), Integer.valueOf(c34186a.mxA), Integer.valueOf(c34186a.mxB), C34189m.m56058Mw(c34186a.mxC), C34189m.m56058Mw(c34186a.mxD), C34189m.m56058Mw(c34186a.mxE), Integer.valueOf(c34186a.mxF));
        AppMethodBeat.m2505o(20718);
    }
}
