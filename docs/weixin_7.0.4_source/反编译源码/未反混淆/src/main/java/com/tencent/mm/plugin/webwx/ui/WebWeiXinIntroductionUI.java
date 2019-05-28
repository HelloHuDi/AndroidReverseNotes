package com.tencent.mm.plugin.webwx.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.ui.MMActivity;

public class WebWeiXinIntroductionUI extends MMActivity {
    private Button uLK;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.b73;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26573);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(26573);
    }

    public final void initView() {
        AppMethodBeat.i(26574);
        setMMTitle("");
        this.uLK = (Button) findViewById(R.id.fjv);
        this.uLK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(26571);
                Intent intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
                intent.putExtra("from_album", false);
                intent.putExtra("show_intro", false);
                intent.setFlags(65536);
                d.b(WebWeiXinIntroductionUI.this, "scanner", ".ui.BaseScanUI", intent);
                AppMethodBeat.o(26571);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26572);
                WebWeiXinIntroductionUI.this.finish();
                AppMethodBeat.o(26572);
                return true;
            }
        });
        AppMethodBeat.o(26574);
    }
}
