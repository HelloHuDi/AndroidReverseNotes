package com.tencent.p177mm.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.graphics.C26320a;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import java.io.Closeable;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.memory.m */
public final class C41214m extends C37899l {
    private static int fdK = -1;

    /* renamed from: a */
    public final Bitmap mo60650a(String str, Options options) {
        Exception e;
        Throwable th;
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(115386);
        Closeable openRead;
        try {
            openRead = C5730e.openRead(str);
            try {
                bitmap = C41214m.m71747b(openRead, null, options);
                C5046bo.m7527b(openRead);
                AppMethodBeat.m2505o(115386);
            } catch (Exception e2) {
                e = e2;
                try {
                    C4990ab.m7413e("MicroMsg.PurgeableBitmapFactory", "decode error: %s", e.getMessage());
                    C5046bo.m7527b(openRead);
                    AppMethodBeat.m2505o(115386);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    C5046bo.m7527b(openRead);
                    AppMethodBeat.m2505o(115386);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            openRead = bitmap;
            C4990ab.m7413e("MicroMsg.PurgeableBitmapFactory", "decode error: %s", e.getMessage());
            C5046bo.m7527b(openRead);
            AppMethodBeat.m2505o(115386);
            return bitmap;
        } catch (Throwable th3) {
            th = th3;
            openRead = bitmap;
            C5046bo.m7527b(openRead);
            AppMethodBeat.m2505o(115386);
            throw th;
        }
        return bitmap;
    }

    /* renamed from: a */
    public final Bitmap mo60651a(String str, Rect rect, Options options) {
        Exception e;
        Throwable th;
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(115387);
        Closeable openRead;
        try {
            openRead = C5730e.openRead(str);
            try {
                bitmap = C41214m.m71747b(openRead, rect, options);
                C5046bo.m7527b(openRead);
                AppMethodBeat.m2505o(115387);
            } catch (Exception e2) {
                e = e2;
                try {
                    C4990ab.m7413e("MicroMsg.PurgeableBitmapFactory", "decode error: %s", e.getMessage());
                    C5046bo.m7527b(openRead);
                    AppMethodBeat.m2505o(115387);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    C5046bo.m7527b(openRead);
                    AppMethodBeat.m2505o(115387);
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
            AppMethodBeat.m2505o(115387);
            throw th;
        }
        return bitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static Bitmap m71747b(InputStream inputStream, Rect rect, Options options) {
        Exception e;
        Object obj;
        Throwable th;
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(115388);
        try {
            ByteBuffer byteBuffer = (ByteBuffer) C18605h.fdF.mo56734aA();
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
                        C18605h.fdF.release(obj);
                    }
                    AppMethodBeat.m2505o(115388);
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
                AppMethodBeat.m2505o(115388);
                throw illegalArgumentException;
            }
            C4990ab.m7417i("MicroMsg.PurgeableBitmapFactory", "mimetype: %s", options.outMimeType);
            options.inDither = true;
            options.inMutable = true;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inJustDecodeBounds = false;
            C5056d.dnX();
            InputStream t = C37899l.m63999t(inputStream);
            C37899l.m64000u(t);
            bitmap = C41214m.m71748c(t, rect, options);
            if (byteBuffer != null) {
                C18605h.fdF.release(byteBuffer);
            }
            AppMethodBeat.m2505o(115388);
            return bitmap;
        } catch (Exception e3) {
            e = e3;
            Bitmap obj2 = bitmap;
            try {
                C4990ab.m7413e("MicroMsg.PurgeableBitmapFactory", "error decode bitmap %s", e.getMessage());
                if (obj2 != null) {
                    C18605h.fdF.release(obj2);
                }
                AppMethodBeat.m2505o(115388);
                return bitmap;
            } catch (Throwable th3) {
                th = th3;
                if (obj2 != null) {
                }
                AppMethodBeat.m2505o(115388);
                throw th;
            }
        } catch (Throwable th32) {
            th = th32;
            obj2 = bitmap;
            if (obj2 != null) {
            }
            AppMethodBeat.m2505o(115388);
            throw th;
        }
    }

    /* renamed from: c */
    private static Bitmap m71748c(InputStream inputStream, Rect rect, Options options) {
        byte[] bArr;
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(115389);
        int i = -1;
        if (inputStream != null) {
            try {
                i = inputStream.available();
                byte[] bArr2 = (byte[]) C32771g.fdE.mo20956a(Integer.valueOf(i));
                if (bArr2 == null) {
                    try {
                        bArr = new byte[i];
                    } catch (Exception e2) {
                        e = e2;
                        bArr = bArr2;
                        try {
                            C4990ab.m7413e("MicroMsg.PurgeableBitmapFactory", "decodeByByteArray error: %s", e.getMessage());
                            C5046bo.m7527b(inputStream);
                            if (i > 0 && bArr != null) {
                                C32771g.fdE.mo53316g(bArr);
                            }
                            AppMethodBeat.m2505o(115389);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            C5046bo.m7527b(inputStream);
                            if (i > 0 && bArr != null) {
                                C32771g.fdE.mo53316g(bArr);
                            }
                            AppMethodBeat.m2505o(115389);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bArr = bArr2;
                        C5046bo.m7527b(inputStream);
                        C32771g.fdE.mo53316g(bArr);
                        AppMethodBeat.m2505o(115389);
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
                        decodeByteArray = C26320a.m41877a(bArr, i, rect, options);
                    }
                    decodeByteArray = MMBitmapFactory.pinBitmap(decodeByteArray);
                    C5046bo.m7527b(inputStream);
                    if (i > 0 && bArr != null) {
                        C32771g.fdE.mo53316g(bArr);
                    }
                    AppMethodBeat.m2505o(115389);
                    return decodeByteArray;
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e32) {
                e = e32;
                bArr = null;
                C4990ab.m7413e("MicroMsg.PurgeableBitmapFactory", "decodeByByteArray error: %s", e.getMessage());
                C5046bo.m7527b(inputStream);
                C32771g.fdE.mo53316g(bArr);
                AppMethodBeat.m2505o(115389);
                return null;
            } catch (Throwable th22) {
                th = th22;
                bArr = null;
                C5046bo.m7527b(inputStream);
                C32771g.fdE.mo53316g(bArr);
                AppMethodBeat.m2505o(115389);
                throw th;
            }
        }
        C5046bo.m7527b(inputStream);
        AppMethodBeat.m2505o(115389);
        return null;
    }

    /* renamed from: v */
    public final void mo60652v(Bitmap bitmap) {
        AppMethodBeat.m2504i(115390);
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    C4990ab.m7417i("MicroMsg.PurgeableBitmapFactory", "bitmap recycle %s", bitmap.toString());
                    bitmap.recycle();
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.PurgeableBitmapFactory", "recycle error: %s", e.getMessage());
                AppMethodBeat.m2505o(115390);
                return;
            }
        }
        AppMethodBeat.m2505o(115390);
    }
}
