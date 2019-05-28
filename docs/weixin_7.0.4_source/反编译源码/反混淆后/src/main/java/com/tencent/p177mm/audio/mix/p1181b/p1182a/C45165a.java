package com.tencent.p177mm.audio.mix.p1181b.p1182a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p1181b.C45166d;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p830a.C37484c;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.audio.mix.b.a.a */
public final class C45165a implements C25837f {
    private String appId;
    private String filePath;

    public C45165a(String str, String str2) {
        this.appId = str;
        this.filePath = str2;
    }

    /* renamed from: Dp */
    public final void mo43825Dp() {
        AppMethodBeat.m2504i(137001);
        C45174b.m83210i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "runTask, appId:%s", this.appId);
        C37484c dv;
        if (TextUtils.isEmpty(this.filePath)) {
            C45174b.m83209i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file task");
            ArrayList Do = C45166d.m83168Dm().mo73131Do();
            if (Do.size() > 0) {
                String str = "";
                Iterator it = Do.iterator();
                int i = 0;
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    C37484c dv2 = C45166d.m83168Dm().mo73133dv(str2);
                    if (dv2 == null || !dv2.cky || !dv2.ckB) {
                        int dw = C45166d.m83168Dm().mo73134dw(str2);
                        if (dw < i) {
                            str2 = str;
                            dw = i;
                        }
                        str = str2;
                        i = dw;
                    }
                }
                dv = C45166d.m83168Dm().mo73133dv(str);
                if (!(dv == null || !dv.cky || dv.ckB)) {
                    dv.mo60398du(this.appId);
                }
                C45174b.m83210i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file path :%s, size:%d", str, Integer.valueOf(i));
            }
            AppMethodBeat.m2505o(137001);
            return;
        }
        int dw2 = C45166d.m83168Dm().mo73134dw(this.filePath);
        C45174b.m83210i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file path :%s, size:%d", this.filePath, Integer.valueOf(dw2));
        dv = C45166d.m83168Dm().mo73133dv(this.filePath);
        if (!(dv == null || !dv.cky || dv.ckB)) {
            dv.mo60398du(this.appId);
        }
        AppMethodBeat.m2505o(137001);
    }

    public final void end() {
    }
}
