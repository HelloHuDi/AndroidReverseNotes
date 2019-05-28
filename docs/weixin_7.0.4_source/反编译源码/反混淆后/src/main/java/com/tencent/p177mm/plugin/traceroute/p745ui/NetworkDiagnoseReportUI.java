package com.tencent.p177mm.plugin.traceroute.p745ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI */
public class NetworkDiagnoseReportUI extends MMActivity {
    private static String sIs;
    private boolean sJg = false;
    private Button sJh;
    private Button sJi;
    private ImageView sJj;
    private TextView sJk;
    private TextView sJl;
    private TextView sJm;

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI$1 */
    class C140071 implements OnMenuItemClickListener {
        C140071() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(26016);
            NetworkDiagnoseReportUI.this.finish();
            AppMethodBeat.m2505o(26016);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI$3 */
    class C224353 implements OnClickListener {
        C224353() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26018);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.addFlags(268435456);
            intent.putExtra("android.intent.extra.EMAIL", new String[]{"WeChat_Log@qq.com"});
            intent.putExtra("android.intent.extra.SUBJECT", NetworkDiagnoseReportUI.m57992a(NetworkDiagnoseReportUI.this));
            intent.putExtra("android.intent.extra.STREAM", C15429k.m23714d(NetworkDiagnoseReportUI.this.mController.ylL, new File(NetworkDiagnoseReportUI.sIs)));
            intent.setType("text/plain");
            NetworkDiagnoseReportUI.this.startActivity(intent);
            AppMethodBeat.m2505o(26018);
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI$2 */
    class C294662 implements OnMenuItemClickListener {
        C294662() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(26017);
            NetworkDiagnoseReportUI.this.finish();
            AppMethodBeat.m2505o(26017);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI$4 */
    class C353274 implements OnClickListener {
        C353274() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26019);
            if (!C5046bo.isNullOrNil(NetworkDiagnoseReportUI.sIs)) {
                File file = new File(NetworkDiagnoseReportUI.sIs);
                if (file.exists()) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    C15429k.m23713a(NetworkDiagnoseReportUI.this.mController.ylL, intent, file, "text/plain");
                    intent.addFlags(268435456);
                    NetworkDiagnoseReportUI.this.startActivity(intent);
                }
            }
            AppMethodBeat.m2505o(26019);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(26020);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(26020);
    }

    public final void initView() {
        AppMethodBeat.m2504i(26021);
        setMMTitle("");
        this.sJj = (ImageView) findViewById(2131826329);
        this.sJk = (TextView) findViewById(2131826330);
        this.sJl = (TextView) findViewById(2131826331);
        this.sJg = getIntent().getBooleanExtra("diagnose_result", false);
        if (this.sJg) {
            this.sJj.setImageResource(C25738R.drawable.ajz);
            this.sJk.setText(getString(C25738R.string.ezb));
            this.sJl.setVisibility(0);
            addTextOptionMenu(0, getString(C25738R.string.b5l), new C140071());
            AppMethodBeat.m2505o(26021);
            return;
        }
        setBackBtn(new C294662());
        sIs = getIntent().getStringExtra("diagnose_log_file_path");
        this.sJj.setImageResource(C25738R.drawable.ajy);
        this.sJk.setText(getString(C25738R.string.eza));
        if (sIs == null || C1173e.m2560cs(sIs) <= 0) {
            AppMethodBeat.m2505o(26021);
            return;
        }
        this.sJm = (TextView) findViewById(2131826334);
        this.sJm.setText(getString(C25738R.string.dqq, new Object[]{sIs.replace("mnt/", "")}));
        findViewById(2131826334).setVisibility(0);
        findViewById(2131826336).setVisibility(0);
        this.sJh = (Button) findViewById(2131826335);
        this.sJh.setVisibility(0);
        this.sJh.setOnClickListener(new C224353());
        this.sJi = (Button) findViewById(2131826333);
        this.sJi.setVisibility(0);
        this.sJi.setOnClickListener(new C353274());
        AppMethodBeat.m2505o(26021);
    }

    public final int getLayoutId() {
        return 2130970298;
    }

    /* renamed from: a */
    static /* synthetic */ String m57992a(NetworkDiagnoseReportUI networkDiagnoseReportUI) {
        AppMethodBeat.m2504i(26022);
        String string = networkDiagnoseReportUI.getString(C25738R.string.dqp);
        File file = new File(sIs);
        if (file.exists()) {
            String name = file.getName();
            if (C5046bo.isNullOrNil(name)) {
                AppMethodBeat.m2505o(26022);
                return string;
            }
            int indexOf = name.indexOf(".");
            StringBuilder append = new StringBuilder().append(string).append("_");
            if (indexOf <= 0) {
                indexOf = name.length();
            }
            String stringBuilder = append.append(name.substring(0, indexOf)).toString();
            AppMethodBeat.m2505o(26022);
            return stringBuilder;
        }
        AppMethodBeat.m2505o(26022);
        return string;
    }
}
