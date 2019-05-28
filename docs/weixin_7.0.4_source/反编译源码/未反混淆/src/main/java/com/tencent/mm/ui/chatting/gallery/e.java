package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.f;
import com.tencent.mm.at.k;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.graphics.a.b;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.chatting.al;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.wxmm.v2helper;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public final class e extends a implements com.tencent.mm.at.d.a, com.tencent.mm.ui.chatting.gallery.f.a {
    private static boolean yVd = true;
    private static long yVf = ((long) (((double) Runtime.getRuntime().maxMemory()) * 0.05d));
    public HashMap<Long, Integer> jNM = new HashMap();
    int mScrollState = 0;
    private HashMap<String, WeakReference<Bitmap>> usl = new HashMap();
    private c yUZ;
    public final f yVa = new f(this);
    private HashMap<bi, String> yVb = new HashMap();
    private HashMap<bi, String> yVc = new HashMap();
    private b yVe = new b();
    private long yVg = 0;

    static class a {
        private static HashMap<String, a> yVm = new HashMap();
        private long cmn = 0;
        private int frO;
        private int height;
        private int width;
        private int yVj = 0;
        private String yVk = "";
        private int yVl = 0;

        private a() {
        }

        static {
            AppMethodBeat.i(32091);
            AppMethodBeat.o(32091);
        }

        public static void eD(String str, int i) {
            AppMethodBeat.i(32089);
            try {
                if (bo.isNullOrNil(str) || i == 0) {
                    AppMethodBeat.o(32089);
                    return;
                }
                a aVar = (a) yVm.get(str);
                if (aVar != null) {
                    aVar.frO = i;
                }
                HashSet<String> hashSet = new HashSet();
                for (String str2 : yVm.keySet()) {
                    a aVar2 = (a) yVm.get(str2);
                    if (aVar2 != null) {
                        ab.i("MicroMsg.ImageGalleryHolderImage", "dkprog report: diff:%d [%d,%d,%d] succ:%d change:%d str:%s file:%s", Long.valueOf(bo.gb(aVar2.cmn)), Integer.valueOf(aVar2.frO), Integer.valueOf(aVar2.width), Integer.valueOf(aVar2.height), Integer.valueOf(aVar2.yVj), Integer.valueOf(aVar2.yVl), aVar2.yVk, str2);
                        if (bo.gb(aVar2.cmn) >= 60000) {
                            if (aVar2.frO > 0 && !bo.isNullOrNil(aVar2.yVk)) {
                                h.pYm.e(11713, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aVar2.frO), Integer.valueOf(aVar2.width), Integer.valueOf(aVar2.height), Integer.valueOf(aVar2.yVj), Integer.valueOf(aVar2.yVl), aVar2.yVk);
                            }
                            hashSet.add(str2);
                        }
                    }
                }
                for (String str22 : hashSet) {
                    yVm.remove(str22);
                }
                AppMethodBeat.o(32089);
            } catch (Throwable th) {
                ab.e("MicroMsg.ImageGalleryHolderImage", "get useopt  setTotalLen :%s", bo.l(th));
                AppMethodBeat.o(32089);
            }
        }

        public static void p(String str, int i, int i2, int i3) {
            AppMethodBeat.i(32090);
            try {
                if (bo.isNullOrNil(str) || i == 0 || i2 == 0) {
                    AppMethodBeat.o(32090);
                    return;
                }
                a aVar = (a) yVm.get(str);
                if (aVar == null) {
                    aVar = new a();
                    aVar.cmn = bo.anU();
                    yVm.put(str, aVar);
                }
                aVar.height = i2;
                aVar.width = i;
                aVar.yVk += i3 + "|";
                if (i3 > 0) {
                    if (aVar.yVj == 0) {
                        aVar.yVj = i3;
                    }
                } else if (aVar.yVj != 0) {
                    aVar.yVl++;
                    aVar.yVj = 0;
                }
                ab.i("MicroMsg.ImageGalleryHolderImage", "dkprog addBit: [%d,%d,%d] succ:%d change:%d str:%s file:%s", Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(aVar.yVj), Integer.valueOf(aVar.yVl), aVar.yVk, str);
                AppMethodBeat.o(32090);
            } catch (Throwable th) {
                ab.e("MicroMsg.ImageGalleryHolderImage", "get useopt  addBit :%s", bo.l(th));
                AppMethodBeat.o(32090);
            }
        }
    }

    static /* synthetic */ void a(k kVar) {
        AppMethodBeat.i(32132);
        a(kVar, true, false);
        AppMethodBeat.o(32132);
    }

    public e(c cVar) {
        super(cVar);
        AppMethodBeat.i(32092);
        com.tencent.mm.sdk.b.a aVar = com.tencent.mm.sdk.b.a.xxA;
        al alVar = new al(com.tencent.mm.ui.chatting.al.a.IMAGE_GALLERY_UI, cVar.yTI);
        this.yUZ = alVar;
        aVar.c(alVar);
        this.yVa.aW(com.tencent.mm.ui.chatting.gallery.g.a.yVD.mQK.snapshot());
        l.dGI().yXN = this;
        AppMethodBeat.o(32092);
    }

    public final void detach() {
        AppMethodBeat.i(32093);
        super.detach();
        com.tencent.mm.sdk.b.a.xxA.d(this.yUZ);
        if (this.usl != null) {
            for (Object obj : this.usl.keySet()) {
                Bitmap bitmap = (Bitmap) ((WeakReference) this.usl.get(obj)).get();
                if (!(bitmap == null || bitmap.isRecycled())) {
                    ab.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
            }
        }
        f fVar = this.yVa;
        fVar.yVo = null;
        fVar.mQG.clear();
        fVar.mQJ.clear();
        fVar.mQI.clear();
        fVar.mQH.clear();
        fVar.yVn.clear();
        fVar.bCH();
        if (!(fVar.yVt == null || fVar.yVt.isRecycled())) {
            ab.i("MicroMsg.ImageGalleryLazyLoader", "bitmap recycle %s", fVar.yVt.toString());
            fVar.yVt.recycle();
            fVar.yVt = null;
        }
        o.ahm().a((com.tencent.mm.at.d.a) this);
        l dGI = l.dGI();
        if (equals(dGI.yXN)) {
            dGI.yXN = null;
        }
        AppMethodBeat.o(32093);
    }

    public final int bA(bi biVar) {
        AppMethodBeat.i(32094);
        if (biVar == null || !this.jNM.containsKey(Long.valueOf(biVar.field_msgId))) {
            AppMethodBeat.o(32094);
            return 0;
        }
        int intValue = ((Integer) this.jNM.get(Long.valueOf(biVar.field_msgId))).intValue();
        AppMethodBeat.o(32094);
        return intValue;
    }

    private void h(bi biVar, int i) {
        AppMethodBeat.i(32095);
        this.jNM.put(Long.valueOf(biVar.field_msgId), Integer.valueOf(i));
        AppMethodBeat.o(32095);
    }

    private void l(long j, int i) {
        AppMethodBeat.i(32096);
        this.jNM.put(Long.valueOf(j), Integer.valueOf(i));
        AppMethodBeat.o(32096);
    }

    public final boolean a(k kVar, bi biVar, int i) {
        AppMethodBeat.i(32097);
        super.a(kVar, biVar, i);
        if (kVar == null || biVar == null || i < 0) {
            AppMethodBeat.o(32097);
            return false;
        }
        int bA = bA(biVar);
        ab.i("MicroMsg.ImageGalleryHolderImage", "filling image : %s position : %s currentState : %s", Integer.valueOf(kVar.yXB.hashCode()), Integer.valueOf(i), Integer.valueOf(bA));
        k.am(kVar.yXs, 8);
        com.tencent.mm.at.e f = f(biVar, false);
        if (f == null) {
            AppMethodBeat.o(32097);
            return false;
        }
        switch (bA) {
            case 0:
                boolean dtH;
                ab.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloadOrSucc");
                ab.i("MicroMsg.ImageGalleryHolderImage", "deal LoadFail");
                if (biVar.field_isSend == 1) {
                    dtH = biVar.dtH();
                } else if (biVar.dtH()) {
                    dtH = true;
                } else {
                    String d = d(biVar, f);
                    if (!f.agP() || (d != null && com.tencent.mm.vfs.e.ct(d))) {
                        Object obj;
                        if (System.currentTimeMillis() - biVar.field_createTime <= 259200000 || (!bo.isNullOrNil(d) && com.tencent.mm.vfs.e.ct(d))) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj != null) {
                            dtH = true;
                        } else {
                            dtH = false;
                        }
                    } else {
                        dtH = true;
                    }
                }
                if (!dtH) {
                    if (a(kVar, biVar, f, i)) {
                        boolean z = false;
                        com.tencent.mm.at.e w = o.ahl().w(biVar);
                        ab.d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc temp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", Long.valueOf(w.fDy), Long.valueOf(w.fDH), Long.valueOf(w.cKK), Integer.valueOf(w.fDJ), Integer.valueOf(w.frO));
                        if (w != null) {
                            if (bo.gW(w.fDJ, 0)) {
                                bA = w.frO;
                            } else {
                                ab.d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc hdTemp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", Long.valueOf(w.fDy), Long.valueOf(w.fDH), Long.valueOf(w.cKK), Integer.valueOf(w.fDJ), Integer.valueOf(o.ahl().ly(w.fDJ).frO));
                                bA = w.frO;
                            }
                            int asZ = (int) com.tencent.mm.vfs.e.asZ(o.ahl().q(f.fDz, "", ""));
                            if (biVar.field_isSend == 1 && bo.gW(bA, asZ)) {
                                z = true;
                            }
                            ab.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc() sizeInDb:%s oriSize:%s noNeedDownLoad:%s", Integer.valueOf(bA), Integer.valueOf(asZ), Boolean.valueOf(z));
                        } else {
                            ab.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc() temp == null");
                        }
                        if (z || f.agP()) {
                            h(biVar, 4);
                            break;
                        }
                        h(biVar, 1);
                    } else {
                        ab.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc dealSucc() == false");
                        h(biVar, 2);
                    }
                    y.C(biVar);
                    bA = o.ahm().a(f.fDy, biVar.field_msgId, 0, Integer.valueOf(i), R.drawable.b0p, this, 0, true);
                    if (this.yTG != null) {
                        this.yTG.g(biVar, false);
                    }
                    ab.i("MicroMsg.ImageGalleryHolderImage", "put image download task downloadCode [%d].", Integer.valueOf(bA));
                    if (bA != -2) {
                        a(kVar, biVar, f, false, i);
                        break;
                    }
                    ab.w("MicroMsg.ImageGalleryHolderImage", "it is already download image finish, but imgInfo is old, search db and repair.");
                    com.tencent.mm.at.e f2 = f(biVar, true);
                    if (f2 != null) {
                        if (!a(kVar, biVar, f2, i)) {
                            h(biVar, 2);
                        } else if (biVar.field_isSend == 1 || f2.agP()) {
                            h(biVar, 4);
                            break;
                        } else {
                            h(biVar, 1);
                        }
                        ab.w("MicroMsg.ImageGalleryHolderImage", "it repair fail show thumb image.ImgInfo[%d, %b]", Long.valueOf(f2.fDy), Boolean.valueOf(f2.agP()));
                        a(kVar, biVar, f2, false, i);
                        break;
                    }
                    ab.w("MicroMsg.ImageGalleryHolderImage", "get imgInfo by db but it is null.");
                    break;
                }
                h(biVar, 5);
                a(biVar, kVar, 5);
                break;
                break;
            case 1:
            case 4:
                a(kVar, biVar, f, i);
                break;
            case 2:
                a(kVar, biVar, f, false, i);
                break;
            case 3:
                a(kVar, biVar, f, true, i);
                break;
            case 5:
            case 6:
                a(biVar, kVar, bA);
                kVar.mRR.invalidate();
                break;
        }
        AppMethodBeat.o(32097);
        return true;
    }

    /* JADX WARNING: Missing block: B:6:0x0025, code skipped:
            if (r0.fDy == 0) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.at.e d(bi biVar) {
        AppMethodBeat.i(32098);
        if (c.c(biVar)) {
            com.tencent.mm.at.e fJ;
            if (biVar.field_isSend == 1) {
                fJ = o.ahl().fJ(biVar.field_msgId);
            }
            fJ = o.ahl().fI(biVar.field_msgSvrId);
            AppMethodBeat.o(32098);
            return fJ;
        }
        AppMethodBeat.o(32098);
        return null;
    }

    /* JADX WARNING: Missing block: B:21:0x0073, code skipped:
            if (r2.fDy == 0) goto L_0x0075;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.at.e f(bi biVar, boolean z) {
        com.tencent.mm.at.e eVar = null;
        AppMethodBeat.i(32099);
        if (!c.c(biVar)) {
            AppMethodBeat.o(32099);
        } else if (this.yTG == null || this.yTG.yTJ == null) {
            ab.e("MicroMsg.ImageGalleryHolderImage", "adapter is null!!");
            AppMethodBeat.o(32099);
        } else {
            if (!z) {
                if (biVar.field_isSend == 1) {
                    eVar = (com.tencent.mm.at.e) this.yTG.yTJ.yUg.get(Long.valueOf(biVar.field_msgId));
                }
                if (eVar == null && biVar.field_msgSvrId > 0) {
                    eVar = (com.tencent.mm.at.e) this.yTG.yTJ.yUf.get(Long.valueOf(biVar.field_msgSvrId));
                }
            }
            if (eVar == null) {
                long j;
                boolean z2 = false;
                if (biVar.field_isSend == 1) {
                    j = biVar.field_msgId;
                    eVar = o.ahl().fJ(j);
                }
                j = biVar.field_msgSvrId;
                eVar = o.ahl().fI(j);
                z2 = true;
                this.yTG.yTJ.a(j, eVar, z2);
            }
            AppMethodBeat.o(32099);
        }
        return eVar;
    }

    private String d(bi biVar, com.tencent.mm.at.e eVar) {
        AppMethodBeat.i(32100);
        String str = (String) this.yVb.get(biVar);
        if (str == null) {
            str = a(biVar, eVar, false);
            if (str == null || str.length() == 0) {
                AppMethodBeat.o(32100);
                return null;
            }
            this.yVb.put(biVar, str);
        }
        AppMethodBeat.o(32100);
        return str;
    }

    private boolean a(k kVar, bi biVar, com.tencent.mm.at.e eVar, int i) {
        AppMethodBeat.i(32101);
        ab.i("MicroMsg.ImageGalleryHolderImage", "edw dealSucc");
        String d = d(biVar, eVar);
        k.am(kVar.yXx, 8);
        String str = (String) this.yVc.get(biVar);
        if (str == null) {
            str = o.ahl().I(biVar.field_imgPath, true);
            this.yVc.put(biVar, str);
        }
        boolean a = a(kVar, str, d, biVar);
        if (i == this.yTG.yTI.getCurrentItem() && this.yTG.yTM) {
            this.yTG.bw(biVar);
            this.yTG.yTM = false;
        }
        AppMethodBeat.o(32101);
        return a;
    }

    private void a(k kVar, bi biVar, com.tencent.mm.at.e eVar, boolean z, int i) {
        AppMethodBeat.i(32102);
        a(kVar, biVar, eVar, z, true, i);
        AppMethodBeat.o(32102);
    }

    private void a(k kVar, bi biVar, com.tencent.mm.at.e eVar, boolean z, boolean z2, int i) {
        AppMethodBeat.i(32103);
        ab.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloading, isHd = ".concat(String.valueOf(z)));
        k.am(kVar.yXy, 8);
        String str = null;
        if (!z) {
            kVar.yXB.setVisibility(0);
        }
        com.tencent.mm.at.e a = f.a(eVar);
        if (z && i == this.yTG.yTI.getCurrentItem()) {
            this.yTG.yTI.dGv();
        }
        if (z) {
            str = a(biVar, eVar, true);
        }
        if (bo.isNullOrNil(str)) {
            str = o.ahl().q(a.fDB, "", "");
        }
        String I = o.ahl().I(biVar.field_imgPath, true);
        if (z2) {
            a(kVar, I, str, biVar);
        }
        if (!z) {
            int i2 = eVar.frO;
            if (Math.max(1, (int) (i2 != 0 ? ((((long) eVar.offset) * 100) / ((long) i2)) - 1 : 0)) > 50) {
                kVar.dGE().yXx.setVisibility(8);
            } else {
                kVar.dGE().yXx.setVisibility(0);
            }
        }
        kVar.dGE().yXv.setVisibility(8);
        kVar.dGE().yXu.setVisibility(8);
        kVar.dGE().yXt.setVisibility(8);
        AppMethodBeat.o(32103);
    }

    private static void a(bi biVar, k kVar, int i) {
        AppMethodBeat.i(32104);
        ab.i("MicroMsg.ImageGalleryHolderImage", "edw dealFail", new Object[0]);
        String I = o.ahl().I(biVar.field_imgPath, true);
        k.am(kVar.yXx, 8);
        k.am(kVar.yXs, 8);
        k.am(kVar.yXB, 8);
        k.am(kVar.yXC, 8);
        k.am(kVar.yXD, 8);
        kVar.dGF().yXy.setVisibility(0);
        kVar.dGF().yXA.setImageResource(R.raw.image_download_fail_icon);
        if (I == null || !com.tencent.mm.vfs.e.ct(I)) {
            kVar.dGF().yXz.setText(R.string.cdj);
            AppMethodBeat.o(32104);
        } else if (i == 6) {
            kVar.dGF().yXz.setText(R.string.cdh);
            AppMethodBeat.o(32104);
        } else if (biVar.dtH()) {
            kVar.dGF().yXz.setText(R.string.cdf);
            AppMethodBeat.o(32104);
        } else {
            kVar.dGF().yXz.setText(R.string.cdg);
            AppMethodBeat.o(32104);
        }
    }

    private boolean a(k kVar, String str, String str2, bi biVar) {
        AppMethodBeat.i(32105);
        boolean b = b(kVar, str, str2, biVar);
        AppMethodBeat.o(32105);
        return b;
    }

    private boolean b(k kVar, String str, String str2, bi biVar) {
        AppMethodBeat.i(32106);
        k.am(kVar.yXB, 0);
        k.am(kVar.yXs, 8);
        k.am(kVar.yXx, 8);
        k.am(kVar.yXy, 8);
        boolean a = a(kVar.yXB, str, str2, kVar.mPosition, biVar, kVar);
        AppMethodBeat.o(32106);
        return a;
    }

    protected static Options arv(String str) {
        AppMethodBeat.i(32107);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        if (decodeFile != null) {
            decodeFile.recycle();
        }
        AppMethodBeat.o(32107);
        return options;
    }

    static {
        AppMethodBeat.i(32135);
        AppMethodBeat.o(32135);
    }

    public static void dFV() {
        yVd = false;
    }

    private boolean a(MultiTouchImageView multiTouchImageView, String str, String str2, int i, bi biVar, k kVar) {
        AppMethodBeat.i(32109);
        boolean a = a(true, multiTouchImageView, str, str2, false, i, biVar, kVar, null, false);
        AppMethodBeat.o(32109);
        return a;
    }

    private boolean a(boolean z, MultiTouchImageView multiTouchImageView, String str, String str2, boolean z2, int i, bi biVar, k kVar, com.tencent.mm.at.e eVar, boolean z3) {
        AppMethodBeat.i(32110);
        ab.i("MicroMsg.ImageGalleryHolderImage", "initImageView image : %s bigImgPath %s position : %s", Integer.valueOf(multiTouchImageView.hashCode()), str2, Integer.valueOf(i));
        String str3 = null;
        boolean z4 = true;
        if (str2 == null || !com.tencent.mm.vfs.e.ct(str2)) {
            z4 = false;
        } else {
            str3 = str2;
        }
        if (str3 == null && str != null && com.tencent.mm.vfs.e.ct(str)) {
            if (com.tencent.mm.vfs.e.ct(str + "hd")) {
                str3 = str + "hd";
            } else {
                str3 = str;
            }
        }
        if (str3 == null) {
            ab.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, file does not exist, filePath %s", str2);
            AppMethodBeat.o(32110);
            return false;
        } else if (kVar == null) {
            ab.e("MicroMsg.ImageGalleryHolderImage", "alvinluo initImageView holder is null");
            AppMethodBeat.o(32110);
            return false;
        } else {
            boolean z5;
            Bitmap bitmap;
            String e;
            boolean z6 = (str3.equals(str) || z3 || !arw(str3)) ? false : true;
            ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt result: %b, path: %s", Boolean.valueOf(z6), str3);
            Object obj = (kVar.yXC == null || kVar.yXC.getVisibility() != 0) ? null : 1;
            if (z6 && obj == null) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (!(z6 || z2 || !this.yVa.mQK.aj(str3))) {
                bitmap = (Bitmap) this.yVa.mQK.ai(str3);
                if (!bitmap.isRecycled()) {
                    ab.i("MicroMsg.ImageGalleryHolderImage", "use cache, fillBitmap path : %s", str3);
                    b(multiTouchImageView, bitmap);
                    AppMethodBeat.o(32110);
                    return true;
                }
            }
            if (z) {
                multiTouchImageView.setImageBitmap(null);
            }
            if (z6) {
                if (kVar.yXC == null) {
                    AppMethodBeat.o(32110);
                    return false;
                }
                if (eVar == null) {
                    eVar = f(biVar, true);
                }
                final int i2 = i;
                final k kVar2 = kVar;
                final bi biVar2 = biVar;
                kVar.yXC.setOnImageLoadEventListener(new b() {
                    public final void oL() {
                        AppMethodBeat.i(32083);
                        ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo SubsamplingImageView onPreviewLoaded");
                        AppMethodBeat.o(32083);
                    }

                    public final void l(Bitmap bitmap) {
                        AppMethodBeat.i(32084);
                        if (!(bitmap == null || e.this.yVa == null)) {
                            ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo onImageLoaded cache bitmap, cacheImagePath: %s", str3);
                            e.this.yVa.c(i2 > 0 ? i2 : kVar2.mPosition, bitmap);
                        }
                        e.a(kVar2);
                        AppMethodBeat.o(32084);
                    }

                    public final void a(com.davemorrissey.labs.subscaleview.a.c cVar) {
                        AppMethodBeat.i(32085);
                        ab.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onPreviewLoadError errCode: %d, errMsg: %s", Integer.valueOf(cVar.errCode), cVar.aIm);
                        AppMethodBeat.o(32085);
                    }

                    public final void b(com.davemorrissey.labs.subscaleview.a.c cVar) {
                        AppMethodBeat.i(32086);
                        ab.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onImageLoadError errCode: %d, errMsg: %s", Integer.valueOf(cVar.errCode), cVar.aIm);
                        int i = cVar.errCode;
                        ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo reportLoadError errCode: %d", Integer.valueOf(i));
                        if (i == 4) {
                            h.pYm.k(896, 2, 1);
                        } else if (i == 5) {
                            h.pYm.k(896, 3, 1);
                        }
                        e.a(e.this, str3, kVar2, i2);
                        if (cVar.errCode == 4) {
                            e.dFV();
                        }
                        AppMethodBeat.o(32086);
                    }

                    public final void c(com.davemorrissey.labs.subscaleview.a.c cVar) {
                        AppMethodBeat.i(32087);
                        ab.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onTileLoadError errCode: %d, errMsg: %s", Integer.valueOf(cVar.errCode), cVar.aIm);
                        e.a(biVar2, kVar2);
                        AppMethodBeat.o(32087);
                    }

                    public final void oM() {
                    }
                });
            }
            if (this.yTG.yTS) {
                if (z6) {
                    e = e(biVar, eVar);
                    a(kVar, true, z5);
                    a(kVar.yXC, str3, e != null ? com.davemorrissey.labs.subscaleview.view.a.af(e) : null);
                    AppMethodBeat.o(32110);
                    return z4;
                }
                bitmap = arx(str3);
                if (bitmap == null) {
                    bitmap = arx(str);
                }
                if (bitmap != null) {
                    a(kVar, false, true);
                    b((View) multiTouchImageView, bitmap);
                    if (str3.equals(str2)) {
                        this.yVa.u(str3, bitmap);
                        this.yVa.c(i, bitmap);
                    }
                    AppMethodBeat.o(32110);
                    return z4;
                }
            } else if (i >= 0) {
                ab.d("MicroMsg.ImageGalleryHolderImage", "alvinluo loadThumb postion: %d", Integer.valueOf(i));
                a(kVar, false, true);
                this.yVa.c((ImageView) multiTouchImageView, i);
            }
            if (z6) {
                a(kVar, true, z5);
                e = e(biVar, eVar);
                f fVar = this.yVa;
                WxImageView wxImageView = kVar.yXC;
                if (i < 0) {
                    i = kVar.mPosition;
                }
                fVar.b(wxImageView, str3, e, i);
            } else {
                a(kVar, false, true);
                f fVar2 = this.yVa;
                if (i < 0) {
                    i = kVar.mPosition;
                }
                fVar2.g(multiTouchImageView, str3, i);
            }
            AppMethodBeat.o(32110);
            return z4;
        }
    }

    private static void a(k kVar, boolean z, boolean z2) {
        int i = 8;
        AppMethodBeat.i(32111);
        if (kVar != null) {
            if (kVar.yXC != null) {
                kVar.yXC.setVisibility(z ? 0 : 8);
                if (z) {
                    kVar.yXE = true;
                } else {
                    kVar.yXE = false;
                }
            }
            if (kVar.yXB != null) {
                MultiTouchImageView multiTouchImageView = kVar.yXB;
                if (z2) {
                    i = 0;
                }
                multiTouchImageView.setVisibility(i);
                if (z2) {
                    kVar.yXE = false;
                }
            }
        }
        AppMethodBeat.o(32111);
    }

    public final void b(View view, Bitmap bitmap) {
        AppMethodBeat.i(32112);
        if (bitmap == null) {
            AppMethodBeat.o(32112);
            return;
        }
        if (view != null) {
            int hashCode = view.hashCode();
            int hashCode2 = bitmap.hashCode();
            int indexOfValue = this.yVa.mQL.indexOfValue(hashCode);
            if (indexOfValue >= 0) {
                this.yVa.mQL.removeAt(indexOfValue);
            }
            this.yVa.mQL.put(hashCode2, hashCode);
            if (view instanceof MultiTouchImageView) {
                b((MultiTouchImageView) view, bitmap);
                AppMethodBeat.o(32112);
                return;
            } else if (view instanceof ImageView) {
                ((ImageView) view).setImageBitmap(bitmap);
            }
        }
        AppMethodBeat.o(32112);
    }

    public final Bitmap loadImage(String str) {
        AppMethodBeat.i(139027);
        Bitmap arx = arx(str);
        AppMethodBeat.o(139027);
        return arx;
    }

    public final void a(WxImageView wxImageView, String str, com.davemorrissey.labs.subscaleview.view.a aVar) {
        AppMethodBeat.i(32114);
        Options arv = arv(str);
        wxImageView.setOrientation(ExifHelper.bJ(str));
        wxImageView.bW(arv.outWidth, arv.outHeight);
        wxImageView.dzA();
        wxImageView.a(str, aVar);
        AppMethodBeat.o(32114);
    }

    private static Bitmap aw(String str, int i, int i2) {
        Throwable th;
        AppMethodBeat.i(32115);
        String str2 = str + "_tmp.jpg";
        Bitmap decodeAsBitmap;
        try {
            if (d.fP(16)) {
                AppMethodBeat.o(32115);
                return null;
            }
            boolean z;
            if (!com.tencent.mm.sdk.a.b.dnO()) {
                int i3 = bo.getInt(g.Nu().getValue("UseOptImageRecv"), 0);
                aw.ZK();
                ab.i("MicroMsg.ImageGalleryHolderImage", "fromPathToImgInfo opt:%d uin:(%d,%d) debug:%b sdk:%d", Integer.valueOf(i3), Long.valueOf(r1.longValue()), Long.valueOf(new p(com.tencent.mm.model.c.QF()).longValue() / 100), Boolean.valueOf(com.tencent.mm.sdk.a.b.dnO()), Integer.valueOf(VERSION.SDK_INT));
                if ((((int) (new p(com.tencent.mm.model.c.QF()).longValue() / 100)) % 100) + 1 > i3) {
                    AppMethodBeat.o(32115);
                    return null;
                }
            }
            com.tencent.mm.vfs.e.tf(com.tencent.mm.vfs.e.atb(str2));
            com.tencent.mm.vfs.e.y(str, str2);
            boolean IsJpegFile = MMNativeJpeg.IsJpegFile(str2);
            boolean isProgressive = MMNativeJpeg.isProgressive(str2);
            if (bo.isNullOrNil(str2) || !new File(str2).exists()) {
                z = false;
            } else {
                z = MMJpegOptim.checkIntegrity(str2);
            }
            int asZ = (int) com.tencent.mm.vfs.e.asZ(str2);
            if (IsJpegFile && isProgressive) {
                if (z) {
                    decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(str2);
                } else {
                    decodeAsBitmap = null;
                }
                try {
                    a.p(str, i2, i, decodeAsBitmap != null ? asZ : 0 - asZ);
                } catch (Throwable th2) {
                    th = th2;
                    ab.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", str, bo.l(th));
                    com.tencent.mm.vfs.e.deleteFile(str2);
                    AppMethodBeat.o(32115);
                    return decodeAsBitmap;
                }
            }
            decodeAsBitmap = null;
            ab.i("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt jpeg:%b isprog:%b inte:%b len:%d [%d,%d] bm:%s path:%s", Boolean.valueOf(IsJpegFile), Boolean.valueOf(isProgressive), Boolean.valueOf(z), Integer.valueOf(asZ), Integer.valueOf(i2), Integer.valueOf(i), decodeAsBitmap, str);
            com.tencent.mm.vfs.e.deleteFile(str2);
            AppMethodBeat.o(32115);
            return decodeAsBitmap;
        } catch (Exception e) {
            ab.e("MicroMsg.ImageGalleryHolderImage", "get useopt :%s", bo.l(e));
            AppMethodBeat.o(32115);
            return null;
        } catch (Throwable th3) {
            th = th3;
            decodeAsBitmap = null;
        }
    }

    private static Bitmap arx(String str) {
        AppMethodBeat.i(32116);
        if (str == null) {
            AppMethodBeat.o(32116);
            return null;
        }
        Bitmap aw;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        if (decodeFile != null) {
            ab.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", decodeFile.toString());
            decodeFile.recycle();
        }
        int bJ = ExifHelper.bJ(str);
        int i = options.outWidth;
        int i2 = options.outHeight;
        try {
            long max = Math.max((Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory()) - yVf, 0);
            long j = (long) ((options.outWidth * options.outHeight) * 4);
            ab.i("MicroMsg.ImageGalleryHolderImage", "hy: current free memory: %d, previewDecodedBmLength: %d", Long.valueOf(max), Long.valueOf(j));
            if (max < j) {
                double sqrt = Math.sqrt(((double) max) / ((double) j));
                ab.v("MicroMsg.ImageGalleryHolderImage", "hy: sample is %f", Double.valueOf(sqrt));
                i = (int) (((double) i) * sqrt);
                i2 = (int) (((double) i2) * sqrt);
            }
            aw = aw(str, i2, i);
            if (aw == null) {
                aw = com.tencent.mm.sdk.platformtools.d.a(str, i, i2, 0.0f);
            }
            if (aw == null && MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                aw = MMNativeJpeg.decodeAsBitmap(str);
                String str2 = "MicroMsg.ImageGalleryHolderImage";
                String str3 = "Progressive jpeg, result isNull:%b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(aw == null);
                ab.i(str2, str3, objArr);
            }
            decodeFile = aw;
        } catch (OutOfMemoryError e) {
            ab.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", e, "hy: out of memory! try use fallback bitmap", new Object[0]);
            decodeFile = c(str, i, i2, getScreenWidth(ah.getContext()), getScreenHeight(ah.getContext()));
        }
        if (decodeFile == null) {
            ab.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
            AppMethodBeat.o(32116);
            return null;
        }
        aw = com.tencent.mm.sdk.platformtools.d.b(decodeFile, (float) bJ);
        if (aw != decodeFile || bJ % v2helper.VOIP_ENC_HEIGHT_LV1 == 0) {
            AppMethodBeat.o(32116);
            return aw;
        }
        ab.e("MicroMsg.ImageGalleryHolderImage", "rotate failed degree:%d", Integer.valueOf(bJ));
        AppMethodBeat.o(32116);
        return null;
    }

    private static Bitmap c(String str, int i, int i2, int i3, int i4) {
        Bitmap bitmap = null;
        AppMethodBeat.i(32117);
        ab.e("MicroMsg.ImageGalleryHolderImage", "hy: enter fallback bitmap logic");
        ab.i("MicroMsg.ImageGalleryHolderImage", "hy: oriImgPixelRate %d, displayPixelRate %d", Integer.valueOf(i * i2), Integer.valueOf(i3 * i4));
        if (i * i2 > i3 * i4) {
            try {
                bitmap = com.tencent.mm.sdk.platformtools.d.a(str, i3, i4, 0.0f);
                AppMethodBeat.o(32117);
            } catch (OutOfMemoryError e) {
                ab.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", e, "hy: oom in fallback bitmap!", new Object[0]);
                AppMethodBeat.o(32117);
            }
        } else {
            ab.e("MicroMsg.ImageGalleryHolderImage", "hy: the picture is even smaller the screen! display nothing");
            AppMethodBeat.o(32117);
        }
        return bitmap;
    }

    private static int getScreenWidth(Context context) {
        AppMethodBeat.i(32118);
        if (context == null) {
            AppMethodBeat.o(32118);
            return 0;
        }
        int i = context.getResources().getDisplayMetrics().widthPixels;
        AppMethodBeat.o(32118);
        return i;
    }

    private static int getScreenHeight(Context context) {
        AppMethodBeat.i(32119);
        if (context == null) {
            AppMethodBeat.o(32119);
            return 0;
        }
        int i = context.getResources().getDisplayMetrics().heightPixels;
        AppMethodBeat.o(32119);
        return i;
    }

    public static String a(bi biVar, com.tencent.mm.at.e eVar) {
        AppMethodBeat.i(32120);
        String a = a(biVar, eVar, false);
        AppMethodBeat.o(32120);
        return a;
    }

    private static String e(bi biVar, com.tencent.mm.at.e eVar) {
        AppMethodBeat.i(32122);
        String str;
        String str2;
        if (biVar == null || eVar == null) {
            AppMethodBeat.o(32122);
            return null;
        } else if (biVar.field_isSend == 1) {
            str = eVar.fDB;
            str2 = o.ahl().q(str, "", "") + "hd";
            ab.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", str, str2);
            if (bo.isNullOrNil(str2) || !com.tencent.mm.vfs.e.ct(str2)) {
                str2 = o.ahl().q(str, "", "");
                ab.d("MicroMsg.ImageGalleryHolderImage", "preview fileName: %s, fullPath:%s", str, str2);
                if (bo.isNullOrNil(str2) || !com.tencent.mm.vfs.e.ct(str2)) {
                    AppMethodBeat.o(32122);
                    return null;
                }
                ab.d("MicroMsg.ImageGalleryHolderImage", "preview image exist");
                AppMethodBeat.o(32122);
                return str2;
            }
            ab.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
            AppMethodBeat.o(32122);
            return str2;
        } else if (eVar.agP()) {
            str2 = o.ahl().q(eVar.fDB, "", "") + "hd";
            ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", str, str2);
            if (bo.isNullOrNil(str2) || !com.tencent.mm.vfs.e.ct(str2)) {
                AppMethodBeat.o(32122);
                return null;
            }
            ab.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
            AppMethodBeat.o(32122);
            return str2;
        } else {
            ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo get previewPath img not completed");
            AppMethodBeat.o(32122);
            return null;
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, m mVar) {
        AppMethodBeat.i(32123);
        if (this.yTG == null || this.yTG.yTI == null) {
            AppMethodBeat.o(32123);
        } else if (this.mScrollState != 0) {
            AppMethodBeat.o(32123);
        } else {
            int a;
            Integer valueOf;
            if (l.dGI().nr(j2)) {
                a = a(j2, obj);
                if (a == -1) {
                    AppMethodBeat.o(32123);
                    return;
                }
                valueOf = Integer.valueOf(a);
            } else {
                valueOf = obj;
            }
            if (valueOf instanceof Integer) {
                int intValue = valueOf.intValue();
                ab.i("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos[%d], offset[%d], totalLen[%d], resId[%d], compressType[%d], imgLocalId[%d],", Integer.valueOf(intValue), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(j));
                if (intValue == -1) {
                    ab.e("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos is -1");
                    AppMethodBeat.o(32123);
                    return;
                } else if (this.yTG.Fp(intValue) == null) {
                    AppMethodBeat.o(32123);
                    return;
                } else {
                    k kVar = (k) this.yTG.Fp(intValue).getTag();
                    if (kVar == null) {
                        AppMethodBeat.o(32123);
                        return;
                    }
                    if (intValue == this.yTG.yTI.getCurrentItem() && !OX(i)) {
                        this.yTG.yTI.hG(false);
                    }
                    if (i3 == 0) {
                        a = 0;
                    } else {
                        a = (int) (i4 != 0 ? ((((float) i3) / ((float) i4)) * 100.0f) - 1.0f : 0.0f);
                    }
                    int max = Math.max(1, a);
                    if (intValue == this.yTG.yTI.getCurrentItem() && OX(i)) {
                        ab.i("MicroMsg.ImageGalleryHolderImage", "jacks loading hd from progress : %d, time: %d", Integer.valueOf(max), Long.valueOf(System.currentTimeMillis()));
                        this.yTG.yTI.Pe(max);
                    }
                    k kVar2 = (k) mVar;
                    boolean isProgressive = MMNativeJpeg.isProgressive(kVar2.fFd);
                    boolean z = kVar2.fFf;
                    long az = bo.az(this.yVg);
                    a.eD(kVar2.fFd, i4);
                    ab.i("MicroMsg.ImageGalleryHolderImage", "dkprog onImgTaskProgress getCanShow:%b isProg:%b timeDiff:%d  [%d/%d] %s", Boolean.valueOf(z), Boolean.valueOf(isProgressive), Long.valueOf(az), Integer.valueOf(i3), Integer.valueOf(i4), kVar2.fFd);
                    if (z && isProgressive && az > 1000) {
                        this.yVg = bo.yz();
                        bi Ou = this.yTG.Ou(intValue);
                        com.tencent.mm.at.e f = f(Ou, true);
                        if (a(false, kVar.yXB, o.ahl().I(Ou.field_imgPath, true), a(Ou, f, true), true, -1, Ou, kVar, f, true)) {
                            k.am(kVar.yXv, 8);
                            k.am(kVar.yXy, 8);
                            if (intValue == this.yTG.yTI.getCurrentItem() && !OX(i)) {
                                if (max > 50) {
                                    k.am(kVar.yXx, 8);
                                    if (this.yTG != null) {
                                        this.yTG.a(Ou, f, i, com.tencent.mm.g.b.a.e.a.ok);
                                        AppMethodBeat.o(32123);
                                        return;
                                    }
                                }
                                k.am(kVar.yXx, 0);
                            }
                        }
                    }
                    AppMethodBeat.o(32123);
                    return;
                }
            }
            ab.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
            AppMethodBeat.o(32123);
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, m mVar) {
        AppMethodBeat.i(32124);
        if (this.yTG == null || this.yTG.yTI == null) {
            AppMethodBeat.o(32124);
            return;
        }
        Integer valueOf;
        if (l.dGI().nr(j2)) {
            int a = a(j2, obj);
            if (a == -1) {
                aw.ZK();
                a(com.tencent.mm.model.c.XO().jf(j2), "background", false);
                AppMethodBeat.o(32124);
                return;
            }
            valueOf = Integer.valueOf(a);
        } else {
            valueOf = obj;
        }
        if (valueOf instanceof Integer) {
            final int intValue = valueOf.intValue();
            ab.i("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos = ".concat(String.valueOf(intValue)));
            if (intValue == -1) {
                ab.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos is -1");
                h.pYm.a(111, 3, 1, true);
                AppMethodBeat.o(32124);
                return;
            }
            k kVar = null;
            if (this.yTG.Fp(intValue) != null) {
                kVar = (k) this.yTG.Fp(intValue).getTag();
            }
            boolean nr = l.dGI().nr(j2);
            if (i3 == 0 && i4 == 0) {
                if (nr) {
                    a(this.yTG.Ou(intValue), "hd_suc:".concat(String.valueOf(intValue)), intValue == this.yTG.yTI.getCurrentItem());
                }
                ab.i("MicroMsg.ImageGalleryHolderImage", "pos = " + intValue + ", selectedPos = " + this.yTG.yTI.getCurrentItem(), new Object[0]);
                l(j2, 4);
                bi Ou = this.yTG.Ou(intValue);
                com.tencent.mm.at.e f = f(Ou, true);
                if (Ou == null || f == null) {
                    AppMethodBeat.o(32124);
                    return;
                }
                if (kVar != null) {
                    this.yTG.yTI.hG(true);
                    if (intValue == this.yTG.yTI.getCurrentItem()) {
                        if (OX(i)) {
                            ImageGalleryUI imageGalleryUI = this.yTG.yTI;
                            imageGalleryUI.hG(true);
                            imageGalleryUI.hG(true);
                            Animation Pd = ImageGalleryUI.Pd(1000);
                            Pd.setAnimationListener(new AnimationListener() {
                                public final void onAnimationStart(Animation animation) {
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    AppMethodBeat.i(32216);
                                    if (ImageGalleryUI.P(ImageGalleryUI.this).yVT.getVisibility() != 0) {
                                        AppMethodBeat.o(32216);
                                        return;
                                    }
                                    ImageGalleryUI.this.dGm();
                                    ImageGalleryUI.P(ImageGalleryUI.this).yVQ.setVisibility(8);
                                    ImageGalleryUI.K(ImageGalleryUI.this);
                                    ImageGalleryUI.L(ImageGalleryUI.this);
                                    AppMethodBeat.o(32216);
                                }
                            });
                            imageGalleryUI.dGm();
                            imageGalleryUI.dFY().yVQ.setVisibility(0);
                            imageGalleryUI.dFY().yVR.setVisibility(8);
                            imageGalleryUI.dFY().yVS.setVisibility(8);
                            imageGalleryUI.dFY().yVT.setVisibility(0);
                            imageGalleryUI.dFY().yVT.startAnimation(Pd);
                        } else {
                            kVar.yXB.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(32088);
                                    if (e.this.yTG == null || e.this.yTG.yTI == null) {
                                        AppMethodBeat.o(32088);
                                        return;
                                    }
                                    e.this.yTG.yTI.Pa(intValue);
                                    AppMethodBeat.o(32088);
                                }
                            });
                        }
                    }
                    if (a(false, kVar.yXB, o.ahl().I(Ou.field_imgPath, true), a(Ou, f, true), true, -1, Ou, kVar, f, false)) {
                        k.am(kVar.yXs, 8);
                        k.am(kVar.yXx, 8);
                        k.am(kVar.yXy, 8);
                        if (bA(Ou) == 4 && this.yTG.yTM) {
                            this.yTG.bw(Ou);
                            this.yTG.yTM = false;
                        }
                        if (this.yTG != null) {
                            this.yTG.a(Ou, f, i, com.tencent.mm.g.b.a.e.a.ok);
                            AppMethodBeat.o(32124);
                            return;
                        }
                    }
                    ab.e("MicroMsg.ImageGalleryHolderImage", "failed to show downloaded image!");
                    h.pYm.a(111, 2, 1, true);
                }
                AppMethodBeat.o(32124);
                return;
            }
            if (nr) {
                a(this.yTG.Ou(intValue), "hd_failed:".concat(String.valueOf(intValue)), intValue == this.yTG.yTI.getCurrentItem());
            }
            if (intValue == this.yTG.yTI.getCurrentItem()) {
                this.yTG.yTI.hG(true);
            }
            if (i4 == -5103059) {
                l(j2, 5);
                h.pYm.a(111, 0, 1, true);
            } else {
                l(j2, 6);
                h.pYm.a(111, 1, 1, true);
            }
            ab.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, errType = " + i3 + ", errCode = " + i4);
            this.yTG.yTN.OK(intValue);
            if (this.yTG != null) {
                this.yTG.a(this.yTG.Ou(intValue), null, i, com.tencent.mm.g.b.a.e.a.error);
            }
            AppMethodBeat.o(32124);
            return;
        }
        ab.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        AppMethodBeat.o(32124);
    }

    private int a(long j, Object obj) {
        int intValue;
        AppMethodBeat.i(32125);
        if (obj instanceof Integer) {
            intValue = ((Integer) obj).intValue();
            bi Ou = this.yTG.Ou(intValue);
            if (Ou != null && Ou.field_msgId == j) {
                AppMethodBeat.o(32125);
                return intValue;
            }
        }
        for (Integer intValue2 : this.yTG.yyK.values()) {
            intValue = intValue2.intValue();
            bi Ou2 = this.yTG.Ou(intValue);
            if (Ou2 != null && Ou2.field_msgId == j) {
                AppMethodBeat.o(32125);
                return intValue;
            }
        }
        AppMethodBeat.o(32125);
        return -1;
    }

    private static void a(bi biVar, String str, boolean z) {
        AppMethodBeat.i(32126);
        ab.i("MicroMsg.ImageGalleryHolderImage", "[oreh download_and_save] hdImg end, msgLocalId:%d, %s", Long.valueOf(biVar.field_msgId), str);
        c.b(ah.getContext(), biVar, z);
        AppMethodBeat.o(32126);
    }

    private static boolean OX(int i) {
        return i == 1;
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
        AppMethodBeat.i(32127);
        if (obj instanceof Integer) {
            ab.i("MicroMsg.ImageGalleryHolderImage", "image task canceled at pos ".concat(String.valueOf(((Integer) obj).intValue())), new Object[0]);
            AppMethodBeat.o(32127);
            return;
        }
        ab.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        AppMethodBeat.o(32127);
    }

    public final void aF(int i, boolean z) {
        AppMethodBeat.i(32128);
        ab.i("MicroMsg.ImageGalleryHolderImage", "viewHdImg, pos = ".concat(String.valueOf(i)));
        bi Ou = this.yTG.Ou(i);
        if (Ou == null || Ou.field_msgId == 0) {
            ab.e("MicroMsg.ImageGalleryHolderImage", "msg is null");
            AppMethodBeat.o(32128);
        } else if (c.c(Ou)) {
            com.tencent.mm.at.e f = f(Ou, true);
            if (f == null || f.fDy == 0) {
                ab.e("MicroMsg.ImageGalleryHolderImage", "viewHdImg fail, msgLocalId = " + (Ou == null ? BuildConfig.COMMAND : Long.valueOf(Ou.field_msgId)) + ", imgLocalId = " + (f == null ? BuildConfig.COMMAND : Long.valueOf(f.fDy)));
                AppMethodBeat.o(32128);
                return;
            }
            h(Ou, 3);
            if (OJ(i) != null) {
                a(OJ(i), Ou, f, true, false, i);
            }
            if (this.yTG != null) {
                this.yTG.g(Ou, true);
            }
            if (z) {
                l dGI = l.dGI();
                ab.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] startScene, msgLoacalID:%d", Long.valueOf(Ou.field_msgId));
                dGI.yXM.add(Long.valueOf(Ou.field_msgId));
                o.ahm().a(f.fDy, Ou.field_msgId, Integer.valueOf(i), dGI);
                AppMethodBeat.o(32128);
                return;
            }
            o.ahm().a(f.fDy, Ou.field_msgId, Integer.valueOf(i), this);
            AppMethodBeat.o(32128);
        } else {
            ab.e("MicroMsg.ImageGalleryHolderImage", "not img can't download hd");
            AppMethodBeat.o(32128);
        }
    }

    public final void bB(bi biVar) {
        AppMethodBeat.i(32129);
        com.tencent.mm.at.e d = d(biVar);
        if (d == null || biVar == null) {
            AppMethodBeat.o(32129);
            return;
        }
        if (this.yTG != null) {
            this.yTG.a(biVar, null, 1, com.tencent.mm.g.b.a.e.a.cancel);
        }
        if (l.dGI().nr(biVar.field_msgId)) {
            com.tencent.mm.at.d.a dGI = l.dGI();
            dGI.yXM.remove(Long.valueOf(biVar.field_msgId));
            o.ahm().a(d.fDy, biVar.field_msgId, dGI);
            o.ahm().x(d.fDy, biVar.field_msgId);
            AppMethodBeat.o(32129);
            return;
        }
        o.ahm().a(d.fDy, biVar.field_msgId, (com.tencent.mm.at.d.a) this);
        o.ahm().x(d.fDy, biVar.field_msgId);
        AppMethodBeat.o(32129);
    }

    @TargetApi(11)
    private void b(MultiTouchImageView multiTouchImageView, Bitmap bitmap) {
        AppMethodBeat.i(32130);
        if (this.yTG == null || this.yTG.yTI == null) {
            AppMethodBeat.o(32130);
            return;
        }
        ab.i("MicroMsg.ImageGalleryHolderImage", "fillBitmap image : %s bmp %s", Integer.valueOf(multiTouchImageView.hashCode()), Integer.valueOf(bitmap.hashCode()));
        if (VERSION.SDK_INT == 20) {
            multiTouchImageView.setLayerType(1, null);
        } else {
            n.w((View) multiTouchImageView.getParent(), bitmap.getWidth(), bitmap.getHeight());
        }
        multiTouchImageView.setEnableHorLongBmpMode(false);
        multiTouchImageView.bW(bitmap.getWidth(), bitmap.getHeight());
        multiTouchImageView.setImageBitmap(null);
        multiTouchImageView.setImageBitmap(bitmap);
        multiTouchImageView.invalidate();
        AppMethodBeat.o(32130);
    }

    public final Bitmap OY(int i) {
        AppMethodBeat.i(32131);
        if (this.yTG == null) {
            AppMethodBeat.o(32131);
            return null;
        }
        bi OV = this.yTG.yTJ.OV(i);
        if (OV != null) {
            String str = (String) this.yVc.get(OV);
            if (str == null) {
                str = o.ahl().I(OV.field_imgPath, true);
                this.yVc.put(OV, str);
            }
            String str2 = str + "hd";
            Bitmap arx;
            if (com.tencent.mm.vfs.e.ct(str2)) {
                arx = arx(str2);
                AppMethodBeat.o(32131);
                return arx;
            }
            arx = arx(str);
            AppMethodBeat.o(32131);
            return arx;
        }
        AppMethodBeat.o(32131);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean arw(String str) {
        AppMethodBeat.i(32108);
        if (yVd) {
            int i;
            if (VERSION.SDK_INT == 27) {
                String str2 = com.tencent.mm.compatible.e.ab.get("ro.mediatek.platform");
                if (str2 != null && (str2.startsWith("mt6765") || str2.startsWith("MT6765"))) {
                    i = 0;
                    if (i != 0) {
                        AppMethodBeat.o(32108);
                        return false;
                    }
                    Options arv = arv(str);
                    int i2 = arv.outWidth;
                    int i3 = arv.outHeight;
                    ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImgOpt ignore abTestFlag, widthFactor: %f, heightFactor: %f, width: %d, height: %d", Float.valueOf(1.0f), Float.valueOf(1.0f), Integer.valueOf(i2), Integer.valueOf(i3));
                    b bVar = this.yVe;
                    if (((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_bigimgopt_for_huawei, 0) == 1) {
                        com.tencent.luggage.g.d.i("MicroMsg.BigImageFilter", "alvinluo BigImageFilter clicfg notFilter: %d", Integer.valueOf(((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_bigimgopt_for_huawei, 0)));
                    } else {
                        i = ((i2 < 5700 || i3 < TXRecordCommon.AUDIO_SAMPLERATE_8000) && (i2 < TXRecordCommon.AUDIO_SAMPLERATE_8000 || i3 < 5700)) ? 0 : 1;
                        if (i != 0) {
                            String str3 = Build.MODEL;
                            if (!bo.isNullOrNil(str3)) {
                                for (String equalsIgnoreCase : bVar.yTH) {
                                    if (str3.equalsIgnoreCase(equalsIgnoreCase)) {
                                        com.tencent.luggage.g.d.i("MicroMsg.BigImageFilter", "alvinluo BigImageFilter filter model: %s, width: %d, height: %d", str3, Integer.valueOf(i2), Integer.valueOf(i3));
                                        i = 1;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    i = 0;
                    if (i != 0) {
                        ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt filter image");
                        AppMethodBeat.o(32108);
                        return false;
                    }
                    ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt not filter");
                    ab.d("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt width: %d, height: %d, screenWidth: %d, screenHeight: %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(getScreenWidth(ah.getContext())), Integer.valueOf(getScreenHeight(ah.getContext())));
                    if (((float) i2) >= ((float) getScreenWidth(ah.getContext())) * 1.0f) {
                        AppMethodBeat.o(32108);
                        return true;
                    } else if (((float) i3) >= ((float) r3) * 1.0f) {
                        AppMethodBeat.o(32108);
                        return true;
                    } else {
                        AppMethodBeat.o(32108);
                        return false;
                    }
                }
            }
            if (com.tencent.mm.compatible.util.m.Mx()) {
                ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt is MTK platform");
                if (VERSION.SDK_INT == 24 || VERSION.SDK_INT == 25 || VERSION.SDK_INT == 27) {
                    ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImgOpt is MTK platform, android api: %d, cannot use BigImgOpt", Integer.valueOf(VERSION.SDK_INT));
                    i = VERSION.SDK_INT;
                    ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo reportMTKPlatform apiLevel: %d", Integer.valueOf(i));
                    if (i == 24) {
                        h.pYm.k(896, 0, 1);
                    } else if (i == 25) {
                        h.pYm.k(896, 1, 1);
                    }
                    i = 1;
                    if (i != 0) {
                    }
                }
            }
            i = 0;
            if (i != 0) {
            }
        } else {
            ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt not enable BigImageOpt");
            AppMethodBeat.o(32108);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String a(bi biVar, com.tencent.mm.at.e eVar, boolean z) {
        AppMethodBeat.i(32121);
        String q;
        String str;
        if (biVar.field_isSend == 1) {
            q = o.ahl().q(o.ahl().d(eVar), "", "");
            ab.d("MicroMsg.ImageGalleryHolderImage", "getImgPath() pre fileName:%s bigImgPath:%s", str, q);
            if (com.tencent.mm.vfs.e.ct(q)) {
                AppMethodBeat.o(32121);
                return q;
            }
            q = o.ahl().q(eVar.fDz, "", "");
            ab.d("MicroMsg.ImageGalleryHolderImage", "getImgPath() after fileName:%s bigImgPath:%s", str, q);
            if (com.tencent.mm.vfs.e.ct(q)) {
                AppMethodBeat.o(32121);
                return q;
            }
            AppMethodBeat.o(32121);
            return null;
        } else if (z || eVar.agP()) {
            str = eVar.fDz;
            if (eVar.agQ()) {
                q = o.ahl().d(eVar);
                if (q != null) {
                    q = o.ahl().q(q, "", "");
                    if (com.tencent.mm.vfs.e.ct(q)) {
                        ab.i("MicroMsg.ImageGalleryHolderImage", "hasHdImg");
                        if (q == null) {
                            q = o.ahl().q(str, "", "");
                        }
                        ab.i("MicroMsg.ImageGalleryHolderImage", "the path : %s", q);
                        AppMethodBeat.o(32121);
                        return q;
                    }
                }
            }
            q = null;
            if (q == null) {
            }
            ab.i("MicroMsg.ImageGalleryHolderImage", "the path : %s", q);
            AppMethodBeat.o(32121);
            return q;
        } else {
            ab.w("MicroMsg.ImageGalleryHolderImage", "getImagePath is null because of isTryToGetProgress %s img.isGetCompleted() %s", Boolean.valueOf(z), Boolean.valueOf(eVar.agP()));
            AppMethodBeat.o(32121);
            return null;
        }
    }
}
