package com.tencent.p177mm.p612ui.conversation;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.p181af.C32223o;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p184aj.C37456x;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p230g.p231a.C6504k;
import com.tencent.p177mm.p230g.p231a.C9293ai;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.tools.C40889b;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.BizTimeLineNewMsgUI;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.websearch.api.C29736ac;
import com.tencent.p177mm.plugin.websearch.api.C40193m;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.brm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI */
public class NewBizConversationUI extends MMActivity {
    private C7617ak conversation;
    private int ctE;
    private int cvd = 1;
    private TextView emptyTipTv;
    private String fuO;
    private boolean isDeleteCancel = false;
    private int jLX = 0;
    private int jLY = 0;
    private C24088a jMO;
    private long jOA = 0;
    private C4884c jOJ = new C794910();
    private C5279d jOb = new C79679();
    private String talker = "";
    private C44275p tipDialog = null;
    private ListView zqO;
    private String zqQ;
    private C7957a zvk;
    private final int zvl = 1;

    /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$15 */
    class C794615 implements C30723a {
        C794615() {
        }

        public final void apt() {
            AppMethodBeat.m2504i(34550);
            NewBizConversationUI.m14130a(NewBizConversationUI.this, NewBizConversationUI.this.zvk.getCount());
            AppMethodBeat.m2505o(34550);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$17 */
    class C794717 implements C23600g {
        C794717() {
        }

        /* renamed from: q */
        public final void mo11108q(View view, int i, int i2) {
            AppMethodBeat.m2504i(34552);
            NewBizConversationUI.this.zqO.performItemClick(view, i, (long) i2);
            AppMethodBeat.m2505o(34552);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$18 */
    class C794818 implements OnItemClickListener {
        C794818() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(34553);
            NewBizConversationUI.this.conversation = (C7617ak) NewBizConversationUI.this.zvk.getItem(i);
            NewBizConversationUI.this.talker = NewBizConversationUI.this.conversation.field_username;
            C7617ak g = NewBizConversationUI.this.conversation;
            if (g == null) {
                C4990ab.m7413e("MicroMsg.NewBizConversationUI", "user should not be null. position:%d, size:%d", Integer.valueOf(i), Integer.valueOf(NewBizConversationUI.this.zvk.getCount()));
                NewBizConversationUI.this.zvk.notifyDataSetChanged();
                AppMethodBeat.m2505o(34553);
                return;
            }
            Intent intent = new Intent(NewBizConversationUI.this, ChattingUI.class);
            intent.putExtra("Chat_User", g.field_username);
            intent.putExtra("finish_direct", true);
            intent.putExtra("biz_click_item_unread_count", NewBizConversationUI.this.conversation.field_unReadCount);
            intent.putExtra("biz_click_item_position", i + 1);
            intent.putExtra("KOpenArticleSceneFromScene", 92);
            intent.putExtra("specific_chat_from_scene", 6);
            NewBizConversationUI.this.startActivity(intent);
            NewBizConversationUI.this.zvk.mo17780a(g, i);
            AppMethodBeat.m2505o(34553);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$10 */
    class C794910 extends C4884c<C6504k> {
        C794910() {
            AppMethodBeat.m2504i(34542);
            this.xxI = C6504k.class.getName().hashCode();
            AppMethodBeat.m2505o(34542);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(34543);
            C6504k c6504k = (C6504k) c4883b;
            if (!(c6504k == null || c6504k.csh == null || c6504k.csh.csi)) {
                NewBizConversationUI.this.jOA = 0;
            }
            AppMethodBeat.m2505o(34543);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$2 */
    class C79502 implements OnTouchListener {
        C79502() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(34533);
            switch (motionEvent.getAction()) {
                case 0:
                    NewBizConversationUI.this.jLX = (int) motionEvent.getRawX();
                    NewBizConversationUI.this.jLY = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.m2505o(34533);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$3 */
    class C79513 implements OnItemLongClickListener {
        C79513() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(34534);
            NewBizConversationUI.this.conversation = (C7617ak) NewBizConversationUI.this.zvk.getItem(i);
            NewBizConversationUI.this.talker = NewBizConversationUI.this.conversation.field_username;
            NewBizConversationUI.this.jMO.mo39885a(view, i, j, NewBizConversationUI.this, NewBizConversationUI.this.jOb, NewBizConversationUI.this.jLX, NewBizConversationUI.this.jLY);
            AppMethodBeat.m2505o(34534);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$4 */
    class C79524 implements C15521c {
        C79524() {
        }

        /* renamed from: cZ */
        public final int mo8831cZ(View view) {
            AppMethodBeat.m2504i(34535);
            int positionForView = NewBizConversationUI.this.zqO.getPositionForView(view);
            AppMethodBeat.m2505o(34535);
            return positionForView;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$5 */
    class C79535 implements C23600g {
        C79535() {
        }

        /* renamed from: q */
        public final void mo11108q(View view, int i, int i2) {
            AppMethodBeat.m2504i(34536);
            NewBizConversationUI.this.zqO.performItemClick(view, i, (long) i2);
            AppMethodBeat.m2505o(34536);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$16 */
    class C795416 implements C15521c {
        C795416() {
        }

        /* renamed from: cZ */
        public final int mo8831cZ(View view) {
            AppMethodBeat.m2504i(34551);
            int positionForView = NewBizConversationUI.this.zqO.getPositionForView(view);
            AppMethodBeat.m2505o(34551);
            return positionForView;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$13 */
    class C795513 implements Runnable {
        C795513() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34548);
            if (NewBizConversationUI.this.uiu || NewBizConversationUI.this.isFinishing()) {
                AppMethodBeat.m2505o(34548);
                return;
            }
            NewBizConversationUI.m14129a(NewBizConversationUI.this);
            AppMethodBeat.m2505o(34548);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$a */
    static class C7957a extends C36282e {
        private String cIe;
        HashMap<String, C7968b> jOf = new HashMap();

        public C7957a(Context context, String str, C30723a c30723a) {
            super(context, c30723a);
            AppMethodBeat.m2504i(34554);
            this.cIe = str;
            AppMethodBeat.m2505o(34554);
        }

        /* renamed from: KC */
        public final void mo6869KC() {
            AppMethodBeat.m2504i(34555);
            C9638aw.m17190ZK();
            setCursor(C18628c.m29083XR().mo15804c(C1855t.fkP, this.elZ, this.cIe));
            if (this.yle != null) {
                this.yle.apt();
            }
            super.notifyDataSetChanged();
            AppMethodBeat.m2505o(34555);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: a */
        public final void mo17781a(C7617ak c7617ak, boolean z, int i, boolean z2) {
            AppMethodBeat.m2504i(34556);
            if (c7617ak == null) {
                AppMethodBeat.m2505o(34556);
                return;
            }
            C7968b c7968b;
            C7968b c7968b2 = (C7968b) this.jOf.get(c7617ak.field_username);
            if (c7968b2 == null) {
                c7968b2 = new C7968b();
                this.jOf.put(c7617ak.field_username, c7968b2);
                c7968b = c7968b2;
            } else {
                c7968b = c7968b2;
            }
            if (c7968b.fPZ > 0) {
                AppMethodBeat.m2505o(34556);
                return;
            }
            c7968b.wTL = z;
            boolean z3 = c7968b.wTO || c7617ak.field_unReadCount > 0;
            c7968b.wTO = z3;
            c7968b.ndr = i + 1;
            if (z2) {
                c7968b.fPZ = c7968b.ndr;
            }
            c7968b.wTN = (int) (System.currentTimeMillis() / 1000);
            if (c7617ak.field_lastSeq == c7968b.wYf) {
                AppMethodBeat.m2505o(34556);
                return;
            }
            c7968b.wYf = c7617ak.field_lastSeq;
            C7620bi Rb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(c7617ak.field_username);
            if (Rb != null && Rb.drC()) {
                C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(Rb.field_msgId, Rb.field_content);
                if (!(b == null || C5046bo.m7548ek(b.fjr) || C5046bo.isNullOrNil(((C32224p) b.fjr.get(0)).url))) {
                    try {
                        Uri parse = Uri.parse(((C32224p) b.fjr.get(0)).url);
                        c7968b.wTJ = C5046bo.getLong(parse.getQueryParameter("mid"), 0);
                        c7968b.wTK = C5046bo.getInt(parse.getQueryParameter("idx"), 0);
                        AppMethodBeat.m2505o(34556);
                        return;
                    } catch (UnsupportedOperationException e) {
                        C4990ab.m7421w("MicroMsg.ConversationAdapter", "exposeLog exp %s", e.getMessage());
                        AppMethodBeat.m2505o(34556);
                        return;
                    } catch (Exception e2) {
                        C4990ab.m7421w("MicroMsg.ConversationAdapter", "exposeLog exp %s", e2.getMessage());
                    }
                }
            }
            AppMethodBeat.m2505o(34556);
        }

        /* renamed from: a */
        public final void mo17780a(C7617ak c7617ak, int i) {
            AppMethodBeat.m2504i(34557);
            C9638aw.m17190ZK();
            mo17781a(c7617ak, C18628c.m29083XR().mo15822g(c7617ak), i, true);
            AppMethodBeat.m2505o(34557);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$11 */
    class C795811 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$11$2 */
        class C79592 implements C5279d {
            C79592() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(34545);
                switch (menuItem.getItemId()) {
                    case 1:
                        Intent intent = new Intent(NewBizConversationUI.this.mController.ylL, BizTimeLineNewMsgUI.class);
                        intent.putExtra("biz_time_line_line_enter_scene", 2);
                        NewBizConversationUI.this.startActivity(intent);
                        AppMethodBeat.m2505o(34545);
                        return;
                    default:
                        C4990ab.m7420w("MicroMsg.NewBizConversationUI", "default onMMMenuItemSelected err");
                        AppMethodBeat.m2505o(34545);
                        return;
                }
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$11$1 */
        class C79601 implements C36073c {
            C79601() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(34544);
                c44273l.mo70072hi(1, C25738R.string.a__);
                AppMethodBeat.m2505o(34544);
            }
        }

        C795811() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(34546);
            C36356d c36356d = new C36356d(NewBizConversationUI.this, 1, false);
            c36356d.rBl = new C79601();
            c36356d.rBm = new C79592();
            c36356d.cpD();
            AppMethodBeat.m2505o(34546);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$1 */
    class C79611 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$1$1 */
        class C79621 implements Runnable {
            C79621() {
            }

            public final void run() {
                AppMethodBeat.m2504i(34531);
                Intent cVd = C46400aa.cVd();
                cVd.putExtra("title", NewBizConversationUI.this.getString(C25738R.string.c2b));
                cVd.putExtra("searchbar_tips", NewBizConversationUI.this.getString(C25738R.string.c2b));
                cVd.putExtra("KRightBtn", true);
                cVd.putExtra("ftsneedkeyboard", true);
                cVd.putExtra("publishIdPrefix", "bs");
                cVd.putExtra("ftsType", 2);
                cVd.putExtra("ftsbizscene", 11);
                Map d = C46400aa.m87334d(11, true, 2);
                String HP = C46400aa.m87299HP(C5046bo.ank((String) d.get("scene")));
                d.put("sessionId", HP);
                cVd.putExtra("sessionId", HP);
                cVd.putExtra("rawUrl", C46400aa.m87298E(d));
                cVd.putExtra("key_load_js_without_delay", true);
                cVd.addFlags(67108864);
                Bundle bundle = null;
                if (VERSION.SDK_INT >= 21) {
                    bundle = ActivityOptions.makeSceneTransitionAnimation(NewBizConversationUI.this, new Pair[0]).toBundle();
                }
                String adN = C29736ac.adN("bizAccountTopSearch");
                if (!TextUtils.isEmpty(adN)) {
                    cVd.putExtra("key_search_input_hint", adN);
                }
                C25985d.m41455a(NewBizConversationUI.this, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", cVd, bundle);
                AppMethodBeat.m2505o(34531);
            }
        }

        C79611() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(34532);
            if (C46400aa.m87304HU(0)) {
                ((C40193m) C1720g.m3528K(C40193m.class)).mo63531a(C4996ah.getContext(), new C79621());
            } else {
                C4990ab.m7412e("MicroMsg.NewBizConversationUI", "fts h5 template not avail");
            }
            AppMethodBeat.m2505o(34532);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$6 */
    class C79636 implements C23599f {
        C79636() {
        }

        /* renamed from: bN */
        public final void mo11067bN(Object obj) {
            AppMethodBeat.m2504i(34537);
            if (obj == null) {
                C4990ab.m7412e("MicroMsg.NewBizConversationUI", "onItemDel object null");
                AppMethodBeat.m2505o(34537);
                return;
            }
            NewBizConversationUI.m14133b(NewBizConversationUI.this, obj.toString());
            AppMethodBeat.m2505o(34537);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$12 */
    class C796412 implements OnMenuItemClickListener {
        C796412() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(34547);
            NewBizConversationUI.this.finish();
            AppMethodBeat.m2505o(34547);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$14 */
    class C796514 implements Runnable {
        C796514() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34549);
            NewBizConversationUI.m14132b(NewBizConversationUI.this);
            NewBizConversationUI.m14135c(NewBizConversationUI.this);
            NewBizConversationUI.m14136d(NewBizConversationUI.this);
            AppMethodBeat.m2505o(34549);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$7 */
    class C79667 implements OnCancelListener {
        C79667() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(34538);
            NewBizConversationUI.this.isDeleteCancel = true;
            AppMethodBeat.m2505o(34538);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$9 */
    class C79679 implements C5279d {
        C79679() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(34541);
            switch (menuItem.getItemId()) {
                case 1:
                    C9638aw.m17190ZK();
                    C7616ad aoO = C18628c.m29078XM().aoO(NewBizConversationUI.this.talker);
                    if (aoO == null) {
                        C4990ab.m7412e("MicroMsg.NewBizConversationUI", "changed biz stick status failed, contact is null, talker = " + NewBizConversationUI.this.talker);
                        AppMethodBeat.m2505o(34541);
                        return;
                    }
                    if (aoO.mo16702Oe()) {
                        C7060h.pYm.mo8381e(13307, aoO.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2));
                        C1855t.m3969x(NewBizConversationUI.this.talker, true);
                    } else {
                        C7060h.pYm.mo8381e(13307, aoO.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2));
                        C1855t.m3967w(NewBizConversationUI.this.talker, true);
                    }
                    C9293ai c9293ai = new C9293ai();
                    c9293ai.ctg.userName = aoO.field_username;
                    C4879a.xxA.mo10055m(c9293ai);
                    AppMethodBeat.m2505o(34541);
                    return;
                case 2:
                    C9638aw.m17190ZK();
                    C40889b.m70857a(C41747z.aeR().mo43729qP(NewBizConversationUI.this.talker), NewBizConversationUI.this, C18628c.m29078XM().aoO(NewBizConversationUI.this.talker), 2);
                    AppMethodBeat.m2505o(34541);
                    return;
                case 3:
                    NewBizConversationUI.m14133b(NewBizConversationUI.this, NewBizConversationUI.this.talker);
                    break;
            }
            AppMethodBeat.m2505o(34541);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.NewBizConversationUI$b */
    static class C7968b extends brm {
        public int fPZ;
        public long wYf;

        private C7968b() {
            this.fPZ = -1;
        }

        /* synthetic */ C7968b(byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public NewBizConversationUI() {
        AppMethodBeat.m2504i(34558);
        AppMethodBeat.m2505o(34558);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(34559);
        super.onCreate(bundle);
        if (C9638aw.m17179RK()) {
            this.ctE = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
            this.cvd = getIntent().getIntExtra("biz_enter_source", 1);
            this.fuO = "officialaccounts";
            C7060h.pYm.mo8381e(11404, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.ctE), Integer.valueOf((int) (System.currentTimeMillis() / 1000)), Integer.valueOf(this.cvd));
            this.zqQ = getIntent().getStringExtra("enterprise_biz_display_name");
            if (C5046bo.isNullOrNil(this.zqQ)) {
                this.zqQ = getString(C25738R.string.a9e);
            }
            initView();
            C5141c ll = C18624c.abi().mo17131ll("100045");
            boolean z = ll.isValid() && "1".equals(ll.dru().get("isOpenSearch"));
            C4990ab.m7411d("MicroMsg.NewBizConversationUI", "open search entrance:%b", Boolean.valueOf(z));
            if (z) {
                addIconOptionMenu(1, C25738R.string.ewn, C1318a.actionbar_icon_dark_search, new C79611());
            }
            mo17393b(getString(C25738R.string.a_c), (int) C1318a.actionbar_icon_dark_more, (OnMenuItemClickListener) new C795811());
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo10118a(this.zvk);
            this.jOA = System.currentTimeMillis();
            C4879a.xxA.mo10052c(this.jOJ);
            AppMethodBeat.m2505o(34559);
            return;
        }
        C4990ab.m7412e("MicroMsg.NewBizConversationUI", "onCreate acc not ready!!!");
        finish();
        AppMethodBeat.m2505o(34559);
    }

    public final int getLayoutId() {
        return 2130970930;
    }

    private void initActionBar() {
        AppMethodBeat.m2504i(34560);
        mo17446xE(-1052684);
        setMMTitle(this.zqQ);
        mo17443ta(WebView.NIGHT_MODE_COLOR);
        setBackBtn(new C796412(), C1318a.actionbar_icon_dark_back);
        setTitleBarDoubleClickListener(new C795513());
        AppMethodBeat.m2505o(34560);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(34561);
        C9638aw.m17180RS().mo10302aa(new C796514());
        C4879a.xxA.mo10053d(this.jOJ);
        if (C9638aw.m17179RK()) {
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo10121b(this.zvk);
        }
        if (this.zvk != null) {
            this.zvk.onDestroy();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(34561);
    }

    public void onResume() {
        AppMethodBeat.m2504i(34562);
        C4990ab.m7418v("MicroMsg.NewBizConversationUI", "on resume");
        if (this.zvk != null) {
            this.zvk.onResume();
        }
        super.onResume();
        AppMethodBeat.m2505o(34562);
    }

    public void onPause() {
        AppMethodBeat.m2504i(34563);
        C4990ab.m7416i("MicroMsg.NewBizConversationUI", "on pause");
        if (this.zvk != null) {
            this.zvk.onPause();
        }
        super.onPause();
        AppMethodBeat.m2505o(34563);
    }

    public final void initView() {
        AppMethodBeat.m2504i(34564);
        initActionBar();
        this.zqO = (ListView) findViewById(2131823620);
        this.emptyTipTv = (TextView) findViewById(2131821807);
        this.emptyTipTv.setText(C25738R.string.bd8);
        this.zvk = new C7957a(this, this.fuO, new C794615());
        this.zvk.setGetViewPositionCallback(new C795416());
        this.zvk.setPerformItemClickListener(new C794717());
        this.zqO.setAdapter(this.zvk);
        this.jMO = new C24088a(this);
        this.zqO.setOnItemClickListener(new C794818());
        this.zqO.setOnTouchListener(new C79502());
        this.zqO.setOnItemLongClickListener(new C79513());
        this.zvk.setGetViewPositionCallback(new C79524());
        this.zvk.setPerformItemClickListener(new C79535());
        this.zvk.mo57142a((C23599f) new C79636());
        AppMethodBeat.m2505o(34564);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(34565);
        super.onActivityResult(i, i2, intent);
        if (!(this.talker == null || this.talker.isEmpty())) {
            this.talker = "";
        }
        if (i2 != -1) {
            AppMethodBeat.m2505o(34565);
        } else {
            AppMethodBeat.m2505o(34565);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(34566);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        C9638aw.m17190ZK();
        C7616ad aoO = C18628c.m29078XM().aoO(this.talker);
        if (aoO == null) {
            C4990ab.m7412e("MicroMsg.NewBizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
            AppMethodBeat.m2505o(34566);
            return;
        }
        CharSequence Oj = aoO.mo16707Oj();
        if (Oj.toLowerCase().endsWith("@chatroom") && C5046bo.isNullOrNil(aoO.field_nickname)) {
            Oj = getString(C25738R.string.ao1);
        }
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        contextMenu.setHeaderTitle(C44089j.m79292b((Context) this, Oj));
        if (C7486a.m12942jh(aoO.field_type)) {
            if (aoO.mo16702Oe()) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, C25738R.string.a9d);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, C25738R.string.a9c);
            }
            contextMenu.add(adapterContextMenuInfo.position, 2, 0, C25738R.string.cvi);
        }
        contextMenu.add(adapterContextMenuInfo.position, 3, 0, C25738R.string.cvq);
        AppMethodBeat.m2505o(34566);
    }

    /* renamed from: a */
    static /* synthetic */ void m14129a(NewBizConversationUI newBizConversationUI) {
        AppMethodBeat.m2504i(34567);
        if (!(newBizConversationUI.zvk == null || newBizConversationUI.zqO == null || newBizConversationUI.zvk.getCount() <= 0)) {
            newBizConversationUI.zqO.setSelection(0);
        }
        AppMethodBeat.m2505o(34567);
    }

    /* renamed from: b */
    static /* synthetic */ void m14132b(NewBizConversationUI newBizConversationUI) {
        AppMethodBeat.m2504i(34568);
        if (C9638aw.m17179RK()) {
            long currentTimeMillis = System.currentTimeMillis();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            long j = 0;
            int i4 = 0;
            StringBuilder stringBuilder = new StringBuilder("");
            C9638aw.m17190ZK();
            Cursor c = C18628c.m29083XR().mo15804c(C1855t.fkP, null, newBizConversationUI.fuO);
            if (c != null) {
                int columnIndex = c.getColumnIndex("unReadCount");
                int columnIndex2 = c.getColumnIndex("conversationTime");
                int columnIndex3 = c.getColumnIndex("flag");
                int count = c.getCount();
                C7617ak c7617ak = new C7617ak();
                while (c.moveToNext()) {
                    c7617ak.mo14743eE(c.getLong(columnIndex3));
                    i4 = c.getInt(columnIndex);
                    if (i4 > 0) {
                        j = c.getLong(columnIndex2);
                        i2++;
                        i += i4;
                    } else {
                        i4 = 0;
                    }
                    stringBuilder.append(c.isFirst() ? "" : ".").append(i4);
                    C9638aw.m17190ZK();
                    if (C18628c.m29083XR().mo15822g(c7617ak)) {
                        i3++;
                    }
                }
                c.close();
                i4 = count;
            }
            C7060h.pYm.mo8381e(13771, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(j / 1000), Integer.valueOf(i3), stringBuilder.toString());
            C4990ab.m7419v("MicroMsg.NewBizConversationUI", "report use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        AppMethodBeat.m2505o(34568);
    }

    /* renamed from: c */
    static /* synthetic */ void m14135c(NewBizConversationUI newBizConversationUI) {
        AppMethodBeat.m2504i(34569);
        if (newBizConversationUI.jOA != 0) {
            C7060h.pYm.mo8381e(13932, Integer.valueOf(((int) (System.currentTimeMillis() - newBizConversationUI.jOA)) / 1000), Integer.valueOf(2), Integer.valueOf(newBizConversationUI.ctE), Integer.valueOf(0), Integer.valueOf(newBizConversationUI.cvd));
        }
        AppMethodBeat.m2505o(34569);
    }

    /* renamed from: d */
    static /* synthetic */ void m14136d(NewBizConversationUI newBizConversationUI) {
        AppMethodBeat.m2504i(34570);
        if (newBizConversationUI.zvk != null) {
            LinkedList linkedList = new LinkedList();
            for (Entry entry : newBizConversationUI.zvk.jOf.entrySet()) {
                boolean z;
                C7968b c7968b = (C7968b) entry.getValue();
                brm brm = new brm();
                brm.vMR = (String) entry.getKey();
                brm.wTJ = c7968b.wTJ;
                brm.wTK = c7968b.wTK;
                brm.ndr = c7968b.ndr;
                if (c7968b.fPZ > 0) {
                    z = true;
                } else {
                    z = false;
                }
                brm.wTM = z;
                brm.wTO = c7968b.wTO;
                brm.wTL = c7968b.wTL;
                brm.wTN = c7968b.wTN;
                linkedList.add(brm);
            }
            C1720g.m3535RO().eJo.mo14541a(new C37456x(linkedList), 0);
            C4990ab.m7411d("MicroMsg.NewBizConversationUI", "reportExpose size:%d", Integer.valueOf(linkedList.size()));
        }
        AppMethodBeat.m2505o(34570);
    }
}
