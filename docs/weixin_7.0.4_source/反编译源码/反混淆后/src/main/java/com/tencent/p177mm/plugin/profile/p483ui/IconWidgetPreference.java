package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.plugin.profile.ui.IconWidgetPreference */
public class IconWidgetPreference extends Preference {
    private ImageView pnG;
    private int pnH;
    private Bitmap pnI;

    public IconWidgetPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconWidgetPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(23643);
        this.pnG = null;
        this.pnH = -1;
        this.pnI = null;
        setLayoutResource(2130970127);
        setWidgetLayoutResource(0);
        AppMethodBeat.m2505o(23643);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(23644);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130970211, viewGroup2);
        AppMethodBeat.m2505o(23644);
        return onCreateView;
    }

    /* renamed from: O */
    public final void mo24866O(Bitmap bitmap) {
        AppMethodBeat.m2504i(23645);
        this.pnI = bitmap;
        if (this.pnG != null) {
            this.pnG.setImageBitmap(bitmap);
        }
        AppMethodBeat.m2505o(23645);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23646);
        super.onBindView(view);
        this.pnG = (ImageView) view.findViewById(2131826082);
        if (this.pnG != null) {
            this.pnG.setVisibility(8);
            if (this.pnH != -1) {
                this.pnG.setImageResource(this.pnH);
                this.pnG.setVisibility(0);
                AppMethodBeat.m2505o(23646);
                return;
            } else if (this.pnI != null) {
                this.pnG.setImageBitmap(this.pnI);
                this.pnG.setVisibility(0);
            }
        }
        AppMethodBeat.m2505o(23646);
    }
}
