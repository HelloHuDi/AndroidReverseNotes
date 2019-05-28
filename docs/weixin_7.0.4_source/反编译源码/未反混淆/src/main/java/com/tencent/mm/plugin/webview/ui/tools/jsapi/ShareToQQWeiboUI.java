package com.tencent.mm.plugin.webview.ui.tools.jsapi;

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
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.view.d;

public class ShareToQQWeiboUI extends MMActivity implements f {
    private ProgressDialog ehJ = null;
    private EditText pwu;
    private TextView qkx;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.t9;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(9843);
        super.onCreate(bundle);
        g.Rg().a(26, (f) this);
        initView();
        AppMethodBeat.o(9843);
    }

    public void onDestroy() {
        AppMethodBeat.i(9844);
        g.Rg().b(26, (f) this);
        super.onDestroy();
        AppMethodBeat.o(9844);
    }

    public final void initView() {
        AppMethodBeat.i(9845);
        setMMTitle((int) R.string.eh0);
        this.pwu = (EditText) findViewById(R.id.m5);
        this.qkx = (TextView) findViewById(R.id.b5v);
        String stringExtra = getIntent().getStringExtra(b.CONTENT);
        String stringExtra2 = getIntent().getStringExtra("shortUrl");
        this.pwu.addTextChangedListener(new c(this.pwu, this.qkx, d.MIC_PTU_TRANS_XINXIAN));
        if (stringExtra.contains(stringExtra2)) {
            this.pwu.setText(stringExtra.trim());
        } else {
            this.pwu.setText(stringExtra + " " + stringExtra2);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(9840);
                ShareToQQWeiboUI.this.aqX();
                ShareToQQWeiboUI.this.finish();
                AppMethodBeat.o(9840);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.tl), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(9842);
                final m vVar = new v(ShareToQQWeiboUI.this.getIntent().getIntExtra("type", 0), ShareToQQWeiboUI.this.getIntent().getStringExtra("shortUrl"), ShareToQQWeiboUI.this.pwu.getText().toString());
                g.Rg().a(vVar, 0);
                ShareToQQWeiboUI shareToQQWeiboUI = ShareToQQWeiboUI.this;
                Context context = ShareToQQWeiboUI.this.mController.ylL;
                ShareToQQWeiboUI.this.getString(R.string.tz);
                shareToQQWeiboUI.ehJ = h.b(context, ShareToQQWeiboUI.this.getString(R.string.g2w), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(9841);
                        g.Rg().c(vVar);
                        AppMethodBeat.o(9841);
                    }
                });
                AppMethodBeat.o(9842);
                return true;
            }
        });
        AppMethodBeat.o(9845);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(9846);
        ab.i("MicroMsg.ShareToQQWeiboUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (mVar.getType() != 26) {
            AppMethodBeat.o(9846);
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
            AppMethodBeat.o(9846);
            return;
        }
        setResult(1, new Intent().putExtra("err_code", i2));
        Toast.makeText(this, getString(R.string.egu, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        AppMethodBeat.o(9846);
    }
}
