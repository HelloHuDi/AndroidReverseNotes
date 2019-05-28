package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

public class f {
    public byte[] eMl = new byte[0];
    ak fbD;
    private boolean vuA = true;
    private com.tencent.mm.platformtools.x.a vuB = new com.tencent.mm.platformtools.x.a() {
        public final void m(String str, final Bitmap bitmap) {
            boolean z = false;
            AppMethodBeat.i(79931);
            String str2 = "MicroMsg.ImageEngine";
            String str3 = "on get picture finish, notifyKey[%s], bitmap is null[%B]";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (bitmap == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            ab.v(str2, str3, objArr);
            if (bitmap == null) {
                AppMethodBeat.o(79931);
                return;
            }
            f.this.vuw.put(str, (Object) bitmap);
            final ImageView imageView = (ImageView) f.this.vuu.get(str);
            if (imageView != null) {
                f.this.vuv.remove(imageView);
                f.this.fbD.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(79930);
                        c.b(imageView, bitmap);
                        AppMethodBeat.o(79930);
                    }
                });
            }
            f.this.vuu.remove(str);
            AppMethodBeat.o(79931);
        }
    };
    volatile boolean vur = false;
    private HandlerThread vus = com.tencent.mm.sdk.g.d.anM("ImageEngine_handlerThread" + System.currentTimeMillis());
    private ak vut;
    public HashMap<String, ImageView> vuu = new HashMap();
    public HashMap<ImageView, String> vuv = new HashMap();
    com.tencent.mm.memory.a.b<Bitmap> vuw;
    private SparseArray<Bitmap> vux;
    a<d> vuy;
    a<b> vuz;

    class b implements Runnable {
        private int eTi;
        private int eTj;
        private String url;
        private String[] vuL;
        private String vuM;

        private b() {
        }

        /* synthetic */ b(f fVar, byte b) {
            this();
        }

        private Bitmap ajZ(String str) {
            AppMethodBeat.i(79933);
            if (str == null) {
                AppMethodBeat.o(79933);
                return null;
            }
            Bitmap vv;
            if (this.eTj <= 0 || this.eTi <= 0) {
                vv = x.vv(str);
            } else {
                String str2 = str + "_" + this.eTi + "_" + this.eTj;
                vv = x.q(str2, this.eTi, this.eTj);
                if (vv == null) {
                    int bJ = ExifHelper.bJ(str);
                    if (90 == bJ || 270 == bJ) {
                        vv = com.tencent.mm.sdk.platformtools.d.d(str, this.eTi, this.eTj, true);
                    } else {
                        vv = com.tencent.mm.sdk.platformtools.d.d(str, this.eTj, this.eTi, true);
                    }
                    if (vv != null) {
                        vv = com.tencent.mm.sdk.platformtools.d.b(vv, (float) bJ);
                        try {
                            com.tencent.mm.sdk.platformtools.d.a(vv, 100, CompressFormat.PNG, str2, false);
                        } catch (IOException e) {
                            ab.printErrStackTrace("MicroMsg.ImageEngine", e, "", new Object[0]);
                        }
                    }
                }
            }
            AppMethodBeat.o(79933);
            return vv;
        }

        /* JADX WARNING: Missing block: B:12:0x0042, code skipped:
            r0 = null;
     */
        /* JADX WARNING: Missing block: B:13:0x0045, code skipped:
            if (r7.vuL == null) goto L_0x0062;
     */
        /* JADX WARNING: Missing block: B:14:0x0047, code skipped:
            r1 = 0;
     */
        /* JADX WARNING: Missing block: B:16:0x004b, code skipped:
            if (r1 >= r7.vuL.length) goto L_0x0062;
     */
        /* JADX WARNING: Missing block: B:17:0x004d, code skipped:
            if (r1 != 0) goto L_0x00d7;
     */
        /* JADX WARNING: Missing block: B:18:0x004f, code skipped:
            r0 = ajZ(r7.vuL[0]);
     */
        /* JADX WARNING: Missing block: B:19:0x0057, code skipped:
            if (r0 == null) goto L_0x0104;
     */
        /* JADX WARNING: Missing block: B:20:0x0059, code skipped:
            r7.vuC.vuw.put(r7.vuM, (java.lang.Object) r0);
     */
        /* JADX WARNING: Missing block: B:21:0x0062, code skipped:
            if (r0 != null) goto L_0x0089;
     */
        /* JADX WARNING: Missing block: B:23:0x006a, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r7.url) != false) goto L_0x0089;
     */
        /* JADX WARNING: Missing block: B:24:0x006c, code skipped:
            r0 = com.tencent.mm.platformtools.x.a(r7.vuC.h(r7.vuM, r7.url, r7.eTi, r7.eTj));
     */
        /* JADX WARNING: Missing block: B:25:0x007e, code skipped:
            if (r0 == null) goto L_0x0089;
     */
        /* JADX WARNING: Missing block: B:26:0x0080, code skipped:
            r7.vuC.vuw.put(r7.vuM, (java.lang.Object) r0);
     */
        /* JADX WARNING: Missing block: B:27:0x0089, code skipped:
            r2 = r0;
     */
        /* JADX WARNING: Missing block: B:28:0x008a, code skipped:
            if (r2 == null) goto L_0x00c5;
     */
        /* JADX WARNING: Missing block: B:29:0x008c, code skipped:
            r3 = r7.vuC.eMl;
     */
        /* JADX WARNING: Missing block: B:30:0x0090, code skipped:
            monitor-enter(r3);
     */
        /* JADX WARNING: Missing block: B:32:?, code skipped:
            r0 = (android.widget.ImageView) r7.vuC.vuu.get(r7.vuM);
     */
        /* JADX WARNING: Missing block: B:33:0x009d, code skipped:
            if (r0 == null) goto L_0x00bb;
     */
        /* JADX WARNING: Missing block: B:34:0x009f, code skipped:
            r7.vuC.vuv.remove(r0);
            r1 = (com.tencent.mm.pluginsdk.ui.tools.f.d) r7.vuC.vuy.dls();
            r1.cAw = r0;
            r1.mQQ = r2;
            r7.vuC.fbD.post(r1);
     */
        /* JADX WARNING: Missing block: B:35:0x00bb, code skipped:
            r7.vuC.vuu.remove(r7.vuM);
     */
        /* JADX WARNING: Missing block: B:36:0x00c4, code skipped:
            monitor-exit(r3);
     */
        /* JADX WARNING: Missing block: B:37:0x00c5, code skipped:
            r7.vuC.vuz.cy(r7);
            com.tencent.matrix.trace.core.AppMethodBeat.o(79934);
     */
        /* JADX WARNING: Missing block: B:42:0x00d7, code skipped:
            r3 = com.tencent.mm.pluginsdk.ui.tools.f.o(r7.vuL[r1], r7.url, r7.eTi, r7.eTj);
            r0 = (android.graphics.Bitmap) r7.vuC.vuw.get(r3);
     */
        /* JADX WARNING: Missing block: B:43:0x00ef, code skipped:
            if (r0 != null) goto L_0x00f9;
     */
        /* JADX WARNING: Missing block: B:44:0x00f1, code skipped:
            r0 = ajZ(r7.vuL[r1]);
     */
        /* JADX WARNING: Missing block: B:45:0x00f9, code skipped:
            if (r0 == null) goto L_0x0104;
     */
        /* JADX WARNING: Missing block: B:46:0x00fb, code skipped:
            r7.vuC.vuw.put(r3, (java.lang.Object) r0);
     */
        /* JADX WARNING: Missing block: B:47:0x0104, code skipped:
            r1 = r1 + 1;
     */
        /* JADX WARNING: Missing block: B:51:0x010a, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(79934);
     */
        /* JADX WARNING: Missing block: B:65:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.i(79934);
            if (f.this.vur) {
                ab.w("MicroMsg.ImageEngine", "on load image jog, isQuit, return");
                AppMethodBeat.o(79934);
                return;
            }
            synchronized (f.this.eMl) {
                try {
                    if (f.this.vuu.get(this.vuM) == null) {
                        ab.w("MicroMsg.ImageEngine", "check before decode, no match wait to render view, renderKey is %s, return", this.vuM);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(79934);
                }
            }
        }
    }

    class d implements Runnable {
        ImageView cAw;
        Bitmap mQQ;

        private d() {
        }

        /* synthetic */ d(f fVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(79940);
            if (this.cAw != null) {
                if (this.mQQ == null || !this.mQQ.isRecycled()) {
                    c.b(this.cAw, this.mQQ);
                } else {
                    c.k(this.cAw);
                }
            }
            this.cAw = null;
            this.mQQ = null;
            f.this.vuy.cy(this);
            AppMethodBeat.o(79940);
        }
    }

    public static class c extends Drawable {
        static final Paint vuN = new Paint(6);
        final Rect Hx = new Rect();
        WeakReference<Bitmap> vuO = new WeakReference(null);
        private boolean vuP = false;
        private boolean vuQ = false;

        public c() {
            AppMethodBeat.i(79935);
            AppMethodBeat.o(79935);
        }

        static {
            AppMethodBeat.i(79939);
            AppMethodBeat.o(79939);
        }

        public static void k(ImageView imageView) {
            AppMethodBeat.i(79937);
            b(imageView, null);
            AppMethodBeat.o(79937);
        }

        public final void setAlpha(int i) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }

        public final int getOpacity() {
            return 0;
        }

        public static void b(ImageView imageView, Bitmap bitmap) {
            c cVar;
            boolean z = true;
            AppMethodBeat.i(79936);
            if (imageView.getDrawable() instanceof c) {
                cVar = (c) imageView.getDrawable();
            } else {
                cVar = new c();
            }
            cVar.vuO = new WeakReference(bitmap);
            cVar.vuP = imageView.getScaleType() == ScaleType.FIT_XY;
            if (imageView.getScaleType() != ScaleType.CENTER_CROP) {
                z = false;
            }
            cVar.vuQ = z;
            imageView.setImageDrawable(cVar);
            imageView.postInvalidate();
            AppMethodBeat.o(79936);
        }

        public final void draw(Canvas canvas) {
            Object obj;
            AppMethodBeat.i(79938);
            Bitmap bitmap = (Bitmap) this.vuO.get();
            if (bitmap == null || bitmap.isRecycled()) {
                obj = null;
            } else {
                copyBounds(this.Hx);
                canvas.drawBitmap(bitmap, null, this.Hx, vuN);
                obj = 1;
            }
            if (obj != null) {
                AppMethodBeat.o(79938);
            } else {
                AppMethodBeat.o(79938);
            }
        }
    }

    abstract class a<T> {
        private ak handler;
        final int vuH = Math.max(1, 16);
        LinkedList<T> vuI = new LinkedList();

        public abstract T dlr();

        public a(Looper looper) {
            this.handler = new ak(looper, f.this) {
                public final void handleMessage(Message message) {
                    AppMethodBeat.i(79932);
                    a aVar = a.this;
                    Object obj = message.obj;
                    if (obj != null && aVar.vuI.size() < aVar.vuH) {
                        aVar.vuI.add(obj);
                    }
                    AppMethodBeat.o(79932);
                }
            };
        }

        public final T dls() {
            if (this.vuI.isEmpty()) {
                return dlr();
            }
            return this.vuI.removeFirst();
        }

        public final void cy(T t) {
            this.handler.sendMessage(this.handler.obtainMessage(1, t));
        }
    }

    public f(int i) {
        AppMethodBeat.i(79941);
        this.vus.start();
        this.vut = new ak(this.vus.getLooper());
        this.fbD = new ak(Looper.getMainLooper());
        this.vuy = new a<d>(this.vus.getLooper()) {
            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ Object dlr() {
                AppMethodBeat.i(79926);
                d dVar = new d(f.this, (byte) 0);
                AppMethodBeat.o(79926);
                return dVar;
            }
        };
        this.vuz = new a<b>(Looper.getMainLooper()) {
            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ Object dlr() {
                AppMethodBeat.i(79927);
                b bVar = new b(f.this, (byte) 0);
                AppMethodBeat.o(79927);
                return bVar;
            }
        };
        this.vux = new SparseArray();
        this.vuw = new com.tencent.mm.memory.a.b(i, new com.tencent.mm.a.f.b<String, Bitmap>() {
            public final /* synthetic */ void c(Object obj, Object obj2, Object obj3) {
                AppMethodBeat.i(79928);
                Bitmap bitmap = (Bitmap) obj2;
                if (bitmap != null) {
                    ab.i("MicroMsg.ImageEngine", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
                AppMethodBeat.o(79928);
            }
        }, getClass());
        x.b(this.vuB);
        AppMethodBeat.o(79941);
    }

    public final void destroy() {
        AppMethodBeat.i(79942);
        ab.d("MicroMsg.ImageEngine", "do destroy");
        this.vur = true;
        this.vus.quit();
        x.c(this.vuB);
        final SparseArray sparseArray = this.vux;
        final com.tencent.mm.memory.a.b bVar = this.vuw;
        this.vux = new SparseArray();
        this.vuw = new com.tencent.mm.memory.a.b(1, getClass());
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(79929);
                ab.i("MicroMsg.ImageEngine", "begin do recycled");
                for (int i = 0; i < sparseArray.size(); i++) {
                    Bitmap bitmap = (Bitmap) sparseArray.valueAt(i);
                    if (bitmap != null) {
                        ab.d("MicroMsg.ImageEngine", "recycled def bmp %s", bitmap.toString());
                        bitmap.recycle();
                    }
                }
                sparseArray.clear();
                ab.i("MicroMsg.ImageEngine", "clear drawable cache");
                bVar.clear();
                ab.i("MicroMsg.ImageEngine", "end do recycled");
                AppMethodBeat.o(79929);
            }
        }, "ImageEngine_destroy_" + System.currentTimeMillis());
        AppMethodBeat.o(79942);
    }

    /* Access modifiers changed, original: protected */
    public v h(String str, String str2, int i, int i2) {
        return null;
    }

    private void b(ImageView imageView, int i) {
        AppMethodBeat.i(79943);
        if (i == 0) {
            c.k(imageView);
            AppMethodBeat.o(79943);
            return;
        }
        Bitmap bitmap = (Bitmap) this.vux.get(i);
        if (bitmap == null) {
            bitmap = com.tencent.mm.compatible.g.a.decodeResource(imageView.getResources(), i);
            this.vux.put(i, bitmap);
        }
        c.b(imageView, bitmap);
        AppMethodBeat.o(79943);
    }

    static String o(String str, String str2, int i, int i2) {
        AppMethodBeat.i(79944);
        String str3 = bo.bc(str, BuildConfig.COMMAND) + "_" + bo.bc(str2, BuildConfig.COMMAND) + "_" + i + "_" + i2;
        AppMethodBeat.o(79944);
        return str3;
    }

    public final void a(ImageView imageView, String[] strArr, String str, int i, int i2, int i3) {
        AppMethodBeat.i(79945);
        if (!this.vuA) {
            AppMethodBeat.o(79945);
        } else if (this.vur) {
            ab.w("MicroMsg.ImageEngine", "on attach, isQuit, return");
            AppMethodBeat.o(79945);
        } else if (imageView == null) {
            ab.w("MicroMsg.ImageEngine", "attach from file path fail, imageview is null");
            AppMethodBeat.o(79945);
        } else if ((strArr == null || strArr.length <= 0) && bo.isNullOrNil(str)) {
            ab.w("MicroMsg.ImageEngine", "attach from file path fail, path and url are null or empty");
            b(imageView, i);
            AppMethodBeat.o(79945);
        } else {
            int i4;
            int i5 = (strArr == null || strArr.length <= 0) ? null : strArr[0];
            String o = o(i5, str, i2, i3);
            synchronized (this.eMl) {
                try {
                    String str2 = (String) this.vuv.get(imageView);
                    if (str2 != null) {
                        this.vuu.remove(str2);
                    }
                    this.vuv.put(imageView, o);
                } finally {
                    while (true) {
                    }
                    i4 = i5;
                    AppMethodBeat.o(79945);
                }
            }
            i5 = (Bitmap) this.vuw.get(o);
            if (i5 == null || i5.isRecycled()) {
                Object obj;
                ab.v("MicroMsg.ImageEngine", "get first render bmp fail, key[%s]", o);
                if (strArr != null && strArr.length > 1) {
                    i5 = 1;
                    while (true) {
                        i4 = i5;
                        if (i4 >= strArr.length) {
                            break;
                        }
                        Bitmap bitmap = (Bitmap) this.vuw.get(o(strArr[i4], str, i2, i3));
                        String str3 = "MicroMsg.ImageEngine";
                        String str4 = "get next render bmp, key[%s], result[%B]";
                        Object[] objArr = new Object[2];
                        objArr[0] = o;
                        objArr[1] = Boolean.valueOf(bitmap != null);
                        ab.v(str3, str4, objArr);
                        if (bitmap != null) {
                            c.b(imageView, bitmap);
                            obj = 1;
                            break;
                        }
                        i5 = i4 + 1;
                    }
                }
                obj = null;
                if (obj == null) {
                    ab.v("MicroMsg.ImageEngine", "use default res to render");
                    b(imageView, i);
                }
                synchronized (this.eMl) {
                    try {
                        this.vuu.put(o, imageView);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(79945);
                    }
                }
                b bVar = (b) this.vuz.dls();
                bVar.vuL = strArr;
                bVar.url = str;
                bVar.vuM = o;
                bVar.eTi = i2;
                bVar.eTj = i3;
                this.vut.postAtFrontOfQueueV2(bVar);
                return;
            }
            c.b(imageView, i5);
        }
    }
}
