package com.tencent.p177mm.plugin.webwx.p582ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.plugin.webwx.C4660a;
import com.tencent.p177mm.plugin.webwx.p1071a.C40356b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI */
public class WebWXPopupUnlockUI extends MMBaseActivity {

    /* renamed from: com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI$2 */
    class C46632 implements OnDismissListener {
        C46632() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(26569);
            WebWXPopupUnlockUI.this.finish();
            AppMethodBeat.m2505o(26569);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(26570);
        super.onCreate(bundle);
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("deviceName");
            if (stringExtra != null) {
                final Dialog dialog = new Dialog(this);
                dialog.requestWindowFeature(1);
                View inflate = View.inflate(this, 2130969452, null);
                TextView textView = (TextView) inflate.findViewById(2131823736);
                ((TextView) inflate.findViewById(2131823737)).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(26568);
                        C9638aw.m17182Rg().mo14541a(new C40356b(2), 0);
                        C4990ab.m7410d("MicroMsg.WebWxPopUnlockUI", "doScene netSceneExtDeviceControl : UNLOCK");
                        C4660a.gkF.mo38869gk(1);
                        C4990ab.m7410d("MicroMsg.WebWxPopUnlockUI", "trigger netSceneSync notify");
                        dialog.dismiss();
                        AppMethodBeat.m2505o(26568);
                    }
                });
                dialog.setOnDismissListener(new C46632());
                textView.setText(stringExtra);
                dialog.setContentView(inflate);
                dialog.show();
                AppMethodBeat.m2505o(26570);
                return;
            }
            C4990ab.m7420w("MicroMsg.WebWxPopUnlockUI", "Mac WeChat request to unlock,the deviceName is null");
        }
        AppMethodBeat.m2505o(26570);
    }
}
