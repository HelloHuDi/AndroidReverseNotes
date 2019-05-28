package com.tencent.p177mm.plugin.profile.p483ui;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.openim.room.p266a.C42249a;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2206au;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42464aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.profile.C39503b;
import com.tencent.p177mm.plugin.profile.p1286a.C43387b;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.ProfileHdHeadImg;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.preference.C14957b;
import com.tencent.p177mm.pluginsdk.p597ui.preference.C35883a.C14956a;
import com.tencent.p177mm.pluginsdk.p597ui.preference.FMessageListView;
import com.tencent.p177mm.pluginsdk.p597ui.preference.PhoneNumPreference;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7569ax;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference */
public class NormalProfileHeaderPreference extends Preference implements OnClickListener, OnLongClickListener {
    private int gOW;
    public C15541f iFE;
    private C7616ad ldh;
    private Context mContext;
    private View omq;
    private C43387b pkh;
    private boolean pnP = false;
    private String pnQ;
    private boolean pnR;
    private int pnS;
    private boolean readOnly = false;

    /* renamed from: com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference$a */
    class C3615a {
        TextView niS = null;
        TextView nrD = null;
        private View pnV = null;
        private View pnW = null;
        private View pnX = null;
        private View pnY = null;
        private View pnZ = null;
        private View poa = null;
        ImageView pob = null;
        TextView poc = null;
        MMNeat7extView pod = null;
        TextView poe = null;
        TextView pof = null;
        TextView pog = null;
        TextView poh = null;
        TextView poi = null;
        ImageView poj = null;
        FMessageListView pok;
        private View pol;
        private LinearLayout pom = null;
        ImageView pon;
        ImageView poo;
        ImageView pop;
        View poq;
        private ImageView por;
        View pot;
        private View pou;

        C3615a(View view) {
            AppMethodBeat.m2504i(23655);
            this.poq = view.findViewById(2131823097);
            this.pok = (FMessageListView) view.findViewById(2131823101);
            this.pol = view.findViewById(2131823100);
            this.pnV = view.findViewById(2131823104);
            this.pnW = view.findViewById(2131823105);
            this.pnX = view.findViewById(2131823102);
            this.pnZ = view.findViewById(2131823103);
            this.poa = view.findViewById(2131823106);
            this.pnY = view.findViewById(2131823108);
            this.poj = (ImageView) view.findViewById(2131823083);
            this.poe = (TextView) view.findViewById(2131823091);
            this.pod = (MMNeat7extView) view.findViewById(2131823084);
            this.niS = (TextView) view.findViewById(2131823090);
            this.poc = (TextView) view.findViewById(2131823089);
            this.pob = (ImageView) view.findViewById(2131823085);
            this.nrD = (TextView) view.findViewById(2131823092);
            this.pof = (TextView) view.findViewById(2131823093);
            this.pog = (TextView) view.findViewById(2131823095);
            this.poh = (TextView) view.findViewById(2131823094);
            this.poi = (TextView) view.findViewById(2131823096);
            this.pon = (ImageView) view.findViewById(2131823088);
            this.poo = (ImageView) view.findViewById(2131823087);
            this.pop = (ImageView) view.findViewById(2131823086);
            this.por = (ImageView) view.findViewById(2131823080);
            this.pot = view.findViewById(2131823079);
            this.pou = view.findViewById(2131823082);
            this.pom = (LinearLayout) view.findViewById(2131823081);
            this.poq.findViewById(2131823098).setOnClickListener(NormalProfileHeaderPreference.this);
            this.poq.findViewById(2131823099).setOnClickListener(NormalProfileHeaderPreference.this);
            this.poa.setOnClickListener(NormalProfileHeaderPreference.this);
            this.pnY.setOnClickListener(NormalProfileHeaderPreference.this);
            this.poj.setOnClickListener(NormalProfileHeaderPreference.this);
            this.pnV.setOnClickListener(NormalProfileHeaderPreference.this);
            this.pnW.setOnClickListener(NormalProfileHeaderPreference.this);
            this.pnX.setOnClickListener(NormalProfileHeaderPreference.this);
            this.pnZ.setOnClickListener(NormalProfileHeaderPreference.this);
            this.nrD.setOnLongClickListener(NormalProfileHeaderPreference.this);
            this.por.setOnClickListener(NormalProfileHeaderPreference.this);
            AppMethodBeat.m2505o(23655);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference$1 */
    class C36161 implements OnCreateContextMenuListener {
        C36161() {
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(23652);
            contextMenu.add(NormalProfileHeaderPreference.this.mContext.getString(C25738R.string.f9082oy));
            AppMethodBeat.m2505o(23652);
        }
    }

    public NormalProfileHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    public NormalProfileHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    /* renamed from: a */
    public final void mo8202a(C7616ad c7616ad, int i, boolean z, C43387b c43387b) {
        AppMethodBeat.m2504i(23656);
        this.pnQ = ((Activity) this.mContext).getIntent().getStringExtra("Contact_RoomNickname");
        this.ldh = c7616ad;
        this.gOW = i;
        this.readOnly = z;
        this.pnP = true;
        this.pkh = c43387b;
        AppMethodBeat.m2505o(23656);
    }

    public final void onDetach() {
        AppMethodBeat.m2504i(23657);
        if (this.omq != null) {
            C3615a c3615a = (C3615a) this.omq.getTag();
            if (c3615a.pok != null) {
                c3615a.pok.detach();
            }
        }
        AppMethodBeat.m2505o(23657);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(23658);
        if (this.omq == null) {
            this.omq = super.onCreateView(viewGroup);
        }
        View view = this.omq;
        AppMethodBeat.m2505o(23658);
        return view;
    }

    /* JADX WARNING: Removed duplicated region for block: B:72:0x0382  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x02c2  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0393  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x02d8  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x03a4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x02fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23659);
        super.onBindView(view);
        if (this.pnP) {
            int intrinsicWidth;
            boolean Od;
            Object obj;
            TextView textView;
            StringBuilder append;
            String Hq;
            if (view.getTag() == null) {
                view.setTag(new C3615a(view));
            }
            C3615a c3615a = (C3615a) view.getTag();
            C40460b.m69434b(c3615a.poj, this.ldh.field_username);
            if (!C5046bo.isNullOrNil(m5951N(this.ldh))) {
                int intrinsicWidth2;
                c3615a.pod.setVisibility(0);
                float textSize = c3615a.pod.getTextSize();
                CharSequence N = m5951N(this.ldh);
                int dimension = (int) this.mContext.getResources().getDimension(C25738R.dimen.f9811ge);
                int dimension2 = ((int) this.mContext.getResources().getDimension(C25738R.dimen.f9804g7)) * 3;
                intrinsicWidth = this.ldh.dtS != 0 ? this.mContext.getResources().getDrawable(C1318a.ic_sex_male).getIntrinsicWidth() : 0;
                Od = this.ldh.mo16701Od();
                boolean UV = C21877n.qFA.mo37357UV(this.ldh.field_username);
                boolean Oc = this.ldh.mo16700Oc();
                int dimension3 = (int) this.mContext.getResources().getDimension(C25738R.dimen.f9797fz);
                if (Od) {
                    intrinsicWidth2 = (this.mContext.getResources().getDrawable(C1318a.circle_notreceive).getIntrinsicWidth() + dimension3) + dimension3;
                } else {
                    intrinsicWidth2 = dimension3;
                }
                if (Oc) {
                    intrinsicWidth2 = (intrinsicWidth2 + this.mContext.getResources().getDrawable(C1318a.profile_star_icon).getIntrinsicWidth()) + dimension3;
                }
                if (UV) {
                    intrinsicWidth2 = (intrinsicWidth2 + this.mContext.getResources().getDrawable(C1318a.circle_notvisible).getIntrinsicWidth()) + dimension3;
                }
                intrinsicWidth = (((this.mContext.getResources().getDisplayMetrics().widthPixels - dimension) - dimension2) - intrinsicWidth) - intrinsicWidth2;
                C4990ab.m7417i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] calculateRemarkNameTvSize:%s", Integer.valueOf(intrinsicWidth));
                c3615a.pod.setMaxWidth(intrinsicWidth);
                c3615a.pod.mo15921ah(C44089j.m79293b(this.mContext, N, textSize));
                c3615a.pod.setContentDescription(C44089j.m79293b(this.mContext, N, textSize));
                if (c3615a.pod.mo15918QV(intrinsicWidth).dPe() > 1) {
                    c3615a.pod.setTextSize(C1338a.m2860dm(this.mContext) * ((float) C1338a.m2859ao(this.mContext, (int) c3615a.pod.getResources().getDimension(C25738R.dimen.f10021nn))));
                    c3615a.pod.mo15921ah(C44089j.m79293b(this.mContext, N, c3615a.pod.getTextSize()));
                }
                if (this.pnR) {
                    c3615a.pod.setTextColor(this.mContext.getResources().getColor(C25738R.color.a6a));
                    c3615a.pod.setMaxLines(1);
                } else {
                    c3615a.pod.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11785h7));
                    c3615a.pod.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
                }
                c3615a.pod.getPaint().setFakeBoldText(true);
            }
            String stringExtra = ((Activity) this.mContext).getIntent().getStringExtra("Contact_Distance");
            if (!((Activity) this.mContext).getIntent().getBooleanExtra("Contact_IsLBSFriend", false) || C5046bo.isNullOrNil(stringExtra)) {
                c3615a.poh.setVisibility(8);
            } else {
                c3615a.poh.setText(this.mContext.getString(C25738R.string.avn) + stringExtra);
                c3615a.poh.setVisibility(0);
            }
            if (C7616ad.aox(this.ldh.field_username)) {
                c3615a.poc.setVisibility(0);
                c3615a.poc.setText(C42249a.m74595A(this.ldh));
            }
            if (C5046bo.isNullOrNil(this.ldh.field_nickname) || C5046bo.isNullOrNil(this.ldh.field_conRemark) || caj()) {
                c3615a.niS.setVisibility(8);
            } else {
                c3615a.niS.setVisibility(0);
                c3615a.niS.setText(C44089j.m79293b(this.mContext, this.mContext.getString(C25738R.string.ay7) + this.ldh.field_nickname, c3615a.niS.getTextSize()));
            }
            if (!C5046bo.isNullOrNil(this.pnQ)) {
                if (((Activity) this.mContext).getIntent().getIntExtra("Contact_Scene", -1) == 14) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    c3615a.poe.setVisibility(0);
                    c3615a.poe.setText(C44089j.m79293b(this.mContext, this.mContext.getString(C25738R.string.av8) + this.pnQ, c3615a.niS.getTextSize()));
                    if ((C5046bo.isNullOrNil(this.ldh.mo14673Hq()) || !C5046bo.isNullOrNil(this.ldh.field_username)) && C7486a.m12942jh(this.ldh.field_type) && !C7616ad.aox(this.ldh.field_username) && !caj()) {
                        c3615a.nrD.setVisibility(0);
                        textView = c3615a.nrD;
                        append = new StringBuilder().append(this.mContext.getString(C25738R.string.f9131qf));
                        if (C5046bo.isNullOrNil(this.ldh.mo14673Hq())) {
                            Hq = this.ldh.mo14673Hq();
                        } else {
                            Hq = this.ldh.field_username;
                        }
                        textView.setText(append.append(Hq).toString());
                    } else {
                        c3615a.nrD.setVisibility(8);
                    }
                    if (this.ldh.field_deleteFlag != 1) {
                        c3615a.poi.setVisibility(0);
                        c3615a.poi.setText(this.mContext.getText(C25738R.string.att));
                        c3615a.niS.setVisibility(8);
                        c3615a.pof.setVisibility(8);
                        obj = 1;
                    } else {
                        c3615a.poi.setVisibility(8);
                        c3615a.pof.setVisibility(8);
                        obj = null;
                    }
                    if (obj == null) {
                        C4990ab.m7417i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] has delete account! username:%s", this.ldh.field_username);
                        AppMethodBeat.m2505o(23659);
                        return;
                    }
                    if (!C7486a.m12942jh(this.ldh.field_type) && !caj() && !C1855t.m3916nB(this.ldh.field_username)) {
                        C4990ab.m7417i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] accept contact! username:%s", this.ldh.field_username);
                        c3615a.poq.setVisibility(8);
                    } else if (c3615a.poq != null) {
                        c3615a.poq.setVisibility(8);
                    }
                    if (C7486a.m12942jh(this.ldh.field_type) || !((Activity) this.mContext).getIntent().getBooleanExtra("User_Verify", false)) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        c3615a.poq.setVisibility(0);
                    } else {
                        c3615a.poq.setVisibility(8);
                    }
                    NormalProfileHeaderPreference.m5954a(c3615a, this.mContext, this.ldh, this.gOW, C28705p.m45603a(this.mContext, this.ldh, this.gOW));
                    if (C5046bo.isNullOrNil(this.ldh.signature)) {
                        c3615a.pof.setVisibility(8);
                    } else {
                        c3615a.pof.setText(C44089j.m79292b(this.mContext, this.ldh.signature));
                        c3615a.pof.setVisibility(8);
                    }
                    if (C5046bo.isNullOrNil(this.ldh.getProvince())) {
                        c3615a.pog.setVisibility(8);
                    } else {
                        c3615a.pog.setVisibility(0);
                        StringBuilder append2 = new StringBuilder().append(C1854s.m3868mL(this.ldh.getProvince()));
                        if (C5046bo.isNullOrNil(this.ldh.getCity())) {
                            Hq = "";
                        } else {
                            Hq = "  " + this.ldh.getCity();
                        }
                        c3615a.pog.setText(this.mContext.getString(C25738R.string.axm) + append2.append(Hq).toString());
                    }
                    ImageView imageView = c3615a.pob;
                    C7616ad c7616ad = this.ldh;
                    imageView.setVisibility(0);
                    if (c7616ad.dtS == 1) {
                        imageView.setImageDrawable(C1338a.m2864g(this.mContext, C1318a.ic_sex_male));
                        imageView.setContentDescription(this.mContext.getString(C25738R.string.dex));
                    } else if (c7616ad.dtS == 2) {
                        imageView.setImageDrawable(C1338a.m2864g(this.mContext, C1318a.ic_sex_female));
                        imageView.setContentDescription(this.mContext.getString(C25738R.string.dew));
                    } else if (c7616ad.dtS == 0) {
                        imageView.setVisibility(8);
                    }
                    intrinsicWidth = ((Activity) this.mContext).getIntent().getIntExtra("Contact_Scene", 0);
                    if (26 > intrinsicWidth || intrinsicWidth > 29) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        c3615a.poh.setVisibility(0);
                        c3615a.niS.setVisibility(8);
                        c3615a.poh.setText(this.mContext.getString(C25738R.string.avn) + stringExtra);
                    }
                    if (!C1855t.m3916nB(this.ldh.field_username)) {
                        boolean Od2 = this.ldh.mo16701Od();
                        Od = C21877n.qFA.mo37357UV(this.ldh.field_username);
                        ImageView imageView2 = c3615a.poo;
                        if (Od2) {
                            intrinsicWidth = 0;
                        } else {
                            intrinsicWidth = 8;
                        }
                        imageView2.setVisibility(intrinsicWidth);
                        imageView2 = c3615a.pop;
                        if (Od && C7486a.m12942jh(this.ldh.field_type)) {
                            intrinsicWidth = 0;
                        } else {
                            intrinsicWidth = 8;
                        }
                        imageView2.setVisibility(intrinsicWidth);
                        ImageView imageView3 = c3615a.pon;
                        if (this.ldh.mo16700Oc() && C7486a.m12942jh(this.ldh.field_type)) {
                            intrinsicWidth = 0;
                        } else {
                            intrinsicWidth = 8;
                        }
                        imageView3.setVisibility(intrinsicWidth);
                    }
                    intrinsicWidth = C5230ak.getStatusBarHeight(this.mContext);
                    C4990ab.m7411d("MicroMsg.NormalProfileHeaderPreference", "actionBarHeight=%s statusBarHeight=%s", Integer.valueOf(this.pnS), Integer.valueOf(intrinsicWidth));
                    if (this.pnR) {
                        c3615a.pot.setPadding(c3615a.pot.getPaddingLeft(), C1338a.m2857am(this.mContext, C25738R.dimen.a7h), c3615a.pot.getPaddingRight(), c3615a.pot.getPaddingBottom());
                        AppMethodBeat.m2505o(23659);
                        return;
                    } else if (intrinsicWidth <= 0 || this.pnS <= 0) {
                        c3615a.pot.setPadding(c3615a.pot.getPaddingLeft(), C1338a.m2857am(this.mContext, C25738R.dimen.a7j), c3615a.pot.getPaddingRight(), c3615a.pot.getPaddingBottom());
                        AppMethodBeat.m2505o(23659);
                        return;
                    } else {
                        c3615a.pot.setPadding(c3615a.pot.getPaddingLeft(), (intrinsicWidth + this.pnS) + C1338a.m2857am(this.mContext, C25738R.dimen.f10011nc), c3615a.pot.getPaddingRight(), c3615a.pot.getPaddingBottom());
                        AppMethodBeat.m2505o(23659);
                        return;
                    }
                }
            }
            c3615a.poe.setVisibility(8);
            if (C5046bo.isNullOrNil(this.ldh.mo14673Hq())) {
            }
            c3615a.nrD.setVisibility(0);
            textView = c3615a.nrD;
            append = new StringBuilder().append(this.mContext.getString(C25738R.string.f9131qf));
            if (C5046bo.isNullOrNil(this.ldh.mo14673Hq())) {
            }
            textView.setText(append.append(Hq).toString());
            if (this.ldh.field_deleteFlag != 1) {
            }
            if (obj == null) {
            }
        } else {
            C4990ab.m7420w("MicroMsg.NormalProfileHeaderPreference", "[onBindView] never attach!");
            AppMethodBeat.m2505o(23659);
        }
    }

    private boolean caj() {
        AppMethodBeat.m2504i(23660);
        boolean mR = C7616ad.m13548mR(this.ldh.field_username);
        AppMethodBeat.m2505o(23660);
        return mR;
    }

    /* renamed from: N */
    private String m5951N(C7616ad c7616ad) {
        String trim;
        AppMethodBeat.m2504i(23661);
        if (caj()) {
            Resources resources = this.mContext.getResources();
            Object[] objArr = new Object[1];
            objArr[0] = C5046bo.isNullOrNil(c7616ad.getCity()) ? C1854s.m3868mL(c7616ad.getProvince()) : c7616ad.getCity();
            trim = resources.getString(C25738R.string.aa8, objArr).trim();
        } else {
            trim = c7616ad.mo16707Oj();
        }
        trim = C5046bo.m7532bc(trim, "");
        AppMethodBeat.m2505o(23661);
        return trim;
    }

    /* renamed from: a */
    private static void m5954a(C3615a c3615a, Context context, C7616ad c7616ad, int i, C14957b[] c14957bArr) {
        int i2 = 0;
        AppMethodBeat.m2504i(23662);
        if (c14957bArr == null || C7486a.m12942jh(c7616ad.field_type)) {
            c3615a.pok.setVisibility(8);
            AppMethodBeat.m2505o(23662);
            return;
        }
        c3615a.pok.setVisibility(0);
        String nullAsNil = C5046bo.nullAsNil(((Activity) context).getIntent().getStringExtra("Verify_ticket"));
        C14956a c14956a = new C14956a();
        c14956a.talker = c7616ad.field_username;
        c14956a.scene = i;
        c14956a.mGZ = nullAsNil;
        c14956a.vqs = c7616ad.dus;
        c14956a.type = 0;
        if (i == 18) {
            c14956a.type = 1;
        } else if (C1829bf.m3750kE(i)) {
            c14956a.type = 2;
        }
        c3615a.pok.setFMessageArgs(c14956a);
        int length = c14957bArr.length;
        while (i2 < length) {
            c3615a.pok.mo39054a(c14957bArr[i2]);
            i2++;
        }
        AppMethodBeat.m2505o(23662);
    }

    /* renamed from: A */
    public final void mo8201A(boolean z, int i) {
        AppMethodBeat.m2504i(23663);
        C4990ab.m7411d("MicroMsg.NormalProfileHeaderPreference", "setHasStory action=%s", Integer.valueOf(i));
        this.pnR = z;
        this.pnS = i;
        if (this.iFE != null) {
            this.iFE.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(23663);
    }

    /* renamed from: a */
    public static CharSequence m5953a(Context context, C7616ad c7616ad, int i, String str, boolean z) {
        AppMethodBeat.m2504i(23664);
        if (i == 9) {
            i = c7616ad.getSource();
        }
        CharSequence string;
        String str2;
        switch (i) {
            case 1:
                if (z || c7616ad.mo16709Ol() > 1000000) {
                    string = context.getResources().getString(C25738R.string.b1d);
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else if (C7486a.m12942jh(c7616ad.field_type)) {
                    string = context.getResources().getString(C25738R.string.b1c);
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else {
                    string = context.getResources().getString(C25738R.string.b1e);
                    AppMethodBeat.m2505o(23664);
                    return string;
                }
            case 3:
                if (z || c7616ad.mo16709Ol() > 1000000) {
                    string = context.getResources().getString(C25738R.string.b1g);
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else if (C7486a.m12942jh(c7616ad.field_type)) {
                    string = context.getResources().getString(C25738R.string.b1f);
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else {
                    string = context.getResources().getString(C25738R.string.b1h);
                    AppMethodBeat.m2505o(23664);
                    return string;
                }
            case 4:
            case 12:
                string = context.getResources().getString(C25738R.string.bw3);
                AppMethodBeat.m2505o(23664);
                return string;
            case 6:
                string = context.getResources().getString(C25738R.string.bw4);
                AppMethodBeat.m2505o(23664);
                return string;
            case 8:
            case 14:
            case 96:
                C7569ax apw = C41789d.akO().apw(str);
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(apw == null ? "" : apw.field_chatroomName);
                if (aoO != null) {
                    str2 = aoO.field_nickname;
                } else {
                    str2 = "";
                }
                if (z || c7616ad.mo16709Ol() > 1000000) {
                    if (C5046bo.isNullOrNil(str2)) {
                        string = context.getString(C25738R.string.b0y);
                    } else {
                        string = context.getString(C25738R.string.b10, new Object[]{str2});
                    }
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else if (C7486a.m12942jh(c7616ad.field_type)) {
                    string = context.getResources().getString(C25738R.string.b0z, new Object[]{str2});
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else {
                    string = context.getResources().getString(C25738R.string.b0x);
                    AppMethodBeat.m2505o(23664);
                    return string;
                }
            case 10:
            case 13:
                if (z || c7616ad.mo16709Ol() > 1000000) {
                    string = context.getResources().getString(C25738R.string.b1m);
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else if (C7486a.m12942jh(c7616ad.field_type)) {
                    string = context.getResources().getString(C25738R.string.b1l);
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else {
                    string = context.getResources().getString(C25738R.string.b1n);
                    AppMethodBeat.m2505o(23664);
                    return string;
                }
            case 15:
                if (z || c7616ad.mo16709Ol() > 1000000) {
                    string = context.getResources().getString(C25738R.string.b1a);
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else if (C7486a.m12942jh(c7616ad.field_type)) {
                    string = context.getResources().getString(C25738R.string.b1_);
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else {
                    string = context.getResources().getString(C25738R.string.b1b);
                    AppMethodBeat.m2505o(23664);
                    return string;
                }
            case 17:
                str2 = C1854s.m3866mJ(((Activity) context).getIntent().getStringExtra("source_from_user_name"));
                if (C5046bo.isNullOrNil(str2)) {
                    str2 = ((Activity) context).getIntent().getStringExtra("source_from_nick_name");
                }
                if (z || c7616ad.mo16709Ol() > 1000000) {
                    if (C5046bo.isNullOrNil(str2)) {
                        string = context.getString(C25738R.string.b0u);
                    } else {
                        string = C44089j.m79292b(context, context.getString(C25738R.string.b0t, new Object[]{str2}));
                    }
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else if (C7486a.m12942jh(c7616ad.field_type)) {
                    if (C5046bo.isNullOrNil(str2)) {
                        string = context.getString(C25738R.string.b0r);
                    } else {
                        string = C44089j.m79292b(context, context.getString(C25738R.string.b0s, new Object[]{str2}));
                    }
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else if (C5046bo.isNullOrNil(str2)) {
                    string = C44089j.m79292b(context, context.getString(C25738R.string.b0w));
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else {
                    string = context.getString(C25738R.string.b0v, new Object[]{str2});
                    AppMethodBeat.m2505o(23664);
                    return string;
                }
            case 18:
                if (z || c7616ad.mo16709Ol() > 1000000) {
                    string = context.getResources().getString(C25738R.string.b12);
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else if (C7486a.m12942jh(c7616ad.field_type)) {
                    string = context.getResources().getString(C25738R.string.b11);
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else {
                    string = context.getResources().getString(C25738R.string.b13);
                    AppMethodBeat.m2505o(23664);
                    return string;
                }
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
            case 29:
                if (z || c7616ad.mo16709Ol() > 1000000) {
                    string = context.getResources().getString(C25738R.string.b1j);
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else if (C7486a.m12942jh(c7616ad.field_type)) {
                    string = context.getResources().getString(C25738R.string.b1i);
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else {
                    string = context.getResources().getString(C25738R.string.b1k);
                    AppMethodBeat.m2505o(23664);
                    return string;
                }
            case 25:
                if (z || c7616ad.mo16709Ol() > 1000000) {
                    string = context.getResources().getString(C25738R.string.b0p);
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else if (C7486a.m12942jh(c7616ad.field_type)) {
                    string = context.getResources().getString(C25738R.string.b0o);
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else {
                    string = context.getResources().getString(C25738R.string.b0q);
                    AppMethodBeat.m2505o(23664);
                    return string;
                }
            case 30:
                if (z || c7616ad.mo16709Ol() > 1000000) {
                    string = context.getResources().getString(C25738R.string.b17);
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else if (C7486a.m12942jh(c7616ad.field_type)) {
                    string = context.getResources().getString(C25738R.string.b16);
                    AppMethodBeat.m2505o(23664);
                    return string;
                } else {
                    string = context.getResources().getString(C25738R.string.b18);
                    AppMethodBeat.m2505o(23664);
                    return string;
                }
            case 34:
                string = context.getResources().getString(C25738R.string.b0m);
                AppMethodBeat.m2505o(23664);
                return string;
            case 48:
                string = context.getResources().getString(C25738R.string.b19);
                AppMethodBeat.m2505o(23664);
                return string;
            case C42464aa.CTRL_INDEX /*58*/:
            case C2206au.CTRL_INDEX /*59*/:
            case 60:
                string = context.getResources().getString(C25738R.string.c8k);
                AppMethodBeat.m2505o(23664);
                return string;
            case 76:
                string = context.getResources().getString(C25738R.string.b14);
                AppMethodBeat.m2505o(23664);
                return string;
            default:
                AppMethodBeat.m2505o(23664);
                return null;
        }
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(23665);
        int id = view.getId();
        if (id == 2131823098) {
            C7616ad c7616ad = this.ldh;
            if (c7616ad == null) {
                C4990ab.m7412e("MicroMsg.NormalProfileHeaderPreference", "contact is null");
                AppMethodBeat.m2505o(23665);
                return;
            } else if (C7486a.m12942jh(c7616ad.field_type)) {
                PhoneNumPreference phoneNumPreference = (PhoneNumPreference) this.iFE.aqO("contact_profile_phone");
                Intent intent = new Intent();
                intent.putExtra("Contact_Scene", this.gOW);
                intent.putExtra("Contact_User", c7616ad.field_username);
                intent.putExtra("view_mode", true);
                intent.putExtra("contact_phone_number_by_md5", phoneNumPreference.vim);
                intent.putExtra("contact_phone_number_list", c7616ad.dur);
                C39503b.gkE.mo38928m(intent, this.mContext);
                AppMethodBeat.m2505o(23665);
                return;
            } else if (C5046bo.isNullOrNil(c7616ad.field_encryptUsername)) {
                m5956a(c7616ad.field_username, c7616ad);
                AppMethodBeat.m2505o(23665);
                return;
            } else {
                m5956a(c7616ad.field_encryptUsername, c7616ad);
                AppMethodBeat.m2505o(23665);
                return;
            }
        }
        if (id == 2131823099) {
            if (this.pkh != null) {
                this.pkh.cas();
                AppMethodBeat.m2505o(23665);
                return;
            }
        } else if (id == 2131823083) {
            String str = this.ldh.field_username;
            Intent intent2 = new Intent(this.mContext, ProfileHdHeadImg.class);
            intent2.putExtra("username", str);
            this.mContext.startActivity(intent2);
        }
        AppMethodBeat.m2505o(23665);
    }

    public boolean onLongClick(View view) {
        AppMethodBeat.m2504i(23666);
        if (view.getId() == 2131823092) {
            final TextView textView = (TextView) view;
            final C7616ad c7616ad = this.ldh;
            final ClipboardManager clipboardManager = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
            if (!(textView.getText() == null || clipboardManager == null)) {
                String charSequence = textView.getText().toString();
                int indexOf = charSequence.indexOf(58);
                if (indexOf >= 0 && indexOf < charSequence.length()) {
                    charSequence = charSequence.substring(indexOf + 1).trim();
                }
                SpannableString spannableString = new SpannableString(textView.getText());
                spannableString.setSpan(new BackgroundColorSpan(this.mContext.getResources().getColor(C25738R.color.f12117sz)), indexOf + 1, textView.getText().length(), 33);
                textView.setText(spannableString);
                C24088a c24088a = new C24088a(this.mContext, textView);
                c24088a.zRZ = new C36161();
                c24088a.rBm = new C5279d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.m2504i(23653);
                        if (i == 0) {
                            clipboardManager.setText(charSequence);
                            C30379h.m48464bP(NormalProfileHeaderPreference.this.mContext, NormalProfileHeaderPreference.this.mContext.getString(C25738R.string.f9083oz));
                        }
                        AppMethodBeat.m2505o(23653);
                    }
                };
                c24088a.zHM = new OnDismissListener() {
                    public final void onDismiss() {
                        AppMethodBeat.m2504i(23654);
                        NormalProfileHeaderPreference.m5955a(NormalProfileHeaderPreference.this, textView, c7616ad);
                        AppMethodBeat.m2505o(23654);
                    }
                };
                c24088a.mo22431dn(0, 0);
            }
            AppMethodBeat.m2505o(23666);
            return true;
        }
        AppMethodBeat.m2505o(23666);
        return false;
    }

    /* renamed from: a */
    private void m5956a(String str, C7616ad c7616ad) {
        AppMethodBeat.m2504i(23667);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.NormalProfileHeaderPreference", "view stranger remark, username is null");
            AppMethodBeat.m2505o(23667);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Scene", this.gOW);
        intent.putExtra("Contact_mode_name_type", 0);
        intent.putExtra("Contact_ModStrangerRemark", true);
        intent.putExtra("Contact_User", c7616ad.field_username);
        intent.putExtra("Contact_Nick", c7616ad.field_nickname);
        intent.putExtra("Contact_RemarkName", c7616ad.field_conRemark);
        C39503b.gkE.mo38929n(intent, this.mContext);
        AppMethodBeat.m2505o(23667);
    }

    /* renamed from: a */
    static /* synthetic */ void m5955a(NormalProfileHeaderPreference normalProfileHeaderPreference, TextView textView, C7616ad c7616ad) {
        AppMethodBeat.m2504i(23668);
        textView.setVisibility(0);
        if (!C5046bo.isNullOrNil(c7616ad.mo14673Hq())) {
            textView.setText(normalProfileHeaderPreference.mContext.getString(C25738R.string.f9131qf) + c7616ad.mo14673Hq());
            AppMethodBeat.m2505o(23668);
        } else if (C7616ad.aoA(c7616ad.field_username) || C1855t.m3911mX(c7616ad.field_username)) {
            textView.setVisibility(8);
            AppMethodBeat.m2505o(23668);
        } else {
            textView.setText(normalProfileHeaderPreference.mContext.getString(C25738R.string.f9131qf) + C5046bo.nullAsNil(c7616ad.mo16708Ok()));
            AppMethodBeat.m2505o(23668);
        }
    }
}
