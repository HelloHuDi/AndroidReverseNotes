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
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.scanner.ui.b */
public final class C28913b extends Preference implements C18765a {
    C15541f ehK;
    String kXM;
    private Context mContext;
    private View mView = null;
    private ImageView qaL = null;

    public C28913b(Context context) {
        super(context);
        AppMethodBeat.m2504i(80903);
        setLayoutResource(2130970377);
        C18764x.m29326a((C18765a) this);
        this.mContext = context;
        AppMethodBeat.m2505o(80903);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(80904);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.m2505o(80904);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(80905);
        super.onBindView(view);
        this.qaL = (ImageView) view.findViewById(2131826570);
        if (!C5046bo.isNullOrNil(this.kXM)) {
            Bitmap a = C18764x.m29325a(new C43498q(this.kXM));
            if (a == null || a.isRecycled()) {
                this.qaL.setBackgroundColor(this.mContext.getResources().getColor(C25738R.color.f12083rq));
                this.qaL.setImageBitmap(null);
            } else {
                this.qaL.setImageBitmap(a);
                this.qaL.setBackgroundColor(0);
                AppMethodBeat.m2505o(80905);
                return;
            }
        }
        AppMethodBeat.m2505o(80905);
    }

    /* renamed from: m */
    public final void mo8136m(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(80906);
        if (!(C5046bo.isNullOrNil(str) || !str.equals(this.kXM) || bitmap == null || bitmap.isRecycled())) {
            this.qaL.setImageBitmap(bitmap);
            this.qaL.setBackgroundColor(0);
            if (this.ehK != null) {
                this.ehK.notifyDataSetChanged();
            }
        }
        AppMethodBeat.m2505o(80906);
    }
}
