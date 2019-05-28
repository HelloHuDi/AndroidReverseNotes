package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.i.a;
import com.tencent.mm.plugin.story.api.l;

public class AvatarImageView extends AppCompatImageView implements l {
    private final String TAG;
    private int pageType;
    private i rDe;
    private String rMJ;
    private boolean zaL;

    public AvatarImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AvatarImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(32748);
        this.TAG = "MicroMsg.AvatarImageView";
        this.pageType = -1;
        this.rDe = null;
        this.rMJ = "";
        this.zaL = true;
        this.rDe = ((e) g.M(e.class)).getStoryUIFactory().eW(context);
        this.rDe.aR(this);
        setLayerType(1, null);
        AppMethodBeat.o(32748);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(32749);
        super.onDraw(canvas);
        if (this.zaL) {
            this.rDe.a(canvas, true, 0);
            AppMethodBeat.o(32749);
            return;
        }
        this.rDe.a(canvas, false, 0);
        AppMethodBeat.o(32749);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(32750);
        super.onMeasure(i, i2);
        AppMethodBeat.o(32750);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(32751);
        super.setOnClickListener(this.rDe.cwV());
        this.rDe.setOnClickListener(onClickListener);
        AppMethodBeat.o(32751);
    }

    public void setOnDoubleClickListener(a aVar) {
        AppMethodBeat.i(32752);
        this.rDe.setOnDoubleClickListener(aVar);
        AppMethodBeat.o(32752);
    }

    public void setShowStoryHint(boolean z) {
        AppMethodBeat.i(32753);
        this.rDe.setShowStoryHint(z);
        AppMethodBeat.o(32753);
    }

    public final void dk(String str, int i) {
        AppMethodBeat.i(32754);
        this.rDe.dk(str, i);
        this.rMJ = str;
        AppMethodBeat.o(32754);
    }

    public void setChattingBG(boolean z) {
        this.zaL = z;
    }

    public final void br(String str, boolean z) {
        AppMethodBeat.i(32755);
        if (TextUtils.isEmpty(str) || getContext() == null) {
            AppMethodBeat.o(32755);
            return;
        }
        if (str.equals(this.rMJ)) {
            setShowStoryHint(!z);
        }
        AppMethodBeat.o(32755);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(32756);
        super.onDetachedFromWindow();
        if (this.pageType != -1) {
            com.tencent.mm.plugin.sns.ui.e.a.b(this.pageType, this.rMJ, this);
        }
        AppMethodBeat.o(32756);
    }
}
