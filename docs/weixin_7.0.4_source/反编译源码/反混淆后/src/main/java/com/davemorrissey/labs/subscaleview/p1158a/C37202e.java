package com.davemorrissey.labs.subscaleview.p1158a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.davemorrissey.labs.subscaleview.a.e */
public class C37202e implements C17565d {
    private BitmapRegionDecoder aIn;
    private final ReadWriteLock aIo;
    private final Config ayC;

    public C37202e() {
        this((byte) 0);
    }

    private C37202e(byte b) {
        AppMethodBeat.m2504i(115608);
        this.aIo = new ReentrantReadWriteLock(true);
        Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (preferredBitmapConfig != null) {
            this.ayC = preferredBitmapConfig;
            AppMethodBeat.m2505o(115608);
            return;
        }
        this.ayC = Config.RGB_565;
        AppMethodBeat.m2505o(115608);
    }

    /* renamed from: c */
    public final Point mo31997c(Context context, Uri uri) {
        AppMethodBeat.m2504i(115609);
        String uri2 = uri.toString();
        if (uri2.startsWith("android.resource://")) {
            Resources resources;
            int identifier;
            String authority = uri.getAuthority();
            if (context.getPackageName().equals(authority)) {
                resources = context.getResources();
            } else {
                resources = context.getPackageManager().getResourcesForApplication(authority);
            }
            List pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && ((String) pathSegments.get(0)).equals("drawable")) {
                identifier = resources.getIdentifier((String) pathSegments.get(1), "drawable", authority);
            } else {
                if (size == 1 && TextUtils.isDigitsOnly((CharSequence) pathSegments.get(0))) {
                    try {
                        identifier = C5046bo.getInt((String) pathSegments.get(0), 0);
                    } catch (NumberFormatException e) {
                    }
                }
                identifier = 0;
            }
            this.aIn = BitmapRegionDecoder.newInstance(context.getResources().openRawResource(identifier), false);
        } else if (uri2.startsWith("file:///android_asset/")) {
            this.aIn = BitmapRegionDecoder.newInstance(context.getAssets().open(uri2.substring(22), 1), false);
        } else if (uri2.startsWith("file://")) {
            this.aIn = BitmapRegionDecoder.newInstance(uri2.substring(7), false);
        } else {
            InputStream inputStream = null;
            try {
                inputStream = context.getContentResolver().openInputStream(uri);
                this.aIn = BitmapRegionDecoder.newInstance(inputStream, false);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e2) {
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                    }
                }
                AppMethodBeat.m2505o(115609);
            }
        }
        Point point = new Point(this.aIn.getWidth(), this.aIn.getHeight());
        AppMethodBeat.m2505o(115609);
        return point;
    }

    /* renamed from: b */
    public final Bitmap mo31996b(Rect rect, int i) {
        AppMethodBeat.m2504i(115610);
        m62351os().lock();
        try {
            if (this.aIn == null || this.aIn.isRecycled()) {
                IllegalStateException illegalStateException = new IllegalStateException("Cannot decode region after decoder has been recycled");
                AppMethodBeat.m2505o(115610);
                throw illegalStateException;
            }
            Options options = new Options();
            options.inSampleSize = i;
            options.inPreferredConfig = this.ayC;
            Bitmap decodeRegion = this.aIn.decodeRegion(rect, options);
            if (decodeRegion != null) {
                return decodeRegion;
            }
            RuntimeException runtimeException = new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            AppMethodBeat.m2505o(115610);
            throw runtimeException;
        } finally {
            m62351os().unlock();
            AppMethodBeat.m2505o(115610);
        }
    }

    public final synchronized boolean isReady() {
        boolean z;
        AppMethodBeat.m2504i(115611);
        if (this.aIn == null || this.aIn.isRecycled()) {
            z = false;
            AppMethodBeat.m2505o(115611);
        } else {
            z = true;
            AppMethodBeat.m2505o(115611);
        }
        return z;
    }

    public final synchronized void recycle() {
        AppMethodBeat.m2504i(115612);
        this.aIo.writeLock().lock();
        try {
            this.aIn.recycle();
            this.aIn = null;
            this.aIo.writeLock().unlock();
            AppMethodBeat.m2505o(115612);
        } catch (Throwable th) {
            this.aIo.writeLock().unlock();
            AppMethodBeat.m2505o(115612);
        }
    }

    /* renamed from: os */
    private Lock m62351os() {
        AppMethodBeat.m2504i(115613);
        Lock writeLock;
        if (VERSION.SDK_INT < 21) {
            writeLock = this.aIo.writeLock();
            AppMethodBeat.m2505o(115613);
            return writeLock;
        }
        writeLock = this.aIo.readLock();
        AppMethodBeat.m2505o(115613);
        return writeLock;
    }
}
