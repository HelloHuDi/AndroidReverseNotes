package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.base.p */
public final class C44275p extends C23636q {
    /* renamed from: WL */
    private View f17253WL;
    public ProgressBar iUz;
    private Context mContext;
    private int style;
    private TextView ykU;

    private C44275p(Context context, int i, int i2) {
        int i3 = 2130970213;
        super(context, i);
        AppMethodBeat.m2504i(106711);
        this.mContext = context;
        this.style = i2;
        switch (this.style) {
            case 1:
                i3 = 2130970214;
                break;
        }
        this.f17253WL = C5616v.m8409hu(this.mContext).inflate(i3, null);
        this.ykU = (TextView) this.f17253WL.findViewById(2131821803);
        this.iUz = (ProgressBar) this.f17253WL.findViewById(2131821802);
        setCanceledOnTouchOutside(true);
        AppMethodBeat.m2505o(106711);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(106712);
        super.onCreate(bundle);
        setContentView(this.f17253WL, new LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        if (this.style == 2) {
            getWindow().addFlags(2);
            attributes.dimAmount = 0.65f;
        }
        onWindowAttributesChanged(attributes);
        AppMethodBeat.m2505o(106712);
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.m2504i(106713);
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
        AppMethodBeat.m2505o(106713);
    }

    public final void setMessage(CharSequence charSequence) {
        AppMethodBeat.m2504i(106714);
        this.ykU.setText(charSequence);
        AppMethodBeat.m2505o(106714);
    }

    /* renamed from: d */
    public static C44275p m79967d(Context context, CharSequence charSequence) {
        AppMethodBeat.m2504i(106715);
        C44275p a = C44275p.m79964a(context, charSequence, true, 0, -1, null);
        AppMethodBeat.m2505o(106715);
        return a;
    }

    /* renamed from: a */
    private static C44275p m79964a(Context context, CharSequence charSequence, boolean z, int i, int i2, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(106716);
        if (i2 <= 0) {
            switch (i) {
                case 0:
                    i2 = C25738R.style.f11415zt;
                    break;
                case 1:
                    i2 = C25738R.style.f11415zt;
                    break;
                case 2:
                    i2 = C25738R.style.f11415zt;
                    break;
                case 3:
                    i2 = C25738R.style.f11420zy;
                    break;
                default:
                    i2 = C25738R.style.f11420zy;
                    break;
            }
        }
        C44275p c44275p = new C44275p(context, i2, i);
        c44275p.setMessage(charSequence);
        c44275p.setCancelable(z);
        c44275p.setOnCancelListener(onCancelListener);
        c44275p.setCanceledOnTouchOutside(false);
        AppMethodBeat.m2505o(106716);
        return c44275p;
    }

    /* renamed from: b */
    public static C44275p m79966b(Context context, CharSequence charSequence, boolean z, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(106717);
        C44275p b = C44275p.m79965b(context, charSequence, z, 0, -1, onCancelListener);
        AppMethodBeat.m2505o(106717);
        return b;
    }

    /* renamed from: b */
    public static C44275p m79965b(Context context, CharSequence charSequence, boolean z, int i, int i2, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(106718);
        C44275p a = C44275p.m79964a(context, charSequence, z, i, i2, onCancelListener);
        a.show();
        AppMethodBeat.m2505o(106718);
        return a;
    }

    public final void show() {
        AppMethodBeat.m2504i(106719);
        try {
            super.show();
            AppMethodBeat.m2505o(106719);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMProgressDialog", e, "", new Object[0]);
            AppMethodBeat.m2505o(106719);
        }
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(106720);
        try {
            super.dismiss();
            AppMethodBeat.m2505o(106720);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MMProgressDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.m2505o(106720);
        }
    }
}
