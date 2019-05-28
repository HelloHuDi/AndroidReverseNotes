package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p230g.p231a.C18411uh;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p230g.p231a.C42062sz;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.C44318s.C23812e;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15614o;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.ar */
public final class C44336ar {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ar$d */
    public static class C15738d extends C30604a {
        /* renamed from: b */
        public final /* bridge */ /* synthetic */ String mo11017b(C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33414);
            String b = super.mo11017b(c46650a, c7620bi);
            AppMethodBeat.m2505o(33414);
            return b;
        }

        public final /* bridge */ /* synthetic */ boolean dHk() {
            AppMethodBeat.m2504i(33413);
            boolean dHk = super.dHk();
            AppMethodBeat.m2505o(33413);
            return dHk;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != 53) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33411);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969073);
                view.setTag(new C40813i().mo64361fe(view));
            }
            AppMethodBeat.m2505o(33411);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33412);
            C40813i.m70725a((C40813i) c5379a, c7620bi, true, i, c46650a, mo48995l(c46650a), mo11021c(c46650a));
            AppMethodBeat.m2505o(33412);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ar$e */
    public static class C15739e extends C23839b {
        public final /* bridge */ /* synthetic */ boolean dHk() {
            AppMethodBeat.m2504i(33417);
            boolean dHk = super.dHk();
            AppMethodBeat.m2505o(33417);
            return dHk;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && i == 53) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33415);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969109);
                view.setTag(new C40813i().mo64361fe(view));
            }
            AppMethodBeat.m2505o(33415);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33416);
            C40813i.m70725a((C40813i) c5379a, c7620bi, false, i, c46650a, mo39635l(c46650a), mo11021c(c46650a));
            AppMethodBeat.m2505o(33416);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ar$b */
    static abstract class C23839b extends C5378c {
        protected C44337h zhX;

        C23839b() {
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: l */
        public final C44337h mo39635l(C46650a c46650a) {
            if (this.zhX == null) {
                this.zhX = new C44337h(c46650a);
            }
            return this.zhX;
        }

        public boolean dHk() {
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ar$a */
    static abstract class C30604a extends C5378c {
        protected C44337h zhX;

        C30604a() {
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: l */
        public final C44337h mo48995l(C46650a c46650a) {
            if (this.zhX == null) {
                this.zhX = new C44337h(c46650a);
            }
            return this.zhX;
        }

        /* renamed from: b */
        public String mo11017b(C46650a c46650a, C7620bi c7620bi) {
            return c46650a.getTalkerUserName();
        }

        public boolean dHk() {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ar$c */
    public static class C31500c extends C30604a {
        /* renamed from: b */
        public final /* bridge */ /* synthetic */ String mo11017b(C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33410);
            String b = super.mo11017b(c46650a, c7620bi);
            AppMethodBeat.m2505o(33410);
            return b;
        }

        public final /* bridge */ /* synthetic */ boolean dHk() {
            AppMethodBeat.m2504i(33409);
            boolean dHk = super.dHk();
            AppMethodBeat.m2505o(33409);
            return dHk;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != 50) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33407);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969072);
                view.setTag(new C40813i().mo64361fe(view));
            }
            AppMethodBeat.m2505o(33407);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33408);
            C40813i.m70725a((C40813i) c5379a, c7620bi, true, i, c46650a, mo48995l(c46650a), mo11021c(c46650a));
            AppMethodBeat.m2505o(33408);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ar$f */
    public static class C40811f extends C5378c {
        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (i == 52) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33418);
            if (view == null || view.getTag() == null) {
                view = layoutInflater.inflate(2130969115, null);
                view.setTag(new C40813i().mo64361fe(view));
            }
            AppMethodBeat.m2505o(33418);
            return view;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean dHj() {
            return false;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33419);
            c5379a.enf.setVisibility(0);
            c5379a.enf.setText(C14835h.m23090p(c46650a.yTx.getContext(), c7620bi.field_createTime));
            AppMethodBeat.m2505o(33419);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean dHl() {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ar$g */
    public static class C40812g extends C23839b {
        public final /* bridge */ /* synthetic */ boolean dHk() {
            AppMethodBeat.m2504i(33422);
            boolean dHk = super.dHk();
            AppMethodBeat.m2505o(33422);
            return dHk;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && i == 50) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33420);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969108);
                view.setTag(new C40813i().mo64361fe(view));
            }
            AppMethodBeat.m2505o(33420);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33421);
            C40813i.m70725a((C40813i) c5379a, c7620bi, false, i, c46650a, mo39635l(c46650a), mo11021c(c46650a));
            AppMethodBeat.m2505o(33421);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean dHl() {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ar$i */
    static final class C40813i extends C5379a {
        TextView zfC;
        View zia = null;

        C40813i() {
        }

        /* renamed from: fe */
        public final C5379a mo64361fe(View view) {
            AppMethodBeat.m2504i(33428);
            super.mo11031eP(view);
            this.enf = (TextView) view.findViewById(2131820587);
            this.zfC = (TextView) view.findViewById(2131822631);
            this.jPL = view.findViewById(2131822515);
            this.zia = view.findViewById(2131822630);
            this.zby = (ImageView) view.findViewById(2131822629);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            AppMethodBeat.m2505o(33428);
            return this;
        }

        /* renamed from: a */
        public static void m70725a(C40813i c40813i, C7620bi c7620bi, boolean z, int i, C46650a c46650a, C44337h c44337h, OnLongClickListener onLongClickListener) {
            AppMethodBeat.m2504i(33429);
            if (c40813i == null) {
                AppMethodBeat.m2505o(33429);
                return;
            }
            if (c40813i.zby != null) {
                c40813i.zby.setVisibility(c7620bi.field_status == 6 ? 8 : 0);
            }
            c40813i.jPL.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, null, 0));
            c40813i.jPL.setOnClickListener(c44337h);
            c40813i.jPL.setOnLongClickListener(onLongClickListener);
            c40813i.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            String str = c7620bi.dqJ;
            if (!C5046bo.isNullOrNil(str)) {
                c40813i.zfC.setText(str);
            } else if (z) {
                c40813i.zfC.setText(C25738R.string.f41);
            } else {
                c40813i.zfC.setText(C25738R.string.f42);
            }
            if (c40813i.zia == null) {
                AppMethodBeat.m2505o(33429);
            } else if (c7620bi.field_content.equals(C7620bi.xZb) || C40813i.m70727kE(c7620bi.field_content)) {
                c40813i.zia.setBackgroundResource(C1318a.voip_voicecall);
                AppMethodBeat.m2505o(33429);
            } else {
                if (c7620bi.field_content.equals(C7620bi.xZc) || C40813i.m70726kD(c7620bi.field_content)) {
                    if (z) {
                        c40813i.zia.setBackgroundResource(C1318a.voip_videocall);
                        AppMethodBeat.m2505o(33429);
                        return;
                    }
                    c40813i.zia.setBackgroundResource(C1318a.voip_videocall_to);
                }
                AppMethodBeat.m2505o(33429);
            }
        }

        /* renamed from: kE */
        private static boolean m70727kE(String str) {
            AppMethodBeat.m2504i(33430);
            C26250ui c26250ui = new C26250ui();
            c26250ui.cQx.cAd = 1;
            c26250ui.cQx.content = str;
            C4879a.xxA.mo10055m(c26250ui);
            if (c26250ui.cQy.type == 3) {
                AppMethodBeat.m2505o(33430);
                return true;
            }
            AppMethodBeat.m2505o(33430);
            return false;
        }

        /* renamed from: kD */
        private static boolean m70726kD(String str) {
            AppMethodBeat.m2504i(33431);
            C26250ui c26250ui = new C26250ui();
            c26250ui.cQx.cAd = 1;
            c26250ui.cQx.content = str;
            C4879a.xxA.mo10055m(c26250ui);
            if (c26250ui.cQy.type == 2) {
                AppMethodBeat.m2505o(33431);
                return true;
            }
            AppMethodBeat.m2505o(33431);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ar$h */
    public static class C44337h extends C23812e {

        /* renamed from: com.tencent.mm.ui.chatting.viewitems.ar$h$2 */
        class C238412 implements OnClickListener {
            C238412() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(33424);
                dialogInterface.dismiss();
                AppMethodBeat.m2505o(33424);
            }
        }

        /* renamed from: a */
        static /* synthetic */ void m80140a(C44337h c44337h, C40814ay c40814ay) {
            AppMethodBeat.m2504i(33427);
            c44337h.m80141a(c40814ay);
            AppMethodBeat.m2505o(33427);
        }

        public C44337h(C46650a c46650a) {
            super(c46650a);
        }

        /* renamed from: a */
        public final void mo10992a(View view, C46650a c46650a, C7620bi c7620bi) {
            int i;
            AppMethodBeat.m2504i(33425);
            final C40814ay c40814ay = (C40814ay) view.getTag();
            String str = c7620bi.field_content;
            C26250ui c26250ui = new C26250ui();
            c26250ui.cQx.cAd = 1;
            c26250ui.cQx.content = str;
            C4879a.xxA.mo10055m(c26250ui);
            if (c26250ui.cQy.type == 2) {
                i = 1;
            } else {
                i = 0;
            }
            C18411uh c18411uh;
            if (i != 0 || c7620bi.field_content.equals(C7620bi.xZc)) {
                if (!C35973a.m59177bH(this.yJI.yTx.getContext())) {
                    c18411uh = new C18411uh();
                    C4879a.xxA.mo10055m(c18411uh);
                    if (c40814ay.cKd.field_talker.equals(c18411uh.cQt.talker) || !(c18411uh.cQt.cQv || c18411uh.cQt.cQw)) {
                        C42062sz c42062sz = new C42062sz();
                        c42062sz.cPf.cPh = true;
                        C4879a.xxA.mo10055m(c42062sz);
                        str = c42062sz.cPg.cPj;
                        if (C42252ah.isNullOrNil(str)) {
                            m80141a(c40814ay);
                        } else {
                            C4990ab.m7418v("MicroMsg.VoipClickListener", "Talkroom is on: ".concat(String.valueOf(str)));
                            C30379h.m48466d(this.yJI.yTx.getContext(), this.yJI.yTx.getContext().getString(C25738R.string.euf), "", this.yJI.yTx.getContext().getString(C25738R.string.f9187s6), this.yJI.yTx.getContext().getString(C25738R.string.f9076or), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(33423);
                                    C42062sz c42062sz = new C42062sz();
                                    c42062sz.cPf.cPi = true;
                                    C4879a.xxA.mo10055m(c42062sz);
                                    C44337h.m80140a(C44337h.this, c40814ay);
                                    dialogInterface.dismiss();
                                    AppMethodBeat.m2505o(33423);
                                }
                            }, new C238412());
                            AppMethodBeat.m2505o(33425);
                            return;
                        }
                    }
                    Toast.makeText(this.yJI.yTx.getContext(), c18411uh.cQt.cQu ? C25738R.string.ac6 : C25738R.string.ac7, 0).show();
                    C4990ab.m7416i("MicroMsg.VoipClickListener", "voip is running, can't do this");
                    AppMethodBeat.m2505o(33425);
                    return;
                }
                AppMethodBeat.m2505o(33425);
                return;
            }
            str = c7620bi.field_content;
            c26250ui = new C26250ui();
            c26250ui.cQx.cAd = 1;
            c26250ui.cQx.content = str;
            C4879a.xxA.mo10055m(c26250ui);
            if (c26250ui.cQy.type == 3) {
                i = 1;
            } else {
                i = 0;
            }
            if ((i != 0 || c7620bi.field_content.equals(C7620bi.xZb)) && !C35973a.m59177bH(this.yJI.yTx.getContext())) {
                c18411uh = new C18411uh();
                C4879a.xxA.mo10055m(c18411uh);
                if (c40814ay.cKd.field_talker.equals(c18411uh.cQt.talker) || !(c18411uh.cQt.cQv || c18411uh.cQt.cQw)) {
                    c40814ay.cKd.setStatus(6);
                    C9638aw.m17190ZK();
                    C18628c.m29080XO().mo15284a(c40814ay.cKd.field_msgId, c40814ay.cKd);
                    ((C15614o) this.yJI.mo74857aF(C15614o.class)).dEb();
                    C26250ui c26250ui2 = new C26250ui();
                    c26250ui2.cQx.cAd = 5;
                    c26250ui2.cQx.talker = c40814ay.cKd.field_talker;
                    c26250ui2.cQx.context = this.yJI.yTx.getContext();
                    c26250ui2.cQx.cQs = 4;
                    C4879a.xxA.mo10055m(c26250ui2);
                    C7060h c7060h = C7060h.pYm;
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(3);
                    objArr[1] = Integer.valueOf(2);
                    if (c40814ay.cKd.dqJ == null || c40814ay.cKd.dqJ.length() <= 0) {
                        i = 1;
                    } else {
                        i = 3;
                    }
                    objArr[2] = Integer.valueOf(i);
                    c7060h.mo8381e(11033, objArr);
                } else {
                    Toast.makeText(this.yJI.yTx.getContext(), c18411uh.cQt.cQu ? C25738R.string.ac6 : C25738R.string.ac7, 0).show();
                    C4990ab.m7416i("MicroMsg.VoipClickListener", "voip is running, can't do this");
                    AppMethodBeat.m2505o(33425);
                    return;
                }
            }
            AppMethodBeat.m2505o(33425);
        }

        /* renamed from: a */
        private void m80141a(C40814ay c40814ay) {
            int i;
            AppMethodBeat.m2504i(33426);
            c40814ay.cKd.setStatus(6);
            C9638aw.m17190ZK();
            C18628c.m29080XO().mo15284a(c40814ay.cKd.field_msgId, c40814ay.cKd);
            ((C15614o) this.yJI.mo74857aF(C15614o.class)).dEb();
            C26250ui c26250ui = new C26250ui();
            c26250ui.cQx.cAd = 5;
            c26250ui.cQx.talker = c40814ay.cKd.field_talker;
            c26250ui.cQx.context = this.yJI.yTx.getContext();
            c26250ui.cQx.cQs = 2;
            C4879a.xxA.mo10055m(c26250ui);
            C7060h c7060h = C7060h.pYm;
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(3);
            objArr[1] = Integer.valueOf(1);
            if (c40814ay.cKd.dqJ == null || c40814ay.cKd.dqJ.length() <= 0) {
                i = 1;
            } else {
                i = 3;
            }
            objArr[2] = Integer.valueOf(i);
            c7060h.mo8381e(11033, objArr);
            AppMethodBeat.m2505o(33426);
        }
    }
}
