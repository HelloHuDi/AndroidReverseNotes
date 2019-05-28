package com.tencent.p177mm.plugin.nearby.p469ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.cache.MCacheItem;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.p1207a.C18608f;
import com.tencent.p177mm.model.p1207a.C26407g;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.modelstat.C18686e;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C42041qh;
import com.tencent.p177mm.p230g.p231a.C6497je;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.applet.C36043b;
import com.tencent.p177mm.p612ui.applet.C36043b.C23577b;
import com.tencent.p177mm.p612ui.applet.C36043b.C5234a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p840bn.C9089a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l.C38034a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.nearby.C39456a;
import com.tencent.p177mm.plugin.nearby.p1001a.C28589a;
import com.tencent.p177mm.plugin.nearby.p1001a.C39454d;
import com.tencent.p177mm.plugin.nearby.p1001a.C43333b;
import com.tencent.p177mm.plugin.nearby.p1001a.C46109c;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.report.service.C34830g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.axv;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7570bf;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.LinkedList;
import java.util.List;

@C18524i
/* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI */
public class NearbyFriendsUI extends MMActivity implements C1202f {
    boolean eVT = false;
    private C4884c ecA = new C346101();
    private C26443d ecr;
    private C42206a ecy = new C346128();
    private ListView gxZ;
    private List<axv> lQs = new LinkedList();
    private boolean nOR = false;
    private boolean nPX;
    private List<axv> nQk = new LinkedList();
    private C46109c oPQ;
    private C28597b oQc;
    private C46109c oQd;
    private C39454d oQe;
    private boolean oQf = false;
    private String[] oQg;
    private int oQh = 1;
    private BindMobileOrQQHeaderView oQi;
    private ViewGroup oQj;
    private View oQk;
    private View oQl;
    private boolean oQm = false;
    private int oQn;
    private boolean oQo = false;
    private int oQp = 0;
    private View oQq = null;
    private C12704a oQr;
    private C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$10 */
    class C354710 implements OnItemClickListener {
        C354710() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(55451);
            if (NearbyFriendsUI.this.oQn > 0 || NearbyFriendsUI.this.oQp > 0) {
                i--;
            }
            if (C9089a.dgL() && NearbyFriendsUI.this.oQq != null) {
                i--;
            }
            if (NearbyFriendsUI.this.oQm) {
                i--;
            }
            if (i < 0 || i >= NearbyFriendsUI.this.lQs.size()) {
                AppMethodBeat.m2505o(55451);
                return;
            }
            axv axv = (axv) NearbyFriendsUI.this.lQs.get(i);
            Intent intent;
            if (C34606c.m56747Aa(axv.guN)) {
                String b = C34606c.m56748b(axv);
                C4990ab.m7410d("MicroMsg.NearbyFriend", "poi item click, go:" + C5046bo.nullAsNil(b));
                if (!C5046bo.isNullOrNil(b)) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", b);
                    intent.putExtra("geta8key_scene", 25);
                    intent.putExtra("stastic_scene", 12);
                    C25985d.m41467b(NearbyFriendsUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.m2505o(55451);
                return;
            }
            String str = axv.jBB;
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
            if (C7486a.m12942jh(aoO.field_type)) {
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_User", str);
                intent2.putExtra("Contact_Scene", 18);
                intent2.putExtra("Sns_from_Scene", 18);
                intent2.putExtra("lbs_ticket", axv.wlF);
                intent2.putExtra("Contact_IsLbsGotoChatting", true);
                if (str != null && str.length() > 0) {
                    if (aoO.dsf()) {
                        C7060h.pYm.mo8374X(10298, str + ",18");
                    }
                    C42041qh c42041qh = new C42041qh();
                    c42041qh.cMw.intent = intent2;
                    c42041qh.cMw.username = str;
                    C4879a.xxA.mo10055m(c42041qh);
                    intent2.putExtra("CONTACT_INFO_UI_SOURCE", 5);
                    C39456a.gkE.mo38912c(intent2, NearbyFriendsUI.this);
                }
                AppMethodBeat.m2505o(55451);
                return;
            }
            intent = new Intent();
            intent.putExtra("Contact_User", axv.jBB);
            intent.putExtra("Contact_Alias", axv.guS);
            intent.putExtra("Contact_Nick", axv.jCH);
            intent.putExtra("Contact_Distance", axv.wBS);
            intent.putExtra("Contact_Signature", axv.guQ);
            intent.putExtra("Contact_RegionCode", RegionCodeDecoder.m7796aC(axv.guW, axv.guO, axv.guP));
            intent.putExtra("Contact_Sex", axv.guN);
            intent.putExtra("Contact_IsLBSFriend", true);
            intent.putExtra("Contact_Scene", 18);
            intent.putExtra("Contact_VUser_Info", axv.wBU);
            intent.putExtra("Contact_VUser_Info_Flag", axv.wBT);
            intent.putExtra("Contact_KWeibo_flag", axv.wBX);
            intent.putExtra("Contact_KWeibo", axv.wBV);
            intent.putExtra("Contact_KWeiboNick", axv.wBW);
            intent.putExtra("Contact_KSnsIFlag", axv.wBZ.guY);
            intent.putExtra("Contact_KSnsBgId", axv.wBZ.gva);
            intent.putExtra("Contact_KSnsBgUrl", axv.wBZ.guZ);
            intent.putExtra("lbs_ticket", axv.wlF);
            intent.putExtra("Contact_IsLbsGotoChatting", true);
            if (axv.guX != null) {
                C4925c c16527d = new C16527d();
                c16527d.field_brandList = axv.guX;
                c16527d.field_brandFlag = axv.wCa.gvb;
                c16527d.field_brandIconURL = axv.wCa.gve;
                c16527d.field_extInfo = axv.wCa.gvc;
                c16527d.field_brandInfo = axv.wCa.gvd;
                intent.putExtra("KBrandInfo_item", new MCacheItem(c16527d));
            }
            intent.putExtra("Sns_from_Scene", 18);
            intent.putExtra("CONTACT_INFO_UI_SOURCE", 5);
            C39456a.gkE.mo38912c(intent, NearbyFriendsUI.this);
            AppMethodBeat.m2505o(55451);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$11 */
    class C354811 implements OnTouchListener {
        C354811() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(55452);
            if (NearbyFriendsUI.this.oQc != null) {
                C28597b t = NearbyFriendsUI.this.oQc;
                if (t.gvm != null) {
                    t.gvm.onTouchEvent(motionEvent);
                }
            }
            AppMethodBeat.m2505o(55452);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$12 */
    class C354912 implements OnMenuItemClickListener {
        C354912() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(55453);
            NearbyFriendsUI.this.finish();
            AppMethodBeat.m2505o(55453);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$3 */
    class C127003 implements OnCancelListener {
        C127003() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(55444);
            C1720g.m3540Rg().mo14547c(NearbyFriendsUI.this.oQe);
            AppMethodBeat.m2505o(55444);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$4 */
    class C127014 implements Runnable {
        C127014() {
        }

        public final void run() {
            AppMethodBeat.m2504i(55445);
            C34830g.m57195BO(11);
            AppMethodBeat.m2505o(55445);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$5 */
    class C127025 implements OnClickListener {
        C127025() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(55446);
            NearbyFriendsUI.this.finish();
            AppMethodBeat.m2505o(55446);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$6 */
    class C127036 implements OnClickListener {
        C127036() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$a */
    class C12704a {
        public int accuracy;
        public float fBr;
        public float fBs;

        public C12704a(float f, float f2, int i) {
            this.fBr = f;
            this.fBs = f2;
            this.accuracy = i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$7 */
    class C285957 implements OnCancelListener {
        C285957() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(55447);
            NearbyFriendsUI.this.eVT = true;
            C34830g.m57196BP(11);
            if (NearbyFriendsUI.this.oQd != null) {
                C1720g.m3540Rg().mo14547c(NearbyFriendsUI.this.oQd);
            }
            C4990ab.m7416i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in loading");
            if (!NearbyFriendsUI.this.oQo) {
                NearbyFriendsUI.this.finish();
                C4990ab.m7416i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in first loading");
            }
            AppMethodBeat.m2505o(55447);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$b */
    class C28597b extends BaseAdapter {
        private final Context context;
        C36043b gvm = new C36043b(new C69941());
        private C23577b gvn = null;

        /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$b$1 */
        class C69941 implements C5234a {
            C69941() {
            }

            /* renamed from: wd */
            public final Bitmap mo10738wd(String str) {
                AppMethodBeat.m2504i(55459);
                Bitmap a = C41730b.m73490a(str, false, -1);
                AppMethodBeat.m2505o(55459);
                return a;
            }
        }

        /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$b$2 */
        class C285982 implements C23577b {
            C285982() {
            }

            /* renamed from: mW */
            public final String mo11090mW(int i) {
                AppMethodBeat.m2504i(55460);
                if (i < 0 || i >= C28597b.this.getCount()) {
                    C4990ab.m7412e("MicroMsg.NearbyFriend", "pos is invalid");
                    AppMethodBeat.m2505o(55460);
                    return null;
                }
                axv zZ = C28597b.this.mo46728zZ(i);
                if (zZ == null) {
                    AppMethodBeat.m2505o(55460);
                    return null;
                }
                String str = zZ.jBB;
                AppMethodBeat.m2505o(55460);
                return str;
            }

            public final int apO() {
                AppMethodBeat.m2504i(55461);
                int count = C28597b.this.getCount();
                AppMethodBeat.m2505o(55461);
                return count;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(55466);
            axv zZ = mo46728zZ(i);
            AppMethodBeat.m2505o(55466);
            return zZ;
        }

        public C28597b(Context context) {
            AppMethodBeat.m2504i(55462);
            this.context = context;
            AppMethodBeat.m2505o(55462);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(55463);
            int size = NearbyFriendsUI.this.lQs.size();
            AppMethodBeat.m2505o(55463);
            return size;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C34607d c34607d;
            AppMethodBeat.m2504i(55464);
            if (this.gvn == null) {
                this.gvn = new C285982();
            }
            if (this.gvm != null) {
                this.gvm.mo56803a(i, this.gvn);
            }
            if (view == null) {
                C34607d c34607d2 = new C34607d();
                view = View.inflate(this.context, 2130970289, null);
                c34607d2.gtG = (TextView) view.findViewById(2131823616);
                c34607d2.oQA = (TextView) view.findViewById(2131826309);
                c34607d2.oQz = (TextView) view.findViewById(2131826303);
                c34607d2.gvq = (ImageView) view.findViewById(2131823615);
                c34607d2.gvr = (TextView) view.findViewById(2131826300);
                c34607d2.oQB = (ImageView) view.findViewById(2131826302);
                c34607d2.oQC = (ImageView) view.findViewById(2131826304);
                c34607d2.oQE = (ImageView) view.findViewById(2131826305);
                c34607d2.oQF = (ImageView) view.findViewById(2131826306);
                c34607d2.oQG = (ImageView) view.findViewById(2131826307);
                LayoutParams layoutParams = c34607d2.oQC.getLayoutParams();
                layoutParams.height = C1338a.m2856al(this.context, C25738R.dimen.f9979m4);
                layoutParams.width = C1338a.m2856al(this.context, C25738R.dimen.f9979m4);
                c34607d2.oQC.setLayoutParams(layoutParams);
                c34607d2.oQD = (ImageView) view.findViewById(2131826301);
                view.setTag(c34607d2);
                c34607d = c34607d2;
            } else {
                c34607d = (C34607d) view.getTag();
            }
            axv axv = (axv) NearbyFriendsUI.this.lQs.get(i);
            c34607d.gtG.setText(C44089j.m79293b(this.context, axv.jCH, c34607d.gtG.getTextSize()));
            if (NearbyFriendsUI.this.oQh == 1) {
                switch (axv.guN) {
                    case 1:
                        c34607d.oQD.setVisibility(0);
                        c34607d.oQD.setImageResource(C1318a.ic_sex_male);
                        c34607d.oQD.setContentDescription(this.context.getString(C25738R.string.cwa));
                        break;
                    case 2:
                        c34607d.oQD.setVisibility(0);
                        c34607d.oQD.setImageResource(C1318a.ic_sex_female);
                        c34607d.oQD.setContentDescription(this.context.getString(C25738R.string.bsl));
                        break;
                    default:
                        c34607d.oQD.setVisibility(8);
                        break;
                }
            }
            c34607d.oQD.setVisibility(8);
            if (axv.wBT != 0) {
                c34607d.oQB.setVisibility(0);
                c34607d.oQB.setImageBitmap(C4977b.m7374i(C26417a.flw.mo37872ky(axv.wBT), 2.0f));
                c34607d.oQD.setVisibility(8);
            } else {
                c34607d.oQB.setVisibility(8);
            }
            c34607d.oQz.setText(axv.wBS);
            c34607d.oQE.setVisibility(8);
            c34607d.oQF.setVisibility(8);
            c34607d.oQG.setVisibility(8);
            if (axv instanceof C28589a) {
                LinkedList linkedList = ((C28589a) axv).oPv;
                if (linkedList != null && linkedList.size() == 1) {
                    c34607d.oQE.setVisibility(0);
                    NearbyFriendsUI.m56769o(c34607d.oQE, (String) linkedList.get(0));
                } else if (linkedList != null && linkedList.size() == 2) {
                    c34607d.oQE.setVisibility(0);
                    c34607d.oQF.setVisibility(0);
                    NearbyFriendsUI.m56769o(c34607d.oQE, (String) linkedList.get(0));
                    NearbyFriendsUI.m56769o(c34607d.oQF, (String) linkedList.get(1));
                } else if (linkedList != null && linkedList.size() >= 3) {
                    c34607d.oQE.setVisibility(0);
                    c34607d.oQF.setVisibility(0);
                    c34607d.oQG.setVisibility(0);
                    NearbyFriendsUI.m56769o(c34607d.oQE, (String) linkedList.get(0));
                    NearbyFriendsUI.m56769o(c34607d.oQF, (String) linkedList.get(1));
                    NearbyFriendsUI.m56769o(c34607d.oQG, (String) linkedList.get(2));
                }
            }
            if (axv.guQ == null || axv.guQ.trim().equals("")) {
                c34607d.oQA.setVisibility(8);
            } else {
                c34607d.oQA.setVisibility(0);
                c34607d.oQA.setText(C44089j.m79293b(this.context, axv.guQ, c34607d.oQA.getTextSize()));
            }
            if (axv.wBZ == null || (axv.wBZ.guY & 1) <= 0) {
                c34607d.oQC.setVisibility(8);
            } else {
                c34607d.oQC.setVisibility(0);
            }
            if (C34606c.m56747Aa(axv.guN)) {
                c34607d.gvq.setImageBitmap(null);
                C17927a c17927a = new C17927a();
                c17927a.ePK = C43217c.m76863XW();
                c17927a.ePH = true;
                c17927a.ePZ = true;
                C32291o.ahp().mo43766a(axv.jBB, c34607d.gvq, c17927a.ahG());
                if (!C5046bo.isNullOrNil(axv.guS)) {
                    c34607d.gvr.setText(axv.guS);
                    c34607d.gvr.setVisibility(0);
                }
                c34607d.gvr.setVisibility(8);
            } else {
                C40460b.m69434b(c34607d.gvq, axv.jBB);
                if (((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoJ(axv.jBB)) {
                    c34607d.gvr.setVisibility(0);
                    if (C7616ad.m13547Mn(axv.wBT)) {
                        c34607d.gvr.setText(NearbyFriendsUI.this.getString(C25738R.string.d4p));
                    } else {
                        C7616ad aoM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoM(axv.jBB);
                        if (aoM != null) {
                            c34607d.gtG.setText(C44089j.m79293b(this.context, C5046bo.isNullOrNil(aoM.mo16707Oj()) ? axv.jCH : aoM.mo16707Oj(), c34607d.gtG.getTextSize()));
                        }
                        c34607d.gvr.setText(NearbyFriendsUI.this.getString(C25738R.string.d4u));
                    }
                }
                c34607d.gvr.setVisibility(8);
            }
            AppMethodBeat.m2505o(55464);
            return view;
        }

        /* renamed from: zZ */
        public final axv mo46728zZ(int i) {
            AppMethodBeat.m2504i(55465);
            axv axv = (axv) NearbyFriendsUI.this.lQs.get(i);
            AppMethodBeat.m2505o(55465);
            return axv;
        }

        public final long getItemId(int i) {
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$c */
    static class C34606c {
        public static int oQy = Downloads.MIN_WAIT_FOR_NETWORK;

        /* renamed from: Aa */
        public static boolean m56747Aa(int i) {
            return i == oQy;
        }

        /* renamed from: b */
        public static String m56748b(axv axv) {
            if (axv != null) {
                return axv.guO;
            }
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$d */
    static class C34607d {
        TextView gtG;
        ImageView gvq;
        TextView gvr;
        TextView oQA;
        ImageView oQB;
        ImageView oQC;
        ImageView oQD;
        ImageView oQE;
        ImageView oQF;
        ImageView oQG;
        TextView oQz;

        C34607d() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$14 */
    class C3460814 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$14$1 */
        class C285941 implements C5279d {

            /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$14$1$1 */
            class C35501 implements OnCancelListener {
                C35501() {
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(55455);
                    C1720g.m3540Rg().mo14547c(NearbyFriendsUI.this.oPQ);
                    AppMethodBeat.m2505o(55455);
                }
            }

            C285941() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(55456);
                switch (i) {
                    case 0:
                        NearbyFriendsUI.this.oQh = 4;
                        NearbyFriendsUI.this.oQf = false;
                        C1720g.m3536RP().mo5239Ry().set(16386, Integer.valueOf(NearbyFriendsUI.this.oQh));
                        NearbyFriendsUI.m56776v(NearbyFriendsUI.this);
                        AppMethodBeat.m2505o(55456);
                        return;
                    case 1:
                        NearbyFriendsUI.this.oQh = 3;
                        NearbyFriendsUI.this.oQf = false;
                        C1720g.m3536RP().mo5239Ry().set(16386, Integer.valueOf(NearbyFriendsUI.this.oQh));
                        NearbyFriendsUI.m56776v(NearbyFriendsUI.this);
                        AppMethodBeat.m2505o(55456);
                        return;
                    case 2:
                        NearbyFriendsUI.this.oQh = 1;
                        NearbyFriendsUI.this.oQf = false;
                        C1720g.m3536RP().mo5239Ry().set(16386, Integer.valueOf(NearbyFriendsUI.this.oQh));
                        NearbyFriendsUI.m56776v(NearbyFriendsUI.this);
                        AppMethodBeat.m2505o(55456);
                        return;
                    case 3:
                        Intent intent = new Intent(NearbyFriendsUI.this, NearbySayHiListUI.class);
                        intent.putExtra("k_say_hi_type", 2);
                        NearbyFriendsUI.this.startActivityForResult(intent, 2009);
                        AppMethodBeat.m2505o(55456);
                        return;
                    case 4:
                        NearbyFriendsUI.this.oPQ = new C46109c(2, 0.0f, 0.0f, 0, 0, "", "");
                        C1720g.m3540Rg().mo14541a(NearbyFriendsUI.this.oPQ, 0);
                        NearbyFriendsUI nearbyFriendsUI = NearbyFriendsUI.this;
                        Context context = NearbyFriendsUI.this.mController.ylL;
                        NearbyFriendsUI.this.getString(C25738R.string.f9238tz);
                        nearbyFriendsUI.tipDialog = C30379h.m48458b(context, NearbyFriendsUI.this.getString(C25738R.string.d4m), true, new C35501());
                        break;
                }
                AppMethodBeat.m2505o(55456);
            }
        }

        /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$14$2 */
        class C346092 implements C36073c {
            C346092() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(55457);
                c44273l.mo70072hi(-1, C25738R.string.d4z);
                c44273l.mo70072hi(-1, C25738R.string.d4y);
                c44273l.mo70072hi(-1, C25738R.string.d4x);
                c44273l.mo70072hi(-1, C25738R.string.dx5);
                c44273l.mo70072hi(-1, C25738R.string.d4i);
                AppMethodBeat.m2505o(55457);
            }
        }

        C3460814() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(55458);
            C36356d c36356d = new C36356d(NearbyFriendsUI.this, 1, false);
            c36356d.rBm = new C285941();
            c36356d.rBl = new C346092();
            c36356d.cpD();
            AppMethodBeat.m2505o(55458);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$1 */
    class C346101 extends C4884c<C6497je> {

        /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$1$1 */
        class C346111 implements Runnable {
            C346111() {
            }

            public final void run() {
                AppMethodBeat.m2504i(55440);
                NearbyFriendsUI.m56753a(NearbyFriendsUI.this);
                AppMethodBeat.m2505o(55440);
            }
        }

        C346101() {
            AppMethodBeat.m2504i(55441);
            this.xxI = C6497je.class.getName().hashCode();
            AppMethodBeat.m2505o(55441);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(55442);
            C6497je c6497je = (C6497je) c4883b;
            if (c6497je != null && (c6497je instanceof C6497je)) {
                C5004al.m7441d(new C346111());
            }
            AppMethodBeat.m2505o(55442);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$8 */
    class C346128 implements C42206a {

        /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$8$1 */
        class C285961 implements OnClickListener {
            C285961() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(55448);
                C26443d.m42103bX(NearbyFriendsUI.this);
                AppMethodBeat.m2505o(55448);
            }
        }

        C346128() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(55449);
            if (NearbyFriendsUI.this.nOR) {
                AppMethodBeat.m2505o(55449);
                return false;
            }
            NearbyFriendsUI.this.nOR = true;
            if (NearbyFriendsUI.this.eVT) {
                if (NearbyFriendsUI.this.tipDialog != null) {
                    NearbyFriendsUI.this.tipDialog.dismiss();
                    NearbyFriendsUI.this.tipDialog = null;
                }
                C34830g.m57196BP(11);
                AppMethodBeat.m2505o(55449);
                return false;
            }
            if (z) {
                boolean z2;
                if (NearbyFriendsUI.this.tipDialog != null) {
                    NearbyFriendsUI.this.tipDialog.setMessage(NearbyFriendsUI.this.getString(C25738R.string.d4o));
                }
                NearbyFriendsUI.this.oQr = new C12704a(f2, f, (int) d2);
                C18686e akf = C18686e.akf();
                boolean z3 = i != 0;
                if (NearbyFriendsUI.this.ecr == null) {
                    z2 = false;
                } else {
                    z2 = NearbyFriendsUI.this.ecr.fBD;
                }
                akf.mo33956a(2001, z3, z2, f, f2, (int) d2);
                NearbyFriendsUI.this.oQd = new C46109c(NearbyFriendsUI.this.oQh, NearbyFriendsUI.this.oQr.fBs, NearbyFriendsUI.this.oQr.fBr, NearbyFriendsUI.this.oQr.accuracy, i, "", "");
                C1720g.m3540Rg().mo14541a(NearbyFriendsUI.this.oQd, 0);
            } else {
                C34830g.m57196BP(11);
                if (NearbyFriendsUI.this.tipDialog != null) {
                    NearbyFriendsUI.this.tipDialog.dismiss();
                    NearbyFriendsUI.this.tipDialog = null;
                }
                NearbyFriendsUI.this.findViewById(2131826298).setVisibility(0);
                NearbyFriendsUI.this.gxZ.setVisibility(8);
                NearbyFriendsUI.this.oQo = true;
                if (!(NearbyFriendsUI.this.nPX || C26443d.agA())) {
                    NearbyFriendsUI.this.nPX = true;
                    C30379h.m48445a(NearbyFriendsUI.this, NearbyFriendsUI.this.getString(C25738R.string.c9z), NearbyFriendsUI.this.getString(C25738R.string.f9238tz), NearbyFriendsUI.this.getString(C25738R.string.ckr), NearbyFriendsUI.this.getString(C25738R.string.f9076or), false, new C285961(), null);
                }
            }
            AppMethodBeat.m2505o(55449);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$13 */
    class C3461313 implements View.OnClickListener {
        C3461313() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(55454);
            C4978c.m7375a(NearbyFriendsUI.this.gxZ);
            AppMethodBeat.m2505o(55454);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$2 */
    class C346142 implements View.OnClickListener {
        C346142() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(55443);
            NearbyFriendsUI.m56778x(NearbyFriendsUI.this);
            AppMethodBeat.m2505o(55443);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI$9 */
    class C346159 implements View.OnClickListener {
        C346159() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(55450);
            NearbyFriendsUI.this.gxZ.removeHeaderView(NearbyFriendsUI.this.oQq);
            NearbyFriendsUI.this.oQq = null;
            Intent intent = new Intent(NearbyFriendsUI.this, NearbySayHiListUI.class);
            intent.putExtra("k_say_hi_type", 2);
            intent.putExtra("show_clear_header", true);
            NearbyFriendsUI.this.startActivityForResult(intent, 2009);
            AppMethodBeat.m2505o(55450);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public NearbyFriendsUI() {
        AppMethodBeat.m2504i(55467);
        AppMethodBeat.m2505o(55467);
    }

    /* renamed from: a */
    static /* synthetic */ void m56753a(NearbyFriendsUI nearbyFriendsUI) {
        AppMethodBeat.m2504i(55479);
        nearbyFriendsUI.bVd();
        AppMethodBeat.m2505o(55479);
    }

    /* renamed from: v */
    static /* synthetic */ void m56776v(NearbyFriendsUI nearbyFriendsUI) {
        AppMethodBeat.m2504i(55480);
        nearbyFriendsUI.getData();
        AppMethodBeat.m2505o(55480);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(55468);
        C34830g.m57194BN(11);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.d57);
        C1720g.m3540Rg().mo14539a(148, (C1202f) this);
        C1720g.m3540Rg().mo14539a(376, (C1202f) this);
        C1720g.m3540Rg().mo14539a((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_BUDING, (C1202f) this);
        this.ecr = C26443d.agz();
        initView();
        this.oQg = new String[]{getResources().getString(C25738R.string.d4z), getResources().getString(C25738R.string.d4y), getResources().getString(C25738R.string.d4x), getResources().getString(C25738R.string.dx5)};
        this.oQh = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(16386, null), 1);
        if (this.oQh == 3) {
            mo17370MZ(C1318a.ic_sex_male);
        } else if (this.oQh == 4) {
            mo17370MZ(C1318a.ic_sex_female);
        } else {
            mo17370MZ(0);
            this.oQh = 1;
        }
        getData();
        AppMethodBeat.m2505o(55468);
    }

    private void getData() {
        AppMethodBeat.m2504i(55469);
        this.nOR = false;
        Context context = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        this.tipDialog = C30379h.m48458b(context, getString(C25738R.string.d4w), true, new C285957());
        this.eVT = false;
        if (this.ecr != null) {
            this.ecr.mo44204a(this.ecy, true);
        }
        AppMethodBeat.m2505o(55469);
    }

    public final int getLayoutId() {
        return 2130970287;
    }

    private void bVd() {
        AppMethodBeat.m2504i(55470);
        if (C9089a.dgL()) {
            View view;
            if (this.oQq != null) {
                this.gxZ.removeHeaderView(this.oQq);
                this.oQq = null;
            }
            View inflate = View.inflate(this, 2130970291, null);
            TextView textView = (TextView) inflate.findViewById(2131824687);
            C1720g.m3534RN().mo5159QU();
            int baS = ((C6982j) C1720g.m3528K(C6982j.class)).bOo().baS();
            if (baS == 0) {
                inflate.setVisibility(8);
                view = null;
            } else {
                inflate.setVisibility(0);
                textView.setText(getResources().getQuantityString(C25738R.plurals.f9615a1, baS, new Object[]{Integer.valueOf(baS)}));
                ImageView imageView = (ImageView) inflate.findViewById(2131824686);
                C7570bf bOx = ((C6982j) C1720g.m3528K(C6982j.class)).bOo().bOx();
                if (bOx != null) {
                    C40460b.m69434b(imageView, bOx.field_sayhiuser);
                }
                inflate.setOnClickListener(new C346159());
                view = inflate;
            }
            this.oQq = view;
            if (this.oQq != null) {
                this.gxZ.addHeaderView(this.oQq);
            }
        }
        AppMethodBeat.m2505o(55470);
    }

    public final void initView() {
        AppMethodBeat.m2504i(55471);
        this.gxZ = (ListView) findViewById(2131826296);
        this.oQc = new C28597b(this);
        this.gxZ.addHeaderView(bVe());
        String value = C26373g.m41964Nu().getValue("LBSShowBindPhone");
        if (value != null && value.length() > 0) {
            try {
                this.oQn = Integer.valueOf(value).intValue();
            } catch (Exception e) {
                this.oQn = 0;
            }
        }
        value = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        if (value != null && value.length() > 0) {
            this.oQn = 0;
        }
        this.oQp = 0;
        if (C26407g.aaK().mo60654oP(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) != null) {
            value = C26407g.aaK().mo60654oP(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL).value;
            C38034a apS = C38033l.apS();
            if (value.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                this.oQp = 0;
            } else if (value.equals("2")) {
                if (apS == C38034a.SUCC_UNLOAD) {
                    this.oQp = 2;
                    C18608f.m29044oT(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                }
            } else if (value.equals("1") && apS == C38034a.NO_INIT) {
                this.oQp = 2;
                C18608f.m29044oT(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            }
        }
        if ((this.oQn > 0 || this.oQp > 0) && this.oQp != 1) {
            this.oQi = new BindMobileOrQQHeaderView(this);
            this.gxZ.addHeaderView(this.oQi);
        }
        this.gxZ.setAdapter(this.oQc);
        this.gxZ.setOnItemClickListener(new C354710());
        this.gxZ.setOnTouchListener(new C354811());
        setBackBtn(new C354912());
        C3461313 c3461313 = new C3461313();
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C3460814());
        AppMethodBeat.m2505o(55471);
    }

    private View bVe() {
        AppMethodBeat.m2504i(55472);
        if (this.oQj == null) {
            this.oQj = new LinearLayout(this);
            this.oQj.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ((LinearLayout) this.oQj).setGravity(17);
        }
        this.oQm = true;
        ViewGroup viewGroup = this.oQj;
        AppMethodBeat.m2505o(55472);
        return viewGroup;
    }

    private void bVf() {
        AppMethodBeat.m2504i(55473);
        C39456a.gkE.mo38908bg(this);
        AppMethodBeat.m2505o(55473);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(55474);
        C4990ab.m7411d("MicroMsg.NearbyFriend", "onActivityResult, requestCode %s, resultCode %s", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.oQf = false;
                    getData();
                    AppMethodBeat.m2505o(55474);
                    return;
                }
                break;
            case 2009:
                if (i2 == -1) {
                    finish();
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(55474);
    }

    public void onPause() {
        AppMethodBeat.m2504i(55475);
        super.onPause();
        if (this.ecr != null) {
            this.ecr.mo44208c(this.ecy);
        }
        C4879a.xxA.mo10053d(this.ecA);
        AppMethodBeat.m2505o(55475);
    }

    public void onResume() {
        AppMethodBeat.m2504i(55476);
        super.onResume();
        if (this.ecr != null) {
            this.ecr.mo44204a(this.ecy, true);
        }
        bVd();
        this.oQc.notifyDataSetChanged();
        C1720g.m3534RN().mo5159QU();
        if (((C6982j) C1720g.m3528K(C6982j.class)).bOo().baS() == 0) {
            this.gxZ.removeHeaderView(this.oQl);
        }
        C4879a.xxA.mo10052c(this.ecA);
        AppMethodBeat.m2505o(55476);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(55477);
        if (this.oQp > 0) {
            C18608f.m29045oU(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        }
        C34830g.m57196BP(11);
        C1720g.m3540Rg().mo14546b(148, (C1202f) this);
        C1720g.m3540Rg().mo14546b(376, (C1202f) this);
        C1720g.m3540Rg().mo14546b((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_BUDING, (C1202f) this);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (this.ecr != null) {
            this.ecr.mo44208c(this.ecy);
        }
        C17884o.acv().cancel();
        if (this.oQc != null) {
            C28597b c28597b = this.oQc;
            if (c28597b.gvm != null) {
                c28597b.gvm.detach();
                c28597b.gvm = null;
            }
        }
        super.onDestroy();
        AppMethodBeat.m2505o(55477);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(55478);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (c1207m.getType() == 148) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            int Ah = ((C46109c) c1207m).mo74036Ah();
            if (this.oQd == null && (Ah == 1 || Ah == 3 || Ah == 4)) {
                AppMethodBeat.m2505o(55478);
                return;
            } else if ((Ah == 1 || Ah == 3 || Ah == 4) && this.oQf) {
                C4990ab.m7419v("MicroMsg.NearbyFriend", "onSceneEnd data already requested, code=%d", Integer.valueOf(Ah));
                AppMethodBeat.m2505o(55478);
                return;
            } else if (this.oPQ == null && Ah == 2) {
                AppMethodBeat.m2505o(55478);
                return;
            } else {
                C4990ab.m7417i("MicroMsg.NearbyFriend", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (c1207m.getType() != 148) {
                    AppMethodBeat.m2505o(55478);
                    return;
                } else if (i == 0 && i2 == 0) {
                    int i3;
                    if (Ah == 1 || Ah == 3 || Ah == 4) {
                        this.lQs = ((C46109c) c1207m).bUZ();
                        if (this.lQs == null || this.lQs.size() == 0) {
                            findViewById(2131826297).setVisibility(0);
                            this.gxZ.setVisibility(8);
                            bVf();
                            C34830g.m57196BP(11);
                        } else {
                            LinkedList linkedList = new LinkedList();
                            i3 = 0;
                            for (axv axv : this.lQs) {
                                if (((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoJ(axv.jBB)) {
                                    linkedList.add(i3, axv);
                                    i3++;
                                } else if (!(C5046bo.isNullOrNil(axv.jBB) || C5046bo.isNullOrNil(axv.wBS))) {
                                    linkedList.add(axv);
                                }
                            }
                            this.lQs.clear();
                            this.lQs = linkedList;
                            if (this.nQk != null) {
                                for (Ah = this.nQk.size() - 1; Ah >= 0; Ah--) {
                                    if (this.nQk.get(Ah) != null) {
                                        this.lQs.add(0, this.nQk.get(Ah));
                                    }
                                }
                            }
                            if (this.lQs == null || this.lQs.size() == 0) {
                                findViewById(2131826297).setVisibility(0);
                                this.gxZ.setVisibility(8);
                            } else {
                                findViewById(2131826297).setVisibility(8);
                                this.oQc.notifyDataSetChanged();
                                if (this.oQc.getCount() > 0) {
                                    this.gxZ.setSelection(0);
                                }
                                this.gxZ.post(new C127014());
                            }
                        }
                        if (this.oQh == 3) {
                            mo17370MZ(C1318a.ic_sex_male);
                        } else if (this.oQh == 4) {
                            mo17370MZ(C1318a.ic_sex_female);
                        } else {
                            mo17370MZ(0);
                            this.oQh = 1;
                        }
                        this.oQf = true;
                        this.oQd = null;
                    }
                    if (((C46109c) c1207m).mo74036Ah() == 2) {
                        C30379h.m48438a(this.mController.ylL, getString(C25738R.string.d4l), "", new C127025());
                        this.oPQ = null;
                    }
                    if (((C46109c) c1207m).bUX()) {
                        String string = getString(C25738R.string.d5_);
                        i3 = ((C46109c) c1207m).bUY();
                        if (this.oQj != null) {
                            if (this.oQk == null) {
                                this.oQk = View.inflate(this, 2130970292, null);
                                this.oQj.addView(this.oQk);
                                this.oQk.setOnClickListener(new C346142());
                            } else {
                                this.oQk.setVisibility(0);
                            }
                            ((TextView) this.oQk.findViewById(2131826311)).setText(string);
                            if (i3 != 0) {
                                ((TextView) this.oQk.findViewById(2131826312)).setText(String.format(getResources().getQuantityString(C25738R.plurals.f9608u, i3, new Object[]{Integer.valueOf(i3)}), new Object[0]));
                            }
                        }
                    } else if (!(this.oQk == null || this.oQj == null)) {
                        this.oQk.setVisibility(8);
                    }
                    this.oQo = true;
                    AppMethodBeat.m2505o(55478);
                    return;
                } else {
                    if (Ah == 1 || Ah == 3 || Ah == 4) {
                        C42124a c42124a;
                        TextView textView = (TextView) findViewById(2131826297);
                        textView.setVisibility(0);
                        bVf();
                        if (str == null || str.length() <= 0) {
                            c42124a = null;
                        } else {
                            c42124a = C42124a.m74268jY(str);
                        }
                        if (c42124a != null && c42124a.desc != null && c42124a.desc.length() > 0) {
                            textView.setText(c42124a.desc);
                        } else if (i2 == -2001) {
                            textView.setText(getString(C25738R.string.d4n));
                        } else {
                            textView.setText(getString(C25738R.string.d4q));
                        }
                        this.gxZ.setVisibility(8);
                        this.oQd = null;
                    }
                    if (((C46109c) c1207m).mo74036Ah() == 2) {
                        Toast.makeText(this, C25738R.string.d4k, 1).show();
                        this.oPQ = null;
                    }
                    AppMethodBeat.m2505o(55478);
                    return;
                }
            }
        }
        if (c1207m.getType() == 376) {
            if (((C39454d) c1207m).mo62404Ah() != 1) {
                AppMethodBeat.m2505o(55478);
                return;
            }
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i == 0 && i2 == 0 && ((C39454d) c1207m).gfa != null) {
                String str2 = ((C39454d) c1207m).gfa;
                C43333b.m77313fr(str2, ((C39454d) c1207m).oPy);
                Intent intent = new Intent();
                intent.putExtra("Chat_User", str2);
                C39456a.gkE.mo38917e(intent, (Context) this);
                AppMethodBeat.m2505o(55478);
                return;
            }
            C30379h.m48431a(this.mController.ylL, (int) C25738R.string.d58, (int) C25738R.string.f9238tz, new C127036());
        }
        AppMethodBeat.m2505o(55478);
    }

    /* renamed from: x */
    static /* synthetic */ void m56778x(NearbyFriendsUI nearbyFriendsUI) {
        AppMethodBeat.m2504i(55481);
        if (nearbyFriendsUI.oQr != null) {
            nearbyFriendsUI.oQe = new C39454d(nearbyFriendsUI.oQr.fBs, nearbyFriendsUI.oQr.fBr, nearbyFriendsUI.oQr.accuracy, "", "");
            Context context = nearbyFriendsUI.mController.ylL;
            nearbyFriendsUI.getString(C25738R.string.f9238tz);
            nearbyFriendsUI.tipDialog = C30379h.m48458b(context, nearbyFriendsUI.getString(C25738R.string.d59), true, new C127003());
            C43333b.m77314zY(3);
            C1720g.m3540Rg().mo14541a(nearbyFriendsUI.oQe, 0);
        }
        AppMethodBeat.m2505o(55481);
    }

    /* renamed from: o */
    static /* synthetic */ void m56769o(ImageView imageView, String str) {
        AppMethodBeat.m2504i(55482);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.NearbyFriend", "setImgBmp url is empty");
            AppMethodBeat.m2505o(55482);
            return;
        }
        imageView.setImageBitmap(null);
        C17927a c17927a = new C17927a();
        c17927a.ePK = C43217c.m76863XW();
        c17927a.ePH = true;
        c17927a.ePZ = true;
        C32291o.ahp().mo43766a(str, imageView, c17927a.ahG());
        AppMethodBeat.m2505o(55482);
    }
}
