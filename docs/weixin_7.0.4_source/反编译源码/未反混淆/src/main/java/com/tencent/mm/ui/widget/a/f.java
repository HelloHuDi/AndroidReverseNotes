package com.tencent.mm.ui.widget.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.ai;

public class f extends ProgressDialog {
    private View WL = View.inflate(this.mContext, R.layout.alx, null);
    private ProgressBar iUz = ((ProgressBar) this.WL.findViewById(R.id.dqk));
    private Context mContext;
    private TextView ykU = ((TextView) this.WL.findViewById(R.id.dql));

    public f(Context context) {
        super(context, R.style.zt);
        AppMethodBeat.i(112694);
        this.mContext = context;
        setCanceledOnTouchOutside(true);
        AppMethodBeat.o(112694);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(112696);
        super.onCreate(bundle);
        setContentView(this.WL, new LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        onWindowAttributesChanged(attributes);
        AppMethodBeat.o(112696);
    }

    public void setCancelable(boolean z) {
        AppMethodBeat.i(112697);
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
        AppMethodBeat.o(112697);
    }

    public void setMessage(CharSequence charSequence) {
        AppMethodBeat.i(112698);
        this.ykU.setText(charSequence);
        AppMethodBeat.o(112698);
    }

    public void show() {
        AppMethodBeat.i(112699);
        try {
            super.show();
            AppMethodBeat.o(112699);
        } catch (Exception e) {
            ai.printErrStackTrace("WeUI.WeUIProgresssDialog", e, "", new Object[0]);
            AppMethodBeat.o(112699);
        }
    }

    public void dismiss() {
        AppMethodBeat.i(112700);
        try {
            super.dismiss();
            AppMethodBeat.o(112700);
        } catch (Exception e) {
            ai.e("WeUI.WeUIProgresssDialog", "dismiss exception, e = " + e.getMessage(), new Object[0]);
            AppMethodBeat.o(112700);
        }
    }

    public static f g(Context context, CharSequence charSequence) {
        AppMethodBeat.i(112695);
        f fVar = new f(context);
        fVar.setMessage(charSequence);
        fVar.setCancelable(false);
        fVar.setOnCancelListener(null);
        fVar.setCanceledOnTouchOutside(false);
        fVar.show();
        AppMethodBeat.o(112695);
        return fVar;
    }
}
