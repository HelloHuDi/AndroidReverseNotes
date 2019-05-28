package com.tencent.toybrick.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.toybrick.c.f;
import java.util.HashMap;

public abstract class BaseToyUI<T extends f> extends BaseActivity {
    private HashMap<String, f> cS = new HashMap();

    public enum a {
        CHANGE,
        INSERT,
        REMOVE;

        static {
            AppMethodBeat.o(113247);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onDestroy() {
        super.onDestroy();
        this.cS.clear();
    }
}
