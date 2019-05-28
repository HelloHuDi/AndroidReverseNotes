package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.a.b.f;
import com.tencent.mm.plugin.sns.a.b.i;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.e;
import java.util.List;

@a(3)
public class SnsBrowseUI extends SnsBaseGalleryUI implements s.a {
    private int cBt = 0;
    private String czD;
    private int ieu = 0;
    private int iev = 0;
    Bundle jWy;
    private boolean jYD = false;
    e jYE;
    private int kkq = 0;
    private int kkr = 0;
    private int kks = 0;
    private int kkt = 0;
    private ak mHandler = new ak();
    private ImageView mmX;
    private int rpA = 0;
    private int rpB = 0;
    private int rpr = 0;
    private boolean rps = false;
    private boolean rpt = false;
    private boolean rpu = false;
    private t rpv;
    private int rpw;
    private int rpx;
    private int rpy = 0;
    private float rpz = 1.0f;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsBrowseUI() {
        AppMethodBeat.i(38759);
        AppMethodBeat.o(38759);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38760);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(134218752, 134218752);
            getWindow().addFlags(67108864);
        }
        dya();
        initView();
        this.jWy = bundle;
        AppMethodBeat.o(38760);
    }

    public void onDestroy() {
        AppMethodBeat.i(38761);
        if (this.rpp != null) {
            int intExtra = getIntent().getIntExtra("K_ad_scene", -1);
            int intExtra2 = getIntent().getIntExtra("K_ad_source", 0);
            SnsInfoFlip snsInfoFlip = this.rpp;
            String str = this.czD;
            if (snsInfoFlip.qFG) {
                if (intExtra < 0) {
                    ab.i("MicroMsg.SnsInfoFlip", "pass by scene ".concat(String.valueOf(intExtra)));
                } else {
                    n YT = af.cnF().YT(str);
                    if (YT != null) {
                        if (snsInfoFlip.rsO >= 0) {
                            long longValue = snsInfoFlip.rsq.containsKey(Integer.valueOf(snsInfoFlip.rsO)) ? ((Long) snsInfoFlip.rsq.get(Integer.valueOf(snsInfoFlip.rsO))).longValue() : 0;
                            if (longValue > 0) {
                                long longValue2 = snsInfoFlip.rsr.containsKey(Integer.valueOf(snsInfoFlip.rsO)) ? ((Long) snsInfoFlip.rsr.get(Integer.valueOf(snsInfoFlip.rsO))).longValue() : 0;
                                longValue = bo.az(longValue);
                                longValue2 += longValue;
                                snsInfoFlip.rsr.put(Integer.valueOf(snsInfoFlip.rsO), Long.valueOf(longValue2));
                                ab.i("MicroMsg.SnsInfoFlip", "lastSelectPosition " + snsInfoFlip.rsO + " curtime " + longValue2 + " passtime " + longValue);
                            }
                        }
                        com.tencent.mm.plugin.sns.storage.e crd = YT.crd();
                        if (intExtra2 == 2) {
                            YT.cqr();
                        } else {
                            YT.cqq();
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer.append("<desc>");
                        String str2 = "<item><id>%d</id><duration>%d</duration><count>%d</count></item>";
                        String str3 = "%d|%d|%d";
                        for (Integer num : snsInfoFlip.rsp.keySet()) {
                            int intValue = ((Integer) snsInfoFlip.rsp.get(num)).intValue();
                            int longValue3 = snsInfoFlip.rsr.containsKey(num) ? (int) (((Long) snsInfoFlip.rsr.get(num)).longValue() * 1) : 0;
                            stringBuffer.append(String.format(str2, new Object[]{num, Integer.valueOf(longValue3), Integer.valueOf(intValue)}));
                            stringBuffer2.append(String.format(str3, new Object[]{num, Integer.valueOf(longValue3), Integer.valueOf(intValue)}) + "&");
                        }
                        stringBuffer.append("</desc>");
                        str = stringBuffer2.toString();
                        if (str.endsWith("&")) {
                            str = str.substring(0, str.length() - 1);
                        }
                        if (YT == null || !YT.coX()) {
                            i cnz = af.cnz();
                            Object[] objArr = new Object[1];
                            objArr[0] = f.a(YT.field_snsId, com.tencent.mm.plugin.sns.data.i.jV(YT.field_snsId), YT.crc(), Integer.valueOf(intExtra), Long.valueOf(snsInfoFlip.rsG), Long.valueOf(System.currentTimeMillis()), str, Integer.valueOf(snsInfoFlip.getCount()));
                            cnz.e(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_WRITE_FAILED, objArr);
                        }
                        if (!crd.cqo().coP()) {
                            com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(intExtra2, intExtra2 == 0 ? 1 : 2, YT.field_snsId, 6, 0));
                        }
                        b lY = b.lY(729);
                        lY.tx(com.tencent.mm.plugin.sns.data.i.jV(YT.field_snsId)).tx(YT.crc()).mb(intExtra).tx(snsInfoFlip.rsG).tx(System.currentTimeMillis()).tx(str).mb(snsInfoFlip.getCount());
                        lY.ajK();
                    }
                }
            }
        }
        b u = b.u(getIntent());
        if (u != null) {
            this.rpp.getSelectCount();
            u.mb(this.rpp.getCount()).mb(this.rpp.getNumOfFileExist());
            u.update();
            u.ajK();
        }
        this.rpp.ctm();
        this.rpp.onDestroy();
        af.cnC().ab(this);
        if (this.rps) {
            this.rpp.cto();
        }
        if (this.rpv != null) {
            this.rpv.stop();
        }
        super.onDestroy();
        AppMethodBeat.o(38761);
    }

    public void onPause() {
        AppMethodBeat.i(38762);
        if (this.rpp != null) {
            this.rpp.onPause();
        }
        super.onPause();
        o.JV(2);
        AppMethodBeat.o(38762);
    }

    public void onResume() {
        AppMethodBeat.i(38763);
        super.onResume();
        if (this.rpp != null) {
            this.rpp.btt();
        }
        o.JV(1);
        AppMethodBeat.o(38763);
    }

    public final int getLayoutId() {
        return R.layout.auv;
    }

    public void onStart() {
        AppMethodBeat.i(38764);
        Bundle bundle = this.jWy;
        if (!this.jYD) {
            this.jYD = true;
            if (VERSION.SDK_INT >= 12) {
                this.kkq = getIntent().getIntExtra("img_gallery_top", 0);
                this.kkr = getIntent().getIntExtra("img_gallery_left", 0);
                this.kks = getIntent().getIntExtra("img_gallery_width", 0);
                this.kkt = getIntent().getIntExtra("img_gallery_height", 0);
                this.jYE.L(this.kkr, this.kkq, this.kks, this.kkt);
                if (bundle == null) {
                    this.rpp.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                        public final boolean onPreDraw() {
                            AppMethodBeat.i(38751);
                            SnsBrowseUI.this.rpp.getViewTreeObserver().removeOnPreDrawListener(this);
                            SnsBrowseUI.this.ieu = SnsBrowseUI.this.rpp.getWidth();
                            SnsBrowseUI.this.iev = SnsBrowseUI.this.rpp.getHeight();
                            SnsBrowseUI.this.rpw = SnsBrowseUI.this.rpp.getWidth();
                            SnsBrowseUI.this.rpx = SnsBrowseUI.this.rpp.getHeight();
                            af.cnC();
                            String C = g.C(SnsBrowseUI.this.rpp.getCntMedia());
                            if (C != null) {
                                Options amj = d.amj(C);
                                SnsBrowseUI.this.rpx = (int) (((float) amj.outHeight) * (((float) SnsBrowseUI.this.rpw) / ((float) amj.outWidth)));
                                if (SnsBrowseUI.this.rpx > SnsBrowseUI.this.rpp.getHeight()) {
                                    SnsBrowseUI.this.rpx = SnsBrowseUI.this.rpp.getHeight();
                                }
                            }
                            SnsBrowseUI.this.jYE.hw(SnsBrowseUI.this.rpw, SnsBrowseUI.this.rpx);
                            SnsBrowseUI.this.jYE.a(SnsBrowseUI.this.rpp, SnsBrowseUI.this.mmX, null);
                            SnsBrowseUI.this.csT();
                            AppMethodBeat.o(38751);
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
        ab.d("MicroMsg.SnsPopMediasUI", "onStart ");
        AppMethodBeat.o(38764);
    }

    public final void crM() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(38765);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            ab.d("MicroMsg.SnsPopMediasUI", "dispatchKeyEvent");
            setResult(-1, new Intent());
            bcW();
            AppMethodBeat.o(38765);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(38765);
        return dispatchKeyEvent;
    }

    public final void initView() {
        AppMethodBeat.i(38766);
        this.jYE = new e(this.mController.ylL);
        this.jYD = false;
        String bc = bo.bc(getIntent().getStringExtra("sns_gallery_userName"), "");
        this.czD = bo.bc(getIntent().getStringExtra("sns_gallery_localId"), "");
        this.rpr = getIntent().getIntExtra("sns_gallery_position", 0);
        this.cBt = getIntent().getIntExtra("sns_position", 0);
        this.rps = getIntent().getBooleanExtra("k_is_from_sns_main_timeline", false);
        this.rpt = getIntent().getBooleanExtra("k_is_from_sns_msg_ui", false);
        this.rpu = getIntent().getBooleanExtra("sns_soon_enter_photoedit_ui", false);
        n YT = af.cnF().YT(this.czD);
        this.mmX = (ImageView) findViewById(R.id.adg);
        this.mmX.setLayerType(2, null);
        this.rpp = new SnsInfoFlip(this);
        this.rpp.setLayerType(2, null);
        this.rpp.setIsFromMainTimeline(this.rps);
        this.rpp.setNeedScanImage(true);
        List Ya = aj.Ya(this.czD);
        this.rpp.setShowPageControl(true);
        this.rpp.setOreitaion(true);
        this.rpp.setTouchFinish(true);
        this.rpp.setInfoType(YT.field_type);
        this.rpp.setIsSoonEnterPhotoEditUI(this.rpu);
        this.rpp.a(Ya, bc, this.rpr, this.rpk, this);
        SnsInfoFlip snsInfoFlip = this.rpp;
        az dtg = az.dtg();
        dtg.oyB = YT.field_createTime;
        snsInfoFlip.setFromScene(dtg);
        addView(this.rpp);
        if (YT != null && YT.DI(32)) {
            this.rpp.setIsAd(true);
        }
        D(YT);
        if (m.k(YT)) {
            if (YT.field_type == 21 && !YT.field_userName.equals(r.Yz())) {
                this.rpv = new t(com.tencent.mm.compatible.util.e.eSl + "/Pictures/Screenshots/", new t.a() {
                    public final void csU() {
                        AppMethodBeat.i(38749);
                        com.tencent.mm.plugin.sns.lucky.a.b.kT(44);
                        com.tencent.mm.plugin.sns.lucky.b.a.a(4, af.cnF().YT(SnsBrowseUI.this.czD));
                        AppMethodBeat.o(38749);
                    }
                });
                this.rpv.start();
            }
            AppMethodBeat.o(38766);
            return;
        }
        ab.e("MicroMsg.SnsPopMediasUI", "error see photo !! " + YT.field_userName + " " + YT.field_snsId);
        finish();
        AppMethodBeat.o(38766);
    }

    private void D(n nVar) {
        AppMethodBeat.i(38767);
        this.rpq = (Button) findViewById(R.id.eh7);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.rpq.getLayoutParams();
        marginLayoutParams.bottomMargin = com.tencent.mm.ui.ak.fr(this) + getResources().getDimensionPixelSize(R.dimen.a96);
        this.rpq.setLayoutParams(marginLayoutParams);
        final TimeLineObject cqu = nVar.cqu();
        final av avVar = cqu != null ? cqu.qNO : null;
        av avVar2 = new av();
        af.a(this, avVar2, cqu.qNO);
        if (avVar2.rBh) {
            this.rpq.setVisibility(0);
            this.rpq.setText(avVar2.rBi);
            this.rpq.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(38750);
                    if (avVar.vCy == null) {
                        AppMethodBeat.o(38750);
                        return;
                    }
                    String df = com.tencent.mm.plugin.sns.c.a.gkF.df(avVar.vCy.fKh);
                    int i = 0;
                    if (cqu.xfI.wbJ == 1) {
                        i = 2;
                    } else if (cqu.xfI.wbJ == 3) {
                        i = 5;
                    } else if (cqu.xfI.wbJ == 15) {
                        i = 4;
                    }
                    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(cqu, SnsBrowseUI.this)) {
                        com.tencent.mm.plugin.sns.c.a.gkF.a(SnsBrowseUI.this, avVar.vCy.fKh, df, cqu.jBB, i, 18, 9, avVar.vCy.vCs, cqu.Id);
                        AppMethodBeat.o(38750);
                        return;
                    }
                    gt gtVar;
                    switch (avVar.jCt) {
                        case 4:
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", avVar.Url);
                            com.tencent.mm.plugin.sns.c.a.gkE.i(intent, SnsBrowseUI.this);
                            com.tencent.mm.plugin.sns.c.a.gkF.a(SnsBrowseUI.this, avVar.vCy.fKh, df, cqu.jBB, i, 18, 1, avVar.vCy.vCs, cqu.Id);
                            AppMethodBeat.o(38750);
                            return;
                        case 5:
                            if (avVar.Scene == 1) {
                                gtVar = new gt();
                                gtVar.cBv.actionCode = 2;
                                gtVar.cBv.scene = 3;
                                gtVar.cBv.appId = avVar.vCy.fKh;
                                gtVar.cBv.context = SnsBrowseUI.this;
                                com.tencent.mm.sdk.b.a.xxA.m(gtVar);
                                com.tencent.mm.plugin.sns.c.a.gkF.a(SnsBrowseUI.this, avVar.vCy.fKh, df, cqu.jBB, i, 18, 6, avVar.vCy.vCs, cqu.Id);
                                AppMethodBeat.o(38750);
                                return;
                            }
                            break;
                        case 6:
                            int a = af.a(SnsBrowseUI.this, avVar);
                            if (a != 1) {
                                if (a == 2) {
                                    gt gtVar2 = new gt();
                                    gtVar2.cBv.context = SnsBrowseUI.this;
                                    gtVar2.cBv.actionCode = 1;
                                    gtVar2.cBv.appId = avVar.vCy.fKh;
                                    gtVar2.cBv.messageAction = avVar.vCy.vCu;
                                    gtVar2.cBv.messageExt = avVar.vCy.vCt;
                                    gtVar2.cBv.scene = 3;
                                    com.tencent.mm.sdk.b.a.xxA.m(gtVar2);
                                    com.tencent.mm.plugin.sns.c.a.gkF.a(SnsBrowseUI.this, avVar.vCy.fKh, df, cqu.jBB, i, 18, 3, avVar.vCy.vCs, cqu.Id);
                                    break;
                                }
                            }
                            gtVar = new gt();
                            gtVar.cBv.context = SnsBrowseUI.this;
                            gtVar.cBv.actionCode = 2;
                            gtVar.cBv.appId = avVar.vCy.fKh;
                            gtVar.cBv.messageAction = avVar.vCy.vCu;
                            gtVar.cBv.messageExt = avVar.vCy.vCt;
                            gtVar.cBv.scene = 3;
                            com.tencent.mm.sdk.b.a.xxA.m(gtVar);
                            com.tencent.mm.plugin.sns.c.a.gkF.a(SnsBrowseUI.this, avVar.vCy.fKh, df, cqu.jBB, i, 18, 6, avVar.vCy.vCs, cqu.Id);
                            AppMethodBeat.o(38750);
                            return;
                            break;
                    }
                    AppMethodBeat.o(38750);
                }
            });
            AppMethodBeat.o(38767);
            return;
        }
        this.rpq.setVisibility(8);
        AppMethodBeat.o(38767);
    }

    public final void bcW() {
        AppMethodBeat.i(38768);
        int i = this.kks;
        int i2 = this.kkt;
        int i3 = this.kkr;
        int i4 = this.kkq;
        if (!this.rpt) {
            gs gsVar = new gs();
            gsVar.cBr.cBu = this.rpp.getGallery().getSelectedItemPosition();
            gsVar.cBr.cBt = this.cBt;
            com.tencent.mm.sdk.b.a.xxA.m(gsVar);
            i = gsVar.cBs.ctV;
            i2 = gsVar.cBs.ctW;
            i3 = gsVar.cBs.ctT;
            i4 = gsVar.cBs.ctU;
        }
        this.rpw = this.rpp.getWidth();
        this.rpx = this.rpp.getHeight();
        af.cnC();
        String C = g.C(this.rpp.getCntMedia());
        if (C != null) {
            Options amj = d.amj(C);
            this.rpx = (int) (((float) amj.outHeight) * (((float) this.rpw) / ((float) amj.outWidth)));
            if (this.rpx > this.rpp.getHeight()) {
                if (((double) this.rpx) < ((double) this.rpp.getHeight()) * 2.5d) {
                    this.rpy = this.rpx - this.rpp.getHeight();
                    if (this.rpp.getCount() == 1) {
                        i2 = (i2 * this.rpp.getHeight()) / this.rpx;
                        this.rpy = 0;
                    }
                }
                this.rpx = this.rpp.getHeight();
            }
        }
        this.jYE.hw(this.rpw, this.rpx);
        this.jYE.L(i3, i4, i, i2);
        if (((double) this.rpz) != 1.0d) {
            this.jYE.zEZ = 1.0f / this.rpz;
            if (!(this.rpA == 0 && this.rpB == 0)) {
                this.jYE.hy(((int) (((float) (this.rpp.getWidth() / 2)) * (1.0f - this.rpz))) + this.rpA, (int) (((float) ((this.rpp.getHeight() / 2) + this.rpB)) - (((float) (this.rpx / 2)) * this.rpz)));
            }
        }
        this.jYE.zFd = this.rpy;
        this.jYE.a(this.rpp, this.mmX, new e.b() {
            public final void onAnimationStart() {
                AppMethodBeat.i(38754);
                SnsInfoFlip snsInfoFlip = SnsBrowseUI.this.rpp;
                if (snsInfoFlip.rsA != null) {
                    snsInfoFlip.rsA.setVisibility(8);
                }
                SnsBrowseUI.this.mHandler.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(38752);
                        SnsInfoFlip snsInfoFlip = SnsBrowseUI.this.rpp;
                        if (snsInfoFlip.rsn != null) {
                            View selectedView = snsInfoFlip.rsn.getSelectedView();
                            if (selectedView instanceof MultiTouchImageView) {
                                ((MultiTouchImageView) selectedView).dzA();
                            }
                        }
                        AppMethodBeat.o(38752);
                    }
                }, 20);
                AppMethodBeat.o(38754);
            }

            public final void onAnimationEnd() {
                AppMethodBeat.i(38755);
                SnsBrowseUI.this.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(38753);
                        SnsBrowseUI.this.finish();
                        SnsBrowseUI.this.overridePendingTransition(0, 0);
                        AppMethodBeat.o(38753);
                    }
                });
                AppMethodBeat.o(38755);
            }
        }, new e.a() {
            public final void F(int i, int i2, int i3, int i4) {
                AppMethodBeat.i(38756);
                if (SnsBrowseUI.this.rpp.getGallery() != null && VERSION.SDK_INT >= 18) {
                    SnsBrowseUI.this.rpp.getGallery().setClipBounds(new Rect(i, i2, i3, i4));
                }
                AppMethodBeat.o(38756);
            }
        });
        AppMethodBeat.o(38768);
    }

    public final void csT() {
        AppMethodBeat.i(38769);
        final Gallery gallery = this.rpp.getGallery();
        if (gallery instanceof MMGestureGallery) {
            ((MMGestureGallery) gallery).setGalleryScaleListener(new MMGestureGallery.b() {
                public final void aa(float f, float f2) {
                    AppMethodBeat.i(38757);
                    if ((SnsBrowseUI.this.iev == 0 || SnsBrowseUI.this.ieu == 0) && SnsBrowseUI.this.rpp != null) {
                        SnsBrowseUI.this.iev = SnsBrowseUI.this.rpp.getHeight();
                        SnsBrowseUI.this.ieu = SnsBrowseUI.this.rpp.getWidth();
                    }
                    if (SnsBrowseUI.this.iev != 0) {
                        float f3 = 1.0f - (f2 / ((float) SnsBrowseUI.this.iev));
                        if (f3 > 1.0f) {
                            f3 = 1.0f;
                        }
                        SnsBrowseUI.this.rpz = f3;
                        View selectedView = ((MMGestureGallery) gallery).getSelectedView();
                        if (selectedView instanceof MultiTouchImageView) {
                            selectedView.setPivotX((float) (SnsBrowseUI.this.ieu / 2));
                            selectedView.setPivotY((float) (SnsBrowseUI.this.iev / 2));
                            selectedView.setScaleX(f3);
                            selectedView.setScaleY(f3);
                            selectedView.setTranslationX(f);
                            selectedView.setTranslationY(f2);
                            SnsBrowseUI.this.mmX.setAlpha(f3);
                        }
                    }
                    AppMethodBeat.o(38757);
                }

                public final void ab(float f, float f2) {
                    AppMethodBeat.i(38758);
                    SnsBrowseUI.this.rpA = (int) f;
                    SnsBrowseUI.this.rpB = (int) f2;
                    AppMethodBeat.o(38758);
                }
            });
        }
        AppMethodBeat.o(38769);
    }

    public final void dg(String str, int i) {
        AppMethodBeat.i(38770);
        ab.i("MicroMsg.SnsPopMediasUI", "[notifyData] opType:%s reset:%s localId;%s", Integer.valueOf(i), Boolean.TRUE, str);
        if (this.rpp != null) {
            this.rpp.btt();
        }
        AppMethodBeat.o(38770);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(38771);
        ab.i("MicroMsg.SnsPopMediasUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.o(38771);
        } else {
            AppMethodBeat.o(38771);
        }
    }

    public final int getForceOrientation() {
        return 2;
    }

    public final void dh(String str, int i) {
        this.rpr = i;
    }
}
