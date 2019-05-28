package com.tencent.p177mm.media.p253f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p196e.C37488e;
import com.tencent.p177mm.audio.mix.p830a.C45164d;
import com.tencent.p177mm.media.p867i.C18594c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 :2\u00020\u0001:\u0001:Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u00128\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n0\f¢\u0006\u0002\u0010\u0013J\b\u0010/\u001a\u00020\nH\u0002J.\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0003J\u000e\u00104\u001a\u00020\n2\u0006\u00102\u001a\u00020\u0015J\b\u00105\u001a\u00020\nH\u0002J\u0006\u00106\u001a\u00020\nJ\u0006\u00107\u001a\u00020\nJ0\u00108\u001a\u00020\u00192\u0006\u00109\u001a\u00020\r2\u0006\u00102\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002R\u000e\u0010\u0014\u001a\u00020\u0015XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R2\u0010\u0017\u001a&\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019 \u001a*\u0012\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u001b0\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u000e¢\u0006\u0002\n\u0000R@\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n0\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R2\u0010-\u001a&\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019 \u001a*\u0012\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u001b0\u0018X\u000e¢\u0006\u0002\n\u0000R2\u0010.\u001a&\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019 \u001a*\u0012\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u001b0\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, dWq = {"Lcom/tencent/mm/media/mix/AudioMixCodec;", "", "sampleRate", "", "channels", "mixBackground", "", "mixMusic", "frameMix", "Lkotlin/Function0;", "", "frameMixEnd", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "data", "", "pts", "(IIZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "TAG", "", "backgroundFrameCount", "backgroundPcmDataList", "", "Lcom/tencent/mm/audio/mix/buffer/PcmDataTrack;", "kotlin.jvm.PlatformType", "", "bitDepth", "flushAllData", "flushLock", "Ljava/lang/Object;", "frameLength", "index", "isBackgroundEnd", "isMixing", "isMixingFinish", "isMusicEnd", "mAudioSyncMixController", "Lcom/tencent/mm/audio/mix/mix/AudioSyncMixController;", "mMixRunnable", "Ljava/lang/Runnable;", "mPts", "mixLock", "musicFrameCount", "musicPcmDataList", "pcmDataList", "getAudioData", "input", "pcmData", "audioId", "channelCount", "inputEnd", "runMix", "startMix", "stopMix", "zipPcmDataTrack", "buffer", "Companion", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.f.a */
public final class C1774a {
    public static final C1777a eWE = new C1777a();
    public final String TAG = "MicroMsg.AudioMixCodec";
    private int channels;
    private final int cku = 2;
    private final boolean eWA;
    private final boolean eWB;
    private C31214a<C37091y> eWC;
    public C31591m<? super byte[], ? super Long, C37091y> eWD;
    public final C37488e eWk = new C37488e();
    private final int eWl = 2048;
    public long eWm;
    private List<C45164d> eWn = Collections.synchronizedList(new ArrayList());
    private List<C45164d> eWo = Collections.synchronizedList(new ArrayList());
    public final List<C45164d> eWp = Collections.synchronizedList(new ArrayList());
    public volatile boolean eWq;
    public volatile boolean eWr;
    public volatile boolean eWs;
    public final Object eWt = new Object();
    public final Object eWu = new Object();
    private int eWv;
    private int eWw;
    private boolean eWx;
    private boolean eWy;
    private final Runnable eWz;
    private int index;
    private int sampleRate;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.f.a$c */
    public static final class C1775c extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C1774a eWF;

        public C1775c(C1774a c1774a) {
            this.eWF = c1774a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(12983);
            this.eWF.eWz.run();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(12983);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.media.f.a$b */
    static final class C1776b implements Runnable {
        final /* synthetic */ C1774a eWF;

        C1776b(C1774a c1774a) {
            this.eWF = c1774a;
        }

        public final void run() {
            AppMethodBeat.m2504i(12982);
            while (this.eWF.eWr) {
                try {
                    C37091y c37091y;
                    synchronized (this.eWF.eWt) {
                        this.eWF.eWt.wait();
                        c37091y = C37091y.AUy;
                    }
                    C4990ab.m7416i(this.eWF.TAG, "mixBackground:" + this.eWF.eWA + ", mixMusic:" + this.eWF.eWB + ", music:" + this.eWF.eWo.size() + ", background:" + this.eWF.eWn.size());
                    synchronized (this.eWF.eWu) {
                        do {
                            if (this.eWF.eWn.size() > 0 || this.eWF.eWo.size() > 0) {
                                int i;
                                if (!this.eWF.eWA || !this.eWF.eWB) {
                                    if (this.eWF.eWA || this.eWF.eWB) {
                                        this.eWF.eWC.invoke();
                                        for (i = 0; i <= 0; i++) {
                                            C1774a.m3660l(this.eWF);
                                            C1774a.m3661m(this.eWF);
                                        }
                                        if (this.eWF.eWB) {
                                            if (this.eWF.eWo.size() <= 0) {
                                                break;
                                            }
                                        }
                                        if (this.eWF.eWA && this.eWF.eWn.size() <= 0) {
                                            break;
                                        }
                                    }
                                } else if (this.eWF.eWn.size() <= 0 || this.eWF.eWo.size() <= 0) {
                                    break;
                                } else {
                                    this.eWF.eWC.invoke();
                                    for (i = 0; i <= 0; i++) {
                                        C1774a.m3660l(this.eWF);
                                        C1774a.m3661m(this.eWF);
                                    }
                                }
                            } else {
                                break;
                            }
                        } while (this.eWF.eWs);
                        if (this.eWF.eWs) {
                            C4990ab.m7416i(this.eWF.TAG, "flush data finish");
                            this.eWF.eWr = false;
                            this.eWF.eWq = true;
                            this.eWF.eWu.notifyAll();
                        }
                        c37091y = C37091y.AUy;
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace(this.eWF.TAG, e, "", new Object[0]);
                    C18594c c18594c = C18594c.faj;
                    C18594c.m28959VQ();
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(12982);
                }
            }
            C4990ab.m7416i(this.eWF.TAG, "finish mix");
            AppMethodBeat.m2505o(12982);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/media/mix/AudioMixCodec$Companion;", "", "()V", "BACKGROUND", "", "BATCH_MIX_NUM", "", "MIX_ALL", "MIX_BACKGROUND", "MIX_MUSIC", "MIX_SILENT", "MUSIC", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.f.a$a */
    public static final class C1777a {
        private C1777a() {
        }

        public /* synthetic */ C1777a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(12987);
        AppMethodBeat.m2505o(12987);
    }

    public C1774a(int i, int i2, boolean z, boolean z2, C31214a<C37091y> c31214a, C31591m<? super byte[], ? super Long, C37091y> c31591m) {
        C25052j.m39376p(c31214a, "frameMix");
        C25052j.m39376p(c31591m, "frameMixEnd");
        AppMethodBeat.m2504i(12986);
        this.sampleRate = i;
        this.channels = i2;
        this.eWA = z;
        this.eWB = z2;
        this.eWC = c31214a;
        this.eWD = c31591m;
        C4990ab.m7416i(this.TAG, "init AudioMixCodec, sampleRate:" + this.sampleRate + ", channels:" + this.channels + ", mixBackground:" + this.eWA + ", mixMusic:" + this.eWB);
        this.eWk.mo60418r(this.sampleRate, this.channels, this.cku, this.eWl);
        this.eWz = new C1776b(this);
        AppMethodBeat.m2505o(12986);
    }

    /* renamed from: lV */
    public final void mo5322lV(String str) {
        Object obj = 1;
        AppMethodBeat.m2504i(12984);
        C25052j.m39376p(str, "audioId");
        synchronized (this.eWt) {
            C4990ab.m7416i(this.TAG, "inputEnd, audioId:" + str + ", mixBackground:" + this.eWA + ", mixMusic:" + this.eWB);
            if (C25052j.m39373j(str, "background")) {
                this.eWx = true;
            }
            if (C25052j.m39373j(str, "music")) {
                this.eWy = true;
            }
            if (!this.eWA || !this.eWB) {
                try {
                    if (!((this.eWA && this.eWx) || (this.eWB && this.eWy))) {
                        obj = null;
                    }
                } finally {
                    AppMethodBeat.m2505o(12984);
                }
            } else if (!(this.eWy && this.eWx)) {
                obj = null;
            }
            if (obj != null) {
                try {
                    this.eWs = true;
                    C4990ab.m7416i(this.TAG, "notify mix");
                    this.eWt.notifyAll();
                } catch (Exception e) {
                }
            }
            C37091y c37091y = C37091y.AUy;
        }
    }

    /* renamed from: a */
    public final boolean mo5321a(byte[] bArr, String str, long j, int i, int i2) {
        AppMethodBeat.m2504i(12985);
        C25052j.m39376p(bArr, "pcmData");
        C25052j.m39376p(str, "audioId");
        synchronized (this.eWt) {
            try {
                C4990ab.m7416i(this.TAG, "pcmData len:" + bArr.length + ", audioId:" + str + ", sampleRate:" + i + ", channelCount:" + i2 + ", pts:" + j);
                C45164d c45164d = new C45164d();
                c45164d.ckD = str;
                c45164d.ckv = bArr;
                c45164d.sampleRate = i;
                c45164d.channels = i2;
                c45164d.ckG = j;
                String str2;
                StringBuilder stringBuilder;
                int i3;
                switch (str.hashCode()) {
                    case -1332194002:
                        if (str.equals("background")) {
                            C4990ab.m7416i(this.TAG, "input the background data num = " + this.eWn.size());
                            this.eWn.add(c45164d);
                            str2 = this.TAG;
                            stringBuilder = new StringBuilder("input background data:");
                            i3 = this.eWv;
                            this.eWv = i3 + 1;
                            C4990ab.m7416i(str2, stringBuilder.append(i3).toString());
                            break;
                        }
                        break;
                    case 104263205:
                        if (str.equals("music")) {
                            C4990ab.m7416i(this.TAG, "input the music data num = " + this.eWo.size());
                            this.eWo.add(c45164d);
                            str2 = this.TAG;
                            stringBuilder = new StringBuilder("input music data:");
                            i3 = this.eWw;
                            this.eWw = i3 + 1;
                            C4990ab.m7416i(str2, stringBuilder.append(i3).toString());
                            break;
                        }
                        break;
                }
                C37091y c37091y;
                if (this.eWB && this.eWA) {
                    if (this.eWo.size() > 0 && this.eWn.size() > 0) {
                        try {
                            C4990ab.m7416i(this.TAG, "notify mix");
                            this.eWt.notifyAll();
                        } catch (Exception e) {
                        }
                    }
                    c37091y = C37091y.AUy;
                } else {
                    if ((this.eWB || this.eWA) && (this.eWo.size() > 0 || this.eWn.size() > 0)) {
                        try {
                            C4990ab.m7416i(this.TAG, "notify mix");
                            this.eWt.notifyAll();
                        } catch (Exception e2) {
                        }
                    }
                    c37091y = C37091y.AUy;
                }
            } catch (Exception e3) {
                C4990ab.printErrStackTrace(this.TAG, e3, "", new Object[0]);
                C18594c c18594c = C18594c.faj;
                C18594c.m28959VQ();
            } catch (Throwable th) {
                AppMethodBeat.m2505o(12985);
            }
        }
        AppMethodBeat.m2505o(12985);
        return true;
    }

    /* renamed from: l */
    public static final /* synthetic */ void m3660l(C1774a c1774a) {
        AppMethodBeat.m2504i(12988);
        List list = c1774a.eWp;
        C25052j.m39375o(list, "pcmDataList");
        synchronized (list) {
            try {
                C45164d c45164d;
                c1774a.eWp.clear();
                C4990ab.m7416i(c1774a.TAG, "getAudioData, background:" + c1774a.eWn.size() + ", music:" + c1774a.eWo.size());
                if (c1774a.eWA && c1774a.eWn.size() > 0) {
                    c45164d = (C45164d) c1774a.eWn.get(0);
                    c1774a.eWp.add(c45164d);
                    c1774a.eWn.remove(c45164d);
                }
                if (c1774a.eWB && c1774a.eWo.size() > 0) {
                    c45164d = (C45164d) c1774a.eWo.get(0);
                    c1774a.eWp.add(c45164d);
                    c1774a.eWo.remove(c45164d);
                }
                String str = c1774a.TAG;
                StringBuilder stringBuilder = new StringBuilder("get audio data num ");
                int i = c1774a.index;
                c1774a.index = i + 1;
                C4990ab.m7416i(str, stringBuilder.append(i).toString());
                C37091y c37091y = C37091y.AUy;
            } finally {
                AppMethodBeat.m2505o(12988);
            }
        }
    }

    /* renamed from: m */
    public static final /* synthetic */ void m3661m(C1774a c1774a) {
        AppMethodBeat.m2504i(12989);
        List list = c1774a.eWp;
        C25052j.m39375o(list, "pcmDataList");
        synchronized (list) {
            try {
                C37091y c37091y;
                C4990ab.m7416i(c1774a.TAG, "the mix thread running mix " + c1774a.index + " pcmDataListSize: " + c1774a.eWp.size());
                if (c1774a.eWp.size() > 0) {
                    long yz = C5046bo.m7588yz();
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(c1774a.eWp);
                    byte[] J = c1774a.eWk.mo60417J(arrayList);
                    if (J != null) {
                        long j = 0;
                        Iterable<C45164d> iterable = arrayList;
                        synchronized (iterable) {
                            for (C45164d c45164d : iterable) {
                                if (C25052j.m39373j(c45164d.ckD, "music")) {
                                    j = c45164d.ckG;
                                }
                            }
                            c37091y = C37091y.AUy;
                        }
                        C4990ab.m7416i(c1774a.TAG, "mix finish pcm frame size: " + J.length + ", musicPts:" + j + ", cost:" + C5046bo.m7525az(yz));
                        c1774a.eWD.mo212m(J, Long.valueOf(j));
                    }
                }
                c37091y = C37091y.AUy;
            } catch (Throwable th) {
            } finally {
                AppMethodBeat.m2505o(12989);
            }
        }
    }
}
