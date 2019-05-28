package com.tencent.mm.plugin.appbrand.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.StopBackgroundMusicTask;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.a;
import com.tencent.mm.sdk.platformtools.ab;

abstract class g extends h {
    private final i gPI;
    int gWW = 0;
    private final a gWX = new a() {
        public final void awG() {
            AppMethodBeat.i(86864);
            g.this.nu(1);
            AppMethodBeat.o(86864);
        }

        public final void onStop() {
            AppMethodBeat.i(86865);
            g.this.nu(1);
            AppMethodBeat.o(86865);
        }
    };

    public abstract void awB();

    g(i iVar, i iVar2) {
        super(iVar);
        this.gPI = iVar2;
    }

    public void enter() {
        this.gWW = awF();
        super.enter();
        nu(0);
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

    private void dB(int i) {
        this.gWW |= i;
    }

    /* Access modifiers changed, original: final */
    public final void nu(int i) {
        this.gWW &= i ^ -1;
        if (this.gWW == 0) {
            awB();
        }
    }

    private int awF() {
        this.gWW = 0;
        String str = this.gPI.mAppId;
        j aa = this.gPI.aa(a.class);
        int i = (aa == null || !((a) aa).gWs) ? 0 : 1;
        AppBrandMusicClientService appBrandMusicClientService;
        if (i == 0) {
            appBrandMusicClientService = AppBrandMusicClientService.ikP;
            if (!TextUtils.isEmpty(str)) {
                if (str.equalsIgnoreCase(appBrandMusicClientService.ikQ)) {
                    MainProcessTask stopBackgroundMusicTask = new StopBackgroundMusicTask();
                    stopBackgroundMusicTask.appId = str;
                    AppBrandMainProcessService.a(stopBackgroundMusicTask);
                } else {
                    ab.e("MicroMsg.AppBrandMusicClientService", "appId is diff, can't stop music");
                }
            }
        } else if (AppBrandMusicClientService.Cu(str)) {
            dB(1);
            appBrandMusicClientService = AppBrandMusicClientService.ikP;
            a aVar = this.gWX;
            if (!(TextUtils.isEmpty(str) || aVar == null)) {
                if (appBrandMusicClientService.ikO.containsKey(str)) {
                    appBrandMusicClientService.ikO.remove(str);
                    appBrandMusicClientService.ikO.put(str, aVar);
                } else {
                    appBrandMusicClientService.ikO.put(str, aVar);
                }
            }
        }
        switch (com.tencent.mm.plugin.appbrand.g.wV(str)) {
            case LAUNCH_MINI_PROGRAM:
                dB(16);
                break;
            case LAUNCH_NATIVE_PAGE:
                dB(4);
                break;
            case HOME_PRESSED:
                try {
                    if (!(this.gPI.gNz.atz().aLZ() && this.gPI.asU() == null)) {
                        dB(8);
                        break;
                    }
                } catch (IllegalAccessError e) {
                    break;
                }
        }
        return this.gWW;
    }
}
