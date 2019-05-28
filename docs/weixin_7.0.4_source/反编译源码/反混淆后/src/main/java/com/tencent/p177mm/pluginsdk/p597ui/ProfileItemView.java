package com.tencent.p177mm.pluginsdk.p597ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.pluginsdk.ui.ProfileItemView */
public abstract class ProfileItemView extends FrameLayout {
    public C7616ad ldh;

    public abstract boolean cby();

    public abstract int getLayout();

    public abstract void init();

    public ProfileItemView(Context context) {
        this(context, null);
    }

    public ProfileItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProfileItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(getLayout(), this);
        init();
    }

    /* renamed from: T */
    public boolean mo27223T(C7616ad c7616ad) {
        this.ldh = c7616ad;
        return cby();
    }
}
