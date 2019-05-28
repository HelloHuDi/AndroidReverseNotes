package com.tencent.p177mm.pluginsdk.p597ui.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.storage.emotion.EmojiInfo;

/* renamed from: com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView */
public class PopEmojiView extends LinearLayout {
    private ViewGroup ius;
    private MMEmojiView vpJ;
    private ProgressBar vpK;

    public PopEmojiView(Context context) {
        super(context);
        AppMethodBeat.m2504i(62481);
        init(context);
        AppMethodBeat.m2505o(62481);
    }

    public PopEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(62482);
        init(context);
        AppMethodBeat.m2505o(62482);
    }

    public PopEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(62483);
        init(context);
        AppMethodBeat.m2505o(62483);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(62484);
        this.ius = (ViewGroup) PopEmojiView.inflate(getContext(), 2130970375, null);
        this.vpJ = (MMEmojiView) this.ius.findViewById(2131820629);
        this.vpJ.setIsMaxSizeLimit(true);
        this.vpJ.setMaxSize(context.getResources().getDimensionPixelSize(C25738R.dimen.a1h) - (context.getResources().getDimensionPixelSize(C25738R.dimen.f9966lo) * 3));
        this.vpK = (ProgressBar) this.ius.findViewById(2131821370);
        addView(this.ius, -1, -1);
        AppMethodBeat.m2505o(62484);
    }

    public void setImageResource(int i) {
        AppMethodBeat.m2504i(62485);
        if (this.vpJ != null) {
            this.vpJ.setImageResource(i);
        }
        AppMethodBeat.m2505o(62485);
    }

    public void setEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(62486);
        if (this.vpJ != null) {
            this.vpJ.mo56663a(emojiInfo, "");
        }
        AppMethodBeat.m2505o(62486);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.m2504i(62487);
        if (!(this.vpJ == null || bitmap == null || bitmap.isRecycled())) {
            bitmap.setDensity(this.vpJ.getEmojiDensity());
            this.vpJ.setImageBitmap(bitmap);
        }
        AppMethodBeat.m2505o(62487);
    }
}
