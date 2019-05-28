package com.tencent.mm.plugin.wear.model.e;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.List;

public final class e extends a {
    public final List<Integer> cUA() {
        AppMethodBeat.i(26395);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_NO_DATA));
        arrayList.add(Integer.valueOf(11014));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_NO_NETWORK));
        AppMethodBeat.o(26395);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] p(int i, byte[] bArr) {
        AppMethodBeat.i(26396);
        switch (i) {
            case TXCStreamUploader.TXE_UPLOAD_ERROR_NO_DATA /*11013*/:
                a.xxA.m(new lh());
                break;
            case 11014:
                ArrayList bOC = ((j) g.K(j.class)).bOr().bOC();
                if (bOC.size() != 1) {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    intent.addFlags(536870912);
                    if (VERSION.SDK_INT < 16) {
                        intent.putExtra("resend_fail_messages", true);
                    }
                    intent.putExtra("From_fail_notify", true);
                    ab.d("MicroMsg.Wear.HttpFailMsgServer", "startMainUI");
                    d.f(ah.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
                    break;
                }
                String str = ((bi) bOC.get(0)).field_talker;
                Intent intent2 = new Intent();
                intent2.putExtra("Main_User", str);
                intent2.putExtra("From_fail_notify", true);
                intent2.addFlags(67108864);
                intent2.addFlags(536870912);
                if (VERSION.SDK_INT < 16) {
                    intent2.putExtra("resend_fail_messages", true);
                }
                ab.d("MicroMsg.Wear.HttpFailMsgServer", "startChattingUI talker=%s", str);
                d.f(ah.getContext(), "com.tencent.mm.ui.LauncherUI", intent2);
                break;
            case TXCStreamUploader.TXE_UPLOAD_ERROR_NO_NETWORK /*11015*/:
                a.xxA.m(new ot());
                break;
        }
        AppMethodBeat.o(26396);
        return null;
    }
}
