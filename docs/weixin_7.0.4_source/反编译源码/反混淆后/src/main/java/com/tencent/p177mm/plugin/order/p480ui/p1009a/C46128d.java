package com.tencent.p177mm.plugin.order.p480ui.p1009a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.order.p1007a.C34657b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.order.ui.a.d */
public final class C46128d extends Preference {
    String kWC;
    String mName;
    OnClickListener mOnClickListener;
    private View mView = null;

    public C46128d(Context context) {
        super(context);
        AppMethodBeat.m2504i(43901);
        setLayoutResource(2130970044);
        AppMethodBeat.m2505o(43901);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(43902);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.m2505o(43902);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(43903);
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(2131825804);
        TextView textView = (TextView) view.findViewById(2131825805);
        imageView.setImageBitmap(null);
        if (!C5046bo.isNullOrNil(this.kWC)) {
            C17927a c17927a = new C17927a();
            C34657b.bYR();
            c17927a.ePK = C34657b.bKP();
            c17927a.ePH = true;
            c17927a.ePZ = true;
            c17927a.eQf = true;
            C32291o.ahp().mo43766a(this.kWC, imageView, c17927a.ahG());
        }
        textView.setText(this.mName);
        view.findViewById(2131825803).setOnClickListener(this.mOnClickListener);
        AppMethodBeat.m2505o(43903);
    }
}
