package com.tencent.mm.at;

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
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.a.p;
import com.tencent.mm.cd.h;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
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

public final class g extends k {
    public static int fEg = 0;
    public static long fEt = 0;
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS ImgInfo ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT )", "CREATE TABLE IF NOT EXISTS ImgInfo2 ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid INT, status INT, nettimes INT, reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text, hashdthumb int DEFAULT 0, iscomplete INT DEFAULT 1, origImgMD5 TEXT, compressType INT DEFAULT 0, midImgPath TEXT, forwardType INT DEFAULT 0, hevcPath TEXT )", "CREATE INDEX IF NOT EXISTS  serverImgInfoIndex ON ImgInfo2 ( msgSvrId ) ", "CREATE INDEX IF NOT EXISTS  serverImgInfoHdIndex ON ImgInfo2 ( reserved1 ) ", "CREATE INDEX IF NOT EXISTS  msgLocalIdIndex ON ImgInfo2 ( msglocalid ) ", "insert into imginfo2 (id,msgSvrId , offset , totalLen , bigImgPath , thumbImgPath) select id, msgSvrId, offset ,totallen , bigimgpath , thumbimgpath from imginfo; ", "delete from ImgInfo ; ", "CREATE INDEX IF NOT EXISTS iscomplete_index ON ImgInfo2 ( iscomplete ) ", "CREATE INDEX IF NOT EXISTS origImgMD5_index ON ImgInfo2 ( origImgMD5 ) "};
    f<String, Bitmap> fEh = new com.tencent.mm.memory.a.b(40, new com.tencent.mm.a.f.b<String, Bitmap>() {
        public final /* synthetic */ void c(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.i(78202);
            String str = (String) obj;
            Bitmap bitmap = (Bitmap) obj2;
            if (!(bitmap == null || bitmap.isRecycled())) {
                ab.i("MicroMsg.ImgInfoStorage", "[preRemoveCallback] key:%s remove bitmap without recycle! :%s size:%s", str, bitmap.toString(), Integer.valueOf(bitmap.getByteCount()));
            }
            AppMethodBeat.o(78202);
        }
    }, getClass());
    private f<String, String> fEi = new c(40);
    private List<b> fEj = new ArrayList();
    private Map<Integer, WeakReference<ImageView>> fEk = new HashMap();
    private Map<Integer, WeakReference<ImageView>> fEl = new HashMap();
    private Map<Integer, WeakReference<View>> fEm = new HashMap();
    private Set<Integer> fEn = new HashSet();
    private Map<String, String> fEo = new HashMap();
    private final AtomicLong fEp = new AtomicLong(1);
    private LayoutParams fEq = new LayoutParams(-2, -2);
    private SoftReference<ColorDrawable> fEr;
    public int fEs = 150;
    private ak fbD = new ak(Looper.getMainLooper());
    public h fni = null;

    static class b {
        int fEA;
        int fEB;
        int fEz;
        String url;

        b(int i, String str, int i2, int i3) {
            this.fEz = i;
            this.url = str;
            this.fEA = i2;
            this.fEB = i3;
        }
    }

    /* renamed from: com.tencent.mm.at.g$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ float ckb;
        final /* synthetic */ String fEv;
        final /* synthetic */ boolean fEw = true;
        final /* synthetic */ int fEx = R.drawable.b0p;

        AnonymousClass2(String str, float f, boolean z, int i) {
            this.fEv = str;
            this.ckb = f;
        }

        public final void run() {
            AppMethodBeat.i(78204);
            g.this.a(this.fEv, true, this.ckb, true, false, this.fEw, this.fEx);
            g.this.fbD.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(78203);
                    g.a(g.this, AnonymousClass2.this.fEv);
                    AppMethodBeat.o(78203);
                }
            });
            AppMethodBeat.o(78204);
        }

        public final String toString() {
            AppMethodBeat.i(78205);
            String str = super.toString() + "|loadImginBackground";
            AppMethodBeat.o(78205);
            return str;
        }
    }

    public static class a extends BitmapDrawable {
        public static void a(Bitmap bitmap, ImageView imageView) {
            AppMethodBeat.i(78206);
            if (imageView == null || imageView.getResources() == null) {
                AppMethodBeat.o(78206);
                return;
            }
            a aVar = new a(imageView.getResources(), bitmap);
            if (imageView.getLayerType() == 1) {
                imageView.destroyDrawingCache();
                imageView.setLayerType(0, null);
            }
            imageView.setImageDrawable(aVar);
            AppMethodBeat.o(78206);
        }

        private a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        public final void draw(Canvas canvas) {
            AppMethodBeat.i(78207);
            if (getBitmap() == null || getBitmap().isRecycled()) {
                if (getBitmap() != null) {
                    ab.e("MicroMsg.ImgInfoStorage", "Cannot draw recycled bitmaps:%s", getBitmap().toString());
                }
                AppMethodBeat.o(78207);
                return;
            }
            super.draw(canvas);
            AppMethodBeat.o(78207);
        }
    }

    public g(h hVar) {
        AppMethodBeat.i(78208);
        a(hVar);
        this.fni = hVar;
        agT();
        AppMethodBeat.o(78208);
    }

    public final void agT() {
        AppMethodBeat.i(78209);
        Cursor a = this.fni.a("SELECT max(id) FROM ImgInfo2", null, 2);
        if (a.moveToFirst()) {
            long j = a.getLong(0) + 1;
            synchronized (this.fEp) {
                try {
                    if (j > this.fEp.get()) {
                        this.fEp.set(j);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(78209);
                    }
                }
            }
        }
        a.close();
        ab.i("MicroMsg.ImgInfoStorage", "loading new img id: " + this.fEp.get());
        AppMethodBeat.o(78209);
    }

    public final long agU() {
        long andIncrement;
        AppMethodBeat.i(78210);
        synchronized (this.fEp) {
            try {
                andIncrement = this.fEp.getAndIncrement();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(78210);
            }
        }
        return andIncrement;
    }

    private static void a(h hVar) {
        AppMethodBeat.i(78211);
        Cursor a = hVar.a("PRAGMA table_info(ImgInfo2)", null, 2);
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
        long iV = com.tencent.mm.kernel.g.RP().eJN.iV(Thread.currentThread().getId());
        if (obj7 == null) {
            hVar.hY("ImgInfo2", "Alter table ImgInfo2 add hashdthumb INT DEFAULT 0");
        }
        if (obj6 == null) {
            hVar.hY("ImgInfo2", "Alter table ImgInfo2 add iscomplete INT DEFAULT 1");
        }
        if (obj5 == null) {
            hVar.hY("ImgInfo2", "Alter table ImgInfo2 add origImgMD5 TEXT");
        }
        if (obj4 == null) {
            hVar.hY("ImgInfo2", "Alter table ImgInfo2 add compressType INT DEFAULT 0");
        }
        if (obj3 == null) {
            hVar.hY("ImgInfo2", "Alter table ImgInfo2 add midImgPath TEXT");
        }
        if (obj2 == null) {
            hVar.hY("ImgInfo2", "Alter table ImgInfo2 add forwardType INT DEFAULT 0");
        }
        if (obj == null) {
            hVar.hY("ImgInfo2", "Alter table ImgInfo2 add hevcPath TEXT");
        }
        if (iV > 0) {
            com.tencent.mm.kernel.g.RP().eJN.mB(iV);
        }
        AppMethodBeat.o(78211);
    }

    public final String b(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(78212);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(78212);
            return null;
        }
        String str4;
        String str5;
        String str6 = "";
        if (str.startsWith("SERVERID://")) {
            try {
                str4 = fI(Long.valueOf(str.substring(11)).longValue()).fDz;
            } catch (NumberFormatException e) {
                ab.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                AppMethodBeat.o(78212);
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
        str6 = com.tencent.mm.plugin.i.c.XW();
        String XX = com.tencent.mm.plugin.i.c.XX();
        if (bo.isNullOrNil(str4)) {
            str4 = str;
        }
        str6 = j.b(str6, XX, str5, str4, str3, z);
        AppMethodBeat.o(78212);
        return str6;
    }

    public final String q(String str, String str2, String str3) {
        AppMethodBeat.i(78213);
        String b = b(str, str2, str3, true);
        AppMethodBeat.o(78213);
        return b;
    }

    public final String getFullPath(String str) {
        AppMethodBeat.i(78214);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(78214);
            return null;
        }
        String str2 = "";
        if (str.startsWith("SERVERID://")) {
            try {
                str2 = fI(Long.valueOf(str.substring(11)).longValue()).fDz;
            } catch (NumberFormatException e) {
                ab.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                AppMethodBeat.o(78214);
                return null;
            }
        }
        String XW = com.tencent.mm.plugin.i.c.XW();
        String XX = com.tencent.mm.plugin.i.c.XX();
        String str3 = "th_";
        if (!bo.isNullOrNil(str2)) {
            str = str2;
        }
        str2 = j.g(XW, XX, str3, str, "");
        AppMethodBeat.o(78214);
        return str2;
    }

    public static String si(String str) {
        AppMethodBeat.i(78215);
        String concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str));
        AppMethodBeat.o(78215);
        return concat;
    }

    public final String sj(String str) {
        AppMethodBeat.i(78216);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(78216);
            return null;
        }
        String str2 = "";
        String trim = str.trim();
        if (trim.startsWith("THUMBNAIL://")) {
            try {
                trim = ly(Integer.valueOf(trim.substring(12)).intValue()).fDB;
            } catch (NumberFormatException e) {
                ab.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                AppMethodBeat.o(78216);
                return null;
            }
        } else if (trim.startsWith("THUMBNAIL_DIRPATH://")) {
            trim = trim.substring(23);
            str2 = "th_";
        }
        str2 = q(trim, str2, "");
        AppMethodBeat.o(78216);
        return str2;
    }

    public final String a(byte[] bArr, boolean z, CompressFormat compressFormat) {
        AppMethodBeat.i(78217);
        String a = a(bArr, z, compressFormat, false);
        AppMethodBeat.o(78217);
        return a;
    }

    public final String a(byte[] bArr, CompressFormat compressFormat) {
        AppMethodBeat.i(78218);
        if (bo.cb(bArr)) {
            ab.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            AppMethodBeat.o(78218);
            return null;
        }
        String agW = agW();
        ab.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = %s", q(agW, "th_", ""));
        try {
            d.a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length), 100, compressFormat, q(agW, "th_", ""), true);
            agW = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
            AppMethodBeat.o(78218);
            return agW;
        } catch (IOException e) {
            ab.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e);
            agW = a(bArr, true, compressFormat);
            AppMethodBeat.o(78218);
            return agW;
        } catch (Exception e2) {
            ab.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e2);
            agW = a(bArr, true, compressFormat);
            AppMethodBeat.o(78218);
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
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
            com.tencent.mm.vfs.e.deleteFile(r14);
     */
    /* JADX WARNING: Missing block: B:84:?, code skipped:
            r5.close();
     */
    /* JADX WARNING: Missing block: B:93:0x0278, code skipped:
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
            com.tencent.mm.vfs.e.deleteFile(r14);
     */
    /* JADX WARNING: Missing block: B:96:?, code skipped:
            r8.close();
     */
    /* JADX WARNING: Missing block: B:116:0x02c2, code skipped:
            r4 = e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String a(byte[] bArr, CompressFormat compressFormat, String str, boolean z) {
        String str2;
        OutputStream outputStream;
        OutputStream L;
        com.tencent.mm.plugin.report.service.h hVar;
        Object[] objArr;
        String concat;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th2;
        IOException e;
        AppMethodBeat.i(78219);
        if (bo.cb(bArr)) {
            ab.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            AppMethodBeat.o(78219);
            return null;
        }
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        String agW = agW();
        String q = q(agW, "th_", "");
        str2 = q + ".tmp";
        ab.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = ".concat(String.valueOf(q)));
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
            L = e.L(str2, false);
            try {
                Bitmap createScaledBitmap;
                Bitmap createBitmap;
                L.write(bArr);
                L.flush();
                Bitmap decodeByteArray = d.decodeByteArray(bArr, i, i3);
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
                                        ab.e("MicroMsg.ImgInfoStorage", "compress bitmap failed.");
                                        if (byteArrayOutputStream2 != null) {
                                            byteArrayOutputStream2.close();
                                        }
                                        d.a(createBitmap, i3, compressFormat, q, true);
                                        ab.d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d", str2, q, Integer.valueOf(i3));
                                        hVar = com.tencent.mm.plugin.report.service.h.pYm;
                                        objArr = new Object[10];
                                        objArr[0] = q.encode(bo.nullAsNil(str), "UTF-8");
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
                                        hVar.e(16498, objArr);
                                        if (e.ct(str2)) {
                                        }
                                        if (L != null) {
                                        }
                                        concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
                                        AppMethodBeat.o(78219);
                                        return concat;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                        AppMethodBeat.o(78219);
                                        throw th;
                                    }
                                }
                            }
                            byteArrayOutputStream2.close();
                            i3 = i2;
                        } catch (Exception e3) {
                            ab.e("MicroMsg.ImgInfoStorage", "compress bitmap failed.");
                            if (byteArrayOutputStream2 != null) {
                            }
                            d.a(createBitmap, i3, compressFormat, q, true);
                            ab.d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d", str2, q, Integer.valueOf(i3));
                            hVar = com.tencent.mm.plugin.report.service.h.pYm;
                            objArr = new Object[10];
                            objArr[0] = q.encode(bo.nullAsNil(str), "UTF-8");
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
                            hVar.e(16498, objArr);
                            if (e.ct(str2)) {
                            }
                            if (L != null) {
                            }
                            concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
                            AppMethodBeat.o(78219);
                            return concat;
                        }
                    } catch (Exception e4) {
                        byteArrayOutputStream2 = null;
                        ab.e("MicroMsg.ImgInfoStorage", "compress bitmap failed.");
                        if (byteArrayOutputStream2 != null) {
                        }
                        d.a(createBitmap, i3, compressFormat, q, true);
                        ab.d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d", str2, q, Integer.valueOf(i3));
                        hVar = com.tencent.mm.plugin.report.service.h.pYm;
                        objArr = new Object[10];
                        objArr[0] = q.encode(bo.nullAsNil(str), "UTF-8");
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
                        hVar.e(16498, objArr);
                        if (e.ct(str2)) {
                        }
                        if (L != null) {
                        }
                        concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
                        AppMethodBeat.o(78219);
                        return concat;
                    } catch (Throwable th22) {
                        th = th22;
                        byteArrayOutputStream = null;
                        if (byteArrayOutputStream != null) {
                        }
                        AppMethodBeat.o(78219);
                        throw th;
                    }
                    d.a(createBitmap, i3, compressFormat, q, true);
                    ab.d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d", str2, q, Integer.valueOf(i3));
                    hVar = com.tencent.mm.plugin.report.service.h.pYm;
                    objArr = new Object[10];
                    objArr[0] = q.encode(bo.nullAsNil(str), "UTF-8");
                    objArr[1] = Integer.valueOf(z ? 1 : 0);
                    objArr[2] = Integer.valueOf(length);
                    objArr[3] = Integer.valueOf(options.outHeight);
                    objArr[4] = Integer.valueOf(options.outWidth);
                    objArr[5] = Integer.valueOf(length2);
                    objArr[6] = Integer.valueOf(createBitmap.getHeight());
                    objArr[7] = Integer.valueOf(createBitmap.getWidth());
                    objArr[8] = Integer.valueOf(1);
                    objArr[9] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                    hVar.e(16498, objArr);
                }
            } catch (Exception e5) {
            } catch (IOException e6) {
            }
            if (e.ct(str2)) {
                ab.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                e.deleteFile(str2);
            }
            if (L != null) {
                try {
                    L.close();
                } catch (Exception e7) {
                }
            }
            concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
            AppMethodBeat.o(78219);
            return concat;
        } catch (IOException e8) {
            e = e8;
        } catch (Exception e9) {
            Exception e10 = e9;
            L = null;
            try {
                ab.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e10);
                concat = a(bArr, true, compressFormat);
                if (e.ct(str2)) {
                }
                if (L != null) {
                }
                AppMethodBeat.o(78219);
                return concat;
            } catch (Throwable th4) {
                th22 = th4;
                if (e.ct(str2)) {
                }
                if (L != null) {
                }
                AppMethodBeat.o(78219);
                throw th22;
            }
        } catch (Throwable th5) {
            th22 = th5;
            L = null;
            if (e.ct(str2)) {
                ab.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                e.deleteFile(str2);
            }
            if (L != null) {
                try {
                    L.close();
                } catch (Exception e11) {
                }
            }
            AppMethodBeat.o(78219);
            throw th22;
        }
        try {
            ab.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e);
            concat = a(bArr, true, compressFormat);
            if (e.ct(str2)) {
            }
            if (outputStream != null) {
            }
            AppMethodBeat.o(78219);
            return concat;
        } catch (Throwable th6) {
            th22 = th6;
            L = outputStream;
            if (e.ct(str2)) {
            }
            if (L != null) {
            }
            AppMethodBeat.o(78219);
            throw th22;
        }
        AppMethodBeat.o(78219);
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
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
            com.tencent.mm.vfs.e.deleteFile(r13);
     */
    /* JADX WARNING: Missing block: B:80:?, code skipped:
            r8.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String a(byte[] bArr, CompressFormat compressFormat, int i, int i2, String str, boolean z) {
        String str2;
        OutputStream outputStream;
        OutputStream L;
        String concat;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th2;
        IOException e;
        AppMethodBeat.i(78220);
        if (bo.cb(bArr)) {
            ab.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            AppMethodBeat.o(78220);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String agW = agW();
        String q = q(agW, "th_", "");
        str2 = q + ".tmp";
        ab.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = ".concat(String.valueOf(q)));
        int length = bArr.length;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        outputStream = null;
        try {
            L = e.L(str2, false);
            try {
                L.write(bArr);
                L.flush();
                Bitmap decodeByteArray = d.decodeByteArray(bArr, i, i2);
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
                                            ab.e("MicroMsg.ImgInfoStorage", "compress bitmap failed.");
                                            if (byteArrayOutputStream2 != null) {
                                                byteArrayOutputStream2.close();
                                            }
                                            d.a(decodeByteArray, i3, compressFormat, q, true);
                                            ab.d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d", str2, q, Integer.valueOf(i3));
                                            com.tencent.mm.plugin.report.service.h.pYm.e(16498, q.encode(bo.nullAsNil(str), "UTF-8"), Boolean.valueOf(z), Integer.valueOf(length), Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth), Integer.valueOf(length2), Integer.valueOf(decodeByteArray.getHeight()), Integer.valueOf(decodeByteArray.getWidth()), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                            if (e.ct(str2)) {
                                            }
                                            if (L != null) {
                                            }
                                            concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
                                            AppMethodBeat.o(78220);
                                            return concat;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            byteArrayOutputStream = byteArrayOutputStream2;
                                            if (byteArrayOutputStream != null) {
                                                byteArrayOutputStream.close();
                                            }
                                            AppMethodBeat.o(78220);
                                            throw th;
                                        }
                                    }
                                }
                                byteArrayOutputStream2.close();
                                i3 = i4;
                            } catch (Exception e3) {
                                ab.e("MicroMsg.ImgInfoStorage", "compress bitmap failed.");
                                if (byteArrayOutputStream2 != null) {
                                }
                                d.a(decodeByteArray, i3, compressFormat, q, true);
                                ab.d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d", str2, q, Integer.valueOf(i3));
                                com.tencent.mm.plugin.report.service.h.pYm.e(16498, q.encode(bo.nullAsNil(str), "UTF-8"), Boolean.valueOf(z), Integer.valueOf(length), Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth), Integer.valueOf(length2), Integer.valueOf(decodeByteArray.getHeight()), Integer.valueOf(decodeByteArray.getWidth()), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                if (e.ct(str2)) {
                                }
                                if (L != null) {
                                }
                                concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
                                AppMethodBeat.o(78220);
                                return concat;
                            }
                        } catch (Exception e4) {
                            byteArrayOutputStream2 = null;
                            ab.e("MicroMsg.ImgInfoStorage", "compress bitmap failed.");
                            if (byteArrayOutputStream2 != null) {
                            }
                            d.a(decodeByteArray, i3, compressFormat, q, true);
                            ab.d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d", str2, q, Integer.valueOf(i3));
                            com.tencent.mm.plugin.report.service.h.pYm.e(16498, q.encode(bo.nullAsNil(str), "UTF-8"), Boolean.valueOf(z), Integer.valueOf(length), Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth), Integer.valueOf(length2), Integer.valueOf(decodeByteArray.getHeight()), Integer.valueOf(decodeByteArray.getWidth()), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            if (e.ct(str2)) {
                            }
                            if (L != null) {
                            }
                            concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
                            AppMethodBeat.o(78220);
                            return concat;
                        } catch (Throwable th22) {
                            th = th22;
                            byteArrayOutputStream = null;
                            if (byteArrayOutputStream != null) {
                            }
                            AppMethodBeat.o(78220);
                            throw th;
                        }
                        d.a(decodeByteArray, i3, compressFormat, q, true);
                    } else {
                        e.aQ(str2, q);
                    }
                    ab.d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d", str2, q, Integer.valueOf(i3));
                    com.tencent.mm.plugin.report.service.h.pYm.e(16498, q.encode(bo.nullAsNil(str), "UTF-8"), Boolean.valueOf(z), Integer.valueOf(length), Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth), Integer.valueOf(length2), Integer.valueOf(decodeByteArray.getHeight()), Integer.valueOf(decodeByteArray.getWidth()), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            } catch (Exception e5) {
            } catch (IOException e6) {
            }
            if (e.ct(str2)) {
                ab.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                e.deleteFile(str2);
            }
            if (L != null) {
                try {
                    L.close();
                } catch (Exception e7) {
                }
            }
            concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
            AppMethodBeat.o(78220);
            return concat;
        } catch (IOException e8) {
            e = e8;
        } catch (Exception e9) {
            Exception e10 = e9;
            L = null;
            try {
                ab.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e10);
                concat = a(bArr, true, compressFormat);
                if (e.ct(str2)) {
                }
                if (L != null) {
                }
                AppMethodBeat.o(78220);
                return concat;
            } catch (Throwable th4) {
                th22 = th4;
                if (e.ct(str2)) {
                    ab.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                    e.deleteFile(str2);
                }
                if (L != null) {
                    try {
                        L.close();
                    } catch (Exception e11) {
                    }
                }
                AppMethodBeat.o(78220);
                throw th22;
            }
        } catch (Throwable th5) {
            th22 = th5;
            L = null;
            if (e.ct(str2)) {
            }
            if (L != null) {
            }
            AppMethodBeat.o(78220);
            throw th22;
        }
        try {
            ab.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e);
            concat = a(bArr, true, compressFormat);
            if (e.ct(str2)) {
                ab.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                e.deleteFile(str2);
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e12) {
                }
            }
            AppMethodBeat.o(78220);
            return concat;
        } catch (Throwable th6) {
            th22 = th6;
            L = outputStream;
            if (e.ct(str2)) {
            }
            if (L != null) {
            }
            AppMethodBeat.o(78220);
            throw th22;
        }
        AppMethodBeat.o(78220);
        return concat;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0126 A:{SYNTHETIC, Splitter:B:45:0x0126} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0126 A:{SYNTHETIC, Splitter:B:45:0x0126} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String a(byte[] bArr, boolean z, CompressFormat compressFormat, boolean z2) {
        String agW;
        String str;
        Exception e;
        OutputStream outputStream;
        Throwable th;
        AppMethodBeat.i(78221);
        if (bo.cb(bArr)) {
            ab.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            AppMethodBeat.o(78221);
            return null;
        }
        agW = agW();
        String q = q(agW, "th_", "");
        str = q + ".tmp";
        ab.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = ".concat(String.valueOf(q)));
        OutputStream outputStream2 = null;
        try {
            outputStream2 = e.L(str, false);
            try {
                Bitmap decodeFile;
                outputStream2.write(bArr);
                outputStream2.flush();
                int i = z ? 128 : 120;
                int i2 = z ? 128 : 120;
                if (z2) {
                    decodeFile = d.decodeFile(str, null);
                } else {
                    decodeFile = d.d(str, i, i2, false);
                }
                if (decodeFile != null) {
                    d.a(decodeFile, 90, compressFormat, q, true);
                    ab.d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s", str, q);
                }
                if (e.ct(str)) {
                    ab.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                    e.deleteFile(str);
                }
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (Exception e2) {
                    }
                }
                String concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
                AppMethodBeat.o(78221);
                return concat;
            } catch (Exception e3) {
                e = e3;
                outputStream = outputStream2;
            } catch (Throwable th2) {
                th = th2;
                outputStream = outputStream2;
                if (e.ct(str)) {
                    ab.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                    e.deleteFile(str);
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e4) {
                    }
                }
                AppMethodBeat.o(78221);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            outputStream = outputStream2;
        } catch (Throwable th3) {
            th = th3;
            outputStream = outputStream2;
            if (e.ct(str)) {
            }
            if (outputStream != null) {
            }
            AppMethodBeat.o(78221);
            throw th;
        }
        AppMethodBeat.o(78221);
        return null;
        try {
            com.tencent.mm.plugin.report.service.h.pYm.a(111, 189, 1, false);
            ab.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: th_" + agW + ", ex = " + e.getMessage());
            if (e.ct(str)) {
                ab.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                e.deleteFile(str);
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e6) {
                }
            }
            AppMethodBeat.o(78221);
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (e.ct(str)) {
            }
            if (outputStream != null) {
            }
            AppMethodBeat.o(78221);
            throw th;
        }
    }

    public final String W(byte[] bArr) {
        AppMethodBeat.i(78222);
        if (bo.cb(bArr)) {
            ab.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            AppMethodBeat.o(78222);
            return null;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (options.outWidth < 0 || options.outHeight < 0) {
            ab.e("MicroMsg.ImgInfoStorage", "Bad thumbBuf, perhaps it's not complete or damaged ??");
            AppMethodBeat.o(78222);
            return null;
        }
        String agW = agW();
        String q = q(agW, "th_", "");
        ab.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = ".concat(String.valueOf(q)));
        e.deleteFile(q);
        e.b(q, bArr, bArr.length);
        agW = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(agW));
        AppMethodBeat.o(78222);
        return agW;
    }

    public final String I(String str, boolean z) {
        AppMethodBeat.i(78223);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(78223);
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("THUMBNAIL://")) {
            try {
                trim = ly(Integer.valueOf(trim.substring(12)).intValue()).fDB;
            } catch (NumberFormatException e) {
                ab.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                AppMethodBeat.o(78223);
                return null;
            }
        } else if (trim.startsWith("THUMBNAIL_DIRPATH://")) {
            trim = b(trim.substring(20).substring(3), "th_", "", z);
            AppMethodBeat.o(78223);
            return trim;
        }
        trim = b(trim, "", "", z);
        AppMethodBeat.o(78223);
        return trim;
    }

    public final Bitmap a(String str, float f, boolean z) {
        AppMethodBeat.i(78225);
        Bitmap a = a(str, false, f, z, false, false, -1);
        AppMethodBeat.o(78225);
        return a;
    }

    public final boolean a(ImageView imageView, String str, float f, int i, int i2, ImageView imageView2, int i3, int i4, View view) {
        AppMethodBeat.i(78226);
        boolean a = a(imageView, str, false, f, i, i2, imageView2, i3, i4, view);
        AppMethodBeat.o(78226);
        return a;
    }

    /* JADX WARNING: Missing block: B:19:0x00af, code skipped:
            if (r6.endsWith("hd") == false) goto L_0x0316;
     */
    /* JADX WARNING: Missing block: B:20:0x00b1, code skipped:
            r8 = (android.graphics.Bitmap) r12.fEh.ai(r6);
     */
    /* JADX WARNING: Missing block: B:21:0x00ba, code skipped:
            if (r8 != null) goto L_0x0195;
     */
    /* JADX WARNING: Missing block: B:22:0x00bc, code skipped:
            a(r13, r19, r22, r6, r16);
            r6 = r6.substring(0, r6.length() - 2);
            r5 = 1;
            r2 = r8;
     */
    /* JADX WARNING: Missing block: B:23:0x00d5, code skipped:
            if (r2 != null) goto L_0x0313;
     */
    /* JADX WARNING: Missing block: B:24:0x00d7, code skipped:
            r4 = (android.graphics.Bitmap) r12.fEh.ai(r6);
     */
    /* JADX WARNING: Missing block: B:25:0x00e0, code skipped:
            if (r4 == null) goto L_0x01e7;
     */
    /* JADX WARNING: Missing block: B:27:0x00e6, code skipped:
            if (r4.isRecycled() != false) goto L_0x01e7;
     */
    /* JADX WARNING: Missing block: B:28:0x00e8, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ImgInfoStorage", "[setbitmapFromUri] bitmap width %d,height %d", java.lang.Integer.valueOf(r4.getWidth()), java.lang.Integer.valueOf(r4.getHeight()));
            r13.setBackgroundDrawable(null);
            com.tencent.mm.at.g.a.a(r4, r13);
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
            com.tencent.matrix.trace.core.AppMethodBeat.o(78227);
     */
    /* JADX WARNING: Missing block: B:58:0x01a6, code skipped:
            if (r12.fEh.remove(r6.substring(0, r6.length() - 2)) == null) goto L_0x01b9;
     */
    /* JADX WARNING: Missing block: B:59:0x01a8, code skipped:
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ImgInfoStorage", "remove low quality thumb from cacheMap, path: ".concat(java.lang.String.valueOf(r6)));
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
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", java.lang.Integer.valueOf(r3));
            r4 = (int) (60.0f * r16);
     */
    /* JADX WARNING: Missing block: B:90:0x0249, code skipped:
            if (((float) r2) >= (60.0f * r16)) goto L_0x0263;
     */
    /* JADX WARNING: Missing block: B:91:0x024b, code skipped:
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", java.lang.Integer.valueOf(r2));
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
            a(r13, r19, r22, r6, r16);
     */
    /* JADX WARNING: Missing block: B:100:0x0285, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(78227);
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
    public final boolean a(ImageView imageView, String str, boolean z, float f, int i, int i2, ImageView imageView2, int i3, int i4, View view) {
        AppMethodBeat.i(78227);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.ImgInfoStorage", "invalid uri is %s", str);
            AppMethodBeat.o(78227);
            return false;
        }
        synchronized (this.fEo) {
            try {
                boolean containsKey = this.fEo.containsKey(str);
                Object c = c(str, z, false);
                if (bo.isNullOrNil(c)) {
                    ab.e("MicroMsg.ImgInfoStorage", "getFullThumbPathByCache uri is null, uri:%s", bo.nullAsNil(str));
                } else if (!containsKey) {
                    if (!c.endsWith("hd") && e.ct(c + "hd")) {
                        this.fEo.put(str, c + "hd");
                        c = c + "hd";
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(78227);
            }
        }
        return false;
    }

    private void a(ImageView imageView, ImageView imageView2, View view, String str, float f) {
        int hashCode;
        int i;
        AppMethodBeat.i(78228);
        int hashCode2 = str.hashCode();
        int hashCode3 = imageView.hashCode();
        for (b bVar : this.fEj) {
            if (hashCode3 == bVar.fEz) {
                ab.i("MicroMsg.ImgInfoStorage", "setbitmapFromUri  [%d, %s] ", Integer.valueOf(bVar.fEz), bVar.url);
                bVar.url = str;
                if (!this.fEn.contains(Integer.valueOf(hashCode2))) {
                    this.fEn.add(Integer.valueOf(hashCode2));
                    f(str, f);
                }
                AppMethodBeat.o(78228);
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
        this.fEj.add(new b(hashCode3, str, i, hashCode));
        if (!this.fEn.contains(Integer.valueOf(hashCode2))) {
            this.fEn.add(Integer.valueOf(hashCode2));
            f(str, f);
        }
        AppMethodBeat.o(78228);
    }

    private void f(String str, float f) {
        AppMethodBeat.i(78229);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RS().aa(new AnonymousClass2(str, f, true, R.drawable.b0p));
        AppMethodBeat.o(78229);
    }

    public final Bitmap b(String str, float f, boolean z) {
        AppMethodBeat.i(78230);
        Bitmap a = a(str, true, f, z, true, false, 0);
        AppMethodBeat.o(78230);
        return a;
    }

    public final Bitmap a(String str, boolean z, float f, boolean z2, boolean z3, boolean z4, int i) {
        AppMethodBeat.i(78231);
        Bitmap a = a(str, z, f, z2, z3, z4, i, true);
        AppMethodBeat.o(78231);
        return a;
    }

    private Bitmap a(String str, boolean z, float f, boolean z2, boolean z3, boolean z4, int i, boolean z5) {
        AppMethodBeat.i(78232);
        Bitmap a = a(str, z, f, z2, z3, z4, i, z5, null);
        AppMethodBeat.o(78232);
        return a;
    }

    private Bitmap a(String str, boolean z, float f, boolean z2, boolean z3, boolean z4, int i, boolean z5, Bitmap bitmap) {
        Object str2;
        AppMethodBeat.i(78233);
        if (!z) {
            str2 = c(str2, false, true);
        }
        if (str2 == null) {
            AppMethodBeat.o(78233);
            return null;
        }
        String str3;
        String str4;
        Object[] objArr;
        Bitmap bitmap2 = null;
        Object obj = (bitmap == null || bitmap.isRecycled()) ? null : 1;
        if (z5) {
            bitmap2 = (Bitmap) this.fEh.ai(str2);
            if (bitmap2 == null) {
                str3 = "MicroMsg.ImgInfoStorage";
                str4 = "bm is null:%b,  url:%s";
                objArr = new Object[2];
                objArr[0] = Boolean.valueOf(bitmap2 == null);
                objArr[1] = str2;
                ab.b(str3, str4, objArr);
            }
        }
        if (bitmap2 == null || bitmap2.isRecycled() || obj != null) {
            Bitmap bitmap3;
            bo.anU();
            if (obj != null) {
                bitmap3 = bitmap;
            } else {
                bitmap3 = d.j(str2, f);
            }
            if (bitmap3 == null) {
                bitmap3 = x.vv(str2);
            }
            if (bitmap3 != null) {
                Bitmap createScaledBitmap;
                long currentTimeMillis = System.currentTimeMillis();
                int width = bitmap3.getWidth();
                int height = bitmap3.getHeight();
                if (z3) {
                    if (fEg == 0) {
                        fEg = com.tencent.mm.bz.a.am(ah.getContext(), R.dimen.a1h);
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
                        ab.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", Integer.valueOf(width));
                        width = (int) (60.0f * f);
                    }
                    if (((float) height) < 60.0f * f) {
                        ab.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", Integer.valueOf(height));
                        height = (int) (60.0f * f);
                    }
                    Context context = ah.getContext();
                    int[] iArr = new int[2];
                    float f3;
                    if (height >= width) {
                        f3 = ((float) height) / ((float) width);
                        if (f3 <= 2.0f) {
                            height = com.tencent.mm.bz.a.am(context, R.dimen.eb);
                            width = (int) (((float) height) / f3);
                        } else {
                            width = com.tencent.mm.bz.a.am(context, R.dimen.ed);
                            height = (int) (((float) width) * f3);
                        }
                    } else {
                        f3 = ((float) width) / ((float) height);
                        if (f3 <= 2.0f) {
                            width = com.tencent.mm.bz.a.am(context, R.dimen.eb);
                            height = (int) (((float) width) / f3);
                        } else {
                            height = com.tencent.mm.bz.a.am(context, R.dimen.ed);
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
                    ab.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", bitmap3.toString());
                    bitmap3.recycle();
                }
                if (z4) {
                    bitmap2 = d.d(createScaledBitmap, i);
                } else if (z2) {
                    bitmap2 = d.a(createScaledBitmap, true, (float) com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 3));
                    ab.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", createScaledBitmap.toString());
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
                ab.i(str3, str4, objArr);
                if (bitmap2 != null && obj == null) {
                    this.fEh.k(str2, bitmap2);
                }
            } else {
                ab.e("MicroMsg.ImgInfoStorage", "img maybe delete, %s, %s", str2, Boolean.valueOf(FileOp.ct(str2)));
            }
        }
        AppMethodBeat.o(78233);
        return bitmap2;
    }

    public final Bitmap sk(String str) {
        AppMethodBeat.i(78234);
        Bitmap j = d.j(c(str, false, true), com.tencent.mm.bz.a.getDensity(ah.getContext()));
        AppMethodBeat.o(78234);
        return j;
    }

    public final Bitmap a(String str, float f, Context context) {
        AppMethodBeat.i(78235);
        Bitmap a = a(str, f, context, -1);
        AppMethodBeat.o(78235);
        return a;
    }

    public final Bitmap a(String str, float f, Context context, int i) {
        AppMethodBeat.i(78236);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(78236);
            return null;
        }
        String trim = str.trim();
        Bitmap bitmap = (Bitmap) this.fEh.ai(trim);
        if (bitmap == null || bitmap.isRecycled()) {
            Bitmap i2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.i(trim, f);
            if (i2 != null) {
                int b;
                int i3;
                int width = i2.getWidth();
                int height = i2.getHeight();
                if (width >= height) {
                    b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, (float) this.fEs);
                    i3 = (int) ((((float) height) / ((float) width)) * ((float) b));
                } else {
                    i3 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, (float) this.fEs);
                    b = (int) ((((float) width) / ((float) height)) * ((float) i3));
                }
                if (b <= 0 || i3 <= 0 || b > 2048 || i3 > 2048) {
                    ab.e("MicroMsg.ImgInfoStorage", "getVideoThumb, error Scale Size %d*%d", Integer.valueOf(b), Integer.valueOf(i3));
                    com.tencent.mm.plugin.report.service.h.pYm.a(111, 188, 1, false);
                    bitmap = null;
                } else {
                    try {
                        bitmap = Bitmap.createScaledBitmap(i2, b, i3, true);
                    } catch (Exception e) {
                        ab.e("MicroMsg.ImgInfoStorage", "getVideoThumb, Bitmap.createScaledBitmap Exception:%s", e.getMessage());
                        bitmap = null;
                        com.tencent.mm.plugin.report.service.h.pYm.a(111, 188, 1, false);
                    }
                }
                if (i != -1) {
                    bitmap = d.d(bitmap, i);
                }
                if (i2 != bitmap) {
                    ab.i("MicroMsg.ImgInfoStorage", "[getVideoThumb] bitmap:%s", i2.toString());
                    i2.recycle();
                }
                ab.d("MicroMsg.ImgInfoStorage", "cached file ".concat(String.valueOf(trim)));
                this.fEh.k(trim, bitmap);
            } else {
                bitmap = i2;
            }
        }
        AppMethodBeat.o(78236);
        return bitmap;
    }

    public final e b(Long l) {
        AppMethodBeat.i(78238);
        e eVar = new e();
        Cursor a = a("ImgInfo2", null, "id=?", new String[]{String.valueOf(l)});
        if (a != null && a.moveToFirst()) {
            eVar.d(a);
        }
        a.close();
        AppMethodBeat.o(78238);
        return eVar;
    }

    private e X(String str, int i) {
        AppMethodBeat.i(78239);
        e eVar = new e();
        Cursor a = a("ImgInfo2", null, "origImgMD5=? AND compressType=?", new String[]{String.valueOf(str), String.valueOf(i)});
        if (a.moveToFirst()) {
            eVar.d(a);
        }
        a.close();
        AppMethodBeat.o(78239);
        return eVar;
    }

    public final List<e> agV() {
        List<e> list = null;
        AppMethodBeat.i(78240);
        Cursor a = this.fni.a(("select * " + " FROM ImgInfo2") + " WHERE iscomplete= 0 AND totalLen != 0 ", null, 0);
        if (a.moveToFirst()) {
            list = new ArrayList();
            do {
                e eVar = new e();
                eVar.d(a);
                e lz = lz((int) eVar.fDy);
                if (lz != null) {
                    if (!(lz.cKK == 0 && lz.fDH == 0)) {
                        list.add(eVar);
                    }
                } else if (!(eVar.cKK == 0 && eVar.fDH == 0)) {
                    list.add(eVar);
                }
            } while (a.moveToNext());
            a.close();
            AppMethodBeat.o(78240);
        } else {
            a.close();
            AppMethodBeat.o(78240);
        }
        return list;
    }

    public final void x(bi biVar) {
        AppMethodBeat.i(78241);
        e w = w(biVar);
        if (w == null || w.fDy == 0) {
            ab.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
            AppMethodBeat.o(78241);
            return;
        }
        e.deleteFile(q(w.fDz, "", ""));
        e.deleteFile(q(w.fDE, "", ""));
        e.deleteFile(q(w.fDB, "", ""));
        e.deleteFile(q(w.fDB, "", "") + "hd");
        this.fni.delete("ImgInfo2", "id=?", new String[]{w.fDy});
        if (w.agQ()) {
            w = ly(w.fDJ);
            if (w == null) {
                AppMethodBeat.o(78241);
                return;
            }
            e.deleteFile(q(w.fDz, "", ""));
            e.deleteFile(q(w.fDE, "", ""));
            e.deleteFile(q(w.fDB, "", ""));
            e.deleteFile(q(w.fDB, "", "") + "hd");
            this.fni.delete("ImgInfo2", "id=?", new String[]{w.fDy});
        }
        AppMethodBeat.o(78241);
    }

    public final String d(e eVar) {
        String str = null;
        AppMethodBeat.i(78242);
        if (eVar == null) {
            AppMethodBeat.o(78242);
        } else if (eVar.agQ()) {
            Cursor b = b("ImgInfo2", new String[]{"bigImgPath"}, "id=? and totalLen = offset", new String[]{eVar.fDJ});
            if (b.moveToFirst()) {
                str = b.getString(0);
            }
            b.close();
            AppMethodBeat.o(78242);
        } else {
            AppMethodBeat.o(78242);
        }
        return str;
    }

    public final HashMap<Long, e> a(Long... lArr) {
        AppMethodBeat.i(78243);
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
        Cursor b = b("ImgInfo2", null, "msgSvrId in ".concat(String.valueOf(str + ")")), null);
        HashMap hashMap = new HashMap();
        while (b.moveToNext()) {
            e eVar = new e();
            eVar.d(b);
            hashMap.put(Long.valueOf(eVar.cKK), eVar);
        }
        b.close();
        AppMethodBeat.o(78243);
        return hashMap;
    }

    public final HashMap<Long, e> b(Long... lArr) {
        AppMethodBeat.i(78244);
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
        Cursor b = b("ImgInfo2", null, "msglocalid in ".concat(String.valueOf(str + ")")), null);
        HashMap hashMap = new HashMap();
        while (b.moveToNext()) {
            e eVar = new e();
            eVar.d(b);
            hashMap.put(Long.valueOf(eVar.cKK), eVar);
        }
        b.close();
        AppMethodBeat.o(78244);
        return hashMap;
    }

    public final e ly(int i) {
        AppMethodBeat.i(78245);
        e b = b(Long.valueOf((long) i));
        AppMethodBeat.o(78245);
        return b;
    }

    public final e fI(long j) {
        AppMethodBeat.i(78246);
        e eVar = new e();
        Cursor b = b("ImgInfo2", null, "msgSvrId=?", new String[]{String.valueOf(j)});
        if (b.moveToFirst()) {
            eVar.d(b);
        }
        b.close();
        AppMethodBeat.o(78246);
        return eVar;
    }

    public final e fJ(long j) {
        AppMethodBeat.i(78247);
        e eVar = new e();
        Cursor b = b("ImgInfo2", null, "msglocalid=?", new String[]{String.valueOf(j)});
        if (b.moveToLast()) {
            eVar.d(b);
        }
        b.close();
        AppMethodBeat.o(78247);
        return eVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final e lz(int i) {
        e eVar;
        Exception e;
        Throwable th;
        AppMethodBeat.i(78248);
        Cursor b;
        try {
            b = b("ImgInfo2", null, "reserved1=?", new String[]{String.valueOf(i)});
            if (b != null) {
                try {
                    if (b.moveToFirst()) {
                        eVar = new e();
                        try {
                            eVar.d(b);
                            if (b != null) {
                                b.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                ab.w("MicroMsg.ImgInfoStorage", "Exception :%s", e.toString());
                                if (b != null) {
                                    b.close();
                                }
                                AppMethodBeat.o(78248);
                                return eVar;
                            } catch (Throwable th2) {
                                th = th2;
                                if (b != null) {
                                }
                                AppMethodBeat.o(78248);
                                throw th;
                            }
                        }
                        AppMethodBeat.o(78248);
                        return eVar;
                    }
                } catch (Exception e3) {
                    e = e3;
                    eVar = null;
                    ab.w("MicroMsg.ImgInfoStorage", "Exception :%s", e.toString());
                    if (b != null) {
                    }
                    AppMethodBeat.o(78248);
                    return eVar;
                }
            }
            eVar = null;
            if (b != null) {
            }
        } catch (Exception e4) {
            e = e4;
            eVar = null;
            b = null;
        } catch (Throwable th3) {
            th = th3;
            b = null;
            if (b != null) {
                b.close();
            }
            AppMethodBeat.o(78248);
            throw th;
        }
        AppMethodBeat.o(78248);
        return eVar;
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2) {
        AppMethodBeat.i(78249);
        Cursor query = this.fni.query(str, strArr, str2, strArr2, null, null, null);
        AppMethodBeat.o(78249);
        return query;
    }

    private Cursor b(String str, String[] strArr, String str2, String[] strArr2) {
        AppMethodBeat.i(78250);
        Cursor a = a(str, strArr, str2, strArr2);
        AppMethodBeat.o(78250);
        return a;
    }

    public final long a(String str, int i, int i2, PString pString, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(78251);
        long a = a(str, i, i2, 0, pString, pInt, pInt2, "", "", -1, null, null, null);
        AppMethodBeat.o(78251);
        return a;
    }

    public final long a(String str, int i, int i2, int i3, PString pString, PInt pInt, PInt pInt2, String str2, String str3, long j, com.tencent.mm.a.b bVar, com.tencent.mm.a.b bVar2, com.tencent.mm.at.n.a aVar) {
        AppMethodBeat.i(78252);
        long a = a(str, null, i, i2, i3, pString, pInt, pInt2, str2, str3, j, bVar, bVar2, aVar);
        AppMethodBeat.o(78252);
        return a;
    }

    /* Access modifiers changed, original: final */
    public final long a(String str, String str2, int i, int i2, int i3, PString pString, PInt pInt, PInt pInt2, String str3, String str4, long j, com.tencent.mm.a.b bVar, com.tencent.mm.a.b bVar2, com.tencent.mm.at.n.a aVar) {
        AppMethodBeat.i(78253);
        long e;
        if (i == 0) {
            e a = a(str, 0, true, i2, i3, pInt, pInt2, pString.value, j, str3, str4, bVar2, bVar, aVar);
            if (a == null) {
                AppMethodBeat.o(78253);
                return -1;
            }
            pString.value = a.fDB;
            if (e.ct(str2)) {
                String IP = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.c.class)).IP(a.fDz);
                e.y(str2, q(IP, "", ""));
                a.sf(IP);
            }
            e = e(a);
            if (e != -1) {
                doNotify();
            }
            AppMethodBeat.o(78253);
            return e;
        } else if (i == 1) {
            e a2 = a(str, 1, true, i2, i3, pInt, pInt2, pString.value, j, str3, str4, bVar2, bVar, aVar);
            if (a2 == null) {
                AppMethodBeat.o(78253);
                return -1;
            }
            pString.value = a2.fDB;
            a2.fG(0);
            a2.eI(0);
            a2.lt((int) e.asZ(q(a2.fDz, "", "")));
            e a3 = a(str, 0, false, i2, i3, new PInt(), new PInt(), "", j, str3, str4, bVar2, bVar, aVar);
            if (a3 == null) {
                AppMethodBeat.o(78253);
                return 0;
            }
            a3.sb(a2.fDz);
            a3.sd(a2.fDB);
            a3.sc(a2.fDA);
            a3.lt(0);
            long iV = this.fni.iV(Thread.currentThread().getId());
            a3.lu((int) e(a2));
            e = e(a3);
            ab.d("MicroMsg.ImgInfoStorage", "summersafecdn insert ret[%d],  getLocalId[%d], getMsgLocalId[%d], getBigImgPath[%s], getMidImgPath[%s], getTotalLen[%d]", Long.valueOf(e), Long.valueOf(a3.fDy), Long.valueOf(a3.fDH), a3.fDz, a3.fDA, Integer.valueOf(a3.frO));
            if (iV > 0) {
                com.tencent.mm.kernel.g.RP().eJN.mB(iV);
            }
            if (e != -1) {
                doNotify();
            }
            AppMethodBeat.o(78253);
            return e;
        } else {
            Assert.assertTrue(false);
            AppMethodBeat.o(78253);
            return 0;
        }
    }

    public final long e(e eVar) {
        AppMethodBeat.i(78254);
        long insert = this.fni.insert("ImgInfo2", "id", eVar.Hl());
        if (insert != -1) {
            eVar.agS();
        }
        ab.i("MicroMsg.ImgInfoStorage", "insert img, result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", Long.valueOf(insert), Long.valueOf(eVar.fDy), Long.valueOf(eVar.fDH), Long.valueOf(eVar.cKK), Integer.valueOf(eVar.fDJ));
        AppMethodBeat.o(78254);
        return insert;
    }

    public final String sl(String str) {
        AppMethodBeat.i(78255);
        String b = b("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str)), "th_", "", false);
        AppMethodBeat.o(78255);
        return b;
    }

    public final String sm(String str) {
        AppMethodBeat.i(78256);
        String b = b(str, "", FileUtils.PIC_POSTFIX_JPEG, false);
        AppMethodBeat.o(78256);
        return b;
    }

    private String Y(String str, int i) {
        AppMethodBeat.i(78257);
        e X = X(f.sh(str), i);
        if (!bo.isNullOrNil(X.fDB)) {
            String I = I(X.fDB, true);
            if (e.ct(I)) {
                AppMethodBeat.o(78257);
                return I;
            }
        }
        AppMethodBeat.o(78257);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Bitmap a(String str, int i, int i2, PInt pInt, PInt pInt2, boolean z, String str2, com.tencent.mm.a.b bVar) {
        Bitmap ar;
        AppMethodBeat.i(78258);
        ab.d("MicroMsg.ImgInfoStorage", "summersafecdn getPreSendBitmap origPath[%s], compressType[%d],needSave[%b], stack[%s], thumbPath: %s", str, Integer.valueOf(i), Boolean.valueOf(z), bo.dpG(), str2);
        Bitmap bitmap = (Bitmap) this.fEh.ai(f.sh(str));
        String str3 = null;
        if (bitmap == null || bitmap.isRecycled()) {
            String str4;
            str3 = Y(str, i);
            if (bo.isNullOrNil(str3)) {
                str4 = str;
            } else if (str3.endsWith("hd")) {
                str4 = str3;
            } else {
                bitmap = d.aml(str3);
                str4 = str;
            }
            if (bitmap == null || bitmap.isRecycled()) {
                int amy = ad.amy(str4);
                int bJ = ExifHelper.bJ(str4) + (i2 * 90);
                if (amy > 0) {
                    ar = ad.ar(str4, amy, bJ);
                } else {
                    ar = d.ao(str4, 120, 120);
                }
                if (ar != null) {
                    this.fEh.k(f.sh(str), ar);
                    pInt.value = ar.getWidth();
                    pInt2.value = ar.getHeight();
                    if (z) {
                        String Y;
                        if (str3 == null) {
                            Y = Y(str, i);
                        } else {
                            Y = str3;
                        }
                        if (!bo.isNullOrNil(Y) && Y.endsWith("hd")) {
                            Y = Y.substring(0, Y.length() - 2);
                        }
                        if (bVar != null) {
                            bVar.getFile();
                        }
                        if (bo.isNullOrNil(Y) || !e.ct(Y)) {
                            try {
                                Object obj = (bo.isNullOrNil(Y) || !Y.endsWith("hd")) ? null : 1;
                                d.a(ar, obj != null ? 80 : 90, CompressFormat.JPEG, str2, false);
                            } catch (IOException e) {
                            }
                        } else {
                            e.y(Y, str2);
                            ab.i("MicroMsg.ImgInfoStorage", "copy from old thumbPath %s", Y);
                        }
                    }
                }
                AppMethodBeat.o(78258);
                return ar;
            }
        }
        ar = bitmap;
        if (ar != null) {
        }
        AppMethodBeat.o(78258);
        return ar;
    }

    public final String a(String str, int i, PString pString, PInt pInt, PInt pInt2, int i2, String str2) {
        AppMethodBeat.i(78259);
        if (e.ct(str)) {
            Object obj;
            if (bo.isNullOrNil(str2)) {
                str2 = agW();
            }
            String concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str2));
            String b = b(concat, "th_", "", false);
            pString.value = concat;
            long yz = bo.yz();
            Bitmap a = a(str, i, i2, pInt, pInt2, false, null, null);
            concat = (String) this.fEi.get(str);
            if (concat != null) {
                obj = (Bitmap) this.fEh.get(concat);
            } else {
                obj = null;
            }
            if (obj == null || obj.isRecycled()) {
                obj = a(str, true, com.tencent.mm.bz.a.getDensity(ah.getContext()), false, false, true, (int) R.drawable.b0p, true, a);
                this.fEi.put(str, b);
            }
            if (obj != null) {
                this.fEh.k(b, obj);
            }
            ab.i("MicroMsg.ImgInfoStorage", "test decode thumb img:%d", Long.valueOf(bo.az(yz)));
            AppMethodBeat.o(78259);
            return str2;
        }
        ab.e("MicroMsg.ImgInfoStorage", "file not exit:%s", str);
        AppMethodBeat.o(78259);
        return null;
    }

    public static synchronized String agW() {
        String sn;
        synchronized (g.class) {
            AppMethodBeat.i(78260);
            sn = sn("");
            AppMethodBeat.o(78260);
        }
        return sn;
    }

    private static synchronized String sn(String str) {
        synchronized (g.class) {
            AppMethodBeat.i(78261);
            long currentTimeMillis = System.currentTimeMillis();
            if (fEt == currentTimeMillis) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
                currentTimeMillis = System.currentTimeMillis();
            }
            fEt = currentTimeMillis;
            ab.i("MicroMsg.ImgInfoStorage", "generateMd5: %s, %s", com.tencent.mm.a.g.x((str + currentTimeMillis).getBytes()), Long.valueOf(currentTimeMillis));
            AppMethodBeat.o(78261);
        }
        return r3;
    }

    private String a(String str, int i, boolean z, int i2, PInt pInt, PInt pInt2, String str2, String str3, com.tencent.mm.a.b bVar) {
        AppMethodBeat.i(78262);
        ab.i("MicroMsg.ImgInfoStorage", "genThumbImg, orig:%s", str);
        if (e.ct(str)) {
            Object str32;
            if (bo.isNullOrNil(str32)) {
                str32 = agW();
            }
            String concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str32));
            String b = b(concat, "th_", "", false);
            if (bVar == null) {
                b = q(concat, "th_", "");
            }
            if (z) {
                if (bo.isNullOrNil(str2) || !e.ct(str2)) {
                    long yz = bo.yz();
                    a(str, i, i2, pInt, pInt2, true, b, bVar);
                    if (e.ct(b)) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(10921, Long.valueOf(e.asZ(b)), Long.valueOf(e.asZ(str)), Integer.valueOf(90), Long.valueOf(bo.az(yz)));
                    } else {
                        ab.e("MicroMsg.ImgInfoStorage", " thumbImg not exits");
                    }
                } else {
                    e.y(str2, b);
                }
                ab.d("MicroMsg.ImgInfoStorage", "insert: thumbName = ".concat(String.valueOf(concat)));
            }
            AppMethodBeat.o(78262);
            return concat;
        }
        ab.e("MicroMsg.ImgInfoStorage", "file not exit:%s", str);
        AppMethodBeat.o(78262);
        return null;
    }

    public final String a(String str, String str2, int i, boolean z, PString pString, PString pString2, PString pString3, PString pString4, String str3, com.tencent.mm.a.b bVar) {
        String q;
        String str4;
        int i2;
        int i3;
        int indexOf;
        int i4;
        boolean z2;
        boolean z3;
        int i5;
        AppMethodBeat.i(78263);
        if (bo.isNullOrNil(str3)) {
            str3 = sn(str);
            ab.i("MicroMsg.ImgInfoStorage", "generateMd5: %s, %s", str3, str);
        }
        String b = b(str3, "", FileUtils.PIC_POSTFIX_JPEG, false);
        if (bVar == null) {
            b = b(str3, "", FileUtils.PIC_POSTFIX_JPEG, true);
        }
        ab.i("MicroMsg.ImgInfoStorage", "fullPath is %s", b);
        if (e.asZ(b) > 0) {
            ab.i("MicroMsg.ImgInfoStorage", "genBigImg file already exist!");
            com.tencent.mm.plugin.report.service.h.pYm.k(944, 8, 1);
        }
        pString.value = str3;
        pString2.value = b;
        if (z && !bo.isNullOrNil(str2) && i == 0) {
            e X = X(str2, i);
            if (!bo.isNullOrNil(X.fDz)) {
                q = q(X.fDz, "", "");
                if (bVar != null) {
                    bVar.getFile();
                }
                e.y(q, b);
                if (e.asZ(q) <= 0) {
                    ab.w("MicroMsg.ImgInfoStorage", "ERR: copy old match file failed ,:%s ,%s ", str, b);
                } else if (bo.isNullOrNil(X.fDK)) {
                    AppMethodBeat.o(78263);
                    return null;
                } else {
                    str4 = X.fDK;
                    AppMethodBeat.o(78263);
                    return str4;
                }
            }
        }
        try {
            i2 = at.isWifi(ah.getContext()) ? bo.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("CompressPicLevelForWifi"), 60) : at.is2G(ah.getContext()) ? bo.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("CompressPicLevelFor2G"), 40) : at.is3G(ah.getContext()) ? bo.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("CompressPicLevelFor3G"), 40) : bo.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("CompressPicLevelFor4G"), 60);
        } catch (Exception e) {
            i2 = 0;
        }
        ab.i("MicroMsg.ImgInfoStorage", "genBigImg CompressPicLevel-level:%d", Integer.valueOf(i2));
        if (i2 <= 10 || i2 > 100) {
            i3 = 70;
        } else {
            i3 = i2;
        }
        int i6 = 0;
        int i7 = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
        try {
            if (at.isWifi(ah.getContext())) {
                str4 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("CompressResolutionForWifi");
            } else if (at.is2G(ah.getContext())) {
                str4 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("CompressResolutionFor2G");
            } else if (at.is3G(ah.getContext())) {
                str4 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("CompressResolutionFor3G");
            } else {
                str4 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("CompressResolutionFor4G");
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
            i4 = bo.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("UseOptImage"), 0);
            com.tencent.mm.kernel.g.RN();
            if ((((int) (new p(com.tencent.mm.kernel.a.QF()).longValue() / 100)) % 100) + 1 <= i4) {
                z2 = true;
            } else {
                z2 = false;
            }
            ab.i("MicroMsg.ImgInfoStorage", "fromPathToImgInfo useOpt:%b opt:%d uin:(%d,%d) debug:%b sdk:%d", Boolean.valueOf(z2), Integer.valueOf(i4), Long.valueOf(new p(com.tencent.mm.kernel.a.QF()).longValue()), Long.valueOf(new p(com.tencent.mm.kernel.a.QF()).longValue() / 100), Boolean.valueOf(com.tencent.mm.sdk.a.b.dnO()), Integer.valueOf(VERSION.SDK_INT));
        } catch (Exception e3) {
            ab.e("MicroMsg.ImgInfoStorage", "get useopt :%s", bo.l(e3));
            z2 = false;
        }
        if (com.tencent.mm.sdk.a.b.dnO()) {
            z2 = true;
        }
        if (com.tencent.mm.compatible.util.d.fP(16)) {
            z3 = false;
        } else {
            z3 = z2;
        }
        ab.i("MicroMsg.ImgInfoStorage", "genBigImg configLong:%d configShort:%d", Integer.valueOf(i6), Integer.valueOf(i7));
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
        i2 = bo.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        if (i2 <= 0) {
            i2 = 100;
        }
        int i8 = i2 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        i2 = bo.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("PicCompressAvoidanceRemainderPerc"), 10);
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
        ab.d("MicroMsg.ImgInfoStorage", "genBigImg insert : original img path: %s, fullpath:%s, needimg:%b,comresstype:%d Avoidance[%d,%d] ", str, b, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i8), Integer.valueOf(i5));
        if (z) {
            Options amj = d.amj(str);
            if (amj == null || amj.outWidth == 0 || amj.outHeight == 0) {
                q = "MicroMsg.ImgInfoStorage";
                String str5 = "genBigImg getImageOptions error:%s, origOptions_null:%b";
                Object[] objArr = new Object[2];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(amj == null);
                ab.w(q, str5, objArr);
                AppMethodBeat.o(78263);
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
            ab.i("MicroMsg.ImgInfoStorage", "genBigImg [%d, %d] -> target:[h,w]:[%d,%d]", Integer.valueOf(amj.outHeight), Integer.valueOf(amj.outWidth), Integer.valueOf(i6), Integer.valueOf(indexOf));
            q = amj != null ? amj.outMimeType : "";
            long asZ = e.asZ(str);
            boolean IsJpegFile = MMNativeJpeg.IsJpegFile(str);
            if (q == null || !(q.endsWith("jpeg") || q.endsWith("jpg") || q.endsWith("bmp") || q.endsWith("png") || q.endsWith("gif"))) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (i != 0 || ((obj == null && asZ <= 204800 && (amj == null || i12 <= 0)) || asZ <= ((long) i8))) {
                ab.i("MicroMsg.ImgInfoStorage", "summersafecdn createThumbNail big pic no compress, calculatedQuality:%d, origLen:%d oriWidth:%d oriHeight:%d", Integer.valueOf(queryQuality), Long.valueOf(asZ), Integer.valueOf(i9), Integer.valueOf(i10));
                if (obj2 != null) {
                    e.y(str, b);
                } else {
                    if (d.a(false, str, i9, i10, CompressFormat.JPEG, 100, b, bVar) != 1) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(111, 187, 1, false);
                        ab.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail (for cvrt to jpg): %s", str);
                        AppMethodBeat.o(78263);
                        return null;
                    }
                }
                i8 = 38;
                j = 0;
                com.tencent.mm.al.f.afx();
                if (!com.tencent.mm.al.b.lg(256)) {
                    ab.d("MicroMsg.ImgInfoStorage", "summersafecdn not use CDNNEWPROTO");
                } else if (i == 1) {
                    int i13;
                    int i14;
                    int i15 = 0;
                    try {
                        i15 = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("CompressMidPicLevel")).intValue();
                    } catch (Exception e4) {
                    }
                    try {
                        i2 = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("CompressMidPicSize")).intValue();
                    } catch (Exception e5) {
                        i2 = 0;
                    }
                    ab.i("MicroMsg.ImgInfoStorage", "summersafecdn CompressMidPicLevel-level:%d size:%d", Integer.valueOf(i15), Integer.valueOf(i2));
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
                        pString3.value = sn(str);
                        pString4.value = b(pString3.value, "", FileUtils.PIC_POSTFIX_JPEG, false);
                        i7 = d.a(false, str, i14, i13, CompressFormat.JPEG, i15, pString4.value, bVar);
                        ab.d("MicroMsg.ImgInfoStorage", "summersafecdn pMidImgName[%s], pMidImgPath[%s], useOpt[%b], ret[%b] [%d, %d]", pString3.value, pString4.value, Boolean.FALSE, Integer.valueOf(i7), Integer.valueOf(i14), Integer.valueOf(i13));
                        z4 = false;
                    } else {
                        pString3.value = pString.value;
                        pString4.value = pString2.value;
                        ab.d("MicroMsg.ImgInfoStorage", "summersafecdn not need to compress mid pic needCompressByQuality[%b], [%d, %d; %d, %d] use big pMidImgName[%s], pMidImgPath[%s]", Boolean.valueOf(z2), Integer.valueOf(i10), Integer.valueOf(i9), Integer.valueOf(i14), Integer.valueOf(i13), pString3.value, pString4.value);
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
                long anU = bo.anU();
                i7 = d.a(z2, str, i6, indexOf, CompressFormat.JPEG, i3, b, bVar);
                if (i7 == 1 || !z2) {
                    z4 = z2;
                } else {
                    i8 = 28;
                    i7 = d.a(false, str, i6, indexOf, CompressFormat.JPEG, i3, b, bVar);
                    z4 = false;
                }
                ab.i("MicroMsg.ImgInfoStorage", "genBigImg check use orig , orig:%d aftercomp:%d diff percent:[%d] picCompressAvoidanceRemainderPerc:%d  %s ", Long.valueOf(asZ), Long.valueOf(e.asZ(b)), Long.valueOf((100 * e.asZ(b)) / asZ), Integer.valueOf(i5), b);
                if (obj2 != null && (asZ - r10) * 100 < ((long) i5) * asZ) {
                    e.y(str, b);
                    z4 = false;
                    i8 = 48;
                    i7 = 1;
                }
                j = bo.anU() - anU;
                if (i7 != 1) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(111, 187, 1, false);
                    ab.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail: %s", str);
                    AppMethodBeat.o(78263);
                    return null;
                }
            }
            Options amj2 = d.amj(b);
            i5 = amj2 != null ? amj2.outWidth : -1;
            indexOf = amj2 != null ? amj2.outHeight : -1;
            long asZ2 = e.asZ(b);
            int queryQuality2 = MMNativeJpeg.queryQuality(b);
            boolean IsJpegFile2 = MMNativeJpeg.IsJpegFile(b);
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
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
            hVar.e(11713, numArr);
            ab.i("MicroMsg.ImgInfoStorage", "genBigImg ret:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", Integer.valueOf(i7), Boolean.valueOf(z4), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(queryQuality), Long.valueOf(asZ), Boolean.valueOf(IsJpegFile), Integer.valueOf(i5), Integer.valueOf(indexOf), Integer.valueOf(queryQuality2), Long.valueOf(asZ2), Boolean.valueOf(IsJpegFile2), str, b);
            if (i == 0 && asZ2 >= 40960 && IsJpegFile2 && !MMNativeJpeg.isProgressive(b)) {
                str4 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("EnableCDNUploadImg");
                if (!bo.isNullOrNil(str4) && str4.equals("1")) {
                    boolean z5;
                    j = bo.anU();
                    if (z4) {
                        i4 = 19;
                        String str6 = b + ".prog";
                        e.y(b, str6);
                        z2 = (bo.isNullOrNil(str6) || bo.isNullOrNil(b) || !new File(str6).exists()) ? false : MMJpegOptim.convertToProgressive(str6, b, i3) == 0;
                        e.deleteFile(str6);
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
                    j = bo.anU() - j;
                    long asZ3 = e.asZ(b);
                    com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.pYm;
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
                    hVar2.e(11713, numArr2);
                    ab.i("MicroMsg.ImgInfoStorage", "genBigImg PROGRESS ret:%d progret:%b size:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", Integer.valueOf(i7), Boolean.valueOf(z5), Long.valueOf(asZ3), Boolean.valueOf(z4), Integer.valueOf(i4), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(queryQuality), Long.valueOf(asZ), Boolean.valueOf(IsJpegFile), Integer.valueOf(i5), Integer.valueOf(indexOf), Integer.valueOf(queryQuality2), Long.valueOf(asZ2), Boolean.valueOf(IsJpegFile2), str, b);
                    if (!z5) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(111, 186, 1, false);
                        ab.e("MicroMsg.ImgInfoStorage", "genBigImg convert to progressive failed %s", b);
                    }
                }
            }
        }
        AppMethodBeat.o(78263);
        return null;
    }

    private e a(String str, int i, boolean z, int i2, int i3, PInt pInt, PInt pInt2, String str2, long j, String str3, String str4, com.tencent.mm.a.b bVar, com.tencent.mm.a.b bVar2, com.tencent.mm.at.n.a aVar) {
        AppMethodBeat.i(78264);
        if (e.ct(str)) {
            PString pString;
            PString pString2;
            PString pString3;
            String a;
            String sh = f.sh(str);
            String a2 = a(str, i, z, i3, pInt, pInt2, str2, str3, bVar);
            if (aVar == null || aVar.fDC != i) {
                com.tencent.mm.a.b bVar3;
                String str5;
                if (aVar == null || aVar.fDC == i) {
                    bVar3 = bVar2;
                    str5 = str4;
                } else {
                    bVar3 = null;
                    str5 = null;
                }
                pString = new PString();
                pString2 = new PString();
                pString3 = new PString();
                a = a(str, sh, i, z, pString, pString2, pString3, new PString(), str5, bVar3);
                ab.i("MicroMsg.ImgInfoStorage", "summersafecdn user change CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", str, Integer.valueOf(i2), Integer.valueOf(i), pString3.value, r10.value);
            } else {
                com.tencent.mm.at.n.a.a ahe = aVar.ahe();
                pString = ahe.fFU;
                pString2 = ahe.fFV;
                a = ahe.fDK;
                pString3 = ahe.fFW;
                PString pString4 = ahe.fFX;
                ab.i("MicroMsg.ImgInfoStorage", "summersafecdn found CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", str, Integer.valueOf(i2), Integer.valueOf(i), pString3.value, pString4.value);
            }
            e eVar = new e();
            eVar.bJt = -1;
            eVar.fH(agU());
            eVar.fG(j);
            if (!bo.isNullOrNil(a)) {
                eVar.se(a);
            }
            eVar.lw(0);
            eVar.setSource(i2);
            if (i2 == 4) {
                if (str.startsWith(aa.Ya())) {
                    eVar.lv(3);
                } else {
                    eVar.lv(2);
                }
            } else {
                eVar.lv(1);
            }
            if (z) {
                eVar.sb(pString.value + FileUtils.PIC_POSTFIX_JPEG);
                if (!bo.isNullOrNil(pString3.value)) {
                    eVar.sc(pString3.value + FileUtils.PIC_POSTFIX_JPEG);
                }
                if (bo.isNullOrNil(eVar.fDB)) {
                    eVar.sd(a2);
                }
                eVar.lt((int) e.asZ(pString2.value));
                if (eVar.frO == 0) {
                    ab.i("MicroMsg.ImgInfoStorage", "thumb file totlen is 0 %s", pString2.value);
                }
                eVar.sa(sh);
            }
            eVar.ls((int) bo.anT());
            eVar.lx(i);
            ab.d("MicroMsg.ImgInfoStorage", "fromPathToImgInfo insert: compress img size = " + eVar.frO);
            AppMethodBeat.o(78264);
            return eVar;
        }
        AppMethodBeat.o(78264);
        return null;
    }

    public final long a(byte[] bArr, long j, boolean z, String str, PString pString, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(78265);
        long a = a(bArr, j, z, "", 0, str, pString, pInt, pInt2);
        AppMethodBeat.o(78265);
        return a;
    }

    public final long a(byte[] bArr, long j, boolean z, String str, int i, String str2, PString pString, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(78266);
        String concat = "SERVERID://".concat(String.valueOf(j));
        String x = com.tencent.mm.a.g.x(concat.getBytes());
        String q = q(x, "th_", "");
        if (bArr != null && bArr.length >= 0) {
            Bitmap bQ = d.bQ(bArr);
            if (bQ == null) {
                ab.e("MicroMsg.ImgInfoStorage", "create decodeByteArray failed: " + new String(bArr));
            }
            if (!(z || bQ == null)) {
                try {
                    bQ = d.ah(bQ);
                    pInt.value = bQ.getWidth();
                    pInt2.value = bQ.getHeight();
                    d.a(bQ, 90, CompressFormat.JPEG, q, true);
                } catch (IOException e) {
                    ab.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: " + x + " " + new String(bArr));
                }
            }
        }
        e eVar = new e();
        if (bo.isNullOrNil(str)) {
            str = concat;
        } else {
            eVar.setOffset(i);
            eVar.lt(i);
        }
        eVar.bJt = -1;
        eVar.fH(agU());
        eVar.sb(str);
        eVar.sd("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(x)));
        pString.value = eVar.fDB;
        if (z) {
            eVar.eI(0);
            eVar.lx(1);
        } else {
            eVar.eI(j);
            eVar.lx(0);
        }
        eVar.se(str2);
        eVar.ls((int) bo.anT());
        long e2 = e(eVar);
        if (e2 != -1) {
            doNotify();
        }
        AppMethodBeat.o(78266);
        return e2;
    }

    public final int a(int i, e eVar) {
        AppMethodBeat.i(78267);
        int a = a(Long.valueOf((long) i), eVar);
        AppMethodBeat.o(78267);
        return a;
    }

    public final int a(Long l, e eVar) {
        int i;
        AppMethodBeat.i(78268);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        ContentValues Hl = eVar.Hl();
        if (Hl.size() == 0) {
            i = 1;
        } else {
            i = this.fni.update("ImgInfo2", Hl, "id=?", new String[]{String.valueOf(l)});
        }
        ab.i("MicroMsg.ImgInfoStorage", "update last :%d values : %s %s", Long.valueOf(System.currentTimeMillis() - valueOf.longValue()), Hl.toString(), Integer.valueOf(i));
        if (i != -1) {
            eVar.agS();
            doNotify();
        }
        AppMethodBeat.o(78268);
        return i;
    }

    public final Bitmap g(int i, int i2, boolean z) {
        Object obj;
        AppMethodBeat.i(78269);
        if (z) {
            obj = "location_backgroup_key_from";
        } else {
            String obj2 = "location_backgroup_key_tor";
        }
        Bitmap bitmap = (Bitmap) this.fEh.ai(obj2);
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = d.gU(i, i2);
            this.fEh.k(obj2, bitmap);
        }
        AppMethodBeat.o(78269);
        return bitmap;
    }

    public final Bitmap a(long j, String str, int i, int i2, int i3, boolean z) {
        Object concat;
        AppMethodBeat.i(78270);
        if (z) {
            concat = "location_backgroup_key_from".concat(String.valueOf(j));
        } else {
            String concat2 = "location_backgroup_key_tor".concat(String.valueOf(j));
        }
        Bitmap bitmap = (Bitmap) this.fEh.ai(concat2);
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = d.o(str, i, i2, i3);
            this.fEh.k(concat2, bitmap);
        }
        AppMethodBeat.o(78270);
        return bitmap;
    }

    public final boolean a(bi biVar, int i, int i2) {
        AppMethodBeat.i(78271);
        String y = y(biVar);
        if (bo.isNullOrNil(y)) {
            AppMethodBeat.o(78271);
            return false;
        }
        boolean a = a(y, biVar.field_imgPath, i, i2, 0, 0);
        AppMethodBeat.o(78271);
        return a;
    }

    public final boolean a(String str, String str2, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(78272);
        ab.d("MicroMsg.ImgInfoStorage", "createHDThumbNail bigPicPath%s thumbPath%s maskResId:%d, compressType:%d, stack[%s]", str, str2, Integer.valueOf(i), Integer.valueOf(i2), bo.dpG());
        long currentTimeMillis = System.currentTimeMillis();
        float density = com.tencent.mm.bz.a.getDensity(ah.getContext());
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            AppMethodBeat.o(78272);
            return false;
        }
        String c = c(str2, false, true);
        if (bo.isNullOrNil(c)) {
            AppMethodBeat.o(78272);
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
        Options amj = d.amj(substring);
        if (amj == null || amj.outWidth <= 0 || amj.outHeight <= 0) {
            com.tencent.mm.plugin.report.service.h.pYm.a(111, 185, 1, false);
            if (e.asZ(substring) > 0) {
                AppMethodBeat.o(78272);
                return false;
            }
            amj = new Options();
            d.dnX();
            ab.i("MicroMsg.ImgInfoStorage", "createHDThumbNail old op is invaild but len is 0 need recreate[%s, %d, %d]", amj, Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
            com.tencent.mm.plugin.report.service.h.pYm.a(111, 183, 1, false);
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
                a = d.a(str, i6, i5, CompressFormat.JPEG, str3, new PInt(), new PInt());
            } catch (Exception e) {
                com.tencent.mm.plugin.report.service.h.pYm.a(111, 184, 1, false);
                ab.e("MicroMsg.ImgInfoStorage", "create hd thumbnail failed. %s", e.toString());
                AppMethodBeat.o(78272);
                return false;
            }
        }
        a = d.b(str, i6, i5, CompressFormat.JPEG, str3, new PInt(), new PInt());
        ab.d("MicroMsg.ImgInfoStorage", "createHDThumbNail user time %s, height %d, width %d, hasHDThumb:%b", (System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(i6), Integer.valueOf(i5), Boolean.valueOf(a));
        a(substring, true, com.tencent.mm.bz.a.getDensity(ah.getContext()), true, false, true, i, false);
        if (a) {
            synchronized (this.fEo) {
                try {
                    if (this.fEo.containsKey(str2) && !((String) this.fEo.get(str2)).endsWith("hd")) {
                        this.fEo.put(str2, str3);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(78272);
                    }
                }
            }
        } else {
            com.tencent.mm.plugin.report.service.h.pYm.a(111, 184, 1, false);
        }
        AppMethodBeat.o(78272);
        return a;
    }

    public final String c(String str, boolean z, boolean z2) {
        String str2;
        AppMethodBeat.i(78273);
        if (str == null || !this.fEo.containsKey(str)) {
            if (z) {
                str2 = str;
            } else {
                str2 = I(str, z2);
            }
            if (!bo.isNullOrNil(str2)) {
                this.fEo.put(str, str2);
            }
        } else {
            str2 = (String) this.fEo.get(str);
        }
        AppMethodBeat.o(78273);
        return str2;
    }

    /* JADX WARNING: Missing block: B:6:0x0030, code skipped:
            if (r0.fDy == 0) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String y(bi biVar) {
        AppMethodBeat.i(78275);
        if (biVar == null) {
            ab.w("MicroMsg.ImgInfoStorage", "[getBigPicPath] msg is null.");
            AppMethodBeat.o(78275);
            return null;
        }
        e fJ;
        long currentTimeMillis = System.currentTimeMillis();
        if (biVar.field_isSend == 1) {
            fJ = o.ahl().fJ(biVar.field_msgId);
        }
        fJ = o.ahl().fI(biVar.field_msgSvrId);
        if (com.tencent.mm.kernel.g.RP().isSDCardAvailable()) {
            String q;
            if (biVar.field_isSend == 1) {
                String c = f.c(fJ);
                String q2 = o.ahl().q(c, "", "");
                if (c == null || c.length() <= 0 || !e.ct(q2)) {
                    q2 = fJ.fDz;
                    q = o.ahl().q(q2, "", "");
                    if (q2 != null && q2.length() > 0 && e.ct(q)) {
                        AppMethodBeat.o(78275);
                        return q;
                    }
                }
                AppMethodBeat.o(78275);
                return q2;
            } else if (fJ.agP()) {
                String str = fJ.fDz;
                if (fJ.agQ()) {
                    fJ = f.a(fJ);
                    if (fJ != null && fJ.fDy > 0 && fJ.agP() && e.ct(o.ahl().q(fJ.fDz, "", ""))) {
                        q = fJ.fDz;
                        AppMethodBeat.o(78275);
                        return q;
                    }
                }
                q = str;
                AppMethodBeat.o(78275);
                return q;
            }
        }
        ab.d("MicroMsg.ImgInfoStorage", "getBigPicPath use time:%s", (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(78275);
        return null;
    }

    public final Bitmap e(String str, float f) {
        AppMethodBeat.i(78224);
        Bitmap a = a(str, f, false);
        AppMethodBeat.o(78224);
        return a;
    }

    public final e w(bi biVar) {
        AppMethodBeat.i(78237);
        e fJ = fJ(biVar.field_msgId);
        if (fJ.fDy == 0) {
            fJ = fI(biVar.field_msgSvrId);
            if (fJ.fDy == 0) {
                ab.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
                AppMethodBeat.o(78237);
                return null;
            }
        }
        AppMethodBeat.o(78237);
        return fJ;
    }

    public final String so(String str) {
        AppMethodBeat.i(139133);
        String c = c(str, false, true);
        AppMethodBeat.o(139133);
        return c;
    }
}
