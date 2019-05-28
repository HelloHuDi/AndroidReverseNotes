package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.loader.a;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.storage.emotion.EmojiInfo;

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
        AppMethodBeat.i(62470);
        this.vpE = context.getResources().getDimensionPixelSize(R.dimen.a1h);
        this.vpF = context.getResources().getDimensionPixelSize(R.dimen.a1f);
        setDefaultImageResource(0);
        AppMethodBeat.o(62470);
    }

    public final void a(EmojiInfo emojiInfo, long j) {
        AppMethodBeat.i(62471);
        this.exP = emojiInfo;
        this.cacheKey = String.valueOf(j);
        setImageDrawable(null);
        reload();
        AppMethodBeat.o(62471);
    }

    public final void reload() {
        AppMethodBeat.i(62472);
        a aVar;
        if (this.exP != null) {
            setStatusNotify(0);
            aVar = a.exs;
            a.a(this.exP, this, this.cacheKey);
            AppMethodBeat.o(62472);
            return;
        }
        aVar = a.exs;
        a.cf(this);
        AppMethodBeat.o(62472);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(62473);
        super.setImageDrawable(drawable);
        AppMethodBeat.o(62473);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        float f;
        AppMethodBeat.i(62474);
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
        AppMethodBeat.o(62474);
    }
}
