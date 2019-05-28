package com.davemorrissey.labs.subscaleview.p793b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import com.davemorrissey.labs.subscaleview.p1158a.C17564b;
import com.davemorrissey.labs.subscaleview.p1158a.C17565d;
import com.davemorrissey.labs.subscaleview.p1158a.C25467c;
import com.davemorrissey.labs.subscaleview.p1519c.C37203b;
import com.davemorrissey.labs.subscaleview.p1519c.C41575c;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;

/* renamed from: com.davemorrissey.labs.subscaleview.b.b */
public final class C25468b implements C41575c {

    /* renamed from: com.davemorrissey.labs.subscaleview.b.b$a */
    static class C25469a extends AsyncTask<Void, Void, int[]> implements C37203b {
        private final WeakReference<SubsamplingScaleImageView> aIp;
        private final WeakReference<Context> aIq;
        private final WeakReference<C17564b<? extends C17565d>> aIr;
        private final Uri aIs;
        private C25467c aIu;
        private long aIv;
        private C17565d aIw;
        private Exception exception;

        /* Access modifiers changed, original: protected|final|synthetic */
        @SuppressLint({"LongLogTag"})
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(115626);
            int[] ov = m40245ov();
            AppMethodBeat.m2505o(115626);
            return ov;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(115625);
            int[] iArr = (int[]) obj;
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.aIp.get();
            if (subsamplingScaleImageView == null) {
                C4990ab.m7412e("MicroMsg.LegacyTileInitLoaderFactory", "alvinluo TileInitTask onPostExecute view is null");
            } else if (this.aIw != null && iArr != null && iArr.length == 3) {
                long currentTimeMillis = System.currentTimeMillis();
                subsamplingScaleImageView.mo2263a(this.aIw, iArr[0], iArr[1], iArr[2]);
                subsamplingScaleImageView.mo2270do((int) (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(115625);
                return;
            } else if (!(this.exception == null || subsamplingScaleImageView.getOnImageEventListener() == null)) {
                subsamplingScaleImageView.getOnImageEventListener().mo2342b(this.aIu);
                AppMethodBeat.m2505o(115625);
                return;
            }
            AppMethodBeat.m2505o(115625);
        }

        C25469a(SubsamplingScaleImageView subsamplingScaleImageView, Context context, C17564b<? extends C17565d> c17564b, Uri uri) {
            AppMethodBeat.m2504i(115621);
            this.aIp = new WeakReference(subsamplingScaleImageView);
            this.aIq = new WeakReference(context);
            this.aIr = new WeakReference(c17564b);
            this.aIs = uri;
            AppMethodBeat.m2505o(115621);
        }

        @SuppressLint({"LongLogTag"})
        /* renamed from: ov */
        private int[] m40245ov() {
            AppMethodBeat.m2504i(115622);
            C4990ab.m7410d("MicroMsg.LegacyTileInitLoaderFactory", "alvinluo TileInitTask doInBackground");
            this.aIv = System.currentTimeMillis();
            try {
                String uri = this.aIs.toString();
                Context context = (Context) this.aIq.get();
                C17564b c17564b = (C17564b) this.aIr.get();
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.aIp.get();
                if (!(context == null || c17564b == null || subsamplingScaleImageView == null)) {
                    this.aIw = (C17565d) c17564b.mo31995or();
                    Point c = this.aIw.mo31997c(context, this.aIs);
                    int i = c.x;
                    int i2 = c.y;
                    int h = subsamplingScaleImageView.mo2292h(context, uri);
                    if (subsamplingScaleImageView.getsRegion() != null) {
                        Rect rect = subsamplingScaleImageView.getsRegion();
                        rect.left = Math.max(0, rect.left);
                        rect.top = Math.max(0, rect.top);
                        rect.right = Math.min(i, rect.right);
                        rect.bottom = Math.min(i2, rect.bottom);
                        int width = rect.width();
                        i2 = rect.height();
                        subsamplingScaleImageView.setsRegion(rect);
                        i = width;
                    }
                    m40244a(subsamplingScaleImageView);
                    int[] iArr = new int[]{i, i2, h};
                    AppMethodBeat.m2505o(115622);
                    return iArr;
                }
            } catch (FileNotFoundException e) {
                C4990ab.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", e, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
                this.exception = e;
                this.aIu = new C25467c(1, "tile init file not found");
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", e2, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
                this.exception = e2;
                this.aIu = new C25467c(4, "tile init failed");
            }
            m40244a((SubsamplingScaleImageView) this.aIp.get());
            AppMethodBeat.m2505o(115622);
            return null;
        }

        /* renamed from: a */
        private void m40244a(SubsamplingScaleImageView subsamplingScaleImageView) {
            AppMethodBeat.m2504i(115623);
            if (!(subsamplingScaleImageView == null || this.aIv == -1)) {
                subsamplingScaleImageView.mo2270do((int) (System.currentTimeMillis() - this.aIv));
            }
            AppMethodBeat.m2505o(115623);
        }

        /* renamed from: ou */
        public final void mo18684ou() {
            AppMethodBeat.m2504i(115624);
            executeOnExecutor(((SubsamplingScaleImageView) this.aIp.get()).executor, new Void[0]);
            AppMethodBeat.m2505o(115624);
        }

        public final void cancel() {
        }
    }

    /* renamed from: a */
    public final C37203b mo42520a(SubsamplingScaleImageView subsamplingScaleImageView, Context context, C17564b<? extends C17565d> c17564b, Uri uri) {
        AppMethodBeat.m2504i(115627);
        C25469a c25469a = new C25469a(subsamplingScaleImageView, context, c17564b, uri);
        AppMethodBeat.m2505o(115627);
        return c25469a;
    }
}
