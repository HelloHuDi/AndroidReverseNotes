package com.tencent.p177mm.p612ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p184aj.p185a.C45142c;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C18348nt;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36072a;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C40670b;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.bizchat.BizChatSelectConversationUI;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.C46648j;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15613i;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.p842bp.C25985d.C25987a;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.p1338b.p1339a.C44100d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C23498az.C23499a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.m */
public final class C30558m {
    private static C23805a yIR;
    private static C44275p yIv = null;

    /* renamed from: com.tencent.mm.ui.chatting.m$a */
    static class C23805a {
        C45316cl cJy;
        String cKf;
        boolean yFW;
        List<C7620bi> yIP;
        C44100d yIQ;
        boolean yIY;

        private C23805a() {
        }

        /* synthetic */ C23805a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.m$b */
    static class C23806b implements C23499a {
        private C46650a cgL;
        private Context context;
        private String fuO;
        private long jMj;
        private boolean mgP;
        private C23805a yIZ;

        public C23806b(C46650a c46650a, Context context, String str, long j, C23805a c23805a) {
            AppMethodBeat.m2504i(30606);
            this.cgL = c46650a;
            this.context = context;
            this.fuO = str;
            this.jMj = j;
            this.yIZ = c23805a;
            this.mgP = C17903f.m28103kq(str);
            AppMethodBeat.m2505o(30606);
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(30607);
            if (this.mgP) {
                C45142c aK = C41747z.aeT().mo60349aK(this.jMj);
                synchronized (C25754e.fxC) {
                    try {
                        String aae = C25754e.aae();
                        C25754e.m40895d(aK);
                        if (this.yIZ.yIY) {
                            dCe();
                        } else {
                            dCf();
                        }
                        C25754e.m40910rx(aae);
                    } finally {
                        AppMethodBeat.m2505o(30607);
                    }
                }
            } else {
                if (this.yIZ.yIY) {
                    dCe();
                } else {
                    dCf();
                }
                AppMethodBeat.m2505o(30607);
            }
            return true;
        }

        /* renamed from: a */
        private void m36639a(Context context, C7620bi c7620bi, boolean z, String str) {
            AppMethodBeat.m2504i(30608);
            if (c7620bi.isText()) {
                C40788j.m70649a(context, str, c7620bi, z);
                AppMethodBeat.m2505o(30608);
            } else if (c7620bi.drE()) {
                C40788j.m70667b(context, str, c7620bi);
                AppMethodBeat.m2505o(30608);
            } else if (c7620bi.bws() && !this.mgP) {
                C40788j.m70670c(context, str, c7620bi);
                AppMethodBeat.m2505o(30608);
            } else if (c7620bi.bAC()) {
                C40788j.m70671c(context, str, c7620bi, z);
                AppMethodBeat.m2505o(30608);
            } else {
                if ((c7620bi.dtx() || c7620bi.dty()) && !this.mgP) {
                    if (!C40788j.m70662av(c7620bi)) {
                        C40788j.m70648a(context, str, c7620bi);
                        AppMethodBeat.m2505o(30608);
                        return;
                    }
                } else if (c7620bi.bAA()) {
                    if (this.mgP && !C40788j.m70656aD(c7620bi)) {
                        AppMethodBeat.m2505o(30608);
                        return;
                    } else if (C40788j.m70657aE(c7620bi)) {
                        AppMethodBeat.m2505o(30608);
                        return;
                    } else if (c7620bi.getType() == 318767153) {
                        AppMethodBeat.m2505o(30608);
                        return;
                    } else if (C40788j.m70661aI(c7620bi)) {
                        AppMethodBeat.m2505o(30608);
                        return;
                    } else if (!C40788j.m70664ax(c7620bi)) {
                        C40788j.m70668b(context, str, c7620bi, z);
                    }
                }
                AppMethodBeat.m2505o(30608);
            }
        }

        private void dCe() {
            AppMethodBeat.m2504i(30609);
            for (C7620bi a : this.yIZ.yIP) {
                m36639a(this.context, a, this.yIZ.yFW, this.fuO);
            }
            AppMethodBeat.m2505o(30609);
        }

        private void dCf() {
            AppMethodBeat.m2504i(30610);
            C30558m.m48699bR(this.context, this.fuO);
            C18348nt c18348nt = new C18348nt();
            c18348nt.cJY.type = 5;
            c18348nt.cJY.cKe = this.yIZ.yIP;
            c18348nt.cJY.toUser = this.fuO;
            c18348nt.cJY.cKf = this.yIZ.cKf;
            c18348nt.cJY.context = this.context;
            c18348nt.cJY.cJy = this.yIZ.cJy;
            c18348nt.cJY.cKh = this.yIZ.yIQ;
            C4879a.xxA.mo10055m(c18348nt);
            AppMethodBeat.m2505o(30610);
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(30611);
            if (C30558m.yIv != null) {
                C30558m.yIv.dismiss();
            }
            C5670b.m8519a(this.context, this.cgL.findViewById(2131825953), this.context.getString(C25738R.string.bvk), null);
            AppMethodBeat.m2505o(30611);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.m$1 */
    static class C305591 implements C36072a {
        C305591() {
        }

        /* renamed from: a */
        public final void mo5750a(ImageView imageView, MenuItem menuItem) {
            AppMethodBeat.m2504i(30597);
            C40460b.m69439t(imageView, menuItem.getTitle());
            AppMethodBeat.m2505o(30597);
        }
    }

    /* renamed from: a */
    public static void m48696a(C46650a c46650a, List<C7620bi> list, boolean z, C46648j c46648j, C7616ad c7616ad) {
        AppMethodBeat.m2504i(30612);
        if (c46650a == null) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, fragment is null");
            AppMethodBeat.m2505o(30612);
        } else if (list == null || list.isEmpty()) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, select item empty");
            AppMethodBeat.m2505o(30612);
        } else {
            C23805a c23805a = new C23805a();
            yIR = c23805a;
            c23805a.yIP = new LinkedList(list);
            yIR.yFW = z;
            yIR.cKf = c7616ad.field_username;
            yIR.yIY = true;
            final Activity context = c46650a.yTx.getContext();
            if (context == null) {
                AppMethodBeat.m2505o(30612);
                return;
            }
            List dBZ;
            C46696j c46696j = new C46696j(context);
            c46696j.zFT = new C305591();
            c46696j.zFU = new C40670b() {
                /* renamed from: a */
                public final void mo5751a(TextView textView, MenuItem menuItem) {
                    AppMethodBeat.m2504i(30598);
                    if (textView != null) {
                        C9638aw.m17190ZK();
                        C7616ad aoO = C18628c.m29078XM().aoO(menuItem.getTitle());
                        if (aoO == null || ((int) aoO.ewQ) <= 0) {
                            textView.setText(menuItem.getTitle());
                            AppMethodBeat.m2505o(30598);
                            return;
                        }
                        textView.setText(C44089j.m79292b(context, aoO.mo16706Oi()));
                    }
                    AppMethodBeat.m2505o(30598);
                }
            };
            if (C35799p.m58695u(context, "com.tencent.wework")) {
                dBZ = C40788j.dBZ();
            } else {
                dBZ = C40788j.dBY();
            }
            c46696j.rBl = new C36073c() {
                /* renamed from: a */
                public final void mo5746a(C44273l c44273l) {
                    AppMethodBeat.m2504i(30599);
                    c44273l.mo70063ax(1193046, C25738R.string.czg, C25738R.drawable.f6543hn);
                    for (CharSequence add : dBZ) {
                        c44273l.add(add);
                    }
                    AppMethodBeat.m2505o(30599);
                }
            };
            final List<C7620bi> list2 = list;
            final C46650a c46650a2 = c46650a;
            final C7616ad c7616ad2 = c7616ad;
            final C46648j c46648j2 = c46648j;
            c46696j.rBm = new C5279d() {

                /* renamed from: com.tencent.mm.ui.chatting.m$4$1 */
                class C157031 implements OnClickListener {
                    C157031() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }

                /* renamed from: com.tencent.mm.ui.chatting.m$4$3 */
                class C157043 implements OnClickListener {
                    C157043() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }

                /* renamed from: com.tencent.mm.ui.chatting.m$4$2 */
                class C305502 implements OnClickListener {
                    C305502() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }

                /* renamed from: com.tencent.mm.ui.chatting.m$4$4 */
                class C305514 implements OnClickListener {
                    C305514() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }

                /* renamed from: com.tencent.mm.ui.chatting.m$4$6 */
                class C305536 implements OnClickListener {
                    C305536() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }

                /* renamed from: com.tencent.mm.ui.chatting.m$4$7 */
                class C305547 implements C36073c {
                    C305547() {
                    }

                    /* renamed from: a */
                    public final void mo5746a(C44273l c44273l) {
                        AppMethodBeat.m2504i(30600);
                        c44273l.mo70072hi(0, C25738R.string.d1y);
                        c44273l.mo70072hi(1, C25738R.string.d1z);
                        AppMethodBeat.m2505o(30600);
                    }
                }

                /* renamed from: com.tencent.mm.ui.chatting.m$4$5 */
                class C305555 implements OnClickListener {
                    C305555() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }

                public final void onMMMenuItemSelected(final MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(30603);
                    if (menuItem.getItemId() == 1193046) {
                        if (C40788j.m70677eS(list2)) {
                            C30379h.m48443a(context, context.getString(C25738R.string.b2y), "", context.getString(C25738R.string.f8636aj), new C157031());
                            AppMethodBeat.m2505o(30603);
                        } else if (C40788j.m70678eT(list2)) {
                            C30379h.m48443a(context, context.getString(C25738R.string.b2z), "", context.getString(C25738R.string.f8636aj), new C305502());
                            AppMethodBeat.m2505o(30603);
                        } else if (C40788j.m70676eR(list2)) {
                            C30379h.m48440a(context, context.getString(C25738R.string.b30), "", new C157043(), null);
                            AppMethodBeat.m2505o(30603);
                        } else {
                            if (C23808n.m36640a(c46650a2, list2, c7616ad2) && c46648j2 != null) {
                                c46648j2.dDL();
                            }
                            AppMethodBeat.m2505o(30603);
                        }
                    } else if (C40788j.m70677eS(list2)) {
                        C30379h.m48443a(context, context.getString(C25738R.string.b2y), "", context.getString(C25738R.string.f8636aj), new C305514());
                        AppMethodBeat.m2505o(30603);
                    } else if (C40788j.m70678eT(list2)) {
                        C30379h.m48443a(context, context.getString(C25738R.string.b2z), "", context.getString(C25738R.string.f8636aj), new C305555());
                        AppMethodBeat.m2505o(30603);
                    } else {
                        boolean z;
                        List<C7620bi> list = list2;
                        if (list != null) {
                            for (C7620bi c7620bi : list) {
                                C26493s uf;
                                if (c7620bi.field_isSend == 1) {
                                    break;
                                } else if (c7620bi.drE()) {
                                    C25822e fJ;
                                    C25822e fI;
                                    if (c7620bi.field_msgId > 0) {
                                        fJ = C32291o.ahl().mo73113fJ(c7620bi.field_msgId);
                                    } else {
                                        fJ = null;
                                    }
                                    if ((fJ == null || fJ.fDy <= 0) && c7620bi.field_msgSvrId > 0) {
                                        fI = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
                                    } else {
                                        fI = fJ;
                                    }
                                    if (fI != null && (fI.offset < fI.frO || fI.frO == 0)) {
                                        z = true;
                                        break;
                                    }
                                } else if (c7620bi.bws()) {
                                    uf = C37961o.all().mo21063uf(c7620bi.field_imgPath);
                                    if (!(uf == null || uf.status == 199 || uf.status == 199)) {
                                        z = true;
                                        break;
                                    }
                                } else if (c7620bi.bwt()) {
                                    uf = C26494u.m42268ut(c7620bi.field_imgPath);
                                    if (!(uf == null || uf.status == 199 || uf.status == 199)) {
                                        z = true;
                                        break;
                                    }
                                } else if (c7620bi.dty()) {
                                    z = !C40788j.m70663aw(c7620bi);
                                }
                            }
                        } else {
                            C4990ab.m7420w("MicroMsg.ChattingEditModeLogic", "check contain undownload image or video error, select item empty");
                        }
                        z = false;
                        if (z || C40788j.m70676eR(list2)) {
                            C30379h.m48440a(context, context.getString(C25738R.string.b30), "", new C305536(), null);
                            AppMethodBeat.m2505o(30603);
                            return;
                        }
                        final String str = (String) menuItem.getTitle();
                        if (C17903f.m28107ra(str)) {
                            if (list2.size() <= 1) {
                                C30558m.yIR.yIY = true;
                                C30558m.m48698a(str, c46650a2, list2);
                                AppMethodBeat.m2505o(30603);
                                return;
                            }
                            C36356d c36356d = new C36356d(context, 1, false);
                            c36356d.rBl = new C305547();
                            c36356d.rBm = new C5279d() {
                                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                    AppMethodBeat.m2504i(30601);
                                    switch (menuItem.getItemId()) {
                                        case 0:
                                            C30558m.yIR.yIY = true;
                                            C30558m.m48698a(str, c46650a2, list2);
                                            AppMethodBeat.m2505o(30601);
                                            return;
                                        case 1:
                                            C30558m.yIR.yIY = false;
                                            C30558m.m48698a(str, c46650a2, list2);
                                            break;
                                    }
                                    AppMethodBeat.m2505o(30601);
                                }
                            };
                            c36356d.cpD();
                            AppMethodBeat.m2505o(30603);
                        } else if (C40788j.m70674eP(list2)) {
                            C30379h.m48440a(context, context.getString(C25738R.string.ce2), "", new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    boolean z;
                                    AppMethodBeat.m2504i(30602);
                                    List<C7620bi> list = list2;
                                    if (list != null && !list.isEmpty()) {
                                        for (C7620bi c7620bi : list) {
                                            if (!C40788j.m70653aA(c7620bi)) {
                                                if (!c7620bi.drD() && !C40788j.m70662av(c7620bi) && !c7620bi.dtw() && !C40788j.m70664ax(c7620bi) && !C40788j.m70665ay(c7620bi) && c7620bi.getType() != -1879048186 && !C40788j.m70658aF(c7620bi) && !C40788j.m70666az(c7620bi) && !C40788j.m70657aE(c7620bi) && !C40788j.m70661aI(c7620bi)) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    C4990ab.m7420w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to brand service error, select item empty");
                                    z = true;
                                    if (z) {
                                        C4990ab.m7420w("MicroMsg.ChattingEditModeSendToBrand", "only contain invalid msg, exit long click mode");
                                        if (c46648j2 != null) {
                                            c46648j2.dDL();
                                        }
                                        AppMethodBeat.m2505o(30602);
                                        return;
                                    }
                                    Context context = context;
                                    context.getString(C25738R.string.f9238tz);
                                    C30558m.yIv = C30379h.m48458b(context, context.getString(C25738R.string.e3l), false, null);
                                    C46648j.yOM.mo39163e(new C23806b(c46650a2, context, menuItem.getTitle(), -1, C30558m.yIR));
                                    if (c46648j2 != null) {
                                        c46648j2.dDL();
                                    }
                                    AppMethodBeat.m2505o(30602);
                                }
                            }, null);
                            AppMethodBeat.m2505o(30603);
                        } else {
                            Context context = context;
                            context.getString(C25738R.string.f9238tz);
                            C30558m.yIv = C30379h.m48458b(context, context.getString(C25738R.string.e3l), false, null);
                            C46648j.yOM.mo39163e(new C23806b(c46650a2, context, menuItem.getTitle(), -1, C30558m.yIR));
                            if (c46648j2 != null) {
                                c46648j2.dDL();
                            }
                            AppMethodBeat.m2505o(30603);
                        }
                    }
                }
            };
            c46696j.cuu();
            AppMethodBeat.m2505o(30612);
        }
    }

    /* renamed from: a */
    public static void m48697a(String str, final C46650a c46650a) {
        AppMethodBeat.m2504i(30614);
        C16527d qX = C17903f.m28104qX(str);
        Intent intent;
        if (qX == null) {
            AppMethodBeat.m2505o(30614);
        } else if (qX.adR()) {
            intent = new Intent(c46650a.yTx.getContext(), BizChatSelectConversationUI.class);
            intent.putExtra("enterprise_biz_name", str);
            intent.putExtra("biz_chat_scene", 2);
            intent.putExtra("enterprise_extra_params", yIR.yIY);
            c46650a.mo74855a(intent, 225, new C25987a() {
                public final void onActivityResult(int i, int i2, Intent intent) {
                    AppMethodBeat.m2504i(30605);
                    if (intent == null) {
                        C4990ab.m7420w("MicroMsg.ChattingEditModeSendToBrand", "[onActivityResult] data is null!");
                        AppMethodBeat.m2505o(30605);
                        return;
                    }
                    if (i == 225) {
                        C30558m.m48695a(c46650a, intent.getStringExtra("enterprise_biz_name"), intent.getLongExtra("key_biz_chat_id", -1));
                    }
                    AppMethodBeat.m2505o(30605);
                }
            });
            AppMethodBeat.m2505o(30614);
        } else {
            if (qX.adP()) {
                intent = new Intent();
                intent.putExtra("enterprise_biz_name", str);
                intent.putExtra("enterprise_scene", 1);
                C25985d.m41458a(c46650a.yTx, "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent, 225);
            }
            AppMethodBeat.m2505o(30614);
        }
    }

    /* renamed from: bR */
    public static C18348nt m48699bR(Context context, String str) {
        AppMethodBeat.m2504i(30615);
        C18348nt c18348nt = new C18348nt();
        c18348nt.cJY.type = 6;
        c18348nt.cJY.cKe = yIR.yIP;
        c18348nt.cJY.toUser = str;
        c18348nt.cJY.cKf = yIR.cKf;
        c18348nt.cJY.context = context;
        C4879a.xxA.mo10055m(c18348nt);
        yIR.cJy = c18348nt.cJZ.cJy;
        yIR.yIQ = c18348nt.cJZ.cKh;
        AppMethodBeat.m2505o(30615);
        return c18348nt;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m48698a(final String str, final C46650a c46650a, List<C7620bi> list) {
        AppMethodBeat.m2504i(30613);
        Context context = c46650a.yTx.getContext();
        if (context == null) {
            AppMethodBeat.m2505o(30613);
            return;
        }
        C16527d qX = C17903f.m28104qX(str);
        if (qX == null) {
            AppMethodBeat.m2505o(30613);
            return;
        }
        String string;
        boolean adR = qX.adR();
        if (yIR.yIY) {
            boolean eP = C40788j.m70674eP(list);
            if (adR) {
                Object obj;
                if (list == null || list.isEmpty()) {
                    C4990ab.m7420w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to bizchat msg error, selected item empty");
                    obj = 1;
                } else {
                    for (C7620bi c7620bi : list) {
                        if (!c7620bi.isText() && !c7620bi.drD() && !c7620bi.drE() && !c7620bi.bAC() && !C40788j.m70656aD(c7620bi)) {
                            int obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                }
                yIR.yIP = new LinkedList(list);
                if (eP || obj2 != null) {
                    string = context.getString(C25738R.string.bds);
                    if (string != null) {
                        C30379h.m48440a(context, string, "", new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(30604);
                                C30558m.m48697a(str, c46650a);
                                AppMethodBeat.m2505o(30604);
                            }
                        }, null);
                        AppMethodBeat.m2505o(30613);
                        return;
                    }
                    C30558m.m48697a(str, c46650a);
                    AppMethodBeat.m2505o(30613);
                    return;
                }
            } else if (eP) {
                string = context.getString(C25738R.string.bdt);
                if (string != null) {
                }
            }
        }
        string = null;
        if (string != null) {
        }
    }

    /* renamed from: a */
    public static void m48695a(C46650a c46650a, String str, long j) {
        AppMethodBeat.m2504i(30616);
        Context context = c46650a.yTx.getContext();
        if (!C42252ah.isNullOrNil(str) && str.length() > 0) {
            context.getString(C25738R.string.f9238tz);
            yIv = C30379h.m48458b(context, context.getString(C25738R.string.e3l), false, null);
            C46648j.yOM.mo39163e(new C23806b(c46650a, context, str, j, yIR));
        }
        ((C15613i) c46650a.mo74857aF(C15613i.class)).dDL();
        AppMethodBeat.m2505o(30616);
    }
}
