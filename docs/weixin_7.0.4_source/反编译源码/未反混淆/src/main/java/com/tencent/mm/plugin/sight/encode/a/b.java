package com.tencent.mm.plugin.sight.encode.a;

import android.database.Cursor;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class b {

    /* renamed from: com.tencent.mm.plugin.sight.encode.a.b$4 */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ String hPW;
        final /* synthetic */ a qAo;
        final /* synthetic */ int qAp;
        final /* synthetic */ List qAr;
        final /* synthetic */ String qAs;

        public AnonymousClass4(String str, List list, String str2, a aVar, int i) {
            this.hPW = str;
            this.qAr = list;
            this.qAs = str2;
            this.qAo = aVar;
            this.qAp = i;
        }

        public final void run() {
            int i;
            long j;
            AppMethodBeat.i(70361);
            String WO = d.WO(this.hPW);
            if (!e.ct(WO)) {
                ab.w("MicroMsg.SightRecorderHelper", "thumb data not found, try to create thumb");
                try {
                    com.tencent.mm.sdk.platformtools.d.a(d.ag(this.hPW, 320, 240), 60, CompressFormat.JPEG, WO, true);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.SightRecorderHelper", e, "", new Object[0]);
                    ab.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String) this.qAr.get(0));
            int i2 = 1;
            while (true) {
                i = i2;
                if (i >= this.qAr.size()) {
                    break;
                }
                stringBuilder.append(',');
                stringBuilder.append((String) this.qAr.get(i));
                i2 = i + 1;
            }
            String stringBuilder2 = stringBuilder.toString();
            Cursor a = o.all().fni.a("SELECT MAX(masssendid) FROM videoinfo2", null, 2);
            if (a == null) {
                j = 0;
            } else {
                j = 0;
                if (a.moveToFirst()) {
                    j = a.getLong(0);
                }
                a.close();
            }
            long j2 = 1 + j;
            i2 = 0;
            while (true) {
                i = i2;
                if (i < this.qAr.size()) {
                    String str = (String) this.qAr.get(i);
                    ab.i("MicroMsg.SightRecorderHelper", "do prepare sight message for %s, massSendId %d, massSendList %s, videoMD5 %s", str, Long.valueOf(j2), stringBuilder2, this.qAs);
                    String ug = t.ug(str);
                    o.all();
                    String ui = t.ui(ug);
                    o.all();
                    String uh = t.uh(ug);
                    ab.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightThumbSize %d bytes", str, Long.valueOf(e.y(WO, ui)));
                    if (e.y(WO, ui) <= 0) {
                        ab.e("MicroMsg.SightRecorderHelper", "copy remux thumb path from %s to %s error, index %d", WO, ui, Integer.valueOf(i));
                        b.a(this.qAo, i);
                    } else {
                        ab.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightFileSize %d bytes", str, Long.valueOf(e.y(this.hPW, uh)));
                        if (e.y(this.hPW, uh) <= 0) {
                            ab.e("MicroMsg.SightRecorderHelper", "copy remux video path from %s to %s error, index %d", this.hPW, uh, Integer.valueOf(i));
                            b.a(this.qAo, i);
                        } else {
                            int i3 = this.qAp;
                            uh = this.qAs;
                            s sVar = new s();
                            sVar.fileName = ug;
                            sVar.fXd = i3;
                            sVar.cIS = str;
                            sVar.fWW = (String) g.RP().Ry().get(2, (Object) "");
                            sVar.createTime = bo.anT();
                            sVar.fXb = bo.anT();
                            sVar.fXj = null;
                            sVar.fUG = null;
                            sVar.fXh = 0;
                            sVar.fXk = 3;
                            o.all();
                            i2 = t.uj(t.uh(ug));
                            if (i2 <= 0) {
                                ab.e("MicroMsg.VideoLogic", "initMassSendSight::get Video size failed:".concat(String.valueOf(ug)));
                            } else {
                                sVar.frO = i2;
                                o.all();
                                str = t.ui(ug);
                                i3 = t.uj(str);
                                if (i3 <= 0) {
                                    ab.e("MicroMsg.VideoLogic", "get Thumb size failed :" + str + " size:" + i3);
                                } else {
                                    sVar.fXa = i3;
                                    ab.i("MicroMsg.VideoLogic", "initMassSendSight file:" + ug + " thumbsize:" + sVar.fXa + " videosize:" + sVar.frO);
                                    sVar.status = 200;
                                    ab.i("MicroMsg.VideoLogic", "massSendId %d, videoMD5 %s, massSendList %s", Long.valueOf(j2), uh, stringBuilder2);
                                    sVar.fXl = stringBuilder2;
                                    sVar.fVs = j2;
                                    sVar.cMW = uh;
                                    o.all().b(sVar);
                                }
                            }
                        }
                    }
                    i2 = i + 1;
                } else {
                    u.fV(j2);
                    e.deleteFile(this.hPW);
                    e.deleteFile(WO);
                    AppMethodBeat.o(70361);
                    return;
                }
            }
        }
    }

    public interface a {
        void onError(int i);
    }

    /* renamed from: com.tencent.mm.plugin.sight.encode.a.b$3 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ String cgl;
        final /* synthetic */ String hPW;
        final /* synthetic */ a qAo;
        final /* synthetic */ int qAp;

        public AnonymousClass3(String str, a aVar, String str2, int i) {
            this.cgl = str;
            this.qAo = aVar;
            this.hPW = str2;
            this.qAp = i;
        }

        public final void run() {
            AppMethodBeat.i(70360);
            ab.i("MicroMsg.SightRecorderHelper", "do prepare sight message for %s", this.cgl);
            String ug = t.ug(this.cgl);
            if (-1 == u.a(ug, this.cgl, null, 62)) {
                ab.e("MicroMsg.SightRecorderHelper", "prepare sight error, filename %s", ug);
                b.a(this.qAo, -1);
                AppMethodBeat.o(70360);
                return;
            }
            String WO = d.WO(this.hPW);
            if (!e.ct(WO)) {
                ab.w("MicroMsg.SightRecorderHelper", "thumb data not found, try to create thumb");
                try {
                    com.tencent.mm.sdk.platformtools.d.a(d.ag(this.hPW, 320, 240), 60, CompressFormat.JPEG, WO, true);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.SightRecorderHelper", e, "", new Object[0]);
                    ab.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
                }
            }
            o.all();
            e.y(WO, t.ui(ug));
            o.all();
            ab.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightFileSize %d bytes", this.cgl, Long.valueOf(e.y(this.hPW, t.uh(ug))));
            if (e.y(this.hPW, t.uh(ug)) <= 0) {
                ab.e("MicroMsg.SightRecorderHelper", "copy remux video path from %s to %s error", this.hPW, r0);
                b.a(this.qAo, -1);
                u.um(ug);
                AppMethodBeat.o(70360);
                return;
            }
            u.n(ug, this.qAp, 62);
            u.uo(ug);
            a aVar = this.qAo;
            if (aVar != null) {
                al.d(new AnonymousClass2(aVar));
            }
            e.deleteFile(this.hPW);
            e.deleteFile(WO);
            AppMethodBeat.o(70360);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.encode.a.b$2 */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ a qAo;
        final /* synthetic */ int val$index = -1;

        AnonymousClass2(a aVar) {
            this.qAo = aVar;
        }

        public final void run() {
        }
    }

    public static void a(final a aVar, final int i) {
        AppMethodBeat.i(70362);
        if (aVar == null) {
            AppMethodBeat.o(70362);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(70359);
                aVar.onError(i);
                AppMethodBeat.o(70359);
            }
        });
        AppMethodBeat.o(70362);
    }
}
