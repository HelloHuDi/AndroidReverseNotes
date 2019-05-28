package com.tencent.toybrick.p1427ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.BaseActivity;
import com.tencent.toybrick.p680c.C44559f;
import java.util.HashMap;

/* renamed from: com.tencent.toybrick.ui.BaseToyUI */
public abstract class BaseToyUI<T extends C44559f> extends BaseActivity {
    /* renamed from: cS */
    private HashMap<String, C44559f> f15465cS = new HashMap();

    /* renamed from: com.tencent.toybrick.ui.BaseToyUI$a */
    public enum C31116a {
        CHANGE,
        INSERT,
        REMOVE;

        static {
            AppMethodBeat.m2505o(113247);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f15465cS.clear();
    }
}
