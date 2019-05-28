package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;

/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI */
public class FreeWifiIntroductionUI extends MMActivity {
    private int cvd;
    private Button mxV;
    private Button mzt;
    private Button mzu;
    private CheckBox mzv;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI$2 */
    class C31462 implements OnClickListener {
        C31462() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20999);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(303104, Integer.valueOf(1));
            Intent intent = FreeWifiIntroductionUI.this.getIntent();
            intent.setClass(FreeWifiIntroductionUI.this, FreeWifiEntryUI.class);
            FreeWifiIntroductionUI.this.startActivity(intent);
            FreeWifiIntroductionUI.this.finish();
            AppMethodBeat.m2505o(20999);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI$4 */
    class C31474 implements OnClickListener {
        C31474() {
        }

        public final void onClick(View view) {
            String string;
            AppMethodBeat.m2504i(21001);
            if (FreeWifiIntroductionUI.this.cvd == 3) {
                string = FreeWifiIntroductionUI.this.getString(C25738R.string.czs);
            } else {
                string = FreeWifiIntroductionUI.this.getString(C25738R.string.c0q);
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", string);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            C25985d.m41467b(FreeWifiIntroductionUI.this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(21001);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI$5 */
    class C31485 implements OnClickListener {
        C31485() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21002);
            String string = FreeWifiIntroductionUI.this.getString(C25738R.string.c07);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", string);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            C25985d.m41467b(FreeWifiIntroductionUI.this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(21002);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI$3 */
    class C119903 implements OnCheckedChangeListener {
        C119903() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.m2504i(21000);
            if (z) {
                FreeWifiIntroductionUI.this.mzt.setEnabled(true);
                AppMethodBeat.m2505o(21000);
                return;
            }
            FreeWifiIntroductionUI.this.mzt.setEnabled(false);
            AppMethodBeat.m2505o(21000);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI$1 */
    class C119911 implements OnMenuItemClickListener {
        C119911() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(20998);
            FreeWifiIntroductionUI.this.finish();
            AppMethodBeat.m2505o(20998);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(21003);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(21003);
    }

    public final void initView() {
        AppMethodBeat.m2504i(21004);
        this.mzt = (Button) findViewById(2131824142);
        this.mzv = (CheckBox) findViewById(2131824140);
        this.mxV = (Button) findViewById(2131824143);
        this.mzu = (Button) findViewById(2131824141);
        this.cvd = getIntent().getIntExtra("free_wifi_source", 1);
        if (this.cvd == 3) {
            setMMTitle((int) C25738R.string.czt);
            ((TextView) findViewById(2131824139)).setText(C25738R.string.czr);
            ((TextView) findViewById(2131824138)).setText(C25738R.string.czq);
            this.mxV.setVisibility(8);
        } else {
            setMMTitle((int) C25738R.string.c0t);
        }
        setBackBtn(new C119911());
        this.mzt.setOnClickListener(new C31462());
        this.mzv.setOnCheckedChangeListener(new C119903());
        this.mzu.setOnClickListener(new C31474());
        this.mxV.setOnClickListener(new C31485());
        AppMethodBeat.m2505o(21004);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return 2130969592;
    }
}
