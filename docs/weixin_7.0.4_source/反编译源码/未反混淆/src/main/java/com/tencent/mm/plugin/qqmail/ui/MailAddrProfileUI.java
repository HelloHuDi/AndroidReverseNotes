package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class MailAddrProfileUI extends MMPreference {
    private f ehK;
    private String nJq;
    private String name;
    private boolean pyw;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int JC() {
        return R.xml.b0;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68334);
        super.onCreate(bundle);
        this.name = getIntent().getStringExtra("name");
        this.nJq = getIntent().getStringExtra("addr");
        this.pyw = getIntent().getBooleanExtra("can_compose", false);
        initView();
        AppMethodBeat.o(68334);
    }

    public final void initView() {
        AppMethodBeat.i(68335);
        setMMTitle((int) R.string.cea);
        this.ehK = this.yCw;
        ((KeyValuePreference) this.ehK.aqO("mail_receiver_info_name")).setSummary((CharSequence) this.name);
        ((KeyValuePreference) this.ehK.aqO("mail_receiver_info_addr")).setSummary((CharSequence) getIntent().getStringExtra("addr"));
        Preference aqO = this.ehK.aqO("mail_compose_btn");
        if (!this.pyw) {
            this.ehK.d(aqO);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68333);
                MailAddrProfileUI.this.aqX();
                MailAddrProfileUI.this.finish();
                AppMethodBeat.o(68333);
                return true;
            }
        });
        AppMethodBeat.o(68335);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(68336);
        if (preference.mKey.equals("mail_compose_btn")) {
            Intent intent = new Intent(this, ComposeUI.class);
            intent.putExtra("composeType", 4);
            intent.putExtra("toList", new String[]{this.name + " " + this.nJq});
            startActivity(intent);
            finish();
        }
        AppMethodBeat.o(68336);
        return false;
    }
}
