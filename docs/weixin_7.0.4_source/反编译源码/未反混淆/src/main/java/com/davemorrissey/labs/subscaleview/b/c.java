package com.davemorrissey.labs.subscaleview.b;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.os.AsyncTask;
import com.davemorrissey.labs.subscaleview.c.b;
import com.davemorrissey.labs.subscaleview.c.d;
import com.davemorrissey.labs.subscaleview.c.e;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

public final class c implements d {

    static class a extends AsyncTask<Void, Void, Bitmap> implements b {
        private final WeakReference<SubsamplingScaleImageView> aIp;
        private com.davemorrissey.labs.subscaleview.a.c aIu;
        private final WeakReference<com.davemorrissey.labs.subscaleview.a.d> aIx;
        private final WeakReference<e> aIy;
        private Exception exception;
        private boolean isCancelled = false;
        private long mStartTime = -1;

        /* Access modifiers changed, original: protected|final|synthetic */
        @SuppressLint({"LongLogTag"})
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.i(115634);
            Bitmap ow = ow();
            AppMethodBeat.o(115634);
            return ow;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(115633);
            Bitmap bitmap = (Bitmap) obj;
            ab.i("MicroMsg.LegacyTileLoaderFactory", "alvinluo onPostExecute %d", Long.valueOf(System.currentTimeMillis()));
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.aIp.get();
            e eVar = (e) this.aIy.get();
            String str = "MicroMsg.LegacyTileLoaderFactory";
            String str2 = "alvinluo onExecuteEnd imageView != null: %b, tile != null: %b, sampleSize: %d, rect: %s";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(subsamplingScaleImageView != null);
            objArr[1] = Boolean.valueOf(eVar != null);
            objArr[2] = Integer.valueOf(eVar != null ? eVar.sampleSize : -1);
            objArr[3] = eVar != null ? eVar.aIz : BuildConfig.COMMAND;
            ab.d(str, str2, objArr);
            if (!(subsamplingScaleImageView == null || eVar == null)) {
                if (bitmap != null) {
                    eVar.bitmap = bitmap;
                    eVar.aIA = false;
                    subsamplingScaleImageView.b(eVar);
                    AppMethodBeat.o(115633);
                    return;
                } else if (!(this.exception == null || subsamplingScaleImageView.getOnImageEventListener() == null)) {
                    subsamplingScaleImageView.getOnImageEventListener().c(this.aIu);
                }
            }
            AppMethodBeat.o(115633);
        }

        a(SubsamplingScaleImageView subsamplingScaleImageView, com.davemorrissey.labs.subscaleview.a.d dVar, e eVar) {
            AppMethodBeat.i(115628);
            this.aIp = new WeakReference(subsamplingScaleImageView);
            this.aIx = new WeakReference(dVar);
            this.aIy = new WeakReference(eVar);
            eVar.aIA = true;
            AppMethodBeat.o(115628);
        }

        @SuppressLint({"LongLogTag"})
        private Bitmap ow() {
            AppMethodBeat.i(115629);
            if (!(this.aIp.get() == null || this.aIy.get() == null || ((SubsamplingScaleImageView) this.aIp.get()).getFullImageSampleSize() != ((e) this.aIy.get()).sampleSize)) {
                this.mStartTime = System.currentTimeMillis();
            }
            SubsamplingScaleImageView subsamplingScaleImageView;
            try {
                subsamplingScaleImageView = (SubsamplingScaleImageView) this.aIp.get();
                com.davemorrissey.labs.subscaleview.a.d dVar = (com.davemorrissey.labs.subscaleview.a.d) this.aIx.get();
                e eVar = (e) this.aIy.get();
                if (dVar == null || eVar == null || subsamplingScaleImageView == null || !dVar.isReady() || !eVar.aIB) {
                    if (eVar != null) {
                        eVar.aIA = false;
                    }
                    a((SubsamplingScaleImageView) this.aIp.get(), (e) this.aIy.get());
                    AppMethodBeat.o(115629);
                    return null;
                }
                ab.d("MicroMsg.LegacyTileLoaderFactory", "alvinluo TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", eVar.aIz, Integer.valueOf(eVar.sampleSize));
                subsamplingScaleImageView.getDecoderLock().readLock().lock();
                if (dVar.isReady()) {
                    Rect rect = eVar.aIz;
                    Rect rect2 = eVar.aID;
                    if (subsamplingScaleImageView.getRequiredRotation() == 0) {
                        rect2.set(rect);
                    } else if (subsamplingScaleImageView.getRequiredRotation() == 90) {
                        rect2.set(rect.top, subsamplingScaleImageView.aIK - rect.right, rect.bottom, subsamplingScaleImageView.aIK - rect.left);
                    } else if (subsamplingScaleImageView.getRequiredRotation() == 180) {
                        rect2.set(subsamplingScaleImageView.aIJ - rect.right, subsamplingScaleImageView.aIK - rect.bottom, subsamplingScaleImageView.aIJ - rect.left, subsamplingScaleImageView.aIK - rect.top);
                    } else {
                        rect2.set(subsamplingScaleImageView.aIJ - rect.bottom, rect.left, subsamplingScaleImageView.aIJ - rect.top, rect.right);
                    }
                    if (subsamplingScaleImageView.getsRegion() != null) {
                        eVar.aID.offset(subsamplingScaleImageView.getsRegion().left, subsamplingScaleImageView.getsRegion().top);
                    }
                    ab.d("MicroMsg.LegacyTileLoaderFactory", "alvinluo tile sampleSize: %d", Integer.valueOf(eVar.sampleSize));
                    Bitmap b = dVar.b(eVar.aID, eVar.sampleSize);
                    a(subsamplingScaleImageView, eVar);
                    subsamplingScaleImageView.getDecoderLock().readLock().unlock();
                    AppMethodBeat.o(115629);
                    return b;
                }
                eVar.aIA = false;
                subsamplingScaleImageView.getDecoderLock().readLock().unlock();
                a((SubsamplingScaleImageView) this.aIp.get(), (e) this.aIy.get());
                AppMethodBeat.o(115629);
                return null;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.LegacyTileLoaderFactory", e, "Failed to decode tile", new Object[0]);
                this.exception = e;
                this.aIu = new com.davemorrissey.labs.subscaleview.a.c(5, "decode tile failed");
            } catch (OutOfMemoryError e2) {
                ab.printErrStackTrace("MicroMsg.LegacyTileLoaderFactory", e2, "Failed to decode tile - OutOfMemoryError", new Object[0]);
                this.exception = new RuntimeException(e2);
                this.aIu = new com.davemorrissey.labs.subscaleview.a.c(6, "decode tile OutOfMemoryError");
                SubsamplingScaleImageView.setPreferredBitmapConfig(Config.RGB_565);
            } catch (Throwable th) {
                subsamplingScaleImageView.getDecoderLock().readLock().unlock();
                AppMethodBeat.o(115629);
            }
        }

        private void a(SubsamplingScaleImageView subsamplingScaleImageView, e eVar) {
            AppMethodBeat.i(115630);
            if (!(subsamplingScaleImageView == null || eVar == null || this.mStartTime == -1 || subsamplingScaleImageView.getFullImageSampleSize() != eVar.sampleSize)) {
                subsamplingScaleImageView.dq((int) (System.currentTimeMillis() - this.mStartTime));
            }
            AppMethodBeat.o(115630);
        }

        public final void ou() {
            AppMethodBeat.i(115631);
            executeOnExecutor(((SubsamplingScaleImageView) this.aIp.get()).executor, new Void[0]);
            AppMethodBeat.o(115631);
        }

        public final void cancel() {
            AppMethodBeat.i(115632);
            try {
                cancel(true);
                this.isCancelled = true;
                AppMethodBeat.o(115632);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.LegacyTileLoaderFactory", e, "alvinluo TileLoaderTask cancel exception", new Object[0]);
                AppMethodBeat.o(115632);
            }
        }
    }

    public final b a(SubsamplingScaleImageView subsamplingScaleImageView, com.davemorrissey.labs.subscaleview.a.d dVar, e eVar) {
        AppMethodBeat.i(115635);
        a aVar = new a(subsamplingScaleImageView, dVar, eVar);
        AppMethodBeat.o(115635);
        return aVar;
    }
}
