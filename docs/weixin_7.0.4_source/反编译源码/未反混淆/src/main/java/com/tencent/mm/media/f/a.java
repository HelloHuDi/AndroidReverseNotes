package com.tencent.mm.media.f;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.mm.audio.mix.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 :2\u00020\u0001:\u0001:Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u00128\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n0\f¢\u0006\u0002\u0010\u0013J\b\u0010/\u001a\u00020\nH\u0002J.\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0003J\u000e\u00104\u001a\u00020\n2\u0006\u00102\u001a\u00020\u0015J\b\u00105\u001a\u00020\nH\u0002J\u0006\u00106\u001a\u00020\nJ\u0006\u00107\u001a\u00020\nJ0\u00108\u001a\u00020\u00192\u0006\u00109\u001a\u00020\r2\u0006\u00102\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002R\u000e\u0010\u0014\u001a\u00020\u0015XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R2\u0010\u0017\u001a&\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019 \u001a*\u0012\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u001b0\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u000e¢\u0006\u0002\n\u0000R@\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n0\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R2\u0010-\u001a&\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019 \u001a*\u0012\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u001b0\u0018X\u000e¢\u0006\u0002\n\u0000R2\u0010.\u001a&\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019 \u001a*\u0012\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u001b0\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, dWq = {"Lcom/tencent/mm/media/mix/AudioMixCodec;", "", "sampleRate", "", "channels", "mixBackground", "", "mixMusic", "frameMix", "Lkotlin/Function0;", "", "frameMixEnd", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "data", "", "pts", "(IIZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "TAG", "", "backgroundFrameCount", "backgroundPcmDataList", "", "Lcom/tencent/mm/audio/mix/buffer/PcmDataTrack;", "kotlin.jvm.PlatformType", "", "bitDepth", "flushAllData", "flushLock", "Ljava/lang/Object;", "frameLength", "index", "isBackgroundEnd", "isMixing", "isMixingFinish", "isMusicEnd", "mAudioSyncMixController", "Lcom/tencent/mm/audio/mix/mix/AudioSyncMixController;", "mMixRunnable", "Ljava/lang/Runnable;", "mPts", "mixLock", "musicFrameCount", "musicPcmDataList", "pcmDataList", "getAudioData", "input", "pcmData", "audioId", "channelCount", "inputEnd", "runMix", "startMix", "stopMix", "zipPcmDataTrack", "buffer", "Companion", "plugin-mediaeditor_release"})
public final class a {
    public static final a eWE = new a();
    public final String TAG = "MicroMsg.AudioMixCodec";
    private int channels;
    private final int cku = 2;
    private final boolean eWA;
    private final boolean eWB;
    private a.f.a.a<y> eWC;
    public m<? super byte[], ? super Long, y> eWD;
    public final e eWk = new e();
    private final int eWl = 2048;
    public long eWm;
    private List<d> eWn = Collections.synchronizedList(new ArrayList());
    private List<d> eWo = Collections.synchronizedList(new ArrayList());
    public final List<d> eWp = Collections.synchronizedList(new ArrayList());
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

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class c extends k implements a.f.a.a<y> {
        final /* synthetic */ a eWF;

        public c(a aVar) {
            this.eWF = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(12983);
            this.eWF.eWz.run();
            y yVar = y.AUy;
            AppMethodBeat.o(12983);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ a eWF;

        b(a aVar) {
            this.eWF = aVar;
        }

        public final void run() {
            AppMethodBeat.i(12982);
            while (this.eWF.eWr) {
                try {
                    y yVar;
                    synchronized (this.eWF.eWt) {
                        this.eWF.eWt.wait();
                        yVar = y.AUy;
                    }
                    ab.i(this.eWF.TAG, "mixBackground:" + this.eWF.eWA + ", mixMusic:" + this.eWF.eWB + ", music:" + this.eWF.eWo.size() + ", background:" + this.eWF.eWn.size());
                    synchronized (this.eWF.eWu) {
                        do {
                            if (this.eWF.eWn.size() > 0 || this.eWF.eWo.size() > 0) {
                                int i;
                                if (!this.eWF.eWA || !this.eWF.eWB) {
                                    if (this.eWF.eWA || this.eWF.eWB) {
                                        this.eWF.eWC.invoke();
                                        for (i = 0; i <= 0; i++) {
                                            a.l(this.eWF);
                                            a.m(this.eWF);
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
                                        a.l(this.eWF);
                                        a.m(this.eWF);
                                    }
                                }
                            } else {
                                break;
                            }
                        } while (this.eWF.eWs);
                        if (this.eWF.eWs) {
                            ab.i(this.eWF.TAG, "flush data finish");
                            this.eWF.eWr = false;
                            this.eWF.eWq = true;
                            this.eWF.eWu.notifyAll();
                        }
                        yVar = y.AUy;
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace(this.eWF.TAG, e, "", new Object[0]);
                    com.tencent.mm.media.i.c cVar = com.tencent.mm.media.i.c.faj;
                    com.tencent.mm.media.i.c.VQ();
                } catch (Throwable th) {
                    AppMethodBeat.o(12982);
                }
            }
            ab.i(this.eWF.TAG, "finish mix");
            AppMethodBeat.o(12982);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/media/mix/AudioMixCodec$Companion;", "", "()V", "BACKGROUND", "", "BATCH_MIX_NUM", "", "MIX_ALL", "MIX_BACKGROUND", "MIX_MUSIC", "MIX_SILENT", "MUSIC", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(12987);
        AppMethodBeat.o(12987);
    }

    public a(int i, int i2, boolean z, boolean z2, a.f.a.a<y> aVar, m<? super byte[], ? super Long, y> mVar) {
        j.p(aVar, "frameMix");
        j.p(mVar, "frameMixEnd");
        AppMethodBeat.i(12986);
        this.sampleRate = i;
        this.channels = i2;
        this.eWA = z;
        this.eWB = z2;
        this.eWC = aVar;
        this.eWD = mVar;
        ab.i(this.TAG, "init AudioMixCodec, sampleRate:" + this.sampleRate + ", channels:" + this.channels + ", mixBackground:" + this.eWA + ", mixMusic:" + this.eWB);
        this.eWk.r(this.sampleRate, this.channels, this.cku, this.eWl);
        this.eWz = new b(this);
        AppMethodBeat.o(12986);
    }

    public final void lV(String str) {
        Object obj = 1;
        AppMethodBeat.i(12984);
        j.p(str, "audioId");
        synchronized (this.eWt) {
            ab.i(this.TAG, "inputEnd, audioId:" + str + ", mixBackground:" + this.eWA + ", mixMusic:" + this.eWB);
            if (j.j(str, "background")) {
                this.eWx = true;
            }
            if (j.j(str, "music")) {
                this.eWy = true;
            }
            if (!this.eWA || !this.eWB) {
                try {
                    if (!((this.eWA && this.eWx) || (this.eWB && this.eWy))) {
                        obj = null;
                    }
                } finally {
                    AppMethodBeat.o(12984);
                }
            } else if (!(this.eWy && this.eWx)) {
                obj = null;
            }
            if (obj != null) {
                try {
                    this.eWs = true;
                    ab.i(this.TAG, "notify mix");
                    this.eWt.notifyAll();
                } catch (Exception e) {
                }
            }
            y yVar = y.AUy;
        }
    }

    public final boolean a(byte[] bArr, String str, long j, int i, int i2) {
        AppMethodBeat.i(12985);
        j.p(bArr, "pcmData");
        j.p(str, "audioId");
        synchronized (this.eWt) {
            try {
                ab.i(this.TAG, "pcmData len:" + bArr.length + ", audioId:" + str + ", sampleRate:" + i + ", channelCount:" + i2 + ", pts:" + j);
                d dVar = new d();
                dVar.ckD = str;
                dVar.ckv = bArr;
                dVar.sampleRate = i;
                dVar.channels = i2;
                dVar.ckG = j;
                String str2;
                StringBuilder stringBuilder;
                int i3;
                switch (str.hashCode()) {
                    case -1332194002:
                        if (str.equals("background")) {
                            ab.i(this.TAG, "input the background data num = " + this.eWn.size());
                            this.eWn.add(dVar);
                            str2 = this.TAG;
                            stringBuilder = new StringBuilder("input background data:");
                            i3 = this.eWv;
                            this.eWv = i3 + 1;
                            ab.i(str2, stringBuilder.append(i3).toString());
                            break;
                        }
                        break;
                    case 104263205:
                        if (str.equals("music")) {
                            ab.i(this.TAG, "input the music data num = " + this.eWo.size());
                            this.eWo.add(dVar);
                            str2 = this.TAG;
                            stringBuilder = new StringBuilder("input music data:");
                            i3 = this.eWw;
                            this.eWw = i3 + 1;
                            ab.i(str2, stringBuilder.append(i3).toString());
                            break;
                        }
                        break;
                }
                y yVar;
                if (this.eWB && this.eWA) {
                    if (this.eWo.size() > 0 && this.eWn.size() > 0) {
                        try {
                            ab.i(this.TAG, "notify mix");
                            this.eWt.notifyAll();
                        } catch (Exception e) {
                        }
                    }
                    yVar = y.AUy;
                } else {
                    if ((this.eWB || this.eWA) && (this.eWo.size() > 0 || this.eWn.size() > 0)) {
                        try {
                            ab.i(this.TAG, "notify mix");
                            this.eWt.notifyAll();
                        } catch (Exception e2) {
                        }
                    }
                    yVar = y.AUy;
                }
            } catch (Exception e3) {
                ab.printErrStackTrace(this.TAG, e3, "", new Object[0]);
                com.tencent.mm.media.i.c cVar = com.tencent.mm.media.i.c.faj;
                com.tencent.mm.media.i.c.VQ();
            } catch (Throwable th) {
                AppMethodBeat.o(12985);
            }
        }
        AppMethodBeat.o(12985);
        return true;
    }

    public static final /* synthetic */ void l(a aVar) {
        AppMethodBeat.i(12988);
        List list = aVar.eWp;
        j.o(list, "pcmDataList");
        synchronized (list) {
            try {
                d dVar;
                aVar.eWp.clear();
                ab.i(aVar.TAG, "getAudioData, background:" + aVar.eWn.size() + ", music:" + aVar.eWo.size());
                if (aVar.eWA && aVar.eWn.size() > 0) {
                    dVar = (d) aVar.eWn.get(0);
                    aVar.eWp.add(dVar);
                    aVar.eWn.remove(dVar);
                }
                if (aVar.eWB && aVar.eWo.size() > 0) {
                    dVar = (d) aVar.eWo.get(0);
                    aVar.eWp.add(dVar);
                    aVar.eWo.remove(dVar);
                }
                String str = aVar.TAG;
                StringBuilder stringBuilder = new StringBuilder("get audio data num ");
                int i = aVar.index;
                aVar.index = i + 1;
                ab.i(str, stringBuilder.append(i).toString());
                y yVar = y.AUy;
            } finally {
                AppMethodBeat.o(12988);
            }
        }
    }

    public static final /* synthetic */ void m(a aVar) {
        AppMethodBeat.i(12989);
        List list = aVar.eWp;
        j.o(list, "pcmDataList");
        synchronized (list) {
            try {
                y yVar;
                ab.i(aVar.TAG, "the mix thread running mix " + aVar.index + " pcmDataListSize: " + aVar.eWp.size());
                if (aVar.eWp.size() > 0) {
                    long yz = bo.yz();
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(aVar.eWp);
                    byte[] J = aVar.eWk.J(arrayList);
                    if (J != null) {
                        long j = 0;
                        Iterable<d> iterable = arrayList;
                        synchronized (iterable) {
                            for (d dVar : iterable) {
                                if (j.j(dVar.ckD, "music")) {
                                    j = dVar.ckG;
                                }
                            }
                            yVar = y.AUy;
                        }
                        ab.i(aVar.TAG, "mix finish pcm frame size: " + J.length + ", musicPts:" + j + ", cost:" + bo.az(yz));
                        aVar.eWD.m(J, Long.valueOf(j));
                    }
                }
                yVar = y.AUy;
            } catch (Throwable th) {
            } finally {
                AppMethodBeat.o(12989);
            }
        }
    }
}
