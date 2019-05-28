package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class IconWidgetPreference extends Preference {
    private ImageView pnG;
    private int pnH;
    private Bitmap pnI;

    public IconWidgetPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconWidgetPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23643);
        this.pnG = null;
        this.pnH = -1;
        this.pnI = null;
        setLayoutResource(R.layout.ae4);
        setWidgetLayoutResource(0);
        AppMethodBeat.o(23643);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(23644);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.agd, viewGroup2);
        AppMethodBeat.o(23644);
        return onCreateView;
    }

    public final void O(Bitmap bitmap) {
        AppMethodBeat.i(23645);
        this.pnI = bitmap;
        if (this.pnG != null) {
            this.pnG.setImageBitmap(bitmap);
        }
        AppMethodBeat.o(23645);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23646);
        super.onBindView(view);
        this.pnG = (ImageView) view.findViewById(R.id.dap);
        if (this.pnG != null) {
            this.pnG.setVisibility(8);
            if (this.pnH != -1) {
                this.pnG.setImageResource(this.pnH);
                this.pnG.setVisibility(0);
                AppMethodBeat.o(23646);
                return;
            } else if (this.pnI != null) {
                this.pnG.setImageBitmap(this.pnI);
                this.pnG.setVisibility(0);
            }
        }
        AppMethodBeat.o(23646);
    }
}
