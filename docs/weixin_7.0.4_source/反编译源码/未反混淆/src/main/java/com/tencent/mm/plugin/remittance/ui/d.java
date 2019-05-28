package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.a.a;
import com.tencent.mm.plugin.remittance.model.NetSceneTenpayRemittanceQuery.ResendMsgInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.c;

public final class d {
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public final void a(ResendMsgInfo resendMsgInfo, final c cVar) {
        AppMethodBeat.i(44817);
        if (resendMsgInfo == null) {
            ab.i("MicroMsg.RemindCollectionDialog", "init() resendMsgInfo == null");
            AppMethodBeat.o(44817);
            return;
        }
        View inflate = View.inflate(this.mContext, R.layout.ao9, null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.dyh);
        MMNeat7extView mMNeat7extView = (MMNeat7extView) inflate.findViewById(R.id.m5);
        a ahv = a.ahv();
        String str = resendMsgInfo.pQx;
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.ePT = R.drawable.bfv;
        ahv.a(str, imageView, aVar.ahG());
        mMNeat7extView.ah(resendMsgInfo.description);
        e.a aVar2 = new e.a(this.mContext);
        e.a fo = aVar2.al(resendMsgInfo.title).fo(inflate);
        fo.zQK = resendMsgInfo.nZb;
        fo.zQJ = resendMsgInfo.nZc;
        aVar2.c(new c() {
            public final void d(boolean z, String str) {
                AppMethodBeat.i(44816);
                ab.i("MicroMsg.RemindCollectionDialog", "onDialogClick() bOk:%s", Boolean.valueOf(z));
                if (cVar != null) {
                    cVar.d(z, str);
                }
                AppMethodBeat.o(44816);
            }
        }).show();
        AppMethodBeat.o(44817);
    }
}
