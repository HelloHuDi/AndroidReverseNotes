package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.base.MMPageControlView */
public class MMPageControlView extends LinearLayout {
    protected ImageView cAw;
    protected Context context;
    protected int count;
    protected Map<Integer, ImageView> map = new HashMap();
    protected int yvY = 2130970231;

    /* renamed from: hj */
    public final void mo69952hj(int i, int i2) {
        AppMethodBeat.m2504i(106699);
        this.count = i;
        mo26032Dr(i2);
        AppMethodBeat.m2505o(106699);
    }

    public void setPage(int i) {
        AppMethodBeat.m2504i(106700);
        mo26032Dr(i);
        AppMethodBeat.m2505o(106700);
    }

    public void setIndicatorLayoutRes(int i) {
        this.yvY = i;
    }

    public MMPageControlView(Context context) {
        super(context);
        AppMethodBeat.m2504i(106701);
        this.context = context;
        AppMethodBeat.m2505o(106701);
    }

    public MMPageControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106702);
        this.context = context;
        AppMethodBeat.m2505o(106702);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Dr */
    public void mo26032Dr(int i) {
        AppMethodBeat.m2504i(106703);
        removeAllViews();
        if (i >= this.count) {
            AppMethodBeat.m2505o(106703);
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
            if (i3 == 0) {
                this.cAw.setPadding(0, 0, 0, 0);
            }
            addView(this.cAw);
        }
        AppMethodBeat.m2505o(106703);
    }
}
