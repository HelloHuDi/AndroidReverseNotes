package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.os.Bundle;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C40808ai.C23819b;
import com.tencent.p177mm.p612ui.chatting.viewitems.C40808ai.C30585a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p707ba.C37504a;
import com.tencent.p177mm.p707ba.C41787r;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.aj */
final class C46666aj implements C30585a {
    C46666aj() {
    }

    /* renamed from: b */
    public final void mo27952b(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33282);
        C23819b c23819b = (C23819b) c5379a;
        c23819b.zgE.mo15921ah(c7620bi.field_content);
        Object bundle = new Bundle();
        bundle.putString("chatroom_name", c46650a.getTalkerUserName());
        bundle.putLong("msg_id", c7620bi.field_msgId);
        if ((c7620bi.field_flag & 8) != 0) {
            c23819b.zgE.mo15920a(C44089j.m79288a(c46650a.yTx.getContext(), c7620bi.field_content, (int) c23819b.zgE.getTextSize(), false, bundle), BufferType.SPANNABLE);
            c23819b.zgE.setClickable(true);
        } else {
            c23819b.zgE.mo15920a(C44089j.m79288a(c46650a.yTx.getContext(), c7620bi.field_content, (int) c23819b.zgE.getTextSize(), true, bundle), BufferType.SPANNABLE);
        }
        C37504a sU = C41787r.aiy().mo73165sU(c46650a.getTalkerUserName());
        C9638aw.m17190ZK();
        int intValue = ((Integer) C18628c.m29072Ry().get(12311, Integer.valueOf(-2))).intValue();
        if ((sU == null || sU.fLV == -2) && (sU != null || intValue == -2)) {
            c23819b.zgE.setTextColor(c46650a.yTx.getContext().getResources().getColor(C25738R.color.a2l));
            c23819b.zgE.setBackground(c46650a.yTx.getContext().getResources().getDrawable(C25738R.drawable.f6550hv));
        } else {
            c23819b.zgE.setTextColor(c46650a.yTx.getContext().getResources().getColor(C25738R.color.f11785h7));
            c23819b.zgE.setBackground(c46650a.yTx.getContext().getResources().getDrawable(C25738R.drawable.f6551hw));
        }
        c23819b.zgE.invalidate();
        AppMethodBeat.m2505o(33282);
    }
}
