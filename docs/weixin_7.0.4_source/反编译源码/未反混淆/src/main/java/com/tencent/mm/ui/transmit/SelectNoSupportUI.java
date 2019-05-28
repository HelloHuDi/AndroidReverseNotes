package com.tencent.mm.ui.transmit;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public class SelectNoSupportUI extends MMActivity {
    private String zKq = "friend";
    private TextView zKr;
    private TextView zKs;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.agk;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(35209);
        super.onCreate(bundle);
        ab.i("MicroMsg.SelectNoSupportUI", "onCreate!");
        this.zKq = getIntent().getStringExtra("sharePictureTo");
        ab.i("MicroMsg.SelectNoSupportUI", "initData done!");
        initView();
        ab.i("MicroMsg.SelectNoSupportUI", "initView done!");
        AppMethodBeat.o(35209);
    }

    public final void initView() {
        AppMethodBeat.i(35210);
        setMMTitle(getString(R.string.e1v));
        this.zKr = (TextView) findViewById(R.id.db5);
        this.zKs = (TextView) findViewById(R.id.db6);
        this.zKr.setText(getString(R.string.e24));
        String str = this.zKq;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1266283874:
                if (str.equals("friend")) {
                    obj = null;
                    break;
                }
                break;
            case 114040:
                if (str.equals("sns")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                this.zKs.setText(getString(R.string.e25));
                break;
            case 1:
                this.zKs.setText(getString(R.string.e26));
                break;
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(35208);
                SelectNoSupportUI selectNoSupportUI = SelectNoSupportUI.this;
                selectNoSupportUI.aqX();
                selectNoSupportUI.finish();
                AppMethodBeat.o(35208);
                return true;
            }
        });
        AppMethodBeat.o(35210);
    }
}
