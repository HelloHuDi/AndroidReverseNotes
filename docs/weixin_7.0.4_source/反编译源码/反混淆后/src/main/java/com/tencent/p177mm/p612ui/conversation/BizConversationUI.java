package com.tencent.p177mm.p612ui.conversation;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C6504k;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.conversation.BaseConversationUI.BaseConversationFmUI;
import com.tencent.p177mm.p612ui.tools.C40889b;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C37985b.C9787b;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.websearch.api.C40193m;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.pluginsdk.C30036f;
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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.ui.conversation.BizConversationUI */
public class BizConversationUI extends BaseConversationUI {
    private View contentView;

    /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI */
    public static class BizConversationFmUI extends BaseConversationFmUI {
        private C7617ak conversation;
        private int cvd = 1;
        private TextView emptyTipTv;
        private String fuO;
        private boolean isDeleteCancel = false;
        private int jLX = 0;
        private int jLY = 0;
        private C24088a jMO;
        private long jOA = 0;
        private C4884c jOJ = new C1703710();
        private C5279d jOb = new C170489();
        private String talker = "";
        private C44275p tipDialog = null;
        private ListView zqO;
        private C17035a zqP;
        private String zqQ;

        /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$6 */
        class C158496 implements C23599f {
            C158496() {
            }

            /* renamed from: bN */
            public final void mo11067bN(Object obj) {
                AppMethodBeat.m2504i(34121);
                if (obj == null) {
                    C4990ab.m7412e("MicroMsg.BizConversationUI", "onItemDel object null");
                    AppMethodBeat.m2505o(34121);
                    return;
                }
                BizConversationFmUI.m26351b(BizConversationFmUI.this, obj.toString());
                AppMethodBeat.m2505o(34121);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$11 */
        class C1703211 implements IdleHandler {
            C1703211() {
            }

            public final boolean queueIdle() {
                AppMethodBeat.m2504i(34128);
                Looper.myQueue().removeIdleHandler(this);
                C45287c.aNX();
                AppMethodBeat.m2505o(34128);
                return false;
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$18 */
        class C1703318 implements OnItemClickListener {
            C1703318() {
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(34135);
                BizConversationFmUI.this.conversation = (C7617ak) BizConversationFmUI.this.zqP.getItem(i);
                BizConversationFmUI.this.talker = BizConversationFmUI.this.conversation.field_username;
                C7617ak f = BizConversationFmUI.this.conversation;
                if (f == null) {
                    C4990ab.m7413e("MicroMsg.BizConversationUI", "user should not be null. position:%d, size:%d", Integer.valueOf(i), Integer.valueOf(BizConversationFmUI.this.zqP.getCount()));
                    BizConversationFmUI.this.zqP.notifyDataSetChanged();
                    AppMethodBeat.m2505o(34135);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("biz_click_item_unread_count", BizConversationFmUI.this.conversation.field_unReadCount);
                bundle.putInt("biz_click_item_position", i + 1);
                bundle.putInt("KOpenArticleSceneFromScene", 131);
                bundle.putInt("specific_chat_from_scene", 1);
                BizConversationFmUI.this.f2991ui.startChatting(f.field_username, bundle, true);
                BizConversationFmUI.this.zqP.mo31103a(f, i);
                AppMethodBeat.m2505o(34135);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$a */
        static class C17035a extends C36282e {
            private String cIe;
            HashMap<String, C17036b> jOf = new HashMap();

            public C17035a(Context context, String str, C30723a c30723a) {
                super(context, c30723a);
                AppMethodBeat.m2504i(34136);
                this.cIe = str;
                AppMethodBeat.m2505o(34136);
            }

            /* renamed from: KC */
            public final void mo6869KC() {
                AppMethodBeat.m2504i(34137);
                C9638aw.m17190ZK();
                setCursor(C18628c.m29083XR().mo15804c(C1855t.fkP, this.elZ, this.cIe));
                if (this.yle != null) {
                    this.yle.apt();
                }
                super.notifyDataSetChanged();
                AppMethodBeat.m2505o(34137);
            }

            /* Access modifiers changed, original: protected|final */
            /* renamed from: a */
            public final void mo17781a(C7617ak c7617ak, boolean z, int i, boolean z2) {
                AppMethodBeat.m2504i(34138);
                if (c7617ak == null) {
                    AppMethodBeat.m2505o(34138);
                    return;
                }
                C17036b c17036b;
                C17036b c17036b2 = (C17036b) this.jOf.get(c7617ak.field_username);
                if (c17036b2 == null) {
                    c17036b2 = new C17036b();
                    this.jOf.put(c7617ak.field_username, c17036b2);
                    c17036b = c17036b2;
                } else {
                    c17036b = c17036b2;
                }
                if (c17036b.fPZ > 0) {
                    AppMethodBeat.m2505o(34138);
                    return;
                }
                c17036b.wTL = z;
                boolean z3 = c17036b.wTO || c7617ak.field_unReadCount > 0;
                c17036b.wTO = z3;
                c17036b.ndr = i + 1;
                if (z2) {
                    c17036b.fPZ = c17036b.ndr;
                }
                c17036b.wTN = (int) (System.currentTimeMillis() / 1000);
                if (c7617ak.field_lastSeq == c17036b.wYf) {
                    AppMethodBeat.m2505o(34138);
                    return;
                }
                c17036b.wYf = c7617ak.field_lastSeq;
                C7620bi Rb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(c7617ak.field_username);
                if (Rb != null && Rb.drC()) {
                    C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(Rb.field_msgId, Rb.field_content);
                    if (!(b == null || C5046bo.m7548ek(b.fjr) || C5046bo.isNullOrNil(((C32224p) b.fjr.get(0)).url))) {
                        try {
                            Uri parse = Uri.parse(((C32224p) b.fjr.get(0)).url);
                            c17036b.wTJ = C5046bo.getLong(parse.getQueryParameter("mid"), 0);
                            c17036b.wTK = C5046bo.getInt(parse.getQueryParameter("idx"), 0);
                            AppMethodBeat.m2505o(34138);
                            return;
                        } catch (UnsupportedOperationException e) {
                            C4990ab.m7421w("MicroMsg.ConversationAdapter", "exposeLog exp %s", e.getMessage());
                            AppMethodBeat.m2505o(34138);
                            return;
                        } catch (Exception e2) {
                            C4990ab.m7421w("MicroMsg.ConversationAdapter", "exposeLog exp %s", e2.getMessage());
                        }
                    }
                }
                AppMethodBeat.m2505o(34138);
            }

            /* renamed from: a */
            public final void mo31103a(C7617ak c7617ak, int i) {
                AppMethodBeat.m2504i(34139);
                C9638aw.m17190ZK();
                mo17781a(c7617ak, C18628c.m29083XR().mo15822g(c7617ak), i, true);
                AppMethodBeat.m2505o(34139);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$b */
        static class C17036b extends brm {
            public int fPZ;
            public long wYf;

            private C17036b() {
                this.fPZ = -1;
            }

            /* synthetic */ C17036b(byte b) {
                this();
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$10 */
        class C1703710 extends C4884c<C6504k> {
            C1703710() {
                AppMethodBeat.m2504i(34126);
                this.xxI = C6504k.class.getName().hashCode();
                AppMethodBeat.m2505o(34126);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(34127);
                C6504k c6504k = (C6504k) c4883b;
                if (!(c6504k == null || c6504k.csh == null || c6504k.csh.csi)) {
                    BizConversationFmUI.this.jOA = 0;
                }
                AppMethodBeat.m2505o(34127);
                return false;
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$17 */
        class C1703817 implements C23600g {
            C1703817() {
            }

            /* renamed from: q */
            public final void mo11108q(View view, int i, int i2) {
                AppMethodBeat.m2504i(34134);
                BizConversationFmUI.this.zqO.performItemClick(view, i, (long) i2);
                AppMethodBeat.m2505o(34134);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$5 */
        class C170395 implements C23600g {
            C170395() {
            }

            /* renamed from: q */
            public final void mo11108q(View view, int i, int i2) {
                AppMethodBeat.m2504i(34120);
                BizConversationFmUI.this.zqO.performItemClick(view, i, (long) i2);
                AppMethodBeat.m2505o(34120);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$7 */
        class C170407 implements OnCancelListener {
            C170407() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(34122);
                BizConversationFmUI.this.isDeleteCancel = true;
                AppMethodBeat.m2505o(34122);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$1 */
        class C170411 implements OnMenuItemClickListener {

            /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$1$1 */
            class C158481 implements Runnable {
                C158481() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(34115);
                    Intent cVd = C46400aa.cVd();
                    cVd.putExtra("title", BizConversationFmUI.this.getString(C25738R.string.c2b));
                    cVd.putExtra("searchbar_tips", BizConversationFmUI.this.getString(C25738R.string.c2b));
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
                        bundle = ActivityOptions.makeSceneTransitionAnimation(BizConversationFmUI.this.thisActivity(), new Pair[0]).toBundle();
                    }
                    C25985d.m41455a(BizConversationFmUI.this.thisActivity(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", cVd, bundle);
                    AppMethodBeat.m2505o(34115);
                }
            }

            C170411() {
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.m2504i(34116);
                if (C46400aa.m87304HU(0)) {
                    ((C40193m) C1720g.m3528K(C40193m.class)).mo63531a(C4996ah.getContext(), new C158481());
                } else {
                    C4990ab.m7412e("MicroMsg.BizConversationUI", "fts h5 template not avail");
                }
                AppMethodBeat.m2505o(34116);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$13 */
        class C1704213 implements OnMenuItemClickListener {
            C1704213() {
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.m2504i(34130);
                BizConversationFmUI.this.finish();
                AppMethodBeat.m2505o(34130);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$16 */
        class C1704316 implements C15521c {
            C1704316() {
            }

            /* renamed from: cZ */
            public final int mo8831cZ(View view) {
                AppMethodBeat.m2504i(34133);
                int positionForView = BizConversationFmUI.this.zqO.getPositionForView(view);
                AppMethodBeat.m2505o(34133);
                return positionForView;
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$2 */
        class C170442 implements OnTouchListener {
            C170442() {
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(34117);
                switch (motionEvent.getAction()) {
                    case 0:
                        BizConversationFmUI.this.jLX = (int) motionEvent.getRawX();
                        BizConversationFmUI.this.jLY = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.m2505o(34117);
                return false;
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$4 */
        class C170454 implements C15521c {
            C170454() {
            }

            /* renamed from: cZ */
            public final int mo8831cZ(View view) {
                AppMethodBeat.m2504i(34119);
                int positionForView = BizConversationFmUI.this.zqO.getPositionForView(view);
                AppMethodBeat.m2505o(34119);
                return positionForView;
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$14 */
        class C1704614 implements OnClickListener {
            C1704614() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(34131);
                C9787b.m17426a(BizConversationFmUI.this.zqO);
                AppMethodBeat.m2505o(34131);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$15 */
        class C1704715 implements C30723a {
            C1704715() {
            }

            public final void apt() {
                AppMethodBeat.m2504i(34132);
                BizConversationFmUI.m26348a(BizConversationFmUI.this, BizConversationFmUI.this.zqP.getCount());
                AppMethodBeat.m2505o(34132);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$9 */
        class C170489 implements C5279d {
            C170489() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(34125);
                switch (menuItem.getItemId()) {
                    case 1:
                        C9638aw.m17190ZK();
                        C7616ad aoO = C18628c.m29078XM().aoO(BizConversationFmUI.this.talker);
                        if (aoO == null) {
                            C4990ab.m7412e("MicroMsg.BizConversationUI", "changed biz stick status failed, contact is null, talker = " + BizConversationFmUI.this.talker);
                            AppMethodBeat.m2505o(34125);
                            return;
                        } else if (aoO.mo16702Oe()) {
                            C7060h.pYm.mo8381e(13307, aoO.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2));
                            C1855t.m3969x(BizConversationFmUI.this.talker, true);
                            AppMethodBeat.m2505o(34125);
                            return;
                        } else {
                            C7060h.pYm.mo8381e(13307, aoO.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2));
                            C1855t.m3967w(BizConversationFmUI.this.talker, true);
                            AppMethodBeat.m2505o(34125);
                            return;
                        }
                    case 2:
                        C9638aw.m17190ZK();
                        C40889b.m70857a(C41747z.aeR().mo43729qP(BizConversationFmUI.this.talker), BizConversationFmUI.this.thisActivity(), C18628c.m29078XM().aoO(BizConversationFmUI.this.talker), 2);
                        AppMethodBeat.m2505o(34125);
                        return;
                    case 3:
                        BizConversationFmUI.m26351b(BizConversationFmUI.this, BizConversationFmUI.this.talker);
                        break;
                }
                AppMethodBeat.m2505o(34125);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$12 */
        class C1704912 implements Runnable {
            C1704912() {
            }

            public final void run() {
                AppMethodBeat.m2504i(34129);
                BizConversationFmUI.m26347a(BizConversationFmUI.this);
                BizConversationFmUI.m26350b(BizConversationFmUI.this);
                BizConversationFmUI.m26353c(BizConversationFmUI.this);
                AppMethodBeat.m2505o(34129);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.BizConversationUI$BizConversationFmUI$3 */
        class C170503 implements OnItemLongClickListener {
            C170503() {
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(34118);
                BizConversationFmUI.this.conversation = (C7617ak) BizConversationFmUI.this.zqP.getItem(i);
                BizConversationFmUI.this.talker = BizConversationFmUI.this.conversation.field_username;
                BizConversationFmUI.this.jMO.mo39885a(view, i, j, BizConversationFmUI.this, BizConversationFmUI.this.jOb, BizConversationFmUI.this.jLX, BizConversationFmUI.this.jLY);
                AppMethodBeat.m2505o(34118);
                return true;
            }
        }

        public BizConversationFmUI() {
            AppMethodBeat.m2504i(34140);
            AppMethodBeat.m2505o(34140);
        }

        public void onActivityCreated(Bundle bundle) {
            AppMethodBeat.m2504i(34141);
            super.onActivityCreated(bundle);
            this.fuO = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
            if (C5046bo.isNullOrNil(this.fuO)) {
                this.fuO = "officialaccounts";
            }
            this.cvd = thisActivity().getIntent().getIntExtra("biz_enter_source", 1);
            if (C5046bo.nullAsNil(this.fuO).equals("officialaccounts")) {
                C7060h.pYm.mo8381e(11404, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf((int) (System.currentTimeMillis() / 1000)), Integer.valueOf(this.cvd));
            }
            this.zqQ = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
            if (C5046bo.isNullOrNil(this.zqQ)) {
                this.zqQ = getString(C25738R.string.a9e);
            }
            setMMTitle(this.zqQ);
            this.zqO = (ListView) findViewById(2131823620);
            this.emptyTipTv = (TextView) findViewById(2131821807);
            this.emptyTipTv.setText(C25738R.string.bd8);
            setBackBtn(new C1704213());
            setToTop(new C1704614());
            this.zqP = new C17035a(thisActivity(), this.fuO, new C1704715());
            this.zqP.setGetViewPositionCallback(new C1704316());
            this.zqP.setPerformItemClickListener(new C1703817());
            this.zqO.setAdapter(this.zqP);
            this.jMO = new C24088a(thisActivity());
            this.zqO.setOnItemClickListener(new C1703318());
            this.zqO.setOnTouchListener(new C170442());
            this.zqO.setOnItemLongClickListener(new C170503());
            this.zqP.setGetViewPositionCallback(new C170454());
            this.zqP.setPerformItemClickListener(new C170395());
            this.zqP.mo57142a((C23599f) new C158496());
            if ("officialaccounts".equals(this.fuO)) {
                C5141c ll = C18624c.abi().mo17131ll("100045");
                boolean z = ll.isValid() && "1".equals(ll.dru().get("isOpenSearch"));
                C4990ab.m7411d("MicroMsg.BizConversationUI", "open search entrance:%b", Boolean.valueOf(z));
                if (z) {
                    addIconOptionMenu(1, (int) C25738R.string.ewn, (int) C1318a.actionbar_icon_dark_search, (OnMenuItemClickListener) new C170411());
                }
            }
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo10118a(this.zqP);
            this.jOA = System.currentTimeMillis();
            C4879a.xxA.mo10052c(this.jOJ);
            Looper.myQueue().addIdleHandler(new C1703211());
            AppMethodBeat.m2505o(34141);
        }

        public int getLayoutId() {
            return 2130970930;
        }

        public String getUserName() {
            return this.fuO;
        }

        public void onDestroy() {
            AppMethodBeat.m2504i(34142);
            C9638aw.m17180RS().mo10302aa(new C1704912());
            C4879a.xxA.mo10053d(this.jOJ);
            if (C9638aw.m17179RK()) {
                C9638aw.m17190ZK();
                C18628c.m29083XR().mo10121b(this.zqP);
            }
            if (this.zqP != null) {
                this.zqP.onDestroy();
            }
            super.onDestroy();
            AppMethodBeat.m2505o(34142);
        }

        public void onResume() {
            AppMethodBeat.m2504i(34143);
            C4990ab.m7418v("MicroMsg.BizConversationUI", "on resume");
            if (this.zqP != null) {
                this.zqP.onResume();
            }
            super.onResume();
            AppMethodBeat.m2505o(34143);
        }

        public void onPause() {
            AppMethodBeat.m2504i(34144);
            C4990ab.m7416i("MicroMsg.BizConversationUI", "on pause");
            C9638aw.m17190ZK();
            C18628c.m29083XR().apb(this.fuO);
            if (this.zqP != null) {
                this.zqP.onPause();
            }
            super.onPause();
            AppMethodBeat.m2505o(34144);
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(34145);
            super.onActivityResult(i, i2, intent);
            if (!(this.talker == null || this.talker.isEmpty())) {
                this.talker = "";
            }
            if (i2 != -1) {
                AppMethodBeat.m2505o(34145);
            } else {
                AppMethodBeat.m2505o(34145);
            }
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(34146);
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(this.talker);
            if (aoO == null) {
                C4990ab.m7412e("MicroMsg.BizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
                AppMethodBeat.m2505o(34146);
                return;
            }
            CharSequence Oj = aoO.mo16707Oj();
            if (Oj.toLowerCase().endsWith("@chatroom") && C5046bo.isNullOrNil(aoO.field_nickname)) {
                Oj = getString(C25738R.string.ao1);
            }
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            contextMenu.setHeaderTitle(C44089j.m79292b(thisActivity(), Oj));
            if (C7486a.m12942jh(aoO.field_type)) {
                if (aoO.mo16702Oe()) {
                    contextMenu.add(adapterContextMenuInfo.position, 1, 0, C25738R.string.cvm);
                } else {
                    contextMenu.add(adapterContextMenuInfo.position, 1, 0, C25738R.string.b1r);
                }
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, C25738R.string.cvi);
            }
            contextMenu.add(adapterContextMenuInfo.position, 3, 0, C25738R.string.cvq);
            AppMethodBeat.m2505o(34146);
        }

        /* renamed from: a */
        static /* synthetic */ void m26347a(BizConversationFmUI bizConversationFmUI) {
            AppMethodBeat.m2504i(34147);
            if (C9638aw.m17179RK() && "officialaccounts".equals(bizConversationFmUI.fuO)) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                long j = 0;
                int i4 = 0;
                StringBuilder stringBuilder = new StringBuilder("");
                C9638aw.m17190ZK();
                Cursor c = C18628c.m29083XR().mo15804c(C1855t.fkP, null, bizConversationFmUI.fuO);
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
                C4990ab.m7419v("MicroMsg.BizConversationUI", "report use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(34147);
                return;
            }
            AppMethodBeat.m2505o(34147);
        }

        /* renamed from: b */
        static /* synthetic */ void m26350b(BizConversationFmUI bizConversationFmUI) {
            AppMethodBeat.m2504i(34148);
            if (bizConversationFmUI.jOA != 0 && "officialaccounts".equals(bizConversationFmUI.fuO)) {
                C7060h.pYm.mo8381e(13932, Integer.valueOf(((int) (System.currentTimeMillis() - bizConversationFmUI.jOA)) / 1000), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bizConversationFmUI.cvd));
            }
            AppMethodBeat.m2505o(34148);
        }

        /* renamed from: c */
        static /* synthetic */ void m26353c(BizConversationFmUI bizConversationFmUI) {
            AppMethodBeat.m2504i(34149);
            if (bizConversationFmUI.zqP != null) {
                LinkedList linkedList = new LinkedList();
                for (Entry entry : bizConversationFmUI.zqP.jOf.entrySet()) {
                    boolean z;
                    C17036b c17036b = (C17036b) entry.getValue();
                    brm brm = new brm();
                    brm.vMR = (String) entry.getKey();
                    brm.wTJ = c17036b.wTJ;
                    brm.wTK = c17036b.wTK;
                    brm.ndr = c17036b.ndr;
                    if (c17036b.fPZ > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    brm.wTM = z;
                    brm.wTO = c17036b.wTO;
                    brm.wTL = c17036b.wTL;
                    brm.wTN = c17036b.wTN;
                    linkedList.add(brm);
                }
                C1720g.m3535RO().eJo.mo14541a(new C37456x(linkedList), 0);
                C4990ab.m7411d("MicroMsg.BizConversationUI", "reportExpose size:%d", Integer.valueOf(linkedList.size()));
            }
            AppMethodBeat.m2505o(34149);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(34152);
        super.onCreate(bundle);
        if (C9638aw.m17179RK()) {
            this.contentView = C5616v.m8409hu(this).inflate(2130968881, null);
            setContentView(this.contentView);
            this.conversationFm = new BizConversationFmUI();
            getSupportFragmentManager().beginTransaction().mo552a(2131821892, this.conversationFm).commit();
            C30036f.m47539a(this, this.contentView);
            AppMethodBeat.m2505o(34152);
            return;
        }
        C4990ab.m7412e("MicroMsg.BizConversationUI", "onCreate acc not ready!!!");
        finish();
        AppMethodBeat.m2505o(34152);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(34153);
        super.onConfigurationChanged(configuration);
        C30036f.m47539a(this, this.contentView);
        AppMethodBeat.m2505o(34153);
    }
}
