package com.tencent.mm.plugin.traceroute.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.MMActivity;
import java.io.File;

public class NetworkDiagnoseReportUI extends MMActivity {
    private static String sIs;
    private boolean sJg = false;
    private Button sJh;
    private Button sJi;
    private ImageView sJj;
    private TextView sJk;
    private TextView sJl;
    private TextView sJm;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26020);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(26020);
    }

    public final void initView() {
        AppMethodBeat.i(26021);
        setMMTitle("");
        this.sJj = (ImageView) findViewById(R.id.dhd);
        this.sJk = (TextView) findViewById(R.id.dhe);
        this.sJl = (TextView) findViewById(R.id.dhf);
        this.sJg = getIntent().getBooleanExtra("diagnose_result", false);
        if (this.sJg) {
            this.sJj.setImageResource(R.drawable.ajz);
            this.sJk.setText(getString(R.string.ezb));
            this.sJl.setVisibility(0);
            addTextOptionMenu(0, getString(R.string.b5l), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(26016);
                    NetworkDiagnoseReportUI.this.finish();
                    AppMethodBeat.o(26016);
                    return false;
                }
            });
            AppMethodBeat.o(26021);
            return;
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26017);
                NetworkDiagnoseReportUI.this.finish();
                AppMethodBeat.o(26017);
                return true;
            }
        });
        sIs = getIntent().getStringExtra("diagnose_log_file_path");
        this.sJj.setImageResource(R.drawable.ajy);
        this.sJk.setText(getString(R.string.eza));
        if (sIs == null || e.cs(sIs) <= 0) {
            AppMethodBeat.o(26021);
            return;
        }
        this.sJm = (TextView) findViewById(R.id.dhi);
        this.sJm.setText(getString(R.string.dqq, new Object[]{sIs.replace("mnt/", "")}));
        findViewById(R.id.dhi).setVisibility(0);
        findViewById(R.id.dhk).setVisibility(0);
        this.sJh = (Button) findViewById(R.id.dhj);
        this.sJh.setVisibility(0);
        this.sJh.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(26018);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.addFlags(268435456);
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"WeChat_Log@qq.com"});
                intent.putExtra("android.intent.extra.SUBJECT", NetworkDiagnoseReportUI.a(NetworkDiagnoseReportUI.this));
                intent.putExtra("android.intent.extra.STREAM", k.d(NetworkDiagnoseReportUI.this.mController.ylL, new File(NetworkDiagnoseReportUI.sIs)));
                intent.setType("text/plain");
                NetworkDiagnoseReportUI.this.startActivity(intent);
                AppMethodBeat.o(26018);
            }
        });
        this.sJi = (Button) findViewById(R.id.dhh);
        this.sJi.setVisibility(0);
        this.sJi.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(26019);
                if (!bo.isNullOrNil(NetworkDiagnoseReportUI.sIs)) {
                    File file = new File(NetworkDiagnoseReportUI.sIs);
                    if (file.exists()) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        k.a(NetworkDiagnoseReportUI.this.mController.ylL, intent, file, "text/plain");
                        intent.addFlags(268435456);
                        NetworkDiagnoseReportUI.this.startActivity(intent);
                    }
                }
                AppMethodBeat.o(26019);
            }
        });
        AppMethodBeat.o(26021);
    }

    public final int getLayoutId() {
        return R.layout.aiq;
    }

    static /* synthetic */ String a(NetworkDiagnoseReportUI networkDiagnoseReportUI) {
        AppMethodBeat.i(26022);
        String string = networkDiagnoseReportUI.getString(R.string.dqp);
        File file = new File(sIs);
        if (file.exists()) {
            String name = file.getName();
            if (bo.isNullOrNil(name)) {
                AppMethodBeat.o(26022);
                return string;
            }
            int indexOf = name.indexOf(".");
            StringBuilder append = new StringBuilder().append(string).append("_");
            if (indexOf <= 0) {
                indexOf = name.length();
            }
            String stringBuilder = append.append(name.substring(0, indexOf)).toString();
            AppMethodBeat.o(26022);
            return stringBuilder;
        }
        AppMethodBeat.o(26022);
        return string;
    }
}
