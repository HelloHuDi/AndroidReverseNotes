package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.sdk.platformtools.C5056d;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallRoundUrlHeadImage */
public class IPCallRoundUrlHeadImage extends CdnImageView {
    public IPCallRoundUrlHeadImage(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IPCallRoundUrlHeadImage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageBitmapCompleted(Bitmap bitmap) {
        AppMethodBeat.m2504i(22282);
        if (bitmap != null) {
            setImageBitmap(C5056d.m7616a(bitmap, false, 0.5f * ((float) bitmap.getWidth())));
        }
        AppMethodBeat.m2505o(22282);
    }
}
