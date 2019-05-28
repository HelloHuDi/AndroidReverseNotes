package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MMFrameLayout;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.sns.ui.PhotosContent */
public class PhotosContent extends MMFrameLayout {
    private int hrp = 120;
    public ArrayList<TagImageView> rlN = new ArrayList();
    private float rlO;

    public final void csr() {
        AppMethodBeat.m2504i(38470);
        this.rlN.clear();
        AppMethodBeat.m2505o(38470);
    }

    /* renamed from: a */
    public final void mo8756a(TagImageView tagImageView) {
        AppMethodBeat.m2504i(38471);
        this.rlN.add(tagImageView);
        AppMethodBeat.m2505o(38471);
    }

    public void setImageViewWidth(int i) {
        AppMethodBeat.m2504i(38472);
        if (i <= 0) {
            AppMethodBeat.m2505o(38472);
            return;
        }
        this.rlO = getResources().getDisplayMetrics().density;
        this.hrp = (int) (((float) this.hrp) * this.rlO);
        if (i >= this.hrp) {
            i = this.hrp;
        }
        for (int i2 = 0; i2 < this.rlN.size(); i2++) {
            View childAt = getChildAt(i2);
            MarginLayoutParams marginLayoutParams = new MarginLayoutParams(childAt.getLayoutParams());
            marginLayoutParams.width = i;
            marginLayoutParams.height = i;
            marginLayoutParams.leftMargin = (int) (((float) (i2 % 3)) * (((float) i) + (this.rlO * 3.0f)));
            marginLayoutParams.topMargin = (int) (((float) (i2 / 3)) * (((float) i) + (this.rlO * 3.0f)));
            LayoutParams layoutParams = new LayoutParams(marginLayoutParams);
            layoutParams.gravity = 51;
            childAt.setLayoutParams(layoutParams);
        }
        int size = this.rlN.size() / 3;
        if (size > 0) {
            MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) getLayoutParams();
            marginLayoutParams2.height = (int) ((((float) (size - 1)) * (this.rlO * 3.0f)) + ((float) (i * size)));
            setLayoutParams(marginLayoutParams2);
        }
        AppMethodBeat.m2505o(38472);
    }

    /* renamed from: DT */
    public final TagImageView mo8755DT(int i) {
        AppMethodBeat.m2504i(38473);
        if (i < this.rlN.size()) {
            TagImageView tagImageView = (TagImageView) this.rlN.get(i);
            AppMethodBeat.m2505o(38473);
            return tagImageView;
        }
        AppMethodBeat.m2505o(38473);
        return null;
    }

    public PhotosContent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(38474);
        AppMethodBeat.m2505o(38474);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(38475);
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(38475);
    }
}
