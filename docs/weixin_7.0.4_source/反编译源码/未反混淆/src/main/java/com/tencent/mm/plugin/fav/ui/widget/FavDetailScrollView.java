package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMLoadScrollView;

public class FavDetailScrollView extends MMLoadScrollView {
    private a mpD;

    public interface a {
        void bwe();

        void bwf();
    }

    public FavDetailScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FavDetailScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnScrollChangeListener(a aVar) {
        this.mpD = aVar;
    }

    /* Access modifiers changed, original: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(74670);
        super.onScrollChanged(i, i2, i3, i4);
        if (getScrollY() != 0 || this.mpD == null) {
            if (this.mpD != null) {
                this.mpD.bwe();
            }
            AppMethodBeat.o(74670);
            return;
        }
        this.mpD.bwf();
        AppMethodBeat.o(74670);
    }
}
