package com.tencent.mm.ui.base;

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
import com.tencent.mm.ui.v;

public final class p extends q {
    private View WL;
    public ProgressBar iUz;
    private Context mContext;
    private int style;
    private TextView ykU;

    private p(Context context, int i, int i2) {
        int i3 = R.layout.agf;
        super(context, i);
        AppMethodBeat.i(106711);
        this.mContext = context;
        this.style = i2;
        switch (this.style) {
            case 1:
                i3 = R.layout.agg;
                break;
        }
        this.WL = v.hu(this.mContext).inflate(i3, null);
        this.ykU = (TextView) this.WL.findViewById(R.id.a70);
        this.iUz = (ProgressBar) this.WL.findViewById(R.id.a6z);
        setCanceledOnTouchOutside(true);
        AppMethodBeat.o(106711);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(106712);
        super.onCreate(bundle);
        setContentView(this.WL, new LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        if (this.style == 2) {
            getWindow().addFlags(2);
            attributes.dimAmount = 0.65f;
        }
        onWindowAttributesChanged(attributes);
        AppMethodBeat.o(106712);
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.i(106713);
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
        AppMethodBeat.o(106713);
    }

    public final void setMessage(CharSequence charSequence) {
        AppMethodBeat.i(106714);
        this.ykU.setText(charSequence);
        AppMethodBeat.o(106714);
    }

    public static p d(Context context, CharSequence charSequence) {
        AppMethodBeat.i(106715);
        p a = a(context, charSequence, true, 0, -1, null);
        AppMethodBeat.o(106715);
        return a;
    }

    private static p a(Context context, CharSequence charSequence, boolean z, int i, int i2, OnCancelListener onCancelListener) {
        AppMethodBeat.i(106716);
        if (i2 <= 0) {
            switch (i) {
                case 0:
                    i2 = R.style.zt;
                    break;
                case 1:
                    i2 = R.style.zt;
                    break;
                case 2:
                    i2 = R.style.zt;
                    break;
                case 3:
                    i2 = R.style.zy;
                    break;
                default:
                    i2 = R.style.zy;
                    break;
            }
        }
        p pVar = new p(context, i2, i);
        pVar.setMessage(charSequence);
        pVar.setCancelable(z);
        pVar.setOnCancelListener(onCancelListener);
        pVar.setCanceledOnTouchOutside(false);
        AppMethodBeat.o(106716);
        return pVar;
    }

    public static p b(Context context, CharSequence charSequence, boolean z, OnCancelListener onCancelListener) {
        AppMethodBeat.i(106717);
        p b = b(context, charSequence, z, 0, -1, onCancelListener);
        AppMethodBeat.o(106717);
        return b;
    }

    public static p b(Context context, CharSequence charSequence, boolean z, int i, int i2, OnCancelListener onCancelListener) {
        AppMethodBeat.i(106718);
        p a = a(context, charSequence, z, i, i2, onCancelListener);
        a.show();
        AppMethodBeat.o(106718);
        return a;
    }

    public final void show() {
        AppMethodBeat.i(106719);
        try {
            super.show();
            AppMethodBeat.o(106719);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMProgressDialog", e, "", new Object[0]);
            AppMethodBeat.o(106719);
        }
    }

    public final void dismiss() {
        AppMethodBeat.i(106720);
        try {
            super.dismiss();
            AppMethodBeat.o(106720);
        } catch (Exception e) {
            ab.e("MicroMsg.MMProgressDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.o(106720);
        }
    }
}
