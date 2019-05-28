package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import com.tencent.map.lib.b;
import com.tencent.map.lib.d;
import com.tencent.map.lib.gl.JNICallback.IconImageInfo;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.map.lib.util.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class gv {
    private WeakReference<Context> a;
    private fn b;
    private gx c;
    private float d = 1.0f;
    private b e;
    private Lock f = new ReentrantLock();
    private Lock g = new ReentrantLock();

    public gv(Context context, fn fnVar, gx gxVar, b bVar) {
        AppMethodBeat.i(99488);
        this.a = new WeakReference(context);
        this.b = fnVar;
        this.c = gxVar;
        this.e = bVar;
        this.d = SystemUtil.getDensity(context);
        AppMethodBeat.o(99488);
    }

    public IconImageInfo a(String str) {
        AppMethodBeat.i(99489);
        IconImageInfo iconImageInfo = new IconImageInfo();
        iconImageInfo.scale = this.d;
        iconImageInfo.anchorPointX1 = 0.5f;
        iconImageInfo.anchorPointY1 = 0.5f;
        iconImageInfo.bitmap = a(str, Config.RGB_565, false);
        AppMethodBeat.o(99489);
        return iconImageInfo;
    }

    public IconImageInfo b(String str) {
        AppMethodBeat.i(99490);
        if (this.e == null) {
            AppMethodBeat.o(99490);
            return null;
        }
        IconImageInfo iconImageInfo = new IconImageInfo();
        iconImageInfo.anchorPointX1 = 0.5f;
        iconImageInfo.anchorPointY1 = 0.5f;
        if (str == null || !str.startsWith("drawRoundRect")) {
            try {
                this.g.lock();
                Bitmap a = this.e.a(str);
                this.g.unlock();
                iconImageInfo.scale = this.d;
                iconImageInfo.bitmap = a;
                if (a == null && !str.equals("compass.png")) {
                    d.b("Failed to get texture for: ".concat(String.valueOf(str)));
                }
                AppMethodBeat.o(99490);
                return iconImageInfo;
            } catch (Exception e) {
                AppMethodBeat.o(99490);
                return null;
            } catch (Throwable th) {
                this.g.unlock();
                AppMethodBeat.o(99490);
            }
        }
        iconImageInfo.scale = 1.0f;
        iconImageInfo.bitmap = c(str);
        AppMethodBeat.o(99490);
        return iconImageInfo;
    }

    public void a() {
        AppMethodBeat.i(99491);
        this.f.lock();
        AppMethodBeat.o(99491);
    }

    public void b() {
        AppMethodBeat.i(99492);
        this.f.unlock();
        AppMethodBeat.o(99492);
    }

    public boolean a(String str, byte[] bArr) {
        AppMethodBeat.i(99493);
        if (this.c == null) {
            AppMethodBeat.o(99493);
            return false;
        }
        boolean a = a(new File(this.c.c()), str, bArr, this.f);
        AppMethodBeat.o(99493);
        return a;
    }

    public boolean b(String str, byte[] bArr) {
        AppMethodBeat.i(99494);
        if (this.c == null) {
            AppMethodBeat.o(99494);
            return false;
        }
        boolean a = a(new File(this.c.d()), str, bArr, this.g);
        AppMethodBeat.o(99494);
        return a;
    }

    public void c() {
        AppMethodBeat.i(99495);
        this.b.f().b("");
        AppMethodBeat.o(99495);
    }

    private Bitmap a(String str, Config config, boolean z) {
        AppMethodBeat.i(99496);
        if (!new File(str).exists() || this.a == null || this.a.get() == null) {
            AppMethodBeat.o(99496);
            return null;
        }
        Options options = new Options();
        options.inPreferredConfig = config;
        if (z) {
            options.inDensity = 320;
            options.inTargetDensity = ((Context) this.a.get()).getResources().getDisplayMetrics().densityDpi;
        }
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            AppMethodBeat.o(99496);
            return decodeFile;
        } catch (OutOfMemoryError e) {
            AppMethodBeat.o(99496);
            return null;
        }
    }

    private boolean a(File file, String str, byte[] bArr, Lock lock) {
        AppMethodBeat.i(99497);
        if (file == null || StringUtil.isEmpty(str) || bArr == null || bArr.length == 0) {
            AppMethodBeat.o(99497);
            return false;
        }
        String str2 = str + "_" + bArr.hashCode();
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str2);
        if (file2.exists()) {
            file2.delete();
        }
        file2.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(bArr);
        fileOutputStream.flush();
        fileOutputStream.close();
        try {
            if (!a.a(bArr).equals(a.a(file2))) {
                AppMethodBeat.o(99497);
                return false;
            }
        } catch (FileNotFoundException e) {
        }
        try {
            File file3 = new File(file, str);
            File file4 = new File(file, str + ".bak");
            if (!file4.exists() || file4.delete()) {
                lock.lock();
                if (file3.exists() && !file3.renameTo(file4)) {
                    if (!file2.delete()) {
                        file2.deleteOnExit();
                    }
                    lock.unlock();
                    AppMethodBeat.o(99497);
                    return false;
                } else if (file2.renameTo(file3)) {
                    if (!file4.delete()) {
                        file4.deleteOnExit();
                    }
                    lock.unlock();
                    AppMethodBeat.o(99497);
                    return true;
                } else {
                    file4.renameTo(file3);
                    if (!file2.delete()) {
                        file2.deleteOnExit();
                    }
                    lock.unlock();
                    AppMethodBeat.o(99497);
                    return false;
                }
            }
            file4.deleteOnExit();
            AppMethodBeat.o(99497);
            return false;
        } catch (Exception e2) {
            AppMethodBeat.o(99497);
            return false;
        } catch (Throwable th) {
            lock.unlock();
            AppMethodBeat.o(99497);
        }
    }

    private Bitmap c(String str) {
        AppMethodBeat.i(99498);
        String substring = str.substring(14);
        if (StringUtil.isEmpty(substring)) {
            AppMethodBeat.o(99498);
            return null;
        }
        String[] split = substring.split(", ");
        if (split == null || split.length < 5) {
            AppMethodBeat.o(99498);
            return null;
        }
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        long parseLong = Long.parseLong(split[2]);
        long parseLong2 = Long.parseLong(split[3]);
        float parseFloat = Float.parseFloat(split[4]);
        if (parseInt < 0 || parseInt2 < 0) {
            AppMethodBeat.o(99498);
            return null;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(parseFloat);
        paint.setStyle(Style.STROKE);
        paint.setColor(a((int) parseLong2));
        Bitmap createBitmap = Bitmap.createBitmap(parseInt, parseInt2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(a((int) parseLong));
        RectF rectF = new RectF();
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = (float) parseInt;
        rectF.bottom = (float) parseInt2;
        canvas.drawRoundRect(rectF, (float) (parseInt >> 3), (float) (parseInt2 >> 3), paint);
        AppMethodBeat.o(99498);
        return createBitmap;
    }

    private int a(int i) {
        return ((16711680 & i) >> 16) | (((i & 255) << 16) | ((-16711681 & i) & -256));
    }
}
