package com.tencent.p177mm.plugin.appbrand.widget.p337b;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.b.b */
public class C6789b extends C5653c implements C38571j {
    private View contentView;
    private OnCancelListener gAs;
    private boolean gHY = true;
    private OnDismissListener jbD;
    private OnShowListener jbE;
    private boolean jbF;
    private C33589k jbG;
    private boolean jbI = false;

    public C6789b(Context context) {
        super(context);
        AppMethodBeat.m2504i(87509);
        setContentView(super.getContentView());
        setCanceledOnTouchOutside(false);
        AppMethodBeat.m2505o(87509);
    }

    public C6789b(Context context, byte b) {
        super(context);
    }

    /* renamed from: a */
    public final void mo15058a(C33589k c33589k) {
        AppMethodBeat.m2504i(87510);
        if (this.jbE != null) {
            this.jbE.onShow(this);
        }
        this.jbG = c33589k;
        AppMethodBeat.m2505o(87510);
    }

    public final View getContentView() {
        AppMethodBeat.m2504i(87511);
        View view;
        if (this.contentView != null) {
            view = this.contentView;
            AppMethodBeat.m2505o(87511);
            return view;
        }
        view = super.getContentView();
        AppMethodBeat.m2505o(87511);
        return view;
    }

    /* renamed from: pF */
    public final void mo15063pF(int i) {
    }

    public void setContentView(int i) {
        AppMethodBeat.m2504i(87512);
        setContentView(LayoutInflater.from(getContext()).inflate(i, null));
        AppMethodBeat.m2505o(87512);
    }

    public void setContentView(View view) {
        AppMethodBeat.m2504i(87513);
        if (!(view instanceof C33583a)) {
            view = new C33583a(view.getContext(), view);
        }
        this.contentView = view;
        AppMethodBeat.m2505o(87513);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        AppMethodBeat.m2504i(87514);
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        setContentView(view);
        AppMethodBeat.m2505o(87514);
    }

    public void show() {
    }

    public void setOnShowListener(OnShowListener onShowListener) {
        AppMethodBeat.m2504i(87515);
        super.setOnShowListener(onShowListener);
        this.jbE = onShowListener;
        AppMethodBeat.m2505o(87515);
    }

    public final void onCancel() {
        AppMethodBeat.m2504i(87516);
        if (this.gAs != null) {
            this.gAs.onCancel(this);
        }
        AppMethodBeat.m2505o(87516);
    }

    public void dismiss() {
        AppMethodBeat.m2504i(87517);
        if (this.jbI) {
            AppMethodBeat.m2505o(87517);
            return;
        }
        this.jbI = true;
        if (this.jbG != null) {
            this.jbG.mo6469c(this);
            if (this.jbD != null) {
                this.jbD.onDismiss(this);
            }
        }
        AppMethodBeat.m2505o(87517);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        AppMethodBeat.m2504i(87518);
        super.setOnDismissListener(onDismissListener);
        this.jbD = onDismissListener;
        AppMethodBeat.m2505o(87518);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        AppMethodBeat.m2504i(87519);
        super.setCanceledOnTouchOutside(z);
        this.jbF = z;
        AppMethodBeat.m2505o(87519);
    }

    public final boolean aKP() {
        return this.jbF;
    }

    public void setCancelable(boolean z) {
        AppMethodBeat.m2504i(87520);
        super.setCancelable(z);
        this.gHY = z;
        AppMethodBeat.m2505o(87520);
    }

    public final boolean isCancelable() {
        return this.gHY;
    }

    public final int getPosition() {
        return 1;
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(87521);
        super.setOnCancelListener(onCancelListener);
        this.gAs = onCancelListener;
        AppMethodBeat.m2505o(87521);
    }
}
