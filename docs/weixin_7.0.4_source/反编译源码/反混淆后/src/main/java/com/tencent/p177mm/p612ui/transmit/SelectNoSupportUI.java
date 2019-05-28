package com.tencent.p177mm.p612ui.transmit;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.transmit.SelectNoSupportUI */
public class SelectNoSupportUI extends MMActivity {
    private String zKq = "friend";
    private TextView zKr;
    private TextView zKs;

    /* renamed from: com.tencent.mm.ui.transmit.SelectNoSupportUI$1 */
    class C159571 implements OnMenuItemClickListener {
        C159571() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(35208);
            SelectNoSupportUI selectNoSupportUI = SelectNoSupportUI.this;
            selectNoSupportUI.aqX();
            selectNoSupportUI.finish();
            AppMethodBeat.m2505o(35208);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130970218;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(35209);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.SelectNoSupportUI", "onCreate!");
        this.zKq = getIntent().getStringExtra("sharePictureTo");
        C4990ab.m7416i("MicroMsg.SelectNoSupportUI", "initData done!");
        initView();
        C4990ab.m7416i("MicroMsg.SelectNoSupportUI", "initView done!");
        AppMethodBeat.m2505o(35209);
    }

    public final void initView() {
        AppMethodBeat.m2504i(35210);
        setMMTitle(getString(C25738R.string.e1v));
        this.zKr = (TextView) findViewById(2131826098);
        this.zKs = (TextView) findViewById(2131826099);
        this.zKr.setText(getString(C25738R.string.e24));
        String str = this.zKq;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1266283874:
                if (str.equals("friend")) {
                    obj = null;
                    break;
                }
                break;
            case 114040:
                if (str.equals("sns")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                this.zKs.setText(getString(C25738R.string.e25));
                break;
            case 1:
                this.zKs.setText(getString(C25738R.string.e26));
                break;
        }
        setBackBtn(new C159571());
        AppMethodBeat.m2505o(35210);
    }
}
