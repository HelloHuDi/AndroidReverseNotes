package com.tencent.p177mm.plugin.appbrand.widget.p337b;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.p633a.C30800f;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.b.g */
public final class C33584g extends C30800f implements C38571j {
    private View contentView;
    private OnCancelListener gAs;
    private boolean gHY = true;
    private OnDismissListener jbD;
    private OnShowListener jbE;
    private boolean jbF;
    private C33589k jbG;

    public C33584g(Context context) {
        super(context);
        AppMethodBeat.m2504i(102358);
        try {
            onCreate(null);
            AppMethodBeat.m2505o(102358);
        } catch (Exception e) {
            AppMethodBeat.m2505o(102358);
        }
    }

    /* renamed from: a */
    public final void mo15058a(C33589k c33589k) {
        AppMethodBeat.m2504i(102359);
        if (this.jbE != null) {
            this.jbE.onShow(this);
        }
        this.jbG = c33589k;
        AppMethodBeat.m2505o(102359);
    }

    public final View getContentView() {
        return this.contentView;
    }

    /* renamed from: pF */
    public final void mo15063pF(int i) {
    }

    public final void setContentView(int i) {
        AppMethodBeat.m2504i(102360);
        setContentView(LayoutInflater.from(getContext()).inflate(i, null));
        AppMethodBeat.m2505o(102360);
    }

    public final void setContentView(View view) {
        this.contentView = view;
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        AppMethodBeat.m2504i(102361);
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        setContentView(view);
        AppMethodBeat.m2505o(102361);
    }

    public final void show() {
    }

    public final void setOnShowListener(OnShowListener onShowListener) {
        AppMethodBeat.m2504i(102362);
        super.setOnShowListener(onShowListener);
        this.jbE = onShowListener;
        AppMethodBeat.m2505o(102362);
    }

    public final void onCancel() {
        AppMethodBeat.m2504i(102363);
        if (this.gAs != null) {
            this.gAs.onCancel(this);
        }
        AppMethodBeat.m2505o(102363);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(102364);
        if (this.jbG != null) {
            this.jbG.mo6469c(this);
            if (this.jbD != null) {
                this.jbD.onDismiss(this);
            }
        }
        AppMethodBeat.m2505o(102364);
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        AppMethodBeat.m2504i(102365);
        super.setOnDismissListener(onDismissListener);
        this.jbD = onDismissListener;
        AppMethodBeat.m2505o(102365);
    }

    public final void setCanceledOnTouchOutside(boolean z) {
        AppMethodBeat.m2504i(102366);
        super.setCanceledOnTouchOutside(z);
        this.jbF = z;
        AppMethodBeat.m2505o(102366);
    }

    public final boolean aKP() {
        return this.jbF;
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.m2504i(102367);
        super.setCancelable(z);
        this.gHY = z;
        AppMethodBeat.m2505o(102367);
    }

    public final boolean isCancelable() {
        return this.gHY;
    }

    public final int getPosition() {
        return 1;
    }

    public final void setOnCancelListener(OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(102368);
        super.setOnCancelListener(onCancelListener);
        this.gAs = onCancelListener;
        AppMethodBeat.m2505o(102368);
    }
}
