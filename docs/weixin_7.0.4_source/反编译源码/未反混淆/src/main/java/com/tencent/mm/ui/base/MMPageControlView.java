package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.HashMap;
import java.util.Map;

public class MMPageControlView extends LinearLayout {
    protected ImageView cAw;
    protected Context context;
    protected int count;
    protected Map<Integer, ImageView> map = new HashMap();
    protected int yvY = R.layout.agx;

    public final void hj(int i, int i2) {
        AppMethodBeat.i(106699);
        this.count = i;
        Dr(i2);
        AppMethodBeat.o(106699);
    }

    public void setPage(int i) {
        AppMethodBeat.i(106700);
        Dr(i);
        AppMethodBeat.o(106700);
    }

    public void setIndicatorLayoutRes(int i) {
        this.yvY = i;
    }

    public MMPageControlView(Context context) {
        super(context);
        AppMethodBeat.i(106701);
        this.context = context;
        AppMethodBeat.o(106701);
    }

    public MMPageControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106702);
        this.context = context;
        AppMethodBeat.o(106702);
    }

    /* Access modifiers changed, original: protected */
    public void Dr(int i) {
        AppMethodBeat.i(106703);
        removeAllViews();
        if (i >= this.count) {
            AppMethodBeat.o(106703);
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
            if (i3 == 0) {
                this.cAw.setPadding(0, 0, 0, 0);
            }
            addView(this.cAw);
        }
        AppMethodBeat.o(106703);
    }
}
