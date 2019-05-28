package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.sns.ui.TimelineRefreshImageView */
public class TimelineRefreshImageView extends ImageView {
    public TimelineRefreshImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TimelineRefreshImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void destroyDrawingCache() {
        AppMethodBeat.m2504i(39894);
        super.destroyDrawingCache();
        C4990ab.m7411d("MicroMsg.TimelineRefreshImageView", "destroyDrawingCache, width: %s, height: %s, hash: %s", Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), Integer.valueOf(hashCode()));
        AppMethodBeat.m2505o(39894);
    }

    public void buildDrawingCache(boolean z) {
        AppMethodBeat.m2504i(39893);
        try {
            String str;
            Field declaredField = View.class.getDeclaredField(z ? "mDrawingCache" : "mUnscaledDrawingCache");
            declaredField.setAccessible(true);
            String str2 = "MicroMsg.TimelineRefreshImageView";
            if (((Bitmap) declaredField.get(this)) == null) {
                str = "cache is null";
            } else {
                str = String.format("cache.width: %s, cache.height: %s, width: %s, height: %s", new Object[]{Integer.valueOf(((Bitmap) declaredField.get(this)).getWidth()), Integer.valueOf(((Bitmap) declaredField.get(this)).getHeight()), Integer.valueOf(getWidth()), Integer.valueOf(getHeight())});
            }
            C4990ab.m7410d(str2, str);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TimelineRefreshImageView", e, "", new Object[0]);
            C4990ab.m7413e("MicroMsg.TimelineRefreshImageView", "checkIfCanReuseDrawingCache error: %s", e.getMessage());
        }
        C4990ab.m7411d("MicroMsg.TimelineRefreshImageView", "buildDrawingCache, autoScale: %s, width: %s, height: %s, hash: %s", Boolean.valueOf(z), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), Integer.valueOf(hashCode()));
        super.buildDrawingCache(z);
        AppMethodBeat.m2505o(39893);
    }
}
