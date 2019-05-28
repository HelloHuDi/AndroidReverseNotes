package com.tencent.p177mm.plugin.fav.p410ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMLoadScrollView;

/* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavDetailScrollView */
public class FavDetailScrollView extends MMLoadScrollView {
    private C36774a mpD;

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavDetailScrollView$a */
    public interface C36774a {
        void bwe();

        void bwf();
    }

    public FavDetailScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FavDetailScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnScrollChangeListener(C36774a c36774a) {
        this.mpD = c36774a;
    }

    /* Access modifiers changed, original: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(74670);
        super.onScrollChanged(i, i2, i3, i4);
        if (getScrollY() != 0 || this.mpD == null) {
            if (this.mpD != null) {
                this.mpD.bwe();
            }
            AppMethodBeat.m2505o(74670);
            return;
        }
        this.mpD.bwf();
        AppMethodBeat.m2505o(74670);
    }
}
