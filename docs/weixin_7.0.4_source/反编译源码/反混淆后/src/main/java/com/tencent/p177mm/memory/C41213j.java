package com.tencent.p177mm.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.graphics.C26320a;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import java.io.Closeable;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.memory.j */
public final class C41213j extends C37899l {
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static Bitmap m71741a(InputStream inputStream, Options options) {
        Bitmap bitmap;
        Exception e;
        ByteBuffer byteBuffer;
        Throwable th;
        Object obj;
        Bitmap bitmap2 = null;
        AppMethodBeat.m2504i(115380);
        try {
            ByteBuffer byteBuffer2 = (ByteBuffer) C18605h.fdF.mo56734aA();
            try {
                bitmap2 = C41213j.m71743b(inputStream, null, C41213j.m71742a(inputStream, options, byteBuffer2, false, null));
                if (byteBuffer2 != null) {
                    C18605h.fdF.release(byteBuffer2);
                    bitmap = bitmap2;
                } else {
                    bitmap = bitmap2;
                }
            } catch (Exception e2) {
                e = e2;
                byteBuffer = byteBuffer2;
            } catch (Throwable th2) {
                th = th2;
                byteBuffer = byteBuffer2;
                if (obj != null) {
                    C18605h.fdF.release(obj);
                }
                AppMethodBeat.m2505o(115380);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            obj = bitmap2;
            try {
                C4990ab.m7413e("MicroMsg.InBitmapFactory", "error decode bitmap %s", e.getMessage());
                if (obj != null) {
                    C18605h.fdF.release(obj);
                    bitmap = bitmap2;
                } else {
                    bitmap = bitmap2;
                }
                AppMethodBeat.m2505o(115380);
                return bitmap;
            } catch (Throwable th3) {
                th = th3;
                if (obj != null) {
                }
                AppMethodBeat.m2505o(115380);
                throw th;
            }
        } catch (Throwable th32) {
            th = th32;
            obj = bitmap2;
            if (obj != null) {
            }
            AppMethodBeat.m2505o(115380);
            throw th;
        }
        AppMethodBeat.m2505o(115380);
        return bitmap;
    }

    /* renamed from: a */
    public final Bitmap mo60650a(String str, Options options) {
        Exception e;
        Throwable th;
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(115381);
        Closeable openRead;
        try {
            openRead = C5730e.openRead(str);
            try {
                bitmap = C41213j.m71741a((InputStream) openRead, options);
                C5046bo.m7527b(openRead);
            } catch (Exception e2) {
                e = e2;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.InBitmapFactory", e, "error decode bitmap %s", e.getMessage());
                    C5046bo.m7527b(openRead);
                    AppMethodBeat.m2505o(115381);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    C5046bo.m7527b(openRead);
                    AppMethodBeat.m2505o(115381);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            openRead = bitmap;
        } catch (Throwable th3) {
            th = th3;
            openRead = bitmap;
            C5046bo.m7527b(openRead);
            AppMethodBeat.m2505o(115381);
            throw th;
        }
        AppMethodBeat.m2505o(115381);
        return bitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final Bitmap mo60651a(String str, Rect rect, Options options) {
        Bitmap bitmap;
        Exception e;
        ByteBuffer byteBuffer;
        Throwable th;
        Object obj;
        Closeable byteBuffer2;
        Closeable closeable = null;
        AppMethodBeat.m2504i(115382);
        Closeable openRead;
        try {
            openRead = C5730e.openRead(str);
            try {
                ByteBuffer byteBuffer3 = (ByteBuffer) C18605h.fdF.mo56734aA();
                try {
                    Bitmap b = C41213j.m71743b(openRead, rect, C41213j.m71742a(openRead, options, byteBuffer3, true, rect));
                    if (byteBuffer3 != null) {
                        C18605h.fdF.release(byteBuffer3);
                    }
                    C5046bo.m7527b(openRead);
                    bitmap = b;
                } catch (Exception e2) {
                    e = e2;
                    byteBuffer2 = byteBuffer3;
                } catch (Throwable th2) {
                    th = th2;
                    byteBuffer2 = byteBuffer3;
                    if (obj != null) {
                    }
                    C5046bo.m7527b(openRead);
                    AppMethodBeat.m2505o(115382);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                byteBuffer2 = closeable;
                try {
                    C4990ab.m7413e("MicroMsg.InBitmapFactory", "error decode bitmap %s", e.getMessage());
                    if (obj != null) {
                        C18605h.fdF.release(obj);
                    }
                    C5046bo.m7527b(openRead);
                    Object bitmap2 = closeable;
                    AppMethodBeat.m2505o(115382);
                    return bitmap2;
                } catch (Throwable th3) {
                    th = th3;
                    if (obj != null) {
                    }
                    C5046bo.m7527b(openRead);
                    AppMethodBeat.m2505o(115382);
                    throw th;
                }
            } catch (Throwable th32) {
                th = th32;
                byteBuffer2 = closeable;
                if (obj != null) {
                    C18605h.fdF.release(obj);
                }
                C5046bo.m7527b(openRead);
                AppMethodBeat.m2505o(115382);
                throw th;
            }
        } catch (Exception e32) {
            e = e32;
            openRead = closeable;
            obj = closeable;
        } catch (Throwable th322) {
            th = th322;
            openRead = closeable;
            obj = closeable;
            if (obj != null) {
            }
            C5046bo.m7527b(openRead);
            AppMethodBeat.m2505o(115382);
            throw th;
        }
        AppMethodBeat.m2505o(115382);
        return bitmap2;
    }

    @TargetApi(19)
    /* renamed from: a */
    private static Options m71742a(InputStream inputStream, Options options, ByteBuffer byteBuffer, boolean z, Rect rect) {
        AppMethodBeat.m2504i(115383);
        if (options == null) {
            options = new Options();
        }
        if (byteBuffer != null) {
            options.inTempStorage = byteBuffer.array();
        }
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("cannot get the bitmap size!");
            AppMethodBeat.m2505o(115383);
            throw illegalArgumentException;
        }
        int i;
        Bitmap bitmap;
        boolean z2;
        options.inJustDecodeBounds = false;
        options.inDither = true;
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (rect == null) {
            C4990ab.m7417i("MicroMsg.InBitmapFactory", "options.outWidth: %s, options.outHeight: %s, sampleSize: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(options.inSampleSize));
            i = i3;
        } else {
            i2 = rect.right - rect.left;
            C4990ab.m7417i("MicroMsg.InBitmapFactory", "region decode, width: %s, height: %s, rect: %s", Integer.valueOf(i2), Integer.valueOf(rect.bottom - rect.top), rect);
            i = i3;
        }
        if (z) {
            bitmap = (Bitmap) C42178c.fdx.mo33852d(C42178c.m74378e(Integer.valueOf(i2 * i)));
            if (bitmap != null && C1443d.m3068iW(19)) {
                bitmap.reconfigure(i2, i, Config.ARGB_8888);
            }
        } else {
            bitmap = C42178c.fdx.mo67723f(C42178c.m74378e(Integer.valueOf(i * i2)));
        }
        String str = "MicroMsg.InBitmapFactory";
        String str2 = "bitmapToReuse: %s, isRecycle: %s, isRegionDecode: %s, width: %s, height: %s";
        Object[] objArr = new Object[5];
        objArr[0] = bitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[1] = Boolean.valueOf(z2);
        objArr[2] = Boolean.valueOf(z);
        if (bitmap != null) {
            i = bitmap.getWidth();
        } else {
            i = 0;
        }
        objArr[3] = Integer.valueOf(i);
        objArr[4] = Integer.valueOf(bitmap != null ? bitmap.getHeight() : 0);
        C4990ab.m7417i(str, str2, objArr);
        if (!(bitmap == null || !bitmap.isMutable() || bitmap.isRecycled())) {
            options.inBitmap = bitmap;
        }
        options.inMutable = true;
        C5056d.dnX();
        C4990ab.m7417i("MicroMsg.InBitmapFactory", "mimetype: %s", options.outMimeType);
        AppMethodBeat.m2505o(115383);
        return options;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static Bitmap m71743b(InputStream inputStream, Rect rect, Options options) {
        Bitmap decodeStream;
        Exception e;
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(115384);
        try {
            InputStream t = C37899l.m63999t(inputStream);
            C37899l.m64000u(t);
            t.mark(1048576);
            if (rect == null) {
                try {
                    bitmap = MMBitmapFactory.decodeStream(t, null, options);
                } catch (Exception e2) {
                    int height;
                    String str = "MicroMsg.InBitmapFactory";
                    String str2 = "decode with inBitmap error: %s, outWidth: %s, outHeight: %s, sampleSize: %s, reuseBitmapWidth: %s, reuseBitmapHeight: %s";
                    Object[] objArr = new Object[6];
                    objArr[0] = e2.getMessage();
                    objArr[1] = Integer.valueOf(options.outWidth);
                    objArr[2] = Integer.valueOf(options.outHeight);
                    objArr[3] = Integer.valueOf(options.inSampleSize);
                    objArr[4] = Integer.valueOf(options.inBitmap != null ? options.inBitmap.getWidth() : 0);
                    if (options.inBitmap != null) {
                        height = options.inBitmap.getHeight();
                    } else {
                        height = 0;
                    }
                    objArr[5] = Integer.valueOf(height);
                    C4990ab.printErrStackTrace(str, e2, str2, objArr);
                }
            } else {
                bitmap = C26320a.m41876a(t, rect, options);
            }
            if (bitmap == null) {
                C4990ab.m7416i("MicroMsg.InBitmapFactory", "decode again");
                C37899l.m64000u(t);
                options.inBitmap = null;
                if (rect == null) {
                    decodeStream = MMBitmapFactory.decodeStream(t, null, options);
                } else {
                    decodeStream = C26320a.m41876a(t, rect, options);
                }
            } else {
                decodeStream = bitmap;
            }
            if (!(rect == null || decodeStream == null)) {
                try {
                    if (decodeStream.getWidth() > rect.right - rect.left && decodeStream.getHeight() > rect.bottom - rect.top) {
                        C4990ab.m7417i("MicroMsg.InBitmapFactory", "fuck region decode size not match, clip it, reqWidth: %s, reqHeight: %s, resultWidth: %s, resultHeight: %s", Integer.valueOf(rect.right - rect.left), Integer.valueOf(rect.bottom - rect.top), Integer.valueOf(decodeStream.getWidth()), Integer.valueOf(decodeStream.getHeight()));
                        decodeStream = Bitmap.createBitmap(decodeStream, 0, 0, rect.right - rect.left, rect.bottom - rect.top);
                    }
                } catch (Exception e3) {
                    e = e3;
                    bitmap = decodeStream;
                    C4990ab.m7413e("MicroMsg.InBitmapFactory", "decodeInternal error: %s", e.getMessage());
                    decodeStream = bitmap;
                    if (decodeStream != null) {
                    }
                    AppMethodBeat.m2505o(115384);
                    return decodeStream;
                }
            }
        } catch (Exception e22) {
            e = e22;
        }
        if (decodeStream != null) {
            C4990ab.m7417i("MicroMsg.InBitmapFactory", "finish decode, decodedBitmap: %s, width: %s, height: %s", decodeStream, Integer.valueOf(decodeStream.getWidth()), Integer.valueOf(decodeStream.getHeight()));
        }
        AppMethodBeat.m2505o(115384);
        return decodeStream;
    }

    /* renamed from: v */
    public final void mo60652v(Bitmap bitmap) {
        AppMethodBeat.m2504i(115385);
        if (!(bitmap == null || bitmap.isRecycled())) {
            C42178c.fdx.mo67724f(bitmap);
        }
        AppMethodBeat.m2505o(115385);
    }
}
