package com.bumptech.glide.c.d.a;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.c.b.a.e;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.i;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class r<T> implements k<T, Bitmap> {
    public static final i<Long> aFJ = i.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", Long.valueOf(-1), new com.bumptech.glide.c.i.a<Long>() {
        private final ByteBuffer buffer = ByteBuffer.allocate(8);

        {
            AppMethodBeat.i(92270);
            AppMethodBeat.o(92270);
        }

        public final /* synthetic */ void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
            AppMethodBeat.i(92271);
            Long l = (Long) obj;
            messageDigest.update(bArr);
            synchronized (this.buffer) {
                try {
                    this.buffer.position(0);
                    messageDigest.update(this.buffer.putLong(l.longValue()).array());
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(92271);
                }
            }
        }
    });
    public static final i<Integer> aFK = i.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", Integer.valueOf(2), new com.bumptech.glide.c.i.a<Integer>() {
        private final ByteBuffer buffer = ByteBuffer.allocate(4);

        {
            AppMethodBeat.i(92272);
            AppMethodBeat.o(92272);
        }

        public final /* synthetic */ void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
            AppMethodBeat.i(92273);
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
                        AppMethodBeat.o(92273);
                    }
                }
                return;
            }
            AppMethodBeat.o(92273);
        }
    });
    private static final b aFL = new b();
    private final c<T> aFM;
    private final b aFN;
    private final e awf;

    static final class d implements c<ParcelFileDescriptor> {
        d() {
        }

        public final /* synthetic */ void a(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
            AppMethodBeat.i(92275);
            mediaMetadataRetriever.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
            AppMethodBeat.o(92275);
        }
    }

    static class b {
        b() {
        }
    }

    interface c<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    static final class a implements c<AssetFileDescriptor> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final /* synthetic */ void a(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
            AppMethodBeat.i(92274);
            AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            AppMethodBeat.o(92274);
        }
    }

    static {
        AppMethodBeat.i(92280);
        AppMethodBeat.o(92280);
    }

    public static k<AssetFileDescriptor, Bitmap> a(e eVar) {
        AppMethodBeat.i(92276);
        r rVar = new r(eVar, new a());
        AppMethodBeat.o(92276);
        return rVar;
    }

    public static k<ParcelFileDescriptor, Bitmap> b(e eVar) {
        AppMethodBeat.i(92277);
        r rVar = new r(eVar, new d());
        AppMethodBeat.o(92277);
        return rVar;
    }

    private r(e eVar, c<T> cVar) {
        this(eVar, cVar, aFL);
    }

    private r(e eVar, c<T> cVar, b bVar) {
        this.awf = eVar;
        this.aFM = cVar;
        this.aFN = bVar;
    }

    public final boolean a(T t, j jVar) {
        return true;
    }

    public final u<Bitmap> a(T t, int i, int i2, j jVar) {
        AppMethodBeat.i(92278);
        long longValue = ((Long) jVar.a(aFJ)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer valueOf;
            g gVar;
            Integer num = (Integer) jVar.a(aFK);
            if (num == null) {
                valueOf = Integer.valueOf(2);
            } else {
                valueOf = num;
            }
            g gVar2 = (g) jVar.a(g.aFh);
            if (gVar2 == null) {
                gVar = g.aFg;
            } else {
                gVar = gVar2;
            }
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                this.aFM.a(mediaMetadataRetriever, t);
                int intValue = valueOf.intValue();
                Bitmap bitmap = null;
                if (!(VERSION.SDK_INT < 27 || i == android.support.v4.widget.j.INVALID_ID || i2 == android.support.v4.widget.j.INVALID_ID || gVar == g.aFf)) {
                    bitmap = a(mediaMetadataRetriever, longValue, intValue, i, i2, gVar);
                }
                if (bitmap == null) {
                    bitmap = mediaMetadataRetriever.getFrameAtTime(longValue, intValue);
                }
                mediaMetadataRetriever.release();
                d a = d.a(bitmap, this.awf);
                AppMethodBeat.o(92278);
                return a;
            } catch (RuntimeException e) {
                IOException iOException = new IOException(e);
                AppMethodBeat.o(92278);
                throw iOException;
            } catch (Throwable th) {
                mediaMetadataRetriever.release();
                AppMethodBeat.o(92278);
            }
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: ".concat(String.valueOf(longValue)));
            AppMethodBeat.o(92278);
            throw illegalArgumentException;
        }
    }

    @TargetApi(27)
    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, g gVar) {
        AppMethodBeat.i(92279);
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
            float l = gVar.l(i4, parseInt3, i2, i3);
            Bitmap scaledFrameAtTime = mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(((float) i4) * l), Math.round(((float) parseInt3) * l));
            AppMethodBeat.o(92279);
            return scaledFrameAtTime;
        } catch (Throwable th) {
            Log.isLoggable("VideoDecoder", 3);
            AppMethodBeat.o(92279);
            return null;
        }
    }
}
