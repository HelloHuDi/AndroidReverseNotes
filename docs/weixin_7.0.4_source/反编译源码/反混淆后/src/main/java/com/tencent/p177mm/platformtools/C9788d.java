package com.tencent.p177mm.platformtools;

import android.app.Activity;
import com.tencent.p177mm.p183ai.C1202f;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.platformtools.d */
public abstract class C9788d implements C1202f {
    public Activity activity;
    Set<Integer> ggX = new HashSet();

    /* renamed from: b */
    public abstract boolean mo5703b(C45475ag c45475ag);

    /* renamed from: c */
    public abstract boolean mo5704c(C45475ag c45475ag);

    /* renamed from: d */
    public abstract boolean mo5705d(C45475ag c45475ag);

    /* renamed from: e */
    public abstract boolean mo5706e(C45475ag c45475ag);

    public C9788d(Activity activity) {
        this.activity = activity;
    }

    /* renamed from: a */
    public final boolean mo21143a(C45475ag c45475ag) {
        if (c45475ag.action == 0) {
            return false;
        }
        switch (c45475ag.action) {
            case 1:
                return mo5703b(c45475ag);
            case 2:
                return mo5704c(c45475ag);
            case 4:
                return mo5705d(c45475ag);
            case 5:
                return mo5706e(c45475ag);
            default:
                return false;
        }
    }
}
