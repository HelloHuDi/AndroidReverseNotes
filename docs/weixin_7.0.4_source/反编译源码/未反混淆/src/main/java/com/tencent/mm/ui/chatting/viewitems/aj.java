package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ba.r;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.viewitems.c.a;

final class aj implements a {
    aj() {
    }

    public final void b(a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar) {
        AppMethodBeat.i(33282);
        b bVar = (b) aVar;
        bVar.zgE.ah(biVar.field_content);
        Object bundle = new Bundle();
        bundle.putString("chatroom_name", aVar2.getTalkerUserName());
        bundle.putLong("msg_id", biVar.field_msgId);
        if ((biVar.field_flag & 8) != 0) {
            bVar.zgE.a(j.a(aVar2.yTx.getContext(), biVar.field_content, (int) bVar.zgE.getTextSize(), false, bundle), BufferType.SPANNABLE);
            bVar.zgE.setClickable(true);
        } else {
            bVar.zgE.a(j.a(aVar2.yTx.getContext(), biVar.field_content, (int) bVar.zgE.getTextSize(), true, bundle), BufferType.SPANNABLE);
        }
        com.tencent.mm.ba.a sU = r.aiy().sU(aVar2.getTalkerUserName());
        aw.ZK();
        int intValue = ((Integer) c.Ry().get(12311, Integer.valueOf(-2))).intValue();
        if ((sU == null || sU.fLV == -2) && (sU != null || intValue == -2)) {
            bVar.zgE.setTextColor(aVar2.yTx.getContext().getResources().getColor(R.color.a2l));
            bVar.zgE.setBackground(aVar2.yTx.getContext().getResources().getDrawable(R.drawable.hv));
        } else {
            bVar.zgE.setTextColor(aVar2.yTx.getContext().getResources().getColor(R.color.h7));
            bVar.zgE.setBackground(aVar2.yTx.getContext().getResources().getDrawable(R.drawable.hw));
        }
        bVar.zgE.invalidate();
        AppMethodBeat.o(33282);
    }
}
