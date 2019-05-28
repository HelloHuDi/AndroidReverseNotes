package com.tencent.p177mm.pluginsdk.p597ui.preference;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6980m.C3466a;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.plugin.story.api.C46270n;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.ProfileDescribeView;
import com.tencent.p177mm.pluginsdk.p597ui.ProfileHdHeadImg;
import com.tencent.p177mm.pluginsdk.p597ui.ProfileLabelView;
import com.tencent.p177mm.pluginsdk.p597ui.ProfileMobilePhoneView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.preference.C35883a.C14956a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7616ad;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference */
public class NormalUserHeaderPreference extends Preference implements C8915a, C3466a, C4937b {
    MMActivity crP;
    C7616ad ehM;
    private String ejD = "";
    private boolean lyb = false;
    private String mGZ;
    private TextView niS;
    private TextView nrD;
    private ClipboardManager oMy;
    private ImageView pkS;
    private boolean pnc;
    private boolean pni = false;
    private boolean poP = false;
    private ImageView quH;
    int qvb;
    private TextView tLA;
    private String vim;
    private String vin;
    private TextView vqF;
    private TextView vqG;
    private View vqH;
    private Button vqI;
    private Button vqJ;
    private TextView vqK;
    private ImageView vqL;
    private CheckBox vqM;
    private ImageView vqN;
    private ImageView vqO;
    private LinearLayout vqP;
    private Button vqQ;
    private FMessageListView vqR;
    private RelativeLayout vqS;
    private ImageView vqT;
    private int vqU = 0;
    private boolean vqV = false;
    private boolean vqW = false;
    private boolean vqX = false;
    private boolean vqY = false;
    private boolean vqZ = false;
    private boolean vra = false;
    private boolean vrb = false;
    private boolean vrc = false;
    private String vrd;
    private ProfileMobilePhoneView vre;
    private ProfileDescribeView vrf;
    private ProfileLabelView vrg;
    private TextView vrh;
    public OnClickListener vri;
    public String vrj = null;

    /* renamed from: com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference$3 */
    class C149543 implements OnClickListener {
        C149543() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(28073);
            NormalUserHeaderPreference.this.vqZ = false;
            NormalUserHeaderPreference normalUserHeaderPreference = NormalUserHeaderPreference.this;
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(normalUserHeaderPreference.ehM.field_username);
            if (!(aoO == null || ((int) aoO.ewQ) == 0 || !aoO.field_username.equals(normalUserHeaderPreference.ehM.field_username))) {
                normalUserHeaderPreference.ehM = aoO;
            }
            Intent intent;
            if (C7486a.m12942jh(normalUserHeaderPreference.ehM.field_type)) {
                intent = new Intent();
                intent.setClassName(normalUserHeaderPreference.mContext, "com.tencent.mm.ui.contact.ContactRemarkInfoModUI");
                intent.putExtra("Contact_Scene", normalUserHeaderPreference.qvb);
                intent.putExtra("Contact_User", normalUserHeaderPreference.ehM.field_username);
                intent.putExtra("Contact_RoomNickname", normalUserHeaderPreference.crP.getIntent().getStringExtra("Contact_RoomNickname"));
                ((Activity) normalUserHeaderPreference.mContext).startActivity(intent);
                AppMethodBeat.m2505o(28073);
                return;
            }
            intent = new Intent();
            intent.setClassName(normalUserHeaderPreference.mContext, "com.tencent.mm.ui.contact.ModRemarkNameUI");
            intent.putExtra("Contact_Scene", normalUserHeaderPreference.qvb);
            intent.putExtra("Contact_mode_name_type", 0);
            intent.putExtra("Contact_ModStrangerRemark", true);
            intent.putExtra("Contact_User", normalUserHeaderPreference.ehM.field_username);
            intent.putExtra("Contact_Nick", normalUserHeaderPreference.ehM.field_nickname);
            intent.putExtra("Contact_RemarkName", normalUserHeaderPreference.ehM.field_conRemark);
            ((Activity) normalUserHeaderPreference.mContext).startActivity(intent);
            AppMethodBeat.m2505o(28073);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference$1 */
    class C301361 implements OnClickListener {
        C301361() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(28071);
            String str = NormalUserHeaderPreference.this.ehM.field_username;
            if (C7616ad.m13548mR(str)) {
                str = C7616ad.aoC(str);
            }
            Intent intent = new Intent(NormalUserHeaderPreference.this.crP, ProfileHdHeadImg.class);
            intent.putExtra("username", str);
            NormalUserHeaderPreference.this.crP.startActivity(intent);
            AppMethodBeat.m2505o(28071);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference$2 */
    class C301372 implements OnClickListener {
        C301372() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(28072);
            C46270n.m86706aT(NormalUserHeaderPreference.this.crP, NormalUserHeaderPreference.this.ehM.field_username);
            AppMethodBeat.m2505o(28072);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference$5 */
    class C358775 implements OnLongClickListener {

        /* renamed from: com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference$5$1 */
        class C233301 implements OnCreateContextMenuListener {
            C233301() {
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.m2504i(28075);
                contextMenu.add(NormalUserHeaderPreference.this.crP.getString(C25738R.string.f9082oy));
                AppMethodBeat.m2505o(28075);
            }
        }

        /* renamed from: com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference$5$3 */
        class C233323 implements OnDismissListener {
            C233323() {
            }

            public final void onDismiss() {
                AppMethodBeat.m2504i(28077);
                NormalUserHeaderPreference.this.dkU();
                AppMethodBeat.m2505o(28077);
            }
        }

        C358775() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(28078);
            if (!(NormalUserHeaderPreference.this.nrD.getText() == null || NormalUserHeaderPreference.this.oMy == null)) {
                String charSequence = NormalUserHeaderPreference.this.nrD.getText().toString();
                int indexOf = charSequence.indexOf(58);
                if (indexOf >= 0 && indexOf < charSequence.length()) {
                    charSequence = charSequence.substring(indexOf + 1).trim();
                }
                SpannableString spannableString = new SpannableString(NormalUserHeaderPreference.this.nrD.getText());
                spannableString.setSpan(new BackgroundColorSpan(NormalUserHeaderPreference.this.crP.getResources().getColor(C25738R.color.f12117sz)), indexOf + 1, NormalUserHeaderPreference.this.nrD.getText().length(), 33);
                NormalUserHeaderPreference.this.nrD.setText(spannableString);
                C24088a c24088a = new C24088a(NormalUserHeaderPreference.this.crP, NormalUserHeaderPreference.this.nrD);
                c24088a.zRZ = new C233301();
                c24088a.rBm = new C5279d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.m2504i(28076);
                        if (i == 0) {
                            NormalUserHeaderPreference.this.oMy.setText(charSequence);
                            C30379h.m48464bP(NormalUserHeaderPreference.this.crP, NormalUserHeaderPreference.this.crP.getString(C25738R.string.f9083oz));
                        }
                        AppMethodBeat.m2505o(28076);
                    }
                };
                c24088a.zHM = new C233323();
                c24088a.mo22431dn(0, 0);
            }
            AppMethodBeat.m2505o(28078);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference$4 */
    class C358794 implements OnClickListener {
        C358794() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(28074);
            Intent intent = new Intent();
            intent.putExtra("sns_permission_userName", NormalUserHeaderPreference.this.ehM.field_username);
            intent.putExtra("sns_permission_anim", true);
            intent.putExtra("sns_permission_block_scene", 3);
            C25985d.m41467b(NormalUserHeaderPreference.this.crP, "sns", ".ui.SnsPermissionUI", intent);
            AppMethodBeat.m2505o(28074);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference$6 */
    class C358806 implements Runnable {
        C358806() {
        }

        public final void run() {
            AppMethodBeat.m2504i(28079);
            NormalUserHeaderPreference.m58821f(NormalUserHeaderPreference.this);
            NormalUserHeaderPreference.m58822g(NormalUserHeaderPreference.this);
            NormalUserHeaderPreference.m58823h(NormalUserHeaderPreference.this);
            if (NormalUserHeaderPreference.this.vqR != null) {
                NormalUserHeaderPreference.this.vqR.setReplyBtnVisible(!C7486a.m12942jh(NormalUserHeaderPreference.this.ehM.field_type));
            }
            AppMethodBeat.m2505o(28079);
        }
    }

    /* renamed from: f */
    static /* synthetic */ void m58821f(NormalUserHeaderPreference normalUserHeaderPreference) {
        AppMethodBeat.m2504i(28106);
        normalUserHeaderPreference.dkY();
        AppMethodBeat.m2505o(28106);
    }

    /* renamed from: g */
    static /* synthetic */ void m58822g(NormalUserHeaderPreference normalUserHeaderPreference) {
        AppMethodBeat.m2504i(28107);
        normalUserHeaderPreference.dla();
        AppMethodBeat.m2505o(28107);
    }

    /* renamed from: h */
    static /* synthetic */ void m58823h(NormalUserHeaderPreference normalUserHeaderPreference) {
        AppMethodBeat.m2504i(28108);
        normalUserHeaderPreference.dkW();
        AppMethodBeat.m2505o(28108);
    }

    /* renamed from: j */
    static /* synthetic */ boolean m58825j(NormalUserHeaderPreference normalUserHeaderPreference) {
        AppMethodBeat.m2504i(28109);
        boolean hasInit = normalUserHeaderPreference.hasInit();
        AppMethodBeat.m2505o(28109);
        return hasInit;
    }

    public NormalUserHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(28081);
        this.crP = (MMActivity) context;
        init();
        AppMethodBeat.m2505o(28081);
    }

    public NormalUserHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(28082);
        this.crP = (MMActivity) context;
        init();
        AppMethodBeat.m2505o(28082);
    }

    private void init() {
        AppMethodBeat.m2504i(28083);
        this.lyb = false;
        this.oMy = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
        AppMethodBeat.m2505o(28083);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(28084);
        if (this.vqR != null) {
            this.vqR.detach();
        }
        View onCreateView = super.onCreateView(viewGroup);
        AppMethodBeat.m2505o(28084);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(28085);
        C4990ab.m7410d("MicroMsg.ContactInfoHeader", "onBindView");
        this.niS = (TextView) view.findViewById(2131821460);
        this.nrD = (TextView) view.findViewById(2131822995);
        this.vqK = (TextView) view.findViewById(2131823015);
        this.vqF = (TextView) view.findViewById(2131823021);
        this.vqG = (TextView) view.findViewById(2131823017);
        this.vqI = (Button) view.findViewById(2131823018);
        this.vqJ = (Button) view.findViewById(2131823019);
        this.vre = (ProfileMobilePhoneView) view.findViewById(2131823025);
        ProfileMobilePhoneView profileMobilePhoneView = this.vre;
        C9638aw.m17190ZK();
        profileMobilePhoneView.viy = ((Boolean) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.FALSE)).booleanValue();
        this.vrf = (ProfileDescribeView) view.findViewById(2131823026);
        this.vrg = (ProfileLabelView) view.findViewById(2131823027);
        this.vrh = (TextView) view.findViewById(2131823024);
        this.vrf.setOnClickListener(this.vri);
        this.vrg.setOnClickListener(this.vri);
        this.vrh.setOnClickListener(this.vri);
        if (C1853r.m3858mG(this.ehM.field_username) || (!C5046bo.isNullOrNil(this.ehM.field_username) && C1855t.m3916nB(this.ehM.field_username))) {
            this.vrh.setVisibility(8);
            this.vre.setVisibility(8);
            this.vrf.setVisibility(8);
            this.vrg.setVisibility(8);
        } else {
            this.vre.mo38944hG(this.vim, this.vin);
            if (C7486a.m12942jh(this.ehM.field_type)) {
                this.vre.setVisibility(0);
            } else {
                this.vre.setVisibility(8);
            }
            boolean T = this.vrf.mo27223T(this.ehM);
            boolean T2 = this.vrg.mo27223T(this.ehM);
            if (T || T2) {
                this.vrh.setVisibility(8);
            } else {
                if (this.vrb || this.vqZ) {
                    this.vrh.setVisibility(8);
                } else {
                    this.vrh.setVisibility(0);
                }
                if (this.vrj != null && (this.vrj.equals("ContactWidgetBottleContact") || this.vrj.equals("ContactWidgetQContact"))) {
                    this.vrh.setVisibility(8);
                }
            }
        }
        this.tLA = (TextView) view.findViewById(2131823030);
        this.vqQ = (Button) view.findViewById(2131823022);
        this.vqR = (FMessageListView) view.findViewById(2131823028);
        C14956a c14956a = new C14956a();
        c14956a.talker = this.ehM.field_username;
        c14956a.scene = this.qvb;
        c14956a.mGZ = this.mGZ;
        c14956a.vqs = this.ehM.dus;
        c14956a.type = 0;
        if (this.qvb == 18) {
            c14956a.type = 1;
        } else if (C1829bf.m3750kE(this.qvb)) {
            c14956a.type = 2;
        }
        this.vqR.setFMessageArgs(c14956a);
        this.vqH = view.findViewById(2131823023);
        this.vqP = (LinearLayout) view.findViewById(2131823007);
        this.pkS = (ImageView) view.findViewById(2131821459);
        this.quH = (ImageView) view.findViewById(2131823009);
        this.vqL = (ImageView) view.findViewById(2131823010);
        this.vqM = (CheckBox) view.findViewById(2131823013);
        this.vqN = (ImageView) view.findViewById(2131823012);
        this.vqO = (ImageView) view.findViewById(2131823011);
        this.vqT = (ImageView) view.findViewById(2131823006);
        this.vqS = (RelativeLayout) view.findViewById(2131823005);
        this.lyb = true;
        initView();
        if (C7486a.m12942jh(this.ehM.field_type)) {
            C4990ab.m7410d("MicroMsg.ContactInfoHeader", "initAddContent, showFMessageList false");
            this.vqR.setVisibility(8);
            if (this.vqR.getVisibility() == 8 && this.vrh.getVisibility() == 8 && this.vrg.getVisibility() == 8 && this.vrf.getVisibility() == 8 && this.tLA.getVisibility() == 8) {
                this.vqH.setVisibility(8);
            }
        } else if (this.mGZ == null || this.mGZ.length() == 0) {
            C4990ab.m7410d("MicroMsg.ContactInfoHeader", "initAddContent, FMessageListView gone, addScene = " + this.qvb + ", verifyTicket = " + this.mGZ);
            this.vqR.setVisibility(8);
            if (this.vqR.getVisibility() == 8 && this.vrh.getVisibility() == 8 && this.vrg.getVisibility() == 8 && this.vrf.getVisibility() == 8 && this.tLA.getVisibility() == 8) {
                this.vqH.setVisibility(8);
            }
        } else {
            C14957b[] a;
            C4990ab.m7410d("MicroMsg.ContactInfoHeader", "initAddContent, scene = " + this.qvb);
            if (this.qvb == 18) {
                C4990ab.m7410d("MicroMsg.ContactInfoHeader", "initAddContent, scene is lbs");
                a = C14957b.m23241a(this.crP, C41789d.akQ().apz(this.ehM.field_username));
            } else if (C1829bf.m3750kE(this.qvb)) {
                C4990ab.m7410d("MicroMsg.ContactInfoHeader", "initAddContent, scene is shake");
                a = C14957b.m23243a(this.crP, C41789d.akR().apY(this.ehM.field_username));
            } else {
                C4990ab.m7410d("MicroMsg.ContactInfoHeader", "initAddContent, scene is other");
                a = C14957b.m23242a(this.crP, C41789d.akO().apv(this.ehM.field_username));
            }
            if (a == null || a.length == 0) {
                C4990ab.m7412e("MicroMsg.ContactInfoHeader", "initAddContent, providerList is null");
                this.vqR.setVisibility(8);
                if (this.vqR.getVisibility() == 8 && this.vrh.getVisibility() == 8 && this.vrg.getVisibility() == 8 && this.vrf.getVisibility() == 8 && this.tLA.getVisibility() == 8) {
                    this.vqH.setVisibility(8);
                }
            } else {
                C4990ab.m7410d("MicroMsg.ContactInfoHeader", "initAddContent, providerList size = " + a.length);
                for (C14957b c14957b : a) {
                    if (c14957b != null) {
                        C4990ab.m7410d("MicroMsg.ContactInfoHeader", "initAddContent, username = " + c14957b.username + ", nickname = " + c14957b.nickname + ", digest = " + c14957b.fjz + ", addScene = " + c14957b.qvb);
                    }
                }
                if (C7616ad.aox(this.ehM.field_username)) {
                    this.vqR.setVisibility(8);
                    this.vqR.setHide(true);
                } else {
                    this.vqR.setVisibility(0);
                    this.vqR.setHide(false);
                }
                if (this.vqR.getVisibility() == 0 || this.vrh.getVisibility() == 0 || this.vrg.getVisibility() == 0 || this.vrf.getVisibility() == 0 || this.tLA.getVisibility() == 0) {
                    this.vqH.setVisibility(0);
                }
                for (C14957b a2 : a) {
                    this.vqR.mo39054a(a2);
                }
            }
        }
        super.onBindView(view);
        AppMethodBeat.m2505o(28085);
    }

    private boolean hasInit() {
        return this.lyb && this.ehM != null;
    }

    private void cfI() {
        AppMethodBeat.m2504i(28087);
        C40460b.m69434b(this.pkS, this.ehM.field_username);
        if (this.pkS != null) {
            int al = C1338a.m2856al(this.mContext, C25738R.dimen.f9724dp);
            int fromDPToPix = C1338a.fromDPToPix(this.crP, 88);
            if (al <= fromDPToPix) {
                fromDPToPix = al;
            }
            LayoutParams layoutParams = new LayoutParams(fromDPToPix, fromDPToPix);
            layoutParams.setMargins(0, 0, C1338a.m2857am(this.mContext, C25738R.dimen.f9951l8), 0);
            this.pkS.setLayoutParams(layoutParams);
        }
        AppMethodBeat.m2505o(28087);
    }

    private void dkT() {
        AppMethodBeat.m2504i(28088);
        this.vqK.setVisibility(0);
        this.niS.setText(C44089j.m79293b(this.crP, C5046bo.nullAsNil(this.ehM.mo16706Oi()) + " ", this.niS.getTextSize()));
        cfI();
        this.vqQ.setVisibility(8);
        this.nrD.setVisibility(8);
        this.vqR.setVisibility(8);
        if (this.vqR.getVisibility() == 8 && this.vrh.getVisibility() == 8 && this.vrg.getVisibility() == 8 && this.vrf.getVisibility() == 8 && this.tLA.getVisibility() == 8) {
            this.vqH.setVisibility(8);
        }
        this.vqI.setVisibility(8);
        this.vqJ.setVisibility(8);
        this.vqM.setVisibility(8);
        if (this.vrg != null) {
            this.vrg.setVisibility(8);
        }
        if (this.vre != null) {
            this.vre.setVisibility(8);
        }
        if (this.vrf != null) {
            this.vrf.setVisibility(8);
        }
        if (this.vrh != null) {
            this.vrh.setVisibility(8);
        }
        if (this.vqG != null) {
            this.vqG.setVisibility(8);
        }
        AppMethodBeat.m2505o(28088);
    }

    private void initView() {
        AppMethodBeat.m2504i(28089);
        if (!hasInit()) {
            C4990ab.m7420w("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.lyb + "contact = " + this.ehM);
            AppMethodBeat.m2505o(28089);
        } else if (this.pni) {
            dkT();
            AppMethodBeat.m2505o(28089);
        } else {
            boolean mR = C7616ad.m13548mR(this.ehM.field_username);
            if (mR) {
                this.niS.setText("");
                if (C7616ad.aoC(C1853r.m3846Yz()).equals(this.ehM.field_username)) {
                    this.vqQ.setVisibility(8);
                }
            } else {
                this.niS.setText(C44089j.m79293b(this.crP, C5046bo.nullAsNil(this.ehM.field_nickname) + " ", this.niS.getTextSize()));
            }
            this.quH.setVisibility(0);
            this.vqX = true;
            if (this.ehM.dtS == 1) {
                this.quH.setImageDrawable(C1338a.m2864g(this.crP, C1318a.ic_sex_male));
                this.quH.setContentDescription(this.mContext.getString(C25738R.string.dex));
            } else if (this.ehM.dtS == 2) {
                this.quH.setImageDrawable(C1338a.m2864g(this.crP, C1318a.ic_sex_female));
                this.quH.setContentDescription(this.mContext.getString(C25738R.string.dew));
            } else if (this.ehM.dtS == 0) {
                this.quH.setVisibility(8);
                this.vqX = false;
            }
            if (this.ehM.field_verifyFlag != 0) {
                Bitmap i;
                this.vqL.setVisibility(0);
                if (C26417a.flw != null) {
                    i = C4977b.m7374i(C26417a.flw.mo37872ky(this.ehM.field_verifyFlag), 2.0f);
                } else {
                    i = null;
                }
                this.vqL.setImageBitmap(i);
                this.vqU = i == null ? 0 : i.getWidth();
            }
            cfI();
            dlb();
            this.pkS.setOnClickListener(new C301361());
            this.vqT.setOnClickListener(new C301372());
            if (C7616ad.aow(this.ehM.field_username)) {
                this.nrD.setText(this.mContext.getString(C25738R.string.f9125q_) + this.ehM.mo16708Ok());
            } else if (C7616ad.aou(this.ehM.field_username)) {
                this.nrD.setText(this.mContext.getString(C25738R.string.f9135ql) + this.ehM.mo16708Ok());
            } else if (this.pnc) {
                if (C7486a.m12942jh(this.ehM.field_type)) {
                    dkU();
                } else if (this.ehM.due == null || this.ehM.due.equals("")) {
                    this.nrD.setText(C25738R.string.f9104pl);
                } else {
                    this.nrD.setText(this.ehM.due);
                }
            } else if (mR) {
                this.nrD.setText((C5046bo.nullAsNil(C1854s.m3868mL(this.ehM.getProvince())) + " " + C5046bo.nullAsNil(this.ehM.getCity())).trim());
            } else {
                if (!C7616ad.aov(this.ehM.field_username) && this.crP.getIntent().getBooleanExtra("Contact_ShowUserName", true)) {
                    if (C5046bo.isNullOrNil(this.ehM.mo14673Hq()) && (C7616ad.aoA(this.ehM.field_username) || C1855t.m3911mX(this.ehM.field_username))) {
                        this.nrD.setVisibility(8);
                    } else if (C7486a.m12942jh(this.ehM.field_type)) {
                        dkU();
                    }
                }
                this.nrD.setVisibility(8);
            }
            if (C1855t.m3916nB(this.ehM.field_username)) {
                this.tLA.setVisibility(0);
            } else {
                this.tLA.setVisibility(8);
            }
            dkY();
            dkW();
            dla();
            dkX();
            this.vqI.setOnClickListener(new C149543());
            this.vqJ.setOnClickListener(new C358794());
            dkV();
            this.nrD.setLongClickable(true);
            this.nrD.setOnLongClickListener(new C358775());
            AppMethodBeat.m2505o(28089);
        }
    }

    public final void dkU() {
        AppMethodBeat.m2504i(28090);
        this.nrD.setVisibility(0);
        if (!C5046bo.isNullOrNil(this.ehM.mo14673Hq())) {
            this.nrD.setText(this.mContext.getString(C25738R.string.f9131qf) + this.ehM.mo14673Hq());
            AppMethodBeat.m2505o(28090);
        } else if (C7616ad.aoA(this.ehM.field_username) || C1855t.m3911mX(this.ehM.field_username)) {
            this.nrD.setVisibility(8);
            AppMethodBeat.m2505o(28090);
        } else {
            this.nrD.setText(this.mContext.getString(C25738R.string.f9131qf) + C5046bo.nullAsNil(this.ehM.mo16708Ok()));
            AppMethodBeat.m2505o(28090);
        }
    }

    private void dkV() {
        AppMethodBeat.m2504i(28091);
        int i = 0;
        if (this.vqX) {
            i = C1338a.fromDPToPix(this.crP, 17) + 0;
        }
        i += this.vqU;
        if (this.vqV) {
            i += C1338a.fromDPToPix(this.crP, 27);
        }
        if (this.vqW) {
            i += C1338a.fromDPToPix(this.crP, 27);
        }
        if (this.vqY) {
            i += C1338a.fromDPToPix(this.crP, 30);
        }
        if (C1338a.m2865ga(this.mContext)) {
            i += C1338a.fromDPToPix(this.crP, 88);
        } else {
            i += C1338a.fromDPToPix(this.crP, 64);
        }
        this.niS.setMaxWidth(this.crP.getResources().getDisplayMetrics().widthPixels - (i + C1338a.fromDPToPix(this.crP, 60)));
        AppMethodBeat.m2505o(28091);
    }

    /* renamed from: bW */
    public final void mo56683bW(String str, boolean z) {
        AppMethodBeat.m2504i(28092);
        if (str != null && str.equals(this.ehM.field_username)) {
            this.vqZ = z;
        }
        AppMethodBeat.m2505o(28092);
    }

    /* renamed from: bX */
    public final void mo56684bX(String str, boolean z) {
        AppMethodBeat.m2504i(28093);
        if (str != null && str.equals(this.ehM.field_username)) {
            this.vra = z;
        }
        AppMethodBeat.m2505o(28093);
    }

    /* renamed from: a */
    public final void mo56682a(C7616ad c7616ad, int i, String str, String str2, String str3) {
        AppMethodBeat.m2504i(28094);
        this.vim = str2;
        this.vin = str3;
        mo56681a(c7616ad, i, str);
        AppMethodBeat.m2505o(28094);
    }

    /* renamed from: a */
    public final void mo56681a(C7616ad c7616ad, int i, String str) {
        boolean z = true;
        AppMethodBeat.m2504i(28095);
        onDetach();
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10118a(this);
        C9638aw.m17190ZK();
        C18628c.m29079XN().mo15366a(this);
        C17884o.acd().mo67502d(this);
        this.ehM = c7616ad;
        this.qvb = i;
        this.mGZ = str;
        this.pnc = this.crP.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
        this.vrc = this.crP.getIntent().getBooleanExtra("Contact_ShowFMessageList", false);
        this.vqZ = this.crP.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
        this.vra = this.crP.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
        this.vrb = this.crP.getIntent().getBooleanExtra("Contact_AlwaysShowRemarkBtn", false);
        this.poP = this.crP.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
        this.vrd = this.crP.getIntent().getStringExtra("Contact_RoomNickname");
        this.pni = c7616ad.field_deleteFlag == 1;
        this.ejD = this.crP.getIntent().getStringExtra("room_name");
        String str2 = "initView: contact username is null";
        if (C5046bo.nullAsNil(c7616ad.field_username).length() <= 0) {
            z = false;
        }
        Assert.assertTrue(str2, z);
        initView();
        AppMethodBeat.m2505o(28095);
    }

    public final void onDetach() {
        AppMethodBeat.m2504i(28096);
        if (this.vqR != null) {
            this.vqR.detach();
        }
        if (this.vrc) {
            C41789d.akP().apt(this.ehM.field_username);
        }
        this.crP.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.vqZ);
        this.crP.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.vra);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10121b(this);
        C17884o.acd().mo67503e(this);
        C9638aw.m17190ZK();
        C18628c.m29079XN().mo15367b(this);
        AppMethodBeat.m2505o(28096);
    }

    private void dkW() {
        int i = 0;
        AppMethodBeat.m2504i(28097);
        if (this.vqN != null && C1855t.m3900mM(this.ehM.field_username)) {
            this.vqW = this.ehM.mo16701Od();
            this.vqN.setVisibility(this.vqW ? 0 : 8);
        }
        if (this.vqO != null && C1855t.m3900mM(this.ehM.field_username)) {
            this.vqV = NormalUserHeaderPreference.m58815UV(this.ehM.field_username);
            ImageView imageView = this.vqO;
            if (!this.vqV) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
        AppMethodBeat.m2505o(28097);
    }

    private void dkX() {
        AppMethodBeat.m2504i(28098);
        if (C5046bo.isNullOrNil(this.vrd)) {
            this.vqF.setVisibility(8);
            AppMethodBeat.m2505o(28098);
            return;
        }
        if (!C1853r.m3858mG(this.ehM.field_username) && C5046bo.nullAsNil(this.ehM.field_conRemark).length() > 0) {
            this.nrD.setVisibility(8);
        }
        this.vqF.setVisibility(0);
        this.vqF.setText(C44089j.m79293b(this.crP, this.crP.getString(C25738R.string.av8) + this.vrd, this.vqF.getTextSize()));
        AppMethodBeat.m2505o(28098);
    }

    private void dkY() {
        AppMethodBeat.m2504i(28099);
        if (C1853r.m3858mG(this.ehM.field_username) || C5046bo.nullAsNil(this.ehM.field_conRemark).length() <= 0) {
            this.vqG.setVisibility(8);
            this.niS.setText(C44089j.m79293b(this.crP, C5046bo.nullAsNil(this.ehM.mo16706Oi()) + " ", this.niS.getTextSize()));
            if (this.vrb) {
                this.vqI.setVisibility(0);
                this.vrh.setVisibility(8);
            } else if (this.vqZ) {
                this.vqI.setVisibility(0);
                this.vrh.setVisibility(8);
            } else {
                if (C7486a.m12942jh(this.ehM.field_type)) {
                    this.vqI.setVisibility(8);
                }
                boolean T = this.vrf.mo27223T(this.ehM);
                boolean T2 = this.vrg.mo27223T(this.ehM);
                if (T || T2) {
                    this.vrh.setVisibility(8);
                }
            }
        } else {
            this.niS.setText(C44089j.m79293b(this.crP, C5046bo.nullAsNil(this.ehM.field_conRemark) + " ", this.niS.getTextSize()));
            this.vqG.setVisibility(0);
            this.vqG.setText(C44089j.m79293b(this.crP, this.mContext.getString(C25738R.string.ay7) + this.ehM.mo16706Oi(), this.vqG.getTextSize()));
            this.vqI.setVisibility(8);
        }
        if (C7616ad.aox(this.ehM.field_username)) {
            this.vrh.setText(C25738R.string.b2o);
            dkZ();
        }
        if (this.poP && !C7486a.m12942jh(this.ehM.field_type)) {
            this.vqJ.setVisibility(0);
        } else if (this.vra) {
            this.vqJ.setVisibility(0);
            if (C1338a.m2865ga(this.crP)) {
                this.vqJ.setTextSize(0, (float) this.crP.getResources().getDimensionPixelSize(C25738R.dimen.f9936kr));
                this.vqI.setTextSize(0, (float) this.crP.getResources().getDimensionPixelSize(C25738R.dimen.f9936kr));
            }
        } else {
            this.vqJ.setVisibility(8);
        }
        if (C7616ad.m13548mR(this.ehM.field_username)) {
            this.niS.setText("");
        }
        if (this.qvb == 76 && this.ehM.field_username != null && this.ehM.field_username.endsWith("@stranger")) {
            this.niS.setText(C44089j.m79293b(this.crP, C5046bo.nullAsNil(this.ehM.field_nickname) + " ", this.niS.getTextSize()));
        }
        if (this.vqJ.getVisibility() == 0 && this.vqG.getVisibility() == 0) {
            LayoutParams layoutParams = (LayoutParams) this.vqG.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
            this.vqG.setLayoutParams(layoutParams);
        }
        AppMethodBeat.m2505o(28099);
    }

    private void dkZ() {
        AppMethodBeat.m2504i(28100);
        if (this.vqP == null) {
            AppMethodBeat.m2505o(28100);
            return;
        }
        View findViewById = this.vqP.findViewById(2131823014);
        if (findViewById == null) {
            AppMethodBeat.m2505o(28100);
            return;
        }
        findViewById.setVisibility(8);
        AppMethodBeat.m2505o(28100);
    }

    private void dla() {
        AppMethodBeat.m2504i(28101);
        this.vqM.setClickable(false);
        if ((C1855t.m3900mM(this.ehM.field_username) || C7616ad.aox(this.ehM.field_username)) && C7486a.m12942jh(this.ehM.field_type) && !C1853r.m3858mG(this.ehM.field_username)) {
            this.vqM.setVisibility(0);
            if (this.ehM.mo16700Oc()) {
                this.vqM.setChecked(true);
                this.vqY = true;
                AppMethodBeat.m2505o(28101);
                return;
            }
            this.vqM.setChecked(false);
            this.vqM.setVisibility(8);
            this.vqY = false;
            AppMethodBeat.m2505o(28101);
            return;
        }
        this.vqY = false;
        this.vqM.setVisibility(8);
        AppMethodBeat.m2505o(28101);
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        AppMethodBeat.m2504i(28102);
        if (!hasInit()) {
            C4990ab.m7412e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.lyb + "contact = " + this.ehM);
            AppMethodBeat.m2505o(28102);
        } else if (C5046bo.nullAsNil(str).length() <= 0) {
            C4990ab.m7412e("MicroMsg.ContactInfoHeader", "notifyChanged: user = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(28102);
        } else {
            if (str.equals(this.ehM.field_username)) {
                initView();
            }
            AppMethodBeat.m2505o(28102);
        }
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(28103);
        C4990ab.m7411d("MicroMsg.ContactInfoHeader", "onNotifyChange event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
        if (obj == null || !(obj instanceof String)) {
            C4990ab.m7413e("MicroMsg.ContactInfoHeader", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
            AppMethodBeat.m2505o(28103);
            return;
        }
        String str = (String) obj;
        C4990ab.m7410d("MicroMsg.ContactInfoHeader", "onNotifyChange username = " + str + ", contact = " + this.ehM);
        if (!hasInit()) {
            C4990ab.m7412e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.lyb + "contact = " + this.ehM);
            AppMethodBeat.m2505o(28103);
        } else if (C5046bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.m2505o(28103);
        } else {
            if (this.ehM != null && this.ehM.field_username.equals(str)) {
                C9638aw.m17190ZK();
                this.ehM = C18628c.m29078XM().aoO(str);
                C5004al.m7441d(new C358806());
            }
            AppMethodBeat.m2505o(28103);
        }
    }

    /* renamed from: a */
    public final void mo7925a(final C7575bv c7575bv) {
        AppMethodBeat.m2504i(28104);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(28080);
                if (!(NormalUserHeaderPreference.this.ehM == null || c7575bv == null || !NormalUserHeaderPreference.this.ehM.field_username.equals(c7575bv.field_encryptUsername))) {
                    NormalUserHeaderPreference.this.ehM.mo14729iz(c7575bv.field_conRemark);
                    if (NormalUserHeaderPreference.m58825j(NormalUserHeaderPreference.this)) {
                        NormalUserHeaderPreference.m58821f(NormalUserHeaderPreference.this);
                    } else {
                        C4990ab.m7412e("MicroMsg.ContactInfoHeader", "initView : bindView = " + NormalUserHeaderPreference.this.lyb + "contact = " + NormalUserHeaderPreference.this.ehM.field_username);
                        AppMethodBeat.m2505o(28080);
                        return;
                    }
                }
                AppMethodBeat.m2505o(28080);
            }
        });
        AppMethodBeat.m2505o(28104);
    }

    private void dlb() {
        AppMethodBeat.m2504i(28105);
        if (C46270n.isShowStoryCheck()) {
            C35168e c35168e = (C35168e) C1720g.m3530M(C35168e.class);
            RelativeLayout.LayoutParams layoutParams;
            if (c35168e.isStoryExist(this.ehM.field_username)) {
                this.vqS.setVisibility(0);
                this.vqT.setVisibility(0);
                layoutParams = (RelativeLayout.LayoutParams) this.vqP.getLayoutParams();
                layoutParams.topMargin = C1338a.fromDPToPix(this.crP, 166);
                this.vqP.setLayoutParams(layoutParams);
            } else {
                this.vqS.setVisibility(8);
                this.vqT.setVisibility(8);
                layoutParams = (RelativeLayout.LayoutParams) this.vqP.getLayoutParams();
                layoutParams.topMargin = 0;
                this.vqP.setLayoutParams(layoutParams);
            }
            c35168e.loadStory(this.ehM.field_username, this.ejD);
            AppMethodBeat.m2505o(28105);
            return;
        }
        this.vqS.setVisibility(8);
        AppMethodBeat.m2505o(28105);
    }

    /* renamed from: UV */
    private static boolean m58815UV(String str) {
        AppMethodBeat.m2504i(28086);
        if (C21877n.qFA != null) {
            boolean UV = C21877n.qFA.mo37357UV(str);
            AppMethodBeat.m2505o(28086);
            return UV;
        }
        AppMethodBeat.m2505o(28086);
        return false;
    }
}
