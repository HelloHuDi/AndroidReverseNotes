package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

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
        AppMethodBeat.i(28066);
        this.height = -1;
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(28066);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(28067);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.aep, viewGroup2);
        this.iNr = (ImageView) onCreateView.findViewById(R.id.d_g);
        AppMethodBeat.o(28067);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(28068);
        super.onBindView(view);
        if (this.iNr == null) {
            this.iNr = (ImageView) view.findViewById(R.id.d_g);
        }
        if (this.qqV != null) {
            this.iNr.setOnClickListener(this.qqV);
        }
        if (this.vqD != null) {
            this.iNr.setImageBitmap(this.vqD);
            this.vqD = null;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.akp);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        AppMethodBeat.o(28068);
    }
}
