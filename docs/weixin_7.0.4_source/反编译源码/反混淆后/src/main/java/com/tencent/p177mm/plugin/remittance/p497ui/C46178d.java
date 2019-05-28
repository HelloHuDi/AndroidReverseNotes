package com.tencent.p177mm.plugin.remittance.p497ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.plugin.remittance.model.NetSceneTenpayRemittanceQuery.ResendMsgInfo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.remittance.ui.d */
public final class C46178d {
    private Context mContext;

    public C46178d(Context context) {
        this.mContext = context;
    }

    /* renamed from: a */
    public final void mo74162a(ResendMsgInfo resendMsgInfo, final C5662c c5662c) {
        AppMethodBeat.m2504i(44817);
        if (resendMsgInfo == null) {
            C4990ab.m7416i("MicroMsg.RemindCollectionDialog", "init() resendMsgInfo == null");
            AppMethodBeat.m2505o(44817);
            return;
        }
        View inflate = View.inflate(this.mContext, 2130970503, null);
        ImageView imageView = (ImageView) inflate.findViewById(2131826962);
        MMNeat7extView mMNeat7extView = (MMNeat7extView) inflate.findViewById(2131821019);
        C25815a ahv = C25815a.ahv();
        String str = resendMsgInfo.pQx;
        C17927a c17927a = new C17927a();
        c17927a.ePT = C25738R.drawable.bfv;
        ahv.mo43766a(str, imageView, c17927a.ahG());
        mMNeat7extView.mo15921ah(resendMsgInfo.description);
        C5659a c5659a = new C5659a(this.mContext);
        C5659a fo = c5659a.mo11514al(resendMsgInfo.title).mo11524fo(inflate);
        fo.zQK = resendMsgInfo.nZb;
        fo.zQJ = resendMsgInfo.nZc;
        c5659a.mo11523c(new C5662c() {
            /* renamed from: d */
            public final void mo5699d(boolean z, String str) {
                AppMethodBeat.m2504i(44816);
                C4990ab.m7417i("MicroMsg.RemindCollectionDialog", "onDialogClick() bOk:%s", Boolean.valueOf(z));
                if (c5662c != null) {
                    c5662c.mo5699d(z, str);
                }
                AppMethodBeat.m2505o(44816);
            }
        }).show();
        AppMethodBeat.m2505o(44817);
    }
}
