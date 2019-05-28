package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.f;

public final class g extends f implements j {
    private View contentView;
    private OnCancelListener gAs;
    private boolean gHY = true;
    private OnDismissListener jbD;
    private OnShowListener jbE;
    private boolean jbF;
    private k jbG;

    public g(Context context) {
        super(context);
        AppMethodBeat.i(102358);
        try {
            onCreate(null);
            AppMethodBeat.o(102358);
        } catch (Exception e) {
            AppMethodBeat.o(102358);
        }
    }

    public final void a(k kVar) {
        AppMethodBeat.i(102359);
        if (this.jbE != null) {
            this.jbE.onShow(this);
        }
        this.jbG = kVar;
        AppMethodBeat.o(102359);
    }

    public final View getContentView() {
        return this.contentView;
    }

    public final void pF(int i) {
    }

    public final void setContentView(int i) {
        AppMethodBeat.i(102360);
        setContentView(LayoutInflater.from(getContext()).inflate(i, null));
        AppMethodBeat.o(102360);
    }

    public final void setContentView(View view) {
        this.contentView = view;
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        AppMethodBeat.i(102361);
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        setContentView(view);
        AppMethodBeat.o(102361);
    }

    public final void show() {
    }

    public final void setOnShowListener(OnShowListener onShowListener) {
        AppMethodBeat.i(102362);
        super.setOnShowListener(onShowListener);
        this.jbE = onShowListener;
        AppMethodBeat.o(102362);
    }

    public final void onCancel() {
        AppMethodBeat.i(102363);
        if (this.gAs != null) {
            this.gAs.onCancel(this);
        }
        AppMethodBeat.o(102363);
    }

    public final void dismiss() {
        AppMethodBeat.i(102364);
        if (this.jbG != null) {
            this.jbG.c(this);
            if (this.jbD != null) {
                this.jbD.onDismiss(this);
            }
        }
        AppMethodBeat.o(102364);
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        AppMethodBeat.i(102365);
        super.setOnDismissListener(onDismissListener);
        this.jbD = onDismissListener;
        AppMethodBeat.o(102365);
    }

    public final void setCanceledOnTouchOutside(boolean z) {
        AppMethodBeat.i(102366);
        super.setCanceledOnTouchOutside(z);
        this.jbF = z;
        AppMethodBeat.o(102366);
    }

    public final boolean aKP() {
        return this.jbF;
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.i(102367);
        super.setCancelable(z);
        this.gHY = z;
        AppMethodBeat.o(102367);
    }

    public final boolean isCancelable() {
        return this.gHY;
    }

    public final int getPosition() {
        return 1;
    }

    public final void setOnCancelListener(OnCancelListener onCancelListener) {
        AppMethodBeat.i(102368);
        super.setOnCancelListener(onCancelListener);
        this.gAs = onCancelListener;
        AppMethodBeat.o(102368);
    }
}
