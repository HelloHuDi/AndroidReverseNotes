package com.bumptech.glide.p086c.p092d.p093a;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.support.p057v4.widget.C8415j;
import android.util.Log;
import com.bumptech.glide.p086c.C17546i;
import com.bumptech.glide.p086c.C17546i.C17545a;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C31968k;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p086c.p088b.p089a.C31925e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.c.d.a.r */
public final class C44997r<T> implements C31968k<T, Bitmap> {
    public static final C17546i<Long> aFJ = C17546i.m27396a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", Long.valueOf(-1), new C246471());
    public static final C17546i<Integer> aFK = C17546i.m27396a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", Integer.valueOf(2), new C415552());
    private static final C25447b aFL = new C25447b();
    private final C25448c<T> aFM;
    private final C25447b aFN;
    private final C31925e awf;

    /* renamed from: com.bumptech.glide.c.d.a.r$d */
    static final class C8549d implements C25448c<ParcelFileDescriptor> {
        C8549d() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo18651a(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
            AppMethodBeat.m2504i(92275);
            mediaMetadataRetriever.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
            AppMethodBeat.m2505o(92275);
        }
    }

    /* renamed from: com.bumptech.glide.c.d.a.r$1 */
    class C246471 implements C17545a<Long> {
        private final ByteBuffer buffer = ByteBuffer.allocate(8);

        C246471() {
            AppMethodBeat.m2504i(92270);
            AppMethodBeat.m2505o(92270);
        }

        /* renamed from: a */
        public final /* synthetic */ void mo18655a(byte[] bArr, Object obj, MessageDigest messageDigest) {
            AppMethodBeat.m2504i(92271);
            Long l = (Long) obj;
            messageDigest.update(bArr);
            synchronized (this.buffer) {
                try {
                    this.buffer.position(0);
                    messageDigest.update(this.buffer.putLong(l.longValue()).array());
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(92271);
                }
            }
        }
    }

    /* renamed from: com.bumptech.glide.c.d.a.r$b */
    static class C25447b {
        C25447b() {
        }
    }

    /* renamed from: com.bumptech.glide.c.d.a.r$c */
    interface C25448c<T> {
        /* renamed from: a */
        void mo18651a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* renamed from: com.bumptech.glide.c.d.a.r$2 */
    class C415552 implements C17545a<Integer> {
        private final ByteBuffer buffer = ByteBuffer.allocate(4);

        C415552() {
            AppMethodBeat.m2504i(92272);
            AppMethodBeat.m2505o(92272);
        }

        /* renamed from: a */
        public final /* synthetic */ void mo18655a(byte[] bArr, Object obj, MessageDigest messageDigest) {
            AppMethodBeat.m2504i(92273);
            Integer num = (Integer) obj;
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.buffer) {
                    try {
                        this.buffer.position(0);
                        messageDigest.update(this.buffer.putInt(num.intValue()).array());
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(92273);
                    }
                }
                return;
            }
            AppMethodBeat.m2505o(92273);
        }
    }

    /* renamed from: com.bumptech.glide.c.d.a.r$a */
    static final class C41556a implements C25448c<AssetFileDescriptor> {
        private C41556a() {
        }

        /* synthetic */ C41556a(byte b) {
            this();
        }

        /* renamed from: a */
        public final /* synthetic */ void mo18651a(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
            AppMethodBeat.m2504i(92274);
            AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            AppMethodBeat.m2505o(92274);
        }
    }

    static {
        AppMethodBeat.m2504i(92280);
        AppMethodBeat.m2505o(92280);
    }

    /* renamed from: a */
    public static C31968k<AssetFileDescriptor, Bitmap> m82401a(C31925e c31925e) {
        AppMethodBeat.m2504i(92276);
        C44997r c44997r = new C44997r(c31925e, new C41556a());
        AppMethodBeat.m2505o(92276);
        return c44997r;
    }

    /* renamed from: b */
    public static C31968k<ParcelFileDescriptor, Bitmap> m82402b(C31925e c31925e) {
        AppMethodBeat.m2504i(92277);
        C44997r c44997r = new C44997r(c31925e, new C8549d());
        AppMethodBeat.m2505o(92277);
        return c44997r;
    }

    private C44997r(C31925e c31925e, C25448c<T> c25448c) {
        this(c31925e, c25448c, aFL);
    }

    private C44997r(C31925e c31925e, C25448c<T> c25448c, C25447b c25447b) {
        this.awf = c31925e;
        this.aFM = c25448c;
        this.aFN = c25447b;
    }

    /* renamed from: a */
    public final boolean mo2235a(T t, C31967j c31967j) {
        return true;
    }

    /* renamed from: a */
    public final C17526u<Bitmap> mo2234a(T t, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92278);
        long longValue = ((Long) c31967j.mo52069a(aFJ)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer valueOf;
            C31955g c31955g;
            Integer num = (Integer) c31967j.mo52069a(aFK);
            if (num == null) {
                valueOf = Integer.valueOf(2);
            } else {
                valueOf = num;
            }
            C31955g c31955g2 = (C31955g) c31967j.mo52069a(C31955g.aFh);
            if (c31955g2 == null) {
                c31955g = C31955g.aFg;
            } else {
                c31955g = c31955g2;
            }
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                this.aFM.mo18651a(mediaMetadataRetriever, t);
                int intValue = valueOf.intValue();
                Bitmap bitmap = null;
                if (!(VERSION.SDK_INT < 27 || i == C8415j.INVALID_ID || i2 == C8415j.INVALID_ID || c31955g == C31955g.aFf)) {
                    bitmap = C44997r.m82400a(mediaMetadataRetriever, longValue, intValue, i, i2, c31955g);
                }
                if (bitmap == null) {
                    bitmap = mediaMetadataRetriever.getFrameAtTime(longValue, intValue);
                }
                mediaMetadataRetriever.release();
                C0771d a = C0771d.m1760a(bitmap, this.awf);
                AppMethodBeat.m2505o(92278);
                return a;
            } catch (RuntimeException e) {
                IOException iOException = new IOException(e);
                AppMethodBeat.m2505o(92278);
                throw iOException;
            } catch (Throwable th) {
                mediaMetadataRetriever.release();
                AppMethodBeat.m2505o(92278);
            }
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: ".concat(String.valueOf(longValue)));
            AppMethodBeat.m2505o(92278);
            throw illegalArgumentException;
        }
    }

    @TargetApi(27)
    /* renamed from: a */
    private static Bitmap m82400a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, C31955g c31955g) {
        AppMethodBeat.m2504i(92279);
        try {
            int i4;
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt3 = parseInt;
                i4 = parseInt2;
            } else {
                parseInt3 = parseInt2;
                i4 = parseInt;
            }
            float l = c31955g.mo31963l(i4, parseInt3, i2, i3);
            Bitmap scaledFrameAtTime = mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(((float) i4) * l), Math.round(((float) parseInt3) * l));
            AppMethodBeat.m2505o(92279);
            return scaledFrameAtTime;
        } catch (Throwable th) {
            Log.isLoggable("VideoDecoder", 3);
            AppMethodBeat.m2505o(92279);
            return null;
        }
    }
}
