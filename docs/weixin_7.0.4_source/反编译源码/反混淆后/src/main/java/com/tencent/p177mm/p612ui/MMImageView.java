package com.tencent.p177mm.p612ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.MMImageView */
public class MMImageView extends ImageView {
    public MMImageView(Context context) {
        super(context);
    }

    public MMImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.m2504i(106103);
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(MMImageView.class.getName());
        AppMethodBeat.m2505o(106103);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        AppMethodBeat.m2504i(106104);
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(MMImageView.class.getName());
        AppMethodBeat.m2505o(106104);
    }
}
