package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.b;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.tools.k;
import java.util.List;

public class EnterpriseBizContactListUI extends MMActivity {
    private boolean cph = false;
    private long edh;
    private long fRR = 0;
    public String jLN;
    private k jLO;
    private EnterpriseBizContactListView jLP;
    private ak jLQ;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.vf;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13947);
        super.onCreate(bundle);
        this.jLN = getIntent().getStringExtra("enterprise_biz_name");
        this.edh = System.currentTimeMillis() / 1000;
        if (this.jLQ == null) {
            this.jLQ = new ak() {
                public final void handleMessage(Message message) {
                    AppMethodBeat.i(13946);
                    if (message != null && message.what == 1 && EnterpriseBizContactListUI.this != null && !EnterpriseBizContactListUI.this.isFinishing()) {
                        z.afd().qB(EnterpriseBizContactListUI.this.jLN);
                        z.aeR();
                        List qS = e.qS(EnterpriseBizContactListUI.this.jLN);
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= qS.size()) {
                                break;
                            }
                            String str = (String) qS.get(i2);
                            if (t.mY(str) && (f.rd(str) || f.kq(str))) {
                                z.afd().qB(str);
                            }
                            i = i2 + 1;
                        }
                    }
                    AppMethodBeat.o(13946);
                }
            };
        } else {
            this.jLQ.removeMessages(1);
        }
        this.jLQ.sendEmptyMessageDelayed(1, 500);
        AppMethodBeat.o(13947);
    }

    public void onResume() {
        AppMethodBeat.i(13948);
        super.onResume();
        if (t.mY(this.jLN)) {
            initView();
            if (!this.cph) {
                int intExtra = getIntent().getIntExtra("enterprise_from_scene", 5);
                int i = -1;
                if (this.jLP != null) {
                    i = this.jLP.getContactCount();
                }
                b qC = z.afa().qC(this.jLN);
                int i2 = qC != null ? qC.field_qyUin : 0;
                long j = qC != null ? qC.field_wwCorpId : 0;
                long j2 = qC != null ? qC.field_wwUserVid : 0;
                h.pYm.e(12892, this.jLN, Integer.valueOf(intExtra), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
                ab.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", this.jLN, Integer.valueOf(intExtra), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
                this.cph = true;
            }
            AppMethodBeat.o(13948);
            return;
        }
        ab.e("MicroMsg.BrandService.EnterpriseBizContactListUI", "%s !isContact", this.jLN);
        finish();
        AppMethodBeat.o(13948);
    }

    public void onPause() {
        AppMethodBeat.i(13949);
        super.onPause();
        AppMethodBeat.o(13949);
    }

    public void onDestroy() {
        AppMethodBeat.i(13950);
        if (this.jLP != null) {
            EnterpriseBizContactListView.release();
        }
        if (this.edh > 0 && this.fRR > 0) {
            int i;
            int i2;
            long j = this.fRR - this.edh;
            b qC = z.afa().qC(this.jLN);
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
            h.pYm.e(13465, "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(2), Long.valueOf(j));
            ab.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(2), Long.valueOf(j));
        }
        super.onDestroy();
        AppMethodBeat.o(13950);
    }

    public final void initView() {
        AppMethodBeat.i(13952);
        setMMTitle(((j) g.K(j.class)).XM().aoO(this.jLN).Oi());
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13942);
                EnterpriseBizContactListUI.this.aqX();
                EnterpriseBizContactListUI.this.finish();
                AppMethodBeat.o(13942);
                return true;
            }
        });
        if (!bo.isNullOrNil(this.jLN)) {
            d qX = f.qX(this.jLN);
            if (qX != null && qX.adP()) {
                aWf();
            }
        }
        this.jLP = (EnterpriseBizContactListView) findViewById(R.id.bi4);
        this.jLP.setFatherBizName(this.jLN);
        this.jLP.setExcludeBizChat(false);
        this.jLP.refresh();
        this.jLP.aWg();
        AppMethodBeat.o(13952);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(13953);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 != -1 || intent == null) {
                    AppMethodBeat.o(13953);
                    return;
                }
                String stringExtra = intent.getStringExtra("be_send_card_name");
                String stringExtra2 = intent.getStringExtra("received_card_name");
                boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                String stringExtra3 = intent.getStringExtra("custom_send_text");
                com.tencent.mm.plugin.messenger.a.g.bOk().q(stringExtra, stringExtra2, booleanExtra);
                com.tencent.mm.plugin.messenger.a.g.bOk().eZ(stringExtra3, stringExtra2);
                com.tencent.mm.ui.widget.snackbar.b.i(this, this.mController.ylL.getString(R.string.cbn));
                AppMethodBeat.o(13953);
                return;
            default:
                AppMethodBeat.o(13953);
                return;
        }
    }

    private void aWf() {
        AppMethodBeat.i(13954);
        addIconOptionMenu(1, R.string.cf, R.raw.actionbar_icon_dark_add, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13945);
                if (EnterpriseBizContactListUI.this.jLO != null) {
                    EnterpriseBizContactListUI.this.jLO.dismiss();
                    EnterpriseBizContactListUI.this.jLO = null;
                }
                EnterpriseBizContactListUI.this.jLO = new k(EnterpriseBizContactListUI.this.mController.ylL);
                EnterpriseBizContactListUI.this.jLO.rBl = new c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(13943);
                        lVar.ax(2, R.string.azw, R.raw.ofm_send_icon);
                        lVar.ax(3, R.string.bdp, R.raw.actionbar_goto_disabled_biz_icon);
                        lVar.ax(4, R.string.cg, R.raw.actionbar_setting_white_icon);
                        AppMethodBeat.o(13943);
                    }
                };
                EnterpriseBizContactListUI.this.jLO.rBm = new n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(13944);
                        Intent intent;
                        switch (menuItem.getItemId()) {
                            case 2:
                                intent = new Intent();
                                intent.putExtra("Select_Talker_Name", EnterpriseBizContactListUI.this.jLN);
                                intent.putExtra("Select_block_List", EnterpriseBizContactListUI.this.jLN);
                                intent.putExtra("Select_Send_Card", true);
                                intent.putExtra("Select_Conv_Type", 3);
                                com.tencent.mm.bp.d.b(EnterpriseBizContactListUI.this, ".ui.transmit.SelectConversationUI", intent, 1);
                                AppMethodBeat.o(13944);
                                return;
                            case 3:
                                intent = new Intent(EnterpriseBizContactListUI.this, EnterpriseBizContactPlainListUI.class);
                                intent.putExtra("enterprise_biz_name", EnterpriseBizContactListUI.this.jLN);
                                intent.putExtra("enterprise_scene", 2);
                                EnterpriseBizContactListUI.this.startActivity(intent);
                                AppMethodBeat.o(13944);
                                return;
                            case 4:
                                intent = new Intent();
                                intent.putExtra("Contact_User", EnterpriseBizContactListUI.this.jLN);
                                com.tencent.mm.plugin.brandservice.b.gkE.c(intent, EnterpriseBizContactListUI.this);
                                break;
                        }
                        AppMethodBeat.o(13944);
                    }
                };
                EnterpriseBizContactListUI.this.jLO.gP();
                AppMethodBeat.o(13945);
                return false;
            }
        });
        AppMethodBeat.o(13954);
    }

    public void finish() {
        AppMethodBeat.i(13951);
        this.fRR = System.currentTimeMillis() / 1000;
        super.finish();
        AppMethodBeat.o(13951);
    }
}
