package com.tencent.mm.vending.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.e.b;

public abstract class PresenterActivity extends Activity implements b {
    private c zXm = new c();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zXm.A(getIntent(), this);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        super.onResume();
        this.zXm.a(2);
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        this.zXm.a(3);
        super.onPause();
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        this.zXm.onDestroy();
        super.onDestroy();
    }
}
