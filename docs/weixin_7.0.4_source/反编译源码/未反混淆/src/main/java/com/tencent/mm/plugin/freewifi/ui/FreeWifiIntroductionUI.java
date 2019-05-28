package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiIntroductionUI extends MMActivity {
    private int cvd;
    private Button mxV;
    private Button mzt;
    private Button mzu;
    private CheckBox mzv;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21003);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(21003);
    }

    public final void initView() {
        AppMethodBeat.i(21004);
        this.mzt = (Button) findViewById(R.id.bw9);
        this.mzv = (CheckBox) findViewById(R.id.bw7);
        this.mxV = (Button) findViewById(R.id.bw_);
        this.mzu = (Button) findViewById(R.id.bw8);
        this.cvd = getIntent().getIntExtra("free_wifi_source", 1);
        if (this.cvd == 3) {
            setMMTitle((int) R.string.czt);
            ((TextView) findViewById(R.id.bw6)).setText(R.string.czr);
            ((TextView) findViewById(R.id.bw5)).setText(R.string.czq);
            this.mxV.setVisibility(8);
        } else {
            setMMTitle((int) R.string.c0t);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(20998);
                FreeWifiIntroductionUI.this.finish();
                AppMethodBeat.o(20998);
                return false;
            }
        });
        this.mzt.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(20999);
                aw.ZK();
                c.Ry().set(303104, Integer.valueOf(1));
                Intent intent = FreeWifiIntroductionUI.this.getIntent();
                intent.setClass(FreeWifiIntroductionUI.this, FreeWifiEntryUI.class);
                FreeWifiIntroductionUI.this.startActivity(intent);
                FreeWifiIntroductionUI.this.finish();
                AppMethodBeat.o(20999);
            }
        });
        this.mzv.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(21000);
                if (z) {
                    FreeWifiIntroductionUI.this.mzt.setEnabled(true);
                    AppMethodBeat.o(21000);
                    return;
                }
                FreeWifiIntroductionUI.this.mzt.setEnabled(false);
                AppMethodBeat.o(21000);
            }
        });
        this.mzu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                String string;
                AppMethodBeat.i(21001);
                if (FreeWifiIntroductionUI.this.cvd == 3) {
                    string = FreeWifiIntroductionUI.this.getString(R.string.czs);
                } else {
                    string = FreeWifiIntroductionUI.this.getString(R.string.c0q);
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                d.b(FreeWifiIntroductionUI.this, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(21001);
            }
        });
        this.mxV.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21002);
                String string = FreeWifiIntroductionUI.this.getString(R.string.c07);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                d.b(FreeWifiIntroductionUI.this, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(21002);
            }
        });
        AppMethodBeat.o(21004);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return R.layout.a0n;
    }
}
