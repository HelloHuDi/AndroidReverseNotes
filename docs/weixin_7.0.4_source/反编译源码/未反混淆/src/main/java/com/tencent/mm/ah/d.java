package com.tencent.mm.ah;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    private static a frB = new a(frw);
    private static int frv = 150;
    private static int frw = 150;
    static final Map<String, Integer> frx;
    private final a frA = new a() {
        public final void qj(String str) {
            a aVar;
            AppMethodBeat.i(77874);
            ab.d("MicroMsg.AvatarStorage", "notifyChanged user:%s clonesize:%d watchers:%d", str, Integer.valueOf(d.this.frz.size()), Integer.valueOf(d.this.frz.size()));
            ArrayList<a> arrayList = new ArrayList();
            synchronized (d.this.frz) {
                try {
                    Iterator it = d.this.frz.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (weakReference != null) {
                            aVar = (a) weakReference.get();
                            if (aVar != null) {
                                arrayList.add(aVar);
                            } else {
                                it.remove();
                            }
                        }
                    }
                } finally {
                    AppMethodBeat.o(77874);
                }
            }
            for (a aVar2 : arrayList) {
                aVar2.qj(str);
            }
        }
    };
    private l<a, String> fry = new l<a, String>() {
        public final /* synthetic */ void w(Object obj, Object obj2) {
            AppMethodBeat.i(77873);
            ((a) obj).qj((String) obj2);
            AppMethodBeat.o(77873);
        }
    };
    private final List<WeakReference<a>> frz = new ArrayList();

    public static class b {
        public static boolean qk(String str) {
            AppMethodBeat.i(77875);
            Bitmap ql = ql(str);
            if (ql == null || ql.isRecycled()) {
                AppMethodBeat.o(77875);
                return false;
            }
            OutputStream outputStream = null;
            try {
                outputStream = e.L(str, false);
                ql.compress(CompressFormat.PNG, 100, outputStream);
                e.deleteFile(str + ".bm");
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                    }
                }
                AppMethodBeat.o(77875);
                return true;
            } catch (IOException e2) {
                ab.printErrStackTrace("MicroMsg.AvatarStorage", e2, "Cannot write avatar file: %s", str);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                    }
                }
                AppMethodBeat.o(77875);
                return false;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
                AppMethodBeat.o(77875);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:38:0x014c A:{SYNTHETIC, Splitter:B:38:0x014c} */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0151 A:{Catch:{ Exception -> 0x0176 }} */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x014c A:{SYNTHETIC, Splitter:B:38:0x014c} */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0151 A:{Catch:{ Exception -> 0x0176 }} */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x014c A:{SYNTHETIC, Splitter:B:38:0x014c} */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0151 A:{Catch:{ Exception -> 0x0176 }} */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x014c A:{SYNTHETIC, Splitter:B:38:0x014c} */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0151 A:{Catch:{ Exception -> 0x0176 }} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static Bitmap ql(String str) {
            Exception e;
            OutOfMemoryError e2;
            AppMethodBeat.i(77876);
            String str2 = str + ".bm";
            boolean z = true;
            ReadableByteChannel readableByteChannel = null;
            InputStream openRead;
            try {
                if (e.ct(str2)) {
                    int asZ = (int) e.asZ(str2);
                    if (asZ <= 0 || !(asZ == 36864 || asZ == 36880)) {
                        remove(str);
                        ab.e("MicroMsg.AvatarStorage", "SmallBM get bm invalid size:%d file:%s", Integer.valueOf(asZ), str2);
                        AppMethodBeat.o(77876);
                        return null;
                    }
                    openRead = e.openRead(str2);
                    try {
                        readableByteChannel = Channels.newChannel(openRead);
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(36864);
                        readableByteChannel.read(allocateDirect);
                        allocateDirect.position(0);
                        if (asZ == 36880) {
                            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(16);
                            readableByteChannel.read(allocateDirect2);
                            if (allocateDirect2.getLong(0) != 1) {
                                ab.e("MicroMsg.AvatarStorage", "SmallBM get bm header invalid flag:%d size:%d file:%s", Long.valueOf(allocateDirect2.getLong(0)), Integer.valueOf(asZ), str2);
                                readableByteChannel.close();
                                openRead.close();
                                remove(str);
                                AppMethodBeat.o(77876);
                                return null;
                            }
                            z = false;
                        }
                        ab.d("MicroMsg.AvatarStorage", "SmallBM get bm size:%d shouldRemoveCorner:%b file:%s", Integer.valueOf(asZ), Boolean.valueOf(z), str2);
                        readableByteChannel.close();
                        try {
                            openRead.close();
                            Bitmap createBitmap = Bitmap.createBitmap(96, 96, Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(allocateDirect);
                            if (z) {
                                Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 9, 9, 78, 78);
                                ab.i("MicroMsg.AvatarStorage", "recycle bitmap:%s", createBitmap.toString());
                                createBitmap.recycle();
                                AppMethodBeat.o(77876);
                                return createBitmap2;
                            }
                            AppMethodBeat.o(77876);
                            return createBitmap;
                        } catch (Exception e3) {
                            e = e3;
                            readableByteChannel = null;
                            ab.e("MicroMsg.AvatarStorage", "SmallBM get exception e:%s file:%s", e.getMessage(), str2);
                            if (readableByteChannel != null) {
                            }
                            if (openRead != null) {
                            }
                            AppMethodBeat.o(77876);
                            return null;
                        } catch (OutOfMemoryError e4) {
                            e2 = e4;
                            readableByteChannel = null;
                            ab.e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                            if (readableByteChannel != null) {
                            }
                            if (openRead != null) {
                            }
                            AppMethodBeat.o(77876);
                            return null;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        ab.e("MicroMsg.AvatarStorage", "SmallBM get exception e:%s file:%s", e.getMessage(), str2);
                        if (readableByteChannel != null) {
                        }
                        if (openRead != null) {
                        }
                        AppMethodBeat.o(77876);
                        return null;
                    } catch (OutOfMemoryError e6) {
                        e2 = e6;
                        ab.e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                        if (readableByteChannel != null) {
                        }
                        if (openRead != null) {
                        }
                        AppMethodBeat.o(77876);
                        return null;
                    }
                }
                ab.d("MicroMsg.AvatarStorage", "SmallBM get bm file not exsit:%s", str2);
                AppMethodBeat.o(77876);
                return null;
            } catch (Exception e7) {
                e = e7;
                openRead = null;
            } catch (OutOfMemoryError e8) {
                e2 = e8;
                openRead = null;
                ab.e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                if (readableByteChannel != null) {
                    try {
                        readableByteChannel.close();
                    } catch (Exception e9) {
                        AppMethodBeat.o(77876);
                        return null;
                    }
                }
                if (openRead != null) {
                    openRead.close();
                }
                AppMethodBeat.o(77876);
                return null;
            }
        }

        static boolean remove(String str) {
            AppMethodBeat.i(77877);
            e.deleteFile(str + ".bm");
            e.deleteFile(str);
            AppMethodBeat.o(77877);
            return true;
        }
    }

    public interface a {
        void qj(String str);
    }

    static {
        AppMethodBeat.i(77904);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        frx = concurrentHashMap;
        concurrentHashMap.put("voipapp", Integer.valueOf(R.raw.default_voip));
        frx.put("qqmail", Integer.valueOf(R.raw.default_qqmail));
        frx.put("fmessage", Integer.valueOf(R.raw.default_fmessage));
        frx.put("floatbottle", Integer.valueOf(R.raw.default_bottle));
        frx.put("lbsapp", Integer.valueOf(R.raw.default_nearby));
        frx.put("shakeapp", Integer.valueOf(R.raw.default_shake));
        frx.put("medianote", Integer.valueOf(R.raw.default_medianote));
        frx.put("qqfriend", Integer.valueOf(R.raw.default_qqfriend));
        frx.put("masssendapp", Integer.valueOf(R.raw.default_masssend));
        frx.put("feedsapp", Integer.valueOf(R.raw.default_feedsapp));
        frx.put("facebookapp", Integer.valueOf(R.raw.default_facebookapp));
        frx.put("newsapp", Integer.valueOf(R.raw.default_readerapp));
        frx.put("helper_entry", Integer.valueOf(R.raw.default_plugin_icon_contract));
        frx.put("voicevoipapp", Integer.valueOf(R.raw.default_voicevoip));
        frx.put("voiceinputapp", Integer.valueOf(R.raw.default_voiceinput));
        frx.put("officialaccounts", Integer.valueOf(R.raw.default_brand_contact));
        frx.put("service_officialaccounts", Integer.valueOf(R.raw.default_servicebrand_contact));
        frx.put("linkedinplugin", Integer.valueOf(R.raw.default_linkedin));
        frx.put("notifymessage", Integer.valueOf(R.raw.default_notify_message_contact));
        frx.put("appbrandcustomerservicemsg", Integer.valueOf(R.raw.default_app_brand_service_msg));
        frx.put("downloaderapp", Integer.valueOf(R.raw.default_downloaderapp));
        AppMethodBeat.o(77904);
    }

    public static void a(Context context, ImageView imageView, int i) {
        AppMethodBeat.i(77878);
        try {
            imageView.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.compatible.g.a.decodeResource(context.getResources(), i), true, 1.0f));
            AppMethodBeat.o(77878);
        } catch (Exception e) {
            ab.e("MicroMsg.AvatarStorage", "exception:%s", bo.l(e));
            AppMethodBeat.o(77878);
        }
    }

    public d() {
        AppMethodBeat.i(77879);
        reset();
        this.fry.a(this.frA, null);
        AppMethodBeat.o(77879);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(77880);
        synchronized (this.frz) {
            try {
                this.frz.add(new WeakReference(aVar));
            } finally {
                while (true) {
                }
                AppMethodBeat.o(77880);
            }
        }
    }

    public final void b(a aVar) {
        AppMethodBeat.i(77881);
        synchronized (this.frz) {
            try {
                WeakReference c = c(aVar);
                if (c != null) {
                    this.frz.remove(c);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(77881);
            }
        }
    }

    private WeakReference<a> c(a aVar) {
        AppMethodBeat.i(77882);
        synchronized (this.frz) {
            WeakReference<a> weakReference;
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 < this.frz.size()) {
                        weakReference = (WeakReference) this.frz.get(i2);
                        if (weakReference != null) {
                            a aVar2 = (a) weakReference.get();
                            if (aVar2 != null && aVar2.equals(aVar)) {
                                break;
                            }
                        }
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.o(77882);
                        return null;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(77882);
                }
            }
            return weakReference;
        }
    }

    @Deprecated
    public final void d(a aVar) {
        AppMethodBeat.i(77883);
        this.fry.a(aVar, Looper.getMainLooper());
        AppMethodBeat.o(77883);
    }

    @Deprecated
    public final void e(a aVar) {
        AppMethodBeat.i(77884);
        this.fry.remove(aVar);
        AppMethodBeat.o(77884);
    }

    public static void reset() {
        AppMethodBeat.i(77885);
        if (frB == null) {
            frB = new a(frw);
        }
        AppMethodBeat.o(77885);
    }

    public static Bitmap qd(String str) {
        AppMethodBeat.i(77886);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(77886);
            return null;
        }
        Bitmap bitmap;
        a aVar = frB;
        if (aVar.fra != null) {
            bitmap = (Bitmap) aVar.fra.ai(str);
        } else {
            bitmap = (Bitmap) com.tencent.mm.cache.e.a.J("avatar_cache", str);
        }
        if (bitmap == null) {
            AppMethodBeat.o(77886);
            return null;
        } else if (bitmap.isRecycled()) {
            aVar = frB;
            if (aVar.fra != null) {
                aVar.fra.remove(str);
            } else {
                com.tencent.mm.cache.e.a.K("avatar_cache", str);
            }
            AppMethodBeat.o(77886);
            return null;
        } else {
            AppMethodBeat.o(77886);
            return bitmap;
        }
    }

    public final void e(String str, Bitmap bitmap) {
        AppMethodBeat.i(77887);
        frB.d(str, bitmap);
        com.tencent.mm.bv.a.a aVar = com.tencent.mm.bv.a.a.a.xtT;
        if (aVar != null) {
            aVar.Dp(str);
        }
        this.fry.cF(str);
        this.fry.doNotify();
        ab.d("MicroMsg.AvatarStorage", "setToCache %s", str);
        AppMethodBeat.o(77887);
    }

    public final Bitmap bU(Context context) {
        AppMethodBeat.i(77888);
        context.getResources();
        Bitmap qd = qd("I_AM_NO_SDCARD_USER_NAME");
        if (!(B(qd) || qd == null)) {
            ab.i("MicroMsg.AvatarStorage", "not cached, recycled=%b, reload=%s", Boolean.valueOf(qd.isRecycled()), "I_AM_NO_SDCARD_USER_NAME");
            qd = com.tencent.mm.sdk.platformtools.d.a(qd, true, 1.0f);
            e("I_AM_NO_SDCARD_USER_NAME", qd);
        }
        AppMethodBeat.o(77888);
        return qd;
    }

    private static StringBuilder a(StringBuilder stringBuilder, String str, boolean z) {
        AppMethodBeat.i(77889);
        String x = g.x(str.getBytes());
        stringBuilder.append(x.substring(0, 2)).append(IOUtils.DIR_SEPARATOR_UNIX).append(x.substring(2, 4)).append(IOUtils.DIR_SEPARATOR_UNIX).append("user_");
        if (z) {
            stringBuilder.append("hd_");
        }
        StringBuilder append = stringBuilder.append(x).append(".png");
        AppMethodBeat.o(77889);
        return append;
    }

    public static String C(String str, boolean z) {
        AppMethodBeat.i(77890);
        String stringBuilder = a(new StringBuilder(64).append("wcf://avatar/"), str, z).toString();
        e.tf(e.atb(stringBuilder));
        AppMethodBeat.o(77890);
        return stringBuilder;
    }

    public static String D(String str, boolean z) {
        AppMethodBeat.i(77891);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(77891);
            return null;
        }
        String stringBuilder = a(new StringBuilder(128).append(com.tencent.mm.kernel.g.RP().cachePath).append("avatar/"), str, z).toString();
        if (e.tf(e.atb(stringBuilder))) {
            AppMethodBeat.o(77891);
            return stringBuilder;
        }
        AppMethodBeat.o(77891);
        return null;
    }

    public static boolean qe(String str) {
        AppMethodBeat.i(77892);
        String C = C(str, false);
        if (e.ct(C) || e.ct(C + ".bm")) {
            AppMethodBeat.o(77892);
            return true;
        }
        AppMethodBeat.o(77892);
        return false;
    }

    public static boolean E(String str, boolean z) {
        AppMethodBeat.i(77893);
        String C = C(str, z);
        ab.i("MicroMsg.AvatarStorage", "Removed avatar: %s, hd: %b, path: %s", str, Boolean.valueOf(z), C);
        boolean deleteFile = e.deleteFile(C);
        if (!z) {
            deleteFile |= b.remove(C);
        }
        AppMethodBeat.o(77893);
        return deleteFile;
    }

    public static Bitmap qf(String str) {
        AppMethodBeat.i(77894);
        Bitmap qi = qi(C(str, false));
        AppMethodBeat.o(77894);
        return qi;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0079 A:{SYNTHETIC, Splitter:B:23:0x0079} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0085 A:{SYNTHETIC, Splitter:B:29:0x0085} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Bitmap m(String str, byte[] bArr) {
        Throwable e;
        AppMethodBeat.i(77895);
        Bitmap decodeByteArray = com.tencent.mm.sdk.platformtools.d.decodeByteArray(bArr, 96, 96);
        if (B(decodeByteArray)) {
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            if (width != height) {
                if (width > height) {
                    decodeByteArray = Bitmap.createBitmap(decodeByteArray, (width - height) / 2, 0, height, height);
                } else {
                    decodeByteArray = Bitmap.createBitmap(decodeByteArray, 0, (height - width) / 2, width, width);
                }
            }
            OutputStream L;
            try {
                L = e.L(C(str, false), false);
                try {
                    L.write(bArr, 0, bArr.length);
                    if (L != null) {
                        try {
                            L.close();
                        } catch (IOException e2) {
                        }
                    }
                    ab.i("MicroMsg.AvatarStorage", "Saved avatar: %s", str);
                    AppMethodBeat.o(77895);
                    return decodeByteArray;
                } catch (IOException e3) {
                    e = e3;
                    try {
                        ab.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                        if (L != null) {
                            try {
                                L.close();
                            } catch (IOException e4) {
                            }
                        }
                        AppMethodBeat.o(77895);
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (L != null) {
                            try {
                                L.close();
                            } catch (IOException e5) {
                            }
                        }
                        AppMethodBeat.o(77895);
                        throw e;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                L = null;
                ab.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                if (L != null) {
                }
                AppMethodBeat.o(77895);
                return null;
            } catch (Throwable th2) {
                e = th2;
                L = null;
                if (L != null) {
                }
                AppMethodBeat.o(77895);
                throw e;
            }
        }
        ab.e("MicroMsg.AvatarStorage", "Failed to decode avatar: %s", str);
        AppMethodBeat.o(77895);
        return null;
    }

    public final boolean n(String str, byte[] bArr) {
        AppMethodBeat.i(77896);
        Bitmap m = m(str, bArr);
        if (B(m)) {
            e(str, m);
            AppMethodBeat.o(77896);
            return true;
        }
        AppMethodBeat.o(77896);
        return false;
    }

    public final boolean au(String str, String str2) {
        boolean z = false;
        AppMethodBeat.i(77897);
        try {
            int i;
            int i2;
            Options amj = com.tencent.mm.sdk.platformtools.d.amj(str);
            int i3 = amj.outWidth;
            int i4 = amj.outHeight;
            if (i4 < i3) {
                i = (i3 * 96) / i4;
                i2 = 96;
            } else {
                i2 = (i4 * 96) / i3;
                i = 96;
            }
            ab.d("MicroMsg.AvatarStorage", "inJustDecodeBounds old [w:%d h:%d]  new [w:%d h:%d] corner:%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(1));
            Options options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            options.inSampleSize = Math.min(i3 / i, i4 / i2);
            z = f(str2, com.tencent.mm.sdk.platformtools.d.decodeFile(str, options));
            AppMethodBeat.o(77897);
        } catch (Exception e) {
            ab.e("MicroMsg.AvatarStorage", "exception:%s", bo.l(e));
            AppMethodBeat.o(77897);
        }
        return z;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d8 A:{SYNTHETIC, Splitter:B:44:0x00d8} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d8 A:{SYNTHETIC, Splitter:B:44:0x00d8} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f(String str, Bitmap bitmap) {
        Throwable e;
        OutputStream outputStream;
        AppMethodBeat.i(77898);
        if (B(bitmap)) {
            Bitmap bitmap2;
            if (bitmap.getWidth() == 96 && bitmap.getHeight() == 96) {
                bitmap2 = bitmap;
            } else {
                try {
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    if (width != height) {
                        if (width > height) {
                            bitmap2 = Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height);
                        } else {
                            bitmap2 = Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width);
                        }
                        bitmap2 = Bitmap.createScaledBitmap(bitmap2, 96, 96, true);
                    } else {
                        bitmap2 = Bitmap.createScaledBitmap(bitmap, 96, 96, true);
                    }
                } catch (OutOfMemoryError e2) {
                    ab.e("MicroMsg.AvatarStorage", "kevin updateAvatar fail  %s ", str);
                    if (B(bitmap)) {
                        ab.i("MicroMsg.AvatarStorage", "recycle bitmap:%s", bitmap.toString());
                        bitmap.recycle();
                    }
                    AppMethodBeat.o(77898);
                    return false;
                }
            }
            if (!(bitmap2 == null || bitmap2 == bitmap)) {
                ab.i("MicroMsg.AvatarStorage", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
                bitmap = bitmap2;
            }
            OutputStream outputStream2 = null;
            try {
                outputStream2 = e.L(C(str, false), false);
                try {
                    bitmap.compress(CompressFormat.PNG, 100, outputStream2);
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    e(str, bitmap);
                    AppMethodBeat.o(77898);
                    return true;
                } catch (IOException e4) {
                    e = e4;
                    outputStream = outputStream2;
                    try {
                        ab.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        AppMethodBeat.o(77898);
                        return false;
                    } catch (Throwable th) {
                        e = th;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                        AppMethodBeat.o(77898);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    outputStream = outputStream2;
                    if (outputStream != null) {
                    }
                    AppMethodBeat.o(77898);
                    throw e;
                }
            } catch (IOException e7) {
                e = e7;
                outputStream = outputStream2;
            } catch (Throwable th3) {
                e = th3;
                outputStream = outputStream2;
                if (outputStream != null) {
                }
                AppMethodBeat.o(77898);
                throw e;
            }
        }
        AppMethodBeat.o(77898);
        return false;
    }

    public static Bitmap j(String str, int i, int i2) {
        AppMethodBeat.i(77899);
        ab.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s, width:%d, height:%d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(77899);
            return null;
        }
        Bitmap ap = com.tencent.mm.sdk.platformtools.d.ap(C(str, true), i, i2);
        AppMethodBeat.o(77899);
        return ap;
    }

    public static Bitmap qg(String str) {
        AppMethodBeat.i(77900);
        ab.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s", str);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(77900);
            return null;
        }
        Bitmap ap = com.tencent.mm.sdk.platformtools.d.ap(C(str, true), 480, 480);
        AppMethodBeat.o(77900);
        return ap;
    }

    public static Bitmap qh(String str) {
        Bitmap decodeResource;
        AppMethodBeat.i(77901);
        int i = 0;
        if (frx.containsKey(str)) {
            i = ((Integer) frx.get(str)).intValue();
        }
        if (i != 0) {
            o.acs();
            decodeResource = com.tencent.mm.compatible.g.a.decodeResource(o.getContext().getResources(), i);
        } else {
            decodeResource = null;
        }
        decodeResource = com.tencent.mm.sdk.platformtools.d.a(decodeResource, true, 1.0f, true);
        AppMethodBeat.o(77901);
        return decodeResource;
    }

    private static boolean B(Bitmap bitmap) {
        AppMethodBeat.i(77902);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(77902);
            return false;
        }
        AppMethodBeat.o(77902);
        return true;
    }

    public static Bitmap qi(String str) {
        Bitmap decodeFile;
        AppMethodBeat.i(77903);
        if (e.ct(str)) {
            decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
        } else {
            decodeFile = null;
        }
        if (decodeFile == null) {
            decodeFile = b.ql(str);
        }
        if (B(decodeFile)) {
            int width = decodeFile.getWidth();
            int height = decodeFile.getHeight();
            if (width != height) {
                if (width > height) {
                    decodeFile = Bitmap.createBitmap(decodeFile, (width - height) / 2, 0, height, height);
                } else {
                    decodeFile = Bitmap.createBitmap(decodeFile, 0, (height - width) / 2, width, width);
                }
            }
        }
        if (B(decodeFile)) {
            AppMethodBeat.o(77903);
            return decodeFile;
        }
        AppMethodBeat.o(77903);
        return null;
    }
}
