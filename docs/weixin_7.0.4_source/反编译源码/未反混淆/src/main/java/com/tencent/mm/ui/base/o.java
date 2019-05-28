package com.tencent.mm.ui.base;

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
import com.tencent.mm.ui.ai;

public class o extends PopupWindow {
    private Context mContext = null;
    private OnTouchListener yvZ;

    class a extends FrameLayout {
        a(Context context) {
            super(context);
        }

        /* Access modifiers changed, original: protected|final */
        public final int[] onCreateDrawableState(int i) {
            AppMethodBeat.i(112558);
            int[] onCreateDrawableState = super.onCreateDrawableState(i);
            AppMethodBeat.o(112558);
            return onCreateDrawableState;
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            AppMethodBeat.i(112559);
            boolean dispatchKeyEvent;
            DispatcherState keyDispatcherState;
            if (keyEvent.getKeyCode() != 4) {
                dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
                AppMethodBeat.o(112559);
                return dispatchKeyEvent;
            } else if (getKeyDispatcherState() == null) {
                dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
                AppMethodBeat.o(112559);
                return dispatchKeyEvent;
            } else if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, this);
                }
                AppMethodBeat.o(112559);
                return true;
            } else {
                if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (!(keyDispatcherState == null || !keyDispatcherState.isTracking(keyEvent) || keyEvent.isCanceled())) {
                        o.this.dismiss();
                        AppMethodBeat.o(112559);
                        return true;
                    }
                }
                dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
                AppMethodBeat.o(112559);
                return dispatchKeyEvent;
            }
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(112560);
            if (o.this.yvZ == null || !o.this.yvZ.onTouch(this, motionEvent)) {
                boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(112560);
                return dispatchTouchEvent;
            }
            AppMethodBeat.o(112560);
            return true;
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(112561);
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x < 0 || x >= getWidth() || y < 0 || y >= getHeight())) {
                o.this.dismiss();
                AppMethodBeat.o(112561);
                return true;
            } else if (motionEvent.getAction() == 4) {
                o.this.dismiss();
                AppMethodBeat.o(112561);
                return true;
            } else {
                boolean onTouchEvent = super.onTouchEvent(motionEvent);
                AppMethodBeat.o(112561);
                return onTouchEvent;
            }
        }

        public final void sendAccessibilityEvent(int i) {
            AppMethodBeat.i(112562);
            if (getChildCount() == 1) {
                getChildAt(0).sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
            super.sendAccessibilityEvent(i);
            AppMethodBeat.o(112562);
        }
    }

    public o(Context context) {
        super(context);
        AppMethodBeat.i(112563);
        this.mContext = context;
        super.setBackgroundDrawable(null);
        setContentView(new a(this.mContext));
        AppMethodBeat.o(112563);
    }

    public o(View view) {
        super(view);
        AppMethodBeat.i(112564);
        super.setBackgroundDrawable(null);
        AppMethodBeat.o(112564);
    }

    public o(View view, int i, int i2) {
        super(view, i, i2);
        AppMethodBeat.i(112565);
        super.setBackgroundDrawable(null);
        AppMethodBeat.o(112565);
    }

    public o(View view, int i, int i2, boolean z) {
        super(view, i, i2, z);
        AppMethodBeat.i(112566);
        super.setBackgroundDrawable(null);
        AppMethodBeat.o(112566);
    }

    public void dismiss() {
        AppMethodBeat.i(112567);
        try {
            super.dismiss();
            AppMethodBeat.o(112567);
        } catch (Exception e) {
            ai.e("MicroMsg.MMPopupWindow", "dismiss exception, e = " + e.getMessage(), new Object[0]);
            AppMethodBeat.o(112567);
        }
    }

    public Drawable getBackground() {
        AppMethodBeat.i(112568);
        View contentView = getContentView();
        if (contentView == null) {
            AppMethodBeat.o(112568);
            return null;
        } else if (contentView instanceof a) {
            Drawable background = contentView.getBackground();
            AppMethodBeat.o(112568);
            return background;
        } else {
            AppMethodBeat.o(112568);
            return null;
        }
    }

    public void setContentView(View view) {
        int i = -2;
        AppMethodBeat.i(112569);
        View contentView = getContentView();
        if (contentView == null) {
            super.setContentView(view);
        } else if (contentView instanceof a) {
            a aVar = (a) contentView;
            aVar.removeAllViews();
            if (view == null) {
                super.setContentView(aVar);
                AppMethodBeat.o(112569);
                return;
            }
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.height != -2) {
                i = -1;
            }
            aVar.addView(view, new FrameLayout.LayoutParams(-1, i));
            super.setContentView(aVar);
            AppMethodBeat.o(112569);
            return;
        }
        super.setContentView(view);
        AppMethodBeat.o(112569);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        int i = -2;
        AppMethodBeat.i(112570);
        View contentView = getContentView();
        if (contentView == null) {
            AppMethodBeat.o(112570);
            return;
        }
        Context context = contentView.getContext();
        if (contentView instanceof a) {
            contentView.setBackgroundDrawable(drawable);
            AppMethodBeat.o(112570);
            return;
        }
        LayoutParams layoutParams = contentView.getLayoutParams();
        if (layoutParams == null || layoutParams.height != -2) {
            i = -1;
        }
        a aVar = new a(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, i);
        aVar.setBackgroundDrawable(drawable);
        aVar.addView(contentView, layoutParams2);
        super.setContentView(aVar);
        AppMethodBeat.o(112570);
    }

    public void setTouchInterceptor(OnTouchListener onTouchListener) {
        this.yvZ = onTouchListener;
    }
}
