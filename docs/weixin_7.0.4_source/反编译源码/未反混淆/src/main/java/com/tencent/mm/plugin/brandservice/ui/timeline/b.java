package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.d.a;
import com.tencent.mm.at.e;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.q;
import java.util.HashMap;

public final class b implements a {
    int jNL;
    public HashMap<Long, Integer> jNM = new HashMap();
    private h jNN;

    public b(h hVar) {
        AppMethodBeat.i(14133);
        this.jNN = hVar;
        AppMethodBeat.o(14133);
    }

    private void a(e eVar, q qVar, int i, ImageView imageView) {
        AppMethodBeat.i(14134);
        if (o.ahm().a(eVar.fDy, qVar.field_msgId, 0, Integer.valueOf(i), R.drawable.b0p, this, 0, false) == -2) {
            ab.w("MicroMsg.BizTimeLineImgMsgHandler", "it is already download image finish, but imgInfo is old, search db and repair.");
            e b = b(qVar);
            if (b == null) {
                ab.w("MicroMsg.BizTimeLineImgMsgHandler", "get imgInfo by db but it is null.");
                AppMethodBeat.o(14134);
                return;
            }
            String g = g(b);
            if (com.tencent.mm.vfs.e.ct(g)) {
                a(g, imageView);
            }
        }
        AppMethodBeat.o(14134);
    }

    public final void a(q qVar, int i, ImageView imageView, int i2) {
        AppMethodBeat.i(14135);
        this.jNL = i2;
        if (gF(qVar.field_msgId) == 2 || gF(qVar.field_msgId) == 3) {
            AppMethodBeat.o(14135);
            return;
        }
        e b = b(qVar);
        if (b != null) {
            String g = g(b);
            if (com.tencent.mm.vfs.e.ct(g)) {
                a(g, imageView);
                l(qVar.field_msgId, 1);
                AppMethodBeat.o(14135);
                return;
            }
            a(b, qVar, i, imageView);
            AppMethodBeat.o(14135);
            return;
        }
        ab.w("MicroMsg.BizTimeLineImgMsgHandler", "showImg img info is null. %d/%d", Long.valueOf(qVar.field_msgId), Long.valueOf(qVar.field_msgSvrId));
        AppMethodBeat.o(14135);
    }

    private void a(String str, ImageView imageView) {
        AppMethodBeat.i(14136);
        final int i = this.jNL != 0 ? R.drawable.axk : 0;
        com.tencent.mm.at.a.a ahp = o.ahp();
        c.a aVar = new c.a();
        aVar.ePX = "biz_nor_img".concat(String.valueOf(i));
        aVar.ePV = R.color.k8;
        aVar.fHe = 1;
        ahp.a(str, imageView, aVar.ahG(), new g() {
            public final void sH(String str) {
            }

            public final Bitmap a(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                AppMethodBeat.i(14132);
                if (i == 0) {
                    AppMethodBeat.o(14132);
                    return null;
                } else if (bVar == null || bVar.bitmap == null || bVar.bitmap.isRecycled()) {
                    ab.w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap bitmap is null");
                    AppMethodBeat.o(14132);
                    return null;
                } else if (bo.isNullOrNil(str)) {
                    ab.w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap url is null");
                    AppMethodBeat.o(14132);
                    return null;
                } else {
                    try {
                        int i;
                        int gd = com.tencent.mm.bz.a.gd(view.getContext()) - ((int) (com.tencent.mm.bz.a.getDensity(view.getContext()) * 16.0f));
                        if (b.this.jNL != 0) {
                            i = b.this.jNL;
                        } else {
                            i = (int) (((double) gd) / 2.35d);
                        }
                        Bitmap b = d.b(bVar.bitmap, gd, i, true);
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b, gd, i, true);
                        if (!(createScaledBitmap == b || b == null || b.isRecycled())) {
                            ab.i("MicroMsg.BizTimeLineImgMsgHandler", "bitmap recycled %s", b);
                            b.recycle();
                        }
                        Bitmap d = d.d(createScaledBitmap, i);
                        if (!(createScaledBitmap == null || createScaledBitmap.isRecycled())) {
                            createScaledBitmap.recycle();
                        }
                        AppMethodBeat.o(14132);
                        return d;
                    } catch (OutOfMemoryError e) {
                        ab.w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap OutOfMemoryError %s", e.getMessage());
                        AppMethodBeat.o(14132);
                        return null;
                    }
                }
            }

            public final void b(String str, View view, com.tencent.mm.at.a.d.b bVar) {
            }
        });
        AppMethodBeat.o(14136);
    }

    private static String g(e eVar) {
        String str = null;
        AppMethodBeat.i(14137);
        if (eVar == null) {
            AppMethodBeat.o(14137);
        } else {
            String str2 = eVar.fDz;
            if (eVar.agQ()) {
                String d = o.ahl().d(eVar);
                if (d != null) {
                    d = o.ahl().q(d, "", "");
                    if (com.tencent.mm.vfs.e.ct(d)) {
                        ab.i("MicroMsg.BizTimeLineImgMsgHandler", "hasHdImg");
                        str = d;
                    }
                }
            }
            if (str == null) {
                str = o.ahl().q(str2, "", "");
            }
            AppMethodBeat.o(14137);
        }
        return str;
    }

    private static e b(q qVar) {
        AppMethodBeat.i(14138);
        e eVar = null;
        if (qVar.field_msgId > 0) {
            eVar = o.ahl().fJ(qVar.field_msgId);
        }
        if ((eVar == null || eVar.fDy <= 0) && qVar.field_msgSvrId > 0) {
            eVar = o.ahl().fI(qVar.field_msgSvrId);
        }
        AppMethodBeat.o(14138);
        return eVar;
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, m mVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, m mVar) {
        AppMethodBeat.i(14139);
        if (i3 == 0 && i4 == 0) {
            l(j2, 1);
            this.jNN.aWv();
            AppMethodBeat.o(14139);
            return;
        }
        ab.i("MicroMsg.BizTimeLineImgMsgHandler", "onImgTaskEnd errType %d, errCode %d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i4 == -5103059) {
            l(j2, 2);
            AppMethodBeat.o(14139);
            return;
        }
        l(j2, 3);
        AppMethodBeat.o(14139);
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
    }

    private int gF(long j) {
        AppMethodBeat.i(14140);
        if (this.jNM.containsKey(Long.valueOf(j))) {
            int intValue = ((Integer) this.jNM.get(Long.valueOf(j))).intValue();
            AppMethodBeat.o(14140);
            return intValue;
        }
        AppMethodBeat.o(14140);
        return 0;
    }

    private void l(long j, int i) {
        AppMethodBeat.i(14141);
        this.jNM.put(Long.valueOf(j), Integer.valueOf(i));
        AppMethodBeat.o(14141);
    }
}
