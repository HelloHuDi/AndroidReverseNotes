package com.tencent.p177mm.plugin.webview.p580ui.tools.bag;

import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p1188f.C37657b;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.C46700c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C22932a.C22933b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C22932a.C22934a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C22932a.C22934a.C145871;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.WebViewBag.C22931a;
import com.tencent.p177mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.p177mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.C30091a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.l */
public enum C29879l {
    ;
    
    private long qBy;
    private WebViewBag uzr;
    private C22932a uzs;
    private boolean uzt;
    public C29884a uzu;
    public LinkedList<C14591b> uzv;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.l$b */
    public interface C14591b {
        void cXm();
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.l$1 */
    class C229411 implements C30091a {
        final /* synthetic */ int fwD;
        final /* synthetic */ String uzx;
        final /* synthetic */ boolean uzy;
        final /* synthetic */ Bundle val$extras;
        final /* synthetic */ String val$url;

        C229411(String str, int i, String str2, Bundle bundle, boolean z) {
            this.val$url = str;
            this.fwD = i;
            this.uzx = str2;
            this.val$extras = bundle;
            this.uzy = z;
        }

        /* renamed from: a */
        public final void mo38035a(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            AppMethodBeat.m2504i(8208);
            requestFloatWindowPermissionDialog.finish();
            C29879l.m47359a(C29879l.this, this.val$url, this.fwD, this.uzx, this.val$extras, this.uzy);
            C29879l.m47356a(C29879l.this);
            AppMethodBeat.m2505o(8208);
        }

        /* renamed from: b */
        public final void mo38036b(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            AppMethodBeat.m2504i(8209);
            requestFloatWindowPermissionDialog.finish();
            AppMethodBeat.m2505o(8209);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.l$2 */
    class C229422 implements C22933b {
        C229422() {
        }

        public final void daY() {
            AppMethodBeat.m2504i(8210);
            C29879l.m47357a(C29879l.this, 17);
            Point point = null;
            if (C29879l.this.uzr != null) {
                point = C29879l.this.uzr.getLastTouchDownViewPos();
            }
            C29879l.this.dbg();
            if (point != null) {
                C29879l.this.uzu.uzB = point.x;
                C29879l.this.uzu.uzA = point.y;
                C29879l.this.uzu.save();
            }
            AppMethodBeat.m2505o(8210);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.l$3 */
    class C298803 implements C22931a {
        C298803() {
        }

        /* renamed from: gz */
        public final void mo38511gz(int i, int i2) {
            AppMethodBeat.m2504i(8211);
            C29879l.m47357a(C29879l.this, 19);
            C29879l.this.uzu.uzB = i;
            C29879l.this.uzu.uzA = i2;
            C29879l.this.uzu.save();
            AppMethodBeat.m2505o(8211);
        }

        public final void onTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(8212);
            if (C29879l.this.uzs != null) {
                C22932a d = C29879l.this.uzs;
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                C22934a c22934a;
                TranslateAnimation translateAnimation;
                switch (motionEvent.getAction()) {
                    case 0:
                        d.uyc.x = rawX;
                        d.uyc.y = rawY;
                        break;
                    case 1:
                        if (!d.uyd) {
                            if (d.mIsShowing) {
                                d.mIsShowing = false;
                                c22934a = d.uxZ;
                                translateAnimation = new TranslateAnimation(0.0f, (float) C29876b.uyp, 0.0f, (float) C29876b.uyp);
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                                AnimationSet animationSet = new AnimationSet(true);
                                animationSet.addAnimation(alphaAnimation);
                                animationSet.addAnimation(translateAnimation);
                                animationSet.setDuration(300);
                                animationSet.setAnimationListener(new C145871());
                                c22934a.lBT.startAnimation(animationSet);
                                c22934a.f4404WL.startAnimation(animationSet);
                                break;
                            }
                        }
                        d.uya.daY();
                        break;
                        break;
                    case 2:
                        boolean z;
                        if (d.uyb) {
                            z = true;
                        } else {
                            if ((((rawX - d.uyc.x) * (rawX - d.uyc.x)) + ((rawY - d.uyc.y) * (rawY - d.uyc.y))) - 900.0f > 0.0f) {
                                z = true;
                            } else {
                                z = false;
                            }
                            d.uyb = z;
                            z = d.uyb;
                        }
                        if (z) {
                            if (!d.mIsShowing) {
                                C29876b.m47353fs(C4996ah.getContext());
                                d.mIsShowing = true;
                                d.mScreenWidth = C1338a.m2868gd(C4996ah.getContext());
                                d.mScreenHeight = C1338a.m2869ge(C4996ah.getContext());
                                d.uye = d.mScreenWidth > d.mScreenHeight;
                                C4990ab.m7417i("MicroMsg.BagCancelController", "updateOrientation mIsLandScape:%b", Boolean.valueOf(d.uye));
                                c22934a = d.uxZ;
                                c22934a.setVisibility(0);
                                translateAnimation = new TranslateAnimation((float) C29876b.uyp, 0.0f, (float) C29876b.uyp, 0.0f);
                                translateAnimation.setFillAfter(true);
                                translateAnimation.setDuration(200);
                                c22934a.lBT.startAnimation(translateAnimation);
                                c22934a.f4404WL.startAnimation(translateAnimation);
                            }
                            boolean z2 = d.uyd;
                            if (d.uye) {
                                rawX = (((float) d.mScreenWidth) - motionEvent.getRawX()) - ((float) C29876b.uyg);
                                rawY = ((float) d.mScreenHeight) - motionEvent.getRawY();
                            } else {
                                rawX = ((float) d.mScreenWidth) - motionEvent.getRawX();
                                rawY = (((float) d.mScreenHeight) - motionEvent.getRawY()) - ((float) C29876b.uyg);
                            }
                            if ((rawX * rawX) + (rawY * rawY) < ((float) C22932a.uxY)) {
                                d.uyd = true;
                            } else {
                                d.uyd = false;
                            }
                            if (d.uyd != z2) {
                                c22934a = d.uxZ;
                                if (d.uyd) {
                                    c22934a.mo38525af(1.0f, C29876b.uyq);
                                    if (c22934a.iVt != null) {
                                        c22934a.iVt.vibrate(10);
                                    }
                                    AppMethodBeat.m2505o(8212);
                                    return;
                                }
                                c22934a.mo38525af(C29876b.uyq, 1.0f);
                                AppMethodBeat.m2505o(8212);
                                return;
                            }
                        }
                        break;
                }
                d.uyb = false;
                d.uyd = false;
            }
            AppMethodBeat.m2505o(8212);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.l$4 */
    class C298814 implements OnClickListener {
        C298814() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(8213);
            C29879l.m47358a(C29879l.this, C29879l.this.uzu.url, C29879l.this.uzu.scene);
            AppMethodBeat.m2505o(8213);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.l$5 */
    class C298825 extends C46700c {
        C298825() {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(8214);
            C29879l.m47363e(C29879l.this);
            AppMethodBeat.m2505o(8214);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.l$6 */
    class C298836 implements Runnable {
        C298836() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8215);
            if (C29879l.this.uzr != null) {
                C29879l.m47363e(C29879l.this);
            }
            AppMethodBeat.m2505o(8215);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.l$a */
    public static final class C29884a {
        String cIY;
        long fAx;
        /* renamed from: id */
        String f13722id;
        int scene;
        public String url;
        int uzA;
        int uzB;
        JSONObject uzC;

        public C29884a() {
            AppMethodBeat.m2504i(8216);
            C1720g.m3537RQ();
            String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WEBVIEW_BAG_INFO_STRING_SYNC, null);
            C4990ab.m7417i("MicroMsg.WebViewBagMgr", "BagInfo#load %s", str);
            if (C5046bo.isNullOrNil(str)) {
                this.f13722id = null;
                this.url = null;
                this.cIY = null;
                this.uzB = (C1338a.m2868gd(C4996ah.getContext()) - C29876b.uyj) - C29876b.uyk;
                this.uzA = C29876b.uyi + C4996ah.getContext().getResources().getDimensionPixelSize(C25738R.dimen.ab0);
                this.uzC = new JSONObject();
                C4990ab.m7417i("MicroMsg.WebViewBagMgr", "BAG_INIT_X:%d BAG_INIT_Y:%d", Integer.valueOf(this.uzB), Integer.valueOf(this.uzA));
                AppMethodBeat.m2505o(8216);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.url = jSONObject.getString("url");
                this.f13722id = jSONObject.optString("id", C4995ag.m7428ck(String.format("bagId#%d#%s", new Object[]{Long.valueOf(System.currentTimeMillis()), this.url})));
                this.cIY = jSONObject.getString("icon");
                this.uzA = jSONObject.getInt("pos_y");
                this.uzB = jSONObject.getInt("pos_x");
                this.fAx = jSONObject.getLong("last_active_time");
                this.uzC = jSONObject.getJSONObject("extras");
                this.scene = jSONObject.optInt("scene", 0);
                AppMethodBeat.m2505o(8216);
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.WebViewBagMgr", "BagInfo#load exp:%s", e);
                AppMethodBeat.m2505o(8216);
            }
        }

        /* Access modifiers changed, original: final */
        public final void save() {
            AppMethodBeat.m2504i(8217);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", C5046bo.nullAsNil(this.f13722id));
                jSONObject.put("url", C5046bo.nullAsNil(this.url));
                jSONObject.put("icon", C5046bo.nullAsNil(this.cIY));
                jSONObject.put("pos_y", this.uzA);
                jSONObject.put("pos_x", this.uzB);
                jSONObject.put("last_active_time", this.fAx);
                jSONObject.put("extras", this.uzC);
                jSONObject.put("scene", this.scene);
                Object jSONObject2 = jSONObject.toString();
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WEBVIEW_BAG_INFO_STRING_SYNC, jSONObject2);
                AppMethodBeat.m2505o(8217);
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.WebViewBagMgr", "BagInfo#save exp:%s", e);
                AppMethodBeat.m2505o(8217);
            }
        }
    }

    private C29879l(String str) {
        AppMethodBeat.m2504i(8220);
        this.qBy = -1;
        this.uzu = new C29884a();
        this.uzv = new LinkedList();
        AppMethodBeat.m2505o(8220);
    }

    static {
        AppMethodBeat.m2505o(8242);
    }

    private boolean dbf() {
        AppMethodBeat.m2504i(8221);
        boolean z = System.currentTimeMillis() - this.qBy > 500;
        if (!z) {
            C4990ab.m7420w("MicroMsg.WebViewBagMgr", "click to fast!!!");
        }
        AppMethodBeat.m2505o(8221);
        return z;
    }

    /* renamed from: nU */
    public final void mo48112nU(boolean z) {
        AppMethodBeat.m2504i(8222);
        C4990ab.m7417i("MicroMsg.WebViewBagMgr", "checkResumeBag mInWebViewUIFromBag:%b", Boolean.valueOf(this.uzt));
        if (C5046bo.isNullOrNil(this.uzu.url) || this.uzt || !dbf()) {
            cYT();
            C4990ab.m7416i("MicroMsg.WebViewBagMgr", "checkResumeBag hide bag");
            AppMethodBeat.m2505o(8222);
        } else if (this.uzr == null || this.uzr.getVisibility() != 0) {
            mo48114nW(z);
            C4990ab.m7416i("MicroMsg.WebViewBagMgr", "checkResumeBag show bag");
            AppMethodBeat.m2505o(8222);
        } else {
            C4990ab.m7416i("MicroMsg.WebViewBagMgr", "already show");
            this.uzr.setTouchEnable(true);
            AppMethodBeat.m2505o(8222);
        }
    }

    public final void dbg() {
        AppMethodBeat.m2504i(8223);
        C4990ab.m7417i("MicroMsg.WebViewBagMgr", "clearBag mCurrentUrl:%s", this.uzu.url);
        cYT();
        C29884a c29884a = this.uzu;
        c29884a.f13722id = null;
        c29884a.url = null;
        c29884a.cIY = null;
        c29884a.fAx = 0;
        c29884a.scene = 0;
        c29884a.uzC = new JSONObject();
        c29884a.save();
        dbk();
        Iterator it = this.uzv.iterator();
        while (it.hasNext()) {
            ((C14591b) it.next()).cXm();
        }
        AppMethodBeat.m2505o(8223);
    }

    public final boolean afZ(String str) {
        AppMethodBeat.m2504i(8224);
        C4990ab.m7417i("MicroMsg.WebViewBagMgr", "hasBagOfThePage targetId:%s currentId:%s", str, this.uzu.f13722id);
        if (C5046bo.isNullOrNil(this.uzu.url) || !C5046bo.nullAsNil(str).equals(this.uzu.f13722id)) {
            AppMethodBeat.m2505o(8224);
            return false;
        }
        AppMethodBeat.m2505o(8224);
        return true;
    }

    /* renamed from: nV */
    public final void mo48113nV(boolean z) {
        AppMethodBeat.m2504i(8225);
        C4990ab.m7417i("MicroMsg.WebViewBagMgr", "markInWebViewUIFromBag inWebViewUIFromBag:%b", Boolean.valueOf(z));
        this.uzt = z;
        AppMethodBeat.m2505o(8225);
    }

    public final Point dbh() {
        AppMethodBeat.m2504i(8226);
        Point point = new Point(this.uzu.uzB, this.uzu.uzA);
        AppMethodBeat.m2505o(8226);
        return point;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: nW */
    public final void mo48114nW(boolean z) {
        AppMethodBeat.m2504i(8227);
        C4990ab.m7417i("MicroMsg.WebViewBagMgr", "showBag url:%s", this.uzu.url);
        if (!C37657b.m63684bF(C4996ah.getContext())) {
            C4990ab.m7420w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
            AppMethodBeat.m2505o(8227);
        } else if (C5046bo.isNullOrNil(this.uzu.url)) {
            dbg();
            AppMethodBeat.m2505o(8227);
        } else {
            boolean z2 = this.uzr == null;
            if (this.uzr == null) {
                this.uzs = new C22932a(new C229422());
                this.uzr = new WebViewBag(C4996ah.getContext(), null);
                this.uzr.setListener(new C298803());
                this.uzr.setOnClickListener(new C298814());
            }
            mo48107bi(1.0f);
            this.uzr.setTouchEnable(true);
            this.uzr.setIcon(this.uzu.cIY);
            dbl();
            C4990ab.m7417i("MicroMsg.WebViewBagMgr", "bag showed needAttach:%b mCurrentBagId:%s", Boolean.valueOf(z2), this.uzu.f13722id);
            if (!z2) {
                if (this.uzr.getVisibility() != 0) {
                    this.uzr.setVisibility(0);
                    if (z) {
                        this.uzr.dbe();
                        AppMethodBeat.m2505o(8227);
                        return;
                    }
                }
                C4990ab.m7416i("MicroMsg.WebViewBagMgr", "already showed");
                AppMethodBeat.m2505o(8227);
            } else if (z) {
                this.uzr.setVisibility(4);
                dbj();
                this.uzr.setVisibility(0);
                this.uzr.dbe();
                AppMethodBeat.m2505o(8227);
            } else {
                dbj();
                AppMethodBeat.m2505o(8227);
            }
        }
    }

    public final void dbi() {
        AppMethodBeat.m2504i(8228);
        C4990ab.m7416i("MicroMsg.WebViewBagMgr", "removeBag");
        if (this.uzr == null) {
            AppMethodBeat.m2505o(8228);
            return;
        }
        this.uzr.mo38513a(new C298825());
        C5004al.m7442n(new C298836(), 120);
        AppMethodBeat.m2505o(8228);
    }

    public final void cYT() {
        AppMethodBeat.m2504i(8229);
        if (this.uzr == null) {
            AppMethodBeat.m2505o(8229);
            return;
        }
        this.uzr.setVisibility(8);
        AppMethodBeat.m2505o(8229);
    }

    /* renamed from: bi */
    public final void mo48107bi(float f) {
        AppMethodBeat.m2504i(8230);
        if (this.uzr == null) {
            AppMethodBeat.m2505o(8230);
            return;
        }
        this.uzr.setAlpha(f);
        if (f == 0.0f) {
            this.uzr.setVisibility(8);
            AppMethodBeat.m2505o(8230);
            return;
        }
        this.uzr.setVisibility(0);
        AppMethodBeat.m2505o(8230);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo48105a(String str, int i, String str2, Bundle bundle, boolean z) {
        AppMethodBeat.m2504i(8231);
        if (!z || C5046bo.isNullOrNil(this.uzu.f13722id)) {
            m47355Jy(23);
            this.uzu.f13722id = C4995ag.m7428ck(String.format("bagId#%d#%s", new Object[]{Long.valueOf(System.currentTimeMillis()), this.uzu.url}));
        }
        this.uzu.url = str;
        this.uzu.cIY = str2;
        this.uzu.scene = i;
        this.uzu.fAx = C5046bo.anU();
        this.uzu.uzC = C22939k.m34818ae(bundle);
        this.uzu.save();
        AppMethodBeat.m2505o(8231);
    }

    private void dbj() {
        AppMethodBeat.m2504i(8232);
        C4990ab.m7416i("MicroMsg.WebViewBagMgr", "attachBag");
        WindowManager windowManager = (WindowManager) C4996ah.getContext().getSystemService("window");
        LayoutParams layoutParams = new LayoutParams();
        if (C1443d.m3068iW(26)) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2002;
        }
        layoutParams.format = 1;
        layoutParams.packageName = C4996ah.getContext().getPackageName();
        layoutParams.flags = 40;
        layoutParams.gravity = 51;
        layoutParams.width = C29876b.uyj;
        layoutParams.height = C29876b.uyj;
        layoutParams.x = this.uzu.uzB;
        layoutParams.y = this.uzu.uzA;
        try {
            windowManager.addView(this.uzr, layoutParams);
            dbl();
            AppMethodBeat.m2505o(8232);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WebViewBagMgr", "add failed %s", e);
            AppMethodBeat.m2505o(8232);
        }
    }

    private void dbk() {
        AppMethodBeat.m2504i(8233);
        C4990ab.m7416i("MicroMsg.WebViewBagMgr", "unAttachBag");
        if (this.uzr != null) {
            try {
                ((WindowManager) C4996ah.getContext().getSystemService("window")).removeView(this.uzr);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.WebViewBagMgr", "remove failed %s", e);
            }
            this.uzr = null;
        } else {
            C4990ab.m7412e("MicroMsg.WebViewBagMgr", "unAttachBag mBag null");
        }
        if (this.uzs != null) {
            this.uzs.daX();
            this.uzs = null;
        }
        AppMethodBeat.m2505o(8233);
    }

    private void dbl() {
        AppMethodBeat.m2504i(8234);
        C4990ab.m7417i("MicroMsg.WebViewBagMgr", "setAngryInfo mBagInfo.lastActiveTime:%d", Long.valueOf(this.uzu.fAx));
        if (this.uzr == null) {
            AppMethodBeat.m2505o(8234);
        } else if (C29879l.dbm()) {
            this.uzr.mo38516j(60000, 100, this.uzu.fAx + FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            AppMethodBeat.m2505o(8234);
        } else {
            this.uzr.mo38516j(3600000, 30000, this.uzu.fAx + 3600000);
            AppMethodBeat.m2505o(8234);
        }
    }

    /* renamed from: Jy */
    private void m47355Jy(int i) {
        AppMethodBeat.m2504i(8235);
        C4990ab.m7419v("MicroMsg.WebViewBagMgr", "kvReport op:%d", Integer.valueOf(i));
        C7060h.pYm.mo8381e(11576, this.uzu.url, Integer.valueOf(i), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.uzu.fAx), this.uzu.f13722id);
        AppMethodBeat.m2505o(8235);
    }

    private static boolean dbm() {
        AppMethodBeat.m2504i(8236);
        boolean equals = "1".equals((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WEBVIEW_BAG_TEST_INFO_STRING_SYNC, AppEventsConstants.EVENT_PARAM_VALUE_NO));
        AppMethodBeat.m2505o(8236);
        return equals;
    }
}
