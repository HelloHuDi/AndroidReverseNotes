package com.tencent.p177mm.p612ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoiceaddr.p875ui.C42239b;
import com.tencent.p177mm.modelvoiceaddr.p875ui.C42239b.C9756a;
import com.tencent.p177mm.modelvoiceaddr.p875ui.VoiceSearchLayout;
import com.tencent.p177mm.modelvoiceaddr.p875ui.VoiceSearchLayout.C32854b;
import com.tencent.p177mm.openim.p1210a.C37974a;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p232b.p233a.C32677t;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C30777u.C30784a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.voicesearch.C46939b;
import com.tencent.p177mm.p612ui.voicesearch.VoiceSearchResultUI;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C14943d;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.but;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import java.io.IOException;

/* renamed from: com.tencent.mm.ui.contact.ChatroomContactUI */
public class ChatroomContactUI extends MMActivity implements C1202f, C4931a {
    private C14943d ein = new C14943d(new C54296());
    private int jLX = 0;
    private int jLY = 0;
    private C24088a jMO;
    private C5279d lCi = new C362341();
    private TextView mht;
    private ListView nIv;
    private C46939b zkc;
    private String zke;
    private ContactCountView zkp;
    private VoiceSearchLayout zlp;
    private C42239b zlq;
    private C36248d zlr;

    /* renamed from: com.tencent.mm.ui.contact.ChatroomContactUI$6 */
    class C54296 implements OnScrollListener {
        C54296() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ChatroomContactUI$5 */
    class C157895 implements C32854b {

        /* renamed from: com.tencent.mm.ui.contact.ChatroomContactUI$5$1 */
        class C157901 implements Runnable {
            C157901() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33575);
                ChatroomContactUI.this.nIv.setSelection(0);
                AppMethodBeat.m2505o(33575);
            }
        }

        C157895() {
        }

        /* renamed from: dd */
        public final void mo28001dd(boolean z) {
            AppMethodBeat.m2504i(33576);
            C4990ab.m7410d("MicroMsg.ChatroomContactUI", "visible ".concat(String.valueOf(z)));
            if (z) {
                int firstVisiblePosition = ChatroomContactUI.this.nIv.getFirstVisiblePosition();
                C4990ab.m7410d("MicroMsg.ChatroomContactUI", "getFirstVisiblePosition  ".concat(String.valueOf(firstVisiblePosition)));
                if (firstVisiblePosition > 0) {
                    ChatroomContactUI.this.nIv.post(new C157901());
                }
            }
            AppMethodBeat.m2505o(33576);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ChatroomContactUI$10 */
    class C2389310 implements C23599f {
        C2389310() {
        }

        /* renamed from: bN */
        public final void mo11067bN(Object obj) {
            AppMethodBeat.m2504i(33582);
            if (obj == null) {
                C4990ab.m7412e("MicroMsg.ChatroomContactUI", "onItemDel object null");
                AppMethodBeat.m2505o(33582);
                return;
            }
            ChatroomContactUI.arN(obj.toString());
            ChatroomContactUI.m59641c(ChatroomContactUI.this);
            AppMethodBeat.m2505o(33582);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ChatroomContactUI$11 */
    class C2389411 implements OnItemClickListener {
        C2389411() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(33583);
            C4990ab.m7410d("MicroMsg.ChatroomContactUI", "onItemClick " + i + (ChatroomContactUI.this.zkc == null ? ChatroomContactUI.this.zkc : Boolean.valueOf(ChatroomContactUI.this.zkc.zLy)));
            if (i < ChatroomContactUI.this.nIv.getHeaderViewsCount()) {
                AppMethodBeat.m2505o(33583);
                return;
            }
            int headerViewsCount = i - ChatroomContactUI.this.nIv.getHeaderViewsCount();
            C7616ad c7616ad;
            C32677t c32677t;
            if (ChatroomContactUI.this.zkc == null || !ChatroomContactUI.this.zkc.zLy) {
                c7616ad = (C7616ad) ChatroomContactUI.this.zlr.getItem(headerViewsCount);
                if (C1855t.m3903mP(c7616ad.field_username)) {
                    c32677t = new C32677t();
                    c32677t.mo53208eO(c7616ad.field_username);
                    c32677t.cXP = 2;
                    c32677t.ajK();
                }
                ChatroomContactUI.m59639b(ChatroomContactUI.this, c7616ad.field_username);
                AppMethodBeat.m2505o(33583);
                return;
            }
            boolean wK = ChatroomContactUI.this.zkc.mo10892wK(headerViewsCount);
            boolean PQ = ChatroomContactUI.this.zkc.mo76189PQ(headerViewsCount);
            C4990ab.m7410d("MicroMsg.ChatroomContactUI", "onItemClick ".concat(String.valueOf(PQ)));
            Intent intent;
            if (PQ) {
                ChatroomContactUI.this.zkc.asx(ChatroomContactUI.this.zlq == null ? "" : ChatroomContactUI.this.zlq.getSearchContent());
                AppMethodBeat.m2505o(33583);
            } else if (wK) {
                but PO = ChatroomContactUI.this.zkc.mo76187PO(headerViewsCount);
                String str = PO.wcB.wVI;
                C9638aw.m17190ZK();
                c7616ad = C18628c.m29078XM().aoO(str);
                if (C7486a.m12942jh(c7616ad.field_type)) {
                    intent = new Intent();
                    intent.putExtra("Contact_User", str);
                    intent.putExtra("Contact_Scene", 3);
                    if (str != null && str.length() > 0) {
                        if (c7616ad.dsf()) {
                            C7060h.pYm.mo8374X(10298, str + ",3");
                        }
                        C36249e.m59677a(intent, str);
                        C25985d.m41467b(ChatroomContactUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                    }
                    AppMethodBeat.m2505o(33583);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_User", PO.wcB.wVI);
                intent2.putExtra("Contact_Alias", PO.guS);
                intent2.putExtra("Contact_Nick", PO.wyX.wVI);
                intent2.putExtra("Contact_Signature", PO.guQ);
                intent2.putExtra("Contact_RegionCode", RegionCodeDecoder.m7796aC(PO.guW, PO.guO, PO.guP));
                intent2.putExtra("Contact_Sex", PO.guN);
                intent2.putExtra("Contact_VUser_Info", PO.wBU);
                intent2.putExtra("Contact_VUser_Info_Flag", PO.wBT);
                intent2.putExtra("Contact_KWeibo_flag", PO.wBX);
                intent2.putExtra("Contact_KWeibo", PO.wBV);
                intent2.putExtra("Contact_KWeiboNick", PO.wBW);
                intent2.putExtra("Contact_KSnsIFlag", PO.wBZ.guY);
                intent2.putExtra("Contact_KSnsBgId", PO.wBZ.gva);
                intent2.putExtra("Contact_KSnsBgUrl", PO.wBZ.guZ);
                if (PO.wCa != null) {
                    try {
                        intent2.putExtra("Contact_customInfo", PO.wCa.toByteArray());
                    } catch (IOException e) {
                        C4990ab.printErrStackTrace("MicroMsg.ChatroomContactUI", e, "", new Object[0]);
                    }
                }
                if ((PO.wBT & 8) > 0) {
                    C7060h.pYm.mo8374X(10298, str + ",3");
                }
                C25985d.m41467b(ChatroomContactUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                AppMethodBeat.m2505o(33583);
            } else {
                C7616ad PP = ChatroomContactUI.this.zkc.mo76188PP(headerViewsCount);
                if (PP == null) {
                    C4990ab.m7413e("MicroMsg.ChatroomContactUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", Integer.valueOf(ChatroomContactUI.this.zkc.getCount()), Integer.valueOf(headerViewsCount));
                    AppMethodBeat.m2505o(33583);
                    return;
                }
                C30670y.m48901q(ChatroomContactUI.this.zlq.getSearchContent(), 9, 3, headerViewsCount + 1);
                String str2 = PP.field_username;
                if (C1855t.m3903mP(str2)) {
                    c32677t = new C32677t();
                    c32677t.mo53208eO(str2);
                    c32677t.cXP = 2;
                    c32677t.ajK();
                }
                intent = new Intent(ChatroomContactUI.this.mController.ylL, ChattingUI.class);
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", str2);
                intent.putExtra("Chat_Mode", 1);
                ChatroomContactUI.this.mController.ylL.startActivity(intent);
                AppMethodBeat.m2505o(33583);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ChatroomContactUI$8 */
    class C238958 implements C15521c {
        C238958() {
        }

        /* renamed from: cZ */
        public final int mo8831cZ(View view) {
            AppMethodBeat.m2504i(33580);
            int positionForView = ChatroomContactUI.this.nIv.getPositionForView(view);
            AppMethodBeat.m2505o(33580);
            return positionForView;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ChatroomContactUI$12 */
    class C3062912 implements OnItemLongClickListener {
        C3062912() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(33584);
            C4990ab.m7410d("MicroMsg.ChatroomContactUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(i)));
            if (i < ChatroomContactUI.this.nIv.getHeaderViewsCount()) {
                C4990ab.m7420w("MicroMsg.ChatroomContactUI", "on item long click, but match header view");
                AppMethodBeat.m2505o(33584);
                return true;
            } else if (ChatroomContactUI.this.zkc == null || !ChatroomContactUI.this.zkc.zLy) {
                String str = ((C7616ad) ChatroomContactUI.this.zlr.getItem(i - ChatroomContactUI.this.nIv.getHeaderViewsCount())).field_username;
                if (C1855t.m3956ny(str) || C1855t.m3957nz(str)) {
                    AppMethodBeat.m2505o(33584);
                    return true;
                }
                ChatroomContactUI.this.zke = str;
                ChatroomContactUI.this.jMO.mo39885a(view, i, j, ChatroomContactUI.this, ChatroomContactUI.this.lCi, ChatroomContactUI.this.jLX, ChatroomContactUI.this.jLY);
                AppMethodBeat.m2505o(33584);
                return true;
            } else {
                AppMethodBeat.m2505o(33584);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ChatroomContactUI$13 */
    class C3063013 implements OnTouchListener {
        C3063013() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(33585);
            switch (motionEvent.getAction()) {
                case 0:
                    ChatroomContactUI.this.aqX();
                    ChatroomContactUI.this.jLX = (int) motionEvent.getRawX();
                    ChatroomContactUI.this.jLY = (int) motionEvent.getRawY();
                    break;
            }
            if (ChatroomContactUI.this.zlr != null) {
                C36248d f = ChatroomContactUI.this.zlr;
                if (f.gvm != null) {
                    f.gvm.onTouchEvent(motionEvent);
                }
            }
            if (ChatroomContactUI.this.zkc != null) {
                C46939b d = ChatroomContactUI.this.zkc;
                if (d.gvm != null) {
                    d.gvm.onTouchEvent(motionEvent);
                }
            }
            AppMethodBeat.m2505o(33585);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ChatroomContactUI$7 */
    class C306317 implements C9756a {
        C306317() {
        }

        public final void apq() {
        }

        public final void apr() {
        }

        /* renamed from: vO */
        public final void mo7460vO(String str) {
            AppMethodBeat.m2504i(33577);
            C4990ab.m7411d("MicroMsg.ChatroomContactUI", "onSearchBarChange %s", str);
            ChatroomContactUI.m59636a(ChatroomContactUI.this, C42252ah.m74631vA(str));
            AppMethodBeat.m2505o(33577);
        }

        public final void apo() {
        }

        public final void app() {
        }

        public final void amJ() {
            AppMethodBeat.m2504i(33578);
            C4990ab.m7418v("MicroMsg.ChatroomContactUI", "onVoiceSearchStart");
            ChatroomContactUI.this.aqX();
            AppMethodBeat.m2505o(33578);
        }

        /* renamed from: a */
        public final void mo21125a(boolean z, String[] strArr, long j, int i) {
            AppMethodBeat.m2504i(33579);
            C4990ab.m7418v("MicroMsg.ChatroomContactUI", "onVoiceReturn");
            Intent intent;
            if (z) {
                intent = new Intent(ChatroomContactUI.this.mController.ylL, VoiceSearchResultUI.class);
                intent.putExtra("VoiceSearchResultUI_Resultlist", strArr);
                intent.putExtra("VoiceSearchResultUI_VoiceId", j);
                intent.putExtra("VoiceSearchResultUI_ShowType", i);
                ChatroomContactUI.this.mController.ylL.startActivity(intent);
                AppMethodBeat.m2505o(33579);
                return;
            }
            intent = new Intent(ChatroomContactUI.this.mController.ylL, VoiceSearchResultUI.class);
            intent.putExtra("VoiceSearchResultUI_Resultlist", new String[0]);
            intent.putExtra("VoiceSearchResultUI_Error", ChatroomContactUI.this.mController.ylL.getString(C25738R.string.bx9));
            intent.putExtra("VoiceSearchResultUI_VoiceId", j);
            intent.putExtra("VoiceSearchResultUI_ShowType", i);
            ChatroomContactUI.this.mController.ylL.startActivity(intent);
            AppMethodBeat.m2505o(33579);
        }

        /* renamed from: vN */
        public final boolean mo7459vN(String str) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ChatroomContactUI$1 */
    class C362341 implements C5279d {
        C362341() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(33571);
            switch (menuItem.getItemId()) {
                case 1:
                    ChatroomContactUI.arN(ChatroomContactUI.this.zke);
                    AppMethodBeat.m2505o(33571);
                    return;
                default:
                    AppMethodBeat.m2505o(33571);
                    return;
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ChatroomContactUI$2 */
    class C362352 implements OnMenuItemClickListener {
        C362352() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33572);
            ChatroomContactUI.this.finish();
            AppMethodBeat.m2505o(33572);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ChatroomContactUI$3 */
    class C362363 implements OnMenuItemClickListener {
        C362363() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33573);
            Intent intent = new Intent(ChatroomContactUI.this, SelectContactUI.class);
            intent.putExtra("titile", ChatroomContactUI.this.getString(C25738R.string.f8781es));
            intent.putExtra("list_type", 0);
            intent.putExtra("list_attr", C15830s.m24190C(C15830s.znG, 256, 512));
            ChatroomContactUI.this.mController.ylL.startActivity(intent);
            AppMethodBeat.m2505o(33573);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ChatroomContactUI$4 */
    class C362374 implements OnClickListener {
        C362374() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33574);
            C4978c.m7375a(ChatroomContactUI.this.nIv);
            AppMethodBeat.m2505o(33574);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ChatroomContactUI$9 */
    class C362389 implements C23600g {
        C362389() {
        }

        /* renamed from: q */
        public final void mo11108q(View view, int i, int i2) {
            AppMethodBeat.m2504i(33581);
            ChatroomContactUI.this.nIv.performItemClick(view, i, (long) i2);
            AppMethodBeat.m2505o(33581);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ChatroomContactUI() {
        AppMethodBeat.m2504i(33586);
        AppMethodBeat.m2505o(33586);
    }

    /* renamed from: c */
    static /* synthetic */ void m59641c(ChatroomContactUI chatroomContactUI) {
        AppMethodBeat.m2504i(33599);
        chatroomContactUI.bJk();
        AppMethodBeat.m2505o(33599);
    }

    public final int getLayoutId() {
        return 2130969003;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(33587);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.f8738dl);
        initView();
        C9638aw.m17182Rg().mo14539a(138, (C1202f) this);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10118a(this.zlr);
        AppMethodBeat.m2505o(33587);
    }

    private void dHE() {
        AppMethodBeat.m2504i(33588);
        ((TextView) findViewById(2131821055)).setVisibility(8);
        AppMethodBeat.m2505o(33588);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(33589);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        C9638aw.m17190ZK();
        if (C18628c.m29078XM().aoO(this.zke) == null) {
            C4990ab.m7412e("MicroMsg.ChatroomContactUI", "onCreateContextMenu, contact is null, username = " + this.zke);
            AppMethodBeat.m2505o(33589);
        } else if (C1855t.m3910mW(this.zke)) {
            contextMenu.setHeaderTitle(C44089j.m79292b(view.getContext(), C1854s.m3866mJ(this.zke)));
            contextMenu.add(adapterContextMenuInfo.position, 1, 0, C25738R.string.f8745dt);
            AppMethodBeat.m2505o(33589);
        } else {
            AppMethodBeat.m2505o(33589);
        }
    }

    public final void initView() {
        AppMethodBeat.m2504i(33590);
        dHE();
        this.nIv = (ListView) findViewById(2131821054);
        this.nIv.setAdapter(null);
        this.mht = (TextView) findViewById(2131821055);
        this.mht.setText(C25738R.string.f8749dx);
        String str = "@all.chatroom.contact";
        this.zlr = new C36248d(this, str);
        this.zlr.mo74996pN(true);
        this.zkc = new C46939b(this.mController.ylL, 1);
        this.zkc.zjx = str;
        this.zlq = new C42239b((byte) 0);
        this.zlq.mo67775a(new C306317());
        mo17380a(this.zlq);
        this.zlr.setGetViewPositionCallback(new C238958());
        this.zlr.setPerformItemClickListener(new C362389());
        this.zlr.mo57114a(new C2389310());
        this.nIv.setOnScrollListener(this.ein);
        this.zlr.vkK = this.ein;
        this.jMO = new C24088a(this.mController.ylL);
        this.nIv.setOnItemClickListener(new C2389411());
        this.nIv.setOnItemLongClickListener(new C3062912());
        this.nIv.setOnTouchListener(new C3063013());
        ListView listView = this.nIv;
        ContactCountView contactCountView = new ContactCountView(this);
        this.zkp = contactCountView;
        listView.addFooterView(contactCountView, null, false);
        setBackBtn(new C362352());
        addIconOptionMenu(0, C25738R.string.f8698cf, C1318a.actionbar_icon_dark_add, new C362363());
        C362374 c362374 = new C362374();
        this.nIv.setAdapter(this.zlr);
        this.zkc.mo76202qU(false);
        this.nIv.setVisibility(0);
        this.zlp = new VoiceSearchLayout(this);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(14);
        this.zlp.setLayoutParams(layoutParams);
        this.zlp.setTopMargin(C4977b.m7371b((Context) this, 100.0f));
        this.zlp.setVisibility(8);
        ((ViewGroup) findViewById(2131822359)).addView(this.zlp);
        if (this.zlp != null) {
            this.zlp.setOnVisibleChangeListener(new C157895());
        }
        if (this.zlr.getCount() == 0) {
            this.mht.setSingleLine(false);
            this.mht.setPadding(40, 0, 40, 0);
            this.mht.setVisibility(0);
        }
        AppMethodBeat.m2505o(33590);
    }

    public void onResume() {
        AppMethodBeat.m2504i(33591);
        super.onResume();
        if (this.zkp != null) {
            this.zkp.setContactType(2);
            this.zkp.dHF();
        }
        C9638aw.m17190ZK();
        C18628c.m29087XV().mo10116c(this);
        if (!(this.zlq == null || this.zlp == null)) {
            C25985d.dlL();
            if (C17950b.ahP() || !C4988aa.dor().equals("zh_CN")) {
                this.zlq.gcl = false;
            } else {
                this.zlq.gcl = true;
                C42239b c42239b = this.zlq;
                c42239b.gcp = this.zlp;
                c42239b.gcn = 1;
                if (1 == c42239b.gcn) {
                    c42239b.gcm = 2;
                } else {
                    c42239b.gcm = 1;
                }
            }
        }
        if (this.zkc != null) {
            this.zkc.onResume();
        }
        AppMethodBeat.m2505o(33591);
    }

    public void onPause() {
        AppMethodBeat.m2504i(33592);
        super.onPause();
        C9638aw.m17190ZK();
        C18628c.m29087XV().mo10117d(this);
        if (this.zlq != null) {
            C42239b c42239b = this.zlq;
            c42239b.dJS();
            c42239b.cancel();
        }
        if (this.zkc != null) {
            this.zkc.onPause();
        }
        AppMethodBeat.m2505o(33592);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(33593);
        super.onDestroy();
        C9638aw.m17182Rg().mo14546b(138, (C1202f) this);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10121b(this.zlr);
        C36248d c36248d = this.zlr;
        if (c36248d.gvm != null) {
            c36248d.gvm.detach();
            c36248d.gvm = null;
        }
        this.zlr.bIf();
        this.zlr.dww();
        this.zkc.detach();
        this.zkc.bIf();
        AppMethodBeat.m2505o(33593);
    }

    private void bJk() {
        AppMethodBeat.m2504i(33594);
        if (this.zlr != null) {
            this.zlr.mo5248a(null, null);
        }
        if (this.zkc != null) {
            this.zkc.mo5248a(null, null);
        }
        AppMethodBeat.m2505o(33594);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(33595);
        if (!C42252ah.m74615cv(this)) {
            AppMethodBeat.m2505o(33595);
        } else if (C30784a.m49123a(this, i, i2, str, 4)) {
            AppMethodBeat.m2505o(33595);
        } else if (i == 0 && i2 == 0) {
            switch (c1207m.getType()) {
                case 138:
                    bJk();
                    break;
            }
            AppMethodBeat.m2505o(33595);
        } else {
            AppMethodBeat.m2505o(33595);
        }
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(33596);
        if (this.zkp != null) {
            this.zkp.setContactType(2);
            this.zkp.dHF();
        }
        AppMethodBeat.m2505o(33596);
    }

    static /* synthetic */ void arN(String str) {
        AppMethodBeat.m2504i(33597);
        C9638aw.m17190ZK();
        C7616ad aoO = C18628c.m29078XM().aoO(str);
        if (C1855t.m3903mP(str)) {
            aoO.mo16677NC();
            ((C37974a) C1720g.m3528K(C37974a.class)).mo60751vg(aoO.field_username);
            C9638aw.m17190ZK();
            C18628c.m29078XM().mo15724b(str, aoO);
            AppMethodBeat.m2505o(33597);
            return;
        }
        aoO.mo16677NC();
        C1855t.m3964u(aoO);
        if (C1855t.m3896kH(str)) {
            C9638aw.m17190ZK();
            C18628c.m29078XM().aoU(str);
            C9638aw.m17190ZK();
            C18628c.m29087XV().mo14891og(str);
            AppMethodBeat.m2505o(33597);
            return;
        }
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo15724b(str, aoO);
        AppMethodBeat.m2505o(33597);
    }
}
