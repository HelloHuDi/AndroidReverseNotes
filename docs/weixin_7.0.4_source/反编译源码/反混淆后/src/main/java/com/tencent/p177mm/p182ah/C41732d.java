package com.tencent.p177mm.p182ah;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.cache.C18129e.C18130a;
import com.tencent.p177mm.compatible.p222g.C1434a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1376bv.p1377a.C32428a;
import com.tencent.p177mm.p1376bv.p1377a.C32428a.C25995a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.sdk.p603e.C4934l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
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

/* renamed from: com.tencent.mm.ah.d */
public final class C41732d {
    private static C17877a frB = new C17877a(frw);
    private static int frv = 150;
    private static int frw = 150;
    static final Map<String, Integer> frx;
    private final C8915a frA = new C374372();
    private C4934l<C8915a, String> fry = new C257491();
    private final List<WeakReference<C8915a>> frz = new ArrayList();

    /* renamed from: com.tencent.mm.ah.d$b */
    public static class C1195b {
        /* renamed from: qk */
        public static boolean m2628qk(String str) {
            AppMethodBeat.m2504i(77875);
            Bitmap ql = C1195b.m2629ql(str);
            if (ql == null || ql.isRecycled()) {
                AppMethodBeat.m2505o(77875);
                return false;
            }
            OutputStream outputStream = null;
            try {
                outputStream = C5730e.m8617L(str, false);
                ql.compress(CompressFormat.PNG, 100, outputStream);
                C5730e.deleteFile(str + ".bm");
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                    }
                }
                AppMethodBeat.m2505o(77875);
                return true;
            } catch (IOException e2) {
                C4990ab.printErrStackTrace("MicroMsg.AvatarStorage", e2, "Cannot write avatar file: %s", str);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                    }
                }
                AppMethodBeat.m2505o(77875);
                return false;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
                AppMethodBeat.m2505o(77875);
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
        /* renamed from: ql */
        public static Bitmap m2629ql(String str) {
            Exception e;
            OutOfMemoryError e2;
            AppMethodBeat.m2504i(77876);
            String str2 = str + ".bm";
            boolean z = true;
            ReadableByteChannel readableByteChannel = null;
            InputStream openRead;
            try {
                if (C5730e.m8628ct(str2)) {
                    int asZ = (int) C5730e.asZ(str2);
                    if (asZ <= 0 || !(asZ == 36864 || asZ == 36880)) {
                        C1195b.remove(str);
                        C4990ab.m7413e("MicroMsg.AvatarStorage", "SmallBM get bm invalid size:%d file:%s", Integer.valueOf(asZ), str2);
                        AppMethodBeat.m2505o(77876);
                        return null;
                    }
                    openRead = C5730e.openRead(str2);
                    try {
                        readableByteChannel = Channels.newChannel(openRead);
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(36864);
                        readableByteChannel.read(allocateDirect);
                        allocateDirect.position(0);
                        if (asZ == 36880) {
                            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(16);
                            readableByteChannel.read(allocateDirect2);
                            if (allocateDirect2.getLong(0) != 1) {
                                C4990ab.m7413e("MicroMsg.AvatarStorage", "SmallBM get bm header invalid flag:%d size:%d file:%s", Long.valueOf(allocateDirect2.getLong(0)), Integer.valueOf(asZ), str2);
                                readableByteChannel.close();
                                openRead.close();
                                C1195b.remove(str);
                                AppMethodBeat.m2505o(77876);
                                return null;
                            }
                            z = false;
                        }
                        C4990ab.m7411d("MicroMsg.AvatarStorage", "SmallBM get bm size:%d shouldRemoveCorner:%b file:%s", Integer.valueOf(asZ), Boolean.valueOf(z), str2);
                        readableByteChannel.close();
                        try {
                            openRead.close();
                            Bitmap createBitmap = Bitmap.createBitmap(96, 96, Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(allocateDirect);
                            if (z) {
                                Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 9, 9, 78, 78);
                                C4990ab.m7417i("MicroMsg.AvatarStorage", "recycle bitmap:%s", createBitmap.toString());
                                createBitmap.recycle();
                                AppMethodBeat.m2505o(77876);
                                return createBitmap2;
                            }
                            AppMethodBeat.m2505o(77876);
                            return createBitmap;
                        } catch (Exception e3) {
                            e = e3;
                            readableByteChannel = null;
                            C4990ab.m7413e("MicroMsg.AvatarStorage", "SmallBM get exception e:%s file:%s", e.getMessage(), str2);
                            if (readableByteChannel != null) {
                            }
                            if (openRead != null) {
                            }
                            AppMethodBeat.m2505o(77876);
                            return null;
                        } catch (OutOfMemoryError e4) {
                            e2 = e4;
                            readableByteChannel = null;
                            C4990ab.m7413e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                            if (readableByteChannel != null) {
                            }
                            if (openRead != null) {
                            }
                            AppMethodBeat.m2505o(77876);
                            return null;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        C4990ab.m7413e("MicroMsg.AvatarStorage", "SmallBM get exception e:%s file:%s", e.getMessage(), str2);
                        if (readableByteChannel != null) {
                        }
                        if (openRead != null) {
                        }
                        AppMethodBeat.m2505o(77876);
                        return null;
                    } catch (OutOfMemoryError e6) {
                        e2 = e6;
                        C4990ab.m7413e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                        if (readableByteChannel != null) {
                        }
                        if (openRead != null) {
                        }
                        AppMethodBeat.m2505o(77876);
                        return null;
                    }
                }
                C4990ab.m7411d("MicroMsg.AvatarStorage", "SmallBM get bm file not exsit:%s", str2);
                AppMethodBeat.m2505o(77876);
                return null;
            } catch (Exception e7) {
                e = e7;
                openRead = null;
            } catch (OutOfMemoryError e8) {
                e2 = e8;
                openRead = null;
                C4990ab.m7413e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                if (readableByteChannel != null) {
                    try {
                        readableByteChannel.close();
                    } catch (Exception e9) {
                        AppMethodBeat.m2505o(77876);
                        return null;
                    }
                }
                if (openRead != null) {
                    openRead.close();
                }
                AppMethodBeat.m2505o(77876);
                return null;
            }
        }

        static boolean remove(String str) {
            AppMethodBeat.m2504i(77877);
            C5730e.deleteFile(str + ".bm");
            C5730e.deleteFile(str);
            AppMethodBeat.m2505o(77877);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ah.d$a */
    public interface C8915a {
        /* renamed from: qj */
        void mo20342qj(String str);
    }

    /* renamed from: com.tencent.mm.ah.d$1 */
    class C257491 extends C4934l<C8915a, String> {
        C257491() {
        }

        /* renamed from: w */
        public final /* synthetic */ void mo10134w(Object obj, Object obj2) {
            AppMethodBeat.m2504i(77873);
            ((C8915a) obj).mo20342qj((String) obj2);
            AppMethodBeat.m2505o(77873);
        }
    }

    /* renamed from: com.tencent.mm.ah.d$2 */
    class C374372 implements C8915a {
        C374372() {
        }

        /* renamed from: qj */
        public final void mo20342qj(String str) {
            C8915a c8915a;
            AppMethodBeat.m2504i(77874);
            C4990ab.m7411d("MicroMsg.AvatarStorage", "notifyChanged user:%s clonesize:%d watchers:%d", str, Integer.valueOf(C41732d.this.frz.size()), Integer.valueOf(C41732d.this.frz.size()));
            ArrayList<C8915a> arrayList = new ArrayList();
            synchronized (C41732d.this.frz) {
                try {
                    Iterator it = C41732d.this.frz.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (weakReference != null) {
                            c8915a = (C8915a) weakReference.get();
                            if (c8915a != null) {
                                arrayList.add(c8915a);
                            } else {
                                it.remove();
                            }
                        }
                    }
                } finally {
                    AppMethodBeat.m2505o(77874);
                }
            }
            for (C8915a c8915a2 : arrayList) {
                c8915a2.mo20342qj(str);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(77904);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        frx = concurrentHashMap;
        concurrentHashMap.put("voipapp", Integer.valueOf(C1318a.default_voip));
        frx.put("qqmail", Integer.valueOf(C1318a.default_qqmail));
        frx.put("fmessage", Integer.valueOf(C1318a.default_fmessage));
        frx.put("floatbottle", Integer.valueOf(C1318a.default_bottle));
        frx.put("lbsapp", Integer.valueOf(C1318a.default_nearby));
        frx.put("shakeapp", Integer.valueOf(C1318a.default_shake));
        frx.put("medianote", Integer.valueOf(C1318a.default_medianote));
        frx.put("qqfriend", Integer.valueOf(C1318a.default_qqfriend));
        frx.put("masssendapp", Integer.valueOf(C1318a.default_masssend));
        frx.put("feedsapp", Integer.valueOf(C1318a.default_feedsapp));
        frx.put("facebookapp", Integer.valueOf(C1318a.default_facebookapp));
        frx.put("newsapp", Integer.valueOf(C1318a.default_readerapp));
        frx.put("helper_entry", Integer.valueOf(C1318a.default_plugin_icon_contract));
        frx.put("voicevoipapp", Integer.valueOf(C1318a.default_voicevoip));
        frx.put("voiceinputapp", Integer.valueOf(C1318a.default_voiceinput));
        frx.put("officialaccounts", Integer.valueOf(C1318a.default_brand_contact));
        frx.put("service_officialaccounts", Integer.valueOf(C1318a.default_servicebrand_contact));
        frx.put("linkedinplugin", Integer.valueOf(C1318a.default_linkedin));
        frx.put("notifymessage", Integer.valueOf(C1318a.default_notify_message_contact));
        frx.put("appbrandcustomerservicemsg", Integer.valueOf(C1318a.default_app_brand_service_msg));
        frx.put("downloaderapp", Integer.valueOf(C1318a.default_downloaderapp));
        AppMethodBeat.m2505o(77904);
    }

    /* renamed from: a */
    public static void m73519a(Context context, ImageView imageView, int i) {
        AppMethodBeat.m2504i(77878);
        try {
            imageView.setImageBitmap(C5056d.m7616a(C1434a.decodeResource(context.getResources(), i), true, 1.0f));
            AppMethodBeat.m2505o(77878);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AvatarStorage", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(77878);
        }
    }

    public C41732d() {
        AppMethodBeat.m2504i(77879);
        C41732d.reset();
        this.fry.mo10125a(this.frA, null);
        AppMethodBeat.m2505o(77879);
    }

    /* renamed from: a */
    public final void mo67498a(C8915a c8915a) {
        AppMethodBeat.m2504i(77880);
        synchronized (this.frz) {
            try {
                this.frz.add(new WeakReference(c8915a));
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(77880);
            }
        }
    }

    /* renamed from: b */
    public final void mo67500b(C8915a c8915a) {
        AppMethodBeat.m2504i(77881);
        synchronized (this.frz) {
            try {
                WeakReference c = m73520c(c8915a);
                if (c != null) {
                    this.frz.remove(c);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(77881);
            }
        }
    }

    /* renamed from: c */
    private WeakReference<C8915a> m73520c(C8915a c8915a) {
        AppMethodBeat.m2504i(77882);
        synchronized (this.frz) {
            WeakReference<C8915a> weakReference;
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 < this.frz.size()) {
                        weakReference = (WeakReference) this.frz.get(i2);
                        if (weakReference != null) {
                            C8915a c8915a2 = (C8915a) weakReference.get();
                            if (c8915a2 != null && c8915a2.equals(c8915a)) {
                                break;
                            }
                        }
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.m2505o(77882);
                        return null;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(77882);
                }
            }
            return weakReference;
        }
    }

    @Deprecated
    /* renamed from: d */
    public final void mo67502d(C8915a c8915a) {
        AppMethodBeat.m2504i(77883);
        this.fry.mo10125a(c8915a, Looper.getMainLooper());
        AppMethodBeat.m2505o(77883);
    }

    @Deprecated
    /* renamed from: e */
    public final void mo67503e(C8915a c8915a) {
        AppMethodBeat.m2504i(77884);
        this.fry.remove(c8915a);
        AppMethodBeat.m2505o(77884);
    }

    public static void reset() {
        AppMethodBeat.m2504i(77885);
        if (frB == null) {
            frB = new C17877a(frw);
        }
        AppMethodBeat.m2505o(77885);
    }

    /* renamed from: qd */
    public static Bitmap m73523qd(String str) {
        AppMethodBeat.m2504i(77886);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(77886);
            return null;
        }
        Bitmap bitmap;
        C17877a c17877a = frB;
        if (c17877a.fra != null) {
            bitmap = (Bitmap) c17877a.fra.mo4404ai(str);
        } else {
            bitmap = (Bitmap) C18130a.m28562J("avatar_cache", str);
        }
        if (bitmap == null) {
            AppMethodBeat.m2505o(77886);
            return null;
        } else if (bitmap.isRecycled()) {
            c17877a = frB;
            if (c17877a.fra != null) {
                c17877a.fra.remove(str);
            } else {
                C18130a.m28563K("avatar_cache", str);
            }
            AppMethodBeat.m2505o(77886);
            return null;
        } else {
            AppMethodBeat.m2505o(77886);
            return bitmap;
        }
    }

    /* renamed from: e */
    public final void mo67504e(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(77887);
        frB.mo33378d(str, bitmap);
        C32428a c32428a = C25995a.xtT;
        if (c32428a != null) {
            c32428a.mo53068Dp(str);
        }
        this.fry.mo10126cF(str);
        this.fry.doNotify();
        C4990ab.m7411d("MicroMsg.AvatarStorage", "setToCache %s", str);
        AppMethodBeat.m2505o(77887);
    }

    /* renamed from: bU */
    public final Bitmap mo67501bU(Context context) {
        AppMethodBeat.m2504i(77888);
        context.getResources();
        Bitmap qd = C41732d.m73523qd("I_AM_NO_SDCARD_USER_NAME");
        if (!(C41732d.m73513B(qd) || qd == null)) {
            C4990ab.m7417i("MicroMsg.AvatarStorage", "not cached, recycled=%b, reload=%s", Boolean.valueOf(qd.isRecycled()), "I_AM_NO_SDCARD_USER_NAME");
            qd = C5056d.m7616a(qd, true, 1.0f);
            mo67504e("I_AM_NO_SDCARD_USER_NAME", qd);
        }
        AppMethodBeat.m2505o(77888);
        return qd;
    }

    /* renamed from: a */
    private static StringBuilder m73517a(StringBuilder stringBuilder, String str, boolean z) {
        AppMethodBeat.m2504i(77889);
        String x = C1178g.m2591x(str.getBytes());
        stringBuilder.append(x.substring(0, 2)).append(IOUtils.DIR_SEPARATOR_UNIX).append(x.substring(2, 4)).append(IOUtils.DIR_SEPARATOR_UNIX).append("user_");
        if (z) {
            stringBuilder.append("hd_");
        }
        StringBuilder append = stringBuilder.append(x).append(".png");
        AppMethodBeat.m2505o(77889);
        return append;
    }

    /* renamed from: C */
    public static String m73514C(String str, boolean z) {
        AppMethodBeat.m2504i(77890);
        String stringBuilder = C41732d.m73517a(new StringBuilder(64).append("wcf://avatar/"), str, z).toString();
        C5730e.m8643tf(C5730e.atb(stringBuilder));
        AppMethodBeat.m2505o(77890);
        return stringBuilder;
    }

    /* renamed from: D */
    public static String m73515D(String str, boolean z) {
        AppMethodBeat.m2504i(77891);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(77891);
            return null;
        }
        String stringBuilder = C41732d.m73517a(new StringBuilder(128).append(C1720g.m3536RP().cachePath).append("avatar/"), str, z).toString();
        if (C5730e.m8643tf(C5730e.atb(stringBuilder))) {
            AppMethodBeat.m2505o(77891);
            return stringBuilder;
        }
        AppMethodBeat.m2505o(77891);
        return null;
    }

    /* renamed from: qe */
    public static boolean m73524qe(String str) {
        AppMethodBeat.m2504i(77892);
        String C = C41732d.m73514C(str, false);
        if (C5730e.m8628ct(C) || C5730e.m8628ct(C + ".bm")) {
            AppMethodBeat.m2505o(77892);
            return true;
        }
        AppMethodBeat.m2505o(77892);
        return false;
    }

    /* renamed from: E */
    public static boolean m73516E(String str, boolean z) {
        AppMethodBeat.m2504i(77893);
        String C = C41732d.m73514C(str, z);
        C4990ab.m7417i("MicroMsg.AvatarStorage", "Removed avatar: %s, hd: %b, path: %s", str, Boolean.valueOf(z), C);
        boolean deleteFile = C5730e.deleteFile(C);
        if (!z) {
            deleteFile |= C1195b.remove(C);
        }
        AppMethodBeat.m2505o(77893);
        return deleteFile;
    }

    /* renamed from: qf */
    public static Bitmap m73525qf(String str) {
        AppMethodBeat.m2504i(77894);
        Bitmap qi = C41732d.m73528qi(C41732d.m73514C(str, false));
        AppMethodBeat.m2505o(77894);
        return qi;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0079 A:{SYNTHETIC, Splitter:B:23:0x0079} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0085 A:{SYNTHETIC, Splitter:B:29:0x0085} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: m */
    public static Bitmap m73522m(String str, byte[] bArr) {
        Throwable e;
        AppMethodBeat.m2504i(77895);
        Bitmap decodeByteArray = C5056d.decodeByteArray(bArr, 96, 96);
        if (C41732d.m73513B(decodeByteArray)) {
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
                L = C5730e.m8617L(C41732d.m73514C(str, false), false);
                try {
                    L.write(bArr, 0, bArr.length);
                    if (L != null) {
                        try {
                            L.close();
                        } catch (IOException e2) {
                        }
                    }
                    C4990ab.m7417i("MicroMsg.AvatarStorage", "Saved avatar: %s", str);
                    AppMethodBeat.m2505o(77895);
                    return decodeByteArray;
                } catch (IOException e3) {
                    e = e3;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                        if (L != null) {
                            try {
                                L.close();
                            } catch (IOException e4) {
                            }
                        }
                        AppMethodBeat.m2505o(77895);
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (L != null) {
                            try {
                                L.close();
                            } catch (IOException e5) {
                            }
                        }
                        AppMethodBeat.m2505o(77895);
                        throw e;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                L = null;
                C4990ab.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                if (L != null) {
                }
                AppMethodBeat.m2505o(77895);
                return null;
            } catch (Throwable th2) {
                e = th2;
                L = null;
                if (L != null) {
                }
                AppMethodBeat.m2505o(77895);
                throw e;
            }
        }
        C4990ab.m7413e("MicroMsg.AvatarStorage", "Failed to decode avatar: %s", str);
        AppMethodBeat.m2505o(77895);
        return null;
    }

    /* renamed from: n */
    public final boolean mo67506n(String str, byte[] bArr) {
        AppMethodBeat.m2504i(77896);
        Bitmap m = C41732d.m73522m(str, bArr);
        if (C41732d.m73513B(m)) {
            mo67504e(str, m);
            AppMethodBeat.m2505o(77896);
            return true;
        }
        AppMethodBeat.m2505o(77896);
        return false;
    }

    /* renamed from: au */
    public final boolean mo67499au(String str, String str2) {
        boolean z = false;
        AppMethodBeat.m2504i(77897);
        try {
            int i;
            int i2;
            Options amj = C5056d.amj(str);
            int i3 = amj.outWidth;
            int i4 = amj.outHeight;
            if (i4 < i3) {
                i = (i3 * 96) / i4;
                i2 = 96;
            } else {
                i2 = (i4 * 96) / i3;
                i = 96;
            }
            C4990ab.m7411d("MicroMsg.AvatarStorage", "inJustDecodeBounds old [w:%d h:%d]  new [w:%d h:%d] corner:%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(1));
            Options options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            options.inSampleSize = Math.min(i3 / i, i4 / i2);
            z = mo67505f(str2, C5056d.decodeFile(str, options));
            AppMethodBeat.m2505o(77897);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AvatarStorage", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(77897);
        }
        return z;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d8 A:{SYNTHETIC, Splitter:B:44:0x00d8} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d8 A:{SYNTHETIC, Splitter:B:44:0x00d8} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    public final boolean mo67505f(String str, Bitmap bitmap) {
        Throwable e;
        OutputStream outputStream;
        AppMethodBeat.m2504i(77898);
        if (C41732d.m73513B(bitmap)) {
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
                    C4990ab.m7413e("MicroMsg.AvatarStorage", "kevin updateAvatar fail  %s ", str);
                    if (C41732d.m73513B(bitmap)) {
                        C4990ab.m7417i("MicroMsg.AvatarStorage", "recycle bitmap:%s", bitmap.toString());
                        bitmap.recycle();
                    }
                    AppMethodBeat.m2505o(77898);
                    return false;
                }
            }
            if (!(bitmap2 == null || bitmap2 == bitmap)) {
                C4990ab.m7417i("MicroMsg.AvatarStorage", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
                bitmap = bitmap2;
            }
            OutputStream outputStream2 = null;
            try {
                outputStream2 = C5730e.m8617L(C41732d.m73514C(str, false), false);
                try {
                    bitmap.compress(CompressFormat.PNG, 100, outputStream2);
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    mo67504e(str, bitmap);
                    AppMethodBeat.m2505o(77898);
                    return true;
                } catch (IOException e4) {
                    e = e4;
                    outputStream = outputStream2;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        AppMethodBeat.m2505o(77898);
                        return false;
                    } catch (Throwable th) {
                        e = th;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                        AppMethodBeat.m2505o(77898);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    outputStream = outputStream2;
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(77898);
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
                AppMethodBeat.m2505o(77898);
                throw e;
            }
        }
        AppMethodBeat.m2505o(77898);
        return false;
    }

    /* renamed from: j */
    public static Bitmap m73521j(String str, int i, int i2) {
        AppMethodBeat.m2504i(77899);
        C4990ab.m7411d("MicroMsg.AvatarStorage", "getHDBitmap user:%s, width:%d, height:%d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(77899);
            return null;
        }
        Bitmap ap = C5056d.m7642ap(C41732d.m73514C(str, true), i, i2);
        AppMethodBeat.m2505o(77899);
        return ap;
    }

    /* renamed from: qg */
    public static Bitmap m73526qg(String str) {
        AppMethodBeat.m2504i(77900);
        C4990ab.m7411d("MicroMsg.AvatarStorage", "getHDBitmap user:%s", str);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(77900);
            return null;
        }
        Bitmap ap = C5056d.m7642ap(C41732d.m73514C(str, true), 480, 480);
        AppMethodBeat.m2505o(77900);
        return ap;
    }

    /* renamed from: qh */
    public static Bitmap m73527qh(String str) {
        Bitmap decodeResource;
        AppMethodBeat.m2504i(77901);
        int i = 0;
        if (frx.containsKey(str)) {
            i = ((Integer) frx.get(str)).intValue();
        }
        if (i != 0) {
            C17884o.acs();
            decodeResource = C1434a.decodeResource(C17884o.getContext().getResources(), i);
        } else {
            decodeResource = null;
        }
        decodeResource = C5056d.m7617a(decodeResource, true, 1.0f, true);
        AppMethodBeat.m2505o(77901);
        return decodeResource;
    }

    /* renamed from: B */
    private static boolean m73513B(Bitmap bitmap) {
        AppMethodBeat.m2504i(77902);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(77902);
            return false;
        }
        AppMethodBeat.m2505o(77902);
        return true;
    }

    /* renamed from: qi */
    public static Bitmap m73528qi(String str) {
        Bitmap decodeFile;
        AppMethodBeat.m2504i(77903);
        if (C5730e.m8628ct(str)) {
            decodeFile = C5056d.decodeFile(str, null);
        } else {
            decodeFile = null;
        }
        if (decodeFile == null) {
            decodeFile = C1195b.m2629ql(str);
        }
        if (C41732d.m73513B(decodeFile)) {
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
        if (C41732d.m73513B(decodeFile)) {
            AppMethodBeat.m2505o(77903);
            return decodeFile;
        }
        AppMethodBeat.m2505o(77903);
        return null;
    }
}
