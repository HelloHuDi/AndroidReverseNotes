package com.tencent.p177mm.plugin.appbrand.widget.actionbar;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.actionbar.g */
public final class C33580g extends PopupWindow {
    private WindowManager gMh;
    private View iVh;
    public FrameLayout iVi;
    private Context mContext = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.actionbar.g$1 */
    class C335811 implements OnTouchListener {
        C335811() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(133658);
            if (motionEvent.getAction() == 1) {
                C33580g.this.dismiss();
                AppMethodBeat.m2505o(133658);
                return true;
            }
            AppMethodBeat.m2505o(133658);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.actionbar.g$2 */
    class C335822 implements OnKeyListener {
        C335822() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(133659);
            if (i == 4) {
                C33580g.this.dismiss();
                AppMethodBeat.m2505o(133659);
                return true;
            }
            AppMethodBeat.m2505o(133659);
            return false;
        }
    }

    public C33580g(Context context) {
        super(context);
        AppMethodBeat.m2504i(133660);
        this.mContext = context;
        this.gMh = (WindowManager) context.getSystemService("window");
        this.iVi = new FrameLayout(this.mContext);
        AppMethodBeat.m2505o(133660);
    }

    public final void showAsDropDown(View view) {
        AppMethodBeat.m2504i(133661);
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
        this.iVh.setOnTouchListener(new C335811());
        this.iVh.setOnKeyListener(new C335822());
        this.gMh.addView(this.iVh, layoutParams);
        super.showAsDropDown(view);
        AppMethodBeat.m2505o(133661);
    }

    public final void setContentView(View view) {
        AppMethodBeat.m2504i(133663);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        layoutParams.topMargin = C1338a.m2857am(this.mContext, C25738R.dimen.f10123qr);
        layoutParams.rightMargin = C1338a.m2857am(this.mContext, C25738R.dimen.f10122qq);
        layoutParams.leftMargin = C1338a.m2857am(this.mContext, C25738R.dimen.f10122qq);
        this.iVi.addView(view, layoutParams);
        super.setContentView(this.iVi);
        AppMethodBeat.m2505o(133663);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(133662);
        if (this.iVh != null) {
            this.gMh.removeViewImmediate(this.iVh);
            this.iVh = null;
        }
        super.dismiss();
        AppMethodBeat.m2505o(133662);
    }
}
