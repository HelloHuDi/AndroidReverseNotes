package com.tencent.p177mm.vending.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vending.p639e.C5685b;

/* renamed from: com.tencent.mm.vending.app.PresenterActivity */
public abstract class PresenterActivity extends Activity implements C5685b {
    private C40919c zXm = new C40919c();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zXm.mo64539A(getIntent(), this);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        super.onResume();
        this.zXm.mo64542a(2);
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        this.zXm.mo64542a(3);
        super.onPause();
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        this.zXm.onDestroy();
        super.onDestroy();
    }
}
