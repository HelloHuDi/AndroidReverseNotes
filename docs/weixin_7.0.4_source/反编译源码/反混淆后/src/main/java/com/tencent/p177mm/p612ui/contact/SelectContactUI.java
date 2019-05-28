package com.tencent.p177mm.p612ui.contact;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.Utility;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C32794m;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.openim.p1210a.C32873b.C32874a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C9022l;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C30777u.C30784a;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.contact.C36246c.C30666a;
import com.tencent.p177mm.p612ui.contact.p625a.C46674k;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C23275s.C23280a;
import com.tencent.p177mm.roomsdk.p1086a.C30262b;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C44205c;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C46609a;
import com.tencent.p177mm.roomsdk.p1086a.p1342c.C46610a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.contact.SelectContactUI */
public class SelectContactUI extends MMBaseSelectContactUI implements C1202f {
    private ProgressDialog ehJ;
    private List<String> elZ;
    private HashSet<String> gnG;
    private String jcF;
    private String nHU;
    private int requestCode;
    private String title;
    private int zkf;
    private TextView zoA;
    private TextView zoB;
    private TextView zoC;
    private TextView zoD;
    private TextView zoE;
    private TextView zoF;
    private boolean zoG;
    private boolean zoH;
    private String zoI;
    private String zoJ;
    private boolean zoK;
    private boolean zoL;
    private boolean zoM;
    private boolean zoN = false;
    private String zoO;
    private HashSet<String> zol;
    private int zon;
    private boolean zoo = true;
    private C15803a zop = new C15803a();

    /* renamed from: com.tencent.mm.ui.contact.SelectContactUI$2 */
    class C54412 implements OnMenuItemClickListener {
        C54412() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33851);
            ArrayList c = SelectContactUI.m48864c(SelectContactUI.this, C15830s.m24192hr(SelectContactUI.this.zon, Utility.DEFAULT_STREAM_BUFFER_SIZE));
            c.remove(C1853r.m3846Yz());
            boolean z = C15830s.m24192hr(SelectContactUI.this.zon, 4096) && c.size() > 1;
            if (z) {
                if (!SelectContactUI.this.zoL) {
                    SelectContactUI.this.zoL = true;
                    SelectContactUI.m48868e(SelectContactUI.this);
                }
                C4990ab.m7416i("MicroMsg.SelectContactUI", "Create the chatroom");
                AppMethodBeat.m2505o(33851);
                return true;
            }
            boolean b = SelectContactUI.m48862b(SelectContactUI.this, SelectContactUI.m48856a(SelectContactUI.this, C15830s.m24192hr(SelectContactUI.this.zon, Utility.DEFAULT_STREAM_BUFFER_SIZE)));
            AppMethodBeat.m2505o(33851);
            return b;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SelectContactUI$10 */
    class C1580010 implements C23280a {
        C1580010() {
        }

        /* renamed from: bD */
        public final void mo27248bD(boolean z) {
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SelectContactUI$12 */
    class C1580112 implements OnClickListener {
        C1580112() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33859);
            C7060h.pYm.mo8381e(11140, Integer.valueOf(0));
            C25985d.m41448H(SelectContactUI.this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
            AppMethodBeat.m2505o(33859);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SelectContactUI$a */
    static class C15803a {
        TextView iqU;
        private AlphaAnimation zoZ;
        private AlphaAnimation zpa;
        boolean zpb = false;

        /* renamed from: com.tencent.mm.ui.contact.SelectContactUI$a$2 */
        class C158042 implements AnimationListener {
            C158042() {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(33868);
                C15803a.this.iqU.setVisibility(8);
                AppMethodBeat.m2505o(33868);
            }
        }

        C15803a() {
        }

        /* renamed from: e */
        public final void mo28016e(final Activity activity, int i, int i2) {
            AppMethodBeat.m2504i(33869);
            if (i2 <= 0 || i != i2 + 1 || this.zpb) {
                if (i < i2) {
                    mo28015aw(activity);
                    this.zpb = false;
                }
                AppMethodBeat.m2505o(33869);
                return;
            }
            if (this.iqU == null) {
                this.iqU = (TextView) activity.findViewById(2131820905);
            }
            if (this.iqU.getVisibility() != 0) {
                this.iqU.setText(C25738R.string.drd);
                this.iqU.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(33867);
                        C15803a.this.zpb = true;
                        C15803a.this.mo28015aw(activity);
                        AppMethodBeat.m2505o(33867);
                    }
                });
                if (this.zoZ == null) {
                    this.zoZ = new AlphaAnimation(0.0f, 1.0f);
                }
                this.zoZ.setDuration(300);
                if (this.zpa != null) {
                    this.zpa.cancel();
                }
                this.iqU.setVisibility(0);
                this.iqU.startAnimation(this.zoZ);
            }
            AppMethodBeat.m2505o(33869);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: aw */
        public final void mo28015aw(Activity activity) {
            AppMethodBeat.m2504i(33870);
            if (this.iqU == null) {
                this.iqU = (TextView) activity.findViewById(2131820905);
            }
            if (this.iqU.getVisibility() == 8) {
                AppMethodBeat.m2505o(33870);
                return;
            }
            if (this.zpa == null) {
                this.zpa = new AlphaAnimation(1.0f, 0.0f);
                this.zpa.setAnimationListener(new C158042());
            }
            this.zpa.setDuration(300);
            if (this.zoZ != null) {
                this.zoZ.cancel();
            }
            this.iqU.startAnimation(this.zpa);
            AppMethodBeat.m2505o(33870);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SelectContactUI$11 */
    class C3063911 implements OnClickListener {
        C3063911() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33858);
            Intent intent = new Intent();
            intent.setClassName(SelectContactUI.this, "com.tencent.mm.ui.contact.GroupCardSelectUI");
            intent.putExtra("group_select_type", true);
            boolean hr = C15830s.m24192hr(SelectContactUI.this.zon, 16384);
            intent.putExtra("group_select_need_result", hr);
            if (!hr) {
                SelectContactUI.this.startActivity(intent);
                AppMethodBeat.m2505o(33858);
            } else if (SelectContactUI.this.zkf == 14) {
                intent.putExtra("group_multi_select", true);
                intent.putExtra("already_select_contact", C42252ah.m74611c(SelectContactUI.m48856a(SelectContactUI.this, true), ","));
                intent.putExtra("max_limit_num", SelectContactUI.this.getIntent().getIntExtra("max_limit_num", 9));
                SelectContactUI.this.startActivityForResult(intent, 4);
                AppMethodBeat.m2505o(33858);
            } else {
                SelectContactUI.this.startActivityForResult(intent, 0);
                AppMethodBeat.m2505o(33858);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SelectContactUI$18 */
    class C3064018 implements DialogInterface.OnClickListener {
        C3064018() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(33866);
            SelectContactUI.this.zoM = false;
            AppMethodBeat.m2505o(33866);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SelectContactUI$1 */
    class C306411 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.ui.contact.SelectContactUI$1$1 */
        class C157991 implements Runnable {
            C157991() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33849);
                SelectContactUI.this.moveTaskToBack(true);
                AppMethodBeat.m2505o(33849);
            }
        }

        C306411() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33850);
            SelectContactUI.this.aqX();
            SelectContactUI.this.finish();
            if (!SelectContactUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
                C5004al.m7442n(new C157991(), 80);
            }
            AppMethodBeat.m2505o(33850);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SelectContactUI$8 */
    class C306438 implements DialogInterface.OnClickListener {
        C306438() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SelectContactUI$13 */
    class C3064613 implements OnClickListener {
        C3064613() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33860);
            Intent intent = new Intent();
            intent.setClassName(SelectContactUI.this, "com.tencent.mm.ui.contact.GroupCardSelectUI");
            intent.putExtra("group_select_type", false);
            SelectContactUI.this.startActivityForResult(intent, 1);
            AppMethodBeat.m2505o(33860);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SelectContactUI$14 */
    class C3064714 implements OnClickListener {
        C3064714() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33861);
            Intent intent = new Intent();
            intent.putExtra("list_attr", 16384);
            C25985d.m41468b(SelectContactUI.this, "brandservice", ".ui.BrandServiceIndexUI", intent, 2);
            AppMethodBeat.m2505o(33861);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SelectContactUI$16 */
    class C3064916 implements OnClickListener {
        C3064916() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33864);
            Intent intent = new Intent(SelectContactUI.this.getIntent());
            intent.setClass(SelectContactUI.this.mController.ylL, OpenIMSelectContactUI.class);
            intent.removeExtra("titile");
            intent.putExtra("openim_appid", "3552365301");
            List arrayList = new ArrayList();
            Iterator it = SelectContactUI.this.gnG.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (C7616ad.aox(str)) {
                    arrayList.add(str);
                }
            }
            intent.putExtra("already_select_contact", C5046bo.m7536c(arrayList, ","));
            SelectContactUI.this.startActivityForResult(intent, 5);
            AppMethodBeat.m2505o(33864);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SelectContactUI() {
        AppMethodBeat.m2504i(33871);
        AppMethodBeat.m2505o(33871);
    }

    /* renamed from: c */
    static /* synthetic */ ArrayList m48864c(SelectContactUI selectContactUI, boolean z) {
        AppMethodBeat.m2504i(33901);
        ArrayList qG = selectContactUI.m48874qG(z);
        AppMethodBeat.m2505o(33901);
        return qG;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Kh */
    public final void mo7850Kh() {
        AppMethodBeat.m2504i(33872);
        super.mo7850Kh();
        this.zon = getIntent().getIntExtra("list_attr", C15830s.znD);
        this.title = getIntent().getStringExtra("titile");
        this.jcF = getIntent().getStringExtra("sub_title");
        this.zkf = getIntent().getIntExtra("list_type", -1);
        this.zoo = getIntent().getBooleanExtra("show_too_many_member", true);
        this.nHU = getIntent().getStringExtra("label_source");
        if (C15830s.m24192hr(this.zon, 256) && C1855t.m3872Zi().size() == 0) {
            C15830s.m24193hs(this.zon, 256);
        }
        this.zoG = getIntent().getBooleanExtra("Add_SendCard", false);
        this.zoH = getIntent().getBooleanExtra("recommend_friends", false);
        if (this.zoG || this.zoH) {
            this.zoI = C5046bo.m7532bc(getIntent().getStringExtra("be_send_card_name"), "");
            this.zoJ = C5046bo.m7532bc(getIntent().getStringExtra("received_card_name"), "");
        }
        this.zoK = getIntent().getBooleanExtra("Forbid_SelectChatRoom", false);
        this.elZ = new ArrayList();
        this.gnG = new HashSet();
        this.zol = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.zol.addAll(C5046bo.m7508P(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.gnG.addAll(C5046bo.m7508P(stringExtra.split(",")));
        }
        HashSet hashSet = new HashSet();
        String stringExtra2 = getIntent().getStringExtra("block_contact");
        if (!C5046bo.isNullOrNil(stringExtra2)) {
            hashSet.addAll(C5046bo.m7508P(stringExtra2.split(",")));
        }
        HashSet hashSet2 = new HashSet(hashSet);
        hashSet2.addAll(C15830s.dIf());
        hashSet2.addAll(C15830s.dIg());
        if (this.zoG) {
            hashSet2.removeAll(C15830s.dIf());
        }
        this.elZ.addAll(hashSet2);
        dIj();
        AppMethodBeat.m2505o(33872);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(33873);
        super.onCreate(bundle);
        C9638aw.m17182Rg().mo14539a(30, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(138, (C1202f) this);
        C4990ab.m7416i("MicroMsg.SelectContactUI", "create!");
        if (!C5046bo.isNullOrNil(this.jcF)) {
            setMMSubTitle(this.jcF);
        }
        if (C15830s.m24192hr(this.zon, 64)) {
            mo17379a(1, getString(C25738R.string.f9187s6), (OnMenuItemClickListener) new C54412(), C5535b.GREEN);
        }
        m48852Kt();
        setBackBtn(new C306411());
        if (this.zkf != 15) {
            Iterator it = this.gnG.iterator();
            while (it.hasNext()) {
                this.opo.mo69767bU((String) it.next(), false);
            }
        }
        AppMethodBeat.m2505o(33873);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(33874);
        C9638aw.m17182Rg().mo14546b(30, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(138, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(33874);
    }

    /* renamed from: mO */
    public final void mo7859mO(int i) {
        AppMethodBeat.m2504i(33875);
        int headerViewsCount = i - getContentLV().getHeaderViewsCount();
        if (headerViewsCount < 0) {
            C4990ab.m7417i("MicroMsg.SelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", Integer.valueOf(headerViewsCount), Integer.valueOf(i));
            AppMethodBeat.m2505o(33875);
            return;
        }
        C5445a Pn = dHV().getItem(headerViewsCount);
        if (Pn == null) {
            AppMethodBeat.m2505o(33875);
        } else if (Pn instanceof C46674k) {
            if (C15830s.m24192hr(this.zon, 16384)) {
                C4990ab.m7416i("MicroMsg.SelectContactUI", "handleClickNonSelect, return the result");
                Intent intent = new Intent();
                String str = "";
                intent.putExtra("Select_Contact", str);
                intent.putExtra("Select_Conv_User", str);
                intent.putExtra("Select_Contact", str);
                setResult(-1, intent);
                finish();
            }
            AppMethodBeat.m2505o(33875);
        } else if (Pn.ehM == null) {
            AppMethodBeat.m2505o(33875);
        } else if (Pn.ehM.field_deleteFlag == 1) {
            AppMethodBeat.m2505o(33875);
        } else {
            String str2 = Pn.ehM.field_username;
            C4990ab.m7417i("MicroMsg.SelectContactUI", "ClickUser=%s", str2);
            if (C15830s.m24192hr(this.zon, 64)) {
                if (!C15830s.m24192hr(this.zon, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) || this.gnG.size() < getIntent().getIntExtra("max_limit_num", BaseClientBuilder.API_PRIORITY_OTHER)) {
                    arR(str2);
                } else if (!this.zol.contains(str2)) {
                    dIb();
                    if (this.gnG.contains(str2)) {
                        this.opo.ajq(str2);
                        this.gnG.remove(str2);
                    } else {
                        str2 = getIntent().getStringExtra("too_many_member_tip_string");
                        if (C5046bo.isNullOrNil(str2)) {
                            str2 = getString(C25738R.string.e1m, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10))});
                        }
                        C30379h.m48438a(this.mController.ylL, str2, getString(C25738R.string.f9213t6), new C306438());
                    }
                }
                m48852Kt();
                dIj();
                dHW().notifyDataSetChanged();
                AppMethodBeat.m2505o(33875);
                return;
            }
            m48870fq(C5046bo.m7508P(new String[]{str2}));
            AppMethodBeat.m2505o(33875);
        }
    }

    private void dIj() {
        int i = 0;
        AppMethodBeat.m2504i(33876);
        if (this.zoo && (this.zkf == 1 || this.zkf == 0)) {
            int size = this.zol != null ? this.zol.size() : 0;
            if (this.gnG != null) {
                i = this.gnG.size();
            }
            this.zop.mo28016e(this, size + i, C5046bo.ank(C26373g.m41964Nu().getValue("ChatRoomInviteStartCount")));
        }
        AppMethodBeat.m2505o(33876);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aow() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aox() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aoy() {
        return this.title;
    }

    /* Access modifiers changed, original: protected|final */
    public final C40845o aoz() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.m2504i(33877);
        C30666a c30666a = new C30666a();
        c30666a.zkR = C15830s.m24192hr(this.zon, 16);
        c30666a.zkQ = C15830s.m24192hr(this.zon, 32);
        c30666a.zkS = !C15830s.m24192hr(this.zon, 4);
        if (C15830s.m24192hr(this.zon, 1)) {
            z = false;
        } else {
            z = true;
        }
        c30666a.zkT = z;
        c30666a.zkU = C15830s.m24192hr(this.zon, 128);
        c30666a.zkV = C15830s.m24192hr(this.zon, 1048576);
        c30666a.zkY = C15830s.m24192hr(this.zon, 256);
        if (c30666a.zkY) {
            c30666a.zkZ = getIntent().getStringExtra("custom_contact");
        }
        if (c30666a.zkU) {
            this.zoN = true;
            c30666a.zkW = getIntent().getStringExtra("wechat_sport_contact");
            c30666a.zkX = getIntent().getStringExtra("wechat_sport_recent_like");
            this.zoO = c30666a.zkW;
        }
        if (C15830s.dIh()) {
            c30666a.zjx = "@all.contact.without.chatroom.without.openim";
        } else {
            c30666a.zjx = "@all.contact.without.chatroom.without.openim.without.openimfavour";
        }
        if (this.scene == 6 || this.scene == 5) {
            c30666a.zjx = "@all.contact.without.chatroom.without.openim.without.openimfavour";
        }
        if (getIntent().getBooleanExtra("KBlockOpenImFav", false)) {
            c30666a.zjx = "@all.contact.without.chatroom.without.openim.without.openimfavour";
        }
        List list = this.elZ;
        boolean hr = C15830s.m24192hr(this.zon, 1);
        boolean hr2 = C15830s.m24192hr(this.zon, 64);
        if (this.zkf == 15) {
            z2 = true;
        }
        C36246c c36246c = new C36246c(this, list, hr, hr2, c30666a, z2);
        AppMethodBeat.m2505o(33877);
        return c36246c;
    }

    /* Access modifiers changed, original: protected|final */
    public final C36877m aoA() {
        AppMethodBeat.m2504i(33878);
        if (this.zoN) {
            C30667r c30667r = new C30667r(this, this.elZ, C15830s.m24192hr(this.zon, 64), this.zoO);
            AppMethodBeat.m2505o(33878);
            return c30667r;
        }
        C36877m c23923q = new C23923q(this, this.elZ, C15830s.m24192hr(this.zon, 64), this.scene);
        AppMethodBeat.m2505o(33878);
        return c23923q;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo7851a(ListView listView, int i) {
        String string;
        AppMethodBeat.m2504i(33879);
        super.mo7851a(listView, i);
        if (C15830s.m24192hr(this.zon, 256)) {
            if (this.zoA == null) {
                C3063911 c3063911 = new C3063911();
                if (this.zkf == 14) {
                    string = getString(C25738R.string.f8774el);
                } else {
                    string = getString(C25738R.string.f8758e6);
                }
                this.zoA = m48855a(listView, c3063911, string);
            }
            this.zoA.setVisibility(i);
        }
        if (C15830s.m24192hr(this.zon, 512)) {
            if (this.zoB == null) {
                this.zoB = m48855a(listView, new C1580112(), getString(C25738R.string.bts));
            }
            this.zoB.setVisibility(i);
        }
        if (C15830s.m24192hr(this.zon, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) {
            if (this.zoC == null) {
                this.zoC = m48855a(listView, new C3064613(), getString(C25738R.string.f8759e7));
            }
            this.zoC.setVisibility(i);
        }
        if (C15830s.m24192hr(this.zon, 2048)) {
            if (this.zoE == null) {
                this.zoE = m48855a(listView, new C3064714(), getString(C25738R.string.f8768ef));
            }
            this.zoE.setVisibility(i);
            this.zoE.setTextSize(16.0f * C1338a.m2860dm(this.zoE.getContext()));
        }
        if (C15830s.m24192hr(this.zon, SQLiteGlobal.journalSizeLimit)) {
            if (this.zoD == null) {
                int i2;
                String str = "";
                int intExtra = getIntent().getIntExtra("topstory_import_type", 0);
                int i3 = C25738R.string.g4w;
                List jT;
                int size;
                if (intExtra == 1) {
                    jT = C21877n.qFA.mo37359jT(5);
                    size = C5046bo.m7548ek(jT) ? 0 : jT.size();
                    str = C5046bo.m7536c(jT, ",");
                    i3 = C25738R.string.g4w;
                    intExtra = C25738R.string.g4x;
                    i2 = size;
                } else if (intExtra == 2) {
                    jT = C1855t.m3877Zn();
                    size = C5046bo.m7548ek(jT) ? 0 : jT.size();
                    str = C5046bo.m7536c(jT, ",");
                    i3 = C25738R.string.g4u;
                    intExtra = C25738R.string.g4v;
                    i2 = size;
                } else {
                    intExtra = C25738R.string.g4x;
                    i2 = 0;
                }
                this.zoD = m48855a(listView, new OnClickListener() {

                    /* renamed from: com.tencent.mm.ui.contact.SelectContactUI$15$1 */
                    class C158021 implements DialogInterface.OnClickListener {
                        C158021() {
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(33862);
                            Intent intent = new Intent();
                            intent.putExtra("Select_Contact", str);
                            intent.putExtra("App_MsgId", "fromSns");
                            SelectContactUI.this.setResult(-1, intent);
                            SelectContactUI.this.finish();
                            AppMethodBeat.m2505o(33862);
                        }
                    }

                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(33863);
                        C30379h.m48466d(SelectContactUI.this, SelectContactUI.this.getString(intExtra, new Object[]{Integer.valueOf(i2)}), "", SelectContactUI.this.getString(C25738R.string.g4t), SelectContactUI.this.getString(C25738R.string.f9076or), new C158021(), null);
                        AppMethodBeat.m2505o(33863);
                    }
                }, getString(i3));
                this.zoD.setTag(Integer.valueOf(i2));
            }
            Object tag = this.zoD.getTag();
            if (!(tag instanceof Integer) || ((Integer) tag).intValue() <= 0) {
                this.zoD.setVisibility(8);
            } else {
                this.zoD.setVisibility(i);
            }
        }
        if (C15830s.m24192hr(this.zon, 16777216) && this.zoF == null) {
            C9638aw.m17190ZK();
            C4990ab.m7417i("MicroMsg.SelectContactUI", "setOpenIMHeaderView %s", Integer.valueOf(C18628c.m29078XM().dsq().size()));
            if (C18628c.m29078XM().dsq().size() != 0) {
                this.zoF = m48855a(listView, new C3064916(), "");
                string = ((C32873b) C1720g.m3528K(C32873b.class)).mo44300a("3552365301", "openim_acct_type_title", C32874a.TYPE_WORDING);
                this.zoF.setVisibility(i);
                this.zoF.setText(string);
            }
        }
        if (!C15830s.m24192hr(this.zon, 16777216) || this.zoF == null) {
            if (C15830s.m24192hr(this.zon, 2048)) {
                if (this.zoE != null) {
                    this.zoE.setBackgroundResource(C25738R.drawable.f6625k7);
                    AppMethodBeat.m2505o(33879);
                    return;
                }
            } else if (C15830s.m24192hr(this.zon, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) {
                if (this.zoC != null) {
                    this.zoC.setBackgroundResource(C25738R.drawable.f6625k7);
                    AppMethodBeat.m2505o(33879);
                    return;
                }
            } else if (C15830s.m24192hr(this.zon, 512)) {
                if (this.zoB != null) {
                    this.zoB.setBackgroundResource(C25738R.drawable.f6625k7);
                    AppMethodBeat.m2505o(33879);
                    return;
                }
            } else if (C15830s.m24192hr(this.zon, 256) && this.zoA != null) {
                this.zoA.setBackgroundResource(C25738R.drawable.f6625k7);
            }
            AppMethodBeat.m2505o(33879);
            return;
        }
        this.zoF.setBackgroundResource(C25738R.drawable.f6625k7);
        AppMethodBeat.m2505o(33879);
    }

    /* renamed from: a */
    private TextView m48855a(ListView listView, OnClickListener onClickListener, String str) {
        AppMethodBeat.m2504i(33880);
        View inflate = C5616v.m8409hu(this).inflate(2130969809, null);
        inflate.setOnClickListener(onClickListener);
        TextView textView = (TextView) inflate.findViewById(2131822953);
        textView.setText(str);
        listView.addHeaderView(inflate);
        AppMethodBeat.m2505o(33880);
        return textView;
    }

    /* renamed from: fq */
    private boolean m48870fq(final List<String> list) {
        AppMethodBeat.m2504i(33881);
        C4990ab.m7417i("MicroMsg.SelectContactUI", "handleSelect %s", list);
        boolean z;
        if (C15830s.m24192hr(this.zon, 65536)) {
            String fs = m48872fs(list);
            this.zoM = true;
            C30379h.m48449a(this.mController.ylL, fs, null, true, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(33865);
                    SelectContactUI.this.zoM = SelectContactUI.m48860a(SelectContactUI.this, list);
                    AppMethodBeat.m2505o(33865);
                }
            }, new C3064018());
            z = this.zoM;
            AppMethodBeat.m2505o(33881);
            return z;
        }
        z = m48871fr(list);
        AppMethodBeat.m2505o(33881);
        return z;
    }

    /* renamed from: fr */
    private boolean m48871fr(List<String> list) {
        boolean z = false;
        AppMethodBeat.m2504i(33882);
        Intent intent;
        if (getIntent().getBooleanExtra("Add_SendCard", false)) {
            if (C5046bo.isNullOrNil(this.zoI)) {
                this.zoI = C5046bo.m7536c((List) list, ",");
            } else if (C5046bo.isNullOrNil(this.zoJ)) {
                this.zoJ = C5046bo.m7536c((List) list, ",");
            } else {
                C4990ab.m7413e("MicroMsg.SelectContactUI", "send card occur error: send:%s | receive:%s", this.zoI, this.zoJ);
                AppMethodBeat.m2505o(33882);
                return false;
            }
            z = C1855t.m3896kH(this.zoJ);
            intent = new Intent();
            intent.putExtra("be_send_card_name", this.zoI);
            intent.putExtra("received_card_name", this.zoJ);
            intent.putExtra("Is_Chatroom", z);
            setResult(-1, intent);
            finish();
        } else if (getIntent().getBooleanExtra("snsPostWhoCanSee", false)) {
            C4990ab.m7417i("MicroMsg.SelectContactUI", "sns post who can see scene,users=%s", list.toString());
            ArrayList qF = m48873qF(false);
            qF.remove(C1853r.m3846Yz());
            boolean z2 = false;
            for (String str : list) {
                if (!C5046bo.isNullOrNil(str)) {
                    if (!(qF.contains(str) || C1853r.m3846Yz().equals(str))) {
                        C9638aw.m17190ZK();
                        C7616ad aoO = C18628c.m29078XM().aoO(str);
                        if (!(aoO == null || ((int) aoO.ewQ) == 0 || !C7486a.m12942jh(aoO.field_type))) {
                            arR(str);
                            qF.add(str);
                            z = true;
                            z2 = z;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (z2) {
                m48852Kt();
                dHV().notifyDataSetChanged();
            } else {
                dIl();
            }
        } else if (getIntent().getBooleanExtra("recommend_friends", false)) {
            C4990ab.m7416i("MicroMsg.SelectContactUI", "Recommend Friends");
            C23927z.m36890a(this.mController.ylL, this.zoJ, list);
        } else if (C15830s.m24192hr(this.zon, 16384)) {
            C4990ab.m7416i("MicroMsg.SelectContactUI", "return the result");
            intent = new Intent();
            String c = C5046bo.m7536c((List) list, ",");
            intent.putExtra("Select_Contact", c);
            intent.putExtra("Select_Conv_User", c);
            intent.putExtra("Select_Contact", c);
            intent.putExtra("label_source", this.nHU);
            c = "Is_Chatroom";
            if (this.requestCode == 1) {
                z = true;
            }
            intent.putExtra(c, z);
            setResult(-1, intent);
            finish();
        } else if (getIntent().getBooleanExtra("shareImage", false)) {
            C4990ab.m7416i("MicroMsg.SelectContactUI", "Share Image");
            dIk();
        } else if (list.size() > 0) {
            C4990ab.m7417i("MicroMsg.SelectContactUI", "Launch ChattingUI: users=%s", list.toString());
            finish();
            intent = new Intent();
            intent.setClass(this, ChattingUI.class);
            intent.putExtra("Chat_User", (String) list.get(0));
            intent.addFlags(67108864);
            startActivity(intent);
        } else {
            C4990ab.m7413e("MicroMsg.SelectContactUI", "unkown action: User=%s", list.toString());
        }
        AppMethodBeat.m2505o(33882);
        return true;
    }

    /* renamed from: Kt */
    private void m48852Kt() {
        AppMethodBeat.m2504i(33883);
        if (!C15830s.m24192hr(this.zon, 64) || this.gnG.size() <= 0) {
            updateOptionMenuText(1, getString(C25738R.string.f9187s6));
            enableOptionMenu(1, false);
            AppMethodBeat.m2505o(33883);
            return;
        }
        updateOptionMenuText(1, getString(C25738R.string.f9187s6) + "(" + this.gnG.size() + ")");
        int intExtra = getIntent().getIntExtra("min_limit_num", 0);
        if (!C15830s.m24192hr(this.zon, 262144) || this.gnG.size() >= intExtra) {
            enableOptionMenu(1, true);
            AppMethodBeat.m2505o(33883);
            return;
        }
        enableOptionMenu(1, false);
        AppMethodBeat.m2505o(33883);
    }

    /* renamed from: qF */
    private ArrayList<String> m48873qF(boolean z) {
        AppMethodBeat.m2504i(33884);
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator it = this.gnG.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z || !C1855t.m3910mW(str)) {
                hashSet.add(str);
            } else {
                List<String> mz = C37921n.m64075mz(str);
                if (mz != null) {
                    for (String str2 : mz) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        arrayList.addAll(hashSet);
        AppMethodBeat.m2505o(33884);
        return arrayList;
    }

    /* renamed from: qG */
    private ArrayList<String> m48874qG(boolean z) {
        AppMethodBeat.m2504i(33885);
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator it = this.gnG.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z || !C1855t.m3910mW(str)) {
                hashSet.add(str);
            } else {
                List<String> mz = C37921n.m64075mz(str);
                if (mz != null) {
                    for (String str2 : mz) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        hashSet.addAll(this.zol);
        arrayList.addAll(hashSet);
        AppMethodBeat.m2505o(33885);
        return arrayList;
    }

    private void dIk() {
        AppMethodBeat.m2504i(33886);
        final ArrayList qF = m48873qF(true);
        qF.remove(C1853r.m3846Yz());
        if (qF.size() > 0) {
            this.ehJ = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.cw8), false, null);
            C9638aw.m17180RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(33852);
                    String Yz = C1853r.m3846Yz();
                    Iterator it = qF.iterator();
                    int i = 0;
                    String str = null;
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        C4990ab.m7411d("MicroMsg.SelectContactUI", "toSend, %s", str2);
                        int i2 = i + (C1855t.m3896kH(str2) ? 1 : 0);
                        C1207m c9022l = new C9022l(4, Yz, str2, SelectContactUI.this.getIntent().getStringExtra("shareImagePath"), 0, null, 0, "", str, true, C25738R.drawable.b0p);
                        C9638aw.m17182Rg().mo14541a(c9022l, 0);
                        if (c9022l.csG != null) {
                            str = c9022l.csG.field_imgPath;
                        }
                        i = i2;
                    }
                    SelectContactUI.this.ehJ.dismiss();
                    Intent intent = new Intent();
                    intent.putStringArrayListExtra("Select_Contact", qF);
                    SelectContactUI.this.setResult(-1, intent);
                    C7060h.pYm.mo8381e(11048, Integer.valueOf(1), Integer.valueOf(qF.size() - i), Integer.valueOf(i));
                    SelectContactUI.this.finish();
                    AppMethodBeat.m2505o(33852);
                }
            });
        }
        AppMethodBeat.m2505o(33886);
    }

    private void dIl() {
        AppMethodBeat.m2504i(33887);
        List qF = m48873qF(false);
        qF.remove(C1853r.m3846Yz());
        final String c = C5046bo.m7536c(qF, ",");
        if (C5046bo.m7548ek(qF)) {
            Intent intent = new Intent();
            intent.putExtra("Select_Contact", c);
            intent.putExtra("Select_Conv_User", c);
            intent.putExtra("Select_Contact", c);
            intent.putExtra("Select_Contacts_To_Create_New_Label", c);
            setResult(0, intent);
            finish();
            AppMethodBeat.m2505o(33887);
            return;
        }
        C30379h.m48453a(this.mController.ylL, true, getString(C25738R.string.clc), "", getString(C25738R.string.clb), getString(C25738R.string.cla), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(33853);
                C4990ab.m7416i("MicroMsg.SelectContactUI", "return the result,and create new label");
                Intent intent = new Intent();
                intent.putExtra("Select_Contact", c);
                intent.putExtra("Select_Conv_User", c);
                intent.putExtra("Select_Contact", c);
                intent.putExtra("Select_Contacts_To_Create_New_Label", c);
                SelectContactUI.this.setResult(-1, intent);
                SelectContactUI.this.finish();
                AppMethodBeat.m2505o(33853);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(33854);
                C4990ab.m7416i("MicroMsg.SelectContactUI", "return the result");
                Intent intent = new Intent();
                intent.putExtra("Select_Contact", c);
                intent.putExtra("Select_Conv_User", c);
                intent.putExtra("Select_Contact", c);
                SelectContactUI.this.setResult(-1, intent);
                SelectContactUI.this.finish();
                AppMethodBeat.m2505o(33854);
            }
        });
        AppMethodBeat.m2505o(33887);
    }

    /* renamed from: a */
    private void m48857a(final C46610a c46610a) {
        AppMethodBeat.m2504i(33888);
        c46610a.mo74755d(new C44205c() {
            /* renamed from: a */
            public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
                AppMethodBeat.m2504i(33855);
                C44205c c44205c = (C44205c) c46609a;
                SelectContactUI.this.zoL = false;
                if (!C30784a.m49123a(SelectContactUI.this, i, i2, str, 4)) {
                    if (i == 0 && i2 == 0 && !C5046bo.isNullOrNil(this.chatroomName)) {
                        if (c46610a.dmW()) {
                            C32794m.m53572a(this.chatroomName, c44205c.ehj, SelectContactUI.this.getString(C25738R.string.aju), false, "");
                        }
                        List list = c44205c.cGd;
                        if (list != null && list.size() > 0) {
                            LinkedList linkedList = new LinkedList();
                            for (int i3 = 0; i3 < list.size(); i3++) {
                                linkedList.add(list.get(i3));
                            }
                            String str2 = "weixin://findfriend/verifycontact/" + this.chatroomName + "/";
                            if (c46610a.dmW()) {
                                C32794m.m53572a(this.chatroomName, linkedList, SelectContactUI.this.getString(C25738R.string.ajv), true, str2);
                            }
                        }
                        SelectContactUI.m48862b(SelectContactUI.this, C5046bo.m7508P(new String[]{this.chatroomName}));
                    } else {
                        SelectContactUI.m48858a(SelectContactUI.this, i, i2, c44205c, str, c46610a.dmW());
                        AppMethodBeat.m2505o(33855);
                        return;
                    }
                }
                AppMethodBeat.m2505o(33855);
            }
        });
        getString(C25738R.string.f9238tz);
        c46610a.mo48450a(this, getString(C25738R.string.cmb), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(33856);
                SelectContactUI.this.zoL = false;
                c46610a.cancel();
                AppMethodBeat.m2505o(33856);
            }
        });
        AppMethodBeat.m2505o(33888);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(33889);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (!C5046bo.m7544cv(this)) {
            AppMethodBeat.m2505o(33889);
        } else if (C30784a.m49123a(this, i, i2, str, 4)) {
            AppMethodBeat.m2505o(33889);
        } else if (i == 0 && i2 == 0) {
            switch (c1207m.getType()) {
                case 138:
                    dHV().notifyDataSetChanged();
                    break;
            }
            AppMethodBeat.m2505o(33889);
        } else {
            if (i == 4 && i2 == -24 && !C5046bo.isNullOrNil(str)) {
                Toast.makeText(this, str, 1).show();
            }
            AppMethodBeat.m2505o(33889);
        }
    }

    public final int[] bMP() {
        boolean z = false;
        AppMethodBeat.m2504i(33892);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
        if (!getIntent().getBooleanExtra("without_openim", false)) {
            arrayList.add(Integer.valueOf(131081));
        }
        if (!C15830s.m24192hr(this.zon, 1)) {
            arrayList.add(Integer.valueOf(131076));
        }
        if (!C15830s.m24192hr(this.zon, 4)) {
            arrayList.add(Integer.valueOf(131075));
        }
        int[] iArr = new int[arrayList.size()];
        while (true) {
            boolean z2 = z;
            if (z2 < arrayList.size()) {
                iArr[z2] = ((Integer) arrayList.get(z2)).intValue();
                z = z2 + 1;
            } else {
                AppMethodBeat.m2505o(33892);
                return iArr;
            }
        }
    }

    /* renamed from: vI */
    public final void mo7901vI(String str) {
        AppMethodBeat.m2504i(33893);
        this.gnG.remove(str);
        dHV().notifyDataSetChanged();
        m48852Kt();
        AppMethodBeat.m2505o(33893);
    }

    private void arR(String str) {
        AppMethodBeat.m2504i(33894);
        if (this.zol.contains(str)) {
            AppMethodBeat.m2505o(33894);
            return;
        }
        dIb();
        this.opo.ajq(str);
        if (this.gnG.contains(str)) {
            this.gnG.remove(str);
            AppMethodBeat.m2505o(33894);
            return;
        }
        this.gnG.add(str);
        AppMethodBeat.m2505o(33894);
    }

    /* renamed from: fs */
    private String m48872fs(List<String> list) {
        AppMethodBeat.m2504i(33895);
        String str = null;
        if (list != null) {
            if (list.size() == 1) {
                str = getString(C25738R.string.e19, new Object[]{C1854s.m3866mJ((String) list.get(0))});
            } else if (list.size() > 1) {
                String string = getString(C25738R.string.f9224tj);
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    if (i == 3) {
                        stringBuilder.append("...");
                        break;
                    }
                    stringBuilder.append(C1854s.m3866mJ((String) list.get(i)));
                    if (i < list.size() - 1) {
                        stringBuilder.append(string);
                    }
                }
                str = getString(C25738R.string.e19, new Object[]{stringBuilder.toString()});
            }
        }
        AppMethodBeat.m2505o(33895);
        return str;
    }

    /* renamed from: O */
    private static List<String> m48853O(List<String> list) {
        AppMethodBeat.m2504i(33896);
        LinkedList linkedList = new LinkedList();
        if (!C9638aw.m17179RK()) {
            AppMethodBeat.m2505o(33896);
            return linkedList;
        } else if (list == null) {
            AppMethodBeat.m2505o(33896);
            return linkedList;
        } else {
            for (Object obj : list) {
                Object obj2;
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(obj2);
                if (!(aoO == null || ((int) aoO.ewQ) == 0)) {
                    obj2 = aoO.mo16707Oj();
                }
                linkedList.add(obj2);
            }
            AppMethodBeat.m2505o(33896);
            return linkedList;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(33897);
        super.onActivityResult(i, i2, intent);
        this.requestCode = i;
        C4990ab.m7417i("MicroMsg.SelectContactUI", "requestCode=%d | resultCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != -1) {
            AppMethodBeat.m2505o(33897);
            return;
        }
        String stringExtra;
        Iterator it;
        switch (i) {
            case 0:
                if (!C5046bo.isNullOrNil(intent.getStringExtra("Select_Conv_User"))) {
                    m48870fq(C5046bo.m7508P(new String[]{intent.getStringExtra("Select_Conv_User")}));
                    AppMethodBeat.m2505o(33897);
                    return;
                }
                break;
            case 1:
                stringExtra = intent.getStringExtra("Select_Contact");
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    m48870fq(C5046bo.m7508P(stringExtra.split(",")));
                    AppMethodBeat.m2505o(33897);
                    return;
                }
                break;
            case 2:
                if (intent != null) {
                    if (!C5046bo.isNullOrNil(intent.getStringExtra("Select_Contact"))) {
                        m48870fq(C5046bo.m7508P(new String[]{intent.getStringExtra("Select_Contact")}));
                    }
                    AppMethodBeat.m2505o(33897);
                    return;
                }
                break;
            case 3:
                stringExtra = intent.getStringExtra("Select_Contact");
                if (C5046bo.isNullOrNil(stringExtra)) {
                    C4990ab.m7416i("MicroMsg.SelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
                    AppMethodBeat.m2505o(33897);
                    return;
                }
                C4990ab.m7417i("MicroMsg.SelectContactUI", "GET_LABEL_USERS select username=%s", stringExtra);
                if (C15830s.m24192hr(this.zon, 64)) {
                    for (Object obj : stringExtra.split(",")) {
                        if (this.gnG.add(obj)) {
                            this.opo.ajq(obj);
                        }
                    }
                    m48852Kt();
                    dHV().notifyDataSetChanged();
                    AppMethodBeat.m2505o(33897);
                    return;
                }
                m48870fq(C5046bo.m7508P(new String[]{stringExtra}));
                AppMethodBeat.m2505o(33897);
                return;
            case 4:
                String stringExtra2 = intent.getStringExtra("Select_Conv_User");
                Iterator it2 = this.gnG.iterator();
                while (it2.hasNext()) {
                    this.opo.ajr((String) it2.next());
                }
                this.gnG.clear();
                if (!C5046bo.isNullOrNil(stringExtra2)) {
                    this.gnG.addAll(C5046bo.m7508P(stringExtra2.split(",")));
                }
                it = this.gnG.iterator();
                while (it.hasNext()) {
                    this.opo.mo69767bU((String) it.next(), false);
                }
                m48852Kt();
                AppMethodBeat.m2505o(33897);
                return;
            case 5:
                if (intent != null) {
                    String stringExtra3 = intent.getStringExtra("Select_Contact");
                    String stringExtra4 = intent.getStringExtra("Cancel_Select_Contact");
                    List<String> hT = C5046bo.isNullOrNil(stringExtra3) ? null : C5046bo.m7569hT(stringExtra3, ",");
                    List list;
                    if (C5046bo.isNullOrNil(stringExtra4)) {
                        list = null;
                    } else {
                        list = C5046bo.m7569hT(stringExtra4, ",");
                    }
                    if (hT != null) {
                        if (this.opo != null) {
                            for (String stringExtra5 : hT) {
                                if (!this.gnG.contains(stringExtra5)) {
                                    this.opo.ajq(stringExtra5);
                                }
                            }
                        }
                        this.gnG.addAll(hT);
                    }
                    if (list != null) {
                        if (this.opo != null) {
                            for (String stringExtra52 : list) {
                                this.opo.ajq(stringExtra52);
                            }
                        }
                        this.gnG.removeAll(list);
                    }
                    dHV().notifyDataSetChanged();
                    if (getIntent().getBooleanExtra("Add_SendCard", false)) {
                        m48870fq(C5046bo.m7508P(new String[]{stringExtra3}));
                    }
                }
                m48852Kt();
                break;
        }
        AppMethodBeat.m2505o(33897);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bOd() {
        if (this.zoN) {
            return false;
        }
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: QA */
    public final void mo7896QA(String str) {
        AppMethodBeat.m2504i(33898);
        C7060h.pYm.mo8381e(11225, Integer.valueOf(1), Integer.valueOf(0));
        Intent intent = new Intent();
        intent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
        intent.putExtra("label", str);
        HashSet hashSet = new HashSet();
        hashSet.addAll(m48873qF(C15830s.m24192hr(this.zon, Utility.DEFAULT_STREAM_BUFFER_SIZE)));
        hashSet.addAll(this.zol);
        intent.putExtra("always_select_contact", C5046bo.m7536c(new ArrayList(hashSet), ","));
        intent.putExtra("always_select_contact", C5046bo.m7536c(new ArrayList(hashSet), ","));
        if (C15830s.m24192hr(this.zon, 64)) {
            intent.putExtra("list_attr", C15830s.m24190C(16384, 64, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
            if (this.zkf == 14) {
                intent.putExtra("max_limit_num", getIntent().getIntExtra("max_limit_num", BaseClientBuilder.API_PRIORITY_OTHER));
            }
        } else {
            intent.putExtra("list_attr", 16384);
        }
        startActivityForResult(intent, 3);
        AppMethodBeat.m2505o(33898);
    }

    /* renamed from: a */
    public final boolean mo7897a(C5445a c5445a) {
        AppMethodBeat.m2504i(33890);
        boolean contains;
        if (c5445a.zmW && c5445a.ehM != null) {
            contains = this.gnG.contains(c5445a.ehM.field_username);
            AppMethodBeat.m2505o(33890);
            return contains;
        } else if (c5445a.zmX && c5445a.ehM != null) {
            contains = this.gnG.contains(c5445a.ehM.field_username);
            AppMethodBeat.m2505o(33890);
            return contains;
        } else if (c5445a instanceof C46674k) {
            contains = this.gnG.isEmpty();
            AppMethodBeat.m2505o(33890);
            return contains;
        } else {
            AppMethodBeat.m2505o(33890);
            return false;
        }
    }

    /* renamed from: b */
    public final boolean mo39661b(C5445a c5445a) {
        AppMethodBeat.m2504i(33891);
        if (!c5445a.zmW || c5445a.ehM == null) {
            AppMethodBeat.m2505o(33891);
            return false;
        }
        boolean contains = this.zol.contains(c5445a.ehM.field_username);
        AppMethodBeat.m2505o(33891);
        return contains;
    }

    /* renamed from: e */
    static /* synthetic */ void m48868e(SelectContactUI selectContactUI) {
        AppMethodBeat.m2504i(33902);
        ArrayList<String> qG = selectContactUI.m48874qG(false);
        qG.remove(C1853r.m3846Yz());
        if (qG.size() == 1) {
            selectContactUI.zoL = false;
            selectContactUI.finish();
            selectContactUI.mo17381a(ChattingUI.class, new Intent().putExtra("Chat_User", (String) qG.get(0)));
            AppMethodBeat.m2505o(33902);
            return;
        }
        boolean z;
        for (String aox : qG) {
            if (C7616ad.aox(aox)) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            selectContactUI.m48857a(C30262b.alY("@chatroom").mo20636b("", qG));
            AppMethodBeat.m2505o(33902);
        } else if (C15830s.dIh()) {
            selectContactUI.zoL = false;
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_OPENIM_SELECT_ALERT_ID_BOOLEAN, false);
            selectContactUI.zoL = true;
            selectContactUI.m48857a(C30262b.alY("@im.chatroom").mo20636b("", qG));
            AppMethodBeat.m2505o(33902);
        } else {
            C30379h.m48438a((Context) selectContactUI, selectContactUI.getString(C25738R.string.egx), "", null);
            selectContactUI.zoL = false;
            AppMethodBeat.m2505o(33902);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m48858a(SelectContactUI selectContactUI, int i, int i2, C44205c c44205c, String str, boolean z) {
        AppMethodBeat.m2504i(33904);
        String str2 = "";
        String str3 = "";
        String string = C4996ah.getContext().getString(C25738R.string.ajw);
        if (!z) {
            if (c44205c != null && !C5046bo.isNullOrNil(c44205c.vEO)) {
                C30379h.m48461b((Context) selectContactUI, c44205c.vEO, "", true);
                AppMethodBeat.m2505o(33904);
                return;
            } else if (!(z || C5046bo.isNullOrNil(str))) {
                C30379h.m48461b((Context) selectContactUI, str, "", true);
                AppMethodBeat.m2505o(33904);
                return;
            }
        }
        if (i2 == -23) {
            str2 = selectContactUI.getString(C25738R.string.dtb);
            str3 = selectContactUI.getString(C25738R.string.dta);
        }
        List list = c44205c.cGd;
        List list2 = c44205c.ehk;
        if (list == null || list.size() <= 0 || (list.size() != c44205c.cEX && (list2 == null || list2.size() <= 0 || c44205c.cEX != list.size() + list2.size()))) {
            String str4;
            list = c44205c.ehk;
            if (list == null || list.size() <= 0 || c44205c.cEX != list.size()) {
                str4 = str3;
            } else {
                str2 = selectContactUI.getString(C25738R.string.cm_);
                str4 = str3 + selectContactUI.getString(C25738R.string.bx_, new Object[]{C5046bo.m7536c(SelectContactUI.m48853O(list), string)});
            }
            List<String> list3 = c44205c.cGa;
            if (list3 != null && list3.size() > 0) {
                Object obj;
                for (String str32 : list3) {
                    if (C7616ad.aox(str32)) {
                        str2 = selectContactUI.getString(C25738R.string.cm_);
                        str4 = selectContactUI.getString(C25738R.string.cma);
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    str2 = selectContactUI.getString(C25738R.string.cm_);
                    str4 = str4 + selectContactUI.getString(C25738R.string.bxc, new Object[]{C5046bo.m7536c(SelectContactUI.m48853O(list3), string)});
                }
            }
            if (str2 == null || str2.length() <= 0) {
                Toast.makeText(selectContactUI, selectContactUI.getString(C25738R.string.bwv, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                AppMethodBeat.m2505o(33904);
                return;
            }
            C30379h.m48461b((Context) selectContactUI, str4, str2, true);
            AppMethodBeat.m2505o(33904);
            return;
        }
        final LinkedList linkedList = new LinkedList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            linkedList.add(list.get(i3));
        }
        Assert.assertTrue(linkedList.size() > 0);
        str32 = C4996ah.getContext().getString(C25738R.string.ajw);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(linkedList);
        arrayList.addAll(list2);
        C30379h.m48445a((Context) selectContactUI, selectContactUI.getString(C25738R.string.bxl, new Object[]{C5046bo.m7536c(SelectContactUI.m48853O(arrayList), str32)}), selectContactUI.getString(C25738R.string.cm_), selectContactUI.getString(C25738R.string.bxk), selectContactUI.getString(C25738R.string.bxj), true, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(33857);
                SelectContactUI.m48859a(SelectContactUI.this, linkedList);
                AppMethodBeat.m2505o(33857);
            }
        }, null);
        AppMethodBeat.m2505o(33904);
    }
}
