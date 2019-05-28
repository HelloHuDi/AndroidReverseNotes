package com.tencent.p177mm.p190at;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.modelsfs.FileOp;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1170b;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C1177f.C1175b;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p187al.C31259b;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p190at.C32290n.C9030a;
import com.tencent.p177mm.p190at.C32290n.C9030a.C9031a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.plugin.emoji.p725b.C27730c;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import com.tencent.p177mm.sdk.platformtools.C35985ad;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.MMJpegOptim;
import com.tencent.p177mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.p177mm.storage.C40620aa;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.baseutils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.at.g */
public final class C45160g extends C7296k {
    public static int fEg = 0;
    public static long fEt = 0;
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS ImgInfo ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT )", "CREATE TABLE IF NOT EXISTS ImgInfo2 ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid INT, status INT, nettimes INT, reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text, hashdthumb int DEFAULT 0, iscomplete INT DEFAULT 1, origImgMD5 TEXT, compressType INT DEFAULT 0, midImgPath TEXT, forwardType INT DEFAULT 0, hevcPath TEXT )", "CREATE INDEX IF NOT EXISTS  serverImgInfoIndex ON ImgInfo2 ( msgSvrId ) ", "CREATE INDEX IF NOT EXISTS  serverImgInfoHdIndex ON ImgInfo2 ( reserved1 ) ", "CREATE INDEX IF NOT EXISTS  msgLocalIdIndex ON ImgInfo2 ( msglocalid ) ", "insert into imginfo2 (id,msgSvrId , offset , totalLen , bigImgPath , thumbImgPath) select id, msgSvrId, offset ,totallen , bigimgpath , thumbimgpath from imginfo; ", "delete from ImgInfo ; ", "CREATE INDEX IF NOT EXISTS iscomplete_index ON ImgInfo2 ( iscomplete ) ", "CREATE INDEX IF NOT EXISTS origImgMD5_index ON ImgInfo2 ( origImgMD5 ) "};
    C1177f<String, Bitmap> fEh = new C26399b(40, new C90181(), getClass());
    private C1177f<String, String> fEi = new C7598c(40);
    private List<C1284b> fEj = new ArrayList();
    private Map<Integer, WeakReference<ImageView>> fEk = new HashMap();
    private Map<Integer, WeakReference<ImageView>> fEl = new HashMap();
    private Map<Integer, WeakReference<View>> fEm = new HashMap();
    private Set<Integer> fEn = new HashSet();
    private Map<String, String> fEo = new HashMap();
    private final AtomicLong fEp = new AtomicLong(1);
    private LayoutParams fEq = new LayoutParams(-2, -2);
    private SoftReference<ColorDrawable> fEr;
    public int fEs = 150;
    private C7306ak fbD = new C7306ak(Looper.getMainLooper());
    public C7480h fni = null;

    /* renamed from: com.tencent.mm.at.g$b */
    static class C1284b {
        int fEA;
        int fEB;
        int fEz;
        String url;

        C1284b(int i, String str, int i2, int i3) {
            this.fEz = i;
            this.url = str;
            this.fEA = i2;
            this.fEB = i3;
        }
    }

    /* renamed from: com.tencent.mm.at.g$1 */
    class C90181 implements C1175b<String, Bitmap> {
        C90181() {
        }

        /* renamed from: c */
        public final /* synthetic */ void mo4401c(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.m2504i(78202);
            String str = (String) obj;
            Bitmap bitmap = (Bitmap) obj2;
            if (!(bitmap == null || bitmap.isRecycled())) {
                C4990ab.m7417i("MicroMsg.ImgInfoStorage", "[preRemoveCallback] key:%s remove bitmap without recycle! :%s size:%s", str, bitmap.toString(), Integer.valueOf(bitmap.getByteCount()));
            }
            AppMethodBeat.m2505o(78202);
        }
    }

    /* renamed from: com.tencent.mm.at.g$2 */
    class C258232 implements Runnable {
        final /* synthetic */ float ckb;
        final /* synthetic */ String fEv;
        final /* synthetic */ boolean fEw = true;
        final /* synthetic */ int fEx = C25738R.drawable.b0p;

        /* renamed from: com.tencent.mm.at.g$2$1 */
        class C258241 implements Runnable {
            C258241() {
            }

            public final void run() {
                AppMethodBeat.m2504i(78203);
                C45160g.m83078a(C45160g.this, C258232.this.fEv);
                AppMethodBeat.m2505o(78203);
            }
        }

        C258232(String str, float f, boolean z, int i) {
            this.fEv = str;
            this.ckb = f;
        }

        public final void run() {
            AppMethodBeat.m2504i(78204);
            C45160g.this.mo73088a(this.fEv, true, this.ckb, true, false, this.fEw, this.fEx);
            C45160g.this.fbD.post(new C258241());
            AppMethodBeat.m2505o(78204);
        }

        public final String toString() {
            AppMethodBeat.m2504i(78205);
            String str = super.toString() + "|loadImginBackground";
            AppMethodBeat.m2505o(78205);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.at.g$a */
    public static class C32285a extends BitmapDrawable {
        /* renamed from: a */
        public static void m52718a(Bitmap bitmap, ImageView imageView) {
            AppMethodBeat.m2504i(78206);
            if (imageView == null || imageView.getResources() == null) {
                AppMethodBeat.m2505o(78206);
                return;
            }
            C32285a c32285a = new C32285a(imageView.getResources(), bitmap);
            if (imageView.getLayerType() == 1) {
                imageView.destroyDrawingCache();
                imageView.setLayerType(0, null);
            }
            imageView.setImageDrawable(c32285a);
            AppMethodBeat.m2505o(78206);
        }

        private C32285a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        public final void draw(Canvas canvas) {
            AppMethodBeat.m2504i(78207);
            if (getBitmap() == null || getBitmap().isRecycled()) {
                if (getBitmap() != null) {
                    C4990ab.m7413e("MicroMsg.ImgInfoStorage", "Cannot draw recycled bitmaps:%s", getBitmap().toString());
                }
                AppMethodBeat.m2505o(78207);
                return;
            }
            super.draw(canvas);
            AppMethodBeat.m2505o(78207);
        }
    }

    public C45160g(C7480h c7480h) {
        AppMethodBeat.m2504i(78208);
        C45160g.m83079a(c7480h);
        this.fni = c7480h;
        agT();
        AppMethodBeat.m2505o(78208);
    }

    public final void agT() {
        AppMethodBeat.m2504i(78209);
        Cursor a = this.fni.mo10104a("SELECT max(id) FROM ImgInfo2", null, 2);
        if (a.moveToFirst()) {
            long j = a.getLong(0) + 1;
            synchronized (this.fEp) {
                try {
                    if (j > this.fEp.get()) {
                        this.fEp.set(j);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(78209);
                    }
                }
            }
        }
        a.close();
        C4990ab.m7416i("MicroMsg.ImgInfoStorage", "loading new img id: " + this.fEp.get());
        AppMethodBeat.m2505o(78209);
    }

    public final long agU() {
        long andIncrement;
        AppMethodBeat.m2504i(78210);
        synchronized (this.fEp) {
            try {
                andIncrement = this.fEp.getAndIncrement();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(78210);
            }
        }
        return andIncrement;
    }

    /* renamed from: a */
    private static void m83079a(C7480h c7480h) {
        AppMethodBeat.m2504i(78211);
        Cursor a = c7480h.mo10104a("PRAGMA table_info(ImgInfo2)", null, 2);
        int columnIndex = a.getColumnIndex("name");
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj6 = null;
        Object obj7 = null;
        while (a.moveToNext()) {
            if (columnIndex >= 0) {
                Object obj8;
                String string = a.getString(columnIndex);
                if ("hashdthumb".equals(string)) {
                    obj7 = 1;
                }
                if ("iscomplete".equals(string)) {
                    obj6 = 1;
                }
                if ("origImgMD5".equals(string)) {
                    obj5 = 1;
                }
                if ("compressType".equals(string)) {
                    obj4 = 1;
                }
                if ("midImgPath".equals(string)) {
                    obj3 = 1;
                }
                if ("forwardType".equals(string)) {
                    obj8 = 1;
                } else {
                    obj8 = obj2;
                }
                if ("hevcPath".equals(string)) {
                    obj = 1;
                }
                obj2 = obj8;
            }
        }
        a.close();
        long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
        if (obj7 == null) {
            c7480h.mo10108hY("ImgInfo2", "Alter table ImgInfo2 add hashdthumb INT DEFAULT 0");
        }
        if (obj6 == null) {
            c7480h.mo10108hY("ImgInfo2", "Alter table ImgInfo2 add iscomplete INT DEFAULT 1");
        }
        if (obj5 == null) {
            c7480h.mo10108hY("ImgInfo2", "Alter table ImgInfo2 add origImgMD5 TEXT");
        }
        if (obj4 == null) {
            c7480h.mo10108hY("ImgInfo2", "Alter table ImgInfo2 add compressType INT DEFAULT 0");
        }
        if (obj3 == null) {
            c7480h.mo10108hY("ImgInfo2", "Alter table ImgInfo2 add midImgPath TEXT");
        }
        if (obj2 == null) {
            c7480h.mo10108hY("ImgInfo2", "Alter table ImgInfo2 add forwardType INT DEFAULT 0");
        }
        if (obj == null) {
            c7480h.mo10108hY("ImgInfo2", "Alter table ImgInfo2 add hevcPath TEXT");
        }
        if (iV > 0) {
            C1720g.m3536RP().eJN.mo15640mB(iV);
        }
        AppMethodBeat.m2505o(78211);
    }

    /* renamed from: b */
    public final String mo73106b(String str, String str2, String str3, boolean z) {
        AppMethodBeat.m2504i(78212);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(78212);
            return null;
        }
        String str4;
        String str5;
        String str6 = "";
        if (str.startsWith("SERVERID://")) {
            try {
                str4 = mo73112fI(Long.valueOf(str.substring(11)).longValue()).fDz;
            } catch (NumberFormatException e) {
                C4990ab.m7412e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                AppMethodBeat.m2505o(78212);
                return null;
            }
        }
        str4 = str6;
        if (str.startsWith("THUMBNAIL_DIRPATH://")) {
            str = str.substring(23);
            str5 = "th_";
        } else {
            str5 = str2;
        }
        str6 = C43217c.m76863XW();
        String XX = C43217c.m76864XX();
        if (C5046bo.isNullOrNil(str4)) {
            str4 = str;
        }
        str6 = C15428j.m23710b(str6, XX, str5, str4, str3, z);
        AppMethodBeat.m2505o(78212);
        return str6;
    }

    /* renamed from: q */
    public final String mo73118q(String str, String str2, String str3) {
        AppMethodBeat.m2504i(78213);
        String b = mo73106b(str, str2, str3, true);
        AppMethodBeat.m2505o(78213);
        return b;
    }

    public final String getFullPath(String str) {
        AppMethodBeat.m2504i(78214);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(78214);
            return null;
        }
        String str2 = "";
        if (str.startsWith("SERVERID://")) {
            try {
                str2 = mo73112fI(Long.valueOf(str.substring(11)).longValue()).fDz;
            } catch (NumberFormatException e) {
                C4990ab.m7412e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                AppMethodBeat.m2505o(78214);
                return null;
            }
        }
        String XW = C43217c.m76863XW();
        String XX = C43217c.m76864XX();
        String str3 = "th_";
        if (!C5046bo.isNullOrNil(str2)) {
            str = str2;
        }
        str2 = C15428j.m23711g(XW, XX, str3, str, "");
        AppMethodBeat.m2505o(78214);
        return str2;
    }

    /* renamed from: si */
    public static String m83082si(String str) {
        AppMethodBeat.m2504i(78215);
        String concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str));
        AppMethodBeat.m2505o(78215);
        return concat;
    }

    /* renamed from: sj */
    public final String mo73119sj(String str) {
        AppMethodBeat.m2504i(78216);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(78216);
            return null;
        }
        String str2 = "";
        String trim = str.trim();
        if (trim.startsWith("THUMBNAIL://")) {
            try {
                trim = mo73116ly(Integer.valueOf(trim.substring(12)).intValue()).fDB;
            } catch (NumberFormatException e) {
                C4990ab.m7412e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                AppMethodBeat.m2505o(78216);
                return null;
            }
        } else if (trim.startsWith("THUMBNAIL_DIRPATH://")) {
            trim = trim.substring(23);
            str2 = "th_";
        }
        str2 = mo73118q(trim, str2, "");
        AppMethodBeat.m2505o(78216);
        return str2;
    }

    /* renamed from: a */
    public final String mo73094a(byte[] bArr, boolean z, CompressFormat compressFormat) {
        AppMethodBeat.m2504i(78217);
        String a = mo73095a(bArr, z, compressFormat, false);
        AppMethodBeat.m2505o(78217);
        return a;
    }

    /* renamed from: a */
    public final String mo73091a(byte[] bArr, CompressFormat compressFormat) {
        AppMethodBeat.m2504i(78218);
        if (C5046bo.m7540cb(bArr)) {
            C4990ab.m7412e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            AppMethodBeat.m2505o(78218);
            return null;
        }
        String agW = C45160g.agW();
        C4990ab.m7411d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = %s", mo73118q(agW, "th_", ""));
        try {
            C5056d.m7625a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length), 100, compressFormat, mo73118q(agW, "th_", ""), true);
            agW = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
            AppMethodBeat.m2505o(78218);
            return agW;
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e);
            agW = mo73094a(bArr, true, compressFormat);
            AppMethodBeat.m2505o(78218);
            return agW;
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e2);
            agW = mo73094a(bArr, true, compressFormat);
            AppMethodBeat.m2505o(78218);
            return agW;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0169 A:{Catch:{ IOException -> 0x0218, Exception -> 0x02c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01d8 A:{SYNTHETIC, Splitter:B:53:0x01d8} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0218 A:{Splitter:B:11:0x0088, ExcHandler: IOException (e java.io.IOException)} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0201 A:{SYNTHETIC, Splitter:B:63:0x0201} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0169 A:{Catch:{ IOException -> 0x0218, Exception -> 0x02c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01d8 A:{SYNTHETIC, Splitter:B:53:0x01d8} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0218 A:{Splitter:B:11:0x0088, ExcHandler: IOException (e java.io.IOException)} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0286 A:{SYNTHETIC, Splitter:B:95:0x0286} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0218 A:{Splitter:B:11:0x0088, ExcHandler: IOException (e java.io.IOException)} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0201 A:{SYNTHETIC, Splitter:B:63:0x0201} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0169 A:{Catch:{ IOException -> 0x0218, Exception -> 0x02c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01d8 A:{SYNTHETIC, Splitter:B:53:0x01d8} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x020e A:{SYNTHETIC, Splitter:B:69:0x020e} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02a7 A:{SYNTHETIC, Splitter:B:104:0x02a7} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02a7 A:{SYNTHETIC, Splitter:B:104:0x02a7} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0248 A:{SYNTHETIC, Splitter:B:83:0x0248} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:57:0x01ef, code skipped:
            r6 = r5;
     */
    /* JADX WARNING: Missing block: B:75:0x0218, code skipped:
            r4 = e;
     */
    /* JADX WARNING: Missing block: B:76:0x0219, code skipped:
            r5 = r8;
     */
    /* JADX WARNING: Missing block: B:81:0x023a, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7410d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
            com.tencent.p177mm.vfs.C5730e.deleteFile(r14);
     */
    /* JADX WARNING: Missing block: B:84:?, code skipped:
            r5.close();
     */
    /* JADX WARNING: Missing block: B:93:0x0278, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7410d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
            com.tencent.p177mm.vfs.C5730e.deleteFile(r14);
     */
    /* JADX WARNING: Missing block: B:96:?, code skipped:
            r8.close();
     */
    /* JADX WARNING: Missing block: B:116:0x02c2, code skipped:
            r4 = e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final String mo73093a(byte[] bArr, CompressFormat compressFormat, String str, boolean z) {
        String str2;
        OutputStream outputStream;
        OutputStream L;
        C7060h c7060h;
        Object[] objArr;
        String concat;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th2;
        IOException e;
        AppMethodBeat.m2504i(78219);
        if (C5046bo.m7540cb(bArr)) {
            C4990ab.m7412e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            AppMethodBeat.m2505o(78219);
            return null;
        }
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        String agW = C45160g.agW();
        String q = mo73118q(agW, "th_", "");
        str2 = q + ".tmp";
        C4990ab.m7410d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = ".concat(String.valueOf(q)));
        int length = bArr.length;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (720 > i2 || 576.0f > ((float) i3)) {
            i = i2;
        } else {
            i = 720;
            i3 = (i3 * 720) / i2;
        }
        outputStream = null;
        try {
            L = C5730e.m8617L(str2, false);
            try {
                Bitmap createScaledBitmap;
                Bitmap createBitmap;
                L.write(bArr);
                L.flush();
                Bitmap decodeByteArray = C5056d.decodeByteArray(bArr, i, i3);
                if (i != decodeByteArray.getWidth()) {
                    createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, i, i3, true);
                } else {
                    createScaledBitmap = decodeByteArray;
                }
                if (((float) createScaledBitmap.getHeight()) > ((float) createScaledBitmap.getWidth()) * 0.8f) {
                    createBitmap = Bitmap.createBitmap(createScaledBitmap, 0, 0, createScaledBitmap.getWidth(), (int) (((float) createScaledBitmap.getWidth()) * 0.8f));
                } else {
                    createBitmap = Bitmap.createBitmap(createScaledBitmap, 0, 0, (int) (((float) createScaledBitmap.getHeight()) / 0.8f), createScaledBitmap.getHeight());
                }
                int length2 = bArr.length;
                if (createBitmap != null) {
                    i3 = 70;
                    ByteArrayOutputStream byteArrayOutputStream2;
                    try {
                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            createBitmap.compress(compressFormat, 70, byteArrayOutputStream2);
                            length2 = byteArrayOutputStream2.toByteArray().length;
                            i2 = 70;
                            while (byteArrayOutputStream2.toByteArray().length > 262144 && i2 >= 15) {
                                try {
                                    byteArrayOutputStream2.reset();
                                    i2 -= 5;
                                    createBitmap.compress(compressFormat, i2, byteArrayOutputStream2);
                                    length2 = byteArrayOutputStream2.toByteArray().length;
                                } catch (Exception e2) {
                                    i3 = i2;
                                    try {
                                        C4990ab.m7412e("MicroMsg.ImgInfoStorage", "compress bitmap failed.");
                                        if (byteArrayOutputStream2 != null) {
                                            byteArrayOutputStream2.close();
                                        }
                                        C5056d.m7625a(createBitmap, i3, compressFormat, q, true);
                                        C4990ab.m7411d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d", str2, q, Integer.valueOf(i3));
                                        c7060h = C7060h.pYm;
                                        objArr = new Object[10];
                                        objArr[0] = C18178q.encode(C5046bo.nullAsNil(str), "UTF-8");
                                        if (z) {
                                        }
                                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                                        objArr[2] = Integer.valueOf(length);
                                        objArr[3] = Integer.valueOf(options.outHeight);
                                        objArr[4] = Integer.valueOf(options.outWidth);
                                        objArr[5] = Integer.valueOf(length2);
                                        objArr[6] = Integer.valueOf(createBitmap.getHeight());
                                        objArr[7] = Integer.valueOf(createBitmap.getWidth());
                                        objArr[8] = Integer.valueOf(1);
                                        objArr[9] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                                        c7060h.mo8381e(16498, objArr);
                                        if (C5730e.m8628ct(str2)) {
                                        }
                                        if (L != null) {
                                        }
                                        concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
                                        AppMethodBeat.m2505o(78219);
                                        return concat;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                        AppMethodBeat.m2505o(78219);
                                        throw th;
                                    }
                                }
                            }
                            byteArrayOutputStream2.close();
                            i3 = i2;
                        } catch (Exception e3) {
                            C4990ab.m7412e("MicroMsg.ImgInfoStorage", "compress bitmap failed.");
                            if (byteArrayOutputStream2 != null) {
                            }
                            C5056d.m7625a(createBitmap, i3, compressFormat, q, true);
                            C4990ab.m7411d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d", str2, q, Integer.valueOf(i3));
                            c7060h = C7060h.pYm;
                            objArr = new Object[10];
                            objArr[0] = C18178q.encode(C5046bo.nullAsNil(str), "UTF-8");
                            if (z) {
                            }
                            objArr[1] = Integer.valueOf(z ? 1 : 0);
                            objArr[2] = Integer.valueOf(length);
                            objArr[3] = Integer.valueOf(options.outHeight);
                            objArr[4] = Integer.valueOf(options.outWidth);
                            objArr[5] = Integer.valueOf(length2);
                            objArr[6] = Integer.valueOf(createBitmap.getHeight());
                            objArr[7] = Integer.valueOf(createBitmap.getWidth());
                            objArr[8] = Integer.valueOf(1);
                            objArr[9] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                            c7060h.mo8381e(16498, objArr);
                            if (C5730e.m8628ct(str2)) {
                            }
                            if (L != null) {
                            }
                            concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
                            AppMethodBeat.m2505o(78219);
                            return concat;
                        }
                    } catch (Exception e4) {
                        byteArrayOutputStream2 = null;
                        C4990ab.m7412e("MicroMsg.ImgInfoStorage", "compress bitmap failed.");
                        if (byteArrayOutputStream2 != null) {
                        }
                        C5056d.m7625a(createBitmap, i3, compressFormat, q, true);
                        C4990ab.m7411d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d", str2, q, Integer.valueOf(i3));
                        c7060h = C7060h.pYm;
                        objArr = new Object[10];
                        objArr[0] = C18178q.encode(C5046bo.nullAsNil(str), "UTF-8");
                        if (z) {
                        }
                        objArr[1] = Integer.valueOf(z ? 1 : 0);
                        objArr[2] = Integer.valueOf(length);
                        objArr[3] = Integer.valueOf(options.outHeight);
                        objArr[4] = Integer.valueOf(options.outWidth);
                        objArr[5] = Integer.valueOf(length2);
                        objArr[6] = Integer.valueOf(createBitmap.getHeight());
                        objArr[7] = Integer.valueOf(createBitmap.getWidth());
                        objArr[8] = Integer.valueOf(1);
                        objArr[9] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                        c7060h.mo8381e(16498, objArr);
                        if (C5730e.m8628ct(str2)) {
                        }
                        if (L != null) {
                        }
                        concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
                        AppMethodBeat.m2505o(78219);
                        return concat;
                    } catch (Throwable th22) {
                        th = th22;
                        byteArrayOutputStream = null;
                        if (byteArrayOutputStream != null) {
                        }
                        AppMethodBeat.m2505o(78219);
                        throw th;
                    }
                    C5056d.m7625a(createBitmap, i3, compressFormat, q, true);
                    C4990ab.m7411d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d", str2, q, Integer.valueOf(i3));
                    c7060h = C7060h.pYm;
                    objArr = new Object[10];
                    objArr[0] = C18178q.encode(C5046bo.nullAsNil(str), "UTF-8");
                    objArr[1] = Integer.valueOf(z ? 1 : 0);
                    objArr[2] = Integer.valueOf(length);
                    objArr[3] = Integer.valueOf(options.outHeight);
                    objArr[4] = Integer.valueOf(options.outWidth);
                    objArr[5] = Integer.valueOf(length2);
                    objArr[6] = Integer.valueOf(createBitmap.getHeight());
                    objArr[7] = Integer.valueOf(createBitmap.getWidth());
                    objArr[8] = Integer.valueOf(1);
                    objArr[9] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                    c7060h.mo8381e(16498, objArr);
                }
            } catch (Exception e5) {
            } catch (IOException e6) {
            }
            if (C5730e.m8628ct(str2)) {
                C4990ab.m7410d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                C5730e.deleteFile(str2);
            }
            if (L != null) {
                try {
                    L.close();
                } catch (Exception e7) {
                }
            }
            concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
            AppMethodBeat.m2505o(78219);
            return concat;
        } catch (IOException e8) {
            e = e8;
        } catch (Exception e9) {
            Exception e10 = e9;
            L = null;
            try {
                C4990ab.m7413e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e10);
                concat = mo73094a(bArr, true, compressFormat);
                if (C5730e.m8628ct(str2)) {
                }
                if (L != null) {
                }
                AppMethodBeat.m2505o(78219);
                return concat;
            } catch (Throwable th4) {
                th22 = th4;
                if (C5730e.m8628ct(str2)) {
                }
                if (L != null) {
                }
                AppMethodBeat.m2505o(78219);
                throw th22;
            }
        } catch (Throwable th5) {
            th22 = th5;
            L = null;
            if (C5730e.m8628ct(str2)) {
                C4990ab.m7410d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                C5730e.deleteFile(str2);
            }
            if (L != null) {
                try {
                    L.close();
                } catch (Exception e11) {
                }
            }
            AppMethodBeat.m2505o(78219);
            throw th22;
        }
        try {
            C4990ab.m7413e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e);
            concat = mo73094a(bArr, true, compressFormat);
            if (C5730e.m8628ct(str2)) {
            }
            if (outputStream != null) {
            }
            AppMethodBeat.m2505o(78219);
            return concat;
        } catch (Throwable th6) {
            th22 = th6;
            L = outputStream;
            if (C5730e.m8628ct(str2)) {
            }
            if (L != null) {
            }
            AppMethodBeat.m2505o(78219);
            throw th22;
        }
        AppMethodBeat.m2505o(78219);
        return concat;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0175 A:{SYNTHETIC, Splitter:B:37:0x0175} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x019e A:{SYNTHETIC, Splitter:B:47:0x019e} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0175 A:{SYNTHETIC, Splitter:B:37:0x0175} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01b5 A:{Splitter:B:6:0x0070, ExcHandler: IOException (e java.io.IOException)} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01b5 A:{Splitter:B:6:0x0070, ExcHandler: IOException (e java.io.IOException)} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01b5 A:{Splitter:B:6:0x0070, ExcHandler: IOException (e java.io.IOException)} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x019e A:{SYNTHETIC, Splitter:B:47:0x019e} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0175 A:{SYNTHETIC, Splitter:B:37:0x0175} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01ab A:{SYNTHETIC, Splitter:B:53:0x01ab} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0245 A:{SYNTHETIC, Splitter:B:88:0x0245} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0224 A:{SYNTHETIC, Splitter:B:79:0x0224} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0245 A:{SYNTHETIC, Splitter:B:88:0x0245} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:41:0x018c, code skipped:
            r6 = r5;
     */
    /* JADX WARNING: Missing block: B:59:0x01b5, code skipped:
            r4 = e;
     */
    /* JADX WARNING: Missing block: B:60:0x01b6, code skipped:
            r5 = r8;
     */
    /* JADX WARNING: Missing block: B:72:0x01f5, code skipped:
            r4 = e;
     */
    /* JADX WARNING: Missing block: B:77:0x0216, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7410d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
            com.tencent.p177mm.vfs.C5730e.deleteFile(r13);
     */
    /* JADX WARNING: Missing block: B:80:?, code skipped:
            r8.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final String mo73092a(byte[] bArr, CompressFormat compressFormat, int i, int i2, String str, boolean z) {
        String str2;
        OutputStream outputStream;
        OutputStream L;
        String concat;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th2;
        IOException e;
        AppMethodBeat.m2504i(78220);
        if (C5046bo.m7540cb(bArr)) {
            C4990ab.m7412e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            AppMethodBeat.m2505o(78220);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String agW = C45160g.agW();
        String q = mo73118q(agW, "th_", "");
        str2 = q + ".tmp";
        C4990ab.m7410d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = ".concat(String.valueOf(q)));
        int length = bArr.length;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        outputStream = null;
        try {
            L = C5730e.m8617L(str2, false);
            try {
                L.write(bArr);
                L.flush();
                Bitmap decodeByteArray = C5056d.decodeByteArray(bArr, i, i2);
                int length2 = bArr.length;
                if (decodeByteArray != null) {
                    int i3 = 100;
                    if (bArr.length > 262144) {
                        ByteArrayOutputStream byteArrayOutputStream2;
                        try {
                            byteArrayOutputStream2 = new ByteArrayOutputStream();
                            try {
                                decodeByteArray.compress(compressFormat, 100, byteArrayOutputStream2);
                                length2 = byteArrayOutputStream2.toByteArray().length;
                                int i4 = 100;
                                while (byteArrayOutputStream2.toByteArray().length > 262144 && i4 >= 15) {
                                    try {
                                        byteArrayOutputStream2.reset();
                                        i4 -= 5;
                                        decodeByteArray.compress(compressFormat, i4, byteArrayOutputStream2);
                                        length2 = byteArrayOutputStream2.toByteArray().length;
                                    } catch (Exception e2) {
                                        i3 = i4;
                                        try {
                                            C4990ab.m7412e("MicroMsg.ImgInfoStorage", "compress bitmap failed.");
                                            if (byteArrayOutputStream2 != null) {
                                                byteArrayOutputStream2.close();
                                            }
                                            C5056d.m7625a(decodeByteArray, i3, compressFormat, q, true);
                                            C4990ab.m7411d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d", str2, q, Integer.valueOf(i3));
                                            C7060h.pYm.mo8381e(16498, C18178q.encode(C5046bo.nullAsNil(str), "UTF-8"), Boolean.valueOf(z), Integer.valueOf(length), Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth), Integer.valueOf(length2), Integer.valueOf(decodeByteArray.getHeight()), Integer.valueOf(decodeByteArray.getWidth()), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                            if (C5730e.m8628ct(str2)) {
                                            }
                                            if (L != null) {
                                            }
                                            concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
                                            AppMethodBeat.m2505o(78220);
                                            return concat;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            byteArrayOutputStream = byteArrayOutputStream2;
                                            if (byteArrayOutputStream != null) {
                                                byteArrayOutputStream.close();
                                            }
                                            AppMethodBeat.m2505o(78220);
                                            throw th;
                                        }
                                    }
                                }
                                byteArrayOutputStream2.close();
                                i3 = i4;
                            } catch (Exception e3) {
                                C4990ab.m7412e("MicroMsg.ImgInfoStorage", "compress bitmap failed.");
                                if (byteArrayOutputStream2 != null) {
                                }
                                C5056d.m7625a(decodeByteArray, i3, compressFormat, q, true);
                                C4990ab.m7411d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d", str2, q, Integer.valueOf(i3));
                                C7060h.pYm.mo8381e(16498, C18178q.encode(C5046bo.nullAsNil(str), "UTF-8"), Boolean.valueOf(z), Integer.valueOf(length), Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth), Integer.valueOf(length2), Integer.valueOf(decodeByteArray.getHeight()), Integer.valueOf(decodeByteArray.getWidth()), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                if (C5730e.m8628ct(str2)) {
                                }
                                if (L != null) {
                                }
                                concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
                                AppMethodBeat.m2505o(78220);
                                return concat;
                            }
                        } catch (Exception e4) {
                            byteArrayOutputStream2 = null;
                            C4990ab.m7412e("MicroMsg.ImgInfoStorage", "compress bitmap failed.");
                            if (byteArrayOutputStream2 != null) {
                            }
                            C5056d.m7625a(decodeByteArray, i3, compressFormat, q, true);
                            C4990ab.m7411d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d", str2, q, Integer.valueOf(i3));
                            C7060h.pYm.mo8381e(16498, C18178q.encode(C5046bo.nullAsNil(str), "UTF-8"), Boolean.valueOf(z), Integer.valueOf(length), Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth), Integer.valueOf(length2), Integer.valueOf(decodeByteArray.getHeight()), Integer.valueOf(decodeByteArray.getWidth()), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            if (C5730e.m8628ct(str2)) {
                            }
                            if (L != null) {
                            }
                            concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
                            AppMethodBeat.m2505o(78220);
                            return concat;
                        } catch (Throwable th22) {
                            th = th22;
                            byteArrayOutputStream = null;
                            if (byteArrayOutputStream != null) {
                            }
                            AppMethodBeat.m2505o(78220);
                            throw th;
                        }
                        C5056d.m7625a(decodeByteArray, i3, compressFormat, q, true);
                    } else {
                        C5730e.m8623aQ(str2, q);
                    }
                    C4990ab.m7411d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d", str2, q, Integer.valueOf(i3));
                    C7060h.pYm.mo8381e(16498, C18178q.encode(C5046bo.nullAsNil(str), "UTF-8"), Boolean.valueOf(z), Integer.valueOf(length), Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth), Integer.valueOf(length2), Integer.valueOf(decodeByteArray.getHeight()), Integer.valueOf(decodeByteArray.getWidth()), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            } catch (Exception e5) {
            } catch (IOException e6) {
            }
            if (C5730e.m8628ct(str2)) {
                C4990ab.m7410d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                C5730e.deleteFile(str2);
            }
            if (L != null) {
                try {
                    L.close();
                } catch (Exception e7) {
                }
            }
            concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
            AppMethodBeat.m2505o(78220);
            return concat;
        } catch (IOException e8) {
            e = e8;
        } catch (Exception e9) {
            Exception e10 = e9;
            L = null;
            try {
                C4990ab.m7413e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e10);
                concat = mo73094a(bArr, true, compressFormat);
                if (C5730e.m8628ct(str2)) {
                }
                if (L != null) {
                }
                AppMethodBeat.m2505o(78220);
                return concat;
            } catch (Throwable th4) {
                th22 = th4;
                if (C5730e.m8628ct(str2)) {
                    C4990ab.m7410d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                    C5730e.deleteFile(str2);
                }
                if (L != null) {
                    try {
                        L.close();
                    } catch (Exception e11) {
                    }
                }
                AppMethodBeat.m2505o(78220);
                throw th22;
            }
        } catch (Throwable th5) {
            th22 = th5;
            L = null;
            if (C5730e.m8628ct(str2)) {
            }
            if (L != null) {
            }
            AppMethodBeat.m2505o(78220);
            throw th22;
        }
        try {
            C4990ab.m7413e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e);
            concat = mo73094a(bArr, true, compressFormat);
            if (C5730e.m8628ct(str2)) {
                C4990ab.m7410d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                C5730e.deleteFile(str2);
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e12) {
                }
            }
            AppMethodBeat.m2505o(78220);
            return concat;
        } catch (Throwable th6) {
            th22 = th6;
            L = outputStream;
            if (C5730e.m8628ct(str2)) {
            }
            if (L != null) {
            }
            AppMethodBeat.m2505o(78220);
            throw th22;
        }
        AppMethodBeat.m2505o(78220);
        return concat;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0126 A:{SYNTHETIC, Splitter:B:45:0x0126} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0126 A:{SYNTHETIC, Splitter:B:45:0x0126} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final String mo73095a(byte[] bArr, boolean z, CompressFormat compressFormat, boolean z2) {
        String agW;
        String str;
        Exception e;
        OutputStream outputStream;
        Throwable th;
        AppMethodBeat.m2504i(78221);
        if (C5046bo.m7540cb(bArr)) {
            C4990ab.m7412e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            AppMethodBeat.m2505o(78221);
            return null;
        }
        agW = C45160g.agW();
        String q = mo73118q(agW, "th_", "");
        str = q + ".tmp";
        C4990ab.m7410d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = ".concat(String.valueOf(q)));
        OutputStream outputStream2 = null;
        try {
            outputStream2 = C5730e.m8617L(str, false);
            try {
                Bitmap decodeFile;
                outputStream2.write(bArr);
                outputStream2.flush();
                int i = z ? 128 : 120;
                int i2 = z ? 128 : 120;
                if (z2) {
                    decodeFile = C5056d.decodeFile(str, null);
                } else {
                    decodeFile = C5056d.m7659d(str, i, i2, false);
                }
                if (decodeFile != null) {
                    C5056d.m7625a(decodeFile, 90, compressFormat, q, true);
                    C4990ab.m7411d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s", str, q);
                }
                if (C5730e.m8628ct(str)) {
                    C4990ab.m7410d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                    C5730e.deleteFile(str);
                }
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (Exception e2) {
                    }
                }
                String concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
                AppMethodBeat.m2505o(78221);
                return concat;
            } catch (Exception e3) {
                e = e3;
                outputStream = outputStream2;
            } catch (Throwable th2) {
                th = th2;
                outputStream = outputStream2;
                if (C5730e.m8628ct(str)) {
                    C4990ab.m7410d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                    C5730e.deleteFile(str);
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e4) {
                    }
                }
                AppMethodBeat.m2505o(78221);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            outputStream = outputStream2;
        } catch (Throwable th3) {
            th = th3;
            outputStream = outputStream2;
            if (C5730e.m8628ct(str)) {
            }
            if (outputStream != null) {
            }
            AppMethodBeat.m2505o(78221);
            throw th;
        }
        AppMethodBeat.m2505o(78221);
        return null;
        try {
            C7060h.pYm.mo8378a(111, 189, 1, false);
            C4990ab.m7412e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: th_" + agW + ", ex = " + e.getMessage());
            if (C5730e.m8628ct(str)) {
                C4990ab.m7410d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                C5730e.deleteFile(str);
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e6) {
                }
            }
            AppMethodBeat.m2505o(78221);
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (C5730e.m8628ct(str)) {
            }
            if (outputStream != null) {
            }
            AppMethodBeat.m2505o(78221);
            throw th;
        }
    }

    /* renamed from: W */
    public final String mo73075W(byte[] bArr) {
        AppMethodBeat.m2504i(78222);
        if (C5046bo.m7540cb(bArr)) {
            C4990ab.m7412e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            AppMethodBeat.m2505o(78222);
            return null;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (options.outWidth < 0 || options.outHeight < 0) {
            C4990ab.m7412e("MicroMsg.ImgInfoStorage", "Bad thumbBuf, perhaps it's not complete or damaged ??");
            AppMethodBeat.m2505o(78222);
            return null;
        }
        String agW = C45160g.agW();
        String q = mo73118q(agW, "th_", "");
        C4990ab.m7410d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = ".concat(String.valueOf(q)));
        C5730e.deleteFile(q);
        C5730e.m8624b(q, bArr, bArr.length);
        agW = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
        AppMethodBeat.m2505o(78222);
        return agW;
    }

    /* renamed from: I */
    public final String mo73074I(String str, boolean z) {
        AppMethodBeat.m2504i(78223);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(78223);
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("THUMBNAIL://")) {
            try {
                trim = mo73116ly(Integer.valueOf(trim.substring(12)).intValue()).fDB;
            } catch (NumberFormatException e) {
                C4990ab.m7412e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                AppMethodBeat.m2505o(78223);
                return null;
            }
        } else if (trim.startsWith("THUMBNAIL_DIRPATH://")) {
            trim = mo73106b(trim.substring(20).substring(3), "th_", "", z);
            AppMethodBeat.m2505o(78223);
            return trim;
        }
        trim = mo73106b(trim, "", "", z);
        AppMethodBeat.m2505o(78223);
        return trim;
    }

    /* renamed from: a */
    public final Bitmap mo73087a(String str, float f, boolean z) {
        AppMethodBeat.m2504i(78225);
        Bitmap a = mo73088a(str, false, f, z, false, false, -1);
        AppMethodBeat.m2505o(78225);
        return a;
    }

    /* renamed from: a */
    public final boolean mo73097a(ImageView imageView, String str, float f, int i, int i2, ImageView imageView2, int i3, int i4, View view) {
        AppMethodBeat.m2504i(78226);
        boolean a = mo73098a(imageView, str, false, f, i, i2, imageView2, i3, i4, view);
        AppMethodBeat.m2505o(78226);
        return a;
    }

    /* JADX WARNING: Missing block: B:19:0x00af, code skipped:
            if (r6.endsWith("hd") == false) goto L_0x0316;
     */
    /* JADX WARNING: Missing block: B:20:0x00b1, code skipped:
            r8 = (android.graphics.Bitmap) r12.fEh.mo4404ai(r6);
     */
    /* JADX WARNING: Missing block: B:21:0x00ba, code skipped:
            if (r8 != null) goto L_0x0195;
     */
    /* JADX WARNING: Missing block: B:22:0x00bc, code skipped:
            m83077a(r13, r19, r22, r6, r16);
            r6 = r6.substring(0, r6.length() - 2);
            r5 = 1;
            r2 = r8;
     */
    /* JADX WARNING: Missing block: B:23:0x00d5, code skipped:
            if (r2 != null) goto L_0x0313;
     */
    /* JADX WARNING: Missing block: B:24:0x00d7, code skipped:
            r4 = (android.graphics.Bitmap) r12.fEh.mo4404ai(r6);
     */
    /* JADX WARNING: Missing block: B:25:0x00e0, code skipped:
            if (r4 == null) goto L_0x01e7;
     */
    /* JADX WARNING: Missing block: B:27:0x00e6, code skipped:
            if (r4.isRecycled() != false) goto L_0x01e7;
     */
    /* JADX WARNING: Missing block: B:28:0x00e8, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.ImgInfoStorage", "[setbitmapFromUri] bitmap width %d,height %d", java.lang.Integer.valueOf(r4.getWidth()), java.lang.Integer.valueOf(r4.getHeight()));
            r13.setBackgroundDrawable(null);
            com.tencent.p177mm.p190at.C45160g.C32285a.m52718a(r4, r13);
     */
    /* JADX WARNING: Missing block: B:29:0x0118, code skipped:
            if (r13.getLayoutParams().width == -2) goto L_0x01bd;
     */
    /* JADX WARNING: Missing block: B:30:0x011a, code skipped:
            r2 = r12.fEq;
     */
    /* JADX WARNING: Missing block: B:31:0x011c, code skipped:
            if (r21 != 0) goto L_0x01c5;
     */
    /* JADX WARNING: Missing block: B:32:0x011e, code skipped:
            r2.gravity = 5;
     */
    /* JADX WARNING: Missing block: B:33:0x0121, code skipped:
            r13.setLayoutParams(r2);
     */
    /* JADX WARNING: Missing block: B:34:0x0133, code skipped:
            if (((double) r4.getWidth()) < (((double) r4.getHeight()) * 2.5d)) goto L_0x01cf;
     */
    /* JADX WARNING: Missing block: B:35:0x0135, code skipped:
            r2 = 1;
     */
    /* JADX WARNING: Missing block: B:37:0x0145, code skipped:
            if (((double) r4.getHeight()) < (((double) r4.getWidth()) * 2.5d)) goto L_0x01d2;
     */
    /* JADX WARNING: Missing block: B:38:0x0147, code skipped:
            r3 = 1;
     */
    /* JADX WARNING: Missing block: B:39:0x0148, code skipped:
            if (r2 != null) goto L_0x014c;
     */
    /* JADX WARNING: Missing block: B:40:0x014a, code skipped:
            if (r3 == null) goto L_0x0151;
     */
    /* JADX WARNING: Missing block: B:41:0x014c, code skipped:
            r13.setScaleType(android.widget.ImageView.ScaleType.CENTER);
     */
    /* JADX WARNING: Missing block: B:42:0x0151, code skipped:
            if (r19 == null) goto L_0x016a;
     */
    /* JADX WARNING: Missing block: B:43:0x0153, code skipped:
            r2 = new android.widget.FrameLayout.LayoutParams(r4.getWidth(), r4.getHeight());
     */
    /* JADX WARNING: Missing block: B:44:0x0160, code skipped:
            if (r21 != 0) goto L_0x01d5;
     */
    /* JADX WARNING: Missing block: B:45:0x0162, code skipped:
            r2.gravity = 5;
     */
    /* JADX WARNING: Missing block: B:46:0x0165, code skipped:
            r19.setLayoutParams(r2);
     */
    /* JADX WARNING: Missing block: B:47:0x016a, code skipped:
            if (r22 == null) goto L_0x0183;
     */
    /* JADX WARNING: Missing block: B:48:0x016c, code skipped:
            r2 = new android.widget.FrameLayout.LayoutParams(r4.getWidth(), r4.getHeight());
     */
    /* JADX WARNING: Missing block: B:49:0x0179, code skipped:
            if (r21 != 0) goto L_0x01de;
     */
    /* JADX WARNING: Missing block: B:50:0x017b, code skipped:
            r2.gravity = 5;
     */
    /* JADX WARNING: Missing block: B:51:0x017e, code skipped:
            r22.setLayoutParams(r2);
     */
    /* JADX WARNING: Missing block: B:52:0x0183, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(78227);
     */
    /* JADX WARNING: Missing block: B:58:0x01a6, code skipped:
            if (r12.fEh.remove(r6.substring(0, r6.length() - 2)) == null) goto L_0x01b9;
     */
    /* JADX WARNING: Missing block: B:59:0x01a8, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7410d("MicroMsg.ImgInfoStorage", "remove low quality thumb from cacheMap, path: ".concat(java.lang.String.valueOf(r6)));
     */
    /* JADX WARNING: Missing block: B:60:0x01b9, code skipped:
            r5 = null;
            r2 = r8;
     */
    /* JADX WARNING: Missing block: B:61:0x01bd, code skipped:
            r2 = (android.widget.FrameLayout.LayoutParams) r13.getLayoutParams();
     */
    /* JADX WARNING: Missing block: B:63:0x01c8, code skipped:
            if (r21 != 1) goto L_0x0121;
     */
    /* JADX WARNING: Missing block: B:64:0x01ca, code skipped:
            r2.gravity = 3;
     */
    /* JADX WARNING: Missing block: B:65:0x01cf, code skipped:
            r2 = null;
     */
    /* JADX WARNING: Missing block: B:66:0x01d2, code skipped:
            r3 = null;
     */
    /* JADX WARNING: Missing block: B:68:0x01d8, code skipped:
            if (r21 != 1) goto L_0x0165;
     */
    /* JADX WARNING: Missing block: B:69:0x01da, code skipped:
            r2.gravity = 3;
     */
    /* JADX WARNING: Missing block: B:71:0x01e1, code skipped:
            if (r21 != 1) goto L_0x017e;
     */
    /* JADX WARNING: Missing block: B:72:0x01e3, code skipped:
            r2.gravity = 3;
     */
    /* JADX WARNING: Missing block: B:73:0x01e7, code skipped:
            if (r20 <= 0) goto L_0x02c4;
     */
    /* JADX WARNING: Missing block: B:74:0x01e9, code skipped:
            r13.setBackgroundResource(r20);
            r13.setImageDrawable(null);
     */
    /* JADX WARNING: Missing block: B:75:0x01f6, code skipped:
            if (r17 >= 160) goto L_0x01fe;
     */
    /* JADX WARNING: Missing block: B:77:0x01fc, code skipped:
            if (r18 < 160) goto L_0x029d;
     */
    /* JADX WARNING: Missing block: B:79:0x0202, code skipped:
            if (r18 <= r17) goto L_0x028e;
     */
    /* JADX WARNING: Missing block: B:80:0x0204, code skipped:
            r2 = 160.0f / ((float) r18);
     */
    /* JADX WARNING: Missing block: B:81:0x020a, code skipped:
            r3 = (int) (((float) r17) * r2);
            r2 = (int) (r2 * ((float) r18));
     */
    /* JADX WARNING: Missing block: B:82:0x0214, code skipped:
            if (r3 <= 0) goto L_0x0296;
     */
    /* JADX WARNING: Missing block: B:83:0x0216, code skipped:
            r3 = (int) (((float) r3) * r16);
     */
    /* JADX WARNING: Missing block: B:84:0x021a, code skipped:
            if (r2 <= 0) goto L_0x029a;
     */
    /* JADX WARNING: Missing block: B:85:0x021c, code skipped:
            r2 = (int) (((float) r2) * r16);
     */
    /* JADX WARNING: Missing block: B:87:0x0227, code skipped:
            if (((float) r3) >= (60.0f * r16)) goto L_0x0310;
     */
    /* JADX WARNING: Missing block: B:88:0x0229, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7411d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", java.lang.Integer.valueOf(r3));
            r4 = (int) (60.0f * r16);
     */
    /* JADX WARNING: Missing block: B:90:0x0249, code skipped:
            if (((float) r2) >= (60.0f * r16)) goto L_0x0263;
     */
    /* JADX WARNING: Missing block: B:91:0x024b, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7411d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", java.lang.Integer.valueOf(r2));
            r2 = (int) (60.0f * r16);
     */
    /* JADX WARNING: Missing block: B:92:0x0263, code skipped:
            r3 = new android.widget.FrameLayout.LayoutParams(r4, r2);
     */
    /* JADX WARNING: Missing block: B:93:0x0268, code skipped:
            if (r21 != 0) goto L_0x02bb;
     */
    /* JADX WARNING: Missing block: B:94:0x026a, code skipped:
            r3.gravity = 5;
     */
    /* JADX WARNING: Missing block: B:95:0x026d, code skipped:
            if (r22 == null) goto L_0x030d;
     */
    /* JADX WARNING: Missing block: B:96:0x026f, code skipped:
            r22.setLayoutParams(r3);
            r2 = r3;
     */
    /* JADX WARNING: Missing block: B:97:0x0275, code skipped:
            r13.setLayoutParams(r2);
     */
    /* JADX WARNING: Missing block: B:98:0x0278, code skipped:
            if (r5 != null) goto L_0x0285;
     */
    /* JADX WARNING: Missing block: B:99:0x027a, code skipped:
            m83077a(r13, r19, r22, r6, r16);
     */
    /* JADX WARNING: Missing block: B:100:0x0285, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(78227);
     */
    /* JADX WARNING: Missing block: B:101:0x028e, code skipped:
            r2 = 160.0f / ((float) r17);
     */
    /* JADX WARNING: Missing block: B:102:0x0296, code skipped:
            r3 = 120;
     */
    /* JADX WARNING: Missing block: B:103:0x029a, code skipped:
            r2 = 75;
     */
    /* JADX WARNING: Missing block: B:104:0x029d, code skipped:
            if (r17 <= 0) goto L_0x02b5;
     */
    /* JADX WARNING: Missing block: B:105:0x029f, code skipped:
            r3 = (int) ((((float) r17) * r16) * 1.25f);
     */
    /* JADX WARNING: Missing block: B:106:0x02a8, code skipped:
            if (r18 <= 0) goto L_0x02b8;
     */
    /* JADX WARNING: Missing block: B:107:0x02aa, code skipped:
            r2 = (int) ((((float) r18) * r16) * 1.25f);
     */
    /* JADX WARNING: Missing block: B:108:0x02b5, code skipped:
            r17 = 120;
     */
    /* JADX WARNING: Missing block: B:109:0x02b8, code skipped:
            r18 = 75;
     */
    /* JADX WARNING: Missing block: B:111:0x02be, code skipped:
            if (r21 != 1) goto L_0x026d;
     */
    /* JADX WARNING: Missing block: B:112:0x02c0, code skipped:
            r3.gravity = 3;
     */
    /* JADX WARNING: Missing block: B:114:0x02c6, code skipped:
            if (r12.fEr == null) goto L_0x02d0;
     */
    /* JADX WARNING: Missing block: B:116:0x02ce, code skipped:
            if (r12.fEr.get() != null) goto L_0x02df;
     */
    /* JADX WARNING: Missing block: B:117:0x02d0, code skipped:
            r12.fEr = new java.lang.ref.SoftReference(new android.graphics.drawable.ColorDrawable(-1118482));
     */
    /* JADX WARNING: Missing block: B:118:0x02df, code skipped:
            r13.setImageDrawable((android.graphics.drawable.ColorDrawable) r12.fEr.get());
     */
    /* JADX WARNING: Missing block: B:119:0x02ec, code skipped:
            if (r17 <= 0) goto L_0x0307;
     */
    /* JADX WARNING: Missing block: B:120:0x02ee, code skipped:
            r3 = (int) ((((float) r17) * r16) * 1.25f);
     */
    /* JADX WARNING: Missing block: B:121:0x02f7, code skipped:
            if (r18 <= 0) goto L_0x030a;
     */
    /* JADX WARNING: Missing block: B:122:0x02f9, code skipped:
            r2 = new android.widget.FrameLayout.LayoutParams(r3, (int) ((((float) r18) * r16) * 1.25f));
     */
    /* JADX WARNING: Missing block: B:123:0x0307, code skipped:
            r17 = 120;
     */
    /* JADX WARNING: Missing block: B:124:0x030a, code skipped:
            r18 = 75;
     */
    /* JADX WARNING: Missing block: B:125:0x030d, code skipped:
            r2 = r3;
     */
    /* JADX WARNING: Missing block: B:126:0x0310, code skipped:
            r4 = r3;
     */
    /* JADX WARNING: Missing block: B:127:0x0313, code skipped:
            r4 = r2;
     */
    /* JADX WARNING: Missing block: B:128:0x0316, code skipped:
            r5 = null;
            r2 = null;
     */
    /* JADX WARNING: Missing block: B:134:?, code skipped:
            return true;
     */
    /* JADX WARNING: Missing block: B:135:?, code skipped:
            return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo73098a(ImageView imageView, String str, boolean z, float f, int i, int i2, ImageView imageView2, int i3, int i4, View view) {
        AppMethodBeat.m2504i(78227);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7413e("MicroMsg.ImgInfoStorage", "invalid uri is %s", str);
            AppMethodBeat.m2505o(78227);
            return false;
        }
        synchronized (this.fEo) {
            try {
                boolean containsKey = this.fEo.containsKey(str);
                Object c = mo73108c(str, z, false);
                if (C5046bo.isNullOrNil(c)) {
                    C4990ab.m7413e("MicroMsg.ImgInfoStorage", "getFullThumbPathByCache uri is null, uri:%s", C5046bo.nullAsNil(str));
                } else if (!containsKey) {
                    if (!c.endsWith("hd") && C5730e.m8628ct(c + "hd")) {
                        this.fEo.put(str, c + "hd");
                        c = c + "hd";
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(78227);
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m83077a(ImageView imageView, ImageView imageView2, View view, String str, float f) {
        int hashCode;
        int i;
        AppMethodBeat.m2504i(78228);
        int hashCode2 = str.hashCode();
        int hashCode3 = imageView.hashCode();
        for (C1284b c1284b : this.fEj) {
            if (hashCode3 == c1284b.fEz) {
                C4990ab.m7417i("MicroMsg.ImgInfoStorage", "setbitmapFromUri  [%d, %s] ", Integer.valueOf(c1284b.fEz), c1284b.url);
                c1284b.url = str;
                if (!this.fEn.contains(Integer.valueOf(hashCode2))) {
                    this.fEn.add(Integer.valueOf(hashCode2));
                    m83081f(str, f);
                }
                AppMethodBeat.m2505o(78228);
                return;
            }
        }
        this.fEk.put(Integer.valueOf(hashCode3), new WeakReference(imageView));
        if (imageView2 != null) {
            hashCode = imageView2.hashCode();
            this.fEl.put(Integer.valueOf(hashCode), new WeakReference(imageView2));
            i = hashCode;
        } else {
            i = 0;
        }
        if (view != null) {
            hashCode = view.hashCode();
            this.fEm.put(Integer.valueOf(hashCode), new WeakReference(view));
        } else {
            hashCode = 0;
        }
        this.fEj.add(new C1284b(hashCode3, str, i, hashCode));
        if (!this.fEn.contains(Integer.valueOf(hashCode2))) {
            this.fEn.add(Integer.valueOf(hashCode2));
            m83081f(str, f);
        }
        AppMethodBeat.m2505o(78228);
    }

    /* renamed from: f */
    private void m83081f(String str, float f) {
        AppMethodBeat.m2504i(78229);
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new C258232(str, f, true, C25738R.drawable.b0p));
        AppMethodBeat.m2505o(78229);
    }

    /* renamed from: b */
    public final Bitmap mo73104b(String str, float f, boolean z) {
        AppMethodBeat.m2504i(78230);
        Bitmap a = mo73088a(str, true, f, z, true, false, 0);
        AppMethodBeat.m2505o(78230);
        return a;
    }

    /* renamed from: a */
    public final Bitmap mo73088a(String str, boolean z, float f, boolean z2, boolean z3, boolean z4, int i) {
        AppMethodBeat.m2504i(78231);
        Bitmap a = m83072a(str, z, f, z2, z3, z4, i, true);
        AppMethodBeat.m2505o(78231);
        return a;
    }

    /* renamed from: a */
    private Bitmap m83072a(String str, boolean z, float f, boolean z2, boolean z3, boolean z4, int i, boolean z5) {
        AppMethodBeat.m2504i(78232);
        Bitmap a = m83073a(str, z, f, z2, z3, z4, i, z5, null);
        AppMethodBeat.m2505o(78232);
        return a;
    }

    /* renamed from: a */
    private Bitmap m83073a(String str, boolean z, float f, boolean z2, boolean z3, boolean z4, int i, boolean z5, Bitmap bitmap) {
        Object str2;
        AppMethodBeat.m2504i(78233);
        if (!z) {
            str2 = mo73108c(str2, false, true);
        }
        if (str2 == null) {
            AppMethodBeat.m2505o(78233);
            return null;
        }
        String str3;
        String str4;
        Object[] objArr;
        Bitmap bitmap2 = null;
        Object obj = (bitmap == null || bitmap.isRecycled()) ? null : 1;
        if (z5) {
            bitmap2 = (Bitmap) this.fEh.mo4404ai(str2);
            if (bitmap2 == null) {
                str3 = "MicroMsg.ImgInfoStorage";
                str4 = "bm is null:%b,  url:%s";
                objArr = new Object[2];
                objArr[0] = Boolean.valueOf(bitmap2 == null);
                objArr[1] = str2;
                C4990ab.m7408b(str3, str4, objArr);
            }
        }
        if (bitmap2 == null || bitmap2.isRecycled() || obj != null) {
            Bitmap bitmap3;
            C5046bo.anU();
            if (obj != null) {
                bitmap3 = bitmap;
            } else {
                bitmap3 = C5056d.m7664j(str2, f);
            }
            if (bitmap3 == null) {
                bitmap3 = C18764x.m29333vv(str2);
            }
            if (bitmap3 != null) {
                Bitmap createScaledBitmap;
                long currentTimeMillis = System.currentTimeMillis();
                int width = bitmap3.getWidth();
                int height = bitmap3.getHeight();
                if (z3) {
                    if (fEg == 0) {
                        fEg = C1338a.m2857am(C4996ah.getContext(), C25738R.dimen.a1h);
                    }
                    if (width > fEg || height > fEg) {
                        if (width > height) {
                            height = (height * fEg) / width;
                            width = fEg;
                        } else if (width == height) {
                            height = fEg;
                            width = fEg;
                        } else {
                            width = (width * fEg) / height;
                            height = fEg;
                        }
                    }
                }
                if (z4) {
                    int i2;
                    if (str2.endsWith("hd")) {
                        i2 = height;
                    } else {
                        width = (int) ((((float) bitmap3.getWidth()) * f) * 1.25f);
                        i2 = (int) ((((float) bitmap3.getHeight()) * f) * 1.25f);
                    }
                    if (((float) width) >= 160.0f * f || ((float) i2) >= 160.0f * f) {
                        float f2;
                        if (i2 > width) {
                            f2 = (160.0f * f) / ((float) i2);
                        } else {
                            f2 = (160.0f * f) / ((float) width);
                        }
                        width = (int) (((float) width) * f2);
                        height = (int) (f2 * ((float) i2));
                    } else {
                        height = i2;
                    }
                    if (((float) width) < 60.0f * f) {
                        C4990ab.m7411d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", Integer.valueOf(width));
                        width = (int) (60.0f * f);
                    }
                    if (((float) height) < 60.0f * f) {
                        C4990ab.m7411d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", Integer.valueOf(height));
                        height = (int) (60.0f * f);
                    }
                    Context context = C4996ah.getContext();
                    int[] iArr = new int[2];
                    float f3;
                    if (height >= width) {
                        f3 = ((float) height) / ((float) width);
                        if (f3 <= 2.0f) {
                            height = C1338a.m2857am(context, C25738R.dimen.f9745eb);
                            width = (int) (((float) height) / f3);
                        } else {
                            width = C1338a.m2857am(context, C25738R.dimen.f9747ed);
                            height = (int) (((float) width) * f3);
                        }
                    } else {
                        f3 = ((float) width) / ((float) height);
                        if (f3 <= 2.0f) {
                            width = C1338a.m2857am(context, C25738R.dimen.f9745eb);
                            height = (int) (((float) width) / f3);
                        } else {
                            height = C1338a.m2857am(context, C25738R.dimen.f9747ed);
                            width = (int) (((float) height) * f3);
                        }
                    }
                    iArr[0] = width;
                    iArr[1] = height;
                    width = iArr[0];
                    height = iArr[1];
                }
                try {
                    createScaledBitmap = Bitmap.createScaledBitmap(bitmap3, width, height, true);
                } catch (OutOfMemoryError e) {
                    createScaledBitmap = bitmap3;
                }
                if (bitmap3 != createScaledBitmap && obj == null) {
                    C4990ab.m7417i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", bitmap3.toString());
                    bitmap3.recycle();
                }
                if (z4) {
                    bitmap2 = C5056d.m7658d(createScaledBitmap, i);
                } else if (z2) {
                    bitmap2 = C5056d.m7616a(createScaledBitmap, true, (float) C1338a.fromDPToPix(C4996ah.getContext(), 3));
                    C4990ab.m7417i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", createScaledBitmap.toString());
                    createScaledBitmap.recycle();
                } else {
                    bitmap2 = createScaledBitmap;
                }
                str3 = "MicroMsg.ImgInfoStorage";
                str4 = "cached file :%s bitmap time:%s bitmap:%s";
                objArr = new Object[3];
                objArr[0] = str2;
                objArr[1] = (System.currentTimeMillis() - currentTimeMillis);
                objArr[2] = bitmap2 == null ? "" : bitmap2.toString();
                C4990ab.m7417i(str3, str4, objArr);
                if (bitmap2 != null && obj == null) {
                    this.fEh.mo4412k(str2, bitmap2);
                }
            } else {
                C4990ab.m7413e("MicroMsg.ImgInfoStorage", "img maybe delete, %s, %s", str2, Boolean.valueOf(FileOp.m64138ct(str2)));
            }
        }
        AppMethodBeat.m2505o(78233);
        return bitmap2;
    }

    /* renamed from: sk */
    public final Bitmap mo73120sk(String str) {
        AppMethodBeat.m2504i(78234);
        Bitmap j = C5056d.m7664j(mo73108c(str, false, true), C1338a.getDensity(C4996ah.getContext()));
        AppMethodBeat.m2505o(78234);
        return j;
    }

    /* renamed from: a */
    public final Bitmap mo73085a(String str, float f, Context context) {
        AppMethodBeat.m2504i(78235);
        Bitmap a = mo73086a(str, f, context, -1);
        AppMethodBeat.m2505o(78235);
        return a;
    }

    /* renamed from: a */
    public final Bitmap mo73086a(String str, float f, Context context, int i) {
        AppMethodBeat.m2504i(78236);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(78236);
            return null;
        }
        String trim = str.trim();
        Bitmap bitmap = (Bitmap) this.fEh.mo4404ai(trim);
        if (bitmap == null || bitmap.isRecycled()) {
            Bitmap i2 = C4977b.m7374i(trim, f);
            if (i2 != null) {
                int b;
                int i3;
                int width = i2.getWidth();
                int height = i2.getHeight();
                if (width >= height) {
                    b = C4977b.m7371b(context, (float) this.fEs);
                    i3 = (int) ((((float) height) / ((float) width)) * ((float) b));
                } else {
                    i3 = C4977b.m7371b(context, (float) this.fEs);
                    b = (int) ((((float) width) / ((float) height)) * ((float) i3));
                }
                if (b <= 0 || i3 <= 0 || b > 2048 || i3 > 2048) {
                    C4990ab.m7413e("MicroMsg.ImgInfoStorage", "getVideoThumb, error Scale Size %d*%d", Integer.valueOf(b), Integer.valueOf(i3));
                    C7060h.pYm.mo8378a(111, 188, 1, false);
                    bitmap = null;
                } else {
                    try {
                        bitmap = Bitmap.createScaledBitmap(i2, b, i3, true);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.ImgInfoStorage", "getVideoThumb, Bitmap.createScaledBitmap Exception:%s", e.getMessage());
                        bitmap = null;
                        C7060h.pYm.mo8378a(111, 188, 1, false);
                    }
                }
                if (i != -1) {
                    bitmap = C5056d.m7658d(bitmap, i);
                }
                if (i2 != bitmap) {
                    C4990ab.m7417i("MicroMsg.ImgInfoStorage", "[getVideoThumb] bitmap:%s", i2.toString());
                    i2.recycle();
                }
                C4990ab.m7410d("MicroMsg.ImgInfoStorage", "cached file ".concat(String.valueOf(trim)));
                this.fEh.mo4412k(trim, bitmap);
            } else {
                bitmap = i2;
            }
        }
        AppMethodBeat.m2505o(78236);
        return bitmap;
    }

    /* renamed from: b */
    public final C25822e mo73105b(Long l) {
        AppMethodBeat.m2504i(78238);
        C25822e c25822e = new C25822e();
        Cursor a = mo73083a("ImgInfo2", null, "id=?", new String[]{String.valueOf(l)});
        if (a != null && a.moveToFirst()) {
            c25822e.mo43791d(a);
        }
        a.close();
        AppMethodBeat.m2505o(78238);
        return c25822e;
    }

    /* renamed from: X */
    private C25822e m83069X(String str, int i) {
        AppMethodBeat.m2504i(78239);
        C25822e c25822e = new C25822e();
        Cursor a = mo73083a("ImgInfo2", null, "origImgMD5=? AND compressType=?", new String[]{String.valueOf(str), String.valueOf(i)});
        if (a.moveToFirst()) {
            c25822e.mo43791d(a);
        }
        a.close();
        AppMethodBeat.m2505o(78239);
        return c25822e;
    }

    public final List<C25822e> agV() {
        List<C25822e> list = null;
        AppMethodBeat.m2504i(78240);
        Cursor a = this.fni.mo10104a(("select * " + " FROM ImgInfo2") + " WHERE iscomplete= 0 AND totalLen != 0 ", null, 0);
        if (a.moveToFirst()) {
            list = new ArrayList();
            do {
                C25822e c25822e = new C25822e();
                c25822e.mo43791d(a);
                C25822e lz = mo73117lz((int) c25822e.fDy);
                if (lz != null) {
                    if (!(lz.cKK == 0 && lz.fDH == 0)) {
                        list.add(c25822e);
                    }
                } else if (!(c25822e.cKK == 0 && c25822e.fDH == 0)) {
                    list.add(c25822e);
                }
            } while (a.moveToNext());
            a.close();
            AppMethodBeat.m2505o(78240);
        } else {
            a.close();
            AppMethodBeat.m2505o(78240);
        }
        return list;
    }

    /* renamed from: x */
    public final void mo73125x(C7620bi c7620bi) {
        AppMethodBeat.m2504i(78241);
        C25822e w = mo73124w(c7620bi);
        if (w == null || w.fDy == 0) {
            C4990ab.m7412e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
            AppMethodBeat.m2505o(78241);
            return;
        }
        C5730e.deleteFile(mo73118q(w.fDz, "", ""));
        C5730e.deleteFile(mo73118q(w.fDE, "", ""));
        C5730e.deleteFile(mo73118q(w.fDB, "", ""));
        C5730e.deleteFile(mo73118q(w.fDB, "", "") + "hd");
        this.fni.delete("ImgInfo2", "id=?", new String[]{w.fDy});
        if (w.agQ()) {
            w = mo73116ly(w.fDJ);
            if (w == null) {
                AppMethodBeat.m2505o(78241);
                return;
            }
            C5730e.deleteFile(mo73118q(w.fDz, "", ""));
            C5730e.deleteFile(mo73118q(w.fDE, "", ""));
            C5730e.deleteFile(mo73118q(w.fDB, "", ""));
            C5730e.deleteFile(mo73118q(w.fDB, "", "") + "hd");
            this.fni.delete("ImgInfo2", "id=?", new String[]{w.fDy});
        }
        AppMethodBeat.m2505o(78241);
    }

    /* renamed from: d */
    public final String mo73109d(C25822e c25822e) {
        String str = null;
        AppMethodBeat.m2504i(78242);
        if (c25822e == null) {
            AppMethodBeat.m2505o(78242);
        } else if (c25822e.agQ()) {
            Cursor b = m83080b("ImgInfo2", new String[]{"bigImgPath"}, "id=? and totalLen = offset", new String[]{c25822e.fDJ});
            if (b.moveToFirst()) {
                str = b.getString(0);
            }
            b.close();
            AppMethodBeat.m2505o(78242);
        } else {
            AppMethodBeat.m2505o(78242);
        }
        return str;
    }

    /* renamed from: a */
    public final HashMap<Long, C25822e> mo73096a(Long... lArr) {
        AppMethodBeat.m2504i(78243);
        String str = "(";
        int length = lArr.length;
        int i = 0;
        Object obj = 1;
        while (i < length) {
            long longValue = lArr[i].longValue();
            str = str + (obj != null ? Long.valueOf(longValue) : ",".concat(String.valueOf(longValue)));
            i++;
            obj = null;
        }
        Cursor b = m83080b("ImgInfo2", null, "msgSvrId in ".concat(String.valueOf(str + ")")), null);
        HashMap hashMap = new HashMap();
        while (b.moveToNext()) {
            C25822e c25822e = new C25822e();
            c25822e.mo43791d(b);
            hashMap.put(Long.valueOf(c25822e.cKK), c25822e);
        }
        b.close();
        AppMethodBeat.m2505o(78243);
        return hashMap;
    }

    /* renamed from: b */
    public final HashMap<Long, C25822e> mo73107b(Long... lArr) {
        AppMethodBeat.m2504i(78244);
        String str = "(";
        int length = lArr.length;
        int i = 0;
        Object obj = 1;
        while (i < length) {
            long longValue = lArr[i].longValue();
            str = str + (obj != null ? Long.valueOf(longValue) : ",".concat(String.valueOf(longValue)));
            i++;
            obj = null;
        }
        Cursor b = m83080b("ImgInfo2", null, "msglocalid in ".concat(String.valueOf(str + ")")), null);
        HashMap hashMap = new HashMap();
        while (b.moveToNext()) {
            C25822e c25822e = new C25822e();
            c25822e.mo43791d(b);
            hashMap.put(Long.valueOf(c25822e.cKK), c25822e);
        }
        b.close();
        AppMethodBeat.m2505o(78244);
        return hashMap;
    }

    /* renamed from: ly */
    public final C25822e mo73116ly(int i) {
        AppMethodBeat.m2504i(78245);
        C25822e b = mo73105b(Long.valueOf((long) i));
        AppMethodBeat.m2505o(78245);
        return b;
    }

    /* renamed from: fI */
    public final C25822e mo73112fI(long j) {
        AppMethodBeat.m2504i(78246);
        C25822e c25822e = new C25822e();
        Cursor b = m83080b("ImgInfo2", null, "msgSvrId=?", new String[]{String.valueOf(j)});
        if (b.moveToFirst()) {
            c25822e.mo43791d(b);
        }
        b.close();
        AppMethodBeat.m2505o(78246);
        return c25822e;
    }

    /* renamed from: fJ */
    public final C25822e mo73113fJ(long j) {
        AppMethodBeat.m2504i(78247);
        C25822e c25822e = new C25822e();
        Cursor b = m83080b("ImgInfo2", null, "msglocalid=?", new String[]{String.valueOf(j)});
        if (b.moveToLast()) {
            c25822e.mo43791d(b);
        }
        b.close();
        AppMethodBeat.m2505o(78247);
        return c25822e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: lz */
    public final C25822e mo73117lz(int i) {
        C25822e c25822e;
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(78248);
        Cursor b;
        try {
            b = m83080b("ImgInfo2", null, "reserved1=?", new String[]{String.valueOf(i)});
            if (b != null) {
                try {
                    if (b.moveToFirst()) {
                        c25822e = new C25822e();
                        try {
                            c25822e.mo43791d(b);
                            if (b != null) {
                                b.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                C4990ab.m7421w("MicroMsg.ImgInfoStorage", "Exception :%s", e.toString());
                                if (b != null) {
                                    b.close();
                                }
                                AppMethodBeat.m2505o(78248);
                                return c25822e;
                            } catch (Throwable th2) {
                                th = th2;
                                if (b != null) {
                                }
                                AppMethodBeat.m2505o(78248);
                                throw th;
                            }
                        }
                        AppMethodBeat.m2505o(78248);
                        return c25822e;
                    }
                } catch (Exception e3) {
                    e = e3;
                    c25822e = null;
                    C4990ab.m7421w("MicroMsg.ImgInfoStorage", "Exception :%s", e.toString());
                    if (b != null) {
                    }
                    AppMethodBeat.m2505o(78248);
                    return c25822e;
                }
            }
            c25822e = null;
            if (b != null) {
            }
        } catch (Exception e4) {
            e = e4;
            c25822e = null;
            b = null;
        } catch (Throwable th3) {
            th = th3;
            b = null;
            if (b != null) {
                b.close();
            }
            AppMethodBeat.m2505o(78248);
            throw th;
        }
        AppMethodBeat.m2505o(78248);
        return c25822e;
    }

    /* renamed from: a */
    public final Cursor mo73083a(String str, String[] strArr, String str2, String[] strArr2) {
        AppMethodBeat.m2504i(78249);
        Cursor query = this.fni.query(str, strArr, str2, strArr2, null, null, null);
        AppMethodBeat.m2505o(78249);
        return query;
    }

    /* renamed from: b */
    private Cursor m83080b(String str, String[] strArr, String str2, String[] strArr2) {
        AppMethodBeat.m2504i(78250);
        Cursor a = mo73083a(str, strArr, str2, strArr2);
        AppMethodBeat.m2505o(78250);
        return a;
    }

    /* renamed from: a */
    public final long mo73079a(String str, int i, int i2, PString pString, PInt pInt, PInt pInt2) {
        AppMethodBeat.m2504i(78251);
        long a = mo73078a(str, i, i2, 0, pString, pInt, pInt2, "", "", -1, null, null, null);
        AppMethodBeat.m2505o(78251);
        return a;
    }

    /* renamed from: a */
    public final long mo73078a(String str, int i, int i2, int i3, PString pString, PInt pInt, PInt pInt2, String str2, String str3, long j, C1170b c1170b, C1170b c1170b2, C9030a c9030a) {
        AppMethodBeat.m2504i(78252);
        long a = mo73080a(str, null, i, i2, i3, pString, pInt, pInt2, str2, str3, j, c1170b, c1170b2, c9030a);
        AppMethodBeat.m2505o(78252);
        return a;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final long mo73080a(String str, String str2, int i, int i2, int i3, PString pString, PInt pInt, PInt pInt2, String str3, String str4, long j, C1170b c1170b, C1170b c1170b2, C9030a c9030a) {
        AppMethodBeat.m2504i(78253);
        long e;
        if (i == 0) {
            C25822e a = m83074a(str, 0, true, i2, i3, pInt, pInt2, pString.value, j, str3, str4, c1170b2, c1170b, c9030a);
            if (a == null) {
                AppMethodBeat.m2505o(78253);
                return -1;
            }
            pString.value = a.fDB;
            if (C5730e.m8628ct(str2)) {
                String IP = ((C27730c) C1720g.m3528K(C27730c.class)).mo45564IP(a.fDz);
                C5730e.m8644y(str2, mo73118q(IP, "", ""));
                a.mo43810sf(IP);
            }
            e = mo73110e(a);
            if (e != -1) {
                doNotify();
            }
            AppMethodBeat.m2505o(78253);
            return e;
        } else if (i == 1) {
            C25822e a2 = m83074a(str, 1, true, i2, i3, pInt, pInt2, pString.value, j, str3, str4, c1170b2, c1170b, c9030a);
            if (a2 == null) {
                AppMethodBeat.m2505o(78253);
                return -1;
            }
            pString.value = a2.fDB;
            a2.mo43793fG(0);
            a2.mo43792eI(0);
            a2.mo43797lt((int) C5730e.asZ(mo73118q(a2.fDz, "", "")));
            C25822e a3 = m83074a(str, 0, false, i2, i3, new PInt(), new PInt(), "", j, str3, str4, c1170b2, c1170b, c9030a);
            if (a3 == null) {
                AppMethodBeat.m2505o(78253);
                return 0;
            }
            a3.mo43803sb(a2.fDz);
            a3.mo43805sd(a2.fDB);
            a3.mo43804sc(a2.fDA);
            a3.mo43797lt(0);
            long iV = this.fni.mo15639iV(Thread.currentThread().getId());
            a3.mo43798lu((int) mo73110e(a2));
            e = mo73110e(a3);
            C4990ab.m7411d("MicroMsg.ImgInfoStorage", "summersafecdn insert ret[%d],  getLocalId[%d], getMsgLocalId[%d], getBigImgPath[%s], getMidImgPath[%s], getTotalLen[%d]", Long.valueOf(e), Long.valueOf(a3.fDy), Long.valueOf(a3.fDH), a3.fDz, a3.fDA, Integer.valueOf(a3.frO));
            if (iV > 0) {
                C1720g.m3536RP().eJN.mo15640mB(iV);
            }
            if (e != -1) {
                doNotify();
            }
            AppMethodBeat.m2505o(78253);
            return e;
        } else {
            Assert.assertTrue(false);
            AppMethodBeat.m2505o(78253);
            return 0;
        }
    }

    /* renamed from: e */
    public final long mo73110e(C25822e c25822e) {
        AppMethodBeat.m2504i(78254);
        long insert = this.fni.insert("ImgInfo2", "id", c25822e.mo43786Hl());
        if (insert != -1) {
            c25822e.agS();
        }
        C4990ab.m7417i("MicroMsg.ImgInfoStorage", "insert img, result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", Long.valueOf(insert), Long.valueOf(c25822e.fDy), Long.valueOf(c25822e.fDH), Long.valueOf(c25822e.cKK), Integer.valueOf(c25822e.fDJ));
        AppMethodBeat.m2505o(78254);
        return insert;
    }

    /* renamed from: sl */
    public final String mo73121sl(String str) {
        AppMethodBeat.m2504i(78255);
        String b = mo73106b("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str)), "th_", "", false);
        AppMethodBeat.m2505o(78255);
        return b;
    }

    /* renamed from: sm */
    public final String mo73122sm(String str) {
        AppMethodBeat.m2504i(78256);
        String b = mo73106b(str, "", FileUtils.PIC_POSTFIX_JPEG, false);
        AppMethodBeat.m2505o(78256);
        return b;
    }

    /* renamed from: Y */
    private String m83070Y(String str, int i) {
        AppMethodBeat.m2504i(78257);
        C25822e X = m83069X(C37478f.m63230sh(str), i);
        if (!C5046bo.isNullOrNil(X.fDB)) {
            String I = mo73074I(X.fDB, true);
            if (C5730e.m8628ct(I)) {
                AppMethodBeat.m2505o(78257);
                return I;
            }
        }
        AppMethodBeat.m2505o(78257);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private Bitmap m83071a(String str, int i, int i2, PInt pInt, PInt pInt2, boolean z, String str2, C1170b c1170b) {
        Bitmap ar;
        AppMethodBeat.m2504i(78258);
        C4990ab.m7411d("MicroMsg.ImgInfoStorage", "summersafecdn getPreSendBitmap origPath[%s], compressType[%d],needSave[%b], stack[%s], thumbPath: %s", str, Integer.valueOf(i), Boolean.valueOf(z), C5046bo.dpG(), str2);
        Bitmap bitmap = (Bitmap) this.fEh.mo4404ai(C37478f.m63230sh(str));
        String str3 = null;
        if (bitmap == null || bitmap.isRecycled()) {
            String str4;
            str3 = m83070Y(str, i);
            if (C5046bo.isNullOrNil(str3)) {
                str4 = str;
            } else if (str3.endsWith("hd")) {
                str4 = str3;
            } else {
                bitmap = C5056d.aml(str3);
                str4 = str;
            }
            if (bitmap == null || bitmap.isRecycled()) {
                int amy = C35985ad.amy(str4);
                int bJ = ExifHelper.m7368bJ(str4) + (i2 * 90);
                if (amy > 0) {
                    ar = C35985ad.m59192ar(str4, amy, bJ);
                } else {
                    ar = C5056d.m7641ao(str4, 120, 120);
                }
                if (ar != null) {
                    this.fEh.mo4412k(C37478f.m63230sh(str), ar);
                    pInt.value = ar.getWidth();
                    pInt2.value = ar.getHeight();
                    if (z) {
                        String Y;
                        if (str3 == null) {
                            Y = m83070Y(str, i);
                        } else {
                            Y = str3;
                        }
                        if (!C5046bo.isNullOrNil(Y) && Y.endsWith("hd")) {
                            Y = Y.substring(0, Y.length() - 2);
                        }
                        if (c1170b != null) {
                            c1170b.getFile();
                        }
                        if (C5046bo.isNullOrNil(Y) || !C5730e.m8628ct(Y)) {
                            try {
                                Object obj = (C5046bo.isNullOrNil(Y) || !Y.endsWith("hd")) ? null : 1;
                                C5056d.m7625a(ar, obj != null ? 80 : 90, CompressFormat.JPEG, str2, false);
                            } catch (IOException e) {
                            }
                        } else {
                            C5730e.m8644y(Y, str2);
                            C4990ab.m7417i("MicroMsg.ImgInfoStorage", "copy from old thumbPath %s", Y);
                        }
                    }
                }
                AppMethodBeat.m2505o(78258);
                return ar;
            }
        }
        ar = bitmap;
        if (ar != null) {
        }
        AppMethodBeat.m2505o(78258);
        return ar;
    }

    /* renamed from: a */
    public final String mo73089a(String str, int i, PString pString, PInt pInt, PInt pInt2, int i2, String str2) {
        AppMethodBeat.m2504i(78259);
        if (C5730e.m8628ct(str)) {
            Object obj;
            if (C5046bo.isNullOrNil(str2)) {
                str2 = C45160g.agW();
            }
            String concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str2));
            String b = mo73106b(concat, "th_", "", false);
            pString.value = concat;
            long yz = C5046bo.m7588yz();
            Bitmap a = m83071a(str, i, i2, pInt, pInt2, false, null, null);
            concat = (String) this.fEi.get(str);
            if (concat != null) {
                obj = (Bitmap) this.fEh.get(concat);
            } else {
                obj = null;
            }
            if (obj == null || obj.isRecycled()) {
                obj = m83073a(str, true, C1338a.getDensity(C4996ah.getContext()), false, false, true, (int) C25738R.drawable.b0p, true, a);
                this.fEi.put(str, b);
            }
            if (obj != null) {
                this.fEh.mo4412k(b, obj);
            }
            C4990ab.m7417i("MicroMsg.ImgInfoStorage", "test decode thumb img:%d", Long.valueOf(C5046bo.m7525az(yz)));
            AppMethodBeat.m2505o(78259);
            return str2;
        }
        C4990ab.m7413e("MicroMsg.ImgInfoStorage", "file not exit:%s", str);
        AppMethodBeat.m2505o(78259);
        return null;
    }

    public static synchronized String agW() {
        String sn;
        synchronized (C45160g.class) {
            AppMethodBeat.m2504i(78260);
            sn = C45160g.m83083sn("");
            AppMethodBeat.m2505o(78260);
        }
        return sn;
    }

    /* renamed from: sn */
    private static synchronized String m83083sn(String str) {
        synchronized (C45160g.class) {
            AppMethodBeat.m2504i(78261);
            long currentTimeMillis = System.currentTimeMillis();
            if (fEt == currentTimeMillis) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
                currentTimeMillis = System.currentTimeMillis();
            }
            fEt = currentTimeMillis;
            C4990ab.m7417i("MicroMsg.ImgInfoStorage", "generateMd5: %s, %s", C1178g.m2591x((str + currentTimeMillis).getBytes()), Long.valueOf(currentTimeMillis));
            AppMethodBeat.m2505o(78261);
        }
        return r3;
    }

    /* renamed from: a */
    private String m83076a(String str, int i, boolean z, int i2, PInt pInt, PInt pInt2, String str2, String str3, C1170b c1170b) {
        AppMethodBeat.m2504i(78262);
        C4990ab.m7417i("MicroMsg.ImgInfoStorage", "genThumbImg, orig:%s", str);
        if (C5730e.m8628ct(str)) {
            Object str32;
            if (C5046bo.isNullOrNil(str32)) {
                str32 = C45160g.agW();
            }
            String concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str32));
            String b = mo73106b(concat, "th_", "", false);
            if (c1170b == null) {
                b = mo73118q(concat, "th_", "");
            }
            if (z) {
                if (C5046bo.isNullOrNil(str2) || !C5730e.m8628ct(str2)) {
                    long yz = C5046bo.m7588yz();
                    m83071a(str, i, i2, pInt, pInt2, true, b, c1170b);
                    if (C5730e.m8628ct(b)) {
                        C7060h.pYm.mo8381e(10921, Long.valueOf(C5730e.asZ(b)), Long.valueOf(C5730e.asZ(str)), Integer.valueOf(90), Long.valueOf(C5046bo.m7525az(yz)));
                    } else {
                        C4990ab.m7412e("MicroMsg.ImgInfoStorage", " thumbImg not exits");
                    }
                } else {
                    C5730e.m8644y(str2, b);
                }
                C4990ab.m7410d("MicroMsg.ImgInfoStorage", "insert: thumbName = ".concat(String.valueOf(concat)));
            }
            AppMethodBeat.m2505o(78262);
            return concat;
        }
        C4990ab.m7413e("MicroMsg.ImgInfoStorage", "file not exit:%s", str);
        AppMethodBeat.m2505o(78262);
        return null;
    }

    /* renamed from: a */
    public final String mo73090a(String str, String str2, int i, boolean z, PString pString, PString pString2, PString pString3, PString pString4, String str3, C1170b c1170b) {
        String q;
        String str4;
        int i2;
        int i3;
        int indexOf;
        int i4;
        boolean z2;
        boolean z3;
        int i5;
        AppMethodBeat.m2504i(78263);
        if (C5046bo.isNullOrNil(str3)) {
            str3 = C45160g.m83083sn(str);
            C4990ab.m7417i("MicroMsg.ImgInfoStorage", "generateMd5: %s, %s", str3, str);
        }
        String b = mo73106b(str3, "", FileUtils.PIC_POSTFIX_JPEG, false);
        if (c1170b == null) {
            b = mo73106b(str3, "", FileUtils.PIC_POSTFIX_JPEG, true);
        }
        C4990ab.m7417i("MicroMsg.ImgInfoStorage", "fullPath is %s", b);
        if (C5730e.asZ(b) > 0) {
            C4990ab.m7416i("MicroMsg.ImgInfoStorage", "genBigImg file already exist!");
            C7060h.pYm.mo15419k(944, 8, 1);
        }
        pString.value = str3;
        pString2.value = b;
        if (z && !C5046bo.isNullOrNil(str2) && i == 0) {
            C25822e X = m83069X(str2, i);
            if (!C5046bo.isNullOrNil(X.fDz)) {
                q = mo73118q(X.fDz, "", "");
                if (c1170b != null) {
                    c1170b.getFile();
                }
                C5730e.m8644y(q, b);
                if (C5730e.asZ(q) <= 0) {
                    C4990ab.m7421w("MicroMsg.ImgInfoStorage", "ERR: copy old match file failed ,:%s ,%s ", str, b);
                } else if (C5046bo.isNullOrNil(X.fDK)) {
                    AppMethodBeat.m2505o(78263);
                    return null;
                } else {
                    str4 = X.fDK;
                    AppMethodBeat.m2505o(78263);
                    return str4;
                }
            }
        }
        try {
            i2 = C5023at.isWifi(C4996ah.getContext()) ? C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("CompressPicLevelForWifi"), 60) : C5023at.is2G(C4996ah.getContext()) ? C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("CompressPicLevelFor2G"), 40) : C5023at.is3G(C4996ah.getContext()) ? C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("CompressPicLevelFor3G"), 40) : C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("CompressPicLevelFor4G"), 60);
        } catch (Exception e) {
            i2 = 0;
        }
        C4990ab.m7417i("MicroMsg.ImgInfoStorage", "genBigImg CompressPicLevel-level:%d", Integer.valueOf(i2));
        if (i2 <= 10 || i2 > 100) {
            i3 = 70;
        } else {
            i3 = i2;
        }
        int i6 = 0;
        int i7 = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
        try {
            if (C5023at.isWifi(C4996ah.getContext())) {
                str4 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("CompressResolutionForWifi");
            } else if (C5023at.is2G(C4996ah.getContext())) {
                str4 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("CompressResolutionFor2G");
            } else if (C5023at.is3G(C4996ah.getContext())) {
                str4 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("CompressResolutionFor3G");
            } else {
                str4 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("CompressResolutionFor4G");
            }
            indexOf = str4.indexOf("*");
            if (-1 != indexOf) {
                i6 = Integer.valueOf(str4.substring(0, indexOf)).intValue();
                i2 = Integer.valueOf(str4.substring(indexOf + 1)).intValue();
            } else {
                i2 = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
            }
            i7 = i2;
        } catch (Exception e2) {
        }
        try {
            i4 = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("UseOptImage"), 0);
            C1720g.m3534RN();
            if ((((int) (new C1183p(C1668a.m3383QF()).longValue() / 100)) % 100) + 1 <= i4) {
                z2 = true;
            } else {
                z2 = false;
            }
            C4990ab.m7417i("MicroMsg.ImgInfoStorage", "fromPathToImgInfo useOpt:%b opt:%d uin:(%d,%d) debug:%b sdk:%d", Boolean.valueOf(z2), Integer.valueOf(i4), Long.valueOf(new C1183p(C1668a.m3383QF()).longValue()), Long.valueOf(new C1183p(C1668a.m3383QF()).longValue() / 100), Boolean.valueOf(C4872b.dnO()), Integer.valueOf(VERSION.SDK_INT));
        } catch (Exception e3) {
            C4990ab.m7413e("MicroMsg.ImgInfoStorage", "get useopt :%s", C5046bo.m7574l(e3));
            z2 = false;
        }
        if (C4872b.dnO()) {
            z2 = true;
        }
        if (C1443d.m3067fP(16)) {
            z3 = false;
        } else {
            z3 = z2;
        }
        C4990ab.m7417i("MicroMsg.ImgInfoStorage", "genBigImg configLong:%d configShort:%d", Integer.valueOf(i6), Integer.valueOf(i7));
        if (i6 <= 0 && i7 <= 0) {
            i6 = 0;
            i7 = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
        } else if (i7 >= 2160) {
            i6 = 0;
            i7 = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
        } else if (i7 <= 0 && i6 > 3240) {
            i6 = 1620;
            i7 = 0;
        }
        i2 = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        if (i2 <= 0) {
            i2 = 100;
        }
        int i8 = i2 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        i2 = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("PicCompressAvoidanceRemainderPerc"), 10);
        if (i2 <= 0 || i2 >= 100) {
            i5 = 10;
        } else {
            i5 = i2;
        }
        int queryQuality = MMNativeJpeg.queryQuality(str);
        Object obj = 1;
        if (queryQuality != 0 && queryQuality <= i3) {
            obj = null;
        }
        C4990ab.m7411d("MicroMsg.ImgInfoStorage", "genBigImg insert : original img path: %s, fullpath:%s, needimg:%b,comresstype:%d Avoidance[%d,%d] ", str, b, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i8), Integer.valueOf(i5));
        if (z) {
            Options amj = C5056d.amj(str);
            if (amj == null || amj.outWidth == 0 || amj.outHeight == 0) {
                q = "MicroMsg.ImgInfoStorage";
                String str5 = "genBigImg getImageOptions error:%s, origOptions_null:%b";
                Object[] objArr = new Object[2];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(amj == null);
                C4990ab.m7421w(q, str5, objArr);
                AppMethodBeat.m2505o(78263);
                return null;
            }
            Object obj2;
            long j;
            boolean z4;
            int i9 = amj.outWidth;
            int i10 = amj.outHeight;
            indexOf = amj.outWidth > amj.outHeight ? amj.outWidth : amj.outHeight;
            int i11 = amj.outWidth < amj.outHeight ? amj.outWidth : amj.outHeight;
            int i12;
            if (i7 > 0) {
                i12 = i11 / i7;
                i6 = amj.outHeight > i7 ? (amj.outHeight * i7) / i11 : amj.outHeight;
                i7 = amj.outWidth > i7 ? (i7 * amj.outWidth) / i11 : amj.outWidth;
                i11 = i6;
                indexOf = i7;
            } else {
                i12 = indexOf / i6;
                i7 = amj.outHeight > i6 ? (amj.outHeight * i6) / indexOf : amj.outHeight;
                if (amj.outWidth > i6) {
                    i6 = (i6 * amj.outWidth) / indexOf;
                } else {
                    i6 = amj.outWidth;
                }
                i11 = i7;
                indexOf = i6;
            }
            if (i11 * indexOf > 10240000) {
                double sqrt = Math.sqrt(1.024E7d / ((double) (i11 * indexOf)));
                i6 = (int) (((double) i11) / sqrt);
                indexOf = (int) (((double) indexOf) / sqrt);
            } else {
                i6 = i11;
            }
            C4990ab.m7417i("MicroMsg.ImgInfoStorage", "genBigImg [%d, %d] -> target:[h,w]:[%d,%d]", Integer.valueOf(amj.outHeight), Integer.valueOf(amj.outWidth), Integer.valueOf(i6), Integer.valueOf(indexOf));
            q = amj != null ? amj.outMimeType : "";
            long asZ = C5730e.asZ(str);
            boolean IsJpegFile = MMNativeJpeg.IsJpegFile(str);
            if (q == null || !(q.endsWith("jpeg") || q.endsWith("jpg") || q.endsWith("bmp") || q.endsWith("png") || q.endsWith("gif"))) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (i != 0 || ((obj == null && asZ <= 204800 && (amj == null || i12 <= 0)) || asZ <= ((long) i8))) {
                C4990ab.m7417i("MicroMsg.ImgInfoStorage", "summersafecdn createThumbNail big pic no compress, calculatedQuality:%d, origLen:%d oriWidth:%d oriHeight:%d", Integer.valueOf(queryQuality), Long.valueOf(asZ), Integer.valueOf(i9), Integer.valueOf(i10));
                if (obj2 != null) {
                    C5730e.m8644y(str, b);
                } else {
                    if (C5056d.m7611a(false, str, i9, i10, CompressFormat.JPEG, 100, b, c1170b) != 1) {
                        C7060h.pYm.mo8378a(111, 187, 1, false);
                        C4990ab.m7413e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail (for cvrt to jpg): %s", str);
                        AppMethodBeat.m2505o(78263);
                        return null;
                    }
                }
                i8 = 38;
                j = 0;
                C37461f.afx();
                if (!C31259b.m50439lg(256)) {
                    C4990ab.m7410d("MicroMsg.ImgInfoStorage", "summersafecdn not use CDNNEWPROTO");
                } else if (i == 1) {
                    int i13;
                    int i14;
                    int i15 = 0;
                    try {
                        i15 = Integer.valueOf(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("CompressMidPicLevel")).intValue();
                    } catch (Exception e4) {
                    }
                    try {
                        i2 = Integer.valueOf(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("CompressMidPicSize")).intValue();
                    } catch (Exception e5) {
                        i2 = 0;
                    }
                    C4990ab.m7417i("MicroMsg.ImgInfoStorage", "summersafecdn CompressMidPicLevel-level:%d size:%d", Integer.valueOf(i15), Integer.valueOf(i2));
                    if (i15 <= 10 || i15 > 100) {
                        i15 = 52;
                    }
                    if (i2 <= 0 || i2 > 800) {
                        i7 = 800;
                    } else {
                        i7 = i2;
                    }
                    if (indexOf > i7) {
                        i13 = i7;
                    } else {
                        i13 = indexOf;
                    }
                    if (i6 > i7) {
                        i14 = i7;
                    } else {
                        i14 = i6;
                    }
                    z2 = true;
                    if (queryQuality != 0 && queryQuality <= i15) {
                        z2 = false;
                    }
                    if (z2 || asZ > 800 || (amj != null && (i10 > i7 || i9 > i7))) {
                        pString3.value = C45160g.m83083sn(str);
                        pString4.value = mo73106b(pString3.value, "", FileUtils.PIC_POSTFIX_JPEG, false);
                        i7 = C5056d.m7611a(false, str, i14, i13, CompressFormat.JPEG, i15, pString4.value, c1170b);
                        C4990ab.m7411d("MicroMsg.ImgInfoStorage", "summersafecdn pMidImgName[%s], pMidImgPath[%s], useOpt[%b], ret[%b] [%d, %d]", pString3.value, pString4.value, Boolean.FALSE, Integer.valueOf(i7), Integer.valueOf(i14), Integer.valueOf(i13));
                        z4 = false;
                    } else {
                        pString3.value = pString.value;
                        pString4.value = pString2.value;
                        C4990ab.m7411d("MicroMsg.ImgInfoStorage", "summersafecdn not need to compress mid pic needCompressByQuality[%b], [%d, %d; %d, %d] use big pMidImgName[%s], pMidImgPath[%s]", Boolean.valueOf(z2), Integer.valueOf(i10), Integer.valueOf(i9), Integer.valueOf(i14), Integer.valueOf(i13), pString3.value, pString4.value);
                        i7 = 1;
                        z4 = false;
                    }
                }
                i7 = 1;
                z4 = false;
            } else {
                if (queryQuality < 55 || !IsJpegFile) {
                    z2 = false;
                } else {
                    z2 = z3;
                }
                if (z2) {
                    i8 = 18;
                } else {
                    i8 = 8;
                }
                long anU = C5046bo.anU();
                i7 = C5056d.m7611a(z2, str, i6, indexOf, CompressFormat.JPEG, i3, b, c1170b);
                if (i7 == 1 || !z2) {
                    z4 = z2;
                } else {
                    i8 = 28;
                    i7 = C5056d.m7611a(false, str, i6, indexOf, CompressFormat.JPEG, i3, b, c1170b);
                    z4 = false;
                }
                C4990ab.m7417i("MicroMsg.ImgInfoStorage", "genBigImg check use orig , orig:%d aftercomp:%d diff percent:[%d] picCompressAvoidanceRemainderPerc:%d  %s ", Long.valueOf(asZ), Long.valueOf(C5730e.asZ(b)), Long.valueOf((100 * C5730e.asZ(b)) / asZ), Integer.valueOf(i5), b);
                if (obj2 != null && (asZ - r10) * 100 < ((long) i5) * asZ) {
                    C5730e.m8644y(str, b);
                    z4 = false;
                    i8 = 48;
                    i7 = 1;
                }
                j = C5046bo.anU() - anU;
                if (i7 != 1) {
                    C7060h.pYm.mo8378a(111, 187, 1, false);
                    C4990ab.m7413e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail: %s", str);
                    AppMethodBeat.m2505o(78263);
                    return null;
                }
            }
            Options amj2 = C5056d.amj(b);
            i5 = amj2 != null ? amj2.outWidth : -1;
            indexOf = amj2 != null ? amj2.outHeight : -1;
            long asZ2 = C5730e.asZ(b);
            int queryQuality2 = MMNativeJpeg.queryQuality(b);
            boolean IsJpegFile2 = MMNativeJpeg.IsJpegFile(b);
            C7060h c7060h = C7060h.pYm;
            Integer[] numArr = new Object[13];
            numArr[0] = Integer.valueOf(i7);
            numArr[1] = Long.valueOf(j);
            numArr[2] = Integer.valueOf(i8);
            numArr[3] = Integer.valueOf(IsJpegFile ? 1 : 2);
            numArr[4] = Long.valueOf(asZ);
            numArr[5] = Integer.valueOf(i9);
            numArr[6] = Integer.valueOf(i10);
            numArr[7] = Integer.valueOf(i);
            numArr[8] = Long.valueOf(asZ2);
            numArr[9] = Integer.valueOf(i5);
            numArr[10] = Integer.valueOf(indexOf);
            numArr[11] = Integer.valueOf(queryQuality);
            numArr[12] = Integer.valueOf(queryQuality2);
            c7060h.mo8381e(11713, numArr);
            C4990ab.m7417i("MicroMsg.ImgInfoStorage", "genBigImg ret:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", Integer.valueOf(i7), Boolean.valueOf(z4), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(queryQuality), Long.valueOf(asZ), Boolean.valueOf(IsJpegFile), Integer.valueOf(i5), Integer.valueOf(indexOf), Integer.valueOf(queryQuality2), Long.valueOf(asZ2), Boolean.valueOf(IsJpegFile2), str, b);
            if (i == 0 && asZ2 >= 40960 && IsJpegFile2 && !MMNativeJpeg.isProgressive(b)) {
                str4 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("EnableCDNUploadImg");
                if (!C5046bo.isNullOrNil(str4) && str4.equals("1")) {
                    boolean z5;
                    j = C5046bo.anU();
                    if (z4) {
                        i4 = 19;
                        String str6 = b + ".prog";
                        C5730e.m8644y(b, str6);
                        z2 = (C5046bo.isNullOrNil(str6) || C5046bo.isNullOrNil(b) || !new File(str6).exists()) ? false : MMJpegOptim.convertToProgressive(str6, b, i3) == 0;
                        C5730e.deleteFile(str6);
                        if (z2) {
                            z5 = z2;
                        } else {
                            z5 = MMNativeJpeg.convertToProgressive(b, i3);
                            i4 = 29;
                        }
                    } else {
                        i4 = 9;
                        z5 = MMNativeJpeg.convertToProgressive(b, i3);
                    }
                    j = C5046bo.anU() - j;
                    long asZ3 = C5730e.asZ(b);
                    C7060h c7060h2 = C7060h.pYm;
                    Integer[] numArr2 = new Object[14];
                    numArr2[0] = Integer.valueOf(z5 ? 1 : -1);
                    numArr2[1] = Long.valueOf(j);
                    numArr2[2] = Integer.valueOf(i4);
                    numArr2[3] = Integer.valueOf(IsJpegFile ? 1 : 2);
                    numArr2[4] = Long.valueOf(asZ);
                    numArr2[5] = Integer.valueOf(i9);
                    numArr2[6] = Integer.valueOf(i10);
                    numArr2[7] = Integer.valueOf(i);
                    numArr2[8] = Long.valueOf(asZ2);
                    numArr2[9] = Integer.valueOf(i5);
                    numArr2[10] = Integer.valueOf(indexOf);
                    numArr2[11] = Integer.valueOf(queryQuality);
                    numArr2[12] = Integer.valueOf(queryQuality2);
                    numArr2[13] = Long.valueOf(asZ3);
                    c7060h2.mo8381e(11713, numArr2);
                    C4990ab.m7417i("MicroMsg.ImgInfoStorage", "genBigImg PROGRESS ret:%d progret:%b size:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", Integer.valueOf(i7), Boolean.valueOf(z5), Long.valueOf(asZ3), Boolean.valueOf(z4), Integer.valueOf(i4), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(queryQuality), Long.valueOf(asZ), Boolean.valueOf(IsJpegFile), Integer.valueOf(i5), Integer.valueOf(indexOf), Integer.valueOf(queryQuality2), Long.valueOf(asZ2), Boolean.valueOf(IsJpegFile2), str, b);
                    if (!z5) {
                        C7060h.pYm.mo8378a(111, 186, 1, false);
                        C4990ab.m7413e("MicroMsg.ImgInfoStorage", "genBigImg convert to progressive failed %s", b);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(78263);
        return null;
    }

    /* renamed from: a */
    private C25822e m83074a(String str, int i, boolean z, int i2, int i3, PInt pInt, PInt pInt2, String str2, long j, String str3, String str4, C1170b c1170b, C1170b c1170b2, C9030a c9030a) {
        AppMethodBeat.m2504i(78264);
        if (C5730e.m8628ct(str)) {
            PString pString;
            PString pString2;
            PString pString3;
            String a;
            String sh = C37478f.m63230sh(str);
            String a2 = m83076a(str, i, z, i3, pInt, pInt2, str2, str3, c1170b);
            if (c9030a == null || c9030a.fDC != i) {
                C1170b c1170b3;
                String str5;
                if (c9030a == null || c9030a.fDC == i) {
                    c1170b3 = c1170b2;
                    str5 = str4;
                } else {
                    c1170b3 = null;
                    str5 = null;
                }
                pString = new PString();
                pString2 = new PString();
                pString3 = new PString();
                a = mo73090a(str, sh, i, z, pString, pString2, pString3, new PString(), str5, c1170b3);
                C4990ab.m7417i("MicroMsg.ImgInfoStorage", "summersafecdn user change CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", str, Integer.valueOf(i2), Integer.valueOf(i), pString3.value, r10.value);
            } else {
                C9031a ahe = c9030a.ahe();
                pString = ahe.fFU;
                pString2 = ahe.fFV;
                a = ahe.fDK;
                pString3 = ahe.fFW;
                PString pString4 = ahe.fFX;
                C4990ab.m7417i("MicroMsg.ImgInfoStorage", "summersafecdn found CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", str, Integer.valueOf(i2), Integer.valueOf(i), pString3.value, pString4.value);
            }
            C25822e c25822e = new C25822e();
            c25822e.bJt = -1;
            c25822e.mo43794fH(agU());
            c25822e.mo43793fG(j);
            if (!C5046bo.isNullOrNil(a)) {
                c25822e.mo43806se(a);
            }
            c25822e.mo43800lw(0);
            c25822e.setSource(i2);
            if (i2 == 4) {
                if (str.startsWith(C40620aa.m70077Ya())) {
                    c25822e.mo43799lv(3);
                } else {
                    c25822e.mo43799lv(2);
                }
            } else {
                c25822e.mo43799lv(1);
            }
            if (z) {
                c25822e.mo43803sb(pString.value + FileUtils.PIC_POSTFIX_JPEG);
                if (!C5046bo.isNullOrNil(pString3.value)) {
                    c25822e.mo43804sc(pString3.value + FileUtils.PIC_POSTFIX_JPEG);
                }
                if (C5046bo.isNullOrNil(c25822e.fDB)) {
                    c25822e.mo43805sd(a2);
                }
                c25822e.mo43797lt((int) C5730e.asZ(pString2.value));
                if (c25822e.frO == 0) {
                    C4990ab.m7417i("MicroMsg.ImgInfoStorage", "thumb file totlen is 0 %s", pString2.value);
                }
                c25822e.mo43802sa(sh);
            }
            c25822e.mo43796ls((int) C5046bo.anT());
            c25822e.mo43801lx(i);
            C4990ab.m7410d("MicroMsg.ImgInfoStorage", "fromPathToImgInfo insert: compress img size = " + c25822e.frO);
            AppMethodBeat.m2505o(78264);
            return c25822e;
        }
        AppMethodBeat.m2505o(78264);
        return null;
    }

    /* renamed from: a */
    public final long mo73082a(byte[] bArr, long j, boolean z, String str, PString pString, PInt pInt, PInt pInt2) {
        AppMethodBeat.m2504i(78265);
        long a = mo73081a(bArr, j, z, "", 0, str, pString, pInt, pInt2);
        AppMethodBeat.m2505o(78265);
        return a;
    }

    /* renamed from: a */
    public final long mo73081a(byte[] bArr, long j, boolean z, String str, int i, String str2, PString pString, PInt pInt, PInt pInt2) {
        AppMethodBeat.m2504i(78266);
        String concat = "SERVERID://".concat(String.valueOf(j));
        String x = C1178g.m2591x(concat.getBytes());
        String q = mo73118q(x, "th_", "");
        if (bArr != null && bArr.length >= 0) {
            Bitmap bQ = C5056d.m7652bQ(bArr);
            if (bQ == null) {
                C4990ab.m7412e("MicroMsg.ImgInfoStorage", "create decodeByteArray failed: " + new String(bArr));
            }
            if (!(z || bQ == null)) {
                try {
                    bQ = C5056d.m7635ah(bQ);
                    pInt.value = bQ.getWidth();
                    pInt2.value = bQ.getHeight();
                    C5056d.m7625a(bQ, 90, CompressFormat.JPEG, q, true);
                } catch (IOException e) {
                    C4990ab.m7412e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: " + x + " " + new String(bArr));
                }
            }
        }
        C25822e c25822e = new C25822e();
        if (C5046bo.isNullOrNil(str)) {
            str = concat;
        } else {
            c25822e.setOffset(i);
            c25822e.mo43797lt(i);
        }
        c25822e.bJt = -1;
        c25822e.mo43794fH(agU());
        c25822e.mo43803sb(str);
        c25822e.mo43805sd("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(x)));
        pString.value = c25822e.fDB;
        if (z) {
            c25822e.mo43792eI(0);
            c25822e.mo43801lx(1);
        } else {
            c25822e.mo43792eI(j);
            c25822e.mo43801lx(0);
        }
        c25822e.mo43806se(str2);
        c25822e.mo43796ls((int) C5046bo.anT());
        long e2 = mo73110e(c25822e);
        if (e2 != -1) {
            doNotify();
        }
        AppMethodBeat.m2505o(78266);
        return e2;
    }

    /* renamed from: a */
    public final int mo73076a(int i, C25822e c25822e) {
        AppMethodBeat.m2504i(78267);
        int a = mo73077a(Long.valueOf((long) i), c25822e);
        AppMethodBeat.m2505o(78267);
        return a;
    }

    /* renamed from: a */
    public final int mo73077a(Long l, C25822e c25822e) {
        int i;
        AppMethodBeat.m2504i(78268);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        ContentValues Hl = c25822e.mo43786Hl();
        if (Hl.size() == 0) {
            i = 1;
        } else {
            i = this.fni.update("ImgInfo2", Hl, "id=?", new String[]{String.valueOf(l)});
        }
        C4990ab.m7417i("MicroMsg.ImgInfoStorage", "update last :%d values : %s %s", Long.valueOf(System.currentTimeMillis() - valueOf.longValue()), Hl.toString(), Integer.valueOf(i));
        if (i != -1) {
            c25822e.agS();
            doNotify();
        }
        AppMethodBeat.m2505o(78268);
        return i;
    }

    /* renamed from: g */
    public final Bitmap mo73114g(int i, int i2, boolean z) {
        Object obj;
        AppMethodBeat.m2504i(78269);
        if (z) {
            obj = "location_backgroup_key_from";
        } else {
            String obj2 = "location_backgroup_key_tor";
        }
        Bitmap bitmap = (Bitmap) this.fEh.mo4404ai(obj2);
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = C5056d.m7663gU(i, i2);
            this.fEh.mo4412k(obj2, bitmap);
        }
        AppMethodBeat.m2505o(78269);
        return bitmap;
    }

    /* renamed from: a */
    public final Bitmap mo73084a(long j, String str, int i, int i2, int i3, boolean z) {
        Object concat;
        AppMethodBeat.m2504i(78270);
        if (z) {
            concat = "location_backgroup_key_from".concat(String.valueOf(j));
        } else {
            String concat2 = "location_backgroup_key_tor".concat(String.valueOf(j));
        }
        Bitmap bitmap = (Bitmap) this.fEh.mo4404ai(concat2);
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = C5056d.m7666o(str, i, i2, i3);
            this.fEh.mo4412k(concat2, bitmap);
        }
        AppMethodBeat.m2505o(78270);
        return bitmap;
    }

    /* renamed from: a */
    public final boolean mo73099a(C7620bi c7620bi, int i, int i2) {
        AppMethodBeat.m2504i(78271);
        String y = C45160g.m83084y(c7620bi);
        if (C5046bo.isNullOrNil(y)) {
            AppMethodBeat.m2505o(78271);
            return false;
        }
        boolean a = mo73100a(y, c7620bi.field_imgPath, i, i2, 0, 0);
        AppMethodBeat.m2505o(78271);
        return a;
    }

    /* renamed from: a */
    public final boolean mo73100a(String str, String str2, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(78272);
        C4990ab.m7411d("MicroMsg.ImgInfoStorage", "createHDThumbNail bigPicPath%s thumbPath%s maskResId:%d, compressType:%d, stack[%s]", str, str2, Integer.valueOf(i), Integer.valueOf(i2), C5046bo.dpG());
        long currentTimeMillis = System.currentTimeMillis();
        float density = C1338a.getDensity(C4996ah.getContext());
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(78272);
            return false;
        }
        String c = mo73108c(str2, false, true);
        if (C5046bo.isNullOrNil(c)) {
            AppMethodBeat.m2505o(78272);
            return false;
        }
        String str3;
        String substring;
        boolean a;
        if (c.endsWith("hd")) {
            str3 = c;
            substring = c.substring(0, c.length() - 2);
        } else {
            str3 = c + "hd";
            substring = c;
        }
        Options amj = C5056d.amj(substring);
        if (amj == null || amj.outWidth <= 0 || amj.outHeight <= 0) {
            C7060h.pYm.mo8378a(111, 185, 1, false);
            if (C5730e.asZ(substring) > 0) {
                AppMethodBeat.m2505o(78272);
                return false;
            }
            amj = new Options();
            C5056d.dnX();
            C4990ab.m7417i("MicroMsg.ImgInfoStorage", "createHDThumbNail old op is invaild but len is 0 need recreate[%s, %d, %d]", amj, Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
            C7060h.pYm.mo8378a(111, 183, 1, false);
        }
        if (amj.outWidth == 0) {
            amj.outWidth = i3;
        }
        if (amj.outHeight == 0) {
            amj.outHeight = i4;
        }
        int i5 = (int) ((((float) amj.outWidth) * density) * 1.25f);
        int i6 = (int) ((((float) amj.outHeight) * density) * 1.25f);
        if (((float) i5) >= 160.0f * density || ((float) i6) >= 160.0f * density) {
            float f;
            if (i6 > i5) {
                f = (160.0f * density) / ((float) i6);
            } else {
                f = (160.0f * density) / ((float) i5);
            }
            i5 = (int) (((float) i5) * f);
            i6 = (int) (f * ((float) i6));
        }
        if (i2 == 0) {
            try {
                a = C5056d.m7632a(str, i6, i5, CompressFormat.JPEG, str3, new PInt(), new PInt());
            } catch (Exception e) {
                C7060h.pYm.mo8378a(111, 184, 1, false);
                C4990ab.m7413e("MicroMsg.ImgInfoStorage", "create hd thumbnail failed. %s", e.toString());
                AppMethodBeat.m2505o(78272);
                return false;
            }
        }
        a = C5056d.m7651b(str, i6, i5, CompressFormat.JPEG, str3, new PInt(), new PInt());
        C4990ab.m7411d("MicroMsg.ImgInfoStorage", "createHDThumbNail user time %s, height %d, width %d, hasHDThumb:%b", (System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(i6), Integer.valueOf(i5), Boolean.valueOf(a));
        m83072a(substring, true, C1338a.getDensity(C4996ah.getContext()), true, false, true, i, false);
        if (a) {
            synchronized (this.fEo) {
                try {
                    if (this.fEo.containsKey(str2) && !((String) this.fEo.get(str2)).endsWith("hd")) {
                        this.fEo.put(str2, str3);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(78272);
                    }
                }
            }
        } else {
            C7060h.pYm.mo8378a(111, 184, 1, false);
        }
        AppMethodBeat.m2505o(78272);
        return a;
    }

    /* renamed from: c */
    public final String mo73108c(String str, boolean z, boolean z2) {
        String str2;
        AppMethodBeat.m2504i(78273);
        if (str == null || !this.fEo.containsKey(str)) {
            if (z) {
                str2 = str;
            } else {
                str2 = mo73074I(str, z2);
            }
            if (!C5046bo.isNullOrNil(str2)) {
                this.fEo.put(str, str2);
            }
        } else {
            str2 = (String) this.fEo.get(str);
        }
        AppMethodBeat.m2505o(78273);
        return str2;
    }

    /* JADX WARNING: Missing block: B:6:0x0030, code skipped:
            if (r0.fDy == 0) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: y */
    public static String m83084y(C7620bi c7620bi) {
        AppMethodBeat.m2504i(78275);
        if (c7620bi == null) {
            C4990ab.m7420w("MicroMsg.ImgInfoStorage", "[getBigPicPath] msg is null.");
            AppMethodBeat.m2505o(78275);
            return null;
        }
        C25822e fJ;
        long currentTimeMillis = System.currentTimeMillis();
        if (c7620bi.field_isSend == 1) {
            fJ = C32291o.ahl().mo73113fJ(c7620bi.field_msgId);
        }
        fJ = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
        if (C1720g.m3536RP().isSDCardAvailable()) {
            String q;
            if (c7620bi.field_isSend == 1) {
                String c = C37478f.m63227c(fJ);
                String q2 = C32291o.ahl().mo73118q(c, "", "");
                if (c == null || c.length() <= 0 || !C5730e.m8628ct(q2)) {
                    q2 = fJ.fDz;
                    q = C32291o.ahl().mo73118q(q2, "", "");
                    if (q2 != null && q2.length() > 0 && C5730e.m8628ct(q)) {
                        AppMethodBeat.m2505o(78275);
                        return q;
                    }
                }
                AppMethodBeat.m2505o(78275);
                return q2;
            } else if (fJ.agP()) {
                String str = fJ.fDz;
                if (fJ.agQ()) {
                    fJ = C37478f.m63225a(fJ);
                    if (fJ != null && fJ.fDy > 0 && fJ.agP() && C5730e.m8628ct(C32291o.ahl().mo73118q(fJ.fDz, "", ""))) {
                        q = fJ.fDz;
                        AppMethodBeat.m2505o(78275);
                        return q;
                    }
                }
                q = str;
                AppMethodBeat.m2505o(78275);
                return q;
            }
        }
        C4990ab.m7411d("MicroMsg.ImgInfoStorage", "getBigPicPath use time:%s", (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(78275);
        return null;
    }

    /* renamed from: e */
    public final Bitmap mo73111e(String str, float f) {
        AppMethodBeat.m2504i(78224);
        Bitmap a = mo73087a(str, f, false);
        AppMethodBeat.m2505o(78224);
        return a;
    }

    /* renamed from: w */
    public final C25822e mo73124w(C7620bi c7620bi) {
        AppMethodBeat.m2504i(78237);
        C25822e fJ = mo73113fJ(c7620bi.field_msgId);
        if (fJ.fDy == 0) {
            fJ = mo73112fI(c7620bi.field_msgSvrId);
            if (fJ.fDy == 0) {
                C4990ab.m7412e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
                AppMethodBeat.m2505o(78237);
                return null;
            }
        }
        AppMethodBeat.m2505o(78237);
        return fJ;
    }

    /* renamed from: so */
    public final String mo73123so(String str) {
        AppMethodBeat.m2504i(139133);
        String c = mo73108c(str, false, true);
        AppMethodBeat.m2505o(139133);
        return c;
    }
}
