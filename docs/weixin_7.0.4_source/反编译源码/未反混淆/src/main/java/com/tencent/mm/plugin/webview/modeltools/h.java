package com.tencent.mm.plugin.webview.modeltools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.widget.MMWebView;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Locale;

public final class h {
    ak iGP = new ak(Looper.getMainLooper(), this.upt);
    MMWebView upq;
    public String upr;
    c ups;
    private com.tencent.mm.sdk.platformtools.ak.a upt = new com.tencent.mm.sdk.platformtools.ak.a() {
        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(7007);
            switch (message.what) {
                case 1:
                    Bitmap bitmap = h.this.upq.getBitmap();
                    if (bitmap != null) {
                        d.post(new b(bitmap), "ViewCaptureHelper_SaveBitmap");
                        h.this.upq = null;
                        break;
                    }
                    break;
                case 2:
                    if (h.this.ups != null) {
                        h.this.ups.BY(h.this.upr);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(7007);
            return false;
        }
    };

    final class b implements Runnable {
        private Bitmap mBitmap;

        public b(Bitmap bitmap) {
            this.mBitmap = bitmap;
        }

        public final void run() {
            AppMethodBeat.i(7010);
            h.this.upr = String.format(Locale.US, "%s%s_%08x.jpg", new Object[]{e.eSn, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.mBitmap.hashCode())});
            try {
                com.tencent.mm.sdk.platformtools.d.a(this.mBitmap, 100, CompressFormat.JPEG, h.this.upr, true);
            } catch (IOException e) {
                ab.e("MicroMsg.ViewCaptureHelper", "saveBitmapToImage failed, " + e.getMessage());
                h.this.upr = null;
            }
            ab.i("MicroMsg.ViewCaptureHelper", "bitmap recycle %s", this.mBitmap.toString());
            this.mBitmap.recycle();
            h.this.iGP.sendEmptyMessage(2);
            AppMethodBeat.o(7010);
        }
    }

    public interface c {
        void BY(String str);
    }

    final class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(h hVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(7009);
            if (h.this.upr == null) {
                AppMethodBeat.o(7009);
                return;
            }
            int length = new File(h.this.upr).getParentFile().listFiles(new FilenameFilter() {
                public final boolean accept(File file, String str) {
                    AppMethodBeat.i(7008);
                    boolean matches = str.matches(".+_.+.\\.jpg");
                    AppMethodBeat.o(7008);
                    return matches;
                }
            }).length;
            for (int i = 0; i < length; i++) {
                ab.i("MicroMsg.ViewCaptureHelper", "deleteFile result: %b", Boolean.valueOf(r2[i].delete()));
            }
            h.this.upr = null;
            AppMethodBeat.o(7009);
        }
    }

    public h() {
        AppMethodBeat.i(7011);
        AppMethodBeat.o(7011);
    }

    public final void a(MMWebView mMWebView, c cVar) {
        AppMethodBeat.i(7012);
        this.upq = mMWebView;
        this.ups = cVar;
        this.iGP.sendEmptyMessage(1);
        AppMethodBeat.o(7012);
    }

    public final void cYK() {
        AppMethodBeat.i(7013);
        d.post(new a(this, (byte) 0), "ViewCaptureHelper_DeleteBitmap");
        AppMethodBeat.o(7013);
    }
}
