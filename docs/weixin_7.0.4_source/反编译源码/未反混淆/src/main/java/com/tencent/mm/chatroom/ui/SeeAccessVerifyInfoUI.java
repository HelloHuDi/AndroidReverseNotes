package com.tencent.mm.chatroom.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.b.i;
import com.tencent.mm.openim.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.k.l;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.protocal.protobuf.fp;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SeeAccessVerifyInfoUI extends MMActivity implements f {
    private u eih;
    private boolean elA = false;
    private boolean elB = false;
    private b eld;
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
    private p tipDialog;

    public class a {
        String csB;
        String elE;
        String elF;
        String nickname;
        String username;

        a(String str, String str2, String str3, String str4, String str5) {
            this.username = str;
            this.nickname = str2;
            this.csB = str3;
            this.elE = str4;
            this.elF = str5;
        }
    }

    class c {
        public ImageView ejo;
        public TextView elJ;
        public TextView elK;

        c() {
        }
    }

    public class b extends BaseAdapter {
        List<a> elG = new ArrayList();
        private com.tencent.mm.at.a.a.c elH = null;
        Context mContext;

        public b(Context context) {
            AppMethodBeat.i(104268);
            this.mContext = context;
            Kk();
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePH = true;
            aVar.ePZ = true;
            aVar.ePT = R.raw.default_avatar;
            this.elH = aVar.ahG();
            AppMethodBeat.o(104268);
        }

        private void Kk() {
            AppMethodBeat.i(104269);
            if (bo.isNullOrNil(SeeAccessVerifyInfoUI.this.elf)) {
                ab.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesUsernames null");
                AppMethodBeat.o(104269);
                return;
            }
            String[] split = SeeAccessVerifyInfoUI.this.elf.split(",");
            if (bo.isNullOrNil(SeeAccessVerifyInfoUI.this.ele)) {
                ab.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesNicknames null");
                AppMethodBeat.o(104269);
                return;
            }
            String[] strArr;
            String[] strArr2;
            String[] strArr3;
            String[] split2 = SeeAccessVerifyInfoUI.this.ele.split(",");
            if (bo.isNullOrNil(SeeAccessVerifyInfoUI.this.elh)) {
                ab.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesAppids null");
                strArr = null;
            } else {
                strArr = SeeAccessVerifyInfoUI.this.elh.split(",");
            }
            if (bo.isNullOrNil(SeeAccessVerifyInfoUI.this.elg)) {
                ab.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesDescids null");
                strArr2 = null;
            } else {
                strArr2 = SeeAccessVerifyInfoUI.this.elg.split(",");
            }
            if (bo.isNullOrNil(SeeAccessVerifyInfoUI.this.eli)) {
                ab.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesHeadimgurls null");
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
                    String str2 = (split2.length <= i2 || bo.isNullOrNil(split2[i2])) ? split[i2] : split2[i2];
                    String str3 = (strArr == null || strArr.length <= i2 || bo.isNullOrNil(strArr[i2])) ? "" : strArr[i2];
                    String str4 = (strArr2 == null || strArr2.length <= i2 || bo.isNullOrNil(strArr2[i2])) ? "" : strArr2[i2];
                    String str5 = (strArr3 == null || strArr3.length <= i2 || bo.isNullOrNil(strArr3[i2])) ? "" : strArr3[i2];
                    list.add(new a(str, str2, str3, str4, str5));
                    i = i2 + 1;
                } else {
                    AppMethodBeat.o(104269);
                    return;
                }
            }
        }

        public final int getCount() {
            AppMethodBeat.i(104270);
            int size = this.elG.size();
            AppMethodBeat.o(104270);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(104271);
            Object obj = this.elG.get(i);
            AppMethodBeat.o(104271);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            c cd;
            AppMethodBeat.i(104272);
            if (view == null) {
                view = View.inflate(this.mContext, R.layout.ap0, null);
                cd = SeeAccessVerifyInfoUI.this.cd(view);
            } else {
                c cVar = (c) view.getTag();
                if (cVar == null) {
                    cd = SeeAccessVerifyInfoUI.this.cd(view);
                } else {
                    cd = cVar;
                }
            }
            cd.ejo.setVisibility(0);
            cd.elJ.setVisibility(0);
            o.ahp().a(((a) this.elG.get(i)).elF, cd.ejo, this.elH);
            cd.elJ.setText(j.b(this.mContext, bo.nullAsNil(((a) this.elG.get(i)).nickname), cd.elJ.getTextSize()));
            if (ad.aox(((a) this.elG.get(i)).username)) {
                SeeAccessVerifyInfoUI.this.elz = true;
                e eVar = new e();
                eVar.field_appid = bo.nullAsNil(((a) this.elG.get(i)).csB);
                eVar.field_wordingId = bo.nullAsNil(((a) this.elG.get(i)).elE);
                eVar.field_language = aa.gw(ah.getContext());
                g.RQ();
                ((PluginOpenIM) g.M(PluginOpenIM.class)).getWordingInfoStg().b((com.tencent.mm.sdk.e.c) eVar, "appid", "wordingId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
                if (TextUtils.isEmpty(eVar.field_wording)) {
                    if (!(bo.isNullOrNil(eVar.field_appid) || bo.isNullOrNil(eVar.field_wordingId))) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(eVar.field_wordingId);
                        if (!bo.C(cd.elK.getTag(), "first")) {
                            SeeAccessVerifyInfoUI.this.elA = true;
                            g.RO().eJo.a(new i(eVar.field_appid, eVar.field_language, linkedList), 0);
                        }
                    }
                    cd.elK.setVisibility(4);
                    cd.elK.setTag("first");
                } else {
                    cd.elK.setVisibility(0);
                    cd.elK.setText("＠" + eVar.field_wording);
                }
            } else {
                cd.elK.setVisibility(8);
            }
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    String Oj;
                    AppMethodBeat.i(104267);
                    String str = ((a) b.this.elG.get(i)).nickname;
                    String str2 = null;
                    if (SeeAccessVerifyInfoUI.this.eih != null) {
                        str2 = SeeAccessVerifyInfoUI.this.eih.mJ(((a) b.this.elG.get(i)).username);
                    }
                    if (bo.isNullOrNil(str2)) {
                        Oj = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(bo.nullAsNil(((a) b.this.elG.get(i)).username)).Oj();
                    } else {
                        Oj = str2;
                    }
                    SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, ((a) b.this.elG.get(i)).username, Oj, str, true);
                    AppMethodBeat.o(104267);
                }
            });
            AppMethodBeat.o(104272);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104273);
        super.onCreate(bundle);
        ab.i("MicroMsg.SeeAccessVerifyInfoUI", "[onCreate]");
        setMMTitle(getString(R.string.c5));
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
        this.eih = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().ob(bo.nullAsNil(this.elp));
        this.eld = new b(this);
        String[] split = this.elf.split(",");
        if (split != null && split.length > 0) {
            ab.i("MicroMsg.SeeAccessVerifyInfoUI", "[%s] has been in chatroom![%s]", split[0], this.elp);
            if (this.eih.afg() != null && this.eih.afg().contains(r0)) {
                bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(this.eln);
                if (!jf.dtS()) {
                    jf.dtQ();
                    ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(this.eln, jf);
                }
            }
        }
        initView();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104261);
                SeeAccessVerifyInfoUI.this.finish();
                AppMethodBeat.o(104261);
                return true;
            }
        });
        AppMethodBeat.o(104273);
    }

    public void onResume() {
        AppMethodBeat.i(104274);
        ab.i("MicroMsg.SeeAccessVerifyInfoUI", "[onResume]");
        g.RO().eJo.a((int) l.CTRL_INDEX, (f) this);
        super.onResume();
        AppMethodBeat.o(104274);
    }

    public void onDestroy() {
        AppMethodBeat.i(104275);
        super.onDestroy();
        g.RO().eJo.b((int) l.CTRL_INDEX, (f) this);
        AppMethodBeat.o(104275);
    }

    public final int getLayoutId() {
        return R.layout.aqb;
    }

    public final void initView() {
        AppMethodBeat.i(104276);
        this.els = (TextView) findViewById(R.id.e7m);
        this.elt = (TextView) findViewById(R.id.e7n);
        this.elv = (TextView) findViewById(R.id.e42);
        this.elw = (TextView) findViewById(R.id.e43);
        this.elu = (ImageView) findViewById(R.id.e3x);
        this.elx = (TextView) findViewById(R.id.e7p);
        this.ely = (GridView) findViewById(R.id.e7o);
        this.ely.setAdapter(this.eld);
        if (this.elu != null) {
            this.elu.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(104262);
                    ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(bo.nullAsNil(SeeAccessVerifyInfoUI.this.elk));
                    String str = aoO.field_nickname;
                    String str2 = null;
                    if (SeeAccessVerifyInfoUI.this.eih != null) {
                        str2 = SeeAccessVerifyInfoUI.this.eih.mJ(SeeAccessVerifyInfoUI.this.elk);
                    }
                    if (bo.isNullOrNil(str2)) {
                        str2 = aoO.Oj();
                    }
                    SeeAccessVerifyInfoUI.a(SeeAccessVerifyInfoUI.this, SeeAccessVerifyInfoUI.this.elk, str2, str, false);
                    AppMethodBeat.o(104262);
                }
            });
        }
        this.ely.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.ely.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(104263);
                int i = 0;
                if (SeeAccessVerifyInfoUI.this.elv != null) {
                    if (SeeAccessVerifyInfoUI.this.elz) {
                        i = (int) ((((float) (SeeAccessVerifyInfoUI.this.elv.getHeight() * 2)) + SeeAccessVerifyInfoUI.this.getResources().getDimension(R.dimen.ds)) + SeeAccessVerifyInfoUI.this.getResources().getDimension(R.dimen.lw));
                    } else {
                        i = (int) ((((float) SeeAccessVerifyInfoUI.this.elv.getHeight()) + SeeAccessVerifyInfoUI.this.getResources().getDimension(R.dimen.ds)) + SeeAccessVerifyInfoUI.this.getResources().getDimension(R.dimen.lw));
                    }
                }
                if (SeeAccessVerifyInfoUI.this.eld.getCount() / 4 > 0) {
                    i *= (SeeAccessVerifyInfoUI.this.eld.getCount() / 4) + 1;
                }
                SeeAccessVerifyInfoUI.this.ely.setLayoutParams(new LayoutParams(SeeAccessVerifyInfoUI.this.ely.getWidth(), i));
                AppMethodBeat.o(104263);
            }
        }, 100);
        if (this.elu != null) {
            com.tencent.mm.pluginsdk.ui.a.b.b(this.elu, bo.nullAsNil(this.elk));
        }
        if (this.elv != null) {
            this.elv.setText(a(bo.nullAsNil(this.elk), this.elv));
        }
        if (this.elw != null) {
            if (t.mP(this.elp) && ad.aox(this.elk)) {
                e eVar = new e();
                eVar.field_appid = this.ell;
                eVar.field_wordingId = this.elm;
                eVar.field_language = aa.gw(ah.getContext());
                g.RQ();
                ((PluginOpenIM) g.M(PluginOpenIM.class)).getWordingInfoStg().b((com.tencent.mm.sdk.e.c) eVar, "appid", "wordingId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
                if (TextUtils.isEmpty(eVar.field_wording)) {
                    if (!(bo.isNullOrNil(this.elm) || bo.isNullOrNil(this.ell))) {
                        this.elB = true;
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(this.elm);
                        g.RO().eJo.a(new i(this.ell, eVar.field_language, linkedList), 0);
                    }
                    this.elw.setVisibility(4);
                } else {
                    this.elw.setVisibility(0);
                    this.elw.setText("＠" + eVar.field_wording);
                }
            } else {
                this.elw.setVisibility(8);
            }
        }
        if (this.els != null) {
            this.els.setText(j.b((Context) this, bo.nullAsNil(this.elj)));
        }
        if (!(this.elt == null || bo.isNullOrNil(this.elq))) {
            this.elt.setText(j.b((Context) this, "\"" + bo.nullAsNil(this.elq) + "\""));
        }
        if (this.elx != null) {
            this.elx.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(104266);
                    SeeAccessVerifyInfoUI seeAccessVerifyInfoUI = SeeAccessVerifyInfoUI.this;
                    Context context = SeeAccessVerifyInfoUI.this.mController.ylL;
                    SeeAccessVerifyInfoUI.this.getString(R.string.tz);
                    seeAccessVerifyInfoUI.tipDialog = h.b(context, SeeAccessVerifyInfoUI.this.getString(R.string.c6), false, null);
                    if (t.mP(SeeAccessVerifyInfoUI.this.elp)) {
                        new com.tencent.mm.openim.c.a.a(SeeAccessVerifyInfoUI.this.elk, SeeAccessVerifyInfoUI.this.elp, SeeAccessVerifyInfoUI.this.elr, new LinkedList(bo.hT(SeeAccessVerifyInfoUI.this.elf, ","))).acy().b(SeeAccessVerifyInfoUI.this).b(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<fp>>() {
                            public final /* synthetic */ Object call(Object obj) {
                                AppMethodBeat.i(104264);
                                com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                                if (SeeAccessVerifyInfoUI.this.tipDialog != null && SeeAccessVerifyInfoUI.this.tipDialog.isShowing()) {
                                    SeeAccessVerifyInfoUI.this.tipDialog.dismiss();
                                }
                                com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(aVar.aIm);
                                if (jY != null) {
                                    jY.a(SeeAccessVerifyInfoUI.this, null, null);
                                } else if (aVar.errType == 0 && aVar.errCode == 0) {
                                    if (aVar.cwn.getType() == 941) {
                                        bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(SeeAccessVerifyInfoUI.this.eln);
                                        jf.dtQ();
                                        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().b(jf.field_msgSvrId, jf);
                                        SeeAccessVerifyInfoUI.this.elx.setBackgroundResource(R.drawable.fr);
                                        SeeAccessVerifyInfoUI.this.elx.setTextColor(SeeAccessVerifyInfoUI.this.getResources().getColor(R.color.rl));
                                        SeeAccessVerifyInfoUI.this.elx.setText(SeeAccessVerifyInfoUI.this.getString(R.string.cbk));
                                        SeeAccessVerifyInfoUI.this.elx.setEnabled(false);
                                        com.tencent.mm.plugin.report.service.h.pYm.a(219, 23, 1, true);
                                    }
                                } else if (aVar.cwn.getType() == 941) {
                                    ab.i("MicroMsg.SeeAccessVerifyInfoUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", Integer.valueOf(941), Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType), bo.nullAsNil(aVar.aIm));
                                    h.b(SeeAccessVerifyInfoUI.this.mController.ylL, SeeAccessVerifyInfoUI.this.getString(R.string.c4), SeeAccessVerifyInfoUI.this.getString(R.string.tz), true);
                                }
                                Void voidR = zXH;
                                AppMethodBeat.o(104264);
                                return voidR;
                            }
                        });
                        AppMethodBeat.o(104266);
                        return;
                    }
                    new com.tencent.mm.chatroom.c.c(SeeAccessVerifyInfoUI.this.elo, SeeAccessVerifyInfoUI.this.elk, SeeAccessVerifyInfoUI.this.elp, SeeAccessVerifyInfoUI.this.elr, new LinkedList(bo.P(SeeAccessVerifyInfoUI.this.elf.split(",")))).acy().b(SeeAccessVerifyInfoUI.this).b(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<fn>>() {
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.i(104265);
                            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                            if (SeeAccessVerifyInfoUI.this.tipDialog != null && SeeAccessVerifyInfoUI.this.tipDialog.isShowing()) {
                                SeeAccessVerifyInfoUI.this.tipDialog.dismiss();
                            }
                            com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(aVar.aIm);
                            if (jY != null) {
                                jY.a(SeeAccessVerifyInfoUI.this, null, null);
                            } else if (aVar.errType == 0 && aVar.errCode == 0) {
                                if (aVar.cwn.getType() == 774) {
                                    bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(SeeAccessVerifyInfoUI.this.eln);
                                    jf.dtQ();
                                    ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().b(jf.field_msgSvrId, jf);
                                    SeeAccessVerifyInfoUI.this.elx.setBackgroundResource(R.drawable.fr);
                                    SeeAccessVerifyInfoUI.this.elx.setTextColor(SeeAccessVerifyInfoUI.this.getResources().getColor(R.color.rl));
                                    SeeAccessVerifyInfoUI.this.elx.setText(SeeAccessVerifyInfoUI.this.getString(R.string.cbk));
                                    SeeAccessVerifyInfoUI.this.elx.setEnabled(false);
                                    com.tencent.mm.plugin.report.service.h.pYm.a(219, 23, 1, true);
                                }
                            } else if (aVar.cwn.getType() == 774) {
                                ab.i("MicroMsg.SeeAccessVerifyInfoUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", Integer.valueOf(774), Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType), bo.nullAsNil(aVar.aIm));
                                h.b(SeeAccessVerifyInfoUI.this.mController.ylL, SeeAccessVerifyInfoUI.this.getString(R.string.c4), SeeAccessVerifyInfoUI.this.getString(R.string.tz), true);
                            }
                            Void voidR = zXH;
                            AppMethodBeat.o(104265);
                            return voidR;
                        }
                    });
                    AppMethodBeat.o(104266);
                }
            });
        }
        if (this.elx != null && ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(this.eln).dtS()) {
            this.elx.setBackgroundResource(R.drawable.fr);
            this.elx.setTextColor(getResources().getColor(R.color.rl));
            this.elx.setText(getString(R.string.cbk));
            this.elx.setEnabled(false);
        }
        AppMethodBeat.o(104276);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(104277);
        if ((mVar instanceof i) && i == 0 && i2 == 0) {
            if (this.elB && bo.ac(this.elw.getText())) {
                this.elB = false;
                e eVar = new e();
                eVar.field_appid = this.ell;
                eVar.field_wordingId = this.elm;
                eVar.field_language = aa.gw(ah.getContext());
                g.RQ();
                ((PluginOpenIM) g.M(PluginOpenIM.class)).getWordingInfoStg().b((com.tencent.mm.sdk.e.c) eVar, "appid", "wordingId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
                if (TextUtils.isEmpty(eVar.field_wording)) {
                    if (!(bo.isNullOrNil(this.elm) || bo.isNullOrNil(this.ell))) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(this.elm);
                        g.RO().eJo.a(new i(this.ell, eVar.field_language, linkedList), 0);
                    }
                    this.elw.setVisibility(4);
                } else {
                    this.elw.setVisibility(0);
                    this.elw.setText("＠" + eVar.field_wording);
                }
            }
            if (this.elA) {
                this.eld.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(104277);
    }

    private SpannableString a(String str, TextView textView) {
        AppMethodBeat.i(104278);
        if (textView == null) {
            AppMethodBeat.o(104278);
            return null;
        }
        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(bo.nullAsNil(str));
        if (aoO == null) {
            ab.w("MicroMsg.SeeAccessVerifyInfoUI", "ct == null");
            AppMethodBeat.o(104278);
            return null;
        }
        String mJ = !bo.isNullOrNil(aoO.field_conRemark) ? aoO.field_conRemark : this.eih != null ? this.eih.mJ(str) : null;
        if (bo.isNullOrNil(mJ)) {
            mJ = aoO.field_conRemark;
        }
        if (bo.isNullOrNil(mJ)) {
            mJ = aoO.Oi();
        }
        SpannableString b = j.b((Context) this, bo.nullAsNil(mJ), textView.getTextSize());
        AppMethodBeat.o(104278);
        return b;
    }

    /* Access modifiers changed, original: protected|final */
    public final c cd(View view) {
        AppMethodBeat.i(104279);
        c cVar = new c();
        cVar.ejo = (ImageView) view.findViewById(R.id.e3x);
        cVar.elJ = (TextView) view.findViewById(R.id.e42);
        cVar.elK = (TextView) view.findViewById(R.id.e43);
        AppMethodBeat.o(104279);
        return cVar;
    }

    static /* synthetic */ void a(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI, String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(104280);
        if (bo.isNullOrNil(str2)) {
            bv RB = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XN().RB(str);
            if (!(RB == null || bo.isNullOrNil(RB.field_encryptUsername))) {
                str2 = RB.field_conRemark;
            }
        }
        if (!bo.isNullOrNil(str)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_RemarkName", str2);
            ab.i("MicroMsg.SeeAccessVerifyInfoUI", "mTicket:%s", seeAccessVerifyInfoUI.elr);
            intent.putExtra("key_add_contact_verify_ticket", seeAccessVerifyInfoUI.elr);
            if (seeAccessVerifyInfoUI.eih != null) {
                intent.putExtra("Contact_RoomNickname", seeAccessVerifyInfoUI.eih.mJ(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", seeAccessVerifyInfoUI.elp);
            ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(str);
            if (aoO != null && ((int) aoO.ewQ) > 0 && com.tencent.mm.n.a.jh(aoO.field_type)) {
                qh qhVar = new qh();
                qhVar.cMw.intent = intent;
                qhVar.cMw.username = str;
                com.tencent.mm.sdk.b.a.xxA.m(qhVar);
            }
            if (aoO != null && aoO.dsf()) {
                com.tencent.mm.plugin.report.service.h.pYm.X(10298, aoO.field_username + ",14");
            }
            if (z) {
                intent.putExtra("Contact_Scene", 96);
            } else {
                intent.putExtra("Contact_Scene", 14);
            }
            intent.putExtra("Is_RoomOwner", true);
            intent.putExtra("Contact_ChatRoomId", seeAccessVerifyInfoUI.elp);
            d.b((Context) seeAccessVerifyInfoUI, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        }
        AppMethodBeat.o(104280);
    }
}
