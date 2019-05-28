package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.IconPreference;

public final class FriendSnsPreference extends IconPreference {
    private Context context;
    private String yhW;
    private Bitmap yhX;
    private long yhY;

    public FriendSnsPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FriendSnsPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.yhW = null;
        this.yhX = null;
        this.context = context;
    }

    public final void aqD(String str) {
        AppMethodBeat.i(29303);
        this.yhX = null;
        this.yeV = -1;
        this.yhW = str;
        this.yhY = 0;
        if (this.olR != null) {
            b.b(this.olR, str);
        }
        AppMethodBeat.o(29303);
    }

    public final void mX(long j) {
        AppMethodBeat.i(29304);
        this.yhW = null;
        this.yhX = null;
        this.yeV = -1;
        this.yhY = j;
        if (!(this.yhY == 0 || this.olR == null)) {
            ((m) g.K(m.class)).a(this.yhY, this.olR, this.mContext.hashCode());
        }
        AppMethodBeat.o(29304);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(29305);
        super.onBindView(view);
        if (this.yhW != null && g.RK()) {
            b.b(this.olR, this.yhW);
        }
        if (!(this.yhY == 0 || this.olR == null)) {
            ((m) g.K(m.class)).a(this.yhY, this.olR, this.mContext.hashCode());
        }
        AppMethodBeat.o(29305);
    }
}
