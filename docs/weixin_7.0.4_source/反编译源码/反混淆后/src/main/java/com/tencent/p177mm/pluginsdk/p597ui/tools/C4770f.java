package com.tencent.p177mm.pluginsdk.p597ui.tools;

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
import com.tencent.p177mm.compatible.p222g.C1434a;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.p178a.C1177f.C1175b;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.platformtools.C9791v;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.f */
public class C4770f {
    public byte[] eMl = new byte[0];
    C7306ak fbD;
    private boolean vuA = true;
    private C18765a vuB = new C47775();
    volatile boolean vur = false;
    private HandlerThread vus = C7305d.anM("ImageEngine_handlerThread" + System.currentTimeMillis());
    private C7306ak vut;
    public HashMap<String, ImageView> vuu = new HashMap();
    public HashMap<ImageView, String> vuv = new HashMap();
    C26399b<Bitmap> vuw;
    private SparseArray<Bitmap> vux;
    C4779a<C4773d> vuy;
    C4779a<C4772b> vuz;

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.f$b */
    class C4772b implements Runnable {
        private int eTi;
        private int eTj;
        private String url;
        private String[] vuL;
        private String vuM;

        private C4772b() {
        }

        /* synthetic */ C4772b(C4770f c4770f, byte b) {
            this();
        }

        private Bitmap ajZ(String str) {
            AppMethodBeat.m2504i(79933);
            if (str == null) {
                AppMethodBeat.m2505o(79933);
                return null;
            }
            Bitmap vv;
            if (this.eTj <= 0 || this.eTi <= 0) {
                vv = C18764x.m29333vv(str);
            } else {
                String str2 = str + "_" + this.eTi + "_" + this.eTj;
                vv = C18764x.m29332q(str2, this.eTi, this.eTj);
                if (vv == null) {
                    int bJ = ExifHelper.m7368bJ(str);
                    if (90 == bJ || 270 == bJ) {
                        vv = C5056d.m7659d(str, this.eTi, this.eTj, true);
                    } else {
                        vv = C5056d.m7659d(str, this.eTj, this.eTi, true);
                    }
                    if (vv != null) {
                        vv = C5056d.m7648b(vv, (float) bJ);
                        try {
                            C5056d.m7625a(vv, 100, CompressFormat.PNG, str2, false);
                        } catch (IOException e) {
                            C4990ab.printErrStackTrace("MicroMsg.ImageEngine", e, "", new Object[0]);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(79933);
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
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r7.url) != false) goto L_0x0089;
     */
        /* JADX WARNING: Missing block: B:24:0x006c, code skipped:
            r0 = com.tencent.p177mm.platformtools.C18764x.m29325a(r7.vuC.mo9924h(r7.vuM, r7.url, r7.eTi, r7.eTj));
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
            r1 = (com.tencent.p177mm.pluginsdk.p597ui.tools.C4770f.C4773d) r7.vuC.vuy.dls();
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
            r7.vuC.vuz.mo9934cy(r7);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(79934);
     */
        /* JADX WARNING: Missing block: B:42:0x00d7, code skipped:
            r3 = com.tencent.p177mm.pluginsdk.p597ui.tools.C4770f.m7125o(r7.vuL[r1], r7.url, r7.eTi, r7.eTj);
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
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(79934);
     */
        /* JADX WARNING: Missing block: B:65:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.m2504i(79934);
            if (C4770f.this.vur) {
                C4990ab.m7420w("MicroMsg.ImageEngine", "on load image jog, isQuit, return");
                AppMethodBeat.m2505o(79934);
                return;
            }
            synchronized (C4770f.this.eMl) {
                try {
                    if (C4770f.this.vuu.get(this.vuM) == null) {
                        C4990ab.m7421w("MicroMsg.ImageEngine", "check before decode, no match wait to render view, renderKey is %s, return", this.vuM);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(79934);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.f$d */
    class C4773d implements Runnable {
        ImageView cAw;
        Bitmap mQQ;

        private C4773d() {
        }

        /* synthetic */ C4773d(C4770f c4770f, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(79940);
            if (this.cAw != null) {
                if (this.mQQ == null || !this.mQQ.isRecycled()) {
                    C4774c.m7133b(this.cAw, this.mQQ);
                } else {
                    C4774c.m7134k(this.cAw);
                }
            }
            this.cAw = null;
            this.mQQ = null;
            C4770f.this.vuy.mo9934cy(this);
            AppMethodBeat.m2505o(79940);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.f$c */
    public static class C4774c extends Drawable {
        static final Paint vuN = new Paint(6);
        /* renamed from: Hx */
        final Rect f1291Hx = new Rect();
        WeakReference<Bitmap> vuO = new WeakReference(null);
        private boolean vuP = false;
        private boolean vuQ = false;

        public C4774c() {
            AppMethodBeat.m2504i(79935);
            AppMethodBeat.m2505o(79935);
        }

        static {
            AppMethodBeat.m2504i(79939);
            AppMethodBeat.m2505o(79939);
        }

        /* renamed from: k */
        public static void m7134k(ImageView imageView) {
            AppMethodBeat.m2504i(79937);
            C4774c.m7133b(imageView, null);
            AppMethodBeat.m2505o(79937);
        }

        public final void setAlpha(int i) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }

        public final int getOpacity() {
            return 0;
        }

        /* renamed from: b */
        public static void m7133b(ImageView imageView, Bitmap bitmap) {
            C4774c c4774c;
            boolean z = true;
            AppMethodBeat.m2504i(79936);
            if (imageView.getDrawable() instanceof C4774c) {
                c4774c = (C4774c) imageView.getDrawable();
            } else {
                c4774c = new C4774c();
            }
            c4774c.vuO = new WeakReference(bitmap);
            c4774c.vuP = imageView.getScaleType() == ScaleType.FIT_XY;
            if (imageView.getScaleType() != ScaleType.CENTER_CROP) {
                z = false;
            }
            c4774c.vuQ = z;
            imageView.setImageDrawable(c4774c);
            imageView.postInvalidate();
            AppMethodBeat.m2505o(79936);
        }

        public final void draw(Canvas canvas) {
            Object obj;
            AppMethodBeat.m2504i(79938);
            Bitmap bitmap = (Bitmap) this.vuO.get();
            if (bitmap == null || bitmap.isRecycled()) {
                obj = null;
            } else {
                copyBounds(this.f1291Hx);
                canvas.drawBitmap(bitmap, null, this.f1291Hx, vuN);
                obj = 1;
            }
            if (obj != null) {
                AppMethodBeat.m2505o(79938);
            } else {
                AppMethodBeat.m2505o(79938);
            }
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.f$3 */
    class C47753 implements C1175b<String, Bitmap> {
        C47753() {
        }

        /* renamed from: c */
        public final /* synthetic */ void mo4401c(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.m2504i(79928);
            Bitmap bitmap = (Bitmap) obj2;
            if (bitmap != null) {
                C4990ab.m7417i("MicroMsg.ImageEngine", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            }
            AppMethodBeat.m2505o(79928);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.f$5 */
    class C47775 implements C18765a {
        C47775() {
        }

        /* renamed from: m */
        public final void mo8136m(String str, final Bitmap bitmap) {
            boolean z = false;
            AppMethodBeat.m2504i(79931);
            String str2 = "MicroMsg.ImageEngine";
            String str3 = "on get picture finish, notifyKey[%s], bitmap is null[%B]";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (bitmap == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            C4990ab.m7419v(str2, str3, objArr);
            if (bitmap == null) {
                AppMethodBeat.m2505o(79931);
                return;
            }
            C4770f.this.vuw.put(str, (Object) bitmap);
            final ImageView imageView = (ImageView) C4770f.this.vuu.get(str);
            if (imageView != null) {
                C4770f.this.vuv.remove(imageView);
                C4770f.this.fbD.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(79930);
                        C4774c.m7133b(imageView, bitmap);
                        AppMethodBeat.m2505o(79930);
                    }
                });
            }
            C4770f.this.vuu.remove(str);
            AppMethodBeat.m2505o(79931);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.f$a */
    abstract class C4779a<T> {
        private C7306ak handler;
        final int vuH = Math.max(1, 16);
        LinkedList<T> vuI = new LinkedList();

        public abstract T dlr();

        public C4779a(Looper looper) {
            this.handler = new C7306ak(looper, C4770f.this) {
                public final void handleMessage(Message message) {
                    AppMethodBeat.m2504i(79932);
                    C4779a c4779a = C4779a.this;
                    Object obj = message.obj;
                    if (obj != null && c4779a.vuI.size() < c4779a.vuH) {
                        c4779a.vuI.add(obj);
                    }
                    AppMethodBeat.m2505o(79932);
                }
            };
        }

        public final T dls() {
            if (this.vuI.isEmpty()) {
                return dlr();
            }
            return this.vuI.removeFirst();
        }

        /* renamed from: cy */
        public final void mo9934cy(T t) {
            this.handler.sendMessage(this.handler.obtainMessage(1, t));
        }
    }

    public C4770f(int i) {
        AppMethodBeat.m2504i(79941);
        this.vus.start();
        this.vut = new C7306ak(this.vus.getLooper());
        this.fbD = new C7306ak(Looper.getMainLooper());
        this.vuy = new C4779a<C4773d>(this.vus.getLooper()) {
            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ Object dlr() {
                AppMethodBeat.m2504i(79926);
                C4773d c4773d = new C4773d(C4770f.this, (byte) 0);
                AppMethodBeat.m2505o(79926);
                return c4773d;
            }
        };
        this.vuz = new C4779a<C4772b>(Looper.getMainLooper()) {
            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ Object dlr() {
                AppMethodBeat.m2504i(79927);
                C4772b c4772b = new C4772b(C4770f.this, (byte) 0);
                AppMethodBeat.m2505o(79927);
                return c4772b;
            }
        };
        this.vux = new SparseArray();
        this.vuw = new C26399b(i, new C47753(), getClass());
        C18764x.m29328b(this.vuB);
        AppMethodBeat.m2505o(79941);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(79942);
        C4990ab.m7410d("MicroMsg.ImageEngine", "do destroy");
        this.vur = true;
        this.vus.quit();
        C18764x.m29330c(this.vuB);
        final SparseArray sparseArray = this.vux;
        final C26399b c26399b = this.vuw;
        this.vux = new SparseArray();
        this.vuw = new C26399b(1, getClass());
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(79929);
                C4990ab.m7416i("MicroMsg.ImageEngine", "begin do recycled");
                for (int i = 0; i < sparseArray.size(); i++) {
                    Bitmap bitmap = (Bitmap) sparseArray.valueAt(i);
                    if (bitmap != null) {
                        C4990ab.m7411d("MicroMsg.ImageEngine", "recycled def bmp %s", bitmap.toString());
                        bitmap.recycle();
                    }
                }
                sparseArray.clear();
                C4990ab.m7416i("MicroMsg.ImageEngine", "clear drawable cache");
                c26399b.clear();
                C4990ab.m7416i("MicroMsg.ImageEngine", "end do recycled");
                AppMethodBeat.m2505o(79929);
            }
        }, "ImageEngine_destroy_" + System.currentTimeMillis());
        AppMethodBeat.m2505o(79942);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: h */
    public C9791v mo9924h(String str, String str2, int i, int i2) {
        return null;
    }

    /* renamed from: b */
    private void m7124b(ImageView imageView, int i) {
        AppMethodBeat.m2504i(79943);
        if (i == 0) {
            C4774c.m7134k(imageView);
            AppMethodBeat.m2505o(79943);
            return;
        }
        Bitmap bitmap = (Bitmap) this.vux.get(i);
        if (bitmap == null) {
            bitmap = C1434a.decodeResource(imageView.getResources(), i);
            this.vux.put(i, bitmap);
        }
        C4774c.m7133b(imageView, bitmap);
        AppMethodBeat.m2505o(79943);
    }

    /* renamed from: o */
    static String m7125o(String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(79944);
        String str3 = C5046bo.m7532bc(str, BuildConfig.COMMAND) + "_" + C5046bo.m7532bc(str2, BuildConfig.COMMAND) + "_" + i + "_" + i2;
        AppMethodBeat.m2505o(79944);
        return str3;
    }

    /* renamed from: a */
    public final void mo9922a(ImageView imageView, String[] strArr, String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(79945);
        if (!this.vuA) {
            AppMethodBeat.m2505o(79945);
        } else if (this.vur) {
            C4990ab.m7420w("MicroMsg.ImageEngine", "on attach, isQuit, return");
            AppMethodBeat.m2505o(79945);
        } else if (imageView == null) {
            C4990ab.m7420w("MicroMsg.ImageEngine", "attach from file path fail, imageview is null");
            AppMethodBeat.m2505o(79945);
        } else if ((strArr == null || strArr.length <= 0) && C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.ImageEngine", "attach from file path fail, path and url are null or empty");
            m7124b(imageView, i);
            AppMethodBeat.m2505o(79945);
        } else {
            int i4;
            int i5 = (strArr == null || strArr.length <= 0) ? null : strArr[0];
            String o = C4770f.m7125o(i5, str, i2, i3);
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
                    AppMethodBeat.m2505o(79945);
                }
            }
            i5 = (Bitmap) this.vuw.get(o);
            if (i5 == null || i5.isRecycled()) {
                Object obj;
                C4990ab.m7419v("MicroMsg.ImageEngine", "get first render bmp fail, key[%s]", o);
                if (strArr != null && strArr.length > 1) {
                    i5 = 1;
                    while (true) {
                        i4 = i5;
                        if (i4 >= strArr.length) {
                            break;
                        }
                        Bitmap bitmap = (Bitmap) this.vuw.get(C4770f.m7125o(strArr[i4], str, i2, i3));
                        String str3 = "MicroMsg.ImageEngine";
                        String str4 = "get next render bmp, key[%s], result[%B]";
                        Object[] objArr = new Object[2];
                        objArr[0] = o;
                        objArr[1] = Boolean.valueOf(bitmap != null);
                        C4990ab.m7419v(str3, str4, objArr);
                        if (bitmap != null) {
                            C4774c.m7133b(imageView, bitmap);
                            obj = 1;
                            break;
                        }
                        i5 = i4 + 1;
                    }
                }
                obj = null;
                if (obj == null) {
                    C4990ab.m7418v("MicroMsg.ImageEngine", "use default res to render");
                    m7124b(imageView, i);
                }
                synchronized (this.eMl) {
                    try {
                        this.vuu.put(o, imageView);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(79945);
                    }
                }
                C4772b c4772b = (C4772b) this.vuz.dls();
                c4772b.vuL = strArr;
                c4772b.url = str;
                c4772b.vuM = o;
                c4772b.eTi = i2;
                c4772b.eTj = i3;
                this.vut.postAtFrontOfQueueV2(c4772b);
                return;
            }
            C4774c.m7133b(imageView, i5);
        }
    }
}
