package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RTChattingEmojiViewTo extends RTChattingEmojiView {
    public RTChattingEmojiViewTo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(62505);
        initView();
        AppMethodBeat.o(62505);
    }

    public RTChattingEmojiViewTo(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(62506);
        initView();
        AppMethodBeat.o(62506);
    }

    public final void initView() {
        AppMethodBeat.i(62507);
        super.initView();
        dkR();
        AppMethodBeat.o(62507);
    }
}
