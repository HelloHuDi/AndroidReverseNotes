package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C40808ai.C23819b;
import com.tencent.p177mm.p612ui.chatting.viewitems.C40808ai.C30585a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p707ba.C37504a;
import com.tencent.p177mm.p707ba.C41787r;
import com.tencent.p177mm.plugin.messenger.p993a.C12514e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.ak */
final class C40809ak implements C30585a {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ak$1 */
    class C408101 implements OnClickListener {
        C408101() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33283);
            C4990ab.m7410d("MicroMsg.ChattingItemNewXmlSysImpl", "hy: textview clicked");
            AppMethodBeat.m2505o(33283);
        }
    }

    C40809ak() {
    }

    /* renamed from: b */
    public final void mo27952b(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi) {
        String str;
        int i2;
        Bundle bundle;
        AppMethodBeat.m2504i(33284);
        String talkerUserName = c46650a.getTalkerUserName();
        C23819b c23819b = (C23819b) c5379a;
        Bundle bundle2 = new Bundle();
        bundle2.putString("conv_talker_username", talkerUserName);
        if (c46650a.yTx instanceof AppBrandServiceChattingFmUI) {
            str = "scene";
            i2 = 10;
            bundle = bundle2;
        } else if (c46650a.dFx()) {
            str = "scene";
            i2 = 2;
            bundle = bundle2;
        } else {
            str = "scene";
            if (C1855t.m3913mZ(talkerUserName)) {
                i2 = 7;
                bundle = bundle2;
            } else {
                i2 = 1;
                bundle = bundle2;
            }
        }
        bundle.putInt(str, i2);
        bundle2.putLong("msg_id", c7620bi.field_msgId);
        bundle2.putLong("msg_sever_id", c7620bi.field_msgSvrId);
        bundle2.putString("send_msg_username", c7620bi.field_talker);
        bundle2.putString("local_session", c46650a.yTA);
        C12514e c12514e = (C12514e) C1720g.m3528K(C12514e.class);
        str = c7620bi.field_content;
        WeakReference weakReference = new WeakReference(c46650a.yTx.getContext());
        WeakReference weakReference2 = new WeakReference(c23819b.zgE);
        CharSequence a = c12514e.mo24437a(str, bundle2, weakReference);
        if (a == null || a.length() == 0) {
            c23819b.mRR.setVisibility(8);
        } else {
            c23819b.mRR.setVisibility(0);
            c23819b.zgE.mo15921ah(a);
        }
        C37504a sU = C41787r.aiy().mo73165sU(talkerUserName);
        C9638aw.m17190ZK();
        i2 = ((Integer) C18628c.m29072Ry().get(12311, Integer.valueOf(-2))).intValue();
        if ((sU == null || sU.fLV == -2) && (sU != null || i2 == -2)) {
            c23819b.zgE.setTextColor(c46650a.yTx.getContext().getResources().getColor(C25738R.color.a2l));
            c23819b.zgE.setBackground(c46650a.yTx.getContext().getResources().getDrawable(C25738R.drawable.f6550hv));
        } else {
            c23819b.zgE.setTextColor(c46650a.yTx.getContext().getResources().getColor(C25738R.color.f11785h7));
            c23819b.zgE.setBackground(c46650a.yTx.getContext().getResources().getDrawable(C25738R.drawable.f6551hw));
        }
        c23819b.zgE.setOnClickListener(new C408101());
        c23819b.zgE.invalidate();
        AppMethodBeat.m2505o(33284);
    }
}
