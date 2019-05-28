package com.tencent.mm.plugin.freewifi.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiErrorUI extends MMActivity {
    private ImageView myL;
    private TextView myM;
    private TextView myN;
    private TextView myO;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(20958);
        super.onCreate(bundle);
        setMMTitle((int) R.string.c0t);
        this.myL = (ImageView) findViewById(R.id.bvs);
        if (getIntent().getIntExtra("free_wifi_show_detail_error", 0) == 1) {
            this.myL.setImageResource(R.drawable.aec);
        }
        this.myM = (TextView) findViewById(R.id.bvt);
        this.myN = (TextView) findViewById(R.id.bvu);
        this.myO = (TextView) findViewById(R.id.bvv);
        String stringExtra = getIntent().getStringExtra("free_wifi_error_ui_error_msg");
        String stringExtra2 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail1");
        String stringExtra3 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail12");
        if (!m.isEmpty(stringExtra)) {
            this.myM.setText(stringExtra);
        }
        if (!m.isEmpty(stringExtra2)) {
            this.myN.setText(stringExtra2);
        }
        if (!m.isEmpty(stringExtra3)) {
            this.myO.setText(stringExtra3);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(20957);
                FreeWifiErrorUI.this.finish();
                AppMethodBeat.o(20957);
                return true;
            }
        });
        AppMethodBeat.o(20958);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return R.layout.a0l;
    }
}
