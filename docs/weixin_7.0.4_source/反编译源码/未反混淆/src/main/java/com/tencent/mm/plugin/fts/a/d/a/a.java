package com.tencent.mm.plugin.fts.a.d.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class a {
    public String info;
    public final int klY;
    public g mDz;
    public int mFa;
    public boolean mFj;
    public boolean mFk = true;
    public int mFl;
    public int mFm;
    public int mFn;
    public String mFo;
    public long mFp;
    public boolean mFq;
    public int mFr;
    public int mFs;
    public boolean mFt;
    public int pageType;
    public final int position;

    public abstract class a {
    }

    public abstract class b {
        public abstract View a(Context context, ViewGroup viewGroup);

        public abstract void a(Context context, a aVar, a aVar2, Object... objArr);

        public abstract boolean a(Context context, a aVar);

        protected static void a(String str, l lVar) {
            ((n) com.tencent.mm.kernel.g.M(n.class)).updateTopHitsRank(str, lVar, 0);
        }
    }

    public abstract b Ps();

    public abstract void a(Context context, a aVar, Object... objArr);

    public a(int i, int i2) {
        this.klY = i;
        this.position = i2;
        ab.v("MicroMsg.FTS.FTSDataItem", "create data item | viewType=%d | position=%d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final void ej(int i, int i2) {
        this.mFr = i;
        this.mFs = i2;
        this.mFt = true;
    }

    public int aAq() {
        return 0;
    }

    public String aAp() {
        return "";
    }

    public int bAu() {
        return 0;
    }

    public boolean bAv() {
        return false;
    }

    public int bAw() {
        return 0;
    }
}
