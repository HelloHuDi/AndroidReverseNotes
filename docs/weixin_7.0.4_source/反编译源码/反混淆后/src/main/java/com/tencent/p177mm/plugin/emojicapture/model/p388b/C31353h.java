package com.tencent.p177mm.plugin.emojicapture.model.p388b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.p228d.C41949b;
import com.tencent.p177mm.loader.p864g.C26365c;
import com.tencent.p177mm.loader.p864g.C45423h;
import com.tencent.p177mm.media.editor.p252a.C9584b;
import com.tencent.p177mm.media.p253f.C32745e;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c.C11617a;
import com.tencent.p177mm.plugin.emojicapture.model.C34007d;
import com.tencent.p177mm.plugin.emojicapture.model.p388b.C38916k.C38915e;
import com.tencent.p177mm.plugin.emojicapture.model.p388b.C38916k.C38917d;
import com.tencent.p177mm.plugin.emojicapture.p389ui.C20443a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C11623d;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C11623d.C11627b;
import com.tencent.p177mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.p177mm.plugin.emojicapture.proxy.EmojiCaptureProxy.C20437a;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo.C30301b;
import com.tencent.p177mm.storage.emotion.EmojiInfo.C30302a;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "mixInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "(Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;)V", "TAG", "", "mixCost", "", "getMixCost", "()J", "setMixCost", "(J)V", "getMixInfo", "()Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "timeEnter", "getTimeEnter", "call", "", "handleResult", "success", "", "uniqueId", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.b.h */
public final class C31353h extends C26365c {
    final String TAG = "MicroMsg.EmojiMixTask";
    final long ezZ = this.liK.ezZ;
    long liJ;
    final C11615d liK;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.h$a */
    static final class C31354a extends C25053k implements C17126b<Boolean, C37091y> {
        final /* synthetic */ C31353h liL;
        final /* synthetic */ long liM;

        C31354a(C31353h c31353h, long j) {
            this.liL = c31353h;
            this.liM = j;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(2677);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            C4990ab.m7416i(this.liL.TAG, String.valueOf(this.liL.ezZ) + " mix end: " + this.liL.liK.lis + ' ' + booleanValue);
            this.liL.liK.liy.stop();
            this.liL.liJ = C5046bo.m7566gb(this.liM);
            if (booleanValue) {
                C31353h.m50652a(this.liL, true);
                this.liL.mo44157a(C45423h.OK);
            } else {
                C31353h.m50652a(this.liL, false);
                this.liL.mo44157a(C45423h.Fail);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2677);
            return c37091y;
        }
    }

    public C31353h(C11615d c11615d) {
        C25052j.m39376p(c11615d, "mixInfo");
        AppMethodBeat.m2504i(2680);
        this.liK = c11615d;
        AppMethodBeat.m2505o(2680);
    }

    /* renamed from: Pa */
    public final void mo9026Pa() {
        double d;
        Object valueOf;
        boolean z;
        Object obj = null;
        AppMethodBeat.m2504i(2678);
        C38916k c38916k = new C38916k(this.liK.videoPath, this.liK.liy, this.liK.lis, this.liK.liz, this.liK.liA, this.liK.liB, this.liK.liC, this.liK.ezZ);
        long anU = C5046bo.anU();
        for (C9584b init : this.liK.liy.eWG) {
            init.init();
        }
        EmojiCaptureReporter.m66038up(37);
        C17126b c31354a = new C31354a(this, anU);
        c38916k.eyR = System.currentTimeMillis();
        C43528a WR = C21846d.m33388WR(c38916k.videoPath);
        if ((WR != null ? Integer.valueOf(WR.eTk) : null) instanceof Integer) {
            d = 1000.0d / ((double) WR.eTk);
        } else {
            d = 0.0d;
        }
        c38916k.lja = c31354a;
        String str = "MicroMsg.EmojiMixer";
        StringBuilder stringBuilder = new StringBuilder("start decode ");
        Thread currentThread = Thread.currentThread();
        C25052j.m39375o(currentThread, "Thread.currentThread()");
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
        C4990ab.m7416i(str, stringBuilder.append(obj).append(", videoFrameDuration: ").append(d).append(", removeBackground:").append(c38916k.ljd).append(", path: ").append(c38916k.videoPath).toString());
        c38916k.frameCount = 0;
        C34007d c34007d = C34007d.lhz;
        boolean z2 = c38916k.ljd;
        boolean z3 = c38916k.liB;
        if (c38916k.liz > 1) {
            z = true;
        } else {
            z = false;
        }
        C34007d.m55707a(z2, z3, z, WR != null ? WR.eWK : 0);
        if (c38916k.liC) {
            c34007d = C34007d.lhz;
            C34007d.bne();
        } else {
            c34007d = C34007d.lhz;
            C34007d.bnd();
        }
        c38916k.liY = new C38909b(c38916k.videoPath, c38916k.ljc, c38916k.liz);
        if (!C5046bo.isNullOrNil(c38916k.hzs)) {
            String str2 = c38916k.hzs;
            C11617a c11617a = C34006c.lhw;
            int bmN = C34006c.lhv;
            c11617a = C34006c.lhw;
            int bmN2 = C34006c.lhv;
            C32745e c32745e = c38916k.liY;
            if (c32745e == null) {
                C25052j.avw("syncMgr");
            }
            c38916k.liZ = new C45867c(str2, bmN, bmN2, (long) c32745e.eWU, c38916k.liC);
        }
        C11617a c11617a2 = C34006c.lhw;
        int bmN3 = C34006c.lhv;
        C11617a c11617a3 = C34006c.lhw;
        c38916k.liX = new C11623d(bmN3, C34006c.lhv);
        C11623d c11623d = c38916k.liX;
        if (c11623d == null) {
            C25052j.avw("mixPixelBuffer");
        }
        c11623d.loY = new C38917d(c38916k);
        c11623d = c38916k.liX;
        if (c11623d == null) {
            C25052j.avw("mixPixelBuffer");
        }
        c11623d.loW.post(new C11627b(c11623d, new C38915e(c38916k, WR)));
        AppMethodBeat.m2505o(2678);
    }

    /* renamed from: Pc */
    public final String mo9027Pc() {
        AppMethodBeat.m2504i(2679);
        String valueOf = String.valueOf(this.ezZ);
        AppMethodBeat.m2505o(2679);
        return valueOf;
    }

    /* renamed from: a */
    public static final /* synthetic */ void m50652a(C31353h c31353h, boolean z) {
        AppMethodBeat.m2504i(2681);
        C41949b c41949b;
        C20437a c20437a;
        if (z) {
            if (!C20443a.m31597uD(c31353h.liK.scene)) {
                c41949b = C41949b.ezV;
                C41949b.m74084b(c31353h.liK.ezZ, true, null);
            }
            c20437a = EmojiCaptureProxy.lkM;
            EmojiCaptureProxy access$getInstance$cp = EmojiCaptureProxy.lkL;
            String str = c31353h.liK.lis;
            String Aq = c31353h.liK.exP.mo20410Aq();
            C25052j.m39375o(Aq, "mixInfo.emojiInfo.md5");
            access$getInstance$cp.postUploadTask(str, Aq);
            EmojiCaptureReporter.m66035e(c31353h.ezZ, c31353h.liJ, c31353h.liK.scene);
            EmojiCaptureReporter.m66034dU(38, (int) c31353h.liJ);
            AppMethodBeat.m2505o(2681);
            return;
        }
        c41949b = C41949b.ezV;
        C41949b.m74084b(c31353h.liK.ezZ, false, null);
        c31353h.liK.exP.mo48511a(C30301b.ERR_MIX_VIDEO_ZERO_FRAME);
        c31353h.liK.exP.mo48510a(C30302a.STATUS_MIX_FAIL);
        c20437a = EmojiCaptureProxy.lkM;
        EmojiCaptureProxy.lkL.updateEmojiInfo(c31353h.liK.exP);
        EmojiCaptureReporter.m66037h(c31353h.ezZ, 3, c31353h.liK.scene);
        AppMethodBeat.m2505o(2681);
    }
}
