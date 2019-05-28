package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(7)
public class CardShowWaringTransparentUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.kc;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(88652);
        super.onCreate(bundle);
        h.a((Context) this, getString(R.string.ai4, new Object[]{getIntent().getStringExtra("KEY_BRAND_NAME")}), getString(R.string.ai5), getString(R.string.aew), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(88651);
                dialogInterface.dismiss();
                CardShowWaringTransparentUI.this.finish();
                AppMethodBeat.o(88651);
            }
        });
        AppMethodBeat.o(88652);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(88653);
        if (i == 4) {
            finish();
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(88653);
        return onKeyUp;
    }
}
