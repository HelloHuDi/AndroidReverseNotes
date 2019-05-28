package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.xweb.x5.sdk.d;
import com.tencent.xweb.x5.sdk.d.a;

public final class u {
    public static long vbI;

    /* renamed from: com.tencent.mm.pluginsdk.model.u$1 */
    public static class AnonymousClass1 implements ValueCallback<Boolean> {
        final /* synthetic */ Context gAj;
        final /* synthetic */ String kvE;
        final /* synthetic */ String val$filePath;

        public AnonymousClass1(String str, String str2, Context context) {
            this.val$filePath = str;
            this.kvE = str2;
            this.gAj = context;
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.i(114657);
            if (!((Boolean) obj).booleanValue()) {
                u.hC(this.val$filePath, this.kvE);
                AppMethodBeat.o(114657);
            } else if (d.isTbsCoreInited()) {
                u.hD(this.val$filePath, this.kvE);
                AppMethodBeat.o(114657);
            } else {
                ab.i("MicroMsg.TBSFileBrowseHelper", "tbs preInit");
                d.a(this.gAj, new a() {
                    public final void onViewInitFinished(boolean z) {
                        AppMethodBeat.i(114656);
                        ab.i("MicroMsg.TBSFileBrowseHelper", "tbs preInit callback, %b", Boolean.valueOf(z));
                        if (z) {
                            u.hD(AnonymousClass1.this.val$filePath, AnonymousClass1.this.kvE);
                            AppMethodBeat.o(114656);
                            return;
                        }
                        u.hC(AnonymousClass1.this.val$filePath, AnonymousClass1.this.kvE);
                        AppMethodBeat.o(114656);
                    }
                });
                AppMethodBeat.o(114657);
            }
        }
    }

    static /* synthetic */ void hC(String str, String str2) {
        AppMethodBeat.i(114658);
        Intent intent = new Intent();
        intent.setAction("MINIQB_OPEN_RET");
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        ab.i("MicroMsg.TBSFileBrowseHelper", "TBS MiniQB cannot open this file:%s", str);
        intent.putExtra("MINIQB_OPEN_RET_VAL", false);
        ah.getContext().sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
        AppMethodBeat.o(114658);
    }

    static /* synthetic */ void hD(String str, String str2) {
        AppMethodBeat.i(114659);
        Intent intent = new Intent();
        intent.setClassName(ah.getContext(), "com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI");
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        intent.addFlags(268435456);
        ah.getContext().startActivity(intent);
        AppMethodBeat.o(114659);
    }
}
