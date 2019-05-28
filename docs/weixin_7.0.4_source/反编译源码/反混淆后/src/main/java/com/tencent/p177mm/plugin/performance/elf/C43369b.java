package com.tencent.p177mm.plugin.performance.elf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mmkv.MMKV;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.performance.elf.ElfCheckResponse.C286671;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.performance.elf.b */
public final class C43369b {
    public static boolean DEBUG = false;
    public static long pfL = 1200000;
    public static final C43369b pfQ = new C43369b();
    public static final C3591b pfR = new C3591b();
    public static final Runnable pfS = new C12805a();
    public static final C7306ak pfh = new C7306ak(Looper.getMainLooper());
    public boolean nDl = false;

    /* renamed from: com.tencent.mm.plugin.performance.elf.b$b */
    static final class C3591b extends BroadcastReceiver {
        private C3591b() {
        }

        /* synthetic */ C3591b(byte b) {
            this();
        }

        public final void onReceive(final Context context, Intent intent) {
            AppMethodBeat.m2504i(111070);
            if ("ACTION_ELF_CHECK_RESPONSE".equals(intent.getAction())) {
                ElfCheckResponse elfCheckResponse = (ElfCheckResponse) intent.getParcelableExtra("MicroMsg.ElfCheckResponse");
                if (elfCheckResponse == null) {
                    C4990ab.m7416i("MicroMsg.ProcessElf", "[onReceive] response is null!");
                    AppMethodBeat.m2505o(111070);
                    return;
                }
                boolean z;
                if (!elfCheckResponse.nDl) {
                    C43369b.pfh.removeCallbacksAndMessages(null);
                }
                C7306ak bZr = C43369b.pfh;
                if (elfCheckResponse.nDl && elfCheckResponse.pfo && elfCheckResponse.pfp) {
                    bZr.postDelayed(new C286671(context), elfCheckResponse.pfs);
                    z = true;
                } else {
                    C4990ab.m7421w("MicroMsg.ElfCheckResponse", "can't call process[%s]", elfCheckResponse.processName);
                    z = false;
                }
                C4990ab.m7417i("MicroMsg.ProcessElf", "[onReceive] %s, isEnable:%s, CHECK_TIME:%s", Boolean.valueOf(z), Boolean.valueOf(elfCheckResponse.nDl), Long.valueOf(C43369b.bZm()));
                AppMethodBeat.m2505o(111070);
                return;
            }
            if ("com.tencent.mm.MMDensityManager".equals(intent.getAction())) {
                C4990ab.m7416i("MicroMsg.ProcessElf", "restart mm for density!");
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(139148);
                        Intent intent = new Intent(context, ElfCallUpReceiver.class);
                        intent.setAction(ElfCallUpReceiver.class.getName());
                        context.sendBroadcast(intent);
                        AppMethodBeat.m2505o(139148);
                    }
                }, 500);
            }
            AppMethodBeat.m2505o(111070);
        }
    }

    /* renamed from: com.tencent.mm.plugin.performance.elf.b$a */
    static final class C12805a implements Runnable {
        private C12805a() {
        }

        /* synthetic */ C12805a(byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(111069);
            C4990ab.m7416i("MicroMsg.ProcessElf", "send check broadcast!");
            ElfCheckRequest elfCheckRequest = new ElfCheckRequest();
            elfCheckRequest.oJs = C43369b.bZm();
            Intent intent = new Intent("ACTION_ELF_CHECK");
            intent.putExtra("MicroMsg.ElfCheckRequest", elfCheckRequest);
            C4996ah.getContext().sendBroadcast(intent);
            C43369b.pfh.postDelayed(this, C43369b.bZm());
            AppMethodBeat.m2505o(111069);
        }
    }

    static {
        AppMethodBeat.m2504i(111072);
        AppMethodBeat.m2505o(111072);
    }

    /* renamed from: aP */
    public static boolean m77393aP(float f) {
        AppMethodBeat.m2504i(111071);
        String a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54613a(C11745a.clicfg_android_process_hard_info, "");
        if (TextUtils.isEmpty(a)) {
            C4990ab.m7416i("MicroMsg.ProcessElf", "[checkHardOpen] json is Empty! just pass!");
        } else {
            try {
                JSONArray jSONArray = new JSONObject(a).getJSONArray("hard-open");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("device-brand");
                    String string2 = jSONObject.getString("device-model");
                    int i2 = jSONObject.getInt("sdk-version");
                    String str = Build.BRAND + " " + Build.MODEL;
                    C4990ab.m7417i("MicroMsg.ProcessElf", "[checkHardOpen] name:%s model:%s version:%s | %s %s ", string, string2, Integer.valueOf(i2), str, Integer.valueOf(VERSION.SDK_INT));
                    if (i2 <= VERSION.SDK_INT && str.contains(string) && str.contains(string2)) {
                        AppMethodBeat.m2505o(111071);
                        return true;
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.ProcessElf", e, "", new Object[0]);
            }
        }
        boolean z = 10000.0f * f > ((float) new Random().nextInt(Downloads.MIN_WAIT_FOR_NETWORK));
        C4990ab.m7417i("MicroMsg.ProcessElf", "[checkHardOpen] rand:%s test:%s isEnable:%s", Float.valueOf(f), Integer.valueOf(new Random().nextInt(Downloads.MIN_WAIT_FOR_NETWORK)), Boolean.valueOf(z));
        MMKV.defaultMMKV().putBoolean("MicroMsg.ProcessElf", z);
        AppMethodBeat.m2505o(111071);
        return z;
    }

    public static long bZm() {
        return DEBUG ? 8000 : pfL;
    }
}
