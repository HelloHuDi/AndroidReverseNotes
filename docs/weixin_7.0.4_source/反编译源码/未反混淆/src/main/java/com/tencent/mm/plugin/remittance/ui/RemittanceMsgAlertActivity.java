package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.c;

public class RemittanceMsgAlertActivity extends AppCompatActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45083);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        a b = new a(this).asL(ah.getContext().getString(getIntent().getBooleanExtra("key_is_no_contact", false) ? R.string.dpa : R.string.dp_)).Qh(ah.getContext().getResources().getColor(R.color.a61)).Qg(R.string.cd_).b(new c() {
            public final void d(boolean z, String str) {
            }
        });
        b.b(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(45082);
                RemittanceMsgAlertActivity.this.finish();
                AppMethodBeat.o(45082);
            }
        });
        b.show();
        AppMethodBeat.o(45083);
    }

    public void onDestroy() {
        AppMethodBeat.i(45084);
        super.onDestroy();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(45084);
    }
}
