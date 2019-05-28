package com.tencent.mm.ui.base;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class s extends Dialog implements DialogInterface {
    private TextView iVf;
    private View jcl;
    private Context mContext;
    private int style = 0;
    private ImageView yxU;

    private s(Context context) {
        int i = R.layout.agq;
        super(context, R.style.zy);
        AppMethodBeat.i(106866);
        this.mContext = context;
        switch (this.style) {
            case 1:
                i = R.layout.agr;
                break;
        }
        this.jcl = View.inflate(this.mContext, i, null);
        this.iVf = (TextView) this.jcl.findViewById(R.id.btw);
        this.yxU = (ImageView) this.jcl.findViewById(R.id.jb);
        setCanceledOnTouchOutside(true);
        AppMethodBeat.o(106866);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(106867);
        super.onCreate(bundle);
        setContentView(this.jcl, new LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        onWindowAttributesChanged(attributes);
        AppMethodBeat.o(106867);
    }

    public static s a(CharSequence charSequence, final Context context) {
        AppMethodBeat.i(106868);
        final s sVar = new s(context);
        sVar.iVf.setText(charSequence);
        sVar.setCanceledOnTouchOutside(true);
        sVar.show();
        sVar.setOnDismissListener(null);
        new ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(106865);
                if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                    AppMethodBeat.o(106865);
                    return;
                }
                sVar.dismiss();
                AppMethodBeat.o(106865);
            }
        }.sendEmptyMessageDelayed(0, 1000);
        AppMethodBeat.o(106868);
        return sVar;
    }

    public final void dismiss() {
        AppMethodBeat.i(106869);
        try {
            super.dismiss();
            AppMethodBeat.o(106869);
        } catch (Exception e) {
            ab.e("MicroMsg.MMTipsDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.o(106869);
        }
    }
}
