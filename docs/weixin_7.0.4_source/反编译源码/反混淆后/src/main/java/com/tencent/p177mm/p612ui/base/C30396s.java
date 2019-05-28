package com.tencent.p177mm.p612ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.ui.base.s */
public final class C30396s extends Dialog implements DialogInterface {
    private TextView iVf;
    private View jcl;
    private Context mContext;
    private int style = 0;
    private ImageView yxU;

    private C30396s(Context context) {
        int i = 2130970224;
        super(context, C25738R.style.f11420zy);
        AppMethodBeat.m2504i(106866);
        this.mContext = context;
        switch (this.style) {
            case 1:
                i = 2130970225;
                break;
        }
        this.jcl = View.inflate(this.mContext, i, null);
        this.iVf = (TextView) this.jcl.findViewById(2131824055);
        this.yxU = (ImageView) this.jcl.findViewById(2131820915);
        setCanceledOnTouchOutside(true);
        AppMethodBeat.m2505o(106866);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(106867);
        super.onCreate(bundle);
        setContentView(this.jcl, new LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        onWindowAttributesChanged(attributes);
        AppMethodBeat.m2505o(106867);
    }

    /* renamed from: a */
    public static C30396s m48490a(CharSequence charSequence, final Context context) {
        AppMethodBeat.m2504i(106868);
        final C30396s c30396s = new C30396s(context);
        c30396s.iVf.setText(charSequence);
        c30396s.setCanceledOnTouchOutside(true);
        c30396s.show();
        c30396s.setOnDismissListener(null);
        new C7306ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(106865);
                if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                    AppMethodBeat.m2505o(106865);
                    return;
                }
                c30396s.dismiss();
                AppMethodBeat.m2505o(106865);
            }
        }.sendEmptyMessageDelayed(0, 1000);
        AppMethodBeat.m2505o(106868);
        return c30396s;
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(106869);
        try {
            super.dismiss();
            AppMethodBeat.m2505o(106869);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MMTipsDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.m2505o(106869);
        }
    }
}
