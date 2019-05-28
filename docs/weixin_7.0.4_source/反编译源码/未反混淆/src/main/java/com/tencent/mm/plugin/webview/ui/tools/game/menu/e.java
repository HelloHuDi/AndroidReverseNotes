package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.i;
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
import com.tencent.mm.R;

public final class e extends i {
    private Context mContext;

    public e(Context context) {
        this(context, (byte) 0);
    }

    private e(Context context, byte b) {
        super(context, R.style.jx);
        AppMethodBeat.i(8836);
        fA();
        this.mContext = context;
        AppMethodBeat.o(8836);
    }

    public final void setContentView(int i) {
        AppMethodBeat.i(8837);
        super.setContentView(b(i, null, null));
        AppMethodBeat.o(8837);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(8838);
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
        AppMethodBeat.o(8838);
    }

    public final void setContentView(View view) {
        AppMethodBeat.i(8839);
        super.setContentView(b(0, view, null));
        AppMethodBeat.o(8839);
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        AppMethodBeat.i(8840);
        super.setContentView(b(0, view, layoutParams));
        AppMethodBeat.o(8840);
    }

    private View b(int i, View view, LayoutParams layoutParams) {
        FrameLayout frameLayout;
        AppMethodBeat.i(8841);
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
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.a4y, null);
        View findViewById = viewGroup.findViewById(R.id.b9h);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, viewGroup, false);
        }
        if (isLandscape()) {
            frameLayout = (FrameLayout) viewGroup.findViewById(R.id.c7s);
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
                    AppMethodBeat.i(8835);
                    if (e.this.isShowing()) {
                        e.this.cancel();
                    }
                    AppMethodBeat.o(8835);
                }
            });
        }
        AppMethodBeat.o(8841);
        return viewGroup;
    }

    private boolean dce() {
        AppMethodBeat.i(8842);
        if (VERSION.SDK_INT < 11) {
            AppMethodBeat.o(8842);
            return true;
        }
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(16843611, typedValue, true)) {
            AppMethodBeat.o(8842);
            return false;
        } else if (typedValue.data != 0) {
            AppMethodBeat.o(8842);
            return true;
        } else {
            AppMethodBeat.o(8842);
            return false;
        }
    }

    private boolean isLandscape() {
        AppMethodBeat.i(8843);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            AppMethodBeat.o(8843);
            return true;
        }
        AppMethodBeat.o(8843);
        return false;
    }
}
