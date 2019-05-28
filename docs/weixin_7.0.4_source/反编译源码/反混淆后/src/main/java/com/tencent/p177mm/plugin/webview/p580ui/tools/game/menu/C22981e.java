package com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p069v7.app.C6218i;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.menu.e */
public final class C22981e extends C6218i {
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.menu.e$1 */
    class C229821 implements OnClickListener {
        C229821() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(8835);
            if (C22981e.this.isShowing()) {
                C22981e.this.cancel();
            }
            AppMethodBeat.m2505o(8835);
        }
    }

    public C22981e(Context context) {
        this(context, (byte) 0);
    }

    private C22981e(Context context, byte b) {
        super(context, C25738R.style.f10957jx);
        AppMethodBeat.m2504i(8836);
        mo14042fA();
        this.mContext = context;
        AppMethodBeat.m2505o(8836);
    }

    public final void setContentView(int i) {
        AppMethodBeat.m2504i(8837);
        super.setContentView(m34856b(i, null, null));
        AppMethodBeat.m2505o(8837);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(8838);
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
        AppMethodBeat.m2505o(8838);
    }

    public final void setContentView(View view) {
        AppMethodBeat.m2504i(8839);
        super.setContentView(m34856b(0, view, null));
        AppMethodBeat.m2505o(8839);
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        AppMethodBeat.m2504i(8840);
        super.setContentView(m34856b(0, view, layoutParams));
        AppMethodBeat.m2505o(8840);
    }

    /* renamed from: b */
    private View m34856b(int i, View view, LayoutParams layoutParams) {
        FrameLayout frameLayout;
        AppMethodBeat.m2504i(8841);
        Window window = getWindow();
        if (isLandscape()) {
            window.setGravity(5);
            window.setWindowAnimations(C25738R.style.f11154qp);
        } else {
            window.setGravity(80);
            window.setWindowAnimations(C25738R.style.f10821fb);
        }
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(2130969751, null);
        View findViewById = viewGroup.findViewById(2131823263);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, viewGroup, false);
        }
        if (isLandscape()) {
            frameLayout = (FrameLayout) viewGroup.findViewById(2131824569);
        } else {
            frameLayout = (FrameLayout) viewGroup.findViewById(2131824568);
        }
        frameLayout.setVisibility(0);
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        if (dce()) {
            findViewById.setOnClickListener(new C229821());
        }
        AppMethodBeat.m2505o(8841);
        return viewGroup;
    }

    private boolean dce() {
        AppMethodBeat.m2504i(8842);
        if (VERSION.SDK_INT < 11) {
            AppMethodBeat.m2505o(8842);
            return true;
        }
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(16843611, typedValue, true)) {
            AppMethodBeat.m2505o(8842);
            return false;
        } else if (typedValue.data != 0) {
            AppMethodBeat.m2505o(8842);
            return true;
        } else {
            AppMethodBeat.m2505o(8842);
            return false;
        }
    }

    private boolean isLandscape() {
        AppMethodBeat.m2504i(8843);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            AppMethodBeat.m2505o(8843);
            return true;
        }
        AppMethodBeat.m2505o(8843);
        return false;
    }
}
