package com.tencent.p177mm.plugin.voip.p546ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.voip.ui.MMSuperAlert */
public class MMSuperAlert extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(4783);
        super.onCreate(bundle);
        setContentView(2130970222);
        final int intExtra = getIntent().getIntExtra("MMSuperAlert_msg", 0);
        final int intExtra2 = getIntent().getIntExtra("MMSuperAlert_title", 0);
        final boolean booleanExtra = getIntent().getBooleanExtra("MMSuperAlert_cancelable", true);
        new C7306ak().postDelayed(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.voip.ui.MMSuperAlert$1$2 */
            class C42952 implements OnClickListener {
                C42952() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(4781);
                    MMSuperAlert.this.finish();
                    AppMethodBeat.m2505o(4781);
                }
            }

            /* renamed from: com.tencent.mm.plugin.voip.ui.MMSuperAlert$1$1 */
            class C42961 implements OnClickListener {
                C42961() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(4780);
                    MMSuperAlert.this.finish();
                    AppMethodBeat.m2505o(4780);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(4782);
                C30379h.m48449a(MMSuperAlert.this, intExtra == 0 ? "" : MMSuperAlert.this.getString(intExtra), intExtra2 == 0 ? "" : MMSuperAlert.this.getString(intExtra2), booleanExtra, new C42961(), new C42952());
                AppMethodBeat.m2505o(4782);
            }
        }, 50);
        AppMethodBeat.m2505o(4783);
    }

    /* renamed from: X */
    public static void m6662X(Context context, int i) {
        AppMethodBeat.m2504i(4784);
        Intent intent = new Intent(context, MMSuperAlert.class);
        intent.putExtra("MMSuperAlert_title", C25738R.string.f9238tz);
        intent.putExtra("MMSuperAlert_msg", i);
        intent.putExtra("MMSuperAlert_cancelable", false);
        context.startActivity(intent);
        AppMethodBeat.m2505o(4784);
    }

    public Resources getResources() {
        AppMethodBeat.m2504i(4785);
        Resources resources;
        if (getAssets() == null || C4996ah.getResources() == null) {
            resources = super.getResources();
            AppMethodBeat.m2505o(4785);
            return resources;
        }
        resources = C4996ah.getResources();
        AppMethodBeat.m2505o(4785);
        return resources;
    }
}
