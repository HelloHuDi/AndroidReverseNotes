package com.tencent.mm.plugin.sns.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ui.e.a;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.ui.tools.MaskImageButton;

public class SnsAvatarImageView extends MaskImageButton implements l {
    private int pageType;
    private i rDe;
    private String rMJ;

    public SnsAvatarImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(40454);
        this.pageType = -1;
        this.rDe = null;
        this.rMJ = "";
        this.rDe = ((e) g.M(e.class)).getStoryUIFactory().eW(getContext());
        this.rDe.aR(this);
        setLayerType(1, null);
        AppMethodBeat.o(40454);
    }

    public void setWeakContext(Context context) {
        AppMethodBeat.i(40455);
        if (!(context instanceof Activity)) {
            d.w("MicroMsg.SnsAvatarImageView", "weakContext is not activity");
        }
        this.rDe.setWeakContext(context);
        AppMethodBeat.o(40455);
    }

    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(40456);
        super.onDraw(canvas);
        this.rDe.a(canvas, true, 0);
        AppMethodBeat.o(40456);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(40457);
        super.onMeasure(i, i2);
        AppMethodBeat.o(40457);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(40458);
        super.setOnClickListener(this.rDe.cwV());
        this.rDe.setOnClickListener(onClickListener);
        AppMethodBeat.o(40458);
    }

    public void setShowStoryHint(boolean z) {
        AppMethodBeat.i(40459);
        this.rDe.setShowStoryHint(z);
        AppMethodBeat.o(40459);
    }

    public void setUserName(String str) {
        AppMethodBeat.i(40460);
        dk(str, -1);
        AppMethodBeat.o(40460);
    }

    public final void dk(String str, int i) {
        AppMethodBeat.i(40461);
        this.rDe.dk(str, i);
        if (!this.rMJ.equals(str)) {
            this.rMJ = str;
            this.pageType = i;
        }
        AppMethodBeat.o(40461);
    }

    public final void br(String str, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(40462);
        d.c("MicroMsg.SnsAvatarImageView", "onNotifyStoryStatusChanged username: %s , isRead:%b", str, Boolean.valueOf(z));
        if (TextUtils.isEmpty(str) || getContext() == null) {
            AppMethodBeat.o(40462);
            return;
        }
        if (str.equals(this.rMJ)) {
            if (z) {
                z2 = false;
            }
            setShowStoryHint(z2);
        }
        AppMethodBeat.o(40462);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(40463);
        super.onDetachedFromWindow();
        if (this.pageType != -1) {
            a.b(this.pageType, this.rMJ, this);
        }
        AppMethodBeat.o(40463);
    }
}
