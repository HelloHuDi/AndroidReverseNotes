package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class PopEmojiView extends LinearLayout {
    private ViewGroup ius;
    private MMEmojiView vpJ;
    private ProgressBar vpK;

    public PopEmojiView(Context context) {
        super(context);
        AppMethodBeat.i(62481);
        init(context);
        AppMethodBeat.o(62481);
    }

    public PopEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(62482);
        init(context);
        AppMethodBeat.o(62482);
    }

    public PopEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(62483);
        init(context);
        AppMethodBeat.o(62483);
    }

    private void init(Context context) {
        AppMethodBeat.i(62484);
        this.ius = (ViewGroup) inflate(getContext(), R.layout.aks, null);
        this.vpJ = (MMEmojiView) this.ius.findViewById(R.id.bl);
        this.vpJ.setIsMaxSizeLimit(true);
        this.vpJ.setMaxSize(context.getResources().getDimensionPixelSize(R.dimen.a1h) - (context.getResources().getDimensionPixelSize(R.dimen.lo) * 3));
        this.vpK = (ProgressBar) this.ius.findViewById(R.id.vm);
        addView(this.ius, -1, -1);
        AppMethodBeat.o(62484);
    }

    public void setImageResource(int i) {
        AppMethodBeat.i(62485);
        if (this.vpJ != null) {
            this.vpJ.setImageResource(i);
        }
        AppMethodBeat.o(62485);
    }

    public void setEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.i(62486);
        if (this.vpJ != null) {
            this.vpJ.a(emojiInfo, "");
        }
        AppMethodBeat.o(62486);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(62487);
        if (!(this.vpJ == null || bitmap == null || bitmap.isRecycled())) {
            bitmap.setDensity(this.vpJ.getEmojiDensity());
            this.vpJ.setImageBitmap(bitmap);
        }
        AppMethodBeat.o(62487);
    }
}
