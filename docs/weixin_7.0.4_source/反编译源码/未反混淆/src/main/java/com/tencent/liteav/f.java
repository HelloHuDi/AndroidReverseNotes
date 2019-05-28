package com.tencent.liteav;

import android.graphics.Bitmap;
import com.tencent.liteav.audio.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.VideoFilterUtil;

public class f implements Cloneable {
    public float A = 0.0f;
    public float B = 0.0f;
    public float C = -1.0f;
    public boolean D = true;
    public boolean E = false;
    public boolean F = false;
    public boolean G = true;
    public int H = 1;
    public boolean I = false;
    public boolean J = false;
    public int K = 0;
    public boolean L = false;
    public boolean M = true;
    public boolean N = false;
    public int a = 0;
    public int b = 0;
    public int c = 400;
    public int d = 600;
    public int e = 300;
    public int f = 5;
    public boolean g = true;
    public int h = 20;
    public int i = 1;
    public int j = 2;
    public int k = 1;
    public int l = 1;
    public boolean m = true;
    public boolean n = true;
    public int o = 3;
    public int p = 3;
    public int q = b.a;
    public int r = b.b;
    public boolean s = true;
    public Bitmap t = null;
    public int u = 300;
    public int v = 10;
    public int w = 1;
    public Bitmap x = null;
    public int y = 0;
    public int z = 0;

    public boolean a() {
        switch (this.k) {
            case 0:
                this.a = 368;
                this.b = 640;
                return false;
            case 1:
                this.a = 544;
                this.b = VideoFilterUtil.IMAGE_HEIGHT;
                return false;
            case 2:
                this.a = 720;
                this.b = ActUtil.HEIGHT;
                return false;
            case 3:
                this.a = 640;
                this.b = 368;
                return true;
            case 4:
                this.a = VideoFilterUtil.IMAGE_HEIGHT;
                this.b = 544;
                return true;
            case 5:
                this.a = ActUtil.HEIGHT;
                this.b = 720;
                return true;
            case 6:
                this.a = 320;
                this.b = 480;
                return false;
            case 7:
                this.a = az.CTRL_INDEX;
                this.b = 320;
                return false;
            case 8:
                this.a = 272;
                this.b = 480;
                return false;
            case 9:
                this.a = 320;
                this.b = az.CTRL_INDEX;
                return true;
            case 10:
                this.a = 480;
                this.b = 272;
                return true;
            case 11:
                this.a = 240;
                this.b = 320;
                return false;
            case 12:
                this.a = 368;
                this.b = 480;
                return false;
            case 13:
                this.a = 480;
                this.b = 640;
                return false;
            case 14:
                this.a = 320;
                this.b = 240;
                return true;
            case 15:
                this.a = 480;
                this.b = 368;
                return true;
            case 16:
                this.a = 640;
                this.b = 480;
                return true;
            case 17:
                this.a = 480;
                this.b = 480;
                return false;
            case 18:
                this.a = 272;
                this.b = 272;
                return false;
            case 19:
                this.a = 160;
                this.b = 160;
                return false;
            default:
                this.a = 368;
                this.b = 640;
                return false;
        }
    }

    /* Access modifiers changed, original: protected */
    public Object clone() {
        AppMethodBeat.i(66378);
        f fVar = (f) super.clone();
        AppMethodBeat.o(66378);
        return fVar;
    }
}
