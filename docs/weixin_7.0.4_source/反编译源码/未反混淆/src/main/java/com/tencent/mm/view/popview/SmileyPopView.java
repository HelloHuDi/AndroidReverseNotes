package com.tencent.mm.view.popview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.b;
import com.tencent.mm.cb.e;
import com.tencent.mm.emoji.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.view.d;

public class SmileyPopView extends AbstractPopView {
    private LayoutParams AdS;
    private View AdV;
    private ImageView AdW;
    private int AdX;
    private TextView nml;

    public SmileyPopView(Context context) {
        this(context, null);
    }

    public SmileyPopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmileyPopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(63070);
        inflate(context, R.layout.u1, this);
        this.AdV = findViewById(R.id.bew);
        this.AdW = (ImageView) findViewById(R.id.bex);
        this.nml = (TextView) findViewById(R.id.bey);
        this.AdS = new LayoutParams(2, d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE, 1);
        this.AdX = getResources().getDimensionPixelOffset(R.dimen.a91);
        this.AdS.width = context.getResources().getDimensionPixelSize(R.dimen.a90);
        this.AdS.height = context.getResources().getDimensionPixelSize(R.dimen.a8y);
        this.AdS.gravity = 49;
        AppMethodBeat.o(63070);
    }

    public void setSmileyItem(f fVar) {
        AppMethodBeat.i(63071);
        String anU = b.dqD().anU(e.dqK().getText(fVar.position));
        ab.i("MicroMsg.SmileyPopView", "pop smiley %s, %s, %s", Integer.valueOf(fVar.position), r0, anU);
        int indexOf = anU.indexOf("[");
        int indexOf2 = anU.indexOf("]");
        if (indexOf2 == -1) {
            indexOf2 = anU.length();
        }
        this.nml.setText(anU.substring(indexOf + 1, indexOf2));
        this.AdW.setImageDrawable(e.dqK().qJ(fVar.position));
        AppMethodBeat.o(63071);
    }

    public LayoutParams getWindowLayoutParams() {
        return this.AdS;
    }

    public final void fw(View view) {
        AppMethodBeat.i(63072);
        view.setPressed(false);
        view.setSelected(false);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = getResources().getDisplayMetrics().widthPixels;
        int measuredWidth = iArr[0] + (view.getMeasuredWidth() / 2);
        int i2 = (this.AdS.width - this.AdX) / 2;
        this.AdS.y = (iArr[1] - this.AdS.height) + view.getMeasuredHeight();
        if (measuredWidth < this.AdS.width / 2) {
            this.AdV.setBackgroundResource(R.raw.emoji_pop_bg_smiley_left);
            this.AdS.x = (measuredWidth + i2) - (i / 2);
            AppMethodBeat.o(63072);
        } else if ((this.AdS.width / 2) + measuredWidth > i) {
            this.AdV.setBackgroundResource(R.raw.emoji_pop_bg_smiley_right);
            this.AdS.x = (measuredWidth - i2) - (i / 2);
            AppMethodBeat.o(63072);
        } else {
            this.AdV.setBackgroundResource(R.raw.emoji_pop_bg_smiley);
            this.AdS.x = measuredWidth - (i / 2);
            AppMethodBeat.o(63072);
        }
    }
}
