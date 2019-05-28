package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountAgreementUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.ari;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127064);
        super.onCreate(bundle);
        setMMTitle((int) R.string.e45);
        initView();
        AppMethodBeat.o(127064);
    }

    public final void initView() {
        AppMethodBeat.i(127065);
        final TextView textView = (TextView) findViewById(R.id.ay8);
        textView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(127061);
                SettingDeleteAccountAgreementUI.this.startActivity(new Intent(SettingDeleteAccountAgreementUI.this, SettingDeleteAccountInputPassUI.class));
                AppMethodBeat.o(127061);
            }
        });
        final CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.id.e9i);
        checkedTextView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(127062);
                textView.setEnabled(checkedTextView.isChecked());
                AppMethodBeat.o(127062);
            }
        });
        textView.setEnabled(checkedTextView.isChecked());
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127063);
                SettingDeleteAccountAgreementUI.this.aqX();
                SettingDeleteAccountAgreementUI.this.finish();
                AppMethodBeat.o(127063);
                return true;
            }
        });
        AppMethodBeat.o(127065);
    }
}
