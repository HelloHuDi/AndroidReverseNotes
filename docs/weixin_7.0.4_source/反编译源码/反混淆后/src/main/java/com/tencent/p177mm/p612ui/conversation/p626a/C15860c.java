package com.tencent.p177mm.p612ui.conversation.p626a;

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
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.platformtools.C9789f;
import com.tencent.p177mm.pluginsdk.p1080h.p1081a.C14859a;
import com.tencent.p177mm.pluginsdk.p1080h.p1081a.C14859a.C14860a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.InputStream;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.conversation.a.c */
public final class C15860c {
    C14859a zvS;

    C15860c(C14859a c14859a) {
        this.zvS = c14859a;
    }

    /* renamed from: a */
    public final int mo28098a(C5476d c5476d) {
        boolean z = true;
        AppMethodBeat.m2504i(34643);
        Assert.assertTrue(c5476d != null);
        if (c5476d.zvU == null) {
            z = false;
        }
        Assert.assertTrue(z);
        Drawable a = C15860c.m24200a(this.zvS.vfN, c5476d.zvT.getContext());
        if (a == null) {
            AppMethodBeat.m2505o(34643);
            return -1;
        }
        c5476d.zvT.setBackgroundDrawable(a);
        c5476d.zvU.setVisibility(this.zvS.vfI ? 0 : 8);
        AppMethodBeat.m2505o(34643);
        return 0;
    }

    /* renamed from: a */
    private static Drawable m24200a(Map<String, String> map, Context context) {
        AppMethodBeat.m2504i(34644);
        if (map == null || map.size() <= 0) {
            AppMethodBeat.m2505o(34644);
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        String str = (String) map.get(displayMetrics.heightPixels + VideoMaterialUtil.CRAZYFACE_X + displayMetrics.widthPixels);
        if (str == null) {
            C9789f c9789f = new C9789f();
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
        if (C42252ah.nullAsNil(str).length() <= 0) {
            AppMethodBeat.m2505o(34644);
            return null;
        }
        C14860a ajl = C14859a.ajl(str);
        if (ajl == C14860a.ERROR) {
            AppMethodBeat.m2505o(34644);
            return null;
        }
        str = C14859a.ajk(str);
        if (C42252ah.nullAsNil(str).length() <= 0) {
            AppMethodBeat.m2505o(34644);
            return null;
        }
        try {
            Bitmap a;
            float density;
            if (ajl == C14860a.ASSET) {
                InputStream open = context.getAssets().open(str);
                density = C1338a.getDensity(context);
                C9789f c9789f2 = new C9789f();
                a = C5056d.m7619a(open, density);
            } else {
                float density2 = C1338a.getDensity(context);
                C9789f c9789f3 = new C9789f();
                density = 160.0f * density2;
                a = C5056d.m7664j(str, density2);
                if (a != null) {
                    a.setDensity((int) density);
                }
            }
            if (a == null) {
                C4990ab.m7412e("MicroMsg.ADListView.Message", "get Bitmap failed type:" + ajl + " path:" + str);
                AppMethodBeat.m2505o(34644);
                return null;
            }
            byte[] ninePatchChunk = a.getNinePatchChunk();
            Drawable bitmapDrawable;
            if (ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
                DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a, displayMetrics2.widthPixels, (displayMetrics2.widthPixels * a.getHeight()) / a.getWidth(), true);
                if (createScaledBitmap != null) {
                    if (a != createScaledBitmap) {
                        C4990ab.m7417i("MicroMsg.ADListView.Message", "recycle bitmap:%s", a);
                        a.recycle();
                    }
                    a = createScaledBitmap;
                }
                bitmapDrawable = new BitmapDrawable(a);
                bitmapDrawable.setTargetDensity(displayMetrics2);
                AppMethodBeat.m2505o(34644);
                return bitmapDrawable;
            }
            bitmapDrawable = new NinePatchDrawable(a, ninePatchChunk, new Rect(), null);
            AppMethodBeat.m2505o(34644);
            return bitmapDrawable;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ADListView.Message", e, "", new Object[0]);
            AppMethodBeat.m2505o(34644);
            return null;
        }
    }
}
