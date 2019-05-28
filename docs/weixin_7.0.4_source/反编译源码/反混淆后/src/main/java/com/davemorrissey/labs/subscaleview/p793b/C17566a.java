package com.davemorrissey.labs.subscaleview.p793b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import com.davemorrissey.labs.subscaleview.p1158a.C17564b;
import com.davemorrissey.labs.subscaleview.p1158a.C17565d;
import com.davemorrissey.labs.subscaleview.p1158a.C25467c;
import com.davemorrissey.labs.subscaleview.p1519c.C37203b;
import com.davemorrissey.labs.subscaleview.p1519c.C45007a;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;

/* renamed from: com.davemorrissey.labs.subscaleview.b.a */
public final class C17566a implements C45007a {

    /* renamed from: com.davemorrissey.labs.subscaleview.b.a$a */
    static class C8568a extends AsyncTask<Void, Void, Integer> implements C37203b {
        private final WeakReference<SubsamplingScaleImageView> aIp;
        private final WeakReference<Context> aIq;
        private final WeakReference<C17564b<? extends C17565d>> aIr;
        private final Uri aIs;
        private final boolean aIt;
        private C25467c aIu;
        private long aIv = -1;
        private Bitmap bitmap;
        private Exception exception;
        private Rect mRect;

        /* Access modifiers changed, original: protected|final|synthetic */
        @SuppressLint({"LongLogTag"})
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(115619);
            Integer ot = m15235ot();
            AppMethodBeat.m2505o(115619);
            return ot;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(115618);
            Integer num = (Integer) obj;
            C4990ab.m7417i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode onPostExecute %d", Long.valueOf(System.currentTimeMillis()));
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.aIp.get();
            if (subsamplingScaleImageView != null) {
                if (this.bitmap == null || num == null) {
                    if (!(this.exception == null || subsamplingScaleImageView.getOnImageEventListener() == null)) {
                        if (this.aIt) {
                            subsamplingScaleImageView.getOnImageEventListener().mo2341a(this.aIu);
                            AppMethodBeat.m2505o(115618);
                            return;
                        }
                        subsamplingScaleImageView.getOnImageEventListener().mo2342b(this.aIu);
                    }
                } else if (this.aIt) {
                    subsamplingScaleImageView.mo2262a(this.bitmap, num);
                    AppMethodBeat.m2505o(115618);
                    return;
                } else {
                    subsamplingScaleImageView.mo2266b(this.bitmap, num.intValue(), false);
                    AppMethodBeat.m2505o(115618);
                    return;
                }
            }
            AppMethodBeat.m2505o(115618);
        }

        C8568a(SubsamplingScaleImageView subsamplingScaleImageView, Context context, C17564b<? extends C17565d> c17564b, Uri uri, boolean z) {
            AppMethodBeat.m2504i(115614);
            this.aIp = new WeakReference(subsamplingScaleImageView);
            this.aIq = new WeakReference(context);
            this.aIr = new WeakReference(c17564b);
            this.aIs = uri;
            this.aIt = z;
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(uri.getPath(), options);
            this.mRect = new Rect(0, 0, options.outWidth, options.outHeight);
            AppMethodBeat.m2505o(115614);
        }

        @SuppressLint({"LongLogTag"})
        /* renamed from: ot */
        private Integer m15235ot() {
            AppMethodBeat.m2504i(115615);
            C4990ab.m7416i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode start");
            if (this.aIt) {
                this.aIv = System.currentTimeMillis();
            }
            try {
                String uri = this.aIs.toString();
                Context context = (Context) this.aIq.get();
                C17564b c17564b = (C17564b) this.aIr.get();
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.aIp.get();
                if (!(context == null || c17564b == null || subsamplingScaleImageView == null)) {
                    subsamplingScaleImageView.mo2293j("BitmapLoadTask.doInBackground", new Object[0]);
                    C17565d c17565d = (C17565d) c17564b.mo31995or();
                    c17565d.mo31997c(context, this.aIs);
                    this.bitmap = c17565d.mo31996b(this.mRect, 1);
                    Integer valueOf = Integer.valueOf(subsamplingScaleImageView.mo2292h(context, uri));
                    c17565d.recycle();
                    m15234a(subsamplingScaleImageView);
                    AppMethodBeat.m2505o(115615);
                    return valueOf;
                }
            } catch (FileNotFoundException e) {
                C4990ab.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", e, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
                this.exception = e;
                this.aIu = new C25467c(1, "tile init file not found");
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", e2, "Failed to load bitmap", new Object[0]);
                this.exception = e2;
                this.aIu = new C25467c(2, "bitmap decode failed");
            } catch (OutOfMemoryError e3) {
                C4990ab.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", e3, "Failed to load bitmap - OutOfMemoryError", new Object[0]);
                this.exception = new RuntimeException(e3);
                this.aIu = new C25467c(3, "bitmap decode OutOfMemoryError");
                SubsamplingScaleImageView.setPreferredBitmapConfig(Config.RGB_565);
            }
            m15234a((SubsamplingScaleImageView) this.aIp.get());
            AppMethodBeat.m2505o(115615);
            return null;
        }

        /* renamed from: a */
        private void m15234a(SubsamplingScaleImageView subsamplingScaleImageView) {
            AppMethodBeat.m2504i(115616);
            if (!(subsamplingScaleImageView == null || !this.aIt || this.aIv == -1)) {
                C4990ab.m7417i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode onEnd %d", Long.valueOf(System.currentTimeMillis()));
                subsamplingScaleImageView.mo2271dp((int) (System.currentTimeMillis() - this.aIv));
            }
            AppMethodBeat.m2505o(115616);
        }

        /* renamed from: ou */
        public final void mo18684ou() {
            AppMethodBeat.m2504i(115617);
            executeOnExecutor(((SubsamplingScaleImageView) this.aIp.get()).executor, new Void[0]);
            AppMethodBeat.m2505o(115617);
        }

        public final void cancel() {
        }
    }

    /* renamed from: a */
    public final C37203b mo32000a(SubsamplingScaleImageView subsamplingScaleImageView, Context context, C17564b<? extends C17565d> c17564b, Uri uri, boolean z) {
        AppMethodBeat.m2504i(115620);
        C8568a c8568a = new C8568a(subsamplingScaleImageView, context, c17564b, uri, z);
        AppMethodBeat.m2505o(115620);
        return c8568a;
    }
}
