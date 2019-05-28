package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.scanner.util.C43498q;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.scanner.ui.f */
public final class C46919f extends Preference implements C18765a {
    C15541f ehK;
    String kXM;
    private Context mContext;
    private View mView = null;
    private ImageView qaL = null;

    public C46919f(Context context) {
        super(context);
        AppMethodBeat.m2504i(81031);
        setLayoutResource(2130970391);
        C18764x.m29326a((C18765a) this);
        this.mContext = context;
        AppMethodBeat.m2505o(81031);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(81032);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.m2505o(81032);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(81033);
        super.onBindView(view);
        this.qaL = (ImageView) view.findViewById(2131822355);
        if (!C5046bo.isNullOrNil(this.kXM)) {
            Bitmap a = C18764x.m29325a(new C43498q(this.kXM));
            if (a == null || a.isRecycled()) {
                this.qaL.setBackgroundColor(this.mContext.getResources().getColor(C25738R.color.f12083rq));
                this.qaL.setImageBitmap(null);
            } else {
                this.qaL.setImageBitmap(a);
                this.qaL.setBackgroundColor(0);
            }
            ((ImageView) view.findViewById(2131826601)).setVisibility(0);
        }
        AppMethodBeat.m2505o(81033);
    }

    /* renamed from: m */
    public final void mo8136m(String str, final Bitmap bitmap) {
        AppMethodBeat.m2504i(81034);
        if (!(C5046bo.isNullOrNil(str) || !str.equals(this.kXM) || bitmap == null || bitmap.isRecycled())) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(81030);
                    C46919f.this.qaL.setImageBitmap(bitmap);
                    C46919f.this.qaL.setBackgroundColor(0);
                    if (C46919f.this.ehK != null) {
                        C46919f.this.ehK.notifyDataSetChanged();
                    }
                    AppMethodBeat.m2505o(81030);
                }
            });
        }
        AppMethodBeat.m2505o(81034);
    }
}
