package com.tencent.p177mm.plugin.webwx.p582ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;

/* renamed from: com.tencent.mm.plugin.webwx.ui.WebWeiXinIntroductionUI */
public class WebWeiXinIntroductionUI extends MMActivity {
    private Button uLK;

    /* renamed from: com.tencent.mm.plugin.webwx.ui.WebWeiXinIntroductionUI$1 */
    class C147121 implements OnClickListener {
        C147121() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26571);
            Intent intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 1);
            intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
            intent.putExtra("from_album", false);
            intent.putExtra("show_intro", false);
            intent.setFlags(65536);
            C25985d.m41467b(WebWeiXinIntroductionUI.this, "scanner", ".ui.BaseScanUI", intent);
            AppMethodBeat.m2505o(26571);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webwx.ui.WebWeiXinIntroductionUI$2 */
    class C147132 implements OnMenuItemClickListener {
        C147132() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(26572);
            WebWeiXinIntroductionUI.this.finish();
            AppMethodBeat.m2505o(26572);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130971203;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(26573);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(26573);
    }

    public final void initView() {
        AppMethodBeat.m2504i(26574);
        setMMTitle("");
        this.uLK = (Button) findViewById(2131829159);
        this.uLK.setOnClickListener(new C147121());
        setBackBtn(new C147132());
        AppMethodBeat.m2505o(26574);
    }
}
