package com.tencent.mm.ui.conversation.a;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.OutputStream;
import java.util.List;

public final class n extends b implements OnClickListener {
    public final int getLayoutId() {
        return R.layout.aba;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(34701);
        ic((Context) this.vlu.get());
        g.RQ();
        g.RP().Ry().set(a.USERINFO_SHOW_MSG_DELAY_BOOLEAN_SYNC, Boolean.FALSE);
        if (this.view != null) {
            this.view.setVisibility(8);
        }
        AppMethodBeat.o(34701);
    }

    private static int dIZ() {
        AppMethodBeat.i(34702);
        if (VERSION.SDK_INT < 23) {
            AppMethodBeat.o(34702);
            return 1;
        }
        int i;
        PowerManager powerManager = (PowerManager) ah.getContext().getSystemService("power");
        try {
            boolean isIgnoringBatteryOptimizations = powerManager.isIgnoringBatteryOptimizations(ah.getContext().getPackageName());
            ab.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]app is ignore:".concat(String.valueOf(isIgnoringBatteryOptimizations)));
            ab.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]is device idle mode:" + powerManager.isDeviceIdleMode());
            if (isIgnoringBatteryOptimizations) {
                i = 3;
            } else {
                i = 2;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.MsgDelayTipsBanner", "[oneliang]ignoring battery optimizations check failure.use another way.");
            i = 3;
        }
        AppMethodBeat.o(34702);
        return i;
    }

    private static int dJa() {
        AppMethodBeat.i(34703);
        String str = Build.BRAND;
        if (str == null) {
            AppMethodBeat.o(34703);
            return R.string.g8b;
        } else if (str.toLowerCase().startsWith("samsung")) {
            AppMethodBeat.o(34703);
            return R.string.g8c;
        } else if (!str.toLowerCase().equalsIgnoreCase("huawei")) {
            AppMethodBeat.o(34703);
            return R.string.g8b;
        } else if (VERSION.SDK_INT == 21 || VERSION.SDK_INT == 22 || VERSION.SDK_INT == 23) {
            AppMethodBeat.o(34703);
            return R.string.g8_;
        } else if (VERSION.SDK_INT == 24) {
            AppMethodBeat.o(34703);
            return R.string.g8a;
        } else {
            AppMethodBeat.o(34703);
            return R.string.g8b;
        }
    }

    public static void ic(Context context) {
        AppMethodBeat.i(34704);
        if (context == null) {
            AppMethodBeat.o(34704);
            return;
        }
        switch (dIZ()) {
            case 1:
            case 3:
                int dJa = dJa();
                if (dJa > 0) {
                    h.a(context, context.getString(dJa), "", new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(34699);
                            ab.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]yes");
                            if (dialogInterface != null) {
                                dialogInterface.dismiss();
                            }
                            AppMethodBeat.o(34699);
                        }
                    });
                    AppMethodBeat.o(34704);
                    return;
                }
                ab.e("MicroMsg.MsgDelayTipsBanner", "[oneliang]impossible......");
                AppMethodBeat.o(34704);
                return;
            case 2:
                ab.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to add ignore");
                Intent data = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS").setData(Uri.parse("package:" + ah.getContext().getPackageName()));
                data.setFlags(268435456);
                context.startActivity(data);
                break;
        }
        AppMethodBeat.o(34704);
    }

    public static void id(Context context) {
        AppMethodBeat.i(34705);
        context.getString(R.string.tz);
        p b = h.b(context, context.getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(34700);
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                AppMethodBeat.o(34700);
            }
        });
        List<com.tencent.mm.an.a.a> afS = com.tencent.mm.an.a.afS();
        StringBuilder stringBuilder = new StringBuilder();
        if (afS != null) {
            for (com.tencent.mm.an.a.a aVar : afS) {
                stringBuilder.append(aVar.toString());
                ab.i("MicroMsg.MsgDelayTipsBanner", aVar.toString());
            }
        }
        if (b != null) {
            b.dismiss();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        aw.ZK();
        String stringBuilder3 = stringBuilder2.append(c.XH()).append("/delayedMsg").toString();
        e.tf(stringBuilder3);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(stringBuilder3, "data.txt");
        stringBuilder3 = stringBuilder.toString();
        if (!bVar.exists()) {
            try {
                bVar.createNewFile();
            } catch (Exception e) {
                ab.i("MicroMsg.MsgDelayTipsBanner", "create new file exception:" + e.getMessage());
            }
        }
        OutputStream outputStream = null;
        try {
            outputStream = e.r(bVar);
            outputStream.write((stringBuilder3 + IOUtils.LINE_SEPARATOR_UNIX).getBytes("UTF-8"));
            outputStream.flush();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e2) {
                    ab.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + e2.getMessage());
                }
            }
        } catch (Exception e22) {
            ab.i("MicroMsg.MsgDelayTipsBanner", "exception:" + e22.getMessage());
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e222) {
                    ab.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + e222.getMessage());
                }
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e3) {
                    ab.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + e3.getMessage());
                }
            }
            AppMethodBeat.o(34705);
        }
        Toast.makeText(context, j.w(bVar.dMD()), 1).show();
        String w = j.w(bVar.dMD());
        bi biVar = new bi();
        biVar.ju("weixin");
        biVar.setContent(w);
        biVar.setType(1);
        biVar.hO(0);
        if (biVar.field_isSend == 1) {
            biVar.setStatus(4);
        } else {
            biVar.setStatus(3);
        }
        long currentTimeMillis = System.currentTimeMillis();
        biVar.eI(currentTimeMillis);
        biVar.eJ(currentTimeMillis);
        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Z(biVar);
        AppMethodBeat.o(34705);
    }

    public final boolean aMN() {
        AppMethodBeat.i(34706);
        ab.i("MicroMsg.MsgDelayTipsBanner", "refresh banner.");
        g.RQ();
        ab.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to show banner:%s", Boolean.valueOf(g.RP().Ry().getBoolean(a.USERINFO_SHOW_MSG_DELAY_BOOLEAN_SYNC, false)));
        if (g.RP().Ry().getBoolean(a.USERINFO_SHOW_MSG_DELAY_BOOLEAN_SYNC, false)) {
            if (this.view != null) {
                this.view.setVisibility(0);
            }
        } else if (this.view != null) {
            this.view.setVisibility(8);
        }
        boolean aMN = super.aMN();
        AppMethodBeat.o(34706);
        return aMN;
    }

    public final void destroy() {
    }
}
