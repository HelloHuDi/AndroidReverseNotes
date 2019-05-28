package com.tencent.p177mm.plugin.sns.p520ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.ui.AsyncNormalTextView */
public class AsyncNormalTextView extends CollapsibleTextView {
    private String content;
    private Context context;
    private C46251au qPr;
    private BaseViewHolder rgW;
    private int rgX = 0;

    public AsyncNormalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    /* renamed from: a */
    public final void mo37539a(String str, C46251au c46251au, int i, C13633av c13633av) {
        AppMethodBeat.m2504i(38136);
        this.rgX = i;
        this.content = str;
        this.qPr = c46251au;
        this.rhX = c13633av;
        if (C5046bo.isNullOrNil(str)) {
            setVisibility(8);
        }
        AppMethodBeat.m2505o(38136);
    }

    public void setShow(BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(38137);
        this.rgW = baseViewHolder;
        crz();
        AppMethodBeat.m2505o(38137);
    }

    public final void crz() {
        AppMethodBeat.m2504i(38138);
        if (!C5046bo.isNullOrNil(this.content)) {
            System.currentTimeMillis();
            setVisibility(0);
            if (this.rgX == 1) {
                this.content = this.content.length() > 100 ? this.content.substring(0, 100) + "..." : this.content;
                mo55592a(this.rgX, new SpannableStringBuilder(C44089j.m79293b(this.context, this.content, this.rhR.getTextSize())), BufferType.NORMAL, this.qPr.rhW, this.rhX.riA, this.rhX.rAs, this.qPr, this.content, this.rhX.rgZ);
            } else if (this.content.length() < 400 || this.rhX.rgZ) {
                CharSequence charSequence = null;
                if (this.rhX != null) {
                    charSequence = this.rhX.rAq;
                }
                if (charSequence == null) {
                    charSequence = new SpannableStringBuilder(C44089j.m79293b(this.context, this.content, this.rhR.getTextSize()));
                }
                if (this.rhX != null) {
                    mo55592a(this.rgX, charSequence, BufferType.SPANNABLE, this.qPr.rhW, this.rhX.riA, this.rhX.rAs, this.qPr, this.content, this.rhX.rgZ);
                }
            } else {
                mo55592a(this.rgX, this.content, BufferType.NORMAL, this.qPr.rhW, this.rhX.riA, this.rhX.rAs, this.qPr, this.content, this.rhX.rgZ);
            }
            C39828ar c39828ar = new C39828ar(this.rhX.rAs, this.rhX.riA, false, false, 1);
            c39828ar.userName = this.rhX.igi;
            this.rhR.setTag(c39828ar);
            if (this.rhS != null) {
                this.rhS.setTag(c39828ar);
            }
            this.rhT.setTag(this.rgW);
        }
        AppMethodBeat.m2505o(38138);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(38139);
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.m2505o(38139);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(38140);
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(38140);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.m2504i(38141);
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(this.content);
        AppMethodBeat.m2505o(38141);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        AppMethodBeat.m2504i(38142);
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setText(this.content);
        AppMethodBeat.m2505o(38142);
    }

    public String getContent() {
        return this.content;
    }

    public void setContentWidth(int i) {
        AppMethodBeat.m2504i(38143);
        if (this.rhS != null) {
            this.rhR.setSpecialWidth(i);
            LayoutParams layoutParams = new LayoutParams(i, -2);
            this.rhS.setLayoutParams(layoutParams);
            this.rhR.setLayoutParams(layoutParams);
            this.rhT.setLayoutParams(layoutParams);
        }
        AppMethodBeat.m2505o(38143);
    }
}
