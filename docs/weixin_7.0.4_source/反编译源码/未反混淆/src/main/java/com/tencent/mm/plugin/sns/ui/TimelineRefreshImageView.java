package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;

public class TimelineRefreshImageView extends ImageView {
    public TimelineRefreshImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TimelineRefreshImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void destroyDrawingCache() {
        AppMethodBeat.i(39894);
        super.destroyDrawingCache();
        ab.d("MicroMsg.TimelineRefreshImageView", "destroyDrawingCache, width: %s, height: %s, hash: %s", Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), Integer.valueOf(hashCode()));
        AppMethodBeat.o(39894);
    }

    public void buildDrawingCache(boolean z) {
        AppMethodBeat.i(39893);
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
            ab.d(str2, str);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TimelineRefreshImageView", e, "", new Object[0]);
            ab.e("MicroMsg.TimelineRefreshImageView", "checkIfCanReuseDrawingCache error: %s", e.getMessage());
        }
        ab.d("MicroMsg.TimelineRefreshImageView", "buildDrawingCache, autoScale: %s, width: %s, height: %s, hash: %s", Boolean.valueOf(z), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), Integer.valueOf(hashCode()));
        super.buildDrawingCache(z);
        AppMethodBeat.o(39893);
    }
}
