package com.tencent.mm.plugin.webview.ui.tools.bag;

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
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.c;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public enum l {
    ;
    
    private long qBy;
    private WebViewBag uzr;
    private a uzs;
    private boolean uzt;
    public a uzu;
    public LinkedList<b> uzv;

    public interface b {
        void cXm();
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.l$1 */
    class AnonymousClass1 implements com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a {
        final /* synthetic */ int fwD;
        final /* synthetic */ String uzx;
        final /* synthetic */ boolean uzy;
        final /* synthetic */ Bundle val$extras;
        final /* synthetic */ String val$url;

        AnonymousClass1(String str, int i, String str2, Bundle bundle, boolean z) {
            this.val$url = str;
            this.fwD = i;
            this.uzx = str2;
            this.val$extras = bundle;
            this.uzy = z;
        }

        public final void a(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            AppMethodBeat.i(8208);
            requestFloatWindowPermissionDialog.finish();
            l.a(l.this, this.val$url, this.fwD, this.uzx, this.val$extras, this.uzy);
            l.a(l.this);
            AppMethodBeat.o(8208);
        }

        public final void b(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            AppMethodBeat.i(8209);
            requestFloatWindowPermissionDialog.finish();
            AppMethodBeat.o(8209);
        }
    }

    public static final class a {
        String cIY;
        long fAx;
        String id;
        int scene;
        public String url;
        int uzA;
        int uzB;
        JSONObject uzC;

        public a() {
            AppMethodBeat.i(8216);
            g.RQ();
            String str = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WEBVIEW_BAG_INFO_STRING_SYNC, null);
            ab.i("MicroMsg.WebViewBagMgr", "BagInfo#load %s", str);
            if (bo.isNullOrNil(str)) {
                this.id = null;
                this.url = null;
                this.cIY = null;
                this.uzB = (com.tencent.mm.bz.a.gd(ah.getContext()) - b.uyj) - b.uyk;
                this.uzA = b.uyi + ah.getContext().getResources().getDimensionPixelSize(R.dimen.ab0);
                this.uzC = new JSONObject();
                ab.i("MicroMsg.WebViewBagMgr", "BAG_INIT_X:%d BAG_INIT_Y:%d", Integer.valueOf(this.uzB), Integer.valueOf(this.uzA));
                AppMethodBeat.o(8216);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.url = jSONObject.getString("url");
                this.id = jSONObject.optString("id", ag.ck(String.format("bagId#%d#%s", new Object[]{Long.valueOf(System.currentTimeMillis()), this.url})));
                this.cIY = jSONObject.getString("icon");
                this.uzA = jSONObject.getInt("pos_y");
                this.uzB = jSONObject.getInt("pos_x");
                this.fAx = jSONObject.getLong("last_active_time");
                this.uzC = jSONObject.getJSONObject("extras");
                this.scene = jSONObject.optInt("scene", 0);
                AppMethodBeat.o(8216);
            } catch (JSONException e) {
                ab.e("MicroMsg.WebViewBagMgr", "BagInfo#load exp:%s", e);
                AppMethodBeat.o(8216);
            }
        }

        /* Access modifiers changed, original: final */
        public final void save() {
            AppMethodBeat.i(8217);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", bo.nullAsNil(this.id));
                jSONObject.put("url", bo.nullAsNil(this.url));
                jSONObject.put("icon", bo.nullAsNil(this.cIY));
                jSONObject.put("pos_y", this.uzA);
                jSONObject.put("pos_x", this.uzB);
                jSONObject.put("last_active_time", this.fAx);
                jSONObject.put("extras", this.uzC);
                jSONObject.put("scene", this.scene);
                Object jSONObject2 = jSONObject.toString();
                g.RQ();
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WEBVIEW_BAG_INFO_STRING_SYNC, jSONObject2);
                AppMethodBeat.o(8217);
            } catch (JSONException e) {
                ab.e("MicroMsg.WebViewBagMgr", "BagInfo#save exp:%s", e);
                AppMethodBeat.o(8217);
            }
        }
    }

    private l(String str) {
        AppMethodBeat.i(8220);
        this.qBy = -1;
        this.uzu = new a();
        this.uzv = new LinkedList();
        AppMethodBeat.o(8220);
    }

    static {
        AppMethodBeat.o(8242);
    }

    private boolean dbf() {
        AppMethodBeat.i(8221);
        boolean z = System.currentTimeMillis() - this.qBy > 500;
        if (!z) {
            ab.w("MicroMsg.WebViewBagMgr", "click to fast!!!");
        }
        AppMethodBeat.o(8221);
        return z;
    }

    public final void nU(boolean z) {
        AppMethodBeat.i(8222);
        ab.i("MicroMsg.WebViewBagMgr", "checkResumeBag mInWebViewUIFromBag:%b", Boolean.valueOf(this.uzt));
        if (bo.isNullOrNil(this.uzu.url) || this.uzt || !dbf()) {
            cYT();
            ab.i("MicroMsg.WebViewBagMgr", "checkResumeBag hide bag");
            AppMethodBeat.o(8222);
        } else if (this.uzr == null || this.uzr.getVisibility() != 0) {
            nW(z);
            ab.i("MicroMsg.WebViewBagMgr", "checkResumeBag show bag");
            AppMethodBeat.o(8222);
        } else {
            ab.i("MicroMsg.WebViewBagMgr", "already show");
            this.uzr.setTouchEnable(true);
            AppMethodBeat.o(8222);
        }
    }

    public final void dbg() {
        AppMethodBeat.i(8223);
        ab.i("MicroMsg.WebViewBagMgr", "clearBag mCurrentUrl:%s", this.uzu.url);
        cYT();
        a aVar = this.uzu;
        aVar.id = null;
        aVar.url = null;
        aVar.cIY = null;
        aVar.fAx = 0;
        aVar.scene = 0;
        aVar.uzC = new JSONObject();
        aVar.save();
        dbk();
        Iterator it = this.uzv.iterator();
        while (it.hasNext()) {
            ((b) it.next()).cXm();
        }
        AppMethodBeat.o(8223);
    }

    public final boolean afZ(String str) {
        AppMethodBeat.i(8224);
        ab.i("MicroMsg.WebViewBagMgr", "hasBagOfThePage targetId:%s currentId:%s", str, this.uzu.id);
        if (bo.isNullOrNil(this.uzu.url) || !bo.nullAsNil(str).equals(this.uzu.id)) {
            AppMethodBeat.o(8224);
            return false;
        }
        AppMethodBeat.o(8224);
        return true;
    }

    public final void nV(boolean z) {
        AppMethodBeat.i(8225);
        ab.i("MicroMsg.WebViewBagMgr", "markInWebViewUIFromBag inWebViewUIFromBag:%b", Boolean.valueOf(z));
        this.uzt = z;
        AppMethodBeat.o(8225);
    }

    public final Point dbh() {
        AppMethodBeat.i(8226);
        Point point = new Point(this.uzu.uzB, this.uzu.uzA);
        AppMethodBeat.o(8226);
        return point;
    }

    /* Access modifiers changed, original: final */
    public final void nW(boolean z) {
        AppMethodBeat.i(8227);
        ab.i("MicroMsg.WebViewBagMgr", "showBag url:%s", this.uzu.url);
        if (!com.tencent.mm.compatible.f.b.bF(ah.getContext())) {
            ab.w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
            AppMethodBeat.o(8227);
        } else if (bo.isNullOrNil(this.uzu.url)) {
            dbg();
            AppMethodBeat.o(8227);
        } else {
            boolean z2 = this.uzr == null;
            if (this.uzr == null) {
                this.uzs = new a(new com.tencent.mm.plugin.webview.ui.tools.bag.a.b() {
                    public final void daY() {
                        AppMethodBeat.i(8210);
                        l.a(l.this, 17);
                        Point point = null;
                        if (l.this.uzr != null) {
                            point = l.this.uzr.getLastTouchDownViewPos();
                        }
                        l.this.dbg();
                        if (point != null) {
                            l.this.uzu.uzB = point.x;
                            l.this.uzu.uzA = point.y;
                            l.this.uzu.save();
                        }
                        AppMethodBeat.o(8210);
                    }
                });
                this.uzr = new WebViewBag(ah.getContext(), null);
                this.uzr.setListener(new com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBag.a() {
                    public final void gz(int i, int i2) {
                        AppMethodBeat.i(8211);
                        l.a(l.this, 19);
                        l.this.uzu.uzB = i;
                        l.this.uzu.uzA = i2;
                        l.this.uzu.save();
                        AppMethodBeat.o(8211);
                    }

                    public final void onTouchEvent(MotionEvent motionEvent) {
                        AppMethodBeat.i(8212);
                        if (l.this.uzs != null) {
                            a d = l.this.uzs;
                            float rawX = motionEvent.getRawX();
                            float rawY = motionEvent.getRawY();
                            a aVar;
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
                                            aVar = d.uxZ;
                                            translateAnimation = new TranslateAnimation(0.0f, (float) b.uyp, 0.0f, (float) b.uyp);
                                            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                                            AnimationSet animationSet = new AnimationSet(true);
                                            animationSet.addAnimation(alphaAnimation);
                                            animationSet.addAnimation(translateAnimation);
                                            animationSet.setDuration(300);
                                            animationSet.setAnimationListener(new c() {
                                                public final void onAnimationEnd(Animation animation) {
                                                    AppMethodBeat.i(8142);
                                                    a.this.setVisibility(8);
                                                    AppMethodBeat.o(8142);
                                                }
                                            });
                                            aVar.lBT.startAnimation(animationSet);
                                            aVar.WL.startAnimation(animationSet);
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
                                            b.fs(ah.getContext());
                                            d.mIsShowing = true;
                                            d.mScreenWidth = com.tencent.mm.bz.a.gd(ah.getContext());
                                            d.mScreenHeight = com.tencent.mm.bz.a.ge(ah.getContext());
                                            d.uye = d.mScreenWidth > d.mScreenHeight;
                                            ab.i("MicroMsg.BagCancelController", "updateOrientation mIsLandScape:%b", Boolean.valueOf(d.uye));
                                            aVar = d.uxZ;
                                            aVar.setVisibility(0);
                                            translateAnimation = new TranslateAnimation((float) b.uyp, 0.0f, (float) b.uyp, 0.0f);
                                            translateAnimation.setFillAfter(true);
                                            translateAnimation.setDuration(200);
                                            aVar.lBT.startAnimation(translateAnimation);
                                            aVar.WL.startAnimation(translateAnimation);
                                        }
                                        boolean z2 = d.uyd;
                                        if (d.uye) {
                                            rawX = (((float) d.mScreenWidth) - motionEvent.getRawX()) - ((float) b.uyg);
                                            rawY = ((float) d.mScreenHeight) - motionEvent.getRawY();
                                        } else {
                                            rawX = ((float) d.mScreenWidth) - motionEvent.getRawX();
                                            rawY = (((float) d.mScreenHeight) - motionEvent.getRawY()) - ((float) b.uyg);
                                        }
                                        if ((rawX * rawX) + (rawY * rawY) < ((float) a.uxY)) {
                                            d.uyd = true;
                                        } else {
                                            d.uyd = false;
                                        }
                                        if (d.uyd != z2) {
                                            aVar = d.uxZ;
                                            if (d.uyd) {
                                                aVar.af(1.0f, b.uyq);
                                                if (aVar.iVt != null) {
                                                    aVar.iVt.vibrate(10);
                                                }
                                                AppMethodBeat.o(8212);
                                                return;
                                            }
                                            aVar.af(b.uyq, 1.0f);
                                            AppMethodBeat.o(8212);
                                            return;
                                        }
                                    }
                                    break;
                            }
                            d.uyb = false;
                            d.uyd = false;
                        }
                        AppMethodBeat.o(8212);
                    }
                });
                this.uzr.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(8213);
                        l.a(l.this, l.this.uzu.url, l.this.uzu.scene);
                        AppMethodBeat.o(8213);
                    }
                });
            }
            bi(1.0f);
            this.uzr.setTouchEnable(true);
            this.uzr.setIcon(this.uzu.cIY);
            dbl();
            ab.i("MicroMsg.WebViewBagMgr", "bag showed needAttach:%b mCurrentBagId:%s", Boolean.valueOf(z2), this.uzu.id);
            if (!z2) {
                if (this.uzr.getVisibility() != 0) {
                    this.uzr.setVisibility(0);
                    if (z) {
                        this.uzr.dbe();
                        AppMethodBeat.o(8227);
                        return;
                    }
                }
                ab.i("MicroMsg.WebViewBagMgr", "already showed");
                AppMethodBeat.o(8227);
            } else if (z) {
                this.uzr.setVisibility(4);
                dbj();
                this.uzr.setVisibility(0);
                this.uzr.dbe();
                AppMethodBeat.o(8227);
            } else {
                dbj();
                AppMethodBeat.o(8227);
            }
        }
    }

    public final void dbi() {
        AppMethodBeat.i(8228);
        ab.i("MicroMsg.WebViewBagMgr", "removeBag");
        if (this.uzr == null) {
            AppMethodBeat.o(8228);
            return;
        }
        this.uzr.a(new c() {
            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(8214);
                l.e(l.this);
                AppMethodBeat.o(8214);
            }
        });
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(8215);
                if (l.this.uzr != null) {
                    l.e(l.this);
                }
                AppMethodBeat.o(8215);
            }
        }, 120);
        AppMethodBeat.o(8228);
    }

    public final void cYT() {
        AppMethodBeat.i(8229);
        if (this.uzr == null) {
            AppMethodBeat.o(8229);
            return;
        }
        this.uzr.setVisibility(8);
        AppMethodBeat.o(8229);
    }

    public final void bi(float f) {
        AppMethodBeat.i(8230);
        if (this.uzr == null) {
            AppMethodBeat.o(8230);
            return;
        }
        this.uzr.setAlpha(f);
        if (f == 0.0f) {
            this.uzr.setVisibility(8);
            AppMethodBeat.o(8230);
            return;
        }
        this.uzr.setVisibility(0);
        AppMethodBeat.o(8230);
    }

    /* Access modifiers changed, original: final */
    public final void a(String str, int i, String str2, Bundle bundle, boolean z) {
        AppMethodBeat.i(8231);
        if (!z || bo.isNullOrNil(this.uzu.id)) {
            Jy(23);
            this.uzu.id = ag.ck(String.format("bagId#%d#%s", new Object[]{Long.valueOf(System.currentTimeMillis()), this.uzu.url}));
        }
        this.uzu.url = str;
        this.uzu.cIY = str2;
        this.uzu.scene = i;
        this.uzu.fAx = bo.anU();
        this.uzu.uzC = k.ae(bundle);
        this.uzu.save();
        AppMethodBeat.o(8231);
    }

    private void dbj() {
        AppMethodBeat.i(8232);
        ab.i("MicroMsg.WebViewBagMgr", "attachBag");
        WindowManager windowManager = (WindowManager) ah.getContext().getSystemService("window");
        LayoutParams layoutParams = new LayoutParams();
        if (d.iW(26)) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2002;
        }
        layoutParams.format = 1;
        layoutParams.packageName = ah.getContext().getPackageName();
        layoutParams.flags = 40;
        layoutParams.gravity = 51;
        layoutParams.width = b.uyj;
        layoutParams.height = b.uyj;
        layoutParams.x = this.uzu.uzB;
        layoutParams.y = this.uzu.uzA;
        try {
            windowManager.addView(this.uzr, layoutParams);
            dbl();
            AppMethodBeat.o(8232);
        } catch (Exception e) {
            ab.e("MicroMsg.WebViewBagMgr", "add failed %s", e);
            AppMethodBeat.o(8232);
        }
    }

    private void dbk() {
        AppMethodBeat.i(8233);
        ab.i("MicroMsg.WebViewBagMgr", "unAttachBag");
        if (this.uzr != null) {
            try {
                ((WindowManager) ah.getContext().getSystemService("window")).removeView(this.uzr);
            } catch (Exception e) {
                ab.e("MicroMsg.WebViewBagMgr", "remove failed %s", e);
            }
            this.uzr = null;
        } else {
            ab.e("MicroMsg.WebViewBagMgr", "unAttachBag mBag null");
        }
        if (this.uzs != null) {
            this.uzs.daX();
            this.uzs = null;
        }
        AppMethodBeat.o(8233);
    }

    private void dbl() {
        AppMethodBeat.i(8234);
        ab.i("MicroMsg.WebViewBagMgr", "setAngryInfo mBagInfo.lastActiveTime:%d", Long.valueOf(this.uzu.fAx));
        if (this.uzr == null) {
            AppMethodBeat.o(8234);
        } else if (dbm()) {
            this.uzr.j(60000, 100, this.uzu.fAx + FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            AppMethodBeat.o(8234);
        } else {
            this.uzr.j(3600000, 30000, this.uzu.fAx + 3600000);
            AppMethodBeat.o(8234);
        }
    }

    private void Jy(int i) {
        AppMethodBeat.i(8235);
        ab.v("MicroMsg.WebViewBagMgr", "kvReport op:%d", Integer.valueOf(i));
        h.pYm.e(11576, this.uzu.url, Integer.valueOf(i), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.uzu.fAx), this.uzu.id);
        AppMethodBeat.o(8235);
    }

    private static boolean dbm() {
        AppMethodBeat.i(8236);
        boolean equals = "1".equals((String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WEBVIEW_BAG_TEST_INFO_STRING_SYNC, AppEventsConstants.EVENT_PARAM_VALUE_NO));
        AppMethodBeat.o(8236);
        return equals;
    }
}
