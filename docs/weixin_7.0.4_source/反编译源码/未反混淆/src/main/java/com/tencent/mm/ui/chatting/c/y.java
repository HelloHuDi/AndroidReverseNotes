package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.database.Cursor;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.a.je;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelmulti.h;
import com.tencent.mm.plugin.bbom.i;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.c.b.t;
import java.util.Arrays;

@a(dFp = t.class)
public class y extends a implements t {
    String cEr = null;
    private String jEs = null;
    boolean vnc = false;
    private boolean yQO = false;
    private Runnable yQP = new Runnable() {
        public final void run() {
            AppMethodBeat.i(31551);
            if (y.this.cgL != null) {
                ((r) y.this.cgL.aF(r.class)).dEr();
            }
            AppMethodBeat.o(31551);
        }
    };
    private Runnable yQQ = new Runnable() {
        public final void run() {
            AppMethodBeat.i(31552);
            if (y.this.cgL != null) {
                o oVar = (o) y.this.cgL.aF(o.class);
                oVar.dDX().setLbsMode(false);
                oVar.dDX().vni = false;
                oVar.dDX().dke();
                ChatFooter dDX = oVar.dDX();
                if (dDX.vmS != null) {
                    dDX.vmS.setVisibility(0);
                }
                ChatFooter dDX2 = oVar.dDX();
                if (dDX2.vmP != null) {
                    dDX2.vmP.setVisibility(0);
                }
            }
            AppMethodBeat.o(31552);
        }
    };
    private c yQR = new c<je>() {
        {
            AppMethodBeat.i(31553);
            this.xxI = je.class.getName().hashCode();
            AppMethodBeat.o(31553);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(31554);
            je jeVar = (je) bVar;
            if ((jeVar instanceof je) && y.this.vnc && (jeVar.cEq.cEr == null || jeVar.cEq.cEr.equals(y.this.cEr))) {
                if (jeVar.cEq.type == 1) {
                    al.d(y.this.yQP);
                } else if (jeVar.cEq.type == 2) {
                    y.this.vnc = false;
                    al.d(y.this.yQQ);
                }
            }
            AppMethodBeat.o(31554);
            return false;
        }
    };

    public y() {
        AppMethodBeat.i(31555);
        AppMethodBeat.o(31555);
    }

    private void dDi() {
        AppMethodBeat.i(31556);
        com.tencent.mm.sdk.b.a.xxA.d(this.yQR);
        AppMethodBeat.o(31556);
    }

    public final boolean dEF() {
        return this.vnc;
    }

    public final void a(Button button, LinearLayout linearLayout, LinearLayout linearLayout2) {
        AppMethodBeat.i(31558);
        if (this.jEs == null) {
            bf apA = d.akQ().apA(this.cEr);
            if (apA != null) {
                ((TextView) linearLayout.findViewById(R.id.aty)).setText(apA.field_sayhicontent);
                ((Button) linearLayout.findViewById(R.id.atz)).setText(R.string.alx);
                AppMethodBeat.o(31558);
                return;
            }
            linearLayout2.setVisibility(8);
            AppMethodBeat.o(31558);
        } else if (this.yQO) {
            ((TextView) linearLayout.findViewById(R.id.aty)).setText(R.string.alz);
            button.setVisibility(8);
            AppMethodBeat.o(31558);
        } else {
            ((TextView) linearLayout.findViewById(R.id.aty)).setText(R.string.am0);
            ((Button) linearLayout.findViewById(R.id.atz)).setText(R.string.aly);
            AppMethodBeat.o(31558);
        }
    }

    public final void OC(int i) {
        AppMethodBeat.i(31559);
        if (this.jEs != null) {
            String format = String.format(this.cgL.yTx.getMMResources().getString(R.string.a5g), new Object[]{bo.nullAsNil(com.tencent.mm.model.r.YB())});
            aw.Rg().a(new m(2, Arrays.asList(new String[]{this.cEr}), Arrays.asList(new Integer[]{Integer.valueOf(18)}), format, ""), 0);
            this.yQO = true;
        } else {
            bf apA = d.akQ().apA(this.cEr);
            aw.Rg().a(new m(this.cEr, apA.field_ticket, i, (byte) 0), 0);
            apA.field_flag = 2;
            d.akQ().c(apA, new String[0]);
        }
        ((r) this.cgL.aF(r.class)).dEr();
        AppMethodBeat.o(31559);
    }

    public final void aV(Intent intent) {
        AppMethodBeat.i(31560);
        intent.putExtra("Contact_IsLBSFriend", true);
        intent.putExtra("Contact_IsLbsChattingProfile", true);
        intent.putExtra("Contact_Scene", 18);
        AppMethodBeat.o(31560);
    }

    public final void dxA() {
    }

    public final void dxC() {
        AppMethodBeat.i(31567);
        dDi();
        AppMethodBeat.o(31567);
    }

    public final void dDh() {
        AppMethodBeat.i(31568);
        super.dDh();
        dDi();
        AppMethodBeat.o(31568);
    }

    public final boolean dEG() {
        AppMethodBeat.i(31557);
        if (this.vnc) {
            bf apA = d.akQ().apA(this.cEr);
            if (!(this.jEs == null && apA == null)) {
                ((r) this.cgL.aF(r.class)).dEr();
            }
            AppMethodBeat.o(31557);
            return true;
        }
        AppMethodBeat.o(31557);
        return false;
    }

    public final String aro(String str) {
        String talkerUserName;
        AppMethodBeat.i(31561);
        if (this.vnc) {
            ab.i("MicroMsg.ChattingUI.LbsComponent", "[oneliang]encrypt:" + this.cEr + ",raw:" + this.cgL.getTalkerUserName());
            talkerUserName = bo.isNullOrNil(this.cEr) ? this.cgL.getTalkerUserName() : this.cEr;
        } else {
            talkerUserName = str;
        }
        AppMethodBeat.o(31561);
        return talkerUserName;
    }

    public final void g(h hVar) {
        bf bfVar = null;
        AppMethodBeat.i(31562);
        if (this.vnc) {
            String str = this.jEs;
            bg akQ = d.akQ();
            String str2 = this.cEr;
            String str3 = "SELECT * FROM " + akQ.getTableName() + " where sayhiencryptuser=? and isSend=0 and flag=0 ORDER BY createtime desc LIMIT 1";
            Cursor a = akQ.bSd.a(str3, new String[]{str2}, 2);
            if (a != null) {
                if (a.moveToFirst()) {
                    bfVar = new bf();
                    bfVar.d(a);
                    a.close();
                } else {
                    a.close();
                }
            }
            if (!(bfVar == null || bo.isNullOrNil(bfVar.field_ticket))) {
                str = bfVar.field_ticket;
            }
            if (bo.isNullOrNil(str)) {
                bfVar = d.akQ().apA(this.cEr);
                if (!(bfVar == null || bo.isNullOrNil(bfVar.field_ticket))) {
                    str = bfVar.field_ticket;
                }
            }
            if (str != null) {
                hVar.fIr = new i(str);
            }
        }
        AppMethodBeat.o(31562);
    }

    public final void dxx() {
        String talkerUserName;
        AppMethodBeat.i(31563);
        this.vnc = this.cgL.yTx.getBooleanExtra("lbs_mode", false).booleanValue();
        if (bo.isNullOrNil(this.cgL.sRl.field_encryptUsername)) {
            talkerUserName = this.cgL.getTalkerUserName();
        } else {
            talkerUserName = this.cgL.sRl.field_encryptUsername;
        }
        this.cEr = talkerUserName;
        this.jEs = this.cgL.yTx.getStringExtra("lbs_ticket");
        AppMethodBeat.o(31563);
    }

    public final void dxy() {
        AppMethodBeat.i(31564);
        if (this.vnc) {
            o oVar = (o) this.cgL.aF(o.class);
            oVar.dDX().setLbsMode(true);
            ChatFooter dDX = oVar.dDX();
            if (dDX.vmS != null) {
                dDX.vmS.setVisibility(8);
            }
            ChatFooter dDX2 = oVar.dDX();
            if (dDX2.vmP != null) {
                dDX2.vmP.setVisibility(8);
            }
        }
        AppMethodBeat.o(31564);
    }

    public final void dxz() {
        AppMethodBeat.i(31565);
        com.tencent.mm.sdk.b.a.xxA.c(this.yQR);
        AppMethodBeat.o(31565);
    }

    public final void dxB() {
        AppMethodBeat.i(31566);
        al.af(this.yQP);
        al.af(this.yQQ);
        AppMethodBeat.o(31566);
    }
}
