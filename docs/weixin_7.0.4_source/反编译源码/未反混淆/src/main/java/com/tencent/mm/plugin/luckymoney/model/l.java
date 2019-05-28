package com.tencent.mm.plugin.luckymoney.model;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.a.d.b;
import com.tencent.mm.ci.c;
import com.tencent.mm.ci.h;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.protocal.protobuf.atc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.io.File;
import java.util.Iterator;

public final class l implements com.tencent.mm.plugin.luckymoney.a.a {
    private static h<com.tencent.mm.at.a.a> nXt = new h(new c<com.tencent.mm.at.a.a>() {
        public final /* synthetic */ Object get() {
            AppMethodBeat.i(42300);
            com.tencent.mm.at.a.a.b.a aVar = new com.tencent.mm.at.a.a.b.a(ah.getContext());
            aVar.fHa = com.tencent.mm.at.a.a.a.cs(1, 5);
            com.tencent.mm.at.a.a aVar2 = new com.tencent.mm.at.a.a(aVar.ahx());
            AppMethodBeat.o(42300);
            return aVar2;
        }
    });

    interface a {
        void a(Bitmap bitmap, int i, String str);
    }

    static {
        AppMethodBeat.i(42325);
        AppMethodBeat.o(42325);
    }

    public final void bKL() {
        AppMethodBeat.i(42311);
        ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger laod envelope after receive");
        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_INT_SYNC, Integer.valueOf(1));
        if (!((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_LUCKY_MONEY_HAS_SHOW_NEW_FLAG_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            com.tencent.mm.x.c.PK().a(com.tencent.mm.storage.ac.a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_STRING_SYNC, true);
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_LUCKY_MONEY_HAS_SHOW_NEW_FLAG_BOOLEAN_SYNC, Boolean.TRUE);
        }
        g.Rg().a(new ag("v1.0", 1, (byte) 0), 0);
        f bLp = f.bLp();
        bLp.b(new c(""));
        bLp.a(new com.tencent.mm.wallet_core.c.a.a<aoj>() {
            public final /* synthetic */ void bX(Object obj) {
                AppMethodBeat.i(42301);
                aoj aoj = (aoj) obj;
                ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do get show source net callback");
                if (aoj != null) {
                    ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "retcode: %s", Integer.valueOf(aoj.kCl));
                    if (aoj.kCl == 0 && aoj.wsA != null) {
                        Iterator it = aoj.wsA.iterator();
                        while (it.hasNext()) {
                            atb atb = (atb) it.next();
                            ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load resource: %s, %s", atb.wwP, atb.materialId);
                            if (atb.cuu <= 0) {
                                l.this.a(atb.wwQ);
                            }
                        }
                    }
                }
                AppMethodBeat.o(42301);
            }

            public final /* bridge */ /* synthetic */ void bY(Object obj) {
            }
        });
        AppMethodBeat.o(42311);
    }

    public final void a(atc atc) {
        AppMethodBeat.i(42312);
        ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger load envelope resources");
        if (atc != null) {
            if (!(bo.isNullOrNil(atc.wwV) || bo.isNullOrNil(atc.wwY))) {
                a(atc.wwV, atc.wwY, null);
            }
            if (!(bo.isNullOrNil(atc.wwX) || bo.isNullOrNil(atc.wxa))) {
                a(atc.wwX, atc.wxa, null);
            }
            if (!(bo.isNullOrNil(atc.wwU) || bo.isNullOrNil(atc.wxb))) {
                a(atc.wwU, atc.wxb, null);
            }
            if (!(bo.isNullOrNil(atc.wwW) || bo.isNullOrNil(atc.wwZ))) {
                a(atc.wwW, atc.wwZ, null);
            }
        }
        AppMethodBeat.o(42312);
    }

    private void a(atb atb, int i, a aVar) {
        AppMethodBeat.i(42313);
        ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get envelope: %s", Integer.valueOf(i));
        if (atb == null) {
            AppMethodBeat.o(42313);
        } else if (atb.cuu > 0) {
            int i2 = atb.cuu;
            ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap subtype: %s, %s", Integer.valueOf(i2), Integer.valueOf(i));
            String xR = m.xR(i2);
            n nVar = new n();
            nVar.field_subtype = i2;
            Bitmap bitmap = null;
            if (!com.tencent.mm.plugin.luckymoney.b.a.bKN().bKM().b((com.tencent.mm.sdk.e.c) nVar, new String[0])) {
                m.bLy();
                ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "can't find subtype res: %s", Integer.valueOf(i2));
            } else if (i == 0) {
                File file = new File(xR, "bubble.png");
                ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "");
                bitmap = f(file, nVar.field_bubbleMd5);
            } else if (i == 1 || i == 2) {
                bitmap = f(new File(xR, "cover.png"), nVar.field_coverMd5);
            } else if (i == 3) {
                bitmap = f(new File(xR, "minilogo.png"), nVar.field_coverMd5);
            }
            if (bitmap == null) {
                com.tencent.mm.plugin.report.service.h.pYm.k(991, 5, 1);
            }
            if (bitmap != null || atb.wwQ == null) {
                aVar.a(bitmap, atb.cuu, "");
                AppMethodBeat.o(42313);
                return;
            }
            ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load subtype fail, try load from url: %s", Integer.valueOf(atb.cuu));
            a(atb.wwQ, i, aVar);
            AppMethodBeat.o(42313);
        } else if (atb.wwQ != null) {
            a(atb.wwQ, i, aVar);
            AppMethodBeat.o(42313);
        } else {
            ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "source object is null");
            AppMethodBeat.o(42313);
        }
    }

    private void a(atc atc, int i, a aVar) {
        AppMethodBeat.i(42314);
        ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap by url: %s", Integer.valueOf(i));
        if (atc == null) {
            AppMethodBeat.o(42314);
            return;
        }
        switch (i) {
            case 0:
                a(atc.wwV, atc.wwY, aVar);
                AppMethodBeat.o(42314);
                return;
            case 1:
                a(atc.wwW, atc.wwZ, aVar);
                AppMethodBeat.o(42314);
                return;
            case 2:
                a(atc.wwX, atc.wxa, aVar);
                AppMethodBeat.o(42314);
                return;
            case 3:
                a(atc.wwU, atc.wxb, aVar);
                break;
        }
        AppMethodBeat.o(42314);
    }

    private void a(String str, final String str2, final a aVar) {
        AppMethodBeat.i(42315);
        ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load image: %s, %s", str, str2);
        bLw().a(str, null, bLx().ahG(), new com.tencent.mm.at.a.c.g() {
            public final void sH(String str) {
            }

            public final Bitmap a(String str, View view, b bVar) {
                return null;
            }

            public final void b(String str, View view, b bVar) {
                AppMethodBeat.i(42302);
                ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load finish url: %s, %s, %s", str, Integer.valueOf(bVar.status), Integer.valueOf(bVar.from));
                if (bVar.status == 0) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(991, 6, 1);
                    if (bVar.data != null) {
                        String w = ag.w(bVar.data);
                        if (!(bo.isNullOrNil(str2) || w.equals(str2))) {
                            ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "md5 not match: %s, %s", w, str2);
                            com.tencent.mm.plugin.report.service.h.pYm.k(991, 8, 1);
                            com.tencent.mm.plugin.report.service.h.pYm.e(16543, str, str2, w);
                        }
                    }
                } else if (bVar.status == 1) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(991, 7, 1);
                } else if (bVar.status == 2) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(991, 8, 1);
                } else if (bVar.bitmap == null || bVar.bitmap.isRecycled()) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(991, 9, 1);
                }
                if (aVar != null) {
                    aVar.a(bVar.bitmap, 0, str);
                }
                AppMethodBeat.o(42302);
            }
        });
        AppMethodBeat.o(42315);
    }

    private static Bitmap f(File file, String str) {
        AppMethodBeat.i(42316);
        boolean exists = file.exists();
        boolean isFile = file.isFile();
        boolean equals = com.tencent.mm.a.g.v(file).equals(str);
        ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get from file: %s, %s, %s", Boolean.valueOf(exists), Boolean.valueOf(isFile), Boolean.valueOf(equals));
        if (exists && isFile && equals) {
            Bitmap decodeFile = MMBitmapFactory.decodeFile(file.getAbsolutePath());
            AppMethodBeat.o(42316);
            return decodeFile;
        }
        if (!equals) {
            com.tencent.mm.plugin.report.service.h.pYm.k(991, 3, 1);
        }
        if (!exists) {
            com.tencent.mm.plugin.report.service.h.pYm.k(991, 4, 1);
        }
        m.bLy();
        AppMethodBeat.o(42316);
        return null;
    }

    public final void a(final ImageView imageView, atb atb) {
        AppMethodBeat.i(42317);
        ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load detail view");
        if (imageView == null || atb == null) {
            AppMethodBeat.o(42317);
            return;
        }
        a(atb, 3, new a() {
            public final void a(final Bitmap bitmap, int i, String str) {
                AppMethodBeat.i(42304);
                if (bitmap == null || bitmap.isRecycled()) {
                    ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", Integer.valueOf(i), str);
                    AppMethodBeat.o(42304);
                    return;
                }
                l.Y(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(42303);
                        imageView.setImageBitmap(d.a(bitmap, false, (float) com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 3)));
                        AppMethodBeat.o(42303);
                    }
                });
                AppMethodBeat.o(42304);
            }
        });
        AppMethodBeat.o(42317);
    }

    public final void b(final ImageView imageView, atb atb) {
        AppMethodBeat.i(42318);
        ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load detail view");
        if (imageView == null || atb == null) {
            AppMethodBeat.o(42318);
            return;
        }
        a(atb, 2, new a() {
            public final void a(final Bitmap bitmap, int i, String str) {
                AppMethodBeat.i(42306);
                if (bitmap == null || bitmap.isRecycled()) {
                    ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", Integer.valueOf(i), str);
                    AppMethodBeat.o(42306);
                    return;
                }
                l.Y(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(42305);
                        imageView.setImageBitmap(bitmap);
                        AppMethodBeat.o(42305);
                    }
                });
                AppMethodBeat.o(42306);
            }
        });
        AppMethodBeat.o(42318);
    }

    public final void a(final ImageView imageView, atb atb, final com.tencent.mm.plugin.luckymoney.a.a.a aVar) {
        AppMethodBeat.i(42319);
        if (imageView == null || atb == null) {
            AppMethodBeat.o(42319);
            return;
        }
        ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load cover view: %s", atb.materialId);
        imageView.setTag(R.id.bv, atb.wwQ.wwW);
        imageView.setTag(R.id.bu, Integer.valueOf(atb.cuu));
        a(atb, 1, new a() {
            public final void a(final Bitmap bitmap, final int i, final String str) {
                AppMethodBeat.i(42308);
                if (bitmap == null || bitmap.isRecycled()) {
                    ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", Integer.valueOf(i), str);
                    if (aVar != null) {
                        aVar.iH(false);
                    }
                    AppMethodBeat.o(42308);
                    return;
                }
                l.Y(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(42307);
                        if (i > 0) {
                            if (((Integer) imageView.getTag(R.id.bu)).intValue() == i) {
                                imageView.setImageBitmap(d.a(bitmap, false, (float) com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 8)));
                                if (aVar != null) {
                                    aVar.iH(true);
                                    AppMethodBeat.o(42307);
                                    return;
                                }
                            }
                            ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss subtype: %s, %s", Integer.valueOf(((Integer) imageView.getTag(R.id.bu)).intValue()), Integer.valueOf(i));
                            AppMethodBeat.o(42307);
                            return;
                        }
                        String str = (String) imageView.getTag(R.id.bv);
                        if (bo.isNullOrNil(str) || !str.equals(str)) {
                            ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", str, str);
                        } else {
                            imageView.setImageBitmap(d.a(bitmap, false, (float) com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 8)));
                            if (aVar != null) {
                                aVar.iH(true);
                                AppMethodBeat.o(42307);
                                return;
                            }
                        }
                        AppMethodBeat.o(42307);
                    }
                });
                AppMethodBeat.o(42308);
            }
        });
        AppMethodBeat.o(42319);
    }

    public final void a(ImageView imageView, int i, int i2, atb atb, boolean z) {
        AppMethodBeat.i(42320);
        ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load chatting view: %s", Boolean.valueOf(z));
        if (imageView == null) {
            AppMethodBeat.o(42320);
            return;
        }
        imageView.setTag(R.id.bv, atb.wwQ.wwV);
        imageView.setTag(R.id.bu, Integer.valueOf(atb.cuu));
        final ImageView imageView2 = imageView;
        final int i3 = i;
        final int i4 = i2;
        final boolean z2 = z;
        a(atb, 0, new a() {
            public final void a(final Bitmap bitmap, final int i, final String str) {
                AppMethodBeat.i(42310);
                if (bitmap == null || bitmap.isRecycled()) {
                    ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", Integer.valueOf(i), str);
                    AppMethodBeat.o(42310);
                    return;
                }
                l.Y(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(42309);
                        if (i > 0) {
                            if (((Integer) imageView2.getTag(R.id.bu)).intValue() == i) {
                                imageView2.setImageBitmap(l.a(bitmap, i3, i4, z2));
                                AppMethodBeat.o(42309);
                                return;
                            }
                            ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss subtype: %s, %s", Integer.valueOf(((Integer) imageView2.getTag(R.id.bu)).intValue()), Integer.valueOf(i));
                            AppMethodBeat.o(42309);
                            return;
                        }
                        String str = (String) imageView2.getTag(R.id.bv);
                        if (bo.isNullOrNil(str) || !str.equals(str)) {
                            ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", str, str);
                            AppMethodBeat.o(42309);
                            return;
                        }
                        imageView2.setImageBitmap(l.a(bitmap, i3, i4, z2));
                        AppMethodBeat.o(42309);
                    }
                });
                AppMethodBeat.o(42310);
            }
        });
        AppMethodBeat.o(42320);
    }

    private static com.tencent.mm.at.a.a bLw() {
        AppMethodBeat.i(42321);
        com.tencent.mm.at.a.a aVar = (com.tencent.mm.at.a.a) nXt.get();
        AppMethodBeat.o(42321);
        return aVar;
    }

    private static com.tencent.mm.at.a.a.c.a bLx() {
        AppMethodBeat.i(42322);
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        com.tencent.mm.plugin.luckymoney.b.a.bKN();
        aVar.ePK = com.tencent.mm.plugin.luckymoney.b.a.bKP();
        aVar.ePN = com.tencent.mm.bz.a.gd(ah.getContext());
        aVar.ePO = com.tencent.mm.bz.a.ge(ah.getContext());
        aVar.ePH = true;
        AppMethodBeat.o(42322);
        return aVar;
    }

    static /* synthetic */ void Y(Runnable runnable) {
        AppMethodBeat.i(42323);
        if (al.isMainThread()) {
            runnable.run();
            AppMethodBeat.o(42323);
            return;
        }
        al.d(runnable);
        AppMethodBeat.o(42323);
    }

    static /* synthetic */ Bitmap a(Bitmap bitmap, int i, int i2, boolean z) {
        int i3;
        AppMethodBeat.i(42324);
        ab.d("MicroMsg.LuckyMoneyEnvelopeLogic", "th: %s, tw: %s", Integer.valueOf(i), Integer.valueOf(i2));
        Bitmap b = d.b(bitmap, i2, i, false);
        if (z) {
            i3 = R.drawable.b0l;
        } else {
            i3 = R.drawable.b0u;
        }
        Bitmap d = d.d(b, i3);
        AppMethodBeat.o(42324);
        return d;
    }
}
