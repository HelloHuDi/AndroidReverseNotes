package com.tencent.mm.plugin.performance.elf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mmkv.MMKV;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    public static boolean DEBUG = false;
    public static long pfL = 1200000;
    public static final b pfQ = new b();
    public static final b pfR = new b();
    public static final Runnable pfS = new a();
    public static final ak pfh = new ak(Looper.getMainLooper());
    public boolean nDl = false;

    static final class b extends BroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void onReceive(final Context context, Intent intent) {
            AppMethodBeat.i(111070);
            if ("ACTION_ELF_CHECK_RESPONSE".equals(intent.getAction())) {
                ElfCheckResponse elfCheckResponse = (ElfCheckResponse) intent.getParcelableExtra("MicroMsg.ElfCheckResponse");
                if (elfCheckResponse == null) {
                    ab.i("MicroMsg.ProcessElf", "[onReceive] response is null!");
                    AppMethodBeat.o(111070);
                    return;
                }
                boolean z;
                if (!elfCheckResponse.nDl) {
                    b.pfh.removeCallbacksAndMessages(null);
                }
                ak bZr = b.pfh;
                if (elfCheckResponse.nDl && elfCheckResponse.pfo && elfCheckResponse.pfp) {
                    bZr.postDelayed(new com.tencent.mm.plugin.performance.elf.ElfCheckResponse.AnonymousClass1(context), elfCheckResponse.pfs);
                    z = true;
                } else {
                    ab.w("MicroMsg.ElfCheckResponse", "can't call process[%s]", elfCheckResponse.processName);
                    z = false;
                }
                ab.i("MicroMsg.ProcessElf", "[onReceive] %s, isEnable:%s, CHECK_TIME:%s", Boolean.valueOf(z), Boolean.valueOf(elfCheckResponse.nDl), Long.valueOf(b.bZm()));
                AppMethodBeat.o(111070);
                return;
            }
            if ("com.tencent.mm.MMDensityManager".equals(intent.getAction())) {
                ab.i("MicroMsg.ProcessElf", "restart mm for density!");
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(139148);
                        Intent intent = new Intent(context, ElfCallUpReceiver.class);
                        intent.setAction(ElfCallUpReceiver.class.getName());
                        context.sendBroadcast(intent);
                        AppMethodBeat.o(139148);
                    }
                }, 500);
            }
            AppMethodBeat.o(111070);
        }
    }

    static final class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(111069);
            ab.i("MicroMsg.ProcessElf", "send check broadcast!");
            ElfCheckRequest elfCheckRequest = new ElfCheckRequest();
            elfCheckRequest.oJs = b.bZm();
            Intent intent = new Intent("ACTION_ELF_CHECK");
            intent.putExtra("MicroMsg.ElfCheckRequest", elfCheckRequest);
            ah.getContext().sendBroadcast(intent);
            b.pfh.postDelayed(this, b.bZm());
            AppMethodBeat.o(111069);
        }
    }

    static {
        AppMethodBeat.i(111072);
        AppMethodBeat.o(111072);
    }

    public static boolean aP(float f) {
        AppMethodBeat.i(111071);
        String a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_android_process_hard_info, "");
        if (TextUtils.isEmpty(a)) {
            ab.i("MicroMsg.ProcessElf", "[checkHardOpen] json is Empty! just pass!");
        } else {
            try {
                JSONArray jSONArray = new JSONObject(a).getJSONArray("hard-open");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("device-brand");
                    String string2 = jSONObject.getString("device-model");
                    int i2 = jSONObject.getInt("sdk-version");
                    String str = Build.BRAND + " " + Build.MODEL;
                    ab.i("MicroMsg.ProcessElf", "[checkHardOpen] name:%s model:%s version:%s | %s %s ", string, string2, Integer.valueOf(i2), str, Integer.valueOf(VERSION.SDK_INT));
                    if (i2 <= VERSION.SDK_INT && str.contains(string) && str.contains(string2)) {
                        AppMethodBeat.o(111071);
                        return true;
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.ProcessElf", e, "", new Object[0]);
            }
        }
        boolean z = 10000.0f * f > ((float) new Random().nextInt(Downloads.MIN_WAIT_FOR_NETWORK));
        ab.i("MicroMsg.ProcessElf", "[checkHardOpen] rand:%s test:%s isEnable:%s", Float.valueOf(f), Integer.valueOf(new Random().nextInt(Downloads.MIN_WAIT_FOR_NETWORK)), Boolean.valueOf(z));
        MMKV.defaultMMKV().putBoolean("MicroMsg.ProcessElf", z);
        AppMethodBeat.o(111071);
        return z;
    }

    public static long bZm() {
        return DEBUG ? 8000 : pfL;
    }
}
