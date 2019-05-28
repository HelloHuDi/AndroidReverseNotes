package com.tencent.mm.plugin.downloader.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.a.c;

@a(7)
public class FileDownloadConfirmUI extends MMBaseActivity {
    private c ggF = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(2518);
        super.onCreate(bundle);
        setContentView(R.layout.v8);
        if (d.iW(21)) {
            getWindow().setStatusBarColor(0);
        }
        final long longExtra = getIntent().getLongExtra("extra_download_id", -1);
        OnClickListener anonymousClass1 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(2516);
                com.tencent.mm.plugin.downloader.model.d.bij().hl(longExtra);
                ab.i("MicroMsg.FileDownloadConfirmUI", "Remove task: %d", Long.valueOf(longExtra));
                AppMethodBeat.o(2516);
            }
        };
        OnClickListener anonymousClass2 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        };
        OnDismissListener anonymousClass3 = new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(2517);
                FileDownloadConfirmUI.this.finish();
                AppMethodBeat.o(2517);
            }
        };
        c.a aVar = new c.a(this);
        aVar.asD("");
        aVar.PZ(R.string.bsm);
        aVar.Qc(R.string.up).a(anonymousClass1);
        aVar.Qd(R.string.s2).b(anonymousClass2);
        aVar.a(anonymousClass3);
        this.ggF = aVar.aMb();
        this.ggF.show();
        ab.i("MicroMsg.FileDownloadConfirmUI", "Confirm Dialog");
        AppMethodBeat.o(2518);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(2519);
        ab.i("MicroMsg.FileDownloadConfirmUI", "onNewIntent");
        AppMethodBeat.o(2519);
    }

    /* Access modifiers changed, original: protected */
    public void onStop() {
        AppMethodBeat.i(2520);
        super.onStop();
        this.ggF.dismiss();
        AppMethodBeat.o(2520);
    }
}
