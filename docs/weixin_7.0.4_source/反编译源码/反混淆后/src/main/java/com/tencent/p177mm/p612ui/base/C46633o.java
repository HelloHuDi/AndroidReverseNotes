package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5227ai;

/* renamed from: com.tencent.mm.ui.base.o */
public class C46633o extends PopupWindow {
    private Context mContext = null;
    private OnTouchListener yvZ;

    /* renamed from: com.tencent.mm.ui.base.o$a */
    class C46632a extends FrameLayout {
        C46632a(Context context) {
            super(context);
        }

        /* Access modifiers changed, original: protected|final */
        public final int[] onCreateDrawableState(int i) {
            AppMethodBeat.m2504i(112558);
            int[] onCreateDrawableState = super.onCreateDrawableState(i);
            AppMethodBeat.m2505o(112558);
            return onCreateDrawableState;
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            AppMethodBeat.m2504i(112559);
            boolean dispatchKeyEvent;
            DispatcherState keyDispatcherState;
            if (keyEvent.getKeyCode() != 4) {
                dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
                AppMethodBeat.m2505o(112559);
                return dispatchKeyEvent;
            } else if (getKeyDispatcherState() == null) {
                dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
                AppMethodBeat.m2505o(112559);
                return dispatchKeyEvent;
            } else if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, this);
                }
                AppMethodBeat.m2505o(112559);
                return true;
            } else {
                if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (!(keyDispatcherState == null || !keyDispatcherState.isTracking(keyEvent) || keyEvent.isCanceled())) {
                        C46633o.this.dismiss();
                        AppMethodBeat.m2505o(112559);
                        return true;
                    }
                }
                dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
                AppMethodBeat.m2505o(112559);
                return dispatchKeyEvent;
            }
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(112560);
            if (C46633o.this.yvZ == null || !C46633o.this.yvZ.onTouch(this, motionEvent)) {
                boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.m2505o(112560);
                return dispatchTouchEvent;
            }
            AppMethodBeat.m2505o(112560);
            return true;
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(112561);
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x < 0 || x >= getWidth() || y < 0 || y >= getHeight())) {
                C46633o.this.dismiss();
                AppMethodBeat.m2505o(112561);
                return true;
            } else if (motionEvent.getAction() == 4) {
                C46633o.this.dismiss();
                AppMethodBeat.m2505o(112561);
                return true;
            } else {
                boolean onTouchEvent = super.onTouchEvent(motionEvent);
                AppMethodBeat.m2505o(112561);
                return onTouchEvent;
            }
        }

        public final void sendAccessibilityEvent(int i) {
            AppMethodBeat.m2504i(112562);
            if (getChildCount() == 1) {
                getChildAt(0).sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
            super.sendAccessibilityEvent(i);
            AppMethodBeat.m2505o(112562);
        }
    }

    public C46633o(Context context) {
        super(context);
        AppMethodBeat.m2504i(112563);
        this.mContext = context;
        super.setBackgroundDrawable(null);
        setContentView(new C46632a(this.mContext));
        AppMethodBeat.m2505o(112563);
    }

    public C46633o(View view) {
        super(view);
        AppMethodBeat.m2504i(112564);
        super.setBackgroundDrawable(null);
        AppMethodBeat.m2505o(112564);
    }

    public C46633o(View view, int i, int i2) {
        super(view, i, i2);
        AppMethodBeat.m2504i(112565);
        super.setBackgroundDrawable(null);
        AppMethodBeat.m2505o(112565);
    }

    public C46633o(View view, int i, int i2, boolean z) {
        super(view, i, i2, z);
        AppMethodBeat.m2504i(112566);
        super.setBackgroundDrawable(null);
        AppMethodBeat.m2505o(112566);
    }

    public void dismiss() {
        AppMethodBeat.m2504i(112567);
        try {
            super.dismiss();
            AppMethodBeat.m2505o(112567);
        } catch (Exception e) {
            C5227ai.m7972e("MicroMsg.MMPopupWindow", "dismiss exception, e = " + e.getMessage(), new Object[0]);
            AppMethodBeat.m2505o(112567);
        }
    }

    public Drawable getBackground() {
        AppMethodBeat.m2504i(112568);
        View contentView = getContentView();
        if (contentView == null) {
            AppMethodBeat.m2505o(112568);
            return null;
        } else if (contentView instanceof C46632a) {
            Drawable background = contentView.getBackground();
            AppMethodBeat.m2505o(112568);
            return background;
        } else {
            AppMethodBeat.m2505o(112568);
            return null;
        }
    }

    public void setContentView(View view) {
        int i = -2;
        AppMethodBeat.m2504i(112569);
        View contentView = getContentView();
        if (contentView == null) {
            super.setContentView(view);
        } else if (contentView instanceof C46632a) {
            C46632a c46632a = (C46632a) contentView;
            c46632a.removeAllViews();
            if (view == null) {
                super.setContentView(c46632a);
                AppMethodBeat.m2505o(112569);
                return;
            }
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.height != -2) {
                i = -1;
            }
            c46632a.addView(view, new FrameLayout.LayoutParams(-1, i));
            super.setContentView(c46632a);
            AppMethodBeat.m2505o(112569);
            return;
        }
        super.setContentView(view);
        AppMethodBeat.m2505o(112569);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        int i = -2;
        AppMethodBeat.m2504i(112570);
        View contentView = getContentView();
        if (contentView == null) {
            AppMethodBeat.m2505o(112570);
            return;
        }
        Context context = contentView.getContext();
        if (contentView instanceof C46632a) {
            contentView.setBackgroundDrawable(drawable);
            AppMethodBeat.m2505o(112570);
            return;
        }
        LayoutParams layoutParams = contentView.getLayoutParams();
        if (layoutParams == null || layoutParams.height != -2) {
            i = -1;
        }
        C46632a c46632a = new C46632a(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, i);
        c46632a.setBackgroundDrawable(drawable);
        c46632a.addView(contentView, layoutParams2);
        super.setContentView(c46632a);
        AppMethodBeat.m2505o(112570);
    }

    public void setTouchInterceptor(OnTouchListener onTouchListener) {
        this.yvZ = onTouchListener;
    }
}
