package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.graphics.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import java.io.Closeable;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class m extends l {
    private static int fdK = -1;

    public final Bitmap a(String str, Options options) {
        Exception e;
        Throwable th;
        Bitmap bitmap = null;
        AppMethodBeat.i(115386);
        Closeable openRead;
        try {
            openRead = e.openRead(str);
            try {
                bitmap = b(openRead, null, options);
                bo.b(openRead);
                AppMethodBeat.o(115386);
            } catch (Exception e2) {
                e = e2;
                try {
                    ab.e("MicroMsg.PurgeableBitmapFactory", "decode error: %s", e.getMessage());
                    bo.b(openRead);
                    AppMethodBeat.o(115386);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    bo.b(openRead);
                    AppMethodBeat.o(115386);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            openRead = bitmap;
            ab.e("MicroMsg.PurgeableBitmapFactory", "decode error: %s", e.getMessage());
            bo.b(openRead);
            AppMethodBeat.o(115386);
            return bitmap;
        } catch (Throwable th3) {
            th = th3;
            openRead = bitmap;
            bo.b(openRead);
            AppMethodBeat.o(115386);
            throw th;
        }
        return bitmap;
    }

    public final Bitmap a(String str, Rect rect, Options options) {
        Exception e;
        Throwable th;
        Bitmap bitmap = null;
        AppMethodBeat.i(115387);
        Closeable openRead;
        try {
            openRead = e.openRead(str);
            try {
                bitmap = b(openRead, rect, options);
                bo.b(openRead);
                AppMethodBeat.o(115387);
            } catch (Exception e2) {
                e = e2;
                try {
                    ab.e("MicroMsg.PurgeableBitmapFactory", "decode error: %s", e.getMessage());
                    bo.b(openRead);
                    AppMethodBeat.o(115387);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    bo.b(openRead);
                    AppMethodBeat.o(115387);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            openRead = bitmap;
        } catch (Throwable th3) {
            th = th3;
            openRead = bitmap;
            bo.b(openRead);
            AppMethodBeat.o(115387);
            throw th;
        }
        return bitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static Bitmap b(InputStream inputStream, Rect rect, Options options) {
        Exception e;
        Object obj;
        Throwable th;
        Bitmap bitmap = null;
        AppMethodBeat.i(115388);
        try {
            ByteBuffer byteBuffer = (ByteBuffer) h.fdF.aA();
            if (options == null) {
                try {
                    options = new Options();
                } catch (Exception e2) {
                    e = e2;
                    obj = byteBuffer;
                } catch (Throwable th2) {
                    th = th2;
                    ByteBuffer byteBuffer2 = byteBuffer;
                    if (obj != null) {
                        h.fdF.release(obj);
                    }
                    AppMethodBeat.o(115388);
                    throw th;
                }
            }
            if (byteBuffer != null) {
                options.inTempStorage = byteBuffer.array();
            }
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeStream(inputStream, null, options);
            if (options.outWidth == -1 || options.outHeight == -1) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("cannot get the bitmap size!");
                AppMethodBeat.o(115388);
                throw illegalArgumentException;
            }
            ab.i("MicroMsg.PurgeableBitmapFactory", "mimetype: %s", options.outMimeType);
            options.inDither = true;
            options.inMutable = true;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inJustDecodeBounds = false;
            d.dnX();
            InputStream t = l.t(inputStream);
            l.u(t);
            bitmap = c(t, rect, options);
            if (byteBuffer != null) {
                h.fdF.release(byteBuffer);
            }
            AppMethodBeat.o(115388);
            return bitmap;
        } catch (Exception e3) {
            e = e3;
            Bitmap obj2 = bitmap;
            try {
                ab.e("MicroMsg.PurgeableBitmapFactory", "error decode bitmap %s", e.getMessage());
                if (obj2 != null) {
                    h.fdF.release(obj2);
                }
                AppMethodBeat.o(115388);
                return bitmap;
            } catch (Throwable th3) {
                th = th3;
                if (obj2 != null) {
                }
                AppMethodBeat.o(115388);
                throw th;
            }
        } catch (Throwable th32) {
            th = th32;
            obj2 = bitmap;
            if (obj2 != null) {
            }
            AppMethodBeat.o(115388);
            throw th;
        }
    }

    private static Bitmap c(InputStream inputStream, Rect rect, Options options) {
        byte[] bArr;
        Exception e;
        Throwable th;
        AppMethodBeat.i(115389);
        int i = -1;
        if (inputStream != null) {
            try {
                i = inputStream.available();
                byte[] bArr2 = (byte[]) g.fdE.a(Integer.valueOf(i));
                if (bArr2 == null) {
                    try {
                        bArr = new byte[i];
                    } catch (Exception e2) {
                        e = e2;
                        bArr = bArr2;
                        try {
                            ab.e("MicroMsg.PurgeableBitmapFactory", "decodeByByteArray error: %s", e.getMessage());
                            bo.b(inputStream);
                            if (i > 0 && bArr != null) {
                                g.fdE.g(bArr);
                            }
                            AppMethodBeat.o(115389);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            bo.b(inputStream);
                            if (i > 0 && bArr != null) {
                                g.fdE.g(bArr);
                            }
                            AppMethodBeat.o(115389);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bArr = bArr2;
                        bo.b(inputStream);
                        g.fdE.g(bArr);
                        AppMethodBeat.o(115389);
                        throw th;
                    }
                }
                bArr = bArr2;
                try {
                    Bitmap decodeByteArray;
                    inputStream.read(bArr);
                    if (rect == null) {
                        decodeByteArray = MMBitmapFactory.decodeByteArray(bArr, 0, i, options);
                    } else {
                        decodeByteArray = a.a(bArr, i, rect, options);
                    }
                    decodeByteArray = MMBitmapFactory.pinBitmap(decodeByteArray);
                    bo.b(inputStream);
                    if (i > 0 && bArr != null) {
                        g.fdE.g(bArr);
                    }
                    AppMethodBeat.o(115389);
                    return decodeByteArray;
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e32) {
                e = e32;
                bArr = null;
                ab.e("MicroMsg.PurgeableBitmapFactory", "decodeByByteArray error: %s", e.getMessage());
                bo.b(inputStream);
                g.fdE.g(bArr);
                AppMethodBeat.o(115389);
                return null;
            } catch (Throwable th22) {
                th = th22;
                bArr = null;
                bo.b(inputStream);
                g.fdE.g(bArr);
                AppMethodBeat.o(115389);
                throw th;
            }
        }
        bo.b(inputStream);
        AppMethodBeat.o(115389);
        return null;
    }

    public final void v(Bitmap bitmap) {
        AppMethodBeat.i(115390);
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    ab.i("MicroMsg.PurgeableBitmapFactory", "bitmap recycle %s", bitmap.toString());
                    bitmap.recycle();
                }
            } catch (Exception e) {
                ab.e("MicroMsg.PurgeableBitmapFactory", "recycle error: %s", e.getMessage());
                AppMethodBeat.o(115390);
                return;
            }
        }
        AppMethodBeat.o(115390);
    }
}
