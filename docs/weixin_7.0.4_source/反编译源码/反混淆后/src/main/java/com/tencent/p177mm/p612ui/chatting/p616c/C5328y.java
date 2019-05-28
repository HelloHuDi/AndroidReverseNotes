package com.tencent.p177mm.p612ui.chatting.p616c;

import android.content.Intent;
import android.database.Cursor;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelmulti.C26451h;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p230g.p231a.C6497je;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15614o;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40725t;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44299r;
import com.tencent.p177mm.plugin.bbom.C20004i;
import com.tencent.p177mm.pluginsdk.model.C46498m;
import com.tencent.p177mm.pluginsdk.p597ui.chat.ChatFooter;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C35998bg;
import com.tencent.p177mm.storage.C7570bf;
import java.util.Arrays;

@C15590a(dFp = C40725t.class)
/* renamed from: com.tencent.mm.ui.chatting.c.y */
public class C5328y extends C44291a implements C40725t {
    String cEr = null;
    private String jEs = null;
    boolean vnc = false;
    private boolean yQO = false;
    private Runnable yQP = new C53291();
    private Runnable yQQ = new C53302();
    private C4884c yQR = new C53313();

    /* renamed from: com.tencent.mm.ui.chatting.c.y$1 */
    class C53291 implements Runnable {
        C53291() {
        }

        public final void run() {
            AppMethodBeat.m2504i(31551);
            if (C5328y.this.cgL != null) {
                ((C44299r) C5328y.this.cgL.mo74857aF(C44299r.class)).dEr();
            }
            AppMethodBeat.m2505o(31551);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.y$2 */
    class C53302 implements Runnable {
        C53302() {
        }

        public final void run() {
            AppMethodBeat.m2504i(31552);
            if (C5328y.this.cgL != null) {
                C15614o c15614o = (C15614o) C5328y.this.cgL.mo74857aF(C15614o.class);
                c15614o.dDX().setLbsMode(false);
                c15614o.dDX().vni = false;
                c15614o.dDX().dke();
                ChatFooter dDX = c15614o.dDX();
                if (dDX.vmS != null) {
                    dDX.vmS.setVisibility(0);
                }
                ChatFooter dDX2 = c15614o.dDX();
                if (dDX2.vmP != null) {
                    dDX2.vmP.setVisibility(0);
                }
            }
            AppMethodBeat.m2505o(31552);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.y$3 */
    class C53313 extends C4884c<C6497je> {
        C53313() {
            AppMethodBeat.m2504i(31553);
            this.xxI = C6497je.class.getName().hashCode();
            AppMethodBeat.m2505o(31553);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(31554);
            C6497je c6497je = (C6497je) c4883b;
            if ((c6497je instanceof C6497je) && C5328y.this.vnc && (c6497je.cEq.cEr == null || c6497je.cEq.cEr.equals(C5328y.this.cEr))) {
                if (c6497je.cEq.type == 1) {
                    C5004al.m7441d(C5328y.this.yQP);
                } else if (c6497je.cEq.type == 2) {
                    C5328y.this.vnc = false;
                    C5004al.m7441d(C5328y.this.yQQ);
                }
            }
            AppMethodBeat.m2505o(31554);
            return false;
        }
    }

    public C5328y() {
        AppMethodBeat.m2504i(31555);
        AppMethodBeat.m2505o(31555);
    }

    private void dDi() {
        AppMethodBeat.m2504i(31556);
        C4879a.xxA.mo10053d(this.yQR);
        AppMethodBeat.m2505o(31556);
    }

    public final boolean dEF() {
        return this.vnc;
    }

    /* renamed from: a */
    public final void mo10947a(Button button, LinearLayout linearLayout, LinearLayout linearLayout2) {
        AppMethodBeat.m2504i(31558);
        if (this.jEs == null) {
            C7570bf apA = C41789d.akQ().apA(this.cEr);
            if (apA != null) {
                ((TextView) linearLayout.findViewById(2131822689)).setText(apA.field_sayhicontent);
                ((Button) linearLayout.findViewById(2131822690)).setText(C25738R.string.alx);
                AppMethodBeat.m2505o(31558);
                return;
            }
            linearLayout2.setVisibility(8);
            AppMethodBeat.m2505o(31558);
        } else if (this.yQO) {
            ((TextView) linearLayout.findViewById(2131822689)).setText(C25738R.string.alz);
            button.setVisibility(8);
            AppMethodBeat.m2505o(31558);
        } else {
            ((TextView) linearLayout.findViewById(2131822689)).setText(C25738R.string.am0);
            ((Button) linearLayout.findViewById(2131822690)).setText(C25738R.string.aly);
            AppMethodBeat.m2505o(31558);
        }
    }

    /* renamed from: OC */
    public final void mo10946OC(int i) {
        AppMethodBeat.m2504i(31559);
        if (this.jEs != null) {
            String format = String.format(this.cgL.yTx.getMMResources().getString(C25738R.string.a5g), new Object[]{C5046bo.nullAsNil(C1853r.m3820YB())});
            C9638aw.m17182Rg().mo14541a(new C46498m(2, Arrays.asList(new String[]{this.cEr}), Arrays.asList(new Integer[]{Integer.valueOf(18)}), format, ""), 0);
            this.yQO = true;
        } else {
            C7570bf apA = C41789d.akQ().apA(this.cEr);
            C9638aw.m17182Rg().mo14541a(new C46498m(this.cEr, apA.field_ticket, i, (byte) 0), 0);
            apA.field_flag = 2;
            C41789d.akQ().mo10103c(apA, new String[0]);
        }
        ((C44299r) this.cgL.mo74857aF(C44299r.class)).dEr();
        AppMethodBeat.m2505o(31559);
    }

    /* renamed from: aV */
    public final void mo10948aV(Intent intent) {
        AppMethodBeat.m2504i(31560);
        intent.putExtra("Contact_IsLBSFriend", true);
        intent.putExtra("Contact_IsLbsChattingProfile", true);
        intent.putExtra("Contact_Scene", 18);
        AppMethodBeat.m2505o(31560);
    }

    public final void dxA() {
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31567);
        dDi();
        AppMethodBeat.m2505o(31567);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31568);
        super.dDh();
        dDi();
        AppMethodBeat.m2505o(31568);
    }

    public final boolean dEG() {
        AppMethodBeat.m2504i(31557);
        if (this.vnc) {
            C7570bf apA = C41789d.akQ().apA(this.cEr);
            if (!(this.jEs == null && apA == null)) {
                ((C44299r) this.cgL.mo74857aF(C44299r.class)).dEr();
            }
            AppMethodBeat.m2505o(31557);
            return true;
        }
        AppMethodBeat.m2505o(31557);
        return false;
    }

    public final String aro(String str) {
        String talkerUserName;
        AppMethodBeat.m2504i(31561);
        if (this.vnc) {
            C4990ab.m7416i("MicroMsg.ChattingUI.LbsComponent", "[oneliang]encrypt:" + this.cEr + ",raw:" + this.cgL.getTalkerUserName());
            talkerUserName = C5046bo.isNullOrNil(this.cEr) ? this.cgL.getTalkerUserName() : this.cEr;
        } else {
            talkerUserName = str;
        }
        AppMethodBeat.m2505o(31561);
        return talkerUserName;
    }

    /* renamed from: g */
    public final void mo10958g(C26451h c26451h) {
        C7570bf c7570bf = null;
        AppMethodBeat.m2504i(31562);
        if (this.vnc) {
            String str = this.jEs;
            C35998bg akQ = C41789d.akQ();
            String str2 = this.cEr;
            String str3 = "SELECT * FROM " + akQ.getTableName() + " where sayhiencryptuser=? and isSend=0 and flag=0 ORDER BY createtime desc LIMIT 1";
            Cursor a = akQ.bSd.mo10104a(str3, new String[]{str2}, 2);
            if (a != null) {
                if (a.moveToFirst()) {
                    c7570bf = new C7570bf();
                    c7570bf.mo8995d(a);
                    a.close();
                } else {
                    a.close();
                }
            }
            if (!(c7570bf == null || C5046bo.isNullOrNil(c7570bf.field_ticket))) {
                str = c7570bf.field_ticket;
            }
            if (C5046bo.isNullOrNil(str)) {
                c7570bf = C41789d.akQ().apA(this.cEr);
                if (!(c7570bf == null || C5046bo.isNullOrNil(c7570bf.field_ticket))) {
                    str = c7570bf.field_ticket;
                }
            }
            if (str != null) {
                c26451h.fIr = new C20004i(str);
            }
        }
        AppMethodBeat.m2505o(31562);
    }

    public final void dxx() {
        String talkerUserName;
        AppMethodBeat.m2504i(31563);
        this.vnc = this.cgL.yTx.getBooleanExtra("lbs_mode", false).booleanValue();
        if (C5046bo.isNullOrNil(this.cgL.sRl.field_encryptUsername)) {
            talkerUserName = this.cgL.getTalkerUserName();
        } else {
            talkerUserName = this.cgL.sRl.field_encryptUsername;
        }
        this.cEr = talkerUserName;
        this.jEs = this.cgL.yTx.getStringExtra("lbs_ticket");
        AppMethodBeat.m2505o(31563);
    }

    public final void dxy() {
        AppMethodBeat.m2504i(31564);
        if (this.vnc) {
            C15614o c15614o = (C15614o) this.cgL.mo74857aF(C15614o.class);
            c15614o.dDX().setLbsMode(true);
            ChatFooter dDX = c15614o.dDX();
            if (dDX.vmS != null) {
                dDX.vmS.setVisibility(8);
            }
            ChatFooter dDX2 = c15614o.dDX();
            if (dDX2.vmP != null) {
                dDX2.vmP.setVisibility(8);
            }
        }
        AppMethodBeat.m2505o(31564);
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31565);
        C4879a.xxA.mo10052c(this.yQR);
        AppMethodBeat.m2505o(31565);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31566);
        C5004al.m7439af(this.yQP);
        C5004al.m7439af(this.yQQ);
        AppMethodBeat.m2505o(31566);
    }
}
