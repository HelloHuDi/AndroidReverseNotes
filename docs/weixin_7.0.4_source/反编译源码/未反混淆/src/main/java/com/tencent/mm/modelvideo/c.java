package com.tencent.mm.modelvideo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import com.tencent.smtt.sdk.WebView;

public final class c {
    public static final int fUE = b.Nd();
    Context context = null;
    int duration = 0;
    public a fUF = null;
    String fUG = null;
    final AsyncTask<String, Integer, String> fUH = new AsyncTask<String, Integer, String>() {
        int ret = 0;

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.i(50625);
            String akS = akS();
            AppMethodBeat.o(50625);
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
            com.tencent.mm.compatible.j.a.a j;
            Throwable e;
            AppMethodBeat.i(50623);
            this.ret = 0;
            boolean is2G = at.is2G(ah.getContext());
            try {
                j = com.tencent.mm.compatible.j.a.j(c.this.context, c.this.intent);
            } catch (Exception e2) {
                ab.e("MicroMsg.ImportVideo", "exception:%s", bo.l(e2));
                j = null;
            }
            if (j == null) {
                ab.e("MicroMsg.ImportVideo", "GetVideoMetadata filed.");
                h.pYm.a(106, 244, 1, false);
                this.ret = -50005;
                AppMethodBeat.o(50623);
                return null;
            }
            c.this.fUG = j.filename;
            int asZ = (int) e.asZ(c.this.fUG);
            ab.i("MicroMsg.ImportVideo", "import file is2G:%b len:%d duration:%d path:%s ", Boolean.valueOf(is2G), Integer.valueOf(asZ), Integer.valueOf(j.duration), c.this.fUG);
            if (asZ <= 0) {
                h.pYm.a(106, 244, 1, false);
                this.ret = -50001;
                AppMethodBeat.o(50623);
                return null;
            }
            if (asZ > (is2G ? 10485760 : c.fUE)) {
                h.pYm.a(106, 245, 1, false);
                this.ret = -50002;
                AppMethodBeat.o(50623);
                return null;
            }
            e.y(c.this.fUG, c.this.videoPath);
            c.this.duration = j.duration / 1000;
            Object obj = 1;
            if (j.bitmap != null) {
                try {
                    d.a(j.bitmap, 60, CompressFormat.JPEG, c.this.thumbPath, true);
                    try {
                        h.pYm.a(106, 231, 1, false);
                        obj = null;
                    } catch (Exception e3) {
                        e = e3;
                        obj = null;
                        ab.e("MicroMsg.ImportVideo", "exception:%s", bo.l(e));
                        if (obj != null) {
                        }
                        if (!e.ct(c.this.videoPath)) {
                        }
                        if (!e.ct(c.this.thumbPath)) {
                        }
                        AppMethodBeat.o(50623);
                        return null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    ab.e("MicroMsg.ImportVideo", "exception:%s", bo.l(e));
                    if (obj != null) {
                    }
                    if (e.ct(c.this.videoPath)) {
                    }
                    if (e.ct(c.this.thumbPath)) {
                    }
                    AppMethodBeat.o(50623);
                    return null;
                }
            }
            if (obj != null) {
                try {
                    h.pYm.a(106, 232, 1, false);
                    d.a(d.au(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, c.this.thumbPath, true);
                } catch (Exception e22) {
                    ab.e("MicroMsg.ImportVideo", "exception:%s", bo.l(e22));
                }
            }
            if (e.ct(c.this.videoPath)) {
                this.ret = -50003;
            }
            if (e.ct(c.this.thumbPath)) {
                this.ret = -50004;
            }
            AppMethodBeat.o(50623);
            return null;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(50624);
            if (c.this.fUF != null) {
                c.this.fUF.b(this.ret, c.this.fileName, c.this.fUG, c.this.duration);
            }
            AppMethodBeat.o(50624);
        }
    };
    String fileName = null;
    Intent intent = null;
    String thumbPath = null;
    String videoPath = null;

    public interface a {
        void b(int i, String str, String str2, int i2);
    }

    public c() {
        AppMethodBeat.i(50626);
        AppMethodBeat.o(50626);
    }

    static {
        AppMethodBeat.i(50628);
        AppMethodBeat.o(50628);
    }

    public final void a(Context context, Intent intent, a aVar) {
        AppMethodBeat.i(50627);
        this.context = context;
        this.intent = intent;
        this.fileName = t.ug((String) g.RP().Ry().get(2, (Object) ""));
        o.all();
        this.thumbPath = t.ui(this.fileName);
        o.all();
        this.videoPath = t.uh(this.fileName);
        this.fUF = aVar;
        this.fUH.execute(new String[0]);
        AppMethodBeat.o(50627);
    }
}
