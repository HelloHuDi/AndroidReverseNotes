package com.tencent.p177mm.plugin.mmsight.segment;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever */
public class FFmpegMetadataRetriever {
    public static final String METADATA_CHAPTER_COUNT = "chapter_count";
    public static final String METADATA_KEY_ALBUM = "album";
    public static final String METADATA_KEY_ALBUM_ARTIST = "album_artist";
    public static final String METADATA_KEY_ARTIST = "artist";
    public static final String METADATA_KEY_AUDIO_CODEC = "audio_codec";
    public static final String METADATA_KEY_CHAPTER_END_TIME = "chapter_end_time";
    public static final String METADATA_KEY_CHAPTER_START_TIME = "chapter_start_time";
    public static final String METADATA_KEY_COMMENT = "comment";
    public static final String METADATA_KEY_COMPOSER = "composer";
    public static final String METADATA_KEY_COPYRIGHT = "copyright";
    public static final String METADATA_KEY_CREATION_TIME = "creation_time";
    public static final String METADATA_KEY_DATE = "date";
    public static final String METADATA_KEY_DISC = "disc";
    public static final String METADATA_KEY_DURATION = "duration";
    public static final String METADATA_KEY_ENCODED_BY = "encoded_by";
    public static final String METADATA_KEY_ENCODER = "encoder";
    public static final String METADATA_KEY_FILENAME = "filename";
    public static final String METADATA_KEY_FILESIZE = "filesize";
    public static final String METADATA_KEY_FRAMERATE = "framerate";
    public static final String METADATA_KEY_GENRE = "genre";
    public static final String METADATA_KEY_ICY_METADATA = "icy_metadata";
    public static final String METADATA_KEY_LANGUAGE = "language";
    public static final String METADATA_KEY_PERFORMER = "performer";
    public static final String METADATA_KEY_PUBLISHER = "publisher";
    public static final String METADATA_KEY_SERVICE_NAME = "service_name";
    public static final String METADATA_KEY_SERVICE_PROVIDER = "service_provider";
    public static final String METADATA_KEY_TITLE = "title";
    public static final String METADATA_KEY_TRACK = "track";
    public static final String METADATA_KEY_VARIANT_BITRATE = "bitrate";
    public static final String METADATA_KEY_VIDEO_CODEC = "video_codec";
    public static final String METADATA_KEY_VIDEO_HEIGHT = "video_height";
    public static final String METADATA_KEY_VIDEO_ROTATION = "rotate";
    public static final String METADATA_KEY_VIDEO_WIDTH = "video_width";
    public static final int OPTION_CLOSEST = 3;
    public static final int OPTION_CLOSEST_SYNC = 2;
    public static final int OPTION_NEXT_SYNC = 1;
    public static final int OPTION_PREVIOUS_SYNC = 0;
    private static final String TAG = "FFmpegMetadataRetriever";
    private long mNativeContext;
    private Bitmap reuse;

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever$a */
    public class C12567a {
        HashMap<String, String> oxG;
    }

    private native byte[] _getFrameAtTime(long j, int i);

    private native byte[] _getScaledFrameAtTime(long j, int i, int i2, int i3);

    private native void _setDataSource(String str, String[] strArr, String[] strArr2);

    private native void native_finalize();

    private final native HashMap<String, String> native_getMetadata(boolean z, boolean z2, HashMap<String, String> hashMap);

    private static native void native_init();

    private native void native_setup();

    public native String extractMetadata(String str);

    public native String extractMetadataFromChapter(String str, int i);

    public native void release();

    public native void setDataSource(FileDescriptor fileDescriptor, long j, long j2);

    static {
        AppMethodBeat.m2504i(3627);
        FFmpegMetadataRetriever.native_init();
        AppMethodBeat.m2505o(3627);
    }

    public FFmpegMetadataRetriever() {
        AppMethodBeat.m2504i(3609);
        native_setup();
        AppMethodBeat.m2505o(3609);
    }

    public void setDataSource(String str) {
        AppMethodBeat.m2504i(3610);
        _setDataSource(str, null, null);
        AppMethodBeat.m2505o(3610);
    }

    public void setDataSource(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(3611);
        int i = 0;
        String[] strArr = new String[map.size()];
        String[] strArr2 = new String[map.size()];
        Iterator it = map.entrySet().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                strArr[i2] = (String) entry.getKey();
                strArr2[i2] = (String) entry.getValue();
                i = i2 + 1;
            } else {
                _setDataSource(str, strArr, strArr2);
                AppMethodBeat.m2505o(3611);
                return;
            }
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        AppMethodBeat.m2504i(3612);
        setDataSource(fileDescriptor, 0, 576460752303423487L);
        AppMethodBeat.m2505o(3612);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x007c A:{SYNTHETIC, Splitter:B:37:0x007c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDataSource(Context context, Uri uri) {
        AssetFileDescriptor assetFileDescriptor;
        Throwable th;
        AppMethodBeat.m2504i(3613);
        IllegalArgumentException illegalArgumentException;
        if (uri == null) {
            illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(3613);
            throw illegalArgumentException;
        }
        String scheme = uri.getScheme();
        if (scheme == null || scheme.equals("file")) {
            setDataSource(uri.getPath());
            AppMethodBeat.m2505o(3613);
            return;
        }
        assetFileDescriptor = null;
        AssetFileDescriptor openAssetFileDescriptor;
        try {
            openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r");
            if (openAssetFileDescriptor == null) {
                try {
                    illegalArgumentException = new IllegalArgumentException();
                    AppMethodBeat.m2505o(3613);
                    throw illegalArgumentException;
                } catch (SecurityException e) {
                    assetFileDescriptor = openAssetFileDescriptor;
                } catch (Throwable th2) {
                    th = th2;
                    if (openAssetFileDescriptor != null) {
                        try {
                            openAssetFileDescriptor.close();
                        } catch (IOException e2) {
                        }
                    }
                    AppMethodBeat.m2505o(3613);
                    throw th;
                }
            }
            FileDescriptor fileDescriptor = openAssetFileDescriptor.getFileDescriptor();
            if (fileDescriptor.valid()) {
                if (openAssetFileDescriptor.getDeclaredLength() < 0) {
                    setDataSource(fileDescriptor);
                } else {
                    setDataSource(fileDescriptor, openAssetFileDescriptor.getStartOffset(), openAssetFileDescriptor.getDeclaredLength());
                }
                if (openAssetFileDescriptor != null) {
                    try {
                        openAssetFileDescriptor.close();
                    } catch (IOException e3) {
                        AppMethodBeat.m2505o(3613);
                        return;
                    }
                }
                AppMethodBeat.m2505o(3613);
                return;
            }
            illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(3613);
            throw illegalArgumentException;
        } catch (FileNotFoundException e4) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException();
            AppMethodBeat.m2505o(3613);
            throw illegalArgumentException2;
        } catch (SecurityException e5) {
        } catch (Throwable th3) {
            th = th3;
            openAssetFileDescriptor = null;
            if (openAssetFileDescriptor != null) {
            }
            AppMethodBeat.m2505o(3613);
            throw th;
        }
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
            } catch (IOException e6) {
            }
        }
        setDataSource(uri.toString());
        AppMethodBeat.m2505o(3613);
        setDataSource(uri.toString());
        AppMethodBeat.m2505o(3613);
    }

    public C12567a getMetadata() {
        boolean z = false;
        AppMethodBeat.m2504i(3614);
        C12567a c12567a = new C12567a();
        HashMap native_getMetadata = native_getMetadata(false, false, null);
        if (native_getMetadata == null) {
            AppMethodBeat.m2505o(3614);
            return null;
        }
        if (native_getMetadata != null) {
            c12567a.oxG = native_getMetadata;
            z = true;
        }
        if (z) {
            AppMethodBeat.m2505o(3614);
            return c12567a;
        }
        AppMethodBeat.m2505o(3614);
        return null;
    }

    public Bitmap getFrameAtTime(long j, int i) {
        AppMethodBeat.m2504i(3615);
        if (i < 0 || i > 3) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported option: ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(3615);
            throw illegalArgumentException;
        }
        Bitmap bitmap = null;
        byte[] _getFrameAtTime = _getFrameAtTime(j, i);
        if (_getFrameAtTime != null) {
            bitmap = getBitmapFromPixels(_getFrameAtTime, -1, -1);
        }
        AppMethodBeat.m2505o(3615);
        return bitmap;
    }

    public Bitmap getFrameAtTime(long j) {
        AppMethodBeat.m2504i(3616);
        Bitmap bitmap = null;
        byte[] _getFrameAtTime = _getFrameAtTime(j, 2);
        if (_getFrameAtTime != null) {
            bitmap = getBitmapFromPixels(_getFrameAtTime, -1, -1);
        }
        AppMethodBeat.m2505o(3616);
        return bitmap;
    }

    public Bitmap getFrameAtTime() {
        AppMethodBeat.m2504i(3617);
        Bitmap frameAtTime = getFrameAtTime(-1, 2);
        AppMethodBeat.m2505o(3617);
        return frameAtTime;
    }

    public Bitmap getScaledFrameAtTime(long j, int i, int i2, int i3) {
        AppMethodBeat.m2504i(3618);
        if (i < 0 || i > 3) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported option: ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(3618);
            throw illegalArgumentException;
        }
        Bitmap bitmap = null;
        byte[] _getScaledFrameAtTime = _getScaledFrameAtTime(j, i, i2, i3);
        if (_getScaledFrameAtTime != null) {
            bitmap = getBitmapFromPixels(_getScaledFrameAtTime, i2, i3);
        }
        AppMethodBeat.m2505o(3618);
        return bitmap;
    }

    public Bitmap getScaledFrameAtTime(long j, int i, int i2) {
        AppMethodBeat.m2504i(3619);
        Bitmap bitmap = null;
        byte[] _getScaledFrameAtTime = _getScaledFrameAtTime(j, 0, i, i2);
        if (_getScaledFrameAtTime != null) {
            bitmap = getBitmapFromPixels(_getScaledFrameAtTime, i, i2);
        }
        AppMethodBeat.m2505o(3619);
        return bitmap;
    }

    public void reuseBitmap(Bitmap bitmap) {
        AppMethodBeat.m2504i(3620);
        if (bitmap == null) {
            AppMethodBeat.m2505o(3620);
            return;
        }
        if (this.reuse != null) {
            this.reuse.recycle();
        }
        this.reuse = bitmap;
        AppMethodBeat.m2505o(3620);
    }

    private Bitmap getBitmapFromPixels(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(3621);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.m2505o(3621);
            return null;
        }
        if (i == -1) {
            i = getVideoWidth();
        }
        if (i2 == -1) {
            i2 = getVideoHeight();
        }
        if (i <= 0 || i2 <= 0) {
            IllegalStateException illegalStateException = new IllegalStateException(String.format(Locale.CHINA, "Can not get bitmap width and height [%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            AppMethodBeat.m2505o(3621);
            throw illegalStateException;
        }
        Bitmap bitmap = this.reuse;
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        }
        bitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        AppMethodBeat.m2505o(3621);
        return bitmap;
    }

    public int getVideoWidth() {
        int i = 0;
        AppMethodBeat.m2504i(3622);
        try {
            String extractMetadata = extractMetadata(METADATA_KEY_VIDEO_ROTATION);
            if ("90".equals(extractMetadata) || "270".equals(extractMetadata)) {
                extractMetadata = extractMetadata(METADATA_KEY_VIDEO_HEIGHT);
            } else {
                extractMetadata = extractMetadata(METADATA_KEY_VIDEO_WIDTH);
            }
            i = Integer.valueOf(extractMetadata).intValue();
        } catch (Exception e) {
            C4990ab.m7413e(TAG, "can not get video width %s", e.getMessage());
        }
        AppMethodBeat.m2505o(3622);
        return i;
    }

    public int getVideoRotation() {
        int i = 0;
        AppMethodBeat.m2504i(3623);
        try {
            i = Integer.valueOf(extractMetadata(METADATA_KEY_VIDEO_ROTATION)).intValue();
        } catch (Exception e) {
            C4990ab.m7413e(TAG, "can not get video rotation. %s", e.getMessage());
        }
        AppMethodBeat.m2505o(3623);
        return i;
    }

    public int getVideoHeight() {
        int i = 0;
        AppMethodBeat.m2504i(3624);
        try {
            String extractMetadata;
            String extractMetadata2 = extractMetadata(METADATA_KEY_VIDEO_ROTATION);
            if ("90".equals(extractMetadata2) || "270".equals(extractMetadata2)) {
                extractMetadata = extractMetadata(METADATA_KEY_VIDEO_WIDTH);
            } else {
                extractMetadata = extractMetadata(METADATA_KEY_VIDEO_HEIGHT);
            }
            C4990ab.m7411d(TAG, "video height %s rotate %s", extractMetadata, extractMetadata2);
            i = Integer.valueOf(extractMetadata).intValue();
        } catch (Exception e) {
            C4990ab.m7413e(TAG, "can not get video height %s", e.getMessage());
        }
        AppMethodBeat.m2505o(3624);
        return i;
    }

    public byte[] getScaledFrameAtTimeUndecoded(long j, int i, int i2) {
        AppMethodBeat.m2504i(3625);
        byte[] _getScaledFrameAtTime = _getScaledFrameAtTime(j, 2, i, i2);
        AppMethodBeat.m2505o(3625);
        return _getScaledFrameAtTime;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(3626);
        try {
            native_finalize();
        } catch (Exception e) {
            C4990ab.m7412e(TAG, "do nothing");
        } finally {
            super.finalize();
            AppMethodBeat.m2505o(3626);
        }
    }
}
