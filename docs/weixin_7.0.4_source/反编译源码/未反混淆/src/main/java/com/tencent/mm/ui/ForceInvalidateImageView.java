package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ForceInvalidateImageView extends ImageView {
    public ForceInvalidateImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ForceInvalidateImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    @TargetApi(8)
    public void onVisibilityChanged(View view, int i) {
        AppMethodBeat.i(29302);
        if (i == 0) {
            invalidate();
        }
        super.onVisibilityChanged(view, i);
        AppMethodBeat.o(29302);
    }
}
