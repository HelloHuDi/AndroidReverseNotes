package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;

public final class g extends PopupWindow {
    private WindowManager gMh;
    private View iVh;
    public FrameLayout iVi;
    private Context mContext = null;

    public g(Context context) {
        super(context);
        AppMethodBeat.i(133660);
        this.mContext = context;
        this.gMh = (WindowManager) context.getSystemService("window");
        this.iVi = new FrameLayout(this.mContext);
        AppMethodBeat.o(133660);
    }

    public final void showAsDropDown(View view) {
        AppMethodBeat.i(133661);
        IBinder windowToken = view.getWindowToken();
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.type = 1000;
        layoutParams.token = windowToken;
        this.iVh = new View(this.mContext);
        this.iVh.setBackgroundColor(2130706432);
        this.iVh.setFitsSystemWindows(false);
        this.iVh.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(133658);
                if (motionEvent.getAction() == 1) {
                    g.this.dismiss();
                    AppMethodBeat.o(133658);
                    return true;
                }
                AppMethodBeat.o(133658);
                return false;
            }
        });
        this.iVh.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(133659);
                if (i == 4) {
                    g.this.dismiss();
                    AppMethodBeat.o(133659);
                    return true;
                }
                AppMethodBeat.o(133659);
                return false;
            }
        });
        this.gMh.addView(this.iVh, layoutParams);
        super.showAsDropDown(view);
        AppMethodBeat.o(133661);
    }

    public final void setContentView(View view) {
        AppMethodBeat.i(133663);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        layoutParams.topMargin = a.am(this.mContext, R.dimen.qr);
        layoutParams.rightMargin = a.am(this.mContext, R.dimen.qq);
        layoutParams.leftMargin = a.am(this.mContext, R.dimen.qq);
        this.iVi.addView(view, layoutParams);
        super.setContentView(this.iVi);
        AppMethodBeat.o(133663);
    }

    public final void dismiss() {
        AppMethodBeat.i(133662);
        if (this.iVh != null) {
            this.gMh.removeViewImmediate(this.iVh);
            this.iVh = null;
        }
        super.dismiss();
        AppMethodBeat.o(133662);
    }
}
