package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.widget.Toast;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.hp.d.d;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.protocal.protobuf.bhv;
import com.tencent.mm.protocal.protobuf.bhy;
import com.tencent.mm.protocal.protobuf.bia;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements a {
    public final boolean a(Context context, final String[] strArr, String str) {
        AppMethodBeat.i(90611);
        if (strArr.length < 2) {
            ab.d("MicroMsg.Tinker.TinkerBootsCommand", "no args input.");
            AppMethodBeat.o(90611);
            return false;
        }
        Object obj;
        String str2 = strArr[1];
        if (b.dnO()) {
            obj = -1;
            switch (str2.hashCode()) {
                case -838846263:
                    if (str2.equals("update")) {
                        obj = null;
                        break;
                    }
                    break;
                case -309518737:
                    if (str2.equals("process")) {
                        obj = 6;
                        break;
                    }
                    break;
                case 3510:
                    if (str2.equals("nd")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 3083269:
                    if (str2.equals("diff")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 3089570:
                    if (str2.equals("down")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 3529469:
                    if (str2.equals("show")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 94746189:
                    if (str2.equals("clear")) {
                        obj = 5;
                        break;
                    }
                    break;
                case 2067292548:
                    if (str2.equals("showall")) {
                        obj = 7;
                        break;
                    }
                    break;
            }
            bia bia;
            bsz bsz;
            switch (obj) {
                case null:
                    bhv bhv;
                    ab.d("MicroMsg.Tinker.TinkerBootsCommand", "command checkout update.");
                    LinkedList linkedList = new LinkedList();
                    String str3 = "tinker_id_d1ddc930233f0ec33f573e365038b6d979b6ebde";
                    String str4 = "";
                    if (strArr.length >= 3) {
                        str2 = strArr[2];
                    } else {
                        str2 = str3;
                    }
                    if (strArr.length >= 4) {
                        str4 = strArr[3];
                    }
                    if (strArr.length >= 5) {
                        bhv = new bhv();
                        bhv.key = ServerProtocol.DIALOG_PARAM_SDK_VERSION;
                        bhv.value = strArr[4];
                        linkedList.add(bhv);
                    } else {
                        bhv = new bhv();
                        bhv.key = ServerProtocol.DIALOG_PARAM_SDK_VERSION;
                        bhv.value = String.valueOf(VERSION.SDK_INT);
                        linkedList.add(bhv);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        bhv = (bhv) it.next();
                        stringBuilder.append(bhv.key).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(bhv.value).append(IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    ab.d("MicroMsg.Tinker.TinkerBootsCommand", "BaseID:%s PatchID:%s %s", str2, str4, stringBuilder.toString());
                    com.tencent.mm.kernel.g.Rg().a(new com.tencent.mm.plugin.hp.c.b(str2, str4, linkedList), 0);
                    AppMethodBeat.o(90611);
                    return true;
                case 1:
                    i.a(ah.getContext().getString(R.string.byv), ah.getContext().getString(R.string.byv), ah.getContext().getString(R.string.cdx), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(90609);
                            Toast.makeText(ah.getContext(), "OK", 0).show();
                            AppMethodBeat.o(90609);
                        }
                    }, ah.getContext().getString(R.string.eyp), null);
                    AppMethodBeat.o(90611);
                    return true;
                case 2:
                    com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                        public final void run() {
                            int i;
                            AppMethodBeat.i(90610);
                            String str = e.eSn + "/Download/2017-07-28_19-43-39.apk";
                            String str2 = e.eSn + "/Download/39-50-diff.apk";
                            String str3 = e.eSn + "/Download/new_50.apk";
                            String str4 = "ab099f75f740be5d88e178d662a36779";
                            if (strArr.length >= 3 && !bo.isNullOrNil(strArr[2])) {
                                str = strArr[2];
                            }
                            if (strArr.length >= 4 && !bo.isNullOrNil(strArr[3])) {
                                str2 = strArr[3];
                            }
                            if (strArr.length >= 5 && !bo.isNullOrNil(strArr[4])) {
                                str3 = strArr[4];
                            }
                            if (strArr.length >= 6 && !bo.isNullOrNil(strArr[5])) {
                                str4 = strArr[5];
                            }
                            if (com.tencent.mm.a.e.ct(str3)) {
                                i = 0;
                            } else {
                                long currentTimeMillis = System.currentTimeMillis();
                                i = com.tencent.mm.plugin.hp.a.b.b(str, str2, str3, str4);
                                ab.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk use :%d retCode：%d", Long.valueOf((System.currentTimeMillis() - currentTimeMillis) / 1000), Integer.valueOf(i));
                            }
                            if (i == 0) {
                                ab.i("MicroMsg.Tinker.TinkerBootsCommand", "show dialog for install");
                                ab.i("MicroMsg.Tinker.TinkerBootsCommand", "New Apk md5:%s", com.tencent.mm.a.g.cz(str3));
                                d.aC(ah.getContext(), str3);
                                ab.i("MicroMsg.Tinker.TinkerBootsCommand", "md5 is equal.");
                                AppMethodBeat.o(90610);
                                return;
                            }
                            ab.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk failed.");
                            AppMethodBeat.o(90610);
                        }
                    });
                    AppMethodBeat.o(90611);
                    return true;
                case 3:
                    bia = new bia();
                    bia.wLn = 1000;
                    bia.wLk = 2;
                    bia.wLl = 2;
                    bia.state = 2;
                    bia.pdA = "android_tinker_id_123123131231231";
                    bsz = new bsz();
                    bsz.wdO = "c3282ad2467fad9561227bc9b5b6712c";
                    bsz.FileSize = 118617;
                    bsz.Url = "http://dldir1.qq.com/weixin/checkresupdate/0x2605136d.3144f5.0x26051334.bf52fb_1510754399.apk";
                    bia.wLk = 3;
                    bsz.wdO = "3ba62fdbd98df2bdf5da7d726010d867";
                    bsz.FileSize = 33338711;
                    bsz.Url = "http://dldir1.qq.com/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk";
                    bia.wLm = bsz;
                    new e(new com.tencent.mm.plugin.hp.d.b(bia)).m5if(false);
                    AppMethodBeat.o(90611);
                    return true;
                case 4:
                    if (strArr.length >= 6) {
                        bo.anl(strArr[5]);
                    }
                    AppMethodBeat.o(90611);
                    return true;
                case 5:
                    com.tencent.mm.plugin.hp.tinker.g.aA(ah.getContext(), "");
                    com.tencent.mm.plugin.hp.tinker.g.aB(ah.getContext(), "");
                    com.tencent.mm.plugin.hp.tinker.g.P(ah.getContext(), 0);
                    ah.getContext();
                    d.bGA();
                    AppMethodBeat.o(90611);
                    return true;
                case 6:
                    bia = new bia();
                    bia.wLn = 1000;
                    bia.wLk = 3;
                    bia.wLl = 2;
                    bia.state = 2;
                    bia.pdA = "android_tinker_id_123123131231231";
                    bsz = new bsz();
                    bsz.wdO = "3ba62fdbd98df2bdf5da7d726010d867";
                    bsz.FileSize = 33338711;
                    bsz.Url = "http://dldir1.qq.com/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk";
                    bia.wLm = bsz;
                    bhy bhy = new bhy();
                    bhy.key = "clientVersion";
                    bhy.value = "0x26060510";
                    bia.wLo.add(bhy);
                    bhy = new bhy();
                    bhy.key = "alphaTitle";
                    bhy.value = "叫你更新你就更新";
                    bia.wLo.add(bhy);
                    bhy = new bhy();
                    bhy.key = "alphaContent";
                    bhy.value = "这个包可以抢到的红包最大，抢红包速度最快。";
                    bia.wLo.add(bhy);
                    bhy = new bhy();
                    bhy.key = "alphaUrl";
                    bhy.value = "www.qq.com";
                    bia.wLo.add(bhy);
                    new e(new com.tencent.mm.plugin.hp.d.b(bia)).m5if(true);
                    AppMethodBeat.o(90611);
                    return true;
                case 7:
                    bGm();
                    AppMethodBeat.o(90611);
                    return true;
                default:
                    ab.d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a debugger command.", str2);
                    break;
            }
        }
        obj = -1;
        switch (str2.hashCode()) {
            case 94627080:
                if (str2.equals("check")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                try {
                    com.tinkerboots.sdk.a.dWj().rF(true);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.Tinker.TinkerBootsCommand", e, "", new Object[0]);
                }
                AppMethodBeat.o(90611);
                return true;
            default:
                ab.d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a release command.", str2);
                AppMethodBeat.o(90611);
                return false;
        }
    }

    private static void bGm() {
        AppMethodBeat.i(90612);
        List<com.tencent.mm.plugin.boots.a.a> aVJ = ((c) com.tencent.mm.kernel.g.K(c.class)).aVJ();
        if (!aVJ.isEmpty()) {
            ab.e("MicroMsg.Tinker.TinkerBootsCommand", "start day active keys");
            for (com.tencent.mm.plugin.boots.a.a aVar : aVJ) {
                ab.i("MicroMsg.Tinker.TinkerBootsCommand", "key:%s active:%d", Integer.toHexString(aVar.field_key), Integer.valueOf(aVar.field_dau));
            }
        }
        AppMethodBeat.o(90612);
    }
}
