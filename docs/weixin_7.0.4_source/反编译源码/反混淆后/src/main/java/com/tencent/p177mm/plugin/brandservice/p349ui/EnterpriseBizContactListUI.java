package com.tencent.p177mm.plugin.brandservice.p349ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C25764e;
import com.tencent.p177mm.p184aj.C36692b;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.tools.C40890k;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.brandservice.C33720b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI */
public class EnterpriseBizContactListUI extends MMActivity {
    private boolean cph = false;
    private long edh;
    private long fRR = 0;
    public String jLN;
    private C40890k jLO;
    private EnterpriseBizContactListView jLP;
    private C7306ak jLQ;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI$1 */
    class C26871 implements OnMenuItemClickListener {
        C26871() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13942);
            EnterpriseBizContactListUI.this.aqX();
            EnterpriseBizContactListUI.this.finish();
            AppMethodBeat.m2505o(13942);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI$2 */
    class C26882 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI$2$1 */
        class C26891 implements C36073c {
            C26891() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(13943);
                c44273l.mo70063ax(2, C25738R.string.azw, C1318a.ofm_send_icon);
                c44273l.mo70063ax(3, C25738R.string.bdp, C1318a.actionbar_goto_disabled_biz_icon);
                c44273l.mo70063ax(4, C25738R.string.f8699cg, C1318a.actionbar_setting_white_icon);
                AppMethodBeat.m2505o(13943);
            }
        }

        /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI$2$2 */
        class C26902 implements C5279d {
            C26902() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(13944);
                Intent intent;
                switch (menuItem.getItemId()) {
                    case 2:
                        intent = new Intent();
                        intent.putExtra("Select_Talker_Name", EnterpriseBizContactListUI.this.jLN);
                        intent.putExtra("Select_block_List", EnterpriseBizContactListUI.this.jLN);
                        intent.putExtra("Select_Send_Card", true);
                        intent.putExtra("Select_Conv_Type", 3);
                        C25985d.m41466b(EnterpriseBizContactListUI.this, ".ui.transmit.SelectConversationUI", intent, 1);
                        AppMethodBeat.m2505o(13944);
                        return;
                    case 3:
                        intent = new Intent(EnterpriseBizContactListUI.this, EnterpriseBizContactPlainListUI.class);
                        intent.putExtra("enterprise_biz_name", EnterpriseBizContactListUI.this.jLN);
                        intent.putExtra("enterprise_scene", 2);
                        EnterpriseBizContactListUI.this.startActivity(intent);
                        AppMethodBeat.m2505o(13944);
                        return;
                    case 4:
                        intent = new Intent();
                        intent.putExtra("Contact_User", EnterpriseBizContactListUI.this.jLN);
                        C33720b.gkE.mo38912c(intent, EnterpriseBizContactListUI.this);
                        break;
                }
                AppMethodBeat.m2505o(13944);
            }
        }

        C26882() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13945);
            if (EnterpriseBizContactListUI.this.jLO != null) {
                EnterpriseBizContactListUI.this.jLO.dismiss();
                EnterpriseBizContactListUI.this.jLO = null;
            }
            EnterpriseBizContactListUI.this.jLO = new C40890k(EnterpriseBizContactListUI.this.mController.ylL);
            EnterpriseBizContactListUI.this.jLO.rBl = new C26891();
            EnterpriseBizContactListUI.this.jLO.rBm = new C26902();
            EnterpriseBizContactListUI.this.jLO.mo49182gP();
            AppMethodBeat.m2505o(13945);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI$3 */
    class C77213 extends C7306ak {
        C77213() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(13946);
            if (message != null && message.what == 1 && EnterpriseBizContactListUI.this != null && !EnterpriseBizContactListUI.this.isFinishing()) {
                C41747z.afd().mo52930qB(EnterpriseBizContactListUI.this.jLN);
                C41747z.aeR();
                List qS = C25764e.m40951qS(EnterpriseBizContactListUI.this.jLN);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= qS.size()) {
                        break;
                    }
                    String str = (String) qS.get(i2);
                    if (C1855t.m3912mY(str) && (C17903f.m28110rd(str) || C17903f.m28103kq(str))) {
                        C41747z.afd().mo52930qB(str);
                    }
                    i = i2 + 1;
                }
            }
            AppMethodBeat.m2505o(13946);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130969397;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13947);
        super.onCreate(bundle);
        this.jLN = getIntent().getStringExtra("enterprise_biz_name");
        this.edh = System.currentTimeMillis() / 1000;
        if (this.jLQ == null) {
            this.jLQ = new C77213();
        } else {
            this.jLQ.removeMessages(1);
        }
        this.jLQ.sendEmptyMessageDelayed(1, 500);
        AppMethodBeat.m2505o(13947);
    }

    public void onResume() {
        AppMethodBeat.m2504i(13948);
        super.onResume();
        if (C1855t.m3912mY(this.jLN)) {
            initView();
            if (!this.cph) {
                int intExtra = getIntent().getIntExtra("enterprise_from_scene", 5);
                int i = -1;
                if (this.jLP != null) {
                    i = this.jLP.getContactCount();
                }
                C36692b qC = C41747z.afa().mo20347qC(this.jLN);
                int i2 = qC != null ? qC.field_qyUin : 0;
                long j = qC != null ? qC.field_wwCorpId : 0;
                long j2 = qC != null ? qC.field_wwUserVid : 0;
                C7060h.pYm.mo8381e(12892, this.jLN, Integer.valueOf(intExtra), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
                C4990ab.m7411d("MicroMsg.BrandService.EnterpriseBizContactListUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", this.jLN, Integer.valueOf(intExtra), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
                this.cph = true;
            }
            AppMethodBeat.m2505o(13948);
            return;
        }
        C4990ab.m7413e("MicroMsg.BrandService.EnterpriseBizContactListUI", "%s !isContact", this.jLN);
        finish();
        AppMethodBeat.m2505o(13948);
    }

    public void onPause() {
        AppMethodBeat.m2504i(13949);
        super.onPause();
        AppMethodBeat.m2505o(13949);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(13950);
        if (this.jLP != null) {
            EnterpriseBizContactListView.release();
        }
        if (this.edh > 0 && this.fRR > 0) {
            int i;
            int i2;
            long j = this.fRR - this.edh;
            C36692b qC = C41747z.afa().mo20347qC(this.jLN);
            if (qC != null) {
                i = qC.field_qyUin;
            } else {
                i = 0;
            }
            if (qC != null) {
                i2 = qC.field_userUin;
            } else {
                i2 = 0;
            }
            C7060h.pYm.mo8381e(13465, "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(2), Long.valueOf(j));
            C4990ab.m7411d("MicroMsg.BrandService.EnterpriseBizContactListUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(2), Long.valueOf(j));
        }
        super.onDestroy();
        AppMethodBeat.m2505o(13950);
    }

    public final void initView() {
        AppMethodBeat.m2504i(13952);
        setMMTitle(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.jLN).mo16706Oi());
        setBackBtn(new C26871());
        if (!C5046bo.isNullOrNil(this.jLN)) {
            C16527d qX = C17903f.m28104qX(this.jLN);
            if (qX != null && qX.adP()) {
                aWf();
            }
        }
        this.jLP = (EnterpriseBizContactListView) findViewById(2131823619);
        this.jLP.setFatherBizName(this.jLN);
        this.jLP.setExcludeBizChat(false);
        this.jLP.refresh();
        this.jLP.aWg();
        AppMethodBeat.m2505o(13952);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(13953);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 != -1 || intent == null) {
                    AppMethodBeat.m2505o(13953);
                    return;
                }
                String stringExtra = intent.getStringExtra("be_send_card_name");
                String stringExtra2 = intent.getStringExtra("received_card_name");
                boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                String stringExtra3 = intent.getStringExtra("custom_send_text");
                C12519g.bOk().mo46462q(stringExtra, stringExtra2, booleanExtra);
                C12519g.bOk().mo46461eZ(stringExtra3, stringExtra2);
                C5670b.m8523i(this, this.mController.ylL.getString(C25738R.string.cbn));
                AppMethodBeat.m2505o(13953);
                return;
            default:
                AppMethodBeat.m2505o(13953);
                return;
        }
    }

    private void aWf() {
        AppMethodBeat.m2504i(13954);
        addIconOptionMenu(1, C25738R.string.f8698cf, C1318a.actionbar_icon_dark_add, new C26882());
        AppMethodBeat.m2505o(13954);
    }

    public void finish() {
        AppMethodBeat.m2504i(13951);
        this.fRR = System.currentTimeMillis() / 1000;
        super.finish();
        AppMethodBeat.m2505o(13951);
    }
}
