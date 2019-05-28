package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.map.lib.C8889f;
import com.tencent.map.lib.p822gl.JNICallback.C32210j;
import com.tencent.map.lib.p822gl.JNICallback.C32212k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C31001da;
import com.tencent.tencentmap.mapsdk.p666a.C36459bg;
import com.tencent.tencentmap.mapsdk.p666a.C5837be;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lo */
public class C41357lo extends C36519hz implements C32210j, C32212k {
    /* renamed from: a */
    C5907lt f16591a;
    /* renamed from: b */
    private WeakReference<C24415ls> f16592b;
    /* renamed from: c */
    private C41073ll f16593c;
    /* renamed from: d */
    private volatile int f16594d = -1;
    /* renamed from: e */
    private volatile ExecutorService f16595e = null;

    /* renamed from: b */
    static /* synthetic */ C31001da m72137b(C41357lo c41357lo, String str) {
        AppMethodBeat.m2504i(100462);
        C31001da b = c41357lo.m72138b(str);
        AppMethodBeat.m2505o(100462);
        return b;
    }

    public C41357lo(C24415ls c24415ls, C5907lt c5907lt) {
        AppMethodBeat.m2504i(100454);
        if (c24415ls == null || c24415ls.mo40736a() == null) {
            AppMethodBeat.m2505o(100454);
            return;
        }
        C8889f b = c24415ls.mo40736a().mo75386b();
        this.f16593c = C41073ll.m71458a(c24415ls.mo40736a().mo65138i().getApplicationContext());
        this.f16592b = new WeakReference(c24415ls);
        this.f16591a = c5907lt;
        b.mo20169a((C32210j) this);
        b.mo20170a((C32212k) this);
        this.f16594d = b.mo20216e(false);
        AppMethodBeat.m2505o(100454);
    }

    /* renamed from: a */
    public void mo29441a(GL10 gl10) {
    }

    /* renamed from: a */
    public boolean mo29444a(float f, float f2) {
        return false;
    }

    /* renamed from: a */
    public boolean mo29443a() {
        return false;
    }

    /* renamed from: b */
    public void mo29445b() {
    }

    /* renamed from: d */
    public void mo29450d() {
        AppMethodBeat.m2504i(100455);
        if (!(this.f16592b == null || this.f16592b.get() == null)) {
            C31061iz a = ((C24415ls) this.f16592b.get()).mo40736a();
            if (!(a == null || a.mo75386b() == null)) {
                C8889f b = a.mo75386b();
                b.mo20169a(null);
                b.mo20170a(null);
                b.mo20229i(this.f16594d);
                this.f16594d = -1;
            }
        }
        AppMethodBeat.m2505o(100455);
    }

    /* renamed from: c */
    public void mo29449c() {
    }

    /* renamed from: a */
    public Bitmap mo52882a(byte[] bArr) {
        AppMethodBeat.m2504i(100456);
        if (this.f16592b == null || this.f16592b.get() == null || this.f16594d == -1) {
            AppMethodBeat.m2505o(100456);
            return null;
        }
        C36459bg c36459bg = new C36459bg();
        c36459bg.mo57660a(bArr);
        C5837be c5837be = new C5837be(c36459bg.mo57659a(), c36459bg.mo57661b(), c36459bg.mo57662c(), 0, this.f16591a.mo12539a());
        Bitmap a = this.f16593c.mo65165a(c5837be);
        if (a != null) {
            AppMethodBeat.m2505o(100456);
            return a;
        }
        String a2 = this.f16591a.mo12540a(c5837be.mo12300a(), c5837be.mo12303b(), c5837be.mo12304c());
        if (a2 == null) {
            AppMethodBeat.m2505o(100456);
            return null;
        }
        byte[] bytes = a2.getBytes();
        Arrays.fill(bArr, (byte) 0);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        AppMethodBeat.m2505o(100456);
        return null;
    }

    /* renamed from: a */
    public void mo52884a(final String str, final byte[] bArr, final byte[] bArr2) {
        AppMethodBeat.m2504i(100457);
        if (this.f16595e == null) {
            synchronized (C41357lo.class) {
                try {
                    if (this.f16595e == null) {
                        this.f16595e = Executors.newSingleThreadExecutor();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(100457);
                    }
                }
            }
        }
        if (!this.f16595e.isShutdown()) {
            this.f16595e.execute(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(100453);
                    if (C41357lo.m72135a(C41357lo.this, str)) {
                        C36459bg c36459bg = new C36459bg();
                        c36459bg.mo57660a(bArr);
                        C5837be c5837be = new C5837be(c36459bg.mo57659a(), c36459bg.mo57661b(), c36459bg.mo57662c(), 0, C41357lo.m72137b(C41357lo.this, str));
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length);
                        if (decodeByteArray != null) {
                            if (!(C41357lo.this.f16592b == null || C41357lo.this.f16592b.get() == null)) {
                                ((C24415ls) C41357lo.this.f16592b.get()).mo40738a(1);
                            }
                            C41357lo.this.f16593c.mo65169a(C24388ht.m37845a(decodeByteArray, CompressFormat.PNG), c5837be);
                        }
                        AppMethodBeat.m2505o(100453);
                        return;
                    }
                    AppMethodBeat.m2505o(100453);
                }
            });
        }
        AppMethodBeat.m2505o(100457);
    }

    /* renamed from: e */
    public void mo66015e() {
        AppMethodBeat.m2504i(100458);
        if (!(this.f16594d == -1 || this.f16592b == null || this.f16592b.get() == null)) {
            ((C24415ls) this.f16592b.get()).mo40736a().mo75386b().mo20232j(this.f16594d);
        }
        AppMethodBeat.m2505o(100458);
    }

    /* renamed from: a */
    private boolean m72136a(String str) {
        AppMethodBeat.m2504i(100459);
        if (str != null && str.length() > 0) {
            Matcher matcher = Pattern.compile("version=\\d+").matcher(str);
            if (matcher.find()) {
                String group = matcher.group();
                if (Integer.parseInt(group.substring(group.indexOf("=") + 1)) == C24414lq.m37992c()) {
                    AppMethodBeat.m2505o(100459);
                    return true;
                }
                AppMethodBeat.m2505o(100459);
                return false;
            }
        }
        AppMethodBeat.m2505o(100459);
        return false;
    }

    /* renamed from: b */
    private C31001da m72138b(String str) {
        AppMethodBeat.m2504i(100460);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(100460);
            return null;
        }
        String str2 = "foreignLanguage";
        C31001da valueOf = C31001da.valueOf(str.substring((str2.length() + 1) + str.lastIndexOf(str2)));
        AppMethodBeat.m2505o(100460);
        return valueOf;
    }
}
