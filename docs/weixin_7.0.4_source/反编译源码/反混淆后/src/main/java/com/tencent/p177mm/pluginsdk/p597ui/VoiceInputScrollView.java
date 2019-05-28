package com.tencent.p177mm.pluginsdk.p597ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputScrollView */
public class VoiceInputScrollView extends ScrollView {
    private C23265a vjw;

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputScrollView$a */
    public interface C23265a {
    }

    public VoiceInputScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VoiceInputScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnScrollListener(C23265a c23265a) {
        this.vjw = c23265a;
    }

    /* Access modifiers changed, original: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(27605);
        super.onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.m2505o(27605);
    }
}
