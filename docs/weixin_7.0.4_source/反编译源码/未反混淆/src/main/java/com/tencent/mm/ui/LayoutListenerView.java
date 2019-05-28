package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class LayoutListenerView extends FrameLayout {
    private String TAG = "MicroMsg.LayoutListenerView";
    private byte[] ykP = new byte[0];
    private a ykQ;
    private c ykR;
    private b ykS;

    public interface a {
    }

    public interface b {
    }

    public interface c {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public void setOnLayoutListener(a aVar) {
        synchronized (this.ykP) {
            this.ykQ = aVar;
        }
    }

    public void setOnResizedListener(c cVar) {
        synchronized (this.ykP) {
            this.ykR = cVar;
        }
    }

    public void setOnPreLayoutListener(b bVar) {
        synchronized (this.ykP) {
            this.ykS = bVar;
        }
    }

    public LayoutListenerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(105976);
        AppMethodBeat.o(105976);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(105977);
        synchronized (this.ykP) {
            try {
            } finally {
                while (true) {
                }
                AppMethodBeat.o(105977);
            }
        }
        super.onLayout(z, i, i2, i3, i4);
        synchronized (this.ykP) {
            try {
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(105977);
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(105978);
        super.onSizeChanged(i, i2, i3, i4);
        synchronized (this.ykP) {
            try {
                if (this.ykR != null) {
                    this.ykR.onSizeChanged(i, i2, i3, i4);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(105978);
            }
        }
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        AppMethodBeat.i(105979);
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        ab.d(this.TAG, "jacks onInitializeAccessibilityNodeInfo");
        AppMethodBeat.o(105979);
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(105980);
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        ab.d(this.TAG, "jacks onPopulateAccessibilityEvent");
        AppMethodBeat.o(105980);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(105981);
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        ab.d(this.TAG, "jacks onInitializeAccessibilityEvent");
        AppMethodBeat.o(105981);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(105982);
        synchronized (this.ykP) {
            try {
                this.ykQ = null;
                this.ykR = null;
                this.ykS = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(105982);
            }
        }
        super.onDetachedFromWindow();
    }
}
