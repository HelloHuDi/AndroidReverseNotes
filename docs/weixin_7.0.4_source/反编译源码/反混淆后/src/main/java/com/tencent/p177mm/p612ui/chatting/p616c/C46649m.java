package com.tencent.p177mm.p612ui.chatting.p616c;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.p185a.C32232a;
import com.tencent.p177mm.p184aj.p185a.C37446b;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15614o;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23730ae;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23733z;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40725t;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40726v;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C43298a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.ChatFooter;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7617ak;

@C15590a(dFp = C23730ae.class)
/* renamed from: com.tencent.mm.ui.chatting.c.m */
public class C46649m extends C44291a implements C23730ae {
    private boolean yPq = false;
    private boolean yPr = false;
    private String yPs;
    private String yPt;
    private C36150a yPu = C36150a.hide;

    /* renamed from: com.tencent.mm.ui.chatting.c.m$a */
    enum C36150a {
        hide,
        show;

        static {
            AppMethodBeat.m2505o(31377);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(31378);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 212:
                if (intent != null) {
                    C15614o c15614o = (C15614o) this.cgL.mo74857aF(C15614o.class);
                    String stringExtra = intent.getStringExtra("select_raw_user_name");
                    String stringExtra2 = intent.getStringExtra("Select_Conv_User");
                    if (!C5046bo.isNullOrNil(stringExtra2)) {
                        C4990ab.m7411d("MicroMsg.ChattingUI.SearchComponent", "@ %s", stringExtra2);
                        c15614o.dDX().setAtSomebody(stringExtra2);
                        c15614o.dDX().mo63906ax(this.cgL.getTalkerUserName(), stringExtra, stringExtra2);
                        this.yPq = true;
                        break;
                    }
                    C4990ab.m7411d("MicroMsg.ChattingUI.SearchComponent", "@ %s", "[nobody]");
                    c15614o.dDX().setAtSomebody("");
                    this.yPq = false;
                    AppMethodBeat.m2505o(31378);
                    return;
                }
                break;
        }
        AppMethodBeat.m2505o(31378);
    }

    public final void dxz() {
    }

    public final void dxA() {
    }

    public final void dxC() {
    }

    public final void dDS() {
        AppMethodBeat.m2504i(31383);
        if (C5046bo.isNullOrNil(this.cgL.getTalkerUserName())) {
            AppMethodBeat.m2505o(31383);
            return;
        }
        C15614o c15614o = (C15614o) this.cgL.mo74857aF(C15614o.class);
        if (C5046bo.isNullOrNil(this.yPs) || c15614o.dDX() == null) {
            if (c15614o.dDX() != null) {
                if (((C40725t) this.cgL.mo74857aF(C40725t.class)).dEF()) {
                    c15614o.dDX().setLastText(this.yPs);
                    c15614o.dDX().setHint(this.cgL.yTx.getMMResources().getString(C25738R.string.ap2));
                    AppMethodBeat.m2505o(31383);
                    return;
                } else if (c15614o.dDX().getIsVoiceInputPanleShow()) {
                    c15614o.dEd();
                    AppMethodBeat.m2505o(31383);
                    return;
                } else {
                    dDT();
                }
            }
            AppMethodBeat.m2505o(31383);
            return;
        }
        boolean z = c15614o.dDX().getMode() == 1 && C5046bo.isNullOrNil(c15614o.dEa());
        boolean dEU = ((C23733z) this.cgL.mo74857aF(C23733z.class)).dEU();
        if (!z || dEU) {
            dDT();
        } else {
            dDU();
        }
        boolean dDn = ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDn();
        if ((this.cgL.dFw() || dDn) && this.yPq) {
            this.yPq = false;
            String atSomebody = c15614o.dDX().getAtSomebody();
            if (!C5046bo.isNullOrNil(atSomebody)) {
                int insertPos = c15614o.dDX().getInsertPos();
                if (insertPos > this.yPs.length()) {
                    insertPos = this.yPs.length();
                }
                StringBuilder append = new StringBuilder().append(this.yPs.substring(0, insertPos)).append(atSomebody).append(8197);
                String str = this.yPs;
                String stringBuilder = append.append(str.substring(insertPos, str.length())).toString();
                insertPos = (insertPos + atSomebody.length()) + 1;
                c15614o.dDX().setLastContent(stringBuilder);
                c15614o.dDX().mo63996u(stringBuilder, insertPos, false);
                c15614o.dDX().setAtSomebody(null);
                this.cgL.showVKB();
            }
        } else {
            c15614o.dDX().setLastContent(this.yPs);
            c15614o.dDX().setLastText(this.yPs);
            if (!(C5046bo.isNullOrNil(this.yPs) || dEU || !C5046bo.isNullOrNil(c15614o.dEa()))) {
                c15614o.dEh();
            }
        }
        c15614o.dEd();
        AppMethodBeat.m2505o(31383);
    }

    private void dDT() {
        AppMethodBeat.m2504i(31384);
        C15614o c15614o = (C15614o) this.cgL.mo74857aF(C15614o.class);
        if (c15614o.dDX() == null) {
            AppMethodBeat.m2505o(31384);
            return;
        }
        c15614o.dDX().mo63958oQ(this.yPu == C36150a.show);
        AppMethodBeat.m2505o(31384);
    }

    private void dDU() {
        AppMethodBeat.m2504i(31385);
        C15614o c15614o = (C15614o) this.cgL.mo74857aF(C15614o.class);
        if (c15614o.dDX() == null) {
            AppMethodBeat.m2505o(31385);
            return;
        }
        c15614o.dDX().dkz();
        AppMethodBeat.m2505o(31385);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(31379);
        if (keyEvent.getKeyCode() == 67) {
            C15614o c15614o = (C15614o) this.cgL.mo74857aF(C15614o.class);
            if (keyEvent.getAction() == 0) {
                if (c15614o.dDX().getCharAtCursor() == 8197) {
                    this.yPr = true;
                } else {
                    this.yPr = false;
                }
            }
            if (keyEvent.getAction() == 1 && this.yPr) {
                this.yPr = false;
                ChatFooter dDX = c15614o.dDX();
                int selectionStart = dDX.getSelectionStart();
                String substring = dDX.getLastText().substring(0, selectionStart);
                int lastIndexOf = substring.lastIndexOf(64);
                if (lastIndexOf < substring.length() && lastIndexOf >= 0) {
                    substring = substring.substring(0, lastIndexOf);
                    String substring2 = dDX.getLastText().substring(selectionStart);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(substring).append(substring2);
                    dDX.setLastText(stringBuilder.toString());
                    dDX.oij.setSelection(lastIndexOf);
                }
            }
        }
        AppMethodBeat.m2505o(31379);
        return false;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(31380);
        this.yPs = ((C15614o) this.cgL.mo74857aF(C15614o.class)).dDX().getLastText();
        dDS();
        AppMethodBeat.m2505o(31380);
    }

    public final void dxy() {
        AppMethodBeat.m2504i(31381);
        C4990ab.m7410d("MicroMsg.ChattingUI.SearchComponent", "jacks mark reset keybord state");
        this.yPu = C36150a.hide;
        if (this.cgL.sRl != null) {
            C36135d c36135d = (C36135d) this.cgL.mo74857aF(C36135d.class);
            String str;
            if (c36135d.dDm()) {
                str = C41747z.aeU().mo60340fv(c36135d.dDz()).field_editingMsg;
                this.yPs = str;
                this.yPt = str;
                AppMethodBeat.m2505o(31381);
                return;
            }
            C9638aw.m17190ZK();
            C7617ak aoZ = C18628c.m29083XR().aoZ(this.cgL.getTalkerUserName());
            if (aoZ != null) {
                str = aoZ.field_editingMsg;
                this.yPs = str;
                this.yPt = str;
            }
        }
        AppMethodBeat.m2505o(31381);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31382);
        C15614o c15614o = (C15614o) this.cgL.mo74857aF(C15614o.class);
        if (c15614o.dDX() != null) {
            if (c15614o.dDX().dkD()) {
                this.yPu = C36150a.show;
                C4990ab.m7410d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: show");
            } else {
                this.yPu = C36150a.hide;
                C4990ab.m7410d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: hide");
            }
            this.yPs = c15614o.dDX().getLastText();
        }
        c15614o = (C15614o) this.cgL.mo74857aF(C15614o.class);
        C36135d c36135d = (C36135d) this.cgL.mo74857aF(C36135d.class);
        if (c36135d.dDm()) {
            C32232a fv = C41747z.aeU().mo60340fv(c36135d.dDz());
            if (c15614o.dDX() != null && (this.yPt == null || !c15614o.dDX().getLastText().trim().equals(this.yPt))) {
                this.yPt = c15614o.dDX().getLastText().trim();
                fv.field_editingMsg = this.yPt;
                fv.field_flag = C37446b.m63109a(fv, 1, C5046bo.isNullOrNil(fv.field_editingMsg) ? fv.field_lastMsgTime : System.currentTimeMillis());
                C41747z.aeU().mo60337b(fv);
                C4990ab.m7418v("MicroMsg.ChattingUI.SearchComponent", "set editMsg history");
            }
            AppMethodBeat.m2505o(31382);
            return;
        }
        C7617ak c7617ak;
        C7617ak c7617ak2 = null;
        if (C1720g.m3534RN().mo5161QY()) {
            C9638aw.m17190ZK();
            c7617ak2 = C18628c.m29083XR().aoZ(this.cgL.getTalkerUserName());
        }
        if (c7617ak2 != null || c15614o.dDX() == null || C5046bo.isNullOrNil(c15614o.dDX().getLastText().trim())) {
            c7617ak = c7617ak2;
        } else {
            c7617ak = new C7617ak(this.cgL.sRl.field_username);
            c7617ak.mo14742eD(System.currentTimeMillis());
            if (((C40726v) this.cgL.mo74857aF(C40726v.class)).dEL()) {
                c7617ak.mo16712jj(4194304);
            }
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo15807d(c7617ak);
        }
        if (!(c7617ak == null || c15614o.dDX() == null || (this.yPt != null && c15614o.dDX().getLastText().trim().equals(this.yPt)))) {
            long j;
            this.yPt = c15614o.dDX().getLastText().trim();
            c7617ak.mo14761jk(c15614o.dDX().getLastText().trim());
            if (C5046bo.isNullOrNil(c7617ak.field_editingMsg)) {
                j = c7617ak.field_conversationTime;
            } else {
                j = System.currentTimeMillis();
            }
            c7617ak.mo14743eE(C43298a.m77176a(c7617ak, 1, j));
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo15768a(c7617ak, c7617ak.field_username, false);
        }
        C4990ab.m7417i("MicroMsg.ChattingUI.SearchComponent", "[doDestroy] set editMsg history! content:%s username:%s", C5046bo.anv(this.yPt), this.cgL.getTalkerUserName());
        AppMethodBeat.m2505o(31382);
    }
}
