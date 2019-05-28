package com.tencent.p177mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.xweb.p685x5.sdk.C24544d;
import com.tencent.xweb.p685x5.sdk.C24544d.C24545a;

/* renamed from: com.tencent.mm.pluginsdk.model.u */
public final class C44067u {
    public static long vbI;

    /* renamed from: com.tencent.mm.pluginsdk.model.u$1 */
    public static class C300841 implements ValueCallback<Boolean> {
        final /* synthetic */ Context gAj;
        final /* synthetic */ String kvE;
        final /* synthetic */ String val$filePath;

        /* renamed from: com.tencent.mm.pluginsdk.model.u$1$1 */
        class C300851 implements C24545a {
            C300851() {
            }

            public final void onViewInitFinished(boolean z) {
                AppMethodBeat.m2504i(114656);
                C4990ab.m7417i("MicroMsg.TBSFileBrowseHelper", "tbs preInit callback, %b", Boolean.valueOf(z));
                if (z) {
                    C44067u.m79211hD(C300841.this.val$filePath, C300841.this.kvE);
                    AppMethodBeat.m2505o(114656);
                    return;
                }
                C44067u.m79210hC(C300841.this.val$filePath, C300841.this.kvE);
                AppMethodBeat.m2505o(114656);
            }
        }

        public C300841(String str, String str2, Context context) {
            this.val$filePath = str;
            this.kvE = str2;
            this.gAj = context;
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(114657);
            if (!((Boolean) obj).booleanValue()) {
                C44067u.m79210hC(this.val$filePath, this.kvE);
                AppMethodBeat.m2505o(114657);
            } else if (C24544d.isTbsCoreInited()) {
                C44067u.m79211hD(this.val$filePath, this.kvE);
                AppMethodBeat.m2505o(114657);
            } else {
                C4990ab.m7416i("MicroMsg.TBSFileBrowseHelper", "tbs preInit");
                C24544d.m38195a(this.gAj, new C300851());
                AppMethodBeat.m2505o(114657);
            }
        }
    }

    /* renamed from: hC */
    static /* synthetic */ void m79210hC(String str, String str2) {
        AppMethodBeat.m2504i(114658);
        Intent intent = new Intent();
        intent.setAction("MINIQB_OPEN_RET");
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        C4990ab.m7417i("MicroMsg.TBSFileBrowseHelper", "TBS MiniQB cannot open this file:%s", str);
        intent.putExtra("MINIQB_OPEN_RET_VAL", false);
        C4996ah.getContext().sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
        AppMethodBeat.m2505o(114658);
    }

    /* renamed from: hD */
    static /* synthetic */ void m79211hD(String str, String str2) {
        AppMethodBeat.m2504i(114659);
        Intent intent = new Intent();
        intent.setClassName(C4996ah.getContext(), "com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI");
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        intent.addFlags(268435456);
        C4996ah.getContext().startActivity(intent);
        AppMethodBeat.m2505o(114659);
    }
}
