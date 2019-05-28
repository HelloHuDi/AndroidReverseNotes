package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.d;

public class IPCallRoundUrlHeadImage extends CdnImageView {
    public IPCallRoundUrlHeadImage(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IPCallRoundUrlHeadImage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageBitmapCompleted(Bitmap bitmap) {
        AppMethodBeat.i(22282);
        if (bitmap != null) {
            setImageBitmap(d.a(bitmap, false, 0.5f * ((float) bitmap.getWidth())));
        }
        AppMethodBeat.o(22282);
    }
}
