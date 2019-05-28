package com.tencent.p177mm.p612ui.bizchat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C25772n;
import com.tencent.p177mm.p184aj.C36692b;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.C8927c;
import com.tencent.p177mm.p184aj.C8927c.C8929a;
import com.tencent.p177mm.p184aj.C8927c.C8929a.C8930a;
import com.tencent.p177mm.p184aj.p185a.C17900n;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p184aj.p185a.C25759h;
import com.tencent.p177mm.p184aj.p185a.C32232a;
import com.tencent.p177mm.p184aj.p185a.C37446b;
import com.tencent.p177mm.p184aj.p185a.C37446b.C37447a;
import com.tencent.p177mm.p184aj.p185a.C37446b.C37447a.C32233b;
import com.tencent.p177mm.p184aj.p185a.C37448d.C25753a;
import com.tencent.p177mm.p184aj.p185a.C37448d.C25753a.C8924b;
import com.tencent.p177mm.p184aj.p185a.C45142c;
import com.tencent.p177mm.p184aj.p185a.C45143j;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C36295g;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.conversation.BaseConversationUI;
import com.tencent.p177mm.p612ui.conversation.BaseConversationUI.BaseConversationFmUI;
import com.tencent.p177mm.p612ui.tools.C40890k;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.protocal.protobuf.acr;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI */
public class BizChatConversationUI extends BaseConversationUI {
    private View contentView;

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI */
    public static class BizChatConversationFmUI extends BaseConversationFmUI implements C25772n, C4937b {
        private TextView emptyTipTv;
        private String fvM;
        private boolean isCurrentActivity;
        private boolean isDeleteCancel = false;
        private ListView jJY;
        private C5279d jKa;
        private C40890k jLO;
        private int jLX = 0;
        private int jLY = 0;
        private long jMj;
        private String jMp;
        private C44275p tipDialog;
        private LinearLayout yEi;
        private C40687b yEj;
        private C45143j yEk;
        private int yEl = 0;
        private C37447a yEm = new C3609511();
        private C25753a yEn = new C3609613();
        private C8929a yEo = new C1554614();

        /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$5 */
        class C52905 implements OnMenuItemClickListener {

            /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$5$1 */
            class C52911 implements C36073c {
                C52911() {
                }

                /* renamed from: a */
                public final void mo5746a(C44273l c44273l) {
                    AppMethodBeat.m2504i(30059);
                    if (BizChatConversationFmUI.this.yEl == 1) {
                        c44273l.mo70063ax(2, C25738R.string.be8, C1318a.actionbar_goto_wework_icon);
                        C36295g.m59750t(BizChatConversationFmUI.this.getContext(), BizChatConversationFmUI.this.jMp, 6);
                    }
                    c44273l.mo70063ax(1, C25738R.string.a_n, C1318a.actionbar_create_biz_chat_icon);
                    c44273l.mo70051a(4, BizChatConversationFmUI.this.getResources().getString(C25738R.string.a_m), C5225ah.m7962f(BizChatConversationFmUI.this.getContext(), C1318a.actionbar_facefriend_icon, -1));
                    c44273l.mo70051a(3, BizChatConversationFmUI.this.getResources().getString(C25738R.string.f8699cg), C5225ah.m7962f(BizChatConversationFmUI.this.getContext(), C1318a.actionbar_setting_white_icon, -1));
                    AppMethodBeat.m2505o(30059);
                }
            }

            /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$5$2 */
            class C52922 implements C5279d {
                C52922() {
                }

                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(30060);
                    Intent intent;
                    switch (menuItem.getItemId()) {
                        case 1:
                            BizChatConversationFmUI.m59412m(BizChatConversationFmUI.this);
                            AppMethodBeat.m2505o(30060);
                            return;
                        case 2:
                            C36295g.m59751u(BizChatConversationFmUI.this.getContext(), BizChatConversationFmUI.this.jMp, 6);
                            AppMethodBeat.m2505o(30060);
                            return;
                        case 3:
                            if (C5046bo.isNullOrNil(BizChatConversationFmUI.this.fvM)) {
                                BizChatConversationFmUI.this.fvM = C41747z.aeR().mo43729qP(BizChatConversationFmUI.this.jMp).adX();
                            }
                            if (!C5046bo.isNullOrNil(BizChatConversationFmUI.this.fvM) && C41747z.afd().mo52930qB(BizChatConversationFmUI.this.fvM)) {
                                C41747z.afa();
                                C8927c.m16090a(BizChatConversationFmUI.this.fvM, null);
                            }
                            intent = new Intent();
                            intent.putExtra("Contact_User", BizChatConversationFmUI.this.jMp);
                            C25985d.m41467b(BizChatConversationFmUI.this.thisActivity(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                            AppMethodBeat.m2505o(30060);
                            return;
                        case 4:
                            if (C5046bo.isNullOrNil(BizChatConversationFmUI.this.jMp)) {
                                C4990ab.m7412e("MicroMsg.BizChatConversationFmUI", "brandUserName null");
                                break;
                            }
                            intent = new Intent(BizChatConversationFmUI.this.getContext(), BizChatFavUI.class);
                            intent.putExtra("Contact_User", BizChatConversationFmUI.this.jMp);
                            intent.addFlags(67108864);
                            BizChatConversationFmUI.this.startActivity(intent);
                            AppMethodBeat.m2505o(30060);
                            return;
                    }
                    AppMethodBeat.m2505o(30060);
                }
            }

            C52905() {
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.m2504i(30061);
                if (BizChatConversationFmUI.this.jLO != null) {
                    BizChatConversationFmUI.this.jLO.dismiss();
                    BizChatConversationFmUI.this.jLO = null;
                }
                BizChatConversationFmUI.this.jLO = new C40890k(BizChatConversationFmUI.this.getContext());
                BizChatConversationFmUI.this.jLO.rBl = new C52911();
                BizChatConversationFmUI.this.jLO.rBm = new C52922();
                BizChatConversationFmUI.this.jLO.mo49182gP();
                AppMethodBeat.m2505o(30061);
                return false;
            }
        }

        /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$7 */
        class C52947 implements OnCancelListener {
            C52947() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(30063);
                BizChatConversationFmUI.this.isDeleteCancel = true;
                AppMethodBeat.m2505o(30063);
            }
        }

        /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$9 */
        class C52959 implements OnCancelListener {
            C52959() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(30066);
                BizChatConversationFmUI.this.finish();
                AppMethodBeat.m2505o(30066);
            }
        }

        /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$14 */
        class C1554614 implements C8929a {
            C1554614() {
            }

            /* renamed from: a */
            public final void mo20352a(C8930a c8930a) {
                AppMethodBeat.m2504i(30071);
                String d = BizChatConversationFmUI.m59403d(BizChatConversationFmUI.this);
                if (!(c8930a == null || C5046bo.isNullOrNil(c8930a.fuO) || !c8930a.fuO.equals(d))) {
                    int l = BizChatConversationFmUI.this.yEl;
                    BizChatConversationFmUI.this.yEl = C36295g.m59747bK(BizChatConversationFmUI.this.getContext(), d);
                    if (BizChatConversationFmUI.this.yEl != l) {
                        BizChatConversationFmUI.m59418r(BizChatConversationFmUI.this);
                    }
                }
                AppMethodBeat.m2505o(30071);
            }
        }

        /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$16 */
        class C1554716 implements OnTouchListener {
            C1554716() {
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(30073);
                if (motionEvent.getAction() == 0) {
                    BizChatConversationFmUI.this.jLX = (int) motionEvent.getRawX();
                    BizChatConversationFmUI.this.jLY = (int) motionEvent.getRawY();
                }
                AppMethodBeat.m2505o(30073);
                return false;
            }
        }

        /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$20 */
        class C2364620 implements C15521c {
            C2364620() {
            }

            /* renamed from: cZ */
            public final int mo8831cZ(View view) {
                AppMethodBeat.m2504i(30077);
                int positionForView = BizChatConversationFmUI.this.jJY.getPositionForView(view);
                AppMethodBeat.m2505o(30077);
                return positionForView;
            }
        }

        /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$21 */
        class C2364721 implements C23600g {
            C2364721() {
            }

            /* renamed from: q */
            public final void mo11108q(View view, int i, int i2) {
                AppMethodBeat.m2504i(30078);
                BizChatConversationFmUI.this.jJY.performItemClick(view, i, (long) i2);
                AppMethodBeat.m2505o(30078);
            }
        }

        /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$15 */
        class C3040015 implements C5279d {
            C3040015() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(30072);
                C32232a fv;
                switch (menuItem.getItemId()) {
                    case 0:
                        BizChatConversationFmUI.m59396a(BizChatConversationFmUI.this, BizChatConversationFmUI.this.jMj);
                        AppMethodBeat.m2505o(30072);
                        return;
                    case 1:
                        fv = C41747z.aeU().mo60340fv(BizChatConversationFmUI.this.jMj);
                        fv.field_unReadCount = 1;
                        fv.field_atCount = 0;
                        C41747z.aeU().mo60337b(fv);
                        C45457b.fRa.mo73254Q(fv.field_brandUserName, true);
                        AppMethodBeat.m2505o(30072);
                        return;
                    case 2:
                        C41747z.aeU().mo60342fx(BizChatConversationFmUI.this.jMj);
                        C45457b.fRa.mo73254Q(C41747z.aeU().mo60340fv(BizChatConversationFmUI.this.jMj).field_brandUserName, false);
                        AppMethodBeat.m2505o(30072);
                        return;
                    case 3:
                        fv = C41747z.aeU().mo60340fv(BizChatConversationFmUI.this.jMj);
                        if (!C41747z.aeU().mo60343fy(BizChatConversationFmUI.this.jMj)) {
                            C41747z.aeU().mo60344fz(BizChatConversationFmUI.this.jMj);
                            C45457b.fRa.mo73263c(true, fv.field_brandUserName, true);
                            break;
                        }
                        C41747z.aeU().mo60338fA(BizChatConversationFmUI.this.jMj);
                        C45457b.fRa.mo73263c(true, fv.field_brandUserName, false);
                        AppMethodBeat.m2505o(30072);
                        return;
                }
                AppMethodBeat.m2505o(30072);
            }
        }

        /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$18 */
        class C3040118 implements OnItemClickListener {
            C3040118() {
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(30075);
                BizChatConversationFmUI.m59400b(BizChatConversationFmUI.this, ((C32232a) BizChatConversationFmUI.this.yEj.getItem(i)).field_bizChatId);
                AppMethodBeat.m2505o(30075);
            }
        }

        /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$2 */
        class C360882 implements C23599f {
            C360882() {
            }

            /* renamed from: bN */
            public final void mo11067bN(Object obj) {
                AppMethodBeat.m2504i(30056);
                if (obj == null) {
                    C4990ab.m7412e("MicroMsg.BizChatConversationFmUI", "onItemDel object null");
                    AppMethodBeat.m2505o(30056);
                    return;
                }
                AppMethodBeat.m2505o(30056);
            }
        }

        /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$3 */
        class C360893 implements OnMenuItemClickListener {
            C360893() {
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.m2504i(30057);
                BizChatConversationFmUI.this.finish();
                AppMethodBeat.m2505o(30057);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$4 */
        class C360904 implements OnMenuItemClickListener {
            C360904() {
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.m2504i(30058);
                C4990ab.m7418v("MicroMsg.BizChatConversationFmUI", "search btn was clicked.");
                Intent intent = new Intent(BizChatConversationFmUI.this.getContext(), BizChatSearchUI.class);
                intent.putExtra("enterprise_biz_name", BizChatConversationFmUI.this.jMp);
                intent.putExtra("biz_chat_search_scene", 1);
                intent.putExtra("biz_chat_search_text", "");
                intent.addFlags(67108864);
                BizChatConversationFmUI.this.startActivity(intent);
                AppMethodBeat.m2505o(30058);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$12 */
        class C3609112 implements OnClickListener {
            C3609112() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(30069);
                C36295g.m59751u(BizChatConversationFmUI.this.getContext(), BizChatConversationFmUI.m59403d(BizChatConversationFmUI.this), 4);
                AppMethodBeat.m2505o(30069);
            }
        }

        /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$19 */
        class C3609219 implements C30723a {
            C3609219() {
            }

            public final void apt() {
                AppMethodBeat.m2504i(30076);
                BizChatConversationFmUI.this.setMMTitle(C1854s.m3866mJ(BizChatConversationFmUI.this.jMp));
                if (BizChatConversationFmUI.this.yEj.getCount() <= 0) {
                    BizChatConversationFmUI.this.emptyTipTv.setVisibility(0);
                    BizChatConversationFmUI.this.jJY.setVisibility(8);
                    AppMethodBeat.m2505o(30076);
                    return;
                }
                BizChatConversationFmUI.this.emptyTipTv.setVisibility(8);
                if (BizChatConversationFmUI.this.jJY != null) {
                    BizChatConversationFmUI.this.jJY.setVisibility(0);
                }
                AppMethodBeat.m2505o(30076);
            }
        }

        /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$1 */
        class C360931 implements IdleHandler {
            C360931() {
            }

            public final boolean queueIdle() {
                AppMethodBeat.m2504i(30055);
                BizChatConversationFmUI.this.fvM = C41747z.aeR().mo43729qP(BizChatConversationFmUI.this.jMp).adX();
                int intExtra = BizChatConversationFmUI.this.thisActivity().getIntent().getIntExtra("biz_chat_from_scene", 7);
                int i = -1;
                if (BizChatConversationFmUI.this.yEj != null) {
                    i = BizChatConversationFmUI.this.yEj.getCount();
                }
                C36692b qC = C41747z.afa().mo20347qC(BizChatConversationFmUI.this.fvM);
                int i2 = qC != null ? qC.field_qyUin : 0;
                int i3 = qC != null ? qC.field_userUin : 0;
                int qE = C41747z.afa().mo20349qE(BizChatConversationFmUI.this.jMp);
                long j = qC != null ? qC.field_wwCorpId : 0;
                long j2 = qC != null ? qC.field_wwUserVid : 0;
                C7060h.pYm.mo8381e(12648, BizChatConversationFmUI.this.fvM, BizChatConversationFmUI.this.jMp, Integer.valueOf(intExtra), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(qE), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2));
                C4990ab.m7411d("MicroMsg.BizChatConversationFmUI", "bizchat report belong:%s,brandUserName:%s,fromScene:%s,itemCount:%s,fatherUin:%d,childUin:%d,userUin:%d,wwCorpId:%l,wwUserVidL%l", BizChatConversationFmUI.this.fvM, BizChatConversationFmUI.this.jMp, Integer.valueOf(intExtra), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(qE), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2));
                AppMethodBeat.m2505o(30055);
                return false;
            }
        }

        /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$10 */
        class C3609410 implements Runnable {
            C3609410() {
            }

            public final void run() {
                AppMethodBeat.m2504i(30067);
                C4990ab.m7416i("MicroMsg.BizChatConversationFmUI", "updateChatInfoFromSvr");
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                Cursor rn = C41747z.aeU().mo60345rn(BizChatConversationFmUI.this.jMp);
                if (rn.moveToFirst()) {
                    while (!rn.isAfterLast()) {
                        C32232a c32232a = new C32232a();
                        c32232a.mo8995d(rn);
                        rn.moveToNext();
                        C45142c aK = C41747z.aeT().mo60349aK(c32232a.field_bizChatId);
                        if (aK.afh()) {
                            if (aK.isGroup()) {
                                linkedList2.add(aK.field_bizChatServId);
                            } else {
                                linkedList.add(aK.field_bizChatServId);
                            }
                        }
                    }
                }
                rn.close();
                if (linkedList2.size() > 0) {
                    C41747z.aeZ().mo43713a(linkedList2, BizChatConversationFmUI.this.jMp);
                }
                BizChatConversationFmUI.m59397a(BizChatConversationFmUI.this, linkedList);
                if (linkedList.size() > 0) {
                    C41747z.aeZ().mo43717b(linkedList, BizChatConversationFmUI.this.jMp);
                }
                AppMethodBeat.m2505o(30067);
            }
        }

        /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$11 */
        class C3609511 implements C37447a {
            C3609511() {
            }

            /* renamed from: a */
            public final void mo48789a(C32233b c32233b) {
                AppMethodBeat.m2504i(30068);
                if (!(c32233b == null || c32233b.fxr == null || !BizChatConversationFmUI.this.jMp.equals(c32233b.fxr.field_brandUserName))) {
                    C4990ab.m7416i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChatConv change");
                    BizChatConversationFmUI.this.yEj.mo64189mY(c32233b.fxq);
                    if (BizChatConversationFmUI.this.isCurrentActivity) {
                        BizChatConversationFmUI.this.yEj.mo6869KC();
                    }
                }
                AppMethodBeat.m2505o(30068);
            }
        }

        /* renamed from: com.tencent.mm.ui.bizchat.BizChatConversationUI$BizChatConversationFmUI$13 */
        class C3609613 implements C25753a {
            C3609613() {
            }

            /* renamed from: a */
            public final void mo15833a(C8924b c8924b) {
                AppMethodBeat.m2504i(30070);
                if (!(c8924b == null || c8924b.fxB == null || !BizChatConversationFmUI.this.jMp.equals(c8924b.fxB.field_brandUserName))) {
                    C4990ab.m7416i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChat change");
                    BizChatConversationFmUI.this.yEj.mo64189mY(c8924b.fxq);
                    if (BizChatConversationFmUI.this.isCurrentActivity) {
                        BizChatConversationFmUI.this.yEj.mo6869KC();
                    }
                }
                AppMethodBeat.m2505o(30070);
            }
        }

        public BizChatConversationFmUI() {
            AppMethodBeat.m2504i(30079);
            AppMethodBeat.m2505o(30079);
        }

        /* renamed from: d */
        static /* synthetic */ String m59403d(BizChatConversationFmUI bizChatConversationFmUI) {
            AppMethodBeat.m2504i(30092);
            String dAM = bizChatConversationFmUI.dAM();
            AppMethodBeat.m2505o(30092);
            return dAM;
        }

        /* renamed from: r */
        static /* synthetic */ void m59418r(BizChatConversationFmUI bizChatConversationFmUI) {
            AppMethodBeat.m2504i(30097);
            bizChatConversationFmUI.dAK();
            AppMethodBeat.m2505o(30097);
        }

        public void onActivityCreated(Bundle bundle) {
            AppMethodBeat.m2504i(30080);
            super.onActivityCreated(bundle);
            this.jMp = thisActivity().getIntent().getStringExtra("Contact_User");
            C4990ab.m7416i("MicroMsg.BizChatConversationFmUI", "[registerListener]");
            C41747z.aeU().mo60334a(this.yEm, thisActivity().getMainLooper());
            C41747z.aeT().mo60347a(this.yEn, thisActivity().getMainLooper());
            C41747z.afa().mo20345a(this.yEo, thisActivity().getMainLooper());
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo10118a(this);
            this.emptyTipTv = (TextView) findViewById(2131821807);
            this.emptyTipTv.setText(C25738R.string.cvu);
            this.jJY = (ListView) findViewById(2131823620);
            dAK();
            this.yEj = new C40687b(thisActivity(), new C3609219(), this.jMp);
            this.yEj.setGetViewPositionCallback(new C2364620());
            this.yEj.setPerformItemClickListener(new C2364721());
            this.yEj.mo64185a(new C360882());
            this.jJY.setAdapter(this.yEj);
            this.jKa = new C3040015();
            final C24088a c24088a = new C24088a(thisActivity());
            this.jJY.setOnTouchListener(new C1554716());
            this.jJY.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.m2504i(30074);
                    c24088a.mo39885a(view, i, j, BizChatConversationFmUI.this, BizChatConversationFmUI.this.jKa, BizChatConversationFmUI.this.jLX, BizChatConversationFmUI.this.jLY);
                    AppMethodBeat.m2505o(30074);
                    return true;
                }
            });
            this.jJY.setOnItemClickListener(new C3040118());
            setBackBtn(new C360893());
            addIconOptionMenu(1, (int) C25738R.string.ewn, (int) C1318a.actionbar_icon_dark_search, (OnMenuItemClickListener) new C360904());
            addIconOptionMenu(2, (int) C25738R.string.f8698cf, (int) C1318a.actionbar_icon_dark_add, (OnMenuItemClickListener) new C52905());
            dAL();
            C9638aw.m17180RS().mo10310m(new C3609410(), 300);
            String dAM = dAM();
            if (dAM != null) {
                C41747z.afa();
                C8927c.m16090a(dAM, null);
                C4990ab.m7413e("MicroMsg.BizChatConversationFmUI", "update father attr from svr mainBizName:%s", dAM);
            } else {
                C4990ab.m7412e("MicroMsg.BizChatConversationFmUI", "mainBizName is null!!!");
            }
            Looper.myQueue().addIdleHandler(new C360931());
            Intent intent = thisActivity().getIntent();
            if (C5068w.m7683a(intent, "biz_chat_need_to_jump_to_chatting_ui", false)) {
                long longExtra = intent.getLongExtra("biz_chat_chat_id", -1);
                if (longExtra != -1) {
                    m59413mZ(longExtra);
                }
            }
            AppMethodBeat.m2505o(30080);
        }

        public int getLayoutId() {
            return 2130969403;
        }

        public String getUserName() {
            AppMethodBeat.m2504i(30081);
            String str;
            if (C5046bo.isNullOrNil(this.fvM)) {
                str = this.jMp;
                AppMethodBeat.m2505o(30081);
                return str;
            }
            str = this.fvM;
            AppMethodBeat.m2505o(30081);
            return str;
        }

        public void onResume() {
            AppMethodBeat.m2504i(30083);
            super.onResume();
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.jMp);
            if (aoO == null || !C7486a.m12942jh(aoO.field_type)) {
                finish();
                AppMethodBeat.m2505o(30083);
                return;
            }
            C16527d qX = C17903f.m28104qX(this.jMp);
            if (qX == null || qX.field_enterpriseFather == null || !C1855t.m3912mY(qX.field_enterpriseFather)) {
                finish();
                AppMethodBeat.m2505o(30083);
                return;
            }
            if (aoO.mo16673DX()) {
                setTitleMuteIconVisibility(0);
            } else {
                setTitleMuteIconVisibility(8);
            }
            this.isCurrentActivity = true;
            this.yEj.mo5248a(null, null);
            C9638aw.getNotification().mo41582jO(this.jMp);
            AppMethodBeat.m2505o(30083);
        }

        public void onPause() {
            AppMethodBeat.m2504i(30084);
            C4990ab.m7416i("MicroMsg.BizChatConversationFmUI", "on pause");
            C9638aw.m17190ZK();
            C18628c.m29083XR().apb(this.jMp);
            C37446b aeU = C41747z.aeU();
            String str = this.jMp;
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.BizConversationStorage", "brandUserName is null");
            } else {
                boolean hY = aeU.bSd.mo10108hY("BizChatConversation", "update BizChatConversation set newUnReadCount = 0 where newUnReadCount != 0 and brandUserName = '" + str + "'");
                C4990ab.m7411d("MicroMsg.BizConversationStorage", "resetNewUnreadCount :%s,sql:%s", Boolean.valueOf(hY), str);
            }
            if (this.yEj != null) {
                this.yEj.onPause();
            }
            this.isCurrentActivity = false;
            C9638aw.getNotification().mo41582jO("");
            super.onPause();
            AppMethodBeat.m2505o(30084);
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(30085);
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            C32232a c32232a = (C32232a) this.yEj.getItem(adapterContextMenuInfo.position);
            this.jMj = c32232a.field_bizChatId;
            if (c32232a.field_unReadCount <= 0) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, C25738R.string.cvl);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, C25738R.string.cvj);
            }
            C41747z.aeU();
            if (C37446b.m63112c(c32232a)) {
                contextMenu.add(adapterContextMenuInfo.position, 3, 1, C25738R.string.cvm);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 3, 1, C25738R.string.cvk);
            }
            contextMenu.add(adapterContextMenuInfo.position, 0, 2, C25738R.string.cvq);
            AppMethodBeat.m2505o(30085);
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(30086);
            super.onActivityResult(i, i2, intent);
            if (i2 != -1) {
                AppMethodBeat.m2505o(30086);
                return;
            }
            switch (i) {
                case 1:
                    boolean z;
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null) {
                        C4990ab.m7416i("MicroMsg.BizChatConversationFmUI", "bundle != null");
                        String string = bundleExtra.getString("enterprise_members");
                        acr acr = new acr();
                        C45142c c45142c = new C45142c();
                        c45142c.field_addMemberUrl = this.yEk != null ? this.yEk.field_addMemberUrl : null;
                        c45142c.field_brandUserName = this.jMp;
                        if (!C25754e.m40892a(c45142c, string, null, acr)) {
                            z = false;
                        } else if (c45142c.field_bizChatLocalId != -1) {
                            m59413mZ(c45142c.field_bizChatLocalId);
                            z = true;
                        } else {
                            C41747z.aeZ();
                            final C17900n a = C25759h.m40917a(this.jMp, acr, (C25772n) this);
                            Context thisActivity = thisActivity();
                            getString(C25738R.string.f9238tz);
                            this.tipDialog = C30379h.m48458b(thisActivity, getString(C25738R.string.f9260un), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.m2504i(30062);
                                    C41747z.aeZ();
                                    C25759h.m40927f(a);
                                    AppMethodBeat.m2505o(30062);
                                }
                            });
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        AppMethodBeat.m2505o(30086);
                        return;
                    }
                    Toast.makeText(thisActivity(), getString(C25738R.string.dru), 0).show();
                    AppMethodBeat.m2505o(30086);
                    return;
                default:
                    AppMethodBeat.m2505o(30086);
                    return;
            }
        }

        /* renamed from: a */
        public final void mo15832a(int i, C1207m c1207m) {
            AppMethodBeat.m2504i(30087);
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (c1207m.getType() == 1355) {
                C45142c rq = C41747z.aeT().mo60352rq(((C17900n) c1207m).afm().wcb.wku.vMV);
                if (rq == null) {
                    Toast.makeText(C4996ah.getContext(), getString(C25738R.string.dru), 0).show();
                    AppMethodBeat.m2505o(30087);
                    return;
                }
                m59413mZ(rq.field_bizChatLocalId);
            }
            AppMethodBeat.m2505o(30087);
        }

        private void dAK() {
            AppMethodBeat.m2504i(30088);
            String dAM = dAM();
            this.yEl = C36295g.m59747bK(getContext(), dAM);
            if (this.yEl == 2 && this.yEi == null) {
                this.yEi = (LinearLayout) findViewById(2131823622);
                LayoutParams layoutParams = this.yEi.getLayoutParams();
                layoutParams.height = C1338a.m2856al(getContext(), C25738R.dimen.f9782fh);
                this.yEi.setLayoutParams(layoutParams);
                View inflate = C5616v.m8409hu(getContext()).inflate(2130969404, this.yEi, false);
                float dm = C1338a.m2860dm(getContext());
                ImageView imageView = (ImageView) inflate.findViewById(2131821226);
                int i = imageView.getLayoutParams().height;
                imageView.getLayoutParams().height = (int) (((float) i) * dm);
                imageView.getLayoutParams().width = (int) (dm * ((float) i));
                imageView.requestLayout();
                ((TextView) inflate.findViewById(2131821185)).setText(C25738R.string.be3);
                this.yEi.addView(inflate);
                inflate.setOnClickListener(new C3609112());
                C36295g.m59750t(getContext(), this.jMp, 4);
                C36295g.m59748bL(getContext(), dAM);
            }
            if (this.yEi != null) {
                if (this.yEl == 2) {
                    this.yEi.setVisibility(0);
                    AppMethodBeat.m2505o(30088);
                    return;
                }
                this.yEi.setVisibility(8);
            }
            AppMethodBeat.m2505o(30088);
        }

        private void dAL() {
            boolean z = false;
            AppMethodBeat.m2504i(30089);
            String cI = C41747z.aeV().mo60357cI(this.jMp);
            this.yEk = C41747z.aeV().mo60356cH(cI);
            String str = "MicroMsg.BizChatConversationFmUI";
            String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
            Object[] objArr = new Object[3];
            objArr[0] = this.jMp;
            objArr[1] = cI;
            if (this.yEk == null) {
                z = true;
            }
            objArr[2] = Boolean.valueOf(z);
            C4990ab.m7417i(str, str2, objArr);
            if (C5046bo.isNullOrNil(cI) || this.yEk == null || this.yEk.afh() || C5046bo.isNullOrNil(this.yEk.field_addMemberUrl)) {
                C41747z.aeZ();
                C25759h.m40920a(this.jMp, (C25772n) this);
                Context thisActivity = thisActivity();
                getString(C25738R.string.f9238tz);
                this.tipDialog = C30379h.m48458b(thisActivity, getString(C25738R.string.f9260un), true, new C52959());
            }
            AppMethodBeat.m2505o(30089);
        }

        private String dAM() {
            AppMethodBeat.m2504i(30090);
            if (C5046bo.isNullOrNil(this.fvM)) {
                this.fvM = C41747z.aeR().mo43729qP(this.jMp).adX();
            }
            String str = this.fvM;
            AppMethodBeat.m2505o(30090);
            return str;
        }

        /* renamed from: mZ */
        private void m59413mZ(long j) {
            AppMethodBeat.m2504i(30091);
            Bundle bundle = new Bundle();
            bundle.putLong("key_biz_chat_id", j);
            bundle.putBoolean("finish_direct", false);
            bundle.putBoolean("key_need_send_video", false);
            bundle.putBoolean("key_is_biz_chat", true);
            this.f2991ui.startChatting(this.jMp, bundle, true);
            AppMethodBeat.m2505o(30091);
        }

        /* renamed from: a */
        public final void mo10136a(int i, C7298n c7298n, Object obj) {
        }

        public void onDestroy() {
            AppMethodBeat.m2504i(30082);
            C4990ab.m7416i("MicroMsg.BizChatConversationFmUI", "[unRegitListener]");
            C41747z.aeU().mo60333a(this.yEm);
            C41747z.aeT().mo60346a(this.yEn);
            C41747z.afa().mo20344a(this.yEo);
            if (C9638aw.m17179RK()) {
                C9638aw.m17190ZK();
                C18628c.m29083XR().mo10121b(this);
            }
            this.yEj.bIf();
            C40687b c40687b = this.yEj;
            if (c40687b.yDY != null) {
                c40687b.yDY.clear();
                c40687b.yDY = null;
            }
            super.onDestroy();
            AppMethodBeat.m2505o(30082);
        }

        /* renamed from: m */
        static /* synthetic */ void m59412m(BizChatConversationFmUI bizChatConversationFmUI) {
            AppMethodBeat.m2504i(30095);
            bizChatConversationFmUI.yEk = C41747z.aeV().mo60356cH(C41747z.aeV().mo60357cI(bizChatConversationFmUI.jMp));
            if (bizChatConversationFmUI.yEk == null || C5046bo.isNullOrNil(bizChatConversationFmUI.yEk.field_addMemberUrl)) {
                Toast.makeText(bizChatConversationFmUI.thisActivity(), bizChatConversationFmUI.getString(C25738R.string.a_o), 0).show();
                bizChatConversationFmUI.dAL();
                AppMethodBeat.m2505o(30095);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", bizChatConversationFmUI.yEk.field_addMemberUrl);
            C4990ab.m7417i("MicroMsg.BizChatConversationFmUI", "KRawUrl :%s", bizChatConversationFmUI.yEk.field_addMemberUrl);
            intent.putExtra("useJs", true);
            intent.addFlags(67108864);
            C25985d.m41468b(bizChatConversationFmUI.getContext(), "webview", ".ui.tools.WebViewUI", intent, 1);
            AppMethodBeat.m2505o(30095);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(30098);
        super.onCreate(bundle);
        this.contentView = C5616v.m8409hu(this).inflate(2130968881, null);
        setContentView(this.contentView);
        this.conversationFm = new BizChatConversationFmUI();
        getSupportFragmentManager().beginTransaction().mo552a(2131821892, this.conversationFm).commit();
        C30036f.m47539a(this, this.contentView);
        AppMethodBeat.m2505o(30098);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(30099);
        super.onConfigurationChanged(configuration);
        C30036f.m47539a(this, this.contentView);
        AppMethodBeat.m2505o(30099);
    }
}
