package com.tencent.p177mm.plugin.p268aa.p270ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.p268aa.p269a.C9797h;
import com.tencent.p177mm.plugin.p268aa.p270ui.C9821a.C9822a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.aa.ui.AAEntranceUI */
public class AAEntranceUI extends MMActivity {
    private Button gna;
    private TextView gnb;

    /* renamed from: com.tencent.mm.plugin.aa.ui.AAEntranceUI$1 */
    class C98001 implements OnClickListener {
        C98001() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40708);
            AAEntranceUI.m53836a(AAEntranceUI.this);
            AppMethodBeat.m2505o(40708);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.AAEntranceUI$2 */
    class C265402 implements C9822a {
        C265402() {
        }

        public final void aos() {
            AppMethodBeat.m2504i(40709);
            AAEntranceUI.this.startActivity(new Intent(AAEntranceUI.this.mController.ylL, AAQueryListUI.class));
            AppMethodBeat.m2505o(40709);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.AAEntranceUI$3 */
    class C328993 implements OnMenuItemClickListener {
        C328993() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(40710);
            AAEntranceUI.this.finish();
            AppMethodBeat.m2505o(40710);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130968576;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(40712);
        if (i2 != -1) {
            AppMethodBeat.m2505o(40712);
            return;
        }
        if (i == 1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            C4990ab.m7417i("MicroMsg.AAEntranceUI", "select chatroom：%s", stringExtra);
            if (!C5046bo.isNullOrNil(stringExtra)) {
                Intent intent2 = new Intent(this.mController.ylL, LaunchAAUI.class);
                intent2.putExtra("enter_scene", 2);
                intent2.putExtra("chatroom_name", stringExtra);
                if (getIntent().getExtras() != null) {
                    intent2.putExtras(getIntent().getExtras());
                }
                startActivityForResult(intent2, 2);
            }
        } else if (i == 2) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(40712);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(40711);
        this.yll = true;
        super.onCreate(bundle);
        mo17446xE(this.mController.dyj());
        setMMTitle((int) C25738R.string.cm5);
        this.gna = (Button) findViewById(2131820885);
        this.gnb = (TextView) findViewById(2131820886);
        this.gna.setOnClickListener(new C98001());
        this.gnb.setClickable(true);
        this.gnb.setOnTouchListener(new C30132m(this));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(C25738R.string.ap7));
        spannableStringBuilder.setSpan(new C9821a(new C265402()), 0, spannableStringBuilder.length(), 18);
        this.gnb.setText(spannableStringBuilder);
        setBackBtn(new C328993());
        AppMethodBeat.m2505o(40711);
    }

    /* renamed from: a */
    static /* synthetic */ void m53836a(AAEntranceUI aAEntranceUI) {
        AppMethodBeat.m2504i(40713);
        C4990ab.m7416i("MicroMsg.AAEntranceUI", "go to contact");
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 1);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", false);
        intent.putExtra("mutil_select_is_ret", false);
        intent.putExtra("Select_block_List", C1853r.m3846Yz());
        intent.putExtra("recent_remittance_contact_list", C9797h.aom());
        C25985d.m41468b(aAEntranceUI.mController.ylL, "remittance", ".ui.SelectRemittanceContactUI", intent, 1);
        AppMethodBeat.m2505o(40713);
    }
}
