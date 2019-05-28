package com.tencent.mm.kiss;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.e.a;

public abstract class WxPresenterActivity extends MMActivity {
    protected c eMI = new c();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eMI.A(getIntent(), this);
    }

    public void onResume() {
        super.onResume();
        this.eMI.a(2);
    }

    public void onPause() {
        this.eMI.a(3);
        super.onPause();
    }

    public void onDestroy() {
        this.eMI.onDestroy();
        super.onDestroy();
    }

    public void keep(a aVar) {
        this.eMI.keep(aVar);
    }

    public final <T extends b<? extends com.tencent.mm.vending.app.a>> T V(Class<? extends b<? extends com.tencent.mm.vending.app.a>> cls) {
        return this.eMI.a(this, cls);
    }

    public final com.tencent.mm.vending.app.a SK() {
        return this.eMI.SK();
    }
}
