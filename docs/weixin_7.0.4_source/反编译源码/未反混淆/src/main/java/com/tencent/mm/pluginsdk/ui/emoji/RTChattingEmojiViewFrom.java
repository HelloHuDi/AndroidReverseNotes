package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RTChattingEmojiViewFrom extends RTChattingEmojiView {
    public RTChattingEmojiViewFrom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(62502);
        initView();
        AppMethodBeat.o(62502);
    }

    public RTChattingEmojiViewFrom(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(62503);
        initView();
        AppMethodBeat.o(62503);
    }

    public final void initView() {
        AppMethodBeat.i(62504);
        super.initView();
        dkQ();
        AppMethodBeat.o(62504);
    }
}
