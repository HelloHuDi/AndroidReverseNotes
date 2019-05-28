package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ba.r;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.viewitems.c.a;
import java.lang.ref.WeakReference;

final class ak implements a {
    ak() {
    }

    public final void b(a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar) {
        String str;
        int i2;
        Bundle bundle;
        AppMethodBeat.i(33284);
        String talkerUserName = aVar2.getTalkerUserName();
        b bVar = (b) aVar;
        Bundle bundle2 = new Bundle();
        bundle2.putString("conv_talker_username", talkerUserName);
        if (aVar2.yTx instanceof AppBrandServiceChattingFmUI) {
            str = "scene";
            i2 = 10;
            bundle = bundle2;
        } else if (aVar2.dFx()) {
            str = "scene";
            i2 = 2;
            bundle = bundle2;
        } else {
            str = "scene";
            if (t.mZ(talkerUserName)) {
                i2 = 7;
                bundle = bundle2;
            } else {
                i2 = 1;
                bundle = bundle2;
            }
        }
        bundle.putInt(str, i2);
        bundle2.putLong("msg_id", biVar.field_msgId);
        bundle2.putLong("msg_sever_id", biVar.field_msgSvrId);
        bundle2.putString("send_msg_username", biVar.field_talker);
        bundle2.putString("local_session", aVar2.yTA);
        e eVar = (e) g.K(e.class);
        str = biVar.field_content;
        WeakReference weakReference = new WeakReference(aVar2.yTx.getContext());
        WeakReference weakReference2 = new WeakReference(bVar.zgE);
        CharSequence a = eVar.a(str, bundle2, weakReference);
        if (a == null || a.length() == 0) {
            bVar.mRR.setVisibility(8);
        } else {
            bVar.mRR.setVisibility(0);
            bVar.zgE.ah(a);
        }
        com.tencent.mm.ba.a sU = r.aiy().sU(talkerUserName);
        aw.ZK();
        i2 = ((Integer) c.Ry().get(12311, Integer.valueOf(-2))).intValue();
        if ((sU == null || sU.fLV == -2) && (sU != null || i2 == -2)) {
            bVar.zgE.setTextColor(aVar2.yTx.getContext().getResources().getColor(R.color.a2l));
            bVar.zgE.setBackground(aVar2.yTx.getContext().getResources().getDrawable(R.drawable.hv));
        } else {
            bVar.zgE.setTextColor(aVar2.yTx.getContext().getResources().getColor(R.color.h7));
            bVar.zgE.setBackground(aVar2.yTx.getContext().getResources().getDrawable(R.drawable.hw));
        }
        bVar.zgE.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33283);
                ab.d("MicroMsg.ChattingItemNewXmlSysImpl", "hy: textview clicked");
                AppMethodBeat.o(33283);
            }
        });
        bVar.zgE.invalidate();
        AppMethodBeat.o(33284);
    }
}
