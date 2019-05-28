package com.tencent.p177mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.modelvideo.C9715b.C9714a;
import com.tencent.p177mm.plugin.p878a.C9794f;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23323a;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C35873d;
import com.tencent.p177mm.pluginsdk.p597ui.CommonVideoView;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerTextureView;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.modelvideo.MMVideoView */
public class MMVideoView extends CommonVideoView implements C9714a {
    private String fUJ;
    protected C9715b fUK;
    protected String fUL;
    public String fUM;
    private C23323a fUN;
    protected int fUO = 0;
    protected int fUP = 0;
    protected C9794f fUQ;
    protected int fUR;
    protected int fUS;
    private boolean fUT;
    protected boolean fUU;
    protected int fUV = 0;
    protected int fUW;
    protected boolean fUX = false;
    private boolean fUY = false;
    private boolean fUZ = false;
    protected C26488a fVa;
    private boolean fVb = false;
    public boolean fVc;
    private C7564ap fVd = new C7564ap(new C187051(), true);

    /* renamed from: com.tencent.mm.modelvideo.MMVideoView$1 */
    class C187051 implements C5015a {
        C187051() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(50629);
            if (MMVideoView.this.klq == null) {
                AppMethodBeat.m2505o(50629);
                return false;
            }
            boolean mm;
            boolean isPlaying = MMVideoView.this.isPlaying();
            if (isPlaying) {
                MMVideoView.m42209b(MMVideoView.this);
            }
            try {
                int currentPosition = MMVideoView.this.klq.getCurrentPosition() / 1000;
                MMVideoView.m42208a(MMVideoView.this, currentPosition);
                mm = MMVideoView.this.mo44255mm(currentPosition);
            } catch (Exception e) {
                C4990ab.m7413e(MMVideoView.this.TAG, "%s online video timer check error [%s] ", MMVideoView.m42212e(MMVideoView.this), e.toString());
                mm = false;
            }
            C4990ab.m7411d(MMVideoView.this.TAG, "%s check timer[%b] isplay[%b]", MMVideoView.m42214g(MMVideoView.this), Boolean.valueOf(mm), Boolean.valueOf(isPlaying));
            false;
            if (mm && isPlaying) {
                AppMethodBeat.m2505o(50629);
                return true;
            }
            AppMethodBeat.m2505o(50629);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.modelvideo.MMVideoView$a */
    public static class C26488a {
        public int fVf;
        public int fVg;

        protected C26488a() {
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m42208a(MMVideoView mMVideoView, int i) {
        AppMethodBeat.m2504i(50662);
        mMVideoView.mo51410ru(i);
        AppMethodBeat.m2505o(50662);
    }

    /* renamed from: b */
    static /* synthetic */ void m42209b(MMVideoView mMVideoView) {
        AppMethodBeat.m2504i(50661);
        mMVideoView.bJc();
        AppMethodBeat.m2505o(50661);
    }

    /* renamed from: e */
    static /* synthetic */ String m42212e(MMVideoView mMVideoView) {
        AppMethodBeat.m2504i(50663);
        String aZk = mMVideoView.aZk();
        AppMethodBeat.m2505o(50663);
        return aZk;
    }

    /* renamed from: g */
    static /* synthetic */ String m42214g(MMVideoView mMVideoView) {
        AppMethodBeat.m2504i(50664);
        String aZk = mMVideoView.aZk();
        AppMethodBeat.m2505o(50664);
        return aZk;
    }

    public MMVideoView(Context context) {
        super(context);
        AppMethodBeat.m2504i(50630);
        AppMethodBeat.m2505o(50630);
    }

    public MMVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(50631);
        AppMethodBeat.m2505o(50631);
    }

    public MMVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(50632);
        AppMethodBeat.m2505o(50632);
    }

    public void initView() {
        AppMethodBeat.m2504i(50633);
        super.initView();
        this.TAG = "MicroMsg.MMVideoView";
        this.fUQ = new C9794f();
        this.fVa = new C26488a();
        akT();
        reset();
        AppMethodBeat.m2505o(50633);
    }

    /* Access modifiers changed, original: protected */
    public void akT() {
        this.fVa.fVf = 5;
        this.fVa.fVg = 2;
    }

    public void reset() {
        this.fUS = -1;
        this.fUV = 0;
        this.fUR = 0;
        this.fUP = 0;
        this.fUO = 0;
        this.fUU = false;
        this.fUX = false;
        this.fUY = false;
        if (this.fVa != null) {
            this.fUW = this.fVa.fVf;
        }
    }

    public void setIOnlineVideoProxy(C9715b c9715b) {
        AppMethodBeat.m2504i(50634);
        this.fUK = c9715b;
        this.fUK.mo8712a(this);
        AppMethodBeat.m2505o(50634);
    }

    public void setIMMDownloadFinish(C23323a c23323a) {
        this.fUN = c23323a;
    }

    /* renamed from: c */
    public void mo9063c(boolean z, String str, int i) {
        AppMethodBeat.m2504i(50635);
        super.mo9063c(z, str, i);
        if (!C5046bo.isNullOrNil(str)) {
            this.fUL = "MMVideo_" + str.hashCode();
            this.fUM = getRootPath() + "MMVideo_" + str.hashCode() + VideoMaterialUtil.MP4_SUFFIX;
            C5730e.m8643tf(C5730e.atb(this.fUM));
            C4990ab.m7417i(this.TAG, "%s set video path [%s %s]", aZk(), this.fUL, this.fUM);
        }
        AppMethodBeat.m2505o(50635);
    }

    public void setRootPath(String str) {
        this.fUJ = str;
    }

    private String getRootPath() {
        AppMethodBeat.m2504i(50636);
        String str;
        if (C5046bo.isNullOrNil(this.fUJ)) {
            str = C6457e.eSn + "video/";
            AppMethodBeat.m2505o(50636);
            return str;
        }
        str = this.fUJ;
        AppMethodBeat.m2505o(50636);
        return str;
    }

    /* Access modifiers changed, original: protected */
    public void akU() {
        AppMethodBeat.m2504i(50637);
        C4990ab.m7409c(this.TAG, "%s prepareVideo", aZk());
        if (this.klq != null) {
            this.fUX = true;
            this.klq.setVideoPath(this.fUM);
        }
        AppMethodBeat.m2505o(50637);
    }

    public void akV() {
        AppMethodBeat.m2504i(50638);
        super.akV();
        if (this.fVb) {
            this.fUZ = true;
            stop();
        }
        AppMethodBeat.m2505o(50638);
    }

    public void akW() {
        AppMethodBeat.m2504i(50639);
        super.akW();
        C4990ab.m7417i(this.TAG, "%s onUIResume stopDownloadByUiPause[%b] currTimeOnUiPause[%d] isPlayOnUiPause[%b]", aZk(), Boolean.valueOf(this.fUZ), Integer.valueOf(this.vgr), Boolean.valueOf(this.vgs));
        if (this.fUZ) {
            mo44252C(this.vgr, this.vgs);
            AppMethodBeat.m2505o(50639);
        } else if (this.klq != null && C1443d.m3068iW(24) && (this.klq instanceof VideoPlayerTextureView)) {
            ((VideoPlayerTextureView) this.klq).bPd();
            AppMethodBeat.m2505o(50639);
        } else {
            AppMethodBeat.m2505o(50639);
        }
    }

    public void start() {
        AppMethodBeat.m2504i(50640);
        C4990ab.m7417i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d]", aZk(), this.fUL, Integer.valueOf(this.fUR));
        if (this.klq != null) {
            if (C5046bo.isNullOrNil(this.klq.getVideoPath())) {
                aNt();
                this.fVb = true;
                this.fUR = 0;
                this.fUO = 1;
                if (this.fUK != null) {
                    this.fUK.mo8715r(this.fUL, this.fUM, this.url);
                    this.fUK.mo8712a(this);
                }
                cso();
            } else {
                play();
            }
            mo51409gp((long) (getReportIdkey() + 1));
        }
        AppMethodBeat.m2505o(50640);
    }

    public void setLoop(boolean z) {
        this.fVc = z;
    }

    /* renamed from: EA */
    public void mo8553EA() {
        AppMethodBeat.m2504i(50641);
        if (this.fVc) {
            mo44252C(0, true);
            AppMethodBeat.m2505o(50641);
            return;
        }
        if (this.fUL != null) {
            this.fUK.mo8713dV(this.fUL);
        }
        reset();
        if (this.klq != null) {
            this.klq.stop();
        }
        super.mo8553EA();
        AppMethodBeat.m2505o(50641);
    }

    public void stop() {
        AppMethodBeat.m2504i(50642);
        if (this.fUK != null) {
            this.fUK.mo8713dV(this.fUL);
        }
        reset();
        super.stop();
        AppMethodBeat.m2505o(50642);
    }

    /* renamed from: cf */
    public C14979e mo9069cf(Context context) {
        AppMethodBeat.m2504i(50643);
        this.vgt = 1;
        VideoPlayerTextureView videoPlayerTextureView = new VideoPlayerTextureView(context);
        videoPlayerTextureView.setNeedResetExtractor(true);
        AppMethodBeat.m2505o(50643);
        return videoPlayerTextureView;
    }

    public void setScaleType(C35873d c35873d) {
        AppMethodBeat.m2504i(50644);
        if (this.klq instanceof VideoPlayerTextureView) {
            ((VideoPlayerTextureView) this.klq).setScaleType(c35873d);
            mo51409gp((long) (getReportIdkey() + 14));
        }
        AppMethodBeat.m2505o(50644);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: mm */
    public final boolean mo44255mm(int i) {
        int i2;
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.m2504i(50645);
        if (this.fUS != -1) {
            i2 = this.fUS;
        } else {
            i2 = i;
        }
        C4990ab.m7417i(this.TAG, "%s check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s isPrepareVideo[%b], isPrepared[%b]", aZk(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.fUV), Integer.valueOf(this.fUR), Integer.valueOf(this.fUP), Integer.valueOf(this.fUO), this.fUL, Boolean.valueOf(this.fUX), Boolean.valueOf(this.f14408VN));
        switch (this.fUO) {
            case 1:
                boolean z3;
                if (!mo9079mn(i2)) {
                    this.fUU = true;
                    if (this.fUV > 0) {
                        C4990ab.m7417i(this.TAG, "%s pause by load data cdnMediaId %s, playStatus %d", aZk(), this.fUL, Integer.valueOf(this.fUP));
                        diO();
                        if (!(this.fUP == 2 || this.fUP == 4)) {
                            this.fUW += this.fVa.fVf;
                            this.fUW = Math.min(this.fUW, 60);
                            diQ();
                            this.fUP = 4;
                        }
                        akX();
                    } else if (this.fUS == -1) {
                        this.fUP = 1;
                    } else {
                        this.fUP = 2;
                    }
                    z3 = false;
                } else if (this.fUX) {
                    MMVideoView mMVideoView;
                    int i3;
                    mo51410ru(i2);
                    C4990ab.m7417i(this.TAG, "resumeByDataGain, playStatus:%s, isPlaying:%s, pauseByLoadData:%s", Integer.valueOf(this.fUP), Boolean.valueOf(this.klq.isPlaying()), Boolean.valueOf(this.fUU));
                    if (this.fUU) {
                        diP();
                        diR();
                        C4990ab.m7417i(this.TAG, "%s resume by data gain cdnMediaId %s", aZk(), this.fUL);
                        if (this.fUS != -1) {
                            mo44252C(this.fUS, this.fUT);
                            this.fUS = -1;
                            z3 = false;
                            mMVideoView = this;
                        } else if (play()) {
                            z3 = false;
                            mMVideoView = this;
                        } else {
                            z3 = true;
                            mMVideoView = this;
                        }
                        mMVideoView.fUU = z3;
                        i3 = 3;
                        mMVideoView = this;
                    } else {
                        if (!(this.fUP == 3 && this.klq.isPlaying())) {
                            C4990ab.m7417i(this.TAG, "%s start to play video playStatus[%d]", aZk(), Integer.valueOf(this.fUP));
                            if (play()) {
                                i3 = 3;
                                mMVideoView = this;
                            } else {
                                i3 = this.fUP;
                                mMVideoView = this;
                            }
                        }
                        z3 = true;
                    }
                    mMVideoView.fUP = i3;
                    z3 = true;
                } else {
                    C4990ab.m7417i(this.TAG, "%s prepare cdnMediaId [%s]", aZk(), this.fUL);
                    if (this.fUP == 5) {
                        this.fUP = 1;
                    }
                    akU();
                    z3 = true;
                }
                mo51410ru(i2);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (mo9055a(i2, pInt, pInt2)) {
                    if (m42215i(pInt.value, pInt2.value, false)) {
                        this.fUV = Math.max(this.fUV, pInt2.value);
                        break;
                    }
                }
                C4990ab.m7411d(this.TAG, "%s can not calc download.", aZk());
                z2 = z3;
                break;
            case 2:
                C4990ab.m7421w(this.TAG, "%s download error.", aZk());
                z2 = false;
                break;
            case 3:
                if (!this.f14408VN) {
                    if (this.fUP == 5) {
                        this.fUP = 1;
                    }
                    akU();
                    break;
                }
                if (this.fUU) {
                    MMVideoView mMVideoView2;
                    if (this.fUS != -1) {
                        mo44252C(this.fUS, true);
                        this.fUS = -1;
                        mMVideoView2 = this;
                    } else if (play()) {
                        mMVideoView2 = this;
                    } else {
                        z = true;
                        mMVideoView2 = this;
                    }
                    mMVideoView2.fUU = z;
                }
                this.fUP = 3;
                mo51410ru(i2);
                break;
            default:
                C4990ab.m7421w(this.TAG, "%s check time default.", aZk());
                z2 = false;
                break;
        }
        AppMethodBeat.m2505o(50645);
        return z2;
    }

    /* renamed from: C */
    public boolean mo44252C(int i, boolean z) {
        boolean z2;
        AppMethodBeat.m2504i(50646);
        switch (this.fUO) {
            case 0:
                if (!bTd()) {
                    if (this.vgw) {
                        this.vgu = z;
                        this.fUT = z;
                        this.vgv = i;
                        this.fUS = i;
                    } else {
                        this.vgu = z;
                        if (i > 0) {
                            this.vgv = i;
                        } else {
                            this.vgv = this.vgr;
                        }
                    }
                    start();
                    break;
                }
                break;
            case 1:
                this.fUP = 2;
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                mo9055a(i, pInt, pInt2);
                if (!m42215i(pInt.value, pInt2.value, true)) {
                    this.fUS = i;
                    this.fUT = z;
                    this.fUU = true;
                    akX();
                    z2 = false;
                    break;
                }
                this.fUS = -1;
                this.fUU = false;
                this.fUV = pInt2.value;
                this.fUP = 3;
                super.mo26912e((double) i, z);
                z2 = true;
                break;
            case 2:
                z2 = true;
                break;
            case 3:
                super.mo26912e((double) i, z);
                z2 = true;
                break;
        }
        z2 = true;
        C4990ab.m7409c(this.TAG, "%s seek video time %d, download status %d playStatus %d", aZk(), Integer.valueOf(i), Integer.valueOf(this.fUO), Integer.valueOf(this.fUP));
        AppMethodBeat.m2505o(50646);
        return z2;
    }

    /* renamed from: cU */
    public void mo9067cU(boolean z) {
        AppMethodBeat.m2504i(50647);
        super.mo9067cU(z);
        bJc();
        AppMethodBeat.m2505o(50647);
    }

    /* renamed from: mn */
    public boolean mo9079mn(int i) {
        Exception e;
        AppMethodBeat.m2504i(50648);
        if (this.fUO == 3) {
            AppMethodBeat.m2505o(50648);
            return true;
        } else if (this.fUV - i > 1 || this.fUV >= this.fUR) {
            boolean isVideoDataAvailable;
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            try {
                if (this.fUQ.mo21144a(i, i + 1, pInt, pInt2)) {
                    isVideoDataAvailable = this.fUK.isVideoDataAvailable(this.fUL, pInt.value, pInt2.value);
                    if (!isVideoDataAvailable) {
                        try {
                            this.fUV = i;
                        } catch (Exception e2) {
                            e = e2;
                            C4990ab.m7413e(this.TAG, "%s check video data error %s ", aZk(), e.toString());
                            AppMethodBeat.m2505o(50648);
                            return isVideoDataAvailable;
                        }
                    }
                }
                isVideoDataAvailable = false;
            } catch (Exception e3) {
                e = e3;
                isVideoDataAvailable = false;
                C4990ab.m7413e(this.TAG, "%s check video data error %s ", aZk(), e.toString());
                AppMethodBeat.m2505o(50648);
                return isVideoDataAvailable;
            }
            AppMethodBeat.m2505o(50648);
            return isVideoDataAvailable;
        } else {
            AppMethodBeat.m2505o(50648);
            return false;
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public boolean mo9055a(int i, PInt pInt, PInt pInt2) {
        AppMethodBeat.m2504i(50649);
        pInt.value = Math.max(i, this.fUV);
        if (this.fUP == 1) {
            pInt.value = i;
            pInt2.value = pInt.value + this.fUW;
        }
        if (this.fUP == 2) {
            pInt.value = i - 8;
            if (pInt.value < 0) {
                pInt.value = 0;
            }
            pInt2.value = (pInt.value + this.fUW) + 8;
        }
        if (this.fUP == 3 || this.fUP == 4) {
            pInt.value = this.fUV;
            pInt2.value = ((this.fUW + i) + 1) + this.fVa.fVg;
        }
        if (pInt2.value >= this.fUR + 1) {
            pInt2.value = this.fUR + 1;
        }
        if (pInt2.value < pInt.value) {
            pInt2.value = pInt.value + this.fVa.fVg;
            AppMethodBeat.m2505o(50649);
            return false;
        }
        C4990ab.m7417i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", aZk(), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i), Integer.valueOf(this.fUP), Integer.valueOf(this.fUV), Integer.valueOf(this.fUW), this.fUL);
        AppMethodBeat.m2505o(50649);
        return true;
    }

    private void akX() {
        AppMethodBeat.m2504i(50650);
        C4990ab.m7417i(this.TAG, "%s pauseByDataBlock ", aZk());
        aNt();
        pause();
        AppMethodBeat.m2505o(50650);
    }

    public boolean pause() {
        AppMethodBeat.m2504i(50651);
        boolean pause = super.pause();
        if (pause) {
            this.fUP = 4;
        }
        AppMethodBeat.m2505o(50651);
        return pause;
    }

    public final boolean play() {
        AppMethodBeat.m2504i(50652);
        boolean play = super.play();
        if (play) {
            this.fUP = 3;
        }
        AppMethodBeat.m2505o(50652);
        return play;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: i */
    private boolean m42215i(int i, int i2, boolean z) {
        boolean isVideoDataAvailable;
        AppMethodBeat.m2504i(50653);
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.fUQ.mo21144a(i, i2, pInt, pInt2)) {
                isVideoDataAvailable = this.fUK.isVideoDataAvailable(this.fUL, pInt.value, pInt2.value);
                if (isVideoDataAvailable) {
                    String str = this.fUL + "_" + pInt.value + "_" + pInt2.value;
                    if (!this.fUY || z) {
                        this.fUY = true;
                        this.fUK.requestVideoData(this.fUL, pInt.value, pInt2.value);
                    } else {
                        C4990ab.m7411d(this.TAG, "%s already request video [%s] isRequestNow[%b] isSeek[%b] ", aZk(), str, Boolean.valueOf(this.fUY), Boolean.valueOf(z));
                    }
                } else {
                    C4990ab.m7411d(this.TAG, "%s already had video data.", aZk());
                }
                AppMethodBeat.m2505o(50653);
                return isVideoDataAvailable;
            }
        } catch (Exception e) {
            C4990ab.m7413e(this.TAG, "%s check video data error[%s] ", aZk(), e.toString());
        }
        isVideoDataAvailable = false;
        if (isVideoDataAvailable) {
        }
        AppMethodBeat.m2505o(50653);
        return isVideoDataAvailable;
    }

    /* renamed from: ml */
    public final void mo21050ml(int i) {
        AppMethodBeat.m2504i(50654);
        C4990ab.m7417i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s", aZk(), Integer.valueOf(i), Integer.valueOf(this.fUR), this.fUL);
        if (this.fUR != 0) {
            C4990ab.m7420w(this.TAG, "moov had callback, do nothing.");
            AppMethodBeat.m2505o(50654);
            return;
        }
        diN();
        try {
            if (this.fUQ == null) {
                C4990ab.m7421w(this.TAG, "%s parser is null, thread is error.", aZk());
                AppMethodBeat.m2505o(50654);
            } else if (this.fUQ.mo21148v(this.fUM, (long) i)) {
                this.fUR = this.fUQ.gkm;
                C4990ab.m7417i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", aZk(), Integer.valueOf(this.fUR), this.fUL);
                if (mo44255mm(0)) {
                    akU();
                }
                if (this.fUS == -1) {
                    this.fUP = 1;
                    AppMethodBeat.m2505o(50654);
                    return;
                }
                this.fUP = 2;
                AppMethodBeat.m2505o(50654);
            } else {
                C4990ab.m7421w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", aZk(), this.fUL);
                this.fUK.requestVideoData(this.fUL, 0, -1);
                AppMethodBeat.m2505o(50654);
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "%s deal moov ready error [%s]", aZk(), this.fUL);
            AppMethodBeat.m2505o(50654);
        }
    }

    public final void onDataAvailable(String str, int i, int i2) {
        AppMethodBeat.m2504i(50655);
        this.fUY = false;
        if (i < 0 || i2 < 0) {
            C4990ab.m7421w(this.TAG, "%s deal data available error offset[%d], length[%d]", aZk(), Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(50655);
        } else if (C5046bo.isEqual(this.fUL, str)) {
            try {
                this.fUV = this.fUQ.mo21147cK(i, i2);
            } catch (Exception e) {
                C4990ab.m7413e(this.TAG, "%s deal data available file pos to video time error[%s] ", aZk(), e.toString());
            }
            C4990ab.m7417i(this.TAG, "%s deal data available. offset[%d] length[%d] cachePlayTime[%d]", aZk(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.fUV));
            mo9068cV(true);
            AppMethodBeat.m2505o(50655);
        } else {
            AppMethodBeat.m2505o(50655);
        }
    }

    /* renamed from: h */
    public void mo9075h(String str, int i, int i2) {
        AppMethodBeat.m2504i(50656);
        if (C5046bo.isEqual(this.fUL, str)) {
            C4990ab.m7411d(this.TAG, "%s download  onProgress [%d, %d]", aZk(), Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(50656);
            return;
        }
        AppMethodBeat.m2505o(50656);
    }

    /* renamed from: ad */
    public void mo9058ad(String str, int i) {
        AppMethodBeat.m2504i(50657);
        if (!C5046bo.isEqual(this.fUL, str) || this.fUO == 3) {
            AppMethodBeat.m2505o(50657);
            return;
        }
        C4990ab.m7417i(this.TAG, "%s download finish [%d]", aZk(), Integer.valueOf(i));
        if (i == 0) {
            this.fUO = 3;
        }
        if (this.fUN != null) {
            boolean z;
            C23323a c23323a = this.fUN;
            String str2 = this.fUM;
            if (this.fUP > 0) {
                z = true;
            } else {
                z = false;
            }
            c23323a.mo39053am(str2, z);
        }
        mo9068cV(true);
        this.fUY = false;
        AppMethodBeat.m2505o(50657);
    }

    /* renamed from: cV */
    public void mo9068cV(boolean z) {
        AppMethodBeat.m2504i(50658);
        C4990ab.m7411d(this.TAG, "%s start timer rightNow[%b]", aZk(), Boolean.valueOf(z));
        this.fVd.stopTimer();
        this.fVd.mo16770ae(10, 500);
        AppMethodBeat.m2505o(50658);
    }

    public void stopTimer() {
        AppMethodBeat.m2504i(50659);
        this.fVd.stopTimer();
        AppMethodBeat.m2505o(50659);
    }

    public int getCacheTimeSec() {
        AppMethodBeat.m2504i(50660);
        int videoDurationSec;
        if (this.fUO == 3) {
            videoDurationSec = getVideoDurationSec();
            AppMethodBeat.m2505o(50660);
            return videoDurationSec;
        }
        videoDurationSec = this.fUV;
        AppMethodBeat.m2505o(50660);
        return videoDurationSec;
    }

    public void akY() {
    }

    public int getReportIdkey() {
        return 100;
    }

    /* Access modifiers changed, original: protected */
    public void setDownloadStatus(int i) {
        this.fUO = i;
    }

    /* Access modifiers changed, original: protected */
    public void setFilepath(String str) {
        this.fUM = str;
    }

    public String getMediaId() {
        return this.fUL;
    }
}
