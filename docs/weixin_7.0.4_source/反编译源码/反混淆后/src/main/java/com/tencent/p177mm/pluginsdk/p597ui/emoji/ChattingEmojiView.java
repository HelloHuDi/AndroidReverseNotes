package com.tencent.p177mm.pluginsdk.p597ui.emoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.emoji.loader.C37682a;
import com.tencent.p177mm.emoji.view.EmojiStatusView;
import com.tencent.p177mm.storage.emotion.EmojiInfo;

/* renamed from: com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView */
public class ChattingEmojiView extends EmojiStatusView {
    private String cacheKey;
    private EmojiInfo exP;
    protected int vpE;
    protected int vpF;

    public ChattingEmojiView(Context context) {
        this(context, null);
    }

    public ChattingEmojiView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChattingEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(62470);
        this.vpE = context.getResources().getDimensionPixelSize(C25738R.dimen.a1h);
        this.vpF = context.getResources().getDimensionPixelSize(C25738R.dimen.a1f);
        setDefaultImageResource(0);
        AppMethodBeat.m2505o(62470);
    }

    /* renamed from: a */
    public final void mo74722a(EmojiInfo emojiInfo, long j) {
        AppMethodBeat.m2504i(62471);
        this.exP = emojiInfo;
        this.cacheKey = String.valueOf(j);
        setImageDrawable(null);
        reload();
        AppMethodBeat.m2505o(62471);
    }

    public final void reload() {
        AppMethodBeat.m2504i(62472);
        C37682a c37682a;
        if (this.exP != null) {
            setStatusNotify(0);
            c37682a = C37682a.exs;
            C37682a.m63720a(this.exP, this, this.cacheKey);
            AppMethodBeat.m2505o(62472);
            return;
        }
        c37682a = C37682a.exs;
        C37682a.m63728cf(this);
        AppMethodBeat.m2505o(62472);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(62473);
        super.setImageDrawable(drawable);
        AppMethodBeat.m2505o(62473);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        float f;
        AppMethodBeat.m2504i(62474);
        super.onMeasure(i, i2);
        if (getStatus() == 1 || this.exP == null) {
            intrinsicWidth = getIntrinsicWidth();
            intrinsicHeight = getIntrinsicHeight();
        } else {
            intrinsicWidth = (int) (((float) this.exP.field_width) * getEmojiDensityScale());
            intrinsicHeight = (int) (((float) this.exP.field_height) * getEmojiDensityScale());
            if (intrinsicWidth <= 0) {
                intrinsicWidth = this.vpE;
            }
            if (intrinsicHeight <= 0) {
                intrinsicHeight = this.vpE;
            }
            intrinsicWidth = Math.max(0, intrinsicWidth);
            intrinsicHeight = Math.max(0, intrinsicHeight);
        }
        if (intrinsicWidth <= 0) {
            intrinsicWidth = this.vpE;
        }
        if (intrinsicHeight <= 0) {
            intrinsicHeight = this.vpE;
        }
        if (intrinsicHeight < this.vpF || intrinsicWidth < this.vpF) {
            if (intrinsicWidth < intrinsicHeight) {
                f = ((float) this.vpF) / ((float) intrinsicWidth);
                intrinsicWidth = this.vpF;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            } else if (intrinsicHeight < intrinsicWidth) {
                f = ((float) this.vpF) / ((float) intrinsicHeight);
                intrinsicHeight = this.vpF;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            } else {
                intrinsicHeight = this.vpF;
                intrinsicWidth = this.vpF;
            }
        }
        if (intrinsicWidth > this.vpE || intrinsicHeight > this.vpE) {
            if (intrinsicWidth > intrinsicHeight) {
                f = ((float) this.vpE) / ((float) intrinsicWidth);
                intrinsicWidth = this.vpE;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            } else if (intrinsicHeight > intrinsicWidth) {
                f = ((float) this.vpE) / ((float) intrinsicHeight);
                intrinsicHeight = this.vpE;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            } else {
                intrinsicWidth = this.vpE;
                intrinsicHeight = this.vpE;
            }
        }
        setMeasuredDimension(intrinsicWidth, intrinsicHeight);
        AppMethodBeat.m2505o(62474);
    }
}
