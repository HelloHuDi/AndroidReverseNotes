package com.tencent.p177mm.plugin.freewifi.p974e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.freewifi.model.C45959f.C11971b;
import com.tencent.p177mm.plugin.freewifi.model.C45959f.C45958a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.freewifi.e.c */
public final class C45952c {

    /* renamed from: com.tencent.mm.plugin.freewifi.e.c$1 */
    public static class C391041 implements C1202f {
        final /* synthetic */ int mwA = 3;
        final /* synthetic */ String mwB;
        final /* synthetic */ C11971b mwC;

        public C391041(String str, C11971b c11971b) {
            this.mwB = str;
            this.mwC = c11971b;
        }

        /* JADX WARNING: Missing block: B:12:0x0056, code skipped:
            r1 = ((com.tencent.p177mm.plugin.freewifi.p416d.C20781g) r13).bzm();
            r4 = new java.lang.Object[3];
            r4[1] = java.lang.Integer.valueOf(r0 + 1);
            r4[2] = r1;
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema.callback, desc=net request [GetInterruptedProtocol31] gets response. schemaUrl=%s", r4);
     */
        /* JADX WARNING: Missing block: B:13:0x007d, code skipped:
            if (com.tencent.p177mm.plugin.freewifi.C34189m.isEmpty(r1) != false) goto L_0x00da;
     */
        /* JADX WARNING: Missing block: B:14:0x007f, code skipped:
            r0 = java.util.regex.Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher(r1);
     */
        /* JADX WARNING: Missing block: B:15:0x008e, code skipped:
            if (r0.find() == false) goto L_0x00da;
     */
        /* JADX WARNING: Missing block: B:18:?, code skipped:
            r1 = java.net.URLDecoder.decode(r0.group(1), "utf8");
     */
        /* JADX WARNING: Missing block: B:19:0x009b, code skipped:
            r0 = r0.group(2);
            r2 = new android.content.Intent();
            r2.putExtra("free_wifi_ap_key", r1);
            r2.putExtra("free_wifi_source", 5);
            r2.putExtra("free_wifi_threeone_startup_type", 2);
            r2.putExtra("free_wifi_schema_ticket", r0);
            r2.putExtra("free_wifi_sessionkey", r0);
            r2.addFlags(268435456);
            r2.setClass(com.tencent.p177mm.sdk.platformtools.C4996ah.getContext(), com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiEntryUI.class);
            com.tencent.p177mm.plugin.freewifi.p974e.C39103b.bzr();
            com.tencent.p177mm.plugin.freewifi.p974e.C39103b.m66544aa(r2);
     */
        /* JADX WARNING: Missing block: B:20:0x00da, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(20803);
     */
        /* JADX WARNING: Missing block: B:25:0x00e9, code skipped:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:26:0x00ea, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=Exception happens when decoding apkey. schemaUrl=%s, apkey=%s, e.getMessage()=%s", r9.mwB, java.lang.Integer.valueOf(r6 + 1), r1, r2, r0.getMessage());
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(20803);
     */
        /* JADX WARNING: Missing block: B:51:?, code skipped:
            return;
     */
        /* JADX WARNING: Missing block: B:52:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(20803);
            r3 = new Object[5];
            int i3 = this.mwA + 1;
            r3[1] = Integer.valueOf(i3);
            r3[2] = Integer.valueOf(i);
            r3[3] = Integer.valueOf(i2);
            r3[4] = str;
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema.callback, desc=net request [GetInterruptedProtocol31] returns. errType=%d, errCode=%d, errMsg=%s", r3);
            if (i == 0 && i2 == 0) {
                synchronized (C45958a.mvN) {
                    try {
                        if (this.mwC != C45958a.mvN.byQ()) {
                        } else {
                            C45958a.mvN.byR();
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(20803);
                    }
                }
            } else if (i2 == -30020) {
                synchronized (C45958a.mvN) {
                    try {
                        if (this.mwC != C45958a.mvN.byQ()) {
                        } else {
                            C45958a.mvN.byR();
                            AppMethodBeat.m2505o(20803);
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(20803);
                    }
                }
            } else {
                AppMethodBeat.m2505o(20803);
            }
        }
    }
}
