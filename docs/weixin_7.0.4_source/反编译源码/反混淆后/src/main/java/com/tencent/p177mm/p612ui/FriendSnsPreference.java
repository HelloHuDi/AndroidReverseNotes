package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.base.preference.IconPreference;
import com.tencent.p177mm.plugin.sns.p1024b.C29034m;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;

/* renamed from: com.tencent.mm.ui.FriendSnsPreference */
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
        AppMethodBeat.m2504i(29303);
        this.yhX = null;
        this.yeV = -1;
        this.yhW = str;
        this.yhY = 0;
        if (this.olR != null) {
            C40460b.m69434b(this.olR, str);
        }
        AppMethodBeat.m2505o(29303);
    }

    /* renamed from: mX */
    public final void mo10655mX(long j) {
        AppMethodBeat.m2504i(29304);
        this.yhW = null;
        this.yhX = null;
        this.yeV = -1;
        this.yhY = j;
        if (!(this.yhY == 0 || this.olR == null)) {
            ((C29034m) C1720g.m3528K(C29034m.class)).mo47120a(this.yhY, this.olR, this.mContext.hashCode());
        }
        AppMethodBeat.m2505o(29304);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(29305);
        super.onBindView(view);
        if (this.yhW != null && C1720g.m3531RK()) {
            C40460b.m69434b(this.olR, this.yhW);
        }
        if (!(this.yhY == 0 || this.olR == null)) {
            ((C29034m) C1720g.m3528K(C29034m.class)).mo47120a(this.yhY, this.olR, this.mContext.hashCode());
        }
        AppMethodBeat.m2505o(29305);
    }
}
