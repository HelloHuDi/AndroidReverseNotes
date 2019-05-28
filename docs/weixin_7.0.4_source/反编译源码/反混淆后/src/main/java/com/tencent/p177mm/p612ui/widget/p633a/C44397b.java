package com.tencent.p177mm.p612ui.widget.p633a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout.C31839d;
import android.support.p069v7.app.C6218i;
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
import com.tencent.p177mm.p612ui.C5230ak;

/* renamed from: com.tencent.mm.ui.widget.a.b */
public final class C44397b extends C6218i {
    private Context mContext;

    /* renamed from: com.tencent.mm.ui.widget.a.b$1 */
    class C159931 implements OnClickListener {
        C159931() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(112591);
            if (C44397b.this.isShowing()) {
                C44397b.this.cancel();
            }
            AppMethodBeat.m2505o(112591);
        }
    }

    public C44397b(Context context) {
        this(context, (byte) 0);
    }

    private C44397b(Context context, byte b) {
        super(context, C25738R.style.f10872h4);
        AppMethodBeat.m2504i(112592);
        this.mContext = context;
        mo14042fA();
        AppMethodBeat.m2505o(112592);
    }

    public final void setContentView(View view) {
        AppMethodBeat.m2504i(112593);
        super.setContentView(m80261b(0, view, null));
        AppMethodBeat.m2505o(112593);
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        AppMethodBeat.m2504i(112594);
        super.setContentView(m80261b(0, view, layoutParams));
        AppMethodBeat.m2505o(112594);
    }

    public final void setContentView(int i) {
        AppMethodBeat.m2504i(112595);
        super.setContentView(m80261b(i, null, null));
        AppMethodBeat.m2505o(112595);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(112596);
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
        AppMethodBeat.m2505o(112596);
    }

    /* renamed from: b */
    private View m80261b(int i, View view, LayoutParams layoutParams) {
        FrameLayout frameLayout;
        AppMethodBeat.m2504i(112597);
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
        if (isLandscape()) {
            attributes.width = -2;
            attributes.height = -1;
        } else {
            attributes.width = -1;
            attributes.height = -2;
        }
        window.setAttributes(attributes);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(2130970084, null);
        View findViewById = viewGroup.findViewById(2131823263);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, viewGroup, false);
        }
        if (isLandscape()) {
            frameLayout = (FrameLayout) viewGroup.findViewById(2131824569);
            if (frameLayout != null) {
                int fr;
                C31839d c31839d = (C31839d) frameLayout.getLayoutParams();
                if (C5230ak.m7991hw(this.mContext)) {
                    fr = C5230ak.m7988fr(this.mContext);
                } else {
                    fr = 0;
                }
                if (getRotation() == 1) {
                    c31839d.setMargins(0, 0, fr, 0);
                } else if (getRotation() == 3) {
                    c31839d.setMargins(fr, 0, 0, 0);
                }
                frameLayout.setLayoutParams(c31839d);
            }
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
            findViewById.setOnClickListener(new C159931());
        }
        AppMethodBeat.m2505o(112597);
        return viewGroup;
    }

    private boolean dce() {
        AppMethodBeat.m2504i(112598);
        if (VERSION.SDK_INT < 11) {
            AppMethodBeat.m2505o(112598);
            return true;
        }
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(16843611, typedValue, true)) {
            AppMethodBeat.m2505o(112598);
            return false;
        } else if (typedValue.data != 0) {
            AppMethodBeat.m2505o(112598);
            return true;
        } else {
            AppMethodBeat.m2505o(112598);
            return false;
        }
    }

    private boolean isLandscape() {
        AppMethodBeat.m2504i(112599);
        if (this.mContext.getResources().getConfiguration().orientation == 2) {
            AppMethodBeat.m2505o(112599);
            return true;
        }
        AppMethodBeat.m2505o(112599);
        return false;
    }

    @SuppressLint({"WrongConstant"})
    private int getRotation() {
        AppMethodBeat.m2504i(112600);
        int rotation = getWindow().getWindowManager().getDefaultDisplay().getRotation();
        AppMethodBeat.m2505o(112600);
        return rotation;
    }
}
