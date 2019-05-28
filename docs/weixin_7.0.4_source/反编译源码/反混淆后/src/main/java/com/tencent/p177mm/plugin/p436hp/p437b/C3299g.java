package com.tencent.p177mm.plugin.p436hp.p437b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.widget.Toast;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.boots.p348a.C20015c;
import com.tencent.p177mm.plugin.boots.p348a.C2678a;
import com.tencent.p177mm.plugin.p436hp.p1272a.C46026b;
import com.tencent.p177mm.plugin.p436hp.p1273d.C28317b;
import com.tencent.p177mm.plugin.p436hp.p1273d.C28318d;
import com.tencent.p177mm.plugin.p436hp.p1552c.C46030b;
import com.tencent.p177mm.plugin.p436hp.tinker.C21075g;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.protocal.protobuf.bhv;
import com.tencent.p177mm.protocal.protobuf.bhy;
import com.tencent.p177mm.protocal.protobuf.bia;
import com.tencent.p177mm.protocal.protobuf.bsz;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tinkerboots.sdk.C44598a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.hp.b.g */
public final class C3299g implements C44041a {

    /* renamed from: com.tencent.mm.plugin.hp.b.g$1 */
    class C33001 implements OnClickListener {
        C33001() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(90609);
            Toast.makeText(C4996ah.getContext(), "OK", 0).show();
            AppMethodBeat.m2505o(90609);
        }
    }

    /* renamed from: a */
    public final boolean mo7165a(Context context, final String[] strArr, String str) {
        AppMethodBeat.m2504i(90611);
        if (strArr.length < 2) {
            C4990ab.m7410d("MicroMsg.Tinker.TinkerBootsCommand", "no args input.");
            AppMethodBeat.m2505o(90611);
            return false;
        }
        Object obj;
        String str2 = strArr[1];
        if (C4872b.dnO()) {
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
                    C4990ab.m7410d("MicroMsg.Tinker.TinkerBootsCommand", "command checkout update.");
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
                    C4990ab.m7411d("MicroMsg.Tinker.TinkerBootsCommand", "BaseID:%s PatchID:%s %s", str2, str4, stringBuilder.toString());
                    C1720g.m3540Rg().mo14541a(new C46030b(str2, str4, linkedList), 0);
                    AppMethodBeat.m2505o(90611);
                    return true;
                case 1:
                    C46029i.m85611a(C4996ah.getContext().getString(C25738R.string.byv), C4996ah.getContext().getString(C25738R.string.byv), C4996ah.getContext().getString(C25738R.string.cdx), new C33001(), C4996ah.getContext().getString(C25738R.string.eyp), null);
                    AppMethodBeat.m2505o(90611);
                    return true;
                case 2:
                    C1720g.m3539RS().mo10302aa(new Runnable() {
                        public final void run() {
                            int i;
                            AppMethodBeat.m2504i(90610);
                            String str = C6457e.eSn + "/Download/2017-07-28_19-43-39.apk";
                            String str2 = C6457e.eSn + "/Download/39-50-diff.apk";
                            String str3 = C6457e.eSn + "/Download/new_50.apk";
                            String str4 = "ab099f75f740be5d88e178d662a36779";
                            if (strArr.length >= 3 && !C5046bo.isNullOrNil(strArr[2])) {
                                str = strArr[2];
                            }
                            if (strArr.length >= 4 && !C5046bo.isNullOrNil(strArr[3])) {
                                str2 = strArr[3];
                            }
                            if (strArr.length >= 5 && !C5046bo.isNullOrNil(strArr[4])) {
                                str3 = strArr[4];
                            }
                            if (strArr.length >= 6 && !C5046bo.isNullOrNil(strArr[5])) {
                                str4 = strArr[5];
                            }
                            if (C1173e.m2561ct(str3)) {
                                i = 0;
                            } else {
                                long currentTimeMillis = System.currentTimeMillis();
                                i = C46026b.m85592b(str, str2, str3, str4);
                                C4990ab.m7417i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk use :%d retCode：%d", Long.valueOf((System.currentTimeMillis() - currentTimeMillis) / 1000), Integer.valueOf(i));
                            }
                            if (i == 0) {
                                C4990ab.m7416i("MicroMsg.Tinker.TinkerBootsCommand", "show dialog for install");
                                C4990ab.m7417i("MicroMsg.Tinker.TinkerBootsCommand", "New Apk md5:%s", C1178g.m2587cz(str3));
                                C28318d.m44927aC(C4996ah.getContext(), str3);
                                C4990ab.m7416i("MicroMsg.Tinker.TinkerBootsCommand", "md5 is equal.");
                                AppMethodBeat.m2505o(90610);
                                return;
                            }
                            C4990ab.m7416i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk failed.");
                            AppMethodBeat.m2505o(90610);
                        }
                    });
                    AppMethodBeat.m2505o(90611);
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
                    new C3296e(new C28317b(bia)).mo7670if(false);
                    AppMethodBeat.m2505o(90611);
                    return true;
                case 4:
                    if (strArr.length >= 6) {
                        C5046bo.anl(strArr[5]);
                    }
                    AppMethodBeat.m2505o(90611);
                    return true;
                case 5:
                    C21075g.m32381aA(C4996ah.getContext(), "");
                    C21075g.m32382aB(C4996ah.getContext(), "");
                    C21075g.m32380P(C4996ah.getContext(), 0);
                    C4996ah.getContext();
                    C28318d.bGA();
                    AppMethodBeat.m2505o(90611);
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
                    new C3296e(new C28317b(bia)).mo7670if(true);
                    AppMethodBeat.m2505o(90611);
                    return true;
                case 7:
                    C3299g.bGm();
                    AppMethodBeat.m2505o(90611);
                    return true;
                default:
                    C4990ab.m7411d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a debugger command.", str2);
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
                    C44598a.dWj().mo71472rF(true);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Tinker.TinkerBootsCommand", e, "", new Object[0]);
                }
                AppMethodBeat.m2505o(90611);
                return true;
            default:
                C4990ab.m7411d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a release command.", str2);
                AppMethodBeat.m2505o(90611);
                return false;
        }
    }

    private static void bGm() {
        AppMethodBeat.m2504i(90612);
        List<C2678a> aVJ = ((C20015c) C1720g.m3528K(C20015c.class)).aVJ();
        if (!aVJ.isEmpty()) {
            C4990ab.m7412e("MicroMsg.Tinker.TinkerBootsCommand", "start day active keys");
            for (C2678a c2678a : aVJ) {
                C4990ab.m7417i("MicroMsg.Tinker.TinkerBootsCommand", "key:%s active:%d", Integer.toHexString(c2678a.field_key), Integer.valueOf(c2678a.field_dau));
            }
        }
        AppMethodBeat.m2505o(90612);
    }
}
