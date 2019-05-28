package com.tencent.mm.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

final class o extends Dialog implements DialogInterface {
    private boolean gHY;
    private View iUw = this.ykT.findViewById(R.id.d8r);
    private TextView jao = ((TextView) this.ykT.findViewById(R.id.d8s));
    private Context mContext;
    Button tJz = ((Button) this.ykT.findViewById(R.id.b00));
    private LinearLayout ykT = ((LinearLayout) v.hu(this.mContext).inflate(R.layout.ad6, null));
    TextView ykU = ((TextView) this.ykT.findViewById(R.id.d8x));
    private TextView ykV = ((TextView) this.ykT.findViewById(R.id.b05));
    LinearLayout ykW = ((LinearLayout) this.ykT.findViewById(R.id.c6c));
    private LinearLayout ykX = ((LinearLayout) this.ykT.findViewById(R.id.d8y));

    /* renamed from: com.tencent.mm.ui.o$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ DialogInterface.OnClickListener ykY;
        final /* synthetic */ boolean ykZ = true;

        AnonymousClass1(DialogInterface.OnClickListener onClickListener) {
            this.ykY = onClickListener;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(29536);
            if (this.ykY != null) {
                this.ykY.onClick(o.this, -1);
            }
            if (this.ykZ) {
                o.this.dismiss();
            }
            AppMethodBeat.o(29536);
        }
    }

    public o(Context context) {
        super(context, R.style.zt);
        AppMethodBeat.i(29538);
        this.mContext = context;
        setCanceledOnTouchOutside(true);
        AppMethodBeat.o(29538);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(29539);
        super.onCreate(bundle);
        setContentView(this.ykT);
        AppMethodBeat.o(29539);
    }

    public final void setTitle(CharSequence charSequence) {
        AppMethodBeat.i(29540);
        this.iUw.setVisibility(0);
        this.jao.setVisibility(0);
        this.jao.setMaxLines(2);
        this.jao.setText(charSequence);
        dxO();
        AppMethodBeat.o(29540);
    }

    public final void setTitle(int i) {
        AppMethodBeat.i(29541);
        this.iUw.setVisibility(0);
        this.jao.setVisibility(0);
        this.jao.setMaxLines(2);
        this.jao.setText(i);
        dxO();
        AppMethodBeat.o(29541);
    }

    private void dxO() {
        AppMethodBeat.i(29542);
        if (this.ykU != null) {
            this.ykU.setTextColor(this.ykU.getContext().getResources().getColor(R.color.ma));
        }
        AppMethodBeat.o(29542);
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.i(29543);
        super.setCancelable(z);
        this.gHY = z;
        setCanceledOnTouchOutside(this.gHY);
        AppMethodBeat.o(29543);
    }

    public final void dxP() {
        AppMethodBeat.i(29544);
        super.setCancelable(true);
        AppMethodBeat.o(29544);
    }

    public final void show() {
        AppMethodBeat.i(29545);
        try {
            super.show();
            AppMethodBeat.o(29545);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.LiteDependDialog", e, "", new Object[0]);
            AppMethodBeat.o(29545);
        }
    }

    public final void dismiss() {
        AppMethodBeat.i(29546);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(29537);
                    o.this.dismiss();
                    AppMethodBeat.o(29537);
                }
            });
            ab.e("MicroMsg.LiteDependDialog", bo.dpG().toString());
            AppMethodBeat.o(29546);
            return;
        }
        try {
            super.dismiss();
            AppMethodBeat.o(29546);
        } catch (Exception e) {
            ab.e("MicroMsg.LiteDependDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.o(29546);
        }
    }
}
