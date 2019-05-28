package com.tencent.p177mm.plugin.sns.p520ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.tools.MaskImageButton;
import com.tencent.p177mm.plugin.sns.p520ui.p1413e.C29210a;
import com.tencent.p177mm.plugin.story.api.C13736l;
import com.tencent.p177mm.plugin.story.api.C29268i;
import com.tencent.p177mm.plugin.story.api.C35168e;

/* renamed from: com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView */
public class SnsAvatarImageView extends MaskImageButton implements C13736l {
    private int pageType;
    private C29268i rDe;
    private String rMJ;

    public SnsAvatarImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(40454);
        this.pageType = -1;
        this.rDe = null;
        this.rMJ = "";
        this.rDe = ((C35168e) C1720g.m3530M(C35168e.class)).getStoryUIFactory().mo69259eW(getContext());
        this.rDe.mo9014aR(this);
        setLayerType(1, null);
        AppMethodBeat.m2505o(40454);
    }

    public void setWeakContext(Context context) {
        AppMethodBeat.m2504i(40455);
        if (!(context instanceof Activity)) {
            C45124d.m82933w("MicroMsg.SnsAvatarImageView", "weakContext is not activity");
        }
        this.rDe.setWeakContext(context);
        AppMethodBeat.m2505o(40455);
    }

    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(40456);
        super.onDraw(canvas);
        this.rDe.mo9013a(canvas, true, 0);
        AppMethodBeat.m2505o(40456);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(40457);
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(40457);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(40458);
        super.setOnClickListener(this.rDe.cwV());
        this.rDe.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(40458);
    }

    public void setShowStoryHint(boolean z) {
        AppMethodBeat.m2504i(40459);
        this.rDe.setShowStoryHint(z);
        AppMethodBeat.m2505o(40459);
    }

    public void setUserName(String str) {
        AppMethodBeat.m2504i(40460);
        mo55778dk(str, -1);
        AppMethodBeat.m2505o(40460);
    }

    /* renamed from: dk */
    public final void mo55778dk(String str, int i) {
        AppMethodBeat.m2504i(40461);
        this.rDe.mo9016dk(str, i);
        if (!this.rMJ.equals(str)) {
            this.rMJ = str;
            this.pageType = i;
        }
        AppMethodBeat.m2505o(40461);
    }

    /* renamed from: br */
    public final void mo25937br(String str, boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(40462);
        C45124d.m82924c("MicroMsg.SnsAvatarImageView", "onNotifyStoryStatusChanged username: %s , isRead:%b", str, Boolean.valueOf(z));
        if (TextUtils.isEmpty(str) || getContext() == null) {
            AppMethodBeat.m2505o(40462);
            return;
        }
        if (str.equals(this.rMJ)) {
            if (z) {
                z2 = false;
            }
            setShowStoryHint(z2);
        }
        AppMethodBeat.m2505o(40462);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(40463);
        super.onDetachedFromWindow();
        if (this.pageType != -1) {
            C29210a.m46386b(this.pageType, this.rMJ, this);
        }
        AppMethodBeat.m2505o(40463);
    }
}
