package com.tencent.mm.platformtools;

import android.app.Activity;
import com.tencent.mm.ai.f;
import java.util.HashSet;
import java.util.Set;

public abstract class d implements f {
    public Activity activity;
    Set<Integer> ggX = new HashSet();

    public abstract boolean b(ag agVar);

    public abstract boolean c(ag agVar);

    public abstract boolean d(ag agVar);

    public abstract boolean e(ag agVar);

    public d(Activity activity) {
        this.activity = activity;
    }

    public final boolean a(ag agVar) {
        if (agVar.action == 0) {
            return false;
        }
        switch (agVar.action) {
            case 1:
                return b(agVar);
            case 2:
                return c(agVar);
            case 4:
                return d(agVar);
            case 5:
                return e(agVar);
            default:
                return false;
        }
    }
}
