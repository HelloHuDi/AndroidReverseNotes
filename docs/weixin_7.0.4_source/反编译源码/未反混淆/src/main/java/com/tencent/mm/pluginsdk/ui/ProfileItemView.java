package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mm.storage.ad;

public abstract class ProfileItemView extends FrameLayout {
    public ad ldh;

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

    public boolean T(ad adVar) {
        this.ldh = adVar;
        return cby();
    }
}
