package com.tencent.p177mm.plugin.webview.p580ui.tools.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMWebView;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.MailMMWebView */
public class MailMMWebView extends MMWebViewWithJsApi implements C29960h {
    private float hke;
    private float hkf;
    private View qpI;
    private boolean uJM;
    private View uJN;
    private boolean uJO;
    private boolean uJP;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.MailMMWebView$a */
    class C23145a extends FrameLayout {
        public C23145a(Context context) {
            super(context);
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(10037);
            if (MailMMWebView.this.uJO || MailMMWebView.this.uJP) {
                switch (motionEvent.getAction() & 255) {
                    case 1:
                    case 3:
                        MailMMWebView.this.uJO = false;
                        MailMMWebView.this.uJP = false;
                        break;
                }
                super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.m2505o(10037);
                return true;
            }
            AppMethodBeat.m2505o(10037);
            return false;
        }

        /* Access modifiers changed, original: protected|final */
        public final void onSizeChanged(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(10038);
            super.onSizeChanged(i, i2, i3, i4);
            if (this != MailMMWebView.this.uJN || MailMMWebView.this.getTitleHeight() <= 0) {
                if (this == MailMMWebView.this.qpI && MailMMWebView.this.getBottomHeight() > 0) {
                    MailMMWebView.this.dcT();
                }
                AppMethodBeat.m2505o(10038);
                return;
            }
            MailMMWebView.this.dcS();
            AppMethodBeat.m2505o(10038);
        }
    }

    /* renamed from: fu */
    public static /* synthetic */ void m35519fu(Context context) {
        AppMethodBeat.m2504i(10055);
        MMWebView.m49133il(context);
        AppMethodBeat.m2505o(10055);
    }

    public MailMMWebView(Context context) {
        this(context, null, 0);
    }

    public MailMMWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MailMMWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(10039);
        this.uJM = true;
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        AppMethodBeat.m2505o(10039);
    }

    public final boolean dcQ() {
        return this.uJM;
    }

    public final void dcR() {
        this.uJM = false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(10040);
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int webScrollY = getWebScrollY();
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.hke = x;
                this.hkf = y;
                if (this.uJN == null || ((int) this.hkf) >= getVisibleTitleBarHeight()) {
                    if (this.qpI != null && this.qpI.getVisibility() == 0 && this.hkf + ((float) getBottomHeight()) > ((float) getHeight())) {
                        this.uJP = true;
                        break;
                    }
                }
                this.uJO = true;
                break;
                break;
            case 2:
                if (Math.abs(y - this.hkf) > 50.0f && this.uJO) {
                    motionEvent.setAction(3);
                    motionEvent.setLocation(this.hke, this.hkf + ((float) webScrollY));
                    this.uJN.dispatchTouchEvent(motionEvent);
                    motionEvent.setAction(0);
                    motionEvent.setLocation(this.hke, this.hkf);
                    super.dispatchTouchEvent(motionEvent);
                    motionEvent.setAction(2);
                    motionEvent.setLocation(x, y);
                    break;
                }
        }
        boolean dispatchTouchEvent;
        if (this.uJO && this.uJN != null) {
            motionEvent.setLocation(x, y + ((float) webScrollY));
            dispatchTouchEvent = this.uJN.dispatchTouchEvent(motionEvent);
            AppMethodBeat.m2505o(10040);
            return dispatchTouchEvent;
        } else if (!this.uJP || this.qpI == null) {
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.m2505o(10040);
            return dispatchTouchEvent;
        } else {
            motionEvent.setLocation(x, (y + ((float) getBottomHeight())) - ((float) getHeight()));
            dispatchTouchEvent = this.qpI.dispatchTouchEvent(motionEvent);
            AppMethodBeat.m2505o(10040);
            return dispatchTouchEvent;
        }
    }

    public void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(10041);
        int contentHeight = (int) (((float) getContentHeight()) * getScale());
        int height = getHeight() + i2;
        super.onWebViewScrollChanged(i, i2, i3, i4);
        invalidate();
        if (contentHeight - height < getBottomHeight()) {
            if (Math.abs(contentHeight - height) > 20) {
                dcT();
                mo38753oe(false);
            } else {
                mo38753oe(true);
            }
        }
        if (getVisibleTitleHeight() == 0) {
            dcS();
        }
        AppMethodBeat.m2505o(10041);
    }

    public void setEmbeddedTitleBarCompat(View view) {
        AppMethodBeat.m2504i(10042);
        setEmbeddedTitleBarSinceJellyBean(view);
        AppMethodBeat.m2505o(10042);
    }

    public int computeVerticalScrollExtent() {
        AppMethodBeat.m2504i(10043);
        int viewHeightWithTitleBar = getViewHeightWithTitleBar() - getVisibleTitleBarHeight();
        AppMethodBeat.m2505o(10043);
        return viewHeightWithTitleBar;
    }

    public int computeVerticalScrollOffset() {
        AppMethodBeat.m2504i(10044);
        int max = Math.max(getWebScrollY() - getTitleHeight(), 0);
        AppMethodBeat.m2505o(10044);
        return max;
    }

    public int getVisibleTitleBarHeight() {
        AppMethodBeat.m2504i(10045);
        int max = Math.max(getTitleHeight() - getWebScrollY(), 0);
        AppMethodBeat.m2505o(10045);
        return max;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild;
        AppMethodBeat.m2504i(10046);
        if (view == this.uJN) {
            int webScrollY = getWebScrollY();
            canvas.save();
            canvas.translate(0.0f, (float) (-webScrollY));
            drawChild = super.drawChild(canvas, view, j);
            canvas.restore();
        } else {
            drawChild = super.drawChild(canvas, view, j);
        }
        AppMethodBeat.m2505o(10046);
        return drawChild;
    }

    public int getTitleHeight() {
        AppMethodBeat.m2504i(10047);
        if (this.uJN != null) {
            int height = this.uJN.getHeight();
            AppMethodBeat.m2505o(10047);
            return height;
        }
        AppMethodBeat.m2505o(10047);
        return 0;
    }

    public int getBottomHeight() {
        AppMethodBeat.m2504i(10048);
        if (this.qpI != null) {
            int height = this.qpI.getHeight();
            AppMethodBeat.m2505o(10048);
            return height;
        }
        AppMethodBeat.m2505o(10048);
        return 0;
    }

    public final void dcS() {
        AppMethodBeat.m2504i(10049);
        evaluateJavascript("javascript:_updateTitleBarHeight(" + ((int) (((float) getTitleHeight()) / getScale())) + ");", null);
        AppMethodBeat.m2505o(10049);
    }

    public final void dcT() {
        AppMethodBeat.m2504i(10050);
        evaluateJavascript("javascript:_updateBottomBarHeight(" + ((int) (((float) getBottomHeight()) / getScale())) + ");", null);
        AppMethodBeat.m2505o(10050);
    }

    private int getViewHeightWithTitleBar() {
        AppMethodBeat.m2504i(10051);
        int height = getHeight();
        if (isHorizontalScrollBarEnabled() && !overlayHorizontalScrollbar()) {
            height -= getHorizontalScrollbarHeight();
        }
        AppMethodBeat.m2505o(10051);
        return height;
    }

    private void setEmbeddedTitleBarSinceJellyBean(View view) {
        AppMethodBeat.m2504i(10052);
        if (view != null) {
            if (this.uJN != null) {
                removeView(this.uJN);
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            this.uJN = new C23145a(getContext());
            ((C23145a) this.uJN).addView(view, new LayoutParams(-1, -2));
            this.uJN.setBackgroundColor(-1);
            addView(this.uJN, layoutParams);
        }
        AppMethodBeat.m2505o(10052);
    }

    /* renamed from: oe */
    public final void mo38753oe(boolean z) {
        AppMethodBeat.m2504i(10053);
        if (this.qpI != null) {
            if (z) {
                this.qpI.setVisibility(0);
                AppMethodBeat.m2505o(10053);
                return;
            }
            this.qpI.setVisibility(4);
        }
        AppMethodBeat.m2505o(10053);
    }

    public void setEmbeddedBottomBar(View view) {
        AppMethodBeat.m2504i(10054);
        if (view != null) {
            if (this.qpI != null) {
                removeView(this.qpI);
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            LayoutParams layoutParams = new LayoutParams(-1, -2, 80);
            this.qpI = new C23145a(getContext());
            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams3 = new LayoutParams(-1, -2);
            layoutParams3.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            ((C23145a) this.qpI).addView(view, layoutParams3);
            addView(this.qpI, layoutParams);
            this.qpI.setVisibility(4);
        }
        AppMethodBeat.m2505o(10054);
    }
}
