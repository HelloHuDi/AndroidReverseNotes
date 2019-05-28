package com.tencent.mm.wallet_core.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.q;

public final class g extends q {
    private View WL = null;
    private ProgressBar iUz;
    private Context mContext;
    private TextView ykU;

    private g(Context context) {
        super(context, R.style.zt);
        AppMethodBeat.i(49335);
        this.mContext = context;
        if (this.WL == null) {
            this.WL = View.inflate(this.mContext, R.layout.b5t, null);
            this.ykU = (TextView) this.WL.findViewById(R.id.a70);
            this.iUz = (ProgressBar) this.WL.findViewById(R.id.a6z);
            setCanceledOnTouchOutside(true);
        }
        AppMethodBeat.o(49335);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(49336);
        super.onCreate(bundle);
        setContentView(this.WL, new LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        getWindow().addFlags(2);
        attributes.dimAmount = 0.65f;
        onWindowAttributesChanged(attributes);
        AppMethodBeat.o(49336);
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.i(49337);
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
        AppMethodBeat.o(49337);
    }

    public final void setMessage(CharSequence charSequence) {
        AppMethodBeat.i(49338);
        this.ykU.setText(charSequence);
        AppMethodBeat.o(49338);
    }

    public static Dialog a(Context context, CharSequence charSequence, OnCancelListener onCancelListener) {
        AppMethodBeat.i(49339);
        g gVar = new g(context);
        gVar.setMessage(charSequence);
        gVar.setCancelable(true);
        gVar.setOnCancelListener(onCancelListener);
        gVar.setCanceledOnTouchOutside(false);
        gVar.show();
        AppMethodBeat.o(49339);
        return gVar;
    }

    public static Dialog d(Context context, String str, OnCancelListener onCancelListener) {
        AppMethodBeat.i(49340);
        View inflate = View.inflate(context, R.layout.b5u, null);
        ((TextView) inflate.findViewById(R.id.fg2)).setText(str);
        i iVar = new i(context, R.style.w3);
        iVar.setCancelable(false);
        iVar.setContentView(inflate);
        iVar.setOnCancelListener(onCancelListener);
        iVar.show();
        AppMethodBeat.o(49340);
        return iVar;
    }

    public static Dialog a(Context context, boolean z, OnCancelListener onCancelListener) {
        AppMethodBeat.i(49341);
        View inflate = View.inflate(context, R.layout.b5u, null);
        i iVar = new i(context, R.style.w3);
        iVar.setCancelable(z);
        iVar.setContentView(inflate);
        iVar.setOnCancelListener(onCancelListener);
        iVar.show();
        AppMethodBeat.o(49341);
        return iVar;
    }

    public static Dialog g(Context context, OnCancelListener onCancelListener) {
        AppMethodBeat.i(49342);
        View inflate = View.inflate(context, R.layout.b5u, null);
        i iVar = new i(context, R.style.w3);
        iVar.setCancelable(true);
        iVar.setContentView(inflate);
        iVar.setCanceledOnTouchOutside(false);
        iVar.setOnCancelListener(onCancelListener);
        iVar.show();
        AppMethodBeat.o(49342);
        return iVar;
    }

    public static Dialog b(Context context, boolean z, OnCancelListener onCancelListener) {
        AppMethodBeat.i(49343);
        context.getString(R.string.pl);
        p b = h.b(context, context.getString(R.string.fop), z, onCancelListener);
        AppMethodBeat.o(49343);
        return b;
    }

    public final void dismiss() {
        AppMethodBeat.i(49344);
        try {
            super.dismiss();
            AppMethodBeat.o(49344);
        } catch (Exception e) {
            ab.e("MicroMsg.WalletProgressDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.o(49344);
        }
    }
}
