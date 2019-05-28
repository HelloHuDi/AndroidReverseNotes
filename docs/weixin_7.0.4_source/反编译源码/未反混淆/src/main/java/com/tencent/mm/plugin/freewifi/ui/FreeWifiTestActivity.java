package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.h;

public class FreeWifiTestActivity extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21110);
        super.onCreate(bundle);
        setContentView(R.layout.a0v);
        findViewById(R.id.bwy).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21108);
                Toast.makeText(ah.getContext(), "test message", 0).show();
                AppMethodBeat.o(21108);
            }
        });
        findViewById(R.id.bwz).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21109);
                h.a(FreeWifiTestActivity.this, "t12345", "t54331", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, null);
                AppMethodBeat.o(21109);
            }
        });
        AppMethodBeat.o(21110);
    }
}
