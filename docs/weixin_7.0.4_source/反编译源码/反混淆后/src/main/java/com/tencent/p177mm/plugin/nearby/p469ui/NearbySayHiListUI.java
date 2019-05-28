package com.tencent.p177mm.plugin.nearby.p469ui;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C37732i;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.MMSlideDelView;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23597d;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p840bn.C9089a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.nearby.C39456a;
import com.tencent.p177mm.plugin.nearby.p1001a.C46109c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C35998bg;
import com.tencent.p177mm.storage.C7570bf;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi.C5138d;

/* renamed from: com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI */
public class NearbySayHiListUI extends MMActivity implements C1202f {
    private int ehD = 0;
    private ListView gtT;
    private View gwR;
    private C5279d jKa = new C213613();
    private int limit = 0;
    private C46109c oPQ;
    private C35998bg oQI = null;
    private C21366a oQJ;
    private int oQK = 0;
    private int oQL = 0;
    private boolean oQM;
    private long oQN;
    private C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI$4 */
    class C127054 implements OnClickListener {
        C127054() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(55496);
            NearbySayHiListUI.this.setResult(-1);
            NearbySayHiListUI.this.finish();
            AppMethodBeat.m2505o(55496);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI$5 */
    class C127065 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI$5$1 */
        class C127071 implements OnClickListener {
            C127071() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(55497);
                NearbySayHiListUI.this.oQI.axQ();
                NearbySayHiListUI.this.oQJ.mo6869KC();
                TextView textView = (TextView) NearbySayHiListUI.this.findViewById(2131821807);
                textView.setText(C25738R.string.dx8);
                textView.setVisibility(0);
                NearbySayHiListUI.this.enableOptionMenu(false);
                AppMethodBeat.m2505o(55497);
            }
        }

        C127065() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(55498);
            C30379h.m48453a(NearbySayHiListUI.this.mController.ylL, true, NearbySayHiListUI.this.getResources().getString(C25738R.string.dx3), "", NearbySayHiListUI.this.getResources().getString(C25738R.string.dx2), NearbySayHiListUI.this.getString(C25738R.string.f9076or), new C127071(), null);
            AppMethodBeat.m2505o(55498);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI$2 */
    class C213572 implements View.OnClickListener {
        C213572() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(55494);
            C4978c.m7375a(NearbySayHiListUI.this.gtT);
            AppMethodBeat.m2505o(55494);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI$12 */
    class C2136012 implements OnMenuItemClickListener {
        C2136012() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(55506);
            NearbySayHiListUI.this.aqX();
            NearbySayHiListUI.this.setResult(0);
            NearbySayHiListUI.this.finish();
            AppMethodBeat.m2505o(55506);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI$3 */
    class C213613 implements C5279d {
        C213613() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(55495);
            C1720g.m3534RN().mo5159QU();
            ((C6982j) C1720g.m3528K(C6982j.class)).bOo().mo15229QT(String.valueOf(NearbySayHiListUI.this.oQN));
            NearbySayHiListUI.this.oQJ.mo5248a(null, null);
            if (NearbySayHiListUI.this.oQK > 0) {
                NearbySayHiListUI.this.oQK = NearbySayHiListUI.this.oQK - 1;
            }
            NearbySayHiListUI.m32771j(NearbySayHiListUI.this);
            AppMethodBeat.m2505o(55495);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI$6 */
    class C213626 implements View.OnClickListener {

        /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI$6$1 */
        class C213581 implements OnCancelListener {
            C213581() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(55499);
                C1720g.m3540Rg().mo14547c(NearbySayHiListUI.this.oPQ);
                AppMethodBeat.m2505o(55499);
            }
        }

        C213626() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(55500);
            NearbySayHiListUI.this.oPQ = new C46109c(2, 0.0f, 0.0f, 0, 0, "", "");
            C1720g.m3540Rg().mo14541a(NearbySayHiListUI.this.oPQ, 0);
            NearbySayHiListUI nearbySayHiListUI = NearbySayHiListUI.this;
            Context context = NearbySayHiListUI.this.mController.ylL;
            NearbySayHiListUI.this.getString(C25738R.string.f9238tz);
            nearbySayHiListUI.tipDialog = C30379h.m48458b(context, NearbySayHiListUI.this.getString(C25738R.string.d4m), true, new C213581());
            C7060h.pYm.mo8374X(11429, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            AppMethodBeat.m2505o(55500);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI$7 */
    class C213637 implements C15521c {
        C213637() {
        }

        /* renamed from: cZ */
        public final int mo8831cZ(View view) {
            AppMethodBeat.m2504i(55501);
            int positionForView = NearbySayHiListUI.this.gtT.getPositionForView(view);
            AppMethodBeat.m2505o(55501);
            return positionForView;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI$8 */
    class C213648 implements C23600g {
        C213648() {
        }

        /* renamed from: q */
        public final void mo11108q(View view, int i, int i2) {
            AppMethodBeat.m2504i(55502);
            NearbySayHiListUI.this.gtT.performItemClick(view, i, (long) i2);
            AppMethodBeat.m2505o(55502);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI$9 */
    class C213659 implements C23599f {
        C213659() {
        }

        /* renamed from: bN */
        public final void mo11067bN(Object obj) {
            AppMethodBeat.m2504i(55503);
            if (obj == null) {
                C4990ab.m7412e("MicroMsg.SayHiListUI", "onItemDel object null");
                AppMethodBeat.m2505o(55503);
                return;
            }
            C1720g.m3534RN().mo5159QU();
            ((C6982j) C1720g.m3528K(C6982j.class)).bOo().mo15229QT(obj.toString());
            NearbySayHiListUI.this.oQJ.mo5248a(null, null);
            AppMethodBeat.m2505o(55503);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI$a */
    class C21366a extends C46692p<C7570bf> {
        private MMActivity crP;
        protected C23600g jJO;
        protected C15521c jJP;
        protected C23597d jJR = MMSlideDelView.getItemStatusCallBack();
        int limit = -1;
        private C35998bg oQI;
        protected C23599f oQS;

        /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI$a$1 */
        class C213591 implements View.OnClickListener {
            C213591() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(55507);
                C4990ab.m7418v("MicroMsg.SayHiAdapter", "on delView clicked");
                C21366a.this.jJR.bIq();
                if (C21366a.this.oQS != null) {
                    C21366a.this.oQS.mo11067bN(view.getTag());
                }
                AppMethodBeat.m2505o(55507);
            }
        }

        /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI$a$a */
        class C21367a {
            ImageView eks;
            TextView gtG;
            View jJW;
            TextView jJX;
            TextView ooM;

            C21367a() {
            }
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
            AppMethodBeat.m2504i(55512);
            C7570bf c7570bf = (C7570bf) obj;
            if (c7570bf == null) {
                c7570bf = new C7570bf();
            }
            c7570bf.mo8995d(cursor);
            AppMethodBeat.m2505o(55512);
            return c7570bf;
        }

        public C21366a(Context context, C35998bg c35998bg, int i) {
            super(context, new C7570bf());
            AppMethodBeat.m2504i(55508);
            this.crP = (MMActivity) context;
            this.limit = i;
            this.oQI = c35998bg;
            AppMethodBeat.m2505o(55508);
        }

        public final void setPerformItemClickListener(C23600g c23600g) {
            this.jJO = c23600g;
        }

        /* renamed from: a */
        public final void mo36822a(C23599f c23599f) {
            this.oQS = c23599f;
        }

        public final void setGetViewPositionCallback(C15521c c15521c) {
            this.jJP = c15521c;
        }

        /* renamed from: KD */
        public final void mo6870KD() {
            AppMethodBeat.m2504i(55509);
            mo6869KC();
            AppMethodBeat.m2505o(55509);
        }

        /* renamed from: KC */
        public final void mo6869KC() {
            AppMethodBeat.m2504i(55510);
            if (C9089a.dgL()) {
                setCursor(this.oQI.mo56737Mq(this.limit));
            } else {
                setCursor(this.oQI.mo56742xm(this.limit));
            }
            super.notifyDataSetChanged();
            AppMethodBeat.m2505o(55510);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C21367a c21367a;
            CharSequence charSequence;
            AppMethodBeat.m2504i(55511);
            C7570bf c7570bf = (C7570bf) getItem(i);
            if (view == null) {
                C21367a c21367a2 = new C21367a();
                View view2 = (MMSlideDelView) View.inflate(this.crP, 2130968832, null);
                View inflate = View.inflate(this.crP, 2130970535, null);
                c21367a2.eks = (ImageView) inflate.findViewById(2131823840);
                c21367a2.gtG = (TextView) inflate.findViewById(2131827176);
                c21367a2.ooM = (TextView) inflate.findViewById(2131827177);
                c21367a2.jJW = view2.findViewById(2131821704);
                c21367a2.jJX = (TextView) view2.findViewById(2131821082);
                view2.setView(inflate);
                view2.setPerformItemClickListener(this.jJO);
                view2.setGetViewPositionCallback(this.jJP);
                view2.setItemStatusCallBack(this.jJR);
                view2.setEnable(false);
                view2.setTag(c21367a2);
                c21367a = c21367a2;
                view = view2;
            } else {
                c21367a = (C21367a) view.getTag();
            }
            if (c7570bf.field_flag != 0) {
                charSequence = C5138d.apF(c7570bf.field_content).nickname;
            } else {
                charSequence = c7570bf.field_talker;
            }
            c21367a.gtG.setText(C44089j.m79293b(this.crP, charSequence, c21367a.gtG.getTextSize()));
            c21367a.ooM.setText(C44089j.m79293b(this.crP, c7570bf.field_sayhicontent, c21367a.ooM.getTextSize()));
            c21367a.jJW.setTag(Long.valueOf(c7570bf.field_svrid));
            c21367a.jJW.setOnClickListener(new C213591());
            C40460b.m69434b(c21367a.eks, c7570bf.field_sayhiuser);
            AppMethodBeat.m2505o(55511);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI$11 */
    class C2136811 implements OnItemClickListener {
        C2136811() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(55505);
            if (NearbySayHiListUI.this.gtT.getHeaderViewsCount() > 0) {
                i -= NearbySayHiListUI.this.gtT.getHeaderViewsCount();
            }
            C7570bf c7570bf = (C7570bf) NearbySayHiListUI.this.oQJ.getItem(i);
            if (c7570bf == null || c7570bf.field_content == null) {
                AppMethodBeat.m2505o(55505);
                return;
            }
            C5138d apF = C5138d.apF(c7570bf.field_content);
            Intent intent = new Intent();
            if (C9089a.dgL()) {
                intent.putExtra("Chat_User", c7570bf.field_sayhiencryptuser);
                intent.putExtra("lbs_mode", true);
                intent.putExtra("add_scene", 18);
                C39456a.gkE.mo38915d(intent, NearbySayHiListUI.this);
            } else {
                String str;
                Intent intent2 = new Intent();
                String str2 = "Contact_User";
                if (C5046bo.isNullOrNil(apF.svN)) {
                    str = c7570bf.field_sayhiuser;
                } else {
                    str = apF.svN;
                }
                intent2.putExtra(str2, str);
                intent2.putExtra("Contact_Alias", apF.dFl);
                intent2.putExtra("Contact_Nick", apF.nickname);
                intent2.putExtra("Contact_QuanPin", apF.gwG);
                intent2.putExtra("Contact_PyInitial", apF.gwF);
                intent2.putExtra("Contact_Sex", apF.dtS);
                intent2.putExtra("Contact_Signature", apF.signature);
                intent2.putExtra("Contact_Scene", apF.scene);
                intent2.putExtra("Contact_FMessageCard", true);
                intent2.putExtra("Contact_City", apF.getCity());
                intent2.putExtra("Contact_Province", apF.getProvince());
                intent2.putExtra("Contact_Content", C5046bo.isNullOrNil(c7570bf.field_sayhicontent) ? NearbySayHiListUI.this.getString(C25738R.string.al3) : c7570bf.field_sayhicontent);
                intent2.putExtra("Contact_verify_Scene", apF.scene);
                intent2.putExtra("Contact_Uin", apF.pnz);
                intent2.putExtra("Contact_QQNick", apF.gwH);
                intent2.putExtra("Contact_Mobile_MD5", apF.xZi);
                intent2.putExtra("User_From_Fmessage", true);
                intent2.putExtra("Contact_from_msgType", 37);
                intent2.putExtra("Verify_ticket", apF.mGZ);
                intent2.putExtra("Contact_Source_FMessage", apF.scene);
                intent2.putExtra("Contact_ShowFMessageList", true);
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(apF.svN);
                if (!(aoO == null || ((int) aoO.ewQ) < 0 || C7486a.m12942jh(aoO.field_type))) {
                    int i2 = apF.cAd;
                    if (i2 == 0 || i2 == 2 || i2 == 5) {
                        intent2.putExtra("User_Verify", true);
                    }
                    intent2.putExtra("Contact_IsLBSFriend", true);
                    intent2.putExtra("Sns_from_Scene", 18);
                }
                C39456a.gkE.mo38912c(intent2, NearbySayHiListUI.this);
            }
            C37732i c37732i = new C37732i();
            c37732i.csa.scene = apF.scene;
            C4879a.xxA.mo10055m(c37732i);
            AppMethodBeat.m2505o(55505);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public NearbySayHiListUI() {
        AppMethodBeat.m2504i(55513);
        AppMethodBeat.m2505o(55513);
    }

    public void onCreate(Bundle bundle) {
        int i;
        NearbySayHiListUI nearbySayHiListUI;
        AppMethodBeat.m2504i(55514);
        super.onCreate(bundle);
        this.ehD = C5046bo.ank(C26373g.m41964Nu().getValue("ThresholdToCleanLocation"));
        this.oQM = getIntent().getBooleanExtra("show_clear_header", false);
        C1720g.m3534RN().mo5159QU();
        this.oQI = (C35998bg) ((C6982j) C1720g.m3528K(C6982j.class)).bOo();
        setMMTitle((int) C25738R.string.dx5);
        this.oQL = this.oQI.baS();
        this.oQK = this.oQI.getCount();
        if (C9089a.dgL()) {
            i = this.oQK;
            nearbySayHiListUI = this;
        } else if (this.oQL == 0) {
            i = 8;
            nearbySayHiListUI = this;
        } else {
            i = this.oQL;
            nearbySayHiListUI = this;
        }
        nearbySayHiListUI.limit = i;
        C35998bg c35998bg = this.oQI;
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(4));
        if (c35998bg.bSd.update(c35998bg.getTableName(), contentValues, "status!=? ", new String[]{"4"}) != 0) {
            c35998bg.doNotify();
        }
        initView();
        AppMethodBeat.m2505o(55514);
    }

    public void onResume() {
        AppMethodBeat.m2504i(55515);
        super.onResume();
        if (this.oQK != this.oQI.getCount()) {
            this.oQK = this.oQI.getCount();
            if (this.oQK == 0) {
                TextView textView = (TextView) findViewById(2131821807);
                textView.setText(C25738R.string.dx8);
                textView.setVisibility(0);
                enableOptionMenu(false);
            }
            this.oQJ.mo6869KC();
        }
        this.oQJ.notifyDataSetChanged();
        C1720g.m3540Rg().mo14539a(148, (C1202f) this);
        AppMethodBeat.m2505o(55515);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(55516);
        this.oQJ.bIf();
        super.onDestroy();
        AppMethodBeat.m2505o(55516);
    }

    public void onPause() {
        AppMethodBeat.m2504i(55517);
        C1720g.m3540Rg().mo14546b(148, (C1202f) this);
        super.onPause();
        AppMethodBeat.m2505o(55517);
    }

    public final int getLayoutId() {
        return 2130969931;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(55518);
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(55518);
        return onKeyDown;
    }

    public final void initView() {
        AppMethodBeat.m2504i(55519);
        this.gtT = (ListView) findViewById(2131825251);
        if (!C9089a.dgL()) {
            final View inflate = getLayoutInflater().inflate(2130970536, null);
            inflate.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(55493);
                    NearbySayHiListUI.this.limit = NearbySayHiListUI.this.limit + 8;
                    C4990ab.m7410d("MicroMsg.SayHiListUI", "dkfooter more btn:" + NearbySayHiListUI.this.limit);
                    C21366a b = NearbySayHiListUI.this.oQJ;
                    int a = NearbySayHiListUI.this.limit;
                    b.bIf();
                    b.limit = a;
                    b.mo6869KC();
                    if (NearbySayHiListUI.this.oQK <= NearbySayHiListUI.this.limit) {
                        NearbySayHiListUI.this.gtT.removeFooterView(inflate);
                        C4990ab.m7410d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + NearbySayHiListUI.this.limit);
                    }
                    AppMethodBeat.m2505o(55493);
                }
            });
            if (this.oQK > 0 && this.limit < this.oQK) {
                this.gtT.addFooterView(inflate);
            }
        }
        addTextOptionMenu(0, getString(C25738R.string.f9078ou), new C127065());
        if (this.oQK == 0) {
            TextView textView = (TextView) findViewById(2131821807);
            textView.setText(C25738R.string.dx8);
            textView.setVisibility(0);
            enableOptionMenu(false);
        }
        if (this.oQM && this.ehD != 0 && this.oQL >= this.ehD && C5046bo.m7558gT(this)) {
            this.gwR = new CleanLocationHeaderView(this);
            this.gwR.setOnClickListener(new C213626());
            this.gtT.addHeaderView(this.gwR);
        }
        this.oQJ = new C21366a(this, this.oQI, this.limit);
        this.oQJ.setGetViewPositionCallback(new C213637());
        this.oQJ.setPerformItemClickListener(new C213648());
        this.oQJ.mo36822a(new C213659());
        this.gtT.setAdapter(this.oQJ);
        final C46696j c46696j = new C46696j(this);
        this.gtT.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(55504);
                if (i < NearbySayHiListUI.this.gtT.getHeaderViewsCount()) {
                    C4990ab.m7420w("MicroMsg.SayHiListUI", "on header view long click, ignore");
                    AppMethodBeat.m2505o(55504);
                } else {
                    c46696j.mo75004a(view, i, j, NearbySayHiListUI.this, NearbySayHiListUI.this.jKa);
                    AppMethodBeat.m2505o(55504);
                }
                return true;
            }
        });
        this.gtT.setOnItemClickListener(new C2136811());
        setBackBtn(new C2136012());
        C213572 c213572 = new C213572();
        AppMethodBeat.m2505o(55519);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(55520);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        C7570bf c7570bf = (C7570bf) this.oQJ.getItem(adapterContextMenuInfo.position);
        if (c7570bf == null) {
            C4990ab.m7412e("MicroMsg.SayHiListUI", "onItemLongClick, item is null, pos = " + adapterContextMenuInfo.position);
            AppMethodBeat.m2505o(55520);
            return;
        }
        contextMenu.add(0, 0, 0, C25738R.string.f9088p4);
        this.oQN = c7570bf.field_svrid;
        AppMethodBeat.m2505o(55520);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(55521);
        setResult(0);
        super.onBackPressed();
        AppMethodBeat.m2505o(55521);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(55522);
        C4990ab.m7417i("MicroMsg.SayHiListUI", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (i != 0 || i2 != 0) {
            C4990ab.m7420w("MicroMsg.SayHiListUI", "[cpan] clear location failed.");
        } else if (((C46109c) c1207m).mo74036Ah() == 2) {
            C30379h.m48438a(this.mController.ylL, getString(C25738R.string.d4l), "", new C127054());
            this.oPQ = null;
            AppMethodBeat.m2505o(55522);
            return;
        }
        AppMethodBeat.m2505o(55522);
    }

    /* renamed from: j */
    static /* synthetic */ void m32771j(NearbySayHiListUI nearbySayHiListUI) {
        AppMethodBeat.m2504i(55523);
        if (nearbySayHiListUI.oQK == 0) {
            TextView textView = (TextView) nearbySayHiListUI.findViewById(2131821807);
            textView.setText(C25738R.string.dx8);
            textView.setVisibility(0);
            nearbySayHiListUI.enableOptionMenu(false);
        }
        AppMethodBeat.m2505o(55523);
    }
}
