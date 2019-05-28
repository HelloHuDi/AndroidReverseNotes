package com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsimple.C32829v;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.MMEditText.C5622c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.ShareToQQWeiboUI */
public class ShareToQQWeiboUI extends MMActivity implements C1202f {
    private ProgressDialog ehJ = null;
    private EditText pwu;
    private TextView qkx;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.ShareToQQWeiboUI$1 */
    class C46271 implements OnMenuItemClickListener {
        C46271() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(9840);
            ShareToQQWeiboUI.this.aqX();
            ShareToQQWeiboUI.this.finish();
            AppMethodBeat.m2505o(9840);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.ShareToQQWeiboUI$2 */
    class C46282 implements OnMenuItemClickListener {
        C46282() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(9842);
            final C1207m c32829v = new C32829v(ShareToQQWeiboUI.this.getIntent().getIntExtra("type", 0), ShareToQQWeiboUI.this.getIntent().getStringExtra("shortUrl"), ShareToQQWeiboUI.this.pwu.getText().toString());
            C1720g.m3540Rg().mo14541a(c32829v, 0);
            ShareToQQWeiboUI shareToQQWeiboUI = ShareToQQWeiboUI.this;
            Context context = ShareToQQWeiboUI.this.mController.ylL;
            ShareToQQWeiboUI.this.getString(C25738R.string.f9238tz);
            shareToQQWeiboUI.ehJ = C30379h.m48458b(context, ShareToQQWeiboUI.this.getString(C25738R.string.g2w), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(9841);
                    C1720g.m3540Rg().mo14547c(c32829v);
                    AppMethodBeat.m2505o(9841);
                }
            });
            AppMethodBeat.m2505o(9842);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130969316;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(9843);
        super.onCreate(bundle);
        C1720g.m3540Rg().mo14539a(26, (C1202f) this);
        initView();
        AppMethodBeat.m2505o(9843);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(9844);
        C1720g.m3540Rg().mo14546b(26, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(9844);
    }

    public final void initView() {
        AppMethodBeat.m2504i(9845);
        setMMTitle((int) C25738R.string.eh0);
        this.pwu = (EditText) findViewById(2131821019);
        this.qkx = (TextView) findViewById(2131823129);
        String stringExtra = getIntent().getStringExtra(C8741b.CONTENT);
        String stringExtra2 = getIntent().getStringExtra("shortUrl");
        this.pwu.addTextChangedListener(new C5622c(this.pwu, this.qkx, C31128d.MIC_PTU_TRANS_XINXIAN));
        if (stringExtra.contains(stringExtra2)) {
            this.pwu.setText(stringExtra.trim());
        } else {
            this.pwu.setText(stringExtra + " " + stringExtra2);
        }
        setBackBtn(new C46271());
        addTextOptionMenu(0, getString(C25738R.string.f9226tl), new C46282());
        AppMethodBeat.m2505o(9845);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(9846);
        C4990ab.m7416i("MicroMsg.ShareToQQWeiboUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (c1207m.getType() != 26) {
            AppMethodBeat.m2505o(9846);
            return;
        }
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 0 && i2 == 0) {
            aqX();
            setResult(-1);
            finish();
            AppMethodBeat.m2505o(9846);
            return;
        }
        setResult(1, new Intent().putExtra("err_code", i2));
        Toast.makeText(this, getString(C25738R.string.egu, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        AppMethodBeat.m2505o(9846);
    }
}
