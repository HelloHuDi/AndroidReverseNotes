package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37907bv;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelmulti.C26451h;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvoice.C32849p;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.modelvoice.C45461f;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p190at.C9022l;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36072a;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C40670b;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.chatting.gallery.ImageGalleryUI;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI.C36349a;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44218ap;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.p177mm.vfs.C5730e;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.am */
public final class C44288am {

    /* renamed from: com.tencent.mm.ui.chatting.am$11 */
    static class C4071011 implements C36072a {
        C4071011() {
        }

        /* renamed from: a */
        public final void mo5750a(ImageView imageView, MenuItem menuItem) {
            AppMethodBeat.m2504i(31020);
            C40460b.m69434b(imageView, menuItem.getTitle());
            AppMethodBeat.m2505o(31020);
        }
    }

    /* renamed from: m */
    public static void m80035m(final String str, final Context context) {
        AppMethodBeat.m2504i(31021);
        if (context == null) {
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: context is null");
            AppMethodBeat.m2505o(31021);
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: content is null");
            AppMethodBeat.m2505o(31021);
        } else {
            C44288am.m80028a(C44288am.m80034eW(C41747z.aeR().mo43727le(1)), context, new C5279d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(31010);
                    String str = menuItem.getTitle();
                    C4990ab.m7417i("MicroMsg.LongClickBrandServiceHelper", "connector click[text]: to[%s] text[%s]", str, str);
                    C9638aw.m17182Rg().mo14541a(new C26451h(str, str, C1855t.m3925nK(str)), 0);
                    C7060h.pYm.mo8381e(10424, Integer.valueOf(1), Integer.valueOf(1), str);
                    C30379h.m48465bQ(context, context.getString(C25738R.string.f9219td));
                    AppMethodBeat.m2505o(31010);
                }
            });
            AppMethodBeat.m2505o(31021);
        }
    }

    /* renamed from: b */
    public static void m80029b(final C7620bi c7620bi, final Context context) {
        AppMethodBeat.m2504i(31022);
        if (context == null) {
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: context is null");
            AppMethodBeat.m2505o(31022);
        } else if (c7620bi == null) {
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: msg is null");
            AppMethodBeat.m2505o(31022);
        } else {
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                C44288am.m80028a(C44288am.m80034eW(C41747z.aeR().mo43727le(2)), context, new C5279d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.m2504i(31013);
                        String str = menuItem.getTitle();
                        if (C5046bo.isNullOrNil(c7620bi.field_imgPath)) {
                            C4990ab.m7412e("MicroMsg.LongClickBrandServiceHelper", "Transfer fileName erro: fileName null");
                            AppMethodBeat.m2505o(31013);
                            return;
                        }
                        int i2;
                        C32849p uW = C32850q.m53736uW(c7620bi.field_imgPath);
                        String str2 = c7620bi.field_imgPath;
                        if (uW == null) {
                            i2 = 0;
                        } else {
                            i2 = uW.gaf;
                        }
                        C4990ab.m7417i("MicroMsg.LongClickBrandServiceHelper", "connector click[voice]: to[%s] filePath[%s]", str, C32850q.m53721f(str, str2, i2));
                        C9638aw.m17182Rg().mo14541a(new C45461f(r0, 1), 0);
                        C7060h.pYm.mo8381e(10424, Integer.valueOf(34), Integer.valueOf(2), str);
                        C30379h.m48465bQ(context, context.getString(C25738R.string.f9219td));
                        AppMethodBeat.m2505o(31013);
                    }
                });
                AppMethodBeat.m2505o(31022);
                return;
            }
            C23639t.m36492hO(context);
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: sd card not available");
            AppMethodBeat.m2505o(31022);
        }
    }

    /* renamed from: a */
    public static void m80025a(final C7620bi c7620bi, final Context context, final String str, final boolean z) {
        AppMethodBeat.m2504i(31023);
        if (context == null) {
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: context is null");
            AppMethodBeat.m2505o(31023);
        } else if (c7620bi == null) {
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: msg is null");
            AppMethodBeat.m2505o(31023);
        } else {
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                C44288am.m80028a(C44288am.m80034eW(C41747z.aeR().mo43727le(4)), context, new C5279d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        C25822e fI;
                        AppMethodBeat.m2504i(31014);
                        String str = menuItem.getTitle();
                        C25822e c25822e = null;
                        if (c7620bi.field_msgId > 0) {
                            c25822e = C32291o.ahl().mo73113fJ(c7620bi.field_msgId);
                        }
                        if ((c25822e == null || c25822e.fDy <= 0) && c7620bi.field_msgSvrId > 0) {
                            fI = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
                        } else {
                            fI = c25822e;
                        }
                        int i2;
                        if (fI == null) {
                            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: try get imgInfo fail");
                            AppMethodBeat.m2505o(31014);
                        } else if (fI.offset < fI.frO || fI.frO == 0) {
                            String str2;
                            Bundle bundle;
                            Intent intent = new Intent(context, ImageGalleryUI.class);
                            intent.putExtra("img_gallery_msg_id", c7620bi.field_msgId);
                            intent.putExtra("img_gallery_msg_svr_id", c7620bi.field_msgSvrId);
                            intent.putExtra("img_gallery_talker", c7620bi.field_talker);
                            intent.putExtra("img_gallery_chatroom_name", c7620bi.field_talker);
                            intent.putExtra("img_gallery_is_restransmit_after_download", true);
                            intent.putExtra("img_gallery_directly_send_name", str);
                            intent.putExtra("start_chatting_ui", false);
                            String str3 = c7620bi.field_talker;
                            Bundle bundle2 = new Bundle();
                            if (z) {
                                str2 = "stat_scene";
                                i2 = 2;
                                bundle = bundle2;
                            } else {
                                str2 = "stat_scene";
                                if (C1855t.m3913mZ(str3)) {
                                    i2 = 7;
                                    bundle = bundle2;
                                } else {
                                    i2 = 1;
                                    bundle = bundle2;
                                }
                            }
                            bundle.putInt(str2, i2);
                            bundle2.putString("stat_msg_id", "msg_" + Long.toString(c7620bi.field_msgSvrId));
                            bundle2.putString("stat_chat_talker_username", str3);
                            bundle2.putString("stat_send_msg_user", str);
                            intent.putExtra("_stat_obj", bundle2);
                            context.startActivity(intent);
                            AppMethodBeat.m2505o(31014);
                        } else {
                            int i3;
                            if (c7620bi.field_isSend == 1) {
                                if (fI.agQ()) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                i3 = i2;
                            } else if (!fI.agQ()) {
                                i3 = 0;
                            } else if (C5730e.m8628ct(C37478f.m63225a(fI).fDz)) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            String Yz = C1853r.m3846Yz();
                            String q = C32291o.ahl().mo73118q(C37478f.m63227c(fI), "", "");
                            if (!C5046bo.isNullOrNil(q)) {
                                C4990ab.m7417i("MicroMsg.LongClickBrandServiceHelper", "connector click[img]: to[%s] fileName[%s]", str, q);
                                C9638aw.m17182Rg().mo14541a(new C9022l(4, Yz, str, q, i3, null, 0, "", "", true, C25738R.drawable.b0p), 0);
                                C37907bv.aaq().mo60662c(C37907bv.fnv, null);
                            }
                            C7060h.pYm.mo8381e(10424, Integer.valueOf(3), Integer.valueOf(4), str);
                            C30379h.m48465bQ(context, context.getString(C25738R.string.f9219td));
                            AppMethodBeat.m2505o(31014);
                        }
                    }
                });
                AppMethodBeat.m2505o(31023);
                return;
            }
            C23639t.m36492hO(context);
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: sd card is not available");
            AppMethodBeat.m2505o(31023);
        }
    }

    /* renamed from: c */
    public static void m80031c(final C7620bi c7620bi, final Context context) {
        AppMethodBeat.m2504i(31024);
        if (context == null) {
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: context is null");
            AppMethodBeat.m2505o(31024);
        } else if (c7620bi == null) {
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: msg is null");
            AppMethodBeat.m2505o(31024);
        } else {
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                C44288am.m80028a(C44288am.m80034eW(C41747z.aeR().mo43727le(8)), context, new C5279d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.m2504i(31015);
                        String str = menuItem.getTitle();
                        C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
                        C4990ab.m7417i("MicroMsg.LongClickBrandServiceHelper", "connector click[video]: to[%s] imgPath[%s]", str, c7620bi.field_imgPath);
                        final C36349a c36349a = new C36349a();
                        Context context = context;
                        context.getResources().getString(C25738R.string.f9238tz);
                        C44275p b = C30379h.m48458b(context, context.getResources().getString(C25738R.string.f9222th), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                c36349a.zJA = true;
                            }
                        });
                        c36349a.context = context;
                        c36349a.fileName = c7620bi.field_imgPath;
                        c36349a.gII = b;
                        c36349a.userName = str;
                        c36349a.zIW = ut.fXh;
                        c36349a.fXd = ut.fXd;
                        c36349a.execute(new Object[0]);
                        C37907bv.aaq().mo60662c(C37907bv.fnw, null);
                        C30379h.m48465bQ(context, context.getString(C25738R.string.f9219td));
                        AppMethodBeat.m2505o(31015);
                    }
                });
                AppMethodBeat.m2505o(31024);
                return;
            }
            C23639t.m36492hO(context);
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: sd card is not available");
            AppMethodBeat.m2505o(31024);
        }
    }

    /* renamed from: n */
    public static void m80036n(final String str, final Context context) {
        AppMethodBeat.m2504i(31025);
        if (context == null) {
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: context is null");
            AppMethodBeat.m2505o(31025);
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: locationXML is null");
            AppMethodBeat.m2505o(31025);
        } else {
            C44288am.m80028a(C44288am.m80034eW(C41747z.aeR().mo43727le(16)), context, new C5279d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(31016);
                    C4990ab.m7417i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", menuItem.getTitle(), str);
                    C9638aw.m17182Rg().mo14541a(new C26451h(r0, str, 48), 0);
                    C7060h.pYm.mo8381e(10424, Integer.valueOf(48), Integer.valueOf(16), r0);
                    C30379h.m48465bQ(context, context.getString(C25738R.string.f9219td));
                    AppMethodBeat.m2505o(31016);
                }
            });
            AppMethodBeat.m2505o(31025);
        }
    }

    /* renamed from: o */
    public static void m80037o(final String str, final Context context) {
        AppMethodBeat.m2504i(31026);
        if (context == null) {
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: context is null");
            AppMethodBeat.m2505o(31026);
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: locationXML is null");
            AppMethodBeat.m2505o(31026);
        } else {
            C44288am.m80028a(C44288am.m80034eW(C41747z.aeR().mo43727le(32)), context, new C5279d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    int i2 = 66;
                    AppMethodBeat.m2504i(31017);
                    String str = menuItem.getTitle();
                    C4990ab.m7417i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", str, str);
                    C5135a apC = C5135a.apC(str);
                    C9638aw.m17182Rg().mo14541a(new C26451h(str, str, C7616ad.aox(apC.svN) ? 66 : 42), 0);
                    C7060h c7060h = C7060h.pYm;
                    Object[] objArr = new Object[3];
                    if (!C7616ad.aox(apC.svN)) {
                        i2 = 42;
                    }
                    objArr[0] = Integer.valueOf(i2);
                    objArr[1] = Integer.valueOf(32);
                    objArr[2] = str;
                    c7060h.mo8381e(10424, objArr);
                    C30379h.m48465bQ(context, context.getString(C25738R.string.f9219td));
                    AppMethodBeat.m2505o(31017);
                }
            });
            AppMethodBeat.m2505o(31026);
        }
    }

    /* renamed from: d */
    public static void m80033d(final C7620bi c7620bi, final Context context) {
        AppMethodBeat.m2504i(31027);
        if (context == null) {
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: context is null");
            AppMethodBeat.m2505o(31027);
        } else if (c7620bi == null) {
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: msg is null");
            AppMethodBeat.m2505o(31027);
        } else {
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                C44288am.m80028a(C44288am.m80034eW(C41747z.aeR().mo43727le(64)), context, new C5279d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        String str;
                        AppMethodBeat.m2504i(31018);
                        String str2 = menuItem.getTitle();
                        String str3 = C44218ap.aps(c7620bi.field_content).cvZ;
                        if (str3 == null || str3.endsWith("-1")) {
                            str = c7620bi.field_imgPath;
                        } else {
                            str = str3;
                        }
                        if (str == null) {
                            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: filePath is null");
                            AppMethodBeat.m2505o(31018);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.LongClickBrandServiceHelper", "connector click[emoji]: to[%s] filePath[%s]", str2, str);
                        if (((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35663r(context, str2, str)) {
                            C7060h.pYm.mo8381e(10424, Integer.valueOf(47), Integer.valueOf(64), str2);
                            C30379h.m48465bQ(context, "");
                        }
                        C7060h.pYm.mo8381e(10424, Integer.valueOf(47), Integer.valueOf(64), str2);
                        C30379h.m48465bQ(context, context.getString(C25738R.string.f9219td));
                        AppMethodBeat.m2505o(31018);
                    }
                });
                AppMethodBeat.m2505o(31027);
                return;
            }
            C23639t.m36492hO(context);
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: sd card is not available");
            AppMethodBeat.m2505o(31027);
        }
    }

    /* renamed from: a */
    public static void m80026a(C7620bi c7620bi, String str, Context context) {
        AppMethodBeat.m2504i(31028);
        C44288am.m80027a(c7620bi, str, context, 512);
        AppMethodBeat.m2505o(31028);
    }

    /* renamed from: b */
    public static void m80030b(C7620bi c7620bi, String str, Context context) {
        AppMethodBeat.m2504i(31029);
        C44288am.m80027a(c7620bi, str, context, 256);
        AppMethodBeat.m2505o(31029);
    }

    /* renamed from: c */
    public static void m80032c(C7620bi c7620bi, String str, Context context) {
        AppMethodBeat.m2504i(31030);
        C44288am.m80027a(c7620bi, str, context, 128);
        AppMethodBeat.m2505o(31030);
    }

    /* renamed from: a */
    private static void m80027a(final C7620bi c7620bi, final String str, final Context context, final int i) {
        AppMethodBeat.m2504i(31031);
        if (context == null) {
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: context is null");
            AppMethodBeat.m2505o(31031);
        } else if (c7620bi == null) {
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: msg is null");
            AppMethodBeat.m2505o(31031);
        } else {
            List list = null;
            switch (i) {
                case 128:
                    list = C44288am.m80034eW(C17903f.aeC());
                    break;
                case 256:
                    list = C44288am.m80034eW(C17903f.aeE());
                    break;
                case 512:
                    list = C44288am.m80034eW(C17903f.aeG());
                    break;
            }
            C44288am.m80028a(list, context, new C5279d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(31019);
                    String str = menuItem.getTitle();
                    C7620bi c7620bi = c7620bi;
                    C8910b me = C8910b.m16064me(C5046bo.anj(str));
                    if (me == null) {
                        C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "send: parse app msg content return null");
                    } else {
                        byte[] bArr = null;
                        if (!(c7620bi.field_imgPath == null || c7620bi.field_imgPath.equals(""))) {
                            try {
                                bArr = C5730e.m8632e(C32291o.ahl().mo73074I(c7620bi.field_imgPath, true), 0, -1);
                            } catch (Exception e) {
                                C4990ab.m7413e("MicroMsg.LongClickBrandServiceHelper", "send appmsg to %s, error:%s", str, e.getLocalizedMessage());
                            }
                        }
                        C30065b c30065b = new C30065b();
                        if (!C5046bo.isNullOrNil(me.csD)) {
                            long j = C5046bo.getLong(me.csD, -1);
                            if (j != -1) {
                                C14877am.aUq().mo16761b(j, (C4925c) c30065b);
                                if (c30065b.xDa != j) {
                                    c30065b = C14877am.aUq().aiE(me.csD);
                                    if (c30065b == null || !c30065b.field_mediaSvrId.equals(me.csD)) {
                                        c30065b = null;
                                    }
                                }
                            } else {
                                c30065b = C14877am.aUq().aiE(me.csD);
                                if (c30065b == null || !c30065b.field_mediaSvrId.equals(me.csD)) {
                                    c30065b = null;
                                }
                            }
                        }
                        String str2 = "";
                        if (!(c30065b == null || c30065b.field_fileFullPath == null || c30065b.field_fileFullPath.equals(""))) {
                            C9638aw.m17190ZK();
                            str2 = C4733l.m7083X(C18628c.m29096Ye(), me.title, me.fgp);
                            C5730e.m8644y(c30065b.field_fileFullPath, str2);
                        }
                        C8910b a = C8910b.m16060a(me);
                        a.fgr = 3;
                        C4733l.m7088a(a, me.appId, me.appName, str, str2, bArr, null);
                    }
                    switch (i) {
                        case 128:
                            C7060h.pYm.mo8381e(10424, Integer.valueOf(49), Integer.valueOf(128), str);
                            break;
                        case 256:
                            C7060h.pYm.mo8381e(10424, Integer.valueOf(49), Integer.valueOf(256), str);
                            break;
                        case 512:
                            C7060h.pYm.mo8381e(10424, Integer.valueOf(49), Integer.valueOf(512), str);
                            break;
                    }
                    C30379h.m48465bQ(context, context.getString(C25738R.string.f9219td));
                    AppMethodBeat.m2505o(31019);
                }
            });
            AppMethodBeat.m2505o(31031);
        }
    }

    /* renamed from: eW */
    private static List<String> m80034eW(List<String> list) {
        AppMethodBeat.m2504i(31032);
        LinkedList linkedList = new LinkedList();
        for (String str : list) {
            if (!C17903f.m28107ra(str)) {
                linkedList.add(str);
            }
        }
        C4990ab.m7411d("MicroMsg.LongClickBrandServiceHelper", "get selected accept list, size %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.m2505o(31032);
        return linkedList;
    }

    /* renamed from: a */
    private static void m80028a(final List<String> list, final Context context, C5279d c5279d) {
        AppMethodBeat.m2504i(31033);
        if (list == null || list.isEmpty()) {
            C4990ab.m7420w("MicroMsg.LongClickBrandServiceHelper", "tryShowConnectorDialog: careList is null or empty");
            AppMethodBeat.m2505o(31033);
            return;
        }
        C46696j c46696j = new C46696j(context);
        c46696j.zFT = new C4071011();
        c46696j.zFU = new C40670b() {
            /* renamed from: a */
            public final void mo5751a(TextView textView, MenuItem menuItem) {
                AppMethodBeat.m2504i(31011);
                if (textView != null) {
                    C9638aw.m17190ZK();
                    C7616ad aoO = C18628c.m29078XM().aoO(menuItem.getTitle());
                    if (aoO == null || ((int) aoO.ewQ) <= 0) {
                        textView.setText(menuItem.getTitle());
                        AppMethodBeat.m2505o(31011);
                        return;
                    }
                    textView.setText(C44089j.m79293b(context, aoO.mo16706Oi(), textView.getTextSize()));
                }
                AppMethodBeat.m2505o(31011);
            }
        };
        c46696j.rBl = new C36073c() {
            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(31012);
                for (CharSequence add : list) {
                    c44273l.add(add);
                }
                AppMethodBeat.m2505o(31012);
            }
        };
        c46696j.rBm = c5279d;
        c46696j.cuu();
        AppMethodBeat.m2505o(31033);
    }
}
