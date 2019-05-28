package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C8909j;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.chatting.C44318s.C23812e;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15611aj;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.plugin.record.p492b.C43432e;
import com.tencent.p177mm.plugin.subapp.p1039c.C22335h;
import com.tencent.p177mm.plugin.subapp.p1039c.C43667k;
import com.tencent.p177mm.plugin.subapp.p1039c.C46291e;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.aq */
public final class C44334aq extends C5378c {
    private C1202f fQS;
    private C46650a yJI;
    private C44335a zhT;

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.aq$a */
    class C44335a extends C23812e {
        public C44335a(C46650a c46650a) {
            super(c46650a);
        }

        /* renamed from: a */
        public final void mo10992a(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33402);
            C40814ay c40814ay = (C40814ay) view.getTag();
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                ((C15611aj) this.yJI.mo74857aF(C15611aj.class)).dFm().mo58724a(c40814ay.position, c40814ay.cKd);
                AppMethodBeat.m2505o(33402);
                return;
            }
            C23639t.m36492hO(this.yJI.yTx.getContext());
            AppMethodBeat.m2505o(33402);
        }
    }

    public final boolean dHk() {
        return false;
    }

    /* renamed from: aH */
    public final boolean mo11016aH(int i, boolean z) {
        if (i == -1879048191) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final View mo11005a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.m2504i(33403);
        if (view == null || view.getTag() == null) {
            view = new C44341v(layoutInflater, 2130969114);
            view.setTag(new C36214bf().mo57093fl(view));
        }
        AppMethodBeat.m2505o(33403);
        return view;
    }

    /* renamed from: a */
    public final void mo11010a(C5379a c5379a, final int i, C46650a c46650a, final C7620bi c7620bi, String str) {
        AppMethodBeat.m2504i(33404);
        C36214bf c36214bf = (C36214bf) c5379a;
        this.yJI = c46650a;
        C8909j ma = C14877am.dhN().mo27204ma(c7620bi.field_msgId);
        String str2 = c7620bi.field_content;
        C8910b c8910b = null;
        if (!(ma == null || str2 == null)) {
            c8910b = C8910b.m16058X(str2, c7620bi.field_reserved);
        }
        if (c8910b != null) {
            c36214bf.gnC.setText(c8910b.description);
        }
        C4990ab.m7410d("MicroMsg.ChattingItemVoiceRemindSys", "content sys " + c7620bi.field_content);
        C46291e abk = C46291e.abk(str2);
        if (abk != null && abk.sta != null && abk.sta.length() > 0 && abk.stb > 0 && this.fQS == null && c8910b != null && C5046bo.isNullOrNil(c7620bi.field_imgPath)) {
            str2 = C43667k.m78198ug(C1853r.m3846Yz());
            String by = C22335h.m34031by(str2, false);
            c7620bi.mo14795jv(str2);
            C9638aw.m17190ZK();
            C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
            final String a = C4733l.m7094a(by, c7620bi.field_msgId, c8910b.sdkVer, c8910b.appId, abk.sta, abk.stb, c8910b.type, c8910b.fgs);
            if (a != null) {
                C6300p Rg = C9638aw.m17182Rg();
                C1202f c362091 = new C1202f() {
                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(33401);
                        C4990ab.m7410d("MicroMsg.ChattingItemVoiceRemindSys", "errType " + i + " errCode " + i2 + "  scene " + c1207m.getType());
                        boolean z = false;
                        if (C26417a.flx != null) {
                            z = C26417a.flx.mo44188fl(c7620bi.field_msgId);
                        }
                        if (!z && i == 0 && i2 == 0 && ((C43432e) c1207m).getMediaId().equals(a)) {
                            ((C15611aj) C44334aq.this.yJI.mo74857aF(C15611aj.class)).dFm().mo58724a(i, c7620bi);
                        }
                        C9638aw.m17182Rg().mo14546b(221, C44334aq.this.fQS);
                        C44334aq.this.fQS = null;
                        AppMethodBeat.m2505o(33401);
                    }
                };
                this.fQS = c362091;
                Rg.mo14539a(221, c362091);
                C1207m c43432e = new C43432e(a);
                c43432e.ceC();
                C9638aw.m17182Rg().mo14541a(c43432e, 0);
            }
        }
        c36214bf.gnC.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, null, 0));
        TextView textView = c36214bf.gnC;
        if (this.zhT == null) {
            this.zhT = new C44335a(this.yJI);
        }
        textView.setOnClickListener(this.zhT);
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable()) {
            c36214bf.gnC.setOnLongClickListener(mo11021c(c46650a));
        }
        AppMethodBeat.m2505o(33404);
    }

    /* renamed from: a */
    public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33405);
        int i = ((C40814ay) view.getTag()).position;
        if (!this.yJI.dFy()) {
            contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
        }
        AppMethodBeat.m2505o(33405);
        return true;
    }

    /* renamed from: a */
    public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33406);
        menuItem.getItemId();
        AppMethodBeat.m2505o(33406);
        return false;
    }

    /* renamed from: b */
    public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
        return true;
    }
}
