package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.account.p275ui.RegByMobileSetPwdUI;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAliasResultUI */
public class SettingsAliasResultUI extends MMActivity {
    private String dFl;
    private TextView gnC;
    private TextView qmN;
    private Button qmO;
    private ImageView qmP;
    private boolean qmQ;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAliasResultUI$1 */
    class C37991 implements OnMenuItemClickListener {
        C37991() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127177);
            SettingsAliasResultUI.this.finish();
            AppMethodBeat.m2505o(127177);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAliasResultUI$2 */
    class C348672 implements OnClickListener {
        C348672() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(127178);
            Intent intent = new Intent(SettingsAliasResultUI.this.mController.ylL, RegByMobileSetPwdUI.class);
            intent.putExtra("kintent_hint", SettingsAliasResultUI.this.getString(C25738R.string.dlx));
            SettingsAliasResultUI.this.startActivityForResult(intent, 0);
            AppMethodBeat.m2505o(127178);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127179);
        super.onCreate(bundle);
        this.dFl = (String) C1720g.m3536RP().mo5239Ry().get(42, null);
        this.qmQ = getIntent().getBooleanExtra("has_pwd", true);
        initView();
        AppMethodBeat.m2505o(127179);
    }

    public final int getLayoutId() {
        return 2130970631;
    }

    public void onPause() {
        AppMethodBeat.m2504i(127180);
        super.onPause();
        AppMethodBeat.m2505o(127180);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127181);
        super.onDestroy();
        AppMethodBeat.m2505o(127181);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127182);
        setMMTitle((int) C25738R.string.d18);
        this.gnC = (TextView) findViewById(2131820991);
        this.qmN = (TextView) findViewById(2131821097);
        this.qmO = (Button) findViewById(2131827383);
        this.qmP = (ImageView) findViewById(2131827382);
        setBackBtn(new C37991());
        this.qmN.setText(this.dFl);
        if (this.qmQ) {
            this.qmO.setVisibility(8);
            this.gnC.setText(getString(C25738R.string.d1d));
        } else {
            this.qmO.setVisibility(0);
            this.gnC.setText(getString(C25738R.string.d1c));
        }
        this.qmO.setOnClickListener(new C348672());
        AppMethodBeat.m2505o(127182);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(127183);
        if (i2 == -1) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(127183);
    }
}
