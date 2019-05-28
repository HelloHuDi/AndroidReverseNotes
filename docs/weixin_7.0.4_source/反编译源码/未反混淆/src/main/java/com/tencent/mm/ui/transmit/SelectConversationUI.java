package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.gf;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.t;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.base.stub.d;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.ag;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.a.g;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.contact.x;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.v;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@a(23)
@i
public class SelectConversationUI extends MMBaseSelectContactUI {
    private static final int zJK = s.C(1, 2);
    private String cJh;
    private bi cKd;
    private long cvv;
    private long cvx;
    private List<String> elZ;
    private int fromScene = 0;
    private int gnI;
    private String imagePath = null;
    private String kcC = null;
    private String lgZ;
    private int[] mqq = new int[]{R.id.asx, R.id.asy, R.id.asz, R.id.at0, R.id.at1};
    private int msgType;
    private TextView yFh;
    private int zJL;
    private boolean zJM = false;
    private boolean zJN = false;
    private boolean zJO = false;
    private boolean zJP = false;
    private boolean zJQ = false;
    private boolean zJR = false;
    private boolean zJS = false;
    private int zJT;
    private boolean zJU = false;
    private String zJV;
    private String zJW;
    private Boolean zJX = Boolean.FALSE;
    private boolean zJY = false;
    private boolean zJZ = false;
    private List<String> zKa = null;
    private ReportArgs zKb;
    private String zKc = null;
    private String zKd;
    private String zKe;
    private int zKf;
    private String zKg;
    private OnMenuItemClickListener zKh = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(35144);
            SelectConversationUI.this.zJZ = !SelectConversationUI.this.zJZ;
            SelectConversationUI.this.dHV().qE(SelectConversationUI.this.zJZ);
            SelectConversationUI.this.zna.qE(SelectConversationUI.this.zJZ);
            SelectConversationUI.k(SelectConversationUI.this);
            SelectConversationUI.this.yFh.setText(!SelectConversationUI.this.zJZ ? SelectConversationUI.this.zJL : R.string.e23);
            AppMethodBeat.o(35144);
            return true;
        }
    };
    private OnMenuItemClickListener zKi = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(35145);
            if (SelectConversationUI.n(SelectConversationUI.this)) {
                AppMethodBeat.o(35145);
                return false;
            }
            for (String asq : SelectConversationUI.this.zKa) {
                if (SelectConversationUI.this.asq(asq)) {
                    AppMethodBeat.o(35145);
                    return false;
                }
            }
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_User", ah.c(SelectConversationUI.this.zKa, ","));
            Intent intent2 = (Intent) SelectConversationUI.this.getIntent().getParcelableExtra("Select_Conv_NextStep");
            if (intent2 != null) {
                SelectConversationUI.a(SelectConversationUI.this, intent, intent2);
            } else if (SelectConversationUI.this.zJQ) {
                SelectConversationUI.a(SelectConversationUI.this, -1, intent);
                SelectConversationUI.this.finish();
            } else {
                SelectConversationUI.a(SelectConversationUI.this, intent);
            }
            AppMethodBeat.o(35145);
            return true;
        }
    };
    private int zeC = -1;
    private boolean znm;
    private boolean zoG = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SelectConversationUI() {
        AppMethodBeat.i(35153);
        AppMethodBeat.o(35153);
    }

    static /* synthetic */ void d(Intent intent, String str, String str2) {
        AppMethodBeat.i(35200);
        c(intent, str, str2);
        AppMethodBeat.o(35200);
    }

    static /* synthetic */ void d(SelectConversationUI selectConversationUI) {
        AppMethodBeat.i(35197);
        selectConversationUI.dKn();
        AppMethodBeat.o(35197);
    }

    static /* synthetic */ void e(Intent intent, String str, String str2) {
        AppMethodBeat.i(35201);
        b(intent, str, str2);
        AppMethodBeat.o(35201);
    }

    static /* synthetic */ void e(SelectConversationUI selectConversationUI) {
        AppMethodBeat.i(35198);
        selectConversationUI.dKo();
        AppMethodBeat.o(35198);
    }

    static /* synthetic */ void f(SelectConversationUI selectConversationUI) {
        AppMethodBeat.i(35199);
        super.bMQ();
        AppMethodBeat.o(35199);
    }

    static /* synthetic */ void k(SelectConversationUI selectConversationUI) {
        AppMethodBeat.i(35203);
        selectConversationUI.Kt();
        AppMethodBeat.o(35203);
    }

    static /* synthetic */ boolean n(SelectConversationUI selectConversationUI) {
        AppMethodBeat.i(35204);
        boolean qS = selectConversationUI.qS(false);
        AppMethodBeat.o(35204);
        return qS;
    }

    static {
        AppMethodBeat.i(35207);
        AppMethodBeat.o(35207);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(35154);
        f.m(this);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("Select_App_Id");
        String stringExtra2 = getIntent().getStringExtra("Select_Open_Id");
        ab.i("MicroMsg.SelectConversationUI", "onCreate, appId = " + stringExtra + ", openId = " + stringExtra2);
        if (!(ah.isNullOrNil(stringExtra) || ah.isNullOrNil(stringExtra2))) {
            new d(this, stringExtra, stringExtra2, new d.a() {
                public final void ft(boolean z) {
                    AppMethodBeat.i(35124);
                    boolean isFinishing = SelectConversationUI.this.isFinishing();
                    ab.i("MicroMsg.SelectConversationUI", "onCheckEnd, isPass = " + z + ", isFinishing = " + isFinishing);
                    if (!(z || isFinishing)) {
                        SelectConversationUI.this.finish();
                    }
                    AppMethodBeat.o(35124);
                }
            }).aVi();
        }
        f.n(this);
        AppMethodBeat.o(35154);
    }

    public final void Kh() {
        AppMethodBeat.i(35155);
        super.Kh();
        this.zJM = getIntent().getBooleanExtra("select_is_ret", false);
        this.fromScene = getIntent().getIntExtra("scene_from", 0);
        ab.i("MicroMsg.SelectConversationUI", "from scene:%d", Integer.valueOf(this.fromScene));
        if (this.fromScene == 1) {
            this.zJN = true;
        } else if (this.fromScene == 2 || this.fromScene == 10) {
            this.zJO = true;
        } else if (this.fromScene == 3) {
            this.zJP = true;
        } else if (this.fromScene == 6) {
            this.zJQ = true;
        } else if (this.fromScene == 7) {
            this.zJR = true;
        } else if (this.fromScene == 11) {
            overridePendingTransition(R.anim.cg, R.anim.ce);
        }
        this.zJS = getIntent().getBooleanExtra("send_to_biz", false);
        this.zeC = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
        this.cvv = getIntent().getLongExtra("select_fav_local_id", -1);
        this.zJT = getIntent().getIntExtra("select_fav_select_count", 0);
        this.zJY = getIntent().getBooleanExtra("mutil_select_is_ret", false);
        this.zoG = getIntent().getBooleanExtra("Select_Send_Card", false);
        this.zJU = getIntent().getBooleanExtra("Retr_Big_File", false);
        if (this.zoG) {
            this.zJV = getIntent().getStringExtra("Select_Talker_Name");
        }
        this.gnI = getIntent().getIntExtra("Select_Conv_Type", zJK);
        this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
        this.cvx = getIntent().getLongExtra("Retr_Msg_Id", -1);
        aw.ZK();
        this.cKd = c.XO().jf(this.cvx);
        this.imagePath = getIntent().getStringExtra("image_path");
        this.zKc = getIntent().getStringExtra("ad_video_title");
        this.kcC = getIntent().getStringExtra("desc_title");
        this.lgZ = getIntent().getStringExtra("Retr_Msg_thumb_path");
        this.cJh = getIntent().getStringExtra("Retr_Msg_content");
        this.zKd = getIntent().getStringExtra("Retr_fav_xml_str");
        if (this.cJh == null && this.cKd != null) {
            this.cJh = this.cKd.field_content;
        }
        this.zKb = (ReportArgs) getIntent().getParcelableExtra("Select_Report_Args");
        this.zKe = getIntent().getStringExtra("KChooseMsgFileType");
        this.zKf = getIntent().getIntExtra("KChooseMsgFileCount", 9);
        this.zKg = getIntent().getStringExtra("KChooseMsgFileExtension");
        HashSet hashSet = new HashSet();
        hashSet.addAll(s.dIf());
        String stringExtra = getIntent().getStringExtra("Select_block_List");
        if (!ah.isNullOrNil(stringExtra)) {
            hashSet.addAll(ah.j(stringExtra.split(",")));
        }
        if (s.hr(this.gnI, 2)) {
            HashSet dIg = s.dIg();
            s.h(dIg);
            hashSet.addAll(dIg);
        }
        this.elZ = new ArrayList();
        this.elZ.addAll(hashSet);
        fy(this.elZ);
        if (s.hr(this.gnI, 1)) {
            this.znm = true;
        }
        if (this.zJY) {
            this.zKa = new LinkedList();
            if (this.zJY) {
                a(1, getString(R.string.rr), this.zKh, b.GREEN);
                Kt();
            }
        }
        AppMethodBeat.o(35155);
    }

    public final o aoz() {
        AppMethodBeat.i(35156);
        x xVar = new x(this, this.elZ, this.znm, this.zJZ, this.zJS, this.gnI);
        AppMethodBeat.o(35156);
        return xVar;
    }

    public final m aoA() {
        AppMethodBeat.i(35157);
        q qVar = new q(this, this.elZ, this.zJZ, this.scene);
        AppMethodBeat.o(35157);
        return qVar;
    }

    public final void a(ListView listView, int i) {
        AppMethodBeat.i(35158);
        super.a(listView, i);
        if (this.fromScene == 11) {
            AppMethodBeat.o(35158);
            return;
        }
        if (this.yFh == null) {
            if (this.zoG) {
                this.zJL = R.string.e23;
            } else if (this.fromScene == 10) {
                this.zJL = R.string.daq;
            } else {
                this.zJL = R.string.e1s;
            }
            AnonymousClass12 anonymousClass12 = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(35136);
                    if (SelectConversationUI.this.zJZ) {
                        SelectConversationUI.b(SelectConversationUI.this);
                        AppMethodBeat.o(35136);
                        return;
                    }
                    String stringExtra = SelectConversationUI.this.getIntent().getStringExtra("Select_App_Id");
                    if (SelectConversationUI.this.zoG && bo.isNullOrNil(stringExtra)) {
                        SelectConversationUI.d(SelectConversationUI.this);
                        AppMethodBeat.o(35136);
                        return;
                    }
                    SelectConversationUI.e(SelectConversationUI.this);
                    AppMethodBeat.o(35136);
                }
            };
            String string = getString(this.zJL);
            View inflate = v.hu(this).inflate(R.layout.a6i, null);
            inflate.setOnClickListener(anonymousClass12);
            TextView textView = (TextView) inflate.findViewById(R.id.b14);
            textView.setText(string);
            listView.addHeaderView(inflate);
            this.yFh = textView;
        }
        this.yFh.setVisibility(i);
        AppMethodBeat.o(35158);
    }

    public final void bMQ() {
        AppMethodBeat.i(35159);
        if (this.fromScene == 5) {
            h.a((Context) this, getString(R.string.csw), null, getString(R.string.e31), getString(R.string.abx), true, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(35146);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(35146);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(35147);
                    SelectConversationUI.f(SelectConversationUI.this);
                    SelectConversationUI.this.aqX();
                    AppMethodBeat.o(35147);
                }
            });
        } else {
            super.bMQ();
            aqX();
        }
        if (this.zKb != null) {
            this.zKb.errCode = 0;
            ReportUtil.a(this, this.zKb, true);
        }
        AppMethodBeat.o(35159);
    }

    public void onBackPressed() {
        AppMethodBeat.i(35160);
        super.bMQ();
        AppMethodBeat.o(35160);
    }

    public final void mO(int i) {
        AppMethodBeat.i(35161);
        int headerViewsCount;
        com.tencent.mm.ui.contact.a.a Pn;
        if (this.zJZ) {
            headerViewsCount = i - getContentLV().getHeaderViewsCount();
            if (headerViewsCount < 0) {
                ab.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", Integer.valueOf(i));
                dKm();
                AppMethodBeat.o(35161);
                return;
            }
            n dHV = dHV();
            Pn = dHV.getItem(headerViewsCount);
            if (Pn == null) {
                AppMethodBeat.o(35161);
            } else if (Pn.ehM == null) {
                AppMethodBeat.o(35161);
            } else {
                String str = Pn.ehM.field_username;
                ab.i("MicroMsg.SelectConversationUI", "ClickUser=%s", str);
                if (this.zKa.contains(str) || !qS(true)) {
                    dIb();
                    this.opo.ajq(str);
                    if (this.zKa.contains(str)) {
                        this.zKa.remove(str);
                    } else {
                        this.zKa.add(str);
                    }
                    Kt();
                    dHV.notifyDataSetChanged();
                    AppMethodBeat.o(35161);
                    return;
                }
                dIb();
                AppMethodBeat.o(35161);
            }
        } else if (i < getContentLV().getHeaderViewsCount()) {
            ab.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", Integer.valueOf(i));
            if (this.zoG) {
                dKn();
                AppMethodBeat.o(35161);
                return;
            }
            dKo();
            AppMethodBeat.o(35161);
        } else {
            Pn = (com.tencent.mm.ui.contact.a.a) getContentLV().getAdapter().getItem(i);
            Intent intent;
            if (Pn == null) {
                AppMethodBeat.o(35161);
            } else if ((Pn instanceof com.tencent.mm.ui.contact.a.b) && ((com.tencent.mm.ui.contact.a.b) Pn).bCu == getResources().getString(R.string.ef)) {
                ab.i("MicroMsg.SelectConversationUI", "doCallSelectBizItem");
                intent = new Intent();
                intent.putExtra("list_attr", 16384);
                com.tencent.mm.bp.d.b((Context) this, "brandservice", ".ui.BrandServiceIndexUI", intent, 4);
                this.zJO = true;
                AppMethodBeat.o(35161);
            } else if (Pn instanceof g) {
                g gVar = (g) Pn;
                Intent intent2 = new Intent();
                intent2.putExtra("scene", this.scene);
                ArrayList arrayList = new ArrayList();
                for (Object add : gVar.mDz.mEa) {
                    arrayList.add(add);
                }
                intent2.putExtra("query_phrase_list", arrayList);
                com.tencent.mm.bp.d.b((Context) this, ".ui.transmit.MMCreateChatroomUI", intent2, 1);
                AppMethodBeat.o(35161);
            } else {
                ad adVar = Pn.ehM;
                if (adVar == null) {
                    AppMethodBeat.o(35161);
                    return;
                }
                String str2 = adVar.field_username;
                ab.i("MicroMsg.SelectConversationUI", "doClickUser=%s", str2);
                if (!asq(str2)) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("Select_Conv_User", str2);
                    intent = (Intent) getIntent().getParcelableExtra("Select_Conv_NextStep");
                    if (intent != null) {
                        a(intent3, intent);
                    } else if (this.zJM || this.zoG || this.zJN || this.zJO || this.zJP) {
                        t(intent3, str2);
                    } else if (this.fromScene == 11) {
                        ass(str2);
                    } else {
                        k(-1, intent3);
                        finish();
                    }
                    aqX();
                }
                AppMethodBeat.o(35161);
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(35162);
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            ab.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            ab.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        String stringExtra;
        Intent intent2;
        final String stringExtra2;
        if (i == 1) {
            if (i2 == -1 && intent != null) {
                stringExtra = intent.getStringExtra("Select_Conv_User");
                ab.i("MicroMsg.SelectConversationUI", "getIntent = " + getIntent());
                intent2 = (Intent) getIntent().getParcelableExtra("Select_Conv_NextStep");
                if (intent2 != null) {
                    if (asq(stringExtra)) {
                        AppMethodBeat.o(35162);
                        return;
                    }
                    a(intent, intent2);
                    AppMethodBeat.o(35162);
                    return;
                } else if (this.zJM || this.zoG || this.zJN || this.zJO || this.zJP) {
                    t(intent, stringExtra);
                    AppMethodBeat.o(35162);
                    return;
                } else if (this.fromScene == 11) {
                    ass(stringExtra);
                    AppMethodBeat.o(35162);
                    return;
                } else {
                    k(-1, intent);
                    finish();
                }
            }
            AppMethodBeat.o(35162);
        } else if (i == 2) {
            switch (i2) {
                case -1:
                    finish();
                    if (intent != null && intent.getBooleanExtra("Select_stay_in_wx", false)) {
                        intent2 = new Intent(this, TaskRedirectUI.class);
                        intent2.addFlags(268435456);
                        startActivity(intent2);
                        ReportUtil.F(false, 0);
                        AppMethodBeat.o(35162);
                        return;
                    }
                case 0:
                    if (intent != null) {
                        this.zKb = (ReportArgs) intent.getParcelableExtra("Select_Report_Args");
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(35162);
        } else if (i == 3) {
            switch (i2) {
                case -1:
                    if (intent != null) {
                        stringExtra2 = intent.getStringExtra("received_card_name");
                        if (!(bo.isNullOrNil(stringExtra2) || asq(stringExtra2))) {
                            com.tencent.mm.pluginsdk.ui.applet.g.a aVar = new com.tencent.mm.pluginsdk.ui.applet.g.a(this.mController.ylL);
                            aVar.cx(stringExtra2);
                            a(aVar, this.zJV);
                            aVar.h(Boolean.TRUE).KQ(R.string.tf).a(new com.tencent.mm.pluginsdk.ui.applet.q.a() {
                                public final void a(boolean z, String str, int i) {
                                    AppMethodBeat.i(35148);
                                    SelectConversationUI.this.aqX();
                                    if (z) {
                                        Intent intent = new Intent();
                                        if (t.kH(stringExtra2)) {
                                            SelectConversationUI.d(intent, SelectConversationUI.this.zJV, stringExtra2);
                                        } else {
                                            SelectConversationUI.e(intent, SelectConversationUI.this.zJV, stringExtra2);
                                        }
                                        intent.putExtra("custom_send_text", str);
                                        SelectConversationUI.a(SelectConversationUI.this, -1, intent);
                                        SelectConversationUI.this.finish();
                                    }
                                    AppMethodBeat.o(35148);
                                }
                            }).gud.show();
                            break;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(35162);
        } else if (i == 4) {
            if (i2 == -1 && intent != null) {
                t(intent, intent.getStringExtra("Select_Contact"));
            }
            AppMethodBeat.o(35162);
        } else if (i == 5) {
            if (i2 == -1 && intent != null) {
                stringExtra = intent.getStringExtra("Select_Conv_User");
                for (String stringExtra22 : this.zKa) {
                    this.opo.ajr(stringExtra22);
                }
                if (ah.isNullOrNil(stringExtra)) {
                    this.zKa.clear();
                } else {
                    this.zKa = ah.j(stringExtra.split(","));
                }
                for (String stringExtra222 : this.zKa) {
                    this.opo.bU(stringExtra222, false);
                }
                Kt();
                dHV().notifyDataSetChanged();
            }
            AppMethodBeat.o(35162);
        } else {
            ab.e("MicroMsg.SelectConversationUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(i)));
            AppMethodBeat.o(35162);
        }
    }

    private static boolean asp(String str) {
        AppMethodBeat.i(35163);
        if (ad.aox(str)) {
            AppMethodBeat.o(35163);
            return true;
        } else if (t.mP(str)) {
            AppMethodBeat.o(35163);
            return true;
        } else {
            AppMethodBeat.o(35163);
            return false;
        }
    }

    public final boolean asq(String str) {
        AppMethodBeat.i(35164);
        if (!asp(str)) {
            AppMethodBeat.o(35164);
            return false;
        } else if (ah.isNullOrNil(getIntent().getStringExtra("Select_App_Id")) || !this.zoG) {
            if (this.zoG) {
                aw.ZK();
                if (ad.Mn(c.XM().aoM(this.zJV).field_verifyFlag)) {
                    asr(str);
                    AppMethodBeat.o(35164);
                    return true;
                }
            }
            switch (this.msgType) {
                case 5:
                    AppMethodBeat.o(35164);
                    return false;
                case 8:
                    aw.ZK();
                    String str2 = c.XO().Rn(this.cJh).svN;
                    aw.ZK();
                    if (t.kv(c.XM().aoM(str2).field_verifyFlag)) {
                        asr(str);
                        AppMethodBeat.o(35164);
                        return true;
                    }
                    AppMethodBeat.o(35164);
                    return false;
                default:
                    AppMethodBeat.o(35164);
                    return false;
            }
        } else {
            AppMethodBeat.o(35164);
            return false;
        }
    }

    private void asr(String str) {
        AppMethodBeat.i(35165);
        try {
            List<String> j = ah.j(str.split(","));
            StringBuffer stringBuffer = new StringBuffer();
            Object obj = null;
            for (String str2 : j) {
                if (!ah.isNullOrNil(str2)) {
                    if (obj != null) {
                        stringBuffer.append(",");
                    }
                    stringBuffer.append(com.tencent.mm.model.s.mJ(str2));
                    obj = 1;
                }
            }
            h.a((Context) this, getString(R.string.egy, new Object[]{stringBuffer}), "", null);
            AppMethodBeat.o(35165);
        } catch (Throwable th) {
            AppMethodBeat.o(35165);
        }
    }

    private void ass(String str) {
        AppMethodBeat.i(35166);
        ab.i("MicroMsg.SelectConversationUI", "doChooseMsgFile userName:%s type:%s count:%d ", str, this.zKe, Integer.valueOf(this.zKf));
        ab.i("MicroMsg.SelectConversationUI", "doChooseMsgFile extension:%s ", this.zKg);
        ((com.tencent.mm.choosemsgfile.compat.a) com.tencent.mm.kernel.g.K(com.tencent.mm.choosemsgfile.compat.a.class)).a(this, str, this.zKe, this.zKf, this.zKg, new com.tencent.mm.choosemsgfile.compat.a.a() {
            public final void a(int i, String str, ArrayList<MsgFile> arrayList) {
                AppMethodBeat.i(35149);
                ab.i("MicroMsg.SelectConversationUI", "resultCode:%d filePaths:%s", Integer.valueOf(i), arrayList);
                Intent intent;
                switch (i) {
                    case -1:
                        intent = new Intent();
                        intent.putParcelableArrayListExtra("FILEPATHS", arrayList);
                        SelectConversationUI.this.setResult(-1, intent);
                        SelectConversationUI.this.finish();
                        AppMethodBeat.o(35149);
                        return;
                    case 1:
                        intent = new Intent();
                        intent.putExtra("ERRMSG", str);
                        SelectConversationUI.this.setResult(1, intent);
                        SelectConversationUI.this.finish();
                        break;
                }
                AppMethodBeat.o(35149);
            }
        });
        AppMethodBeat.o(35166);
    }

    private static void b(Intent intent, String str, String str2) {
        AppMethodBeat.i(35167);
        List linkedList = new LinkedList();
        linkedList.add(str2);
        a(intent, str, linkedList);
        AppMethodBeat.o(35167);
    }

    private static void a(Intent intent, String str, List<String> list) {
        AppMethodBeat.i(35168);
        if (list.size() > 0) {
            intent.putExtra("be_send_card_name", str);
            intent.putExtra("received_card_name", ah.c(list, ","));
            intent.putExtra("Is_Chatroom", false);
        }
        AppMethodBeat.o(35168);
    }

    private static void c(Intent intent, String str, String str2) {
        AppMethodBeat.i(35169);
        Assert.assertTrue("cardNameToSend is null", str != null);
        intent.putExtra("be_send_card_name", str);
        intent.putExtra("received_card_name", str2);
        intent.putExtra("Is_Chatroom", true);
        AppMethodBeat.o(35169);
    }

    private void a(com.tencent.mm.pluginsdk.ui.applet.g.a aVar, String str) {
        AppMethodBeat.i(35170);
        aw.ZK();
        c.XM().aoM(str);
        String mJ = com.tencent.mm.model.s.mJ(str);
        if (!bo.isNullOrNil(this.zJW)) {
            mJ = this.zJW;
        }
        aVar.ajC(new StringBuffer(ast(str)).append(mJ).toString());
        AppMethodBeat.o(35170);
    }

    private String ast(String str) {
        AppMethodBeat.i(35171);
        aw.ZK();
        ad aoM = c.XM().aoM(str);
        String string = getResources().getString(R.string.qy);
        if (aoM == null) {
            AppMethodBeat.o(35171);
        } else {
            if (t.kv(aoM.field_verifyFlag)) {
                string = getResources().getString(R.string.qx);
            } else if (ad.aox(str)) {
                string = c(this, aoM);
            } else {
                string = getResources().getString(R.string.qy);
            }
            AppMethodBeat.o(35171);
        }
        return string;
    }

    public static String c(Context context, ad adVar) {
        String string;
        AppMethodBeat.i(35172);
        if (TextUtils.isEmpty(((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.b.class)).a(adVar.field_openImAppid, "openim_card_type_name", com.tencent.mm.openim.a.b.a.TYPE_WORDING))) {
            string = context.getResources().getString(R.string.qy);
        } else {
            string = String.format("[%s]", new Object[]{((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.b.class)).a(adVar.field_openImAppid, "openim_card_type_name", com.tencent.mm.openim.a.b.a.TYPE_WORDING)});
        }
        AppMethodBeat.o(35172);
        return string;
    }

    private void a(Intent intent, Intent intent2) {
        AppMethodBeat.i(35173);
        ab.d("MicroMsg.SelectConversationUI", "has next step, jump now, intent=".concat(String.valueOf(intent2)));
        intent2.putExtras(intent.getExtras());
        startActivityForResult(intent2, 2);
        com.tencent.mm.ui.base.b.K(this.mController.ylL, intent2);
        AppMethodBeat.o(35173);
    }

    private void t(final Intent intent, final String str) {
        AppMethodBeat.i(35174);
        if (asq(str)) {
            AppMethodBeat.o(35174);
        } else if (s.hr(this.gnI, 256)) {
            k(-1, intent);
            finish();
            AppMethodBeat.o(35174);
        } else if (ah.isNullOrNil(str)) {
            ab.v("MicroMsg.SelectConversationUI", "avatarUseName is null or nil show dialog fail ");
            AppMethodBeat.o(35174);
        } else {
            if (t.kH(str)) {
                int mA = com.tencent.mm.model.n.mA(str);
                if (!this.zJU || mA <= ah.getInt(com.tencent.mm.m.g.Nu().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50)) {
                    getString(R.string.e1l, new Object[]{Integer.valueOf(mA)});
                } else {
                    ab.w("MicroMsg.SelectConversationUI", "summerbig SelectConversationUI group limit[%d], count[%d]", Integer.valueOf(ah.getInt(com.tencent.mm.m.g.Nu().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50)), Integer.valueOf(mA));
                    h.b((Context) this, getString(R.string.e1n, new Object[]{Integer.valueOf(r1)}), "", true);
                    AppMethodBeat.o(35174);
                    return;
                }
            }
            com.tencent.mm.pluginsdk.ui.applet.g.a aVar = new com.tencent.mm.pluginsdk.ui.applet.g.a(this.mController.ylL);
            aVar.cx(str);
            final String str2;
            if (this.zoG) {
                a(aVar, this.zJV);
                if (t.kH(str)) {
                    c(intent, this.zJV, str);
                } else {
                    b(intent, this.zJV, str);
                }
                aVar.h(Boolean.TRUE);
            } else if (this.zJN) {
                if (this.cvv != -1) {
                    b(aVar);
                    gf gfVar = new gf();
                    gfVar.cAC.cvv = this.cvv;
                    gfVar.cAC.cAD = aVar;
                    gfVar.cAC.cAE = this.zKd;
                    gfVar.cAC.csX = this.mController.ylL;
                    com.tencent.mm.sdk.b.a.xxA.m(gfVar);
                } else if (this.msgType == 17 && this.zJT != 0) {
                    aVar.ajC(new StringBuffer(getResources().getString(R.string.rp)).append(this.mController.ylL.getString(R.string.dr3, new Object[]{Integer.valueOf(this.zJT)})).toString());
                }
                aVar.h(Boolean.TRUE);
            } else if (this.zJO) {
                HashMap hashMap = (HashMap) getIntent().getSerializableExtra("webview_params");
                String str3 = (String) hashMap.get("img_url");
                String str4 = (String) hashMap.get("title");
                str2 = (String) hashMap.get("url");
                aVar.ajC(new StringBuffer(getResources().getString(R.string.u9)).append(str4).toString());
                aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                    public final void bwF() {
                        AppMethodBeat.i(35150);
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str2);
                        intent.putExtra("showShare", false);
                        com.tencent.mm.bp.d.b(SelectConversationUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.o(35150);
                    }
                });
                aVar.ajD(str3).djx();
                aVar.h(Boolean.TRUE);
            } else if (this.zJP && a(intent, aVar)) {
                AppMethodBeat.o(35174);
                return;
            } else if (this.zJR) {
                str2 = getResources().getString(R.string.r1);
                if (this.kcC != null) {
                    str2 = new StringBuffer(str2).append(this.kcC).toString();
                }
                aVar.ajC(str2);
                aVar.h(Boolean.FALSE);
            } else {
                a(aVar);
                b(aVar);
                aVar.h(Boolean.TRUE);
            }
            aVar.KQ(R.string.tf).a(new com.tencent.mm.pluginsdk.ui.applet.q.a() {
                public final void a(boolean z, String str, int i) {
                    AppMethodBeat.i(35151);
                    SelectConversationUI.this.aqX();
                    boolean booleanExtra = intent.getBooleanExtra("need_delete_chatroom_when_cancel", false);
                    if (booleanExtra) {
                        int i2;
                        if (z) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        ab.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomOperation %d %d", Integer.valueOf(13943), Integer.valueOf(i2));
                        com.tencent.mm.plugin.report.service.h.pYm.e(13943, Integer.valueOf(i2));
                    }
                    if (z) {
                        intent.putExtra("custom_send_text", str);
                        SelectConversationUI.a(SelectConversationUI.this, -1, intent);
                        l.hK(SelectConversationUI.this.cJh, str);
                        SelectConversationUI.this.finish();
                        AppMethodBeat.o(35151);
                        return;
                    }
                    if (booleanExtra) {
                        String stringExtra = intent.getStringExtra("Select_Contact");
                        aw.ZK();
                        c.XR().aoX(stringExtra);
                    }
                    AppMethodBeat.o(35151);
                }
            }).gud.show();
            AppMethodBeat.o(35174);
        }
    }

    private boolean a(Intent intent, com.tencent.mm.pluginsdk.ui.applet.g.a aVar) {
        AppMethodBeat.i(35175);
        HashMap hashMap = (HashMap) getIntent().getSerializableExtra("appbrand_params");
        if (ce.bc(hashMap.get("is_weishi_video"))) {
            boolean a = a(aVar, hashMap);
            AppMethodBeat.o(35175);
            return a;
        }
        int i = ce.getInt(hashMap.get("type"), 1);
        String e = ce.e(hashMap.get("title"), "");
        String e2 = ce.e(hashMap.get("img_url"), null);
        if (i == 2 || i == 3) {
            String e3 = ce.e(hashMap.get("app_id"), null);
            int i2 = ce.getInt(hashMap.get("pkg_type"), 0);
            int i3 = ce.getInt(hashMap.get("pkg_version"), 0);
            String e4 = ce.e(hashMap.get("cache_key"), null);
            String e5 = ce.e(hashMap.get("path"), null);
            String e6 = ce.e(hashMap.get("delay_load_img_path"), null);
            String e7 = ce.e(hashMap.get("nickname"), "");
            boolean bc = ce.bc(hashMap.get("is_dynamic"));
            Bundle bundle = null;
            int i4 = ce.getInt(hashMap.get("biz"), j.a.BUSINESS_MAX.ordinal());
            if (j.a.isValid(i4)) {
                String e8 = ce.e(hashMap.get("tail_lang"), "");
                String e9 = ce.e(hashMap.get("icon_url"), "");
                Bundle bundle2 = new Bundle();
                bundle2.putInt("key_biz", i4);
                bundle2.putString("key_footer_text_default", e7);
                bundle2.putString("key_footer_text", j.a.b(i4, e8, this.mController.ylL));
                bundle2.putString("key_footer_icon", e9);
                ab.d("MicroMsg.SelectConversationUI", "defaultFooterTxt: %s, tailLang: %s.", e7, e8);
                bundle = bundle2;
            } else {
                ab.w("MicroMsg.SelectConversationUI", "fake native share msg biz invalidate, biz: %d.", Integer.valueOf(i4));
            }
            final View d = ((com.tencent.mm.modelappbrand.i) com.tencent.mm.kernel.g.K(com.tencent.mm.modelappbrand.i.class)).d((Context) this, bundle);
            e7 = com.tencent.mm.plugin.appbrand.r.n.bE(this);
            Bundle bundle3 = new Bundle();
            bundle3.putString("app_id", e3);
            bundle3.putString("msg_id", String.format("%d-%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
            bundle3.putInt("msg_pkg_type", i2);
            bundle3.putInt("pkg_version", i3);
            bundle3.putString(MessengerShareContentUtility.IMAGE_URL, e2);
            bundle3.putBoolean("is_dynamic_page", bc);
            bundle3.putString("title", e);
            bundle3.putString("cache_key", e4);
            bundle3.putString("msg_path", e5);
            bundle3.putString("delay_load_img_path", e6);
            final e eVar = new e(this);
            final Intent intent2 = intent;
            eVar.zKR = new a() {
                public final void z(boolean z, String str) {
                    AppMethodBeat.i(35152);
                    if (z) {
                        intent2.putExtra("custom_send_text", str);
                        SelectConversationUI.a(SelectConversationUI.this, -1, intent2);
                        SelectConversationUI.this.finish();
                    } else {
                        SelectConversationUI.a(SelectConversationUI.this, 0, intent2);
                        SelectConversationUI.this.finish();
                    }
                    ((com.tencent.mm.modelappbrand.i) com.tencent.mm.kernel.g.K(com.tencent.mm.modelappbrand.i.class)).a(e7, d);
                    AppMethodBeat.o(35152);
                }
            };
            ((com.tencent.mm.modelappbrand.i) com.tencent.mm.kernel.g.K(com.tencent.mm.modelappbrand.i.class)).a(e7, d, bundle3, new com.tencent.mm.modelappbrand.i.b() {
                public final void kQ(int i) {
                    AppMethodBeat.i(35125);
                    ab.i("MicroMsg.SelectConversationUI", "onLoadImageResult() result:%d", Integer.valueOf(i));
                    e eVar = eVar;
                    eVar.iHk = true;
                    if (eVar.oC()) {
                        al.af(eVar.hEw);
                        eVar.aMl();
                    }
                    AppMethodBeat.o(35125);
                }
            });
            aVar.ev(d);
            aVar.h(Boolean.TRUE);
            aVar.djy();
            aVar.jbD = new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(35126);
                    ((com.tencent.mm.modelappbrand.i) com.tencent.mm.kernel.g.K(com.tencent.mm.modelappbrand.i.class)).a(e7, d);
                    AppMethodBeat.o(35126);
                }
            };
            aVar.KQ(R.string.tf).a(new com.tencent.mm.pluginsdk.ui.applet.q.a() {
                public final void a(boolean z, String str, int i) {
                    AppMethodBeat.i(35127);
                    SelectConversationUI.this.aqX();
                    e eVar = eVar;
                    eVar.iHj = true;
                    eVar.iHl = z;
                    eVar.text = str;
                    eVar.iHm = i;
                    if (eVar.oC()) {
                        eVar.aMl();
                        AppMethodBeat.o(35127);
                        return;
                    }
                    if (z) {
                        eVar.tipDialog = h.b(eVar.context, eVar.context.getString(R.string.e3l), true, null);
                        al.n(eVar.hEw, 5000);
                    }
                    AppMethodBeat.o(35127);
                }
            }).gud.show();
            AppMethodBeat.o(35175);
            return true;
        }
        aVar.ajC(new StringBuffer(getResources().getString(R.string.ho)).append(e).toString());
        aVar.ajD(e2).djx();
        aVar.h(Boolean.TRUE);
        AppMethodBeat.o(35175);
        return false;
    }

    private boolean a(com.tencent.mm.pluginsdk.ui.applet.g.a aVar, HashMap<String, Object> hashMap) {
        AppMethodBeat.i(35176);
        final String e = ce.e(hashMap.get("img_url"), null);
        if (ah.isNullOrNil(e)) {
            String e2 = ce.e(hashMap.get("msg_img_path"), null);
            if (!ah.isNullOrNil(e2)) {
                ab.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, imageUrl:%s, msgImgPath:%s", e, e2);
                aVar.b(asu(e2), 2);
            }
        } else {
            RelativeLayout relativeLayout = new RelativeLayout(this);
            View inflate = LayoutInflater.from(this).inflate(R.layout.pm, null);
            relativeLayout.addView(inflate, new LayoutParams(-2, -2));
            ((LayoutParams) inflate.getLayoutParams()).addRule(14);
            final ImageView imageView = (ImageView) inflate.findViewById(R.id.b04);
            ((ImageView) inflate.findViewById(R.id.b07)).setImageResource(R.raw.video_icon_in_gird);
            aVar.ev(relativeLayout);
            aVar.djy();
            com.tencent.mm.modelappbrand.a.b.abR().a(new com.tencent.mm.modelappbrand.a.b.i() {
                public final void abU() {
                }

                public final void x(Bitmap bitmap) {
                    AppMethodBeat.i(35128);
                    if (!(SelectConversationUI.this.isFinishing() || bitmap == null || bitmap.isRecycled() || imageView == null)) {
                        imageView.setImageBitmap(ag.d(SelectConversationUI.a(SelectConversationUI.this, bitmap, imageView, bitmap.getWidth(), bitmap.getHeight()), (float) aj.fromDPToPix(SelectConversationUI.this, 3)));
                    }
                    AppMethodBeat.o(35128);
                }

                public final void mr() {
                    AppMethodBeat.i(35129);
                    ab.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, image load fail:%", e);
                    AppMethodBeat.o(35129);
                }

                public final String wP() {
                    return "SelectConversationUI#WEISHITHUMB";
                }
            }, e, null, null);
        }
        aVar.h(Boolean.TRUE);
        AppMethodBeat.o(35176);
        return false;
    }

    private void a(com.tencent.mm.pluginsdk.ui.applet.g.a aVar) {
        AppMethodBeat.i(35177);
        int orientationInDegree;
        switch (this.msgType) {
            case 0:
            case 16:
                Bitmap dKl = dKl();
                if (dKl == null && this.imagePath != null) {
                    Bitmap j = com.tencent.mm.sdk.platformtools.d.j(this.imagePath, com.tencent.mm.bz.a.getDensity(com.tencent.mm.sdk.platformtools.ah.getContext()));
                    orientationInDegree = Exif.fromFile(this.imagePath).getOrientationInDegree();
                    if (orientationInDegree < 0) {
                        orientationInDegree = 0;
                    }
                    dKl = com.tencent.mm.sdk.platformtools.d.b(j, (float) orientationInDegree);
                }
                aVar.b(dKl, 3);
                AppMethodBeat.o(35177);
                return;
            case 1:
                aVar.b(dKk(), 2);
                AppMethodBeat.o(35177);
                return;
            case 2:
            case 10:
                j.b X;
                j.b me = j.b.me(bo.anj(this.cJh));
                if (this.cKd.drC() && me == null) {
                    X = j.b.X(bo.anj(this.cJh), bo.anj(this.cJh));
                } else {
                    X = me;
                }
                String string;
                if (X == null) {
                    if (this.zKc != null) {
                        string = getResources().getString(R.string.ud);
                        aVar.ajC(new StringBuffer(string).append(this.zKc).toString());
                    }
                    AppMethodBeat.o(35177);
                    return;
                }
                String string2;
                string = X.title;
                if (com.tencent.mm.ui.chatting.l.f(this.cKd, this.zeC)) {
                    string2 = getResources().getString(R.string.ho);
                } else if (X.type == 5) {
                    string2 = getResources().getString(R.string.u9);
                } else if (X.type == 6) {
                    string2 = getResources().getString(R.string.qr);
                } else if (X.type == 24) {
                    string2 = getResources().getString(R.string.s5);
                    string = i(X);
                } else if (X.type == 19) {
                    string2 = getResources().getString(R.string.t5);
                } else if (X.type == 3) {
                    string2 = getResources().getString(R.string.rs);
                } else if (X.type == 4) {
                    string2 = getResources().getString(R.string.ud);
                } else if (X.type == 8) {
                    string2 = getResources().getString(R.string.pj);
                } else if (X.type != 33 && X.type != 36 && X.type != 44) {
                    string2 = getResources().getString(R.string.fy);
                } else if (X.fiR == 2 || X.fiR == 3 || X.type == 36) {
                    Bundle bundle;
                    int i = X.fiW;
                    if (X.cw(false)) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("key_biz", i);
                        bundle2.putString("key_footer_text_default", X.cMh);
                        bundle2.putString("key_footer_text", X.p(this.mController.ylL, false));
                        bundle2.putString("key_footer_icon", X.fjb);
                        bundle = bundle2;
                    } else {
                        ab.w("MicroMsg.SelectConversationUI", "fake native share msg biz invalidate, biz: %d.", Integer.valueOf(i));
                        bundle = null;
                    }
                    final View d = ((com.tencent.mm.modelappbrand.i) com.tencent.mm.kernel.g.K(com.tencent.mm.modelappbrand.i.class)).d((Context) this, bundle);
                    aVar.ev(d);
                    aVar.h(Boolean.TRUE);
                    aVar.djy();
                    string = com.tencent.mm.at.o.ahl().c(this.cKd.field_imgPath, false, true);
                    final String bE = com.tencent.mm.plugin.appbrand.r.n.bE(this);
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("app_id", X.fiQ);
                    bundle3.putString("msg_id", String.format("%d-%d", new Object[]{Integer.valueOf(X.fiZ), Integer.valueOf(X.fiT)}));
                    bundle3.putInt("msg_pkg_type", X.fiZ);
                    bundle3.putInt("pkg_version", X.fiT);
                    if (!bo.isNullOrNil(string)) {
                        bundle3.putString(MessengerShareContentUtility.IMAGE_URL, "file://".concat(String.valueOf(string)));
                    }
                    com.tencent.mm.af.a aVar2 = (com.tencent.mm.af.a) X.X(com.tencent.mm.af.a.class);
                    if (aVar2 != null) {
                        bundle3.putBoolean("is_dynamic_page", aVar2.feY);
                        bundle3.putString("cache_key", aVar2.feZ);
                    }
                    bundle3.putString("title", X.title);
                    bundle3.putString("msg_path", X.fiO);
                    ((com.tencent.mm.modelappbrand.i) com.tencent.mm.kernel.g.K(com.tencent.mm.modelappbrand.i.class)).a(bE, d, bundle3);
                    aVar.jbD = new OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            AppMethodBeat.i(35130);
                            ((com.tencent.mm.modelappbrand.i) com.tencent.mm.kernel.g.K(com.tencent.mm.modelappbrand.i.class)).a(bE, d);
                            AppMethodBeat.o(35130);
                        }
                    };
                    AppMethodBeat.o(35177);
                    return;
                } else {
                    string2 = getResources().getString(R.string.ho);
                }
                if (X.type == 46) {
                    aVar.b(dKl(), 2);
                    AppMethodBeat.o(35177);
                    return;
                }
                if (string == null) {
                    string = "";
                }
                aVar.ajC(string2 + string);
                if (X.thumburl != null) {
                    aVar.ajD(X.thumburl).djx();
                    AppMethodBeat.o(35177);
                    return;
                }
                break;
            case 3:
                if (this.kcC != null) {
                    aVar.ajC(new StringBuffer(getResources().getString(R.string.qr)).append(this.kcC).toString());
                    break;
                }
                break;
            case 4:
                aVar.ajC(this.cJh);
                aVar.djw();
                AppMethodBeat.o(35177);
                return;
            case 5:
                if (!bo.isNullOrNil(this.lgZ)) {
                    aVar.ajE(this.lgZ);
                    AppMethodBeat.o(35177);
                    return;
                } else if (bo.isNullOrNil(this.cKd.field_imgPath)) {
                    aVar.ajE(this.imagePath);
                    AppMethodBeat.o(35177);
                    return;
                } else {
                    aVar.ajE(this.cKd.field_imgPath);
                    AppMethodBeat.o(35177);
                    return;
                }
            case 8:
                aw.ZK();
                bi.a Rn = c.XO().Rn(this.cJh);
                this.zJV = Rn.svN;
                this.zJW = Rn.nickname;
                this.zJX = Boolean.valueOf(t.kv(Rn.ufB));
                a(aVar, this.zJV);
                AppMethodBeat.o(35177);
                return;
            case 9:
                aVar.ajC(dKj());
                AppMethodBeat.o(35177);
                return;
            case 11:
                aVar.b(dKk(), 2);
                AppMethodBeat.o(35177);
                return;
            case 12:
                nt hS = k.hS(this.mController.ylL);
                if (hS.cJY.cKe != null) {
                    orientationInDegree = hS.cJY.cKe.size();
                } else {
                    orientationInDegree = 0;
                }
                aVar.ajC(new StringBuffer(getResources().getString(R.string.rp)).append(this.mController.ylL.getString(R.string.dr3, new Object[]{Integer.valueOf(orientationInDegree)})).toString());
                AppMethodBeat.o(35177);
                return;
            case 13:
                aVar.ajC(new StringBuffer(getResources().getString(R.string.rq)).append(ah.bc(k.hS(this.mController.ylL).cJZ.cKh.title, "")).toString());
                AppMethodBeat.o(35177);
                return;
        }
        AppMethodBeat.o(35177);
    }

    private void b(com.tencent.mm.pluginsdk.ui.applet.g.a aVar) {
        AppMethodBeat.i(35178);
        switch (this.msgType) {
            case 0:
            case 1:
            case 11:
            case 16:
                aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                    public final void bwF() {
                        AppMethodBeat.i(35132);
                        Intent intent = new Intent(SelectConversationUI.this.mController.ylL, ImageGalleryUI.class);
                        intent.putExtra("img_gallery_msg_id", SelectConversationUI.this.cvx);
                        intent.putExtra("img_gallery_msg_svr_id", SelectConversationUI.this.cKd.field_msgSvrId);
                        intent.putExtra("img_gallery_talker", SelectConversationUI.this.cKd.field_talker);
                        intent.putExtra("img_gallery_chatroom_name", SelectConversationUI.this.cKd.field_talker);
                        intent.putExtra("img_preview_only", true);
                        SelectConversationUI.this.startActivity(intent);
                        com.tencent.mm.ui.base.b.hL(SelectConversationUI.this.mController.ylL);
                        AppMethodBeat.o(35132);
                    }
                });
                AppMethodBeat.o(35178);
                return;
            case 2:
            case 10:
                final j.b me = j.b.me(bo.anj(this.cJh));
                if (me == null) {
                    AppMethodBeat.o(35178);
                    return;
                } else if (me.type == 5 && !com.tencent.mm.ui.chatting.l.f(this.cKd, this.zeC)) {
                    final String str = me.url;
                    aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                        public final void bwF() {
                            AppMethodBeat.i(35134);
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("showShare", false);
                            com.tencent.mm.bp.d.b(SelectConversationUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                            AppMethodBeat.o(35134);
                        }
                    });
                    AppMethodBeat.o(35178);
                    return;
                } else if (me.type == 6) {
                    aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                        public final void bwF() {
                            AppMethodBeat.i(35135);
                            Intent intent = new Intent();
                            intent.setClassName(SelectConversationUI.this.mController.ylL, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                            intent.putExtra("app_msg_id", SelectConversationUI.this.cvx);
                            intent.putExtra("app_show_share", false);
                            SelectConversationUI.this.startActivity(intent);
                            AppMethodBeat.o(35135);
                        }
                    });
                    AppMethodBeat.o(35178);
                    return;
                } else if (me.type == 24) {
                    aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                        public final void bwF() {
                            AppMethodBeat.i(35137);
                            lz lzVar = new lz();
                            lzVar.cHO.context = SelectConversationUI.this.mController.ylL;
                            lzVar.cHO.cvx = SelectConversationUI.this.cvx;
                            lzVar.cHO.cHP = me.fgU;
                            lzVar.cHO.cHc = false;
                            lzVar.cHO.scene = 7;
                            com.tencent.mm.sdk.b.a.xxA.m(lzVar);
                            AppMethodBeat.o(35137);
                        }
                    });
                    AppMethodBeat.o(35178);
                    return;
                } else if (me.type == 19) {
                    aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                        public final void bwF() {
                            AppMethodBeat.i(35138);
                            Intent intent = new Intent();
                            intent.putExtra("message_id", SelectConversationUI.this.cvx);
                            intent.putExtra("record_xml", me.fgU);
                            intent.putExtra("record_show_share", false);
                            com.tencent.mm.bp.d.b(SelectConversationUI.this.mController.ylL, "record", ".ui.RecordMsgDetailUI", intent);
                            AppMethodBeat.o(35138);
                        }
                    });
                    AppMethodBeat.o(35178);
                    return;
                } else if (me.type == 3) {
                    aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                        public final void bwF() {
                            AppMethodBeat.i(35139);
                            String B = p.B(me.url, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                            String B2 = p.B(me.fgn, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                            if (at.isMobile(SelectConversationUI.this.mController.ylL) ? B2 != null && B2.length() > 0 : B == null || B.length() <= 0) {
                                B = B2;
                            }
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", B);
                            intent.putExtra("showShare", false);
                            com.tencent.mm.bp.d.b(SelectConversationUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                            AppMethodBeat.o(35139);
                        }
                    });
                    AppMethodBeat.o(35178);
                    return;
                } else if (me.type == 4) {
                    aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                        public final void bwF() {
                        }
                    });
                    AppMethodBeat.o(35178);
                    return;
                }
                break;
            case 3:
                aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                    public final void bwF() {
                        AppMethodBeat.i(35141);
                        Intent intent = new Intent();
                        intent.setClassName(SelectConversationUI.this.mController.ylL, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                        intent.putExtra("app_msg_id", SelectConversationUI.this.cvx);
                        intent.putExtra("app_show_share", false);
                        SelectConversationUI.this.startActivity(intent);
                        AppMethodBeat.o(35141);
                    }
                });
                break;
            case 4:
                aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                    public final void bwF() {
                        AppMethodBeat.i(35131);
                        Intent intent = new Intent(SelectConversationUI.this.mController.ylL, RetransmitPreviewUI.class);
                        intent.putExtra("Retr_Msg_content", SelectConversationUI.this.cJh);
                        SelectConversationUI.this.startActivity(intent);
                        com.tencent.mm.ui.base.b.hL(SelectConversationUI.this.mController.ylL);
                        AppMethodBeat.o(35131);
                    }
                });
                AppMethodBeat.o(35178);
                return;
            case 9:
                aw.ZK();
                final bi.b Ro = c.XO().Ro(this.cJh);
                final String str2 = Ro.label;
                aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                    public final void bwF() {
                        AppMethodBeat.i(35133);
                        Intent intent = new Intent();
                        intent.putExtra("map_view_type", 1);
                        intent.putExtra("kwebmap_slat", Ro.nJu);
                        intent.putExtra("kwebmap_lng", Ro.nJv);
                        intent.putExtra("Kwebmap_locaion", str2);
                        intent.putExtra("kShowshare", false);
                        com.tencent.mm.bp.d.b(SelectConversationUI.this.mController.ylL, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent);
                        AppMethodBeat.o(35133);
                    }
                });
                AppMethodBeat.o(35178);
                return;
            case 12:
                k.hS(this.mController.ylL);
                AppMethodBeat.o(35178);
                return;
            case 13:
                aVar.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                    public final void bwF() {
                        AppMethodBeat.i(35140);
                        nt hS = k.hS(SelectConversationUI.this.mController.ylL);
                        j.b me = j.b.me(bo.anj(com.tencent.mm.plugin.record.b.n.a(hS.cJZ.cKh.title, hS.cJZ.cKh.desc, hS.cJZ.cJy.cvA.cvC, hS.cJY.cKf)));
                        if (me == null) {
                            AppMethodBeat.o(35140);
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("message_id", SelectConversationUI.this.cvx);
                        intent.putExtra("record_xml", me.fgU);
                        intent.putExtra("record_show_share", false);
                        com.tencent.mm.bp.d.b(SelectConversationUI.this.mController.ylL, "record", ".ui.RecordMsgDetailUI", intent);
                        AppMethodBeat.o(35140);
                    }
                });
                AppMethodBeat.o(35178);
                return;
        }
        AppMethodBeat.o(35178);
    }

    private String dKj() {
        AppMethodBeat.i(35179);
        aw.ZK();
        bi.b Ro = c.XO().Ro(this.cJh);
        String str = "";
        if (Ro != null) {
            str = Ro.label;
        }
        str = this.mController.ylL.getString(R.string.rf) + str;
        AppMethodBeat.o(35179);
        return str;
    }

    private Bitmap dKk() {
        AppMethodBeat.i(35180);
        com.tencent.mm.modelvideo.o.all();
        String ui = com.tencent.mm.modelvideo.t.ui(this.cKd.field_imgPath);
        if (ui == null) {
            ui = this.imagePath;
        }
        Bitmap aml = com.tencent.mm.sdk.platformtools.d.aml(ui);
        AppMethodBeat.o(35180);
        return aml;
    }

    private Bitmap dKl() {
        AppMethodBeat.i(35181);
        if (this.cKd == null) {
            AppMethodBeat.o(35181);
            return null;
        }
        String str = this.cKd.field_imgPath;
        Bitmap sk = com.tencent.mm.at.o.ahl().sk(str);
        if (sk != null) {
            try {
                int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
                if (orientationInDegree < 0) {
                    orientationInDegree = 0;
                }
                sk = com.tencent.mm.sdk.platformtools.d.b(sk, (float) orientationInDegree);
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.SelectConversationUI", th, "unexpected exception.", new Object[0]);
            }
        }
        AppMethodBeat.o(35181);
        return sk;
    }

    private static Bitmap asu(String str) {
        AppMethodBeat.i(35182);
        Bitmap sk = com.tencent.mm.at.o.ahl().sk(str);
        if (sk != null) {
            try {
                int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
                if (orientationInDegree < 0) {
                    orientationInDegree = 0;
                }
                sk = com.tencent.mm.sdk.platformtools.d.b(sk, (float) orientationInDegree);
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.SelectConversationUI", th, "unexpected exception.", new Object[0]);
            }
        }
        AppMethodBeat.o(35182);
        return sk;
    }

    public static Bitmap a(Context context, Bitmap bitmap, ImageView imageView, int i, int i2) {
        AppMethodBeat.i(35183);
        Bitmap bitmap2 = null;
        float f = ((float) i2) / ((float) i);
        int i3 = 0;
        int i4 = 0;
        int am = aj.am(context, R.dimen.fl);
        int am2 = aj.am(context, R.dimen.fk);
        int i5 = 0;
        int i6 = 0;
        if (f > 0.0f && ((double) f) < 0.5d) {
            i4 = (int) (((float) am) / f);
            i6 = am;
            i5 = am2;
            i3 = am;
        } else if (((double) f) >= 0.5d && f < 1.0f) {
            am = (int) (((float) am2) * f);
            i6 = am;
            i5 = am2;
            i4 = am2;
            i3 = am;
        } else if (f >= 1.0f && f < 2.0f) {
            am = (int) (((float) am2) / f);
            i6 = am2;
            i5 = am;
            i4 = am;
            i3 = am2;
        } else if (f >= 2.0f) {
            i3 = (int) (((float) am) * f);
            i6 = am2;
            i5 = am;
            i4 = am;
        }
        if (i3 > 0 && i4 > 0 && bitmap != null) {
            bitmap2 = Bitmap.createScaledBitmap(bitmap, i4, i3, true);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(i5, i6));
        }
        AppMethodBeat.o(35183);
        return bitmap2;
    }

    private static String i(j.b bVar) {
        AppMethodBeat.i(35184);
        nt ntVar = new nt();
        ntVar.cJY.type = 0;
        ntVar.cJY.cKa = bVar.fgU;
        com.tencent.mm.sdk.b.a.xxA.m(ntVar);
        String replaceAll = bo.bc(ntVar.cJZ.cKi.desc, bVar.description).replaceAll(IOUtils.LINE_SEPARATOR_UNIX, " ");
        AppMethodBeat.o(35184);
        return replaceAll;
    }

    private void dKm() {
        boolean z;
        AppMethodBeat.i(35185);
        ab.i("MicroMsg.SelectConversationUI", "doCallSelectContactUIForMultiRetransmit");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_type", 14);
        intent.putExtra("titile", getString(R.string.eu));
        intent.putExtra("list_attr", s.znK);
        intent.putExtra("already_select_contact", ah.c(this.zKa, ","));
        intent.putExtra("max_limit_num", 9);
        String str = "Forbid_SelectChatRoom";
        if (this.zoG && ad.aox(this.zJV)) {
            z = true;
        } else {
            z = false;
        }
        intent.putExtra(str, z);
        this.mController.ylL.startActivityForResult(intent, 5);
        AppMethodBeat.o(35185);
    }

    private void dKn() {
        boolean z = true;
        AppMethodBeat.i(35186);
        ab.i("MicroMsg.SelectConversationUI", "doSendCardOrQRCode2CallSelectContactUI");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_attr", s.znH);
        intent.putExtra("list_type", 3);
        intent.putExtra("be_send_card_name", this.zJV);
        intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
        intent.putExtra("Add_SendCard", true);
        intent.putExtra("titile", getString(R.string.eu));
        String str = "Forbid_SelectChatRoom";
        if (!(this.zoG && ad.aox(this.zJV))) {
            z = false;
        }
        intent.putExtra(str, z);
        this.mController.ylL.startActivityForResult(intent, 3);
        AppMethodBeat.o(35186);
    }

    private void dKo() {
        AppMethodBeat.i(35187);
        ab.i("MicroMsg.SelectConversationUI", "doCallSelectContactUI");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_type", 5);
        intent.putExtra("titile", getString(R.string.eu));
        if (((this.fromScene == 4 || this.fromScene == 9) && getIntent().getIntExtra("jsapi_select_mode", 0) == 1) || this.fromScene == 10) {
            intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
            intent.putExtra("list_attr", s.C(32, 16, 1, 2, 4, 16384));
        } else {
            intent.putExtra("list_attr", s.znJ);
        }
        this.mController.ylL.startActivityForResult(intent, 1);
        AppMethodBeat.o(35187);
    }

    public final boolean aox() {
        return false;
    }

    public final String aoy() {
        AppMethodBeat.i(35188);
        String stringExtra = getIntent().getStringExtra("Select_Conv_ui_title");
        if (stringExtra == null || stringExtra.length() <= 0) {
            stringExtra = getString(R.string.e1v);
            AppMethodBeat.o(35188);
            return stringExtra;
        }
        AppMethodBeat.o(35188);
        return stringExtra;
    }

    public final boolean aow() {
        return false;
    }

    public final void vI(String str) {
        AppMethodBeat.i(35190);
        this.zKa.remove(str);
        dHV().notifyDataSetChanged();
        Kt();
        AppMethodBeat.o(35190);
    }

    private void Kt() {
        AppMethodBeat.i(35191);
        if (!this.zJY) {
            AppMethodBeat.o(35191);
        } else if (this.zKa != null && this.zKa.size() > 0) {
            updateOptionMenuText(1, getString(R.string.tf) + "(" + this.zKa.size() + ")");
            a(1, this.zKi);
            enableOptionMenu(1, true);
            AppMethodBeat.o(35191);
        } else if (this.zJZ) {
            updateOptionMenuText(1, getString(R.string.tr));
            a(1, this.zKh);
            enableOptionMenu(1, true);
            AppMethodBeat.o(35191);
        } else {
            updateOptionMenuText(1, getString(R.string.rr));
            a(1, this.zKh);
            enableOptionMenu(1, true);
            AppMethodBeat.o(35191);
        }
    }

    private boolean qS(boolean z) {
        AppMethodBeat.i(35192);
        if (z ? this.zKa.size() >= 9 : this.zKa.size() > 9) {
            h.a(this.mController.ylL, getString(R.string.e1o, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", 9))}), getString(R.string.t6), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(35192);
            return true;
        }
        AppMethodBeat.o(35192);
        return false;
    }

    public final boolean dHZ() {
        return true;
    }

    public final int[] bMP() {
        AppMethodBeat.i(35193);
        int[] intArrayExtra = getIntent().getIntArrayExtra("search_range");
        if (this.fromScene == 4 || this.fromScene == 10) {
            intArrayExtra = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
            AppMethodBeat.o(35193);
            return intArrayExtra;
        } else if (intArrayExtra != null) {
            AppMethodBeat.o(35193);
            return intArrayExtra;
        } else {
            intArrayExtra = super.bMP();
            AppMethodBeat.o(35193);
            return intArrayExtra;
        }
    }

    private void k(int i, Intent intent) {
        AppMethodBeat.i(35194);
        if (this.msgType == 5) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra("emoji_thumb_path", this.lgZ);
            intent.putExtra("emoji_activity_id", getIntent().getStringExtra("emoji_activity_id"));
        }
        super.setResult(i, intent);
        AppMethodBeat.o(35194);
    }

    private void fy(List<String> list) {
        AppMethodBeat.i(35195);
        long currentTimeMillis = System.currentTimeMillis();
        int size = list.size();
        y nY = z.nY(getString(R.string.c_1));
        Cursor cursor = null;
        try {
            com.tencent.mm.kernel.g.RQ();
            cursor = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().d(nY.getType(), "", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ad adVar = new ad();
                adVar.d(cursor);
                list.add(adVar.field_username);
                cursor.moveToNext();
            }
            if (cursor != null) {
                cursor.close();
            }
            ab.i("MicroMsg.SelectConversationUI", "[fillBlockList] cost:%sms size:%s block size:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(size), Integer.valueOf(list.size() - size));
            AppMethodBeat.o(35195);
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            ab.i("MicroMsg.SelectConversationUI", "[fillBlockList] cost:%sms size:%s block size:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(size), Integer.valueOf(list.size() - size));
            AppMethodBeat.o(35195);
        }
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(35189);
        if (!aVar.zmW || aVar.ehM == null) {
            AppMethodBeat.o(35189);
            return false;
        }
        boolean contains = this.zKa.contains(aVar.ehM.field_username);
        AppMethodBeat.o(35189);
        return contains;
    }
}
