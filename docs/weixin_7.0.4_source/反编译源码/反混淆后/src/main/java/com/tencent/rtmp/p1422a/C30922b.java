package com.tencent.rtmp.p1422a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.rtmp.a.b */
public class C30922b implements C44447a {
    /* renamed from: a */
    private final Options f13781a;
    /* renamed from: b */
    private HandlerThread f13782b;
    /* renamed from: c */
    private Handler f13783c;
    /* renamed from: d */
    private List<C30926c> f13784d;
    /* renamed from: e */
    private Map<String, BitmapRegionDecoder> f13785e;

    /* renamed from: com.tencent.rtmp.a.b$1 */
    class C309231 implements Runnable {
        C309231() {
        }

        public void run() {
            AppMethodBeat.m2504i(65978);
            if (C30922b.this.f13784d != null) {
                C30922b.this.f13784d.clear();
            }
            if (C30922b.this.f13785e != null) {
                for (BitmapRegionDecoder bitmapRegionDecoder : C30922b.this.f13785e.values()) {
                    if (bitmapRegionDecoder != null) {
                        bitmapRegionDecoder.recycle();
                    }
                }
                C30922b.this.f13785e.clear();
            }
            AppMethodBeat.m2505o(65978);
        }
    }

    /* renamed from: com.tencent.rtmp.a.b$b */
    static class C30924b implements Runnable {
        /* renamed from: a */
        private WeakReference<C30922b> f13787a;
        /* renamed from: b */
        private String f13788b;
        /* renamed from: c */
        private String f13789c;

        public C30924b(C30922b c30922b, String str, String str2) {
            AppMethodBeat.m2504i(65973);
            this.f13787a = new WeakReference(c30922b);
            this.f13788b = str;
            this.f13789c = str2;
            AppMethodBeat.m2505o(65973);
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x006f A:{Splitter:B:4:0x0015, ExcHandler: all (th java.lang.Throwable)} */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:21:0x0060, code skipped:
            r0 = r1;
     */
        /* JADX WARNING: Missing block: B:29:0x0070, code skipped:
            if (r1 != null) goto L_0x0072;
     */
        /* JADX WARNING: Missing block: B:31:?, code skipped:
            r1.close();
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            InputStream inputStream;
            AppMethodBeat.m2504i(65974);
            C30922b c30922b = (C30922b) this.f13787a.get();
            if (!(this.f13787a == null || c30922b == null)) {
                InputStream inputStream2 = null;
                try {
                    inputStream2 = C30922b.m49372a(c30922b, this.f13789c);
                    int lastIndexOf = this.f13789c.lastIndexOf("/");
                    if (lastIndexOf != -1 && lastIndexOf + 1 < this.f13789c.length()) {
                        String substring = this.f13789c.substring(lastIndexOf + 1, this.f13789c.length());
                        if (c30922b.f13785e != null) {
                            c30922b.f13785e.put(substring, BitmapRegionDecoder.newInstance(inputStream2, true));
                        }
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                            AppMethodBeat.m2505o(65974);
                            return;
                        } catch (IOException e) {
                            AppMethodBeat.m2505o(65974);
                            return;
                        }
                    }
                } catch (IOException e2) {
                    inputStream = inputStream2;
                } catch (Throwable th) {
                }
            }
            AppMethodBeat.m2505o(65974);
            return;
            if (inputStream != null) {
                try {
                    inputStream.close();
                    AppMethodBeat.m2505o(65974);
                    return;
                } catch (IOException e3) {
                    AppMethodBeat.m2505o(65974);
                    return;
                }
            }
            AppMethodBeat.m2505o(65974);
            return;
            AppMethodBeat.m2505o(65974);
        }
    }

    /* renamed from: com.tencent.rtmp.a.b$a */
    static class C30925a implements Runnable {
        /* renamed from: a */
        private WeakReference<C30922b> f13790a;
        /* renamed from: b */
        private String f13791b;

        public C30925a(C30922b c30922b, String str) {
            AppMethodBeat.m2504i(65975);
            this.f13790a = new WeakReference(c30922b);
            this.f13791b = str;
            AppMethodBeat.m2505o(65975);
        }

        /* renamed from: a */
        private float m49379a(String str) {
            String str2;
            String str3;
            String str4;
            float f = 0.0f;
            AppMethodBeat.m2504i(65976);
            String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            if (split.length == 3) {
                str2 = split[0];
                String str5 = split[1];
                str3 = split[2];
                str4 = str5;
            } else if (split.length == 2) {
                str4 = split[0];
                str3 = split[1];
                str2 = null;
            } else if (split.length == 1) {
                str3 = split[0];
                str4 = null;
                str2 = null;
            } else {
                str3 = null;
                str4 = null;
                str2 = null;
            }
            if (str2 != null) {
            }
            if (str4 != null) {
                f = 0.0f + (Float.valueOf(str4).floatValue() * 60.0f);
            }
            if (str3 != null) {
                f += Float.valueOf(str3).floatValue();
            }
            AppMethodBeat.m2505o(65976);
            return f;
        }

        /* JADX WARNING: Removed duplicated region for block: B:60:0x012b A:{SYNTHETIC, Splitter:B:60:0x012b} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            BufferedReader bufferedReader;
            Throwable th;
            AppMethodBeat.m2504i(65977);
            C30922b c30922b = (C30922b) this.f13790a.get();
            BufferedReader bufferedReader2;
            try {
                InputStream a = C30922b.m49372a(c30922b, this.f13791b);
                if (a == null) {
                    AppMethodBeat.m2505o(65977);
                    return;
                }
                bufferedReader2 = new BufferedReader(new InputStreamReader(a));
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null || readLine.length() == 0 || !readLine.contains("WEBVTT")) {
                        TXCLog.m15676e("TXImageSprite", "DownloadAndParseVTTFileTask : getVTT File Error!");
                        if (c30922b != null) {
                            C30922b.m49378c(c30922b);
                        }
                        try {
                            bufferedReader2.close();
                            AppMethodBeat.m2505o(65977);
                            return;
                        } catch (IOException e) {
                            AppMethodBeat.m2505o(65977);
                            return;
                        }
                    }
                    do {
                        readLine = bufferedReader2.readLine();
                        if (readLine != null && readLine.contains("-->")) {
                            String[] split = readLine.split(" --> ");
                            if (split.length == 2) {
                                String readLine2 = bufferedReader2.readLine();
                                C30926c c30926c = new C30926c();
                                c30926c.f13792a = m49379a(split[0]);
                                c30926c.f13793b = m49379a(split[1]);
                                c30926c.f13794c = readLine2;
                                int indexOf = readLine2.indexOf("#");
                                if (indexOf != -1) {
                                    c30926c.f13795d = readLine2.substring(0, indexOf);
                                }
                                indexOf = readLine2.indexOf("=");
                                if (indexOf != -1 && indexOf + 1 < readLine2.length()) {
                                    split = readLine2.substring(indexOf + 1, readLine2.length()).split(",");
                                    if (split.length == 4) {
                                        c30926c.f13796e = Integer.valueOf(split[0]).intValue();
                                        c30926c.f13797f = Integer.valueOf(split[1]).intValue();
                                        c30926c.f13798g = Integer.valueOf(split[2]).intValue();
                                        c30926c.f13799h = Integer.valueOf(split[3]).intValue();
                                    }
                                }
                                if (!(c30922b == null || c30922b.f13784d == null)) {
                                    c30922b.f13784d.add(c30926c);
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    } while (readLine != null);
                    try {
                        bufferedReader2.close();
                        AppMethodBeat.m2505o(65977);
                    } catch (IOException e2) {
                        AppMethodBeat.m2505o(65977);
                    }
                } catch (IOException e3) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            AppMethodBeat.m2505o(65977);
                            return;
                        } catch (IOException e4) {
                            AppMethodBeat.m2505o(65977);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(65977);
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader2 != null) {
                    }
                    AppMethodBeat.m2505o(65977);
                    throw th;
                }
            } catch (IOException e5) {
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader2 = null;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e6) {
                    }
                }
                AppMethodBeat.m2505o(65977);
                throw th;
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ InputStream m49372a(C30922b c30922b, String str) {
        AppMethodBeat.m2504i(65987);
        InputStream a = c30922b.m49373a(str);
        AppMethodBeat.m2505o(65987);
        return a;
    }

    /* renamed from: c */
    static /* synthetic */ void m49378c(C30922b c30922b) {
        AppMethodBeat.m2504i(65988);
        c30922b.m49377b();
        AppMethodBeat.m2505o(65988);
    }

    public C30922b() {
        AppMethodBeat.m2504i(65979);
        this.f13781a = new Options();
        this.f13784d = new ArrayList();
        this.f13784d = Collections.synchronizedList(this.f13784d);
        this.f13785e = new HashMap();
        this.f13785e = Collections.synchronizedMap(this.f13785e);
        AppMethodBeat.m2505o(65979);
    }

    public void setVTTUrlAndImageUrls(String str, List<String> list) {
        AppMethodBeat.m2504i(65980);
        if (TextUtils.isEmpty(str)) {
            TXCLog.m15676e("TXImageSprite", "setVTTUrlAndImageUrls: vttUrl can't be null!");
            AppMethodBeat.m2505o(65980);
            return;
        }
        m49377b();
        m49375a();
        this.f13783c.post(new C30925a(this, str));
        if (!(list == null || list.size() == 0)) {
            for (String c30924b : list) {
                this.f13783c.post(new C30924b(this, str, c30924b));
            }
        }
        AppMethodBeat.m2505o(65980);
    }

    public Bitmap getThumbnail(float f) {
        AppMethodBeat.m2504i(65981);
        if (this.f13784d.size() == 0) {
            AppMethodBeat.m2505o(65981);
            return null;
        }
        C30926c a = m49371a(0, this.f13784d.size() - 1, f);
        if (a == null) {
            AppMethodBeat.m2505o(65981);
            return null;
        }
        BitmapRegionDecoder bitmapRegionDecoder = (BitmapRegionDecoder) this.f13785e.get(a.f13795d);
        if (bitmapRegionDecoder == null) {
            AppMethodBeat.m2505o(65981);
            return null;
        }
        Rect rect = new Rect();
        rect.left = a.f13796e;
        rect.top = a.f13797f;
        rect.right = a.f13796e + a.f13798g;
        rect.bottom = a.f13799h + a.f13797f;
        Bitmap decodeRegion = bitmapRegionDecoder.decodeRegion(rect, this.f13781a);
        AppMethodBeat.m2505o(65981);
        return decodeRegion;
    }

    public void release() {
        AppMethodBeat.m2504i(65982);
        m49377b();
        if (!(this.f13782b == null || this.f13783c == null)) {
            if (VERSION.SDK_INT >= 18) {
                this.f13782b.quitSafely();
            } else {
                this.f13782b.quit();
            }
            this.f13783c = null;
            this.f13782b = null;
        }
        AppMethodBeat.m2505o(65982);
    }

    /* renamed from: a */
    private C30926c m49371a(int i, int i2, float f) {
        AppMethodBeat.m2504i(65983);
        while (true) {
            int i3 = ((i2 - i) / 2) + i;
            C30926c c30926c;
            if (((C30926c) this.f13784d.get(i3)).f13792a <= f && ((C30926c) this.f13784d.get(i3)).f13793b > f) {
                c30926c = (C30926c) this.f13784d.get(i3);
                AppMethodBeat.m2505o(65983);
                return c30926c;
            } else if (i >= i2) {
                c30926c = (C30926c) this.f13784d.get(i);
                AppMethodBeat.m2505o(65983);
                return c30926c;
            } else if (f >= ((C30926c) this.f13784d.get(i3)).f13793b) {
                i = i3 + 1;
            } else if (f < ((C30926c) this.f13784d.get(i3)).f13792a) {
                i2 = i3 - 1;
            } else {
                AppMethodBeat.m2505o(65983);
                return null;
            }
        }
    }

    /* renamed from: a */
    private void m49375a() {
        AppMethodBeat.m2504i(65984);
        if (this.f13782b == null) {
            this.f13782b = new HandlerThread("SuperVodThumbnailsWorkThread");
            this.f13782b.start();
            this.f13783c = new Handler(this.f13782b.getLooper());
        }
        AppMethodBeat.m2505o(65984);
    }

    /* renamed from: b */
    private void m49377b() {
        AppMethodBeat.m2504i(65985);
        if (this.f13783c != null) {
            TXCLog.m15677i("TXImageSprite", " remove all tasks!");
            this.f13783c.removeCallbacksAndMessages(null);
            this.f13783c.post(new C309231());
        }
        AppMethodBeat.m2505o(65985);
    }

    /* renamed from: a */
    private InputStream m49373a(String str) {
        AppMethodBeat.m2504i(65986);
        URLConnection openConnection = new URL(str).openConnection();
        openConnection.connect();
        openConnection.getInputStream();
        openConnection.setConnectTimeout(15000);
        openConnection.setReadTimeout(15000);
        InputStream inputStream = openConnection.getInputStream();
        AppMethodBeat.m2505o(65986);
        return inputStream;
    }
}
