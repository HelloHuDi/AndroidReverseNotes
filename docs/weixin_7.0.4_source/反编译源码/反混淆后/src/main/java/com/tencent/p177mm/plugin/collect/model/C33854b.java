package com.tencent.p177mm.plugin.collect.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.p1529bw.p1530a.C37623a;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.qbar.QbarNative;

/* renamed from: com.tencent.mm.plugin.collect.model.b */
public final class C33854b {
    /* renamed from: a */
    public static Bitmap m55398a(Context context, String str, String str2, int i, String str3, C18765a c18765a) {
        AppMethodBeat.m2504i(40919);
        Bitmap a = C33854b.m55399a(context, str, str2, i, str3, c18765a, false);
        AppMethodBeat.m2505o(40919);
        return a;
    }

    /* renamed from: a */
    public static Bitmap m55399a(Context context, String str, String str2, int i, String str3, C18765a c18765a, boolean z) {
        AppMethodBeat.m2504i(40920);
        Bitmap a = C33854b.m55397a(context, str, str2, i, str3, C4977b.m7371b(context, 197.0f), c18765a, z);
        AppMethodBeat.m2505o(40920);
        return a;
    }

    /* renamed from: a */
    public static Bitmap m55397a(Context context, String str, String str2, int i, String str3, int i2, C18765a c18765a, boolean z) {
        AppMethodBeat.m2504i(40921);
        int i3 = (int) (((float) i2) * 0.26f);
        int i4 = (int) (((float) i2) * 0.22f);
        int i5 = (int) (((float) i2) * 0.076f);
        try {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            C4990ab.m7417i("MicroMsg.CollectBitmapFactory", "createCollectQrcode size avatarSize %s dpCanvas %s", Integer.valueOf(i4), Integer.valueOf(i3));
            Bitmap createBitmap = Bitmap.createBitmap(i3, i3, Config.ARGB_8888);
            Bitmap bitmap = null;
            if (i == 1 && !C5046bo.isNullOrNil(str3)) {
                bitmap = C18764x.m29325a(new C16731c(str3));
                C18764x.m29328b(c18765a);
            }
            if (bitmap == null) {
                bitmap = C41730b.m73493d(str2, i4, i4, (int) (((float) i4) * 0.06f));
            }
            if (bitmap == null) {
                bitmap = C4977b.m7372b(C4996ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), C1338a.getDensity(null));
                bitmap = C5056d.m7616a(bitmap, false, 0.06f * ((float) bitmap.getWidth()));
            }
            if (bitmap != null && z) {
                bitmap = C5056d.m7616a(bitmap, false, ((float) bitmap.getWidth()) * 0.5f);
            }
            Canvas canvas = new Canvas(createBitmap);
            i4 = (i3 - i4) / 2;
            canvas.drawBitmap(bitmap, null, new Rect(i4, i4, i3 - i4, i3 - i4), paint);
            canvas.drawBitmap(MMBitmapFactory.decodeStream(context.getResources().openRawResource(C25738R.drawable.b20)), null, new Rect(i3 - i5, i3 - i5, i3, i3), paint);
            byte[] bArr = new byte[40000];
            int[] iArr = new int[2];
            i4 = QbarNative.m49363a(bArr, iArr, str, 12, 3, "UTF-8");
            QbarNative.nativeRelease();
            if (i4 == 0) {
                bitmap = C37623a.m63539a(context, createBitmap, bArr, iArr);
                if (bitmap == null) {
                    C4990ab.m7417i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", Integer.valueOf(i4), C5046bo.dpG().toString());
                } else {
                    C4990ab.m7417i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", bitmap);
                }
            } else {
                C4990ab.m7417i("MicroMsg.QRCodeBitmapFactory", "result %d %s", Integer.valueOf(i4), C5046bo.dpG().toString());
                bitmap = null;
            }
            C4990ab.m7417i("MicroMsg.CollectBitmapFactory", "bitmap recycle %s", createBitmap);
            createBitmap.recycle();
            AppMethodBeat.m2505o(40921);
            return bitmap;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.CollectBitmapFactory", e, "", new Object[0]);
            AppMethodBeat.m2505o(40921);
            return null;
        }
    }
}
