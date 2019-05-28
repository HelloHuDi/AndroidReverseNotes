package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.freewifi.C34189m;

/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiErrorUI */
public class FreeWifiErrorUI extends MMActivity {
    private ImageView myL;
    private TextView myM;
    private TextView myN;
    private TextView myO;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiErrorUI$1 */
    class C77681 implements OnMenuItemClickListener {
        C77681() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(20957);
            FreeWifiErrorUI.this.finish();
            AppMethodBeat.m2505o(20957);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(20958);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.c0t);
        this.myL = (ImageView) findViewById(2131824125);
        if (getIntent().getIntExtra("free_wifi_show_detail_error", 0) == 1) {
            this.myL.setImageResource(C25738R.drawable.aec);
        }
        this.myM = (TextView) findViewById(2131824126);
        this.myN = (TextView) findViewById(2131824127);
        this.myO = (TextView) findViewById(2131824128);
        String stringExtra = getIntent().getStringExtra("free_wifi_error_ui_error_msg");
        String stringExtra2 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail1");
        String stringExtra3 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail12");
        if (!C34189m.isEmpty(stringExtra)) {
            this.myM.setText(stringExtra);
        }
        if (!C34189m.isEmpty(stringExtra2)) {
            this.myN.setText(stringExtra2);
        }
        if (!C34189m.isEmpty(stringExtra3)) {
            this.myO.setText(stringExtra3);
        }
        setBackBtn(new C77681());
        AppMethodBeat.m2505o(20958);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return 2130969590;
    }
}
