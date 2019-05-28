package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class l {
    private static Map<String, a> mkp = new HashMap();
    private static f<String, Bitmap> mkq = new b(10, l.class);
    private static f<String, Bitmap> mkr = new b(20, l.class);
    public Context context;
    public e mkm;
    public HashMap<String, String[]> mkn = new HashMap();
    private HashMap<String, String[]> mko = new HashMap();

    /* renamed from: com.tencent.mm.plugin.fav.ui.l$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ String fXq;
        final /* synthetic */ g meE;
        final /* synthetic */ aar mjL;

        public AnonymousClass2(String str, g gVar, aar aar) {
            this.fXq = str;
            this.meE = gVar;
            this.mjL = aar;
        }

        public final void run() {
            AppMethodBeat.i(74189);
            if (l.cW(this.fXq)) {
                com.tencent.mm.plugin.fav.a.b.a(this.meE, this.mjL, false);
            }
            AppMethodBeat.o(74189);
        }

        public final String toString() {
            AppMethodBeat.i(74190);
            String str = super.toString() + "|attachImg";
            AppMethodBeat.o(74190);
            return str;
        }
    }

    static /* synthetic */ void c(g gVar, aar aar, boolean z) {
        AppMethodBeat.i(74217);
        b(gVar, aar, z);
        AppMethodBeat.o(74217);
    }

    static {
        AppMethodBeat.i(74218);
        AppMethodBeat.o(74218);
    }

    public l(Context context, int i) {
        AppMethodBeat.i(74201);
        this.context = context;
        if (i <= 0) {
            i = 24;
        }
        this.mkm = new e(i);
        AppMethodBeat.o(74201);
    }

    private void bvP() {
        AppMethodBeat.i(74202);
        e eVar = this.mkm;
        synchronized (eVar.eMl) {
            try {
                ab.d("MicroMsg.ImageEngine", "do clear mark");
                eVar.vuu.clear();
                eVar.vuv.clear();
                eVar.vuu = new HashMap();
                eVar.vuv = new HashMap();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(74202);
            }
        }
    }

    public final void destory() {
        AppMethodBeat.i(74203);
        bvP();
        this.mkn.clear();
        this.mko.clear();
        this.mkm.destroy();
        this.context = null;
        this.mkn = null;
        this.mko = null;
        this.mkm = null;
        AppMethodBeat.o(74203);
    }

    public final void a(ImageView imageView, aar aar, g gVar, int i, int i2, int i3) {
        String str = null;
        AppMethodBeat.i(74205);
        if (imageView == null) {
            AppMethodBeat.o(74205);
        } else if (!com.tencent.mm.compatible.util.f.Mn()) {
            imageView.setImageResource(R.drawable.ak_);
            AppMethodBeat.o(74205);
        } else if (gVar == null) {
            AppMethodBeat.o(74205);
        } else {
            abe abe;
            switch (gVar.field_type) {
                case 4:
                case 16:
                    if (aar != null) {
                        a(imageView, aar, gVar, aar.cvq, i, i2, i3);
                        AppMethodBeat.o(74205);
                        return;
                    }
                    break;
                case 5:
                    abu abu = gVar.field_favProto.whA;
                    if (aar == null) {
                        if (abu != null) {
                            this.mkm.a(imageView, null, abu.thumbUrl, i, i2, i3);
                        }
                        AppMethodBeat.o(74205);
                        return;
                    }
                    String str2;
                    if (abu != null) {
                        str = abu.thumbUrl;
                    }
                    if (bo.isNullOrNil(str)) {
                        str2 = aar.cvq;
                    } else {
                        str2 = str;
                    }
                    a(imageView, aar, gVar, str2, i, i2, i3);
                    AppMethodBeat.o(74205);
                    return;
                case 7:
                    if (aar != null) {
                        a(imageView, aar, gVar, aar.cvq, i, i2, i3);
                        AppMethodBeat.o(74205);
                        return;
                    }
                    break;
                case 10:
                    abe = gVar.field_favProto.whC;
                    if (abe != null) {
                        this.mkm.a(imageView, null, abe.thumbUrl, i, i2, i3);
                        AppMethodBeat.o(74205);
                        return;
                    }
                    break;
                case 11:
                    abe = gVar.field_favProto.whC;
                    if (abe != null) {
                        this.mkm.a(imageView, null, abe.thumbUrl, i, i2, i3);
                        AppMethodBeat.o(74205);
                        return;
                    }
                    break;
                case 15:
                    abo abo = gVar.field_favProto.whE;
                    if (abo != null) {
                        this.mkm.a(imageView, null, abo.thumbUrl, i, i2, i3);
                        AppMethodBeat.o(74205);
                        return;
                    }
                    break;
                default:
                    ab.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", Integer.valueOf(gVar.field_type));
                    AppMethodBeat.o(74205);
                    return;
            }
            AppMethodBeat.o(74205);
        }
    }

    public final void b(ImageView imageView, aar aar, g gVar, int i, int i2, int i3) {
        String str = null;
        AppMethodBeat.i(74206);
        if (imageView == null) {
            AppMethodBeat.o(74206);
        } else if (!com.tencent.mm.compatible.util.f.Mn()) {
            imageView.setImageResource(R.drawable.ak_);
            AppMethodBeat.o(74206);
        } else if (gVar == null || aar == null) {
            imageView.setImageDrawable(com.tencent.mm.bz.a.g(this.context, i));
            AppMethodBeat.o(74206);
        } else {
            abe abe;
            switch (aar.dataType) {
                case 4:
                case 15:
                    a(imageView, aar, gVar, aar.cvq, i, i2, i3);
                    AppMethodBeat.o(74206);
                    return;
                case 5:
                    abu abu;
                    String str2;
                    if (aar.wgT != null) {
                        abu = aar.wgT.whA;
                    } else {
                        ab.w("MicroMsg.FavoriteImageLogic", "webpage: get data proto item null, dataid[%s], infoid[%d, %d]", aar.mnd, Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id));
                        abu = null;
                    }
                    if (abu != null) {
                        str = abu.thumbUrl;
                    }
                    if (bo.isNullOrNil(str)) {
                        str2 = aar.cvq;
                    } else {
                        str2 = str;
                    }
                    a(imageView, aar, gVar, str2, i, i2, i3);
                    AppMethodBeat.o(74206);
                    return;
                case 7:
                    a(imageView, aar, gVar, aar.cvq, i, i2, i3);
                    AppMethodBeat.o(74206);
                    return;
                case 10:
                    if (aar.wgT == null) {
                        ab.w("MicroMsg.FavoriteImageLogic", "good: get data proto item null, dataid[%s], infoid[%d, %d]", aar.mnd, Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id));
                        AppMethodBeat.o(74206);
                        return;
                    }
                    abe = aar.wgT.whC;
                    if (abe != null) {
                        this.mkm.a(imageView, null, abe.thumbUrl, i, i2, i3);
                        AppMethodBeat.o(74206);
                        return;
                    }
                    break;
                case 11:
                    if (aar.wgT == null) {
                        ab.w("MicroMsg.FavoriteImageLogic", "product: get data proto item null, dataid[%s], infoid[%d, %d]", aar.mnd, Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id));
                        AppMethodBeat.o(74206);
                        return;
                    }
                    abe = aar.wgT.whC;
                    if (abe != null) {
                        this.mkm.a(imageView, null, abe.thumbUrl, i, i2, i3);
                        AppMethodBeat.o(74206);
                        return;
                    }
                    break;
                case 14:
                    if (aar.wgT == null) {
                        ab.w("MicroMsg.FavoriteImageLogic", "tv: get data proto item null, dataid[%s], infoid[%d, %d]", aar.mnd, Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id));
                        AppMethodBeat.o(74206);
                        return;
                    }
                    abo abo = aar.wgT.whE;
                    if (abo != null) {
                        this.mkm.a(imageView, null, abo.thumbUrl, i, i2, i3);
                        AppMethodBeat.o(74206);
                        return;
                    }
                    break;
                case 19:
                    if (aar.wgT == null) {
                        ab.w("MicroMsg.FavoriteImageLogic", "app brand: get data proto item null, dataid[%s], infoid[%d, %d]", aar.mnd, Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id));
                        AppMethodBeat.o(74206);
                        return;
                    }
                    aap aap = aar.wgT.whN;
                    if (aap != null) {
                        this.mkm.a(imageView, null, aap.iconUrl, i, i2, i3);
                        AppMethodBeat.o(74206);
                        return;
                    }
                    break;
                default:
                    ab.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", Integer.valueOf(gVar.field_type));
                    AppMethodBeat.o(74206);
                    return;
            }
            AppMethodBeat.o(74206);
        }
    }

    private static Bitmap a(aar aar, boolean z, boolean z2) {
        String c;
        AppMethodBeat.i(74207);
        if (z) {
            c = com.tencent.mm.plugin.fav.a.b.c(aar);
        } else {
            c = com.tencent.mm.plugin.fav.a.b.b(aar);
        }
        if (e.ct(c)) {
            Bitmap aI = c.aI(c, z2);
            AppMethodBeat.o(74207);
            return aI;
        }
        ab.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
        AppMethodBeat.o(74207);
        return null;
    }

    public static Bitmap b(final aar aar, final g gVar, int i) {
        AppMethodBeat.i(74208);
        Bitmap decodeResource;
        if (!com.tencent.mm.compatible.util.f.Mn()) {
            decodeResource = BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.ak_);
            AppMethodBeat.o(74208);
            return decodeResource;
        } else if (aar.mnd == null) {
            AppMethodBeat.o(74208);
            return null;
        } else {
            String b = com.tencent.mm.plugin.fav.a.b.b(aar);
            if (e.ct(b)) {
                decodeResource = (Bitmap) mkq.get(b);
                if (decodeResource != null) {
                    ab.d("MicroMsg.FavoriteImageLogic", "get bm from cache %s", b);
                } else {
                    int i2;
                    ab.d("MicroMsg.FavoriteImageLogic", "get from cache fail, try to decode from file");
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    decodeResource = BitmapFactory.decodeFile(b, options);
                    if (decodeResource != null) {
                        ab.i("MicroMsg.FavoriteImageLogic", "bitmap recycle %s", decodeResource);
                        decodeResource.recycle();
                    }
                    int i3 = options.outWidth;
                    int i4 = options.outHeight;
                    ab.d("MicroMsg.FavoriteImageLogic", "width: %s, height: %s", Integer.valueOf(i3), Integer.valueOf(i4));
                    if (i3 > i) {
                        i4 = (options.outHeight * i) / options.outWidth;
                    } else {
                        i = i3;
                    }
                    int max = Math.max(1, i);
                    i3 = Math.max(1, i4);
                    ab.w("MicroMsg.FavoriteImageLogic", "fit long picture, beg %d*%d, after %d*%d", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(max), Integer.valueOf(i3));
                    int bJ = ExifHelper.bJ(b);
                    if (bJ == 90 || bJ == 270) {
                        i4 = max;
                        i2 = i3;
                    } else {
                        i4 = i3;
                        i2 = max;
                    }
                    decodeResource = d.d(b, i4, i2, false);
                    if (decodeResource == null) {
                        ab.e("MicroMsg.FavoriteImageLogic", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(b)));
                        decodeResource = null;
                    } else {
                        decodeResource = d.b(decodeResource, (float) bJ);
                        mkq.put(b, decodeResource);
                    }
                }
            } else {
                ab.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
                decodeResource = null;
            }
            if (decodeResource == null) {
                final String b2 = com.tencent.mm.plugin.fav.a.b.b(aar);
                com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                    final /* synthetic */ boolean mkt = false;

                    public final void run() {
                        AppMethodBeat.i(74191);
                        if (this.mkt || l.cW(b2)) {
                            com.tencent.mm.plugin.fav.a.b.a(gVar, aar, this.mkt);
                        }
                        AppMethodBeat.o(74191);
                    }

                    public final String toString() {
                        AppMethodBeat.i(74192);
                        String str = super.toString() + "|getBigImg";
                        AppMethodBeat.o(74192);
                        return str;
                    }
                });
            }
            AppMethodBeat.o(74208);
            return decodeResource;
        }
    }

    public static Bitmap j(aar aar) {
        AppMethodBeat.i(74209);
        Bitmap decodeResource;
        if (!com.tencent.mm.compatible.util.f.Mn()) {
            decodeResource = BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.ak_);
            AppMethodBeat.o(74209);
            return decodeResource;
        } else if (aar.mnd == null) {
            AppMethodBeat.o(74209);
            return null;
        } else {
            decodeResource = a(aar, false, true);
            AppMethodBeat.o(74209);
            return decodeResource;
        }
    }

    public static Bitmap a(final aar aar, final g gVar, final boolean z) {
        AppMethodBeat.i(74210);
        Bitmap decodeResource;
        if (!com.tencent.mm.compatible.util.f.Mn()) {
            decodeResource = BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.ak_);
            AppMethodBeat.o(74210);
            return decodeResource;
        } else if (aar.mnd == null) {
            AppMethodBeat.o(74210);
            return null;
        } else {
            decodeResource = a(aar, false, false);
            if (decodeResource == null) {
                final String b = com.tencent.mm.plugin.fav.a.b.b(aar);
                com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(74193);
                        if (z || l.cW(b)) {
                            com.tencent.mm.plugin.fav.a.b.a(gVar, aar, z);
                        }
                        AppMethodBeat.o(74193);
                    }

                    public final String toString() {
                        AppMethodBeat.i(74194);
                        String str = super.toString() + "|getBigImg";
                        AppMethodBeat.o(74194);
                        return str;
                    }
                });
            }
            AppMethodBeat.o(74210);
            return decodeResource;
        }
    }

    public static Bitmap a(final aar aar, final g gVar) {
        AppMethodBeat.i(74211);
        Bitmap decodeResource;
        if (!com.tencent.mm.compatible.util.f.Mn()) {
            decodeResource = BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.ak_);
            AppMethodBeat.o(74211);
            return decodeResource;
        } else if (com.tencent.mm.plugin.fav.a.b.LA(aar.mnd) == null) {
            AppMethodBeat.o(74211);
            return null;
        } else {
            decodeResource = a(aar, true, false);
            if (decodeResource == null) {
                final String c = com.tencent.mm.plugin.fav.a.b.c(aar);
                com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(74195);
                        if (l.cW(c)) {
                            com.tencent.mm.plugin.fav.a.b.a(gVar, aar);
                        }
                        AppMethodBeat.o(74195);
                    }

                    public final String toString() {
                        AppMethodBeat.i(74196);
                        String str = super.toString() + "|getThumb";
                        AppMethodBeat.o(74196);
                        return str;
                    }
                });
            }
            AppMethodBeat.o(74211);
            return decodeResource;
        }
    }

    public static Bitmap b(String str, int i, int i2, boolean z) {
        AppMethodBeat.i(74212);
        boolean z2 = false;
        if (e.ct(str)) {
            Bitmap bitmap = (Bitmap) mkr.get(str);
            if (bitmap != null || z) {
                String str2 = "MicroMsg.FavoriteImageLogic";
                String str3 = "return bm path %s, bm %s";
                Object[] objArr = new Object[2];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(bitmap != null);
                ab.d(str2, str3, objArr);
                AppMethodBeat.o(74212);
                return bitmap;
            }
            try {
                int i3;
                int i4;
                Options options = new Options();
                options.inJustDecodeBounds = true;
                d.decodeFile(str, options);
                int i5 = options.outWidth;
                int i6 = options.outHeight;
                int bJ = ExifHelper.bJ(str);
                if (bJ == 90 || bJ == 270) {
                    z2 = true;
                    i3 = i5;
                    i4 = i6;
                } else {
                    i3 = i6;
                    i4 = i5;
                }
                options.inSampleSize = 1;
                while (i3 / options.inSampleSize > i2 && i4 / options.inSampleSize > i) {
                    options.inSampleSize++;
                }
                i6 = (i4 * i2) / i;
                ab.d("MicroMsg.FavoriteImageLogic", "decode top region width: %d, height: %d, scaleheight: %d, rotate: %b", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i6), Boolean.valueOf(z2));
                if (i6 <= 0 || i3 <= i6) {
                    options.inJustDecodeBounds = false;
                    bitmap = d.decodeFile(str, options);
                } else {
                    Rect rect = new Rect();
                    rect.top = 0;
                    rect.left = 0;
                    if (z2) {
                        rect.right = i6;
                        rect.bottom = i4;
                    } else {
                        rect.right = i4;
                        rect.bottom = i6;
                    }
                    BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(str, true);
                    options.inJustDecodeBounds = false;
                    bitmap = newInstance.decodeRegion(rect, options);
                }
                if (bitmap != null && z2) {
                    bitmap = d.b(bitmap, (float) bJ);
                }
                if (bitmap != null) {
                    ab.d("MicroMsg.FavoriteImageLogic", "width %d, height %d, tw %d, th %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(i), Integer.valueOf(i2));
                    mkr.put(str, bitmap);
                } else {
                    ab.w("MicroMsg.FavoriteImageLogic", "decode bm fail!");
                }
            } catch (IOException e) {
                ab.e("MicroMsg.FavoriteImageLogic", e.getMessage());
            }
            AppMethodBeat.o(74212);
            return bitmap;
        }
        ab.w("MicroMsg.FavoriteImageLogic", "file not exist");
        AppMethodBeat.o(74212);
        return null;
    }

    public static void a(ImageView imageView, aar aar, g gVar, boolean z, int i, int i2) {
        AppMethodBeat.i(74213);
        if (!com.tencent.mm.compatible.util.f.Mn()) {
            imageView.setImageBitmap(BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.ak_));
        }
        if (aar.mnd == null) {
            imageView.setImageResource(R.raw.fav_list_img_default);
        }
        Bitmap a = a(aar, gVar);
        final String b = com.tencent.mm.plugin.fav.a.b.b(aar);
        if (e.ct(b)) {
            a = b(b, i, i2, true);
        }
        if (a == null) {
            imageView.setImageResource(R.raw.fav_list_img_default);
            imageView.setTag(b);
            final int i3 = i;
            final int i4 = i2;
            final g gVar2 = gVar;
            final aar aar2 = aar;
            final boolean z2 = z;
            final ImageView imageView2 = imageView;
            com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(74198);
                    final Bitmap b = l.b(b, i3, i4, false);
                    if (b == null) {
                        l.c(gVar2, aar2, z2);
                        AppMethodBeat.o(74198);
                        return;
                    }
                    String str = (String) imageView2.getTag();
                    if (str != null && str.equals(b)) {
                        com.tencent.mm.kernel.g.RS();
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(74197);
                                imageView2.setImageBitmap(b);
                                AppMethodBeat.o(74197);
                            }
                        });
                    }
                    AppMethodBeat.o(74198);
                }
            });
            AppMethodBeat.o(74213);
            return;
        }
        imageView.setImageBitmap(a);
        AppMethodBeat.o(74213);
    }

    private static void b(final g gVar, final aar aar, final boolean z) {
        AppMethodBeat.i(74214);
        final String b = com.tencent.mm.plugin.fav.a.b.b(aar);
        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74199);
                if (z || l.cW(b)) {
                    com.tencent.mm.plugin.fav.a.b.a(gVar, aar, z);
                }
                AppMethodBeat.o(74199);
            }

            public final String toString() {
                AppMethodBeat.i(74200);
                String str = super.toString() + "|reDownload";
                AppMethodBeat.o(74200);
                return str;
            }
        });
        AppMethodBeat.o(74214);
    }

    public static void b(g gVar, aar aar) {
        AppMethodBeat.i(74215);
        b(gVar, aar, true);
        AppMethodBeat.o(74215);
    }

    public final void a(ImageView imageView, final aar aar, final g gVar, String str, int i, int i2, int i3) {
        AppMethodBeat.i(74204);
        String LA = com.tencent.mm.plugin.fav.a.b.LA(aar.mnd);
        String[] strArr = null;
        if (aar.mnd != null) {
            String[] strArr2 = (String[]) this.mko.get(LA);
            if (strArr2 == null) {
                strArr = new String[]{com.tencent.mm.plugin.fav.a.b.c(aar)};
                this.mko.put(LA, strArr);
            } else {
                strArr = strArr2;
            }
        }
        this.mkm.a(imageView, strArr, str, i, i2, i3);
        if (strArr == null || strArr.length <= 0) {
            AppMethodBeat.o(74204);
            return;
        }
        final String str2 = strArr[0];
        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74187);
                if (l.cW(str2)) {
                    com.tencent.mm.plugin.fav.a.b.a(gVar, aar);
                }
                AppMethodBeat.o(74187);
            }

            public final String toString() {
                AppMethodBeat.i(74188);
                String str = super.toString() + "|mAttachThumb";
                AppMethodBeat.o(74188);
                return str;
            }
        });
        AppMethodBeat.o(74204);
    }

    static /* synthetic */ boolean cW(String str) {
        AppMethodBeat.i(74216);
        if (!new com.tencent.mm.vfs.b(str).exists()) {
            a aVar = (a) mkp.get(str);
            if (aVar == null) {
                mkp.put(str, new a());
                AppMethodBeat.o(74216);
                return true;
            } else if (aVar.Mr() > 30000) {
                ab.v("MicroMsg.FavoriteImageLogic", "error diff time");
                aVar.evE = SystemClock.elapsedRealtime();
                AppMethodBeat.o(74216);
                return true;
            }
        }
        AppMethodBeat.o(74216);
        return false;
    }
}
