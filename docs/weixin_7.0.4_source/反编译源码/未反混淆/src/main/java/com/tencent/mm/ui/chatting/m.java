package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.bizchat.BizChatSelectConversationUI;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.j;
import java.util.LinkedList;
import java.util.List;

public final class m {
    private static a yIR;
    private static p yIv = null;

    static class a {
        cl cJy;
        String cKf;
        boolean yFW;
        List<bi> yIP;
        d yIQ;
        boolean yIY;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    static class b implements com.tencent.mm.sdk.platformtools.az.a {
        private com.tencent.mm.ui.chatting.d.a cgL;
        private Context context;
        private String fuO;
        private long jMj;
        private boolean mgP;
        private a yIZ;

        public b(com.tencent.mm.ui.chatting.d.a aVar, Context context, String str, long j, a aVar2) {
            AppMethodBeat.i(30606);
            this.cgL = aVar;
            this.context = context;
            this.fuO = str;
            this.jMj = j;
            this.yIZ = aVar2;
            this.mgP = f.kq(str);
            AppMethodBeat.o(30606);
        }

        public final boolean acf() {
            AppMethodBeat.i(30607);
            if (this.mgP) {
                c aK = z.aeT().aK(this.jMj);
                synchronized (e.fxC) {
                    try {
                        String aae = e.aae();
                        e.d(aK);
                        if (this.yIZ.yIY) {
                            dCe();
                        } else {
                            dCf();
                        }
                        e.rx(aae);
                    } finally {
                        AppMethodBeat.o(30607);
                    }
                }
            } else {
                if (this.yIZ.yIY) {
                    dCe();
                } else {
                    dCf();
                }
                AppMethodBeat.o(30607);
            }
            return true;
        }

        private void a(Context context, bi biVar, boolean z, String str) {
            AppMethodBeat.i(30608);
            if (biVar.isText()) {
                j.a(context, str, biVar, z);
                AppMethodBeat.o(30608);
            } else if (biVar.drE()) {
                j.b(context, str, biVar);
                AppMethodBeat.o(30608);
            } else if (biVar.bws() && !this.mgP) {
                j.c(context, str, biVar);
                AppMethodBeat.o(30608);
            } else if (biVar.bAC()) {
                j.c(context, str, biVar, z);
                AppMethodBeat.o(30608);
            } else {
                if ((biVar.dtx() || biVar.dty()) && !this.mgP) {
                    if (!j.av(biVar)) {
                        j.a(context, str, biVar);
                        AppMethodBeat.o(30608);
                        return;
                    }
                } else if (biVar.bAA()) {
                    if (this.mgP && !j.aD(biVar)) {
                        AppMethodBeat.o(30608);
                        return;
                    } else if (j.aE(biVar)) {
                        AppMethodBeat.o(30608);
                        return;
                    } else if (biVar.getType() == 318767153) {
                        AppMethodBeat.o(30608);
                        return;
                    } else if (j.aI(biVar)) {
                        AppMethodBeat.o(30608);
                        return;
                    } else if (!j.ax(biVar)) {
                        j.b(context, str, biVar, z);
                    }
                }
                AppMethodBeat.o(30608);
            }
        }

        private void dCe() {
            AppMethodBeat.i(30609);
            for (bi a : this.yIZ.yIP) {
                a(this.context, a, this.yIZ.yFW, this.fuO);
            }
            AppMethodBeat.o(30609);
        }

        private void dCf() {
            AppMethodBeat.i(30610);
            m.bR(this.context, this.fuO);
            nt ntVar = new nt();
            ntVar.cJY.type = 5;
            ntVar.cJY.cKe = this.yIZ.yIP;
            ntVar.cJY.toUser = this.fuO;
            ntVar.cJY.cKf = this.yIZ.cKf;
            ntVar.cJY.context = this.context;
            ntVar.cJY.cJy = this.yIZ.cJy;
            ntVar.cJY.cKh = this.yIZ.yIQ;
            com.tencent.mm.sdk.b.a.xxA.m(ntVar);
            AppMethodBeat.o(30610);
        }

        public final boolean acg() {
            AppMethodBeat.i(30611);
            if (m.yIv != null) {
                m.yIv.dismiss();
            }
            com.tencent.mm.ui.widget.snackbar.b.a(this.context, this.cgL.findViewById(R.id.d88), this.context.getString(R.string.bvk), null);
            AppMethodBeat.o(30611);
            return true;
        }
    }

    public static void a(com.tencent.mm.ui.chatting.d.a aVar, List<bi> list, boolean z, j jVar, ad adVar) {
        AppMethodBeat.i(30612);
        if (aVar == null) {
            ab.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, fragment is null");
            AppMethodBeat.o(30612);
        } else if (list == null || list.isEmpty()) {
            ab.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, select item empty");
            AppMethodBeat.o(30612);
        } else {
            a aVar2 = new a();
            yIR = aVar2;
            aVar2.yIP = new LinkedList(list);
            yIR.yFW = z;
            yIR.cKf = adVar.field_username;
            yIR.yIY = true;
            final Activity context = aVar.yTx.getContext();
            if (context == null) {
                AppMethodBeat.o(30612);
                return;
            }
            List dBZ;
            com.tencent.mm.ui.tools.j jVar2 = new com.tencent.mm.ui.tools.j(context);
            jVar2.zFT = new com.tencent.mm.ui.base.n.a() {
                public final void a(ImageView imageView, MenuItem menuItem) {
                    AppMethodBeat.i(30597);
                    com.tencent.mm.pluginsdk.ui.a.b.t(imageView, menuItem.getTitle());
                    AppMethodBeat.o(30597);
                }
            };
            jVar2.zFU = new com.tencent.mm.ui.base.n.b() {
                public final void a(TextView textView, MenuItem menuItem) {
                    AppMethodBeat.i(30598);
                    if (textView != null) {
                        aw.ZK();
                        ad aoO = com.tencent.mm.model.c.XM().aoO(menuItem.getTitle());
                        if (aoO == null || ((int) aoO.ewQ) <= 0) {
                            textView.setText(menuItem.getTitle());
                            AppMethodBeat.o(30598);
                            return;
                        }
                        textView.setText(com.tencent.mm.pluginsdk.ui.e.j.b(context, aoO.Oi()));
                    }
                    AppMethodBeat.o(30598);
                }
            };
            if (com.tencent.mm.pluginsdk.model.app.p.u(context, "com.tencent.wework")) {
                dBZ = j.dBZ();
            } else {
                dBZ = j.dBY();
            }
            jVar2.rBl = new n.c() {
                public final void a(l lVar) {
                    AppMethodBeat.i(30599);
                    lVar.ax(1193046, R.string.czg, R.drawable.hn);
                    for (CharSequence add : dBZ) {
                        lVar.add(add);
                    }
                    AppMethodBeat.o(30599);
                }
            };
            final List<bi> list2 = list;
            final com.tencent.mm.ui.chatting.d.a aVar3 = aVar;
            final ad adVar2 = adVar;
            final j jVar3 = jVar;
            jVar2.rBm = new n.d() {
                public final void onMMMenuItemSelected(final MenuItem menuItem, int i) {
                    AppMethodBeat.i(30603);
                    if (menuItem.getItemId() == 1193046) {
                        if (j.eS(list2)) {
                            h.a(context, context.getString(R.string.b2y), "", context.getString(R.string.aj), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            AppMethodBeat.o(30603);
                        } else if (j.eT(list2)) {
                            h.a(context, context.getString(R.string.b2z), "", context.getString(R.string.aj), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            AppMethodBeat.o(30603);
                        } else if (j.eR(list2)) {
                            h.a(context, context.getString(R.string.b30), "", new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }, null);
                            AppMethodBeat.o(30603);
                        } else {
                            if (n.a(aVar3, list2, adVar2) && jVar3 != null) {
                                jVar3.dDL();
                            }
                            AppMethodBeat.o(30603);
                        }
                    } else if (j.eS(list2)) {
                        h.a(context, context.getString(R.string.b2y), "", context.getString(R.string.aj), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        AppMethodBeat.o(30603);
                    } else if (j.eT(list2)) {
                        h.a(context, context.getString(R.string.b2z), "", context.getString(R.string.aj), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        AppMethodBeat.o(30603);
                    } else {
                        boolean z;
                        List<bi> list = list2;
                        if (list != null) {
                            for (bi biVar : list) {
                                s uf;
                                if (biVar.field_isSend == 1) {
                                    break;
                                } else if (biVar.drE()) {
                                    com.tencent.mm.at.e fJ;
                                    com.tencent.mm.at.e fI;
                                    if (biVar.field_msgId > 0) {
                                        fJ = o.ahl().fJ(biVar.field_msgId);
                                    } else {
                                        fJ = null;
                                    }
                                    if ((fJ == null || fJ.fDy <= 0) && biVar.field_msgSvrId > 0) {
                                        fI = o.ahl().fI(biVar.field_msgSvrId);
                                    } else {
                                        fI = fJ;
                                    }
                                    if (fI != null && (fI.offset < fI.frO || fI.frO == 0)) {
                                        z = true;
                                        break;
                                    }
                                } else if (biVar.bws()) {
                                    uf = com.tencent.mm.modelvideo.o.all().uf(biVar.field_imgPath);
                                    if (!(uf == null || uf.status == 199 || uf.status == 199)) {
                                        z = true;
                                        break;
                                    }
                                } else if (biVar.bwt()) {
                                    uf = u.ut(biVar.field_imgPath);
                                    if (!(uf == null || uf.status == 199 || uf.status == 199)) {
                                        z = true;
                                        break;
                                    }
                                } else if (biVar.dty()) {
                                    z = !j.aw(biVar);
                                }
                            }
                        } else {
                            ab.w("MicroMsg.ChattingEditModeLogic", "check contain undownload image or video error, select item empty");
                        }
                        z = false;
                        if (z || j.eR(list2)) {
                            h.a(context, context.getString(R.string.b30), "", new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }, null);
                            AppMethodBeat.o(30603);
                            return;
                        }
                        final String str = (String) menuItem.getTitle();
                        if (f.ra(str)) {
                            if (list2.size() <= 1) {
                                m.yIR.yIY = true;
                                m.a(str, aVar3, list2);
                                AppMethodBeat.o(30603);
                                return;
                            }
                            com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(context, 1, false);
                            dVar.rBl = new n.c() {
                                public final void a(l lVar) {
                                    AppMethodBeat.i(30600);
                                    lVar.hi(0, R.string.d1y);
                                    lVar.hi(1, R.string.d1z);
                                    AppMethodBeat.o(30600);
                                }
                            };
                            dVar.rBm = new n.d() {
                                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                    AppMethodBeat.i(30601);
                                    switch (menuItem.getItemId()) {
                                        case 0:
                                            m.yIR.yIY = true;
                                            m.a(str, aVar3, list2);
                                            AppMethodBeat.o(30601);
                                            return;
                                        case 1:
                                            m.yIR.yIY = false;
                                            m.a(str, aVar3, list2);
                                            break;
                                    }
                                    AppMethodBeat.o(30601);
                                }
                            };
                            dVar.cpD();
                            AppMethodBeat.o(30603);
                        } else if (j.eP(list2)) {
                            h.a(context, context.getString(R.string.ce2), "", new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    boolean z;
                                    AppMethodBeat.i(30602);
                                    List<bi> list = list2;
                                    if (list != null && !list.isEmpty()) {
                                        for (bi biVar : list) {
                                            if (!j.aA(biVar)) {
                                                if (!biVar.drD() && !j.av(biVar) && !biVar.dtw() && !j.ax(biVar) && !j.ay(biVar) && biVar.getType() != -1879048186 && !j.aF(biVar) && !j.az(biVar) && !j.aE(biVar) && !j.aI(biVar)) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    ab.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to brand service error, select item empty");
                                    z = true;
                                    if (z) {
                                        ab.w("MicroMsg.ChattingEditModeSendToBrand", "only contain invalid msg, exit long click mode");
                                        if (jVar3 != null) {
                                            jVar3.dDL();
                                        }
                                        AppMethodBeat.o(30602);
                                        return;
                                    }
                                    Context context = context;
                                    context.getString(R.string.tz);
                                    m.yIv = h.b(context, context.getString(R.string.e3l), false, null);
                                    j.yOM.e(new b(aVar3, context, menuItem.getTitle(), -1, m.yIR));
                                    if (jVar3 != null) {
                                        jVar3.dDL();
                                    }
                                    AppMethodBeat.o(30602);
                                }
                            }, null);
                            AppMethodBeat.o(30603);
                        } else {
                            Context context = context;
                            context.getString(R.string.tz);
                            m.yIv = h.b(context, context.getString(R.string.e3l), false, null);
                            j.yOM.e(new b(aVar3, context, menuItem.getTitle(), -1, m.yIR));
                            if (jVar3 != null) {
                                jVar3.dDL();
                            }
                            AppMethodBeat.o(30603);
                        }
                    }
                }
            };
            jVar2.cuu();
            AppMethodBeat.o(30612);
        }
    }

    public static void a(String str, final com.tencent.mm.ui.chatting.d.a aVar) {
        AppMethodBeat.i(30614);
        com.tencent.mm.aj.d qX = f.qX(str);
        Intent intent;
        if (qX == null) {
            AppMethodBeat.o(30614);
        } else if (qX.adR()) {
            intent = new Intent(aVar.yTx.getContext(), BizChatSelectConversationUI.class);
            intent.putExtra("enterprise_biz_name", str);
            intent.putExtra("biz_chat_scene", 2);
            intent.putExtra("enterprise_extra_params", yIR.yIY);
            aVar.a(intent, 225, new com.tencent.mm.bp.d.a() {
                public final void onActivityResult(int i, int i2, Intent intent) {
                    AppMethodBeat.i(30605);
                    if (intent == null) {
                        ab.w("MicroMsg.ChattingEditModeSendToBrand", "[onActivityResult] data is null!");
                        AppMethodBeat.o(30605);
                        return;
                    }
                    if (i == 225) {
                        m.a(aVar, intent.getStringExtra("enterprise_biz_name"), intent.getLongExtra("key_biz_chat_id", -1));
                    }
                    AppMethodBeat.o(30605);
                }
            });
            AppMethodBeat.o(30614);
        } else {
            if (qX.adP()) {
                intent = new Intent();
                intent.putExtra("enterprise_biz_name", str);
                intent.putExtra("enterprise_scene", 1);
                com.tencent.mm.bp.d.a(aVar.yTx, "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent, 225);
            }
            AppMethodBeat.o(30614);
        }
    }

    public static nt bR(Context context, String str) {
        AppMethodBeat.i(30615);
        nt ntVar = new nt();
        ntVar.cJY.type = 6;
        ntVar.cJY.cKe = yIR.yIP;
        ntVar.cJY.toUser = str;
        ntVar.cJY.cKf = yIR.cKf;
        ntVar.cJY.context = context;
        com.tencent.mm.sdk.b.a.xxA.m(ntVar);
        yIR.cJy = ntVar.cJZ.cJy;
        yIR.yIQ = ntVar.cJZ.cKh;
        AppMethodBeat.o(30615);
        return ntVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(final String str, final com.tencent.mm.ui.chatting.d.a aVar, List<bi> list) {
        AppMethodBeat.i(30613);
        Context context = aVar.yTx.getContext();
        if (context == null) {
            AppMethodBeat.o(30613);
            return;
        }
        com.tencent.mm.aj.d qX = f.qX(str);
        if (qX == null) {
            AppMethodBeat.o(30613);
            return;
        }
        String string;
        boolean adR = qX.adR();
        if (yIR.yIY) {
            boolean eP = j.eP(list);
            if (adR) {
                Object obj;
                if (list == null || list.isEmpty()) {
                    ab.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to bizchat msg error, selected item empty");
                    obj = 1;
                } else {
                    for (bi biVar : list) {
                        if (!biVar.isText() && !biVar.drD() && !biVar.drE() && !biVar.bAC() && !j.aD(biVar)) {
                            int obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                }
                yIR.yIP = new LinkedList(list);
                if (eP || obj2 != null) {
                    string = context.getString(R.string.bds);
                    if (string != null) {
                        h.a(context, string, "", new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(30604);
                                m.a(str, aVar);
                                AppMethodBeat.o(30604);
                            }
                        }, null);
                        AppMethodBeat.o(30613);
                        return;
                    }
                    a(str, aVar);
                    AppMethodBeat.o(30613);
                    return;
                }
            } else if (eP) {
                string = context.getString(R.string.bdt);
                if (string != null) {
                }
            }
        }
        string = null;
        if (string != null) {
        }
    }

    public static void a(com.tencent.mm.ui.chatting.d.a aVar, String str, long j) {
        AppMethodBeat.i(30616);
        Context context = aVar.yTx.getContext();
        if (!ah.isNullOrNil(str) && str.length() > 0) {
            context.getString(R.string.tz);
            yIv = h.b(context, context.getString(R.string.e3l), false, null);
            j.yOM.e(new b(aVar, context, str, j, yIR));
        }
        ((i) aVar.aF(i.class)).dDL();
        AppMethodBeat.o(30616);
    }
}
