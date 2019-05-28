package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.scanner.util.C43498q;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.scanner.ui.a */
public final class C13150a extends Preference implements C18765a {
    private C15541f iFE;
    private ImageView iUn;
    String kWC;
    private View mView = null;
    private TextView qaI = null;
    String qaJ = null;

    public C13150a(Context context) {
        super(context);
        AppMethodBeat.m2504i(80899);
        setLayoutResource(2130970549);
        C18764x.m29326a((C18765a) this);
        AppMethodBeat.m2505o(80899);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(80900);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.m2505o(80900);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(80901);
        super.onBindView(view);
        this.qaI = (TextView) view.findViewById(2131822459);
        this.iUn = (ImageView) view.findViewById(2131827214);
        if (C5046bo.isNullOrNil(this.qaJ)) {
            this.qaI.setVisibility(8);
        } else {
            this.qaI.setText(this.qaJ);
            this.qaI.setVisibility(0);
        }
        if (!C5046bo.isNullOrNil(this.kWC)) {
            Bitmap a = C18764x.m29325a(new C43498q(this.kWC));
            if (!(a == null || a.isRecycled())) {
                this.iUn.setImageBitmap(a);
                this.iUn.setVisibility(0);
            }
        }
        AppMethodBeat.m2505o(80901);
    }

    /* renamed from: m */
    public final void mo8136m(String str, final Bitmap bitmap) {
        AppMethodBeat.m2504i(80902);
        if (!(C5046bo.isNullOrNil(str) || !str.equals(this.kWC) || bitmap == null || bitmap.isRecycled() || this.iUn == null)) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(80898);
                    C13150a.this.iUn.setImageBitmap(bitmap);
                    C13150a.this.iUn.setVisibility(0);
                    if (C13150a.this.iFE != null) {
                        C13150a.this.iFE.notifyDataSetChanged();
                    }
                    AppMethodBeat.m2505o(80898);
                }
            });
        }
        AppMethodBeat.m2505o(80902);
    }
}
