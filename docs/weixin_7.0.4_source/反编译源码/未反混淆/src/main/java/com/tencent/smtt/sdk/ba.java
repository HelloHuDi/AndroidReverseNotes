package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.q.h;
import com.tencent.mm.plugin.appbrand.jsapi.q.l;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;

class ba {
    private DexLoader a = null;
    private Object b = null;

    public ba(DexLoader dexLoader, Context context) {
        AppMethodBeat.i(64533);
        this.a = dexLoader;
        this.b = this.a.newInstance("com.tencent.tbs.player.TbsMediaPlayerProxy", new Class[]{Context.class}, context);
        AppMethodBeat.o(64533);
    }

    public void a(float f) {
        AppMethodBeat.i(64537);
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", l.NAME, new Class[]{Float.TYPE}, Float.valueOf(f));
        AppMethodBeat.o(64537);
    }

    public void a(int i) {
        AppMethodBeat.i(64539);
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", MessengerShareContentUtility.SUBTITLE, new Class[]{Integer.TYPE}, Integer.valueOf(i));
        AppMethodBeat.o(64539);
    }

    public void a(long j) {
        AppMethodBeat.i(64543);
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "seek", new Class[]{Long.TYPE}, Long.valueOf(j));
        AppMethodBeat.o(64543);
    }

    public void a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(64534);
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setSurfaceTexture", new Class[]{SurfaceTexture.class}, surfaceTexture);
        AppMethodBeat.o(64534);
    }

    public void a(TbsMediaPlayerListener tbsMediaPlayerListener) {
        AppMethodBeat.i(64535);
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setPlayerListener", new Class[]{Object.class}, tbsMediaPlayerListener);
        AppMethodBeat.o(64535);
    }

    public void a(String str, Bundle bundle) {
        AppMethodBeat.i(64538);
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "startPlay", new Class[]{String.class, Bundle.class}, str, bundle);
        AppMethodBeat.o(64538);
    }

    public boolean a() {
        return this.b != null;
    }

    public float b() {
        AppMethodBeat.i(64536);
        Float f = (Float) this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", h.NAME, new Class[0], new Object[0]);
        if (f != null) {
            float floatValue = f.floatValue();
            AppMethodBeat.o(64536);
            return floatValue;
        }
        AppMethodBeat.o(64536);
        return 0.0f;
    }

    public void b(int i) {
        AppMethodBeat.i(64540);
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", SlookAirButtonRecentMediaAdapter.AUDIO_TYPE, new Class[]{Integer.TYPE}, Integer.valueOf(i));
        AppMethodBeat.o(64540);
    }

    public void c() {
        AppMethodBeat.i(64541);
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "pause", new Class[0], new Object[0]);
        AppMethodBeat.o(64541);
    }

    public void d() {
        AppMethodBeat.i(64542);
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "play", new Class[0], new Object[0]);
        AppMethodBeat.o(64542);
    }

    public void e() {
        AppMethodBeat.i(64544);
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "close", new Class[0], new Object[0]);
        AppMethodBeat.o(64544);
    }
}
