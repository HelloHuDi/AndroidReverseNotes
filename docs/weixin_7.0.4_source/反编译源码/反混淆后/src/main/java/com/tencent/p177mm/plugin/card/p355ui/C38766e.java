package com.tencent.p177mm.plugin.card.p355ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p230g.p231a.C45315ca;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.C11286b;
import com.tencent.p177mm.plugin.card.model.C33770m;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.model.CardGiftInfo;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import com.tencent.p177mm.plugin.card.p352b.C20123j.C20125b;
import com.tencent.p177mm.plugin.card.p352b.C33753g.C20120a;
import com.tencent.p177mm.plugin.card.p352b.C38728f;
import com.tencent.p177mm.plugin.card.p355ui.p1244a.C20172b;
import com.tencent.p177mm.plugin.card.p355ui.p1244a.C20173c;
import com.tencent.p177mm.plugin.card.p355ui.p1244a.C20174d;
import com.tencent.p177mm.plugin.card.p355ui.p1244a.C27617e;
import com.tencent.p177mm.plugin.card.p355ui.p1244a.C38765f;
import com.tencent.p177mm.plugin.card.p355ui.p1244a.C42867g;
import com.tencent.p177mm.plugin.card.p355ui.p1244a.C44725a;
import com.tencent.p177mm.plugin.card.p355ui.p1244a.C44841h;
import com.tencent.p177mm.plugin.card.p355ui.view.C11357e;
import com.tencent.p177mm.plugin.card.p355ui.view.C11358g;
import com.tencent.p177mm.plugin.card.p355ui.view.C20197m;
import com.tencent.p177mm.plugin.card.p355ui.view.C20200w;
import com.tencent.p177mm.plugin.card.p355ui.view.C27633y;
import com.tencent.p177mm.plugin.card.p355ui.view.C33805d;
import com.tencent.p177mm.plugin.card.p355ui.view.C38777c;
import com.tencent.p177mm.plugin.card.p355ui.view.C38778l;
import com.tencent.p177mm.plugin.card.p355ui.view.C38779z;
import com.tencent.p177mm.plugin.card.p355ui.view.C42868j;
import com.tencent.p177mm.plugin.card.p355ui.view.C42869q;
import com.tencent.p177mm.plugin.card.p355ui.view.C42872u;
import com.tencent.p177mm.plugin.card.p355ui.view.C45800i;
import com.tencent.p177mm.plugin.card.p355ui.view.C46902b;
import com.tencent.p177mm.plugin.card.p355ui.view.C46903k;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C42839c;
import com.tencent.p177mm.plugin.card.p931d.C42840d;
import com.tencent.p177mm.plugin.card.p931d.C42840d.C27574a;
import com.tencent.p177mm.plugin.card.p931d.C45774b;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.p177mm.plugin.card.sharecard.p354ui.CardConsumeCodeUI;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42856b;
import com.tencent.p177mm.plugin.card.widget.C27634g;
import com.tencent.p177mm.plugin.card.widget.C33806c;
import com.tencent.p177mm.plugin.card.widget.C38780d;
import com.tencent.p177mm.plugin.card.widget.C38781f;
import com.tencent.p177mm.plugin.card.widget.C45802e;
import com.tencent.p177mm.plugin.card.widget.C6821b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C23282t.C23281a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.protocal.protobuf.C15320ax;
import com.tencent.p177mm.protocal.protobuf.C15395wy;
import com.tencent.p177mm.protocal.protobuf.C23422od;
import com.tencent.p177mm.protocal.protobuf.C23446tm;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
/* renamed from: com.tencent.mm.plugin.card.ui.e */
public final class C38766e implements C20120a, C33791n, C5186a {
    private final String TAG = "MicroMsg.CardDetailUIContoller";
    boolean cAY = false;
    OnClickListener gKK = new C276204();
    private View jcl;
    C42837b kaS;
    List<C11286b> kaW = new ArrayList();
    ArrayList<C23422od> kaY;
    public int kgP = 0;
    String kgQ = "";
    String kgR = "";
    public ArrayList<String> kgS = new ArrayList();
    public ArrayList<String> kgT = new ArrayList();
    public String kjA = "";
    HashMap<Integer, String> kjB = new HashMap();
    HashMap<String, String> kjC = new HashMap();
    ArrayList<String> kjD = new ArrayList();
    C38770d kjE;
    C20176a kjF;
    private C7306ak kjG = new C276193();
    C4884c kjH = new C201757();
    CardDetailBaseUI kjd;
    C42867g kje;
    C45800i kjf;
    boolean kjg = false;
    C45800i kjh;
    C45800i kji;
    C27634g kjj;
    C11358g kjk;
    C33788m kjl;
    C45800i kjm;
    C45800i kjn;
    C45800i kjo;
    C45800i kjp;
    C45800i kjq;
    C45800i kjr;
    C45800i kjs;
    C45800i kjt;
    C33805d kju;
    C45800i kjv;
    C2777j kjw;
    boolean kjx = true;
    C38728f kjy;
    public String kjz = "";
    /* renamed from: lK */
    LinearLayout f16163lK;
    ListView mListView;

    /* renamed from: com.tencent.mm.plugin.card.ui.e$5 */
    class C113355 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.card.ui.e$5$1 */
        class C113361 implements C30391c {

            /* renamed from: com.tencent.mm.plugin.card.ui.e$5$1$2 */
            class C113372 extends C27574a {
                C113372() {
                }

                public final void aZA() {
                    AppMethodBeat.m2504i(88340);
                    if (C38766e.this.kjE != null) {
                        C38766e.this.kjE.bct();
                    }
                    AppMethodBeat.m2505o(88340);
                }
            }

            /* renamed from: com.tencent.mm.plugin.card.ui.e$5$1$1 */
            class C113381 extends C27574a {
                C113381() {
                }

                public final void aZA() {
                    AppMethodBeat.m2504i(88339);
                    if (C38766e.this.kjE != null) {
                        C38766e.this.kjE.bcq();
                    }
                    AppMethodBeat.m2505o(88339);
                }
            }

            C113361() {
            }

            /* renamed from: iE */
            public final void mo7700iE(int i) {
                AppMethodBeat.m2504i(88341);
                String str = (String) C38766e.this.kjB.get(Integer.valueOf(i));
                if (TextUtils.isEmpty(str)) {
                    AppMethodBeat.m2505o(88341);
                } else if (str.equals("menu_func_share_friend")) {
                    int i2;
                    C5186a c5186a = C38766e.this;
                    C45774b.m84623a(c5186a.kjd, 1, c5186a);
                    c5186a.kjd.ifE = c5186a;
                    C7060h c7060h = C7060h.pYm;
                    Object[] objArr = new Object[9];
                    objArr[0] = "BrandContactView";
                    objArr[1] = Integer.valueOf(C38766e.this.kaS.aZV().iAd);
                    objArr[2] = C38766e.this.kaS.baa();
                    objArr[3] = C38766e.this.kaS.aZZ();
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(C38766e.this.kjF.kgn);
                    objArr[6] = C38766e.this.kjF.kiN;
                    if (C38766e.this.kaS.aZT()) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    objArr[7] = Integer.valueOf(i2);
                    objArr[8] = "";
                    c7060h.mo8381e(11324, objArr);
                    C7060h.pYm.mo8381e(11582, "OperShareFriend", Integer.valueOf(1), Integer.valueOf(C38766e.this.kaS.aZV().iAd), C38766e.this.kaS.baa(), C38766e.this.kaS.aZZ(), C38766e.this.kjz);
                    AppMethodBeat.m2505o(88341);
                } else if (str.equals("menu_func_gift")) {
                    C38766e.m65771b(C38766e.this);
                    AppMethodBeat.m2505o(88341);
                } else if (str.equals("menu_func_delete")) {
                    str = "";
                    if (C38766e.this.kaS.aZD()) {
                        str = C38766e.this.kjd.getString(C25738R.string.adh);
                    }
                    C42840d.m76035a(C38766e.this.kjd, C38766e.this.kjF.kaE, str, new C113381());
                    C7060h.pYm.mo8381e(11582, "OperDelete", Integer.valueOf(1), Integer.valueOf(C38766e.this.kaS.aZV().iAd), C38766e.this.kaS.baa(), C38766e.this.kaS.aZZ(), "");
                    AppMethodBeat.m2505o(88341);
                } else if (str.equals("menu_func_service")) {
                    if (!TextUtils.isEmpty(C38766e.this.kaS.aZV().vTT)) {
                        C45774b.m84631af(C38766e.this.kjd, C38766e.this.kaS.aZV().vTT);
                        C42852am.bbc().mo15082s(C38766e.this.kaS.aZZ(), C38766e.this.kaS.baa(), 1);
                    }
                    C7060h.pYm.mo8381e(11582, "OperService", Integer.valueOf(1), Integer.valueOf(C38766e.this.kaS.aZV().iAd), C38766e.this.kaS.baa(), C38766e.this.kaS.aZZ(), C38766e.this.kjF.kiN);
                    AppMethodBeat.m2505o(88341);
                } else if (str.equals("menu_func_report")) {
                    if (!TextUtils.isEmpty(C38766e.this.kaS.aZW().vSf)) {
                        C45774b.m84627a(C38766e.this.kjd, C38766e.this.kaS.aZW().vSf, C38766e.this.getString(C25738R.string.agm));
                    }
                    C7060h.pYm.mo8381e(11582, "OperReport", Integer.valueOf(1), Integer.valueOf(C38766e.this.kaS.aZV().iAd), C38766e.this.kaS.baa(), C38766e.this.kaS.aZZ(), "");
                    AppMethodBeat.m2505o(88341);
                } else if (str.equals("menu_func_share_timeline")) {
                    C18764x.m29325a(new C33770m(C38766e.this.kaS.aZV().kbV));
                    Context context = C38766e.this.kjd;
                    C42837b c42837b = C38766e.this.kaS;
                    String str2 = C38766e.this.kjF.kaE;
                    String str3 = C38766e.this.kjF.kiP;
                    Intent intent = new Intent();
                    intent.putExtra("Ksnsupload_link", c42837b.aZV().vUc);
                    intent.putExtra("KContentObjDesc", c42837b.aZV().kdg);
                    intent.putExtra("Ksnsupload_title", c42837b.aZV().title);
                    if (TextUtils.isEmpty(str3)) {
                        intent.putExtra("KUploadProduct_UserData", str2 + "#");
                    } else {
                        intent.putExtra("KUploadProduct_UserData", str2 + "#" + str3);
                    }
                    intent.putExtra("Ksnsupload_imgurl", c42837b.aZV().kbV);
                    if (!TextUtils.isEmpty(c42837b.aZV().kbV)) {
                        intent.putExtra("KsnsUpload_imgPath", new C33770m(c42837b.aZV().kbV).anJ());
                    }
                    C4990ab.m7410d("MicroMsg.CardActivityHelper", "doShareTimeLine KSnsUploadImgPath:" + intent.getStringExtra("KsnsUpload_imgPath"));
                    intent.putExtra("src_username", C1853r.m3846Yz());
                    intent.putExtra("src_displayname", C1853r.m3820YB());
                    intent.putExtra("Ksnsupload_appid", c42837b.aZV().csB);
                    intent.putExtra("Ksnsupload_appname", c42837b.aZV().vTT);
                    intent.putExtra("Ksnsupload_type", 7);
                    String nW = C37922v.m64078nW("card_package");
                    C37922v.m64076Zp().mo60676y(nW, true).mo53356j("prePublishId", "card_package");
                    intent.putExtra("reportSessionId", nW);
                    C25985d.m41472c(context, "sns", ".ui.SnsUploadUI", intent);
                    C7060h.pYm.mo8381e(11582, "OperShareTimeLine", Integer.valueOf(1), Integer.valueOf(C38766e.this.kaS.aZV().iAd), C38766e.this.kaS.baa(), C38766e.this.kaS.aZZ(), C38766e.this.kjF.kiN);
                    AppMethodBeat.m2505o(88341);
                } else if (str.equals("menu_func_delete_share_card")) {
                    C42840d.m76035a(C38766e.this.kjd, C38766e.this.kjF.kaE, "", new C113372());
                    AppMethodBeat.m2505o(88341);
                } else {
                    str = (String) C38766e.this.kjC.get(str);
                    if (!C5046bo.isNullOrNil(str)) {
                        C45774b.m84626a(C38766e.this.kjd, str, 0);
                    }
                    AppMethodBeat.m2505o(88341);
                }
            }
        }

        C113355() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88342);
            if (C38766e.this.kaS == null) {
                C4990ab.m7412e("MicroMsg.CardDetailUIContoller", "mCardInfo is null, err");
                AppMethodBeat.m2505o(88342);
                return;
            }
            C7060h.pYm.mo8381e(11582, "CardDetailUiMenu", Integer.valueOf(1), Integer.valueOf(C38766e.this.kaS.aZV().iAd), C38766e.this.kaS.baa(), C38766e.this.kaS.aZZ(), C38766e.this.kjF.kiN);
            C30379h.m48424a(C38766e.this.kjd.mController.ylL, null, (String[]) C38766e.this.kjD.toArray(new String[C38766e.this.kjD.size()]), null, false, new C113361());
            AppMethodBeat.m2505o(88342);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.e$7 */
    class C201757 extends C4884c<C45315ca> {
        C201757() {
            AppMethodBeat.m2504i(88344);
            this.xxI = C45315ca.class.getName().hashCode();
            AppMethodBeat.m2505o(88344);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(88345);
            C45315ca c45315ca = (C45315ca) c4883b;
            if (C1720g.m3531RK()) {
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "deal with card notify event ConsumedCardByOfflinePayEvent");
                if (c45315ca instanceof C45315ca) {
                    if (c45315ca.cvj.bFZ == 0) {
                        C42840d.m76040c(C38766e.this.kjd, C38766e.this.kjd.getResources().getString(C25738R.string.aik));
                    }
                    AppMethodBeat.m2505o(88345);
                    return true;
                }
            }
            AppMethodBeat.m2505o(88345);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.e$a */
    public static class C20176a {
        public int emC = 3;
        public String kaE = "";
        public boolean kcf = false;
        public int kgn = -1;
        public String kiN = "";
        public String kiO = "";
        public String kiP = "";
        public String kir = "";
        public String kis = "";
        public int kjL = 0;
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.e$b */
    public enum C20177b {
        onGetCodeSuccess,
        onShowTimeExpired,
        onReceiveCodeUnavailable,
        onGetCodeFail;

        static {
            AppMethodBeat.m2505o(88348);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.e$3 */
    class C276193 extends C7306ak {
        C276193() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(88337);
            if (message.obj != null && (message.obj instanceof C38769c)) {
                C38769c c38769c = (C38769c) message.obj;
                if (c38769c.kjR == C20177b.onGetCodeFail) {
                    if (C38766e.this.kjk != null) {
                        C42840d.m76036a(C38766e.this.kjd, c38769c.aIm, false);
                        C38766e.this.kjk.bev();
                        AppMethodBeat.m2505o(88337);
                        return;
                    }
                } else if (c38769c.kjR == C20177b.onShowTimeExpired) {
                    if (C38766e.this.kjk != null) {
                        C38766e.this.kjk.mo23067d(C42839c.CARDCODEREFRESHACTION_SHOWING_TIMEOUT);
                        AppMethodBeat.m2505o(88337);
                        return;
                    }
                } else if (C38766e.this.kjk != null) {
                    C38766e.this.kjk.mo23067d(c38769c.kjS);
                }
            }
            AppMethodBeat.m2505o(88337);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.e$4 */
    class C276204 implements OnClickListener {
        C276204() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:69:0x01df  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0188  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x02a2  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x025b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(View view) {
            boolean z = true;
            int i = false;
            AppMethodBeat.m2504i(88338);
            C7060h c7060h;
            Object[] objArr;
            C23446tm c23446tm;
            int i2;
            C23422od c23422od;
            if (view.getId() == 2131821928 || view.getId() == 2131821929) {
                if (C38766e.this.kaS.aZB()) {
                    if (C38766e.this.kjE != null) {
                        C38766e.this.kjE.bcr();
                        AppMethodBeat.m2505o(88338);
                        return;
                    }
                } else if (C38766e.this.kaS.aZC() && C38766e.this.kjE != null) {
                    C38766e.this.kjE.bcp();
                    AppMethodBeat.m2505o(88338);
                    return;
                }
            } else if (view.getId() == 2131824180 || view.getId() == 2131821934) {
                C45774b.m84630ae(C38766e.this.kjd, C38766e.this.kjF.kiN);
                AppMethodBeat.m2505o(88338);
                return;
            } else if (view.getId() == 2131821963 || view.getId() == 2131821956) {
                if (view.getId() == 2131821963) {
                    C38766e.this.kjx = false;
                } else if (view.getId() == 2131821956) {
                    C38766e.this.kjx = true;
                }
                if (C38766e.this.kjk instanceof C42869q) {
                    C38766e.this.kjw.knw = ((C42869q) C38766e.this.kjk).mo23069e(C42839c.CARDCODEREFRESHACTION_DOREFRESH);
                }
                C2777j c2777j = C38766e.this.kjw;
                boolean z2 = C38766e.this.kjx;
                c2777j.bdp();
                c2777j.kjx = z2;
                if (!(c2777j.gKG == null || c2777j.gKG.isShowing())) {
                    c2777j.gKG.showAtLocation(view.getRootView(), 17, 0, 0);
                    c2777j.gKG.setFocusable(true);
                    c2777j.gKG.setTouchable(true);
                    c2777j.gKG.setBackgroundDrawable(new ColorDrawable(16777215));
                    c2777j.gKG.setOutsideTouchable(true);
                    CharSequence charSequence;
                    if (c2777j.kjx) {
                        c2777j.kns.setOnClickListener(c2777j.gKK);
                        Bitmap bitmap = c2777j.kno;
                        if (c2777j.kgb != null) {
                            c2777j.kno = C38736l.m65708J(c2777j.kgb);
                        } else {
                            c2777j.kno = null;
                        }
                        c2777j.kns.setImageBitmap(c2777j.kno);
                        c2777j.knv.add(0, bitmap);
                        c2777j.bds();
                        c2777j.gKI.setVisibility(8);
                        c2777j.knr.setVisibility(0);
                        charSequence = c2777j.kaS.aZW().code;
                        if (c2777j.kaS.aZV().vUB == null || !c2777j.kaS.aZV().vUB.wdu) {
                            if (!C5046bo.isNullOrNil(c2777j.kaS.aZW().vSo)) {
                                charSequence = c2777j.kaS.aZW().vSo;
                            } else if (c2777j.kaS.aZQ()) {
                                if (!C5046bo.isNullOrNil(c2777j.knw)) {
                                    charSequence = c2777j.knw;
                                }
                            }
                            if (!TextUtils.isEmpty(charSequence) || charSequence.length() > 40) {
                                c2777j.knt.setVisibility(8);
                            } else {
                                c2777j.knt.setText(C45778m.m84640Hu(charSequence));
                                if (c2777j.kaS.aZL()) {
                                    c2777j.knt.setVisibility(0);
                                } else {
                                    c2777j.knt.setVisibility(8);
                                }
                            }
                            if (C5046bo.isNullOrNil(c2777j.kaS.aZV().kCx)) {
                                c2777j.knu.setText(c2777j.kaS.aZV().kCx);
                                c2777j.knu.setVisibility(0);
                            } else {
                                c2777j.knu.setVisibility(8);
                            }
                        }
                        charSequence = "";
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        c2777j.knt.setVisibility(8);
                        if (C5046bo.isNullOrNil(c2777j.kaS.aZV().kCx)) {
                        }
                    } else {
                        c2777j.gKH.setOnClickListener(c2777j.gKK);
                        c2777j.gKH.setImageBitmap(c2777j.gKF);
                        charSequence = c2777j.kaS.aZW().code;
                        if (c2777j.kaS.aZV().vUB == null || !c2777j.kaS.aZV().vUB.wdu) {
                            if (!C5046bo.isNullOrNil(c2777j.kaS.aZW().vSo)) {
                                charSequence = c2777j.kaS.aZW().vSo;
                            } else if (c2777j.kaS.aZQ()) {
                                if (!C5046bo.isNullOrNil(c2777j.knw)) {
                                    charSequence = c2777j.knw;
                                }
                            }
                            if (!TextUtils.isEmpty(charSequence) || charSequence.length() > 40) {
                                c2777j.knp.setVisibility(8);
                            } else {
                                c2777j.knp.setText(C45778m.m84640Hu(charSequence));
                                if (c2777j.kaS.aZL()) {
                                    c2777j.knp.setVisibility(0);
                                } else {
                                    c2777j.knp.setVisibility(8);
                                }
                            }
                            if (TextUtils.isEmpty(c2777j.kaS.aZV().kCx)) {
                                c2777j.knq.setText(c2777j.kaS.aZV().kCx);
                                c2777j.knq.setVisibility(0);
                            } else {
                                c2777j.knq.setVisibility(8);
                            }
                            c2777j.gKI.setVisibility(0);
                            c2777j.knr.setVisibility(8);
                        }
                        charSequence = "";
                        if (TextUtils.isEmpty(charSequence)) {
                        }
                        c2777j.knp.setVisibility(8);
                        if (TextUtils.isEmpty(c2777j.kaS.aZV().kCx)) {
                        }
                        c2777j.gKI.setVisibility(0);
                        c2777j.knr.setVisibility(8);
                    }
                    c2777j.gKG.update();
                }
                AppMethodBeat.m2505o(88338);
                return;
            } else if (view.getId() == 2131822332 || view.getId() == 2131822230 || view.getId() == 2131822003 || view.getId() == 2131821958 || view.getId() == 2131822229) {
                if (view.getId() == 2131822332) {
                    if (C38766e.this.kaS.aZC()) {
                        int i3;
                        c7060h = C7060h.pYm;
                        objArr = new Object[9];
                        objArr[0] = "CardConsumedCodeUI";
                        objArr[1] = Integer.valueOf(C38766e.this.kaS.aZV().iAd);
                        objArr[2] = C38766e.this.kaS.baa();
                        objArr[3] = C38766e.this.kaS.aZZ();
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(C38766e.this.kjF.kgn);
                        objArr[6] = C38766e.this.kjF.kiN;
                        if (C38766e.this.kaS.aZT()) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        objArr[7] = Integer.valueOf(i3);
                        objArr[8] = "";
                        c7060h.mo8381e(11324, objArr);
                        if (C38766e.this.kjE != null) {
                            C38766e.this.kjE.mo54319fJ(true);
                            AppMethodBeat.m2505o(88338);
                            return;
                        }
                    }
                    C38766e.this.mo61638a(true, new C20125b(), false);
                    AppMethodBeat.m2505o(88338);
                    return;
                } else if (view.getId() == 2131821958 && C38766e.this.kaS.aZV().vUE) {
                    AppMethodBeat.m2505o(88338);
                    return;
                } else if (!C38766e.this.kaS.aZC()) {
                    C38766e.this.mo61638a(false, new C20125b(), false);
                    AppMethodBeat.m2505o(88338);
                    return;
                } else if (C38766e.this.kjE != null) {
                    C38766e.this.kjE.mo54319fJ(false);
                    AppMethodBeat.m2505o(88338);
                    return;
                }
            } else if (view.getId() == 2131822039) {
                if (!TextUtils.isEmpty(C38766e.this.kaS.aZV().vUi)) {
                    C45774b.m84626a(C38766e.this.kjd, C38766e.this.kaS.aZV().vUi, 3);
                    C7060h.pYm.mo8381e(11941, Integer.valueOf(13), C38766e.this.kaS.aZZ(), C38766e.this.kaS.baa(), "", C38766e.this.kaS.aZV().vUh);
                    AppMethodBeat.m2505o(88338);
                    return;
                }
            } else if (view.getId() == 2131821932) {
                C7060h.pYm.mo8381e(11582, "OpenShareUserSelectView", Integer.valueOf(0), Integer.valueOf(C38766e.this.kaS.aZV().iAd), C38766e.this.kaS.baa(), C38766e.this.kaS.aZZ(), C38766e.this.kjF.kiN);
                Intent intent = new Intent();
                intent.putExtra("KLabel_range_index", C38766e.this.kgP);
                intent.putExtra("Klabel_name_list", C38766e.this.kgQ);
                intent.putExtra("Kother_user_name_list", C38766e.this.kgR);
                intent.putExtra("k_sns_label_ui_title", C38766e.this.kjd.getString(C25738R.string.aha));
                intent.putExtra("k_sns_label_ui_style", 0);
                intent.putExtra("KLabel_is_filter_private", true);
                C25985d.m41468b(C38766e.this.kjd, "sns", ".ui.SnsLabelUI", intent, 2);
                C38766e.this.kjd.ifE = C38766e.this;
                AppMethodBeat.m2505o(88338);
                return;
            } else if (view.getId() == 2131822279) {
                if (C38766e.this.kaS.aZW().vSc != null) {
                    LinkedList linkedList = C38766e.this.kaS.aZW().vSc;
                    int intValue = ((Integer) view.getTag()).intValue();
                    c23446tm = (C23446tm) linkedList.get(intValue);
                    if (C45774b.m84629a(C38766e.this.kaS.aZZ(), c23446tm, C38766e.this.kjF.kgn, C38766e.this.kjF.kjL)) {
                        C7060h.pYm.mo8381e(11941, Integer.valueOf(19), C38766e.this.kaS.aZZ(), C38766e.this.kaS.baa(), "", c23446tm.title);
                        AppMethodBeat.m2505o(88338);
                        return;
                    }
                    if (!(c23446tm == null || TextUtils.isEmpty(c23446tm.url))) {
                        C45774b.m84626a(C38766e.this.kjd, c23446tm.url, 1);
                        C7060h c7060h2 = C7060h.pYm;
                        Object[] objArr2 = new Object[5];
                        switch (intValue) {
                            case 0:
                                i2 = 10;
                                break;
                            case 1:
                                i2 = 11;
                                break;
                            case 2:
                                i2 = 12;
                                break;
                            case 3:
                                i2 = 16;
                                break;
                            default:
                                i2 = 10;
                                break;
                        }
                        objArr2[0] = Integer.valueOf(i2);
                        objArr2[1] = C38766e.this.kaS.aZZ();
                        objArr2[2] = C38766e.this.kaS.baa();
                        objArr2[3] = "";
                        objArr2[4] = c23446tm.title;
                        c7060h2.mo8381e(11941, objArr2);
                        if (C38736l.m65714a(c23446tm, C38766e.this.kaS.aZZ())) {
                            C38736l.m65706Hs(C38766e.this.kaS.aZZ());
                            C45774b.m84633b(C38766e.this.kjd, C38766e.this.kaS.aZV().kdg);
                        }
                    }
                    AppMethodBeat.m2505o(88338);
                    return;
                }
            } else if (view.getId() == 2131822282) {
                if (C38766e.this.kaS.aZW().vSc != null) {
                    c23446tm = (C23446tm) C38766e.this.kaS.aZW().vSc.get(0);
                    if (C45774b.m84629a(C38766e.this.kaS.aZZ(), c23446tm, C38766e.this.kjF.kgn, C38766e.this.kjF.kjL)) {
                        C7060h.pYm.mo8381e(11941, Integer.valueOf(19), C38766e.this.kaS.aZZ(), C38766e.this.kaS.baa(), "", c23446tm.title);
                        AppMethodBeat.m2505o(88338);
                        return;
                    }
                    if (!(c23446tm == null || TextUtils.isEmpty(c23446tm.url))) {
                        C45774b.m84626a(C38766e.this.kjd, c23446tm.url, 1);
                        C7060h.pYm.mo8381e(11941, Integer.valueOf(10), C38766e.this.kaS.aZZ(), C38766e.this.kaS.baa(), "", c23446tm.title);
                        if (C38736l.m65714a(c23446tm, C38766e.this.kaS.aZZ())) {
                            C38736l.m65706Hs(C38766e.this.kaS.aZZ());
                            C45774b.m84633b(C38766e.this.kjd, C38766e.this.kaS.aZV().kdg);
                        }
                    }
                    AppMethodBeat.m2505o(88338);
                    return;
                }
            } else if (view.getId() == 2131822245 || view.getId() == 2131822246) {
                if (C38766e.this.kaS.aZW().vSj != null) {
                    if (C38766e.this.kaS.aZO()) {
                        if (!C38766e.this.kaS.aZC()) {
                            C38766e.this.mo61638a(false, new C20125b(), false);
                            AppMethodBeat.m2505o(88338);
                            return;
                        } else if (C38766e.this.kjE != null) {
                            C38766e.this.kjE.mo54319fJ(false);
                            AppMethodBeat.m2505o(88338);
                            return;
                        }
                    } else if (C38766e.this.kaS.aZP()) {
                        C20125b c20125b = new C20125b();
                        C45774b.m84624a(C38766e.this.kjd, c20125b.kbK, c20125b.kbL, false, C38766e.this.kaS);
                        AppMethodBeat.m2505o(88338);
                        return;
                    } else {
                        c23446tm = C38766e.this.kaS.aZW().vSj;
                        if (C45774b.m84629a(C38766e.this.kaS.aZZ(), c23446tm, C38766e.this.kjF.kgn, C38766e.this.kjF.kjL)) {
                            C7060h.pYm.mo8381e(11941, Integer.valueOf(20), C38766e.this.kaS.aZZ(), C38766e.this.kaS.baa(), "", c23446tm.title);
                            AppMethodBeat.m2505o(88338);
                            return;
                        }
                        if (!(c23446tm == null || TextUtils.isEmpty(c23446tm.url))) {
                            C45774b.m84626a(C38766e.this.kjd, C38736l.m65699A(c23446tm.url, c23446tm.vUW), 1);
                            C7060h.pYm.mo8381e(11941, Integer.valueOf(9), C38766e.this.kaS.aZZ(), C38766e.this.kaS.baa(), "", c23446tm.title);
                            if (C38736l.m65714a(c23446tm, C38766e.this.kaS.aZZ())) {
                                C38736l.m65706Hs(C38766e.this.kaS.aZZ());
                                C45774b.m84633b(C38766e.this.kjd, C38766e.this.kaS.aZV().kdg);
                            }
                        }
                        AppMethodBeat.m2505o(88338);
                        return;
                    }
                }
            } else if (view.getId() == 2131822030 || view.getId() == 2131822023) {
                C15395wy c15395wy = C38766e.this.kaS.aZV().vUo;
                c7060h = C7060h.pYm;
                objArr = new Object[9];
                objArr[0] = "CardLeftRightIntroduceView";
                objArr[1] = Integer.valueOf(C38766e.this.kaS.aZV().iAd);
                objArr[2] = C38766e.this.kaS.baa();
                objArr[3] = C38766e.this.kaS.aZZ();
                objArr[4] = Integer.valueOf(0);
                objArr[5] = Integer.valueOf(C38766e.this.kjF.kgn);
                objArr[6] = C38766e.this.kjF.kiN;
                if (C38766e.this.kaS.aZT()) {
                    i = 1;
                }
                objArr[7] = Integer.valueOf(i);
                objArr[8] = "";
                c7060h.mo8381e(11324, objArr);
                if (c15395wy == null || TextUtils.isEmpty(c15395wy.url)) {
                    Intent intent2 = new Intent();
                    if (C38766e.this.kaS instanceof CardInfo) {
                        intent2.putExtra("key_card_info_data", (CardInfo) C38766e.this.kaS);
                    } else if (C38766e.this.kaS instanceof ShareCardInfo) {
                        intent2.putExtra("key_card_info_data", (ShareCardInfo) C38766e.this.kaS);
                    }
                    intent2.setClass(C38766e.this.kjd, CardDetailPreference.class);
                    C38766e.this.kjd.startActivity(intent2);
                    AppMethodBeat.m2505o(88338);
                    return;
                }
                C45774b.m84626a(C38766e.this.kjd, c15395wy.url, 1);
                AppMethodBeat.m2505o(88338);
                return;
            } else if (view.getId() == 2131822302) {
                if (C42856b.m76073GC(C38766e.this.kaS.baa()) <= 1) {
                    AppMethodBeat.m2505o(88338);
                    return;
                }
                C38766e c38766e = C38766e.this;
                if (C38766e.this.kjg) {
                    z = false;
                }
                c38766e.kjg = z;
                C38766e.this.bbB();
                AppMethodBeat.m2505o(88338);
                return;
            } else if (view.getId() == 2131822026) {
                if (!(C38766e.this.kaS.aZV().vUk == null || TextUtils.isEmpty(C38766e.this.kaS.aZV().vUk.url))) {
                    C45774b.m84626a(C38766e.this.kjd, C38766e.this.kaS.aZV().vUk.url, 3);
                    C7060h.pYm.mo8381e(11941, Integer.valueOf(3), C38766e.this.kaS.aZZ(), C38766e.this.kaS.baa(), "", C38766e.this.kaS.aZV().vUk.text);
                    AppMethodBeat.m2505o(88338);
                    return;
                }
            } else if (view.getId() == 2131821937) {
                if (!(C38766e.this.kaS.aZV().vUr == null || C5046bo.isNullOrNil(C38766e.this.kaS.aZV().vUr.url))) {
                    C45774b.m84626a(C38766e.this.kjd, C38766e.this.kaS.aZV().vUr.url, 1);
                    C7060h.pYm.mo8381e(11941, Integer.valueOf(14), C38766e.this.kaS.aZZ(), C38766e.this.kaS.baa(), "", C38766e.this.kaS.aZV().vUr.text);
                    AppMethodBeat.m2505o(88338);
                    return;
                }
            } else if (view.getId() == 2131822315 || view.getId() == 2131822314) {
                if (C38766e.this.kaS.aZV().vUa > 0) {
                    if (C38766e.this.kaY == null || C38766e.this.kaY.size() == 0) {
                        C4990ab.m7412e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                        AppMethodBeat.m2505o(88338);
                        return;
                    }
                    c23422od = (C23422od) C38766e.this.kaY.get(0);
                    C45774b.m84622a(C38766e.this.kjd, c23422od.cEB, c23422od.cGm, c23422od.fBg);
                    C7060h c7060h3 = C7060h.pYm;
                    Object[] objArr3 = new Object[9];
                    objArr3[0] = "UsedStoresView";
                    objArr3[1] = Integer.valueOf(C38766e.this.kaS.aZV().iAd);
                    objArr3[2] = C38766e.this.kaS.baa();
                    objArr3[3] = C38766e.this.kaS.aZZ();
                    objArr3[4] = Integer.valueOf(0);
                    objArr3[5] = Integer.valueOf(C38766e.this.kjF.kgn);
                    objArr3[6] = C38766e.this.kjF.kiN;
                    if (C38766e.this.kaS.aZT()) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    objArr3[7] = Integer.valueOf(i2);
                    objArr3[8] = "";
                    c7060h3.mo8381e(11324, objArr3);
                    C7060h.pYm.mo8381e(11941, Integer.valueOf(5), C38766e.this.kaS.aZZ(), C38766e.this.kaS.baa(), "", c23422od.name);
                    AppMethodBeat.m2505o(88338);
                    return;
                }
            } else if (view.getId() == 2131822342) {
                if (C38766e.this.kaY == null || C38766e.this.kaY.size() == 0) {
                    C4990ab.m7412e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                    AppMethodBeat.m2505o(88338);
                    return;
                }
                c23422od = (C23422od) C38766e.this.kaY.get(0);
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str) || !str.equals(C38766e.this.kjd.getString(C25738R.string.acx))) {
                    if (!TextUtils.isEmpty(c23422od.kdF)) {
                        C45774b.m84626a(C38766e.this.kjd, c23422od.kdF, 1);
                        C7060h.pYm.mo8381e(11941, Integer.valueOf(4), C38766e.this.kaS.aZZ(), C38766e.this.kaS.baa(), "", c23422od.name);
                    }
                    AppMethodBeat.m2505o(88338);
                    return;
                }
                C38766e.m65770a(C38766e.this);
                AppMethodBeat.m2505o(88338);
                return;
            } else if (view.getId() == 2131822346) {
                C38766e.m65770a(C38766e.this);
            }
            AppMethodBeat.m2505o(88338);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.e$1 */
    class C387671 implements OnItemClickListener {
        C387671() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(88335);
            C11286b c11286b = (C11286b) C38766e.this.kaW.get(i);
            if (c11286b == null || TextUtils.isEmpty(c11286b.url)) {
                AppMethodBeat.m2505o(88335);
                return;
            }
            Intent intent = new Intent();
            if (C38766e.this.kaS instanceof CardInfo) {
                intent.putExtra("key_card_info_data", (CardInfo) C38766e.this.kaS);
            } else if (C38766e.this.kaS instanceof ShareCardInfo) {
                intent.putExtra("key_card_info_data", (ShareCardInfo) C38766e.this.kaS);
            }
            C7060h c7060h;
            Object[] objArr;
            if (c11286b.url.equals("card://jump_detail")) {
                int i2;
                if (C38766e.this.kaS.aZV().vUo == null || TextUtils.isEmpty(C38766e.this.kaS.aZV().vUo.url)) {
                    intent.setClass(C38766e.this.kjd, CardDetailPreference.class);
                    C38766e.this.kjd.startActivity(intent);
                } else {
                    C45774b.m84626a(C38766e.this.kjd, C38766e.this.kaS.aZV().vUo.url, 1);
                }
                c7060h = C7060h.pYm;
                objArr = new Object[9];
                objArr[0] = "CardLeftRightIntroduceView";
                objArr[1] = Integer.valueOf(C38766e.this.kaS.aZV().iAd);
                objArr[2] = C38766e.this.kaS.baa();
                objArr[3] = C38766e.this.kaS.aZZ();
                objArr[4] = Integer.valueOf(0);
                objArr[5] = Integer.valueOf(C38766e.this.kjF.kgn);
                objArr[6] = C38766e.this.kjF.kiN;
                if (C38766e.this.kaS.aZT()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                objArr[7] = Integer.valueOf(i2);
                objArr[8] = "";
                c7060h.mo8381e(11324, objArr);
                AppMethodBeat.m2505o(88335);
            } else if (c11286b.url.equals("card://jump_shop_list") && C38766e.this.kaS.aZV().vUa > 0) {
                C38766e.m65770a(C38766e.this);
                AppMethodBeat.m2505o(88335);
            } else if (!c11286b.url.equals("card://jump_shop") || C38766e.this.kaS.aZV().vUa <= 0) {
                if (c11286b.url.equals("card://jump_service")) {
                    if (!TextUtils.isEmpty(C38766e.this.kaS.aZV().vTT)) {
                        C45774b.m84631af(C38766e.this.kjd, C38766e.this.kaS.aZV().vTT);
                        C42852am.bbc().mo15082s(C38766e.this.kaS.aZZ(), C38766e.this.kaS.baa(), 1);
                    }
                    C7060h.pYm.mo8381e(11582, "OperService", Integer.valueOf(1), Integer.valueOf(C38766e.this.kaS.aZV().iAd), C38766e.this.kaS.baa(), C38766e.this.kaS.aZZ(), C38766e.this.kjF.kiN);
                    AppMethodBeat.m2505o(88335);
                } else if (c11286b.url.equals("card://jump_gift")) {
                    C38766e.m65771b(C38766e.this);
                    C38766e c38766e = C38766e.this;
                    if (c38766e.kaS.aZW().vSn == null) {
                        C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "mCardInfo.getDataInfo().gifting_info_cell is null");
                        AppMethodBeat.m2505o(88335);
                    } else if (c38766e.kaS.aZW().vSn.waC == null) {
                        C4990ab.m7412e("MicroMsg.CardDetailUIContoller", "mCardInfo.getDataInfo().gifting_info_cell.gifting_info is null");
                        AppMethodBeat.m2505o(88335);
                    } else {
                        C7060h.pYm.mo8381e(13866, Integer.valueOf(6), c38766e.kaS.aZW().vSn.waC.vBB, C1183p.getString(c38766e.kaS.aZW().vSn.waC.vBA));
                        AppMethodBeat.m2505o(88335);
                    }
                } else if (c11286b.url.equals("card://jump_card_gift")) {
                    if (C38766e.this.kaS.aZW().vSn == null) {
                        C4990ab.m7412e("MicroMsg.CardDetailUIContoller", "jump_card_gift mCardInfo.getDataInfo().gifting_info_cell is null");
                        AppMethodBeat.m2505o(88335);
                    } else if (C38766e.this.kaS.aZW().vSn.waC == null) {
                        C4990ab.m7412e("MicroMsg.CardDetailUIContoller", "jump_card_gift mCardInfo.getDataInfo().gifting_info_cell.gifting_info is null");
                        AppMethodBeat.m2505o(88335);
                    } else {
                        C38766e c38766e2 = C38766e.this;
                        C4990ab.m7411d("MicroMsg.CardDetailUIContoller", "doJumpCardGift, order_id:%s, biz_uin:%d", C38766e.this.kaS.aZW().vSn.waC.vBB, Integer.valueOf(C38766e.this.kaS.aZW().vSn.waC.vBA));
                        Intent intent2 = new Intent(c38766e2.kjd, CardGiftReceiveUI.class);
                        intent2.putExtra("key_biz_uin", r2);
                        intent2.putExtra("key_order_id", r0);
                        intent2.putExtra("key_gift_into", (CardGiftInfo) c38766e2.kjd.getIntent().getParcelableExtra("key_card_git_info"));
                        c38766e2.kjd.startActivity(intent2);
                        C7060h.pYm.mo8381e(13866, Integer.valueOf(5), C38766e.this.kaS.aZW().vSn.waC.vBB, C1183p.getString(C38766e.this.kaS.aZW().vSn.waC.vBA));
                        AppMethodBeat.m2505o(88335);
                    }
                } else if ((c11286b.vUW & 32) > 0) {
                    C5186a c5186a = C38766e.this;
                    C45774b.m84623a(c5186a.kjd, 4, c5186a);
                    c5186a.kjd.ifE = c5186a;
                    AppMethodBeat.m2505o(88335);
                } else if (C45774b.m84634d(C38766e.this.kaS.aZZ(), c11286b.vTL, c11286b.vTM, C38766e.this.kjF.kgn, C38766e.this.kjF.kjL)) {
                    C7060h.pYm.mo8381e(11941, Integer.valueOf(21), C38766e.this.kaS.aZZ(), C38766e.this.kaS.baa(), "", c11286b.title);
                    AppMethodBeat.m2505o(88335);
                } else {
                    C45774b.m84626a(C38766e.this.kjd, C38736l.m65699A(c11286b.url, c11286b.vUW), 1);
                    C7060h.pYm.mo8381e(11492, Integer.valueOf(C38766e.this.kjF.kgn), C38766e.this.kjF.kiO, C38766e.this.kaS.aZZ(), C38766e.this.kaS.baa(), Integer.valueOf(C38766e.this.kaS.aZW().status), r1, Integer.valueOf(C38766e.this.kaS.aZV().iAd), C38766e.this.kaS.aZV().vTT);
                    C7060h.pYm.mo8381e(11941, Integer.valueOf(6), C38766e.this.kaS.aZZ(), C38766e.this.kaS.baa(), "", c11286b.title);
                    if (C38736l.m65712a(c11286b, C38766e.this.kaS.aZZ())) {
                        C38736l.m65706Hs(C38766e.this.kaS.aZZ());
                        C45774b.m84633b(C38766e.this.kjd, C38766e.this.kaS.aZV().kdg);
                    }
                    AppMethodBeat.m2505o(88335);
                }
            } else if (C38766e.this.kaY == null || C38766e.this.kaY.size() == 0) {
                C4990ab.m7412e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                AppMethodBeat.m2505o(88335);
            } else {
                C23422od c23422od = (C23422od) C38766e.this.kaY.get(0);
                if (!(c23422od == null || TextUtils.isEmpty(c23422od.kdF))) {
                    C45774b.m84626a(C38766e.this.kjd, c23422od.kdF, 1);
                    C7060h.pYm.mo8381e(11941, Integer.valueOf(4), C38766e.this.kaS.aZZ(), C38766e.this.kaS.baa(), "", c23422od.name);
                }
                c7060h = C7060h.pYm;
                objArr = new Object[9];
                objArr[0] = "UsedStoresView";
                objArr[1] = Integer.valueOf(C38766e.this.kaS.aZV().iAd);
                objArr[2] = C38766e.this.kaS.baa();
                objArr[3] = C38766e.this.kaS.aZZ();
                objArr[4] = Integer.valueOf(0);
                objArr[5] = Integer.valueOf(C38766e.this.kjF.kgn);
                objArr[6] = C38766e.this.kjF.kiN;
                objArr[7] = Integer.valueOf(C38766e.this.kaS.aZT() ? 1 : 0);
                objArr[8] = "";
                c7060h.mo8381e(11324, objArr);
                AppMethodBeat.m2505o(88335);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.e$2 */
    class C387682 implements DialogInterface.OnClickListener {
        C387682() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(88336);
            dialogInterface.dismiss();
            if (C38766e.this.kjE != null) {
                C38766e.this.kjE.bcs();
            }
            AppMethodBeat.m2505o(88336);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.e$c */
    static class C38769c {
        String aIm;
        int errCode;
        C20177b kjR;
        C42839c kjS;

        private C38769c() {
        }

        /* synthetic */ C38769c(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.e$d */
    public interface C38770d {
        /* renamed from: GQ */
        void mo54310GQ(String str);

        /* renamed from: b */
        void mo54311b(C42837b c42837b);

        void bco();

        void bcp();

        void bcq();

        void bcr();

        void bcs();

        void bct();

        void bcu();

        /* renamed from: fJ */
        void mo54319fJ(boolean z);
    }

    public C38766e(CardDetailBaseUI cardDetailBaseUI, View view) {
        AppMethodBeat.m2504i(88349);
        this.kjd = cardDetailBaseUI;
        this.jcl = view;
        AppMethodBeat.m2505o(88349);
    }

    /* renamed from: a */
    public final void mo61637a(C42837b c42837b, C20176a c20176a, ArrayList<C23422od> arrayList) {
        this.kaS = c42837b;
        this.kjF = c20176a;
        this.kaY = arrayList;
    }

    public final View findViewById(int i) {
        AppMethodBeat.m2504i(88350);
        View findViewById = this.jcl.findViewById(i);
        AppMethodBeat.m2505o(88350);
        return findViewById;
    }

    public final C42837b bcv() {
        return this.kaS;
    }

    /* renamed from: b */
    public final void mo54333b(C42837b c42837b) {
        AppMethodBeat.m2504i(88351);
        if (c42837b != null) {
            this.kaS = c42837b;
            if (this.kjE != null) {
                this.kjE.mo54311b(c42837b);
            }
            bbB();
        }
        AppMethodBeat.m2505o(88351);
    }

    public final boolean bcw() {
        return this.kjg;
    }

    public final void bcx() {
        this.kjg = false;
    }

    public final MMActivity bcy() {
        return this.kjd;
    }

    public final OnClickListener bcz() {
        return this.gKK;
    }

    public final C42867g bcA() {
        return this.kje;
    }

    public final C38770d bcB() {
        return this.kjE;
    }

    public final C20176a bcC() {
        return this.kjF;
    }

    public final C38728f bcD() {
        return this.kjy;
    }

    public final C2777j bcE() {
        return this.kjw;
    }

    public final String getString(int i) {
        AppMethodBeat.m2504i(88352);
        String string = this.kjd.getString(i);
        AppMethodBeat.m2505o(88352);
        return string;
    }

    public final void bbB() {
        AppMethodBeat.m2504i(88354);
        if (this.kaS == null) {
            C4990ab.m7412e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo == null");
            if (this.kjE != null) {
                this.kjE.bcs();
            }
            AppMethodBeat.m2505o(88354);
        } else if (this.kaS.aZV() == null) {
            C4990ab.m7412e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getCardTpInfo() == null");
            if (this.kjE != null) {
                this.kjE.bcs();
            }
            AppMethodBeat.m2505o(88354);
        } else if (this.kaS.aZW() == null) {
            C4990ab.m7412e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getDataInfo() == null");
            if (this.kjE != null) {
                this.kjE.bcs();
            }
            AppMethodBeat.m2505o(88354);
        } else if (this.kaS.aZI()) {
            C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "doUpdate()");
            C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "doUpdate() showAcceptView:" + this.kaS.aZV().vUx);
            this.kjy.mo61605a(this.kaS, this.kaY, this.kjF.emC);
            bcF();
            this.kje.bee();
            C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "");
            updateTitle();
            bcJ();
            if (this.kje.bdN()) {
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "updateShareUsersInfoLayout()");
                this.kjf.update();
            } else {
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "don't updateShareUsersInfoLayout()");
                this.kjf.bes();
            }
            if (this.kje.bdE()) {
                if (this.kjv == null) {
                    this.kjv = new C46902b();
                    this.kjv.mo73598a(this);
                }
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "update CardAcceptView()");
                this.kjv.update();
            } else {
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "don't update CardAcceptView()");
                if (this.kjv != null) {
                    this.kjv.bes();
                }
            }
            this.kjd.mo45444fH(this.kje.bdI());
            if (this.kje.bdJ()) {
                bcP();
            }
            if (this.kje.bdK()) {
                bcQ();
            }
            if (this.kje.bdL()) {
                bcR();
            }
            bcN();
            m65773x(this.kje.bdG(), this.kje.bdH());
            if (!this.kaS.aZD() && this.kje.bdP()) {
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "update mFromUserView");
                this.kjh.update();
            } else if (this.kaS.aZD() && this.kje.bdP()) {
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout for username");
                this.kji.update();
            } else if (this.kje.bdQ()) {
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout");
                this.kji.update();
            } else {
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "don't update mFromUserView and mAcceptHeaderLayout");
                this.kji.bes();
                this.kjh.bes();
            }
            if (this.kjj != null) {
                this.kjj.mo6891fM(this.kje.bcT());
            }
            bcH();
            if (this.kje.bdU()) {
                if (this.kjn == null) {
                    this.kjn = new C27633y();
                    this.kjn.mo73598a(this);
                }
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "update CardStatusView");
                this.kjn.update();
            } else {
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "don't update CardStatusView");
                if (this.kjn != null) {
                    this.kjn.bes();
                }
            }
            if (this.kje.bed()) {
                if (this.kjm == null) {
                    this.kjm = new C38777c();
                    this.kjm.mo73598a(this);
                }
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "update mAdtitleView()");
                this.kjm.update();
            } else {
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "don't update AdTitleView()");
                if (this.kjm != null) {
                    this.kjm.bes();
                }
            }
            if (this.kje.bdV()) {
                if (this.kjo == null) {
                    this.kjo = new C46903k();
                    this.kjo.mo73598a(this);
                }
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "update mCardDetailFieldView()");
                this.kjo.update();
            } else {
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "don't update mCardDetailFieldView()");
                if (this.kjo != null) {
                    this.kjo.bes();
                }
            }
            if (this.kje.bdW()) {
                if (this.kjp == null) {
                    this.kjp = new C20200w();
                    this.kjp.mo73598a(this);
                }
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "update CardSecondaryFieldView");
                this.kjp.update();
            } else {
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "don't update CardSecondaryFieldView");
                if (this.kjp != null) {
                    this.kjp.bes();
                }
            }
            if (this.kje.bdX()) {
                if (this.kjq == null) {
                    this.kjq = new C38778l();
                    this.kjq.mo73598a(this);
                }
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "update CardDetailTableView");
                this.kjq.update();
            } else {
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "don't update CardDetailTableView");
                if (this.kjq != null) {
                    this.kjq.bes();
                }
            }
            if (this.kje.bdY()) {
                if (this.kjr == null) {
                    this.kjr = new C38779z();
                    this.kjr.mo73598a(this);
                }
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "update CardThirdFieldView");
                this.kjr.update();
            } else {
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "don't update CardThirdFieldView");
                if (this.kjr != null) {
                    this.kjr.bes();
                }
            }
            if (this.kje.bea()) {
                if (this.kjs == null) {
                    this.kjs = new C11357e();
                    this.kjs.mo73598a(this);
                }
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "updateCardAnnoucementView");
                this.kjs.update();
            } else {
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "don't updateCardAnnoucementView");
                if (this.kjs != null) {
                    this.kjs.bes();
                }
            }
            if (this.kje.bdZ()) {
                if (this.kjt == null) {
                    this.kjt = new C42872u();
                    this.kjt.mo73598a(this);
                }
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "updateCardOperateFieldView");
                this.kjt.update();
            } else {
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "don't updateCardOperateFieldView");
                if (this.kjt != null) {
                    this.kjt.bes();
                }
            }
            bcI();
            if (this.kje.bdS()) {
                bcO();
                if (this.kje.bdT()) {
                    if (this.kjk == null) {
                        bcG();
                        this.kjk.mo73598a(this);
                        this.kjk.update();
                    } else if (this.kjk.mo23070f(this.kaS)) {
                        this.kjk.mo23060b(this.kaS);
                        this.kjk.update();
                    }
                } else if (this.kjk != null) {
                    this.kjk.bex();
                }
                if (this.kjj != null) {
                    this.kjj.mo6890fL(true);
                }
            } else {
                C4990ab.m7412e("MicroMsg.CardDetailUIContoller", "don't update CardCodeView");
                if (this.kjk != null) {
                    this.kjk.bex();
                }
                if (this.kjj != null) {
                    this.kjj.mo6890fL(false);
                }
            }
            if (this.kje.beb()) {
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "update CardAdvertiseView");
                this.kju.update();
            } else {
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "don't update CardAdvertiseView");
                this.kju.bes();
            }
            this.kjw.kaS = this.kaS;
            AppMethodBeat.m2505o(88354);
        } else {
            C4990ab.m7413e("MicroMsg.CardDetailUIContoller", "doUpdate fail, not support card type :%d", Integer.valueOf(this.kaS.aZV().iAd));
            if (TextUtils.isEmpty(this.kaS.aZV().vUc)) {
                C30379h.m48448a(this.kjd, getString(C25738R.string.agb), null, false, new C387682());
            } else {
                C45774b.m84626a(this.kjd, this.kaS.aZV().vUc, 0);
                if (this.kjE != null) {
                    this.kjE.bcs();
                    AppMethodBeat.m2505o(88354);
                    return;
                }
            }
            AppMethodBeat.m2505o(88354);
        }
    }

    /* renamed from: c */
    public final void mo35368c(C42839c c42839c) {
        AppMethodBeat.m2504i(88355);
        C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "onGetCodeSuccess! do update code view!");
        Message obtain = Message.obtain();
        C38769c c38769c = new C38769c();
        c38769c.kjR = C20177b.onGetCodeSuccess;
        c38769c.kjS = c42839c;
        obtain.obj = c38769c;
        this.kjG.sendMessage(obtain);
        AppMethodBeat.m2505o(88355);
    }

    /* renamed from: ap */
    public final void mo35365ap(int i, String str) {
        String string;
        AppMethodBeat.m2504i(88356);
        C4990ab.m7413e("MicroMsg.CardDetailUIContoller", "onGetCodeFail! errCode = %d, errMsg=%s", Integer.valueOf(i), str);
        Message obtain = Message.obtain();
        C38769c c38769c = new C38769c();
        c38769c.kjR = C20177b.onGetCodeFail;
        c38769c.errCode = i;
        if (i == -1) {
            string = getString(C25738R.string.adw);
        } else if (i == 2) {
            string = getString(C25738R.string.ad2);
        } else {
            string = getString(C25738R.string.adv);
        }
        c38769c.aIm = string;
        obtain.obj = c38769c;
        this.kjG.sendMessage(obtain);
        AppMethodBeat.m2505o(88356);
    }

    public final void baA() {
        AppMethodBeat.m2504i(88357);
        C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "on show TimeExpired! do update refresh code view!");
        Message obtain = Message.obtain();
        C38769c c38769c = new C38769c();
        c38769c.kjR = C20177b.onShowTimeExpired;
        obtain.obj = c38769c;
        this.kjG.sendMessage(obtain);
        AppMethodBeat.m2505o(88357);
    }

    /* renamed from: b */
    public final void mo35366b(C42839c c42839c) {
        AppMethodBeat.m2504i(88358);
        C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "on onReceiveCodeUnavailable! do update refresh code view!");
        Message obtain = Message.obtain();
        C38769c c38769c = new C38769c();
        c38769c.kjR = C20177b.onReceiveCodeUnavailable;
        c38769c.kjS = c42839c;
        obtain.obj = c38769c;
        this.kjG.sendMessage(obtain);
        AppMethodBeat.m2505o(88358);
    }

    private void bcG() {
        AppMethodBeat.m2504i(88359);
        if (this.kaS.aZV().vUB != null && this.kaS.aZV().vUB.wdu) {
            this.kjk = new C20197m();
            C42852am.bbm().mo54284a((C20120a) this);
            AppMethodBeat.m2505o(88359);
        } else if (this.kaS.aZV().iAd == 10) {
            this.kjk = new C42869q();
            AppMethodBeat.m2505o(88359);
        } else {
            this.kjk = new C42868j();
            AppMethodBeat.m2505o(88359);
        }
    }

    private void bcH() {
        AppMethodBeat.m2504i(88360);
        if (this.cAY) {
            C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "updateUIBackground onPause return");
            AppMethodBeat.m2505o(88360);
            return;
        }
        View findViewById;
        LayoutParams layoutParams;
        if (this.kaS.aZB() && this.kaS.aZD()) {
            this.jcl.findViewById(2131822015).setBackgroundColor(this.kjd.getResources().getColor(C25738R.color.f11834ir));
            this.kjd.mo45443O(-1, true);
        } else {
            int Hn = C38736l.m65701Hn(this.kaS.aZV().color);
            this.jcl.findViewById(2131822015).setBackgroundColor(Hn);
            this.kjd.mo45443O(Hn, false);
        }
        View findViewById2 = this.jcl.findViewById(2131822019);
        View findViewById3 = this.jcl.findViewById(2131822020);
        View findViewById4 = this.jcl.findViewById(2131822021);
        if (this.kaS.aZB() && this.kje.bdP()) {
            if (this.kaS.aZE()) {
                findViewById2.setBackgroundResource(C25738R.drawable.azw);
                this.jcl.findViewById(2131824179).setBackgroundResource(C25738R.drawable.f6512gm);
                findViewById4.setBackgroundResource(0);
            } else if (this.kaS.aZD()) {
                this.jcl.findViewById(2131824179).setBackgroundResource(0);
                findViewById4.setBackgroundColor(this.kjd.getResources().getColor(C25738R.color.f11834ir));
            } else if (this.kaS.aZF()) {
                findViewById2.setBackgroundResource(C25738R.drawable.azw);
                this.jcl.findViewById(2131824179).setBackgroundResource(C25738R.drawable.f6512gm);
                findViewById4.setBackgroundResource(0);
            } else if (!this.kaS.aZG() && this.kaS.aZH()) {
                findViewById4.setBackgroundColor(this.kjd.getResources().getColor(C25738R.color.f11834ir));
            }
        } else if (this.kaS.aZC()) {
            if (this.kje.bdN() && this.kjg) {
                findViewById2.setBackgroundResource(C25738R.drawable.azw);
                findViewById4.setBackgroundResource(0);
            } else if (!this.kje.bdN() || this.kjg) {
                findViewById2.setBackgroundResource(0);
                if (this.kje.bcT()) {
                    findViewById4.setBackgroundResource(C25738R.drawable.azv);
                } else {
                    findViewById4.setBackgroundResource(C25738R.drawable.azw);
                }
            } else {
                findViewById2.setBackgroundResource(C25738R.drawable.azv);
                findViewById4.setBackgroundResource(0);
            }
        } else if (this.kaS.aZE()) {
            findViewById2.setBackgroundResource(0);
            if (this.kje.bcT()) {
                findViewById4.setBackgroundResource(C25738R.drawable.azv);
            } else {
                findViewById4.setBackgroundResource(C25738R.drawable.azw);
            }
        } else if (this.kaS.aZF()) {
            findViewById2.setBackgroundResource(C25738R.drawable.f6532ha);
            findViewById4.setBackgroundResource(0);
        } else {
            findViewById2.setBackgroundResource(0);
            findViewById4.setBackgroundColor(this.kjd.getResources().getColor(C25738R.color.f11834ir));
        }
        if (this.kaS.aZH()) {
            TextView textView = (TextView) this.jcl.findViewById(2131822037);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(C5056d.m7610LV(C25738R.drawable.azu));
            bitmapDrawable.setTileModeX(TileMode.REPEAT);
            textView.setBackgroundDrawable(bitmapDrawable);
            textView.setVisibility(0);
        }
        Rect rect = new Rect(0, 0, 0, 0);
        findViewById2.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        findViewById2.invalidate();
        findViewById4.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        findViewById4.invalidate();
        if (this.kaS.aZC() && this.kje.bdN() && this.kjg) {
            findViewById = this.jcl.findViewById(2131822308);
            findViewById.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            findViewById.invalidate();
        }
        if (this.kaS.aZB() && this.kje.bdP()) {
            findViewById = this.jcl.findViewById(2131824179);
            rect.left = this.kjd.getResources().getDimensionPixelOffset(C25738R.dimen.f9948l5);
            rect.right = this.kjd.getResources().getDimensionPixelOffset(C25738R.dimen.f9948l5);
            findViewById.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            findViewById.invalidate();
            if (this.kaS.aZF()) {
                findViewById = this.jcl.findViewById(2131822017);
                layoutParams = (LayoutParams) findViewById.getLayoutParams();
                int dimensionPixelSize = this.kjd.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
                layoutParams.rightMargin = dimensionPixelSize;
                layoutParams.leftMargin = dimensionPixelSize;
                findViewById.setLayoutParams(layoutParams);
            }
        }
        if (this.kje.bdP() || this.kje.bdN()) {
            if (this.kjj != null && ((this.kaS.aZB() && this.kaS.aZE()) || this.kaS.aZC())) {
                this.kjj.mo6896tq(0);
            }
        } else if (this.kjj != null && ((this.kaS.aZB() && this.kaS.aZE()) || this.kaS.aZC())) {
            if (this.kje.bcT()) {
                this.kjj.mo6896tq(C25738R.drawable.azx);
            } else {
                this.kjj.mo6896tq(C25738R.drawable.f6530h9);
            }
        }
        if (this.kjj != null && this.kaS.aZB() && this.kaS.aZD()) {
            this.kjj.mo6885a(C38736l.m65725dI(C38736l.m65701Hn(this.kaS.aZV().color), this.kjd.getResources().getDimensionPixelOffset(C25738R.dimen.f10259w1)));
        }
        if (this.kaS.aZB() && this.kaS.aZD()) {
            layoutParams = (LayoutParams) findViewById2.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
            if (TextUtils.isEmpty(this.kaS.aZV().vUh)) {
                layoutParams.height = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.weight = 0.0f;
                layoutParams.height = -2;
            }
            findViewById2.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) findViewById3.getLayoutParams();
            int dimensionPixelSize2 = this.kjd.getResources().getDimensionPixelSize(C25738R.dimen.f9966lo);
            layoutParams.rightMargin = dimensionPixelSize2;
            layoutParams.leftMargin = dimensionPixelSize2;
            if (this.kaS.aZD()) {
                layoutParams.topMargin = this.kjd.getResources().getDimensionPixelSize(C25738R.dimen.f9957ld);
                layoutParams.bottomMargin = this.kjd.getResources().getDimensionPixelSize(C25738R.dimen.f9958le);
                dimensionPixelSize2 = this.kjd.getResources().getDimensionPixelSize(C25738R.dimen.f9951l8);
                layoutParams.rightMargin = dimensionPixelSize2;
                layoutParams.leftMargin = dimensionPixelSize2;
            } else {
                dimensionPixelSize2 = this.kjd.getResources().getDimensionPixelSize(C25738R.dimen.f9732dy);
                layoutParams.bottomMargin = dimensionPixelSize2;
                layoutParams.topMargin = dimensionPixelSize2;
            }
            findViewById3.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) findViewById4.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
            if (this.kaS.aZD()) {
                layoutParams.bottomMargin = this.kjd.getResources().getDimensionPixelSize(C25738R.dimen.f9951l8);
            }
            if (TextUtils.isEmpty(this.kaS.aZV().vUh)) {
                layoutParams.height = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.weight = 0.0f;
                layoutParams.height = -2;
            }
            findViewById4.setLayoutParams(layoutParams);
            if (!TextUtils.isEmpty(this.kaS.aZV().vUh)) {
                findViewById2 = findViewById(2131822038);
                layoutParams = (LayoutParams) findViewById2.getLayoutParams();
                layoutParams.height = 0;
                layoutParams.weight = 1.0f;
                findViewById2.setLayoutParams(layoutParams);
            }
        }
        this.jcl.invalidate();
        AppMethodBeat.m2505o(88360);
    }

    /* renamed from: a */
    public final void mo61638a(boolean z, C20125b c20125b, boolean z2) {
        int i = 1;
        AppMethodBeat.m2504i(88361);
        C7060h c7060h;
        Object[] objArr;
        if (z) {
            C23446tm c23446tm = this.kaS.aZW().vSj;
            C7060h c7060h2;
            Object[] objArr2;
            if (this.kaS.aZP()) {
                C45774b.m84624a(this.kjd, c20125b.kbK, c20125b.kbL, z2, this.kaS);
                C7060h.pYm.mo8381e(11941, Integer.valueOf(17), this.kaS.aZZ(), this.kaS.baa(), "", this.kaS.aZW().vSj.title);
                AppMethodBeat.m2505o(88361);
                return;
            } else if (c23446tm != null && !TextUtils.isEmpty(c23446tm.vTL) && !TextUtils.isEmpty(c23446tm.vTM)) {
                C45774b.m84629a(this.kaS.aZZ(), c23446tm, this.kjF.kgn, this.kjF.kjL);
                c7060h2 = C7060h.pYm;
                objArr2 = new Object[5];
                objArr2[0] = Integer.valueOf(6);
                objArr2[1] = this.kaS.aZZ();
                objArr2[2] = this.kaS.baa();
                objArr2[3] = "";
                objArr2[4] = c23446tm.title != null ? c23446tm.title : "";
                c7060h2.mo8381e(11941, objArr2);
                AppMethodBeat.m2505o(88361);
                return;
            } else if (c23446tm == null || TextUtils.isEmpty(c23446tm.url)) {
                c7060h = C7060h.pYm;
                objArr = new Object[9];
                objArr[0] = "CardConsumedCodeUI";
                objArr[1] = Integer.valueOf(this.kaS.aZV().iAd);
                objArr[2] = this.kaS.baa();
                objArr[3] = this.kaS.aZZ();
                objArr[4] = Integer.valueOf(0);
                objArr[5] = Integer.valueOf(this.kjF.kgn);
                objArr[6] = this.kjF.kiN;
                if (!this.kaS.aZT()) {
                    i = 0;
                }
                objArr[7] = Integer.valueOf(i);
                objArr[8] = "";
                c7060h.mo8381e(11324, objArr);
                m65769GR(c20125b.kbH);
                AppMethodBeat.m2505o(88361);
                return;
            } else {
                C45774b.m84626a(this.kjd, C38736l.m65699A(c23446tm.url, c23446tm.vUW), 1);
                c7060h2 = C7060h.pYm;
                objArr2 = new Object[5];
                objArr2[0] = Integer.valueOf(6);
                objArr2[1] = this.kaS.aZZ();
                objArr2[2] = this.kaS.baa();
                objArr2[3] = "";
                objArr2[4] = c23446tm.title != null ? c23446tm.title : "";
                c7060h2.mo8381e(11941, objArr2);
                AppMethodBeat.m2505o(88361);
                return;
            }
        }
        c7060h = C7060h.pYm;
        objArr = new Object[9];
        objArr[0] = "CardConsumedCodeUI";
        objArr[1] = Integer.valueOf(this.kaS.aZV().iAd);
        objArr[2] = this.kaS.baa();
        objArr[3] = this.kaS.aZZ();
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(this.kjF.kgn);
        objArr[6] = this.kjF.kiN;
        if (!this.kaS.aZT()) {
            i = 0;
        }
        objArr[7] = Integer.valueOf(i);
        objArr[8] = "";
        c7060h.mo8381e(11324, objArr);
        m65769GR(c20125b.kbH);
        AppMethodBeat.m2505o(88361);
    }

    /* renamed from: x */
    private void m65773x(boolean z, boolean z2) {
        AppMethodBeat.m2504i(88362);
        if (this.kjj != null) {
            this.kjj.mo6897x(z, z2);
        }
        AppMethodBeat.m2505o(88362);
    }

    private void updateTitle() {
        AppMethodBeat.m2504i(88363);
        if (this.kje.bdM()) {
            this.kjd.setMMTitle(this.kjy.getTitle());
            AppMethodBeat.m2505o(88363);
            return;
        }
        this.kjd.setMMTitle("");
        AppMethodBeat.m2505o(88363);
    }

    private void bcI() {
        AppMethodBeat.m2504i(88364);
        if (this.kje.bdR()) {
            this.kaW.clear();
            this.kaW.addAll(this.kjy.baw());
            this.kjl.setData(this.kaW);
            this.kjl.kob = this.kaS.aZH();
            this.kjl.notifyDataSetChanged();
            AppMethodBeat.m2505o(88364);
            return;
        }
        C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "card is membership or share card or general coupon, not accept, don't updateCellData()");
        AppMethodBeat.m2505o(88364);
    }

    private void bcJ() {
        AppMethodBeat.m2504i(88365);
        if (this.kaS == null) {
            C4990ab.m7412e("MicroMsg.CardDetailUIContoller", "updateWidget, mCardInfo is null");
            AppMethodBeat.m2505o(88365);
            return;
        }
        if (bcK()) {
            bcM();
        }
        if (this.kjj == null) {
            bcL();
        }
        if (this.kjj != null) {
            if (this.kaS.aZF()) {
                ((C38781f) this.kjj).kaY = this.kaY;
            }
            this.kjj.mo6889d(this.kaS);
        }
        AppMethodBeat.m2505o(88365);
    }

    private boolean bcK() {
        AppMethodBeat.m2504i(88366);
        if (this.kjj == null) {
            AppMethodBeat.m2505o(88366);
            return false;
        } else if (this.kaS.aZD()) {
            if (this.kjj instanceof C45802e) {
                AppMethodBeat.m2505o(88366);
                return false;
            }
            AppMethodBeat.m2505o(88366);
            return true;
        } else if (this.kaS.aZG()) {
            if (this.kjj instanceof C33806c) {
                AppMethodBeat.m2505o(88366);
                return false;
            }
            AppMethodBeat.m2505o(88366);
            return true;
        } else if (this.kaS.aZE()) {
            if (this.kjj instanceof C6821b) {
                AppMethodBeat.m2505o(88366);
                return false;
            }
            AppMethodBeat.m2505o(88366);
            return true;
        } else if (this.kaS.aZF()) {
            if (this.kjj instanceof C38781f) {
                AppMethodBeat.m2505o(88366);
                return false;
            }
            AppMethodBeat.m2505o(88366);
            return true;
        } else if (!this.kaS.aZH()) {
            AppMethodBeat.m2505o(88366);
            return false;
        } else if (this.kjj instanceof C38780d) {
            AppMethodBeat.m2505o(88366);
            return false;
        } else {
            AppMethodBeat.m2505o(88366);
            return true;
        }
    }

    private void bcL() {
        AppMethodBeat.m2504i(88367);
        if (this.kaS.aZD()) {
            this.kjj = new C45802e(this.kjd);
        } else if (this.kaS.aZG()) {
            this.kjj = new C33806c(this.kjd);
        } else if (this.kaS.aZE()) {
            this.kjj = new C6821b(this.kjd);
        } else if (this.kaS.aZF()) {
            this.kjj = new C38781f(this.kjd);
        } else if (this.kaS.aZH()) {
            this.kjj = new C38780d(this.kjd);
        } else {
            this.kjj = new C6821b(this.kjd);
        }
        this.kjj.mo6893i(this.kaS);
        View hS = this.kjj.mo6892hS();
        if (hS != null) {
            C45778m.m84642a(hS, this.f16163lK);
        }
        this.f16163lK.invalidate();
        this.kjj.setOnClickListener(this.gKK);
        m65773x(false, false);
        AppMethodBeat.m2505o(88367);
    }

    private void bcM() {
        AppMethodBeat.m2504i(88368);
        View hS = this.kjj.mo6892hS();
        if (hS != null) {
            this.f16163lK.removeView(hS);
        }
        this.f16163lK.removeAllViews();
        this.f16163lK.invalidate();
        this.kjj.release();
        this.kjj = null;
        AppMethodBeat.m2505o(88368);
    }

    private void bcN() {
        AppMethodBeat.m2504i(88369);
        if (this.kjj != null && (this.kjj instanceof C6821b)) {
            ((C6821b) this.kjj).bcN();
        }
        AppMethodBeat.m2505o(88369);
    }

    private void bcO() {
        AppMethodBeat.m2504i(88370);
        this.kaS.mo45388a(this.kaS.aZW());
        C38736l.m65732h(this.kaS);
        AppMethodBeat.m2505o(88370);
    }

    private void bcP() {
        int i = 0;
        AppMethodBeat.m2504i(88371);
        this.kjB.clear();
        this.kjD.clear();
        if (this.kaS.aZK()) {
            this.kjD.add(getString(C25738R.string.aij));
            this.kjB.put(Integer.valueOf(0), "menu_func_share_friend");
            this.kjD.add(getString(C25738R.string.aii));
            this.kjB.put(Integer.valueOf(1), "menu_func_share_timeline");
            i = 2;
        }
        if (!TextUtils.isEmpty(this.kaS.aZW().vSf)) {
            this.kjD.add(getString(C25738R.string.ag3));
            this.kjB.put(Integer.valueOf(i), "menu_func_report");
            i++;
        }
        m65772tc(i);
        if (this.kjD.size() > 0) {
            this.kjd.mo45444fH(true);
        }
        AppMethodBeat.m2505o(88371);
    }

    private void bcQ() {
        int i = 0;
        AppMethodBeat.m2504i(88372);
        this.kjB.clear();
        this.kjD.clear();
        if (this.kaS.aZB() && this.kaS.aZJ()) {
            if (!C5046bo.isNullOrNil(this.kaS.aZV().vUI)) {
                this.kjD.add(this.kaS.aZV().vUI);
            } else if (this.kaS.aZH()) {
                this.kjD.add(getString(C25738R.string.ag2));
            } else {
                this.kjD.add(getString(C25738R.string.ag1));
            }
            this.kjB.put(Integer.valueOf(0), "menu_func_gift");
            i = 1;
        }
        if (!TextUtils.isEmpty(this.kaS.aZW().vSf)) {
            this.kjD.add(getString(C25738R.string.ag3));
            this.kjB.put(Integer.valueOf(i), "menu_func_report");
            i++;
        }
        if (this.kaS.aZB()) {
            this.kjD.add(getString(C25738R.string.f9088p4));
            this.kjB.put(Integer.valueOf(i), "menu_func_delete");
            i++;
        } else if (this.kaS.aZC()) {
            String Yz = C1853r.m3846Yz();
            String bab = this.kaS.bab();
            if (Yz == null || !Yz.equals(bab)) {
                C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "the card is not belong mine");
            } else {
                this.kjD.add(getString(C25738R.string.f9088p4));
                this.kjB.put(Integer.valueOf(i), "menu_func_delete_share_card");
                i++;
            }
        }
        m65772tc(i);
        if (this.kjD.size() > 0) {
            this.kjd.mo45444fH(true);
        }
        AppMethodBeat.m2505o(88372);
    }

    private void bcR() {
        int i = 0;
        AppMethodBeat.m2504i(88373);
        this.kjB.clear();
        this.kjD.clear();
        if (!TextUtils.isEmpty(this.kaS.aZW().vSf)) {
            this.kjD.add(getString(C25738R.string.ag3));
            this.kjB.put(Integer.valueOf(0), "menu_func_report");
            i = 1;
        }
        m65772tc(i);
        if (this.kjD.size() > 0) {
            this.kjd.mo45444fH(true);
        }
        AppMethodBeat.m2505o(88373);
    }

    /* renamed from: tc */
    private void m65772tc(int i) {
        AppMethodBeat.m2504i(88374);
        LinkedList linkedList = this.kaS.aZW().vSh;
        if (linkedList == null) {
            AppMethodBeat.m2505o(88374);
            return;
        }
        this.kjC.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < linkedList.size()) {
                C15320ax c15320ax = (C15320ax) linkedList.get(i3);
                if (!(C5046bo.isNullOrNil(c15320ax.text) || C5046bo.isNullOrNil(c15320ax.url))) {
                    this.kjD.add(c15320ax.text);
                    this.kjB.put(Integer.valueOf(i), c15320ax.text);
                    this.kjC.put(c15320ax.text, c15320ax.url);
                    i++;
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.m2505o(88374);
                return;
            }
        }
    }

    /* renamed from: c */
    public final void mo6069c(final int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(88375);
        switch (i) {
            case 0:
            case 1:
            case 4:
                if (i2 == -1 && intent != null) {
                    this.kjz = intent.getStringExtra("Select_Conv_User");
                    final String str = this.kjz;
                    if (this.kaS == null || this.kaS.aZV() == null) {
                        C4990ab.m7412e("MicroMsg.CardDetailUIContoller", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
                        AppMethodBeat.m2505o(88375);
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    if (i == 0) {
                        if (TextUtils.isEmpty(this.kaS.aZX().wYl) || this.kaS.aZH()) {
                            stringBuilder.append(getString(C25738R.string.ens));
                        } else {
                            stringBuilder.append(this.kaS.aZX().wYl);
                        }
                    } else if (i == 1) {
                        stringBuilder.append(getString(C25738R.string.ahl) + this.kjy.getTitle());
                    } else if (i == 4) {
                        stringBuilder.append(getString(C25738R.string.agj) + this.kjy.getTitle());
                    }
                    C23281a.vlq.mo30687a(this.kjd.mController, stringBuilder.toString(), this.kaS.aZV().kbV, this.kaS.aZV().title + IOUtils.LINE_SEPARATOR_UNIX + this.kaS.aZV().kdg, true, this.kjd.getResources().getString(C25738R.string.f9221tf), new C30111a() {
                        /* renamed from: a */
                        public final void mo6399a(boolean z, String str, int i) {
                            AppMethodBeat.m2504i(88343);
                            if (z) {
                                C38766e.this.kjA = str;
                                C38766e c38766e;
                                if (i == 0) {
                                    if (C38766e.this.kjE != null) {
                                        C38766e.this.kjE.mo54310GQ(str);
                                    }
                                    C7060h.pYm.mo8381e(11582, "OperGift", Integer.valueOf(1), Integer.valueOf(C38766e.this.kaS.aZV().iAd), C38766e.this.kaS.baa(), C38766e.this.kaS.aZZ(), C38766e.this.kjz);
                                    C30379h.m48465bQ(C38766e.this.kjd, C38766e.this.kjd.getResources().getString(C25738R.string.aeq));
                                    AppMethodBeat.m2505o(88343);
                                    return;
                                } else if (i == 1) {
                                    c38766e = C38766e.this;
                                    c38766e.kaS.aZX().wYl = c38766e.getString(C25738R.string.ahl) + c38766e.kjy.getTitle();
                                    C38736l.m65711a(c38766e.kaS, c38766e.kjz, c38766e.kjF.kiP, 2);
                                    C38736l.m65727dw(c38766e.kjA, c38766e.kjz);
                                    C30379h.m48465bQ(C38766e.this.kjd, C38766e.this.kjd.getResources().getString(C25738R.string.aeq));
                                    AppMethodBeat.m2505o(88343);
                                    return;
                                } else if (i == 4) {
                                    c38766e = C38766e.this;
                                    if (TextUtils.isEmpty(c38766e.kaS.bab())) {
                                        c38766e.kaS.mo45386Gi(C1853r.m3846Yz());
                                    }
                                    c38766e.kaS.aZX().wYl = c38766e.getString(C25738R.string.agj) + c38766e.kjy.getTitle();
                                    C38736l.m65711a(c38766e.kaS, c38766e.kjz, c38766e.kjF.kiP, 23);
                                    C38736l.m65727dw(c38766e.kjA, c38766e.kjz);
                                    C7060h.pYm.mo8381e(11582, "OpeRecommendCard", Integer.valueOf(C38766e.this.kjF.emC), Integer.valueOf(C38766e.this.kaS.aZV().iAd), C38766e.this.kaS.baa(), C38766e.this.kaS.aZZ(), C38766e.this.kjz);
                                    C30379h.m48465bQ(C38766e.this.kjd, C38766e.this.kjd.getResources().getString(C25738R.string.aeq));
                                }
                            }
                            AppMethodBeat.m2505o(88343);
                        }
                    });
                    AppMethodBeat.m2505o(88375);
                    return;
                }
                break;
            case 2:
                if (i2 != -1) {
                    AppMethodBeat.m2505o(88375);
                    return;
                }
                this.kgP = intent.getIntExtra("Ktag_range_index", 0);
                C4990ab.m7417i("MicroMsg.CardDetailUIContoller", "mPrivateSelelct : %d", Integer.valueOf(this.kgP));
                if (this.kgP >= 2) {
                    this.kgQ = intent.getStringExtra("Klabel_name_list");
                    this.kgR = intent.getStringExtra("Kother_user_name_list");
                    C4990ab.m7411d("MicroMsg.CardDetailUIContoller", "mPrivateSelect : %d, names : %s", Integer.valueOf(this.kgP), this.kgQ);
                    if (TextUtils.isEmpty(this.kgQ) && TextUtils.isEmpty(this.kgR)) {
                        C4990ab.m7412e("MicroMsg.CardDetailUIContoller", "mLabelNameList by getIntent is empty");
                        AppMethodBeat.m2505o(88375);
                        return;
                    }
                    List asList = Arrays.asList(this.kgQ.split(","));
                    this.kgT = C38736l.m65724bl(asList);
                    this.kgS = C38736l.m65723bk(asList);
                    if (this.kgR != null && this.kgR.length() > 0) {
                        this.kgS.addAll(Arrays.asList(this.kgR.split(",")));
                    }
                    if (this.kgT != null) {
                        C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "mPrivateIdsList size is " + this.kgT.size());
                    }
                    if (this.kgS != null) {
                        C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "mPrivateNamesList size is " + this.kgS.size());
                        Iterator it = this.kgS.iterator();
                        while (it.hasNext()) {
                            C4990ab.m7411d("MicroMsg.CardDetailUIContoller", "username : %s", (String) it.next());
                        }
                    }
                    if (this.kgP == 2) {
                        this.kju.mo54354Hd(this.kjd.getString(C25738R.string.ah_, new Object[]{bbF()}));
                        AppMethodBeat.m2505o(88375);
                        return;
                    } else if (this.kgP == 3) {
                        this.kju.mo54354Hd(this.kjd.getString(C25738R.string.ah9, new Object[]{bbF()}));
                        AppMethodBeat.m2505o(88375);
                        return;
                    } else {
                        this.kju.mo54354Hd(this.kjd.getString(C25738R.string.ah8));
                        AppMethodBeat.m2505o(88375);
                        return;
                    }
                }
                this.kju.mo54354Hd(this.kjd.getString(C25738R.string.ah8));
                AppMethodBeat.m2505o(88375);
                return;
            case 3:
                if (this.kjE != null) {
                    this.kjE.bcu();
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(88375);
    }

    private String bbF() {
        AppMethodBeat.m2504i(88376);
        String str;
        if (!TextUtils.isEmpty(this.kgQ) && !TextUtils.isEmpty(this.kgR)) {
            str = this.kgQ + "," + C38736l.m65704Hq(this.kgR);
            AppMethodBeat.m2505o(88376);
            return str;
        } else if (!TextUtils.isEmpty(this.kgQ)) {
            str = this.kgQ;
            AppMethodBeat.m2505o(88376);
            return str;
        } else if (TextUtils.isEmpty(this.kgR)) {
            str = "";
            AppMethodBeat.m2505o(88376);
            return str;
        } else {
            str = C38736l.m65704Hq(this.kgR);
            AppMethodBeat.m2505o(88376);
            return str;
        }
    }

    /* renamed from: GR */
    private void m65769GR(String str) {
        AppMethodBeat.m2504i(88377);
        Intent intent = new Intent();
        if (this.kaS instanceof CardInfo) {
            intent.putExtra("key_card_info_data", (CardInfo) this.kaS);
        } else if (this.kaS instanceof ShareCardInfo) {
            intent.putExtra("key_card_info_data", (ShareCardInfo) this.kaS);
        }
        intent.setClass(this.kjd, CardConsumeCodeUI.class);
        intent.putExtra("key_from_scene", this.kjF.emC);
        intent.putExtra("key_previous_scene", this.kjF.kgn);
        intent.putExtra("key_mark_user", str);
        intent.putExtra("key_from_appbrand_type", this.kjF.kjL);
        this.kjd.startActivityForResult(intent, 3);
        this.kjd.ifE = this;
        AppMethodBeat.m2505o(88377);
    }

    public final int bcS() {
        AppMethodBeat.m2504i(88378);
        if (this.kjy == null) {
            AppMethodBeat.m2505o(88378);
            return 0;
        } else if (this.kjy.bay()) {
            AppMethodBeat.m2505o(88378);
            return 1;
        } else {
            AppMethodBeat.m2505o(88378);
            return 0;
        }
    }

    public final boolean bcT() {
        AppMethodBeat.m2504i(88379);
        if (this.kje == null) {
            AppMethodBeat.m2505o(88379);
            return false;
        }
        boolean bcT = this.kje.bcT();
        AppMethodBeat.m2505o(88379);
        return bcT;
    }

    private void bcF() {
        int i;
        AppMethodBeat.m2504i(88353);
        if (this.kje == null) {
            i = 0;
        } else if (this.kaS.aZC()) {
            if (this.kje instanceof C44841h) {
                i = 0;
            } else {
                i = 1;
            }
        } else if (this.kaS.aZD()) {
            if (this.kje instanceof C27617e) {
                i = 0;
            } else {
                i = 1;
            }
        } else if (this.kaS.aZG()) {
            if (this.kje instanceof C20172b) {
                i = 0;
            } else {
                i = 1;
            }
        } else if (this.kaS.aZE()) {
            if (this.kje instanceof C20173c) {
                i = 0;
            } else {
                i = 1;
            }
        } else if (this.kaS.aZF()) {
            if (this.kje instanceof C38765f) {
                i = 0;
            } else {
                i = 1;
            }
        } else if (this.kaS.aZH()) {
            if (this.kje instanceof C20174d) {
                i = 0;
            } else {
                i = 1;
            }
        } else if (this.kje instanceof C44725a) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            this.kje.release();
            this.kje = null;
            C4990ab.m7417i("MicroMsg.CardDetailUIContoller", "updateShowLogic, need recreate show logic, card_type:%d", Integer.valueOf(this.kaS.aZV().iAd));
        }
        if (this.kje == null) {
            C4990ab.m7417i("MicroMsg.CardDetailUIContoller", "updateShowLogic, mCardShowLogic == null, card_type:%d", Integer.valueOf(this.kaS.aZV().iAd));
            C4990ab.m7417i("MicroMsg.CardDetailUIContoller", "createShowLogic, card_type:%d", Integer.valueOf(this.kaS.aZV().iAd));
            if (!this.kaS.aZC()) {
                switch (this.kaS.aZV().iAd) {
                    case 0:
                        this.kje = new C20173c(this.kjd);
                        break;
                    case 10:
                        this.kje = new C27617e(this.kjd);
                        break;
                    case 11:
                        this.kje = new C20172b(this.kjd);
                        break;
                    case 20:
                        this.kje = new C38765f(this.kjd);
                        break;
                    case 30:
                        this.kje = new C20174d(this.kjd);
                        break;
                    default:
                        this.kje = new C44725a(this.kjd);
                        break;
                }
            }
            this.kje = new C44841h(this.kjd);
        }
        C4990ab.m7417i("MicroMsg.CardDetailUIContoller", "updateShowLogic, card_tye:%d", Integer.valueOf(this.kaS.aZV().iAd));
        this.kje.mo68381a(this.kaS, this.kjF);
        AppMethodBeat.m2505o(88353);
    }

    /* renamed from: a */
    static /* synthetic */ void m65770a(C38766e c38766e) {
        int i;
        AppMethodBeat.m2504i(88380);
        Intent intent = new Intent();
        if (c38766e.kaS instanceof CardInfo) {
            intent.putExtra("key_card_info_data", (CardInfo) c38766e.kaS);
        } else if (c38766e.kaS instanceof ShareCardInfo) {
            intent.putExtra("key_card_info_data", (ShareCardInfo) c38766e.kaS);
        }
        intent.putExtra("key_from_appbrand_type", c38766e.kjF.kjL);
        intent.setClass(c38766e.kjd, CardShopUI.class);
        c38766e.kjd.startActivity(intent);
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[9];
        objArr[0] = "UsedStoresView";
        objArr[1] = Integer.valueOf(c38766e.kaS.aZV().iAd);
        objArr[2] = c38766e.kaS.baa();
        objArr[3] = c38766e.kaS.aZZ();
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(c38766e.kjF.kgn);
        objArr[6] = c38766e.kjF.kiN;
        if (c38766e.kaS.aZT()) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[7] = Integer.valueOf(i);
        objArr[8] = "";
        c7060h.mo8381e(11324, objArr);
        AppMethodBeat.m2505o(88380);
    }
}
