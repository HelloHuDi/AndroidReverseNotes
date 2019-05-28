package com.tencent.p177mm.plugin.order.p480ui.p1009a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.plugin.order.ui.a.c */
public final class C39482c extends Preference {
    Bitmap fru = null;
    OnClickListener mOnClickListener;
    private View mView = null;
    private TextView oZK;
    private ImageView pex;
    String pey = "";

    public C39482c(Context context) {
        super(context);
        AppMethodBeat.m2504i(43898);
        setLayoutResource(2130970043);
        AppMethodBeat.m2505o(43898);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(43899);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.m2505o(43899);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(43900);
        super.onBindView(view);
        this.oZK = (TextView) view.findViewById(2131825802);
        this.pex = (ImageView) view.findViewById(2131825801);
        this.oZK.setText(this.pey);
        this.pex.setImageBitmap(this.fru);
        this.pex.setOnClickListener(this.mOnClickListener);
        if (this.pey != null && this.pey.length() > 48) {
            this.oZK.setTextSize(0, (float) C1338a.m2856al(this.mContext, C25738R.dimen.f9936kr));
        }
        AppMethodBeat.m2505o(43900);
    }
}
