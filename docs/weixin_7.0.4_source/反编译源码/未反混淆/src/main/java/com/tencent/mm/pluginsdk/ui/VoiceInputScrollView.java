package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VoiceInputScrollView extends ScrollView {
    private a vjw;

    public interface a {
    }

    public VoiceInputScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VoiceInputScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnScrollListener(a aVar) {
        this.vjw = aVar;
    }

    /* Access modifiers changed, original: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(27605);
        super.onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.o(27605);
    }
}
