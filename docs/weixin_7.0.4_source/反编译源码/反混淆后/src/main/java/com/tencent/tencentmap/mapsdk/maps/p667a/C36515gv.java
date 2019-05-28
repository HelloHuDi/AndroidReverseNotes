package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import com.tencent.map.lib.C1015d;
import com.tencent.map.lib.C41716b;
import com.tencent.map.lib.p822gl.JNICallback.IconImageInfo;
import com.tencent.map.lib.util.C25735a;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gv */
public class C36515gv {
    /* renamed from: a */
    private WeakReference<Context> f15375a;
    /* renamed from: b */
    private C5876fn f15376b;
    /* renamed from: c */
    private C36516gx f15377c;
    /* renamed from: d */
    private float f15378d = 1.0f;
    /* renamed from: e */
    private C41716b f15379e;
    /* renamed from: f */
    private Lock f15380f = new ReentrantLock();
    /* renamed from: g */
    private Lock f15381g = new ReentrantLock();

    public C36515gv(Context context, C5876fn c5876fn, C36516gx c36516gx, C41716b c41716b) {
        AppMethodBeat.m2504i(99488);
        this.f15375a = new WeakReference(context);
        this.f15376b = c5876fn;
        this.f15377c = c36516gx;
        this.f15379e = c41716b;
        this.f15378d = SystemUtil.getDensity(context);
        AppMethodBeat.m2505o(99488);
    }

    /* renamed from: a */
    public IconImageInfo mo57738a(String str) {
        AppMethodBeat.m2504i(99489);
        IconImageInfo iconImageInfo = new IconImageInfo();
        iconImageInfo.scale = this.f15378d;
        iconImageInfo.anchorPointX1 = 0.5f;
        iconImageInfo.anchorPointY1 = 0.5f;
        iconImageInfo.bitmap = m60421a(str, Config.RGB_565, false);
        AppMethodBeat.m2505o(99489);
        return iconImageInfo;
    }

    /* renamed from: b */
    public IconImageInfo mo57741b(String str) {
        AppMethodBeat.m2504i(99490);
        if (this.f15379e == null) {
            AppMethodBeat.m2505o(99490);
            return null;
        }
        IconImageInfo iconImageInfo = new IconImageInfo();
        iconImageInfo.anchorPointX1 = 0.5f;
        iconImageInfo.anchorPointY1 = 0.5f;
        if (str == null || !str.startsWith("drawRoundRect")) {
            try {
                this.f15381g.lock();
                Bitmap a = this.f15379e.mo57764a(str);
                this.f15381g.unlock();
                iconImageInfo.scale = this.f15378d;
                iconImageInfo.bitmap = a;
                if (a == null && !str.equals("compass.png")) {
                    C1015d.m2290b("Failed to get texture for: ".concat(String.valueOf(str)));
                }
                AppMethodBeat.m2505o(99490);
                return iconImageInfo;
            } catch (Exception e) {
                AppMethodBeat.m2505o(99490);
                return null;
            } catch (Throwable th) {
                this.f15381g.unlock();
                AppMethodBeat.m2505o(99490);
            }
        }
        iconImageInfo.scale = 1.0f;
        iconImageInfo.bitmap = m60423c(str);
        AppMethodBeat.m2505o(99490);
        return iconImageInfo;
    }

    /* renamed from: a */
    public void mo57739a() {
        AppMethodBeat.m2504i(99491);
        this.f15380f.lock();
        AppMethodBeat.m2505o(99491);
    }

    /* renamed from: b */
    public void mo57742b() {
        AppMethodBeat.m2504i(99492);
        this.f15380f.unlock();
        AppMethodBeat.m2505o(99492);
    }

    /* renamed from: a */
    public boolean mo57740a(String str, byte[] bArr) {
        AppMethodBeat.m2504i(99493);
        if (this.f15377c == null) {
            AppMethodBeat.m2505o(99493);
            return false;
        }
        boolean a = m60422a(new File(this.f15377c.mo57747c()), str, bArr, this.f15380f);
        AppMethodBeat.m2505o(99493);
        return a;
    }

    /* renamed from: b */
    public boolean mo57743b(String str, byte[] bArr) {
        AppMethodBeat.m2504i(99494);
        if (this.f15377c == null) {
            AppMethodBeat.m2505o(99494);
            return false;
        }
        boolean a = m60422a(new File(this.f15377c.mo57748d()), str, bArr, this.f15381g);
        AppMethodBeat.m2505o(99494);
        return a;
    }

    /* renamed from: c */
    public void mo57744c() {
        AppMethodBeat.m2504i(99495);
        this.f15376b.mo12445f().mo29358b("");
        AppMethodBeat.m2505o(99495);
    }

    /* renamed from: a */
    private Bitmap m60421a(String str, Config config, boolean z) {
        AppMethodBeat.m2504i(99496);
        if (!new File(str).exists() || this.f15375a == null || this.f15375a.get() == null) {
            AppMethodBeat.m2505o(99496);
            return null;
        }
        Options options = new Options();
        options.inPreferredConfig = config;
        if (z) {
            options.inDensity = 320;
            options.inTargetDensity = ((Context) this.f15375a.get()).getResources().getDisplayMetrics().densityDpi;
        }
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            AppMethodBeat.m2505o(99496);
            return decodeFile;
        } catch (OutOfMemoryError e) {
            AppMethodBeat.m2505o(99496);
            return null;
        }
    }

    /* renamed from: a */
    private boolean m60422a(File file, String str, byte[] bArr, Lock lock) {
        AppMethodBeat.m2504i(99497);
        if (file == null || StringUtil.isEmpty(str) || bArr == null || bArr.length == 0) {
            AppMethodBeat.m2505o(99497);
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
            if (!C25735a.m40859a(bArr).equals(C25735a.m40858a(file2))) {
                AppMethodBeat.m2505o(99497);
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
                    AppMethodBeat.m2505o(99497);
                    return false;
                } else if (file2.renameTo(file3)) {
                    if (!file4.delete()) {
                        file4.deleteOnExit();
                    }
                    lock.unlock();
                    AppMethodBeat.m2505o(99497);
                    return true;
                } else {
                    file4.renameTo(file3);
                    if (!file2.delete()) {
                        file2.deleteOnExit();
                    }
                    lock.unlock();
                    AppMethodBeat.m2505o(99497);
                    return false;
                }
            }
            file4.deleteOnExit();
            AppMethodBeat.m2505o(99497);
            return false;
        } catch (Exception e2) {
            AppMethodBeat.m2505o(99497);
            return false;
        } catch (Throwable th) {
            lock.unlock();
            AppMethodBeat.m2505o(99497);
        }
    }

    /* renamed from: c */
    private Bitmap m60423c(String str) {
        AppMethodBeat.m2504i(99498);
        String substring = str.substring(14);
        if (StringUtil.isEmpty(substring)) {
            AppMethodBeat.m2505o(99498);
            return null;
        }
        String[] split = substring.split(", ");
        if (split == null || split.length < 5) {
            AppMethodBeat.m2505o(99498);
            return null;
        }
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        long parseLong = Long.parseLong(split[2]);
        long parseLong2 = Long.parseLong(split[3]);
        float parseFloat = Float.parseFloat(split[4]);
        if (parseInt < 0 || parseInt2 < 0) {
            AppMethodBeat.m2505o(99498);
            return null;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(parseFloat);
        paint.setStyle(Style.STROKE);
        paint.setColor(m60420a((int) parseLong2));
        Bitmap createBitmap = Bitmap.createBitmap(parseInt, parseInt2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(m60420a((int) parseLong));
        RectF rectF = new RectF();
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = (float) parseInt;
        rectF.bottom = (float) parseInt2;
        canvas.drawRoundRect(rectF, (float) (parseInt >> 3), (float) (parseInt2 >> 3), paint);
        AppMethodBeat.m2505o(99498);
        return createBitmap;
    }

    /* renamed from: a */
    private int m60420a(int i) {
        return ((16711680 & i) >> 16) | (((i & 255) << 16) | ((-16711681 & i) & -256));
    }
}
