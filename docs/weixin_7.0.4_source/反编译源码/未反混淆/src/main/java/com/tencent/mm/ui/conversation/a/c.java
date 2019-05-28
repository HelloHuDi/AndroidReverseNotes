package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.pluginsdk.h.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.InputStream;
import java.util.Map;
import junit.framework.Assert;

public final class c {
    a zvS;

    c(a aVar) {
        this.zvS = aVar;
    }

    public final int a(d dVar) {
        boolean z = true;
        AppMethodBeat.i(34643);
        Assert.assertTrue(dVar != null);
        if (dVar.zvU == null) {
            z = false;
        }
        Assert.assertTrue(z);
        Drawable a = a(this.zvS.vfN, dVar.zvT.getContext());
        if (a == null) {
            AppMethodBeat.o(34643);
            return -1;
        }
        dVar.zvT.setBackgroundDrawable(a);
        dVar.zvU.setVisibility(this.zvS.vfI ? 0 : 8);
        AppMethodBeat.o(34643);
        return 0;
    }

    private static Drawable a(Map<String, String> map, Context context) {
        AppMethodBeat.i(34644);
        if (map == null || map.size() <= 0) {
            AppMethodBeat.o(34644);
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        String str = (String) map.get(displayMetrics.heightPixels + VideoMaterialUtil.CRAZYFACE_X + displayMetrics.widthPixels);
        if (str == null) {
            f fVar = new f();
            displayMetrics = context.getResources().getDisplayMetrics();
            Configuration configuration = context.getResources().getConfiguration();
            String str2 = "";
            if (displayMetrics.density < 1.0f) {
                str = str2 + "LDPI";
            } else if (displayMetrics.density >= 1.5f) {
                str = str2 + "HDPI";
            } else {
                str = str2 + "MDPI";
            }
            StringBuilder append = new StringBuilder().append(str);
            if (configuration.orientation == 2) {
                str = "_L";
            } else {
                str = "_P";
            }
            str = (String) map.get(append.append(str).toString());
        }
        if (ah.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(34644);
            return null;
        }
        a.a ajl = a.ajl(str);
        if (ajl == a.a.ERROR) {
            AppMethodBeat.o(34644);
            return null;
        }
        str = a.ajk(str);
        if (ah.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(34644);
            return null;
        }
        try {
            Bitmap a;
            float density;
            if (ajl == a.a.ASSET) {
                InputStream open = context.getAssets().open(str);
                density = com.tencent.mm.bz.a.getDensity(context);
                f fVar2 = new f();
                a = d.a(open, density);
            } else {
                float density2 = com.tencent.mm.bz.a.getDensity(context);
                f fVar3 = new f();
                density = 160.0f * density2;
                a = d.j(str, density2);
                if (a != null) {
                    a.setDensity((int) density);
                }
            }
            if (a == null) {
                ab.e("MicroMsg.ADListView.Message", "get Bitmap failed type:" + ajl + " path:" + str);
                AppMethodBeat.o(34644);
                return null;
            }
            byte[] ninePatchChunk = a.getNinePatchChunk();
            Drawable bitmapDrawable;
            if (ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
                DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a, displayMetrics2.widthPixels, (displayMetrics2.widthPixels * a.getHeight()) / a.getWidth(), true);
                if (createScaledBitmap != null) {
                    if (a != createScaledBitmap) {
                        ab.i("MicroMsg.ADListView.Message", "recycle bitmap:%s", a);
                        a.recycle();
                    }
                    a = createScaledBitmap;
                }
                bitmapDrawable = new BitmapDrawable(a);
                bitmapDrawable.setTargetDensity(displayMetrics2);
                AppMethodBeat.o(34644);
                return bitmapDrawable;
            }
            bitmapDrawable = new NinePatchDrawable(a, ninePatchChunk, new Rect(), null);
            AppMethodBeat.o(34644);
            return bitmapDrawable;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ADListView.Message", e, "", new Object[0]);
            AppMethodBeat.o(34644);
            return null;
        }
    }
}
