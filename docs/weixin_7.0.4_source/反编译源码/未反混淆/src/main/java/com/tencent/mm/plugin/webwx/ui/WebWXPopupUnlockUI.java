package com.tencent.mm.plugin.webwx.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.webwx.a;
import com.tencent.mm.plugin.webwx.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMBaseActivity;

public class WebWXPopupUnlockUI extends MMBaseActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26570);
        super.onCreate(bundle);
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("deviceName");
            if (stringExtra != null) {
                final Dialog dialog = new Dialog(this);
                dialog.requestWindowFeature(1);
                View inflate = View.inflate(this, R.layout.wx, null);
                TextView textView = (TextView) inflate.findViewById(R.id.bl_);
                ((TextView) inflate.findViewById(R.id.bla)).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(26568);
                        aw.Rg().a(new b(2), 0);
                        ab.d("MicroMsg.WebWxPopUnlockUI", "doScene netSceneExtDeviceControl : UNLOCK");
                        a.gkF.gk(1);
                        ab.d("MicroMsg.WebWxPopUnlockUI", "trigger netSceneSync notify");
                        dialog.dismiss();
                        AppMethodBeat.o(26568);
                    }
                });
                dialog.setOnDismissListener(new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(26569);
                        WebWXPopupUnlockUI.this.finish();
                        AppMethodBeat.o(26569);
                    }
                });
                textView.setText(stringExtra);
                dialog.setContentView(inflate);
                dialog.show();
                AppMethodBeat.o(26570);
                return;
            }
            ab.w("MicroMsg.WebWxPopUnlockUI", "Mac WeChat request to unlock,the deviceName is null");
        }
        AppMethodBeat.o(26570);
    }
}
