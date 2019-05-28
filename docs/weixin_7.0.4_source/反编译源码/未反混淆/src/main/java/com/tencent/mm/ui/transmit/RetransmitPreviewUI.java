package com.tencent.mm.ui.transmit;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.g;
import com.tencent.mm.ui.MMActivity;

public class RetransmitPreviewUI extends MMActivity {
    private TextView sW = null;
    private String text = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.mr;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(35121);
        super.onCreate(bundle);
        setMMTitle("");
        this.text = getIntent().getStringExtra("Retr_Msg_content");
        this.sW = (TextView) findViewById(R.id.ash);
        this.sW.setText(g.dqQ().b(this.text, this.sW.getTextSize()));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(35120);
                RetransmitPreviewUI.this.finish();
                AppMethodBeat.o(35120);
                return true;
            }
        });
        AppMethodBeat.o(35121);
    }

    public void onBackPressed() {
        AppMethodBeat.i(35122);
        finish();
        AppMethodBeat.o(35122);
    }

    public void onDestroy() {
        AppMethodBeat.i(35123);
        super.onDestroy();
        AppMethodBeat.o(35123);
    }
}
