package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p180ad.C37433a.C1190a;

/* renamed from: com.tencent.mm.ui.base.preference.ImagePreference */
public final class ImagePreference extends Preference {
    private ImageView pnv;
    private C30395e yCd;

    public ImagePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImagePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107192);
        this.pnv = null;
        this.yCd = new C30395e();
        setLayoutResource(2130970182);
        setWidgetLayoutResource(2130970202);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1190a.ImagePreference);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            C30395e c30395e = this.yCd;
            c30395e.resId = resourceId;
            c30395e.bitmap = null;
            this.yCd.mo48781l(this.pnv);
        }
        obtainStyledAttributes.recycle();
        AppMethodBeat.m2505o(107192);
    }

    /* Access modifiers changed, original: protected|final */
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107193);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821839);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130970182, viewGroup2);
        AppMethodBeat.m2505o(107193);
        return onCreateView;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBindView(View view) {
        AppMethodBeat.m2504i(107194);
        super.onBindView(view);
        this.pnv = (ImageView) view.findViewById(2131822184);
        this.yCd.mo48781l(this.pnv);
        AppMethodBeat.m2505o(107194);
    }
}
