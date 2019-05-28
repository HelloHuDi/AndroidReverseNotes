package com.tencent.mm.ui.chatting;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.d.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class n {
    public static boolean a(a aVar, List<bi> list, ad adVar) {
        AppMethodBeat.i(30618);
        if (aVar == null) {
            ab.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, context is null");
            AppMethodBeat.o(30618);
            return false;
        } else if (list == null || list.isEmpty()) {
            ab.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, select item empty");
            AppMethodBeat.o(30618);
            return false;
        } else if (adVar == null || ((int) adVar.ewQ) <= 0) {
            ab.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, contact error");
            AppMethodBeat.o(30618);
            return false;
        } else {
            boolean b = b(aVar, list, adVar);
            AppMethodBeat.o(30618);
            return b;
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(final a aVar, List<bi> list, ad adVar) {
        String str;
        String format;
        AppMethodBeat.i(30619);
        if (t.kH(adVar.field_username)) {
            if (bo.isNullOrNil(adVar.field_nickname)) {
                String str2;
                str = "";
                Iterator it = com.tencent.mm.model.n.my(adVar.field_username).iterator();
                while (true) {
                    str2 = str;
                    if (!it.hasNext()) {
                        break;
                    }
                    str = str2 + s.mJ((String) it.next()) + ", ";
                }
                str = str2.substring(0, str2.length() - 2);
            } else {
                str = adVar.Oi();
            }
            format = String.format(aVar.yTx.getMMResources().getString(R.string.e3c), new Object[]{str});
        } else {
            str = aVar.yTx.getMMResources().getString(R.string.e3b);
            Object[] objArr = new Object[2];
            objArr[0] = adVar.Oi();
            aw.ZK();
            objArr[1] = c.Ry().get(4, null);
            format = String.format(str, objArr);
        }
        h.pYm.e(10811, Integer.valueOf(7), Integer.valueOf(list.size()));
        if ((r.YK() & 1) == 0) {
            ab.d("MicroMsg.ChattingEditModeSendToMail", "use qq mail plugin to send mail");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (bi biVar : list) {
                if (biVar.bws()) {
                    o.all();
                    arrayList.add(com.tencent.mm.modelvideo.t.uh(biVar.field_imgPath));
                    arrayList2.add(null);
                } else if (biVar.bAA()) {
                    b me = b.me(biVar.field_content);
                    if (me != null) {
                        switch (me.type) {
                            case 4:
                            case 6:
                                com.tencent.mm.pluginsdk.model.app.b aiE = am.aUq().aiE(me.csD);
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
                ab.i("MicroMsg.ChattingEditModeSendToMail", "file path = " + arrayList + "file name = " + arrayList2);
            }
            str = new QQMailHistoryExporter(aVar.yTx.getContext(), list, adVar).dCL();
            Intent intent = new Intent();
            intent.putExtra("mail_mode", 6);
            intent.putExtra("mail_content", str);
            intent.putExtra("subject", format);
            intent.putExtra("show_qqmail", true);
            intent.putStringArrayListExtra("mail_attach", arrayList);
            intent.putStringArrayListExtra("mail_attach_title", arrayList2);
            d.a(aVar.yTv, "qqmail", ".ui.ComposeUI", intent, 220, new d.a() {
                public final void onActivityResult(int i, int i2, Intent intent) {
                    AppMethodBeat.i(30617);
                    i iVar = (i) aVar.aF(i.class);
                    if (-1 == i2 && iVar != null && iVar.dDN()) {
                        iVar.dDL();
                    }
                    AppMethodBeat.o(30617);
                }
            });
            AppMethodBeat.o(30619);
            return false;
        }
        ArrayList arrayList3;
        ab.w("MicroMsg.ChattingEditModeSendToMail", "use order mail app to send mail");
        aj ajVar = new aj(aVar.yTx.getContext(), list, adVar);
        str = ajVar.dCL();
        Intent intent2 = new Intent("android.intent.action.SEND_MULTIPLE");
        intent2.setType("message/rfc822");
        intent2.putExtra("android.intent.extra.SUBJECT", format);
        intent2.putExtra("android.intent.extra.TEXT", str);
        String str3 = "android.intent.extra.STREAM";
        Context context = aVar.yTx.getContext();
        String str4 = "MicroMsg.OtherMailHistoryExporter";
        String str5 = "get image attach: history is null? %B, selectItems.size = %d";
        Object[] objArr2 = new Object[2];
        objArr2[0] = Boolean.valueOf(ajVar.mGM == null);
        objArr2[1] = Integer.valueOf(ajVar.yIP.size());
        ab.d(str4, str5, objArr2);
        if (ajVar.mGM != null) {
            arrayList3 = ajVar.yLW;
        } else {
            ab.w("MicroMsg.OtherMailHistoryExporter", "had not exported, do export first");
            ajVar.dCL();
            arrayList3 = ajVar.yLW;
        }
        intent2.putParcelableArrayListExtra(str3, k.d(context, arrayList3));
        try {
            aVar.yTx.startActivity(Intent.createChooser(intent2, aVar.yTx.getContext().getString(R.string.e3a)));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(aVar.yTx.getContext(), R.string.e3d, 0).show();
        }
        AppMethodBeat.o(30619);
        return true;
    }
}
