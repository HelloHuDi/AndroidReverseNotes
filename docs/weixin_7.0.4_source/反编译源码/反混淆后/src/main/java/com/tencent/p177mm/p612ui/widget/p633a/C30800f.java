package com.tencent.p177mm.p612ui.widget.p633a;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5227ai;

/* renamed from: com.tencent.mm.ui.widget.a.f */
public class C30800f extends ProgressDialog {
    /* renamed from: WL */
    private View f13758WL = View.inflate(this.mContext, 2130970417, null);
    private ProgressBar iUz = ((ProgressBar) this.f13758WL.findViewById(2131826669));
    private Context mContext;
    private TextView ykU = ((TextView) this.f13758WL.findViewById(2131826670));

    public C30800f(Context context) {
        super(context, C25738R.style.f11415zt);
        AppMethodBeat.m2504i(112694);
        this.mContext = context;
        setCanceledOnTouchOutside(true);
        AppMethodBeat.m2505o(112694);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(112696);
        super.onCreate(bundle);
        setContentView(this.f13758WL, new LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        onWindowAttributesChanged(attributes);
        AppMethodBeat.m2505o(112696);
    }

    public void setCancelable(boolean z) {
        AppMethodBeat.m2504i(112697);
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
        AppMethodBeat.m2505o(112697);
    }

    public void setMessage(CharSequence charSequence) {
        AppMethodBeat.m2504i(112698);
        this.ykU.setText(charSequence);
        AppMethodBeat.m2505o(112698);
    }

    public void show() {
        AppMethodBeat.m2504i(112699);
        try {
            super.show();
            AppMethodBeat.m2505o(112699);
        } catch (Exception e) {
            C5227ai.printErrStackTrace("WeUI.WeUIProgresssDialog", e, "", new Object[0]);
            AppMethodBeat.m2505o(112699);
        }
    }

    public void dismiss() {
        AppMethodBeat.m2504i(112700);
        try {
            super.dismiss();
            AppMethodBeat.m2505o(112700);
        } catch (Exception e) {
            C5227ai.m7972e("WeUI.WeUIProgresssDialog", "dismiss exception, e = " + e.getMessage(), new Object[0]);
            AppMethodBeat.m2505o(112700);
        }
    }

    /* renamed from: g */
    public static C30800f m49147g(Context context, CharSequence charSequence) {
        AppMethodBeat.m2504i(112695);
        C30800f c30800f = new C30800f(context);
        c30800f.setMessage(charSequence);
        c30800f.setCancelable(false);
        c30800f.setOnCancelListener(null);
        c30800f.setCanceledOnTouchOutside(false);
        c30800f.show();
        AppMethodBeat.m2505o(112695);
        return c30800f;
    }
}
