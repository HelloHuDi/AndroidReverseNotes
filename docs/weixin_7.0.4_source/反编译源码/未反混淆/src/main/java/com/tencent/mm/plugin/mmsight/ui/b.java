package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.c;
import com.tencent.mm.api.e;
import com.tencent.mm.api.g;
import com.tencent.mm.api.n;
import com.tencent.mm.api.r;
import com.tencent.mm.api.s;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public final class b {
    private static int ehv;
    private static final Object oBK = new Object();
    private MMActivity crP;
    String cvZ;
    private p eir;
    private boolean oBA = false;
    private int oBB = -1;
    public int oBC = -1;
    public int oBD = -1;
    private ap oBE;
    private ViewGroup oBF;
    private s oBG;
    private c oBH;
    private com.tencent.mm.plugin.mmsight.api.a oBI;
    private com.tencent.mm.media.g.c oBJ;
    public a oBL;
    private boolean oBM = false;
    public boolean oBN = false;
    private boolean oBO = false;
    private boolean oBP = false;
    public String oBQ = null;
    public int oBR = -1;
    private com.tencent.mm.plugin.mmsight.a.a.b oBS;
    public boolean oBT = false;
    public boolean oBU = true;
    private RecyclerThumbSeekBar oBz;
    private VideoTransPara ouc;
    private VideoPlayerTextureView oxL;
    private VideoSeekBarEditorView oxM;
    public int scene;
    private String videoPath;

    public interface a {
        void bQf();

        void bQg();

        void onError();
    }

    static /* synthetic */ void p(b bVar) {
        AppMethodBeat.i(55171);
        bVar.bQw();
        AppMethodBeat.o(55171);
    }

    static /* synthetic */ void r(b bVar) {
        AppMethodBeat.i(55172);
        bVar.bQx();
        AppMethodBeat.o(55172);
    }

    static {
        AppMethodBeat.i(55175);
        AppMethodBeat.o(55175);
    }

    public final void a(MMActivity mMActivity, int i, String str, VideoSeekBarEditorView videoSeekBarEditorView, VideoPlayerTextureView videoPlayerTextureView, ViewGroup viewGroup, VideoTransPara videoTransPara, boolean z) {
        AppMethodBeat.i(55162);
        this.ouc = videoTransPara;
        if (this.ouc == null) {
            ab.e("MicroMsg.MMSightVideoEditor", "video trans para is null!!!");
            this.ouc = new VideoTransPara();
            this.ouc.duration = Downloads.MIN_WAIT_FOR_NETWORK;
        } else if (this.ouc.duration <= 0) {
            this.ouc.duration = Downloads.MIN_WAIT_FOR_NETWORK;
        }
        this.scene = i;
        this.videoPath = str;
        this.oxM = videoSeekBarEditorView;
        this.oxL = videoPlayerTextureView;
        this.oBF = viewGroup;
        this.crP = mMActivity;
        this.oBO = z;
        this.oBS = new com.tencent.mm.plugin.mmsight.a.a.b(i);
        this.oBz = videoSeekBarEditorView.oDA;
        this.oBz.setVideoTransPara(this.ouc);
        bQv();
        AppMethodBeat.o(55162);
    }

    private void bQv() {
        AppMethodBeat.i(55163);
        this.oBG = s.ccQ.Ae();
        s sVar = this.oBG;
        com.tencent.mm.api.s.a.a aVar = new com.tencent.mm.api.s.a.a();
        aVar.ccS = false;
        aVar.ccU = true;
        aVar.ccR = s.c.VIDEO;
        aVar.ccV = new Rect(this.oxL.getLeft(), this.oxL.getTop(), this.oxL.getRight(), this.oxL.getBottom());
        sVar.a(aVar.AB());
        this.oBH = this.oBG.aQ(this.oBF.getContext());
        this.oBH.setActionBarCallback(new g() {
            public final void onFinish() {
                AppMethodBeat.i(55134);
                ab.i("MicroMsg.MMSightVideoEditor", "photoEditor onFinish");
                b.this.oBG.a(new n() {
                    public final void onError(Exception exception) {
                        AppMethodBeat.i(55131);
                        ab.e("MicroMsg.MMSightVideoEditor", "photoEditor onError: %s", exception);
                        AppMethodBeat.o(55131);
                    }

                    public final void b(final Bitmap bitmap, boolean z) {
                        AppMethodBeat.i(55132);
                        ab.i("MicroMsg.MMSightVideoEditor", "photoEditor onSuccess: %s isNever：%s", bitmap, Boolean.valueOf(z));
                        if (z) {
                            if (!(bitmap == null || bitmap.isRecycled())) {
                                bitmap.recycle();
                            }
                            if (b.this.oBL == null || b.this.oBN) {
                                if (b.this.oBN) {
                                    al.d(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(55129);
                                            b.this.eir = h.b(b.this.crP, b.this.crP.getString(R.string.d02), false, null);
                                            b.this.oxL.pause();
                                            b.a(b.this, null);
                                            AppMethodBeat.o(55129);
                                        }
                                    });
                                    AppMethodBeat.o(55132);
                                    return;
                                }
                            } else if (b.this.oBD <= 0 || b.this.oBB <= 0 || b.this.oBD > b.this.oBB) {
                                b.this.cvZ = com.tencent.mm.c.g.cz(b.this.videoPath);
                                al.d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(55128);
                                        b.this.oBL.bQf();
                                        AppMethodBeat.o(55128);
                                    }
                                });
                                AppMethodBeat.o(55132);
                                return;
                            } else {
                                al.d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(55127);
                                        b.this.eir = h.b(b.this.crP, b.this.crP.getString(R.string.d02), false, null);
                                        b.this.oxL.pause();
                                        b.a(b.this, null);
                                        AppMethodBeat.o(55127);
                                    }
                                });
                                AppMethodBeat.o(55132);
                                return;
                            }
                        } else if (bitmap != null) {
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(55130);
                                    b.this.eir = h.b(b.this.crP, b.this.crP.getString(R.string.d02), false, null);
                                    b.this.oxL.pause();
                                    b.a(b.this, bitmap);
                                    AppMethodBeat.o(55130);
                                }
                            });
                        }
                        AppMethodBeat.o(55132);
                    }
                });
                AppMethodBeat.o(55134);
            }

            public final void onExit() {
                AppMethodBeat.i(55135);
                ab.i("MicroMsg.MMSightVideoEditor", "photoEditor onExit");
                b.this.release();
                if (b.this.oBL != null) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(55133);
                            b.this.oBL.bQg();
                            AppMethodBeat.o(55133);
                        }
                    });
                }
                AppMethodBeat.o(55135);
            }
        });
        MarginLayoutParams marginLayoutParams = new MarginLayoutParams(-1, -1);
        if (ak.hw(this.crP)) {
            marginLayoutParams.height = d.bPg().y - Math.max(ak.fr(this.crP), ak.hx(this.crP));
        }
        this.oBF.addView(this.oBH, marginLayoutParams);
        this.oBH.setSelectedFeatureListener(new r() {
            public final void a(e eVar) {
                AppMethodBeat.i(55147);
                ab.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedFeature] features:%s", eVar.name());
                if (eVar == e.CROP_VIDEO) {
                    b.i(b.this);
                }
                AppMethodBeat.o(55147);
            }

            public final void a(e eVar, int i) {
                AppMethodBeat.i(55148);
                ab.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedDetailFeature] features:%s index:%s", eVar.name(), Integer.valueOf(i));
                AppMethodBeat.o(55148);
            }

            public final void bd(boolean z) {
                AppMethodBeat.i(55149);
                if (z) {
                    b.this.crP.showVKB();
                    AppMethodBeat.o(55149);
                    return;
                }
                b.this.crP.hideVKB(b.this.oBF);
                AppMethodBeat.o(55149);
            }
        });
        this.oxM.setCancelButtonClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(55152);
                if (!b.this.oBM && b.this.oBB <= b.this.ouc.duration) {
                    b.this.oBC = b.this.oBD = -1;
                    b.this.oxM.bQM();
                    b.this.oBz = b.this.oxM.oDA;
                    b.this.oBA = false;
                }
                if (b.this.oBU) {
                    b.p(b.this);
                    if (!(b.this.oBM || !b.this.oBT || b.this.oBL == null)) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(55151);
                                b.this.oBL.bQg();
                                AppMethodBeat.o(55151);
                            }
                        });
                    }
                } else if (b.this.oBL != null) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(55150);
                            b.this.oBL.bQg();
                            AppMethodBeat.o(55150);
                        }
                    });
                    AppMethodBeat.o(55152);
                    return;
                }
                AppMethodBeat.o(55152);
            }
        });
        this.oxM.setFinishButtonClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(55153);
                if (b.this.oBU) {
                    b.p(b.this);
                    if (b.this.oBC >= 0 && b.this.oBD > 0) {
                        b.this.oBM = true;
                    }
                    AppMethodBeat.o(55153);
                    return;
                }
                b.r(b.this);
                AppMethodBeat.o(55153);
            }
        });
        if (this.oBO) {
            this.oxM.setVisibility(0);
            this.oxM.bringToFront();
            this.oxM.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(55154);
                    b.this.oBH.setFooterVisible(false);
                    b.this.oBH.setActionBarVisible(false);
                    b.this.oBH.setActivated(false);
                    b.i(b.this);
                    AppMethodBeat.o(55154);
                }
            });
        }
        AppMethodBeat.o(55163);
    }

    private void bQw() {
        AppMethodBeat.i(55164);
        this.oxL.animate().scaleX(1.0f).scaleY(1.0f).translationY(0.0f).setDuration(300);
        this.oxM.animate().alpha(0.0f).setDuration(100).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(55137);
                b.this.oxM.setVisibility(8);
                b.this.oxM.setAlpha(1.0f);
                AppMethodBeat.o(55137);
            }
        });
        this.oBH.setFooterVisible(true);
        this.oBH.setAutoShowFooterAndBar(true);
        this.oBH.setActionBarVisible(true);
        this.oBH.animate().scaleX(1.0f).scaleY(1.0f).translationY(0.0f).setDuration(300);
        this.oBP = false;
        AppMethodBeat.o(55164);
    }

    private void bQx() {
        AppMethodBeat.i(55165);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(55146);
                if (b.this.eir != null) {
                    b.this.eir.dismiss();
                }
                if (b.this.oBL != null) {
                    b.this.oBL.bQf();
                }
                AppMethodBeat.o(55146);
            }
        });
        AppMethodBeat.o(55165);
    }

    public final void release() {
        AppMethodBeat.i(55166);
        try {
            if (this.oBE != null) {
                this.oBE.stopTimer();
                this.oBE = null;
            }
            if (this.oBz != null) {
                this.oBz.release();
            }
            if (this.oBG != null) {
                this.oBG.onDestroy();
            }
            if (this.oBF != null) {
                this.oBF.removeView(this.oBH);
            }
            if (this.oxM != null) {
                this.oxM.bQM();
            }
            this.oBA = false;
            j.owk.WY();
            AppMethodBeat.o(55166);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMSightVideoEditor", e, "release error: %s", e.getMessage());
            AppMethodBeat.o(55166);
        }
    }

    public final void n(boolean z, String str) {
        AppMethodBeat.i(55167);
        try {
            this.oBS.eVT = z;
            if (this.oBG == null) {
                ab.e("MicroMsg.MMSightVideoEditor", "[report] null == photoEditor");
                AppMethodBeat.o(55167);
                return;
            }
            com.tencent.mm.api.p Ac = this.oBG.Ac();
            this.oBS.oxz = Ac.As();
            this.oBS.oxA = Ac.Ar();
            this.oBS.oxC = Ac.Au();
            this.oBS.efs = Ac.Av();
            this.oBS.oxD = Ac.Ax();
            this.oBS.textColor = Ac.getTextColor();
            com.tencent.mm.plugin.mmsight.a.a.a(this.oBS, str);
            AppMethodBeat.o(55167);
        } catch (Exception e) {
            AppMethodBeat.o(55167);
        }
    }

    public final boolean wY() {
        AppMethodBeat.i(55168);
        if (!this.oBU) {
            AppMethodBeat.o(55168);
            return false;
        } else if (this.oBP) {
            bQw();
            AppMethodBeat.o(55168);
            return true;
        } else if (this.oBG != null) {
            boolean Ab = this.oBG.Ab();
            AppMethodBeat.o(55168);
            return Ab;
        } else {
            AppMethodBeat.o(55168);
            return false;
        }
    }

    static /* synthetic */ void i(b bVar) {
        AppMethodBeat.i(55170);
        int width = bVar.oxL.getWidth();
        int height = bVar.oxL.getHeight();
        int fromDPToPix = ((bVar.oxM.getHeight() <= 0 ? com.tencent.mm.bz.a.fromDPToPix(bVar.crP, 95) : bVar.oxM.getHeight()) + com.tencent.mm.bz.a.fromDPToPix(bVar.crP, 20)) + com.tencent.mm.bz.a.fromDPToPix(bVar.crP, 12);
        if (ak.hw(bVar.crP)) {
            fromDPToPix += ak.fr(bVar.crP);
        }
        int i = height - fromDPToPix;
        if (bVar.oxL.getBottom() + fromDPToPix < d.eu(bVar.crP).y) {
            i = (int) (((float) (width - (com.tencent.mm.bz.a.fromDPToPix(bVar.crP, 32) * 2))) / (((float) width) / ((float) height)));
        }
        float f = ((float) ((int) ((((float) width) / ((float) height)) * ((float) i)))) / ((float) width);
        float f2 = ((float) i) / ((float) height);
        bVar.oxL.animate().scaleX(f).scaleY(f2).translationY(-(((float) fromDPToPix) / 2.0f)).setDuration(300).setListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(55136);
                if (b.this.oxL != null) {
                    b.this.oxL.requestLayout();
                }
                AppMethodBeat.o(55136);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        bVar.oBH.animate().scaleX(f).scaleY(f2).translationY(-(((float) fromDPToPix) / 2.0f)).setDuration(300);
        bVar.oBH.setAutoShowFooterAndBar(false);
        bVar.oBH.setFooterVisible(false);
        bVar.oBH.setActionBarVisible(false);
        if (!bVar.oBA) {
            bVar.oBz.setOnPreparedListener(new com.tencent.mm.plugin.mmsight.segment.c.a() {
                public final void iY(boolean z) {
                    AppMethodBeat.i(55156);
                    if (z) {
                        ab.e("MicroMsg.MMSightVideoEditor", "Not Supported init SegmentSeekBar failed.");
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(55155);
                                if (b.this.eir != null) {
                                    b.this.eir.dismiss();
                                }
                                if (b.this.oBL != null) {
                                    b.this.oBL.onError();
                                }
                                AppMethodBeat.o(55155);
                            }
                        });
                        AppMethodBeat.o(55156);
                        return;
                    }
                    if (b.this.oBz != null) {
                        b.this.oBB = b.this.oBz.getDurationMs();
                        ab.i("MicroMsg.MMSightVideoEditor", "thumbSeekBar onPrepared success %d", Integer.valueOf(b.this.oBB));
                        try {
                            if (b.this.oxL != null) {
                                b.this.oBC = Math.round(((float) b.this.oBB) * b.this.oBz.bQa());
                                b.this.oBD = Math.round(((float) b.this.oBB) * b.this.oBz.bQb());
                                if (b.this.oBD <= 0) {
                                    if (b.this.oBB <= (b.this.ouc.duration * 1000) + 500) {
                                        b.this.oBD = b.this.oBB;
                                    } else {
                                        b.this.oBD = b.this.ouc.duration * 1000;
                                    }
                                }
                                ab.i("MicroMsg.MMSightVideoEditor", "thumbSeekBar onPrepared, start: %s, end: %s, duration: %s", Integer.valueOf(b.this.oBC), Integer.valueOf(b.this.oBD), Integer.valueOf(b.this.oBB));
                            }
                            b.x(b.this);
                            AppMethodBeat.o(55156);
                            return;
                        } catch (Exception e) {
                        }
                    }
                    AppMethodBeat.o(55156);
                }
            });
            bVar.oBz.setThumbBarSeekListener(new com.tencent.mm.plugin.mmsight.segment.c.b() {
                public final void U(float f, float f2) {
                    AppMethodBeat.i(55157);
                    if (b.this.oxL == null) {
                        AppMethodBeat.o(55157);
                        return;
                    }
                    int d = b.this.oBB;
                    b.this.oBC = Math.round(((float) d) * f);
                    b.this.oBD = Math.round(((float) d) * f2);
                    ab.i("MicroMsg.MMSightVideoEditor", "onRecyclerChanged, start: %s, end: %s %s %s", Integer.valueOf(b.this.oBC), Integer.valueOf(b.this.oBD), Float.valueOf(f), Float.valueOf(f2));
                    b.this.oxL.d((double) b.this.oBC, true);
                    AppMethodBeat.o(55157);
                }

                public final void bQc() {
                    AppMethodBeat.i(55158);
                    if (b.this.oxL == null) {
                        AppMethodBeat.o(55158);
                        return;
                    }
                    b.this.oxL.pause();
                    AppMethodBeat.o(55158);
                }

                public final void V(float f, float f2) {
                    AppMethodBeat.i(55159);
                    if (b.this.oxL == null) {
                        AppMethodBeat.o(55159);
                        return;
                    }
                    int d = b.this.oBB;
                    b.this.oBC = Math.round(((float) d) * f);
                    b.this.oBD = Math.round(((float) d) * f2);
                    if (b.this.oBD <= 0) {
                        b.this.oBD = 1000;
                    }
                    b.this.oxL.d((double) b.this.oBC, true);
                    ab.i("MicroMsg.MMSightVideoEditor", "onUp, start: %s, end: %s %s %s", Integer.valueOf(b.this.oBC), Integer.valueOf(b.this.oBD), Float.valueOf(f), Float.valueOf(f2));
                    AppMethodBeat.o(55159);
                }

                public final void W(float f, float f2) {
                }
            });
            bVar.oBz.RO(bVar.videoPath);
            bVar.oxL.setLoop(true);
            bVar.oxL.setVideoCallback(new com.tencent.mm.pluginsdk.ui.tools.e.a() {
                public final void pL() {
                }

                public final void EA() {
                    AppMethodBeat.i(55160);
                    if (b.this.oBC > 0) {
                        b.this.oxL.d((double) b.this.oBC, true);
                        AppMethodBeat.o(55160);
                        return;
                    }
                    b.this.oxL.d(0.0d, true);
                    AppMethodBeat.o(55160);
                }

                public final int dG(int i, int i2) {
                    return 0;
                }

                public final void dH(int i, int i2) {
                }

                public final void onError(int i, int i2) {
                }
            });
            bVar.oBA = true;
        }
        bVar.oxM.setVisibility(0);
        bVar.oxM.bringToFront();
        bVar.oBP = true;
        AppMethodBeat.o(55170);
    }

    static /* synthetic */ void x(b bVar) {
        AppMethodBeat.i(55173);
        bVar.oBE = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(55161);
                if (b.this.oxL != null && b.this.oxL.isPlaying()) {
                    if (b.this.oBD <= 0 || b.this.oxL.getCurrentPosition() < b.this.oBD) {
                        b.this.oBz.setCurrentCursorPosition(((float) b.this.oxL.getCurrentPosition()) / ((float) b.this.oBB));
                    } else {
                        b.this.oxL.d((double) b.this.oBC, true);
                        b.this.oBz.setCurrentCursorPosition(((float) b.this.oBC) / ((float) b.this.oBB));
                    }
                }
                AppMethodBeat.o(55161);
                return true;
            }
        }, true);
        bVar.oBE.ae(20, 20);
        AppMethodBeat.o(55173);
    }

    static /* synthetic */ Point C(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(55174);
        ab.d("MicroMsg.MMSightVideoEditor", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i3 + "], specHeight = [" + i4 + "]");
        if (i > i3 || i2 > i4) {
            int max = Math.max(i, i2);
            int min = Math.min(i, i2);
            int max2 = Math.max(i3, i4);
            int min2 = Math.min(i3, i4);
            int i5;
            Point point;
            if (max % 16 == 0 && Math.abs(max - max2) < 16 && min % 16 == 0 && Math.abs(min - min2) < 16) {
                ab.i("MicroMsg.MMSightVideoEditor", "calc scale, same len divide by 16, no need scale");
                AppMethodBeat.o(55174);
                return null;
            } else if (max / 2 == max2 && min / 2 == min2) {
                ab.i("MicroMsg.MMSightVideoEditor", "calc scale, double ratio");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                point = new Point(i5, max);
                AppMethodBeat.o(55174);
                return point;
            } else {
                i5 = max / 2;
                max = min / 2;
                if (i5 % 16 != 0 || Math.abs(i5 - max2) >= 16 || max % 16 != 0 || Math.abs(max - min2) >= 16) {
                    point = new Point();
                    if (i < i2) {
                        i5 = Math.min(i3, i4);
                        max = (int) (((double) i2) / ((((double) i) * 1.0d) / ((double) i5)));
                    } else {
                        max = Math.min(i3, i4);
                        i5 = (int) (((double) i) / ((((double) i2) * 1.0d) / ((double) max)));
                    }
                    if (max % 2 != 0) {
                        max++;
                    }
                    if (i5 % 2 != 0) {
                        i5++;
                    }
                    ab.i("MicroMsg.MMSightVideoEditor", "calc scale, outputsize: %s %s", Integer.valueOf(i5), Integer.valueOf(max));
                    point.x = i5;
                    point.y = max;
                    AppMethodBeat.o(55174);
                    return point;
                }
                ab.i("MicroMsg.MMSightVideoEditor", "calc scale, double ratio divide by 16");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                point = new Point(i5, max);
                AppMethodBeat.o(55174);
                return point;
            }
        }
        ab.i("MicroMsg.MMSightVideoEditor", "calc scale, small or equal to spec size");
        AppMethodBeat.o(55174);
        return null;
    }
}
