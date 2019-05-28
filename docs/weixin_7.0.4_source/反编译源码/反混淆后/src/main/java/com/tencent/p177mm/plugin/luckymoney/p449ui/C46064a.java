package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.content.Context;
import android.os.Bundle;
import android.support.p069v7.app.C6218i;
import android.view.Display;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.a */
public final class C46064a extends C6218i {
    C34503a obT;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.a$a */
    interface C34503a {
        void bMl();
    }

    public C46064a(Context context) {
        super(context, C25738R.style.f10872h4);
        AppMethodBeat.m2504i(42555);
        mo14042fA();
        AppMethodBeat.m2505o(42555);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42556);
        super.onCreate(bundle);
        getWindow().setGravity(80);
        Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
        LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        getWindow().setAttributes(attributes);
        AppMethodBeat.m2505o(42556);
    }

    public final void onBackPressed() {
        AppMethodBeat.m2504i(42557);
        if (this.obT != null) {
            this.obT.bMl();
        }
        AppMethodBeat.m2505o(42557);
    }
}
