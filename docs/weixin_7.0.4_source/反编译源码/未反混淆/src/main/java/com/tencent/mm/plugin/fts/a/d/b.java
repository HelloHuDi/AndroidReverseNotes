package com.tencent.mm.plugin.fts.a.d;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.fts.a.d.a.a;
import java.util.List;

public abstract class b implements e {
    protected Context context;
    protected com.tencent.mm.plugin.fts.a.d.e.b mEZ;
    protected int mFa;

    public b(Context context, com.tencent.mm.plugin.fts.a.d.e.b bVar, int i) {
        this.context = context;
        this.mEZ = bVar;
        this.mFa = i;
    }

    protected static boolean bX(List<? extends Object> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        return true;
    }

    protected static <T> List<T> bY(List<T> list) {
        if (!bX(list) || list.size() <= 3) {
            return list;
        }
        return list.subList(0, 3);
    }

    public boolean a(View view, a aVar, boolean z) {
        return false;
    }
}
