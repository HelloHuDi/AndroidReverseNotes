package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C27067l;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C45616h;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;

/* renamed from: com.tencent.smtt.sdk.ba */
class C30945ba {
    /* renamed from: a */
    private DexLoader f13903a = null;
    /* renamed from: b */
    private Object f13904b = null;

    public C30945ba(DexLoader dexLoader, Context context) {
        AppMethodBeat.m2504i(64533);
        this.f13903a = dexLoader;
        this.f13904b = this.f13903a.newInstance("com.tencent.tbs.player.TbsMediaPlayerProxy", new Class[]{Context.class}, context);
        AppMethodBeat.m2505o(64533);
    }

    /* renamed from: a */
    public void mo50049a(float f) {
        AppMethodBeat.m2504i(64537);
        this.f13903a.invokeMethod(this.f13904b, "com.tencent.tbs.player.TbsMediaPlayerProxy", C27067l.NAME, new Class[]{Float.TYPE}, Float.valueOf(f));
        AppMethodBeat.m2505o(64537);
    }

    /* renamed from: a */
    public void mo50050a(int i) {
        AppMethodBeat.m2504i(64539);
        this.f13903a.invokeMethod(this.f13904b, "com.tencent.tbs.player.TbsMediaPlayerProxy", MessengerShareContentUtility.SUBTITLE, new Class[]{Integer.TYPE}, Integer.valueOf(i));
        AppMethodBeat.m2505o(64539);
    }

    /* renamed from: a */
    public void mo50051a(long j) {
        AppMethodBeat.m2504i(64543);
        this.f13903a.invokeMethod(this.f13904b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "seek", new Class[]{Long.TYPE}, Long.valueOf(j));
        AppMethodBeat.m2505o(64543);
    }

    /* renamed from: a */
    public void mo50052a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(64534);
        this.f13903a.invokeMethod(this.f13904b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setSurfaceTexture", new Class[]{SurfaceTexture.class}, surfaceTexture);
        AppMethodBeat.m2505o(64534);
    }

    /* renamed from: a */
    public void mo50053a(TbsMediaPlayerListener tbsMediaPlayerListener) {
        AppMethodBeat.m2504i(64535);
        this.f13903a.invokeMethod(this.f13904b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setPlayerListener", new Class[]{Object.class}, tbsMediaPlayerListener);
        AppMethodBeat.m2505o(64535);
    }

    /* renamed from: a */
    public void mo50054a(String str, Bundle bundle) {
        AppMethodBeat.m2504i(64538);
        this.f13903a.invokeMethod(this.f13904b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "startPlay", new Class[]{String.class, Bundle.class}, str, bundle);
        AppMethodBeat.m2505o(64538);
    }

    /* renamed from: a */
    public boolean mo50055a() {
        return this.f13904b != null;
    }

    /* renamed from: b */
    public float mo50056b() {
        AppMethodBeat.m2504i(64536);
        Float f = (Float) this.f13903a.invokeMethod(this.f13904b, "com.tencent.tbs.player.TbsMediaPlayerProxy", C45616h.NAME, new Class[0], new Object[0]);
        if (f != null) {
            float floatValue = f.floatValue();
            AppMethodBeat.m2505o(64536);
            return floatValue;
        }
        AppMethodBeat.m2505o(64536);
        return 0.0f;
    }

    /* renamed from: b */
    public void mo50057b(int i) {
        AppMethodBeat.m2504i(64540);
        this.f13903a.invokeMethod(this.f13904b, "com.tencent.tbs.player.TbsMediaPlayerProxy", SlookAirButtonRecentMediaAdapter.AUDIO_TYPE, new Class[]{Integer.TYPE}, Integer.valueOf(i));
        AppMethodBeat.m2505o(64540);
    }

    /* renamed from: c */
    public void mo50058c() {
        AppMethodBeat.m2504i(64541);
        this.f13903a.invokeMethod(this.f13904b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "pause", new Class[0], new Object[0]);
        AppMethodBeat.m2505o(64541);
    }

    /* renamed from: d */
    public void mo50059d() {
        AppMethodBeat.m2504i(64542);
        this.f13903a.invokeMethod(this.f13904b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "play", new Class[0], new Object[0]);
        AppMethodBeat.m2505o(64542);
    }

    /* renamed from: e */
    public void mo50060e() {
        AppMethodBeat.m2504i(64544);
        this.f13903a.invokeMethod(this.f13904b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "close", new Class[0], new Object[0]);
        AppMethodBeat.m2505o(64544);
    }
}
