package com.tencent.p177mm.plugin.fts.p419a.p421d;

import android.content.Context;
import android.view.View;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.a.d.b */
public abstract class C3158b implements C45970e {
    protected Context context;
    protected C39133b mEZ;
    protected int mFa;

    public C3158b(Context context, C39133b c39133b, int i) {
        this.context = context;
        this.mEZ = c39133b;
        this.mFa = i;
    }

    /* renamed from: bX */
    protected static boolean m5391bX(List<? extends Object> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        return true;
    }

    /* renamed from: bY */
    protected static <T> List<T> m5392bY(List<T> list) {
        if (!C3158b.m5391bX(list) || list.size() <= 3) {
            return list;
        }
        return list.subList(0, 3);
    }

    /* renamed from: a */
    public boolean mo7424a(View view, C3154a c3154a, boolean z) {
        return false;
    }
}
