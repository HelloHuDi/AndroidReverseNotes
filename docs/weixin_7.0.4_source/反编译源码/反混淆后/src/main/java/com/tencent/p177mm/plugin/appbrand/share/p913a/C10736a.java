package com.tencent.p177mm.plugin.appbrand.share.p913a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.magicbrush.C37414c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C26436f;
import com.tencent.p177mm.modelappbrand.C32809i;
import com.tencent.p177mm.modelappbrand.C32809i.C32807a;
import com.tencent.p177mm.modelappbrand.C32809i.C32808b;
import com.tencent.p177mm.modelappbrand.C36700ac;
import com.tencent.p177mm.modelappbrand.C9687e;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37924e;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37932f;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p181af.C8909j.C8913a;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.p177mm.plugin.appbrand.share.C19736a;
import com.tencent.p177mm.plugin.appbrand.share.C19738b;
import com.tencent.p177mm.plugin.appbrand.share.widget.WxaShareMessagePage;
import com.tencent.p177mm.plugin.appbrand.share.widget.WxaShareMessagePage.C272981;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.appbrand.share.a.a */
public final class C10736a implements C32809i {
    private final Map<String, SoftReference<C37924e>> iDL = new ConcurrentHashMap();
    private final Map<String, SoftReference<C37932f>> iDM = new ConcurrentHashMap();
    private final Map<Integer, C10737a> iDN = new ConcurrentHashMap();
    private final Map<Integer, Bundle> iDO = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.share.a.a$a */
    interface C10737a {
        /* renamed from: C */
        void mo22295C(Bundle bundle);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.share.a.a$1 */
    class C107401 implements C10737a {
        C107401() {
        }

        /* renamed from: C */
        public final void mo22295C(Bundle bundle) {
            AppMethodBeat.m2504i(132739);
            C10736a.this.iDO.remove(Integer.valueOf(2));
            AppMethodBeat.m2505o(132739);
        }
    }

    public C10736a() {
        AppMethodBeat.m2504i(132743);
        m18411a(1, new C107401());
        AppMethodBeat.m2505o(132743);
    }

    /* renamed from: d */
    public final View mo22293d(Context context, Bundle bundle) {
        AppMethodBeat.m2504i(132744);
        Assert.assertNotNull(context);
        WxaShareMessagePage wxaShareMessagePage = new WxaShareMessagePage(context);
        if (bundle != null) {
            int i = bundle.getInt("key_biz", C8913a.BUSINESS_MAX.ordinal());
            if (C8913a.isValid(i)) {
                String string;
                wxaShareMessagePage.iEa = true;
                LayoutParams layoutParams = wxaShareMessagePage.hYX.getLayoutParams();
                layoutParams.width = C1338a.fromDPToPix(wxaShareMessagePage.getContext(), 112);
                layoutParams.height = C1338a.fromDPToPix(wxaShareMessagePage.getContext(), 63);
                wxaShareMessagePage.hYX.setLayoutParams(layoutParams);
                wxaShareMessagePage.hYX.setScaleType(ScaleType.CENTER_CROP);
                layoutParams = wxaShareMessagePage.iDU.getLayoutParams();
                layoutParams.width = C1338a.fromDPToPix(wxaShareMessagePage.getContext(), 112);
                layoutParams.height = C1338a.fromDPToPix(wxaShareMessagePage.getContext(), 63);
                wxaShareMessagePage.iDU.setLayoutParams(layoutParams);
                layoutParams = wxaShareMessagePage.f13680qQ.getLayoutParams();
                layoutParams.width = C1338a.fromDPToPix(wxaShareMessagePage.getContext(), 112);
                layoutParams.height = C1338a.fromDPToPix(wxaShareMessagePage.getContext(), 63);
                wxaShareMessagePage.f13680qQ.setLayoutParams(layoutParams);
                if (C8913a.BUSINESS_MY_LIFE_AROUND.ordinal() == i) {
                    wxaShareMessagePage.iDX.setImageResource(C1318a.my_life_around_default_icon);
                    wxaShareMessagePage.iDU.setImageResource(C1318a.app_msg_share_nearby_life_default);
                } else if (C8913a.BUSINESS_OTHER.ordinal() == i) {
                    string = bundle.getString("key_footer_icon", "");
                    if (!C37414c.isNullOrNil(string)) {
                        C32291o.aho().mo53003a(string, new C272981());
                    }
                }
                string = bundle.getString("key_footer_text", "");
                String string2 = bundle.getString("key_footer_text_default", "");
                if (!string.isEmpty()) {
                    wxaShareMessagePage.iDY.setText(string);
                } else if (!string2.isEmpty()) {
                    wxaShareMessagePage.iDY.setText(string2);
                }
            }
        }
        AppMethodBeat.m2505o(132744);
        return wxaShareMessagePage;
    }

    /* renamed from: a */
    public final boolean mo22289a(String str, View view, Bundle bundle) {
        AppMethodBeat.m2504i(132745);
        boolean a = mo22290a(str, view, bundle, null);
        AppMethodBeat.m2505o(132745);
        return a;
    }

    /* renamed from: a */
    public final boolean mo22290a(String str, View view, Bundle bundle, final C32808b c32808b) {
        AppMethodBeat.m2504i(132746);
        Assert.assertNotNull(view);
        Assert.assertNotNull(bundle);
        if (view instanceof WxaShareMessagePage) {
            C4990ab.m7417i("MicroMsg.WxaShareMessageService", "onBindView(%s, %s)", str, Integer.valueOf(view.hashCode()));
            final WxaShareMessagePage wxaShareMessagePage = (WxaShareMessagePage) view;
            boolean z = bundle.getBoolean("is_dynamic_page");
            wxaShareMessagePage.setTitle(bundle.getString("title", ""));
            if (z) {
                wxaShareMessagePage.getCoverImageView().setVisibility(4);
                IPCDynamicPageView widgetPageView = wxaShareMessagePage.getWidgetPageView();
                widgetPageView.setVisibility(0);
                bundle.putInt("view_init_width", wxaShareMessagePage.getWidgetWidth());
                bundle.putInt("view_init_height", wxaShareMessagePage.getWidgetHeight());
                ((C9687e) C1720g.m3528K(C9687e.class)).mo21014a(str, widgetPageView, bundle, new C36700ac(new C26436f() {
                    /* renamed from: F */
                    public final void mo9596F(View view, int i) {
                        AppMethodBeat.m2504i(132740);
                        switch (i) {
                            case 0:
                                wxaShareMessagePage.getLoadingView().setVisibility(0);
                                wxaShareMessagePage.getErrorImageView().setVisibility(4);
                                wxaShareMessagePage.getWidgetPageView().setVisibility(4);
                                wxaShareMessagePage.getLoadingView().dKS();
                                AppMethodBeat.m2505o(132740);
                                return;
                            case 1:
                                wxaShareMessagePage.getLoadingView().dKT();
                                wxaShareMessagePage.getLoadingView().setVisibility(4);
                                wxaShareMessagePage.getErrorImageView().setVisibility(0);
                                wxaShareMessagePage.getWidgetPageView().setVisibility(4);
                                wxaShareMessagePage.getErrorImageView().setImageResource(C1318a.dynamic_page_res_not_found);
                                AppMethodBeat.m2505o(132740);
                                return;
                            case 4:
                                wxaShareMessagePage.getLoadingView().setVisibility(4);
                                wxaShareMessagePage.getErrorImageView().setVisibility(4);
                                wxaShareMessagePage.getWidgetPageView().setVisibility(0);
                                AppMethodBeat.m2505o(132740);
                                return;
                            default:
                                wxaShareMessagePage.getLoadingView().dKT();
                                wxaShareMessagePage.getLoadingView().setVisibility(4);
                                wxaShareMessagePage.getErrorImageView().setVisibility(0);
                                wxaShareMessagePage.getWidgetPageView().setVisibility(4);
                                wxaShareMessagePage.getErrorImageView().setImageResource(C1318a.app_brand_share_page_cover_default);
                                AppMethodBeat.m2505o(132740);
                                return;
                        }
                    }
                }));
                C10736a.m18413a(c32808b, 0);
            } else {
                Bitmap decodeByteArray;
                wxaShareMessagePage.getWidgetPageView().setVisibility(4);
                wxaShareMessagePage.getCoverImageView().setVisibility(0);
                byte[] byteArray = bundle.getByteArray(ImagesContract.IMAGE_DATA);
                if (byteArray != null && byteArray.length > 0) {
                    decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    if (!(decodeByteArray == null || decodeByteArray.isRecycled())) {
                        wxaShareMessagePage.setImageData(decodeByteArray);
                        C10736a.m18413a(c32808b, 0);
                        AppMethodBeat.m2505o(132746);
                        return true;
                    }
                }
                String string = bundle.getString("delay_load_img_path");
                if (C5046bo.isNullOrNil(string)) {
                    String string2 = bundle.getString(MessengerShareContentUtility.IMAGE_URL);
                    if (string2 == null || !(string2.startsWith("http://") || string2.startsWith("https://"))) {
                        if (string2 != null && string2.startsWith("file://")) {
                            decodeByteArray = C37926b.abR().mo60681a(string2, null);
                            if (!(decodeByteArray == null || decodeByteArray.isRecycled())) {
                                wxaShareMessagePage.setImageData(decodeByteArray);
                                C10736a.m18413a(c32808b, 0);
                                AppMethodBeat.m2505o(132746);
                                return true;
                            }
                        }
                        wxaShareMessagePage.mo6522mr();
                        C10736a.m18413a(c32808b, 1);
                    } else {
                        wxaShareMessagePage.setOnLoadImageResult(c32808b);
                        wxaShareMessagePage.setImageUrl(string2);
                    }
                } else {
                    decodeByteArray = null;
                    if (!string.startsWith("delayLoadFile://")) {
                        decodeByteArray = C37926b.abR().mo60681a(string, null);
                        C4990ab.m7417i("MicroMsg.WxaShareMessageService", "findCachedLocal(%s)", string);
                    } else if (this.iDO.containsKey(Integer.valueOf(2))) {
                        decodeByteArray = C5056d.aml(string.replace("delayLoadFile://", ""));
                        C4990ab.m7417i("MicroMsg.WxaShareMessageService", "getBitmapNative(%s)", string);
                    }
                    if (decodeByteArray != null) {
                        if (decodeByteArray.isRecycled()) {
                            wxaShareMessagePage.setOnLoadImageResult(c32808b);
                            wxaShareMessagePage.setImageUrl(string);
                        } else {
                            wxaShareMessagePage.setImageData(decodeByteArray);
                            C10736a.m18413a(c32808b, 0);
                        }
                        AppMethodBeat.m2505o(132746);
                        return true;
                    }
                    C4990ab.m7417i("MicroMsg.WxaShareMessageService", "delay loadImage(%s)", string);
                    wxaShareMessagePage.getLoadingView().setVisibility(0);
                    wxaShareMessagePage.getErrorImageView().setVisibility(4);
                    wxaShareMessagePage.getCoverImageView().setVisibility(4);
                    wxaShareMessagePage.getLoadingView().dKS();
                    m18411a(2, new C10737a() {
                        /* renamed from: C */
                        public final void mo22295C(final Bundle bundle) {
                            AppMethodBeat.m2504i(132742);
                            C26006a.m41506q(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(132741);
                                    wxaShareMessagePage.setImageUrl(bundle.getString("delay_load_img_path"));
                                    C4990ab.m7417i("MicroMsg.WxaShareMessageService", "onLoadImageFinishedAction(%s)", r0);
                                    C10736a.m18412a(c32808b);
                                    AppMethodBeat.m2505o(132741);
                                }
                            });
                            AppMethodBeat.m2505o(132742);
                        }
                    });
                }
            }
            AppMethodBeat.m2505o(132746);
            return true;
        }
        AppMethodBeat.m2505o(132746);
        return false;
    }

    /* renamed from: a */
    private static void m18413a(C32808b c32808b, int i) {
        AppMethodBeat.m2504i(132747);
        if (c32808b != null) {
            c32808b.mo6398kQ(i);
        }
        AppMethodBeat.m2505o(132747);
    }

    /* renamed from: a */
    public final void mo22288a(String str, View view) {
        AppMethodBeat.m2504i(132748);
        Assert.assertNotNull(view);
        if (view instanceof WxaShareMessagePage) {
            C4990ab.m7417i("MicroMsg.WxaShareMessageService", "onUnbindView(%s, %s)", str, Integer.valueOf(view.hashCode()));
            ((C9687e) C1720g.m3528K(C9687e.class)).mo21015a(str, ((WxaShareMessagePage) view).getWidgetPageView());
            this.iDN.remove(Integer.valueOf(2));
            AppMethodBeat.m2505o(132748);
            return;
        }
        AppMethodBeat.m2505o(132748);
    }

    /* renamed from: d */
    public final synchronized void mo22294d(int i, Bundle bundle) {
        AppMethodBeat.m2504i(132749);
        C10737a c10737a = (C10737a) this.iDN.get(Integer.valueOf(i));
        if (c10737a != null) {
            c10737a.mo22295C(bundle);
        }
        this.iDO.put(Integer.valueOf(i), bundle);
        C4990ab.m7417i("MicroMsg.WxaShareMessageService", "onAction(%d, %s)", Integer.valueOf(i), bundle);
        AppMethodBeat.m2505o(132749);
    }

    /* renamed from: cq */
    public final C37924e mo22292cq(int i, int i2) {
        AppMethodBeat.m2504i(132750);
        C37924e a = mo22287a(i, i2, C32807a.DECODE_TYPE_DEFAULT);
        AppMethodBeat.m2505o(132750);
        return a;
    }

    /* JADX WARNING: Missing block: B:3:0x002e, code skipped:
            if (r1 == null) goto L_0x0030;
     */
    /* JADX WARNING: Missing block: B:9:0x0041, code skipped:
            if (r1 == null) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final C37924e mo22287a(int i, int i2, C32807a c32807a) {
        C37924e c37924e;
        AppMethodBeat.m2504i(132751);
        String format = String.format("%d-%d-dp", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        SoftReference softReference = (SoftReference) this.iDL.get(format);
        if (softReference != null) {
            c37924e = (C37924e) softReference.get();
        }
        synchronized (this) {
            try {
                softReference = (SoftReference) this.iDL.get(format);
                if (softReference != null) {
                    c37924e = (C37924e) softReference.get();
                }
                C19736a c19736a = new C19736a(C1338a.fromDPToPix(C4996ah.getContext(), i), C1338a.fromDPToPix(C4996ah.getContext(), i2));
                c19736a.iDJ = c32807a;
                this.iDL.put(format, new SoftReference(c19736a));
                c37924e = c19736a;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(132751);
                }
            }
        }
        AppMethodBeat.m2505o(132751);
        return c37924e;
    }

    /* JADX WARNING: Missing block: B:3:0x0032, code skipped:
            if (r0 == null) goto L_0x0034;
     */
    /* JADX WARNING: Missing block: B:9:0x0045, code skipped:
            if (r0 == null) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final C37932f abB() {
        C37932f c37932f;
        AppMethodBeat.m2504i(132752);
        String format = String.format("%d-%d-dp", new Object[]{Integer.valueOf(112), Integer.valueOf(90)});
        SoftReference softReference = (SoftReference) this.iDM.get(format);
        if (softReference != null) {
            c37932f = (C37932f) softReference.get();
        }
        synchronized (this) {
            try {
                softReference = (SoftReference) this.iDM.get(format);
                if (softReference != null) {
                    c37932f = (C37932f) softReference.get();
                }
                c37932f = new C19738b(C1338a.fromDPToPix(C4996ah.getContext(), 112), C1338a.fromDPToPix(C4996ah.getContext(), 90));
                this.iDM.put(format, new SoftReference(c37932f));
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(132752);
                }
            }
        }
        AppMethodBeat.m2505o(132752);
        return c37932f;
    }

    /* renamed from: a */
    private void m18411a(int i, C10737a c10737a) {
        AppMethodBeat.m2504i(132753);
        this.iDN.put(Integer.valueOf(i), c10737a);
        if (this.iDO.containsKey(Integer.valueOf(i))) {
            c10737a.mo22295C((Bundle) this.iDO.get(Integer.valueOf(i)));
        }
        AppMethodBeat.m2505o(132753);
    }
}
