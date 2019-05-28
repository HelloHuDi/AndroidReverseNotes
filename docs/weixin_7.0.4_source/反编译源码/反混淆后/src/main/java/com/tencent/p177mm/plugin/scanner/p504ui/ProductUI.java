package com.tencent.p177mm.plugin.scanner.p504ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C37494a.C374957;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p198aw.C9059f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C9306cg;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.platformtools.C9791v;
import com.tencent.p177mm.platformtools.C9791v.C9792b;
import com.tencent.p177mm.platformtools.C9791v.C9793a;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.scanner.C28892c;
import com.tencent.p177mm.plugin.scanner.C43488e;
import com.tencent.p177mm.plugin.scanner.history.p503a.C3755a;
import com.tencent.p177mm.plugin.scanner.p504ui.C39634e.C13153a;
import com.tencent.p177mm.plugin.scanner.p504ui.MusicPreference.C28903a;
import com.tencent.p177mm.plugin.scanner.p504ui.ProductScrollView.C13135a;
import com.tencent.p177mm.plugin.scanner.p740a.C21677c;
import com.tencent.p177mm.plugin.scanner.p740a.C21678d;
import com.tencent.p177mm.plugin.scanner.p740a.C28889l;
import com.tencent.p177mm.plugin.scanner.p740a.C43482a;
import com.tencent.p177mm.plugin.scanner.p740a.C43482a.C34833a;
import com.tencent.p177mm.plugin.scanner.p740a.C43485i;
import com.tencent.p177mm.plugin.scanner.p740a.C43486j;
import com.tencent.p177mm.plugin.scanner.util.C28919i;
import com.tencent.p177mm.plugin.scanner.util.C43494o;
import com.tencent.p177mm.plugin.scanner.util.C43494o.C13185a;
import com.tencent.p177mm.plugin.scanner.util.C43498q;
import com.tencent.p177mm.protocal.protobuf.C30197ko;
import com.tencent.p177mm.protocal.protobuf.C30198kq;
import com.tencent.p177mm.protocal.protobuf.abe;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.scanner.ui.ProductUI */
public class ProductUI extends MMPreference implements C1202f, C18765a {
    private long cvx;
    private C26443d ecr;
    private C42206a ecy = new C447601();
    protected ProgressDialog ehJ = null;
    protected C15541f ehK;
    private boolean fwx = false;
    private int gOW;
    private TextView gne;
    private TextView gsS;
    private C4884c hAA = new C216975();
    private String kWz;
    private long mStartTime;
    private boolean nPX;
    private List<MusicPreference> oMb;
    private ImageView qcU;
    private ImageView qcV;
    private View qcW;
    private TextView qcX;
    private ImageView qcY;
    private View qcZ;
    private LinearLayout qda;
    private ImageView qdb;
    private C13185a qdc;
    private View qdd;
    private int qde = 0;
    private int qdf;
    private C21700a qdg;
    private boolean qdh = false;
    private HashMap<String, Boolean> qdi;
    private C13153a qdj;
    private String qdk;
    private boolean qdl = false;
    private String qdm;
    private boolean qdn = false;
    private boolean qdo = false;
    private boolean qdp = false;
    private C3755a qdq;
    private C1837a qdr = new C461849();
    private C28903a qds = new C216964();
    private boolean qdt = true;

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductUI$11 */
    class C1685011 implements C13153a {
        C1685011() {
        }

        /* renamed from: a */
        public final void mo25179a(String str, Boolean bool) {
            AppMethodBeat.m2504i(81092);
            if (str != null && str.length() > 0) {
                ProductUI.this.qdi.put(str, bool);
            }
            AppMethodBeat.m2505o(81092);
        }

        /* renamed from: Wg */
        public final Boolean mo25178Wg(String str) {
            AppMethodBeat.m2504i(81093);
            if (str == null || str.length() <= 0) {
                AppMethodBeat.m2505o(81093);
                return null;
            }
            Boolean bool = (Boolean) ProductUI.this.qdi.get(str);
            AppMethodBeat.m2505o(81093);
            return bool;
        }

        public final void chl() {
            AppMethodBeat.m2504i(81094);
            if (ProductUI.this.ehK != null) {
                ProductUI.this.ehK.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(81094);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductUI$13 */
    class C2169513 implements OnClickListener {
        C2169513() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(81096);
            ProductUI.m89423l(ProductUI.this);
            AppMethodBeat.m2505o(81096);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductUI$4 */
    class C216964 implements C28903a {
        C216964() {
        }

        /* renamed from: d */
        public final void mo37172d(MusicPreference musicPreference) {
            AppMethodBeat.m2504i(81082);
            if (musicPreference == null) {
                C4990ab.m7412e("MicroMsg.scanner.ProductUI", "onMusicPrefClick, musicPref == null");
                AppMethodBeat.m2505o(81082);
            } else if (C5046bo.isNullOrNil(musicPreference.pZl) && C5046bo.isNullOrNil(musicPreference.pZm)) {
                C4990ab.m7420w("MicroMsg.scanner.ProductUI", "wifiurl = null,  wapurl = null");
                if (!C5046bo.isNullOrNil(musicPreference.pZn)) {
                    ProductUI.m89407a(ProductUI.this, musicPreference.pZn);
                }
                AppMethodBeat.m2505o(81082);
            } else {
                if (ProductUI.m89403Wm(String.format("%s_cd_%s", new Object[]{musicPreference.pZl, musicPreference.mKey}))) {
                    C37494a.aic();
                    C4990ab.m7411d("MicroMsg.scanner.ProductUI", "isTheSameId, playMusicId : [%s]", r1);
                } else if (musicPreference.getTitle() == null) {
                    C4990ab.m7412e("MicroMsg.scanner.ProductUI", "onPlayBtnClick, getTitle() == null");
                    AppMethodBeat.m2505o(81082);
                    return;
                } else {
                    String str;
                    int i = -1;
                    if (ProductUI.this.qdg == null) {
                        str = null;
                    } else {
                        str = ProductUI.this.qdg.anJ();
                    }
                    String format = String.format("%s_cd_%s", new Object[]{musicPreference.pZl, musicPreference.mKey});
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    for (MusicPreference musicPreference2 : ProductUI.this.oMb) {
                        int i3;
                        String format2 = String.format("%s_cd_%s", new Object[]{musicPreference2.pZl, musicPreference2.mKey});
                        if (format.equals(format2)) {
                            i3 = i2;
                        } else {
                            i3 = i;
                        }
                        ArrayList arrayList2 = arrayList;
                        arrayList2.add(C9059f.m16431a(5, str, musicPreference2.getTitle().toString(), "", musicPreference2.pZn, musicPreference2.pZm, musicPreference2.pZl, format2, C1720g.m3536RP().eJM, str, "", "wx482a4001c37e2b74"));
                        i2++;
                        i = i3;
                    }
                    if (i < 0) {
                        AppMethodBeat.m2505o(81082);
                        return;
                    }
                    C5004al.m7441d(new C374957(arrayList, i));
                }
                ProductUI.m89430q(ProductUI.this);
                AppMethodBeat.m2505o(81082);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductUI$5 */
    class C216975 extends C4884c<C37752ke> {
        C216975() {
            AppMethodBeat.m2504i(81083);
            this.xxI = C37752ke.class.getName().hashCode();
            AppMethodBeat.m2505o(81083);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(81084);
            switch (((C37752ke) c4883b).cFH.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 7:
                    if (ProductUI.this.ehK != null) {
                        ProductUI.m89430q(ProductUI.this);
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(81084);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductUI$6 */
    class C216996 implements C30382d {

        /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductUI$6$1 */
        class C216981 implements C30382d {
            C216981() {
            }

            /* renamed from: bV */
            public final void mo4975bV(int i, int i2) {
                AppMethodBeat.m2504i(81085);
                switch (i2) {
                    case -1:
                        C9306cg c9306cg = new C9306cg();
                        c9306cg.cvt.cvv = ProductUI.this.getIntent().getLongExtra("key_favorite_local_id", -1);
                        C4879a.xxA.mo10055m(c9306cg);
                        C4990ab.m7411d("MicroMsg.scanner.ProductUI", "do del fav product, local id %d, result %B", Long.valueOf(c9306cg.cvt.cvv), Boolean.valueOf(c9306cg.cvu.cvi));
                        if (c9306cg.cvu.cvi) {
                            ProductUI.this.finish();
                            AppMethodBeat.m2505o(81085);
                            return;
                        }
                        break;
                    default:
                        C4990ab.m7410d("MicroMsg.scanner.ProductUI", "do del cancel");
                        break;
                }
                AppMethodBeat.m2505o(81085);
            }
        }

        C216996() {
        }

        /* renamed from: bV */
        public final void mo4975bV(int i, int i2) {
            AppMethodBeat.m2504i(81086);
            if (ProductUI.this.qdc == null) {
                AppMethodBeat.m2505o(81086);
                return;
            }
            Intent intent;
            switch (i2) {
                case -1:
                    C30379h.m48419a(ProductUI.this.mController.ylL, ProductUI.this.mController.ylL.getString(C25738R.string.f9089p5), null, null, ProductUI.this.mController.ylL.getString(C25738R.string.f9088p4), new C216981());
                    AppMethodBeat.m2505o(81086);
                    return;
                case 0:
                    C7060h.pYm.mo8381e(11446, ProductUI.this.qdc.field_productid, Integer.valueOf(2));
                    if (ProductUI.this.gOW == 3) {
                        C27968h.m44531j(ProductUI.this.getIntent().getLongExtra("key_favorite_local_id", -1), 1, 0);
                        C7060h.pYm.mo8381e(10651, Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0));
                    }
                    intent = new Intent();
                    intent.putExtra("KContentObjDesc", ProductUI.this.qdc.field_subtitle);
                    intent.putExtra("Ksnsupload_title", ProductUI.this.qdc.field_title);
                    intent.putExtra("Ksnsupload_link", ProductUI.this.qdc.field_shareurl);
                    intent.putExtra("Ksnsupload_appname", C43494o.m77709T(ProductUI.this, ProductUI.this.qdc.field_type));
                    intent.putExtra("Ksnsupload_appid", C43486j.m77689BT(ProductUI.this.qdc.field_functionType));
                    intent.putExtra("Ksnsupload_imgurl", ProductUI.this.qdc.field_thumburl);
                    C4990ab.m7416i("MicroMsg.scanner.ProductUI", "product.field_thumburl : " + ProductUI.this.qdc.field_thumburl);
                    if (ProductUI.this.qdg != null) {
                        intent.putExtra("KsnsUpload_imgPath", ProductUI.this.qdg.anJ());
                    } else {
                        C4990ab.m7412e("MicroMsg.scanner.ProductUI", "imgGetStrategy is null");
                    }
                    intent.putExtra("Ksnsupload_type", 3);
                    intent.putExtra("KUploadProduct_UserData", C43494o.m77715c(ProductUI.this.qdc));
                    intent.putExtra("KUploadProduct_subType", ProductUI.this.qdc.field_type);
                    String nW = C37922v.m64078nW("scan_product");
                    C37922v.m64076Zp().mo60676y(nW, true).mo53356j("prePublishId", "scan_product");
                    intent.putExtra("reportSessionId", nW);
                    C25985d.m41467b(ProductUI.this, "sns", ".ui.SnsUploadUI", intent);
                    AppMethodBeat.m2505o(81086);
                    return;
                case 1:
                    C7060h.pYm.mo8381e(11446, ProductUI.this.qdc.field_productid, Integer.valueOf(1));
                    String a = C43486j.m77690a(ProductUI.this.mController.ylL, ProductUI.this.qdc);
                    Intent intent2 = new Intent();
                    intent2.putExtra("Retr_Msg_content", a);
                    intent2.putExtra("Retr_Msg_Type", 2);
                    if (ProductUI.this.qdg != null) {
                        intent2.putExtra("Retr_Msg_thumb_path", ProductUI.this.qdg.anJ());
                    } else {
                        C4990ab.m7412e("MicroMsg.scanner.ProductUI", "imgGetStrategy is null");
                    }
                    intent2.putExtra("Retr_go_to_chattingUI", false);
                    intent2.putExtra("Retr_show_success_tips", true);
                    C28892c.gkE.mo38926k(intent2, ProductUI.this);
                    if (ProductUI.this.gOW == 3) {
                        C7060h.pYm.mo8381e(10651, Integer.valueOf(10), Integer.valueOf(1), Integer.valueOf(0));
                        AppMethodBeat.m2505o(81086);
                        return;
                    }
                    break;
                case 2:
                    C7060h.pYm.mo8381e(11446, ProductUI.this.qdc.field_productid, Integer.valueOf(3));
                    ProductUI.m89431r(ProductUI.this);
                    AppMethodBeat.m2505o(81086);
                    return;
                case 3:
                    intent = new Intent();
                    intent.putExtra("key_fav_scene", 2);
                    intent.putExtra("key_fav_item_id", ProductUI.this.getIntent().getLongExtra("key_favorite_local_id", -1));
                    C39037b.m66371b(ProductUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                    AppMethodBeat.m2505o(81086);
                    return;
                case 4:
                    intent = new Intent();
                    intent.putExtra("rawUrl", ProductUI.this.qdc.field_exposeurl);
                    C25985d.m41467b(ProductUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                    break;
            }
            AppMethodBeat.m2505o(81086);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductUI$a */
    public static final class C21700a implements C9791v {
        private C13185a qdc;

        public C21700a(C13185a c13185a) {
            this.qdc = c13185a;
        }

        public final String anJ() {
            AppMethodBeat.m2504i(81100);
            String fQ = C43488e.cgy().mo69040fQ(this.qdc.field_thumburl, "@S");
            AppMethodBeat.m2505o(81100);
            return fQ;
        }

        public final String anK() {
            if (this.qdc == null) {
                return "";
            }
            return this.qdc.field_thumburl;
        }

        public final String anL() {
            if (this.qdc == null) {
                return "";
            }
            return this.qdc.field_thumburl;
        }

        public final String getCacheKey() {
            if (this.qdc == null) {
                return "";
            }
            return this.qdc.field_thumburl;
        }

        public final boolean anM() {
            return false;
        }

        public final boolean anN() {
            return false;
        }

        /* renamed from: a */
        public final Bitmap mo9517a(Bitmap bitmap, C9793a c9793a, String str) {
            AppMethodBeat.m2504i(81101);
            if (C9793a.NET == c9793a) {
                try {
                    C5056d.m7625a(bitmap, 100, CompressFormat.PNG, anJ(), false);
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.scanner.ProductUI", e, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(81101);
            return bitmap;
        }

        public final void anP() {
        }

        /* renamed from: V */
        public final void mo9516V(String str, boolean z) {
        }

        /* renamed from: a */
        public final void mo9518a(C9793a c9793a, String str) {
        }

        public final Bitmap anO() {
            AppMethodBeat.m2504i(81102);
            if (C4996ah.getContext() == null) {
                AppMethodBeat.m2505o(81102);
                return null;
            }
            Bitmap decodeResource = BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.ak_);
            AppMethodBeat.m2505o(81102);
            return decodeResource;
        }

        public final C9792b anI() {
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductUI$12 */
    class C2890612 implements OnClickListener {
        C2890612() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(81095);
            ProductUI.m89423l(ProductUI.this);
            AppMethodBeat.m2505o(81095);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductUI$14 */
    class C2890714 implements OnClickListener {
        C2890714() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(81097);
            if (!(ProductUI.this.qdc == null || C5046bo.isNullOrNil(ProductUI.this.qdc.field_certificationurl))) {
                ProductUI.m89405a(ProductUI.this, 10002, ProductUI.this.qdc.field_certificationurl);
                ProductUI.m89407a(ProductUI.this, ProductUI.this.qdc.field_certificationurl);
            }
            AppMethodBeat.m2505o(81097);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductUI$b */
    final class C28909b {
        int acV;
        ProductScrollView qdA = ((ProductScrollView) ProductUI.this.findViewById(2131826575));
        boolean qdB;
        private C13135a qdC = new C289101();

        /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductUI$b$1 */
        class C289101 implements C13135a {
            C289101() {
            }

            public final void bpT() {
                float f;
                float f2 = 1.0f;
                AppMethodBeat.m2504i(81103);
                C28909b c28909b = C28909b.this;
                int scrollY = c28909b.qdA.getScrollY();
                if (scrollY < 0) {
                    f = -1.0f;
                } else if (scrollY >= ProductUI.this.qdf - c28909b.acV || ((float) ProductUI.this.qdf) == 0.0f) {
                    f = 1.0f;
                } else {
                    f = (((float) scrollY) * 1.37f) / ((float) ProductUI.this.qdf);
                }
                C4990ab.m7418v("MicroMsg.ProductUI.HeaderEffectHelper", "rate=".concat(String.valueOf(f)));
                if (f == 1.0f) {
                    if (!c28909b.qdB) {
                        c28909b.qdB = true;
                    }
                    AppMethodBeat.m2505o(81103);
                }
                c28909b.qdB = false;
                if (ProductUI.this.qda != null) {
                    float f3 = (1.0f - f) - 0.2f;
                    if (f3 <= 0.0f) {
                        f3 = 0.0f;
                    }
                    if (f == 0.0f) {
                        f3 = 1.0f;
                    }
                    ProductUI.m89429p(ProductUI.this.qda, f3);
                }
                if (ProductUI.this.qdd != null) {
                    if (f == 0.0f) {
                        f2 = 0.0f;
                    } else if (f >= 0.0f) {
                        f += 0.2f;
                        if (f <= 1.0f) {
                            f2 = f;
                        }
                    }
                    ProductUI.m89429p(ProductUI.this.qdd, f2);
                }
                AppMethodBeat.m2505o(81103);
            }
        }

        public C28909b() {
            AppMethodBeat.m2504i(81104);
            this.qdA.setOnScrollListener(this.qdC);
            this.acV = ProductUI.m89437w(ProductUI.this);
            AppMethodBeat.m2505o(81104);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductUI$10 */
    class C4349010 implements OnMenuItemClickListener {
        C4349010() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(81091);
            if (ProductUI.this.gOW == 4) {
                ProductUI.this.setResult(0);
            }
            ProductUI.this.finish();
            AppMethodBeat.m2505o(81091);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductUI$2 */
    class C434912 implements OnMenuItemClickListener {
        C434912() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(81080);
            ProductUI.m89425n(ProductUI.this);
            AppMethodBeat.m2505o(81080);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductUI$1 */
    class C447601 implements C42206a {

        /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductUI$1$1 */
        class C289051 implements DialogInterface.OnClickListener {
            C289051() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(81078);
                C26443d.m42103bX(ProductUI.this);
                AppMethodBeat.m2505o(81078);
            }
        }

        C447601() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(81079);
            if (z) {
                C4990ab.m7416i("MicroMsg.scanner.ProductUI", "getLocation suc");
                if (ProductUI.this.qdc != null) {
                    C4990ab.m7416i("MicroMsg.scanner.ProductUI", "do getActionInfoScene, lng=" + f + ", lat=" + f2);
                    C1720g.m3540Rg().mo14541a(new C21677c(ProductUI.this.kWz, C28889l.m45905cU(ProductUI.this.qdc.qiL), ProductUI.this.gOW, ProductUI.this.qdk, (double) f, (double) f2), 0);
                }
                if (ProductUI.this.ecr != null) {
                    ProductUI.this.ecr.mo44208c(ProductUI.this.ecy);
                }
                if (!ProductUI.this.fwx) {
                    ProductUI.this.fwx = true;
                    C18698o.m29222a(2011, f, f2, (int) d2);
                }
                AppMethodBeat.m2505o(81079);
                return false;
            }
            if (!(ProductUI.this.nPX || C26443d.agA())) {
                ProductUI.this.nPX = true;
                C30379h.m48445a(ProductUI.this, ProductUI.this.getString(C25738R.string.c9z), ProductUI.this.getString(C25738R.string.f9238tz), ProductUI.this.getString(C25738R.string.ckr), ProductUI.this.getString(C25738R.string.f9076or), false, new C289051(), null);
            }
            C4990ab.m7420w("MicroMsg.scanner.ProductUI", "getLocation fail");
            AppMethodBeat.m2505o(81079);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductUI$9 */
    class C461849 implements C1837a {

        /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductUI$9$1 */
        class C131361 implements Runnable {
            C131361() {
            }

            public final void run() {
                AppMethodBeat.m2504i(81089);
                ProductUI.m89406a(ProductUI.this, ProductUI.this.qdc);
                AppMethodBeat.m2505o(81089);
            }
        }

        C461849() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(81090);
            String a = C1946aa.m4148a(c1197a.eAB.vED);
            C4990ab.m7416i("MicroMsg.scanner.ProductUI", "lo-scanner-onRecieveMsg");
            C13185a a2 = ProductUI.this.qdc;
            if (!(a2 == null || C5046bo.isNullOrNil(a))) {
                Map z = C5049br.m7595z(a, "sysmsg");
                a = (String) z.get(".sysmsg.scanproductinfo.product.id");
                if (C5046bo.isNullOrNil(a2.field_productid) || !a2.field_productid.equals(a)) {
                    C4990ab.m7416i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: product id not match, productId=" + C5046bo.nullAsNil(a) + ", target=" + a2.field_productid);
                } else {
                    LinkedList l = C43482a.m77679l(z, ".sysmsg.scanproductinfo.product");
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < l.size(); i++) {
                        LinkedList linkedList = ((C43482a) l.get(i)).fPL;
                        if (linkedList != null) {
                            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                                C34833a c34833a = (C34833a) linkedList.get(i2);
                                if (c34833a != null) {
                                    hashMap.put(c34833a.key, c34833a);
                                }
                            }
                        }
                    }
                    C4990ab.m7416i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: toUpdateSize=" + hashMap.size());
                    C28889l.m45904b(a2.qiL, hashMap);
                }
            }
            C5004al.m7441d(new C131361());
            AppMethodBeat.m2505o(81090);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ProductUI() {
        AppMethodBeat.m2504i(81105);
        AppMethodBeat.m2505o(81105);
    }

    /* renamed from: Wm */
    static /* synthetic */ boolean m89403Wm(String str) {
        AppMethodBeat.m2504i(81137);
        boolean Wi = ProductUI.m89399Wi(str);
        AppMethodBeat.m2505o(81137);
        return Wi;
    }

    /* renamed from: a */
    static /* synthetic */ void m89405a(ProductUI productUI, int i, String str) {
        AppMethodBeat.m2504i(81132);
        productUI.m89412bb(i, str);
        AppMethodBeat.m2505o(81132);
    }

    /* renamed from: m */
    static /* synthetic */ int m89424m(ProductUI productUI) {
        AppMethodBeat.m2504i(81134);
        int aGu = productUI.aGu();
        AppMethodBeat.m2505o(81134);
        return aGu;
    }

    /* renamed from: p */
    static /* synthetic */ void m89429p(View view, float f) {
        AppMethodBeat.m2504i(81142);
        ProductUI.m89427o(view, f);
        AppMethodBeat.m2505o(81142);
    }

    /* renamed from: q */
    static /* synthetic */ void m89430q(ProductUI productUI) {
        AppMethodBeat.m2504i(81138);
        productUI.cho();
        AppMethodBeat.m2505o(81138);
    }

    /* renamed from: t */
    static /* synthetic */ void m89433t(ProductUI productUI) {
        AppMethodBeat.m2504i(81140);
        productUI.chn();
        AppMethodBeat.m2505o(81140);
    }

    public final int getLayoutId() {
        return 2130970380;
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8525b_;
    }

    public final int aWi() {
        return 2130970387;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(81106);
        super.onCreate(bundle);
        this.mStartTime = C5046bo.anT();
        this.gOW = getIntent().getIntExtra("key_ProductUI_getProductInfoScene", 0);
        C18764x.m29328b((C18765a) this);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("scanproductinfo", this.qdr, true);
        initView();
        AppMethodBeat.m2505o(81106);
    }

    public void onResume() {
        AppMethodBeat.m2504i(81107);
        super.onResume();
        C1720g.m3540Rg().mo14539a((int) FilterEnum4Shaka.MIC_WEISHI_BAIXIANG, (C1202f) this);
        C1720g.m3540Rg().mo14539a((int) FilterEnum4Shaka.MIC_WEISHI_HUANGDAN, (C1202f) this);
        AppMethodBeat.m2505o(81107);
    }

    public void onPause() {
        AppMethodBeat.m2504i(81108);
        C1720g.m3540Rg().mo14546b((int) FilterEnum4Shaka.MIC_WEISHI_BAIXIANG, (C1202f) this);
        C1720g.m3540Rg().mo14546b((int) FilterEnum4Shaka.MIC_WEISHI_HUANGDAN, (C1202f) this);
        super.onPause();
        AppMethodBeat.m2505o(81108);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(81109);
        C18764x.m29330c((C18765a) this);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("scanproductinfo", this.qdr, true);
        C4879a.xxA.mo10053d(this.hAA);
        if (this.ecr != null) {
            this.ecr.mo44208c(this.ecy);
        }
        m89412bb(10100, (C5046bo.anT() - this.mStartTime));
        super.onDestroy();
        AppMethodBeat.m2505o(81109);
    }

    public final void initView() {
        AppMethodBeat.m2504i(81110);
        setMMTitle((int) C25738R.string.dyh);
        this.ehK = this.yCw;
        chq();
        setBackBtn(new C4349010());
        this.gne = (TextView) findViewById(2131826592);
        this.qcV = (ImageView) findViewById(2131826584);
        this.qcW = findViewById(2131826585);
        this.qcY = (ImageView) findViewById(2131826594);
        this.qdd = findViewById(2131826577);
        this.qda = (LinearLayout) findViewById(2131826586);
        this.qdb = (ImageView) findViewById(2131826597);
        this.qcZ = findViewById(2131826593);
        ProductUI.m89427o(this.qdd, 0.0f);
        if (C1338a.m2865ga(this.mController.ylL)) {
            this.gne.setTextSize(0, ((float) this.mController.ylL.getResources().getDimensionPixelSize(C25738R.dimen.f9792fr)) * 1.25f);
        } else {
            this.gne.setTextSize(0, (float) C1338a.m2856al(this.mController.ylL, C25738R.dimen.f9792fr));
        }
        this.qcX = (TextView) findViewById(2131826595);
        this.gsS = (TextView) findViewById(2131826576);
        this.qdi = new HashMap();
        this.qdj = new C1685011();
        this.qdq = new C3755a();
        this.qdq.field_ScanTime = System.currentTimeMillis();
        this.qdq.field_scene = this.gOW;
        String stringExtra;
        String Wj;
        if (this.gOW == 5) {
            this.qdn = true;
            stringExtra = getIntent().getStringExtra("key_Qrcode_Url");
            Wj = ProductUI.m89400Wj(stringExtra);
            this.qdq.field_qrcodeUrl = stringExtra;
            this.qdq.field_productId = Wj;
            m89434u(Wj, stringExtra, false);
        } else if (this.gOW == 4) {
            stringExtra = getIntent().getStringExtra("key_product_id");
            Wj = getIntent().getStringExtra("key_Qrcode_Url");
            if (C5046bo.isNullOrNil(stringExtra)) {
                C4990ab.m7412e("MicroMsg.scanner.ProductUI", "jsapi jump finish productId null");
                finish();
                AppMethodBeat.m2505o(81110);
                return;
            }
            m89434u(stringExtra, Wj, false);
        } else {
            this.qdp = getIntent().getBooleanExtra("key_is_from_barcode", false);
            this.qdn = getIntent().getBooleanExtra("key_need_add_to_history", false);
            stringExtra = getIntent().getStringExtra("key_Product_xml");
            if (C5046bo.isNullOrNil(stringExtra)) {
                stringExtra = getIntent().getStringExtra("key_Product_ID");
                if (C5046bo.isNullOrNil(stringExtra)) {
                    C4990ab.m7412e("MicroMsg.scanner.ProductUI", "normal finish productId null");
                    finish();
                    AppMethodBeat.m2505o(81110);
                    return;
                }
                m89434u(stringExtra, null, false);
            } else {
                int intExtra = getIntent().getIntExtra("key_Product_funcType", 0);
                this.qdc = C43486j.m77691cV(stringExtra, intExtra);
                if (this.qdc == null) {
                    C4990ab.m7412e("MicroMsg.scanner.ProductUI", "initView(), product == null");
                    finish();
                    AppMethodBeat.m2505o(81110);
                    return;
                }
                this.kWz = this.qdc.field_productid;
                this.qdk = this.qdc.field_extinfo;
                if (!this.qdn || TextUtils.isEmpty(this.kWz)) {
                    C4990ab.m7416i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.qdn + " mProductId:" + this.kWz);
                } else {
                    this.qdq.field_xmlContent = stringExtra;
                    this.qdq.field_qrcodeUrl = this.qdk;
                    this.qdq.field_productId = this.kWz;
                    this.qdq.field_funcType = intExtra;
                    chs();
                }
                C13185a c13185a = this.qdc;
                getIntent().getBooleanExtra("key_ProductUI_addToDB", true);
                m89408a(c13185a);
                if (intExtra != 0 || C5046bo.isNullOrNil(this.qdc.field_productid)) {
                    chr();
                } else {
                    m89434u(this.qdc.field_productid, this.qdc.field_extinfo, true);
                }
            }
        }
        findViewById(2131826582).setOnClickListener(new C2890612());
        findViewById(2131826596).setOnClickListener(new C2169513());
        this.qcZ.setOnClickListener(new C2890714());
        C28909b c28909b = new C28909b();
        AppMethodBeat.m2505o(81110);
    }

    /* renamed from: a */
    private void m89408a(final C13185a c13185a) {
        AppMethodBeat.m2504i(81112);
        if (c13185a == null) {
            C4990ab.m7412e("MicroMsg.scanner.ProductUI", "refreshViewByProduct(), pd == null");
            finish();
            AppMethodBeat.m2505o(81112);
            return;
        }
        if (!C5046bo.isNullOrNil(c13185a.field_thumburl)) {
            this.qdg = new C21700a(c13185a);
        }
        chm();
        if (C5046bo.isNullOrNil(c13185a.field_introtitle) || C5046bo.isNullOrNil(c13185a.field_introlink)) {
            this.gsS.setVisibility(8);
        } else {
            this.gsS.setText(c13185a.field_introtitle);
            this.gsS.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(81098);
                    ProductUI.m89405a(ProductUI.this, 10003, c13185a.field_introlink);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", c13185a.field_introlink);
                    intent.putExtra("geta8key_scene", ProductUI.m89424m(ProductUI.this));
                    C25985d.m41467b(ProductUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.m2505o(81098);
                }
            });
            this.gsS.setVisibility(0);
        }
        this.qde = this.qdc.field_functionType;
        if (c13185a.field_xmlType == 3) {
            this.gne.setText(c13185a.field_title);
            if (C5046bo.isNullOrNil(c13185a.field_certification)) {
                this.qcX.setText(c13185a.field_source);
                this.qcY.setVisibility(8);
                this.qcZ.setOnClickListener(null);
                this.qcZ.setBackgroundDrawable(null);
                this.qcZ.setFocusable(false);
            } else {
                this.qcX.setText(c13185a.field_certification);
                this.qcY.setVisibility(0);
            }
            if (c13185a.field_type == 1 || c13185a.field_type == 2) {
                this.qcU = (ImageView) findViewById(2131826588);
                findViewById(2131826588).setVisibility(0);
                findViewById(2131826589).setVisibility(8);
            } else {
                this.qcU = (ImageView) findViewById(2131826589);
                findViewById(2131826589).setVisibility(0);
                findViewById(2131826588).setVisibility(8);
            }
            if (!C5046bo.isNullOrNil(c13185a.field_playurl)) {
                ImageView imageView = (ImageView) findViewById(2131826590);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(81099);
                        Intent intent = new Intent("android.intent.action.VIEW");
                        C15429k.m23712a(ProductUI.this.mController.ylL, intent, Uri.parse(c13185a.field_playurl), "video/*");
                        ProductUI.this.startActivity(intent);
                        AppMethodBeat.m2505o(81099);
                    }
                });
            }
            addIconOptionMenu(0, C25738R.drawable.f6899uu, new C434912());
        } else if (c13185a.field_xmlType == 4) {
            this.qcU = (ImageView) findViewById(2131826589);
            findViewById(2131826589).setVisibility(0);
            findViewById(2131826588).setVisibility(8);
            this.qcU.setImageResource(C1318a.scan_without_commodity_icon);
            this.qcU.setBackgroundResource(C1318a.scan_without_commodity_icon);
            this.gne.setText(C25738R.string.dxv);
            this.qcX.setText(null);
        }
        C4990ab.m7418v("MicroMsg.scanner.ProductUI", "start postToMainThread initBodyView");
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(81081);
                ProductUI.m89406a(ProductUI.this, c13185a);
                ProductUI.m89410b(ProductUI.this, c13185a);
                AppMethodBeat.m2505o(81081);
            }
        });
        AppMethodBeat.m2505o(81112);
    }

    private void chn() {
        AppMethodBeat.m2504i(81113);
        this.cvx = getIntent().getLongExtra("key_ProductUI_chatting_msgId", 0);
        if (this.cvx > 0 && C1720g.m3531RK()) {
            C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(this.cvx);
            if (jf.field_msgId > 0) {
                jf.mo14795jv(this.qdg.anJ());
                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(this.cvx, jf);
            }
        }
        AppMethodBeat.m2505o(81113);
    }

    /* renamed from: b */
    private void m89411b(C13185a c13185a) {
        AppMethodBeat.m2504i(81114);
        if (c13185a == null || c13185a.qiL == null || c13185a.qiL.size() == 0 || this.ehK == null) {
            AppMethodBeat.m2505o(81114);
            return;
        }
        this.ehK.removeAll();
        for (int i = 0; i < c13185a.qiL.size(); i++) {
            C43482a c43482a = (C43482a) c13185a.qiL.get(i);
            if (!(c43482a == null || c43482a.fPL == null || c43482a.fPL.size() == 0 || c43482a.pZh == 1 || !c43482a.pZj)) {
                if (i != 0) {
                    Preference preference = new Preference(this);
                    preference.setLayoutResource(2130970378);
                    this.ehK.mo27713b(preference);
                }
                if (!C5046bo.isNullOrNil(c43482a.title) && (c43482a.type == 6 || c43482a.type == 7)) {
                    CategoryWithTitlePreference categoryWithTitlePreference = new CategoryWithTitlePreference(this);
                    categoryWithTitlePreference.setTitle(c43482a.title);
                    this.ehK.mo27713b(categoryWithTitlePreference);
                }
                int i2;
                C34833a c34833a;
                if (c43482a.type == 6) {
                    ArrayList arrayList = new ArrayList();
                    for (i2 = 0; i2 < c43482a.fPL.size(); i2++) {
                        c34833a = (C34833a) c43482a.fPL.get(i2);
                        if (c34833a.type == 10) {
                            arrayList.add(c34833a);
                        }
                    }
                    if (arrayList.size() > 0) {
                        C13155h c13155h = new C13155h(this);
                        c13155h.setKey((i * 100));
                        c13155h.pil = arrayList;
                        this.ehK.mo27713b(c13155h);
                    }
                } else {
                    i2 = 0;
                    while (i2 < c43482a.fPL.size()) {
                        String str = ((i * 100) + i2);
                        c34833a = (C34833a) c43482a.fPL.get(i2);
                        if (c34833a.type == 11) {
                            this.qdl = true;
                            this.qdm = c34833a.name;
                        }
                        if (c34833a.showType != 2) {
                            if (c34833a.showType != 1) {
                                if (c34833a.type == 5) {
                                    MusicPreference musicPreference = new MusicPreference(this);
                                    musicPreference.setKey(str);
                                    musicPreference.setTitle((CharSequence) c34833a.name);
                                    musicPreference.pZl = c34833a.pZl;
                                    musicPreference.pZm = c34833a.pZm;
                                    musicPreference.pZn = c34833a.pZn;
                                    if (ProductUI.m89399Wi(String.format("%s_cd_%s", new Object[]{c34833a.pZl, str}))) {
                                        musicPreference.mo47018kk(true);
                                    } else {
                                        musicPreference.mo47018kk(false);
                                    }
                                    musicPreference.qcA = this.qds;
                                    this.ehK.mo27713b(musicPreference);
                                    C4879a.xxA.mo10052c(this.hAA);
                                    if (this.oMb == null) {
                                        this.oMb = new ArrayList();
                                    }
                                    if (this.qdt) {
                                        this.oMb.add(musicPreference);
                                    }
                                } else if (c34833a.type == 6) {
                                    C39634e c39634e = new C39634e(this);
                                    c39634e.setKey(str);
                                    c39634e.mTitle = c34833a.name;
                                    c39634e.setSummary((CharSequence) c34833a.desc);
                                    this.ehK.mo27713b(c39634e);
                                    c39634e.qcp = this.qdj;
                                } else if (c34833a.type == 12) {
                                    C46919f c46919f = new C46919f(this);
                                    c46919f.setKey(str);
                                    c46919f.kXM = c34833a.thumburl;
                                    c46919f.ehK = this.ehK;
                                    this.ehK.mo27713b(c46919f);
                                } else if (c34833a.type == 2) {
                                    CharSequence charSequence = ProductUI.m89401Wk(c34833a.username) ? c34833a.pZt : c34833a.pZs;
                                    C13150a c13150a = new C13150a(this);
                                    c13150a.setKey(str);
                                    c13150a.setTitle(charSequence);
                                    c13150a.setSummary((CharSequence) c34833a.desc);
                                    c13150a.qaJ = c34833a.fjz;
                                    this.ehK.mo27713b(c13150a);
                                } else if (c34833a.type == 22) {
                                    C46918d c46918d = new C46918d(this);
                                    c46918d.setKey(str);
                                    if (!C5046bo.isNullOrNil(c34833a.nickname)) {
                                        c46918d.kux = c34833a.nickname + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D;
                                    }
                                    c46918d.mXp = c34833a.content;
                                    c46918d.qcd = c34833a.thumburl;
                                    this.ehK.mo27713b(c46918d);
                                } else {
                                    C13150a c13150a2 = new C13150a(this);
                                    c13150a2.setKey(str);
                                    c13150a2.setTitle((CharSequence) c34833a.name);
                                    c13150a2.setSummary((CharSequence) c34833a.desc);
                                    c13150a2.qaJ = c34833a.fjz;
                                    c13150a2.kWC = c34833a.iconUrl;
                                    this.ehK.mo27713b(c13150a2);
                                }
                                if (!(i2 >= c43482a.fPL.size() - 1 || c34833a.type == 12 || ((C34833a) c43482a.fPL.get(i2 + 1)).type == 12 || ((C34833a) c43482a.fPL.get(i2 + 1)).showType == 1 || !ProductUI.m89414c(i2, c43482a.fPL))) {
                                    this.ehK.mo27713b(new C3763g(this));
                                }
                            } else if (!C5046bo.isNullOrNil(c34833a.image)) {
                                C28913b c28913b = new C28913b(this);
                                c28913b.setKey(str);
                                c28913b.kXM = c34833a.image;
                                c28913b.ehK = this.ehK;
                                this.ehK.mo27713b(c28913b);
                            }
                        }
                        i2++;
                    }
                }
            }
        }
        this.ehK.notifyDataSetChanged();
        C4990ab.m7410d("MicroMsg.scanner.ProductUI", "initBodyView finish");
        if (this.oMb != null) {
            this.qdt = false;
        }
        AppMethodBeat.m2505o(81114);
    }

    /* renamed from: c */
    private static boolean m89414c(int i, LinkedList<C34833a> linkedList) {
        AppMethodBeat.m2504i(81115);
        if (linkedList != null) {
            int i2 = i + 1;
            while (true) {
                int i3 = i2;
                if (i3 >= linkedList.size()) {
                    break;
                } else if (((C34833a) linkedList.get(i3)).showType != 2) {
                    AppMethodBeat.m2505o(81115);
                    return true;
                } else {
                    i2 = i3 + 1;
                }
            }
        }
        AppMethodBeat.m2505o(81115);
        return false;
    }

    private void cho() {
        AppMethodBeat.m2504i(81116);
        if (this.qdc == null || this.qdc.qiL == null || this.qdc.qiL.size() == 0 || this.ehK == null) {
            AppMethodBeat.m2505o(81116);
            return;
        }
        for (int i = 0; i < this.qdc.qiL.size(); i++) {
            C43482a c43482a = (C43482a) this.qdc.qiL.get(i);
            if (!(c43482a == null || c43482a.fPL == null || c43482a.fPL.size() == 0)) {
                for (int i2 = 0; i2 < c43482a.fPL.size(); i2++) {
                    if (((C34833a) c43482a.fPL.get(i2)).type == 5) {
                        MusicPreference musicPreference = (MusicPreference) this.ehK.aqO(((i * 100) + i2));
                        if (musicPreference != null) {
                            if (ProductUI.m89399Wi(String.format("%s_cd_%s", new Object[]{r1.pZl, r6}))) {
                                musicPreference.mo47018kk(true);
                            } else {
                                musicPreference.mo47018kk(false);
                            }
                        }
                    }
                }
            }
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(81116);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(81117);
        C4990ab.m7417i("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick item: [%s]", preference.mKey);
        if (this.qdc == null || this.qdc.qiL == null) {
            C4990ab.m7412e("MicroMsg.scanner.ProductUI", "product == null || product.actionlist == null");
            AppMethodBeat.m2505o(81117);
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.mKey).intValue();
            int i = intValue / 100;
            int i2 = intValue % 100;
            C4990ab.m7419v("MicroMsg.scanner.ProductUI", "keyId=[%s], ii=[%s], jj=[%s]", Integer.valueOf(intValue), Integer.valueOf(i), Integer.valueOf(i2));
            if (i < 0 || i >= this.qdc.qiL.size()) {
                C4990ab.m7421w("MicroMsg.scanner.ProductUI", "index out of bounds, ii=[%s], list Size=[%s]", Integer.valueOf(i), Integer.valueOf(this.qdc.qiL.size()));
                AppMethodBeat.m2505o(81117);
                return false;
            }
            C43482a c43482a = (C43482a) this.qdc.qiL.get(i);
            if (c43482a == null) {
                C4990ab.m7420w("MicroMsg.scanner.ProductUI", "actionList == null");
                AppMethodBeat.m2505o(81117);
                return false;
            }
            if (i2 >= 0) {
                if (i2 < c43482a.fPL.size()) {
                    C34833a c34833a = (C34833a) c43482a.fPL.get(i2);
                    if (c34833a == null) {
                        C4990ab.m7420w("MicroMsg.scanner.ProductUI", "action == null");
                        AppMethodBeat.m2505o(81117);
                        return false;
                    }
                    C4990ab.m7417i("MicroMsg.scanner.ProductUI", "action.type = [%s]", Integer.valueOf(c34833a.type));
                    String str = null;
                    Intent intent = new Intent();
                    switch (c34833a.type) {
                        case 1:
                        case 3:
                        case 22:
                            str = c34833a.link;
                            if (!C5046bo.isNullOrNil(c34833a.link)) {
                                m89402Wl(c34833a.link);
                                break;
                            }
                            break;
                        case 2:
                        case 4:
                            str = c34833a.username;
                            if (!C5046bo.isNullOrNil(c34833a.username)) {
                                String str2 = c34833a.username;
                                Intent intent2;
                                if (!ProductUI.m89401Wk(str2)) {
                                    if (!TextUtils.isEmpty(str2)) {
                                        intent2 = new Intent();
                                        intent2.putExtra("Contact_User", str2);
                                        intent2.putExtra("force_get_contact", true);
                                        intent2.putExtra("Contact_Scene", chp());
                                        C28892c.gkE.mo38912c(intent2, this);
                                        break;
                                    }
                                    C4990ab.m7418v("MicroMsg.scanner.ProductUI", "username is null");
                                    break;
                                }
                                intent2 = new Intent();
                                intent2.putExtra("Chat_User", str2);
                                intent2.putExtra("finish_direct", true);
                                intent2.putExtra("add_scene", chp());
                                C28892c.gkE.mo38915d(intent2, this.mController.ylL);
                                break;
                            }
                            break;
                        case 5:
                            str = c34833a.pZn;
                            intent.putExtra("rawUrl", c34833a.pZn);
                            intent.putExtra("geta8key_scene", aGu());
                            C28892c.gkE.mo38924i(intent, this);
                            C37494a.aic();
                            cho();
                            break;
                        case 6:
                        case 7:
                        case 10:
                            break;
                        case 8:
                            str = c34833a.pZp;
                            intent.putExtra("key_card_id", c34833a.pZr);
                            intent.putExtra("key_card_ext", c34833a.pZq);
                            intent.putExtra("key_from_scene", 9);
                            C25985d.m41467b((Context) this, "card", ".ui.CardDetailUI", intent);
                            break;
                        case 9:
                            str = c34833a.pZp;
                            if (!C5046bo.isNullOrNil(c34833a.pZp)) {
                                intent.putExtra("key_product_id", c34833a.pZp);
                                intent.putExtra("key_product_scene", 12);
                                C25985d.m41467b((Context) this, "product", ".ui.MallProductUI", intent);
                                break;
                            }
                            break;
                        case 11:
                            intent.setClass(this, ProductFurtherInfoUI.class);
                            intent.putExtra("key_Product_xml", this.qdc.field_xml);
                            intent.putExtra("key_title", c34833a.name);
                            startActivity(intent);
                            break;
                        case 12:
                            str = c34833a.link;
                            if (!C5046bo.isNullOrNil(c34833a.link)) {
                                m89402Wl(c34833a.link);
                                break;
                            }
                            break;
                        case 21:
                            str = c34833a.pZi;
                            intent.setClass(this, ProductPurchaseAreaUI.class);
                            intent.putExtra("key_Product_xml", this.qdc.field_xml);
                            intent.putExtra("referkey", c34833a.pZi);
                            intent.putExtra("key_Product_funcType", this.qde);
                            startActivity(intent);
                            break;
                        default:
                            C4990ab.m7410d("MicroMsg.scanner.ProductUI", "Default go url:" + c34833a.link);
                            if (!C5046bo.isNullOrNil(c34833a.link)) {
                                m89402Wl(c34833a.link);
                                break;
                            }
                            break;
                    }
                    C1720g.m3540Rg().mo14541a(new C43485i(this.qdc.field_productid, c34833a.pZo, c34833a.type, str, c43482a.fPL.size(), c34833a.showType), 0);
                    AppMethodBeat.m2505o(81117);
                    return true;
                }
            }
            C4990ab.m7421w("MicroMsg.scanner.ProductUI", "index out of bounds, jj=[%s], actions Size=[%s]", Integer.valueOf(i2), Integer.valueOf(c43482a.fPL.size()));
            AppMethodBeat.m2505o(81117);
            return false;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick, [%s]", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.scanner.ProductUI", e, "", new Object[0]);
            AppMethodBeat.m2505o(81117);
            return false;
        }
    }

    /* renamed from: Wi */
    private static boolean m89399Wi(String str) {
        AppMethodBeat.m2504i(81118);
        C9058e aih = C37494a.aih();
        if (aih != null && aih.fJS == 5 && str.equals(aih.fJU) && C37494a.aie()) {
            AppMethodBeat.m2505o(81118);
            return true;
        }
        AppMethodBeat.m2505o(81118);
        return false;
    }

    /* renamed from: bb */
    private void m89412bb(int i, String str) {
        AppMethodBeat.m2504i(81119);
        if (this.qdc == null) {
            AppMethodBeat.m2505o(81119);
            return;
        }
        C1720g.m3540Rg().mo14541a(new C43485i(this.qdc.field_productid, "", i, str, 0, 0), 0);
        AppMethodBeat.m2505o(81119);
    }

    /* renamed from: m */
    public final void mo8136m(final String str, final Bitmap bitmap) {
        AppMethodBeat.m2504i(81120);
        if (!(C5046bo.isNullOrNil(str) || this.qdc == null || bitmap == null || bitmap.isRecycled())) {
            C4990ab.m7410d("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=".concat(String.valueOf(str)));
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(81087);
                    if (str.equals(ProductUI.this.qdc.field_thumburl) && ProductUI.this.qcU != null) {
                        C4990ab.m7416i("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=" + str);
                        try {
                            ProductUI.this.qcU.setImageBitmap(bitmap);
                            ProductUI.this.qcU.setBackgroundDrawable(null);
                            ProductUI.this.qcU.setBackgroundColor(-1);
                            ProductUI.m89433t(ProductUI.this);
                            ProductUI.this.qdh = true;
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.scanner.ProductUI", "onGetPictureFinish : [%s]", e.getLocalizedMessage());
                        }
                    }
                    if (str.equals(ProductUI.this.qdc.field_headerbackgroundurl) && ProductUI.this.qcV != null) {
                        ProductUI.this.qcV.setImageBitmap(bitmap);
                    }
                    AppMethodBeat.m2505o(81087);
                }
            });
        }
        AppMethodBeat.m2505o(81120);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(81121);
        if (c1207m == null) {
            C4990ab.m7420w("MicroMsg.scanner.ProductUI", "scene == null");
            AppMethodBeat.m2505o(81121);
        } else if (c1207m.getType() != FilterEnum4Shaka.MIC_WEISHI_BAIXIANG) {
            if (c1207m.getType() == FilterEnum4Shaka.MIC_WEISHI_HUANGDAN && i == 0 && i2 == 0) {
                LinkedList linkedList = ((C30197ko) ((C21677c) c1207m).ehh.fsH.fsP).vNJ;
                if (this.qdc != null && C28889l.m45904b(this.qdc.qiL, C28889l.m45906cV(linkedList))) {
                    m89411b(this.qdc);
                }
            }
            AppMethodBeat.m2505o(81121);
        } else if (i == 0 && i2 == 0) {
            C30198kq c30198kq;
            C21678d c21678d = (C21678d) c1207m;
            if (c21678d.ehh == null || c21678d.ehh.fsH.fsP == null) {
                c30198kq = null;
            } else {
                c30198kq = (C30198kq) c21678d.ehh.fsH.fsP;
            }
            if (c30198kq == null) {
                C4990ab.m7420w("MicroMsg.scanner.ProductUI", "onSceneEnd productInfo == null");
                AppMethodBeat.m2505o(81121);
                return;
            }
            if (c30198kq.vNK != null) {
                C4990ab.m7410d("MicroMsg.scanner.ProductUI", "onSceneEnd  productInfo.DescXML != null");
                C13185a cV = C43486j.m77691cV(c30198kq.vNK, this.qde);
                if (this.qdc != null && this.qdc.field_xml != null && cV != null && cV.field_xml != null && !this.qdc.field_xml.equals(cV.field_xml)) {
                    this.qdc = cV;
                    m89408a(this.qdc);
                } else if (!(cV == null || cV.field_xml == null)) {
                    this.qdc = cV;
                    m89408a(this.qdc);
                }
                if (this.ehJ != null && this.ehJ.isShowing()) {
                    this.ehJ.dismiss();
                }
                chr();
                if (!this.qdn || this.qdo || TextUtils.isEmpty(this.kWz)) {
                    C4990ab.m7416i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.qdn + " mProductId:" + this.kWz + "  hasAddToHistory:" + this.qdo);
                } else {
                    this.qdq.field_xmlContent = c30198kq.vNK;
                    this.qdq.field_funcType = this.qde;
                    chs();
                    AppMethodBeat.m2505o(81121);
                    return;
                }
            }
            AppMethodBeat.m2505o(81121);
        } else {
            C4990ab.m7413e("MicroMsg.scanner.ProductUI", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(81121);
        }
    }

    /* renamed from: Wj */
    private static String m89400Wj(String str) {
        String str2 = null;
        AppMethodBeat.m2504i(81122);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(81122);
        } else {
            try {
                str2 = Uri.parse(str).getQueryParameter("p");
                AppMethodBeat.m2505o(81122);
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.scanner.ProductUI", str + ";" + e.getLocalizedMessage());
                AppMethodBeat.m2505o(81122);
            }
        }
        return str2;
    }

    /* renamed from: u */
    private void m89434u(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(81123);
        this.kWz = str;
        this.qdk = str2;
        final C1207m c21678d = new C21678d(str, this.gOW, str2);
        C1720g.m3540Rg().mo14541a(c21678d, 0);
        if (!z) {
            AppCompatActivity appCompatActivity = this.mController.ylL;
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48457b(appCompatActivity, getString(C25738R.string.dy4), new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(81088);
                    C4990ab.m7410d("MicroMsg.scanner.ProductUI", "User cancel");
                    C1720g.m3540Rg().mo14547c(c21678d);
                    AppMethodBeat.m2505o(81088);
                }
            });
        }
        AppMethodBeat.m2505o(81123);
    }

    /* renamed from: Wk */
    private static boolean m89401Wk(String str) {
        AppMethodBeat.m2504i(81124);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null || ((int) aoO.ewQ) <= 0 || !C7486a.m12942jh(aoO.field_type)) {
            AppMethodBeat.m2505o(81124);
            return false;
        }
        AppMethodBeat.m2505o(81124);
        return true;
    }

    private int aGu() {
        if (this.qde == 4) {
            return 11;
        }
        if (this.qde == 3) {
            return 12;
        }
        return 0;
    }

    /* renamed from: Wl */
    private void m89402Wl(String str) {
        AppMethodBeat.m2504i(81125);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("jsapi_args_appid", C43486j.m77689BT(this.qde));
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("rawUrl", str);
        intent.putExtra("pay_channel", 3);
        intent.putExtra("geta8key_scene", aGu());
        C25985d.m41467b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(81125);
    }

    private int chp() {
        if (this.qde == 3) {
            return 47;
        }
        return 49;
    }

    @TargetApi(11)
    private void chq() {
        AppMethodBeat.m2504i(81126);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(null);
            getSupportActionBar();
        }
        AppMethodBeat.m2505o(81126);
    }

    private void chr() {
        AppMethodBeat.m2504i(81127);
        if (this.qdc != null) {
            C4990ab.m7416i("MicroMsg.scanner.ProductUI", "doUpdateActionLogic, flag=:" + this.qdc.field_getaction);
            if ((this.qdc.field_getaction & 2) > 0) {
                this.ecr = C26443d.agz();
                if (this.ecr != null) {
                    this.ecr.mo44206b(this.ecy);
                    AppMethodBeat.m2505o(81127);
                    return;
                }
            } else if ((this.qdc.field_getaction & 1) > 0) {
                C1720g.m3540Rg().mo14541a(new C21677c(this.kWz, C28889l.m45905cU(this.qdc.qiL), this.gOW, this.qdk, 0.0d, 0.0d), 0);
            }
        }
        AppMethodBeat.m2505o(81127);
    }

    /* renamed from: o */
    private static void m89427o(View view, float f) {
        AppMethodBeat.m2504i(81128);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f);
        alphaAnimation.setDuration(0);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
        AppMethodBeat.m2505o(81128);
    }

    private void chs() {
        AppMethodBeat.m2504i(81129);
        if (C28919i.cig()) {
            boolean c;
            C3755a c3755a = new C3755a();
            c3755a.field_productId = this.kWz;
            if (C43488e.cgy().cgC().mo10102b((C4925c) c3755a, new String[0])) {
                c = C43488e.cgy().cgC().mo10103c(this.qdq, new String[0]);
            } else {
                c = C43488e.cgy().cgC().mo10101b((C4925c) this.qdq);
            }
            if (c) {
                C4990ab.m7416i("MicroMsg.scanner.ProductUI", "mHistoryItem insert success!");
                this.qdo = true;
                AppMethodBeat.m2505o(81129);
                return;
            }
            C4990ab.m7412e("MicroMsg.scanner.ProductUI", "mHistoryItem insert fail!");
            AppMethodBeat.m2505o(81129);
            return;
        }
        C4990ab.m7412e("MicroMsg.scanner.ProductUI", "mHistoryItem ScanHistoryUtil.shouldShowHistoryList() is false!");
        AppMethodBeat.m2505o(81129);
    }

    private void chm() {
        AppMethodBeat.m2504i(81111);
        this.qdf = this.mController.ylL.getResources().getDimensionPixelSize(C25738R.dimen.a7c);
        if (this.qdc != null && (this.qdc.field_type == 1 || this.qdc.field_type == 2)) {
            this.qdf = this.mController.ylL.getResources().getDimensionPixelSize(C25738R.dimen.a7d);
            LayoutParams layoutParams = this.qcV.getLayoutParams();
            layoutParams.height = this.qdf;
            this.qcV.setLayoutParams(layoutParams);
            layoutParams = this.qcW.getLayoutParams();
            layoutParams.height = this.qdf;
            this.qda.setLayoutParams(layoutParams);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131826583);
            LayoutParams layoutParams2 = relativeLayout.getLayoutParams();
            layoutParams2.height = this.qdf;
            relativeLayout.setLayoutParams(layoutParams2);
            layoutParams = this.qda.getLayoutParams();
            layoutParams.height = this.qdf;
            this.qda.setLayoutParams(layoutParams);
        }
        AppMethodBeat.m2505o(81111);
    }

    /* renamed from: l */
    static /* synthetic */ void m89423l(ProductUI productUI) {
        AppMethodBeat.m2504i(81131);
        if (productUI.qdc != null) {
            if (!C5046bo.isNullOrNil(productUI.qdc.field_detailurl)) {
                productUI.m89412bb(Downloads.MIN_WAIT_FOR_NETWORK, productUI.qdc.field_detailurl);
                productUI.m89402Wl(productUI.qdc.field_detailurl);
                AppMethodBeat.m2505o(81131);
                return;
            } else if (!C5046bo.isNullOrNil(productUI.qdc.field_xml) && productUI.qdl) {
                productUI.m89412bb(10001, "");
                Intent intent = new Intent();
                intent.setClass(productUI, ProductFurtherInfoUI.class);
                intent.putExtra("key_Product_xml", productUI.qdc.field_xml);
                intent.putExtra("key_title", productUI.qdm);
                productUI.startActivity(intent);
            }
        }
        AppMethodBeat.m2505o(81131);
    }

    /* renamed from: n */
    static /* synthetic */ void m89425n(ProductUI productUI) {
        AppMethodBeat.m2504i(81135);
        String str = "";
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(productUI.getString(C25738R.string.g24));
        linkedList2.add(Integer.valueOf(0));
        linkedList.add(productUI.getString(C25738R.string.g23));
        linkedList2.add(Integer.valueOf(1));
        if (!productUI.getIntent().getBooleanExtra("key_is_favorite_item", false)) {
            linkedList.add(productUI.getString(C25738R.string.dcq));
            linkedList2.add(Integer.valueOf(2));
        } else if (productUI.getIntent().getBooleanExtra("key_can_delete_favorite_item", true)) {
            str = productUI.getString(C25738R.string.f9088p4);
            linkedList.add(productUI.getString(C25738R.string.f8718d2));
            linkedList2.add(Integer.valueOf(3));
        } else {
            str = "";
        }
        if (!(productUI.qdc == null || TextUtils.isEmpty(productUI.qdc.field_exposeurl))) {
            linkedList.add(productUI.getString(C25738R.string.avr));
            linkedList2.add(Integer.valueOf(4));
        }
        C30379h.m48420a((Context) productUI, "", linkedList, linkedList2, str, false, new C216996());
        AppMethodBeat.m2505o(81135);
    }

    /* renamed from: b */
    static /* synthetic */ void m89410b(ProductUI productUI, C13185a c13185a) {
        AppMethodBeat.m2504i(81136);
        if (c13185a == null || C5046bo.isNullOrNil(c13185a.field_thumburl)) {
            C4990ab.m7412e("MicroMsg.scanner.ProductUI", "product == null || Util.isNullOrNil(product.field_thumburl)");
            AppMethodBeat.m2505o(81136);
            return;
        }
        try {
            productUI.qcW.setBackgroundColor(Color.parseColor(c13185a.field_headermask));
            if (!C5046bo.isNullOrNil(c13185a.field_headermask) && c13185a.field_headermask.length() == 9) {
                productUI.qdd.setBackgroundColor(Color.parseColor("#" + c13185a.field_headermask.substring(3, 9)));
            }
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.scanner.ProductUI", "parse maskColor wrong");
        }
        C4990ab.m7412e("MicroMsg.scanner.ProductUI", "begin to get the url " + c13185a.field_thumburl);
        Bitmap a = C18764x.m29325a(productUI.qdg);
        if (a != null) {
            productUI.qcU.setImageBitmap(a);
            productUI.qcU.setBackgroundDrawable(null);
            productUI.qcU.setBackgroundColor(-1);
            productUI.qdh = true;
            productUI.chn();
        } else {
            productUI.qcU.setImageBitmap(null);
        }
        if (!C5046bo.isNullOrNil(c13185a.field_headerbackgroundurl)) {
            a = C18764x.m29325a(new C43498q(c13185a.field_headerbackgroundurl));
            if (!(a == null || a.isRecycled())) {
                productUI.qcV.setImageBitmap(a);
            }
        }
        AppMethodBeat.m2505o(81136);
    }

    /* renamed from: r */
    static /* synthetic */ void m89431r(ProductUI productUI) {
        AppMethodBeat.m2504i(81139);
        if (productUI.qdc == null) {
            C4990ab.m7420w("MicroMsg.scanner.ProductUI", "do favorite, but product is null");
            AppMethodBeat.m2505o(81139);
            return;
        }
        C45316cl c45316cl = new C45316cl();
        abf abf = new abf();
        abl abl = new abl();
        abe abe = new abe();
        abl.alD(C1853r.m3846Yz());
        abl.alE(C1853r.m3846Yz());
        abl.mo39126LN(8);
        abl.mo39136ml(C5046bo.anU());
        abl.alJ(C43486j.m77689BT(productUI.qdc.field_functionType));
        abe.alw(productUI.qdc.field_title);
        abe.alx(productUI.qdc.field_subtitle);
        abe.mo27436LK(productUI.qdc.field_type);
        abe.alz(C43494o.m77715c(productUI.qdc));
        abe.aly(productUI.qdc.field_thumburl);
        c45316cl.cvA.title = productUI.qdc.field_title;
        c45316cl.cvA.desc = productUI.qdc.field_subtitle;
        c45316cl.cvA.cvC = abf;
        c45316cl.cvA.type = 10;
        abf.mo74737a(abl);
        abf.mo74744b(abe);
        c45316cl.cvA.cvH = 11;
        c45316cl.cvA.activity = productUI;
        C4879a.xxA.mo10055m(c45316cl);
        AppMethodBeat.m2505o(81139);
    }

    /* renamed from: w */
    static /* synthetic */ int m89437w(ProductUI productUI) {
        AppMethodBeat.m2504i(81141);
        int i = 0;
        TypedValue typedValue = new TypedValue();
        if (productUI.getTheme().resolveAttribute(C25738R.attr.f5618dx, typedValue, true)) {
            i = TypedValue.complexToDimensionPixelSize(typedValue.data, productUI.getResources().getDisplayMetrics());
        }
        AppMethodBeat.m2505o(81141);
        return i;
    }
}
