package com.tencent.mm.plugin.priority.b;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;

public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    public static boolean pgk = false;

    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(54886);
        if (ab.getLogLevel() > 1) {
            AppMethodBeat.o(54886);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.o(54886);
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
                    ab.i("MicroMsg.Priority.PriorityCommand", "copydb");
                    g.RQ();
                    absolutePath = new File(g.RP().cachePath, "MicroMsgPriority.db").getAbsolutePath();
                    e.deleteFile("/sdcard/tencent/MicroMsg/Download/priority.db");
                    e.y(absolutePath, "/sdcard/tencent/MicroMsg/Download/priority.db");
                    break;
                case 1:
                    ab.i("MicroMsg.Priority.PriorityCommand", "deletedb");
                    g.RQ();
                    e.deleteFile(new File(g.RP().cachePath, "MicroMsgPriority.db").getAbsolutePath());
                    Process.killProcess(Process.myPid());
                    break;
                case 2:
                    ab.i("MicroMsg.Priority.PriorityCommand", "enabledebug %s", strArr[2]);
                    try {
                        pgk = strArr[2].equals("1");
                        break;
                    } catch (Exception e) {
                        pgk = false;
                        break;
                    }
                case 3:
                    if (strArr.length > 2 && t.kH(str)) {
                        double[] fC = ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgImgUsageStorage().fC(str, strArr[2]);
                        ab.i("MicroMsg.Priority.PriorityCommand", "printrate %s", String.format("%s\n%s\n DayClickRate: %.2f\nWeekClickRate: %.2f\nMonthClickRate: %.2f", new Object[]{strArr[2], ((b) g.K(b.class)).mJ(strArr[2]), Double.valueOf(fC[0]), Double.valueOf(fC[1]), Double.valueOf(fC[2])}));
                        E(context, absolutePath);
                        break;
                    }
                    double[] dArr;
                    StringBuffer stringBuffer = new StringBuffer();
                    if (t.kH(str)) {
                        double[] fC2 = ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgImgUsageStorage().fC(str, "@all");
                        for (aul aul : ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgImgUsageStorage().UH(str)) {
                            stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
                            stringBuffer.append(((b) g.K(b.class)).mJ(aul.wyw));
                            stringBuffer.append("[");
                            stringBuffer.append(aul.wyw);
                            stringBuffer.append("][");
                            stringBuffer.append(h.formatTime("yyyy-MM-dd", aul.wyx / 1000));
                            stringBuffer.append("]");
                            stringBuffer.append(String.format("%.2f %.2f %.2f %d", new Object[]{Float.valueOf(aul.wyE), Float.valueOf(aul.wyF), Float.valueOf(aul.wyG), Integer.valueOf(aul.wyC)}));
                        }
                        dArr = fC2;
                    } else {
                        dArr = ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgImgUsageStorage().fC(str, str);
                    }
                    ab.i("MicroMsg.Priority.PriorityCommand", "printrate %s", String.format("DayClickRate: %.2f\nWeekClickRate: %.2f\nMonthClickRate: %.2f%s", new Object[]{Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Double.valueOf(dArr[2]), stringBuffer.toString()}));
                    E(context, absolutePath);
                    break;
                    break;
                case 4:
                    try {
                        ab.i("MicroMsg.Priority.PriorityCommand", "currentCount %d", Long.valueOf(Long.valueOf(strArr[2]).longValue()));
                        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, Long.valueOf(r0));
                        break;
                    } catch (Exception e2) {
                        break;
                    }
            }
            AppMethodBeat.o(54886);
            return true;
        }
    }

    private static void E(Context context, String str) {
        AppMethodBeat.i(54887);
        View textView = new TextView(context);
        textView.setText(str);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16711936);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.l5);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        com.tencent.mm.ui.base.h.a(context, null, textView, null);
        AppMethodBeat.o(54887);
    }
}
