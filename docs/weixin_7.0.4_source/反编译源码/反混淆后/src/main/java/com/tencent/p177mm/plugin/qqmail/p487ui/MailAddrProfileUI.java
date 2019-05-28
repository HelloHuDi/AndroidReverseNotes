package com.tencent.p177mm.plugin.qqmail.p487ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.KeyValuePreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrProfileUI */
public class MailAddrProfileUI extends MMPreference {
    private C15541f ehK;
    private String nJq;
    private String name;
    private boolean pyw;

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAddrProfileUI$1 */
    class C395451 implements OnMenuItemClickListener {
        C395451() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(68333);
            MailAddrProfileUI.this.aqX();
            MailAddrProfileUI.this.finish();
            AppMethodBeat.m2505o(68333);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8515b0;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(68334);
        super.onCreate(bundle);
        this.name = getIntent().getStringExtra("name");
        this.nJq = getIntent().getStringExtra("addr");
        this.pyw = getIntent().getBooleanExtra("can_compose", false);
        initView();
        AppMethodBeat.m2505o(68334);
    }

    public final void initView() {
        AppMethodBeat.m2504i(68335);
        setMMTitle((int) C25738R.string.cea);
        this.ehK = this.yCw;
        ((KeyValuePreference) this.ehK.aqO("mail_receiver_info_name")).setSummary((CharSequence) this.name);
        ((KeyValuePreference) this.ehK.aqO("mail_receiver_info_addr")).setSummary((CharSequence) getIntent().getStringExtra("addr"));
        Preference aqO = this.ehK.aqO("mail_compose_btn");
        if (!this.pyw) {
            this.ehK.mo27716d(aqO);
        }
        setBackBtn(new C395451());
        AppMethodBeat.m2505o(68335);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(68336);
        if (preference.mKey.equals("mail_compose_btn")) {
            Intent intent = new Intent(this, ComposeUI.class);
            intent.putExtra("composeType", 4);
            intent.putExtra("toList", new String[]{this.name + " " + this.nJq});
            startActivity(intent);
            finish();
        }
        AppMethodBeat.m2505o(68336);
        return false;
    }
}
