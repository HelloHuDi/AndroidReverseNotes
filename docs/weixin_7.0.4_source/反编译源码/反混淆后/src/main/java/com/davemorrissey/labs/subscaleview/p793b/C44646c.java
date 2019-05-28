package com.davemorrissey.labs.subscaleview.p793b;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.os.AsyncTask;
import com.davemorrissey.labs.subscaleview.p1158a.C17565d;
import com.davemorrissey.labs.subscaleview.p1158a.C25467c;
import com.davemorrissey.labs.subscaleview.p1519c.C37203b;
import com.davemorrissey.labs.subscaleview.p1519c.C37204e;
import com.davemorrissey.labs.subscaleview.p1519c.C41576d;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;

/* renamed from: com.davemorrissey.labs.subscaleview.b.c */
public final class C44646c implements C41576d {

    /* renamed from: com.davemorrissey.labs.subscaleview.b.c$a */
    static class C31983a extends AsyncTask<Void, Void, Bitmap> implements C37203b {
        private final WeakReference<SubsamplingScaleImageView> aIp;
        private C25467c aIu;
        private final WeakReference<C17565d> aIx;
        private final WeakReference<C37204e> aIy;
        private Exception exception;
        private boolean isCancelled = false;
        private long mStartTime = -1;

        /* Access modifiers changed, original: protected|final|synthetic */
        @SuppressLint({"LongLogTag"})
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(115634);
            Bitmap ow = m51972ow();
            AppMethodBeat.m2505o(115634);
            return ow;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(115633);
            Bitmap bitmap = (Bitmap) obj;
            C4990ab.m7417i("MicroMsg.LegacyTileLoaderFactory", "alvinluo onPostExecute %d", Long.valueOf(System.currentTimeMillis()));
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.aIp.get();
            C37204e c37204e = (C37204e) this.aIy.get();
            String str = "MicroMsg.LegacyTileLoaderFactory";
            String str2 = "alvinluo onExecuteEnd imageView != null: %b, tile != null: %b, sampleSize: %d, rect: %s";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(subsamplingScaleImageView != null);
            objArr[1] = Boolean.valueOf(c37204e != null);
            objArr[2] = Integer.valueOf(c37204e != null ? c37204e.sampleSize : -1);
            objArr[3] = c37204e != null ? c37204e.aIz : BuildConfig.COMMAND;
            C4990ab.m7411d(str, str2, objArr);
            if (!(subsamplingScaleImageView == null || c37204e == null)) {
                if (bitmap != null) {
                    c37204e.bitmap = bitmap;
                    c37204e.aIA = false;
                    subsamplingScaleImageView.mo2267b(c37204e);
                    AppMethodBeat.m2505o(115633);
                    return;
                } else if (!(this.exception == null || subsamplingScaleImageView.getOnImageEventListener() == null)) {
                    subsamplingScaleImageView.getOnImageEventListener().mo2343c(this.aIu);
                }
            }
            AppMethodBeat.m2505o(115633);
        }

        C31983a(SubsamplingScaleImageView subsamplingScaleImageView, C17565d c17565d, C37204e c37204e) {
            AppMethodBeat.m2504i(115628);
            this.aIp = new WeakReference(subsamplingScaleImageView);
            this.aIx = new WeakReference(c17565d);
            this.aIy = new WeakReference(c37204e);
            c37204e.aIA = true;
            AppMethodBeat.m2505o(115628);
        }

        @SuppressLint({"LongLogTag"})
        /* renamed from: ow */
        private Bitmap m51972ow() {
            AppMethodBeat.m2504i(115629);
            if (!(this.aIp.get() == null || this.aIy.get() == null || ((SubsamplingScaleImageView) this.aIp.get()).getFullImageSampleSize() != ((C37204e) this.aIy.get()).sampleSize)) {
                this.mStartTime = System.currentTimeMillis();
            }
            SubsamplingScaleImageView subsamplingScaleImageView;
            try {
                subsamplingScaleImageView = (SubsamplingScaleImageView) this.aIp.get();
                C17565d c17565d = (C17565d) this.aIx.get();
                C37204e c37204e = (C37204e) this.aIy.get();
                if (c17565d == null || c37204e == null || subsamplingScaleImageView == null || !c17565d.isReady() || !c37204e.aIB) {
                    if (c37204e != null) {
                        c37204e.aIA = false;
                    }
                    m51971a((SubsamplingScaleImageView) this.aIp.get(), (C37204e) this.aIy.get());
                    AppMethodBeat.m2505o(115629);
                    return null;
                }
                C4990ab.m7411d("MicroMsg.LegacyTileLoaderFactory", "alvinluo TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", c37204e.aIz, Integer.valueOf(c37204e.sampleSize));
                subsamplingScaleImageView.getDecoderLock().readLock().lock();
                if (c17565d.isReady()) {
                    Rect rect = c37204e.aIz;
                    Rect rect2 = c37204e.aID;
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
                        c37204e.aID.offset(subsamplingScaleImageView.getsRegion().left, subsamplingScaleImageView.getsRegion().top);
                    }
                    C4990ab.m7411d("MicroMsg.LegacyTileLoaderFactory", "alvinluo tile sampleSize: %d", Integer.valueOf(c37204e.sampleSize));
                    Bitmap b = c17565d.mo31996b(c37204e.aID, c37204e.sampleSize);
                    m51971a(subsamplingScaleImageView, c37204e);
                    subsamplingScaleImageView.getDecoderLock().readLock().unlock();
                    AppMethodBeat.m2505o(115629);
                    return b;
                }
                c37204e.aIA = false;
                subsamplingScaleImageView.getDecoderLock().readLock().unlock();
                m51971a((SubsamplingScaleImageView) this.aIp.get(), (C37204e) this.aIy.get());
                AppMethodBeat.m2505o(115629);
                return null;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.LegacyTileLoaderFactory", e, "Failed to decode tile", new Object[0]);
                this.exception = e;
                this.aIu = new C25467c(5, "decode tile failed");
            } catch (OutOfMemoryError e2) {
                C4990ab.printErrStackTrace("MicroMsg.LegacyTileLoaderFactory", e2, "Failed to decode tile - OutOfMemoryError", new Object[0]);
                this.exception = new RuntimeException(e2);
                this.aIu = new C25467c(6, "decode tile OutOfMemoryError");
                SubsamplingScaleImageView.setPreferredBitmapConfig(Config.RGB_565);
            } catch (Throwable th) {
                subsamplingScaleImageView.getDecoderLock().readLock().unlock();
                AppMethodBeat.m2505o(115629);
            }
        }

        /* renamed from: a */
        private void m51971a(SubsamplingScaleImageView subsamplingScaleImageView, C37204e c37204e) {
            AppMethodBeat.m2504i(115630);
            if (!(subsamplingScaleImageView == null || c37204e == null || this.mStartTime == -1 || subsamplingScaleImageView.getFullImageSampleSize() != c37204e.sampleSize)) {
                subsamplingScaleImageView.mo2272dq((int) (System.currentTimeMillis() - this.mStartTime));
            }
            AppMethodBeat.m2505o(115630);
        }

        /* renamed from: ou */
        public final void mo18684ou() {
            AppMethodBeat.m2504i(115631);
            executeOnExecutor(((SubsamplingScaleImageView) this.aIp.get()).executor, new Void[0]);
            AppMethodBeat.m2505o(115631);
        }

        public final void cancel() {
            AppMethodBeat.m2504i(115632);
            try {
                cancel(true);
                this.isCancelled = true;
                AppMethodBeat.m2505o(115632);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.LegacyTileLoaderFactory", e, "alvinluo TileLoaderTask cancel exception", new Object[0]);
                AppMethodBeat.m2505o(115632);
            }
        }
    }

    /* renamed from: a */
    public final C37203b mo66600a(SubsamplingScaleImageView subsamplingScaleImageView, C17565d c17565d, C37204e c37204e) {
        AppMethodBeat.m2504i(115635);
        C31983a c31983a = new C31983a(subsamplingScaleImageView, c17565d, c37204e);
        AppMethodBeat.m2505o(115635);
        return c31983a;
    }
}
