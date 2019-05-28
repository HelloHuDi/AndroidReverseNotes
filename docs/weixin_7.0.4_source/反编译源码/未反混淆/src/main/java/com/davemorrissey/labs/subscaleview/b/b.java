package com.davemorrissey.labs.subscaleview.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import com.davemorrissey.labs.subscaleview.a.d;
import com.davemorrissey.labs.subscaleview.c.c;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;

public final class b implements c {

    static class a extends AsyncTask<Void, Void, int[]> implements com.davemorrissey.labs.subscaleview.c.b {
        private final WeakReference<SubsamplingScaleImageView> aIp;
        private final WeakReference<Context> aIq;
        private final WeakReference<com.davemorrissey.labs.subscaleview.a.b<? extends d>> aIr;
        private final Uri aIs;
        private com.davemorrissey.labs.subscaleview.a.c aIu;
        private long aIv;
        private d aIw;
        private Exception exception;

        /* Access modifiers changed, original: protected|final|synthetic */
        @SuppressLint({"LongLogTag"})
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.i(115626);
            int[] ov = ov();
            AppMethodBeat.o(115626);
            return ov;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(115625);
            int[] iArr = (int[]) obj;
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.aIp.get();
            if (subsamplingScaleImageView == null) {
                ab.e("MicroMsg.LegacyTileInitLoaderFactory", "alvinluo TileInitTask onPostExecute view is null");
            } else if (this.aIw != null && iArr != null && iArr.length == 3) {
                long currentTimeMillis = System.currentTimeMillis();
                subsamplingScaleImageView.a(this.aIw, iArr[0], iArr[1], iArr[2]);
                subsamplingScaleImageView.m1do((int) (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(115625);
                return;
            } else if (!(this.exception == null || subsamplingScaleImageView.getOnImageEventListener() == null)) {
                subsamplingScaleImageView.getOnImageEventListener().b(this.aIu);
                AppMethodBeat.o(115625);
                return;
            }
            AppMethodBeat.o(115625);
        }

        a(SubsamplingScaleImageView subsamplingScaleImageView, Context context, com.davemorrissey.labs.subscaleview.a.b<? extends d> bVar, Uri uri) {
            AppMethodBeat.i(115621);
            this.aIp = new WeakReference(subsamplingScaleImageView);
            this.aIq = new WeakReference(context);
            this.aIr = new WeakReference(bVar);
            this.aIs = uri;
            AppMethodBeat.o(115621);
        }

        @SuppressLint({"LongLogTag"})
        private int[] ov() {
            AppMethodBeat.i(115622);
            ab.d("MicroMsg.LegacyTileInitLoaderFactory", "alvinluo TileInitTask doInBackground");
            this.aIv = System.currentTimeMillis();
            try {
                String uri = this.aIs.toString();
                Context context = (Context) this.aIq.get();
                com.davemorrissey.labs.subscaleview.a.b bVar = (com.davemorrissey.labs.subscaleview.a.b) this.aIr.get();
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.aIp.get();
                if (!(context == null || bVar == null || subsamplingScaleImageView == null)) {
                    this.aIw = (d) bVar.or();
                    Point c = this.aIw.c(context, this.aIs);
                    int i = c.x;
                    int i2 = c.y;
                    int h = subsamplingScaleImageView.h(context, uri);
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
                    a(subsamplingScaleImageView);
                    int[] iArr = new int[]{i, i2, h};
                    AppMethodBeat.o(115622);
                    return iArr;
                }
            } catch (FileNotFoundException e) {
                ab.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", e, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
                this.exception = e;
                this.aIu = new com.davemorrissey.labs.subscaleview.a.c(1, "tile init file not found");
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", e2, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
                this.exception = e2;
                this.aIu = new com.davemorrissey.labs.subscaleview.a.c(4, "tile init failed");
            }
            a((SubsamplingScaleImageView) this.aIp.get());
            AppMethodBeat.o(115622);
            return null;
        }

        private void a(SubsamplingScaleImageView subsamplingScaleImageView) {
            AppMethodBeat.i(115623);
            if (!(subsamplingScaleImageView == null || this.aIv == -1)) {
                subsamplingScaleImageView.m1do((int) (System.currentTimeMillis() - this.aIv));
            }
            AppMethodBeat.o(115623);
        }

        public final void ou() {
            AppMethodBeat.i(115624);
            executeOnExecutor(((SubsamplingScaleImageView) this.aIp.get()).executor, new Void[0]);
            AppMethodBeat.o(115624);
        }

        public final void cancel() {
        }
    }

    public final com.davemorrissey.labs.subscaleview.c.b a(SubsamplingScaleImageView subsamplingScaleImageView, Context context, com.davemorrissey.labs.subscaleview.a.b<? extends d> bVar, Uri uri) {
        AppMethodBeat.i(115627);
        a aVar = new a(subsamplingScaleImageView, context, bVar, uri);
        AppMethodBeat.o(115627);
        return aVar;
    }
}
