package com.tencent.p177mm.modelvideo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p1380j.C45291a;
import com.tencent.p177mm.compatible.p1380j.C45291a.C41941a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.modelvideo.c */
public final class C1878c {
    public static final int fUE = C42164b.m74342Nd();
    Context context = null;
    int duration = 0;
    public C1877a fUF = null;
    String fUG = null;
    final AsyncTask<String, Integer, String> fUH = new C18791();
    String fileName = null;
    Intent intent = null;
    String thumbPath = null;
    String videoPath = null;

    /* renamed from: com.tencent.mm.modelvideo.c$a */
    public interface C1877a {
        /* renamed from: b */
        void mo5453b(int i, String str, String str2, int i2);
    }

    /* renamed from: com.tencent.mm.modelvideo.c$1 */
    class C18791 extends AsyncTask<String, Integer, String> {
        int ret = 0;

        C18791() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(50625);
            String akS = akS();
            AppMethodBeat.m2505o(50625);
            return akS;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0106 A:{SYNTHETIC, Splitter:B:25:0x0106} */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0132  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0141  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0106 A:{SYNTHETIC, Splitter:B:25:0x0106} */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0132  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0141  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private String akS() {
            C41941a j;
            Throwable e;
            AppMethodBeat.m2504i(50623);
            this.ret = 0;
            boolean is2G = C5023at.is2G(C4996ah.getContext());
            try {
                j = C45291a.m83515j(C1878c.this.context, C1878c.this.intent);
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.ImportVideo", "exception:%s", C5046bo.m7574l(e2));
                j = null;
            }
            if (j == null) {
                C4990ab.m7412e("MicroMsg.ImportVideo", "GetVideoMetadata filed.");
                C7060h.pYm.mo8378a(106, 244, 1, false);
                this.ret = -50005;
                AppMethodBeat.m2505o(50623);
                return null;
            }
            C1878c.this.fUG = j.filename;
            int asZ = (int) C5730e.asZ(C1878c.this.fUG);
            C4990ab.m7417i("MicroMsg.ImportVideo", "import file is2G:%b len:%d duration:%d path:%s ", Boolean.valueOf(is2G), Integer.valueOf(asZ), Integer.valueOf(j.duration), C1878c.this.fUG);
            if (asZ <= 0) {
                C7060h.pYm.mo8378a(106, 244, 1, false);
                this.ret = -50001;
                AppMethodBeat.m2505o(50623);
                return null;
            }
            if (asZ > (is2G ? 10485760 : C1878c.fUE)) {
                C7060h.pYm.mo8378a(106, 245, 1, false);
                this.ret = -50002;
                AppMethodBeat.m2505o(50623);
                return null;
            }
            C5730e.m8644y(C1878c.this.fUG, C1878c.this.videoPath);
            C1878c.this.duration = j.duration / 1000;
            Object obj = 1;
            if (j.bitmap != null) {
                try {
                    C5056d.m7625a(j.bitmap, 60, CompressFormat.JPEG, C1878c.this.thumbPath, true);
                    try {
                        C7060h.pYm.mo8378a(106, 231, 1, false);
                        obj = null;
                    } catch (Exception e3) {
                        e = e3;
                        obj = null;
                        C4990ab.m7413e("MicroMsg.ImportVideo", "exception:%s", C5046bo.m7574l(e));
                        if (obj != null) {
                        }
                        if (!C5730e.m8628ct(C1878c.this.videoPath)) {
                        }
                        if (!C5730e.m8628ct(C1878c.this.thumbPath)) {
                        }
                        AppMethodBeat.m2505o(50623);
                        return null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    C4990ab.m7413e("MicroMsg.ImportVideo", "exception:%s", C5046bo.m7574l(e));
                    if (obj != null) {
                    }
                    if (C5730e.m8628ct(C1878c.this.videoPath)) {
                    }
                    if (C5730e.m8628ct(C1878c.this.thumbPath)) {
                    }
                    AppMethodBeat.m2505o(50623);
                    return null;
                }
            }
            if (obj != null) {
                try {
                    C7060h.pYm.mo8378a(106, 232, 1, false);
                    C5056d.m7625a(C5056d.m7644au(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, C1878c.this.thumbPath, true);
                } catch (Exception e22) {
                    C4990ab.m7413e("MicroMsg.ImportVideo", "exception:%s", C5046bo.m7574l(e22));
                }
            }
            if (C5730e.m8628ct(C1878c.this.videoPath)) {
                this.ret = -50003;
            }
            if (C5730e.m8628ct(C1878c.this.thumbPath)) {
                this.ret = -50004;
            }
            AppMethodBeat.m2505o(50623);
            return null;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(50624);
            if (C1878c.this.fUF != null) {
                C1878c.this.fUF.mo5453b(this.ret, C1878c.this.fileName, C1878c.this.fUG, C1878c.this.duration);
            }
            AppMethodBeat.m2505o(50624);
        }
    }

    public C1878c() {
        AppMethodBeat.m2504i(50626);
        AppMethodBeat.m2505o(50626);
    }

    static {
        AppMethodBeat.m2504i(50628);
        AppMethodBeat.m2505o(50628);
    }

    /* renamed from: a */
    public final void mo5454a(Context context, Intent intent, C1877a c1877a) {
        AppMethodBeat.m2504i(50627);
        this.context = context;
        this.intent = intent;
        this.fileName = C9720t.m17302ug((String) C1720g.m3536RP().mo5239Ry().get(2, (Object) ""));
        C37961o.all();
        this.thumbPath = C9720t.m17304ui(this.fileName);
        C37961o.all();
        this.videoPath = C9720t.m17303uh(this.fileName);
        this.fUF = c1877a;
        this.fUH.execute(new String[0]);
        AppMethodBeat.m2505o(50627);
    }
}
