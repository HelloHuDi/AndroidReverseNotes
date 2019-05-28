package com.davemorrissey.labs.subscaleview.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import com.davemorrissey.labs.subscaleview.a.c;
import com.davemorrissey.labs.subscaleview.a.d;
import com.davemorrissey.labs.subscaleview.c.b;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;

public final class a implements com.davemorrissey.labs.subscaleview.c.a {

    static class a extends AsyncTask<Void, Void, Integer> implements b {
        private final WeakReference<SubsamplingScaleImageView> aIp;
        private final WeakReference<Context> aIq;
        private final WeakReference<com.davemorrissey.labs.subscaleview.a.b<? extends d>> aIr;
        private final Uri aIs;
        private final boolean aIt;
        private c aIu;
        private long aIv = -1;
        private Bitmap bitmap;
        private Exception exception;
        private Rect mRect;

        /* Access modifiers changed, original: protected|final|synthetic */
        @SuppressLint({"LongLogTag"})
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.i(115619);
            Integer ot = ot();
            AppMethodBeat.o(115619);
            return ot;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(115618);
            Integer num = (Integer) obj;
            ab.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode onPostExecute %d", Long.valueOf(System.currentTimeMillis()));
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.aIp.get();
            if (subsamplingScaleImageView != null) {
                if (this.bitmap == null || num == null) {
                    if (!(this.exception == null || subsamplingScaleImageView.getOnImageEventListener() == null)) {
                        if (this.aIt) {
                            subsamplingScaleImageView.getOnImageEventListener().a(this.aIu);
                            AppMethodBeat.o(115618);
                            return;
                        }
                        subsamplingScaleImageView.getOnImageEventListener().b(this.aIu);
                    }
                } else if (this.aIt) {
                    subsamplingScaleImageView.a(this.bitmap, num);
                    AppMethodBeat.o(115618);
                    return;
                } else {
                    subsamplingScaleImageView.b(this.bitmap, num.intValue(), false);
                    AppMethodBeat.o(115618);
                    return;
                }
            }
            AppMethodBeat.o(115618);
        }

        a(SubsamplingScaleImageView subsamplingScaleImageView, Context context, com.davemorrissey.labs.subscaleview.a.b<? extends d> bVar, Uri uri, boolean z) {
            AppMethodBeat.i(115614);
            this.aIp = new WeakReference(subsamplingScaleImageView);
            this.aIq = new WeakReference(context);
            this.aIr = new WeakReference(bVar);
            this.aIs = uri;
            this.aIt = z;
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(uri.getPath(), options);
            this.mRect = new Rect(0, 0, options.outWidth, options.outHeight);
            AppMethodBeat.o(115614);
        }

        @SuppressLint({"LongLogTag"})
        private Integer ot() {
            AppMethodBeat.i(115615);
            ab.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode start");
            if (this.aIt) {
                this.aIv = System.currentTimeMillis();
            }
            try {
                String uri = this.aIs.toString();
                Context context = (Context) this.aIq.get();
                com.davemorrissey.labs.subscaleview.a.b bVar = (com.davemorrissey.labs.subscaleview.a.b) this.aIr.get();
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.aIp.get();
                if (!(context == null || bVar == null || subsamplingScaleImageView == null)) {
                    subsamplingScaleImageView.j("BitmapLoadTask.doInBackground", new Object[0]);
                    d dVar = (d) bVar.or();
                    dVar.c(context, this.aIs);
                    this.bitmap = dVar.b(this.mRect, 1);
                    Integer valueOf = Integer.valueOf(subsamplingScaleImageView.h(context, uri));
                    dVar.recycle();
                    a(subsamplingScaleImageView);
                    AppMethodBeat.o(115615);
                    return valueOf;
                }
            } catch (FileNotFoundException e) {
                ab.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", e, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
                this.exception = e;
                this.aIu = new c(1, "tile init file not found");
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", e2, "Failed to load bitmap", new Object[0]);
                this.exception = e2;
                this.aIu = new c(2, "bitmap decode failed");
            } catch (OutOfMemoryError e3) {
                ab.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", e3, "Failed to load bitmap - OutOfMemoryError", new Object[0]);
                this.exception = new RuntimeException(e3);
                this.aIu = new c(3, "bitmap decode OutOfMemoryError");
                SubsamplingScaleImageView.setPreferredBitmapConfig(Config.RGB_565);
            }
            a((SubsamplingScaleImageView) this.aIp.get());
            AppMethodBeat.o(115615);
            return null;
        }

        private void a(SubsamplingScaleImageView subsamplingScaleImageView) {
            AppMethodBeat.i(115616);
            if (!(subsamplingScaleImageView == null || !this.aIt || this.aIv == -1)) {
                ab.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode onEnd %d", Long.valueOf(System.currentTimeMillis()));
                subsamplingScaleImageView.dp((int) (System.currentTimeMillis() - this.aIv));
            }
            AppMethodBeat.o(115616);
        }

        public final void ou() {
            AppMethodBeat.i(115617);
            executeOnExecutor(((SubsamplingScaleImageView) this.aIp.get()).executor, new Void[0]);
            AppMethodBeat.o(115617);
        }

        public final void cancel() {
        }
    }

    public final b a(SubsamplingScaleImageView subsamplingScaleImageView, Context context, com.davemorrissey.labs.subscaleview.a.b<? extends d> bVar, Uri uri, boolean z) {
        AppMethodBeat.i(115620);
        a aVar = new a(subsamplingScaleImageView, context, bVar, uri, z);
        AppMethodBeat.o(115620);
        return aVar;
    }
}
