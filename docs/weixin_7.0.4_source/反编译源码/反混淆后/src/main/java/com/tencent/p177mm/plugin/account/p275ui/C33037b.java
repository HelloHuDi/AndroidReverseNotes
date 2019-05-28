package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.applet.SecurityImage;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15494b;
import com.tencent.p177mm.p612ui.base.C30379h;

/* renamed from: com.tencent.mm.plugin.account.ui.b */
public abstract class C33037b extends C15494b {
    C1207m gAi = null;
    SecurityImage gue = null;

    /* renamed from: com.tencent.mm.plugin.account.ui.b$1 */
    class C189591 implements OnClickListener {
        final /* synthetic */ Context gAj;

        C189591(Context context) {
            this.gAj = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(124716);
            final C1207m a = C33037b.this.mo53591a(C33037b.this.gAi, C33037b.this.gue.getSecImgCode());
            C1720g.m3540Rg().mo14541a(a, 0);
            Context context = this.gAj;
            this.gAj.getString(C25738R.string.f9238tz);
            C30379h.m48458b(context, this.gAj.getString(C25738R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(124715);
                    C1720g.m3540Rg().mo14547c(a);
                    AppMethodBeat.m2505o(124715);
                }
            });
            AppMethodBeat.m2505o(124716);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.b$2 */
    class C189602 implements OnDismissListener {
        C189602() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            C33037b.this.gue = null;
        }
    }

    /* renamed from: a */
    public abstract C1207m mo53591a(C1207m c1207m, String str);

    public final void apw() {
        C1720g.m3540Rg().mo14541a(mo53591a(this.gAi, ""), 0);
    }
}
