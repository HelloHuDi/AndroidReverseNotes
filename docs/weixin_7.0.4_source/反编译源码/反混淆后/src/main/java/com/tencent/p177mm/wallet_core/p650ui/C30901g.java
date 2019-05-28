package com.tencent.p177mm.wallet_core.p650ui;

import android.app.Dialog;
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
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.p612ui.base.C23636q;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.wallet_core.ui.g */
public final class C30901g extends C23636q {
    /* renamed from: WL */
    private View f13772WL = null;
    private ProgressBar iUz;
    private Context mContext;
    private TextView ykU;

    private C30901g(Context context) {
        super(context, C25738R.style.f11415zt);
        AppMethodBeat.m2504i(49335);
        this.mContext = context;
        if (this.f13772WL == null) {
            this.f13772WL = View.inflate(this.mContext, 2130971156, null);
            this.ykU = (TextView) this.f13772WL.findViewById(2131821803);
            this.iUz = (ProgressBar) this.f13772WL.findViewById(2131821802);
            setCanceledOnTouchOutside(true);
        }
        AppMethodBeat.m2505o(49335);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(49336);
        super.onCreate(bundle);
        setContentView(this.f13772WL, new LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        getWindow().addFlags(2);
        attributes.dimAmount = 0.65f;
        onWindowAttributesChanged(attributes);
        AppMethodBeat.m2505o(49336);
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.m2504i(49337);
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
        AppMethodBeat.m2505o(49337);
    }

    public final void setMessage(CharSequence charSequence) {
        AppMethodBeat.m2504i(49338);
        this.ykU.setText(charSequence);
        AppMethodBeat.m2505o(49338);
    }

    /* renamed from: a */
    public static Dialog m49316a(Context context, CharSequence charSequence, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(49339);
        C30901g c30901g = new C30901g(context);
        c30901g.setMessage(charSequence);
        c30901g.setCancelable(true);
        c30901g.setOnCancelListener(onCancelListener);
        c30901g.setCanceledOnTouchOutside(false);
        c30901g.show();
        AppMethodBeat.m2505o(49339);
        return c30901g;
    }

    /* renamed from: d */
    public static Dialog m49319d(Context context, String str, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(49340);
        View inflate = View.inflate(context, 2130971157, null);
        ((TextView) inflate.findViewById(2131829018)).setText(str);
        C15532i c15532i = new C15532i(context, C25738R.style.f11304w3);
        c15532i.setCancelable(false);
        c15532i.setContentView(inflate);
        c15532i.setOnCancelListener(onCancelListener);
        c15532i.show();
        AppMethodBeat.m2505o(49340);
        return c15532i;
    }

    /* renamed from: a */
    public static Dialog m49317a(Context context, boolean z, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(49341);
        View inflate = View.inflate(context, 2130971157, null);
        C15532i c15532i = new C15532i(context, C25738R.style.f11304w3);
        c15532i.setCancelable(z);
        c15532i.setContentView(inflate);
        c15532i.setOnCancelListener(onCancelListener);
        c15532i.show();
        AppMethodBeat.m2505o(49341);
        return c15532i;
    }

    /* renamed from: g */
    public static Dialog m49320g(Context context, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(49342);
        View inflate = View.inflate(context, 2130971157, null);
        C15532i c15532i = new C15532i(context, C25738R.style.f11304w3);
        c15532i.setCancelable(true);
        c15532i.setContentView(inflate);
        c15532i.setCanceledOnTouchOutside(false);
        c15532i.setOnCancelListener(onCancelListener);
        c15532i.show();
        AppMethodBeat.m2505o(49342);
        return c15532i;
    }

    /* renamed from: b */
    public static Dialog m49318b(Context context, boolean z, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(49343);
        context.getString(C25738R.string.f9104pl);
        C44275p b = C30379h.m48458b(context, context.getString(C25738R.string.fop), z, onCancelListener);
        AppMethodBeat.m2505o(49343);
        return b;
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(49344);
        try {
            super.dismiss();
            AppMethodBeat.m2505o(49344);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.WalletProgressDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.m2505o(49344);
        }
    }
}
