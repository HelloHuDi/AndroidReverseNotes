package com.tencent.p177mm.plugin.wear.model.p575e;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C37757lh;
import com.tencent.p177mm.p230g.p231a.C37779ot;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wear.model.e.e */
public final class C14410e extends C46394a {
    public final List<Integer> cUA() {
        AppMethodBeat.m2504i(26395);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_NO_DATA));
        arrayList.add(Integer.valueOf(11014));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_NO_NETWORK));
        AppMethodBeat.m2505o(26395);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: p */
    public final byte[] mo9572p(int i, byte[] bArr) {
        AppMethodBeat.m2504i(26396);
        switch (i) {
            case TXCStreamUploader.TXE_UPLOAD_ERROR_NO_DATA /*11013*/:
                C4879a.xxA.mo10055m(new C37757lh());
                break;
            case 11014:
                ArrayList bOC = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().bOC();
                if (bOC.size() != 1) {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    intent.addFlags(536870912);
                    if (VERSION.SDK_INT < 16) {
                        intent.putExtra("resend_fail_messages", true);
                    }
                    intent.putExtra("From_fail_notify", true);
                    C4990ab.m7410d("MicroMsg.Wear.HttpFailMsgServer", "startMainUI");
                    C25985d.m41473f(C4996ah.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
                    break;
                }
                String str = ((C7620bi) bOC.get(0)).field_talker;
                Intent intent2 = new Intent();
                intent2.putExtra("Main_User", str);
                intent2.putExtra("From_fail_notify", true);
                intent2.addFlags(67108864);
                intent2.addFlags(536870912);
                if (VERSION.SDK_INT < 16) {
                    intent2.putExtra("resend_fail_messages", true);
                }
                C4990ab.m7411d("MicroMsg.Wear.HttpFailMsgServer", "startChattingUI talker=%s", str);
                C25985d.m41473f(C4996ah.getContext(), "com.tencent.mm.ui.LauncherUI", intent2);
                break;
            case TXCStreamUploader.TXE_UPLOAD_ERROR_NO_NETWORK /*11015*/:
                C4879a.xxA.mo10055m(new C37779ot());
                break;
        }
        AppMethodBeat.m2505o(26396);
        return null;
    }
}
