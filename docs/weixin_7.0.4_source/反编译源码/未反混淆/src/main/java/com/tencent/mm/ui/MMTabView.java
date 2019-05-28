package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.support.v4.widget.j;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.tools.r;

public class MMTabView extends ViewGroup {
    private TextView gnB;
    private int index;
    private int padding;
    public int total;
    private TextView ykC;
    private ImageView ynA;

    public MMTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(106110);
        this.total = 3;
        this.padding = 0;
        init();
        AppMethodBeat.o(106110);
    }

    public MMTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106111);
        this.total = 3;
        this.padding = 0;
        init();
        AppMethodBeat.o(106111);
    }

    private MMTabView(Context context) {
        super(context);
        AppMethodBeat.i(106112);
        this.total = 3;
        this.padding = 0;
        init();
        AppMethodBeat.o(106112);
    }

    public MMTabView(Context context, int i) {
        this(context);
        AppMethodBeat.i(106113);
        this.index = i;
        dyw();
        AppMethodBeat.o(106113);
    }

    public final void dyw() {
        AppMethodBeat.i(106114);
        ab.d("MicroMsg.MMTabView", "jacks build : %d desc, unread: %s", Integer.valueOf(this.index), getUnread());
        a.yqY.a(this, getText(), getUnread(), this.index);
        AppMethodBeat.o(106114);
    }

    private void init() {
        int dm;
        AppMethodBeat.i(106115);
        this.padding = getResources().getDimensionPixelSize(R.dimen.nj);
        String dor = aa.dor();
        boolean don = aa.don();
        boolean equalsIgnoreCase = dor.equalsIgnoreCase("en");
        if (don) {
            dm = (int) (com.tencent.mm.bz.a.dm(getContext()) * ((float) com.tencent.mm.bz.a.fromDPToPix(getContext(), 2)));
        } else {
            dm = 0;
        }
        this.gnB = new TextView(getContext());
        this.gnB.setSingleLine();
        this.gnB.setEllipsize(TruncateAt.END);
        this.gnB.setTextColor(getResources().getColorStateList(R.color.a61));
        this.gnB.setTextSize(0, (float) com.tencent.mm.bz.a.al(getContext(), R.dimen.kr));
        this.gnB.setText("");
        if (don) {
            this.gnB.setTextSize(0, ((float) dm) + this.gnB.getTextSize());
            this.gnB.setTypeface(null, 0);
        } else if (equalsIgnoreCase) {
            this.gnB.setTypeface(null, 1);
        }
        addView(this.gnB);
        this.ynA = new ImageView(getContext());
        this.ynA.setBackgroundResource(R.drawable.a4h);
        this.ynA.setVisibility(4);
        addView(this.ynA);
        this.ykC = new TextView(getContext());
        this.ykC.setTextColor(getResources().getColor(R.color.a69));
        this.ykC.setTextSize(1, 11.0f);
        this.ykC.setBackgroundResource(r.ik(getContext()));
        this.ykC.setTypeface(Typeface.DEFAULT_BOLD);
        this.ykC.setGravity(17);
        this.ykC.setVisibility(4);
        addView(this.ykC);
        setBackgroundResource(R.drawable.a_r);
        AppMethodBeat.o(106115);
    }

    public void setText(int i) {
        AppMethodBeat.i(106116);
        this.gnB.setText(i);
        AppMethodBeat.o(106116);
    }

    public void setText(String str) {
        AppMethodBeat.i(106117);
        this.gnB.setText(str);
        AppMethodBeat.o(106117);
    }

    public void setTextColor(ColorStateList colorStateList) {
        AppMethodBeat.i(106118);
        this.gnB.setTextColor(colorStateList);
        AppMethodBeat.o(106118);
    }

    public String getText() {
        AppMethodBeat.i(106119);
        String charSequence = this.gnB.getText().toString();
        AppMethodBeat.o(106119);
        return charSequence;
    }

    public String getUnread() {
        AppMethodBeat.i(106120);
        String charSequence = this.ykC.getText().toString();
        AppMethodBeat.o(106120);
        return charSequence;
    }

    public void setUnread(final String str) {
        AppMethodBeat.i(106121);
        if (bo.isNullOrNil(str)) {
            this.ykC.setVisibility(4);
            AppMethodBeat.o(106121);
            return;
        }
        this.ykC.setVisibility(0);
        this.ykC.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(106109);
                MMTabView.this.ykC.setText(str);
                MMTabView.this.dyw();
                AppMethodBeat.o(106109);
            }
        });
        AppMethodBeat.o(106121);
    }

    public final void pR(boolean z) {
        AppMethodBeat.i(106122);
        this.ynA.setVisibility(z ? 0 : 4);
        AppMethodBeat.o(106122);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int makeMeasureSpec;
        AppMethodBeat.i(106123);
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int size2 = (MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        if (MeasureSpec.getMode(i2) == j.INVALID_ID) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, j.INVALID_ID);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        }
        this.gnB.measure(MeasureSpec.makeMeasureSpec(size, j.INVALID_ID), makeMeasureSpec);
        this.ynA.measure(MeasureSpec.makeMeasureSpec(size, j.INVALID_ID), makeMeasureSpec);
        this.ykC.measure(MeasureSpec.makeMeasureSpec(size, j.INVALID_ID), makeMeasureSpec);
        setMeasuredDimension(size, size2);
        AppMethodBeat.o(106123);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(106124);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int measuredWidth = (i5 - this.gnB.getMeasuredWidth()) / 2;
        int measuredWidth2 = this.gnB.getMeasuredWidth() + measuredWidth;
        int measuredHeight = (i6 - this.gnB.getMeasuredHeight()) / 2;
        this.gnB.layout(measuredWidth, measuredHeight, measuredWidth2, this.gnB.getMeasuredHeight() + measuredHeight);
        measuredHeight = this.padding + measuredWidth2;
        int measuredHeight2 = (i6 - this.ynA.getMeasuredHeight()) / 2;
        this.ynA.layout(measuredHeight, measuredHeight2, this.ynA.getMeasuredWidth() + measuredHeight, this.ynA.getMeasuredHeight() + measuredHeight2);
        if (measuredWidth - this.padding < this.ykC.getMeasuredWidth()) {
            i5 -= this.ykC.getMeasuredWidth();
            i6 = (i6 - this.ykC.getMeasuredHeight()) / 2;
            this.ykC.layout(i5, i6, this.ykC.getMeasuredWidth() + i5, this.ykC.getMeasuredHeight() + i6);
            AppMethodBeat.o(106124);
            return;
        }
        i5 = this.padding + measuredWidth2;
        i6 = (i6 - this.ykC.getMeasuredHeight()) / 2;
        this.ykC.layout(i5, i6, this.ykC.getMeasuredWidth() + i5, this.ykC.getMeasuredHeight() + i6);
        AppMethodBeat.o(106124);
    }
}
