package com.tencent.p177mm.p612ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26428i;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C25764e;
import com.tencent.p177mm.p184aj.C36692b;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.C8927c;
import com.tencent.p177mm.p184aj.C8927c.C8929a;
import com.tencent.p177mm.p184aj.C8927c.C8929a.C8930a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C36295g;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.bizchat.BizChatConversationUI;
import com.tencent.p177mm.p612ui.conversation.BaseConversationUI.BaseConversationFmUI;
import com.tencent.p177mm.p612ui.tools.C40890k;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.transmit.SelectConversationUI;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C37985b.C9787b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.profile.p1287b.C28682d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.bbo;
import com.tencent.p177mm.protocal.protobuf.cfr;
import com.tencent.p177mm.protocal.protobuf.cfs;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI */
public class EnterpriseConversationUI extends BaseConversationUI {
    private View contentView;

    /* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI$EnterpriseConversationFmUI */
    public static class EnterpriseConversationFmUI extends BaseConversationFmUI implements C1202f, C4937b {
        private C46696j contextMenuHelper;
        private long edh = 0;
        private TextView emptyTipTv;
        long fRR = 0;
        private int fromScene;
        private String fuO;
        private boolean isDeleteCancel = false;
        private String jMa = "";
        private C5279d jOb;
        private long jrh = 0;
        private C44275p tipDialog;
        private LinearLayout yEi = null;
        private int yEl = 0;
        private C8929a yEo = new C3067210();
        private ListView zqO;
        private String zqQ;
        private C40890k zum;
        private View zun = null;
        private C36287i zuo;
        private String zup = null;
        private C7306ak zuq;
        private int zur = -2;
        private String zus = null;

        /* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI$EnterpriseConversationFmUI$14 */
        class C546814 implements OnMenuItemClickListener {
            C546814() {
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.m2504i(34432);
                Intent intent = new Intent();
                intent.putExtra("enterprise_biz_name", EnterpriseConversationFmUI.this.fuO);
                intent.addFlags(67108864);
                C25985d.m41467b(EnterpriseConversationFmUI.this.getContext(), "brandservice", ".ui.EnterpriseBizSearchUI", intent);
                AppMethodBeat.m2505o(34432);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI$EnterpriseConversationFmUI$15 */
        class C547015 implements OnMenuItemClickListener {

            /* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI$EnterpriseConversationFmUI$15$1 */
            class C54691 implements C36073c {
                C54691() {
                }

                /* renamed from: a */
                public final void mo5746a(C44273l c44273l) {
                    AppMethodBeat.m2504i(34433);
                    if (EnterpriseConversationFmUI.this.yEl == 1) {
                        c44273l.mo70063ax(2, C25738R.string.be8, C1318a.actionbar_goto_wework_icon);
                        C36295g.m59750t(EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationFmUI.this.fuO, 5);
                    }
                    c44273l.mo70063ax(3, C25738R.string.azw, C1318a.ofm_send_icon);
                    c44273l.mo70063ax(4, C25738R.string.bdp, C1318a.actionbar_goto_disabled_biz_icon);
                    c44273l.mo70063ax(5, C25738R.string.f8699cg, C1318a.actionbar_setting_white_icon);
                    AppMethodBeat.m2505o(34433);
                }
            }

            /* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI$EnterpriseConversationFmUI$15$2 */
            class C54712 implements C5279d {
                C54712() {
                }

                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(34434);
                    int i2 = 0;
                    Intent intent;
                    switch (menuItem.getItemId()) {
                        case 2:
                            C36295g.m59751u(EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationFmUI.this.fuO, 5);
                            break;
                        case 3:
                            intent = new Intent(EnterpriseConversationFmUI.this.thisActivity(), SelectConversationUI.class);
                            intent.putExtra("Select_Talker_Name", EnterpriseConversationFmUI.this.fuO);
                            intent.putExtra("Select_block_List", EnterpriseConversationFmUI.this.fuO);
                            intent.putExtra("Select_Send_Card", true);
                            intent.putExtra("Select_Conv_Type", 3);
                            EnterpriseConversationFmUI.this.startActivityForResult(intent, 1);
                            i2 = 3;
                            break;
                        case 4:
                            i2 = 4;
                            Intent intent2 = new Intent();
                            intent2.putExtra("enterprise_biz_name", EnterpriseConversationFmUI.this.fuO);
                            intent2.putExtra("enterprise_scene", 2);
                            C25985d.m41467b(EnterpriseConversationFmUI.this.thisActivity(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent2);
                            break;
                        case 5:
                            intent = new Intent();
                            intent.putExtra("Contact_User", EnterpriseConversationFmUI.this.fuO);
                            C25985d.m41467b(EnterpriseConversationFmUI.this.thisActivity(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                            i2 = 5;
                            break;
                    }
                    C36295g.m59749ew(EnterpriseConversationFmUI.this.fuO, i2);
                    AppMethodBeat.m2505o(34434);
                }
            }

            C547015() {
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.m2504i(34435);
                if (EnterpriseConversationFmUI.this.zum != null) {
                    EnterpriseConversationFmUI.this.zum.dismiss();
                    EnterpriseConversationFmUI.this.zum = null;
                }
                EnterpriseConversationFmUI.this.zum = new C40890k(EnterpriseConversationFmUI.this.getContext());
                EnterpriseConversationFmUI.this.zum.rBl = new C54691();
                EnterpriseConversationFmUI.this.zum.rBm = new C54712();
                EnterpriseConversationFmUI.this.zum.mo49182gP();
                C36295g.m59749ew(EnterpriseConversationFmUI.this.fuO, 1);
                AppMethodBeat.m2505o(34435);
                return false;
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI$EnterpriseConversationFmUI$16 */
        class C547216 implements C30723a {
            C547216() {
            }

            public final void apt() {
                AppMethodBeat.m2504i(34436);
                EnterpriseConversationFmUI.m48905a(EnterpriseConversationFmUI.this, EnterpriseConversationFmUI.this.zuo.getCount());
                AppMethodBeat.m2505o(34436);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI$EnterpriseConversationFmUI$17 */
        class C547317 implements C15521c {
            C547317() {
            }

            /* renamed from: cZ */
            public final int mo8831cZ(View view) {
                AppMethodBeat.m2504i(34437);
                int positionForView = EnterpriseConversationFmUI.this.zqO.getPositionForView(view);
                AppMethodBeat.m2505o(34437);
                return positionForView;
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI$EnterpriseConversationFmUI$18 */
        class C547418 implements C23600g {
            C547418() {
            }

            /* renamed from: q */
            public final void mo11108q(View view, int i, int i2) {
                AppMethodBeat.m2504i(34438);
                EnterpriseConversationFmUI.this.zqO.performItemClick(view, i, (long) i2);
                AppMethodBeat.m2505o(34438);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI$EnterpriseConversationFmUI$1 */
        class C239511 implements OnMenuItemClickListener {
            C239511() {
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.m2504i(34417);
                EnterpriseConversationFmUI.this.finish();
                AppMethodBeat.m2505o(34417);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI$EnterpriseConversationFmUI$2 */
        class C239522 implements C23599f {
            C239522() {
            }

            /* renamed from: bN */
            public final void mo11067bN(Object obj) {
                AppMethodBeat.m2504i(34418);
                if (obj == null) {
                    C4990ab.m7412e("MicroMsg.EnterpriseConversationUI", "onItemDel object null");
                    AppMethodBeat.m2505o(34418);
                    return;
                }
                EnterpriseConversationFmUI.m48907a(EnterpriseConversationFmUI.this, obj.toString());
                AppMethodBeat.m2505o(34418);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI$EnterpriseConversationFmUI$3 */
        class C239533 implements OnItemClickListener {
            C239533() {
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String str = null;
                AppMethodBeat.m2504i(34419);
                C7617ak c7617ak = (C7617ak) EnterpriseConversationFmUI.this.zuo.getItem(i);
                if (c7617ak == null) {
                    C4990ab.m7413e("MicroMsg.EnterpriseConversationUI", "user should not be null. position:%d, size:%d", Integer.valueOf(i), Integer.valueOf(EnterpriseConversationFmUI.this.zuo.getCount()));
                    EnterpriseConversationFmUI.this.zuo.notifyDataSetChanged();
                    AppMethodBeat.m2505o(34419);
                } else if (C17903f.m28103kq(c7617ak.field_username)) {
                    Intent intent = new Intent(EnterpriseConversationFmUI.this.thisActivity(), BizChatConversationUI.class);
                    intent.putExtra("Contact_User", c7617ak.field_username);
                    intent.putExtra("biz_chat_from_scene", 7);
                    intent.addFlags(67108864);
                    EnterpriseConversationFmUI.this.startActivity(intent);
                    AppMethodBeat.m2505o(34419);
                } else if (C17903f.m28110rd(c7617ak.field_username)) {
                    C16527d qX = C17903f.m28104qX(c7617ak.field_username);
                    if (qX != null) {
                        str = qX.adT();
                    }
                    if (str == null) {
                        str = "";
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("srcUsername", c7617ak.field_username);
                    intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                    intent2.putExtra("geta8key_scene", 51);
                    intent2.addFlags(67108864);
                    C25985d.m41467b(EnterpriseConversationFmUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    EnterpriseConversationFmUI.m48906a(EnterpriseConversationFmUI.this, qX, 2, c7617ak.field_unReadCount);
                    AppMethodBeat.m2505o(34419);
                } else {
                    EnterpriseConversationFmUI.this.f2991ui.startChatting(c7617ak.field_username, null, true);
                    EnterpriseConversationFmUI.m48906a(EnterpriseConversationFmUI.this, C17903f.m28104qX(c7617ak.field_username), 1, c7617ak.field_unReadCount);
                    AppMethodBeat.m2505o(34419);
                }
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI$EnterpriseConversationFmUI$9 */
        class C306719 extends C7306ak {
            C306719() {
            }

            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(34427);
                if (message != null && message.what == 1 && EnterpriseConversationFmUI.this.thisActivity() != null && !EnterpriseConversationFmUI.this.thisActivity().isFinishing()) {
                    int i;
                    int i2;
                    int count = EnterpriseConversationFmUI.this.zuo.getCount();
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    int i6 = 0;
                    while (i6 < count) {
                        C7617ak c7617ak = (C7617ak) EnterpriseConversationFmUI.this.zuo.getItem(i6);
                        if (c7617ak != null) {
                            String str = c7617ak.field_username;
                            if (str != null) {
                                if (C1855t.m3912mY(str) && C17903f.m28111re(str)) {
                                    C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                                    boolean aph = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aph(str);
                                    Object obj = (aoO == null || (aoO.field_type & 2048) == 0) ? null : 1;
                                    if (obj != null && !aph) {
                                        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apf(str);
                                    } else if (obj == null && aph) {
                                        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apg(str);
                                    }
                                    if (C17903f.m28110rd(str)) {
                                        linkedList2.add(str);
                                    }
                                    if (c7617ak.field_unReadCount > 0) {
                                        if (C1855t.m3928nN(str)) {
                                            i3++;
                                            i = i5;
                                            i2 = i4;
                                        } else {
                                            i2 = i4 + 1;
                                            i = c7617ak.field_unReadCount + i5;
                                        }
                                        i6++;
                                        i5 = i;
                                        i4 = i2;
                                    }
                                } else {
                                    C4990ab.m7411d("MicroMsg.EnterpriseConversationUI", "checkEnterpriseChildConv delete conv %s", str);
                                    linkedList.add(str);
                                    i = i5;
                                    i2 = i4;
                                    i6++;
                                    i5 = i;
                                    i4 = i2;
                                }
                            }
                        }
                        i = i5;
                        i2 = i4;
                        i6++;
                        i5 = i;
                        i4 = i2;
                    }
                    C36692b qC = C41747z.afa().mo20347qC(EnterpriseConversationFmUI.this.fuO);
                    int i7 = qC != null ? qC.field_qyUin : 0;
                    long j = qC != null ? qC.field_wwCorpId : 0;
                    long j2 = qC != null ? qC.field_wwUserVid : 0;
                    i6 = 0;
                    if (!C5046bo.isNullOrNil(EnterpriseConversationFmUI.this.zus)) {
                        i6 = C41747z.afa().mo20349qE(EnterpriseConversationFmUI.this.zus);
                    }
                    C7060h.pYm.mo8381e(12892, EnterpriseConversationFmUI.this.fuO, Integer.valueOf(EnterpriseConversationFmUI.this.fromScene), Integer.valueOf(count), "", Integer.valueOf(EnterpriseConversationFmUI.this.zur), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(EnterpriseConversationFmUI.this.jrh), Integer.valueOf(i6), Integer.valueOf(i7), Long.valueOf(j), Long.valueOf(j2));
                    C4990ab.m7411d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", EnterpriseConversationFmUI.this.fuO, Integer.valueOf(EnterpriseConversationFmUI.this.fromScene), Integer.valueOf(count), "", Integer.valueOf(EnterpriseConversationFmUI.this.zur), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(EnterpriseConversationFmUI.this.jrh), Integer.valueOf(i6), Integer.valueOf(i7), Long.valueOf(j), Long.valueOf(j2));
                    if (linkedList.size() > 0) {
                        C9638aw.m17190ZK();
                        C18628c.m29083XR().mo15778aF(linkedList);
                        EnterpriseConversationFmUI.this.zuo.mo6869KC();
                    }
                    if (C41747z.afd().mo52930qB(EnterpriseConversationFmUI.this.fuO)) {
                        C41747z.afa();
                        C8927c.m16090a(EnterpriseConversationFmUI.this.fuO, null);
                    }
                    C41747z.afd().mo52930qB(EnterpriseConversationFmUI.m48925p(EnterpriseConversationFmUI.this));
                    if (linkedList2.size() > 0) {
                        i = 0;
                        while (true) {
                            i2 = i;
                            if (i2 >= linkedList2.size()) {
                                break;
                            }
                            C41747z.afd().mo52930qB((String) linkedList2.get(i2));
                            i = i2 + 1;
                        }
                    }
                }
                AppMethodBeat.m2505o(34427);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI$EnterpriseConversationFmUI$10 */
        class C3067210 implements C8929a {
            C3067210() {
            }

            /* renamed from: a */
            public final void mo20352a(C8930a c8930a) {
                AppMethodBeat.m2504i(34428);
                if (!(c8930a == null || C5046bo.isNullOrNil(c8930a.fuO) || !c8930a.fuO.equals(EnterpriseConversationFmUI.this.fuO))) {
                    int e = EnterpriseConversationFmUI.this.yEl;
                    EnterpriseConversationFmUI.this.yEl = C36295g.m59747bK(EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationFmUI.this.fuO);
                    if (EnterpriseConversationFmUI.this.yEl != e) {
                        EnterpriseConversationFmUI.m48926q(EnterpriseConversationFmUI.this);
                    }
                }
                AppMethodBeat.m2505o(34428);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI$EnterpriseConversationFmUI$11 */
        class C3067311 implements OnClickListener {
            C3067311() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(34429);
                C9787b.m17426a(EnterpriseConversationFmUI.this.zqO);
                AppMethodBeat.m2505o(34429);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI$EnterpriseConversationFmUI$13 */
        class C3067413 implements OnClickListener {
            C3067413() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(34431);
                C36295g.m59751u(EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationFmUI.this.fuO, 3);
                AppMethodBeat.m2505o(34431);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI$EnterpriseConversationFmUI$12 */
        class C3067512 implements C1202f {
            C3067512() {
            }

            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(34430);
                EnterpriseConversationFmUI.m48909b(EnterpriseConversationFmUI.this);
                AppMethodBeat.m2505o(34430);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI$EnterpriseConversationFmUI$4 */
        class C306764 implements C5279d {
            C306764() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(34420);
                switch (menuItem.getItemId()) {
                    case 1:
                        EnterpriseConversationFmUI.m48907a(EnterpriseConversationFmUI.this, EnterpriseConversationFmUI.this.jMa);
                        AppMethodBeat.m2505o(34420);
                        return;
                    case 2:
                        EnterpriseConversationFmUI.m48910b(EnterpriseConversationFmUI.this, EnterpriseConversationFmUI.this.jMa);
                        AppMethodBeat.m2505o(34420);
                        return;
                    case 3:
                        EnterpriseConversationFmUI.arW(EnterpriseConversationFmUI.this.jMa);
                        break;
                }
                AppMethodBeat.m2505o(34420);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI$EnterpriseConversationFmUI$5 */
        class C306775 implements OnItemLongClickListener {
            C306775() {
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(34421);
                EnterpriseConversationFmUI.this.jMa = ((C7617ak) EnterpriseConversationFmUI.this.zuo.getItem(i)).field_username;
                EnterpriseConversationFmUI.this.contextMenuHelper.mo75004a(view, i, j, EnterpriseConversationFmUI.this, EnterpriseConversationFmUI.this.jOb);
                AppMethodBeat.m2505o(34421);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.EnterpriseConversationUI$EnterpriseConversationFmUI$7 */
        class C306807 implements OnCancelListener {
            C306807() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(34424);
                EnterpriseConversationFmUI.this.isDeleteCancel = true;
                AppMethodBeat.m2505o(34424);
            }
        }

        public EnterpriseConversationFmUI() {
            AppMethodBeat.m2504i(34439);
            AppMethodBeat.m2505o(34439);
        }

        /* renamed from: q */
        static /* synthetic */ void m48926q(EnterpriseConversationFmUI enterpriseConversationFmUI) {
            AppMethodBeat.m2504i(34456);
            enterpriseConversationFmUI.dAK();
            AppMethodBeat.m2505o(34456);
        }

        public void onActivityCreated(Bundle bundle) {
            AppMethodBeat.m2504i(34440);
            super.onActivityCreated(bundle);
            this.fuO = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
            this.zqQ = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
            this.fromScene = thisActivity().getIntent().getIntExtra("enterprise_from_scene", 5);
            setMMTitle(this.zqQ);
            this.zqO = (ListView) findViewById(2131823620);
            this.emptyTipTv = (TextView) findViewById(2131821807);
            this.emptyTipTv.setText(C25738R.string.bdq);
            setBackBtn(new C239511());
            setToTop(new C3067311());
            if (C17903f.m28104qX(this.fuO) != null) {
                dAK();
                if (this.fuO != null) {
                    C1202f c3067512 = new C3067512();
                    C41747z.afa();
                    C8927c.m16090a(this.fuO, c3067512);
                    C4990ab.m7413e("MicroMsg.EnterpriseConversationUI", "update father attr from svr bizName:%s", this.fuO);
                } else {
                    C4990ab.m7412e("MicroMsg.EnterpriseConversationUI", "bizName is null!!!");
                }
                addIconOptionMenu(1, (int) C25738R.string.ewn, (int) C1318a.actionbar_icon_dark_search, (OnMenuItemClickListener) new C546814());
                addIconOptionMenu(2, (int) C25738R.string.f8698cf, (int) C1318a.actionbar_icon_dark_add, (OnMenuItemClickListener) new C547015());
                this.zuo = new C36287i(thisActivity(), this.fuO, new C547216());
                this.zuo.setGetViewPositionCallback(new C547317());
                this.zuo.setPerformItemClickListener(new C547418());
                this.zuo.mo57151a(new C239522());
                this.zqO.setAdapter(this.zuo);
                this.zqO.setOnItemClickListener(new C239533());
                this.contextMenuHelper = new C46696j(thisActivity());
                this.jOb = new C306764();
                this.zqO.setOnItemLongClickListener(new C306775());
            }
            this.edh = System.currentTimeMillis() / 1000;
            C9638aw.m17190ZK();
            C7617ak aoZ = C18628c.m29083XR().aoZ(this.fuO);
            if (aoZ != null) {
                String str;
                this.zur = aoZ.field_unReadCount;
                if (this.zur == 0 && aoZ.field_unReadMuteCount > 0) {
                    this.zur = -1;
                }
                this.jrh = aoZ.field_conversationTime / 1000;
                if (aoZ.field_isSend == 1) {
                    str = null;
                } else {
                    str = aoZ.field_digestUser;
                }
                this.zus = str;
            }
            C41747z.afa().mo20345a(this.yEo, thisActivity().getMainLooper());
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo10118a(this);
            C9638aw.m17190ZK();
            C18628c.m29078XM().mo10118a(this);
            if (this.zuo != null) {
                if (this.zuq == null) {
                    this.zuq = new C306719();
                } else {
                    this.zuq.removeMessages(1);
                }
                this.zuq.sendEmptyMessageDelayed(1, 500);
            }
            AppMethodBeat.m2505o(34440);
        }

        public int getLayoutId() {
            return 2130969403;
        }

        public String getUserName() {
            return this.fuO;
        }

        public void onDestroy() {
            AppMethodBeat.m2504i(34441);
            C41747z.afa().mo20344a(this.yEo);
            if (C9638aw.m17179RK()) {
                C9638aw.m17190ZK();
                C18628c.m29083XR().mo10121b(this);
                C9638aw.m17190ZK();
                C18628c.m29078XM().mo10121b(this);
            }
            if (this.zuo != null) {
                C36287i c36287i = this.zuo;
                c36287i.zrC.stopTimer();
                if (c36287i.yDY != null) {
                    c36287i.yDY.clear();
                    c36287i.yDY = null;
                }
                c36287i.bIf();
                c36287i.dww();
                C9638aw.m17190ZK();
                C18628c.m29083XR().mo10121b(c36287i);
            }
            C9638aw.m17182Rg().mo14546b(1394, (C1202f) this);
            if (this.edh > 0 && this.fRR > 0) {
                int i;
                int i2;
                long j = this.fRR - this.edh;
                C36692b qC = C41747z.afa().mo20347qC(this.fuO);
                if (qC != null) {
                    i = qC.field_qyUin;
                } else {
                    i = 0;
                }
                if (qC != null) {
                    i2 = qC.field_userUin;
                } else {
                    i2 = 0;
                }
                C7060h.pYm.mo8381e(13465, "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(j));
                C4990ab.m7411d("MicroMsg.EnterpriseConversationUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(j));
            }
            super.onDestroy();
            AppMethodBeat.m2505o(34441);
        }

        public void onResume() {
            AppMethodBeat.m2504i(34442);
            C4990ab.m7418v("MicroMsg.EnterpriseConversationUI", "on resume");
            if (this.zuo != null) {
                this.zuo.onResume();
            }
            super.onResume();
            if (!C1855t.m3912mY(this.fuO)) {
                finish();
            }
            AppMethodBeat.m2505o(34442);
        }

        public void onPause() {
            AppMethodBeat.m2504i(34443);
            C4990ab.m7418v("MicroMsg.EnterpriseConversationUI", "on pause");
            C9638aw.m17190ZK();
            C18628c.m29083XR().apb(this.fuO);
            if (this.zuo != null) {
                this.zuo.onPause();
            }
            super.onPause();
            AppMethodBeat.m2505o(34443);
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(34444);
            super.onActivityResult(i, i2, intent);
            switch (i) {
                case 1:
                    if (i2 != -1 || intent == null) {
                        AppMethodBeat.m2505o(34444);
                        return;
                    }
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    C12519g.bOk().mo46462q(stringExtra, stringExtra2, booleanExtra);
                    C12519g.bOk().mo46461eZ(stringExtra3, stringExtra2);
                    C5670b.m8523i(thisActivity(), getContext().getString(C25738R.string.bvk));
                    AppMethodBeat.m2505o(34444);
                    return;
                default:
                    AppMethodBeat.m2505o(34444);
                    return;
            }
        }

        private void dAK() {
            AppMethodBeat.m2504i(34445);
            this.yEl = C36295g.m59747bK(getContext(), this.fuO);
            if (this.yEl == 2 && this.yEi == null) {
                this.yEi = (LinearLayout) findViewById(2131823622);
                LayoutParams layoutParams = this.yEi.getLayoutParams();
                layoutParams.height = C1338a.m2856al(getContext(), C25738R.dimen.f9782fh);
                this.yEi.setLayoutParams(layoutParams);
                this.zun = C5616v.m8409hu(getContext()).inflate(2130969404, this.yEi, false);
                float dm = C1338a.m2860dm(getContext());
                ImageView imageView = (ImageView) this.zun.findViewById(2131821226);
                int i = imageView.getLayoutParams().height;
                imageView.getLayoutParams().height = (int) (((float) i) * dm);
                imageView.getLayoutParams().width = (int) (dm * ((float) i));
                imageView.requestLayout();
                TextView textView = (TextView) this.zun.findViewById(2131821185);
                C36692b qC = C41747z.afa().mo20347qC(this.fuO);
                C41747z.afa();
                C41747z.afa();
                String lb = C8927c.m16091lb(0);
                if (qC == null || qC.field_chatOpen || qC.field_use_preset_banner_tips || lb == null) {
                    textView.setText(C25738R.string.be7);
                } else {
                    textView.setText(lb);
                }
                C36295g.m59746at(this.fuO, 1, 2);
                this.yEi.addView(this.zun);
                this.zun.setOnClickListener(new C3067413());
                C36295g.m59750t(getContext(), this.fuO, 3);
                C36295g.m59748bL(getContext(), this.fuO);
            }
            if (this.yEi != null) {
                if (this.yEl == 2) {
                    this.yEi.setVisibility(0);
                    dIM();
                    AppMethodBeat.m2505o(34445);
                    return;
                }
                this.yEi.setVisibility(8);
            }
            AppMethodBeat.m2505o(34445);
        }

        private void dIM() {
            AppMethodBeat.m2504i(34446);
            C36692b qC = C41747z.afa().mo20347qC(this.fuO);
            int i = qC != null ? qC.field_qyUin : 0;
            int i2 = qC != null ? qC.field_userUin : 0;
            long j = qC != null ? qC.field_wwCorpId : 0;
            long j2 = qC != null ? qC.field_wwUserVid : 0;
            C7060h.pYm.mo8381e(13656, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(j), Long.valueOf(j2));
            C4990ab.m7411d("MicroMsg.EnterpriseConversationUI", "expose wework btn on session list  report: %s,%s,%s,%s,%s,%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(j), Long.valueOf(j2));
            AppMethodBeat.m2505o(34446);
        }

        public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(34447);
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (i == 0 && i2 == 0) {
                if (c1207m.getType() == 1394) {
                    cfr caz = ((C28682d) c1207m).caz();
                    cfs cay = ((C28682d) c1207m).cay();
                    if (cay == null || cay.vNh == null || cay.vNh.ret != 0) {
                        if (cay == null || cay.vNh == null) {
                            C4990ab.m7421w("MicroMsg.EnterpriseConversationUI", "chuangchen onSceneEnd type:%s, err:resp == null", Integer.valueOf(c1207m.getType()));
                            AppMethodBeat.m2505o(34447);
                            return;
                        }
                        C4990ab.m7421w("MicroMsg.EnterpriseConversationUI", "chuangchen onSceneEnd type:%s, err:code:%s", Integer.valueOf(c1207m.getType()), Integer.valueOf(cay.vNh.ret));
                        AppMethodBeat.m2505o(34447);
                        return;
                    } else if (caz.xeS) {
                        C16527d qX = C17903f.m28104qX(caz.vNb);
                        qX.field_brandFlag |= 1;
                        bbo bbo = new bbo();
                        bbo.gvb = qX.field_brandFlag;
                        bbo.jBB = caz.vNb;
                        C9638aw.m17190ZK();
                        C18628c.m29077XL().mo7920c(new C3465a(47, bbo));
                        C41747z.aeR().mo10103c(qX, new String[0]);
                        C9638aw.m17190ZK();
                        C18628c.m29083XR().aoX(qX.field_username);
                        C9638aw.m17190ZK();
                        if (C18628c.m29083XR().apl(qX.field_enterpriseFather) <= 0) {
                            C9638aw.m17190ZK();
                            C18628c.m29083XR().aoX(qX.field_enterpriseFather);
                            AppMethodBeat.m2505o(34447);
                            return;
                        }
                        C9638aw.m17190ZK();
                        C18628c.m29082XQ().aoj(qX.field_enterpriseFather);
                    } else {
                        AppMethodBeat.m2505o(34447);
                        return;
                    }
                }
                AppMethodBeat.m2505o(34447);
                return;
            }
            AppMethodBeat.m2505o(34447);
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(34448);
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(this.jMa);
            if (aoO == null) {
                C4990ab.m7412e("MicroMsg.EnterpriseConversationUI", "onCreateContextMenu, contact is null, talker = " + this.jMa);
                AppMethodBeat.m2505o(34448);
                return;
            }
            CharSequence Oj = aoO.mo16707Oj();
            if (Oj.toLowerCase().endsWith("@chatroom") && C5046bo.isNullOrNil(aoO.field_nickname)) {
                Oj = getString(C25738R.string.ao1);
            }
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            contextMenu.setHeaderTitle(C44089j.m79292b(thisActivity(), Oj));
            if (aoO.mo16702Oe()) {
                contextMenu.add(adapterContextMenuInfo.position, 3, 0, C25738R.string.cvm);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 3, 0, C25738R.string.be1);
            }
            contextMenu.add(adapterContextMenuInfo.position, 2, 1, C25738R.string.bdu);
            contextMenu.add(adapterContextMenuInfo.position, 1, 2, C25738R.string.cvq);
            AppMethodBeat.m2505o(34448);
        }

        /* renamed from: a */
        public final void mo10136a(int i, C7298n c7298n, Object obj) {
        }

        /* renamed from: b */
        static /* synthetic */ void m48909b(EnterpriseConversationFmUI enterpriseConversationFmUI) {
            AppMethodBeat.m2504i(34449);
            if (enterpriseConversationFmUI.zun != null) {
                C36692b qC = C41747z.afa().mo20347qC(enterpriseConversationFmUI.fuO);
                if (!(qC == null || qC.field_chatOpen || qC.field_use_preset_banner_tips)) {
                    TextView textView = (TextView) enterpriseConversationFmUI.zun.findViewById(2131821185);
                    C41747z.afa();
                    C41747z.afa();
                    String lb = C8927c.m16091lb(0);
                    if (!(textView == null || lb == null || textView.getText().equals(lb))) {
                        textView.setText(lb);
                    }
                }
            }
            AppMethodBeat.m2505o(34449);
        }

        /* renamed from: a */
        static /* synthetic */ void m48906a(EnterpriseConversationFmUI enterpriseConversationFmUI, C16527d c16527d, int i, int i2) {
            AppMethodBeat.m2504i(34452);
            C36692b qC = C41747z.afa().mo20347qC(enterpriseConversationFmUI.fuO);
            long j = qC != null ? qC.field_wwCorpId : 0;
            long j2 = qC != null ? qC.field_wwUserVid : 0;
            int i3 = i2 > 0 ? 1 : 2;
            long adU = c16527d == null ? 0 : c16527d.adU();
            C7060h.pYm.mo8381e(14507, Long.valueOf(j), Long.valueOf(adU), Long.valueOf(j2), Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(i));
            C4990ab.m7411d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", Long.valueOf(j), Long.valueOf(adU), Long.valueOf(j2), Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(i));
            AppMethodBeat.m2505o(34452);
        }

        static /* synthetic */ void arW(String str) {
            AppMethodBeat.m2504i(34454);
            C9638aw.m17190ZK();
            if (C18628c.m29078XM().aoO(str) == null) {
                C4990ab.m7412e("MicroMsg.EnterpriseConversationUI", "changed biz stick status failed, contact is null, talker = ".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(34454);
                return;
            }
            C9638aw.m17190ZK();
            if (C18628c.m29083XR().aph(str)) {
                C1855t.m3969x(str, true);
                AppMethodBeat.m2505o(34454);
                return;
            }
            C26428i.m42084mn(str);
            AppMethodBeat.m2505o(34454);
        }

        /* renamed from: p */
        static /* synthetic */ String m48925p(EnterpriseConversationFmUI enterpriseConversationFmUI) {
            String qT;
            AppMethodBeat.m2504i(34455);
            if (enterpriseConversationFmUI.zup == null) {
                C41747z.aeR();
                qT = C25764e.m40952qT(enterpriseConversationFmUI.fuO);
                if (C5046bo.isNullOrNil(qT)) {
                    qT = "";
                }
                enterpriseConversationFmUI.zup = qT;
            }
            if (C5046bo.isNullOrNil(enterpriseConversationFmUI.zup)) {
                AppMethodBeat.m2505o(34455);
                return null;
            }
            qT = enterpriseConversationFmUI.zup;
            AppMethodBeat.m2505o(34455);
            return qT;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(34457);
        super.onCreate(bundle);
        this.contentView = C5616v.m8409hu(this).inflate(2130968881, null);
        setContentView(this.contentView);
        this.conversationFm = new EnterpriseConversationFmUI();
        getSupportFragmentManager().beginTransaction().mo552a(2131821892, this.conversationFm).commit();
        C30036f.m47539a(this, this.contentView);
        AppMethodBeat.m2505o(34457);
    }

    public void finish() {
        AppMethodBeat.m2504i(34458);
        if (this.conversationFm != null && (this.conversationFm instanceof EnterpriseConversationFmUI)) {
            ((EnterpriseConversationFmUI) this.conversationFm).fRR = System.currentTimeMillis() / 1000;
        }
        super.finish();
        AppMethodBeat.m2505o(34458);
    }
}
