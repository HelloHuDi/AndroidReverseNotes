package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountAgreementUI */
public class SettingDeleteAccountAgreementUI extends MMActivity {

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountAgreementUI$1 */
    class C289381 implements OnClickListener {
        C289381() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(127061);
            SettingDeleteAccountAgreementUI.this.startActivity(new Intent(SettingDeleteAccountAgreementUI.this, SettingDeleteAccountInputPassUI.class));
            AppMethodBeat.m2505o(127061);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountAgreementUI$3 */
    class C396673 implements OnMenuItemClickListener {
        C396673() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127063);
            SettingDeleteAccountAgreementUI.this.aqX();
            SettingDeleteAccountAgreementUI.this.finish();
            AppMethodBeat.m2505o(127063);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130970624;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127064);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.e45);
        initView();
        AppMethodBeat.m2505o(127064);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127065);
        final TextView textView = (TextView) findViewById(2131822846);
        textView.setOnClickListener(new C289381());
        final CheckedTextView checkedTextView = (CheckedTextView) findViewById(2131827370);
        checkedTextView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(127062);
                textView.setEnabled(checkedTextView.isChecked());
                AppMethodBeat.m2505o(127062);
            }
        });
        textView.setEnabled(checkedTextView.isChecked());
        setBackBtn(new C396673());
        AppMethodBeat.m2505o(127065);
    }
}
