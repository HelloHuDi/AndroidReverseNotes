package com.tencent.p177mm.view.popview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.emoji.p227a.C1511f;
import com.tencent.p177mm.p211cb.C26003e;
import com.tencent.p177mm.p211cb.C37626b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.view.popview.SmileyPopView */
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
        AppMethodBeat.m2504i(63070);
        SmileyPopView.inflate(context, 2130969345, this);
        this.AdV = findViewById(2131823500);
        this.AdW = (ImageView) findViewById(2131823501);
        this.nml = (TextView) findViewById(2131823502);
        this.AdS = new LayoutParams(2, C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE, 1);
        this.AdX = getResources().getDimensionPixelOffset(C25738R.dimen.a91);
        this.AdS.width = context.getResources().getDimensionPixelSize(C25738R.dimen.a90);
        this.AdS.height = context.getResources().getDimensionPixelSize(C25738R.dimen.a8y);
        this.AdS.gravity = 49;
        AppMethodBeat.m2505o(63070);
    }

    public void setSmileyItem(C1511f c1511f) {
        AppMethodBeat.m2504i(63071);
        String anU = C37626b.dqD().anU(C26003e.dqK().getText(c1511f.position));
        C4990ab.m7417i("MicroMsg.SmileyPopView", "pop smiley %s, %s, %s", Integer.valueOf(c1511f.position), r0, anU);
        int indexOf = anU.indexOf("[");
        int indexOf2 = anU.indexOf("]");
        if (indexOf2 == -1) {
            indexOf2 = anU.length();
        }
        this.nml.setText(anU.substring(indexOf + 1, indexOf2));
        this.AdW.setImageDrawable(C26003e.dqK().mo43876qJ(c1511f.position));
        AppMethodBeat.m2505o(63071);
    }

    public LayoutParams getWindowLayoutParams() {
        return this.AdS;
    }

    /* renamed from: fw */
    public final void mo49356fw(View view) {
        AppMethodBeat.m2504i(63072);
        view.setPressed(false);
        view.setSelected(false);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = getResources().getDisplayMetrics().widthPixels;
        int measuredWidth = iArr[0] + (view.getMeasuredWidth() / 2);
        int i2 = (this.AdS.width - this.AdX) / 2;
        this.AdS.y = (iArr[1] - this.AdS.height) + view.getMeasuredHeight();
        if (measuredWidth < this.AdS.width / 2) {
            this.AdV.setBackgroundResource(C1318a.emoji_pop_bg_smiley_left);
            this.AdS.x = (measuredWidth + i2) - (i / 2);
            AppMethodBeat.m2505o(63072);
        } else if ((this.AdS.width / 2) + measuredWidth > i) {
            this.AdV.setBackgroundResource(C1318a.emoji_pop_bg_smiley_right);
            this.AdS.x = (measuredWidth - i2) - (i / 2);
            AppMethodBeat.m2505o(63072);
        } else {
            this.AdV.setBackgroundResource(C1318a.emoji_pop_bg_smiley);
            this.AdS.x = measuredWidth - (i / 2);
            AppMethodBeat.m2505o(63072);
        }
    }
}
