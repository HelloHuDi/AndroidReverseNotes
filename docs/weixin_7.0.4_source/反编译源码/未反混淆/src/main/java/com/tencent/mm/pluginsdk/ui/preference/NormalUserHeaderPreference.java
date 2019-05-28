package com.tencent.mm.pluginsdk.ui.preference;

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
import com.tencent.mm.R;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.bi.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.ProfileLabelView;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class NormalUserHeaderPreference extends Preference implements a, m.a, b {
    MMActivity crP;
    ad ehM;
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

    static /* synthetic */ void f(NormalUserHeaderPreference normalUserHeaderPreference) {
        AppMethodBeat.i(28106);
        normalUserHeaderPreference.dkY();
        AppMethodBeat.o(28106);
    }

    static /* synthetic */ void g(NormalUserHeaderPreference normalUserHeaderPreference) {
        AppMethodBeat.i(28107);
        normalUserHeaderPreference.dla();
        AppMethodBeat.o(28107);
    }

    static /* synthetic */ void h(NormalUserHeaderPreference normalUserHeaderPreference) {
        AppMethodBeat.i(28108);
        normalUserHeaderPreference.dkW();
        AppMethodBeat.o(28108);
    }

    static /* synthetic */ boolean j(NormalUserHeaderPreference normalUserHeaderPreference) {
        AppMethodBeat.i(28109);
        boolean hasInit = normalUserHeaderPreference.hasInit();
        AppMethodBeat.o(28109);
        return hasInit;
    }

    public NormalUserHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(28081);
        this.crP = (MMActivity) context;
        init();
        AppMethodBeat.o(28081);
    }

    public NormalUserHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(28082);
        this.crP = (MMActivity) context;
        init();
        AppMethodBeat.o(28082);
    }

    private void init() {
        AppMethodBeat.i(28083);
        this.lyb = false;
        this.oMy = (ClipboardManager) ah.getContext().getSystemService("clipboard");
        AppMethodBeat.o(28083);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(28084);
        if (this.vqR != null) {
            this.vqR.detach();
        }
        View onCreateView = super.onCreateView(viewGroup);
        AppMethodBeat.o(28084);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(28085);
        ab.d("MicroMsg.ContactInfoHeader", "onBindView");
        this.niS = (TextView) view.findViewById(R.id.y2);
        this.nrD = (TextView) view.findViewById(R.id.b29);
        this.vqK = (TextView) view.findViewById(R.id.b2s);
        this.vqF = (TextView) view.findViewById(R.id.b2y);
        this.vqG = (TextView) view.findViewById(R.id.b2u);
        this.vqI = (Button) view.findViewById(R.id.b2v);
        this.vqJ = (Button) view.findViewById(R.id.b2w);
        this.vre = (ProfileMobilePhoneView) view.findViewById(R.id.b32);
        ProfileMobilePhoneView profileMobilePhoneView = this.vre;
        aw.ZK();
        profileMobilePhoneView.viy = ((Boolean) c.Ry().get(ac.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.FALSE)).booleanValue();
        this.vrf = (ProfileDescribeView) view.findViewById(R.id.b33);
        this.vrg = (ProfileLabelView) view.findViewById(R.id.b34);
        this.vrh = (TextView) view.findViewById(R.id.b31);
        this.vrf.setOnClickListener(this.vri);
        this.vrg.setOnClickListener(this.vri);
        this.vrh.setOnClickListener(this.vri);
        if (r.mG(this.ehM.field_username) || (!bo.isNullOrNil(this.ehM.field_username) && t.nB(this.ehM.field_username))) {
            this.vrh.setVisibility(8);
            this.vre.setVisibility(8);
            this.vrf.setVisibility(8);
            this.vrg.setVisibility(8);
        } else {
            this.vre.hG(this.vim, this.vin);
            if (com.tencent.mm.n.a.jh(this.ehM.field_type)) {
                this.vre.setVisibility(0);
            } else {
                this.vre.setVisibility(8);
            }
            boolean T = this.vrf.T(this.ehM);
            boolean T2 = this.vrg.T(this.ehM);
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
        this.tLA = (TextView) view.findViewById(R.id.b37);
        this.vqQ = (Button) view.findViewById(R.id.b2z);
        this.vqR = (FMessageListView) view.findViewById(R.id.b35);
        a.a aVar = new a.a();
        aVar.talker = this.ehM.field_username;
        aVar.scene = this.qvb;
        aVar.mGZ = this.mGZ;
        aVar.vqs = this.ehM.dus;
        aVar.type = 0;
        if (this.qvb == 18) {
            aVar.type = 1;
        } else if (bf.kE(this.qvb)) {
            aVar.type = 2;
        }
        this.vqR.setFMessageArgs(aVar);
        this.vqH = view.findViewById(R.id.b30);
        this.vqP = (LinearLayout) view.findViewById(R.id.b2k);
        this.pkS = (ImageView) view.findViewById(R.id.y1);
        this.quH = (ImageView) view.findViewById(R.id.b2m);
        this.vqL = (ImageView) view.findViewById(R.id.b2n);
        this.vqM = (CheckBox) view.findViewById(R.id.b2q);
        this.vqN = (ImageView) view.findViewById(R.id.b2p);
        this.vqO = (ImageView) view.findViewById(R.id.b2o);
        this.vqT = (ImageView) view.findViewById(R.id.b2j);
        this.vqS = (RelativeLayout) view.findViewById(R.id.b2i);
        this.lyb = true;
        initView();
        if (com.tencent.mm.n.a.jh(this.ehM.field_type)) {
            ab.d("MicroMsg.ContactInfoHeader", "initAddContent, showFMessageList false");
            this.vqR.setVisibility(8);
            if (this.vqR.getVisibility() == 8 && this.vrh.getVisibility() == 8 && this.vrg.getVisibility() == 8 && this.vrf.getVisibility() == 8 && this.tLA.getVisibility() == 8) {
                this.vqH.setVisibility(8);
            }
        } else if (this.mGZ == null || this.mGZ.length() == 0) {
            ab.d("MicroMsg.ContactInfoHeader", "initAddContent, FMessageListView gone, addScene = " + this.qvb + ", verifyTicket = " + this.mGZ);
            this.vqR.setVisibility(8);
            if (this.vqR.getVisibility() == 8 && this.vrh.getVisibility() == 8 && this.vrg.getVisibility() == 8 && this.vrf.getVisibility() == 8 && this.tLA.getVisibility() == 8) {
                this.vqH.setVisibility(8);
            }
        } else {
            b[] a;
            ab.d("MicroMsg.ContactInfoHeader", "initAddContent, scene = " + this.qvb);
            if (this.qvb == 18) {
                ab.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is lbs");
                a = b.a(this.crP, d.akQ().apz(this.ehM.field_username));
            } else if (bf.kE(this.qvb)) {
                ab.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is shake");
                a = b.a(this.crP, d.akR().apY(this.ehM.field_username));
            } else {
                ab.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is other");
                a = b.a(this.crP, d.akO().apv(this.ehM.field_username));
            }
            if (a == null || a.length == 0) {
                ab.e("MicroMsg.ContactInfoHeader", "initAddContent, providerList is null");
                this.vqR.setVisibility(8);
                if (this.vqR.getVisibility() == 8 && this.vrh.getVisibility() == 8 && this.vrg.getVisibility() == 8 && this.vrf.getVisibility() == 8 && this.tLA.getVisibility() == 8) {
                    this.vqH.setVisibility(8);
                }
            } else {
                ab.d("MicroMsg.ContactInfoHeader", "initAddContent, providerList size = " + a.length);
                for (b bVar : a) {
                    if (bVar != null) {
                        ab.d("MicroMsg.ContactInfoHeader", "initAddContent, username = " + bVar.username + ", nickname = " + bVar.nickname + ", digest = " + bVar.fjz + ", addScene = " + bVar.qvb);
                    }
                }
                if (ad.aox(this.ehM.field_username)) {
                    this.vqR.setVisibility(8);
                    this.vqR.setHide(true);
                } else {
                    this.vqR.setVisibility(0);
                    this.vqR.setHide(false);
                }
                if (this.vqR.getVisibility() == 0 || this.vrh.getVisibility() == 0 || this.vrg.getVisibility() == 0 || this.vrf.getVisibility() == 0 || this.tLA.getVisibility() == 0) {
                    this.vqH.setVisibility(0);
                }
                for (b a2 : a) {
                    this.vqR.a(a2);
                }
            }
        }
        super.onBindView(view);
        AppMethodBeat.o(28085);
    }

    private boolean hasInit() {
        return this.lyb && this.ehM != null;
    }

    private void cfI() {
        AppMethodBeat.i(28087);
        com.tencent.mm.pluginsdk.ui.a.b.b(this.pkS, this.ehM.field_username);
        if (this.pkS != null) {
            int al = com.tencent.mm.bz.a.al(this.mContext, R.dimen.dp);
            int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(this.crP, 88);
            if (al <= fromDPToPix) {
                fromDPToPix = al;
            }
            LayoutParams layoutParams = new LayoutParams(fromDPToPix, fromDPToPix);
            layoutParams.setMargins(0, 0, com.tencent.mm.bz.a.am(this.mContext, R.dimen.l8), 0);
            this.pkS.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(28087);
    }

    private void dkT() {
        AppMethodBeat.i(28088);
        this.vqK.setVisibility(0);
        this.niS.setText(j.b(this.crP, bo.nullAsNil(this.ehM.Oi()) + " ", this.niS.getTextSize()));
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
        AppMethodBeat.o(28088);
    }

    private void initView() {
        AppMethodBeat.i(28089);
        if (!hasInit()) {
            ab.w("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.lyb + "contact = " + this.ehM);
            AppMethodBeat.o(28089);
        } else if (this.pni) {
            dkT();
            AppMethodBeat.o(28089);
        } else {
            boolean mR = ad.mR(this.ehM.field_username);
            if (mR) {
                this.niS.setText("");
                if (ad.aoC(r.Yz()).equals(this.ehM.field_username)) {
                    this.vqQ.setVisibility(8);
                }
            } else {
                this.niS.setText(j.b(this.crP, bo.nullAsNil(this.ehM.field_nickname) + " ", this.niS.getTextSize()));
            }
            this.quH.setVisibility(0);
            this.vqX = true;
            if (this.ehM.dtS == 1) {
                this.quH.setImageDrawable(com.tencent.mm.bz.a.g(this.crP, R.raw.ic_sex_male));
                this.quH.setContentDescription(this.mContext.getString(R.string.dex));
            } else if (this.ehM.dtS == 2) {
                this.quH.setImageDrawable(com.tencent.mm.bz.a.g(this.crP, R.raw.ic_sex_female));
                this.quH.setContentDescription(this.mContext.getString(R.string.dew));
            } else if (this.ehM.dtS == 0) {
                this.quH.setVisibility(8);
                this.vqX = false;
            }
            if (this.ehM.field_verifyFlag != 0) {
                Bitmap i;
                this.vqL.setVisibility(0);
                if (ao.a.flw != null) {
                    i = BackwardSupportUtil.b.i(ao.a.flw.ky(this.ehM.field_verifyFlag), 2.0f);
                } else {
                    i = null;
                }
                this.vqL.setImageBitmap(i);
                this.vqU = i == null ? 0 : i.getWidth();
            }
            cfI();
            dlb();
            this.pkS.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(28071);
                    String str = NormalUserHeaderPreference.this.ehM.field_username;
                    if (ad.mR(str)) {
                        str = ad.aoC(str);
                    }
                    Intent intent = new Intent(NormalUserHeaderPreference.this.crP, ProfileHdHeadImg.class);
                    intent.putExtra("username", str);
                    NormalUserHeaderPreference.this.crP.startActivity(intent);
                    AppMethodBeat.o(28071);
                }
            });
            this.vqT.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(28072);
                    n.aT(NormalUserHeaderPreference.this.crP, NormalUserHeaderPreference.this.ehM.field_username);
                    AppMethodBeat.o(28072);
                }
            });
            if (ad.aow(this.ehM.field_username)) {
                this.nrD.setText(this.mContext.getString(R.string.q_) + this.ehM.Ok());
            } else if (ad.aou(this.ehM.field_username)) {
                this.nrD.setText(this.mContext.getString(R.string.ql) + this.ehM.Ok());
            } else if (this.pnc) {
                if (com.tencent.mm.n.a.jh(this.ehM.field_type)) {
                    dkU();
                } else if (this.ehM.due == null || this.ehM.due.equals("")) {
                    this.nrD.setText(R.string.pl);
                } else {
                    this.nrD.setText(this.ehM.due);
                }
            } else if (mR) {
                this.nrD.setText((bo.nullAsNil(s.mL(this.ehM.getProvince())) + " " + bo.nullAsNil(this.ehM.getCity())).trim());
            } else {
                if (!ad.aov(this.ehM.field_username) && this.crP.getIntent().getBooleanExtra("Contact_ShowUserName", true)) {
                    if (bo.isNullOrNil(this.ehM.Hq()) && (ad.aoA(this.ehM.field_username) || t.mX(this.ehM.field_username))) {
                        this.nrD.setVisibility(8);
                    } else if (com.tencent.mm.n.a.jh(this.ehM.field_type)) {
                        dkU();
                    }
                }
                this.nrD.setVisibility(8);
            }
            if (t.nB(this.ehM.field_username)) {
                this.tLA.setVisibility(0);
            } else {
                this.tLA.setVisibility(8);
            }
            dkY();
            dkW();
            dla();
            dkX();
            this.vqI.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(28073);
                    NormalUserHeaderPreference.this.vqZ = false;
                    NormalUserHeaderPreference normalUserHeaderPreference = NormalUserHeaderPreference.this;
                    aw.ZK();
                    ad aoO = c.XM().aoO(normalUserHeaderPreference.ehM.field_username);
                    if (!(aoO == null || ((int) aoO.ewQ) == 0 || !aoO.field_username.equals(normalUserHeaderPreference.ehM.field_username))) {
                        normalUserHeaderPreference.ehM = aoO;
                    }
                    Intent intent;
                    if (com.tencent.mm.n.a.jh(normalUserHeaderPreference.ehM.field_type)) {
                        intent = new Intent();
                        intent.setClassName(normalUserHeaderPreference.mContext, "com.tencent.mm.ui.contact.ContactRemarkInfoModUI");
                        intent.putExtra("Contact_Scene", normalUserHeaderPreference.qvb);
                        intent.putExtra("Contact_User", normalUserHeaderPreference.ehM.field_username);
                        intent.putExtra("Contact_RoomNickname", normalUserHeaderPreference.crP.getIntent().getStringExtra("Contact_RoomNickname"));
                        ((Activity) normalUserHeaderPreference.mContext).startActivity(intent);
                        AppMethodBeat.o(28073);
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
                    AppMethodBeat.o(28073);
                }
            });
            this.vqJ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(28074);
                    Intent intent = new Intent();
                    intent.putExtra("sns_permission_userName", NormalUserHeaderPreference.this.ehM.field_username);
                    intent.putExtra("sns_permission_anim", true);
                    intent.putExtra("sns_permission_block_scene", 3);
                    com.tencent.mm.bp.d.b(NormalUserHeaderPreference.this.crP, "sns", ".ui.SnsPermissionUI", intent);
                    AppMethodBeat.o(28074);
                }
            });
            dkV();
            this.nrD.setLongClickable(true);
            this.nrD.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(28078);
                    if (!(NormalUserHeaderPreference.this.nrD.getText() == null || NormalUserHeaderPreference.this.oMy == null)) {
                        String charSequence = NormalUserHeaderPreference.this.nrD.getText().toString();
                        int indexOf = charSequence.indexOf(58);
                        if (indexOf >= 0 && indexOf < charSequence.length()) {
                            charSequence = charSequence.substring(indexOf + 1).trim();
                        }
                        SpannableString spannableString = new SpannableString(NormalUserHeaderPreference.this.nrD.getText());
                        spannableString.setSpan(new BackgroundColorSpan(NormalUserHeaderPreference.this.crP.getResources().getColor(R.color.sz)), indexOf + 1, NormalUserHeaderPreference.this.nrD.getText().length(), 33);
                        NormalUserHeaderPreference.this.nrD.setText(spannableString);
                        com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(NormalUserHeaderPreference.this.crP, NormalUserHeaderPreference.this.nrD);
                        aVar.zRZ = new OnCreateContextMenuListener() {
                            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                                AppMethodBeat.i(28075);
                                contextMenu.add(NormalUserHeaderPreference.this.crP.getString(R.string.oy));
                                AppMethodBeat.o(28075);
                            }
                        };
                        aVar.rBm = new com.tencent.mm.ui.base.n.d() {
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                AppMethodBeat.i(28076);
                                if (i == 0) {
                                    NormalUserHeaderPreference.this.oMy.setText(charSequence);
                                    h.bP(NormalUserHeaderPreference.this.crP, NormalUserHeaderPreference.this.crP.getString(R.string.oz));
                                }
                                AppMethodBeat.o(28076);
                            }
                        };
                        aVar.zHM = new OnDismissListener() {
                            public final void onDismiss() {
                                AppMethodBeat.i(28077);
                                NormalUserHeaderPreference.this.dkU();
                                AppMethodBeat.o(28077);
                            }
                        };
                        aVar.dn(0, 0);
                    }
                    AppMethodBeat.o(28078);
                    return true;
                }
            });
            AppMethodBeat.o(28089);
        }
    }

    public final void dkU() {
        AppMethodBeat.i(28090);
        this.nrD.setVisibility(0);
        if (!bo.isNullOrNil(this.ehM.Hq())) {
            this.nrD.setText(this.mContext.getString(R.string.qf) + this.ehM.Hq());
            AppMethodBeat.o(28090);
        } else if (ad.aoA(this.ehM.field_username) || t.mX(this.ehM.field_username)) {
            this.nrD.setVisibility(8);
            AppMethodBeat.o(28090);
        } else {
            this.nrD.setText(this.mContext.getString(R.string.qf) + bo.nullAsNil(this.ehM.Ok()));
            AppMethodBeat.o(28090);
        }
    }

    private void dkV() {
        AppMethodBeat.i(28091);
        int i = 0;
        if (this.vqX) {
            i = com.tencent.mm.bz.a.fromDPToPix(this.crP, 17) + 0;
        }
        i += this.vqU;
        if (this.vqV) {
            i += com.tencent.mm.bz.a.fromDPToPix(this.crP, 27);
        }
        if (this.vqW) {
            i += com.tencent.mm.bz.a.fromDPToPix(this.crP, 27);
        }
        if (this.vqY) {
            i += com.tencent.mm.bz.a.fromDPToPix(this.crP, 30);
        }
        if (com.tencent.mm.bz.a.ga(this.mContext)) {
            i += com.tencent.mm.bz.a.fromDPToPix(this.crP, 88);
        } else {
            i += com.tencent.mm.bz.a.fromDPToPix(this.crP, 64);
        }
        this.niS.setMaxWidth(this.crP.getResources().getDisplayMetrics().widthPixels - (i + com.tencent.mm.bz.a.fromDPToPix(this.crP, 60)));
        AppMethodBeat.o(28091);
    }

    public final void bW(String str, boolean z) {
        AppMethodBeat.i(28092);
        if (str != null && str.equals(this.ehM.field_username)) {
            this.vqZ = z;
        }
        AppMethodBeat.o(28092);
    }

    public final void bX(String str, boolean z) {
        AppMethodBeat.i(28093);
        if (str != null && str.equals(this.ehM.field_username)) {
            this.vra = z;
        }
        AppMethodBeat.o(28093);
    }

    public final void a(ad adVar, int i, String str, String str2, String str3) {
        AppMethodBeat.i(28094);
        this.vim = str2;
        this.vin = str3;
        a(adVar, i, str);
        AppMethodBeat.o(28094);
    }

    public final void a(ad adVar, int i, String str) {
        boolean z = true;
        AppMethodBeat.i(28095);
        onDetach();
        aw.ZK();
        c.XM().a(this);
        aw.ZK();
        c.XN().a(this);
        o.acd().d(this);
        this.ehM = adVar;
        this.qvb = i;
        this.mGZ = str;
        this.pnc = this.crP.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
        this.vrc = this.crP.getIntent().getBooleanExtra("Contact_ShowFMessageList", false);
        this.vqZ = this.crP.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
        this.vra = this.crP.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
        this.vrb = this.crP.getIntent().getBooleanExtra("Contact_AlwaysShowRemarkBtn", false);
        this.poP = this.crP.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
        this.vrd = this.crP.getIntent().getStringExtra("Contact_RoomNickname");
        this.pni = adVar.field_deleteFlag == 1;
        this.ejD = this.crP.getIntent().getStringExtra("room_name");
        String str2 = "initView: contact username is null";
        if (bo.nullAsNil(adVar.field_username).length() <= 0) {
            z = false;
        }
        Assert.assertTrue(str2, z);
        initView();
        AppMethodBeat.o(28095);
    }

    public final void onDetach() {
        AppMethodBeat.i(28096);
        if (this.vqR != null) {
            this.vqR.detach();
        }
        if (this.vrc) {
            d.akP().apt(this.ehM.field_username);
        }
        this.crP.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.vqZ);
        this.crP.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.vra);
        aw.ZK();
        c.XM().b(this);
        o.acd().e(this);
        aw.ZK();
        c.XN().b(this);
        AppMethodBeat.o(28096);
    }

    private void dkW() {
        int i = 0;
        AppMethodBeat.i(28097);
        if (this.vqN != null && t.mM(this.ehM.field_username)) {
            this.vqW = this.ehM.Od();
            this.vqN.setVisibility(this.vqW ? 0 : 8);
        }
        if (this.vqO != null && t.mM(this.ehM.field_username)) {
            this.vqV = UV(this.ehM.field_username);
            ImageView imageView = this.vqO;
            if (!this.vqV) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
        AppMethodBeat.o(28097);
    }

    private void dkX() {
        AppMethodBeat.i(28098);
        if (bo.isNullOrNil(this.vrd)) {
            this.vqF.setVisibility(8);
            AppMethodBeat.o(28098);
            return;
        }
        if (!r.mG(this.ehM.field_username) && bo.nullAsNil(this.ehM.field_conRemark).length() > 0) {
            this.nrD.setVisibility(8);
        }
        this.vqF.setVisibility(0);
        this.vqF.setText(j.b(this.crP, this.crP.getString(R.string.av8) + this.vrd, this.vqF.getTextSize()));
        AppMethodBeat.o(28098);
    }

    private void dkY() {
        AppMethodBeat.i(28099);
        if (r.mG(this.ehM.field_username) || bo.nullAsNil(this.ehM.field_conRemark).length() <= 0) {
            this.vqG.setVisibility(8);
            this.niS.setText(j.b(this.crP, bo.nullAsNil(this.ehM.Oi()) + " ", this.niS.getTextSize()));
            if (this.vrb) {
                this.vqI.setVisibility(0);
                this.vrh.setVisibility(8);
            } else if (this.vqZ) {
                this.vqI.setVisibility(0);
                this.vrh.setVisibility(8);
            } else {
                if (com.tencent.mm.n.a.jh(this.ehM.field_type)) {
                    this.vqI.setVisibility(8);
                }
                boolean T = this.vrf.T(this.ehM);
                boolean T2 = this.vrg.T(this.ehM);
                if (T || T2) {
                    this.vrh.setVisibility(8);
                }
            }
        } else {
            this.niS.setText(j.b(this.crP, bo.nullAsNil(this.ehM.field_conRemark) + " ", this.niS.getTextSize()));
            this.vqG.setVisibility(0);
            this.vqG.setText(j.b(this.crP, this.mContext.getString(R.string.ay7) + this.ehM.Oi(), this.vqG.getTextSize()));
            this.vqI.setVisibility(8);
        }
        if (ad.aox(this.ehM.field_username)) {
            this.vrh.setText(R.string.b2o);
            dkZ();
        }
        if (this.poP && !com.tencent.mm.n.a.jh(this.ehM.field_type)) {
            this.vqJ.setVisibility(0);
        } else if (this.vra) {
            this.vqJ.setVisibility(0);
            if (com.tencent.mm.bz.a.ga(this.crP)) {
                this.vqJ.setTextSize(0, (float) this.crP.getResources().getDimensionPixelSize(R.dimen.kr));
                this.vqI.setTextSize(0, (float) this.crP.getResources().getDimensionPixelSize(R.dimen.kr));
            }
        } else {
            this.vqJ.setVisibility(8);
        }
        if (ad.mR(this.ehM.field_username)) {
            this.niS.setText("");
        }
        if (this.qvb == 76 && this.ehM.field_username != null && this.ehM.field_username.endsWith("@stranger")) {
            this.niS.setText(j.b(this.crP, bo.nullAsNil(this.ehM.field_nickname) + " ", this.niS.getTextSize()));
        }
        if (this.vqJ.getVisibility() == 0 && this.vqG.getVisibility() == 0) {
            LayoutParams layoutParams = (LayoutParams) this.vqG.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.nc);
            this.vqG.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(28099);
    }

    private void dkZ() {
        AppMethodBeat.i(28100);
        if (this.vqP == null) {
            AppMethodBeat.o(28100);
            return;
        }
        View findViewById = this.vqP.findViewById(R.id.b2r);
        if (findViewById == null) {
            AppMethodBeat.o(28100);
            return;
        }
        findViewById.setVisibility(8);
        AppMethodBeat.o(28100);
    }

    private void dla() {
        AppMethodBeat.i(28101);
        this.vqM.setClickable(false);
        if ((t.mM(this.ehM.field_username) || ad.aox(this.ehM.field_username)) && com.tencent.mm.n.a.jh(this.ehM.field_type) && !r.mG(this.ehM.field_username)) {
            this.vqM.setVisibility(0);
            if (this.ehM.Oc()) {
                this.vqM.setChecked(true);
                this.vqY = true;
                AppMethodBeat.o(28101);
                return;
            }
            this.vqM.setChecked(false);
            this.vqM.setVisibility(8);
            this.vqY = false;
            AppMethodBeat.o(28101);
            return;
        }
        this.vqY = false;
        this.vqM.setVisibility(8);
        AppMethodBeat.o(28101);
    }

    public final void qj(String str) {
        AppMethodBeat.i(28102);
        if (!hasInit()) {
            ab.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.lyb + "contact = " + this.ehM);
            AppMethodBeat.o(28102);
        } else if (bo.nullAsNil(str).length() <= 0) {
            ab.e("MicroMsg.ContactInfoHeader", "notifyChanged: user = ".concat(String.valueOf(str)));
            AppMethodBeat.o(28102);
        } else {
            if (str.equals(this.ehM.field_username)) {
                initView();
            }
            AppMethodBeat.o(28102);
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
        AppMethodBeat.i(28103);
        ab.d("MicroMsg.ContactInfoHeader", "onNotifyChange event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
        if (obj == null || !(obj instanceof String)) {
            ab.e("MicroMsg.ContactInfoHeader", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
            AppMethodBeat.o(28103);
            return;
        }
        String str = (String) obj;
        ab.d("MicroMsg.ContactInfoHeader", "onNotifyChange username = " + str + ", contact = " + this.ehM);
        if (!hasInit()) {
            ab.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.lyb + "contact = " + this.ehM);
            AppMethodBeat.o(28103);
        } else if (bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(28103);
        } else {
            if (this.ehM != null && this.ehM.field_username.equals(str)) {
                aw.ZK();
                this.ehM = c.XM().aoO(str);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(28079);
                        NormalUserHeaderPreference.f(NormalUserHeaderPreference.this);
                        NormalUserHeaderPreference.g(NormalUserHeaderPreference.this);
                        NormalUserHeaderPreference.h(NormalUserHeaderPreference.this);
                        if (NormalUserHeaderPreference.this.vqR != null) {
                            NormalUserHeaderPreference.this.vqR.setReplyBtnVisible(!com.tencent.mm.n.a.jh(NormalUserHeaderPreference.this.ehM.field_type));
                        }
                        AppMethodBeat.o(28079);
                    }
                });
            }
            AppMethodBeat.o(28103);
        }
    }

    public final void a(final bv bvVar) {
        AppMethodBeat.i(28104);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(28080);
                if (!(NormalUserHeaderPreference.this.ehM == null || bvVar == null || !NormalUserHeaderPreference.this.ehM.field_username.equals(bvVar.field_encryptUsername))) {
                    NormalUserHeaderPreference.this.ehM.iz(bvVar.field_conRemark);
                    if (NormalUserHeaderPreference.j(NormalUserHeaderPreference.this)) {
                        NormalUserHeaderPreference.f(NormalUserHeaderPreference.this);
                    } else {
                        ab.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + NormalUserHeaderPreference.this.lyb + "contact = " + NormalUserHeaderPreference.this.ehM.field_username);
                        AppMethodBeat.o(28080);
                        return;
                    }
                }
                AppMethodBeat.o(28080);
            }
        });
        AppMethodBeat.o(28104);
    }

    private void dlb() {
        AppMethodBeat.i(28105);
        if (n.isShowStoryCheck()) {
            e eVar = (e) g.M(e.class);
            RelativeLayout.LayoutParams layoutParams;
            if (eVar.isStoryExist(this.ehM.field_username)) {
                this.vqS.setVisibility(0);
                this.vqT.setVisibility(0);
                layoutParams = (RelativeLayout.LayoutParams) this.vqP.getLayoutParams();
                layoutParams.topMargin = com.tencent.mm.bz.a.fromDPToPix(this.crP, 166);
                this.vqP.setLayoutParams(layoutParams);
            } else {
                this.vqS.setVisibility(8);
                this.vqT.setVisibility(8);
                layoutParams = (RelativeLayout.LayoutParams) this.vqP.getLayoutParams();
                layoutParams.topMargin = 0;
                this.vqP.setLayoutParams(layoutParams);
            }
            eVar.loadStory(this.ehM.field_username, this.ejD);
            AppMethodBeat.o(28105);
            return;
        }
        this.vqS.setVisibility(8);
        AppMethodBeat.o(28105);
    }

    private static boolean UV(String str) {
        AppMethodBeat.i(28086);
        if (com.tencent.mm.plugin.sns.b.n.qFA != null) {
            boolean UV = com.tencent.mm.plugin.sns.b.n.qFA.UV(str);
            AppMethodBeat.o(28086);
            return UV;
        }
        AppMethodBeat.o(28086);
        return false;
    }
}
