package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.c.a;

public class FavTipsUI extends MMBaseActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74167);
        super.onCreate(bundle);
        a aVar = new a(this);
        aVar.asD(getString(R.string.bpb));
        aVar.asE(getString(R.string.bp_) + "\n\n" + getString(R.string.bpa));
        aVar.Qc(R.string.bp9).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(74165);
                FavTipsUI.this.finish();
                AppMethodBeat.o(74165);
            }
        });
        aVar.f(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(74166);
                FavTipsUI.this.finish();
                AppMethodBeat.o(74166);
            }
        });
        aVar.aMb().show();
        AppMethodBeat.o(74167);
    }
}
