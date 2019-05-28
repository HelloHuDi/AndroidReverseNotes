package com.tencent.p177mm.plugin.priority.p1284b;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.plugin.priority.PluginPriority;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.protocal.protobuf.aul;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.priority.b.a */
public final class C46130a implements C44041a {
    public static boolean pgk = false;

    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        AppMethodBeat.m2504i(54886);
        if (C4990ab.getLogLevel() > 1) {
            AppMethodBeat.m2505o(54886);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.m2505o(54886);
            return true;
        } else {
            String str2 = strArr[1];
            Object obj = -1;
            switch (str2.hashCode()) {
                case -1796087539:
                    if (str2.equals("printrate")) {
                        obj = 3;
                        break;
                    }
                    break;
                case -1424659792:
                    if (str2.equals("enabledebug")) {
                        obj = 2;
                        break;
                    }
                    break;
                case -1354714445:
                    if (str2.equals("copydb")) {
                        obj = null;
                        break;
                    }
                    break;
                case 66125101:
                    if (str2.equals("outlimit")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 819712873:
                    if (str2.equals("deletedb")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            String absolutePath;
            switch (obj) {
                case null:
                    C4990ab.m7416i("MicroMsg.Priority.PriorityCommand", "copydb");
                    C1720g.m3537RQ();
                    absolutePath = new File(C1720g.m3536RP().cachePath, "MicroMsgPriority.db").getAbsolutePath();
                    C5730e.deleteFile("/sdcard/tencent/MicroMsg/Download/priority.db");
                    C5730e.m8644y(absolutePath, "/sdcard/tencent/MicroMsg/Download/priority.db");
                    break;
                case 1:
                    C4990ab.m7416i("MicroMsg.Priority.PriorityCommand", "deletedb");
                    C1720g.m3537RQ();
                    C5730e.deleteFile(new File(C1720g.m3536RP().cachePath, "MicroMsgPriority.db").getAbsolutePath());
                    Process.killProcess(Process.myPid());
                    break;
                case 2:
                    C4990ab.m7417i("MicroMsg.Priority.PriorityCommand", "enabledebug %s", strArr[2]);
                    try {
                        pgk = strArr[2].equals("1");
                        break;
                    } catch (Exception e) {
                        pgk = false;
                        break;
                    }
                case 3:
                    if (strArr.length > 2 && C1855t.m3896kH(str)) {
                        double[] fC = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgImgUsageStorage().mo36901fC(str, strArr[2]);
                        C4990ab.m7417i("MicroMsg.Priority.PriorityCommand", "printrate %s", String.format("%s\n%s\n DayClickRate: %.2f\nWeekClickRate: %.2f\nMonthClickRate: %.2f", new Object[]{strArr[2], ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(strArr[2]), Double.valueOf(fC[0]), Double.valueOf(fC[1]), Double.valueOf(fC[2])}));
                        C46130a.m86090E(context, absolutePath);
                        break;
                    }
                    double[] dArr;
                    StringBuffer stringBuffer = new StringBuffer();
                    if (C1855t.m3896kH(str)) {
                        double[] fC2 = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgImgUsageStorage().mo36901fC(str, "@all");
                        for (aul aul : ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgImgUsageStorage().mo36898UH(str)) {
                            stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
                            stringBuffer.append(((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(aul.wyw));
                            stringBuffer.append("[");
                            stringBuffer.append(aul.wyw);
                            stringBuffer.append("][");
                            stringBuffer.append(C14835h.formatTime("yyyy-MM-dd", aul.wyx / 1000));
                            stringBuffer.append("]");
                            stringBuffer.append(String.format("%.2f %.2f %.2f %d", new Object[]{Float.valueOf(aul.wyE), Float.valueOf(aul.wyF), Float.valueOf(aul.wyG), Integer.valueOf(aul.wyC)}));
                        }
                        dArr = fC2;
                    } else {
                        dArr = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgImgUsageStorage().mo36901fC(str, str);
                    }
                    C4990ab.m7417i("MicroMsg.Priority.PriorityCommand", "printrate %s", String.format("DayClickRate: %.2f\nWeekClickRate: %.2f\nMonthClickRate: %.2f%s", new Object[]{Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Double.valueOf(dArr[2]), stringBuffer.toString()}));
                    C46130a.m86090E(context, absolutePath);
                    break;
                    break;
                case 4:
                    try {
                        C4990ab.m7417i("MicroMsg.Priority.PriorityCommand", "currentCount %d", Long.valueOf(Long.valueOf(strArr[2]).longValue()));
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, Long.valueOf(r0));
                        break;
                    } catch (Exception e2) {
                        break;
                    }
            }
            AppMethodBeat.m2505o(54886);
            return true;
        }
    }

    /* renamed from: E */
    private static void m86090E(Context context, String str) {
        AppMethodBeat.m2504i(54887);
        View textView = new TextView(context);
        textView.setText(str);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16711936);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        C30379h.m48435a(context, null, textView, null);
        AppMethodBeat.m2505o(54887);
    }
}
