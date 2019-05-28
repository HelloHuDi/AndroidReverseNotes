package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p200ay.C1304a;
import com.tencent.p177mm.p200ay.C1304a.C1303b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23732x;
import com.tencent.p177mm.p612ui.chatting.viewitems.C40808ai.C23819b;
import com.tencent.p177mm.p612ui.chatting.viewitems.C40808ai.C30585a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.widget.C5664a;
import com.tencent.p177mm.p707ba.C37504a;
import com.tencent.p177mm.p707ba.C41787r;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23322n;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.ag */
final class C15723ag implements C30585a {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ag$2 */
    class C157242 implements OnClickListener {
        C157242() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33269);
            C4990ab.m7410d("MicroMsg.ChattingItemNewXmlSysImpl", "clicked");
            AppMethodBeat.m2505o(33269);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ag$a */
    static class C15726a {
        public int end;
        public int start;
        public ClickableSpan zgl;

        C15726a() {
        }
    }

    C15723ag() {
    }

    /* renamed from: b */
    public final void mo27952b(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33270);
        final C23819b c23819b = (C23819b) c5379a;
        final C1303b c1303b = (C1303b) c46650a.mo74857aF(C23732x.class);
        int color = c23819b.zgE.getContext().getResources().getColor(C25738R.color.f12123t7);
        int color2 = c23819b.zgE.getContext().getResources().getColor(C25738R.color.f12124t8);
        final C1304a dtX = c7620bi.dtX();
        if (dtX == null) {
            c23819b.mRR.setVisibility(8);
        } else {
            int i2;
            CharSequence charSequence;
            c23819b.mRR.setVisibility(0);
            c23819b.zgE.mo15920a(C44089j.m79293b(c23819b.zgE.getContext(), C5046bo.nullAsNil(dtX.fKW), c23819b.zgE.getTextSize()), BufferType.SPANNABLE);
            Object charSequence2;
            if (dtX.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication") || dtX.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
                color = c23819b.zgE.getContext().getResources().getColor(C25738R.color.f11795hi);
                color2 = c23819b.zgE.getContext().getResources().getColor(C25738R.color.f11797hk);
                if (c7620bi.dtS()) {
                    color = c23819b.zgE.getContext().getResources().getColor(C25738R.color.f11795hi);
                    color2 = c23819b.zgE.getContext().getResources().getColor(C25738R.color.f11797hk);
                    charSequence2 = Factory.getInstance().newSpannable(c23819b.zgE.dPr());
                    i2 = 0;
                } else {
                    Spannable newSpannable = Factory.getInstance().newSpannable("    " + c23819b.zgE.dPr());
                    Drawable drawable = c23819b.zgE.getContext().getResources().getDrawable(C1318a.invite_sysmsg_icon);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    C5664a c5664a = new C5664a(drawable);
                    c5664a.zLT = (int) (((((float) drawable.getIntrinsicHeight()) - c23819b.zgE.getTextSize()) + ((float) C1338a.fromDPToPix(c23819b.zgE.getContext(), 2))) / 2.0f);
                    newSpannable.setSpan(c5664a, 0, 3, 33);
                    charSequence2 = newSpannable;
                    i2 = 4;
                }
            } else {
                charSequence2 = Factory.getInstance().newSpannable(c23819b.zgE.dPr());
                i2 = 0;
            }
            for (int i3 = 0; i3 < dtX.fKY.size(); i3++) {
                C15726a c15726a = new C15726a();
                final C7620bi c7620bi2 = c7620bi;
                final int i4 = i;
                c15726a.zgl = new C23322n(color, color2) {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(33268);
                        C4990ab.m7417i("MicroMsg.ChattingItemNewXmlSysImpl", "[onClick] pBaseNewXmlMsg:%s", dtX);
                        c1303b.mo4613a(c23819b.mRR, c7620bi2, dtX, i3);
                        AppMethodBeat.m2505o(33268);
                    }
                };
                c15726a.start = ((Integer) dtX.fKZ.get(i3)).intValue();
                c15726a.end = ((Integer) dtX.fLa.get(i3)).intValue();
                charSequence2.setSpan(c15726a.zgl, c15726a.start + i2, c15726a.end + i2, 18);
            }
            c23819b.zgE.mo15920a(charSequence2, BufferType.SPANNABLE);
            c23819b.zgE.setOnClickListener(new C157242());
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
        AppMethodBeat.m2505o(33270);
    }
}
