package com.tencent.mm.plugin.record.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

public class l {
    private HashMap<String, String[]> mko = new HashMap();
    protected f<String, Bitmap> mkq = new b(10, getClass());
    protected com.tencent.mm.pluginsdk.ui.tools.f pJN = new com.tencent.mm.pluginsdk.ui.tools.f() {
        public final v h(String str, String str2, int i, int i2) {
            AppMethodBeat.i(24168);
            p pVar = new p(str, str2, i, i2);
            AppMethodBeat.o(24168);
            return pVar;
        }
    };
    private HashSet<String> pJO = new HashSet();
    private HashMap<String, a> pJP = new HashMap();

    public l() {
        AppMethodBeat.i(24169);
        AppMethodBeat.o(24169);
    }

    public final void destory() {
        AppMethodBeat.i(24170);
        this.pJN.destroy();
        this.mko.clear();
        this.pJO.clear();
        this.pJN = null;
        this.mko = null;
        this.pJO = null;
        AppMethodBeat.o(24170);
    }

    public final Bitmap a(aar aar, long j, boolean z) {
        int i = 1;
        AppMethodBeat.i(24172);
        Bitmap bitmap;
        if (com.tencent.mm.compatible.util.f.Mn()) {
            String f;
            if (z) {
                f = n.f(aar, j);
            } else {
                f = n.c(aar, j);
            }
            if (bo.isNullOrNil(f) || !e.ct(f)) {
                ab.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", Boolean.valueOf(z), f);
                AppMethodBeat.o(24172);
                return null;
            }
            bitmap = (Bitmap) this.mkq.get(f);
            if (bitmap != null) {
                AppMethodBeat.o(24172);
                return bitmap;
            }
            int i2;
            int i3;
            ab.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", f);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            bitmap = BitmapFactory.decodeFile(f, options);
            if (bitmap != null) {
                ab.i("MicroMsg.RecordMsgImgService", "bitmap recycled %s", bitmap);
                bitmap.recycle();
            }
            int i4 = (!ad.cJ(options.outWidth, options.outHeight) || options.outWidth <= 480) ? 0 : 1;
            if (!ad.cI(options.outWidth, options.outHeight) || options.outHeight <= 480) {
                i = 0;
            }
            if (i4 == 0 && i == 0) {
                i4 = VideoFilterUtil.IMAGE_HEIGHT;
                i = 960;
            } else {
                i4 = options.outHeight;
                i = options.outWidth;
            }
            int bJ = ExifHelper.bJ(f);
            if (bJ == 90 || bJ == 270) {
                i2 = i;
                i3 = i4;
            } else {
                i2 = i4;
                i3 = i;
            }
            bitmap = d.d(f, i2, i3, false);
            if (bitmap == null) {
                ab.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = ".concat(String.valueOf(f)));
                AppMethodBeat.o(24172);
                return null;
            }
            bitmap = d.b(bitmap, (float) bJ);
            this.mkq.put(f, bitmap);
            AppMethodBeat.o(24172);
            return bitmap;
        }
        bitmap = BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.ak_);
        AppMethodBeat.o(24172);
        return bitmap;
    }

    public final Bitmap b(aar aar, long j) {
        AppMethodBeat.i(24173);
        Bitmap a = a(aar, j, true);
        if (a == null) {
            ab.d("MicroMsg.RecordMsgImgService", "get thumb fail, try download, can retry:%B", Boolean.valueOf(a(aar, j)));
            n.c(aar, j, r1);
        }
        AppMethodBeat.o(24173);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(ImageView imageView, aar aar, long j, String str, int i, int i2, int i3) {
        AppMethodBeat.i(24174);
        String str2 = n.LA(aar.mnd) + "@" + String.valueOf(j);
        if (aar.mnd != null) {
            String[] strArr;
            String[] strArr2 = (String[]) this.mko.get(str2);
            if (strArr2 == null || strArr2.length <= 0) {
                strArr = new String[]{n.f(aar, j)};
                this.mko.put(str2, strArr);
            } else {
                strArr = strArr2;
            }
            this.pJN.a(imageView, strArr, str, i, i2, i3);
            if (this.pJO.contains(str2)) {
                AppMethodBeat.o(24174);
                return;
            }
            this.pJO.add(str2);
            if (!(new File(strArr[0]).exists() || (bo.isNullOrNil(aar.fgE) && bo.isNullOrNil(aar.fgv)))) {
                n.c(aar, j, a(aar, j));
            }
            AppMethodBeat.o(24174);
            return;
        }
        AppMethodBeat.o(24174);
    }

    public final boolean a(aar aar, long j) {
        AppMethodBeat.i(24171);
        String h = n.h(aar.mnd, j, true);
        a aVar = (a) this.pJP.get(h);
        if (aVar == null) {
            this.pJP.put(h, new a());
            AppMethodBeat.o(24171);
            return true;
        } else if (aVar.Mr() > 30000) {
            aVar.evE = SystemClock.elapsedRealtime();
            AppMethodBeat.o(24171);
            return true;
        } else {
            AppMethodBeat.o(24171);
            return false;
        }
    }
}
