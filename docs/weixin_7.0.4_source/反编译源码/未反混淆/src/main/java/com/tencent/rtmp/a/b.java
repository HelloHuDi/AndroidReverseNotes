package com.tencent.rtmp.a;

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

public class b implements a {
    private final Options a;
    private HandlerThread b;
    private Handler c;
    private List<c> d;
    private Map<String, BitmapRegionDecoder> e;

    static class b implements Runnable {
        private WeakReference<b> a;
        private String b;
        private String c;

        public b(b bVar, String str, String str2) {
            AppMethodBeat.i(65973);
            this.a = new WeakReference(bVar);
            this.b = str;
            this.c = str2;
            AppMethodBeat.o(65973);
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
            AppMethodBeat.i(65974);
            b bVar = (b) this.a.get();
            if (!(this.a == null || bVar == null)) {
                InputStream inputStream2 = null;
                try {
                    inputStream2 = b.a(bVar, this.c);
                    int lastIndexOf = this.c.lastIndexOf("/");
                    if (lastIndexOf != -1 && lastIndexOf + 1 < this.c.length()) {
                        String substring = this.c.substring(lastIndexOf + 1, this.c.length());
                        if (bVar.e != null) {
                            bVar.e.put(substring, BitmapRegionDecoder.newInstance(inputStream2, true));
                        }
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                            AppMethodBeat.o(65974);
                            return;
                        } catch (IOException e) {
                            AppMethodBeat.o(65974);
                            return;
                        }
                    }
                } catch (IOException e2) {
                    inputStream = inputStream2;
                } catch (Throwable th) {
                }
            }
            AppMethodBeat.o(65974);
            return;
            if (inputStream != null) {
                try {
                    inputStream.close();
                    AppMethodBeat.o(65974);
                    return;
                } catch (IOException e3) {
                    AppMethodBeat.o(65974);
                    return;
                }
            }
            AppMethodBeat.o(65974);
            return;
            AppMethodBeat.o(65974);
        }
    }

    static class a implements Runnable {
        private WeakReference<b> a;
        private String b;

        public a(b bVar, String str) {
            AppMethodBeat.i(65975);
            this.a = new WeakReference(bVar);
            this.b = str;
            AppMethodBeat.o(65975);
        }

        private float a(String str) {
            String str2;
            String str3;
            String str4;
            float f = 0.0f;
            AppMethodBeat.i(65976);
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
            AppMethodBeat.o(65976);
            return f;
        }

        /* JADX WARNING: Removed duplicated region for block: B:60:0x012b A:{SYNTHETIC, Splitter:B:60:0x012b} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            BufferedReader bufferedReader;
            Throwable th;
            AppMethodBeat.i(65977);
            b bVar = (b) this.a.get();
            BufferedReader bufferedReader2;
            try {
                InputStream a = b.a(bVar, this.b);
                if (a == null) {
                    AppMethodBeat.o(65977);
                    return;
                }
                bufferedReader2 = new BufferedReader(new InputStreamReader(a));
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null || readLine.length() == 0 || !readLine.contains("WEBVTT")) {
                        TXCLog.e("TXImageSprite", "DownloadAndParseVTTFileTask : getVTT File Error!");
                        if (bVar != null) {
                            b.c(bVar);
                        }
                        try {
                            bufferedReader2.close();
                            AppMethodBeat.o(65977);
                            return;
                        } catch (IOException e) {
                            AppMethodBeat.o(65977);
                            return;
                        }
                    }
                    do {
                        readLine = bufferedReader2.readLine();
                        if (readLine != null && readLine.contains("-->")) {
                            String[] split = readLine.split(" --> ");
                            if (split.length == 2) {
                                String readLine2 = bufferedReader2.readLine();
                                c cVar = new c();
                                cVar.a = a(split[0]);
                                cVar.b = a(split[1]);
                                cVar.c = readLine2;
                                int indexOf = readLine2.indexOf("#");
                                if (indexOf != -1) {
                                    cVar.d = readLine2.substring(0, indexOf);
                                }
                                indexOf = readLine2.indexOf("=");
                                if (indexOf != -1 && indexOf + 1 < readLine2.length()) {
                                    split = readLine2.substring(indexOf + 1, readLine2.length()).split(",");
                                    if (split.length == 4) {
                                        cVar.e = Integer.valueOf(split[0]).intValue();
                                        cVar.f = Integer.valueOf(split[1]).intValue();
                                        cVar.g = Integer.valueOf(split[2]).intValue();
                                        cVar.h = Integer.valueOf(split[3]).intValue();
                                    }
                                }
                                if (!(bVar == null || bVar.d == null)) {
                                    bVar.d.add(cVar);
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    } while (readLine != null);
                    try {
                        bufferedReader2.close();
                        AppMethodBeat.o(65977);
                    } catch (IOException e2) {
                        AppMethodBeat.o(65977);
                    }
                } catch (IOException e3) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            AppMethodBeat.o(65977);
                            return;
                        } catch (IOException e4) {
                            AppMethodBeat.o(65977);
                            return;
                        }
                    }
                    AppMethodBeat.o(65977);
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader2 != null) {
                    }
                    AppMethodBeat.o(65977);
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
                AppMethodBeat.o(65977);
                throw th;
            }
        }
    }

    static /* synthetic */ InputStream a(b bVar, String str) {
        AppMethodBeat.i(65987);
        InputStream a = bVar.a(str);
        AppMethodBeat.o(65987);
        return a;
    }

    static /* synthetic */ void c(b bVar) {
        AppMethodBeat.i(65988);
        bVar.b();
        AppMethodBeat.o(65988);
    }

    public b() {
        AppMethodBeat.i(65979);
        this.a = new Options();
        this.d = new ArrayList();
        this.d = Collections.synchronizedList(this.d);
        this.e = new HashMap();
        this.e = Collections.synchronizedMap(this.e);
        AppMethodBeat.o(65979);
    }

    public void setVTTUrlAndImageUrls(String str, List<String> list) {
        AppMethodBeat.i(65980);
        if (TextUtils.isEmpty(str)) {
            TXCLog.e("TXImageSprite", "setVTTUrlAndImageUrls: vttUrl can't be null!");
            AppMethodBeat.o(65980);
            return;
        }
        b();
        a();
        this.c.post(new a(this, str));
        if (!(list == null || list.size() == 0)) {
            for (String bVar : list) {
                this.c.post(new b(this, str, bVar));
            }
        }
        AppMethodBeat.o(65980);
    }

    public Bitmap getThumbnail(float f) {
        AppMethodBeat.i(65981);
        if (this.d.size() == 0) {
            AppMethodBeat.o(65981);
            return null;
        }
        c a = a(0, this.d.size() - 1, f);
        if (a == null) {
            AppMethodBeat.o(65981);
            return null;
        }
        BitmapRegionDecoder bitmapRegionDecoder = (BitmapRegionDecoder) this.e.get(a.d);
        if (bitmapRegionDecoder == null) {
            AppMethodBeat.o(65981);
            return null;
        }
        Rect rect = new Rect();
        rect.left = a.e;
        rect.top = a.f;
        rect.right = a.e + a.g;
        rect.bottom = a.h + a.f;
        Bitmap decodeRegion = bitmapRegionDecoder.decodeRegion(rect, this.a);
        AppMethodBeat.o(65981);
        return decodeRegion;
    }

    public void release() {
        AppMethodBeat.i(65982);
        b();
        if (!(this.b == null || this.c == null)) {
            if (VERSION.SDK_INT >= 18) {
                this.b.quitSafely();
            } else {
                this.b.quit();
            }
            this.c = null;
            this.b = null;
        }
        AppMethodBeat.o(65982);
    }

    private c a(int i, int i2, float f) {
        AppMethodBeat.i(65983);
        while (true) {
            int i3 = ((i2 - i) / 2) + i;
            c cVar;
            if (((c) this.d.get(i3)).a <= f && ((c) this.d.get(i3)).b > f) {
                cVar = (c) this.d.get(i3);
                AppMethodBeat.o(65983);
                return cVar;
            } else if (i >= i2) {
                cVar = (c) this.d.get(i);
                AppMethodBeat.o(65983);
                return cVar;
            } else if (f >= ((c) this.d.get(i3)).b) {
                i = i3 + 1;
            } else if (f < ((c) this.d.get(i3)).a) {
                i2 = i3 - 1;
            } else {
                AppMethodBeat.o(65983);
                return null;
            }
        }
    }

    private void a() {
        AppMethodBeat.i(65984);
        if (this.b == null) {
            this.b = new HandlerThread("SuperVodThumbnailsWorkThread");
            this.b.start();
            this.c = new Handler(this.b.getLooper());
        }
        AppMethodBeat.o(65984);
    }

    private void b() {
        AppMethodBeat.i(65985);
        if (this.c != null) {
            TXCLog.i("TXImageSprite", " remove all tasks!");
            this.c.removeCallbacksAndMessages(null);
            this.c.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(65978);
                    if (b.this.d != null) {
                        b.this.d.clear();
                    }
                    if (b.this.e != null) {
                        for (BitmapRegionDecoder bitmapRegionDecoder : b.this.e.values()) {
                            if (bitmapRegionDecoder != null) {
                                bitmapRegionDecoder.recycle();
                            }
                        }
                        b.this.e.clear();
                    }
                    AppMethodBeat.o(65978);
                }
            });
        }
        AppMethodBeat.o(65985);
    }

    private InputStream a(String str) {
        AppMethodBeat.i(65986);
        URLConnection openConnection = new URL(str).openConnection();
        openConnection.connect();
        openConnection.getInputStream();
        openConnection.setConnectTimeout(15000);
        openConnection.setReadTimeout(15000);
        InputStream inputStream = openConnection.getInputStream();
        AppMethodBeat.o(65986);
        return inputStream;
    }
}
