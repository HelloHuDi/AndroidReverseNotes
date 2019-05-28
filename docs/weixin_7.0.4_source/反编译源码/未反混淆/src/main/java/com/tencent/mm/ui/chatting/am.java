package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.e;
import com.tencent.mm.at.l;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelmulti.h;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;
import java.util.LinkedList;
import java.util.List;

public final class am {
    public static void m(final String str, final Context context) {
        AppMethodBeat.i(31021);
        if (context == null) {
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: context is null");
            AppMethodBeat.o(31021);
        } else if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: content is null");
            AppMethodBeat.o(31021);
        } else {
            a(eW(z.aeR().le(1)), context, new d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(31010);
                    String str = menuItem.getTitle();
                    ab.i("MicroMsg.LongClickBrandServiceHelper", "connector click[text]: to[%s] text[%s]", str, str);
                    aw.Rg().a(new h(str, str, t.nK(str)), 0);
                    com.tencent.mm.plugin.report.service.h.pYm.e(10424, Integer.valueOf(1), Integer.valueOf(1), str);
                    com.tencent.mm.ui.base.h.bQ(context, context.getString(R.string.td));
                    AppMethodBeat.o(31010);
                }
            });
            AppMethodBeat.o(31021);
        }
    }

    public static void b(final bi biVar, final Context context) {
        AppMethodBeat.i(31022);
        if (context == null) {
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: context is null");
            AppMethodBeat.o(31022);
        } else if (biVar == null) {
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: msg is null");
            AppMethodBeat.o(31022);
        } else {
            aw.ZK();
            if (c.isSDCardAvailable()) {
                a(eW(z.aeR().le(2)), context, new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(31013);
                        String str = menuItem.getTitle();
                        if (bo.isNullOrNil(biVar.field_imgPath)) {
                            ab.e("MicroMsg.LongClickBrandServiceHelper", "Transfer fileName erro: fileName null");
                            AppMethodBeat.o(31013);
                            return;
                        }
                        int i2;
                        p uW = q.uW(biVar.field_imgPath);
                        String str2 = biVar.field_imgPath;
                        if (uW == null) {
                            i2 = 0;
                        } else {
                            i2 = uW.gaf;
                        }
                        ab.i("MicroMsg.LongClickBrandServiceHelper", "connector click[voice]: to[%s] filePath[%s]", str, q.f(str, str2, i2));
                        aw.Rg().a(new f(r0, 1), 0);
                        com.tencent.mm.plugin.report.service.h.pYm.e(10424, Integer.valueOf(34), Integer.valueOf(2), str);
                        com.tencent.mm.ui.base.h.bQ(context, context.getString(R.string.td));
                        AppMethodBeat.o(31013);
                    }
                });
                AppMethodBeat.o(31022);
                return;
            }
            com.tencent.mm.ui.base.t.hO(context);
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: sd card not available");
            AppMethodBeat.o(31022);
        }
    }

    public static void a(final bi biVar, final Context context, final String str, final boolean z) {
        AppMethodBeat.i(31023);
        if (context == null) {
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: context is null");
            AppMethodBeat.o(31023);
        } else if (biVar == null) {
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: msg is null");
            AppMethodBeat.o(31023);
        } else {
            aw.ZK();
            if (c.isSDCardAvailable()) {
                a(eW(z.aeR().le(4)), context, new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        e fI;
                        AppMethodBeat.i(31014);
                        String str = menuItem.getTitle();
                        e eVar = null;
                        if (biVar.field_msgId > 0) {
                            eVar = o.ahl().fJ(biVar.field_msgId);
                        }
                        if ((eVar == null || eVar.fDy <= 0) && biVar.field_msgSvrId > 0) {
                            fI = o.ahl().fI(biVar.field_msgSvrId);
                        } else {
                            fI = eVar;
                        }
                        int i2;
                        if (fI == null) {
                            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: try get imgInfo fail");
                            AppMethodBeat.o(31014);
                        } else if (fI.offset < fI.frO || fI.frO == 0) {
                            String str2;
                            Bundle bundle;
                            Intent intent = new Intent(context, ImageGalleryUI.class);
                            intent.putExtra("img_gallery_msg_id", biVar.field_msgId);
                            intent.putExtra("img_gallery_msg_svr_id", biVar.field_msgSvrId);
                            intent.putExtra("img_gallery_talker", biVar.field_talker);
                            intent.putExtra("img_gallery_chatroom_name", biVar.field_talker);
                            intent.putExtra("img_gallery_is_restransmit_after_download", true);
                            intent.putExtra("img_gallery_directly_send_name", str);
                            intent.putExtra("start_chatting_ui", false);
                            String str3 = biVar.field_talker;
                            Bundle bundle2 = new Bundle();
                            if (z) {
                                str2 = "stat_scene";
                                i2 = 2;
                                bundle = bundle2;
                            } else {
                                str2 = "stat_scene";
                                if (t.mZ(str3)) {
                                    i2 = 7;
                                    bundle = bundle2;
                                } else {
                                    i2 = 1;
                                    bundle = bundle2;
                                }
                            }
                            bundle.putInt(str2, i2);
                            bundle2.putString("stat_msg_id", "msg_" + Long.toString(biVar.field_msgSvrId));
                            bundle2.putString("stat_chat_talker_username", str3);
                            bundle2.putString("stat_send_msg_user", str);
                            intent.putExtra("_stat_obj", bundle2);
                            context.startActivity(intent);
                            AppMethodBeat.o(31014);
                        } else {
                            int i3;
                            if (biVar.field_isSend == 1) {
                                if (fI.agQ()) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                i3 = i2;
                            } else if (!fI.agQ()) {
                                i3 = 0;
                            } else if (com.tencent.mm.vfs.e.ct(com.tencent.mm.at.f.a(fI).fDz)) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            String Yz = r.Yz();
                            String q = o.ahl().q(com.tencent.mm.at.f.c(fI), "", "");
                            if (!bo.isNullOrNil(q)) {
                                ab.i("MicroMsg.LongClickBrandServiceHelper", "connector click[img]: to[%s] fileName[%s]", str, q);
                                aw.Rg().a(new l(4, Yz, str, q, i3, null, 0, "", "", true, R.drawable.b0p), 0);
                                bv.aaq().c(bv.fnv, null);
                            }
                            com.tencent.mm.plugin.report.service.h.pYm.e(10424, Integer.valueOf(3), Integer.valueOf(4), str);
                            com.tencent.mm.ui.base.h.bQ(context, context.getString(R.string.td));
                            AppMethodBeat.o(31014);
                        }
                    }
                });
                AppMethodBeat.o(31023);
                return;
            }
            com.tencent.mm.ui.base.t.hO(context);
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: sd card is not available");
            AppMethodBeat.o(31023);
        }
    }

    public static void c(final bi biVar, final Context context) {
        AppMethodBeat.i(31024);
        if (context == null) {
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: context is null");
            AppMethodBeat.o(31024);
        } else if (biVar == null) {
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: msg is null");
            AppMethodBeat.o(31024);
        } else {
            aw.ZK();
            if (c.isSDCardAvailable()) {
                a(eW(z.aeR().le(8)), context, new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(31015);
                        String str = menuItem.getTitle();
                        s ut = u.ut(biVar.field_imgPath);
                        ab.i("MicroMsg.LongClickBrandServiceHelper", "connector click[video]: to[%s] imgPath[%s]", str, biVar.field_imgPath);
                        final a aVar = new a();
                        Context context = context;
                        context.getResources().getString(R.string.tz);
                        com.tencent.mm.ui.base.p b = com.tencent.mm.ui.base.h.b(context, context.getResources().getString(R.string.th), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                aVar.zJA = true;
                            }
                        });
                        aVar.context = context;
                        aVar.fileName = biVar.field_imgPath;
                        aVar.gII = b;
                        aVar.userName = str;
                        aVar.zIW = ut.fXh;
                        aVar.fXd = ut.fXd;
                        aVar.execute(new Object[0]);
                        bv.aaq().c(bv.fnw, null);
                        com.tencent.mm.ui.base.h.bQ(context, context.getString(R.string.td));
                        AppMethodBeat.o(31015);
                    }
                });
                AppMethodBeat.o(31024);
                return;
            }
            com.tencent.mm.ui.base.t.hO(context);
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: sd card is not available");
            AppMethodBeat.o(31024);
        }
    }

    public static void n(final String str, final Context context) {
        AppMethodBeat.i(31025);
        if (context == null) {
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: context is null");
            AppMethodBeat.o(31025);
        } else if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: locationXML is null");
            AppMethodBeat.o(31025);
        } else {
            a(eW(z.aeR().le(16)), context, new d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(31016);
                    ab.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", menuItem.getTitle(), str);
                    aw.Rg().a(new h(r0, str, 48), 0);
                    com.tencent.mm.plugin.report.service.h.pYm.e(10424, Integer.valueOf(48), Integer.valueOf(16), r0);
                    com.tencent.mm.ui.base.h.bQ(context, context.getString(R.string.td));
                    AppMethodBeat.o(31016);
                }
            });
            AppMethodBeat.o(31025);
        }
    }

    public static void o(final String str, final Context context) {
        AppMethodBeat.i(31026);
        if (context == null) {
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: context is null");
            AppMethodBeat.o(31026);
        } else if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: locationXML is null");
            AppMethodBeat.o(31026);
        } else {
            a(eW(z.aeR().le(32)), context, new d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    int i2 = 66;
                    AppMethodBeat.i(31017);
                    String str = menuItem.getTitle();
                    ab.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", str, str);
                    bi.a apC = bi.a.apC(str);
                    aw.Rg().a(new h(str, str, ad.aox(apC.svN) ? 66 : 42), 0);
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                    Object[] objArr = new Object[3];
                    if (!ad.aox(apC.svN)) {
                        i2 = 42;
                    }
                    objArr[0] = Integer.valueOf(i2);
                    objArr[1] = Integer.valueOf(32);
                    objArr[2] = str;
                    hVar.e(10424, objArr);
                    com.tencent.mm.ui.base.h.bQ(context, context.getString(R.string.td));
                    AppMethodBeat.o(31017);
                }
            });
            AppMethodBeat.o(31026);
        }
    }

    public static void d(final bi biVar, final Context context) {
        AppMethodBeat.i(31027);
        if (context == null) {
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: context is null");
            AppMethodBeat.o(31027);
        } else if (biVar == null) {
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: msg is null");
            AppMethodBeat.o(31027);
        } else {
            aw.ZK();
            if (c.isSDCardAvailable()) {
                a(eW(z.aeR().le(64)), context, new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        String str;
                        AppMethodBeat.i(31018);
                        String str2 = menuItem.getTitle();
                        String str3 = ap.aps(biVar.field_content).cvZ;
                        if (str3 == null || str3.endsWith("-1")) {
                            str = biVar.field_imgPath;
                        } else {
                            str = str3;
                        }
                        if (str == null) {
                            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: filePath is null");
                            AppMethodBeat.o(31018);
                            return;
                        }
                        ab.i("MicroMsg.LongClickBrandServiceHelper", "connector click[emoji]: to[%s] filePath[%s]", str2, str);
                        if (((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().r(context, str2, str)) {
                            com.tencent.mm.plugin.report.service.h.pYm.e(10424, Integer.valueOf(47), Integer.valueOf(64), str2);
                            com.tencent.mm.ui.base.h.bQ(context, "");
                        }
                        com.tencent.mm.plugin.report.service.h.pYm.e(10424, Integer.valueOf(47), Integer.valueOf(64), str2);
                        com.tencent.mm.ui.base.h.bQ(context, context.getString(R.string.td));
                        AppMethodBeat.o(31018);
                    }
                });
                AppMethodBeat.o(31027);
                return;
            }
            com.tencent.mm.ui.base.t.hO(context);
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: sd card is not available");
            AppMethodBeat.o(31027);
        }
    }

    public static void a(bi biVar, String str, Context context) {
        AppMethodBeat.i(31028);
        a(biVar, str, context, 512);
        AppMethodBeat.o(31028);
    }

    public static void b(bi biVar, String str, Context context) {
        AppMethodBeat.i(31029);
        a(biVar, str, context, 256);
        AppMethodBeat.o(31029);
    }

    public static void c(bi biVar, String str, Context context) {
        AppMethodBeat.i(31030);
        a(biVar, str, context, 128);
        AppMethodBeat.o(31030);
    }

    private static void a(final bi biVar, final String str, final Context context, final int i) {
        AppMethodBeat.i(31031);
        if (context == null) {
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: context is null");
            AppMethodBeat.o(31031);
        } else if (biVar == null) {
            ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: msg is null");
            AppMethodBeat.o(31031);
        } else {
            List list = null;
            switch (i) {
                case 128:
                    list = eW(com.tencent.mm.aj.f.aeC());
                    break;
                case 256:
                    list = eW(com.tencent.mm.aj.f.aeE());
                    break;
                case 512:
                    list = eW(com.tencent.mm.aj.f.aeG());
                    break;
            }
            a(list, context, new d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(31019);
                    String str = menuItem.getTitle();
                    bi biVar = biVar;
                    b me = b.me(bo.anj(str));
                    if (me == null) {
                        ab.w("MicroMsg.LongClickBrandServiceHelper", "send: parse app msg content return null");
                    } else {
                        byte[] bArr = null;
                        if (!(biVar.field_imgPath == null || biVar.field_imgPath.equals(""))) {
                            try {
                                bArr = com.tencent.mm.vfs.e.e(o.ahl().I(biVar.field_imgPath, true), 0, -1);
                            } catch (Exception e) {
                                ab.e("MicroMsg.LongClickBrandServiceHelper", "send appmsg to %s, error:%s", str, e.getLocalizedMessage());
                            }
                        }
                        com.tencent.mm.pluginsdk.model.app.b bVar = new com.tencent.mm.pluginsdk.model.app.b();
                        if (!bo.isNullOrNil(me.csD)) {
                            long j = bo.getLong(me.csD, -1);
                            if (j != -1) {
                                com.tencent.mm.pluginsdk.model.app.am.aUq().b(j, (com.tencent.mm.sdk.e.c) bVar);
                                if (bVar.xDa != j) {
                                    bVar = com.tencent.mm.pluginsdk.model.app.am.aUq().aiE(me.csD);
                                    if (bVar == null || !bVar.field_mediaSvrId.equals(me.csD)) {
                                        bVar = null;
                                    }
                                }
                            } else {
                                bVar = com.tencent.mm.pluginsdk.model.app.am.aUq().aiE(me.csD);
                                if (bVar == null || !bVar.field_mediaSvrId.equals(me.csD)) {
                                    bVar = null;
                                }
                            }
                        }
                        String str2 = "";
                        if (!(bVar == null || bVar.field_fileFullPath == null || bVar.field_fileFullPath.equals(""))) {
                            aw.ZK();
                            str2 = com.tencent.mm.pluginsdk.model.app.l.X(c.Ye(), me.title, me.fgp);
                            com.tencent.mm.vfs.e.y(bVar.field_fileFullPath, str2);
                        }
                        b a = b.a(me);
                        a.fgr = 3;
                        com.tencent.mm.pluginsdk.model.app.l.a(a, me.appId, me.appName, str, str2, bArr, null);
                    }
                    switch (i) {
                        case 128:
                            com.tencent.mm.plugin.report.service.h.pYm.e(10424, Integer.valueOf(49), Integer.valueOf(128), str);
                            break;
                        case 256:
                            com.tencent.mm.plugin.report.service.h.pYm.e(10424, Integer.valueOf(49), Integer.valueOf(256), str);
                            break;
                        case 512:
                            com.tencent.mm.plugin.report.service.h.pYm.e(10424, Integer.valueOf(49), Integer.valueOf(512), str);
                            break;
                    }
                    com.tencent.mm.ui.base.h.bQ(context, context.getString(R.string.td));
                    AppMethodBeat.o(31019);
                }
            });
            AppMethodBeat.o(31031);
        }
    }

    private static List<String> eW(List<String> list) {
        AppMethodBeat.i(31032);
        LinkedList linkedList = new LinkedList();
        for (String str : list) {
            if (!com.tencent.mm.aj.f.ra(str)) {
                linkedList.add(str);
            }
        }
        ab.d("MicroMsg.LongClickBrandServiceHelper", "get selected accept list, size %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(31032);
        return linkedList;
    }

    private static void a(final List<String> list, final Context context, d dVar) {
        AppMethodBeat.i(31033);
        if (list == null || list.isEmpty()) {
            ab.w("MicroMsg.LongClickBrandServiceHelper", "tryShowConnectorDialog: careList is null or empty");
            AppMethodBeat.o(31033);
            return;
        }
        j jVar = new j(context);
        jVar.zFT = new n.a() {
            public final void a(ImageView imageView, MenuItem menuItem) {
                AppMethodBeat.i(31020);
                com.tencent.mm.pluginsdk.ui.a.b.b(imageView, menuItem.getTitle());
                AppMethodBeat.o(31020);
            }
        };
        jVar.zFU = new n.b() {
            public final void a(TextView textView, MenuItem menuItem) {
                AppMethodBeat.i(31011);
                if (textView != null) {
                    aw.ZK();
                    ad aoO = c.XM().aoO(menuItem.getTitle());
                    if (aoO == null || ((int) aoO.ewQ) <= 0) {
                        textView.setText(menuItem.getTitle());
                        AppMethodBeat.o(31011);
                        return;
                    }
                    textView.setText(com.tencent.mm.pluginsdk.ui.e.j.b(context, aoO.Oi(), textView.getTextSize()));
                }
                AppMethodBeat.o(31011);
            }
        };
        jVar.rBl = new n.c() {
            public final void a(com.tencent.mm.ui.base.l lVar) {
                AppMethodBeat.i(31012);
                for (CharSequence add : list) {
                    lVar.add(add);
                }
                AppMethodBeat.o(31012);
            }
        };
        jVar.rBm = dVar;
        jVar.cuu();
        AppMethodBeat.o(31033);
    }
}
