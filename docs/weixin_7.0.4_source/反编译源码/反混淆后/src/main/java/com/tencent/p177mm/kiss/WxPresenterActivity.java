package com.tencent.p177mm.kiss;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.vending.app.C16025a;
import com.tencent.p177mm.vending.app.C40919c;
import com.tencent.p177mm.vending.p637c.C24135b;
import com.tencent.p177mm.vending.p639e.C5684a;

/* renamed from: com.tencent.mm.kiss.WxPresenterActivity */
public abstract class WxPresenterActivity extends MMActivity {
    protected C40919c eMI = new C40919c();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eMI.mo64539A(getIntent(), this);
    }

    public void onResume() {
        super.onResume();
        this.eMI.mo64542a(2);
    }

    public void onPause() {
        this.eMI.mo64542a(3);
        super.onPause();
    }

    public void onDestroy() {
        this.eMI.onDestroy();
        super.onDestroy();
    }

    public void keep(C5684a c5684a) {
        this.eMI.keep(c5684a);
    }

    /* renamed from: V */
    public final <T extends C24135b<? extends C16025a>> T mo20831V(Class<? extends C24135b<? extends C16025a>> cls) {
        return this.eMI.mo64541a(this, cls);
    }

    /* renamed from: SK */
    public final C16025a mo20830SK() {
        return this.eMI.mo64540SK();
    }
}
