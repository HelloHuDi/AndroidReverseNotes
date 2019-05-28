package com.tencent.p177mm.p612ui.chatting.gallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.davemorrissey.labs.subscaleview.p1158a.C25467c;
import com.davemorrissey.labs.subscaleview.view.C31985a;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p221e.C1414ab;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C41943m;
import com.tencent.p177mm.graphics.p1191a.C36695b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C37951y;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C17940d.C9017a;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C25826k;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p230g.p232b.p233a.C42100e.C26292a;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.MultiTouchImageView;
import com.tencent.p177mm.p612ui.base.WxImageView;
import com.tencent.p177mm.p612ui.chatting.C23701al;
import com.tencent.p177mm.p612ui.chatting.C23701al.C23702a;
import com.tencent.p177mm.p612ui.chatting.gallery.C15656g.C5340a;
import com.tencent.p177mm.p612ui.chatting.gallery.C46651f.C30516a;
import com.tencent.p177mm.p612ui.chatting.gallery.ImageGalleryUI.C2377017;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.C46616n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.MMJpegOptim;
import com.tencent.p177mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.wxmm.v2helper;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.tencent.mm.ui.chatting.gallery.e */
public final class C40780e extends C23777a implements C9017a, C30516a {
    private static boolean yVd = true;
    private static long yVf = ((long) (((double) Runtime.getRuntime().maxMemory()) * 0.05d));
    public HashMap<Long, Integer> jNM = new HashMap();
    int mScrollState = 0;
    private HashMap<String, WeakReference<Bitmap>> usl = new HashMap();
    private C4884c yUZ;
    public final C46651f yVa = new C46651f(this);
    private HashMap<C7620bi, String> yVb = new HashMap();
    private HashMap<C7620bi, String> yVc = new HashMap();
    private C30512b yVe = new C30512b();
    private long yVg = 0;

    /* renamed from: com.tencent.mm.ui.chatting.gallery.e$a */
    static class C40781a {
        private static HashMap<String, C40781a> yVm = new HashMap();
        private long cmn = 0;
        private int frO;
        private int height;
        private int width;
        private int yVj = 0;
        private String yVk = "";
        private int yVl = 0;

        private C40781a() {
        }

        static {
            AppMethodBeat.m2504i(32091);
            AppMethodBeat.m2505o(32091);
        }

        /* renamed from: eD */
        public static void m70635eD(String str, int i) {
            AppMethodBeat.m2504i(32089);
            try {
                if (C5046bo.isNullOrNil(str) || i == 0) {
                    AppMethodBeat.m2505o(32089);
                    return;
                }
                C40781a c40781a = (C40781a) yVm.get(str);
                if (c40781a != null) {
                    c40781a.frO = i;
                }
                HashSet<String> hashSet = new HashSet();
                for (String str2 : yVm.keySet()) {
                    C40781a c40781a2 = (C40781a) yVm.get(str2);
                    if (c40781a2 != null) {
                        C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "dkprog report: diff:%d [%d,%d,%d] succ:%d change:%d str:%s file:%s", Long.valueOf(C5046bo.m7566gb(c40781a2.cmn)), Integer.valueOf(c40781a2.frO), Integer.valueOf(c40781a2.width), Integer.valueOf(c40781a2.height), Integer.valueOf(c40781a2.yVj), Integer.valueOf(c40781a2.yVl), c40781a2.yVk, str2);
                        if (C5046bo.m7566gb(c40781a2.cmn) >= 60000) {
                            if (c40781a2.frO > 0 && !C5046bo.isNullOrNil(c40781a2.yVk)) {
                                C7060h.pYm.mo8381e(11713, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c40781a2.frO), Integer.valueOf(c40781a2.width), Integer.valueOf(c40781a2.height), Integer.valueOf(c40781a2.yVj), Integer.valueOf(c40781a2.yVl), c40781a2.yVk);
                            }
                            hashSet.add(str2);
                        }
                    }
                }
                for (String str22 : hashSet) {
                    yVm.remove(str22);
                }
                AppMethodBeat.m2505o(32089);
            } catch (Throwable th) {
                C4990ab.m7413e("MicroMsg.ImageGalleryHolderImage", "get useopt  setTotalLen :%s", C5046bo.m7574l(th));
                AppMethodBeat.m2505o(32089);
            }
        }

        /* renamed from: p */
        public static void m70636p(String str, int i, int i2, int i3) {
            AppMethodBeat.m2504i(32090);
            try {
                if (C5046bo.isNullOrNil(str) || i == 0 || i2 == 0) {
                    AppMethodBeat.m2505o(32090);
                    return;
                }
                C40781a c40781a = (C40781a) yVm.get(str);
                if (c40781a == null) {
                    c40781a = new C40781a();
                    c40781a.cmn = C5046bo.anU();
                    yVm.put(str, c40781a);
                }
                c40781a.height = i2;
                c40781a.width = i;
                c40781a.yVk += i3 + "|";
                if (i3 > 0) {
                    if (c40781a.yVj == 0) {
                        c40781a.yVj = i3;
                    }
                } else if (c40781a.yVj != 0) {
                    c40781a.yVl++;
                    c40781a.yVj = 0;
                }
                C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "dkprog addBit: [%d,%d,%d] succ:%d change:%d str:%s file:%s", Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(c40781a.yVj), Integer.valueOf(c40781a.yVl), c40781a.yVk, str);
                AppMethodBeat.m2505o(32090);
            } catch (Throwable th) {
                C4990ab.m7413e("MicroMsg.ImageGalleryHolderImage", "get useopt  addBit :%s", C5046bo.m7574l(th));
                AppMethodBeat.m2505o(32090);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m70607a(C36180k c36180k) {
        AppMethodBeat.m2504i(32132);
        C40780e.m70610a(c36180k, true, false);
        AppMethodBeat.m2505o(32132);
    }

    public C40780e(C40775c c40775c) {
        super(c40775c);
        AppMethodBeat.m2504i(32092);
        C4879a c4879a = C4879a.xxA;
        C23701al c23701al = new C23701al(C23702a.IMAGE_GALLERY_UI, c40775c.yTI);
        this.yUZ = c23701al;
        c4879a.mo10052c(c23701al);
        this.yVa.mo74888aW(C5340a.yVD.mQK.snapshot());
        C40782l.dGI().yXN = this;
        AppMethodBeat.m2505o(32092);
    }

    public final void detach() {
        AppMethodBeat.m2504i(32093);
        super.detach();
        C4879a.xxA.mo10053d(this.yUZ);
        if (this.usl != null) {
            for (Object obj : this.usl.keySet()) {
                Bitmap bitmap = (Bitmap) ((WeakReference) this.usl.get(obj)).get();
                if (!(bitmap == null || bitmap.isRecycled())) {
                    C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
            }
        }
        C46651f c46651f = this.yVa;
        c46651f.yVo = null;
        c46651f.mQG.clear();
        c46651f.mQJ.clear();
        c46651f.mQI.clear();
        c46651f.mQH.clear();
        c46651f.yVn.clear();
        c46651f.bCH();
        if (!(c46651f.yVt == null || c46651f.yVt.isRecycled())) {
            C4990ab.m7417i("MicroMsg.ImageGalleryLazyLoader", "bitmap recycle %s", c46651f.yVt.toString());
            c46651f.yVt.recycle();
            c46651f.yVt = null;
        }
        C32291o.ahm().mo33465a((C9017a) this);
        C40782l dGI = C40782l.dGI();
        if (equals(dGI.yXN)) {
            dGI.yXN = null;
        }
        AppMethodBeat.m2505o(32093);
    }

    /* renamed from: bA */
    public final int mo64336bA(C7620bi c7620bi) {
        AppMethodBeat.m2504i(32094);
        if (c7620bi == null || !this.jNM.containsKey(Long.valueOf(c7620bi.field_msgId))) {
            AppMethodBeat.m2505o(32094);
            return 0;
        }
        int intValue = ((Integer) this.jNM.get(Long.valueOf(c7620bi.field_msgId))).intValue();
        AppMethodBeat.m2505o(32094);
        return intValue;
    }

    /* renamed from: h */
    private void m70622h(C7620bi c7620bi, int i) {
        AppMethodBeat.m2504i(32095);
        this.jNM.put(Long.valueOf(c7620bi.field_msgId), Integer.valueOf(i));
        AppMethodBeat.m2505o(32095);
    }

    /* renamed from: l */
    private void m70623l(long j, int i) {
        AppMethodBeat.m2504i(32096);
        this.jNM.put(Long.valueOf(j), Integer.valueOf(i));
        AppMethodBeat.m2505o(32096);
    }

    /* renamed from: a */
    public final boolean mo27898a(C36180k c36180k, C7620bi c7620bi, int i) {
        AppMethodBeat.m2504i(32097);
        super.mo27898a(c36180k, c7620bi, i);
        if (c36180k == null || c7620bi == null || i < 0) {
            AppMethodBeat.m2505o(32097);
            return false;
        }
        int bA = mo64336bA(c7620bi);
        C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "filling image : %s position : %s currentState : %s", Integer.valueOf(c36180k.yXB.hashCode()), Integer.valueOf(i), Integer.valueOf(bA));
        C36180k.m59559am(c36180k.yXs, 8);
        C25822e f = mo64338f(c7620bi, false);
        if (f == null) {
            AppMethodBeat.m2505o(32097);
            return false;
        }
        switch (bA) {
            case 0:
                boolean dtH;
                C4990ab.m7416i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloadOrSucc");
                C4990ab.m7416i("MicroMsg.ImageGalleryHolderImage", "deal LoadFail");
                if (c7620bi.field_isSend == 1) {
                    dtH = c7620bi.dtH();
                } else if (c7620bi.dtH()) {
                    dtH = true;
                } else {
                    String d = m70620d(c7620bi, f);
                    if (!f.agP() || (d != null && C5730e.m8628ct(d))) {
                        Object obj;
                        if (System.currentTimeMillis() - c7620bi.field_createTime <= 259200000 || (!C5046bo.isNullOrNil(d) && C5730e.m8628ct(d))) {
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
                    if (m70612a(c36180k, c7620bi, f, i)) {
                        boolean z = false;
                        C25822e w = C32291o.ahl().mo73124w(c7620bi);
                        C4990ab.m7411d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc temp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", Long.valueOf(w.fDy), Long.valueOf(w.fDH), Long.valueOf(w.cKK), Integer.valueOf(w.fDJ), Integer.valueOf(w.frO));
                        if (w != null) {
                            if (C5046bo.m7563gW(w.fDJ, 0)) {
                                bA = w.frO;
                            } else {
                                C4990ab.m7411d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc hdTemp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", Long.valueOf(w.fDy), Long.valueOf(w.fDH), Long.valueOf(w.cKK), Integer.valueOf(w.fDJ), Integer.valueOf(C32291o.ahl().mo73116ly(w.fDJ).frO));
                                bA = w.frO;
                            }
                            int asZ = (int) C5730e.asZ(C32291o.ahl().mo73118q(f.fDz, "", ""));
                            if (c7620bi.field_isSend == 1 && C5046bo.m7563gW(bA, asZ)) {
                                z = true;
                            }
                            C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc() sizeInDb:%s oriSize:%s noNeedDownLoad:%s", Integer.valueOf(bA), Integer.valueOf(asZ), Boolean.valueOf(z));
                        } else {
                            C4990ab.m7416i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc() temp == null");
                        }
                        if (z || f.agP()) {
                            m70622h(c7620bi, 4);
                            break;
                        }
                        m70622h(c7620bi, 1);
                    } else {
                        C4990ab.m7416i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc dealSucc() == false");
                        m70622h(c7620bi, 2);
                    }
                    C37951y.m64162C(c7620bi);
                    bA = C32291o.ahm().mo33463a(f.fDy, c7620bi.field_msgId, 0, Integer.valueOf(i), C25738R.drawable.b0p, this, 0, true);
                    if (this.yTG != null) {
                        this.yTG.mo64328g(c7620bi, false);
                    }
                    C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "put image download task downloadCode [%d].", Integer.valueOf(bA));
                    if (bA != -2) {
                        m70608a(c36180k, c7620bi, f, false, i);
                        break;
                    }
                    C4990ab.m7420w("MicroMsg.ImageGalleryHolderImage", "it is already download image finish, but imgInfo is old, search db and repair.");
                    C25822e f2 = mo64338f(c7620bi, true);
                    if (f2 != null) {
                        if (!m70612a(c36180k, c7620bi, f2, i)) {
                            m70622h(c7620bi, 2);
                        } else if (c7620bi.field_isSend == 1 || f2.agP()) {
                            m70622h(c7620bi, 4);
                            break;
                        } else {
                            m70622h(c7620bi, 1);
                        }
                        C4990ab.m7421w("MicroMsg.ImageGalleryHolderImage", "it repair fail show thumb image.ImgInfo[%d, %b]", Long.valueOf(f2.fDy), Boolean.valueOf(f2.agP()));
                        m70608a(c36180k, c7620bi, f2, false, i);
                        break;
                    }
                    C4990ab.m7420w("MicroMsg.ImageGalleryHolderImage", "get imgInfo by db but it is null.");
                    break;
                }
                m70622h(c7620bi, 5);
                C40780e.m70604a(c7620bi, c36180k, 5);
                break;
                break;
            case 1:
            case 4:
                m70612a(c36180k, c7620bi, f, i);
                break;
            case 2:
                m70608a(c36180k, c7620bi, f, false, i);
                break;
            case 3:
                m70608a(c36180k, c7620bi, f, true, i);
                break;
            case 5:
            case 6:
                C40780e.m70604a(c7620bi, c36180k, bA);
                c36180k.mRR.invalidate();
                break;
        }
        AppMethodBeat.m2505o(32097);
        return true;
    }

    /* JADX WARNING: Missing block: B:6:0x0025, code skipped:
            if (r0.fDy == 0) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public static C25822e m70619d(C7620bi c7620bi) {
        AppMethodBeat.m2504i(32098);
        if (C40775c.m70571c(c7620bi)) {
            C25822e fJ;
            if (c7620bi.field_isSend == 1) {
                fJ = C32291o.ahl().mo73113fJ(c7620bi.field_msgId);
            }
            fJ = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
            AppMethodBeat.m2505o(32098);
            return fJ;
        }
        AppMethodBeat.m2505o(32098);
        return null;
    }

    /* JADX WARNING: Missing block: B:21:0x0073, code skipped:
            if (r2.fDy == 0) goto L_0x0075;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    public final C25822e mo64338f(C7620bi c7620bi, boolean z) {
        C25822e c25822e = null;
        AppMethodBeat.m2504i(32099);
        if (!C40775c.m70571c(c7620bi)) {
            AppMethodBeat.m2505o(32099);
        } else if (this.yTG == null || this.yTG.yTJ == null) {
            C4990ab.m7412e("MicroMsg.ImageGalleryHolderImage", "adapter is null!!");
            AppMethodBeat.m2505o(32099);
        } else {
            if (!z) {
                if (c7620bi.field_isSend == 1) {
                    c25822e = (C25822e) this.yTG.yTJ.yUg.get(Long.valueOf(c7620bi.field_msgId));
                }
                if (c25822e == null && c7620bi.field_msgSvrId > 0) {
                    c25822e = (C25822e) this.yTG.yTJ.yUf.get(Long.valueOf(c7620bi.field_msgSvrId));
                }
            }
            if (c25822e == null) {
                long j;
                boolean z2 = false;
                if (c7620bi.field_isSend == 1) {
                    j = c7620bi.field_msgId;
                    c25822e = C32291o.ahl().mo73113fJ(j);
                }
                j = c7620bi.field_msgSvrId;
                c25822e = C32291o.ahl().mo73112fI(j);
                z2 = true;
                this.yTG.yTJ.mo48933a(j, c25822e, z2);
            }
            AppMethodBeat.m2505o(32099);
        }
        return c25822e;
    }

    /* renamed from: d */
    private String m70620d(C7620bi c7620bi, C25822e c25822e) {
        AppMethodBeat.m2504i(32100);
        String str = (String) this.yVb.get(c7620bi);
        if (str == null) {
            str = C40780e.m70602a(c7620bi, c25822e, false);
            if (str == null || str.length() == 0) {
                AppMethodBeat.m2505o(32100);
                return null;
            }
            this.yVb.put(c7620bi, str);
        }
        AppMethodBeat.m2505o(32100);
        return str;
    }

    /* renamed from: a */
    private boolean m70612a(C36180k c36180k, C7620bi c7620bi, C25822e c25822e, int i) {
        AppMethodBeat.m2504i(32101);
        C4990ab.m7416i("MicroMsg.ImageGalleryHolderImage", "edw dealSucc");
        String d = m70620d(c7620bi, c25822e);
        C36180k.m59559am(c36180k.yXx, 8);
        String str = (String) this.yVc.get(c7620bi);
        if (str == null) {
            str = C32291o.ahl().mo73074I(c7620bi.field_imgPath, true);
            this.yVc.put(c7620bi, str);
        }
        boolean a = m70613a(c36180k, str, d, c7620bi);
        if (i == this.yTG.yTI.getCurrentItem() && this.yTG.yTM) {
            this.yTG.mo64317bw(c7620bi);
            this.yTG.yTM = false;
        }
        AppMethodBeat.m2505o(32101);
        return a;
    }

    /* renamed from: a */
    private void m70608a(C36180k c36180k, C7620bi c7620bi, C25822e c25822e, boolean z, int i) {
        AppMethodBeat.m2504i(32102);
        m70609a(c36180k, c7620bi, c25822e, z, true, i);
        AppMethodBeat.m2505o(32102);
    }

    /* renamed from: a */
    private void m70609a(C36180k c36180k, C7620bi c7620bi, C25822e c25822e, boolean z, boolean z2, int i) {
        AppMethodBeat.m2504i(32103);
        C4990ab.m7416i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloading, isHd = ".concat(String.valueOf(z)));
        C36180k.m59559am(c36180k.yXy, 8);
        String str = null;
        if (!z) {
            c36180k.yXB.setVisibility(0);
        }
        C25822e a = C37478f.m63225a(c25822e);
        if (z && i == this.yTG.yTI.getCurrentItem()) {
            this.yTG.yTI.dGv();
        }
        if (z) {
            str = C40780e.m70602a(c7620bi, c25822e, true);
        }
        if (C5046bo.isNullOrNil(str)) {
            str = C32291o.ahl().mo73118q(a.fDB, "", "");
        }
        String I = C32291o.ahl().mo73074I(c7620bi.field_imgPath, true);
        if (z2) {
            m70613a(c36180k, I, str, c7620bi);
        }
        if (!z) {
            int i2 = c25822e.frO;
            if (Math.max(1, (int) (i2 != 0 ? ((((long) c25822e.offset) * 100) / ((long) i2)) - 1 : 0)) > 50) {
                c36180k.dGE().yXx.setVisibility(8);
            } else {
                c36180k.dGE().yXx.setVisibility(0);
            }
        }
        c36180k.dGE().yXv.setVisibility(8);
        c36180k.dGE().yXu.setVisibility(8);
        c36180k.dGE().yXt.setVisibility(8);
        AppMethodBeat.m2505o(32103);
    }

    /* renamed from: a */
    private static void m70604a(C7620bi c7620bi, C36180k c36180k, int i) {
        AppMethodBeat.m2504i(32104);
        C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "edw dealFail", new Object[0]);
        String I = C32291o.ahl().mo73074I(c7620bi.field_imgPath, true);
        C36180k.m59559am(c36180k.yXx, 8);
        C36180k.m59559am(c36180k.yXs, 8);
        C36180k.m59559am(c36180k.yXB, 8);
        C36180k.m59559am(c36180k.yXC, 8);
        C36180k.m59559am(c36180k.yXD, 8);
        c36180k.dGF().yXy.setVisibility(0);
        c36180k.dGF().yXA.setImageResource(C1318a.image_download_fail_icon);
        if (I == null || !C5730e.m8628ct(I)) {
            c36180k.dGF().yXz.setText(C25738R.string.cdj);
            AppMethodBeat.m2505o(32104);
        } else if (i == 6) {
            c36180k.dGF().yXz.setText(C25738R.string.cdh);
            AppMethodBeat.m2505o(32104);
        } else if (c7620bi.dtH()) {
            c36180k.dGF().yXz.setText(C25738R.string.cdf);
            AppMethodBeat.m2505o(32104);
        } else {
            c36180k.dGF().yXz.setText(C25738R.string.cdg);
            AppMethodBeat.m2505o(32104);
        }
    }

    /* renamed from: a */
    private boolean m70613a(C36180k c36180k, String str, String str2, C7620bi c7620bi) {
        AppMethodBeat.m2504i(32105);
        boolean b = m70617b(c36180k, str, str2, c7620bi);
        AppMethodBeat.m2505o(32105);
        return b;
    }

    /* renamed from: b */
    private boolean m70617b(C36180k c36180k, String str, String str2, C7620bi c7620bi) {
        AppMethodBeat.m2504i(32106);
        C36180k.m59559am(c36180k.yXB, 0);
        C36180k.m59559am(c36180k.yXs, 8);
        C36180k.m59559am(c36180k.yXx, 8);
        C36180k.m59559am(c36180k.yXy, 8);
        boolean a = m70611a(c36180k.yXB, str, str2, c36180k.mPosition, c7620bi, c36180k);
        AppMethodBeat.m2505o(32106);
        return a;
    }

    protected static Options arv(String str) {
        AppMethodBeat.m2504i(32107);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        if (decodeFile != null) {
            decodeFile.recycle();
        }
        AppMethodBeat.m2505o(32107);
        return options;
    }

    static {
        AppMethodBeat.m2504i(32135);
        AppMethodBeat.m2505o(32135);
    }

    public static void dFV() {
        yVd = false;
    }

    /* renamed from: a */
    private boolean m70611a(MultiTouchImageView multiTouchImageView, String str, String str2, int i, C7620bi c7620bi, C36180k c36180k) {
        AppMethodBeat.m2504i(32109);
        boolean a = m70614a(true, multiTouchImageView, str, str2, false, i, c7620bi, c36180k, null, false);
        AppMethodBeat.m2505o(32109);
        return a;
    }

    /* renamed from: a */
    private boolean m70614a(boolean z, MultiTouchImageView multiTouchImageView, String str, String str2, boolean z2, int i, C7620bi c7620bi, C36180k c36180k, C25822e c25822e, boolean z3) {
        AppMethodBeat.m2504i(32110);
        C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "initImageView image : %s bigImgPath %s position : %s", Integer.valueOf(multiTouchImageView.hashCode()), str2, Integer.valueOf(i));
        String str3 = null;
        boolean z4 = true;
        if (str2 == null || !C5730e.m8628ct(str2)) {
            z4 = false;
        } else {
            str3 = str2;
        }
        if (str3 == null && str != null && C5730e.m8628ct(str)) {
            if (C5730e.m8628ct(str + "hd")) {
                str3 = str + "hd";
            } else {
                str3 = str;
            }
        }
        if (str3 == null) {
            C4990ab.m7413e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, file does not exist, filePath %s", str2);
            AppMethodBeat.m2505o(32110);
            return false;
        } else if (c36180k == null) {
            C4990ab.m7412e("MicroMsg.ImageGalleryHolderImage", "alvinluo initImageView holder is null");
            AppMethodBeat.m2505o(32110);
            return false;
        } else {
            boolean z5;
            Bitmap bitmap;
            String e;
            boolean z6 = (str3.equals(str) || z3 || !arw(str3)) ? false : true;
            C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt result: %b, path: %s", Boolean.valueOf(z6), str3);
            Object obj = (c36180k.yXC == null || c36180k.yXC.getVisibility() != 0) ? null : 1;
            if (z6 && obj == null) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (!(z6 || z2 || !this.yVa.mQK.mo4405aj(str3))) {
                bitmap = (Bitmap) this.yVa.mQK.mo4404ai(str3);
                if (!bitmap.isRecycled()) {
                    C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "use cache, fillBitmap path : %s", str3);
                    m70616b(multiTouchImageView, bitmap);
                    AppMethodBeat.m2505o(32110);
                    return true;
                }
            }
            if (z) {
                multiTouchImageView.setImageBitmap(null);
            }
            if (z6) {
                if (c36180k.yXC == null) {
                    AppMethodBeat.m2505o(32110);
                    return false;
                }
                if (c25822e == null) {
                    c25822e = mo64338f(c7620bi, true);
                }
                final int i2 = i;
                final C36180k c36180k2 = c36180k;
                final C7620bi c7620bi2 = c7620bi;
                c36180k.yXC.setOnImageLoadEventListener(new C36695b() {
                    /* renamed from: oL */
                    public final void mo2345oL() {
                        AppMethodBeat.m2504i(32083);
                        C4990ab.m7416i("MicroMsg.ImageGalleryHolderImage", "alvinluo SubsamplingImageView onPreviewLoaded");
                        AppMethodBeat.m2505o(32083);
                    }

                    /* renamed from: l */
                    public final void mo2344l(Bitmap bitmap) {
                        AppMethodBeat.m2504i(32084);
                        if (!(bitmap == null || C40780e.this.yVa == null)) {
                            C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "alvinluo onImageLoaded cache bitmap, cacheImagePath: %s", str3);
                            C40780e.this.yVa.mo74891c(i2 > 0 ? i2 : c36180k2.mPosition, bitmap);
                        }
                        C40780e.m70607a(c36180k2);
                        AppMethodBeat.m2505o(32084);
                    }

                    /* renamed from: a */
                    public final void mo2341a(C25467c c25467c) {
                        AppMethodBeat.m2504i(32085);
                        C4990ab.m7413e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onPreviewLoadError errCode: %d, errMsg: %s", Integer.valueOf(c25467c.errCode), c25467c.aIm);
                        AppMethodBeat.m2505o(32085);
                    }

                    /* renamed from: b */
                    public final void mo2342b(C25467c c25467c) {
                        AppMethodBeat.m2504i(32086);
                        C4990ab.m7413e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onImageLoadError errCode: %d, errMsg: %s", Integer.valueOf(c25467c.errCode), c25467c.aIm);
                        int i = c25467c.errCode;
                        C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "alvinluo reportLoadError errCode: %d", Integer.valueOf(i));
                        if (i == 4) {
                            C7060h.pYm.mo15419k(896, 2, 1);
                        } else if (i == 5) {
                            C7060h.pYm.mo15419k(896, 3, 1);
                        }
                        C40780e.m70606a(C40780e.this, str3, c36180k2, i2);
                        if (c25467c.errCode == 4) {
                            C40780e.dFV();
                        }
                        AppMethodBeat.m2505o(32086);
                    }

                    /* renamed from: c */
                    public final void mo2343c(C25467c c25467c) {
                        AppMethodBeat.m2504i(32087);
                        C4990ab.m7413e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onTileLoadError errCode: %d, errMsg: %s", Integer.valueOf(c25467c.errCode), c25467c.aIm);
                        C40780e.m70603a(c7620bi2, c36180k2);
                        AppMethodBeat.m2505o(32087);
                    }

                    /* renamed from: oM */
                    public final void mo2346oM() {
                    }
                });
            }
            if (this.yTG.yTS) {
                if (z6) {
                    e = C40780e.m70621e(c7620bi, c25822e);
                    C40780e.m70610a(c36180k, true, z5);
                    mo48937a(c36180k.yXC, str3, e != null ? C31985a.m51974af(e) : null);
                    AppMethodBeat.m2505o(32110);
                    return z4;
                }
                bitmap = C40780e.arx(str3);
                if (bitmap == null) {
                    bitmap = C40780e.arx(str);
                }
                if (bitmap != null) {
                    C40780e.m70610a(c36180k, false, true);
                    mo48938b((View) multiTouchImageView, bitmap);
                    if (str3.equals(str2)) {
                        this.yVa.mo74894u(str3, bitmap);
                        this.yVa.mo74891c(i, bitmap);
                    }
                    AppMethodBeat.m2505o(32110);
                    return z4;
                }
            } else if (i >= 0) {
                C4990ab.m7411d("MicroMsg.ImageGalleryHolderImage", "alvinluo loadThumb postion: %d", Integer.valueOf(i));
                C40780e.m70610a(c36180k, false, true);
                this.yVa.mo74892c((ImageView) multiTouchImageView, i);
            }
            if (z6) {
                C40780e.m70610a(c36180k, true, z5);
                e = C40780e.m70621e(c7620bi, c25822e);
                C46651f c46651f = this.yVa;
                WxImageView wxImageView = c36180k.yXC;
                if (i < 0) {
                    i = c36180k.mPosition;
                }
                c46651f.mo74889b(wxImageView, str3, e, i);
            } else {
                C40780e.m70610a(c36180k, false, true);
                C46651f c46651f2 = this.yVa;
                if (i < 0) {
                    i = c36180k.mPosition;
                }
                c46651f2.mo74893g(multiTouchImageView, str3, i);
            }
            AppMethodBeat.m2505o(32110);
            return z4;
        }
    }

    /* renamed from: a */
    private static void m70610a(C36180k c36180k, boolean z, boolean z2) {
        int i = 8;
        AppMethodBeat.m2504i(32111);
        if (c36180k != null) {
            if (c36180k.yXC != null) {
                c36180k.yXC.setVisibility(z ? 0 : 8);
                if (z) {
                    c36180k.yXE = true;
                } else {
                    c36180k.yXE = false;
                }
            }
            if (c36180k.yXB != null) {
                MultiTouchImageView multiTouchImageView = c36180k.yXB;
                if (z2) {
                    i = 0;
                }
                multiTouchImageView.setVisibility(i);
                if (z2) {
                    c36180k.yXE = false;
                }
            }
        }
        AppMethodBeat.m2505o(32111);
    }

    /* renamed from: b */
    public final void mo48938b(View view, Bitmap bitmap) {
        AppMethodBeat.m2504i(32112);
        if (bitmap == null) {
            AppMethodBeat.m2505o(32112);
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
                m70616b((MultiTouchImageView) view, bitmap);
                AppMethodBeat.m2505o(32112);
                return;
            } else if (view instanceof ImageView) {
                ((ImageView) view).setImageBitmap(bitmap);
            }
        }
        AppMethodBeat.m2505o(32112);
    }

    public final Bitmap loadImage(String str) {
        AppMethodBeat.m2504i(139027);
        Bitmap arx = C40780e.arx(str);
        AppMethodBeat.m2505o(139027);
        return arx;
    }

    /* renamed from: a */
    public final void mo48937a(WxImageView wxImageView, String str, C31985a c31985a) {
        AppMethodBeat.m2504i(32114);
        Options arv = C40780e.arv(str);
        wxImageView.setOrientation(ExifHelper.m7368bJ(str));
        wxImageView.mo44098bW(arv.outWidth, arv.outHeight);
        wxImageView.dzA();
        wxImageView.mo44097a(str, c31985a);
        AppMethodBeat.m2505o(32114);
    }

    /* renamed from: aw */
    private static Bitmap m70615aw(String str, int i, int i2) {
        Throwable th;
        AppMethodBeat.m2504i(32115);
        String str2 = str + "_tmp.jpg";
        Bitmap decodeAsBitmap;
        try {
            if (C1443d.m3067fP(16)) {
                AppMethodBeat.m2505o(32115);
                return null;
            }
            boolean z;
            if (!C4872b.dnO()) {
                int i3 = C5046bo.getInt(C26373g.m41964Nu().getValue("UseOptImageRecv"), 0);
                C9638aw.m17190ZK();
                C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "fromPathToImgInfo opt:%d uin:(%d,%d) debug:%b sdk:%d", Integer.valueOf(i3), Long.valueOf(r1.longValue()), Long.valueOf(new C1183p(C18628c.m29064QF()).longValue() / 100), Boolean.valueOf(C4872b.dnO()), Integer.valueOf(VERSION.SDK_INT));
                if ((((int) (new C1183p(C18628c.m29064QF()).longValue() / 100)) % 100) + 1 > i3) {
                    AppMethodBeat.m2505o(32115);
                    return null;
                }
            }
            C5730e.m8643tf(C5730e.atb(str2));
            C5730e.m8644y(str, str2);
            boolean IsJpegFile = MMNativeJpeg.IsJpegFile(str2);
            boolean isProgressive = MMNativeJpeg.isProgressive(str2);
            if (C5046bo.isNullOrNil(str2) || !new File(str2).exists()) {
                z = false;
            } else {
                z = MMJpegOptim.checkIntegrity(str2);
            }
            int asZ = (int) C5730e.asZ(str2);
            if (IsJpegFile && isProgressive) {
                if (z) {
                    decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(str2);
                } else {
                    decodeAsBitmap = null;
                }
                try {
                    C40781a.m70636p(str, i2, i, decodeAsBitmap != null ? asZ : 0 - asZ);
                } catch (Throwable th2) {
                    th = th2;
                    C4990ab.m7413e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", str, C5046bo.m7574l(th));
                    C5730e.deleteFile(str2);
                    AppMethodBeat.m2505o(32115);
                    return decodeAsBitmap;
                }
            }
            decodeAsBitmap = null;
            C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt jpeg:%b isprog:%b inte:%b len:%d [%d,%d] bm:%s path:%s", Boolean.valueOf(IsJpegFile), Boolean.valueOf(isProgressive), Boolean.valueOf(z), Integer.valueOf(asZ), Integer.valueOf(i2), Integer.valueOf(i), decodeAsBitmap, str);
            C5730e.deleteFile(str2);
            AppMethodBeat.m2505o(32115);
            return decodeAsBitmap;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ImageGalleryHolderImage", "get useopt :%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(32115);
            return null;
        } catch (Throwable th3) {
            th = th3;
            decodeAsBitmap = null;
        }
    }

    private static Bitmap arx(String str) {
        AppMethodBeat.m2504i(32116);
        if (str == null) {
            AppMethodBeat.m2505o(32116);
            return null;
        }
        Bitmap aw;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        if (decodeFile != null) {
            C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", decodeFile.toString());
            decodeFile.recycle();
        }
        int bJ = ExifHelper.m7368bJ(str);
        int i = options.outWidth;
        int i2 = options.outHeight;
        try {
            long max = Math.max((Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory()) - yVf, 0);
            long j = (long) ((options.outWidth * options.outHeight) * 4);
            C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "hy: current free memory: %d, previewDecodedBmLength: %d", Long.valueOf(max), Long.valueOf(j));
            if (max < j) {
                double sqrt = Math.sqrt(((double) max) / ((double) j));
                C4990ab.m7419v("MicroMsg.ImageGalleryHolderImage", "hy: sample is %f", Double.valueOf(sqrt));
                i = (int) (((double) i) * sqrt);
                i2 = (int) (((double) i2) * sqrt);
            }
            aw = C40780e.m70615aw(str, i2, i);
            if (aw == null) {
                aw = C5056d.m7622a(str, i, i2, 0.0f);
            }
            if (aw == null && MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                aw = MMNativeJpeg.decodeAsBitmap(str);
                String str2 = "MicroMsg.ImageGalleryHolderImage";
                String str3 = "Progressive jpeg, result isNull:%b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(aw == null);
                C4990ab.m7417i(str2, str3, objArr);
            }
            decodeFile = aw;
        } catch (OutOfMemoryError e) {
            C4990ab.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", e, "hy: out of memory! try use fallback bitmap", new Object[0]);
            decodeFile = C40780e.m70618c(str, i, i2, C40780e.getScreenWidth(C4996ah.getContext()), C40780e.getScreenHeight(C4996ah.getContext()));
        }
        if (decodeFile == null) {
            C4990ab.m7412e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(32116);
            return null;
        }
        aw = C5056d.m7648b(decodeFile, (float) bJ);
        if (aw != decodeFile || bJ % v2helper.VOIP_ENC_HEIGHT_LV1 == 0) {
            AppMethodBeat.m2505o(32116);
            return aw;
        }
        C4990ab.m7413e("MicroMsg.ImageGalleryHolderImage", "rotate failed degree:%d", Integer.valueOf(bJ));
        AppMethodBeat.m2505o(32116);
        return null;
    }

    /* renamed from: c */
    private static Bitmap m70618c(String str, int i, int i2, int i3, int i4) {
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(32117);
        C4990ab.m7412e("MicroMsg.ImageGalleryHolderImage", "hy: enter fallback bitmap logic");
        C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "hy: oriImgPixelRate %d, displayPixelRate %d", Integer.valueOf(i * i2), Integer.valueOf(i3 * i4));
        if (i * i2 > i3 * i4) {
            try {
                bitmap = C5056d.m7622a(str, i3, i4, 0.0f);
                AppMethodBeat.m2505o(32117);
            } catch (OutOfMemoryError e) {
                C4990ab.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", e, "hy: oom in fallback bitmap!", new Object[0]);
                AppMethodBeat.m2505o(32117);
            }
        } else {
            C4990ab.m7412e("MicroMsg.ImageGalleryHolderImage", "hy: the picture is even smaller the screen! display nothing");
            AppMethodBeat.m2505o(32117);
        }
        return bitmap;
    }

    private static int getScreenWidth(Context context) {
        AppMethodBeat.m2504i(32118);
        if (context == null) {
            AppMethodBeat.m2505o(32118);
            return 0;
        }
        int i = context.getResources().getDisplayMetrics().widthPixels;
        AppMethodBeat.m2505o(32118);
        return i;
    }

    private static int getScreenHeight(Context context) {
        AppMethodBeat.m2504i(32119);
        if (context == null) {
            AppMethodBeat.m2505o(32119);
            return 0;
        }
        int i = context.getResources().getDisplayMetrics().heightPixels;
        AppMethodBeat.m2505o(32119);
        return i;
    }

    /* renamed from: a */
    public static String m70601a(C7620bi c7620bi, C25822e c25822e) {
        AppMethodBeat.m2504i(32120);
        String a = C40780e.m70602a(c7620bi, c25822e, false);
        AppMethodBeat.m2505o(32120);
        return a;
    }

    /* renamed from: e */
    private static String m70621e(C7620bi c7620bi, C25822e c25822e) {
        AppMethodBeat.m2504i(32122);
        String str;
        String str2;
        if (c7620bi == null || c25822e == null) {
            AppMethodBeat.m2505o(32122);
            return null;
        } else if (c7620bi.field_isSend == 1) {
            str = c25822e.fDB;
            str2 = C32291o.ahl().mo73118q(str, "", "") + "hd";
            C4990ab.m7411d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", str, str2);
            if (C5046bo.isNullOrNil(str2) || !C5730e.m8628ct(str2)) {
                str2 = C32291o.ahl().mo73118q(str, "", "");
                C4990ab.m7411d("MicroMsg.ImageGalleryHolderImage", "preview fileName: %s, fullPath:%s", str, str2);
                if (C5046bo.isNullOrNil(str2) || !C5730e.m8628ct(str2)) {
                    AppMethodBeat.m2505o(32122);
                    return null;
                }
                C4990ab.m7410d("MicroMsg.ImageGalleryHolderImage", "preview image exist");
                AppMethodBeat.m2505o(32122);
                return str2;
            }
            C4990ab.m7410d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
            AppMethodBeat.m2505o(32122);
            return str2;
        } else if (c25822e.agP()) {
            str2 = C32291o.ahl().mo73118q(c25822e.fDB, "", "") + "hd";
            C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", str, str2);
            if (C5046bo.isNullOrNil(str2) || !C5730e.m8628ct(str2)) {
                AppMethodBeat.m2505o(32122);
                return null;
            }
            C4990ab.m7410d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
            AppMethodBeat.m2505o(32122);
            return str2;
        } else {
            C4990ab.m7416i("MicroMsg.ImageGalleryHolderImage", "alvinluo get previewPath img not completed");
            AppMethodBeat.m2505o(32122);
            return null;
        }
    }

    /* renamed from: a */
    public final void mo20450a(long j, long j2, int i, int i2, Object obj, int i3, int i4, C1207m c1207m) {
        AppMethodBeat.m2504i(32123);
        if (this.yTG == null || this.yTG.yTI == null) {
            AppMethodBeat.m2505o(32123);
        } else if (this.mScrollState != 0) {
            AppMethodBeat.m2505o(32123);
        } else {
            int a;
            Integer valueOf;
            if (C40782l.dGI().mo64339nr(j2)) {
                a = m70600a(j2, obj);
                if (a == -1) {
                    AppMethodBeat.m2505o(32123);
                    return;
                }
                valueOf = Integer.valueOf(a);
            } else {
                valueOf = obj;
            }
            if (valueOf instanceof Integer) {
                int intValue = valueOf.intValue();
                C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos[%d], offset[%d], totalLen[%d], resId[%d], compressType[%d], imgLocalId[%d],", Integer.valueOf(intValue), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(j));
                if (intValue == -1) {
                    C4990ab.m7412e("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos is -1");
                    AppMethodBeat.m2505o(32123);
                    return;
                } else if (this.yTG.mo70155Fp(intValue) == null) {
                    AppMethodBeat.m2505o(32123);
                    return;
                } else {
                    C36180k c36180k = (C36180k) this.yTG.mo70155Fp(intValue).getTag();
                    if (c36180k == null) {
                        AppMethodBeat.m2505o(32123);
                        return;
                    }
                    if (intValue == this.yTG.yTI.getCurrentItem() && !C40780e.m70599OX(i)) {
                        this.yTG.yTI.mo64295hG(false);
                    }
                    if (i3 == 0) {
                        a = 0;
                    } else {
                        a = (int) (i4 != 0 ? ((((float) i3) / ((float) i4)) * 100.0f) - 1.0f : 0.0f);
                    }
                    int max = Math.max(1, a);
                    if (intValue == this.yTG.yTI.getCurrentItem() && C40780e.m70599OX(i)) {
                        C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "jacks loading hd from progress : %d, time: %d", Integer.valueOf(max), Long.valueOf(System.currentTimeMillis()));
                        this.yTG.yTI.mo64283Pe(max);
                    }
                    C25826k c25826k = (C25826k) c1207m;
                    boolean isProgressive = MMNativeJpeg.isProgressive(c25826k.fFd);
                    boolean z = c25826k.fFf;
                    long az = C5046bo.m7525az(this.yVg);
                    C40781a.m70635eD(c25826k.fFd, i4);
                    C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "dkprog onImgTaskProgress getCanShow:%b isProg:%b timeDiff:%d  [%d/%d] %s", Boolean.valueOf(z), Boolean.valueOf(isProgressive), Long.valueOf(az), Integer.valueOf(i3), Integer.valueOf(i4), c25826k.fFd);
                    if (z && isProgressive && az > 1000) {
                        this.yVg = C5046bo.m7588yz();
                        C7620bi Ou = this.yTG.mo64312Ou(intValue);
                        C25822e f = mo64338f(Ou, true);
                        if (m70614a(false, c36180k.yXB, C32291o.ahl().mo73074I(Ou.field_imgPath, true), C40780e.m70602a(Ou, f, true), true, -1, Ou, c36180k, f, true)) {
                            C36180k.m59559am(c36180k.yXv, 8);
                            C36180k.m59559am(c36180k.yXy, 8);
                            if (intValue == this.yTG.yTI.getCurrentItem() && !C40780e.m70599OX(i)) {
                                if (max > 50) {
                                    C36180k.m59559am(c36180k.yXx, 8);
                                    if (this.yTG != null) {
                                        this.yTG.mo64313a(Ou, f, i, C26292a.ok);
                                        AppMethodBeat.m2505o(32123);
                                        return;
                                    }
                                }
                                C36180k.m59559am(c36180k.yXx, 0);
                            }
                        }
                    }
                    AppMethodBeat.m2505o(32123);
                    return;
                }
            }
            C4990ab.m7412e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
            AppMethodBeat.m2505o(32123);
        }
    }

    /* renamed from: a */
    public final void mo20451a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(32124);
        if (this.yTG == null || this.yTG.yTI == null) {
            AppMethodBeat.m2505o(32124);
            return;
        }
        Integer valueOf;
        if (C40782l.dGI().mo64339nr(j2)) {
            int a = m70600a(j2, obj);
            if (a == -1) {
                C9638aw.m17190ZK();
                C40780e.m70605a(C18628c.m29080XO().mo15340jf(j2), "background", false);
                AppMethodBeat.m2505o(32124);
                return;
            }
            valueOf = Integer.valueOf(a);
        } else {
            valueOf = obj;
        }
        if (valueOf instanceof Integer) {
            final int intValue = valueOf.intValue();
            C4990ab.m7416i("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos = ".concat(String.valueOf(intValue)));
            if (intValue == -1) {
                C4990ab.m7412e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos is -1");
                C7060h.pYm.mo8378a(111, 3, 1, true);
                AppMethodBeat.m2505o(32124);
                return;
            }
            C36180k c36180k = null;
            if (this.yTG.mo70155Fp(intValue) != null) {
                c36180k = (C36180k) this.yTG.mo70155Fp(intValue).getTag();
            }
            boolean nr = C40782l.dGI().mo64339nr(j2);
            if (i3 == 0 && i4 == 0) {
                if (nr) {
                    C40780e.m70605a(this.yTG.mo64312Ou(intValue), "hd_suc:".concat(String.valueOf(intValue)), intValue == this.yTG.yTI.getCurrentItem());
                }
                C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "pos = " + intValue + ", selectedPos = " + this.yTG.yTI.getCurrentItem(), new Object[0]);
                m70623l(j2, 4);
                C7620bi Ou = this.yTG.mo64312Ou(intValue);
                C25822e f = mo64338f(Ou, true);
                if (Ou == null || f == null) {
                    AppMethodBeat.m2505o(32124);
                    return;
                }
                if (c36180k != null) {
                    this.yTG.yTI.mo64295hG(true);
                    if (intValue == this.yTG.yTI.getCurrentItem()) {
                        if (C40780e.m70599OX(i)) {
                            ImageGalleryUI imageGalleryUI = this.yTG.yTI;
                            imageGalleryUI.mo64295hG(true);
                            imageGalleryUI.mo64295hG(true);
                            Animation Pd = ImageGalleryUI.m70486Pd(1000);
                            Pd.setAnimationListener(new C2377017());
                            imageGalleryUI.dGm();
                            imageGalleryUI.dFY().yVQ.setVisibility(0);
                            imageGalleryUI.dFY().yVR.setVisibility(8);
                            imageGalleryUI.dFY().yVS.setVisibility(8);
                            imageGalleryUI.dFY().yVT.setVisibility(0);
                            imageGalleryUI.dFY().yVT.startAnimation(Pd);
                        } else {
                            c36180k.yXB.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(32088);
                                    if (C40780e.this.yTG == null || C40780e.this.yTG.yTI == null) {
                                        AppMethodBeat.m2505o(32088);
                                        return;
                                    }
                                    C40780e.this.yTG.yTI.mo64281Pa(intValue);
                                    AppMethodBeat.m2505o(32088);
                                }
                            });
                        }
                    }
                    if (m70614a(false, c36180k.yXB, C32291o.ahl().mo73074I(Ou.field_imgPath, true), C40780e.m70602a(Ou, f, true), true, -1, Ou, c36180k, f, false)) {
                        C36180k.m59559am(c36180k.yXs, 8);
                        C36180k.m59559am(c36180k.yXx, 8);
                        C36180k.m59559am(c36180k.yXy, 8);
                        if (mo64336bA(Ou) == 4 && this.yTG.yTM) {
                            this.yTG.mo64317bw(Ou);
                            this.yTG.yTM = false;
                        }
                        if (this.yTG != null) {
                            this.yTG.mo64313a(Ou, f, i, C26292a.ok);
                            AppMethodBeat.m2505o(32124);
                            return;
                        }
                    }
                    C4990ab.m7412e("MicroMsg.ImageGalleryHolderImage", "failed to show downloaded image!");
                    C7060h.pYm.mo8378a(111, 2, 1, true);
                }
                AppMethodBeat.m2505o(32124);
                return;
            }
            if (nr) {
                C40780e.m70605a(this.yTG.mo64312Ou(intValue), "hd_failed:".concat(String.valueOf(intValue)), intValue == this.yTG.yTI.getCurrentItem());
            }
            if (intValue == this.yTG.yTI.getCurrentItem()) {
                this.yTG.yTI.mo64295hG(true);
            }
            if (i4 == -5103059) {
                m70623l(j2, 5);
                C7060h.pYm.mo8378a(111, 0, 1, true);
            } else {
                m70623l(j2, 6);
                C7060h.pYm.mo8378a(111, 1, 1, true);
            }
            C4990ab.m7412e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, errType = " + i3 + ", errCode = " + i4);
            this.yTG.yTN.mo39606OK(intValue);
            if (this.yTG != null) {
                this.yTG.mo64313a(this.yTG.mo64312Ou(intValue), null, i, C26292a.error);
            }
            AppMethodBeat.m2505o(32124);
            return;
        }
        C4990ab.m7412e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        AppMethodBeat.m2505o(32124);
    }

    /* renamed from: a */
    private int m70600a(long j, Object obj) {
        int intValue;
        AppMethodBeat.m2504i(32125);
        if (obj instanceof Integer) {
            intValue = ((Integer) obj).intValue();
            C7620bi Ou = this.yTG.mo64312Ou(intValue);
            if (Ou != null && Ou.field_msgId == j) {
                AppMethodBeat.m2505o(32125);
                return intValue;
            }
        }
        for (Integer intValue2 : this.yTG.yyK.values()) {
            intValue = intValue2.intValue();
            C7620bi Ou2 = this.yTG.mo64312Ou(intValue);
            if (Ou2 != null && Ou2.field_msgId == j) {
                AppMethodBeat.m2505o(32125);
                return intValue;
            }
        }
        AppMethodBeat.m2505o(32125);
        return -1;
    }

    /* renamed from: a */
    private static void m70605a(C7620bi c7620bi, String str, boolean z) {
        AppMethodBeat.m2504i(32126);
        C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "[oreh download_and_save] hdImg end, msgLocalId:%d, %s", Long.valueOf(c7620bi.field_msgId), str);
        C40775c.m70563b(C4996ah.getContext(), c7620bi, z);
        AppMethodBeat.m2505o(32126);
    }

    /* renamed from: OX */
    private static boolean m70599OX(int i) {
        return i == 1;
    }

    /* renamed from: a */
    public final void mo20449a(long j, long j2, int i, int i2, Object obj) {
        AppMethodBeat.m2504i(32127);
        if (obj instanceof Integer) {
            C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "image task canceled at pos ".concat(String.valueOf(((Integer) obj).intValue())), new Object[0]);
            AppMethodBeat.m2505o(32127);
            return;
        }
        C4990ab.m7412e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        AppMethodBeat.m2505o(32127);
    }

    /* renamed from: aF */
    public final void mo64335aF(int i, boolean z) {
        AppMethodBeat.m2504i(32128);
        C4990ab.m7416i("MicroMsg.ImageGalleryHolderImage", "viewHdImg, pos = ".concat(String.valueOf(i)));
        C7620bi Ou = this.yTG.mo64312Ou(i);
        if (Ou == null || Ou.field_msgId == 0) {
            C4990ab.m7412e("MicroMsg.ImageGalleryHolderImage", "msg is null");
            AppMethodBeat.m2505o(32128);
        } else if (C40775c.m70571c(Ou)) {
            C25822e f = mo64338f(Ou, true);
            if (f == null || f.fDy == 0) {
                C4990ab.m7412e("MicroMsg.ImageGalleryHolderImage", "viewHdImg fail, msgLocalId = " + (Ou == null ? BuildConfig.COMMAND : Long.valueOf(Ou.field_msgId)) + ", imgLocalId = " + (f == null ? BuildConfig.COMMAND : Long.valueOf(f.fDy)));
                AppMethodBeat.m2505o(32128);
                return;
            }
            m70622h(Ou, 3);
            if (mo39605OJ(i) != null) {
                m70609a(mo39605OJ(i), Ou, f, true, false, i);
            }
            if (this.yTG != null) {
                this.yTG.mo64328g(Ou, true);
            }
            if (z) {
                C40782l dGI = C40782l.dGI();
                C4990ab.m7417i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] startScene, msgLoacalID:%d", Long.valueOf(Ou.field_msgId));
                dGI.yXM.add(Long.valueOf(Ou.field_msgId));
                C32291o.ahm().mo33464a(f.fDy, Ou.field_msgId, Integer.valueOf(i), dGI);
                AppMethodBeat.m2505o(32128);
                return;
            }
            C32291o.ahm().mo33464a(f.fDy, Ou.field_msgId, Integer.valueOf(i), this);
            AppMethodBeat.m2505o(32128);
        } else {
            C4990ab.m7412e("MicroMsg.ImageGalleryHolderImage", "not img can't download hd");
            AppMethodBeat.m2505o(32128);
        }
    }

    /* renamed from: bB */
    public final void mo64337bB(C7620bi c7620bi) {
        AppMethodBeat.m2504i(32129);
        C25822e d = C40780e.m70619d(c7620bi);
        if (d == null || c7620bi == null) {
            AppMethodBeat.m2505o(32129);
            return;
        }
        if (this.yTG != null) {
            this.yTG.mo64313a(c7620bi, null, 1, C26292a.cancel);
        }
        if (C40782l.dGI().mo64339nr(c7620bi.field_msgId)) {
            C9017a dGI = C40782l.dGI();
            dGI.yXM.remove(Long.valueOf(c7620bi.field_msgId));
            C32291o.ahm().mo33468a(d.fDy, c7620bi.field_msgId, dGI);
            C32291o.ahm().mo33471x(d.fDy, c7620bi.field_msgId);
            AppMethodBeat.m2505o(32129);
            return;
        }
        C32291o.ahm().mo33468a(d.fDy, c7620bi.field_msgId, (C9017a) this);
        C32291o.ahm().mo33471x(d.fDy, c7620bi.field_msgId);
        AppMethodBeat.m2505o(32129);
    }

    @TargetApi(11)
    /* renamed from: b */
    private void m70616b(MultiTouchImageView multiTouchImageView, Bitmap bitmap) {
        AppMethodBeat.m2504i(32130);
        if (this.yTG == null || this.yTG.yTI == null) {
            AppMethodBeat.m2505o(32130);
            return;
        }
        C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "fillBitmap image : %s bmp %s", Integer.valueOf(multiTouchImageView.hashCode()), Integer.valueOf(bitmap.hashCode()));
        if (VERSION.SDK_INT == 20) {
            multiTouchImageView.setLayerType(1, null);
        } else {
            C46616n.m88171w((View) multiTouchImageView.getParent(), bitmap.getWidth(), bitmap.getHeight());
        }
        multiTouchImageView.setEnableHorLongBmpMode(false);
        multiTouchImageView.mo71980bW(bitmap.getWidth(), bitmap.getHeight());
        multiTouchImageView.setImageBitmap(null);
        multiTouchImageView.setImageBitmap(bitmap);
        multiTouchImageView.invalidate();
        AppMethodBeat.m2505o(32130);
    }

    /* renamed from: OY */
    public final Bitmap mo48936OY(int i) {
        AppMethodBeat.m2504i(32131);
        if (this.yTG == null) {
            AppMethodBeat.m2505o(32131);
            return null;
        }
        C7620bi OV = this.yTG.yTJ.mo48932OV(i);
        if (OV != null) {
            String str = (String) this.yVc.get(OV);
            if (str == null) {
                str = C32291o.ahl().mo73074I(OV.field_imgPath, true);
                this.yVc.put(OV, str);
            }
            String str2 = str + "hd";
            Bitmap arx;
            if (C5730e.m8628ct(str2)) {
                arx = C40780e.arx(str2);
                AppMethodBeat.m2505o(32131);
                return arx;
            }
            arx = C40780e.arx(str);
            AppMethodBeat.m2505o(32131);
            return arx;
        }
        AppMethodBeat.m2505o(32131);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean arw(String str) {
        AppMethodBeat.m2504i(32108);
        if (yVd) {
            int i;
            if (VERSION.SDK_INT == 27) {
                String str2 = C1414ab.get("ro.mediatek.platform");
                if (str2 != null && (str2.startsWith("mt6765") || str2.startsWith("MT6765"))) {
                    i = 0;
                    if (i != 0) {
                        AppMethodBeat.m2505o(32108);
                        return false;
                    }
                    Options arv = C40780e.arv(str);
                    int i2 = arv.outWidth;
                    int i3 = arv.outHeight;
                    C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImgOpt ignore abTestFlag, widthFactor: %f, heightFactor: %f, width: %d, height: %d", Float.valueOf(1.0f), Float.valueOf(1.0f), Integer.valueOf(i2), Integer.valueOf(i3));
                    C30512b c30512b = this.yVe;
                    if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_bigimgopt_for_huawei, 0) == 1) {
                        C45124d.m82930i("MicroMsg.BigImageFilter", "alvinluo BigImageFilter clicfg notFilter: %d", Integer.valueOf(((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_bigimgopt_for_huawei, 0)));
                    } else {
                        i = ((i2 < 5700 || i3 < TXRecordCommon.AUDIO_SAMPLERATE_8000) && (i2 < TXRecordCommon.AUDIO_SAMPLERATE_8000 || i3 < 5700)) ? 0 : 1;
                        if (i != 0) {
                            String str3 = Build.MODEL;
                            if (!C5046bo.isNullOrNil(str3)) {
                                for (String equalsIgnoreCase : c30512b.yTH) {
                                    if (str3.equalsIgnoreCase(equalsIgnoreCase)) {
                                        C45124d.m82930i("MicroMsg.BigImageFilter", "alvinluo BigImageFilter filter model: %s, width: %d, height: %d", str3, Integer.valueOf(i2), Integer.valueOf(i3));
                                        i = 1;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    i = 0;
                    if (i != 0) {
                        C4990ab.m7416i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt filter image");
                        AppMethodBeat.m2505o(32108);
                        return false;
                    }
                    C4990ab.m7416i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt not filter");
                    C4990ab.m7411d("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt width: %d, height: %d, screenWidth: %d, screenHeight: %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(C40780e.getScreenWidth(C4996ah.getContext())), Integer.valueOf(C40780e.getScreenHeight(C4996ah.getContext())));
                    if (((float) i2) >= ((float) C40780e.getScreenWidth(C4996ah.getContext())) * 1.0f) {
                        AppMethodBeat.m2505o(32108);
                        return true;
                    } else if (((float) i3) >= ((float) r3) * 1.0f) {
                        AppMethodBeat.m2505o(32108);
                        return true;
                    } else {
                        AppMethodBeat.m2505o(32108);
                        return false;
                    }
                }
            }
            if (C41943m.m74078Mx()) {
                C4990ab.m7416i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt is MTK platform");
                if (VERSION.SDK_INT == 24 || VERSION.SDK_INT == 25 || VERSION.SDK_INT == 27) {
                    C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImgOpt is MTK platform, android api: %d, cannot use BigImgOpt", Integer.valueOf(VERSION.SDK_INT));
                    i = VERSION.SDK_INT;
                    C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "alvinluo reportMTKPlatform apiLevel: %d", Integer.valueOf(i));
                    if (i == 24) {
                        C7060h.pYm.mo15419k(896, 0, 1);
                    } else if (i == 25) {
                        C7060h.pYm.mo15419k(896, 1, 1);
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
            C4990ab.m7416i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt not enable BigImageOpt");
            AppMethodBeat.m2505o(32108);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static String m70602a(C7620bi c7620bi, C25822e c25822e, boolean z) {
        AppMethodBeat.m2504i(32121);
        String q;
        String str;
        if (c7620bi.field_isSend == 1) {
            q = C32291o.ahl().mo73118q(C32291o.ahl().mo73109d(c25822e), "", "");
            C4990ab.m7411d("MicroMsg.ImageGalleryHolderImage", "getImgPath() pre fileName:%s bigImgPath:%s", str, q);
            if (C5730e.m8628ct(q)) {
                AppMethodBeat.m2505o(32121);
                return q;
            }
            q = C32291o.ahl().mo73118q(c25822e.fDz, "", "");
            C4990ab.m7411d("MicroMsg.ImageGalleryHolderImage", "getImgPath() after fileName:%s bigImgPath:%s", str, q);
            if (C5730e.m8628ct(q)) {
                AppMethodBeat.m2505o(32121);
                return q;
            }
            AppMethodBeat.m2505o(32121);
            return null;
        } else if (z || c25822e.agP()) {
            str = c25822e.fDz;
            if (c25822e.agQ()) {
                q = C32291o.ahl().mo73109d(c25822e);
                if (q != null) {
                    q = C32291o.ahl().mo73118q(q, "", "");
                    if (C5730e.m8628ct(q)) {
                        C4990ab.m7416i("MicroMsg.ImageGalleryHolderImage", "hasHdImg");
                        if (q == null) {
                            q = C32291o.ahl().mo73118q(str, "", "");
                        }
                        C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "the path : %s", q);
                        AppMethodBeat.m2505o(32121);
                        return q;
                    }
                }
            }
            q = null;
            if (q == null) {
            }
            C4990ab.m7417i("MicroMsg.ImageGalleryHolderImage", "the path : %s", q);
            AppMethodBeat.m2505o(32121);
            return q;
        } else {
            C4990ab.m7421w("MicroMsg.ImageGalleryHolderImage", "getImagePath is null because of isTryToGetProgress %s img.isGetCompleted() %s", Boolean.valueOf(z), Boolean.valueOf(c25822e.agP()));
            AppMethodBeat.m2505o(32121);
            return null;
        }
    }
}
