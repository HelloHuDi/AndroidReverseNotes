package com.tencent.p177mm.p190at.p191a.p829g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.p191a.C25817c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.mm.at.a.g.a */
public final class C25819a {
    /* renamed from: a */
    public static Bitmap m41096a(C25817c c25817c, String str, int i, int i2) {
        AppMethodBeat.m2504i(116114);
        Bitmap d;
        if (i > 0 && i2 > 0) {
            d = C5056d.m7659d(str, i2, i, false);
            AppMethodBeat.m2505o(116114);
            return d;
        } else if (c25817c == null || c25817c.width <= 0 || c25817c.width <= 0) {
            d = C5056d.aml(str);
            AppMethodBeat.m2505o(116114);
            return d;
        } else {
            d = C5056d.m7642ap(str, c25817c.width, c25817c.height);
            AppMethodBeat.m2505o(116114);
            return d;
        }
    }

    /* renamed from: b */
    public static Bitmap m41098b(C25817c c25817c, String str, int i, int i2) {
        AppMethodBeat.m2504i(116115);
        Options amj = C5056d.amj(str);
        Bitmap d;
        if (amj == null || (amj.outWidth < amj.outHeight * 2 && amj.outWidth * 2 > amj.outHeight)) {
            d = C5056d.m7659d(str, i2, i, false);
            AppMethodBeat.m2505o(116115);
            return d;
        } else if (i > 0 && i2 > 0) {
            d = C5056d.m7659d(str, i2, i, true);
            AppMethodBeat.m2505o(116115);
            return d;
        } else if (c25817c == null || c25817c.width <= 0 || c25817c.width <= 0) {
            int i3;
            int i4;
            if (c25817c == null || c25817c.getImageView() == null) {
                C4990ab.m7420w("MicroMsg.imageloader.ImageLoaderUtils", "crop bitmap cant not un set width or height");
                i3 = 0;
                i4 = 0;
            } else {
                int measuredWidth = c25817c.getImageView().getMeasuredWidth();
                i3 = c25817c.getImageView().getMeasuredHeight();
                i4 = measuredWidth;
            }
            d = C5056d.m7659d(str, i3, i4, true);
            AppMethodBeat.m2505o(116115);
            return d;
        } else {
            d = C5056d.m7659d(str, c25817c.height, c25817c.width, true);
            AppMethodBeat.m2505o(116115);
            return d;
        }
    }

    /* renamed from: a */
    public static Bitmap m41095a(C25817c c25817c, InputStream inputStream, int i, int i2, boolean z, float f, boolean z2) {
        Bitmap a;
        AppMethodBeat.m2504i(116116);
        if (i > 0 && i2 > 0) {
            a = C5056d.m7620a(inputStream, 0.0f, i, i2);
        } else if (c25817c == null || c25817c.width <= 0 || c25817c.width <= 0) {
            a = C5056d.decodeStream(inputStream);
        } else {
            a = C5056d.m7620a(inputStream, 0.0f, c25817c.width, c25817c.height);
        }
        if (z) {
            a = C5056d.m7615a(a, i, i2, false, true);
        }
        if (f > 0.0f) {
            a = C5056d.m7654c(a, f);
        }
        if (z2) {
            a = C5056d.m7638ak(a);
        }
        AppMethodBeat.m2505o(116116);
        return a;
    }

    /* renamed from: a */
    public static Bitmap m41097a(C25817c c25817c, byte[] bArr, int i, int i2, boolean z, float f, boolean z2) {
        Bitmap decodeByteArray;
        AppMethodBeat.m2504i(116117);
        if (i > 0 && i2 > 0) {
            decodeByteArray = C5056d.decodeByteArray(bArr, i, i2);
        } else if (c25817c == null || c25817c.width <= 0 || c25817c.width <= 0) {
            decodeByteArray = C5056d.m7652bQ(bArr);
        } else {
            decodeByteArray = C5056d.decodeByteArray(bArr, c25817c.width, c25817c.height);
        }
        if (z) {
            decodeByteArray = C5056d.m7615a(C5056d.decodeByteArray(bArr, i, i2), i, i2, false, true);
        }
        if (f > 0.0f) {
            decodeByteArray = C5056d.m7654c(decodeByteArray, f);
        }
        if (z2) {
            decodeByteArray = C5056d.m7638ak(decodeByteArray);
        }
        AppMethodBeat.m2505o(116117);
        return decodeByteArray;
    }

    /* renamed from: c */
    public static Bitmap m41099c(C25817c c25817c, String str, int i, int i2) {
        AppMethodBeat.m2504i(116118);
        Bitmap aq;
        if (i <= 0 || i2 <= 0) {
            if (c25817c != null) {
                try {
                    if (c25817c.width > 0 && c25817c.width > 0) {
                        aq = C5056d.m7643aq(str, c25817c.width, c25817c.height);
                        AppMethodBeat.m2505o(116118);
                        return aq;
                    }
                } catch (IOException e) {
                    C4990ab.m7413e("MicroMsg.imageloader.ImageLoaderUtils", "get bitmap from assert failed. :%s", e.toString());
                    AppMethodBeat.m2505o(116118);
                    return null;
                }
            }
            aq = C5056d.m7643aq(str, 0, 0);
            AppMethodBeat.m2505o(116118);
            return aq;
        }
        aq = C5056d.m7643aq(str, i, i2);
        AppMethodBeat.m2505o(116118);
        return aq;
    }

    /* renamed from: a */
    public static Bitmap m41094a(C25817c c25817c, int i, int i2, int i3) {
        AppMethodBeat.m2504i(116119);
        Bitmap aw;
        if (i2 > 0 && i3 > 0) {
            aw = C5056d.m7646aw(i, i2, i3);
            AppMethodBeat.m2505o(116119);
            return aw;
        } else if (c25817c == null || c25817c.width <= 0 || c25817c.width <= 0) {
            aw = C5056d.m7610LV(i);
            AppMethodBeat.m2505o(116119);
            return aw;
        } else {
            aw = C5056d.m7646aw(i, c25817c.width, c25817c.height);
            AppMethodBeat.m2505o(116119);
            return aw;
        }
    }
}
