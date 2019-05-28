package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.j;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.storage.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import org.xwalk.core.XWalkEnvironment;

public class SendFeedBackUI extends MMActivity implements f {
    private ProgressDialog ehJ = null;
    private EditText pwu;
    private TextView qlE = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.ta;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127048);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(127048);
    }

    public void onDestroy() {
        AppMethodBeat.i(127049);
        g.Rg().b((int) XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, (f) this);
        super.onDestroy();
        AppMethodBeat.o(127049);
    }

    public final void initView() {
        AppMethodBeat.i(127050);
        setMMTitle((int) R.string.e75);
        this.pwu = (EditText) findViewById(R.id.m5);
        String stringExtra = getIntent().getStringExtra("intentKeyFrom");
        if (stringExtra != null && stringExtra.equals("fromEnjoyAppDialog")) {
            this.qlE = (TextView) findViewById(R.id.bbr);
            this.qlE.setVisibility(0);
            this.qlE.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(127043);
                    Intent intent = new Intent();
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", SendFeedBackUI.this.getString(R.string.g0f));
                    d.b(SendFeedBackUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(127043);
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127044);
                SendFeedBackUI.this.aqX();
                SendFeedBackUI.this.finish();
                AppMethodBeat.o(127044);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.tf), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127046);
                String trim = SendFeedBackUI.this.pwu.getText().toString().trim();
                if (trim.length() > 0) {
                    if (trim.startsWith("//traceroute")) {
                        SendFeedBackUI.this.pwu.setText("");
                        d.H(SendFeedBackUI.this.mController.ylL, "traceroute", ".ui.NetworkDiagnoseIntroUI");
                        AppMethodBeat.o(127046);
                        return false;
                    }
                    final m jVar = new j(q.Mc(), trim + " key " + bs.dut() + " local key " + bs.dus() + "NetType:" + at.getNetTypeString(SendFeedBackUI.this.getApplicationContext()) + " hasNeon: " + n.LC() + " isArmv6: " + n.LE() + " isArmv7: " + n.LD());
                    g.Rg().a((int) XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, SendFeedBackUI.this);
                    g.Rg().a(jVar, 0);
                    SendFeedBackUI.this.aqX();
                    SendFeedBackUI sendFeedBackUI = SendFeedBackUI.this;
                    Context context = SendFeedBackUI.this;
                    SendFeedBackUI.this.getString(R.string.tz);
                    sendFeedBackUI.ehJ = h.b(context, SendFeedBackUI.this.getString(R.string.th), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(127045);
                            g.Rg().c(jVar);
                            AppMethodBeat.o(127045);
                        }
                    });
                }
                AppMethodBeat.o(127046);
                return false;
            }
        });
        AppMethodBeat.o(127050);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(127051);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 0 && i2 == 0) {
            h.a((Context) this, getString(R.string.e74), getString(R.string.tz), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(127047);
                    SendFeedBackUI.this.finish();
                    AppMethodBeat.o(127047);
                }
            });
            AppMethodBeat.o(127051);
            return;
        }
        h.a((Context) this, getString(R.string.e73), getString(R.string.tz), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(127051);
    }
}
