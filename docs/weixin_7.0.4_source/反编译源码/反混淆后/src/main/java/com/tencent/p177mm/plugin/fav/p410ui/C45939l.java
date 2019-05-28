package com.tencent.p177mm.plugin.fav.p410ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.protocal.protobuf.aap;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abe;
import com.tencent.p177mm.protocal.protobuf.abo;
import com.tencent.p177mm.protocal.protobuf.abu;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.fav.ui.l */
public class C45939l {
    private static Map<String, C1446a> mkp = new HashMap();
    private static C1177f<String, Bitmap> mkq = new C26399b(10, C45939l.class);
    private static C1177f<String, Bitmap> mkr = new C26399b(20, C45939l.class);
    public Context context;
    public C45936e mkm;
    public HashMap<String, String[]> mkn = new HashMap();
    private HashMap<String, String[]> mko = new HashMap();

    /* renamed from: com.tencent.mm.plugin.fav.ui.l$2 */
    public class C207472 implements Runnable {
        final /* synthetic */ String fXq;
        final /* synthetic */ C27966g meE;
        final /* synthetic */ aar mjL;

        public C207472(String str, C27966g c27966g, aar aar) {
            this.fXq = str;
            this.meE = c27966g;
            this.mjL = aar;
        }

        public final void run() {
            AppMethodBeat.m2504i(74189);
            if (C45939l.m85284cW(this.fXq)) {
                C39037b.m66360a(this.meE, this.mjL, false);
            }
            AppMethodBeat.m2505o(74189);
        }

        public final String toString() {
            AppMethodBeat.m2504i(74190);
            String str = super.toString() + "|attachImg";
            AppMethodBeat.m2505o(74190);
            return str;
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m85283c(C27966g c27966g, aar aar, boolean z) {
        AppMethodBeat.m2504i(74217);
        C45939l.m85282b(c27966g, aar, z);
        AppMethodBeat.m2505o(74217);
    }

    static {
        AppMethodBeat.m2504i(74218);
        AppMethodBeat.m2505o(74218);
    }

    public C45939l(Context context, int i) {
        AppMethodBeat.m2504i(74201);
        this.context = context;
        if (i <= 0) {
            i = 24;
        }
        this.mkm = new C45936e(i);
        AppMethodBeat.m2505o(74201);
    }

    private void bvP() {
        AppMethodBeat.m2504i(74202);
        C45936e c45936e = this.mkm;
        synchronized (c45936e.eMl) {
            try {
                C4990ab.m7410d("MicroMsg.ImageEngine", "do clear mark");
                c45936e.vuu.clear();
                c45936e.vuv.clear();
                c45936e.vuu = new HashMap();
                c45936e.vuv = new HashMap();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(74202);
            }
        }
    }

    public final void destory() {
        AppMethodBeat.m2504i(74203);
        bvP();
        this.mkn.clear();
        this.mko.clear();
        this.mkm.destroy();
        this.context = null;
        this.mkn = null;
        this.mko = null;
        this.mkm = null;
        AppMethodBeat.m2505o(74203);
    }

    /* renamed from: a */
    public final void mo73786a(ImageView imageView, aar aar, C27966g c27966g, int i, int i2, int i3) {
        String str = null;
        AppMethodBeat.m2504i(74205);
        if (imageView == null) {
            AppMethodBeat.m2505o(74205);
        } else if (!C1445f.m3070Mn()) {
            imageView.setImageResource(C25738R.drawable.ak_);
            AppMethodBeat.m2505o(74205);
        } else if (c27966g == null) {
            AppMethodBeat.m2505o(74205);
        } else {
            abe abe;
            switch (c27966g.field_type) {
                case 4:
                case 16:
                    if (aar != null) {
                        mo73787a(imageView, aar, c27966g, aar.cvq, i, i2, i3);
                        AppMethodBeat.m2505o(74205);
                        return;
                    }
                    break;
                case 5:
                    abu abu = c27966g.field_favProto.whA;
                    if (aar == null) {
                        if (abu != null) {
                            this.mkm.mo9922a(imageView, null, abu.thumbUrl, i, i2, i3);
                        }
                        AppMethodBeat.m2505o(74205);
                        return;
                    }
                    String str2;
                    if (abu != null) {
                        str = abu.thumbUrl;
                    }
                    if (C5046bo.isNullOrNil(str)) {
                        str2 = aar.cvq;
                    } else {
                        str2 = str;
                    }
                    mo73787a(imageView, aar, c27966g, str2, i, i2, i3);
                    AppMethodBeat.m2505o(74205);
                    return;
                case 7:
                    if (aar != null) {
                        mo73787a(imageView, aar, c27966g, aar.cvq, i, i2, i3);
                        AppMethodBeat.m2505o(74205);
                        return;
                    }
                    break;
                case 10:
                    abe = c27966g.field_favProto.whC;
                    if (abe != null) {
                        this.mkm.mo9922a(imageView, null, abe.thumbUrl, i, i2, i3);
                        AppMethodBeat.m2505o(74205);
                        return;
                    }
                    break;
                case 11:
                    abe = c27966g.field_favProto.whC;
                    if (abe != null) {
                        this.mkm.mo9922a(imageView, null, abe.thumbUrl, i, i2, i3);
                        AppMethodBeat.m2505o(74205);
                        return;
                    }
                    break;
                case 15:
                    abo abo = c27966g.field_favProto.whE;
                    if (abo != null) {
                        this.mkm.mo9922a(imageView, null, abo.thumbUrl, i, i2, i3);
                        AppMethodBeat.m2505o(74205);
                        return;
                    }
                    break;
                default:
                    C4990ab.m7421w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", Integer.valueOf(c27966g.field_type));
                    AppMethodBeat.m2505o(74205);
                    return;
            }
            AppMethodBeat.m2505o(74205);
        }
    }

    /* renamed from: b */
    public final void mo73788b(ImageView imageView, aar aar, C27966g c27966g, int i, int i2, int i3) {
        String str = null;
        AppMethodBeat.m2504i(74206);
        if (imageView == null) {
            AppMethodBeat.m2505o(74206);
        } else if (!C1445f.m3070Mn()) {
            imageView.setImageResource(C25738R.drawable.ak_);
            AppMethodBeat.m2505o(74206);
        } else if (c27966g == null || aar == null) {
            imageView.setImageDrawable(C1338a.m2864g(this.context, i));
            AppMethodBeat.m2505o(74206);
        } else {
            abe abe;
            switch (aar.dataType) {
                case 4:
                case 15:
                    mo73787a(imageView, aar, c27966g, aar.cvq, i, i2, i3);
                    AppMethodBeat.m2505o(74206);
                    return;
                case 5:
                    abu abu;
                    String str2;
                    if (aar.wgT != null) {
                        abu = aar.wgT.whA;
                    } else {
                        C4990ab.m7421w("MicroMsg.FavoriteImageLogic", "webpage: get data proto item null, dataid[%s], infoid[%d, %d]", aar.mnd, Long.valueOf(c27966g.field_localId), Integer.valueOf(c27966g.field_id));
                        abu = null;
                    }
                    if (abu != null) {
                        str = abu.thumbUrl;
                    }
                    if (C5046bo.isNullOrNil(str)) {
                        str2 = aar.cvq;
                    } else {
                        str2 = str;
                    }
                    mo73787a(imageView, aar, c27966g, str2, i, i2, i3);
                    AppMethodBeat.m2505o(74206);
                    return;
                case 7:
                    mo73787a(imageView, aar, c27966g, aar.cvq, i, i2, i3);
                    AppMethodBeat.m2505o(74206);
                    return;
                case 10:
                    if (aar.wgT == null) {
                        C4990ab.m7421w("MicroMsg.FavoriteImageLogic", "good: get data proto item null, dataid[%s], infoid[%d, %d]", aar.mnd, Long.valueOf(c27966g.field_localId), Integer.valueOf(c27966g.field_id));
                        AppMethodBeat.m2505o(74206);
                        return;
                    }
                    abe = aar.wgT.whC;
                    if (abe != null) {
                        this.mkm.mo9922a(imageView, null, abe.thumbUrl, i, i2, i3);
                        AppMethodBeat.m2505o(74206);
                        return;
                    }
                    break;
                case 11:
                    if (aar.wgT == null) {
                        C4990ab.m7421w("MicroMsg.FavoriteImageLogic", "product: get data proto item null, dataid[%s], infoid[%d, %d]", aar.mnd, Long.valueOf(c27966g.field_localId), Integer.valueOf(c27966g.field_id));
                        AppMethodBeat.m2505o(74206);
                        return;
                    }
                    abe = aar.wgT.whC;
                    if (abe != null) {
                        this.mkm.mo9922a(imageView, null, abe.thumbUrl, i, i2, i3);
                        AppMethodBeat.m2505o(74206);
                        return;
                    }
                    break;
                case 14:
                    if (aar.wgT == null) {
                        C4990ab.m7421w("MicroMsg.FavoriteImageLogic", "tv: get data proto item null, dataid[%s], infoid[%d, %d]", aar.mnd, Long.valueOf(c27966g.field_localId), Integer.valueOf(c27966g.field_id));
                        AppMethodBeat.m2505o(74206);
                        return;
                    }
                    abo abo = aar.wgT.whE;
                    if (abo != null) {
                        this.mkm.mo9922a(imageView, null, abo.thumbUrl, i, i2, i3);
                        AppMethodBeat.m2505o(74206);
                        return;
                    }
                    break;
                case 19:
                    if (aar.wgT == null) {
                        C4990ab.m7421w("MicroMsg.FavoriteImageLogic", "app brand: get data proto item null, dataid[%s], infoid[%d, %d]", aar.mnd, Long.valueOf(c27966g.field_localId), Integer.valueOf(c27966g.field_id));
                        AppMethodBeat.m2505o(74206);
                        return;
                    }
                    aap aap = aar.wgT.whN;
                    if (aap != null) {
                        this.mkm.mo9922a(imageView, null, aap.iconUrl, i, i2, i3);
                        AppMethodBeat.m2505o(74206);
                        return;
                    }
                    break;
                default:
                    C4990ab.m7421w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", Integer.valueOf(c27966g.field_type));
                    AppMethodBeat.m2505o(74206);
                    return;
            }
            AppMethodBeat.m2505o(74206);
        }
    }

    /* renamed from: a */
    private static Bitmap m85277a(aar aar, boolean z, boolean z2) {
        String c;
        AppMethodBeat.m2504i(74207);
        if (z) {
            c = C39037b.m66379c(aar);
        } else {
            c = C39037b.m66370b(aar);
        }
        if (C5730e.m8628ct(c)) {
            Bitmap aI = C45932c.m85262aI(c, z2);
            AppMethodBeat.m2505o(74207);
            return aI;
        }
        C4990ab.m7420w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
        AppMethodBeat.m2505o(74207);
        return null;
    }

    /* renamed from: b */
    public static Bitmap m85279b(final aar aar, final C27966g c27966g, int i) {
        AppMethodBeat.m2504i(74208);
        Bitmap decodeResource;
        if (!C1445f.m3070Mn()) {
            decodeResource = BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.ak_);
            AppMethodBeat.m2505o(74208);
            return decodeResource;
        } else if (aar.mnd == null) {
            AppMethodBeat.m2505o(74208);
            return null;
        } else {
            String b = C39037b.m66370b(aar);
            if (C5730e.m8628ct(b)) {
                decodeResource = (Bitmap) mkq.get(b);
                if (decodeResource != null) {
                    C4990ab.m7411d("MicroMsg.FavoriteImageLogic", "get bm from cache %s", b);
                } else {
                    int i2;
                    C4990ab.m7410d("MicroMsg.FavoriteImageLogic", "get from cache fail, try to decode from file");
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    decodeResource = BitmapFactory.decodeFile(b, options);
                    if (decodeResource != null) {
                        C4990ab.m7417i("MicroMsg.FavoriteImageLogic", "bitmap recycle %s", decodeResource);
                        decodeResource.recycle();
                    }
                    int i3 = options.outWidth;
                    int i4 = options.outHeight;
                    C4990ab.m7411d("MicroMsg.FavoriteImageLogic", "width: %s, height: %s", Integer.valueOf(i3), Integer.valueOf(i4));
                    if (i3 > i) {
                        i4 = (options.outHeight * i) / options.outWidth;
                    } else {
                        i = i3;
                    }
                    int max = Math.max(1, i);
                    i3 = Math.max(1, i4);
                    C4990ab.m7421w("MicroMsg.FavoriteImageLogic", "fit long picture, beg %d*%d, after %d*%d", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(max), Integer.valueOf(i3));
                    int bJ = ExifHelper.m7368bJ(b);
                    if (bJ == 90 || bJ == 270) {
                        i4 = max;
                        i2 = i3;
                    } else {
                        i4 = i3;
                        i2 = max;
                    }
                    decodeResource = C5056d.m7659d(b, i4, i2, false);
                    if (decodeResource == null) {
                        C4990ab.m7412e("MicroMsg.FavoriteImageLogic", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(b)));
                        decodeResource = null;
                    } else {
                        decodeResource = C5056d.m7648b(decodeResource, (float) bJ);
                        mkq.put(b, decodeResource);
                    }
                }
            } else {
                C4990ab.m7420w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
                decodeResource = null;
            }
            if (decodeResource == null) {
                final String b2 = C39037b.m66370b(aar);
                C1720g.m3539RS().mo10302aa(new Runnable() {
                    final /* synthetic */ boolean mkt = false;

                    public final void run() {
                        AppMethodBeat.m2504i(74191);
                        if (this.mkt || C45939l.m85284cW(b2)) {
                            C39037b.m66360a(c27966g, aar, this.mkt);
                        }
                        AppMethodBeat.m2505o(74191);
                    }

                    public final String toString() {
                        AppMethodBeat.m2504i(74192);
                        String str = super.toString() + "|getBigImg";
                        AppMethodBeat.m2505o(74192);
                        return str;
                    }
                });
            }
            AppMethodBeat.m2505o(74208);
            return decodeResource;
        }
    }

    /* renamed from: j */
    public static Bitmap m85285j(aar aar) {
        AppMethodBeat.m2504i(74209);
        Bitmap decodeResource;
        if (!C1445f.m3070Mn()) {
            decodeResource = BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.ak_);
            AppMethodBeat.m2505o(74209);
            return decodeResource;
        } else if (aar.mnd == null) {
            AppMethodBeat.m2505o(74209);
            return null;
        } else {
            decodeResource = C45939l.m85277a(aar, false, true);
            AppMethodBeat.m2505o(74209);
            return decodeResource;
        }
    }

    /* renamed from: a */
    public static Bitmap m85276a(final aar aar, final C27966g c27966g, final boolean z) {
        AppMethodBeat.m2504i(74210);
        Bitmap decodeResource;
        if (!C1445f.m3070Mn()) {
            decodeResource = BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.ak_);
            AppMethodBeat.m2505o(74210);
            return decodeResource;
        } else if (aar.mnd == null) {
            AppMethodBeat.m2505o(74210);
            return null;
        } else {
            decodeResource = C45939l.m85277a(aar, false, false);
            if (decodeResource == null) {
                final String b = C39037b.m66370b(aar);
                C1720g.m3539RS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(74193);
                        if (z || C45939l.m85284cW(b)) {
                            C39037b.m66360a(c27966g, aar, z);
                        }
                        AppMethodBeat.m2505o(74193);
                    }

                    public final String toString() {
                        AppMethodBeat.m2504i(74194);
                        String str = super.toString() + "|getBigImg";
                        AppMethodBeat.m2505o(74194);
                        return str;
                    }
                });
            }
            AppMethodBeat.m2505o(74210);
            return decodeResource;
        }
    }

    /* renamed from: a */
    public static Bitmap m85275a(final aar aar, final C27966g c27966g) {
        AppMethodBeat.m2504i(74211);
        Bitmap decodeResource;
        if (!C1445f.m3070Mn()) {
            decodeResource = BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.ak_);
            AppMethodBeat.m2505o(74211);
            return decodeResource;
        } else if (C39037b.m66336LA(aar.mnd) == null) {
            AppMethodBeat.m2505o(74211);
            return null;
        } else {
            decodeResource = C45939l.m85277a(aar, true, false);
            if (decodeResource == null) {
                final String c = C39037b.m66379c(aar);
                C1720g.m3539RS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(74195);
                        if (C45939l.m85284cW(c)) {
                            C39037b.m66359a(c27966g, aar);
                        }
                        AppMethodBeat.m2505o(74195);
                    }

                    public final String toString() {
                        AppMethodBeat.m2504i(74196);
                        String str = super.toString() + "|getThumb";
                        AppMethodBeat.m2505o(74196);
                        return str;
                    }
                });
            }
            AppMethodBeat.m2505o(74211);
            return decodeResource;
        }
    }

    /* renamed from: b */
    public static Bitmap m85280b(String str, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(74212);
        boolean z2 = false;
        if (C5730e.m8628ct(str)) {
            Bitmap bitmap = (Bitmap) mkr.get(str);
            if (bitmap != null || z) {
                String str2 = "MicroMsg.FavoriteImageLogic";
                String str3 = "return bm path %s, bm %s";
                Object[] objArr = new Object[2];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(bitmap != null);
                C4990ab.m7411d(str2, str3, objArr);
                AppMethodBeat.m2505o(74212);
                return bitmap;
            }
            try {
                int i3;
                int i4;
                Options options = new Options();
                options.inJustDecodeBounds = true;
                C5056d.decodeFile(str, options);
                int i5 = options.outWidth;
                int i6 = options.outHeight;
                int bJ = ExifHelper.m7368bJ(str);
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
                C4990ab.m7411d("MicroMsg.FavoriteImageLogic", "decode top region width: %d, height: %d, scaleheight: %d, rotate: %b", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i6), Boolean.valueOf(z2));
                if (i6 <= 0 || i3 <= i6) {
                    options.inJustDecodeBounds = false;
                    bitmap = C5056d.decodeFile(str, options);
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
                    bitmap = C5056d.m7648b(bitmap, (float) bJ);
                }
                if (bitmap != null) {
                    C4990ab.m7411d("MicroMsg.FavoriteImageLogic", "width %d, height %d, tw %d, th %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(i), Integer.valueOf(i2));
                    mkr.put(str, bitmap);
                } else {
                    C4990ab.m7420w("MicroMsg.FavoriteImageLogic", "decode bm fail!");
                }
            } catch (IOException e) {
                C4990ab.m7412e("MicroMsg.FavoriteImageLogic", e.getMessage());
            }
            AppMethodBeat.m2505o(74212);
            return bitmap;
        }
        C4990ab.m7420w("MicroMsg.FavoriteImageLogic", "file not exist");
        AppMethodBeat.m2505o(74212);
        return null;
    }

    /* renamed from: a */
    public static void m85278a(ImageView imageView, aar aar, C27966g c27966g, boolean z, int i, int i2) {
        AppMethodBeat.m2504i(74213);
        if (!C1445f.m3070Mn()) {
            imageView.setImageBitmap(BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.ak_));
        }
        if (aar.mnd == null) {
            imageView.setImageResource(C1318a.fav_list_img_default);
        }
        Bitmap a = C45939l.m85275a(aar, c27966g);
        final String b = C39037b.m66370b(aar);
        if (C5730e.m8628ct(b)) {
            a = C45939l.m85280b(b, i, i2, true);
        }
        if (a == null) {
            imageView.setImageResource(C1318a.fav_list_img_default);
            imageView.setTag(b);
            final int i3 = i;
            final int i4 = i2;
            final C27966g c27966g2 = c27966g;
            final aar aar2 = aar;
            final boolean z2 = z;
            final ImageView imageView2 = imageView;
            C1720g.m3539RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(74198);
                    final Bitmap b = C45939l.m85280b(b, i3, i4, false);
                    if (b == null) {
                        C45939l.m85283c(c27966g2, aar2, z2);
                        AppMethodBeat.m2505o(74198);
                        return;
                    }
                    String str = (String) imageView2.getTag();
                    if (str != null && str.equals(b)) {
                        C1720g.m3539RS();
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(74197);
                                imageView2.setImageBitmap(b);
                                AppMethodBeat.m2505o(74197);
                            }
                        });
                    }
                    AppMethodBeat.m2505o(74198);
                }
            });
            AppMethodBeat.m2505o(74213);
            return;
        }
        imageView.setImageBitmap(a);
        AppMethodBeat.m2505o(74213);
    }

    /* renamed from: b */
    private static void m85282b(final C27966g c27966g, final aar aar, final boolean z) {
        AppMethodBeat.m2504i(74214);
        final String b = C39037b.m66370b(aar);
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(74199);
                if (z || C45939l.m85284cW(b)) {
                    C39037b.m66360a(c27966g, aar, z);
                }
                AppMethodBeat.m2505o(74199);
            }

            public final String toString() {
                AppMethodBeat.m2504i(74200);
                String str = super.toString() + "|reDownload";
                AppMethodBeat.m2505o(74200);
                return str;
            }
        });
        AppMethodBeat.m2505o(74214);
    }

    /* renamed from: b */
    public static void m85281b(C27966g c27966g, aar aar) {
        AppMethodBeat.m2504i(74215);
        C45939l.m85282b(c27966g, aar, true);
        AppMethodBeat.m2505o(74215);
    }

    /* renamed from: a */
    public final void mo73787a(ImageView imageView, final aar aar, final C27966g c27966g, String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(74204);
        String LA = C39037b.m66336LA(aar.mnd);
        String[] strArr = null;
        if (aar.mnd != null) {
            String[] strArr2 = (String[]) this.mko.get(LA);
            if (strArr2 == null) {
                strArr = new String[]{C39037b.m66379c(aar)};
                this.mko.put(LA, strArr);
            } else {
                strArr = strArr2;
            }
        }
        this.mkm.mo9922a(imageView, strArr, str, i, i2, i3);
        if (strArr == null || strArr.length <= 0) {
            AppMethodBeat.m2505o(74204);
            return;
        }
        final String str2 = strArr[0];
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(74187);
                if (C45939l.m85284cW(str2)) {
                    C39037b.m66359a(c27966g, aar);
                }
                AppMethodBeat.m2505o(74187);
            }

            public final String toString() {
                AppMethodBeat.m2504i(74188);
                String str = super.toString() + "|mAttachThumb";
                AppMethodBeat.m2505o(74188);
                return str;
            }
        });
        AppMethodBeat.m2505o(74204);
    }

    /* renamed from: cW */
    static /* synthetic */ boolean m85284cW(String str) {
        AppMethodBeat.m2504i(74216);
        if (!new C5728b(str).exists()) {
            C1446a c1446a = (C1446a) mkp.get(str);
            if (c1446a == null) {
                mkp.put(str, new C1446a());
                AppMethodBeat.m2505o(74216);
                return true;
            } else if (c1446a.mo4908Mr() > 30000) {
                C4990ab.m7418v("MicroMsg.FavoriteImageLogic", "error diff time");
                c1446a.evE = SystemClock.elapsedRealtime();
                AppMethodBeat.m2505o(74216);
                return true;
            }
        }
        AppMethodBeat.m2505o(74216);
        return false;
    }
}
