package com.tencent.mm.plugin.appbrand.share.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.magicbrush.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b.e;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.i.b;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class a implements i {
    private final Map<String, SoftReference<e>> iDL = new ConcurrentHashMap();
    private final Map<String, SoftReference<f>> iDM = new ConcurrentHashMap();
    private final Map<Integer, a> iDN = new ConcurrentHashMap();
    private final Map<Integer, Bundle> iDO = new ConcurrentHashMap();

    interface a {
        void C(Bundle bundle);
    }

    public a() {
        AppMethodBeat.i(132743);
        a(1, new a() {
            public final void C(Bundle bundle) {
                AppMethodBeat.i(132739);
                a.this.iDO.remove(Integer.valueOf(2));
                AppMethodBeat.o(132739);
            }
        });
        AppMethodBeat.o(132743);
    }

    public final View d(Context context, Bundle bundle) {
        AppMethodBeat.i(132744);
        Assert.assertNotNull(context);
        WxaShareMessagePage wxaShareMessagePage = new WxaShareMessagePage(context);
        if (bundle != null) {
            int i = bundle.getInt("key_biz", com.tencent.mm.af.j.a.BUSINESS_MAX.ordinal());
            if (com.tencent.mm.af.j.a.isValid(i)) {
                String string;
                wxaShareMessagePage.iEa = true;
                LayoutParams layoutParams = wxaShareMessagePage.hYX.getLayoutParams();
                layoutParams.width = com.tencent.mm.bz.a.fromDPToPix(wxaShareMessagePage.getContext(), 112);
                layoutParams.height = com.tencent.mm.bz.a.fromDPToPix(wxaShareMessagePage.getContext(), 63);
                wxaShareMessagePage.hYX.setLayoutParams(layoutParams);
                wxaShareMessagePage.hYX.setScaleType(ScaleType.CENTER_CROP);
                layoutParams = wxaShareMessagePage.iDU.getLayoutParams();
                layoutParams.width = com.tencent.mm.bz.a.fromDPToPix(wxaShareMessagePage.getContext(), 112);
                layoutParams.height = com.tencent.mm.bz.a.fromDPToPix(wxaShareMessagePage.getContext(), 63);
                wxaShareMessagePage.iDU.setLayoutParams(layoutParams);
                layoutParams = wxaShareMessagePage.qQ.getLayoutParams();
                layoutParams.width = com.tencent.mm.bz.a.fromDPToPix(wxaShareMessagePage.getContext(), 112);
                layoutParams.height = com.tencent.mm.bz.a.fromDPToPix(wxaShareMessagePage.getContext(), 63);
                wxaShareMessagePage.qQ.setLayoutParams(layoutParams);
                if (com.tencent.mm.af.j.a.BUSINESS_MY_LIFE_AROUND.ordinal() == i) {
                    wxaShareMessagePage.iDX.setImageResource(R.raw.my_life_around_default_icon);
                    wxaShareMessagePage.iDU.setImageResource(R.raw.app_msg_share_nearby_life_default);
                } else if (com.tencent.mm.af.j.a.BUSINESS_OTHER.ordinal() == i) {
                    string = bundle.getString("key_footer_icon", "");
                    if (!c.isNullOrNil(string)) {
                        o.aho().a(string, new com.tencent.mm.at.p.a() {
                            public final void i(String str, final Bitmap bitmap) {
                                AppMethodBeat.i(132756);
                                al.d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(132755);
                                        WxaShareMessagePage.this.iDX.setImageBitmap(bitmap);
                                        WxaShareMessagePage.this.iDU.setImageBitmap(bitmap);
                                        AppMethodBeat.o(132755);
                                    }
                                });
                                AppMethodBeat.o(132756);
                            }
                        });
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
        AppMethodBeat.o(132744);
        return wxaShareMessagePage;
    }

    public final boolean a(String str, View view, Bundle bundle) {
        AppMethodBeat.i(132745);
        boolean a = a(str, view, bundle, null);
        AppMethodBeat.o(132745);
        return a;
    }

    public final boolean a(String str, View view, Bundle bundle, final b bVar) {
        AppMethodBeat.i(132746);
        Assert.assertNotNull(view);
        Assert.assertNotNull(bundle);
        if (view instanceof WxaShareMessagePage) {
            ab.i("MicroMsg.WxaShareMessageService", "onBindView(%s, %s)", str, Integer.valueOf(view.hashCode()));
            final WxaShareMessagePage wxaShareMessagePage = (WxaShareMessagePage) view;
            boolean z = bundle.getBoolean("is_dynamic_page");
            wxaShareMessagePage.setTitle(bundle.getString("title", ""));
            if (z) {
                wxaShareMessagePage.getCoverImageView().setVisibility(4);
                IPCDynamicPageView widgetPageView = wxaShareMessagePage.getWidgetPageView();
                widgetPageView.setVisibility(0);
                bundle.putInt("view_init_width", wxaShareMessagePage.getWidgetWidth());
                bundle.putInt("view_init_height", wxaShareMessagePage.getWidgetHeight());
                ((com.tencent.mm.modelappbrand.e) g.K(com.tencent.mm.modelappbrand.e.class)).a(str, widgetPageView, bundle, new ac(new com.tencent.mm.modelappbrand.f() {
                    public final void F(View view, int i) {
                        AppMethodBeat.i(132740);
                        switch (i) {
                            case 0:
                                wxaShareMessagePage.getLoadingView().setVisibility(0);
                                wxaShareMessagePage.getErrorImageView().setVisibility(4);
                                wxaShareMessagePage.getWidgetPageView().setVisibility(4);
                                wxaShareMessagePage.getLoadingView().dKS();
                                AppMethodBeat.o(132740);
                                return;
                            case 1:
                                wxaShareMessagePage.getLoadingView().dKT();
                                wxaShareMessagePage.getLoadingView().setVisibility(4);
                                wxaShareMessagePage.getErrorImageView().setVisibility(0);
                                wxaShareMessagePage.getWidgetPageView().setVisibility(4);
                                wxaShareMessagePage.getErrorImageView().setImageResource(R.raw.dynamic_page_res_not_found);
                                AppMethodBeat.o(132740);
                                return;
                            case 4:
                                wxaShareMessagePage.getLoadingView().setVisibility(4);
                                wxaShareMessagePage.getErrorImageView().setVisibility(4);
                                wxaShareMessagePage.getWidgetPageView().setVisibility(0);
                                AppMethodBeat.o(132740);
                                return;
                            default:
                                wxaShareMessagePage.getLoadingView().dKT();
                                wxaShareMessagePage.getLoadingView().setVisibility(4);
                                wxaShareMessagePage.getErrorImageView().setVisibility(0);
                                wxaShareMessagePage.getWidgetPageView().setVisibility(4);
                                wxaShareMessagePage.getErrorImageView().setImageResource(R.raw.app_brand_share_page_cover_default);
                                AppMethodBeat.o(132740);
                                return;
                        }
                    }
                }));
                a(bVar, 0);
            } else {
                Bitmap decodeByteArray;
                wxaShareMessagePage.getWidgetPageView().setVisibility(4);
                wxaShareMessagePage.getCoverImageView().setVisibility(0);
                byte[] byteArray = bundle.getByteArray(ImagesContract.IMAGE_DATA);
                if (byteArray != null && byteArray.length > 0) {
                    decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    if (!(decodeByteArray == null || decodeByteArray.isRecycled())) {
                        wxaShareMessagePage.setImageData(decodeByteArray);
                        a(bVar, 0);
                        AppMethodBeat.o(132746);
                        return true;
                    }
                }
                String string = bundle.getString("delay_load_img_path");
                if (bo.isNullOrNil(string)) {
                    String string2 = bundle.getString(MessengerShareContentUtility.IMAGE_URL);
                    if (string2 == null || !(string2.startsWith("http://") || string2.startsWith("https://"))) {
                        if (string2 != null && string2.startsWith("file://")) {
                            decodeByteArray = com.tencent.mm.modelappbrand.a.b.abR().a(string2, null);
                            if (!(decodeByteArray == null || decodeByteArray.isRecycled())) {
                                wxaShareMessagePage.setImageData(decodeByteArray);
                                a(bVar, 0);
                                AppMethodBeat.o(132746);
                                return true;
                            }
                        }
                        wxaShareMessagePage.mr();
                        a(bVar, 1);
                    } else {
                        wxaShareMessagePage.setOnLoadImageResult(bVar);
                        wxaShareMessagePage.setImageUrl(string2);
                    }
                } else {
                    decodeByteArray = null;
                    if (!string.startsWith("delayLoadFile://")) {
                        decodeByteArray = com.tencent.mm.modelappbrand.a.b.abR().a(string, null);
                        ab.i("MicroMsg.WxaShareMessageService", "findCachedLocal(%s)", string);
                    } else if (this.iDO.containsKey(Integer.valueOf(2))) {
                        decodeByteArray = d.aml(string.replace("delayLoadFile://", ""));
                        ab.i("MicroMsg.WxaShareMessageService", "getBitmapNative(%s)", string);
                    }
                    if (decodeByteArray != null) {
                        if (decodeByteArray.isRecycled()) {
                            wxaShareMessagePage.setOnLoadImageResult(bVar);
                            wxaShareMessagePage.setImageUrl(string);
                        } else {
                            wxaShareMessagePage.setImageData(decodeByteArray);
                            a(bVar, 0);
                        }
                        AppMethodBeat.o(132746);
                        return true;
                    }
                    ab.i("MicroMsg.WxaShareMessageService", "delay loadImage(%s)", string);
                    wxaShareMessagePage.getLoadingView().setVisibility(0);
                    wxaShareMessagePage.getErrorImageView().setVisibility(4);
                    wxaShareMessagePage.getCoverImageView().setVisibility(4);
                    wxaShareMessagePage.getLoadingView().dKS();
                    a(2, new a() {
                        public final void C(final Bundle bundle) {
                            AppMethodBeat.i(132742);
                            com.tencent.mm.ce.a.q(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(132741);
                                    wxaShareMessagePage.setImageUrl(bundle.getString("delay_load_img_path"));
                                    ab.i("MicroMsg.WxaShareMessageService", "onLoadImageFinishedAction(%s)", r0);
                                    a.a(bVar);
                                    AppMethodBeat.o(132741);
                                }
                            });
                            AppMethodBeat.o(132742);
                        }
                    });
                }
            }
            AppMethodBeat.o(132746);
            return true;
        }
        AppMethodBeat.o(132746);
        return false;
    }

    private static void a(b bVar, int i) {
        AppMethodBeat.i(132747);
        if (bVar != null) {
            bVar.kQ(i);
        }
        AppMethodBeat.o(132747);
    }

    public final void a(String str, View view) {
        AppMethodBeat.i(132748);
        Assert.assertNotNull(view);
        if (view instanceof WxaShareMessagePage) {
            ab.i("MicroMsg.WxaShareMessageService", "onUnbindView(%s, %s)", str, Integer.valueOf(view.hashCode()));
            ((com.tencent.mm.modelappbrand.e) g.K(com.tencent.mm.modelappbrand.e.class)).a(str, ((WxaShareMessagePage) view).getWidgetPageView());
            this.iDN.remove(Integer.valueOf(2));
            AppMethodBeat.o(132748);
            return;
        }
        AppMethodBeat.o(132748);
    }

    public final synchronized void d(int i, Bundle bundle) {
        AppMethodBeat.i(132749);
        a aVar = (a) this.iDN.get(Integer.valueOf(i));
        if (aVar != null) {
            aVar.C(bundle);
        }
        this.iDO.put(Integer.valueOf(i), bundle);
        ab.i("MicroMsg.WxaShareMessageService", "onAction(%d, %s)", Integer.valueOf(i), bundle);
        AppMethodBeat.o(132749);
    }

    public final e cq(int i, int i2) {
        AppMethodBeat.i(132750);
        e a = a(i, i2, com.tencent.mm.modelappbrand.i.a.DECODE_TYPE_DEFAULT);
        AppMethodBeat.o(132750);
        return a;
    }

    /* JADX WARNING: Missing block: B:3:0x002e, code skipped:
            if (r1 == null) goto L_0x0030;
     */
    /* JADX WARNING: Missing block: B:9:0x0041, code skipped:
            if (r1 == null) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final e a(int i, int i2, com.tencent.mm.modelappbrand.i.a aVar) {
        e eVar;
        AppMethodBeat.i(132751);
        String format = String.format("%d-%d-dp", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        SoftReference softReference = (SoftReference) this.iDL.get(format);
        if (softReference != null) {
            eVar = (e) softReference.get();
        }
        synchronized (this) {
            try {
                softReference = (SoftReference) this.iDL.get(format);
                if (softReference != null) {
                    eVar = (e) softReference.get();
                }
                com.tencent.mm.plugin.appbrand.share.a aVar2 = new com.tencent.mm.plugin.appbrand.share.a(com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), i), com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), i2));
                aVar2.iDJ = aVar;
                this.iDL.put(format, new SoftReference(aVar2));
                eVar = aVar2;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(132751);
                }
            }
        }
        AppMethodBeat.o(132751);
        return eVar;
    }

    /* JADX WARNING: Missing block: B:3:0x0032, code skipped:
            if (r0 == null) goto L_0x0034;
     */
    /* JADX WARNING: Missing block: B:9:0x0045, code skipped:
            if (r0 == null) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final f abB() {
        f fVar;
        AppMethodBeat.i(132752);
        String format = String.format("%d-%d-dp", new Object[]{Integer.valueOf(112), Integer.valueOf(90)});
        SoftReference softReference = (SoftReference) this.iDM.get(format);
        if (softReference != null) {
            fVar = (f) softReference.get();
        }
        synchronized (this) {
            try {
                softReference = (SoftReference) this.iDM.get(format);
                if (softReference != null) {
                    fVar = (f) softReference.get();
                }
                fVar = new com.tencent.mm.plugin.appbrand.share.b(com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 112), com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 90));
                this.iDM.put(format, new SoftReference(fVar));
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(132752);
                }
            }
        }
        AppMethodBeat.o(132752);
        return fVar;
    }

    private void a(int i, a aVar) {
        AppMethodBeat.i(132753);
        this.iDN.put(Integer.valueOf(i), aVar);
        if (this.iDO.containsKey(Integer.valueOf(i))) {
            aVar.C((Bundle) this.iDO.get(Integer.valueOf(i)));
        }
        AppMethodBeat.o(132753);
    }
}
