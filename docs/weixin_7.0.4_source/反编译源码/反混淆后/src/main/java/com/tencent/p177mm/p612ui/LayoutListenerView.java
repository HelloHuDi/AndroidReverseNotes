package com.tencent.p177mm.p612ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.LayoutListenerView */
public class LayoutListenerView extends FrameLayout {
    private String TAG = "MicroMsg.LayoutListenerView";
    private byte[] ykP = new byte[0];
    private C5183a ykQ;
    private C5185c ykR;
    private C5184b ykS;

    /* renamed from: com.tencent.mm.ui.LayoutListenerView$a */
    public interface C5183a {
    }

    /* renamed from: com.tencent.mm.ui.LayoutListenerView$b */
    public interface C5184b {
    }

    /* renamed from: com.tencent.mm.ui.LayoutListenerView$c */
    public interface C5185c {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public void setOnLayoutListener(C5183a c5183a) {
        synchronized (this.ykP) {
            this.ykQ = c5183a;
        }
    }

    public void setOnResizedListener(C5185c c5185c) {
        synchronized (this.ykP) {
            this.ykR = c5185c;
        }
    }

    public void setOnPreLayoutListener(C5184b c5184b) {
        synchronized (this.ykP) {
            this.ykS = c5184b;
        }
    }

    public LayoutListenerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(105976);
        AppMethodBeat.m2505o(105976);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(105977);
        synchronized (this.ykP) {
            try {
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(105977);
            }
        }
        super.onLayout(z, i, i2, i3, i4);
        synchronized (this.ykP) {
            try {
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(105977);
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(105978);
        super.onSizeChanged(i, i2, i3, i4);
        synchronized (this.ykP) {
            try {
                if (this.ykR != null) {
                    this.ykR.onSizeChanged(i, i2, i3, i4);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(105978);
            }
        }
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        AppMethodBeat.m2504i(105979);
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        C4990ab.m7410d(this.TAG, "jacks onInitializeAccessibilityNodeInfo");
        AppMethodBeat.m2505o(105979);
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.m2504i(105980);
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        C4990ab.m7410d(this.TAG, "jacks onPopulateAccessibilityEvent");
        AppMethodBeat.m2505o(105980);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.m2504i(105981);
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        C4990ab.m7410d(this.TAG, "jacks onInitializeAccessibilityEvent");
        AppMethodBeat.m2505o(105981);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(105982);
        synchronized (this.ykP) {
            try {
                this.ykQ = null;
                this.ykR = null;
                this.ykS = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(105982);
            }
        }
        super.onDetachedFromWindow();
    }
}
