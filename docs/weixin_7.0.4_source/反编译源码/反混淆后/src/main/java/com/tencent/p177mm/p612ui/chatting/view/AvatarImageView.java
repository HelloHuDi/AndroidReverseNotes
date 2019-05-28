package com.tencent.p177mm.p612ui.chatting.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.p069v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.sns.p520ui.p1413e.C29210a;
import com.tencent.p177mm.plugin.story.api.C13736l;
import com.tencent.p177mm.plugin.story.api.C29268i;
import com.tencent.p177mm.plugin.story.api.C29268i.C29267a;
import com.tencent.p177mm.plugin.story.api.C35168e;

/* renamed from: com.tencent.mm.ui.chatting.view.AvatarImageView */
public class AvatarImageView extends AppCompatImageView implements C13736l {
    private final String TAG;
    private int pageType;
    private C29268i rDe;
    private String rMJ;
    private boolean zaL;

    public AvatarImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AvatarImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(32748);
        this.TAG = "MicroMsg.AvatarImageView";
        this.pageType = -1;
        this.rDe = null;
        this.rMJ = "";
        this.zaL = true;
        this.rDe = ((C35168e) C1720g.m3530M(C35168e.class)).getStoryUIFactory().mo69259eW(context);
        this.rDe.mo9014aR(this);
        setLayerType(1, null);
        AppMethodBeat.m2505o(32748);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(32749);
        super.onDraw(canvas);
        if (this.zaL) {
            this.rDe.mo9013a(canvas, true, 0);
            AppMethodBeat.m2505o(32749);
            return;
        }
        this.rDe.mo9013a(canvas, false, 0);
        AppMethodBeat.m2505o(32749);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(32750);
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(32750);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(32751);
        super.setOnClickListener(this.rDe.cwV());
        this.rDe.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(32751);
    }

    public void setOnDoubleClickListener(C29267a c29267a) {
        AppMethodBeat.m2504i(32752);
        this.rDe.setOnDoubleClickListener(c29267a);
        AppMethodBeat.m2505o(32752);
    }

    public void setShowStoryHint(boolean z) {
        AppMethodBeat.m2504i(32753);
        this.rDe.setShowStoryHint(z);
        AppMethodBeat.m2505o(32753);
    }

    /* renamed from: dk */
    public final void mo70201dk(String str, int i) {
        AppMethodBeat.m2504i(32754);
        this.rDe.mo9016dk(str, i);
        this.rMJ = str;
        AppMethodBeat.m2505o(32754);
    }

    public void setChattingBG(boolean z) {
        this.zaL = z;
    }

    /* renamed from: br */
    public final void mo25937br(String str, boolean z) {
        AppMethodBeat.m2504i(32755);
        if (TextUtils.isEmpty(str) || getContext() == null) {
            AppMethodBeat.m2505o(32755);
            return;
        }
        if (str.equals(this.rMJ)) {
            setShowStoryHint(!z);
        }
        AppMethodBeat.m2505o(32755);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(32756);
        super.onDetachedFromWindow();
        if (this.pageType != -1) {
            C29210a.m46386b(this.pageType, this.rMJ, this);
        }
        AppMethodBeat.m2505o(32756);
    }
}
