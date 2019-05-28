package com.tencent.p177mm.plugin.fts.p419a.p421d.p422a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.fts.a.d.a.a */
public abstract class C3154a {
    public String info;
    public final int klY;
    public C20840g mDz;
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

    /* renamed from: com.tencent.mm.plugin.fts.a.d.a.a$a */
    public abstract class C3155a {
    }

    /* renamed from: com.tencent.mm.plugin.fts.a.d.a.a$b */
    public abstract class C3156b {
        /* renamed from: a */
        public abstract View mo7420a(Context context, ViewGroup viewGroup);

        /* renamed from: a */
        public abstract void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr);

        /* renamed from: a */
        public abstract boolean mo7422a(Context context, C3154a c3154a);

        /* renamed from: a */
        protected static void m5386a(String str, C45966l c45966l) {
            ((C12029n) C1720g.m3530M(C12029n.class)).updateTopHitsRank(str, c45966l, 0);
        }
    }

    /* renamed from: Ps */
    public abstract C3156b mo7412Ps();

    /* renamed from: a */
    public abstract void mo7413a(Context context, C3155a c3155a, Object... objArr);

    public C3154a(int i, int i2) {
        this.klY = i;
        this.position = i2;
        C4990ab.m7419v("MicroMsg.FTS.FTSDataItem", "create data item | viewType=%d | position=%d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* renamed from: ej */
    public final void mo7419ej(int i, int i2) {
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
