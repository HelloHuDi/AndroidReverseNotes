package com.tencent.p177mm.plugin.sns.p520ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.modelsns.SnsAdClick;
import com.tencent.p177mm.p230g.p231a.C9362gs;
import com.tencent.p177mm.p230g.p231a.C9365gt;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.MultiTouchImageView;
import com.tencent.p177mm.p612ui.tools.C30759e;
import com.tencent.p177mm.p612ui.tools.C30759e.C24050a;
import com.tencent.p177mm.p612ui.tools.C30759e.C24051b;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery.C30748b;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C21904b;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C39742m;
import com.tencent.p177mm.plugin.sns.lucky.p1657b.C46215a;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C21925g;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C13341f;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C13348i;
import com.tencent.p177mm.plugin.sns.p520ui.C29238s.C29239a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3953i;
import com.tencent.p177mm.plugin.sns.storage.C43570e;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29970o;
import com.tencent.p177mm.pluginsdk.model.C30082t;
import com.tencent.p177mm.pluginsdk.model.C30082t.C30083a;
import com.tencent.p177mm.protocal.protobuf.C7252av;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C44222az;
import java.util.List;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.sns.ui.SnsBrowseUI */
public class SnsBrowseUI extends SnsBaseGalleryUI implements C29239a {
    private int cBt = 0;
    private String czD;
    private int ieu = 0;
    private int iev = 0;
    Bundle jWy;
    private boolean jYD = false;
    C30759e jYE;
    private int kkq = 0;
    private int kkr = 0;
    private int kks = 0;
    private int kkt = 0;
    private C7306ak mHandler = new C7306ak();
    private ImageView mmX;
    private int rpA = 0;
    private int rpB = 0;
    private int rpr = 0;
    private boolean rps = false;
    private boolean rpt = false;
    private boolean rpu = false;
    private C30082t rpv;
    private int rpw;
    private int rpx;
    private int rpy = 0;
    private float rpz = 1.0f;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsBrowseUI$1 */
    class C220101 implements C30083a {
        C220101() {
        }

        public final void csU() {
            AppMethodBeat.m2504i(38749);
            C21904b.m33474kT(44);
            C46215a.m86422a(4, C13373af.cnF().mo62918YT(SnsBrowseUI.this.czD));
            AppMethodBeat.m2505o(38749);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsBrowseUI$3 */
    class C220123 implements OnPreDrawListener {
        C220123() {
        }

        public final boolean onPreDraw() {
            AppMethodBeat.m2504i(38751);
            SnsBrowseUI.this.rpp.getViewTreeObserver().removeOnPreDrawListener(this);
            SnsBrowseUI.this.ieu = SnsBrowseUI.this.rpp.getWidth();
            SnsBrowseUI.this.iev = SnsBrowseUI.this.rpp.getHeight();
            SnsBrowseUI.this.rpw = SnsBrowseUI.this.rpp.getWidth();
            SnsBrowseUI.this.rpx = SnsBrowseUI.this.rpp.getHeight();
            C13373af.cnC();
            String C = C21925g.m33507C(SnsBrowseUI.this.rpp.getCntMedia());
            if (C != null) {
                Options amj = C5056d.amj(C);
                SnsBrowseUI.this.rpx = (int) (((float) amj.outHeight) * (((float) SnsBrowseUI.this.rpw) / ((float) amj.outWidth)));
                if (SnsBrowseUI.this.rpx > SnsBrowseUI.this.rpp.getHeight()) {
                    SnsBrowseUI.this.rpx = SnsBrowseUI.this.rpp.getHeight();
                }
            }
            SnsBrowseUI.this.jYE.mo49168hw(SnsBrowseUI.this.rpw, SnsBrowseUI.this.rpx);
            SnsBrowseUI.this.jYE.mo49166a(SnsBrowseUI.this.rpp, SnsBrowseUI.this.mmX, null);
            SnsBrowseUI.this.csT();
            AppMethodBeat.m2505o(38751);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsBrowseUI$4 */
    class C398014 implements C24051b {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsBrowseUI$4$1 */
        class C398001 implements Runnable {
            C398001() {
            }

            public final void run() {
                AppMethodBeat.m2504i(38752);
                SnsInfoFlip snsInfoFlip = SnsBrowseUI.this.rpp;
                if (snsInfoFlip.rsn != null) {
                    View selectedView = snsInfoFlip.rsn.getSelectedView();
                    if (selectedView instanceof MultiTouchImageView) {
                        ((MultiTouchImageView) selectedView).dzA();
                    }
                }
                AppMethodBeat.m2505o(38752);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsBrowseUI$4$2 */
        class C398022 implements Runnable {
            C398022() {
            }

            public final void run() {
                AppMethodBeat.m2504i(38753);
                SnsBrowseUI.this.finish();
                SnsBrowseUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.m2505o(38753);
            }
        }

        C398014() {
        }

        public final void onAnimationStart() {
            AppMethodBeat.m2504i(38754);
            SnsInfoFlip snsInfoFlip = SnsBrowseUI.this.rpp;
            if (snsInfoFlip.rsA != null) {
                snsInfoFlip.rsA.setVisibility(8);
            }
            SnsBrowseUI.this.mHandler.postDelayed(new C398001(), 20);
            AppMethodBeat.m2505o(38754);
        }

        public final void onAnimationEnd() {
            AppMethodBeat.m2504i(38755);
            SnsBrowseUI.this.mHandler.post(new C398022());
            AppMethodBeat.m2505o(38755);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsBrowseUI$5 */
    class C462395 implements C24050a {
        C462395() {
        }

        /* renamed from: F */
        public final void mo39856F(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(38756);
            if (SnsBrowseUI.this.rpp.getGallery() != null && VERSION.SDK_INT >= 18) {
                SnsBrowseUI.this.rpp.getGallery().setClipBounds(new Rect(i, i2, i3, i4));
            }
            AppMethodBeat.m2505o(38756);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsBrowseUI() {
        AppMethodBeat.m2504i(38759);
        AppMethodBeat.m2505o(38759);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(38760);
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
        AppMethodBeat.m2505o(38760);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(38761);
        if (this.rpp != null) {
            int intExtra = getIntent().getIntExtra("K_ad_scene", -1);
            int intExtra2 = getIntent().getIntExtra("K_ad_source", 0);
            SnsInfoFlip snsInfoFlip = this.rpp;
            String str = this.czD;
            if (snsInfoFlip.qFG) {
                if (intExtra < 0) {
                    C4990ab.m7416i("MicroMsg.SnsInfoFlip", "pass by scene ".concat(String.valueOf(intExtra)));
                } else {
                    C46236n YT = C13373af.cnF().mo62918YT(str);
                    if (YT != null) {
                        if (snsInfoFlip.rsO >= 0) {
                            long longValue = snsInfoFlip.rsq.containsKey(Integer.valueOf(snsInfoFlip.rsO)) ? ((Long) snsInfoFlip.rsq.get(Integer.valueOf(snsInfoFlip.rsO))).longValue() : 0;
                            if (longValue > 0) {
                                long longValue2 = snsInfoFlip.rsr.containsKey(Integer.valueOf(snsInfoFlip.rsO)) ? ((Long) snsInfoFlip.rsr.get(Integer.valueOf(snsInfoFlip.rsO))).longValue() : 0;
                                longValue = C5046bo.m7525az(longValue);
                                longValue2 += longValue;
                                snsInfoFlip.rsr.put(Integer.valueOf(snsInfoFlip.rsO), Long.valueOf(longValue2));
                                C4990ab.m7416i("MicroMsg.SnsInfoFlip", "lastSelectPosition " + snsInfoFlip.rsO + " curtime " + longValue2 + " passtime " + longValue);
                            }
                        }
                        C43570e crd = YT.crd();
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
                            C13348i cnz = C13373af.cnz();
                            Object[] objArr = new Object[1];
                            objArr[0] = C13341f.m21438a(YT.field_snsId, C29036i.m46117jV(YT.field_snsId), YT.crc(), Integer.valueOf(intExtra), Long.valueOf(snsInfoFlip.rsG), Long.valueOf(System.currentTimeMillis()), str, Integer.valueOf(snsInfoFlip.getCount()));
                            cnz.mo25454e(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_WRITE_FAILED, objArr);
                        }
                        if (!crd.cqo().coP()) {
                            C29036i.m46098a(new SnsAdClick(intExtra2, intExtra2 == 0 ? 1 : 2, YT.field_snsId, 6, 0));
                        }
                        C37952b lY = C37952b.m64170lY(729);
                        lY.mo60722tx(C29036i.m46117jV(YT.field_snsId)).mo60722tx(YT.crc()).mo60720mb(intExtra).mo60722tx(snsInfoFlip.rsG).mo60722tx(System.currentTimeMillis()).mo60722tx(str).mo60720mb(snsInfoFlip.getCount());
                        lY.ajK();
                    }
                }
            }
        }
        C37952b u = C37952b.m64173u(getIntent());
        if (u != null) {
            this.rpp.getSelectCount();
            u.mo60720mb(this.rpp.getCount()).mo60720mb(this.rpp.getNumOfFileExist());
            u.update();
            u.ajK();
        }
        this.rpp.ctm();
        this.rpp.onDestroy();
        C13373af.cnC().mo37452ab(this);
        if (this.rps) {
            this.rpp.cto();
        }
        if (this.rpv != null) {
            this.rpv.stop();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(38761);
    }

    public void onPause() {
        AppMethodBeat.m2504i(38762);
        if (this.rpp != null) {
            this.rpp.onPause();
        }
        super.onPause();
        C29970o.m47417JV(2);
        AppMethodBeat.m2505o(38762);
    }

    public void onResume() {
        AppMethodBeat.m2504i(38763);
        super.onResume();
        if (this.rpp != null) {
            this.rpp.btt();
        }
        C29970o.m47417JV(1);
        AppMethodBeat.m2505o(38763);
    }

    public final int getLayoutId() {
        return 2130970748;
    }

    public void onStart() {
        AppMethodBeat.m2504i(38764);
        Bundle bundle = this.jWy;
        if (!this.jYD) {
            this.jYD = true;
            if (VERSION.SDK_INT >= 12) {
                this.kkq = getIntent().getIntExtra("img_gallery_top", 0);
                this.kkr = getIntent().getIntExtra("img_gallery_left", 0);
                this.kks = getIntent().getIntExtra("img_gallery_width", 0);
                this.kkt = getIntent().getIntExtra("img_gallery_height", 0);
                this.jYE.mo49164L(this.kkr, this.kkq, this.kks, this.kkt);
                if (bundle == null) {
                    this.rpp.getViewTreeObserver().addOnPreDrawListener(new C220123());
                }
            }
        }
        super.onStart();
        C4990ab.m7410d("MicroMsg.SnsPopMediasUI", "onStart ");
        AppMethodBeat.m2505o(38764);
    }

    public final void crM() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(38765);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            C4990ab.m7410d("MicroMsg.SnsPopMediasUI", "dispatchKeyEvent");
            setResult(-1, new Intent());
            bcW();
            AppMethodBeat.m2505o(38765);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(38765);
        return dispatchKeyEvent;
    }

    public final void initView() {
        AppMethodBeat.m2504i(38766);
        this.jYE = new C30759e(this.mController.ylL);
        this.jYD = false;
        String bc = C5046bo.m7532bc(getIntent().getStringExtra("sns_gallery_userName"), "");
        this.czD = C5046bo.m7532bc(getIntent().getStringExtra("sns_gallery_localId"), "");
        this.rpr = getIntent().getIntExtra("sns_gallery_position", 0);
        this.cBt = getIntent().getIntExtra("sns_position", 0);
        this.rps = getIntent().getBooleanExtra("k_is_from_sns_main_timeline", false);
        this.rpt = getIntent().getBooleanExtra("k_is_from_sns_msg_ui", false);
        this.rpu = getIntent().getBooleanExtra("sns_soon_enter_photoedit_ui", false);
        C46236n YT = C13373af.cnF().mo62918YT(this.czD);
        this.mmX = (ImageView) findViewById(2131822079);
        this.mmX.setLayerType(2, null);
        this.rpp = new SnsInfoFlip(this);
        this.rpp.setLayerType(2, null);
        this.rpp.setIsFromMainTimeline(this.rps);
        this.rpp.setNeedScanImage(true);
        List Ya = C34955aj.m57392Ya(this.czD);
        this.rpp.setShowPageControl(true);
        this.rpp.setOreitaion(true);
        this.rpp.setTouchFinish(true);
        this.rpp.setInfoType(YT.field_type);
        this.rpp.setIsSoonEnterPhotoEditUI(this.rpu);
        this.rpp.mo8770a(Ya, bc, this.rpr, this.rpk, this);
        SnsInfoFlip snsInfoFlip = this.rpp;
        C44222az dtg = C44222az.dtg();
        dtg.oyB = YT.field_createTime;
        snsInfoFlip.setFromScene(dtg);
        addView(this.rpp);
        if (YT != null && YT.mo74253DI(32)) {
            this.rpp.setIsAd(true);
        }
        m86497D(YT);
        if (C39742m.m67970k(YT)) {
            if (YT.field_type == 21 && !YT.field_userName.equals(C1853r.m3846Yz())) {
                this.rpv = new C30082t(C6457e.eSl + "/Pictures/Screenshots/", new C220101());
                this.rpv.start();
            }
            AppMethodBeat.m2505o(38766);
            return;
        }
        C4990ab.m7412e("MicroMsg.SnsPopMediasUI", "error see photo !! " + YT.field_userName + " " + YT.field_snsId);
        finish();
        AppMethodBeat.m2505o(38766);
    }

    /* renamed from: D */
    private void m86497D(C46236n c46236n) {
        AppMethodBeat.m2504i(38767);
        this.rpq = (Button) findViewById(2131827691);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.rpq.getLayoutParams();
        marginLayoutParams.bottomMargin = C5230ak.m7988fr(this) + getResources().getDimensionPixelSize(C25738R.dimen.a96);
        this.rpq.setLayoutParams(marginLayoutParams);
        final TimeLineObject cqu = c46236n.cqu();
        final C7252av c7252av = cqu != null ? cqu.qNO : null;
        C13633av c13633av = new C13633av();
        C22055af.m33675a(this, c13633av, cqu.qNO);
        if (c13633av.rBh) {
            this.rpq.setVisibility(0);
            this.rpq.setText(c13633av.rBi);
            this.rpq.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(38750);
                    if (c7252av.vCy == null) {
                        AppMethodBeat.m2505o(38750);
                        return;
                    }
                    String df = C24826a.gkF.mo38864df(c7252av.vCy.fKh);
                    int i = 0;
                    if (cqu.xfI.wbJ == 1) {
                        i = 2;
                    } else if (cqu.xfI.wbJ == 3) {
                        i = 5;
                    } else if (cqu.xfI.wbJ == 15) {
                        i = 4;
                    }
                    if (C3953i.m6294a(cqu, SnsBrowseUI.this)) {
                        C24826a.gkF.mo38855a(SnsBrowseUI.this, c7252av.vCy.fKh, df, cqu.jBB, i, 18, 9, c7252av.vCy.vCs, cqu.f15074Id);
                        AppMethodBeat.m2505o(38750);
                        return;
                    }
                    C9365gt c9365gt;
                    switch (c7252av.jCt) {
                        case 4:
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", c7252av.Url);
                            C24826a.gkE.mo38924i(intent, SnsBrowseUI.this);
                            C24826a.gkF.mo38855a(SnsBrowseUI.this, c7252av.vCy.fKh, df, cqu.jBB, i, 18, 1, c7252av.vCy.vCs, cqu.f15074Id);
                            AppMethodBeat.m2505o(38750);
                            return;
                        case 5:
                            if (c7252av.Scene == 1) {
                                c9365gt = new C9365gt();
                                c9365gt.cBv.actionCode = 2;
                                c9365gt.cBv.scene = 3;
                                c9365gt.cBv.appId = c7252av.vCy.fKh;
                                c9365gt.cBv.context = SnsBrowseUI.this;
                                C4879a.xxA.mo10055m(c9365gt);
                                C24826a.gkF.mo38855a(SnsBrowseUI.this, c7252av.vCy.fKh, df, cqu.jBB, i, 18, 6, c7252av.vCy.vCs, cqu.f15074Id);
                                AppMethodBeat.m2505o(38750);
                                return;
                            }
                            break;
                        case 6:
                            int a = C22055af.m33674a(SnsBrowseUI.this, c7252av);
                            if (a != 1) {
                                if (a == 2) {
                                    C9365gt c9365gt2 = new C9365gt();
                                    c9365gt2.cBv.context = SnsBrowseUI.this;
                                    c9365gt2.cBv.actionCode = 1;
                                    c9365gt2.cBv.appId = c7252av.vCy.fKh;
                                    c9365gt2.cBv.messageAction = c7252av.vCy.vCu;
                                    c9365gt2.cBv.messageExt = c7252av.vCy.vCt;
                                    c9365gt2.cBv.scene = 3;
                                    C4879a.xxA.mo10055m(c9365gt2);
                                    C24826a.gkF.mo38855a(SnsBrowseUI.this, c7252av.vCy.fKh, df, cqu.jBB, i, 18, 3, c7252av.vCy.vCs, cqu.f15074Id);
                                    break;
                                }
                            }
                            c9365gt = new C9365gt();
                            c9365gt.cBv.context = SnsBrowseUI.this;
                            c9365gt.cBv.actionCode = 2;
                            c9365gt.cBv.appId = c7252av.vCy.fKh;
                            c9365gt.cBv.messageAction = c7252av.vCy.vCu;
                            c9365gt.cBv.messageExt = c7252av.vCy.vCt;
                            c9365gt.cBv.scene = 3;
                            C4879a.xxA.mo10055m(c9365gt);
                            C24826a.gkF.mo38855a(SnsBrowseUI.this, c7252av.vCy.fKh, df, cqu.jBB, i, 18, 6, c7252av.vCy.vCs, cqu.f15074Id);
                            AppMethodBeat.m2505o(38750);
                            return;
                            break;
                    }
                    AppMethodBeat.m2505o(38750);
                }
            });
            AppMethodBeat.m2505o(38767);
            return;
        }
        this.rpq.setVisibility(8);
        AppMethodBeat.m2505o(38767);
    }

    public final void bcW() {
        AppMethodBeat.m2504i(38768);
        int i = this.kks;
        int i2 = this.kkt;
        int i3 = this.kkr;
        int i4 = this.kkq;
        if (!this.rpt) {
            C9362gs c9362gs = new C9362gs();
            c9362gs.cBr.cBu = this.rpp.getGallery().getSelectedItemPosition();
            c9362gs.cBr.cBt = this.cBt;
            C4879a.xxA.mo10055m(c9362gs);
            i = c9362gs.cBs.ctV;
            i2 = c9362gs.cBs.ctW;
            i3 = c9362gs.cBs.ctT;
            i4 = c9362gs.cBs.ctU;
        }
        this.rpw = this.rpp.getWidth();
        this.rpx = this.rpp.getHeight();
        C13373af.cnC();
        String C = C21925g.m33507C(this.rpp.getCntMedia());
        if (C != null) {
            Options amj = C5056d.amj(C);
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
        this.jYE.mo49168hw(this.rpw, this.rpx);
        this.jYE.mo49164L(i3, i4, i, i2);
        if (((double) this.rpz) != 1.0d) {
            this.jYE.zEZ = 1.0f / this.rpz;
            if (!(this.rpA == 0 && this.rpB == 0)) {
                this.jYE.mo49170hy(((int) (((float) (this.rpp.getWidth() / 2)) * (1.0f - this.rpz))) + this.rpA, (int) (((float) ((this.rpp.getHeight() / 2) + this.rpB)) - (((float) (this.rpx / 2)) * this.rpz)));
            }
        }
        this.jYE.zFd = this.rpy;
        this.jYE.mo49167a(this.rpp, this.mmX, new C398014(), new C462395());
        AppMethodBeat.m2505o(38768);
    }

    public final void csT() {
        AppMethodBeat.m2504i(38769);
        final Gallery gallery = this.rpp.getGallery();
        if (gallery instanceof MMGestureGallery) {
            ((MMGestureGallery) gallery).setGalleryScaleListener(new C30748b() {
                /* renamed from: aa */
                public final void mo26118aa(float f, float f2) {
                    AppMethodBeat.m2504i(38757);
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
                    AppMethodBeat.m2505o(38757);
                }

                /* renamed from: ab */
                public final void mo26119ab(float f, float f2) {
                    AppMethodBeat.m2504i(38758);
                    SnsBrowseUI.this.rpA = (int) f;
                    SnsBrowseUI.this.rpB = (int) f2;
                    AppMethodBeat.m2505o(38758);
                }
            });
        }
        AppMethodBeat.m2505o(38769);
    }

    /* renamed from: dg */
    public final void mo8727dg(String str, int i) {
        AppMethodBeat.m2504i(38770);
        C4990ab.m7417i("MicroMsg.SnsPopMediasUI", "[notifyData] opType:%s reset:%s localId;%s", Integer.valueOf(i), Boolean.TRUE, str);
        if (this.rpp != null) {
            this.rpp.btt();
        }
        AppMethodBeat.m2505o(38770);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(38771);
        C4990ab.m7416i("MicroMsg.SnsPopMediasUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.m2505o(38771);
        } else {
            AppMethodBeat.m2505o(38771);
        }
    }

    public final int getForceOrientation() {
        return 2;
    }

    /* renamed from: dh */
    public final void mo8728dh(String str, int i) {
        this.rpr = i;
    }
}
