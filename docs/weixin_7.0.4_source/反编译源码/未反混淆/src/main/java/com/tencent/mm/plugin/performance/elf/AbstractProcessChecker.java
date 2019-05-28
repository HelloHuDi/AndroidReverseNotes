package com.tencent.mm.plugin.performance.elf;

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
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractProcessChecker extends BroadcastReceiver {
    private static HandlerThread pfg;
    boolean caA = true;
    ak pfh;
    a pfi = new a(this, (byte) 0);
    private long pfj = -1;

    class a implements ActivityLifecycleCallbacks {
        boolean isResume;
        String pfl;
        boolean pfm;

        private a() {
            this.pfl = "";
            this.pfm = false;
            this.isResume = true;
        }

        /* synthetic */ a(AbstractProcessChecker abstractProcessChecker, byte b) {
            this();
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            AppMethodBeat.i(111042);
            if (activity.getClass().getSimpleName().endsWith("WeChatSplashActivity")) {
                this.pfm = true;
                ab.i(AbstractProcessChecker.this.getTag(), "WeChatSplashActivity was created!");
            }
            AppMethodBeat.o(111042);
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
            AppMethodBeat.i(111043);
            this.pfl = activity.getClass().getName();
            this.isResume = true;
            AppMethodBeat.o(111043);
        }

        public final void onActivityPaused(Activity activity) {
            AppMethodBeat.i(111044);
            if (bo.isNullOrNil(this.pfl)) {
                this.pfl = activity.getClass().getName();
            }
            AppMethodBeat.o(111044);
        }

        public final void onActivityStopped(Activity activity) {
            AppMethodBeat.i(111045);
            if (bo.isNullOrNil(this.pfl)) {
                this.pfl = activity.getClass().getName();
            }
            this.isResume = false;
            AppMethodBeat.o(111045);
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }
    }

    public abstract boolean Q(long j, long j2);

    public abstract void awE();

    public abstract long bZm();

    public abstract boolean isEnable();

    /* Access modifiers changed, original: protected */
    public String getTag() {
        return "AbstractProcessChecker";
    }

    public static String getProcessName() {
        return ah.getProcessName();
    }

    /* Access modifiers changed, original: protected */
    public void eU(int i, int i2) {
    }

    /* Access modifiers changed, original: protected */
    public boolean bZj() {
        return true;
    }

    public AbstractProcessChecker() {
        HandlerThread anM = d.anM("ProcessChecker");
        pfg = anM;
        anM.start();
        this.pfh = new ak(pfg.getLooper());
        if (!com.tencent.mm.protocal.d.vxp) {
            long j = ah.doB().getLong("MicroMsg.AbstractProcessChecker", 0);
            ab.i("MicroMsg.AbstractProcessChecker", "[updateProcessTime] last process durTime:%sms", Long.valueOf(j));
            if (j > 0) {
                int i;
                if (ah.bqo()) {
                    i = (int) (j / 7200000);
                    if (i >= 36) {
                        e.pXa.a(959, 46, 1, false);
                    } else {
                        e.pXa.a(959, (long) (i + 10), 1, false);
                    }
                }
                i = (int) (j / 600000);
                e.pXa.e(16338, ah.getProcessName(), Integer.valueOf(i), Integer.valueOf(1));
            }
            if (this.pfj < 0) {
                this.pfj = System.currentTimeMillis();
                ah.doB().edit().putLong("MicroMsg.AbstractProcessChecker", 0).commit();
            }
            this.pfh.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(111041);
                    ah.doB().edit().putLong("MicroMsg.AbstractProcessChecker", System.currentTimeMillis() - AbstractProcessChecker.this.pfj).commit();
                    AbstractProcessChecker.this.pfh.postDelayed(this, 600000);
                    AppMethodBeat.o(111041);
                }
            }, 600000);
        }
        ((Application) ah.getContext()).registerActivityLifecycleCallbacks(this.pfi);
        if (ElfCallUpReceiver.pfn > 0) {
            eU(Process.myPid(), ElfCallUpReceiver.pfn);
        } else {
            ab.w(getTag(), "not processElf call up!");
        }
    }

    /* Access modifiers changed, original: protected */
    public void start() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_ELF_CHECK");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        ah.getContext().registerReceiver(this, intentFilter);
    }

    public final void onReceive(Context context, final Intent intent) {
        if (intent.getAction() == "ACTION_ELF_CHECK") {
            this.pfh.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(111040);
                    if ("ACTION_ELF_CHECK".equals(intent.getAction())) {
                        ElfCheckRequest elfCheckRequest = (ElfCheckRequest) intent.getParcelableExtra("MicroMsg.ElfCheckRequest");
                        if (elfCheckRequest == null) {
                            ab.w("MicroMsg.AbstractProcessChecker", "pass this check,because request is null! ????");
                            AppMethodBeat.o(111040);
                            return;
                        }
                        ab.i("MicroMsg.AbstractProcessChecker", "[onReceive] begin to check process[%s] isCanKill:%s isNeedReCall:%s", AbstractProcessChecker.getProcessName(), Boolean.valueOf(AbstractProcessChecker.this.Q((long) Process.myPid(), elfCheckRequest.oJs)), Boolean.valueOf(AbstractProcessChecker.this.bZj()));
                        if (AbstractProcessChecker.this.Q((long) Process.myPid(), elfCheckRequest.oJs)) {
                            AbstractProcessChecker.this.bZk();
                            AppMethodBeat.o(111040);
                            return;
                        }
                        AbstractProcessChecker.this.jI(false);
                    }
                    AppMethodBeat.o(111040);
                }
            });
        } else if (intent.getAction() == "android.intent.action.SCREEN_OFF") {
            awE();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bZk() {
        if (this.caA || this.pfi.isResume) {
            ab.w("MicroMsg.AbstractProcessChecker", "pass this kill! app is on foreground!");
            e.pXa.a(959, 6, 1, true);
            jI(false);
            return;
        }
        jI(true);
        throw new RuntimeException(bZl());
    }

    private void jI(boolean z) {
        ElfCheckResponse elfCheckResponse = new ElfCheckResponse(isEnable(), bZm(), z, bZj(), ah.getProcessName(), ElfCallUpReceiver.class.getName());
        Bundle bundle = new Bundle();
        bundle.putInt("processId", Process.myPid());
        elfCheckResponse.DA = bundle;
        Intent intent = new Intent("ACTION_ELF_CHECK_RESPONSE");
        intent.putExtra("MicroMsg.ElfCheckResponse", elfCheckResponse);
        ah.getContext().sendBroadcast(intent);
    }

    public void jJ(boolean z) {
        this.caA = z;
    }

    /* Access modifiers changed, original: protected */
    public String bZl() {
        return String.format("ProcessEfl found exception!kill process[%s] %s %s %s", new Object[]{Integer.valueOf(Process.myPid()), Long.valueOf(zJ()), Long.valueOf(Debug.getNativeHeapSize()), Long.valueOf(Runtime.getRuntime().totalMemory())});
    }

    public static long zJ() {
        Matcher matcher = Pattern.compile("\\d+").matcher(bZn());
        if (matcher.find()) {
            return (long) bo.ank(matcher.group());
        }
        return -1;
    }

    private static String bZn() {
        try {
            String[] split = getStringFromFile(String.format("/proc/%s/status", new Object[]{Integer.valueOf(Process.myPid())})).trim().split(IOUtils.LINE_SEPARATOR_UNIX);
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
            String stringFromFile = getStringFromFile(String.format("/proc/%s/schedstat", new Object[]{Integer.valueOf(Process.myPid())}));
            if (stringFromFile == null) {
                return -1;
            }
            return bo.anl(stringFromFile.replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "").split(" ")[2]);
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
                String convertStreamToString = convertStreamToString(fileInputStream);
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

    protected static int U(Map<String, Integer> map) {
        ThreadGroup threadGroup = Looper.getMainLooper().getThread().getThreadGroup();
        Thread[] threadArr = new Thread[(threadGroup.activeCount() * 2)];
        int enumerate = threadGroup.enumerate(threadArr);
        int i = 0;
        int i2 = 0;
        while (i < enumerate) {
            int i3;
            String name = threadArr[i].getName();
            if (bo.isNullOrNil(name)) {
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
        for (RunningServiceInfo runningServiceInfo : ((ActivityManager) ah.getContext().getSystemService("activity")).getRunningServices(50)) {
            if (runningServiceInfo.foreground) {
                ab.i(getTag(), "foreground service:%s process:%s ", ((RunningServiceInfo) r3.next()).service, ((RunningServiceInfo) r3.next()).process);
                return true;
            }
        }
        return false;
    }
}
