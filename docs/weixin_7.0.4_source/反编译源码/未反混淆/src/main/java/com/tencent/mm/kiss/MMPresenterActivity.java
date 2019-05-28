package com.tencent.mm.kiss;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.app.c;

public abstract class MMPresenterActivity extends MMActivity {
    private c eMI = new c();

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
        super.onPause();
        this.eMI.a(3);
    }

    public void onDestroy() {
        super.onDestroy();
        this.eMI.onDestroy();
    }
}
