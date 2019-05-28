package com.tencent.p177mm.plugin.webview.modeltools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7306ak.C4998a;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.webview.modeltools.h */
public final class C14543h {
    C7306ak iGP = new C7306ak(Looper.getMainLooper(), this.upt);
    MMWebView upq;
    public String upr;
    C14545c ups;
    private C4998a upt = new C145481();

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.h$b */
    final class C14544b implements Runnable {
        private Bitmap mBitmap;

        public C14544b(Bitmap bitmap) {
            this.mBitmap = bitmap;
        }

        public final void run() {
            AppMethodBeat.m2504i(7010);
            C14543h.this.upr = String.format(Locale.US, "%s%s_%08x.jpg", new Object[]{C6457e.eSn, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.mBitmap.hashCode())});
            try {
                C5056d.m7625a(this.mBitmap, 100, CompressFormat.JPEG, C14543h.this.upr, true);
            } catch (IOException e) {
                C4990ab.m7412e("MicroMsg.ViewCaptureHelper", "saveBitmapToImage failed, " + e.getMessage());
                C14543h.this.upr = null;
            }
            C4990ab.m7417i("MicroMsg.ViewCaptureHelper", "bitmap recycle %s", this.mBitmap.toString());
            this.mBitmap.recycle();
            C14543h.this.iGP.sendEmptyMessage(2);
            AppMethodBeat.m2505o(7010);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.h$c */
    public interface C14545c {
        /* renamed from: BY */
        void mo26772BY(String str);
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.h$a */
    final class C14546a implements Runnable {

        /* renamed from: com.tencent.mm.plugin.webview.modeltools.h$a$1 */
        class C145471 implements FilenameFilter {
            C145471() {
            }

            public final boolean accept(File file, String str) {
                AppMethodBeat.m2504i(7008);
                boolean matches = str.matches(".+_.+.\\.jpg");
                AppMethodBeat.m2505o(7008);
                return matches;
            }
        }

        private C14546a() {
        }

        /* synthetic */ C14546a(C14543h c14543h, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(7009);
            if (C14543h.this.upr == null) {
                AppMethodBeat.m2505o(7009);
                return;
            }
            int length = new File(C14543h.this.upr).getParentFile().listFiles(new C145471()).length;
            for (int i = 0; i < length; i++) {
                C4990ab.m7417i("MicroMsg.ViewCaptureHelper", "deleteFile result: %b", Boolean.valueOf(r2[i].delete()));
            }
            C14543h.this.upr = null;
            AppMethodBeat.m2505o(7009);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.h$1 */
    class C145481 implements C4998a {
        C145481() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.m2504i(7007);
            switch (message.what) {
                case 1:
                    Bitmap bitmap = C14543h.this.upq.getBitmap();
                    if (bitmap != null) {
                        C7305d.post(new C14544b(bitmap), "ViewCaptureHelper_SaveBitmap");
                        C14543h.this.upq = null;
                        break;
                    }
                    break;
                case 2:
                    if (C14543h.this.ups != null) {
                        C14543h.this.ups.mo26772BY(C14543h.this.upr);
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(7007);
            return false;
        }
    }

    public C14543h() {
        AppMethodBeat.m2504i(7011);
        AppMethodBeat.m2505o(7011);
    }

    /* renamed from: a */
    public final void mo26769a(MMWebView mMWebView, C14545c c14545c) {
        AppMethodBeat.m2504i(7012);
        this.upq = mMWebView;
        this.ups = c14545c;
        this.iGP.sendEmptyMessage(1);
        AppMethodBeat.m2505o(7012);
    }

    public final void cYK() {
        AppMethodBeat.m2504i(7013);
        C7305d.post(new C14546a(this, (byte) 0), "ViewCaptureHelper_DeleteBitmap");
        AppMethodBeat.m2505o(7013);
    }
}
