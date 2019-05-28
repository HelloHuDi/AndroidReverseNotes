package com.tencent.p177mm.p612ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.o */
final class C5519o extends Dialog implements DialogInterface {
    private boolean gHY;
    private View iUw = this.ykT.findViewById(2131825973);
    private TextView jao = ((TextView) this.ykT.findViewById(2131825974));
    private Context mContext;
    Button tJz = ((Button) this.ykT.findViewById(2131822912));
    private LinearLayout ykT = ((LinearLayout) C5616v.m8409hu(this.mContext).inflate(2130970092, null));
    TextView ykU = ((TextView) this.ykT.findViewById(2131825979));
    private TextView ykV = ((TextView) this.ykT.findViewById(2131822917));
    LinearLayout ykW = ((LinearLayout) this.ykT.findViewById(2131824516));
    private LinearLayout ykX = ((LinearLayout) this.ykT.findViewById(2131825980));

    /* renamed from: com.tencent.mm.ui.o$1 */
    class C55171 implements OnClickListener {
        final /* synthetic */ DialogInterface.OnClickListener ykY;
        final /* synthetic */ boolean ykZ = true;

        C55171(DialogInterface.OnClickListener onClickListener) {
            this.ykY = onClickListener;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(29536);
            if (this.ykY != null) {
                this.ykY.onClick(C5519o.this, -1);
            }
            if (this.ykZ) {
                C5519o.this.dismiss();
            }
            AppMethodBeat.m2505o(29536);
        }
    }

    /* renamed from: com.tencent.mm.ui.o$2 */
    class C55182 implements Runnable {
        C55182() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29537);
            C5519o.this.dismiss();
            AppMethodBeat.m2505o(29537);
        }
    }

    public C5519o(Context context) {
        super(context, C25738R.style.f11415zt);
        AppMethodBeat.m2504i(29538);
        this.mContext = context;
        setCanceledOnTouchOutside(true);
        AppMethodBeat.m2505o(29538);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(29539);
        super.onCreate(bundle);
        setContentView(this.ykT);
        AppMethodBeat.m2505o(29539);
    }

    public final void setTitle(CharSequence charSequence) {
        AppMethodBeat.m2504i(29540);
        this.iUw.setVisibility(0);
        this.jao.setVisibility(0);
        this.jao.setMaxLines(2);
        this.jao.setText(charSequence);
        dxO();
        AppMethodBeat.m2505o(29540);
    }

    public final void setTitle(int i) {
        AppMethodBeat.m2504i(29541);
        this.iUw.setVisibility(0);
        this.jao.setVisibility(0);
        this.jao.setMaxLines(2);
        this.jao.setText(i);
        dxO();
        AppMethodBeat.m2505o(29541);
    }

    private void dxO() {
        AppMethodBeat.m2504i(29542);
        if (this.ykU != null) {
            this.ykU.setTextColor(this.ykU.getContext().getResources().getColor(C25738R.color.f11939ma));
        }
        AppMethodBeat.m2505o(29542);
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.m2504i(29543);
        super.setCancelable(z);
        this.gHY = z;
        setCanceledOnTouchOutside(this.gHY);
        AppMethodBeat.m2505o(29543);
    }

    public final void dxP() {
        AppMethodBeat.m2504i(29544);
        super.setCancelable(true);
        AppMethodBeat.m2505o(29544);
    }

    public final void show() {
        AppMethodBeat.m2504i(29545);
        try {
            super.show();
            AppMethodBeat.m2505o(29545);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.LiteDependDialog", e, "", new Object[0]);
            AppMethodBeat.m2505o(29545);
        }
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(29546);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            C5004al.m7441d(new C55182());
            C4990ab.m7412e("MicroMsg.LiteDependDialog", C5046bo.dpG().toString());
            AppMethodBeat.m2505o(29546);
            return;
        }
        try {
            super.dismiss();
            AppMethodBeat.m2505o(29546);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.LiteDependDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.m2505o(29546);
        }
    }
}
