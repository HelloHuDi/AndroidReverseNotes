package com.tencent.p177mm.chatroom.p216ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.chatroom.p710c.C32436c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.openim.PluginOpenIM;
import com.tencent.p177mm.openim.p1211c.p1212a.C42241a;
import com.tencent.p177mm.openim.p716b.C32878i;
import com.tencent.p177mm.openim.p877e.C42248e;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C42041qh;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C38317l;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.C15340fn;
import com.tencent.p177mm.protocal.protobuf.C15341fp;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI */
public class SeeAccessVerifyInfoUI extends MMActivity implements C1202f {
    private C7577u eih;
    private boolean elA = false;
    private boolean elB = false;
    private C26023b eld;
    private String ele;
    private String elf;
    private String elg;
    private String elh;
    private String eli;
    private String elj;
    private String elk;
    private String ell;
    private String elm;
    private long eln;
    private long elo;
    private String elp;
    private String elq;
    private String elr;
    private TextView els;
    private TextView elt;
    private ImageView elu;
    private TextView elv;
    private TextView elw;
    private TextView elx;
    private GridView ely;
    private boolean elz = false;
    private C44275p tipDialog;

    /* renamed from: com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI$5 */
    class C13815 implements OnClickListener {

        /* renamed from: com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI$5$1 */
        class C13821 implements C5681a<Void, C37441a<C15341fp>> {
            C13821() {
            }

            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(104264);
                C37441a c37441a = (C37441a) obj;
                if (SeeAccessVerifyInfoUI.this.tipDialog != null && SeeAccessVerifyInfoUI.this.tipDialog.isShowing()) {
                    SeeAccessVerifyInfoUI.this.tipDialog.dismiss();
                }
                C42124a jY = C42124a.m74268jY(c37441a.aIm);
                if (jY != null) {
                    jY.mo67668a(SeeAccessVerifyInfoUI.this, null, null);
                } else if (c37441a.errType == 0 && c37441a.errCode == 0) {
                    if (c37441a.cwn.getType() == 941) {
                        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(SeeAccessVerifyInfoUI.this.eln);
                        jf.dtQ();
                        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15302b(jf.field_msgSvrId, jf);
                        SeeAccessVerifyInfoUI.this.elx.setBackgroundResource(C25738R.drawable.f6486fr);
                        SeeAccessVerifyInfoUI.this.elx.setTextColor(SeeAccessVerifyInfoUI.this.getResources().getColor(C25738R.color.f12079rl));
                        SeeAccessVerifyInfoUI.this.elx.setText(SeeAccessVerifyInfoUI.this.getString(C25738R.string.cbk));
                        SeeAccessVerifyInfoUI.this.elx.setEnabled(false);
                        C7060h.pYm.mo8378a(219, 23, 1, true);
                    }
                } else if (c37441a.cwn.getType() == 941) {
                    C4990ab.m7417i("MicroMsg.SeeAccessVerifyInfoUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", Integer.valueOf(941), Integer.valueOf(c37441a.errCode), Integer.valueOf(c37441a.errType), C5046bo.nullAsNil(c37441a.aIm));
                    C30379h.m48461b(SeeAccessVerifyInfoUI.this.mController.ylL, SeeAccessVerifyInfoUI.this.getString(C25738R.string.f8689c4), SeeAccessVerifyInfoUI.this.getString(C25738R.string.f9238tz), true);
                }
                Void voidR = zXH;
                AppMethodBeat.m2505o(104264);
                return voidR;
            }
        }

        /* renamed from: com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI$5$2 */
        class C13832 implements C5681a<Void, C37441a<C15340fn>> {
            C13832() {
            }

            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(104265);
                C37441a c37441a = (C37441a) obj;
                if (SeeAccessVerifyInfoUI.this.tipDialog != null && SeeAccessVerifyInfoUI.this.tipDialog.isShowing()) {
                    SeeAccessVerifyInfoUI.this.tipDialog.dismiss();
                }
                C42124a jY = C42124a.m74268jY(c37441a.aIm);
                if (jY != null) {
                    jY.mo67668a(SeeAccessVerifyInfoUI.this, null, null);
                } else if (c37441a.errType == 0 && c37441a.errCode == 0) {
                    if (c37441a.cwn.getType() == 774) {
                        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(SeeAccessVerifyInfoUI.this.eln);
                        jf.dtQ();
                        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15302b(jf.field_msgSvrId, jf);
                        SeeAccessVerifyInfoUI.this.elx.setBackgroundResource(C25738R.drawable.f6486fr);
                        SeeAccessVerifyInfoUI.this.elx.setTextColor(SeeAccessVerifyInfoUI.this.getResources().getColor(C25738R.color.f12079rl));
                        SeeAccessVerifyInfoUI.this.elx.setText(SeeAccessVerifyInfoUI.this.getString(C25738R.string.cbk));
                        SeeAccessVerifyInfoUI.this.elx.setEnabled(false);
                        C7060h.pYm.mo8378a(219, 23, 1, true);
                    }
                } else if (c37441a.cwn.getType() == 774) {
                    C4990ab.m7417i("MicroMsg.SeeAccessVerifyInfoUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", Integer.valueOf(774), Integer.valueOf(c37441a.errCode), Integer.valueOf(c37441a.errType), C5046bo.nullAsNil(c37441a.aIm));
                    C30379h.m48461b(SeeAccessVerifyInfoUI.this.mController.ylL, SeeAccessVerifyInfoUI.this.getString(C25738R.string.f8689c4), SeeAccessVerifyInfoUI.this.getString(C25738R.string.f9238tz), true);
                }
                Void voidR = zXH;
                AppMethodBeat.m2505o(104265);
                return voidR;
            }
        }

        C13815() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(104266);
            SeeAccessVerifyInfoUI seeAccessVerifyInfoUI = SeeAccessVerifyInfoUI.this;
            Context context = SeeAccessVerifyInfoUI.this.mController.ylL;
            SeeAccessVerifyInfoUI.this.getString(C25738R.string.f9238tz);
            seeAccessVerifyInfoUI.tipDialog = C30379h.m48458b(context, SeeAccessVerifyInfoUI.this.getString(C25738R.string.f8691c6), false, null);
            if (C1855t.m3903mP(SeeAccessVerifyInfoUI.this.elp)) {
                new C42241a(SeeAccessVerifyInfoUI.this.elk, SeeAccessVerifyInfoUI.this.elp, SeeAccessVerifyInfoUI.this.elr, new LinkedList(C5046bo.m7569hT(SeeAccessVerifyInfoUI.this.elf, ","))).acy().mo60488b(SeeAccessVerifyInfoUI.this).mo60487b(new C13821());
                AppMethodBeat.m2505o(104266);
                return;
            }
            new C32436c(SeeAccessVerifyInfoUI.this.elo, SeeAccessVerifyInfoUI.this.elk, SeeAccessVerifyInfoUI.this.elp, SeeAccessVerifyInfoUI.this.elr, new LinkedList(C5046bo.m7508P(SeeAccessVerifyInfoUI.this.elf.split(",")))).acy().mo60488b(SeeAccessVerifyInfoUI.this).mo60487b(new C13832());
            AppMethodBeat.m2505o(104266);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI$a */
    public class C9226a {
        String csB;
        String elE;
        String elF;
        String nickname;
        String username;

        C9226a(String str, String str2, String str3, String str4, String str5) {
            this.username = str;
            this.nickname = str2;
            this.csB = str3;
            this.elE = str4;
            this.elF = str5;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI$c */
    class C18153c {
        public ImageView ejo;
        public TextView elJ;
        public TextView elK;

        C18153c() {
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI$b */
    public class C26023b extends BaseAdapter {
        List<C9226a> elG = new ArrayList();
        private C25814c elH = null;
        Context mContext;

        public C26023b(Context context) {
            AppMethodBeat.m2504i(104268);
            this.mContext = context;
            m41542Kk();
            C17927a c17927a = new C17927a();
            c17927a.ePH = true;
            c17927a.ePZ = true;
            c17927a.ePT = C1318a.default_avatar;
            this.elH = c17927a.ahG();
            AppMethodBeat.m2505o(104268);
        }

        /* renamed from: Kk */
        private void m41542Kk() {
            AppMethodBeat.m2504i(104269);
            if (C5046bo.isNullOrNil(SeeAccessVerifyInfoUI.this.elf)) {
                C4990ab.m7420w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesUsernames null");
                AppMethodBeat.m2505o(104269);
                return;
            }
            String[] split = SeeAccessVerifyInfoUI.this.elf.split(",");
            if (C5046bo.isNullOrNil(SeeAccessVerifyInfoUI.this.ele)) {
                C4990ab.m7420w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesNicknames null");
                AppMethodBeat.m2505o(104269);
                return;
            }
            String[] strArr;
            String[] strArr2;
            String[] strArr3;
            String[] split2 = SeeAccessVerifyInfoUI.this.ele.split(",");
            if (C5046bo.isNullOrNil(SeeAccessVerifyInfoUI.this.elh)) {
                C4990ab.m7420w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesAppids null");
                strArr = null;
            } else {
                strArr = SeeAccessVerifyInfoUI.this.elh.split(",");
            }
            if (C5046bo.isNullOrNil(SeeAccessVerifyInfoUI.this.elg)) {
                C4990ab.m7420w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesDescids null");
                strArr2 = null;
            } else {
                strArr2 = SeeAccessVerifyInfoUI.this.elg.split(",");
            }
            if (C5046bo.isNullOrNil(SeeAccessVerifyInfoUI.this.eli)) {
                C4990ab.m7420w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesHeadimgurls null");
                strArr3 = null;
            } else {
                strArr3 = SeeAccessVerifyInfoUI.this.eli.split(",");
            }
            this.elG.clear();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < split.length) {
                    List list = this.elG;
                    SeeAccessVerifyInfoUI seeAccessVerifyInfoUI = SeeAccessVerifyInfoUI.this;
                    String str = split[i2];
                    String str2 = (split2.length <= i2 || C5046bo.isNullOrNil(split2[i2])) ? split[i2] : split2[i2];
                    String str3 = (strArr == null || strArr.length <= i2 || C5046bo.isNullOrNil(strArr[i2])) ? "" : strArr[i2];
                    String str4 = (strArr2 == null || strArr2.length <= i2 || C5046bo.isNullOrNil(strArr2[i2])) ? "" : strArr2[i2];
                    String str5 = (strArr3 == null || strArr3.length <= i2 || C5046bo.isNullOrNil(strArr3[i2])) ? "" : strArr3[i2];
                    list.add(new C9226a(str, str2, str3, str4, str5));
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(104269);
                    return;
                }
            }
        }

        public final int getCount() {
            AppMethodBeat.m2504i(104270);
            int size = this.elG.size();
            AppMethodBeat.m2505o(104270);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(104271);
            Object obj = this.elG.get(i);
            AppMethodBeat.m2505o(104271);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            C18153c cd;
            AppMethodBeat.m2504i(104272);
            if (view == null) {
                view = View.inflate(this.mContext, 2130970531, null);
                cd = SeeAccessVerifyInfoUI.this.mo60478cd(view);
            } else {
                C18153c c18153c = (C18153c) view.getTag();
                if (c18153c == null) {
                    cd = SeeAccessVerifyInfoUI.this.mo60478cd(view);
                } else {
                    cd = c18153c;
                }
            }
            cd.ejo.setVisibility(0);
            cd.elJ.setVisibility(0);
            C32291o.ahp().mo43766a(((C9226a) this.elG.get(i)).elF, cd.ejo, this.elH);
            cd.elJ.setText(C44089j.m79293b(this.mContext, C5046bo.nullAsNil(((C9226a) this.elG.get(i)).nickname), cd.elJ.getTextSize()));
            if (C7616ad.aox(((C9226a) this.elG.get(i)).username)) {
                SeeAccessVerifyInfoUI.this.elz = true;
                C42248e c42248e = new C42248e();
                c42248e.field_appid = C5046bo.nullAsNil(((C9226a) this.elG.get(i)).csB);
                c42248e.field_wordingId = C5046bo.nullAsNil(((C9226a) this.elG.get(i)).elE);
                c42248e.field_language = C4988aa.m7403gw(C4996ah.getContext());
                C1720g.m3537RQ();
                ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getWordingInfoStg().mo10102b((C4925c) c42248e, "appid", "wordingId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
                if (TextUtils.isEmpty(c42248e.field_wording)) {
                    if (!(C5046bo.isNullOrNil(c42248e.field_appid) || C5046bo.isNullOrNil(c42248e.field_wordingId))) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(c42248e.field_wordingId);
                        if (!C5046bo.m7500C(cd.elK.getTag(), "first")) {
                            SeeAccessVerifyInfoUI.this.elA = true;
                            C1720g.m3535RO().eJo.mo14541a(new C32878i(c42248e.field_appid, c42248e.field_language, linkedList), 0);
                        }
                    }
                    cd.elK.setVisibility(4);
                    cd.elK.setTag("first");
                } else {
                    cd.elK.setVisibility(0);
                    cd.elK.setText("＠" + c42248e.field_wording);
                }
            } else {
                cd.elK.setVisibility(8);
            }
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    String Oj;
                    AppMethodBeat.m2504i(104267);
                    String str = ((C9226a) C26023b.this.elG.get(i)).nickname;
                    String str2 = null;
                    if (SeeAccessVerifyInfoUI.this.eih != null) {
                        str2 = SeeAccessVerifyInfoUI.this.eih.mo16807mJ(((C9226a) C26023b.this.elG.get(i)).username);
                    }
                    if (C5046bo.isNullOrNil(str2)) {
                        Oj = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(C5046bo.nullAsNil(((C9226a) C26023b.this.elG.get(i)).username)).mo16707Oj();
                    } else {
                        Oj = str2;
                    }
                    SeeAccessVerifyInfoUI.m63620a(SeeAccessVerifyInfoUI.this, ((C9226a) C26023b.this.elG.get(i)).username, Oj, str, true);
                    AppMethodBeat.m2505o(104267);
                }
            });
            AppMethodBeat.m2505o(104272);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI$1 */
    class C324571 implements OnMenuItemClickListener {
        C324571() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104261);
            SeeAccessVerifyInfoUI.this.finish();
            AppMethodBeat.m2505o(104261);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI$2 */
    class C324582 implements OnClickListener {
        C324582() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(104262);
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(C5046bo.nullAsNil(SeeAccessVerifyInfoUI.this.elk));
            String str = aoO.field_nickname;
            String str2 = null;
            if (SeeAccessVerifyInfoUI.this.eih != null) {
                str2 = SeeAccessVerifyInfoUI.this.eih.mo16807mJ(SeeAccessVerifyInfoUI.this.elk);
            }
            if (C5046bo.isNullOrNil(str2)) {
                str2 = aoO.mo16707Oj();
            }
            SeeAccessVerifyInfoUI.m63620a(SeeAccessVerifyInfoUI.this, SeeAccessVerifyInfoUI.this.elk, str2, str, false);
            AppMethodBeat.m2505o(104262);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI$4 */
    class C324594 implements Runnable {
        C324594() {
        }

        public final void run() {
            AppMethodBeat.m2504i(104263);
            int i = 0;
            if (SeeAccessVerifyInfoUI.this.elv != null) {
                if (SeeAccessVerifyInfoUI.this.elz) {
                    i = (int) ((((float) (SeeAccessVerifyInfoUI.this.elv.getHeight() * 2)) + SeeAccessVerifyInfoUI.this.getResources().getDimension(C25738R.dimen.f9727ds)) + SeeAccessVerifyInfoUI.this.getResources().getDimension(C25738R.dimen.f9972lw));
                } else {
                    i = (int) ((((float) SeeAccessVerifyInfoUI.this.elv.getHeight()) + SeeAccessVerifyInfoUI.this.getResources().getDimension(C25738R.dimen.f9727ds)) + SeeAccessVerifyInfoUI.this.getResources().getDimension(C25738R.dimen.f9972lw));
                }
            }
            if (SeeAccessVerifyInfoUI.this.eld.getCount() / 4 > 0) {
                i *= (SeeAccessVerifyInfoUI.this.eld.getCount() / 4) + 1;
            }
            SeeAccessVerifyInfoUI.this.ely.setLayoutParams(new LayoutParams(SeeAccessVerifyInfoUI.this.ely.getWidth(), i));
            AppMethodBeat.m2505o(104263);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI$3 */
    class C376483 implements OnTouchListener {
        C376483() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(104273);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.SeeAccessVerifyInfoUI", "[onCreate]");
        setMMTitle(getString(C25738R.string.f8690c5));
        this.eln = getIntent().getLongExtra("msgLocalId", 0);
        this.elo = getIntent().getLongExtra("msgSvrId", 0);
        this.elj = getIntent().getStringExtra("invitertitle");
        this.elk = getIntent().getStringExtra("inviterusername");
        this.ell = getIntent().getStringExtra("inviterappid");
        this.elm = getIntent().getStringExtra("inviterdescid");
        this.elp = getIntent().getStringExtra("chatroom");
        this.elq = getIntent().getStringExtra("invitationreason");
        this.elr = getIntent().getStringExtra("ticket");
        this.elf = getIntent().getStringExtra("username");
        this.ele = getIntent().getStringExtra("nickname");
        this.elg = getIntent().getStringExtra("descid");
        this.elh = getIntent().getStringExtra("appid");
        this.eli = getIntent().getStringExtra("headimgurl");
        this.eih = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14886ob(C5046bo.nullAsNil(this.elp));
        this.eld = new C26023b(this);
        String[] split = this.elf.split(",");
        if (split != null && split.length > 0) {
            C4990ab.m7417i("MicroMsg.SeeAccessVerifyInfoUI", "[%s] has been in chatroom![%s]", split[0], this.elp);
            if (this.eih.afg() != null && this.eih.afg().contains(r0)) {
                C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(this.eln);
                if (!jf.dtS()) {
                    jf.dtQ();
                    ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(this.eln, jf);
                }
            }
        }
        initView();
        setBackBtn(new C324571());
        AppMethodBeat.m2505o(104273);
    }

    public void onResume() {
        AppMethodBeat.m2504i(104274);
        C4990ab.m7416i("MicroMsg.SeeAccessVerifyInfoUI", "[onResume]");
        C1720g.m3535RO().eJo.mo14539a((int) C38317l.CTRL_INDEX, (C1202f) this);
        super.onResume();
        AppMethodBeat.m2505o(104274);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(104275);
        super.onDestroy();
        C1720g.m3535RO().eJo.mo14546b((int) C38317l.CTRL_INDEX, (C1202f) this);
        AppMethodBeat.m2505o(104275);
    }

    public final int getLayoutId() {
        return 2130970580;
    }

    public final void initView() {
        AppMethodBeat.m2504i(104276);
        this.els = (TextView) findViewById(2131827300);
        this.elt = (TextView) findViewById(2131827301);
        this.elv = (TextView) findViewById(2131827168);
        this.elw = (TextView) findViewById(2131827169);
        this.elu = (ImageView) findViewById(2131827163);
        this.elx = (TextView) findViewById(2131827303);
        this.ely = (GridView) findViewById(2131827302);
        this.ely.setAdapter(this.eld);
        if (this.elu != null) {
            this.elu.setOnClickListener(new C324582());
        }
        this.ely.setOnTouchListener(new C376483());
        this.ely.postDelayed(new C324594(), 100);
        if (this.elu != null) {
            C40460b.m69434b(this.elu, C5046bo.nullAsNil(this.elk));
        }
        if (this.elv != null) {
            this.elv.setText(m63617a(C5046bo.nullAsNil(this.elk), this.elv));
        }
        if (this.elw != null) {
            if (C1855t.m3903mP(this.elp) && C7616ad.aox(this.elk)) {
                C42248e c42248e = new C42248e();
                c42248e.field_appid = this.ell;
                c42248e.field_wordingId = this.elm;
                c42248e.field_language = C4988aa.m7403gw(C4996ah.getContext());
                C1720g.m3537RQ();
                ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getWordingInfoStg().mo10102b((C4925c) c42248e, "appid", "wordingId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
                if (TextUtils.isEmpty(c42248e.field_wording)) {
                    if (!(C5046bo.isNullOrNil(this.elm) || C5046bo.isNullOrNil(this.ell))) {
                        this.elB = true;
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(this.elm);
                        C1720g.m3535RO().eJo.mo14541a(new C32878i(this.ell, c42248e.field_language, linkedList), 0);
                    }
                    this.elw.setVisibility(4);
                } else {
                    this.elw.setVisibility(0);
                    this.elw.setText("＠" + c42248e.field_wording);
                }
            } else {
                this.elw.setVisibility(8);
            }
        }
        if (this.els != null) {
            this.els.setText(C44089j.m79292b((Context) this, C5046bo.nullAsNil(this.elj)));
        }
        if (!(this.elt == null || C5046bo.isNullOrNil(this.elq))) {
            this.elt.setText(C44089j.m79292b((Context) this, "\"" + C5046bo.nullAsNil(this.elq) + "\""));
        }
        if (this.elx != null) {
            this.elx.setOnClickListener(new C13815());
        }
        if (this.elx != null && ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(this.eln).dtS()) {
            this.elx.setBackgroundResource(C25738R.drawable.f6486fr);
            this.elx.setTextColor(getResources().getColor(C25738R.color.f12079rl));
            this.elx.setText(getString(C25738R.string.cbk));
            this.elx.setEnabled(false);
        }
        AppMethodBeat.m2505o(104276);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(104277);
        if ((c1207m instanceof C32878i) && i == 0 && i2 == 0) {
            if (this.elB && C5046bo.m7519ac(this.elw.getText())) {
                this.elB = false;
                C42248e c42248e = new C42248e();
                c42248e.field_appid = this.ell;
                c42248e.field_wordingId = this.elm;
                c42248e.field_language = C4988aa.m7403gw(C4996ah.getContext());
                C1720g.m3537RQ();
                ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getWordingInfoStg().mo10102b((C4925c) c42248e, "appid", "wordingId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
                if (TextUtils.isEmpty(c42248e.field_wording)) {
                    if (!(C5046bo.isNullOrNil(this.elm) || C5046bo.isNullOrNil(this.ell))) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(this.elm);
                        C1720g.m3535RO().eJo.mo14541a(new C32878i(this.ell, c42248e.field_language, linkedList), 0);
                    }
                    this.elw.setVisibility(4);
                } else {
                    this.elw.setVisibility(0);
                    this.elw.setText("＠" + c42248e.field_wording);
                }
            }
            if (this.elA) {
                this.eld.notifyDataSetChanged();
            }
        }
        AppMethodBeat.m2505o(104277);
    }

    /* renamed from: a */
    private SpannableString m63617a(String str, TextView textView) {
        AppMethodBeat.m2504i(104278);
        if (textView == null) {
            AppMethodBeat.m2505o(104278);
            return null;
        }
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(C5046bo.nullAsNil(str));
        if (aoO == null) {
            C4990ab.m7420w("MicroMsg.SeeAccessVerifyInfoUI", "ct == null");
            AppMethodBeat.m2505o(104278);
            return null;
        }
        String mJ = !C5046bo.isNullOrNil(aoO.field_conRemark) ? aoO.field_conRemark : this.eih != null ? this.eih.mo16807mJ(str) : null;
        if (C5046bo.isNullOrNil(mJ)) {
            mJ = aoO.field_conRemark;
        }
        if (C5046bo.isNullOrNil(mJ)) {
            mJ = aoO.mo16706Oi();
        }
        SpannableString b = C44089j.m79293b((Context) this, C5046bo.nullAsNil(mJ), textView.getTextSize());
        AppMethodBeat.m2505o(104278);
        return b;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: cd */
    public final C18153c mo60478cd(View view) {
        AppMethodBeat.m2504i(104279);
        C18153c c18153c = new C18153c();
        c18153c.ejo = (ImageView) view.findViewById(2131827163);
        c18153c.elJ = (TextView) view.findViewById(2131827168);
        c18153c.elK = (TextView) view.findViewById(2131827169);
        AppMethodBeat.m2505o(104279);
        return c18153c;
    }

    /* renamed from: a */
    static /* synthetic */ void m63620a(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI, String str, String str2, String str3, boolean z) {
        AppMethodBeat.m2504i(104280);
        if (C5046bo.isNullOrNil(str2)) {
            C7575bv RB = ((C6982j) C1720g.m3528K(C6982j.class)).mo15370XN().mo15364RB(str);
            if (!(RB == null || C5046bo.isNullOrNil(RB.field_encryptUsername))) {
                str2 = RB.field_conRemark;
            }
        }
        if (!C5046bo.isNullOrNil(str)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_RemarkName", str2);
            C4990ab.m7417i("MicroMsg.SeeAccessVerifyInfoUI", "mTicket:%s", seeAccessVerifyInfoUI.elr);
            intent.putExtra("key_add_contact_verify_ticket", seeAccessVerifyInfoUI.elr);
            if (seeAccessVerifyInfoUI.eih != null) {
                intent.putExtra("Contact_RoomNickname", seeAccessVerifyInfoUI.eih.mo16807mJ(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", seeAccessVerifyInfoUI.elp);
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
            if (aoO != null && ((int) aoO.ewQ) > 0 && C7486a.m12942jh(aoO.field_type)) {
                C42041qh c42041qh = new C42041qh();
                c42041qh.cMw.intent = intent;
                c42041qh.cMw.username = str;
                C4879a.xxA.mo10055m(c42041qh);
            }
            if (aoO != null && aoO.dsf()) {
                C7060h.pYm.mo8374X(10298, aoO.field_username + ",14");
            }
            if (z) {
                intent.putExtra("Contact_Scene", 96);
            } else {
                intent.putExtra("Contact_Scene", 14);
            }
            intent.putExtra("Is_RoomOwner", true);
            intent.putExtra("Contact_ChatRoomId", seeAccessVerifyInfoUI.elp);
            C25985d.m41467b((Context) seeAccessVerifyInfoUI, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        }
        AppMethodBeat.m2505o(104280);
    }
}
