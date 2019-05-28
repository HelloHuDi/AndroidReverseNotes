package com.tencent.mm.at.a.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;
import java.io.InputStream;

public final class a {
    public static Bitmap a(c cVar, String str, int i, int i2) {
        AppMethodBeat.i(116114);
        Bitmap d;
        if (i > 0 && i2 > 0) {
            d = d.d(str, i2, i, false);
            AppMethodBeat.o(116114);
            return d;
        } else if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            d = d.aml(str);
            AppMethodBeat.o(116114);
            return d;
        } else {
            d = d.ap(str, cVar.width, cVar.height);
            AppMethodBeat.o(116114);
            return d;
        }
    }

    public static Bitmap b(c cVar, String str, int i, int i2) {
        AppMethodBeat.i(116115);
        Options amj = d.amj(str);
        Bitmap d;
        if (amj == null || (amj.outWidth < amj.outHeight * 2 && amj.outWidth * 2 > amj.outHeight)) {
            d = d.d(str, i2, i, false);
            AppMethodBeat.o(116115);
            return d;
        } else if (i > 0 && i2 > 0) {
            d = d.d(str, i2, i, true);
            AppMethodBeat.o(116115);
            return d;
        } else if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            int i3;
            int i4;
            if (cVar == null || cVar.getImageView() == null) {
                ab.w("MicroMsg.imageloader.ImageLoaderUtils", "crop bitmap cant not un set width or height");
                i3 = 0;
                i4 = 0;
            } else {
                int measuredWidth = cVar.getImageView().getMeasuredWidth();
                i3 = cVar.getImageView().getMeasuredHeight();
                i4 = measuredWidth;
            }
            d = d.d(str, i3, i4, true);
            AppMethodBeat.o(116115);
            return d;
        } else {
            d = d.d(str, cVar.height, cVar.width, true);
            AppMethodBeat.o(116115);
            return d;
        }
    }

    public static Bitmap a(c cVar, InputStream inputStream, int i, int i2, boolean z, float f, boolean z2) {
        Bitmap a;
        AppMethodBeat.i(116116);
        if (i > 0 && i2 > 0) {
            a = d.a(inputStream, 0.0f, i, i2);
        } else if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            a = d.decodeStream(inputStream);
        } else {
            a = d.a(inputStream, 0.0f, cVar.width, cVar.height);
        }
        if (z) {
            a = d.a(a, i, i2, false, true);
        }
        if (f > 0.0f) {
            a = d.c(a, f);
        }
        if (z2) {
            a = d.ak(a);
        }
        AppMethodBeat.o(116116);
        return a;
    }

    public static Bitmap a(c cVar, byte[] bArr, int i, int i2, boolean z, float f, boolean z2) {
        Bitmap decodeByteArray;
        AppMethodBeat.i(116117);
        if (i > 0 && i2 > 0) {
            decodeByteArray = d.decodeByteArray(bArr, i, i2);
        } else if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            decodeByteArray = d.bQ(bArr);
        } else {
            decodeByteArray = d.decodeByteArray(bArr, cVar.width, cVar.height);
        }
        if (z) {
            decodeByteArray = d.a(d.decodeByteArray(bArr, i, i2), i, i2, false, true);
        }
        if (f > 0.0f) {
            decodeByteArray = d.c(decodeByteArray, f);
        }
        if (z2) {
            decodeByteArray = d.ak(decodeByteArray);
        }
        AppMethodBeat.o(116117);
        return decodeByteArray;
    }

    public static Bitmap c(c cVar, String str, int i, int i2) {
        AppMethodBeat.i(116118);
        Bitmap aq;
        if (i <= 0 || i2 <= 0) {
            if (cVar != null) {
                try {
                    if (cVar.width > 0 && cVar.width > 0) {
                        aq = d.aq(str, cVar.width, cVar.height);
                        AppMethodBeat.o(116118);
                        return aq;
                    }
                } catch (IOException e) {
                    ab.e("MicroMsg.imageloader.ImageLoaderUtils", "get bitmap from assert failed. :%s", e.toString());
                    AppMethodBeat.o(116118);
                    return null;
                }
            }
            aq = d.aq(str, 0, 0);
            AppMethodBeat.o(116118);
            return aq;
        }
        aq = d.aq(str, i, i2);
        AppMethodBeat.o(116118);
        return aq;
    }

    public static Bitmap a(c cVar, int i, int i2, int i3) {
        AppMethodBeat.i(116119);
        Bitmap aw;
        if (i2 > 0 && i3 > 0) {
            aw = d.aw(i, i2, i3);
            AppMethodBeat.o(116119);
            return aw;
        } else if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            aw = d.LV(i);
            AppMethodBeat.o(116119);
            return aw;
        } else {
            aw = d.aw(i, cVar.width, cVar.height);
            AppMethodBeat.o(116119);
            return aw;
        }
    }
}
