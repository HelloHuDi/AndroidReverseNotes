package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.support.annotation.Keep;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

class LegacyBitmap implements IBitmap<Bitmap> {
    private Bitmap aLX = null;
    private long lastDecodeUsing = -1;

    LegacyBitmap() {
    }

    @Keep
    public BitmapType getType() {
        return BitmapType.Legacy;
    }

    public long getDecodeTime() {
        return this.lastDecodeUsing;
    }

    @Keep
    public Bitmap provide() {
        return this.aLX;
    }

    @Keep
    public void recycle() {
        AppMethodBeat.i(115751);
        if (this.aLX != null) {
            this.aLX.recycle();
        }
        AppMethodBeat.o(115751);
    }

    public void decodeInputStream(InputStream inputStream, Config config, c cVar) {
        AppMethodBeat.i(115750);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Options options = new Options();
        options.inPreferredConfig = config;
        this.aLX = BitmapFactory.decodeStream(inputStream, null, options);
        if (!(this.aLX == null || this.aLX.getConfig() == Config.ARGB_8888)) {
            com.tencent.magicbrush.a.c.c.w("Ni.LegacyBitmap", "hy: config not argb-8888", new Object[0]);
            Bitmap createBitmap = Bitmap.createBitmap(this.aLX.getWidth(), this.aLX.getHeight(), Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(this.aLX, 0.0f, 0.0f, null);
            this.aLX.recycle();
            this.aLX = createBitmap;
        }
        this.lastDecodeUsing = SystemClock.elapsedRealtime() - elapsedRealtime;
        AppMethodBeat.o(115750);
    }
}
