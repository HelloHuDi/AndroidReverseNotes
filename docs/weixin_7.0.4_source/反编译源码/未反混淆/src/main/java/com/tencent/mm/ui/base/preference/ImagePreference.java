package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ad.a.a;

public final class ImagePreference extends Preference {
    private ImageView pnv;
    private e yCd;

    public ImagePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImagePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107192);
        this.pnv = null;
        this.yCd = new e();
        setLayoutResource(R.layout.afl);
        setWidgetLayoutResource(R.layout.ag5);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.ImagePreference);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            e eVar = this.yCd;
            eVar.resId = resourceId;
            eVar.bitmap = null;
            this.yCd.l(this.pnv);
        }
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(107192);
    }

    /* Access modifiers changed, original: protected|final */
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(107193);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.a7z);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.afl, viewGroup2);
        AppMethodBeat.o(107193);
        return onCreateView;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBindView(View view) {
        AppMethodBeat.i(107194);
        super.onBindView(view);
        this.pnv = (ImageView) view.findViewById(R.id.aga);
        this.yCd.l(this.pnv);
        AppMethodBeat.o(107194);
    }
}
