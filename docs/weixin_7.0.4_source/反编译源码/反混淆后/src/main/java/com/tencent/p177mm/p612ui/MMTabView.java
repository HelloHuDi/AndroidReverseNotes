package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.support.p057v4.widget.C8415j;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.p613a.C5216a.C5215a;
import com.tencent.p177mm.p612ui.tools.C44385r;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.MMTabView */
public class MMTabView extends ViewGroup {
    private TextView gnB;
    private int index;
    private int padding;
    public int total;
    private TextView ykC;
    private ImageView ynA;

    public MMTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(106110);
        this.total = 3;
        this.padding = 0;
        init();
        AppMethodBeat.m2505o(106110);
    }

    public MMTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106111);
        this.total = 3;
        this.padding = 0;
        init();
        AppMethodBeat.m2505o(106111);
    }

    private MMTabView(Context context) {
        super(context);
        AppMethodBeat.m2504i(106112);
        this.total = 3;
        this.padding = 0;
        init();
        AppMethodBeat.m2505o(106112);
    }

    public MMTabView(Context context, int i) {
        this(context);
        AppMethodBeat.m2504i(106113);
        this.index = i;
        dyw();
        AppMethodBeat.m2505o(106113);
    }

    public final void dyw() {
        AppMethodBeat.m2504i(106114);
        C4990ab.m7411d("MicroMsg.MMTabView", "jacks build : %d desc, unread: %s", Integer.valueOf(this.index), getUnread());
        C5215a.yqY.mo10715a(this, getText(), getUnread(), this.index);
        AppMethodBeat.m2505o(106114);
    }

    private void init() {
        int dm;
        AppMethodBeat.m2504i(106115);
        this.padding = getResources().getDimensionPixelSize(C25738R.dimen.f10017nj);
        String dor = C4988aa.dor();
        boolean don = C4988aa.don();
        boolean equalsIgnoreCase = dor.equalsIgnoreCase("en");
        if (don) {
            dm = (int) (C1338a.m2860dm(getContext()) * ((float) C1338a.fromDPToPix(getContext(), 2)));
        } else {
            dm = 0;
        }
        this.gnB = new TextView(getContext());
        this.gnB.setSingleLine();
        this.gnB.setEllipsize(TruncateAt.END);
        this.gnB.setTextColor(getResources().getColorStateList(C25738R.color.a61));
        this.gnB.setTextSize(0, (float) C1338a.m2856al(getContext(), C25738R.dimen.f9936kr));
        this.gnB.setText("");
        if (don) {
            this.gnB.setTextSize(0, ((float) dm) + this.gnB.getTextSize());
            this.gnB.setTypeface(null, 0);
        } else if (equalsIgnoreCase) {
            this.gnB.setTypeface(null, 1);
        }
        addView(this.gnB);
        this.ynA = new ImageView(getContext());
        this.ynA.setBackgroundResource(C25738R.drawable.a4h);
        this.ynA.setVisibility(4);
        addView(this.ynA);
        this.ykC = new TextView(getContext());
        this.ykC.setTextColor(getResources().getColor(C25738R.color.a69));
        this.ykC.setTextSize(1, 11.0f);
        this.ykC.setBackgroundResource(C44385r.m80243ik(getContext()));
        this.ykC.setTypeface(Typeface.DEFAULT_BOLD);
        this.ykC.setGravity(17);
        this.ykC.setVisibility(4);
        addView(this.ykC);
        setBackgroundResource(C25738R.drawable.a_r);
        AppMethodBeat.m2505o(106115);
    }

    public void setText(int i) {
        AppMethodBeat.m2504i(106116);
        this.gnB.setText(i);
        AppMethodBeat.m2505o(106116);
    }

    public void setText(String str) {
        AppMethodBeat.m2504i(106117);
        this.gnB.setText(str);
        AppMethodBeat.m2505o(106117);
    }

    public void setTextColor(ColorStateList colorStateList) {
        AppMethodBeat.m2504i(106118);
        this.gnB.setTextColor(colorStateList);
        AppMethodBeat.m2505o(106118);
    }

    public String getText() {
        AppMethodBeat.m2504i(106119);
        String charSequence = this.gnB.getText().toString();
        AppMethodBeat.m2505o(106119);
        return charSequence;
    }

    public String getUnread() {
        AppMethodBeat.m2504i(106120);
        String charSequence = this.ykC.getText().toString();
        AppMethodBeat.m2505o(106120);
        return charSequence;
    }

    public void setUnread(final String str) {
        AppMethodBeat.m2504i(106121);
        if (C5046bo.isNullOrNil(str)) {
            this.ykC.setVisibility(4);
            AppMethodBeat.m2505o(106121);
            return;
        }
        this.ykC.setVisibility(0);
        this.ykC.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(106109);
                MMTabView.this.ykC.setText(str);
                MMTabView.this.dyw();
                AppMethodBeat.m2505o(106109);
            }
        });
        AppMethodBeat.m2505o(106121);
    }

    /* renamed from: pR */
    public final void mo10695pR(boolean z) {
        AppMethodBeat.m2504i(106122);
        this.ynA.setVisibility(z ? 0 : 4);
        AppMethodBeat.m2505o(106122);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int makeMeasureSpec;
        AppMethodBeat.m2504i(106123);
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int size2 = (MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        if (MeasureSpec.getMode(i2) == C8415j.INVALID_ID) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, C8415j.INVALID_ID);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        }
        this.gnB.measure(MeasureSpec.makeMeasureSpec(size, C8415j.INVALID_ID), makeMeasureSpec);
        this.ynA.measure(MeasureSpec.makeMeasureSpec(size, C8415j.INVALID_ID), makeMeasureSpec);
        this.ykC.measure(MeasureSpec.makeMeasureSpec(size, C8415j.INVALID_ID), makeMeasureSpec);
        setMeasuredDimension(size, size2);
        AppMethodBeat.m2505o(106123);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(106124);
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
            AppMethodBeat.m2505o(106124);
            return;
        }
        i5 = this.padding + measuredWidth2;
        i6 = (i6 - this.ykC.getMeasuredHeight()) / 2;
        this.ykC.layout(i5, i6, this.ykC.getMeasuredWidth() + i5, this.ykC.getMeasuredHeight() + i6);
        AppMethodBeat.m2505o(106124);
    }
}
