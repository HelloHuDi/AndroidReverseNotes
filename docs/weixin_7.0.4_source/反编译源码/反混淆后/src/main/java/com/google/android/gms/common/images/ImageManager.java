package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.p057v4.p065f.C0408g;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.images.ImageRequest.ImageViewImageRequest;
import com.google.android.gms.common.images.ImageRequest.ListenerImageRequest;
import com.google.android.gms.common.images.internal.PostProcessedResourceCache;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    public static final int PRIORITY_HIGH = 3;
    public static final int PRIORITY_LOW = 1;
    public static final int PRIORITY_MEDIUM = 2;
    private static final Object zzov = new Object();
    private static HashSet<Uri> zzow = new HashSet();
    private static ImageManager zzox;
    private static ImageManager zzoy;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService zzoz = Executors.newFixedThreadPool(4);
    private final zza zzpa;
    private final PostProcessedResourceCache zzpb;
    private final Map<ImageRequest, ImageReceiver> zzpc;
    private final Map<Uri, ImageReceiver> zzpd;
    private final Map<Uri, Long> zzpe;

    static final class zza extends C0408g<zza, Bitmap> {
        public zza(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            super((int) (((float) ((((context.getApplicationInfo().flags & 1048576) != 0 ? 1 : null) != null ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass()) * 1048576)) * 0.33f));
            AppMethodBeat.m2504i(61208);
            AppMethodBeat.m2505o(61208);
        }

        public final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
            AppMethodBeat.m2504i(61210);
            super.entryRemoved(z, (zza) obj, (Bitmap) obj2, (Bitmap) obj3);
            AppMethodBeat.m2505o(61210);
        }

        public final /* synthetic */ int sizeOf(Object obj, Object obj2) {
            AppMethodBeat.m2504i(61209);
            Bitmap bitmap = (Bitmap) obj2;
            int height = bitmap.getHeight() * bitmap.getRowBytes();
            AppMethodBeat.m2505o(61209);
            return height;
        }
    }

    @KeepName
    final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        private final ArrayList<ImageRequest> zzpf = new ArrayList();

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            AppMethodBeat.m2504i(61203);
            this.mUri = uri;
            AppMethodBeat.m2505o(61203);
        }

        public final void onReceiveResult(int i, Bundle bundle) {
            AppMethodBeat.m2504i(61207);
            ImageManager.this.zzoz.execute(new zzb(this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
            AppMethodBeat.m2505o(61207);
        }

        public final void zza(ImageRequest imageRequest) {
            AppMethodBeat.m2504i(61204);
            Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzpf.add(imageRequest);
            AppMethodBeat.m2505o(61204);
        }

        public final void zzb(ImageRequest imageRequest) {
            AppMethodBeat.m2504i(61205);
            Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzpf.remove(imageRequest);
            AppMethodBeat.m2505o(61205);
        }

        public final void zzco() {
            AppMethodBeat.m2504i(61206);
            Intent intent = new Intent(Constants.ACTION_LOAD_IMAGE);
            intent.putExtra(Constants.EXTRA_URI, this.mUri);
            intent.putExtra(Constants.EXTRA_RESULT_RECEIVER, this);
            intent.putExtra(Constants.EXTRA_PRIORITY, 3);
            ImageManager.this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(61206);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    final class zzb implements Runnable {
        private final Uri mUri;
        private final ParcelFileDescriptor zzph;

        public zzb(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.zzph = parcelFileDescriptor;
        }

        public final void run() {
            AppMethodBeat.m2504i(61211);
            Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.zzph != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.zzph.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    String valueOf = String.valueOf(this.mUri);
                    new StringBuilder(String.valueOf(valueOf).length() + 34).append("OOM while loading bitmap for uri: ").append(valueOf);
                    z = true;
                }
                try {
                    this.zzph.close();
                } catch (IOException e2) {
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(new zze(this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
                AppMethodBeat.m2505o(61211);
            } catch (InterruptedException e3) {
                String valueOf2 = String.valueOf(this.mUri);
                new StringBuilder(String.valueOf(valueOf2).length() + 32).append("Latch interrupted while posting ").append(valueOf2);
                AppMethodBeat.m2505o(61211);
            }
        }
    }

    static final class zzd implements ComponentCallbacks2 {
        private final zza zzpa;

        public zzd(zza zza) {
            this.zzpa = zza;
        }

        public final void onConfigurationChanged(Configuration configuration) {
        }

        public final void onLowMemory() {
            AppMethodBeat.m2504i(61213);
            this.zzpa.evictAll();
            AppMethodBeat.m2505o(61213);
        }

        public final void onTrimMemory(int i) {
            AppMethodBeat.m2504i(61214);
            if (i >= 60) {
                this.zzpa.evictAll();
                AppMethodBeat.m2505o(61214);
                return;
            }
            if (i >= 20) {
                this.zzpa.trimToSize(this.zzpa.size() / 2);
            }
            AppMethodBeat.m2505o(61214);
        }
    }

    final class zzc implements Runnable {
        private final ImageRequest zzpi;

        public zzc(ImageRequest imageRequest) {
            this.zzpi = imageRequest;
        }

        public final void run() {
            AppMethodBeat.m2504i(61212);
            Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzpc.get(this.zzpi);
            if (imageReceiver != null) {
                ImageManager.this.zzpc.remove(this.zzpi);
                imageReceiver.zzb(this.zzpi);
            }
            zza zza = this.zzpi.zzpk;
            if (zza.uri == null) {
                this.zzpi.zza(ImageManager.this.mContext, ImageManager.this.zzpb, true);
                AppMethodBeat.m2505o(61212);
                return;
            }
            Bitmap zza2 = ImageManager.zza(ImageManager.this, zza);
            if (zza2 != null) {
                this.zzpi.zza(ImageManager.this.mContext, zza2, true);
                AppMethodBeat.m2505o(61212);
                return;
            }
            Long l = (Long) ImageManager.this.zzpe.get(zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zzpi.zza(ImageManager.this.mContext, ImageManager.this.zzpb, true);
                    AppMethodBeat.m2505o(61212);
                    return;
                }
                ImageManager.this.zzpe.remove(zza.uri);
            }
            this.zzpi.zza(ImageManager.this.mContext, ImageManager.this.zzpb);
            imageReceiver = (ImageReceiver) ImageManager.this.zzpd.get(zza.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(zza.uri);
                ImageManager.this.zzpd.put(zza.uri, imageReceiver);
            }
            imageReceiver.zza(this.zzpi);
            if (!(this.zzpi instanceof ListenerImageRequest)) {
                ImageManager.this.zzpc.put(this.zzpi, imageReceiver);
            }
            synchronized (ImageManager.zzov) {
                try {
                    if (!ImageManager.zzow.contains(zza.uri)) {
                        ImageManager.zzow.add(zza.uri);
                        imageReceiver.zzco();
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(61212);
                }
            }
        }
    }

    final class zze implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        private final CountDownLatch zzfd;
        private boolean zzpj;

        public zze(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.zzpj = z;
            this.zzfd = countDownLatch;
        }

        public final void run() {
            AppMethodBeat.m2504i(61215);
            Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (ImageManager.this.zzpa != null) {
                if (this.zzpj) {
                    ImageManager.this.zzpa.evictAll();
                    System.gc();
                    this.zzpj = false;
                    ImageManager.this.mHandler.post(this);
                    AppMethodBeat.m2505o(61215);
                    return;
                } else if (z) {
                    ImageManager.this.zzpa.put(new zza(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzpd.remove(this.mUri);
            if (imageReceiver != null) {
                ArrayList zza = imageReceiver.zzpf;
                int size = zza.size();
                for (int i = 0; i < size; i++) {
                    ImageRequest imageRequest = (ImageRequest) zza.get(i);
                    if (z) {
                        imageRequest.zza(ImageManager.this.mContext, this.mBitmap, false);
                    } else {
                        ImageManager.this.zzpe.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                        imageRequest.zza(ImageManager.this.mContext, ImageManager.this.zzpb, false);
                    }
                    if (!(imageRequest instanceof ListenerImageRequest)) {
                        ImageManager.this.zzpc.remove(imageRequest);
                    }
                }
            }
            this.zzfd.countDown();
            synchronized (ImageManager.zzov) {
                try {
                    ImageManager.zzow.remove(this.mUri);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(61215);
                }
            }
        }
    }

    static {
        AppMethodBeat.m2504i(61227);
        AppMethodBeat.m2505o(61227);
    }

    private ImageManager(Context context, boolean z) {
        AppMethodBeat.m2504i(61218);
        this.mContext = context.getApplicationContext();
        if (z) {
            this.zzpa = new zza(this.mContext);
            this.mContext.registerComponentCallbacks(new zzd(this.zzpa));
        } else {
            this.zzpa = null;
        }
        this.zzpb = new PostProcessedResourceCache();
        this.zzpc = new HashMap();
        this.zzpd = new HashMap();
        this.zzpe = new HashMap();
        AppMethodBeat.m2505o(61218);
    }

    public static ImageManager create(Context context) {
        AppMethodBeat.m2504i(61216);
        ImageManager create = create(context, false);
        AppMethodBeat.m2505o(61216);
        return create;
    }

    public static ImageManager create(Context context, boolean z) {
        AppMethodBeat.m2504i(61217);
        ImageManager imageManager;
        if (z) {
            if (zzoy == null) {
                zzoy = new ImageManager(context, true);
            }
            imageManager = zzoy;
            AppMethodBeat.m2505o(61217);
            return imageManager;
        }
        if (zzox == null) {
            zzox = new ImageManager(context, false);
        }
        imageManager = zzox;
        AppMethodBeat.m2505o(61217);
        return imageManager;
    }

    static /* synthetic */ Bitmap zza(ImageManager imageManager, zza zza) {
        AppMethodBeat.m2504i(61226);
        Bitmap zza2 = imageManager.zza(zza);
        AppMethodBeat.m2505o(61226);
        return zza2;
    }

    private final Bitmap zza(zza zza) {
        AppMethodBeat.m2504i(61225);
        if (this.zzpa == null) {
            AppMethodBeat.m2505o(61225);
            return null;
        }
        Bitmap bitmap = (Bitmap) this.zzpa.get(zza);
        AppMethodBeat.m2505o(61225);
        return bitmap;
    }

    public final void loadImage(ImageView imageView, int i) {
        AppMethodBeat.m2504i(61220);
        loadImage(new ImageViewImageRequest(imageView, i));
        AppMethodBeat.m2505o(61220);
    }

    public final void loadImage(ImageView imageView, Uri uri) {
        AppMethodBeat.m2504i(61219);
        loadImage(new ImageViewImageRequest(imageView, uri));
        AppMethodBeat.m2505o(61219);
    }

    public final void loadImage(ImageView imageView, Uri uri, int i) {
        AppMethodBeat.m2504i(61221);
        ImageViewImageRequest imageViewImageRequest = new ImageViewImageRequest(imageView, uri);
        imageViewImageRequest.setNoDataPlaceholder(i);
        loadImage(imageViewImageRequest);
        AppMethodBeat.m2505o(61221);
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        AppMethodBeat.m2504i(61222);
        loadImage(new ListenerImageRequest(onImageLoadedListener, uri));
        AppMethodBeat.m2505o(61222);
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        AppMethodBeat.m2504i(61223);
        ListenerImageRequest listenerImageRequest = new ListenerImageRequest(onImageLoadedListener, uri);
        listenerImageRequest.setNoDataPlaceholder(i);
        loadImage(listenerImageRequest);
        AppMethodBeat.m2505o(61223);
    }

    public final void loadImage(ImageRequest imageRequest) {
        AppMethodBeat.m2504i(61224);
        Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
        new zzc(imageRequest).run();
        AppMethodBeat.m2505o(61224);
    }
}
