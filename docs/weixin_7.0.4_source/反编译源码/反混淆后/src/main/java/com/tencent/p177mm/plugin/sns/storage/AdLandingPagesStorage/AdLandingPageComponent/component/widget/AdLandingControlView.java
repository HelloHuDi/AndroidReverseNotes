package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MMPageControlView;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingControlView */
public class AdLandingControlView extends MMPageControlView {
    public AdLandingControlView(Context context) {
        super(context);
    }

    public AdLandingControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: Dr */
    public final void mo26032Dr(int i) {
        AppMethodBeat.m2504i(37368);
        removeAllViews();
        if (i >= this.count) {
            AppMethodBeat.m2505o(37368);
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
                    this.cAw = (ImageView) View.inflate(this.context, this.yvY, null).findViewById(2131826106);
                    this.map.put(Integer.valueOf(i3), this.cAw);
                }
                this.cAw.setSelected(true);
            } else {
                if (this.map.size() > i3) {
                    this.cAw = (ImageView) this.map.get(Integer.valueOf(i3));
                }
                if (this.cAw == null) {
                    this.cAw = (ImageView) View.inflate(this.context, this.yvY, null).findViewById(2131826106);
                    this.map.put(Integer.valueOf(i3), this.cAw);
                }
                this.cAw.setSelected(false);
            }
            addView(this.cAw);
        }
        AppMethodBeat.m2505o(37368);
    }
}
