package com.tencent.mm.plugin.profile.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.bi.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.preference.FMessageListView;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ax;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class NormalProfileHeaderPreference extends Preference implements OnClickListener, OnLongClickListener {
    private int gOW;
    public f iFE;
    private ad ldh;
    private Context mContext;
    private View omq;
    private b pkh;
    private boolean pnP = false;
    private String pnQ;
    private boolean pnR;
    private int pnS;
    private boolean readOnly = false;

    class a {
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

        a(View view) {
            AppMethodBeat.i(23655);
            this.poq = view.findViewById(R.id.b50);
            this.pok = (FMessageListView) view.findViewById(R.id.b54);
            this.pol = view.findViewById(R.id.b53);
            this.pnV = view.findViewById(R.id.b57);
            this.pnW = view.findViewById(R.id.b58);
            this.pnX = view.findViewById(R.id.b55);
            this.pnZ = view.findViewById(R.id.b56);
            this.poa = view.findViewById(R.id.b59);
            this.pnY = view.findViewById(R.id.b5a);
            this.poj = (ImageView) view.findViewById(R.id.b4m);
            this.poe = (TextView) view.findViewById(R.id.b4u);
            this.pod = (MMNeat7extView) view.findViewById(R.id.b4n);
            this.niS = (TextView) view.findViewById(R.id.b4t);
            this.poc = (TextView) view.findViewById(R.id.b4s);
            this.pob = (ImageView) view.findViewById(R.id.b4o);
            this.nrD = (TextView) view.findViewById(R.id.b4v);
            this.pof = (TextView) view.findViewById(R.id.b4w);
            this.pog = (TextView) view.findViewById(R.id.b4y);
            this.poh = (TextView) view.findViewById(R.id.b4x);
            this.poi = (TextView) view.findViewById(R.id.b4z);
            this.pon = (ImageView) view.findViewById(R.id.b4r);
            this.poo = (ImageView) view.findViewById(R.id.b4q);
            this.pop = (ImageView) view.findViewById(R.id.b4p);
            this.por = (ImageView) view.findViewById(R.id.b4j);
            this.pot = view.findViewById(R.id.b4i);
            this.pou = view.findViewById(R.id.b4l);
            this.pom = (LinearLayout) view.findViewById(R.id.b4k);
            this.poq.findViewById(R.id.b51).setOnClickListener(NormalProfileHeaderPreference.this);
            this.poq.findViewById(R.id.b52).setOnClickListener(NormalProfileHeaderPreference.this);
            this.poa.setOnClickListener(NormalProfileHeaderPreference.this);
            this.pnY.setOnClickListener(NormalProfileHeaderPreference.this);
            this.poj.setOnClickListener(NormalProfileHeaderPreference.this);
            this.pnV.setOnClickListener(NormalProfileHeaderPreference.this);
            this.pnW.setOnClickListener(NormalProfileHeaderPreference.this);
            this.pnX.setOnClickListener(NormalProfileHeaderPreference.this);
            this.pnZ.setOnClickListener(NormalProfileHeaderPreference.this);
            this.nrD.setOnLongClickListener(NormalProfileHeaderPreference.this);
            this.por.setOnClickListener(NormalProfileHeaderPreference.this);
            AppMethodBeat.o(23655);
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

    public final void a(ad adVar, int i, boolean z, b bVar) {
        AppMethodBeat.i(23656);
        this.pnQ = ((Activity) this.mContext).getIntent().getStringExtra("Contact_RoomNickname");
        this.ldh = adVar;
        this.gOW = i;
        this.readOnly = z;
        this.pnP = true;
        this.pkh = bVar;
        AppMethodBeat.o(23656);
    }

    public final void onDetach() {
        AppMethodBeat.i(23657);
        if (this.omq != null) {
            a aVar = (a) this.omq.getTag();
            if (aVar.pok != null) {
                aVar.pok.detach();
            }
        }
        AppMethodBeat.o(23657);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(23658);
        if (this.omq == null) {
            this.omq = super.onCreateView(viewGroup);
        }
        View view = this.omq;
        AppMethodBeat.o(23658);
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
        AppMethodBeat.i(23659);
        super.onBindView(view);
        if (this.pnP) {
            int intrinsicWidth;
            boolean Od;
            Object obj;
            TextView textView;
            StringBuilder append;
            String Hq;
            if (view.getTag() == null) {
                view.setTag(new a(view));
            }
            a aVar = (a) view.getTag();
            com.tencent.mm.pluginsdk.ui.a.b.b(aVar.poj, this.ldh.field_username);
            if (!bo.isNullOrNil(N(this.ldh))) {
                int intrinsicWidth2;
                aVar.pod.setVisibility(0);
                float textSize = aVar.pod.getTextSize();
                CharSequence N = N(this.ldh);
                int dimension = (int) this.mContext.getResources().getDimension(R.dimen.ge);
                int dimension2 = ((int) this.mContext.getResources().getDimension(R.dimen.g7)) * 3;
                intrinsicWidth = this.ldh.dtS != 0 ? this.mContext.getResources().getDrawable(R.raw.ic_sex_male).getIntrinsicWidth() : 0;
                Od = this.ldh.Od();
                boolean UV = n.qFA.UV(this.ldh.field_username);
                boolean Oc = this.ldh.Oc();
                int dimension3 = (int) this.mContext.getResources().getDimension(R.dimen.fz);
                if (Od) {
                    intrinsicWidth2 = (this.mContext.getResources().getDrawable(R.raw.circle_notreceive).getIntrinsicWidth() + dimension3) + dimension3;
                } else {
                    intrinsicWidth2 = dimension3;
                }
                if (Oc) {
                    intrinsicWidth2 = (intrinsicWidth2 + this.mContext.getResources().getDrawable(R.raw.profile_star_icon).getIntrinsicWidth()) + dimension3;
                }
                if (UV) {
                    intrinsicWidth2 = (intrinsicWidth2 + this.mContext.getResources().getDrawable(R.raw.circle_notvisible).getIntrinsicWidth()) + dimension3;
                }
                intrinsicWidth = (((this.mContext.getResources().getDisplayMetrics().widthPixels - dimension) - dimension2) - intrinsicWidth) - intrinsicWidth2;
                ab.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] calculateRemarkNameTvSize:%s", Integer.valueOf(intrinsicWidth));
                aVar.pod.setMaxWidth(intrinsicWidth);
                aVar.pod.ah(j.b(this.mContext, N, textSize));
                aVar.pod.setContentDescription(j.b(this.mContext, N, textSize));
                if (aVar.pod.QV(intrinsicWidth).dPe() > 1) {
                    aVar.pod.setTextSize(com.tencent.mm.bz.a.dm(this.mContext) * ((float) com.tencent.mm.bz.a.ao(this.mContext, (int) aVar.pod.getResources().getDimension(R.dimen.nn))));
                    aVar.pod.ah(j.b(this.mContext, N, aVar.pod.getTextSize()));
                }
                if (this.pnR) {
                    aVar.pod.setTextColor(this.mContext.getResources().getColor(R.color.a6a));
                    aVar.pod.setMaxLines(1);
                } else {
                    aVar.pod.setTextColor(this.mContext.getResources().getColor(R.color.h7));
                    aVar.pod.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
                }
                aVar.pod.getPaint().setFakeBoldText(true);
            }
            String stringExtra = ((Activity) this.mContext).getIntent().getStringExtra("Contact_Distance");
            if (!((Activity) this.mContext).getIntent().getBooleanExtra("Contact_IsLBSFriend", false) || bo.isNullOrNil(stringExtra)) {
                aVar.poh.setVisibility(8);
            } else {
                aVar.poh.setText(this.mContext.getString(R.string.avn) + stringExtra);
                aVar.poh.setVisibility(0);
            }
            if (ad.aox(this.ldh.field_username)) {
                aVar.poc.setVisibility(0);
                aVar.poc.setText(com.tencent.mm.openim.room.a.a.A(this.ldh));
            }
            if (bo.isNullOrNil(this.ldh.field_nickname) || bo.isNullOrNil(this.ldh.field_conRemark) || caj()) {
                aVar.niS.setVisibility(8);
            } else {
                aVar.niS.setVisibility(0);
                aVar.niS.setText(j.b(this.mContext, this.mContext.getString(R.string.ay7) + this.ldh.field_nickname, aVar.niS.getTextSize()));
            }
            if (!bo.isNullOrNil(this.pnQ)) {
                if (((Activity) this.mContext).getIntent().getIntExtra("Contact_Scene", -1) == 14) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    aVar.poe.setVisibility(0);
                    aVar.poe.setText(j.b(this.mContext, this.mContext.getString(R.string.av8) + this.pnQ, aVar.niS.getTextSize()));
                    if ((bo.isNullOrNil(this.ldh.Hq()) || !bo.isNullOrNil(this.ldh.field_username)) && com.tencent.mm.n.a.jh(this.ldh.field_type) && !ad.aox(this.ldh.field_username) && !caj()) {
                        aVar.nrD.setVisibility(0);
                        textView = aVar.nrD;
                        append = new StringBuilder().append(this.mContext.getString(R.string.qf));
                        if (bo.isNullOrNil(this.ldh.Hq())) {
                            Hq = this.ldh.Hq();
                        } else {
                            Hq = this.ldh.field_username;
                        }
                        textView.setText(append.append(Hq).toString());
                    } else {
                        aVar.nrD.setVisibility(8);
                    }
                    if (this.ldh.field_deleteFlag != 1) {
                        aVar.poi.setVisibility(0);
                        aVar.poi.setText(this.mContext.getText(R.string.att));
                        aVar.niS.setVisibility(8);
                        aVar.pof.setVisibility(8);
                        obj = 1;
                    } else {
                        aVar.poi.setVisibility(8);
                        aVar.pof.setVisibility(8);
                        obj = null;
                    }
                    if (obj == null) {
                        ab.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] has delete account! username:%s", this.ldh.field_username);
                        AppMethodBeat.o(23659);
                        return;
                    }
                    if (!com.tencent.mm.n.a.jh(this.ldh.field_type) && !caj() && !t.nB(this.ldh.field_username)) {
                        ab.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] accept contact! username:%s", this.ldh.field_username);
                        aVar.poq.setVisibility(8);
                    } else if (aVar.poq != null) {
                        aVar.poq.setVisibility(8);
                    }
                    if (com.tencent.mm.n.a.jh(this.ldh.field_type) || !((Activity) this.mContext).getIntent().getBooleanExtra("User_Verify", false)) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        aVar.poq.setVisibility(0);
                    } else {
                        aVar.poq.setVisibility(8);
                    }
                    a(aVar, this.mContext, this.ldh, this.gOW, p.a(this.mContext, this.ldh, this.gOW));
                    if (bo.isNullOrNil(this.ldh.signature)) {
                        aVar.pof.setVisibility(8);
                    } else {
                        aVar.pof.setText(j.b(this.mContext, this.ldh.signature));
                        aVar.pof.setVisibility(8);
                    }
                    if (bo.isNullOrNil(this.ldh.getProvince())) {
                        aVar.pog.setVisibility(8);
                    } else {
                        aVar.pog.setVisibility(0);
                        StringBuilder append2 = new StringBuilder().append(s.mL(this.ldh.getProvince()));
                        if (bo.isNullOrNil(this.ldh.getCity())) {
                            Hq = "";
                        } else {
                            Hq = "  " + this.ldh.getCity();
                        }
                        aVar.pog.setText(this.mContext.getString(R.string.axm) + append2.append(Hq).toString());
                    }
                    ImageView imageView = aVar.pob;
                    ad adVar = this.ldh;
                    imageView.setVisibility(0);
                    if (adVar.dtS == 1) {
                        imageView.setImageDrawable(com.tencent.mm.bz.a.g(this.mContext, R.raw.ic_sex_male));
                        imageView.setContentDescription(this.mContext.getString(R.string.dex));
                    } else if (adVar.dtS == 2) {
                        imageView.setImageDrawable(com.tencent.mm.bz.a.g(this.mContext, R.raw.ic_sex_female));
                        imageView.setContentDescription(this.mContext.getString(R.string.dew));
                    } else if (adVar.dtS == 0) {
                        imageView.setVisibility(8);
                    }
                    intrinsicWidth = ((Activity) this.mContext).getIntent().getIntExtra("Contact_Scene", 0);
                    if (26 > intrinsicWidth || intrinsicWidth > 29) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        aVar.poh.setVisibility(0);
                        aVar.niS.setVisibility(8);
                        aVar.poh.setText(this.mContext.getString(R.string.avn) + stringExtra);
                    }
                    if (!t.nB(this.ldh.field_username)) {
                        boolean Od2 = this.ldh.Od();
                        Od = n.qFA.UV(this.ldh.field_username);
                        ImageView imageView2 = aVar.poo;
                        if (Od2) {
                            intrinsicWidth = 0;
                        } else {
                            intrinsicWidth = 8;
                        }
                        imageView2.setVisibility(intrinsicWidth);
                        imageView2 = aVar.pop;
                        if (Od && com.tencent.mm.n.a.jh(this.ldh.field_type)) {
                            intrinsicWidth = 0;
                        } else {
                            intrinsicWidth = 8;
                        }
                        imageView2.setVisibility(intrinsicWidth);
                        ImageView imageView3 = aVar.pon;
                        if (this.ldh.Oc() && com.tencent.mm.n.a.jh(this.ldh.field_type)) {
                            intrinsicWidth = 0;
                        } else {
                            intrinsicWidth = 8;
                        }
                        imageView3.setVisibility(intrinsicWidth);
                    }
                    intrinsicWidth = ak.getStatusBarHeight(this.mContext);
                    ab.d("MicroMsg.NormalProfileHeaderPreference", "actionBarHeight=%s statusBarHeight=%s", Integer.valueOf(this.pnS), Integer.valueOf(intrinsicWidth));
                    if (this.pnR) {
                        aVar.pot.setPadding(aVar.pot.getPaddingLeft(), com.tencent.mm.bz.a.am(this.mContext, R.dimen.a7h), aVar.pot.getPaddingRight(), aVar.pot.getPaddingBottom());
                        AppMethodBeat.o(23659);
                        return;
                    } else if (intrinsicWidth <= 0 || this.pnS <= 0) {
                        aVar.pot.setPadding(aVar.pot.getPaddingLeft(), com.tencent.mm.bz.a.am(this.mContext, R.dimen.a7j), aVar.pot.getPaddingRight(), aVar.pot.getPaddingBottom());
                        AppMethodBeat.o(23659);
                        return;
                    } else {
                        aVar.pot.setPadding(aVar.pot.getPaddingLeft(), (intrinsicWidth + this.pnS) + com.tencent.mm.bz.a.am(this.mContext, R.dimen.nc), aVar.pot.getPaddingRight(), aVar.pot.getPaddingBottom());
                        AppMethodBeat.o(23659);
                        return;
                    }
                }
            }
            aVar.poe.setVisibility(8);
            if (bo.isNullOrNil(this.ldh.Hq())) {
            }
            aVar.nrD.setVisibility(0);
            textView = aVar.nrD;
            append = new StringBuilder().append(this.mContext.getString(R.string.qf));
            if (bo.isNullOrNil(this.ldh.Hq())) {
            }
            textView.setText(append.append(Hq).toString());
            if (this.ldh.field_deleteFlag != 1) {
            }
            if (obj == null) {
            }
        } else {
            ab.w("MicroMsg.NormalProfileHeaderPreference", "[onBindView] never attach!");
            AppMethodBeat.o(23659);
        }
    }

    private boolean caj() {
        AppMethodBeat.i(23660);
        boolean mR = ad.mR(this.ldh.field_username);
        AppMethodBeat.o(23660);
        return mR;
    }

    private String N(ad adVar) {
        String trim;
        AppMethodBeat.i(23661);
        if (caj()) {
            Resources resources = this.mContext.getResources();
            Object[] objArr = new Object[1];
            objArr[0] = bo.isNullOrNil(adVar.getCity()) ? s.mL(adVar.getProvince()) : adVar.getCity();
            trim = resources.getString(R.string.aa8, objArr).trim();
        } else {
            trim = adVar.Oj();
        }
        trim = bo.bc(trim, "");
        AppMethodBeat.o(23661);
        return trim;
    }

    private static void a(a aVar, Context context, ad adVar, int i, com.tencent.mm.pluginsdk.ui.preference.b[] bVarArr) {
        int i2 = 0;
        AppMethodBeat.i(23662);
        if (bVarArr == null || com.tencent.mm.n.a.jh(adVar.field_type)) {
            aVar.pok.setVisibility(8);
            AppMethodBeat.o(23662);
            return;
        }
        aVar.pok.setVisibility(0);
        String nullAsNil = bo.nullAsNil(((Activity) context).getIntent().getStringExtra("Verify_ticket"));
        com.tencent.mm.pluginsdk.ui.preference.a.a aVar2 = new com.tencent.mm.pluginsdk.ui.preference.a.a();
        aVar2.talker = adVar.field_username;
        aVar2.scene = i;
        aVar2.mGZ = nullAsNil;
        aVar2.vqs = adVar.dus;
        aVar2.type = 0;
        if (i == 18) {
            aVar2.type = 1;
        } else if (bf.kE(i)) {
            aVar2.type = 2;
        }
        aVar.pok.setFMessageArgs(aVar2);
        int length = bVarArr.length;
        while (i2 < length) {
            aVar.pok.a(bVarArr[i2]);
            i2++;
        }
        AppMethodBeat.o(23662);
    }

    public final void A(boolean z, int i) {
        AppMethodBeat.i(23663);
        ab.d("MicroMsg.NormalProfileHeaderPreference", "setHasStory action=%s", Integer.valueOf(i));
        this.pnR = z;
        this.pnS = i;
        if (this.iFE != null) {
            this.iFE.notifyDataSetChanged();
        }
        AppMethodBeat.o(23663);
    }

    public static CharSequence a(Context context, ad adVar, int i, String str, boolean z) {
        AppMethodBeat.i(23664);
        if (i == 9) {
            i = adVar.getSource();
        }
        CharSequence string;
        String str2;
        switch (i) {
            case 1:
                if (z || adVar.Ol() > 1000000) {
                    string = context.getResources().getString(R.string.b1d);
                    AppMethodBeat.o(23664);
                    return string;
                } else if (com.tencent.mm.n.a.jh(adVar.field_type)) {
                    string = context.getResources().getString(R.string.b1c);
                    AppMethodBeat.o(23664);
                    return string;
                } else {
                    string = context.getResources().getString(R.string.b1e);
                    AppMethodBeat.o(23664);
                    return string;
                }
            case 3:
                if (z || adVar.Ol() > 1000000) {
                    string = context.getResources().getString(R.string.b1g);
                    AppMethodBeat.o(23664);
                    return string;
                } else if (com.tencent.mm.n.a.jh(adVar.field_type)) {
                    string = context.getResources().getString(R.string.b1f);
                    AppMethodBeat.o(23664);
                    return string;
                } else {
                    string = context.getResources().getString(R.string.b1h);
                    AppMethodBeat.o(23664);
                    return string;
                }
            case 4:
            case 12:
                string = context.getResources().getString(R.string.bw3);
                AppMethodBeat.o(23664);
                return string;
            case 6:
                string = context.getResources().getString(R.string.bw4);
                AppMethodBeat.o(23664);
                return string;
            case 8:
            case 14:
            case 96:
                ax apw = d.akO().apw(str);
                ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(apw == null ? "" : apw.field_chatroomName);
                if (aoO != null) {
                    str2 = aoO.field_nickname;
                } else {
                    str2 = "";
                }
                if (z || adVar.Ol() > 1000000) {
                    if (bo.isNullOrNil(str2)) {
                        string = context.getString(R.string.b0y);
                    } else {
                        string = context.getString(R.string.b10, new Object[]{str2});
                    }
                    AppMethodBeat.o(23664);
                    return string;
                } else if (com.tencent.mm.n.a.jh(adVar.field_type)) {
                    string = context.getResources().getString(R.string.b0z, new Object[]{str2});
                    AppMethodBeat.o(23664);
                    return string;
                } else {
                    string = context.getResources().getString(R.string.b0x);
                    AppMethodBeat.o(23664);
                    return string;
                }
            case 10:
            case 13:
                if (z || adVar.Ol() > 1000000) {
                    string = context.getResources().getString(R.string.b1m);
                    AppMethodBeat.o(23664);
                    return string;
                } else if (com.tencent.mm.n.a.jh(adVar.field_type)) {
                    string = context.getResources().getString(R.string.b1l);
                    AppMethodBeat.o(23664);
                    return string;
                } else {
                    string = context.getResources().getString(R.string.b1n);
                    AppMethodBeat.o(23664);
                    return string;
                }
            case 15:
                if (z || adVar.Ol() > 1000000) {
                    string = context.getResources().getString(R.string.b1a);
                    AppMethodBeat.o(23664);
                    return string;
                } else if (com.tencent.mm.n.a.jh(adVar.field_type)) {
                    string = context.getResources().getString(R.string.b1_);
                    AppMethodBeat.o(23664);
                    return string;
                } else {
                    string = context.getResources().getString(R.string.b1b);
                    AppMethodBeat.o(23664);
                    return string;
                }
            case 17:
                str2 = s.mJ(((Activity) context).getIntent().getStringExtra("source_from_user_name"));
                if (bo.isNullOrNil(str2)) {
                    str2 = ((Activity) context).getIntent().getStringExtra("source_from_nick_name");
                }
                if (z || adVar.Ol() > 1000000) {
                    if (bo.isNullOrNil(str2)) {
                        string = context.getString(R.string.b0u);
                    } else {
                        string = j.b(context, context.getString(R.string.b0t, new Object[]{str2}));
                    }
                    AppMethodBeat.o(23664);
                    return string;
                } else if (com.tencent.mm.n.a.jh(adVar.field_type)) {
                    if (bo.isNullOrNil(str2)) {
                        string = context.getString(R.string.b0r);
                    } else {
                        string = j.b(context, context.getString(R.string.b0s, new Object[]{str2}));
                    }
                    AppMethodBeat.o(23664);
                    return string;
                } else if (bo.isNullOrNil(str2)) {
                    string = j.b(context, context.getString(R.string.b0w));
                    AppMethodBeat.o(23664);
                    return string;
                } else {
                    string = context.getString(R.string.b0v, new Object[]{str2});
                    AppMethodBeat.o(23664);
                    return string;
                }
            case 18:
                if (z || adVar.Ol() > 1000000) {
                    string = context.getResources().getString(R.string.b12);
                    AppMethodBeat.o(23664);
                    return string;
                } else if (com.tencent.mm.n.a.jh(adVar.field_type)) {
                    string = context.getResources().getString(R.string.b11);
                    AppMethodBeat.o(23664);
                    return string;
                } else {
                    string = context.getResources().getString(R.string.b13);
                    AppMethodBeat.o(23664);
                    return string;
                }
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
            case 29:
                if (z || adVar.Ol() > 1000000) {
                    string = context.getResources().getString(R.string.b1j);
                    AppMethodBeat.o(23664);
                    return string;
                } else if (com.tencent.mm.n.a.jh(adVar.field_type)) {
                    string = context.getResources().getString(R.string.b1i);
                    AppMethodBeat.o(23664);
                    return string;
                } else {
                    string = context.getResources().getString(R.string.b1k);
                    AppMethodBeat.o(23664);
                    return string;
                }
            case 25:
                if (z || adVar.Ol() > 1000000) {
                    string = context.getResources().getString(R.string.b0p);
                    AppMethodBeat.o(23664);
                    return string;
                } else if (com.tencent.mm.n.a.jh(adVar.field_type)) {
                    string = context.getResources().getString(R.string.b0o);
                    AppMethodBeat.o(23664);
                    return string;
                } else {
                    string = context.getResources().getString(R.string.b0q);
                    AppMethodBeat.o(23664);
                    return string;
                }
            case 30:
                if (z || adVar.Ol() > 1000000) {
                    string = context.getResources().getString(R.string.b17);
                    AppMethodBeat.o(23664);
                    return string;
                } else if (com.tencent.mm.n.a.jh(adVar.field_type)) {
                    string = context.getResources().getString(R.string.b16);
                    AppMethodBeat.o(23664);
                    return string;
                } else {
                    string = context.getResources().getString(R.string.b18);
                    AppMethodBeat.o(23664);
                    return string;
                }
            case 34:
                string = context.getResources().getString(R.string.b0m);
                AppMethodBeat.o(23664);
                return string;
            case 48:
                string = context.getResources().getString(R.string.b19);
                AppMethodBeat.o(23664);
                return string;
            case aa.CTRL_INDEX /*58*/:
            case au.CTRL_INDEX /*59*/:
            case 60:
                string = context.getResources().getString(R.string.c8k);
                AppMethodBeat.o(23664);
                return string;
            case 76:
                string = context.getResources().getString(R.string.b14);
                AppMethodBeat.o(23664);
                return string;
            default:
                AppMethodBeat.o(23664);
                return null;
        }
    }

    public void onClick(View view) {
        AppMethodBeat.i(23665);
        int id = view.getId();
        if (id == R.id.b51) {
            ad adVar = this.ldh;
            if (adVar == null) {
                ab.e("MicroMsg.NormalProfileHeaderPreference", "contact is null");
                AppMethodBeat.o(23665);
                return;
            } else if (com.tencent.mm.n.a.jh(adVar.field_type)) {
                PhoneNumPreference phoneNumPreference = (PhoneNumPreference) this.iFE.aqO("contact_profile_phone");
                Intent intent = new Intent();
                intent.putExtra("Contact_Scene", this.gOW);
                intent.putExtra("Contact_User", adVar.field_username);
                intent.putExtra("view_mode", true);
                intent.putExtra("contact_phone_number_by_md5", phoneNumPreference.vim);
                intent.putExtra("contact_phone_number_list", adVar.dur);
                com.tencent.mm.plugin.profile.b.gkE.m(intent, this.mContext);
                AppMethodBeat.o(23665);
                return;
            } else if (bo.isNullOrNil(adVar.field_encryptUsername)) {
                a(adVar.field_username, adVar);
                AppMethodBeat.o(23665);
                return;
            } else {
                a(adVar.field_encryptUsername, adVar);
                AppMethodBeat.o(23665);
                return;
            }
        }
        if (id == R.id.b52) {
            if (this.pkh != null) {
                this.pkh.cas();
                AppMethodBeat.o(23665);
                return;
            }
        } else if (id == R.id.b4m) {
            String str = this.ldh.field_username;
            Intent intent2 = new Intent(this.mContext, ProfileHdHeadImg.class);
            intent2.putExtra("username", str);
            this.mContext.startActivity(intent2);
        }
        AppMethodBeat.o(23665);
    }

    public boolean onLongClick(View view) {
        AppMethodBeat.i(23666);
        if (view.getId() == R.id.b4v) {
            final TextView textView = (TextView) view;
            final ad adVar = this.ldh;
            final ClipboardManager clipboardManager = (ClipboardManager) ah.getContext().getSystemService("clipboard");
            if (!(textView.getText() == null || clipboardManager == null)) {
                String charSequence = textView.getText().toString();
                int indexOf = charSequence.indexOf(58);
                if (indexOf >= 0 && indexOf < charSequence.length()) {
                    charSequence = charSequence.substring(indexOf + 1).trim();
                }
                SpannableString spannableString = new SpannableString(textView.getText());
                spannableString.setSpan(new BackgroundColorSpan(this.mContext.getResources().getColor(R.color.sz)), indexOf + 1, textView.getText().length(), 33);
                textView.setText(spannableString);
                com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(this.mContext, textView);
                aVar.zRZ = new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(23652);
                        contextMenu.add(NormalProfileHeaderPreference.this.mContext.getString(R.string.oy));
                        AppMethodBeat.o(23652);
                    }
                };
                aVar.rBm = new com.tencent.mm.ui.base.n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(23653);
                        if (i == 0) {
                            clipboardManager.setText(charSequence);
                            h.bP(NormalProfileHeaderPreference.this.mContext, NormalProfileHeaderPreference.this.mContext.getString(R.string.oz));
                        }
                        AppMethodBeat.o(23653);
                    }
                };
                aVar.zHM = new OnDismissListener() {
                    public final void onDismiss() {
                        AppMethodBeat.i(23654);
                        NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this, textView, adVar);
                        AppMethodBeat.o(23654);
                    }
                };
                aVar.dn(0, 0);
            }
            AppMethodBeat.o(23666);
            return true;
        }
        AppMethodBeat.o(23666);
        return false;
    }

    private void a(String str, ad adVar) {
        AppMethodBeat.i(23667);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.NormalProfileHeaderPreference", "view stranger remark, username is null");
            AppMethodBeat.o(23667);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Scene", this.gOW);
        intent.putExtra("Contact_mode_name_type", 0);
        intent.putExtra("Contact_ModStrangerRemark", true);
        intent.putExtra("Contact_User", adVar.field_username);
        intent.putExtra("Contact_Nick", adVar.field_nickname);
        intent.putExtra("Contact_RemarkName", adVar.field_conRemark);
        com.tencent.mm.plugin.profile.b.gkE.n(intent, this.mContext);
        AppMethodBeat.o(23667);
    }

    static /* synthetic */ void a(NormalProfileHeaderPreference normalProfileHeaderPreference, TextView textView, ad adVar) {
        AppMethodBeat.i(23668);
        textView.setVisibility(0);
        if (!bo.isNullOrNil(adVar.Hq())) {
            textView.setText(normalProfileHeaderPreference.mContext.getString(R.string.qf) + adVar.Hq());
            AppMethodBeat.o(23668);
        } else if (ad.aoA(adVar.field_username) || t.mX(adVar.field_username)) {
            textView.setVisibility(8);
            AppMethodBeat.o(23668);
        } else {
            textView.setText(normalProfileHeaderPreference.mContext.getString(R.string.qf) + bo.nullAsNil(adVar.Ok()));
            AppMethodBeat.o(23668);
        }
    }
}
