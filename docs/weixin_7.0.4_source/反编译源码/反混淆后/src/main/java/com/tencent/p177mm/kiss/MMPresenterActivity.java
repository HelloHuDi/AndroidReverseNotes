package com.tencent.p177mm.kiss;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.vending.app.C40919c;

/* renamed from: com.tencent.mm.kiss.MMPresenterActivity */
public abstract class MMPresenterActivity extends MMActivity {
    private C40919c eMI = new C40919c();

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
        super.onPause();
        this.eMI.mo64542a(3);
    }

    public void onDestroy() {
        super.onDestroy();
        this.eMI.onDestroy();
    }
}
