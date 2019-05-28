package com.tencent.p177mm.plugin.luckymoney.model;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p193c.C9014g;
import com.tencent.p177mm.p190at.p191a.p827a.C17926b.C17925a;
import com.tencent.p177mm.p190at.p191a.p827a.C25813a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p217ci.C32467c;
import com.tencent.p177mm.p217ci.C41931h;
import com.tencent.p177mm.plugin.luckymoney.p735b.C6964a;
import com.tencent.p177mm.plugin.luckymoney.p987a.C12405a;
import com.tencent.p177mm.plugin.luckymoney.p987a.C12405a.C12406a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.aoj;
import com.tencent.p177mm.protocal.protobuf.atb;
import com.tencent.p177mm.protocal.protobuf.atc;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C44421a.C40926a;
import java.io.File;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.l */
public final class C43258l implements C12405a {
    private static C41931h<C25815a> nXt = new C41931h(new C367881());

    /* renamed from: com.tencent.mm.plugin.luckymoney.model.l$a */
    interface C12430a {
        /* renamed from: a */
        void mo7795a(Bitmap bitmap, int i, String str);
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.model.l$2 */
    class C344452 implements C40926a<aoj> {
        C344452() {
        }

        /* renamed from: bX */
        public final /* synthetic */ void mo9356bX(Object obj) {
            AppMethodBeat.m2504i(42301);
            aoj aoj = (aoj) obj;
            C4990ab.m7416i("MicroMsg.LuckyMoneyEnvelopeLogic", "do get show source net callback");
            if (aoj != null) {
                C4990ab.m7417i("MicroMsg.LuckyMoneyEnvelopeLogic", "retcode: %s", Integer.valueOf(aoj.kCl));
                if (aoj.kCl == 0 && aoj.wsA != null) {
                    Iterator it = aoj.wsA.iterator();
                    while (it.hasNext()) {
                        atb atb = (atb) it.next();
                        C4990ab.m7417i("MicroMsg.LuckyMoneyEnvelopeLogic", "load resource: %s, %s", atb.wwP, atb.materialId);
                        if (atb.cuu <= 0) {
                            C43258l.this.mo24256a(atb.wwQ);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(42301);
        }

        /* renamed from: bY */
        public final /* bridge */ /* synthetic */ void mo9357bY(Object obj) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.model.l$1 */
    static class C367881 implements C32467c<C25815a> {
        C367881() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(42300);
            C17925a c17925a = new C17925a(C4996ah.getContext());
            c17925a.fHa = C25813a.m41070cs(1, 5);
            C25815a c25815a = new C25815a(c17925a.ahx());
            AppMethodBeat.m2505o(42300);
            return c25815a;
        }
    }

    static {
        AppMethodBeat.m2504i(42325);
        AppMethodBeat.m2505o(42325);
    }

    public final void bKL() {
        AppMethodBeat.m2504i(42311);
        C4990ab.m7416i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger laod envelope after receive");
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_INT_SYNC, Integer.valueOf(1));
        if (!((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LUCKY_MONEY_HAS_SHOW_NEW_FLAG_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            C16112c.m24429PK().mo28542a(C5127a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_STRING_SYNC, true);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LUCKY_MONEY_HAS_SHOW_NEW_FLAG_BOOLEAN_SYNC, Boolean.TRUE);
        }
        C1720g.m3540Rg().mo14541a(new C3381ag("v1.0", 1, (byte) 0), 0);
        C46061f bLp = C46061f.bLp();
        bLp.mo70317b(new C46059c(""));
        bLp.mo70316a(new C344452());
        AppMethodBeat.m2505o(42311);
    }

    /* renamed from: a */
    public final void mo24256a(atc atc) {
        AppMethodBeat.m2504i(42312);
        C4990ab.m7416i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger load envelope resources");
        if (atc != null) {
            if (!(C5046bo.isNullOrNil(atc.wwV) || C5046bo.isNullOrNil(atc.wwY))) {
                m76996a(atc.wwV, atc.wwY, null);
            }
            if (!(C5046bo.isNullOrNil(atc.wwX) || C5046bo.isNullOrNil(atc.wxa))) {
                m76996a(atc.wwX, atc.wxa, null);
            }
            if (!(C5046bo.isNullOrNil(atc.wwU) || C5046bo.isNullOrNil(atc.wxb))) {
                m76996a(atc.wwU, atc.wxb, null);
            }
            if (!(C5046bo.isNullOrNil(atc.wwW) || C5046bo.isNullOrNil(atc.wwZ))) {
                m76996a(atc.wwW, atc.wwZ, null);
            }
        }
        AppMethodBeat.m2505o(42312);
    }

    /* renamed from: a */
    private void m76994a(atb atb, int i, C12430a c12430a) {
        AppMethodBeat.m2504i(42313);
        C4990ab.m7417i("MicroMsg.LuckyMoneyEnvelopeLogic", "get envelope: %s", Integer.valueOf(i));
        if (atb == null) {
            AppMethodBeat.m2505o(42313);
        } else if (atb.cuu > 0) {
            int i2 = atb.cuu;
            C4990ab.m7417i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap subtype: %s, %s", Integer.valueOf(i2), Integer.valueOf(i));
            String xR = C43259m.m77005xR(i2);
            C43260n c43260n = new C43260n();
            c43260n.field_subtype = i2;
            Bitmap bitmap = null;
            if (!C6964a.bKN().bKM().mo10102b((C4925c) c43260n, new String[0])) {
                C43259m.bLy();
                C4990ab.m7421w("MicroMsg.LuckyMoneyEnvelopeLogic", "can't find subtype res: %s", Integer.valueOf(i2));
            } else if (i == 0) {
                File file = new File(xR, "bubble.png");
                C4990ab.m7416i("MicroMsg.LuckyMoneyEnvelopeLogic", "");
                bitmap = C43258l.m76997f(file, c43260n.field_bubbleMd5);
            } else if (i == 1 || i == 2) {
                bitmap = C43258l.m76997f(new File(xR, "cover.png"), c43260n.field_coverMd5);
            } else if (i == 3) {
                bitmap = C43258l.m76997f(new File(xR, "minilogo.png"), c43260n.field_coverMd5);
            }
            if (bitmap == null) {
                C7060h.pYm.mo15419k(991, 5, 1);
            }
            if (bitmap != null || atb.wwQ == null) {
                c12430a.mo7795a(bitmap, atb.cuu, "");
                AppMethodBeat.m2505o(42313);
                return;
            }
            C4990ab.m7417i("MicroMsg.LuckyMoneyEnvelopeLogic", "load subtype fail, try load from url: %s", Integer.valueOf(atb.cuu));
            m76995a(atb.wwQ, i, c12430a);
            AppMethodBeat.m2505o(42313);
        } else if (atb.wwQ != null) {
            m76995a(atb.wwQ, i, c12430a);
            AppMethodBeat.m2505o(42313);
        } else {
            C4990ab.m7420w("MicroMsg.LuckyMoneyEnvelopeLogic", "source object is null");
            AppMethodBeat.m2505o(42313);
        }
    }

    /* renamed from: a */
    private void m76995a(atc atc, int i, C12430a c12430a) {
        AppMethodBeat.m2504i(42314);
        C4990ab.m7417i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap by url: %s", Integer.valueOf(i));
        if (atc == null) {
            AppMethodBeat.m2505o(42314);
            return;
        }
        switch (i) {
            case 0:
                m76996a(atc.wwV, atc.wwY, c12430a);
                AppMethodBeat.m2505o(42314);
                return;
            case 1:
                m76996a(atc.wwW, atc.wwZ, c12430a);
                AppMethodBeat.m2505o(42314);
                return;
            case 2:
                m76996a(atc.wwX, atc.wxa, c12430a);
                AppMethodBeat.m2505o(42314);
                return;
            case 3:
                m76996a(atc.wwU, atc.wxb, c12430a);
                break;
        }
        AppMethodBeat.m2505o(42314);
    }

    /* renamed from: a */
    private void m76996a(String str, final String str2, final C12430a c12430a) {
        AppMethodBeat.m2504i(42315);
        C4990ab.m7417i("MicroMsg.LuckyMoneyEnvelopeLogic", "load image: %s, %s", str, str2);
        C43258l.bLw().mo43767a(str, null, C43258l.bLx().ahG(), new C9014g() {
            /* renamed from: sH */
            public final void mo7596sH(String str) {
            }

            /* renamed from: a */
            public final Bitmap mo7594a(String str, View view, C37477b c37477b) {
                return null;
            }

            /* renamed from: b */
            public final void mo7595b(String str, View view, C37477b c37477b) {
                AppMethodBeat.m2504i(42302);
                C4990ab.m7417i("MicroMsg.LuckyMoneyEnvelopeLogic", "load finish url: %s, %s, %s", str, Integer.valueOf(c37477b.status), Integer.valueOf(c37477b.from));
                if (c37477b.status == 0) {
                    C7060h.pYm.mo15419k(991, 6, 1);
                    if (c37477b.data != null) {
                        String w = C4995ag.m7429w(c37477b.data);
                        if (!(C5046bo.isNullOrNil(str2) || w.equals(str2))) {
                            C4990ab.m7417i("MicroMsg.LuckyMoneyEnvelopeLogic", "md5 not match: %s, %s", w, str2);
                            C7060h.pYm.mo15419k(991, 8, 1);
                            C7060h.pYm.mo8381e(16543, str, str2, w);
                        }
                    }
                } else if (c37477b.status == 1) {
                    C7060h.pYm.mo15419k(991, 7, 1);
                } else if (c37477b.status == 2) {
                    C7060h.pYm.mo15419k(991, 8, 1);
                } else if (c37477b.bitmap == null || c37477b.bitmap.isRecycled()) {
                    C7060h.pYm.mo15419k(991, 9, 1);
                }
                if (c12430a != null) {
                    c12430a.mo7795a(c37477b.bitmap, 0, str);
                }
                AppMethodBeat.m2505o(42302);
            }
        });
        AppMethodBeat.m2505o(42315);
    }

    /* renamed from: f */
    private static Bitmap m76997f(File file, String str) {
        AppMethodBeat.m2504i(42316);
        boolean exists = file.exists();
        boolean isFile = file.isFile();
        boolean equals = C1178g.m2589v(file).equals(str);
        C4990ab.m7417i("MicroMsg.LuckyMoneyEnvelopeLogic", "get from file: %s, %s, %s", Boolean.valueOf(exists), Boolean.valueOf(isFile), Boolean.valueOf(equals));
        if (exists && isFile && equals) {
            Bitmap decodeFile = MMBitmapFactory.decodeFile(file.getAbsolutePath());
            AppMethodBeat.m2505o(42316);
            return decodeFile;
        }
        if (!equals) {
            C7060h.pYm.mo15419k(991, 3, 1);
        }
        if (!exists) {
            C7060h.pYm.mo15419k(991, 4, 1);
        }
        C43259m.bLy();
        AppMethodBeat.m2505o(42316);
        return null;
    }

    /* renamed from: a */
    public final void mo24254a(final ImageView imageView, atb atb) {
        AppMethodBeat.m2504i(42317);
        C4990ab.m7416i("MicroMsg.LuckyMoneyEnvelopeLogic", "load detail view");
        if (imageView == null || atb == null) {
            AppMethodBeat.m2505o(42317);
            return;
        }
        m76994a(atb, 3, new C12430a() {
            /* renamed from: a */
            public final void mo7795a(final Bitmap bitmap, int i, String str) {
                AppMethodBeat.m2504i(42304);
                if (bitmap == null || bitmap.isRecycled()) {
                    C4990ab.m7421w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", Integer.valueOf(i), str);
                    AppMethodBeat.m2505o(42304);
                    return;
                }
                C43258l.m76992Y(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(42303);
                        imageView.setImageBitmap(C5056d.m7616a(bitmap, false, (float) C1338a.fromDPToPix(C4996ah.getContext(), 3)));
                        AppMethodBeat.m2505o(42303);
                    }
                });
                AppMethodBeat.m2505o(42304);
            }
        });
        AppMethodBeat.m2505o(42317);
    }

    /* renamed from: b */
    public final void mo24257b(final ImageView imageView, atb atb) {
        AppMethodBeat.m2504i(42318);
        C4990ab.m7416i("MicroMsg.LuckyMoneyEnvelopeLogic", "load detail view");
        if (imageView == null || atb == null) {
            AppMethodBeat.m2505o(42318);
            return;
        }
        m76994a(atb, 2, new C12430a() {
            /* renamed from: a */
            public final void mo7795a(final Bitmap bitmap, int i, String str) {
                AppMethodBeat.m2504i(42306);
                if (bitmap == null || bitmap.isRecycled()) {
                    C4990ab.m7421w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", Integer.valueOf(i), str);
                    AppMethodBeat.m2505o(42306);
                    return;
                }
                C43258l.m76992Y(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(42305);
                        imageView.setImageBitmap(bitmap);
                        AppMethodBeat.m2505o(42305);
                    }
                });
                AppMethodBeat.m2505o(42306);
            }
        });
        AppMethodBeat.m2505o(42318);
    }

    /* renamed from: a */
    public final void mo24255a(final ImageView imageView, atb atb, final C12406a c12406a) {
        AppMethodBeat.m2504i(42319);
        if (imageView == null || atb == null) {
            AppMethodBeat.m2505o(42319);
            return;
        }
        C4990ab.m7417i("MicroMsg.LuckyMoneyEnvelopeLogic", "load cover view: %s", atb.materialId);
        imageView.setTag(2131820639, atb.wwQ.wwW);
        imageView.setTag(2131820638, Integer.valueOf(atb.cuu));
        m76994a(atb, 1, new C12430a() {
            /* renamed from: a */
            public final void mo7795a(final Bitmap bitmap, final int i, final String str) {
                AppMethodBeat.m2504i(42308);
                if (bitmap == null || bitmap.isRecycled()) {
                    C4990ab.m7421w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", Integer.valueOf(i), str);
                    if (c12406a != null) {
                        c12406a.mo7846iH(false);
                    }
                    AppMethodBeat.m2505o(42308);
                    return;
                }
                C43258l.m76992Y(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(42307);
                        if (i > 0) {
                            if (((Integer) imageView.getTag(2131820638)).intValue() == i) {
                                imageView.setImageBitmap(C5056d.m7616a(bitmap, false, (float) C1338a.fromDPToPix(C4996ah.getContext(), 8)));
                                if (c12406a != null) {
                                    c12406a.mo7846iH(true);
                                    AppMethodBeat.m2505o(42307);
                                    return;
                                }
                            }
                            C4990ab.m7421w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss subtype: %s, %s", Integer.valueOf(((Integer) imageView.getTag(2131820638)).intValue()), Integer.valueOf(i));
                            AppMethodBeat.m2505o(42307);
                            return;
                        }
                        String str = (String) imageView.getTag(2131820639);
                        if (C5046bo.isNullOrNil(str) || !str.equals(str)) {
                            C4990ab.m7421w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", str, str);
                        } else {
                            imageView.setImageBitmap(C5056d.m7616a(bitmap, false, (float) C1338a.fromDPToPix(C4996ah.getContext(), 8)));
                            if (c12406a != null) {
                                c12406a.mo7846iH(true);
                                AppMethodBeat.m2505o(42307);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(42307);
                    }
                });
                AppMethodBeat.m2505o(42308);
            }
        });
        AppMethodBeat.m2505o(42319);
    }

    /* renamed from: a */
    public final void mo24253a(ImageView imageView, int i, int i2, atb atb, boolean z) {
        AppMethodBeat.m2504i(42320);
        C4990ab.m7417i("MicroMsg.LuckyMoneyEnvelopeLogic", "load chatting view: %s", Boolean.valueOf(z));
        if (imageView == null) {
            AppMethodBeat.m2505o(42320);
            return;
        }
        imageView.setTag(2131820639, atb.wwQ.wwV);
        imageView.setTag(2131820638, Integer.valueOf(atb.cuu));
        final ImageView imageView2 = imageView;
        final int i3 = i;
        final int i4 = i2;
        final boolean z2 = z;
        m76994a(atb, 0, new C12430a() {
            /* renamed from: a */
            public final void mo7795a(final Bitmap bitmap, final int i, final String str) {
                AppMethodBeat.m2504i(42310);
                if (bitmap == null || bitmap.isRecycled()) {
                    C4990ab.m7421w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", Integer.valueOf(i), str);
                    AppMethodBeat.m2505o(42310);
                    return;
                }
                C43258l.m76992Y(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(42309);
                        if (i > 0) {
                            if (((Integer) imageView2.getTag(2131820638)).intValue() == i) {
                                imageView2.setImageBitmap(C43258l.m76993a(bitmap, i3, i4, z2));
                                AppMethodBeat.m2505o(42309);
                                return;
                            }
                            C4990ab.m7421w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss subtype: %s, %s", Integer.valueOf(((Integer) imageView2.getTag(2131820638)).intValue()), Integer.valueOf(i));
                            AppMethodBeat.m2505o(42309);
                            return;
                        }
                        String str = (String) imageView2.getTag(2131820639);
                        if (C5046bo.isNullOrNil(str) || !str.equals(str)) {
                            C4990ab.m7421w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", str, str);
                            AppMethodBeat.m2505o(42309);
                            return;
                        }
                        imageView2.setImageBitmap(C43258l.m76993a(bitmap, i3, i4, z2));
                        AppMethodBeat.m2505o(42309);
                    }
                });
                AppMethodBeat.m2505o(42310);
            }
        });
        AppMethodBeat.m2505o(42320);
    }

    private static C25815a bLw() {
        AppMethodBeat.m2504i(42321);
        C25815a c25815a = (C25815a) nXt.get();
        AppMethodBeat.m2505o(42321);
        return c25815a;
    }

    private static C17927a bLx() {
        AppMethodBeat.m2504i(42322);
        C17927a c17927a = new C17927a();
        C6964a.bKN();
        c17927a.ePK = C6964a.bKP();
        c17927a.ePN = C1338a.m2868gd(C4996ah.getContext());
        c17927a.ePO = C1338a.m2869ge(C4996ah.getContext());
        c17927a.ePH = true;
        AppMethodBeat.m2505o(42322);
        return c17927a;
    }

    /* renamed from: Y */
    static /* synthetic */ void m76992Y(Runnable runnable) {
        AppMethodBeat.m2504i(42323);
        if (C5004al.isMainThread()) {
            runnable.run();
            AppMethodBeat.m2505o(42323);
            return;
        }
        C5004al.m7441d(runnable);
        AppMethodBeat.m2505o(42323);
    }

    /* renamed from: a */
    static /* synthetic */ Bitmap m76993a(Bitmap bitmap, int i, int i2, boolean z) {
        int i3;
        AppMethodBeat.m2504i(42324);
        C4990ab.m7411d("MicroMsg.LuckyMoneyEnvelopeLogic", "th: %s, tw: %s", Integer.valueOf(i), Integer.valueOf(i2));
        Bitmap b = C5056d.m7649b(bitmap, i2, i, false);
        if (z) {
            i3 = C25738R.drawable.b0l;
        } else {
            i3 = C25738R.drawable.b0u;
        }
        Bitmap d = C5056d.m7658d(b, i3);
        AppMethodBeat.m2505o(42324);
        return d;
    }
}
