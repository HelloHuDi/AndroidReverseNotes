package com.tencent.p177mm.p612ui.conversation.p626a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p188an.C41753a;
import com.tencent.p177mm.p188an.C41753a.C1239a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.OutputStream;
import java.util.List;

/* renamed from: com.tencent.mm.ui.conversation.a.n */
public final class C17062n extends C14933b implements OnClickListener {

    /* renamed from: com.tencent.mm.ui.conversation.a.n$1 */
    static class C54801 implements DialogInterface.OnClickListener {
        C54801() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(34699);
            C4990ab.m7416i("MicroMsg.MsgDelayTipsBanner", "[oneliang]yes");
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            AppMethodBeat.m2505o(34699);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.a.n$2 */
    static class C158642 implements OnCancelListener {
        C158642() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(34700);
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            AppMethodBeat.m2505o(34700);
        }
    }

    public final int getLayoutId() {
        return 2130970023;
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(34701);
        C17062n.m26378ic((Context) this.vlu.get());
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SHOW_MSG_DELAY_BOOLEAN_SYNC, Boolean.FALSE);
        if (this.view != null) {
            this.view.setVisibility(8);
        }
        AppMethodBeat.m2505o(34701);
    }

    private static int dIZ() {
        AppMethodBeat.m2504i(34702);
        if (VERSION.SDK_INT < 23) {
            AppMethodBeat.m2505o(34702);
            return 1;
        }
        int i;
        PowerManager powerManager = (PowerManager) C4996ah.getContext().getSystemService("power");
        try {
            boolean isIgnoringBatteryOptimizations = powerManager.isIgnoringBatteryOptimizations(C4996ah.getContext().getPackageName());
            C4990ab.m7416i("MicroMsg.MsgDelayTipsBanner", "[oneliang]app is ignore:".concat(String.valueOf(isIgnoringBatteryOptimizations)));
            C4990ab.m7416i("MicroMsg.MsgDelayTipsBanner", "[oneliang]is device idle mode:" + powerManager.isDeviceIdleMode());
            if (isIgnoringBatteryOptimizations) {
                i = 3;
            } else {
                i = 2;
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MsgDelayTipsBanner", "[oneliang]ignoring battery optimizations check failure.use another way.");
            i = 3;
        }
        AppMethodBeat.m2505o(34702);
        return i;
    }

    private static int dJa() {
        AppMethodBeat.m2504i(34703);
        String str = Build.BRAND;
        if (str == null) {
            AppMethodBeat.m2505o(34703);
            return C25738R.string.g8b;
        } else if (str.toLowerCase().startsWith("samsung")) {
            AppMethodBeat.m2505o(34703);
            return C25738R.string.g8c;
        } else if (!str.toLowerCase().equalsIgnoreCase("huawei")) {
            AppMethodBeat.m2505o(34703);
            return C25738R.string.g8b;
        } else if (VERSION.SDK_INT == 21 || VERSION.SDK_INT == 22 || VERSION.SDK_INT == 23) {
            AppMethodBeat.m2505o(34703);
            return C25738R.string.g8_;
        } else if (VERSION.SDK_INT == 24) {
            AppMethodBeat.m2505o(34703);
            return C25738R.string.g8a;
        } else {
            AppMethodBeat.m2505o(34703);
            return C25738R.string.g8b;
        }
    }

    /* renamed from: ic */
    public static void m26378ic(Context context) {
        AppMethodBeat.m2504i(34704);
        if (context == null) {
            AppMethodBeat.m2505o(34704);
            return;
        }
        switch (C17062n.dIZ()) {
            case 1:
            case 3:
                int dJa = C17062n.dJa();
                if (dJa > 0) {
                    C30379h.m48438a(context, context.getString(dJa), "", new C54801());
                    AppMethodBeat.m2505o(34704);
                    return;
                }
                C4990ab.m7412e("MicroMsg.MsgDelayTipsBanner", "[oneliang]impossible......");
                AppMethodBeat.m2505o(34704);
                return;
            case 2:
                C4990ab.m7416i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to add ignore");
                Intent data = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS").setData(Uri.parse("package:" + C4996ah.getContext().getPackageName()));
                data.setFlags(268435456);
                context.startActivity(data);
                break;
        }
        AppMethodBeat.m2505o(34704);
    }

    /* renamed from: id */
    public static void m26379id(Context context) {
        AppMethodBeat.m2504i(34705);
        context.getString(C25738R.string.f9238tz);
        C44275p b = C30379h.m48458b(context, context.getString(C25738R.string.f9260un), true, new C158642());
        List<C1239a> afS = C41753a.afS();
        StringBuilder stringBuilder = new StringBuilder();
        if (afS != null) {
            for (C1239a c1239a : afS) {
                stringBuilder.append(c1239a.toString());
                C4990ab.m7416i("MicroMsg.MsgDelayTipsBanner", c1239a.toString());
            }
        }
        if (b != null) {
            b.dismiss();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        C9638aw.m17190ZK();
        String stringBuilder3 = stringBuilder2.append(C18628c.m29073XH()).append("/delayedMsg").toString();
        C5730e.m8643tf(stringBuilder3);
        C5728b c5728b = new C5728b(stringBuilder3, "data.txt");
        stringBuilder3 = stringBuilder.toString();
        if (!c5728b.exists()) {
            try {
                c5728b.createNewFile();
            } catch (Exception e) {
                C4990ab.m7416i("MicroMsg.MsgDelayTipsBanner", "create new file exception:" + e.getMessage());
            }
        }
        OutputStream outputStream = null;
        try {
            outputStream = C5730e.m8642r(c5728b);
            outputStream.write((stringBuilder3 + IOUtils.LINE_SEPARATOR_UNIX).getBytes("UTF-8"));
            outputStream.flush();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e2) {
                    C4990ab.m7416i("MicroMsg.MsgDelayTipsBanner", "close exception:" + e2.getMessage());
                }
            }
        } catch (Exception e22) {
            C4990ab.m7416i("MicroMsg.MsgDelayTipsBanner", "exception:" + e22.getMessage());
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e222) {
                    C4990ab.m7416i("MicroMsg.MsgDelayTipsBanner", "close exception:" + e222.getMessage());
                }
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e3) {
                    C4990ab.m7416i("MicroMsg.MsgDelayTipsBanner", "close exception:" + e3.getMessage());
                }
            }
            AppMethodBeat.m2505o(34705);
        }
        Toast.makeText(context, C5736j.m8649w(c5728b.dMD()), 1).show();
        String w = C5736j.m8649w(c5728b.dMD());
        C7620bi c7620bi = new C7620bi();
        c7620bi.mo14794ju("weixin");
        c7620bi.setContent(w);
        c7620bi.setType(1);
        c7620bi.mo14781hO(0);
        if (c7620bi.field_isSend == 1) {
            c7620bi.setStatus(4);
        } else {
            c7620bi.setStatus(3);
        }
        long currentTimeMillis = System.currentTimeMillis();
        c7620bi.mo14774eI(currentTimeMillis);
        c7620bi.mo14775eJ(currentTimeMillis);
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
        AppMethodBeat.m2505o(34705);
    }

    public final boolean aMN() {
        AppMethodBeat.m2504i(34706);
        C4990ab.m7416i("MicroMsg.MsgDelayTipsBanner", "refresh banner.");
        C1720g.m3537RQ();
        C4990ab.m7417i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to show banner:%s", Boolean.valueOf(C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_SHOW_MSG_DELAY_BOOLEAN_SYNC, false)));
        if (C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_SHOW_MSG_DELAY_BOOLEAN_SYNC, false)) {
            if (this.view != null) {
                this.view.setVisibility(0);
            }
        } else if (this.view != null) {
            this.view.setVisibility(8);
        }
        boolean aMN = super.aMN();
        AppMethodBeat.m2505o(34706);
        return aMN;
    }

    public final void destroy() {
    }
}
