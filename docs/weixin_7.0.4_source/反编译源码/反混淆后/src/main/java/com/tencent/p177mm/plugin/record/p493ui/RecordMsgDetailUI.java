package com.tencent.p177mm.plugin.record.p493ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.record.p1016a.C21592a;
import com.tencent.p177mm.plugin.record.p492b.C43432e;
import com.tencent.p177mm.plugin.record.p492b.C43436n;
import com.tencent.p177mm.pluginsdk.model.C40443e;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.protocal.p1338b.p1339a.C44099c;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgDetailUI */
public class RecordMsgDetailUI extends RecordMsgBaseUI {
    private boolean cHc = true;
    private String cKa = null;
    private long cvx = -1;
    private C44275p ejZ = null;
    private boolean pKA = false;
    private String pKB = "";
    private String pKC = "";
    private C44099c pKz = null;
    private String title = "";

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgDetailUI$3 */
    class C129933 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgDetailUI$3$1 */
        class C129941 implements C36073c {
            C129941() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(24236);
                c44273l.mo70068e(0, RecordMsgDetailUI.this.getString(C25738R.string.bri));
                if (RecordMsgDetailUI.this.getIntent().getIntExtra("from_scene", 0) == 0) {
                    c44273l.mo70068e(2, RecordMsgDetailUI.this.getString(C25738R.string.dcq));
                }
                AppMethodBeat.m2505o(24236);
            }
        }

        /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgDetailUI$3$2 */
        class C129952 implements C5279d {
            C129952() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(24237);
                switch (menuItem.getItemId()) {
                    case 0:
                        Intent intent = new Intent();
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("select_is_ret", true);
                        intent.putExtra("mutil_select_is_ret", true);
                        intent.putExtra("Retr_Msg_Type", 10);
                        intent.putExtra("Retr_Msg_Id", RecordMsgDetailUI.this.cvx);
                        C25985d.m41466b(RecordMsgDetailUI.this, ".ui.transmit.SelectConversationUI", intent, 1001);
                        AppMethodBeat.m2505o(24237);
                        return;
                    case 1:
                        AppMethodBeat.m2505o(24237);
                        return;
                    case 2:
                        C45316cl c45316cl = new C45316cl();
                        C40443e.m69369a(c45316cl, RecordMsgDetailUI.this.cvx);
                        c45316cl.cvA.cvH = 9;
                        c45316cl.cvA.activity = RecordMsgDetailUI.this;
                        C4879a.xxA.mo10055m(c45316cl);
                        break;
                }
                AppMethodBeat.m2505o(24237);
            }
        }

        C129933() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24238);
            C36356d c36356d = new C36356d(RecordMsgDetailUI.this.mController.ylL, 1, false);
            c36356d.rBl = new C129941();
            c36356d.rBm = new C129952();
            c36356d.cpD();
            AppMethodBeat.m2505o(24238);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgDetailUI$1 */
    class C288331 implements OnMenuItemClickListener {
        C288331() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24234);
            RecordMsgDetailUI.this.finish();
            AppMethodBeat.m2505o(24234);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgDetailUI$2 */
    class C288342 implements C32231g {
        C288342() {
        }

        /* renamed from: a */
        public final void mo8280a(int i, int i2, C1207m c1207m) {
            AppMethodBeat.m2504i(24235);
            if (i == i2) {
                if (RecordMsgDetailUI.this.ejZ != null) {
                    RecordMsgDetailUI.this.ejZ.dismiss();
                    RecordMsgDetailUI.this.ejZ = null;
                }
                C9638aw.m17190ZK();
                C7620bi jf = C18628c.m29080XO().mo15340jf(RecordMsgDetailUI.this.cvx);
                String str = jf.field_content;
                if (C1855t.m3896kH(jf.field_talker)) {
                    str = C1829bf.m3763oz(jf.field_content);
                }
                C8910b me = C8910b.m16064me(str);
                if (me != null) {
                    RecordMsgDetailUI.this.cKa = me.fgU;
                    RecordMsgDetailUI.this.pKz = C43436n.m77547VI(RecordMsgDetailUI.this.cKa);
                    if (RecordMsgDetailUI.this.pKz != null) {
                        if (RecordMsgDetailUI.m45842b(RecordMsgDetailUI.this, RecordMsgDetailUI.this.pKz) != null) {
                            RecordMsgDetailUI.this.title = RecordMsgDetailUI.m45842b(RecordMsgDetailUI.this, RecordMsgDetailUI.this.pKz);
                        } else {
                            RecordMsgDetailUI.this.title = RecordMsgDetailUI.this.pKz.title;
                        }
                        RecordMsgDetailUI.this.pKB = ((aar) RecordMsgDetailUI.this.pKz.fjr.getFirst()).wgX;
                        RecordMsgDetailUI.this.pKC = ((aar) RecordMsgDetailUI.this.pKz.fjr.getLast()).wgX;
                    }
                    RecordMsgDetailUI.m45850f(RecordMsgDetailUI.this);
                }
            }
            AppMethodBeat.m2505o(24235);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: f */
    static /* synthetic */ void m45850f(RecordMsgDetailUI recordMsgDetailUI) {
        AppMethodBeat.m2504i(24251);
        recordMsgDetailUI.m45846cu();
        AppMethodBeat.m2505o(24251);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(24242);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(24242);
    }

    /* Access modifiers changed, original: protected|final */
    public final void ceI() {
        AppMethodBeat.m2504i(24243);
        this.cvx = getIntent().getLongExtra("message_id", -1);
        this.cKa = getIntent().getStringExtra("record_xml");
        this.cHc = getIntent().getBooleanExtra("record_show_share", true);
        this.pKA = getIntent().getBooleanExtra("big_appmsg", false);
        this.pKz = C43436n.m77547VI(this.cKa);
        if (this.pKz != null) {
            if (m45840a(this.pKz) != null) {
                this.title = m45840a(this.pKz);
            } else {
                this.title = this.pKz.title;
            }
            if (!C5046bo.m7548ek(this.pKz.fjr)) {
                this.pKB = ((aar) this.pKz.fjr.getFirst()).wgX;
                this.pKC = ((aar) this.pKz.fjr.getLast()).wgX;
            }
        } else {
            C9638aw.m17190ZK();
            C7620bi jf = C18628c.m29080XO().mo15340jf(this.cvx);
            C8910b X = C8910b.m16058X(jf.field_content, jf.field_reserved);
            if (X != null) {
                this.title = X.title;
                this.ejZ = C44275p.m79966b(this, getString(C25738R.string.cn5), true, null);
            }
        }
        if (this.cKa == null || this.pKz == null) {
            ceQ();
            setBackBtn(new C288331());
            if (this.pKA && C14877am.aUq().mo48329lZ(this.cvx) != null) {
                C9638aw.m17190ZK();
                C9638aw.m17182Rg().mo14541a(new C43432e(this.cvx, C18628c.m29080XO().mo15340jf(this.cvx).field_msgSvrId, new C288342()), 0);
            }
            AppMethodBeat.m2505o(24243);
            return;
        }
        m45846cu();
        AppMethodBeat.m2505o(24243);
    }

    /* renamed from: a */
    private String m45840a(C44099c c44099c) {
        String str;
        AppMethodBeat.m2504i(24244);
        if (c44099c != null) {
            Iterator it = c44099c.fjr.iterator();
            int i = 0;
            Object obj = null;
            String str2 = null;
            str = null;
            while (it.hasNext()) {
                aar aar = (aar) it.next();
                if (aar.wgT.whw.whU != null) {
                    i = 1;
                    str = this.mController.ylL.getString(C25738R.string.dja);
                } else {
                    String str3;
                    if (aar.wgT.whw.cEV != null) {
                        if (str2 == null) {
                            str2 = aar.wgV;
                        } else if (str2 != aar.wgV) {
                            str3 = aar.wgV;
                            obj = str3;
                        }
                    }
                    str3 = obj;
                    obj = str3;
                }
            }
            if (str2 != null && obj == null && i == 0) {
                str = this.mController.ylL.getString(C25738R.string.bqj, new Object[]{str2});
            } else if (!(str2 == null || obj == null || str2.equals(obj) || i != 0)) {
                str = this.mController.ylL.getString(C25738R.string.bqi, new Object[]{str2, obj});
            }
        } else {
            str = null;
        }
        AppMethodBeat.m2505o(24244);
        return str;
    }

    /* renamed from: cu */
    private void m45846cu() {
        AppMethodBeat.m2504i(24245);
        C39580f c39580f = new C39580f();
        c39580f.pJZ = this.pKz.fjr;
        c39580f.cvx = this.cvx;
        c39580f.cKa = this.cKa;
        super.ceI();
        this.pKw.mo8328a(c39580f);
        ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37080a((C34803e) this.pKw);
        AppMethodBeat.m2505o(24245);
    }

    /* Access modifiers changed, original: protected|final */
    public final C3706h ceJ() {
        AppMethodBeat.m2504i(24246);
        C34803e c34803e = new C34803e(this, new C36803g());
        c34803e.fromScene = getIntent().getIntExtra("from_scene", 0);
        AppMethodBeat.m2505o(24246);
        return c34803e;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(24247);
        super.onDestroy();
        ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37083b((C34803e) this.pKw);
        AppMethodBeat.m2505o(24247);
    }

    /* Access modifiers changed, original: protected|final */
    public final String ceK() {
        return this.title;
    }

    /* Access modifiers changed, original: protected|final */
    public final String ceL() {
        return this.pKB;
    }

    /* Access modifiers changed, original: protected|final */
    public final String ceM() {
        return this.pKC;
    }

    /* Access modifiers changed, original: protected|final */
    public final void ceN() {
        AppMethodBeat.m2504i(24248);
        if (this.cHc) {
            addIconOptionMenu(0, C25738R.drawable.f6899uu, new C129933());
            AppMethodBeat.m2505o(24248);
            return;
        }
        AppMethodBeat.m2505o(24248);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: d */
    public final void mo37104d(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(24249);
        if (-1 != i2) {
            C4990ab.m7413e("MicroMsg.RecordMsgDetailUI", "processResult %d", Integer.valueOf(i2));
            AppMethodBeat.m2505o(24249);
        } else if (1001 == i) {
            final String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            final String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            if (C5046bo.isNullOrNil(stringExtra)) {
                C4990ab.m7420w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but toUser is null");
                AppMethodBeat.m2505o(24249);
                return;
            }
            C9638aw.m17190ZK();
            final C7620bi jf = C18628c.m29080XO().mo15340jf(this.cvx);
            if (jf.field_msgId != this.cvx) {
                C4990ab.m7420w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but message info is null");
                AppMethodBeat.m2505o(24249);
                return;
            }
            final C44275p b = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.bp2), false, null);
            C9638aw.m17180RS().mo10302aa(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.record.ui.RecordMsgDetailUI$4$1 */
                class C288361 implements Runnable {
                    C288361() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(24239);
                        b.dismiss();
                        AppMethodBeat.m2505o(24239);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(24240);
                    C43436n.m77550a(stringExtra, stringExtra2, jf);
                    C5004al.m7441d(new C288361());
                    AppMethodBeat.m2505o(24240);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(24241);
                    String str = super.toString() + "|onActivityResult";
                    AppMethodBeat.m2505o(24241);
                    return str;
                }
            });
            AppMethodBeat.m2505o(24249);
        } else {
            if (1002 == i && intent.getBooleanExtra("kfavorite", false)) {
                C45316cl c45316cl = new C45316cl();
                C40443e.m69370a(c45316cl, intent);
                c45316cl.cvA.activity = this;
                c45316cl.cvA.cvH = 8;
                C4879a.xxA.mo10055m(c45316cl);
            }
            AppMethodBeat.m2505o(24249);
        }
    }
}
