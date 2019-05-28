package com.tencent.mm.plugin.mmsight.api;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.remoteservice.d;

public abstract class b {
    public static a ota = null;

    public interface a {
        b asm();
    }

    public abstract void a(d dVar, VideoTransPara videoTransPara);

    public abstract com.tencent.mm.plugin.mmsight.model.a.d asl();

    public abstract void b(d dVar, VideoTransPara videoTransPara);
}
