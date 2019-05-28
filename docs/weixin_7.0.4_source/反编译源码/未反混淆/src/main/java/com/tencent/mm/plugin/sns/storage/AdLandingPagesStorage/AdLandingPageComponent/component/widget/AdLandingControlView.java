package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.MMPageControlView;

public class AdLandingControlView extends MMPageControlView {
    public AdLandingControlView(Context context) {
        super(context);
    }

    public AdLandingControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void Dr(int i) {
        AppMethodBeat.i(37368);
        removeAllViews();
        if (i >= this.count) {
            AppMethodBeat.o(37368);
            return;
        }
        int i2 = this.count;
        for (int i3 = 0; i3 < i2; i3++) {
            this.cAw = null;
            if (i == i3) {
                if (this.map.size() > i3) {
                    this.cAw = (ImageView) this.map.get(Integer.valueOf(i3));
                }
                if (this.cAw == null) {
                    this.cAw = (ImageView) View.inflate(this.context, this.yvY, null).findViewById(R.id.dbc);
                    this.map.put(Integer.valueOf(i3), this.cAw);
                }
                this.cAw.setSelected(true);
            } else {
                if (this.map.size() > i3) {
                    this.cAw = (ImageView) this.map.get(Integer.valueOf(i3));
                }
                if (this.cAw == null) {
                    this.cAw = (ImageView) View.inflate(this.context, this.yvY, null).findViewById(R.id.dbc);
                    this.map.put(Integer.valueOf(i3), this.cAw);
                }
                this.cAw.setSelected(false);
            }
            addView(this.cAw);
        }
        AppMethodBeat.o(37368);
    }
}
