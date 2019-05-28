package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ay.a.b;
import com.tencent.mm.ba.r;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.x;

final class ag implements a {

    static class a {
        public int end;
        public int start;
        public ClickableSpan zgl;

        a() {
        }
    }

    ag() {
    }

    public final void b(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar) {
        AppMethodBeat.i(33270);
        final b bVar = (b) aVar;
        final b bVar2 = (b) aVar2.aF(x.class);
        int color = bVar.zgE.getContext().getResources().getColor(R.color.t7);
        int color2 = bVar.zgE.getContext().getResources().getColor(R.color.t8);
        final com.tencent.mm.ay.a dtX = biVar.dtX();
        if (dtX == null) {
            bVar.mRR.setVisibility(8);
        } else {
            int i2;
            CharSequence charSequence;
            bVar.mRR.setVisibility(0);
            bVar.zgE.a(j.b(bVar.zgE.getContext(), bo.nullAsNil(dtX.fKW), bVar.zgE.getTextSize()), BufferType.SPANNABLE);
            Object charSequence2;
            if (dtX.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication") || dtX.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
                color = bVar.zgE.getContext().getResources().getColor(R.color.hi);
                color2 = bVar.zgE.getContext().getResources().getColor(R.color.hk);
                if (biVar.dtS()) {
                    color = bVar.zgE.getContext().getResources().getColor(R.color.hi);
                    color2 = bVar.zgE.getContext().getResources().getColor(R.color.hk);
                    charSequence2 = Factory.getInstance().newSpannable(bVar.zgE.dPr());
                    i2 = 0;
                } else {
                    Spannable newSpannable = Factory.getInstance().newSpannable("    " + bVar.zgE.dPr());
                    Drawable drawable = bVar.zgE.getContext().getResources().getDrawable(R.raw.invite_sysmsg_icon);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    com.tencent.mm.ui.widget.a aVar3 = new com.tencent.mm.ui.widget.a(drawable);
                    aVar3.zLT = (int) (((((float) drawable.getIntrinsicHeight()) - bVar.zgE.getTextSize()) + ((float) com.tencent.mm.bz.a.fromDPToPix(bVar.zgE.getContext(), 2))) / 2.0f);
                    newSpannable.setSpan(aVar3, 0, 3, 33);
                    charSequence2 = newSpannable;
                    i2 = 4;
                }
            } else {
                charSequence2 = Factory.getInstance().newSpannable(bVar.zgE.dPr());
                i2 = 0;
            }
            for (int i3 = 0; i3 < dtX.fKY.size(); i3++) {
                a aVar4 = new a();
                final bi biVar2 = biVar;
                final int i4 = i;
                aVar4.zgl = new n(color, color2) {
                    public final void onClick(View view) {
                        AppMethodBeat.i(33268);
                        ab.i("MicroMsg.ChattingItemNewXmlSysImpl", "[onClick] pBaseNewXmlMsg:%s", dtX);
                        bVar2.a(bVar.mRR, biVar2, dtX, i3);
                        AppMethodBeat.o(33268);
                    }
                };
                aVar4.start = ((Integer) dtX.fKZ.get(i3)).intValue();
                aVar4.end = ((Integer) dtX.fLa.get(i3)).intValue();
                charSequence2.setSpan(aVar4.zgl, aVar4.start + i2, aVar4.end + i2, 18);
            }
            bVar.zgE.a(charSequence2, BufferType.SPANNABLE);
            bVar.zgE.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(33269);
                    ab.d("MicroMsg.ChattingItemNewXmlSysImpl", "clicked");
                    AppMethodBeat.o(33269);
                }
            });
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
        AppMethodBeat.o(33270);
    }
}
