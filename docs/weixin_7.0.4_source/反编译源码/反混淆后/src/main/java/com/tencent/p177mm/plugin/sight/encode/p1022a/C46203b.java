package com.tencent.p177mm.plugin.sight.encode.p1022a;

import android.database.Cursor;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sight.encode.a.b */
public final class C46203b {

    /* renamed from: com.tencent.mm.plugin.sight.encode.a.b$4 */
    public class C133364 implements Runnable {
        final /* synthetic */ String hPW;
        final /* synthetic */ C29022a qAo;
        final /* synthetic */ int qAp;
        final /* synthetic */ List qAr;
        final /* synthetic */ String qAs;

        public C133364(String str, List list, String str2, C29022a c29022a, int i) {
            this.hPW = str;
            this.qAr = list;
            this.qAs = str2;
            this.qAo = c29022a;
            this.qAp = i;
        }

        public final void run() {
            int i;
            long j;
            AppMethodBeat.m2504i(70361);
            String WO = C21846d.m33385WO(this.hPW);
            if (!C1173e.m2561ct(WO)) {
                C4990ab.m7420w("MicroMsg.SightRecorderHelper", "thumb data not found, try to create thumb");
                try {
                    C5056d.m7625a(C21846d.m33390ag(this.hPW, 320, 240), 60, CompressFormat.JPEG, WO, true);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.SightRecorderHelper", e, "", new Object[0]);
                    C4990ab.m7412e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
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
            Cursor a = C37961o.all().fni.mo10104a("SELECT MAX(masssendid) FROM videoinfo2", null, 2);
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
                    C4990ab.m7417i("MicroMsg.SightRecorderHelper", "do prepare sight message for %s, massSendId %d, massSendList %s, videoMD5 %s", str, Long.valueOf(j2), stringBuilder2, this.qAs);
                    String ug = C9720t.m17302ug(str);
                    C37961o.all();
                    String ui = C9720t.m17304ui(ug);
                    C37961o.all();
                    String uh = C9720t.m17303uh(ug);
                    C4990ab.m7417i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightThumbSize %d bytes", str, Long.valueOf(C1173e.m2577y(WO, ui)));
                    if (C1173e.m2577y(WO, ui) <= 0) {
                        C4990ab.m7413e("MicroMsg.SightRecorderHelper", "copy remux thumb path from %s to %s error, index %d", WO, ui, Integer.valueOf(i));
                        C46203b.m86397a(this.qAo, i);
                    } else {
                        C4990ab.m7417i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightFileSize %d bytes", str, Long.valueOf(C1173e.m2577y(this.hPW, uh)));
                        if (C1173e.m2577y(this.hPW, uh) <= 0) {
                            C4990ab.m7413e("MicroMsg.SightRecorderHelper", "copy remux video path from %s to %s error, index %d", this.hPW, uh, Integer.valueOf(i));
                            C46203b.m86397a(this.qAo, i);
                        } else {
                            int i3 = this.qAp;
                            uh = this.qAs;
                            C26493s c26493s = new C26493s();
                            c26493s.fileName = ug;
                            c26493s.fXd = i3;
                            c26493s.cIS = str;
                            c26493s.fWW = (String) C1720g.m3536RP().mo5239Ry().get(2, (Object) "");
                            c26493s.createTime = C5046bo.anT();
                            c26493s.fXb = C5046bo.anT();
                            c26493s.fXj = null;
                            c26493s.fUG = null;
                            c26493s.fXh = 0;
                            c26493s.fXk = 3;
                            C37961o.all();
                            i2 = C9720t.m17305uj(C9720t.m17303uh(ug));
                            if (i2 <= 0) {
                                C4990ab.m7412e("MicroMsg.VideoLogic", "initMassSendSight::get Video size failed:".concat(String.valueOf(ug)));
                            } else {
                                c26493s.frO = i2;
                                C37961o.all();
                                str = C9720t.m17304ui(ug);
                                i3 = C9720t.m17305uj(str);
                                if (i3 <= 0) {
                                    C4990ab.m7412e("MicroMsg.VideoLogic", "get Thumb size failed :" + str + " size:" + i3);
                                } else {
                                    c26493s.fXa = i3;
                                    C4990ab.m7416i("MicroMsg.VideoLogic", "initMassSendSight file:" + ug + " thumbsize:" + c26493s.fXa + " videosize:" + c26493s.frO);
                                    c26493s.status = 200;
                                    C4990ab.m7417i("MicroMsg.VideoLogic", "massSendId %d, videoMD5 %s, massSendList %s", Long.valueOf(j2), uh, stringBuilder2);
                                    c26493s.fXl = stringBuilder2;
                                    c26493s.fVs = j2;
                                    c26493s.cMW = uh;
                                    C37961o.all().mo21059b(c26493s);
                                }
                            }
                        }
                    }
                    i2 = i + 1;
                } else {
                    C26494u.m42254fV(j2);
                    C1173e.deleteFile(this.hPW);
                    C1173e.deleteFile(WO);
                    AppMethodBeat.m2505o(70361);
                    return;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.encode.a.b$a */
    public interface C29022a {
        void onError(int i);
    }

    /* renamed from: com.tencent.mm.plugin.sight.encode.a.b$3 */
    public class C349233 implements Runnable {
        final /* synthetic */ String cgl;
        final /* synthetic */ String hPW;
        final /* synthetic */ C29022a qAo;
        final /* synthetic */ int qAp;

        public C349233(String str, C29022a c29022a, String str2, int i) {
            this.cgl = str;
            this.qAo = c29022a;
            this.hPW = str2;
            this.qAp = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(70360);
            C4990ab.m7417i("MicroMsg.SightRecorderHelper", "do prepare sight message for %s", this.cgl);
            String ug = C9720t.m17302ug(this.cgl);
            if (-1 == C26494u.m42238a(ug, this.cgl, null, 62)) {
                C4990ab.m7413e("MicroMsg.SightRecorderHelper", "prepare sight error, filename %s", ug);
                C46203b.m86397a(this.qAo, -1);
                AppMethodBeat.m2505o(70360);
                return;
            }
            String WO = C21846d.m33385WO(this.hPW);
            if (!C1173e.m2561ct(WO)) {
                C4990ab.m7420w("MicroMsg.SightRecorderHelper", "thumb data not found, try to create thumb");
                try {
                    C5056d.m7625a(C21846d.m33390ag(this.hPW, 320, 240), 60, CompressFormat.JPEG, WO, true);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.SightRecorderHelper", e, "", new Object[0]);
                    C4990ab.m7412e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
                }
            }
            C37961o.all();
            C1173e.m2577y(WO, C9720t.m17304ui(ug));
            C37961o.all();
            C4990ab.m7417i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightFileSize %d bytes", this.cgl, Long.valueOf(C1173e.m2577y(this.hPW, C9720t.m17303uh(ug))));
            if (C1173e.m2577y(this.hPW, C9720t.m17303uh(ug)) <= 0) {
                C4990ab.m7413e("MicroMsg.SightRecorderHelper", "copy remux video path from %s to %s error", this.hPW, r0);
                C46203b.m86397a(this.qAo, -1);
                C26494u.m42261um(ug);
                AppMethodBeat.m2505o(70360);
                return;
            }
            C26494u.m42257n(ug, this.qAp, 62);
            C26494u.m42263uo(ug);
            C29022a c29022a = this.qAo;
            if (c29022a != null) {
                C5004al.m7441d(new C397162(c29022a));
            }
            C1173e.deleteFile(this.hPW);
            C1173e.deleteFile(WO);
            AppMethodBeat.m2505o(70360);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.encode.a.b$2 */
    static class C397162 implements Runnable {
        final /* synthetic */ C29022a qAo;
        final /* synthetic */ int val$index = -1;

        C397162(C29022a c29022a) {
            this.qAo = c29022a;
        }

        public final void run() {
        }
    }

    /* renamed from: a */
    public static void m86397a(final C29022a c29022a, final int i) {
        AppMethodBeat.m2504i(70362);
        if (c29022a == null) {
            AppMethodBeat.m2505o(70362);
            return;
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(70359);
                c29022a.onError(i);
                AppMethodBeat.m2505o(70359);
            }
        });
        AppMethodBeat.m2505o(70362);
    }
}
