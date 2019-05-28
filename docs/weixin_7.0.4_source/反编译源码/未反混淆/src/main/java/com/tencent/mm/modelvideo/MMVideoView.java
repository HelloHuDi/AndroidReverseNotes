package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.util.VideoMaterialUtil;

public class MMVideoView extends CommonVideoView implements com.tencent.mm.modelvideo.b.a {
    private String fUJ;
    protected b fUK;
    protected String fUL;
    public String fUM;
    private com.tencent.mm.pluginsdk.ui.h.a fUN;
    protected int fUO = 0;
    protected int fUP = 0;
    protected f fUQ;
    protected int fUR;
    protected int fUS;
    private boolean fUT;
    protected boolean fUU;
    protected int fUV = 0;
    protected int fUW;
    protected boolean fUX = false;
    private boolean fUY = false;
    private boolean fUZ = false;
    protected a fVa;
    private boolean fVb = false;
    public boolean fVc;
    private ap fVd = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(50629);
            if (MMVideoView.this.klq == null) {
                AppMethodBeat.o(50629);
                return false;
            }
            boolean mm;
            boolean isPlaying = MMVideoView.this.isPlaying();
            if (isPlaying) {
                MMVideoView.b(MMVideoView.this);
            }
            try {
                int currentPosition = MMVideoView.this.klq.getCurrentPosition() / 1000;
                MMVideoView.a(MMVideoView.this, currentPosition);
                mm = MMVideoView.this.mm(currentPosition);
            } catch (Exception e) {
                ab.e(MMVideoView.this.TAG, "%s online video timer check error [%s] ", MMVideoView.e(MMVideoView.this), e.toString());
                mm = false;
            }
            ab.d(MMVideoView.this.TAG, "%s check timer[%b] isplay[%b]", MMVideoView.g(MMVideoView.this), Boolean.valueOf(mm), Boolean.valueOf(isPlaying));
            false;
            if (mm && isPlaying) {
                AppMethodBeat.o(50629);
                return true;
            }
            AppMethodBeat.o(50629);
            return false;
        }
    }, true);

    public static class a {
        public int fVf;
        public int fVg;

        protected a() {
        }
    }

    static /* synthetic */ void a(MMVideoView mMVideoView, int i) {
        AppMethodBeat.i(50662);
        mMVideoView.ru(i);
        AppMethodBeat.o(50662);
    }

    static /* synthetic */ void b(MMVideoView mMVideoView) {
        AppMethodBeat.i(50661);
        mMVideoView.bJc();
        AppMethodBeat.o(50661);
    }

    static /* synthetic */ String e(MMVideoView mMVideoView) {
        AppMethodBeat.i(50663);
        String aZk = mMVideoView.aZk();
        AppMethodBeat.o(50663);
        return aZk;
    }

    static /* synthetic */ String g(MMVideoView mMVideoView) {
        AppMethodBeat.i(50664);
        String aZk = mMVideoView.aZk();
        AppMethodBeat.o(50664);
        return aZk;
    }

    public MMVideoView(Context context) {
        super(context);
        AppMethodBeat.i(50630);
        AppMethodBeat.o(50630);
    }

    public MMVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(50631);
        AppMethodBeat.o(50631);
    }

    public MMVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(50632);
        AppMethodBeat.o(50632);
    }

    public void initView() {
        AppMethodBeat.i(50633);
        super.initView();
        this.TAG = "MicroMsg.MMVideoView";
        this.fUQ = new f();
        this.fVa = new a();
        akT();
        reset();
        AppMethodBeat.o(50633);
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

    public void setIOnlineVideoProxy(b bVar) {
        AppMethodBeat.i(50634);
        this.fUK = bVar;
        this.fUK.a(this);
        AppMethodBeat.o(50634);
    }

    public void setIMMDownloadFinish(com.tencent.mm.pluginsdk.ui.h.a aVar) {
        this.fUN = aVar;
    }

    public void c(boolean z, String str, int i) {
        AppMethodBeat.i(50635);
        super.c(z, str, i);
        if (!bo.isNullOrNil(str)) {
            this.fUL = "MMVideo_" + str.hashCode();
            this.fUM = getRootPath() + "MMVideo_" + str.hashCode() + VideoMaterialUtil.MP4_SUFFIX;
            e.tf(e.atb(this.fUM));
            ab.i(this.TAG, "%s set video path [%s %s]", aZk(), this.fUL, this.fUM);
        }
        AppMethodBeat.o(50635);
    }

    public void setRootPath(String str) {
        this.fUJ = str;
    }

    private String getRootPath() {
        AppMethodBeat.i(50636);
        String str;
        if (bo.isNullOrNil(this.fUJ)) {
            str = com.tencent.mm.compatible.util.e.eSn + "video/";
            AppMethodBeat.o(50636);
            return str;
        }
        str = this.fUJ;
        AppMethodBeat.o(50636);
        return str;
    }

    /* Access modifiers changed, original: protected */
    public void akU() {
        AppMethodBeat.i(50637);
        ab.c(this.TAG, "%s prepareVideo", aZk());
        if (this.klq != null) {
            this.fUX = true;
            this.klq.setVideoPath(this.fUM);
        }
        AppMethodBeat.o(50637);
    }

    public void akV() {
        AppMethodBeat.i(50638);
        super.akV();
        if (this.fVb) {
            this.fUZ = true;
            stop();
        }
        AppMethodBeat.o(50638);
    }

    public void akW() {
        AppMethodBeat.i(50639);
        super.akW();
        ab.i(this.TAG, "%s onUIResume stopDownloadByUiPause[%b] currTimeOnUiPause[%d] isPlayOnUiPause[%b]", aZk(), Boolean.valueOf(this.fUZ), Integer.valueOf(this.vgr), Boolean.valueOf(this.vgs));
        if (this.fUZ) {
            C(this.vgr, this.vgs);
            AppMethodBeat.o(50639);
        } else if (this.klq != null && d.iW(24) && (this.klq instanceof VideoPlayerTextureView)) {
            ((VideoPlayerTextureView) this.klq).bPd();
            AppMethodBeat.o(50639);
        } else {
            AppMethodBeat.o(50639);
        }
    }

    public void start() {
        AppMethodBeat.i(50640);
        ab.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d]", aZk(), this.fUL, Integer.valueOf(this.fUR));
        if (this.klq != null) {
            if (bo.isNullOrNil(this.klq.getVideoPath())) {
                aNt();
                this.fVb = true;
                this.fUR = 0;
                this.fUO = 1;
                if (this.fUK != null) {
                    this.fUK.r(this.fUL, this.fUM, this.url);
                    this.fUK.a(this);
                }
                cso();
            } else {
                play();
            }
            gp((long) (getReportIdkey() + 1));
        }
        AppMethodBeat.o(50640);
    }

    public void setLoop(boolean z) {
        this.fVc = z;
    }

    public void EA() {
        AppMethodBeat.i(50641);
        if (this.fVc) {
            C(0, true);
            AppMethodBeat.o(50641);
            return;
        }
        if (this.fUL != null) {
            this.fUK.dV(this.fUL);
        }
        reset();
        if (this.klq != null) {
            this.klq.stop();
        }
        super.EA();
        AppMethodBeat.o(50641);
    }

    public void stop() {
        AppMethodBeat.i(50642);
        if (this.fUK != null) {
            this.fUK.dV(this.fUL);
        }
        reset();
        super.stop();
        AppMethodBeat.o(50642);
    }

    public com.tencent.mm.pluginsdk.ui.tools.e cf(Context context) {
        AppMethodBeat.i(50643);
        this.vgt = 1;
        VideoPlayerTextureView videoPlayerTextureView = new VideoPlayerTextureView(context);
        videoPlayerTextureView.setNeedResetExtractor(true);
        AppMethodBeat.o(50643);
        return videoPlayerTextureView;
    }

    public void setScaleType(h.d dVar) {
        AppMethodBeat.i(50644);
        if (this.klq instanceof VideoPlayerTextureView) {
            ((VideoPlayerTextureView) this.klq).setScaleType(dVar);
            gp((long) (getReportIdkey() + 14));
        }
        AppMethodBeat.o(50644);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean mm(int i) {
        int i2;
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.i(50645);
        if (this.fUS != -1) {
            i2 = this.fUS;
        } else {
            i2 = i;
        }
        ab.i(this.TAG, "%s check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s isPrepareVideo[%b], isPrepared[%b]", aZk(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.fUV), Integer.valueOf(this.fUR), Integer.valueOf(this.fUP), Integer.valueOf(this.fUO), this.fUL, Boolean.valueOf(this.fUX), Boolean.valueOf(this.VN));
        switch (this.fUO) {
            case 1:
                boolean z3;
                if (!mn(i2)) {
                    this.fUU = true;
                    if (this.fUV > 0) {
                        ab.i(this.TAG, "%s pause by load data cdnMediaId %s, playStatus %d", aZk(), this.fUL, Integer.valueOf(this.fUP));
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
                    ru(i2);
                    ab.i(this.TAG, "resumeByDataGain, playStatus:%s, isPlaying:%s, pauseByLoadData:%s", Integer.valueOf(this.fUP), Boolean.valueOf(this.klq.isPlaying()), Boolean.valueOf(this.fUU));
                    if (this.fUU) {
                        diP();
                        diR();
                        ab.i(this.TAG, "%s resume by data gain cdnMediaId %s", aZk(), this.fUL);
                        if (this.fUS != -1) {
                            C(this.fUS, this.fUT);
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
                            ab.i(this.TAG, "%s start to play video playStatus[%d]", aZk(), Integer.valueOf(this.fUP));
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
                    ab.i(this.TAG, "%s prepare cdnMediaId [%s]", aZk(), this.fUL);
                    if (this.fUP == 5) {
                        this.fUP = 1;
                    }
                    akU();
                    z3 = true;
                }
                ru(i2);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (a(i2, pInt, pInt2)) {
                    if (i(pInt.value, pInt2.value, false)) {
                        this.fUV = Math.max(this.fUV, pInt2.value);
                        break;
                    }
                }
                ab.d(this.TAG, "%s can not calc download.", aZk());
                z2 = z3;
                break;
            case 2:
                ab.w(this.TAG, "%s download error.", aZk());
                z2 = false;
                break;
            case 3:
                if (!this.VN) {
                    if (this.fUP == 5) {
                        this.fUP = 1;
                    }
                    akU();
                    break;
                }
                if (this.fUU) {
                    MMVideoView mMVideoView2;
                    if (this.fUS != -1) {
                        C(this.fUS, true);
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
                ru(i2);
                break;
            default:
                ab.w(this.TAG, "%s check time default.", aZk());
                z2 = false;
                break;
        }
        AppMethodBeat.o(50645);
        return z2;
    }

    public boolean C(int i, boolean z) {
        boolean z2;
        AppMethodBeat.i(50646);
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
                a(i, pInt, pInt2);
                if (!i(pInt.value, pInt2.value, true)) {
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
                super.e((double) i, z);
                z2 = true;
                break;
            case 2:
                z2 = true;
                break;
            case 3:
                super.e((double) i, z);
                z2 = true;
                break;
        }
        z2 = true;
        ab.c(this.TAG, "%s seek video time %d, download status %d playStatus %d", aZk(), Integer.valueOf(i), Integer.valueOf(this.fUO), Integer.valueOf(this.fUP));
        AppMethodBeat.o(50646);
        return z2;
    }

    public void cU(boolean z) {
        AppMethodBeat.i(50647);
        super.cU(z);
        bJc();
        AppMethodBeat.o(50647);
    }

    public boolean mn(int i) {
        Exception e;
        AppMethodBeat.i(50648);
        if (this.fUO == 3) {
            AppMethodBeat.o(50648);
            return true;
        } else if (this.fUV - i > 1 || this.fUV >= this.fUR) {
            boolean isVideoDataAvailable;
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            try {
                if (this.fUQ.a(i, i + 1, pInt, pInt2)) {
                    isVideoDataAvailable = this.fUK.isVideoDataAvailable(this.fUL, pInt.value, pInt2.value);
                    if (!isVideoDataAvailable) {
                        try {
                            this.fUV = i;
                        } catch (Exception e2) {
                            e = e2;
                            ab.e(this.TAG, "%s check video data error %s ", aZk(), e.toString());
                            AppMethodBeat.o(50648);
                            return isVideoDataAvailable;
                        }
                    }
                }
                isVideoDataAvailable = false;
            } catch (Exception e3) {
                e = e3;
                isVideoDataAvailable = false;
                ab.e(this.TAG, "%s check video data error %s ", aZk(), e.toString());
                AppMethodBeat.o(50648);
                return isVideoDataAvailable;
            }
            AppMethodBeat.o(50648);
            return isVideoDataAvailable;
        } else {
            AppMethodBeat.o(50648);
            return false;
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean a(int i, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(50649);
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
            AppMethodBeat.o(50649);
            return false;
        }
        ab.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", aZk(), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i), Integer.valueOf(this.fUP), Integer.valueOf(this.fUV), Integer.valueOf(this.fUW), this.fUL);
        AppMethodBeat.o(50649);
        return true;
    }

    private void akX() {
        AppMethodBeat.i(50650);
        ab.i(this.TAG, "%s pauseByDataBlock ", aZk());
        aNt();
        pause();
        AppMethodBeat.o(50650);
    }

    public boolean pause() {
        AppMethodBeat.i(50651);
        boolean pause = super.pause();
        if (pause) {
            this.fUP = 4;
        }
        AppMethodBeat.o(50651);
        return pause;
    }

    public final boolean play() {
        AppMethodBeat.i(50652);
        boolean play = super.play();
        if (play) {
            this.fUP = 3;
        }
        AppMethodBeat.o(50652);
        return play;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean i(int i, int i2, boolean z) {
        boolean isVideoDataAvailable;
        AppMethodBeat.i(50653);
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.fUQ.a(i, i2, pInt, pInt2)) {
                isVideoDataAvailable = this.fUK.isVideoDataAvailable(this.fUL, pInt.value, pInt2.value);
                if (isVideoDataAvailable) {
                    String str = this.fUL + "_" + pInt.value + "_" + pInt2.value;
                    if (!this.fUY || z) {
                        this.fUY = true;
                        this.fUK.requestVideoData(this.fUL, pInt.value, pInt2.value);
                    } else {
                        ab.d(this.TAG, "%s already request video [%s] isRequestNow[%b] isSeek[%b] ", aZk(), str, Boolean.valueOf(this.fUY), Boolean.valueOf(z));
                    }
                } else {
                    ab.d(this.TAG, "%s already had video data.", aZk());
                }
                AppMethodBeat.o(50653);
                return isVideoDataAvailable;
            }
        } catch (Exception e) {
            ab.e(this.TAG, "%s check video data error[%s] ", aZk(), e.toString());
        }
        isVideoDataAvailable = false;
        if (isVideoDataAvailable) {
        }
        AppMethodBeat.o(50653);
        return isVideoDataAvailable;
    }

    public final void ml(int i) {
        AppMethodBeat.i(50654);
        ab.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s", aZk(), Integer.valueOf(i), Integer.valueOf(this.fUR), this.fUL);
        if (this.fUR != 0) {
            ab.w(this.TAG, "moov had callback, do nothing.");
            AppMethodBeat.o(50654);
            return;
        }
        diN();
        try {
            if (this.fUQ == null) {
                ab.w(this.TAG, "%s parser is null, thread is error.", aZk());
                AppMethodBeat.o(50654);
            } else if (this.fUQ.v(this.fUM, (long) i)) {
                this.fUR = this.fUQ.gkm;
                ab.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", aZk(), Integer.valueOf(this.fUR), this.fUL);
                if (mm(0)) {
                    akU();
                }
                if (this.fUS == -1) {
                    this.fUP = 1;
                    AppMethodBeat.o(50654);
                    return;
                }
                this.fUP = 2;
                AppMethodBeat.o(50654);
            } else {
                ab.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", aZk(), this.fUL);
                this.fUK.requestVideoData(this.fUL, 0, -1);
                AppMethodBeat.o(50654);
            }
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "%s deal moov ready error [%s]", aZk(), this.fUL);
            AppMethodBeat.o(50654);
        }
    }

    public final void onDataAvailable(String str, int i, int i2) {
        AppMethodBeat.i(50655);
        this.fUY = false;
        if (i < 0 || i2 < 0) {
            ab.w(this.TAG, "%s deal data available error offset[%d], length[%d]", aZk(), Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(50655);
        } else if (bo.isEqual(this.fUL, str)) {
            try {
                this.fUV = this.fUQ.cK(i, i2);
            } catch (Exception e) {
                ab.e(this.TAG, "%s deal data available file pos to video time error[%s] ", aZk(), e.toString());
            }
            ab.i(this.TAG, "%s deal data available. offset[%d] length[%d] cachePlayTime[%d]", aZk(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.fUV));
            cV(true);
            AppMethodBeat.o(50655);
        } else {
            AppMethodBeat.o(50655);
        }
    }

    public void h(String str, int i, int i2) {
        AppMethodBeat.i(50656);
        if (bo.isEqual(this.fUL, str)) {
            ab.d(this.TAG, "%s download  onProgress [%d, %d]", aZk(), Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(50656);
            return;
        }
        AppMethodBeat.o(50656);
    }

    public void ad(String str, int i) {
        AppMethodBeat.i(50657);
        if (!bo.isEqual(this.fUL, str) || this.fUO == 3) {
            AppMethodBeat.o(50657);
            return;
        }
        ab.i(this.TAG, "%s download finish [%d]", aZk(), Integer.valueOf(i));
        if (i == 0) {
            this.fUO = 3;
        }
        if (this.fUN != null) {
            boolean z;
            com.tencent.mm.pluginsdk.ui.h.a aVar = this.fUN;
            String str2 = this.fUM;
            if (this.fUP > 0) {
                z = true;
            } else {
                z = false;
            }
            aVar.am(str2, z);
        }
        cV(true);
        this.fUY = false;
        AppMethodBeat.o(50657);
    }

    public void cV(boolean z) {
        AppMethodBeat.i(50658);
        ab.d(this.TAG, "%s start timer rightNow[%b]", aZk(), Boolean.valueOf(z));
        this.fVd.stopTimer();
        this.fVd.ae(10, 500);
        AppMethodBeat.o(50658);
    }

    public void stopTimer() {
        AppMethodBeat.i(50659);
        this.fVd.stopTimer();
        AppMethodBeat.o(50659);
    }

    public int getCacheTimeSec() {
        AppMethodBeat.i(50660);
        int videoDurationSec;
        if (this.fUO == 3) {
            videoDurationSec = getVideoDurationSec();
            AppMethodBeat.o(50660);
            return videoDurationSec;
        }
        videoDurationSec = this.fUV;
        AppMethodBeat.o(50660);
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
