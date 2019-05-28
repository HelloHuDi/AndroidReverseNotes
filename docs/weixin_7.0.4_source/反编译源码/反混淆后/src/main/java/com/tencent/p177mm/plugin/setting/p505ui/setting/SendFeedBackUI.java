package com.tencent.p177mm.plugin.setting.p505ui.setting;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1422n;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.setting.model.C7081j;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.storage.C7574bs;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI */
public class SendFeedBackUI extends MMActivity implements C1202f {
    private ProgressDialog ehJ = null;
    private EditText pwu;
    private TextView qlE = null;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI$1 */
    class C348581 implements OnClickListener {
        C348581() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(127043);
            Intent intent = new Intent();
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", SendFeedBackUI.this.getString(C25738R.string.g0f));
            C25985d.m41467b(SendFeedBackUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(127043);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI$2 */
    class C348592 implements OnMenuItemClickListener {
        C348592() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127044);
            SendFeedBackUI.this.aqX();
            SendFeedBackUI.this.finish();
            AppMethodBeat.m2505o(127044);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI$3 */
    class C348603 implements OnMenuItemClickListener {
        C348603() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127046);
            String trim = SendFeedBackUI.this.pwu.getText().toString().trim();
            if (trim.length() > 0) {
                if (trim.startsWith("//traceroute")) {
                    SendFeedBackUI.this.pwu.setText("");
                    C25985d.m41448H(SendFeedBackUI.this.mController.ylL, "traceroute", ".ui.NetworkDiagnoseIntroUI");
                    AppMethodBeat.m2505o(127046);
                    return false;
                }
                final C1207m c7081j = new C7081j(C1427q.m3044Mc(), trim + " key " + C7574bs.dut() + " local key " + C7574bs.dus() + "NetType:" + C5023at.getNetTypeString(SendFeedBackUI.this.getApplicationContext()) + " hasNeon: " + C1422n.m3013LC() + " isArmv6: " + C1422n.m3015LE() + " isArmv7: " + C1422n.m3014LD());
                C1720g.m3540Rg().mo14539a((int) XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, SendFeedBackUI.this);
                C1720g.m3540Rg().mo14541a(c7081j, 0);
                SendFeedBackUI.this.aqX();
                SendFeedBackUI sendFeedBackUI = SendFeedBackUI.this;
                Context context = SendFeedBackUI.this;
                SendFeedBackUI.this.getString(C25738R.string.f9238tz);
                sendFeedBackUI.ehJ = C30379h.m48458b(context, SendFeedBackUI.this.getString(C25738R.string.f9222th), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(127045);
                        C1720g.m3540Rg().mo14547c(c7081j);
                        AppMethodBeat.m2505o(127045);
                    }
                });
            }
            AppMethodBeat.m2505o(127046);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI$5 */
    class C348615 implements DialogInterface.OnClickListener {
        C348615() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI$4 */
    class C396664 implements DialogInterface.OnClickListener {
        C396664() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127047);
            SendFeedBackUI.this.finish();
            AppMethodBeat.m2505o(127047);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130969318;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127048);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(127048);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127049);
        C1720g.m3540Rg().mo14546b((int) XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(127049);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127050);
        setMMTitle((int) C25738R.string.e75);
        this.pwu = (EditText) findViewById(2131821019);
        String stringExtra = getIntent().getStringExtra("intentKeyFrom");
        if (stringExtra != null && stringExtra.equals("fromEnjoyAppDialog")) {
            this.qlE = (TextView) findViewById(2131823384);
            this.qlE.setVisibility(0);
            this.qlE.setOnClickListener(new C348581());
        }
        setBackBtn(new C348592());
        addTextOptionMenu(0, getString(C25738R.string.f9221tf), new C348603());
        AppMethodBeat.m2505o(127050);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(127051);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 0 && i2 == 0) {
            C30379h.m48438a((Context) this, getString(C25738R.string.e74), getString(C25738R.string.f9238tz), new C396664());
            AppMethodBeat.m2505o(127051);
            return;
        }
        C30379h.m48438a((Context) this, getString(C25738R.string.e73), getString(C25738R.string.f9238tz), new C348615());
        AppMethodBeat.m2505o(127051);
    }
}
