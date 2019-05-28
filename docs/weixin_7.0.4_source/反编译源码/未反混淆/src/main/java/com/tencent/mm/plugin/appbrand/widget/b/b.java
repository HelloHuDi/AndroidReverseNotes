package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.c;

public class b extends c implements j {
    private View contentView;
    private OnCancelListener gAs;
    private boolean gHY = true;
    private OnDismissListener jbD;
    private OnShowListener jbE;
    private boolean jbF;
    private k jbG;
    private boolean jbI = false;

    public b(Context context) {
        super(context);
        AppMethodBeat.i(87509);
        setContentView(super.getContentView());
        setCanceledOnTouchOutside(false);
        AppMethodBeat.o(87509);
    }

    public b(Context context, byte b) {
        super(context);
    }

    public final void a(k kVar) {
        AppMethodBeat.i(87510);
        if (this.jbE != null) {
            this.jbE.onShow(this);
        }
        this.jbG = kVar;
        AppMethodBeat.o(87510);
    }

    public final View getContentView() {
        AppMethodBeat.i(87511);
        View view;
        if (this.contentView != null) {
            view = this.contentView;
            AppMethodBeat.o(87511);
            return view;
        }
        view = super.getContentView();
        AppMethodBeat.o(87511);
        return view;
    }

    public final void pF(int i) {
    }

    public void setContentView(int i) {
        AppMethodBeat.i(87512);
        setContentView(LayoutInflater.from(getContext()).inflate(i, null));
        AppMethodBeat.o(87512);
    }

    public void setContentView(View view) {
        AppMethodBeat.i(87513);
        if (!(view instanceof a)) {
            view = new a(view.getContext(), view);
        }
        this.contentView = view;
        AppMethodBeat.o(87513);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        AppMethodBeat.i(87514);
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        setContentView(view);
        AppMethodBeat.o(87514);
    }

    public void show() {
    }

    public void setOnShowListener(OnShowListener onShowListener) {
        AppMethodBeat.i(87515);
        super.setOnShowListener(onShowListener);
        this.jbE = onShowListener;
        AppMethodBeat.o(87515);
    }

    public final void onCancel() {
        AppMethodBeat.i(87516);
        if (this.gAs != null) {
            this.gAs.onCancel(this);
        }
        AppMethodBeat.o(87516);
    }

    public void dismiss() {
        AppMethodBeat.i(87517);
        if (this.jbI) {
            AppMethodBeat.o(87517);
            return;
        }
        this.jbI = true;
        if (this.jbG != null) {
            this.jbG.c(this);
            if (this.jbD != null) {
                this.jbD.onDismiss(this);
            }
        }
        AppMethodBeat.o(87517);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        AppMethodBeat.i(87518);
        super.setOnDismissListener(onDismissListener);
        this.jbD = onDismissListener;
        AppMethodBeat.o(87518);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        AppMethodBeat.i(87519);
        super.setCanceledOnTouchOutside(z);
        this.jbF = z;
        AppMethodBeat.o(87519);
    }

    public final boolean aKP() {
        return this.jbF;
    }

    public void setCancelable(boolean z) {
        AppMethodBeat.i(87520);
        super.setCancelable(z);
        this.gHY = z;
        AppMethodBeat.o(87520);
    }

    public final boolean isCancelable() {
        return this.gHY;
    }

    public final int getPosition() {
        return 1;
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        AppMethodBeat.i(87521);
        super.setOnCancelListener(onCancelListener);
        this.gAs = onCancelListener;
        AppMethodBeat.o(87521);
    }
}
