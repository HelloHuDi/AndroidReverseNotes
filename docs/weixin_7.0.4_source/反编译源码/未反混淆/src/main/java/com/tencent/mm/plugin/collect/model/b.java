package com.tencent.mm.plugin.collect.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.qbar.QbarNative;

public final class b {
    public static Bitmap a(Context context, String str, String str2, int i, String str3, a aVar) {
        AppMethodBeat.i(40919);
        Bitmap a = a(context, str, str2, i, str3, aVar, false);
        AppMethodBeat.o(40919);
        return a;
    }

    public static Bitmap a(Context context, String str, String str2, int i, String str3, a aVar, boolean z) {
        AppMethodBeat.i(40920);
        Bitmap a = a(context, str, str2, i, str3, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, 197.0f), aVar, z);
        AppMethodBeat.o(40920);
        return a;
    }

    public static Bitmap a(Context context, String str, String str2, int i, String str3, int i2, a aVar, boolean z) {
        AppMethodBeat.i(40921);
        int i3 = (int) (((float) i2) * 0.26f);
        int i4 = (int) (((float) i2) * 0.22f);
        int i5 = (int) (((float) i2) * 0.076f);
        try {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            ab.i("MicroMsg.CollectBitmapFactory", "createCollectQrcode size avatarSize %s dpCanvas %s", Integer.valueOf(i4), Integer.valueOf(i3));
            Bitmap createBitmap = Bitmap.createBitmap(i3, i3, Config.ARGB_8888);
            Bitmap bitmap = null;
            if (i == 1 && !bo.isNullOrNil(str3)) {
                bitmap = x.a(new c(str3));
                x.b(aVar);
            }
            if (bitmap == null) {
                bitmap = com.tencent.mm.ah.b.d(str2, i4, i4, (int) (((float) i4) * 0.06f));
            }
            if (bitmap == null) {
                bitmap = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bz.a.getDensity(null));
                bitmap = d.a(bitmap, false, 0.06f * ((float) bitmap.getWidth()));
            }
            if (bitmap != null && z) {
                bitmap = d.a(bitmap, false, ((float) bitmap.getWidth()) * 0.5f);
            }
            Canvas canvas = new Canvas(createBitmap);
            i4 = (i3 - i4) / 2;
            canvas.drawBitmap(bitmap, null, new Rect(i4, i4, i3 - i4, i3 - i4), paint);
            canvas.drawBitmap(MMBitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.b20)), null, new Rect(i3 - i5, i3 - i5, i3, i3), paint);
            byte[] bArr = new byte[40000];
            int[] iArr = new int[2];
            i4 = QbarNative.a(bArr, iArr, str, 12, 3, "UTF-8");
            QbarNative.nativeRelease();
            if (i4 == 0) {
                bitmap = com.tencent.mm.bw.a.a.a(context, createBitmap, bArr, iArr);
                if (bitmap == null) {
                    ab.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", Integer.valueOf(i4), bo.dpG().toString());
                } else {
                    ab.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", bitmap);
                }
            } else {
                ab.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", Integer.valueOf(i4), bo.dpG().toString());
                bitmap = null;
            }
            ab.i("MicroMsg.CollectBitmapFactory", "bitmap recycle %s", createBitmap);
            createBitmap.recycle();
            AppMethodBeat.o(40921);
            return bitmap;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.CollectBitmapFactory", e, "", new Object[0]);
            AppMethodBeat.o(40921);
            return null;
        }
    }
}
