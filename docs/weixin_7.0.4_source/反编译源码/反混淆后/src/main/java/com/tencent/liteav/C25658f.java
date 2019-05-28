package com.tencent.liteav;

import android.graphics.Bitmap;
import com.tencent.liteav.audio.C8790b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.VideoFilterUtil;

/* renamed from: com.tencent.liteav.f */
public class C25658f implements Cloneable {
    /* renamed from: A */
    public float f5288A = 0.0f;
    /* renamed from: B */
    public float f5289B = 0.0f;
    /* renamed from: C */
    public float f5290C = -1.0f;
    /* renamed from: D */
    public boolean f5291D = true;
    /* renamed from: E */
    public boolean f5292E = false;
    /* renamed from: F */
    public boolean f5293F = false;
    /* renamed from: G */
    public boolean f5294G = true;
    /* renamed from: H */
    public int f5295H = 1;
    /* renamed from: I */
    public boolean f5296I = false;
    /* renamed from: J */
    public boolean f5297J = false;
    /* renamed from: K */
    public int f5298K = 0;
    /* renamed from: L */
    public boolean f5299L = false;
    /* renamed from: M */
    public boolean f5300M = true;
    /* renamed from: N */
    public boolean f5301N = false;
    /* renamed from: a */
    public int f5302a = 0;
    /* renamed from: b */
    public int f5303b = 0;
    /* renamed from: c */
    public int f5304c = 400;
    /* renamed from: d */
    public int f5305d = 600;
    /* renamed from: e */
    public int f5306e = 300;
    /* renamed from: f */
    public int f5307f = 5;
    /* renamed from: g */
    public boolean f5308g = true;
    /* renamed from: h */
    public int f5309h = 20;
    /* renamed from: i */
    public int f5310i = 1;
    /* renamed from: j */
    public int f5311j = 2;
    /* renamed from: k */
    public int f5312k = 1;
    /* renamed from: l */
    public int f5313l = 1;
    /* renamed from: m */
    public boolean f5314m = true;
    /* renamed from: n */
    public boolean f5315n = true;
    /* renamed from: o */
    public int f5316o = 3;
    /* renamed from: p */
    public int f5317p = 3;
    /* renamed from: q */
    public int f5318q = C8790b.f2444a;
    /* renamed from: r */
    public int f5319r = C8790b.f2445b;
    /* renamed from: s */
    public boolean f5320s = true;
    /* renamed from: t */
    public Bitmap f5321t = null;
    /* renamed from: u */
    public int f5322u = 300;
    /* renamed from: v */
    public int f5323v = 10;
    /* renamed from: w */
    public int f5324w = 1;
    /* renamed from: x */
    public Bitmap f5325x = null;
    /* renamed from: y */
    public int f5326y = 0;
    /* renamed from: z */
    public int f5327z = 0;

    /* renamed from: a */
    public boolean mo43387a() {
        switch (this.f5312k) {
            case 0:
                this.f5302a = 368;
                this.f5303b = 640;
                return false;
            case 1:
                this.f5302a = 544;
                this.f5303b = VideoFilterUtil.IMAGE_HEIGHT;
                return false;
            case 2:
                this.f5302a = 720;
                this.f5303b = ActUtil.HEIGHT;
                return false;
            case 3:
                this.f5302a = 640;
                this.f5303b = 368;
                return true;
            case 4:
                this.f5302a = VideoFilterUtil.IMAGE_HEIGHT;
                this.f5303b = 544;
                return true;
            case 5:
                this.f5302a = ActUtil.HEIGHT;
                this.f5303b = 720;
                return true;
            case 6:
                this.f5302a = 320;
                this.f5303b = 480;
                return false;
            case 7:
                this.f5302a = C33250az.CTRL_INDEX;
                this.f5303b = 320;
                return false;
            case 8:
                this.f5302a = 272;
                this.f5303b = 480;
                return false;
            case 9:
                this.f5302a = 320;
                this.f5303b = C33250az.CTRL_INDEX;
                return true;
            case 10:
                this.f5302a = 480;
                this.f5303b = 272;
                return true;
            case 11:
                this.f5302a = 240;
                this.f5303b = 320;
                return false;
            case 12:
                this.f5302a = 368;
                this.f5303b = 480;
                return false;
            case 13:
                this.f5302a = 480;
                this.f5303b = 640;
                return false;
            case 14:
                this.f5302a = 320;
                this.f5303b = 240;
                return true;
            case 15:
                this.f5302a = 480;
                this.f5303b = 368;
                return true;
            case 16:
                this.f5302a = 640;
                this.f5303b = 480;
                return true;
            case 17:
                this.f5302a = 480;
                this.f5303b = 480;
                return false;
            case 18:
                this.f5302a = 272;
                this.f5303b = 272;
                return false;
            case 19:
                this.f5302a = 160;
                this.f5303b = 160;
                return false;
            default:
                this.f5302a = 368;
                this.f5303b = 640;
                return false;
        }
    }

    /* Access modifiers changed, original: protected */
    public Object clone() {
        AppMethodBeat.m2504i(66378);
        C25658f c25658f = (C25658f) super.clone();
        AppMethodBeat.m2505o(66378);
        return c25658f;
    }
}
