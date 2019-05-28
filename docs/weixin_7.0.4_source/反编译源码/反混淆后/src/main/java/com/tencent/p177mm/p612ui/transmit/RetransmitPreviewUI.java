package com.tencent.p177mm.p612ui.transmit;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p211cb.C9212g;
import com.tencent.p177mm.p612ui.MMActivity;

/* renamed from: com.tencent.mm.ui.transmit.RetransmitPreviewUI */
public class RetransmitPreviewUI extends MMActivity {
    /* renamed from: sW */
    private TextView f16220sW = null;
    private String text = null;

    /* renamed from: com.tencent.mm.ui.transmit.RetransmitPreviewUI$1 */
    class C408941 implements OnMenuItemClickListener {
        C408941() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(35120);
            RetransmitPreviewUI.this.finish();
            AppMethodBeat.m2505o(35120);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130969075;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(35121);
        super.onCreate(bundle);
        setMMTitle("");
        this.text = getIntent().getStringExtra("Retr_Msg_content");
        this.f16220sW = (TextView) findViewById(2131822635);
        this.f16220sW.setText(C9212g.dqQ().mo20622b(this.text, this.f16220sW.getTextSize()));
        setBackBtn(new C408941());
        AppMethodBeat.m2505o(35121);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(35122);
        finish();
        AppMethodBeat.m2505o(35122);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(35123);
        super.onDestroy();
        AppMethodBeat.m2505o(35123);
    }
}
