package com.tencent.p177mm.plugin.performance.elf;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Debug;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.performance.elf.AbstractProcessChecker */
public abstract class AbstractProcessChecker extends BroadcastReceiver {
    private static HandlerThread pfg;
    boolean caA = true;
    C7306ak pfh;
    C46129a pfi = new C46129a(this, (byte) 0);
    private long pfj = -1;

    /* renamed from: com.tencent.mm.plugin.performance.elf.AbstractProcessChecker$2 */
    class C128042 implements Runnable {
        C128042() {
        }

        public final void run() {
            AppMethodBeat.m2504i(111041);
            C4996ah.doB().edit().putLong("MicroMsg.AbstractProcessChecker", System.currentTimeMillis() - AbstractProcessChecker.this.pfj).commit();
            AbstractProcessChecker.this.pfh.postDelayed(this, 600000);
            AppMethodBeat.m2505o(111041);
        }
    }

    /* renamed from: com.tencent.mm.plugin.performance.elf.AbstractProcessChecker$a */
    class C46129a implements ActivityLifecycleCallbacks {
        boolean isResume;
        String pfl;
        boolean pfm;

        private C46129a() {
            this.pfl = "";
            this.pfm = false;
            this.isResume = true;
        }

        /* synthetic */ C46129a(AbstractProcessChecker abstractProcessChecker, byte b) {
            this();
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            AppMethodBeat.m2504i(111042);
            if (activity.getClass().getSimpleName().endsWith("WeChatSplashActivity")) {
                this.pfm = true;
                C4990ab.m7416i(AbstractProcessChecker.this.getTag(), "WeChatSplashActivity was created!");
            }
            AppMethodBeat.m2505o(111042);
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
            AppMethodBeat.m2504i(111043);
            this.pfl = activity.getClass().getName();
            this.isResume = true;
            AppMethodBeat.m2505o(111043);
        }

        public final void onActivityPaused(Activity activity) {
            AppMethodBeat.m2504i(111044);
            if (C5046bo.isNullOrNil(this.pfl)) {
                this.pfl = activity.getClass().getName();
            }
            AppMethodBeat.m2505o(111044);
        }

        public final void onActivityStopped(Activity activity) {
            AppMethodBeat.m2504i(111045);
            if (C5046bo.isNullOrNil(this.pfl)) {
                this.pfl = activity.getClass().getName();
            }
            this.isResume = false;
            AppMethodBeat.m2505o(111045);
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }
    }

    /* renamed from: Q */
    public abstract boolean mo62432Q(long j, long j2);

    public abstract void awE();

    public abstract long bZm();

    public abstract boolean isEnable();

    /* Access modifiers changed, original: protected */
    public String getTag() {
        return "AbstractProcessChecker";
    }

    public static String getProcessName() {
        return C4996ah.getProcessName();
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: eU */
    public void mo62436eU(int i, int i2) {
    }

    /* Access modifiers changed, original: protected */
    public boolean bZj() {
        return true;
    }

    public AbstractProcessChecker() {
        HandlerThread anM = C7305d.anM("ProcessChecker");
        pfg = anM;
        anM.start();
        this.pfh = new C7306ak(pfg.getLooper());
        if (!C7243d.vxp) {
            long j = C4996ah.doB().getLong("MicroMsg.AbstractProcessChecker", 0);
            C4990ab.m7417i("MicroMsg.AbstractProcessChecker", "[updateProcessTime] last process durTime:%sms", Long.valueOf(j));
            if (j > 0) {
                int i;
                if (C4996ah.bqo()) {
                    i = (int) (j / 7200000);
                    if (i >= 36) {
                        C7053e.pXa.mo8378a(959, 46, 1, false);
                    } else {
                        C7053e.pXa.mo8378a(959, (long) (i + 10), 1, false);
                    }
                }
                i = (int) (j / 600000);
                C7053e.pXa.mo8381e(16338, C4996ah.getProcessName(), Integer.valueOf(i), Integer.valueOf(1));
            }
            if (this.pfj < 0) {
                this.pfj = System.currentTimeMillis();
                C4996ah.doB().edit().putLong("MicroMsg.AbstractProcessChecker", 0).commit();
            }
            this.pfh.postDelayed(new C128042(), 600000);
        }
        ((Application) C4996ah.getContext()).registerActivityLifecycleCallbacks(this.pfi);
        if (ElfCallUpReceiver.pfn > 0) {
            mo62436eU(Process.myPid(), ElfCallUpReceiver.pfn);
        } else {
            C4990ab.m7420w(getTag(), "not processElf call up!");
        }
    }

    /* Access modifiers changed, original: protected */
    public void start() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_ELF_CHECK");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        C4996ah.getContext().registerReceiver(this, intentFilter);
    }

    public final void onReceive(Context context, final Intent intent) {
        if (intent.getAction() == "ACTION_ELF_CHECK") {
            this.pfh.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(111040);
                    if ("ACTION_ELF_CHECK".equals(intent.getAction())) {
                        ElfCheckRequest elfCheckRequest = (ElfCheckRequest) intent.getParcelableExtra("MicroMsg.ElfCheckRequest");
                        if (elfCheckRequest == null) {
                            C4990ab.m7420w("MicroMsg.AbstractProcessChecker", "pass this check,because request is null! ????");
                            AppMethodBeat.m2505o(111040);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.AbstractProcessChecker", "[onReceive] begin to check process[%s] isCanKill:%s isNeedReCall:%s", AbstractProcessChecker.getProcessName(), Boolean.valueOf(AbstractProcessChecker.this.mo62432Q((long) Process.myPid(), elfCheckRequest.oJs)), Boolean.valueOf(AbstractProcessChecker.this.bZj()));
                        if (AbstractProcessChecker.this.mo62432Q((long) Process.myPid(), elfCheckRequest.oJs)) {
                            AbstractProcessChecker.this.bZk();
                            AppMethodBeat.m2505o(111040);
                            return;
                        }
                        AbstractProcessChecker.this.m86085jI(false);
                    }
                    AppMethodBeat.m2505o(111040);
                }
            });
        } else if (intent.getAction() == "android.intent.action.SCREEN_OFF") {
            awE();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bZk() {
        if (this.caA || this.pfi.isResume) {
            C4990ab.m7420w("MicroMsg.AbstractProcessChecker", "pass this kill! app is on foreground!");
            C7053e.pXa.mo8378a(959, 6, 1, true);
            m86085jI(false);
            return;
        }
        m86085jI(true);
        throw new RuntimeException(bZl());
    }

    /* renamed from: jI */
    private void m86085jI(boolean z) {
        ElfCheckResponse elfCheckResponse = new ElfCheckResponse(isEnable(), bZm(), z, bZj(), C4996ah.getProcessName(), ElfCallUpReceiver.class.getName());
        Bundle bundle = new Bundle();
        bundle.putInt("processId", Process.myPid());
        elfCheckResponse.f13699DA = bundle;
        Intent intent = new Intent("ACTION_ELF_CHECK_RESPONSE");
        intent.putExtra("MicroMsg.ElfCheckResponse", elfCheckResponse);
        C4996ah.getContext().sendBroadcast(intent);
    }

    /* renamed from: jJ */
    public void mo62438jJ(boolean z) {
        this.caA = z;
    }

    /* Access modifiers changed, original: protected */
    public String bZl() {
        return String.format("ProcessEfl found exception!kill process[%s] %s %s %s", new Object[]{Integer.valueOf(Process.myPid()), Long.valueOf(AbstractProcessChecker.m86086zJ()), Long.valueOf(Debug.getNativeHeapSize()), Long.valueOf(Runtime.getRuntime().totalMemory())});
    }

    /* renamed from: zJ */
    public static long m86086zJ() {
        Matcher matcher = Pattern.compile("\\d+").matcher(AbstractProcessChecker.bZn());
        if (matcher.find()) {
            return (long) C5046bo.ank(matcher.group());
        }
        return -1;
    }

    private static String bZn() {
        try {
            String[] split = AbstractProcessChecker.getStringFromFile(String.format("/proc/%s/status", new Object[]{Integer.valueOf(Process.myPid())})).trim().split(IOUtils.LINE_SEPARATOR_UNIX);
            for (String str : split) {
                if (str.startsWith("VmSize")) {
                    return str;
                }
            }
            return split[12];
        } catch (Exception e) {
            return "";
        }
    }

    protected static long bZo() {
        try {
            String stringFromFile = AbstractProcessChecker.getStringFromFile(String.format("/proc/%s/schedstat", new Object[]{Integer.valueOf(Process.myPid())}));
            if (stringFromFile == null) {
                return -1;
            }
            return C5046bo.anl(stringFromFile.replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "").split(" ")[2]);
        } catch (Exception e) {
            return -2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String convertStreamToString(InputStream inputStream) {
        Throwable th;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuilder.append(readLine).append(10);
                    } else {
                        bufferedReader.close();
                        return stringBuilder.toString();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String getStringFromFile(String str) {
        Throwable th;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                String convertStreamToString = AbstractProcessChecker.convertStreamToString(fileInputStream);
                fileInputStream.close();
                return convertStreamToString;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    /* renamed from: U */
    protected static int m86081U(Map<String, Integer> map) {
        ThreadGroup threadGroup = Looper.getMainLooper().getThread().getThreadGroup();
        Thread[] threadArr = new Thread[(threadGroup.activeCount() * 2)];
        int enumerate = threadGroup.enumerate(threadArr);
        int i = 0;
        int i2 = 0;
        while (i < enumerate) {
            int i3;
            String name = threadArr[i].getName();
            if (C5046bo.isNullOrNil(name)) {
                i3 = i2;
            } else {
                String replaceAll = name.replaceAll("-?[0-9]\\d*", "?");
                if (map.containsKey(replaceAll)) {
                    map.put(replaceAll, Integer.valueOf(((Integer) map.get(replaceAll)).intValue() + 1));
                } else {
                    map.put(replaceAll, Integer.valueOf(1));
                }
                i3 = i2 + 1;
            }
            i++;
            i2 = i3;
        }
        return i2;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bZp() {
        for (RunningServiceInfo runningServiceInfo : ((ActivityManager) C4996ah.getContext().getSystemService("activity")).getRunningServices(50)) {
            if (runningServiceInfo.foreground) {
                C4990ab.m7417i(getTag(), "foreground service:%s process:%s ", ((RunningServiceInfo) r3.next()).service, ((RunningServiceInfo) r3.next()).process);
                return true;
            }
        }
        return false;
    }
}
