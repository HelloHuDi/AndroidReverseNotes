package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C5837be;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ju */
public class C31069ju implements C46797jw {
    /* renamed from: a */
    private C41073ll f14298a;
    /* renamed from: b */
    private C24396jv f14299b;
    /* renamed from: c */
    private C31064js f14300c;
    /* renamed from: d */
    private volatile ExecutorService f14301d = null;

    public C31069ju(Context context) {
        AppMethodBeat.m2504i(100113);
        this.f14298a = C41073ll.m71458a(context);
        this.f14299b = new C24396jv(m50083a(context));
        this.f14300c = new C31064js();
        this.f14301d = Executors.newSingleThreadExecutor();
        AppMethodBeat.m2505o(100113);
    }

    /* renamed from: a */
    public Bitmap mo50496a(int i, int i2, int i3, byte[] bArr) {
        AppMethodBeat.m2504i(100114);
        C5837be c5837be = new C5837be(i, i2, i3, 1);
        Bitmap a = this.f14299b.mo40654a(c5837be.toString());
        if (a != null) {
            AppMethodBeat.m2505o(100114);
            return a;
        }
        Options c = m50089c();
        Bitmap a2 = this.f14299b.mo40653a();
        if (a2 != null) {
            c.inBitmap = a2;
        }
        c5837be.mo12302a(c);
        a = m50084a(c5837be);
        if (a != null) {
            this.f14299b.mo40655a(c5837be.toString(), a);
            AppMethodBeat.m2505o(100114);
            return a;
        }
        m50086a(c5837be, bArr);
        AppMethodBeat.m2505o(100114);
        return null;
    }

    /* renamed from: a */
    public void mo50498a(int i, int i2, int i3, final String str, final byte[] bArr) {
        AppMethodBeat.m2504i(100115);
        final C5837be c5837be = new C5837be(i, i2, i3, 1);
        if (m50088a(str)) {
            Options c = m50089c();
            Bitmap a = this.f14299b.mo40653a();
            if (a != null) {
                c.inBitmap = a;
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, c);
            if (decodeByteArray != null) {
                this.f14299b.mo40655a(c5837be.toString(), decodeByteArray);
                this.f14301d.execute(new Runnable() {
                    public void run() {
                        AppMethodBeat.m2504i(100112);
                        if (C31069ju.m50087a(C31069ju.this, str)) {
                            C31069ju.this.f14298a.mo65169a(bArr, c5837be);
                            AppMethodBeat.m2505o(100112);
                            return;
                        }
                        AppMethodBeat.m2505o(100112);
                    }
                });
            }
            AppMethodBeat.m2505o(100115);
            return;
        }
        AppMethodBeat.m2505o(100115);
    }

    /* renamed from: a */
    public void mo50497a() {
        AppMethodBeat.m2504i(100116);
        this.f14299b.mo40656b();
        this.f14298a.mo65168a(1);
        AppMethodBeat.m2505o(100116);
    }

    /* renamed from: b */
    public void mo50499b() {
        AppMethodBeat.m2504i(100117);
        this.f14299b.mo40657c();
        AppMethodBeat.m2505o(100117);
    }

    /* renamed from: a */
    private Bitmap m50084a(C5837be c5837be) {
        AppMethodBeat.m2504i(100118);
        if (c5837be == null) {
            AppMethodBeat.m2505o(100118);
            return null;
        }
        Options c = m50089c();
        Bitmap a = this.f14299b.mo40653a();
        if (a != null) {
            c.inBitmap = a;
        }
        c5837be.mo12302a(c);
        Bitmap a2 = this.f14298a.mo65165a(c5837be);
        AppMethodBeat.m2505o(100118);
        return a2;
    }

    /* renamed from: a */
    private void m50086a(C5837be c5837be, byte[] bArr) {
        AppMethodBeat.m2504i(100119);
        String a = this.f14300c.mo50492a(c5837be.mo12300a(), c5837be.mo12303b(), c5837be.mo12304c());
        if (a == null) {
            AppMethodBeat.m2505o(100119);
            return;
        }
        byte[] bytes = a.getBytes();
        Arrays.fill(bArr, (byte) 0);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        AppMethodBeat.m2505o(100119);
    }

    /* renamed from: c */
    private Options m50089c() {
        AppMethodBeat.m2504i(100120);
        Options options = new Options();
        options.inPreferredConfig = Config.ARGB_8888;
        options.inSampleSize = 1;
        options.outWidth = 256;
        options.outHeight = 256;
        options.inMutable = true;
        AppMethodBeat.m2505o(100120);
        return options;
    }

    /* renamed from: a */
    private boolean m50088a(String str) {
        AppMethodBeat.m2504i(100121);
        if (str != null && str.length() > 0) {
            Matcher matcher = Pattern.compile("version=\\d+").matcher(str);
            if (matcher.find()) {
                String group = matcher.group();
                if (Integer.parseInt(group.substring(group.indexOf("=") + 1)) == C46796jp.m88979a()) {
                    AppMethodBeat.m2505o(100121);
                    return true;
                }
                AppMethodBeat.m2505o(100121);
                return false;
            }
        }
        AppMethodBeat.m2505o(100121);
        return false;
    }

    /* renamed from: a */
    private int m50083a(Context context) {
        AppMethodBeat.m2504i(100122);
        int i = ((((int) (((((double) context.getResources().getDisplayMetrics().heightPixels) * 1.0d) / 256.0d) + 0.5d)) * 262144) * ((int) (((((double) context.getResources().getDisplayMetrics().widthPixels) * 1.0d) / 256.0d) + 0.5d))) * 3;
        AppMethodBeat.m2505o(100122);
        return i;
    }
}
