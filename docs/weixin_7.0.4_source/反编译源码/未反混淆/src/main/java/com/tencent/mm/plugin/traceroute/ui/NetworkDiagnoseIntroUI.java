package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.traceroute.a.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;

public class NetworkDiagnoseIntroUI extends MMActivity {
    private Button sJd;
    private TextView sJe;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26014);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(26014);
    }

    public final void initView() {
        AppMethodBeat.i(26015);
        this.sJd = (Button) findViewById(R.id.dhb);
        this.sJd.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(26011);
                aw.ZK();
                if (!c.isSDCardAvailable()) {
                    t.hO(NetworkDiagnoseIntroUI.this);
                    AppMethodBeat.o(26011);
                } else if (aw.Rg().acS() == 0) {
                    Toast.makeText(NetworkDiagnoseIntroUI.this, NetworkDiagnoseIntroUI.this.getString(R.string.bx9), 0).show();
                    AppMethodBeat.o(26011);
                } else {
                    NetworkDiagnoseIntroUI.this.startActivity(new Intent(NetworkDiagnoseIntroUI.this, NetworkDiagnoseUI.class));
                    NetworkDiagnoseIntroUI.this.finish();
                    AppMethodBeat.o(26011);
                }
            }
        });
        this.sJe = (TextView) findViewById(R.id.dhc);
        this.sJe.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(26012);
                Intent intent = new Intent();
                intent.putExtra("title", NetworkDiagnoseIntroUI.this.getString(R.string.dek));
                intent.putExtra("rawUrl", NetworkDiagnoseIntroUI.this.getString(R.string.ezj));
                intent.putExtra("showShare", false);
                a.gkE.i(intent, NetworkDiagnoseIntroUI.this.mController.ylL);
                AppMethodBeat.o(26012);
            }
        });
        setMMTitle("");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26013);
                NetworkDiagnoseIntroUI.this.finish();
                AppMethodBeat.o(26013);
                return true;
            }
        });
        AppMethodBeat.o(26015);
    }

    public final int getLayoutId() {
        return R.layout.aip;
    }
}
