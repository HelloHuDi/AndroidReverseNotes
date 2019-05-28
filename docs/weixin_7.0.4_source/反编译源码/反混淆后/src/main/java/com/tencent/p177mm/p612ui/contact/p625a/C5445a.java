package com.tencent.p177mm.p612ui.contact.p625a;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.ui.contact.a.a */
public abstract class C5445a {
    public static final int mHw = C1338a.m2856al(C4996ah.getContext(), C25738R.dimen.f9980m5);
    public static final TextPaint mHx = new TextPaint();
    public static final int mHy = C1338a.m2856al(C4996ah.getContext(), C25738R.dimen.f9936kr);
    public static final TextPaint mHz = new TextPaint();
    public String cuP;
    public boolean eDk;
    public C7616ad ehM;
    public boolean jLx;
    public final int klY;
    public C20840g mDz;
    public int mFm;
    public int mFr;
    public int mFs;
    public final int position;
    public String query;
    public int scene;
    public boolean zmW;
    public boolean zmX;
    public boolean zpA;
    boolean zpB;
    public boolean zpC;

    /* renamed from: com.tencent.mm.ui.contact.a.a$a */
    public class C5446a {
    }

    /* renamed from: com.tencent.mm.ui.contact.a.a$b */
    public abstract class C5447b {
        /* renamed from: a */
        public abstract View mo11086a(Context context, ViewGroup viewGroup);

        /* renamed from: a */
        public abstract void mo11087a(Context context, C5446a c5446a, C5445a c5445a, boolean z, boolean z2);

        public abstract boolean aov();
    }

    /* renamed from: a */
    public abstract void mo11082a(Context context, C5446a c5446a);

    public abstract C5447b aou();

    static {
        mHx.setTextSize((float) mHw);
        mHz.setTextSize((float) mHy);
    }

    public C5445a(int i, int i2) {
        this.klY = i;
        this.position = i2;
        C4990ab.m7417i("MicroMsg.BaseContactDataItem", "Create BaseContactDataItem viewType=%d | position=%d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* renamed from: ej */
    public final void mo11085ej(int i, int i2) {
        this.mFr = i;
        this.mFs = i2;
    }

    public boolean bAv() {
        return false;
    }
}
