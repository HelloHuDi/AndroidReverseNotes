package com.tencent.p177mm.pluginsdk.p597ui.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.pluginsdk.ui.preference.HeadImgPreference */
public final class HeadImgPreference extends Preference {
    private int height;
    private ImageView iNr;
    private OnClickListener qqV;
    private Bitmap vqD;

    public HeadImgPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImgPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(28066);
        this.height = -1;
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(28066);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(28067);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130970149, viewGroup2);
        this.iNr = (ImageView) onCreateView.findViewById(2131826036);
        AppMethodBeat.m2505o(28067);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(28068);
        super.onBindView(view);
        if (this.iNr == null) {
            this.iNr = (ImageView) view.findViewById(2131826036);
        }
        if (this.qqV != null) {
            this.iNr.setOnClickListener(this.qqV);
        }
        if (this.vqD != null) {
            this.iNr.setImageBitmap(this.vqD);
            this.vqD = null;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131822347);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        AppMethodBeat.m2505o(28068);
    }
}
