package com.tencent.mm.ui.widget.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v7.app.i;
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
import com.tencent.mm.R;
import com.tencent.mm.ui.ak;

public final class b extends i {
    private Context mContext;

    public b(Context context) {
        this(context, (byte) 0);
    }

    private b(Context context, byte b) {
        super(context, R.style.h4);
        AppMethodBeat.i(112592);
        this.mContext = context;
        fA();
        AppMethodBeat.o(112592);
    }

    public final void setContentView(View view) {
        AppMethodBeat.i(112593);
        super.setContentView(b(0, view, null));
        AppMethodBeat.o(112593);
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        AppMethodBeat.i(112594);
        super.setContentView(b(0, view, layoutParams));
        AppMethodBeat.o(112594);
    }

    public final void setContentView(int i) {
        AppMethodBeat.i(112595);
        super.setContentView(b(i, null, null));
        AppMethodBeat.o(112595);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(112596);
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
        AppMethodBeat.o(112596);
    }

    private View b(int i, View view, LayoutParams layoutParams) {
        FrameLayout frameLayout;
        AppMethodBeat.i(112597);
        Window window = getWindow();
        if (isLandscape()) {
            window.setGravity(5);
            window.setWindowAnimations(R.style.qp);
        } else {
            window.setGravity(80);
            window.setWindowAnimations(R.style.fb);
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
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.acy, null);
        View findViewById = viewGroup.findViewById(R.id.b9h);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, viewGroup, false);
        }
        if (isLandscape()) {
            frameLayout = (FrameLayout) viewGroup.findViewById(R.id.c7s);
            if (frameLayout != null) {
                int fr;
                d dVar = (d) frameLayout.getLayoutParams();
                if (ak.hw(this.mContext)) {
                    fr = ak.fr(this.mContext);
                } else {
                    fr = 0;
                }
                if (getRotation() == 1) {
                    dVar.setMargins(0, 0, fr, 0);
                } else if (getRotation() == 3) {
                    dVar.setMargins(fr, 0, 0, 0);
                }
                frameLayout.setLayoutParams(dVar);
            }
        } else {
            frameLayout = (FrameLayout) viewGroup.findViewById(R.id.c7r);
        }
        frameLayout.setVisibility(0);
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        if (dce()) {
            findViewById.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(112591);
                    if (b.this.isShowing()) {
                        b.this.cancel();
                    }
                    AppMethodBeat.o(112591);
                }
            });
        }
        AppMethodBeat.o(112597);
        return viewGroup;
    }

    private boolean dce() {
        AppMethodBeat.i(112598);
        if (VERSION.SDK_INT < 11) {
            AppMethodBeat.o(112598);
            return true;
        }
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(16843611, typedValue, true)) {
            AppMethodBeat.o(112598);
            return false;
        } else if (typedValue.data != 0) {
            AppMethodBeat.o(112598);
            return true;
        } else {
            AppMethodBeat.o(112598);
            return false;
        }
    }

    private boolean isLandscape() {
        AppMethodBeat.i(112599);
        if (this.mContext.getResources().getConfiguration().orientation == 2) {
            AppMethodBeat.o(112599);
            return true;
        }
        AppMethodBeat.o(112599);
        return false;
    }

    @SuppressLint({"WrongConstant"})
    private int getRotation() {
        AppMethodBeat.i(112600);
        int rotation = getWindow().getWindowManager().getDefaultDisplay().getRotation();
        AppMethodBeat.o(112600);
        return rotation;
    }
}
