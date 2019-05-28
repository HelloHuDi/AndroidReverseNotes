package com.tencent.p177mm.plugin.appbrand.p281b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10441j;
import com.tencent.p177mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.p177mm.plugin.appbrand.media.music.AppBrandMusicClientService.C10622a;
import com.tencent.p177mm.plugin.appbrand.media.music.AppBrandMusicClientService.StopBackgroundMusicTask;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.b.g */
abstract class C26795g extends C38138h {
    private final C6750i gPI;
    int gWW = 0;
    private final C10622a gWX = new C267971();

    /* renamed from: com.tencent.mm.plugin.appbrand.b.g$1 */
    class C267971 implements C10622a {
        C267971() {
        }

        public final void awG() {
            AppMethodBeat.m2504i(86864);
            C26795g.this.mo44563nu(1);
            AppMethodBeat.m2505o(86864);
        }

        public final void onStop() {
            AppMethodBeat.m2504i(86865);
            C26795g.this.mo44563nu(1);
            AppMethodBeat.m2505o(86865);
        }
    }

    public abstract void awB();

    C26795g(C45525i c45525i, C6750i c6750i) {
        super(c45525i);
        this.gPI = c6750i;
    }

    public void enter() {
        this.gWW = awF();
        super.enter();
        mo44563nu(0);
    }

    public void exit() {
        super.exit();
        this.gWW = 0;
        AppBrandMusicClientService appBrandMusicClientService = AppBrandMusicClientService.ikP;
        String str = this.gPI.mAppId;
        if (!TextUtils.isEmpty(str) && appBrandMusicClientService.ikO.containsKey(str)) {
            appBrandMusicClientService.ikO.remove(str);
        }
    }

    /* renamed from: dB */
    private void m42648dB(int i) {
        this.gWW |= i;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: nu */
    public final void mo44563nu(int i) {
        this.gWW &= i ^ -1;
        if (this.gWW == 0) {
            awB();
        }
    }

    private int awF() {
        this.gWW = 0;
        String str = this.gPI.mAppId;
        C10441j aa = this.gPI.mo14986aa(C38137a.class);
        int i = (aa == null || !((C38137a) aa).gWs) ? 0 : 1;
        AppBrandMusicClientService appBrandMusicClientService;
        if (i == 0) {
            appBrandMusicClientService = AppBrandMusicClientService.ikP;
            if (!TextUtils.isEmpty(str)) {
                if (str.equalsIgnoreCase(appBrandMusicClientService.ikQ)) {
                    MainProcessTask stopBackgroundMusicTask = new StopBackgroundMusicTask();
                    stopBackgroundMusicTask.appId = str;
                    AppBrandMainProcessService.m54349a(stopBackgroundMusicTask);
                } else {
                    C4990ab.m7412e("MicroMsg.AppBrandMusicClientService", "appId is diff, can't stop music");
                }
            }
        } else if (AppBrandMusicClientService.m18308Cu(str)) {
            m42648dB(1);
            appBrandMusicClientService = AppBrandMusicClientService.ikP;
            C10622a c10622a = this.gWX;
            if (!(TextUtils.isEmpty(str) || c10622a == null)) {
                if (appBrandMusicClientService.ikO.containsKey(str)) {
                    appBrandMusicClientService.ikO.remove(str);
                    appBrandMusicClientService.ikO.put(str, c10622a);
                } else {
                    appBrandMusicClientService.ikO.put(str, c10622a);
                }
            }
        }
        switch (C33183g.m54286wV(str)) {
            case LAUNCH_MINI_PROGRAM:
                m42648dB(16);
                break;
            case LAUNCH_NATIVE_PAGE:
                m42648dB(4);
                break;
            case HOME_PRESSED:
                try {
                    if (!(this.gPI.gNz.atz().aLZ() && this.gPI.asU() == null)) {
                        m42648dB(8);
                        break;
                    }
                } catch (IllegalAccessError e) {
                    break;
                }
        }
        return this.gWW;
    }
}
