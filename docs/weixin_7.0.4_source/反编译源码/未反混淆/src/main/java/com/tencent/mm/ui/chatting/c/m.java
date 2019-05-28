package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.chatting.c.b.ae;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.c.b.t;
import com.tencent.mm.ui.chatting.c.b.v;
import com.tencent.mm.ui.chatting.c.b.z;

@com.tencent.mm.ui.chatting.c.a.a(dFp = ae.class)
public class m extends a implements ae {
    private boolean yPq = false;
    private boolean yPr = false;
    private String yPs;
    private String yPt;
    private a yPu = a.hide;

    enum a {
        hide,
        show;

        static {
            AppMethodBeat.o(31377);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(31378);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 212:
                if (intent != null) {
                    o oVar = (o) this.cgL.aF(o.class);
                    String stringExtra = intent.getStringExtra("select_raw_user_name");
                    String stringExtra2 = intent.getStringExtra("Select_Conv_User");
                    if (!bo.isNullOrNil(stringExtra2)) {
                        ab.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", stringExtra2);
                        oVar.dDX().setAtSomebody(stringExtra2);
                        oVar.dDX().ax(this.cgL.getTalkerUserName(), stringExtra, stringExtra2);
                        this.yPq = true;
                        break;
                    }
                    ab.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", "[nobody]");
                    oVar.dDX().setAtSomebody("");
                    this.yPq = false;
                    AppMethodBeat.o(31378);
                    return;
                }
                break;
        }
        AppMethodBeat.o(31378);
    }

    public final void dxz() {
    }

    public final void dxA() {
    }

    public final void dxC() {
    }

    public final void dDS() {
        AppMethodBeat.i(31383);
        if (bo.isNullOrNil(this.cgL.getTalkerUserName())) {
            AppMethodBeat.o(31383);
            return;
        }
        o oVar = (o) this.cgL.aF(o.class);
        if (bo.isNullOrNil(this.yPs) || oVar.dDX() == null) {
            if (oVar.dDX() != null) {
                if (((t) this.cgL.aF(t.class)).dEF()) {
                    oVar.dDX().setLastText(this.yPs);
                    oVar.dDX().setHint(this.cgL.yTx.getMMResources().getString(R.string.ap2));
                    AppMethodBeat.o(31383);
                    return;
                } else if (oVar.dDX().getIsVoiceInputPanleShow()) {
                    oVar.dEd();
                    AppMethodBeat.o(31383);
                    return;
                } else {
                    dDT();
                }
            }
            AppMethodBeat.o(31383);
            return;
        }
        boolean z = oVar.dDX().getMode() == 1 && bo.isNullOrNil(oVar.dEa());
        boolean dEU = ((z) this.cgL.aF(z.class)).dEU();
        if (!z || dEU) {
            dDT();
        } else {
            dDU();
        }
        boolean dDn = ((d) this.cgL.aF(d.class)).dDn();
        if ((this.cgL.dFw() || dDn) && this.yPq) {
            this.yPq = false;
            String atSomebody = oVar.dDX().getAtSomebody();
            if (!bo.isNullOrNil(atSomebody)) {
                int insertPos = oVar.dDX().getInsertPos();
                if (insertPos > this.yPs.length()) {
                    insertPos = this.yPs.length();
                }
                StringBuilder append = new StringBuilder().append(this.yPs.substring(0, insertPos)).append(atSomebody).append(8197);
                String str = this.yPs;
                String stringBuilder = append.append(str.substring(insertPos, str.length())).toString();
                insertPos = (insertPos + atSomebody.length()) + 1;
                oVar.dDX().setLastContent(stringBuilder);
                oVar.dDX().u(stringBuilder, insertPos, false);
                oVar.dDX().setAtSomebody(null);
                this.cgL.showVKB();
            }
        } else {
            oVar.dDX().setLastContent(this.yPs);
            oVar.dDX().setLastText(this.yPs);
            if (!(bo.isNullOrNil(this.yPs) || dEU || !bo.isNullOrNil(oVar.dEa()))) {
                oVar.dEh();
            }
        }
        oVar.dEd();
        AppMethodBeat.o(31383);
    }

    private void dDT() {
        AppMethodBeat.i(31384);
        o oVar = (o) this.cgL.aF(o.class);
        if (oVar.dDX() == null) {
            AppMethodBeat.o(31384);
            return;
        }
        oVar.dDX().oQ(this.yPu == a.show);
        AppMethodBeat.o(31384);
    }

    private void dDU() {
        AppMethodBeat.i(31385);
        o oVar = (o) this.cgL.aF(o.class);
        if (oVar.dDX() == null) {
            AppMethodBeat.o(31385);
            return;
        }
        oVar.dDX().dkz();
        AppMethodBeat.o(31385);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(31379);
        if (keyEvent.getKeyCode() == 67) {
            o oVar = (o) this.cgL.aF(o.class);
            if (keyEvent.getAction() == 0) {
                if (oVar.dDX().getCharAtCursor() == 8197) {
                    this.yPr = true;
                } else {
                    this.yPr = false;
                }
            }
            if (keyEvent.getAction() == 1 && this.yPr) {
                this.yPr = false;
                ChatFooter dDX = oVar.dDX();
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
        AppMethodBeat.o(31379);
        return false;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(31380);
        this.yPs = ((o) this.cgL.aF(o.class)).dDX().getLastText();
        dDS();
        AppMethodBeat.o(31380);
    }

    public final void dxy() {
        AppMethodBeat.i(31381);
        ab.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark reset keybord state");
        this.yPu = a.hide;
        if (this.cgL.sRl != null) {
            d dVar = (d) this.cgL.aF(d.class);
            String str;
            if (dVar.dDm()) {
                str = com.tencent.mm.aj.z.aeU().fv(dVar.dDz()).field_editingMsg;
                this.yPs = str;
                this.yPt = str;
                AppMethodBeat.o(31381);
                return;
            }
            aw.ZK();
            ak aoZ = c.XR().aoZ(this.cgL.getTalkerUserName());
            if (aoZ != null) {
                str = aoZ.field_editingMsg;
                this.yPs = str;
                this.yPt = str;
            }
        }
        AppMethodBeat.o(31381);
    }

    public final void dxB() {
        AppMethodBeat.i(31382);
        o oVar = (o) this.cgL.aF(o.class);
        if (oVar.dDX() != null) {
            if (oVar.dDX().dkD()) {
                this.yPu = a.show;
                ab.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: show");
            } else {
                this.yPu = a.hide;
                ab.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: hide");
            }
            this.yPs = oVar.dDX().getLastText();
        }
        oVar = (o) this.cgL.aF(o.class);
        d dVar = (d) this.cgL.aF(d.class);
        if (dVar.dDm()) {
            com.tencent.mm.aj.a.a fv = com.tencent.mm.aj.z.aeU().fv(dVar.dDz());
            if (oVar.dDX() != null && (this.yPt == null || !oVar.dDX().getLastText().trim().equals(this.yPt))) {
                this.yPt = oVar.dDX().getLastText().trim();
                fv.field_editingMsg = this.yPt;
                fv.field_flag = b.a(fv, 1, bo.isNullOrNil(fv.field_editingMsg) ? fv.field_lastMsgTime : System.currentTimeMillis());
                com.tencent.mm.aj.z.aeU().b(fv);
                ab.v("MicroMsg.ChattingUI.SearchComponent", "set editMsg history");
            }
            AppMethodBeat.o(31382);
            return;
        }
        ak akVar;
        ak akVar2 = null;
        if (g.RN().QY()) {
            aw.ZK();
            akVar2 = c.XR().aoZ(this.cgL.getTalkerUserName());
        }
        if (akVar2 != null || oVar.dDX() == null || bo.isNullOrNil(oVar.dDX().getLastText().trim())) {
            akVar = akVar2;
        } else {
            akVar = new ak(this.cgL.sRl.field_username);
            akVar.eD(System.currentTimeMillis());
            if (((v) this.cgL.aF(v.class)).dEL()) {
                akVar.jj(4194304);
            }
            aw.ZK();
            c.XR().d(akVar);
        }
        if (!(akVar == null || oVar.dDX() == null || (this.yPt != null && oVar.dDX().getLastText().trim().equals(this.yPt)))) {
            long j;
            this.yPt = oVar.dDX().getLastText().trim();
            akVar.jk(oVar.dDX().getLastText().trim());
            if (bo.isNullOrNil(akVar.field_editingMsg)) {
                j = akVar.field_conversationTime;
            } else {
                j = System.currentTimeMillis();
            }
            akVar.eE(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(akVar, 1, j));
            aw.ZK();
            c.XR().a(akVar, akVar.field_username, false);
        }
        ab.i("MicroMsg.ChattingUI.SearchComponent", "[doDestroy] set editMsg history! content:%s username:%s", bo.anv(this.yPt), this.cgL.getTalkerUserName());
        AppMethodBeat.o(31382);
    }
}
