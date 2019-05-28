package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public class AsyncNormalTextView extends CollapsibleTextView {
    private String content;
    private Context context;
    private au qPr;
    private BaseViewHolder rgW;
    private int rgX = 0;

    public AsyncNormalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public final void a(String str, au auVar, int i, av avVar) {
        AppMethodBeat.i(38136);
        this.rgX = i;
        this.content = str;
        this.qPr = auVar;
        this.rhX = avVar;
        if (bo.isNullOrNil(str)) {
            setVisibility(8);
        }
        AppMethodBeat.o(38136);
    }

    public void setShow(BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(38137);
        this.rgW = baseViewHolder;
        crz();
        AppMethodBeat.o(38137);
    }

    public final void crz() {
        AppMethodBeat.i(38138);
        if (!bo.isNullOrNil(this.content)) {
            System.currentTimeMillis();
            setVisibility(0);
            if (this.rgX == 1) {
                this.content = this.content.length() > 100 ? this.content.substring(0, 100) + "..." : this.content;
                a(this.rgX, new SpannableStringBuilder(j.b(this.context, this.content, this.rhR.getTextSize())), BufferType.NORMAL, this.qPr.rhW, this.rhX.riA, this.rhX.rAs, this.qPr, this.content, this.rhX.rgZ);
            } else if (this.content.length() < 400 || this.rhX.rgZ) {
                CharSequence charSequence = null;
                if (this.rhX != null) {
                    charSequence = this.rhX.rAq;
                }
                if (charSequence == null) {
                    charSequence = new SpannableStringBuilder(j.b(this.context, this.content, this.rhR.getTextSize()));
                }
                if (this.rhX != null) {
                    a(this.rgX, charSequence, BufferType.SPANNABLE, this.qPr.rhW, this.rhX.riA, this.rhX.rAs, this.qPr, this.content, this.rhX.rgZ);
                }
            } else {
                a(this.rgX, this.content, BufferType.NORMAL, this.qPr.rhW, this.rhX.riA, this.rhX.rAs, this.qPr, this.content, this.rhX.rgZ);
            }
            ar arVar = new ar(this.rhX.rAs, this.rhX.riA, false, false, 1);
            arVar.userName = this.rhX.igi;
            this.rhR.setTag(arVar);
            if (this.rhS != null) {
                this.rhS.setTag(arVar);
            }
            this.rhT.setTag(this.rgW);
        }
        AppMethodBeat.o(38138);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(38139);
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.o(38139);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(38140);
        super.onMeasure(i, i2);
        AppMethodBeat.o(38140);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(38141);
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(this.content);
        AppMethodBeat.o(38141);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        AppMethodBeat.i(38142);
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setText(this.content);
        AppMethodBeat.o(38142);
    }

    public String getContent() {
        return this.content;
    }

    public void setContentWidth(int i) {
        AppMethodBeat.i(38143);
        if (this.rhS != null) {
            this.rhR.setSpecialWidth(i);
            LayoutParams layoutParams = new LayoutParams(i, -2);
            this.rhS.setLayoutParams(layoutParams);
            this.rhR.setLayoutParams(layoutParams);
            this.rhT.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(38143);
    }
}
