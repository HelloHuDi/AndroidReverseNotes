package com.tencent.mm.plugin.emojicapture.model.b;

import a.f.a.b;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.media.f.e;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "mixInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "(Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;)V", "TAG", "", "mixCost", "", "getMixCost", "()J", "setMixCost", "(J)V", "getMixInfo", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "timeEnter", "getTimeEnter", "call", "", "handleResult", "success", "", "uniqueId", "plugin-emojicapture_release"})
public final class h extends c {
    final String TAG = "MicroMsg.EmojiMixTask";
    final long ezZ = this.liK.ezZ;
    long liJ;
    final d liK;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    static final class a extends k implements b<Boolean, y> {
        final /* synthetic */ h liL;
        final /* synthetic */ long liM;

        a(h hVar, long j) {
            this.liL = hVar;
            this.liM = j;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(2677);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            ab.i(this.liL.TAG, String.valueOf(this.liL.ezZ) + " mix end: " + this.liL.liK.lis + ' ' + booleanValue);
            this.liL.liK.liy.stop();
            this.liL.liJ = bo.gb(this.liM);
            if (booleanValue) {
                h.a(this.liL, true);
                this.liL.a(com.tencent.mm.loader.g.h.OK);
            } else {
                h.a(this.liL, false);
                this.liL.a(com.tencent.mm.loader.g.h.Fail);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(2677);
            return yVar;
        }
    }

    public h(d dVar) {
        j.p(dVar, "mixInfo");
        AppMethodBeat.i(2680);
        this.liK = dVar;
        AppMethodBeat.o(2680);
    }

    public final void Pa() {
        double d;
        Object valueOf;
        boolean z;
        Object obj = null;
        AppMethodBeat.i(2678);
        k kVar = new k(this.liK.videoPath, this.liK.liy, this.liK.lis, this.liK.liz, this.liK.liA, this.liK.liB, this.liK.liC, this.liK.ezZ);
        long anU = bo.anU();
        for (com.tencent.mm.media.editor.a.b init : this.liK.liy.eWG) {
            init.init();
        }
        EmojiCaptureReporter.up(37);
        b aVar = new a(this, anU);
        kVar.eyR = System.currentTimeMillis();
        com.tencent.mm.plugin.sight.base.a WR = d.WR(kVar.videoPath);
        if ((WR != null ? Integer.valueOf(WR.eTk) : null) instanceof Integer) {
            d = 1000.0d / ((double) WR.eTk);
        } else {
            d = 0.0d;
        }
        kVar.lja = aVar;
        String str = "MicroMsg.EmojiMixer";
        StringBuilder stringBuilder = new StringBuilder("start decode ");
        Thread currentThread = Thread.currentThread();
        j.o(currentThread, "Thread.currentThread()");
        StringBuilder append = stringBuilder.append(currentThread.getId()).append(", fps: ");
        if (WR != null) {
            valueOf = Integer.valueOf(WR.eTk);
        } else {
            valueOf = null;
        }
        stringBuilder = append.append(valueOf).append(", duration: ");
        if (WR != null) {
            obj = Integer.valueOf(WR.eWK);
        }
        ab.i(str, stringBuilder.append(obj).append(", videoFrameDuration: ").append(d).append(", removeBackground:").append(kVar.ljd).append(", path: ").append(kVar.videoPath).toString());
        kVar.frameCount = 0;
        com.tencent.mm.plugin.emojicapture.model.d dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
        boolean z2 = kVar.ljd;
        boolean z3 = kVar.liB;
        if (kVar.liz > 1) {
            z = true;
        } else {
            z = false;
        }
        com.tencent.mm.plugin.emojicapture.model.d.a(z2, z3, z, WR != null ? WR.eWK : 0);
        if (kVar.liC) {
            dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
            com.tencent.mm.plugin.emojicapture.model.d.bne();
        } else {
            dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
            com.tencent.mm.plugin.emojicapture.model.d.bnd();
        }
        kVar.liY = new b(kVar.videoPath, kVar.ljc, kVar.liz);
        if (!bo.isNullOrNil(kVar.hzs)) {
            String str2 = kVar.hzs;
            com.tencent.mm.plugin.emojicapture.model.c.a aVar2 = com.tencent.mm.plugin.emojicapture.model.c.lhw;
            int bmN = com.tencent.mm.plugin.emojicapture.model.c.lhv;
            aVar2 = com.tencent.mm.plugin.emojicapture.model.c.lhw;
            int bmN2 = com.tencent.mm.plugin.emojicapture.model.c.lhv;
            e eVar = kVar.liY;
            if (eVar == null) {
                j.avw("syncMgr");
            }
            kVar.liZ = new c(str2, bmN, bmN2, (long) eVar.eWU, kVar.liC);
        }
        com.tencent.mm.plugin.emojicapture.model.c.a aVar3 = com.tencent.mm.plugin.emojicapture.model.c.lhw;
        int bmN3 = com.tencent.mm.plugin.emojicapture.model.c.lhv;
        com.tencent.mm.plugin.emojicapture.model.c.a aVar4 = com.tencent.mm.plugin.emojicapture.model.c.lhw;
        kVar.liX = new com.tencent.mm.plugin.emojicapture.ui.b.d(bmN3, com.tencent.mm.plugin.emojicapture.model.c.lhv);
        com.tencent.mm.plugin.emojicapture.ui.b.d dVar2 = kVar.liX;
        if (dVar2 == null) {
            j.avw("mixPixelBuffer");
        }
        dVar2.loY = new d(kVar);
        dVar2 = kVar.liX;
        if (dVar2 == null) {
            j.avw("mixPixelBuffer");
        }
        dVar2.loW.post(new com.tencent.mm.plugin.emojicapture.ui.b.d.b(dVar2, new e(kVar, WR)));
        AppMethodBeat.o(2678);
    }

    public final String Pc() {
        AppMethodBeat.i(2679);
        String valueOf = String.valueOf(this.ezZ);
        AppMethodBeat.o(2679);
        return valueOf;
    }

    public static final /* synthetic */ void a(h hVar, boolean z) {
        AppMethodBeat.i(2681);
        com.tencent.mm.emoji.d.b bVar;
        com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a aVar;
        if (z) {
            if (!com.tencent.mm.plugin.emojicapture.ui.a.uD(hVar.liK.scene)) {
                bVar = com.tencent.mm.emoji.d.b.ezV;
                com.tencent.mm.emoji.d.b.b(hVar.liK.ezZ, true, null);
            }
            aVar = EmojiCaptureProxy.lkM;
            EmojiCaptureProxy access$getInstance$cp = EmojiCaptureProxy.lkL;
            String str = hVar.liK.lis;
            String Aq = hVar.liK.exP.Aq();
            j.o(Aq, "mixInfo.emojiInfo.md5");
            access$getInstance$cp.postUploadTask(str, Aq);
            EmojiCaptureReporter.e(hVar.ezZ, hVar.liJ, hVar.liK.scene);
            EmojiCaptureReporter.dU(38, (int) hVar.liJ);
            AppMethodBeat.o(2681);
            return;
        }
        bVar = com.tencent.mm.emoji.d.b.ezV;
        com.tencent.mm.emoji.d.b.b(hVar.liK.ezZ, false, null);
        hVar.liK.exP.a(EmojiInfo.b.ERR_MIX_VIDEO_ZERO_FRAME);
        hVar.liK.exP.a(com.tencent.mm.storage.emotion.EmojiInfo.a.STATUS_MIX_FAIL);
        aVar = EmojiCaptureProxy.lkM;
        EmojiCaptureProxy.lkL.updateEmojiInfo(hVar.liK.exP);
        EmojiCaptureReporter.h(hVar.ezZ, 3, hVar.liK.scene);
        AppMethodBeat.o(2681);
    }
}
