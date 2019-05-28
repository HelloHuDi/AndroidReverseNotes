package com.tencent.mm.audio.mix.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.c;
import com.tencent.mm.audio.mix.b.d;
import com.tencent.mm.audio.mix.h.b;
import java.util.ArrayList;
import java.util.Iterator;

public final class a implements f {
    private String appId;
    private String filePath;

    public a(String str, String str2) {
        this.appId = str;
        this.filePath = str2;
    }

    public final void Dp() {
        AppMethodBeat.i(137001);
        b.i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "runTask, appId:%s", this.appId);
        c dv;
        if (TextUtils.isEmpty(this.filePath)) {
            b.i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file task");
            ArrayList Do = d.Dm().Do();
            if (Do.size() > 0) {
                String str = "";
                Iterator it = Do.iterator();
                int i = 0;
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    c dv2 = d.Dm().dv(str2);
                    if (dv2 == null || !dv2.cky || !dv2.ckB) {
                        int dw = d.Dm().dw(str2);
                        if (dw < i) {
                            str2 = str;
                            dw = i;
                        }
                        str = str2;
                        i = dw;
                    }
                }
                dv = d.Dm().dv(str);
                if (!(dv == null || !dv.cky || dv.ckB)) {
                    dv.du(this.appId);
                }
                b.i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file path :%s, size:%d", str, Integer.valueOf(i));
            }
            AppMethodBeat.o(137001);
            return;
        }
        int dw2 = d.Dm().dw(this.filePath);
        b.i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file path :%s, size:%d", this.filePath, Integer.valueOf(dw2));
        dv = d.Dm().dv(this.filePath);
        if (!(dv == null || !dv.cky || dv.ckB)) {
            dv.du(this.appId);
        }
        AppMethodBeat.o(137001);
    }

    public final void end() {
    }
}
