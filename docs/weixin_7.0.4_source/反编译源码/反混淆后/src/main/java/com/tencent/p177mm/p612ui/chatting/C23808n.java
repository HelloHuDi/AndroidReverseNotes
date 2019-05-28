package com.tencent.p177mm.p612ui.chatting;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15613i;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.p842bp.C25985d.C25987a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.n */
public final class C23808n {
    /* renamed from: a */
    public static boolean m36640a(C46650a c46650a, List<C7620bi> list, C7616ad c7616ad) {
        AppMethodBeat.m2504i(30618);
        if (c46650a == null) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, context is null");
            AppMethodBeat.m2505o(30618);
            return false;
        } else if (list == null || list.isEmpty()) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, select item empty");
            AppMethodBeat.m2505o(30618);
            return false;
        } else if (c7616ad == null || ((int) c7616ad.ewQ) <= 0) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, contact error");
            AppMethodBeat.m2505o(30618);
            return false;
        } else {
            boolean b = C23808n.m36641b(c46650a, list, c7616ad);
            AppMethodBeat.m2505o(30618);
            return b;
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static boolean m36641b(final C46650a c46650a, List<C7620bi> list, C7616ad c7616ad) {
        String str;
        String format;
        AppMethodBeat.m2504i(30619);
        if (C1855t.m3896kH(c7616ad.field_username)) {
            if (C5046bo.isNullOrNil(c7616ad.field_nickname)) {
                String str2;
                str = "";
                Iterator it = C37921n.m64074my(c7616ad.field_username).iterator();
                while (true) {
                    str2 = str;
                    if (!it.hasNext()) {
                        break;
                    }
                    str = str2 + C1854s.m3866mJ((String) it.next()) + ", ";
                }
                str = str2.substring(0, str2.length() - 2);
            } else {
                str = c7616ad.mo16706Oi();
            }
            format = String.format(c46650a.yTx.getMMResources().getString(C25738R.string.e3c), new Object[]{str});
        } else {
            str = c46650a.yTx.getMMResources().getString(C25738R.string.e3b);
            Object[] objArr = new Object[2];
            objArr[0] = c7616ad.mo16706Oi();
            C9638aw.m17190ZK();
            objArr[1] = C18628c.m29072Ry().get(4, null);
            format = String.format(str, objArr);
        }
        C7060h.pYm.mo8381e(10811, Integer.valueOf(7), Integer.valueOf(list.size()));
        if ((C1853r.m3829YK() & 1) == 0) {
            C4990ab.m7410d("MicroMsg.ChattingEditModeSendToMail", "use qq mail plugin to send mail");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (C7620bi c7620bi : list) {
                if (c7620bi.bws()) {
                    C37961o.all();
                    arrayList.add(C9720t.m17303uh(c7620bi.field_imgPath));
                    arrayList2.add(null);
                } else if (c7620bi.bAA()) {
                    C8910b me = C8910b.m16064me(c7620bi.field_content);
                    if (me != null) {
                        switch (me.type) {
                            case 4:
                            case 6:
                                C30065b aiE = C14877am.aUq().aiE(me.csD);
                                if (aiE != null) {
                                    File file = new File(aiE.field_fileFullPath);
                                    if (file.exists()) {
                                        arrayList.add(file.getAbsolutePath());
                                        arrayList2.add(me.title);
                                    }
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                C4990ab.m7416i("MicroMsg.ChattingEditModeSendToMail", "file path = " + arrayList + "file name = " + arrayList2);
            }
            str = new QQMailHistoryExporter(c46650a.yTx.getContext(), list, c7616ad).dCL();
            Intent intent = new Intent();
            intent.putExtra("mail_mode", 6);
            intent.putExtra("mail_content", str);
            intent.putExtra("subject", format);
            intent.putExtra("show_qqmail", true);
            intent.putStringArrayListExtra("mail_attach", arrayList);
            intent.putStringArrayListExtra("mail_attach_title", arrayList2);
            C25985d.m41459a(c46650a.yTv, "qqmail", ".ui.ComposeUI", intent, 220, new C25987a() {
                public final void onActivityResult(int i, int i2, Intent intent) {
                    AppMethodBeat.m2504i(30617);
                    C15613i c15613i = (C15613i) c46650a.mo74857aF(C15613i.class);
                    if (-1 == i2 && c15613i != null && c15613i.dDN()) {
                        c15613i.dDL();
                    }
                    AppMethodBeat.m2505o(30617);
                }
            });
            AppMethodBeat.m2505o(30619);
            return false;
        }
        ArrayList arrayList3;
        C4990ab.m7420w("MicroMsg.ChattingEditModeSendToMail", "use order mail app to send mail");
        C23700aj c23700aj = new C23700aj(c46650a.yTx.getContext(), list, c7616ad);
        str = c23700aj.dCL();
        Intent intent2 = new Intent("android.intent.action.SEND_MULTIPLE");
        intent2.setType("message/rfc822");
        intent2.putExtra("android.intent.extra.SUBJECT", format);
        intent2.putExtra("android.intent.extra.TEXT", str);
        String str3 = "android.intent.extra.STREAM";
        Context context = c46650a.yTx.getContext();
        String str4 = "MicroMsg.OtherMailHistoryExporter";
        String str5 = "get image attach: history is null? %B, selectItems.size = %d";
        Object[] objArr2 = new Object[2];
        objArr2[0] = Boolean.valueOf(c23700aj.mGM == null);
        objArr2[1] = Integer.valueOf(c23700aj.yIP.size());
        C4990ab.m7411d(str4, str5, objArr2);
        if (c23700aj.mGM != null) {
            arrayList3 = c23700aj.yLW;
        } else {
            C4990ab.m7420w("MicroMsg.OtherMailHistoryExporter", "had not exported, do export first");
            c23700aj.dCL();
            arrayList3 = c23700aj.yLW;
        }
        intent2.putParcelableArrayListExtra(str3, C15429k.m23715d(context, arrayList3));
        try {
            c46650a.yTx.startActivity(Intent.createChooser(intent2, c46650a.yTx.getContext().getString(C25738R.string.e3a)));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(c46650a.yTx.getContext(), C25738R.string.e3d, 0).show();
        }
        AppMethodBeat.m2505o(30619);
        return true;
    }
}
