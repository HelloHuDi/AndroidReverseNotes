package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ad;

public abstract class a {
    public static final int mHw = com.tencent.mm.bz.a.al(ah.getContext(), R.dimen.m5);
    public static final TextPaint mHx = new TextPaint();
    public static final int mHy = com.tencent.mm.bz.a.al(ah.getContext(), R.dimen.kr);
    public static final TextPaint mHz = new TextPaint();
    public String cuP;
    public boolean eDk;
    public ad ehM;
    public boolean jLx;
    public final int klY;
    public g mDz;
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

    public class a {
    }

    public abstract class b {
        public abstract View a(Context context, ViewGroup viewGroup);

        public abstract void a(Context context, a aVar, a aVar2, boolean z, boolean z2);

        public abstract boolean aov();
    }

    public abstract void a(Context context, a aVar);

    public abstract b aou();

    static {
        mHx.setTextSize((float) mHw);
        mHz.setTextSize((float) mHy);
    }

    public a(int i, int i2) {
        this.klY = i;
        this.position = i2;
        ab.i("MicroMsg.BaseContactDataItem", "Create BaseContactDataItem viewType=%d | position=%d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final void ej(int i, int i2) {
        this.mFr = i;
        this.mFs = i2;
    }

    public boolean bAv() {
        return false;
    }
}
