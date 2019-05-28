package com.tencent.mm.view.popview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.view.d;

public class EmojiPopView extends AbstractPopView {
    private EmojiStatusView AdR;
    private LayoutParams AdS;
    private String AdT;
    private int offsetY;
    private ProgressBar ppY;

    public EmojiPopView(Context context) {
        this(context, null);
    }

    public EmojiPopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmojiPopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(63064);
        inflate(context, R.layout.u0, this);
        this.AdR = (EmojiStatusView) findViewById(R.id.bl);
        this.ppY = (ProgressBar) findViewById(R.id.vm);
        setBackgroundResource(R.drawable.b2t);
        this.AdS = new LayoutParams(2, d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE, 1);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.a1b);
        this.AdS.width = dimensionPixelSize;
        this.AdS.height = dimensionPixelSize;
        this.AdS.gravity = 8388659;
        this.offsetY = context.getResources().getDimensionPixelSize(R.dimen.a1_);
        AppMethodBeat.o(63064);
    }

    public void setEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.i(63065);
        if (emojiInfo == null) {
            this.AdR.setVisibility(4);
            this.ppY.setVisibility(0);
            ab.i("MicroMsg.EmojiPopView", "emoji is null. set null");
            AppMethodBeat.o(63065);
            return;
        }
        if (!emojiInfo.Aq().equals(this.AdT)) {
            this.AdT = emojiInfo.Aq();
            this.AdR.setStatusListener(new b() {
                public final void jm(int i) {
                    AppMethodBeat.i(63063);
                    if (i == 1) {
                        EmojiPopView.this.ppY.setVisibility(8);
                        EmojiPopView.this.AdR.setVisibility(0);
                        AppMethodBeat.o(63063);
                        return;
                    }
                    EmojiPopView.this.AdR.setVisibility(4);
                    EmojiPopView.this.ppY.setVisibility(0);
                    AppMethodBeat.o(63063);
                }
            });
            this.AdR.setEmojiInfo(emojiInfo);
        }
        AppMethodBeat.o(63065);
    }

    public LayoutParams getWindowLayoutParams() {
        return this.AdS;
    }

    public final void fw(View view) {
        AppMethodBeat.i(63066);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        this.AdS.x = iArr[0] - ((this.AdS.width - view.getMeasuredWidth()) / 2);
        this.AdS.y = (iArr[1] - this.AdS.height) + this.offsetY;
        AppMethodBeat.o(63066);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(63067);
        super.onDetachedFromWindow();
        AppMethodBeat.o(63067);
    }
}
