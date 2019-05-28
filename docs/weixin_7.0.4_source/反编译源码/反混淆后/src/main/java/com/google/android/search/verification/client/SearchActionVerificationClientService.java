package com.google.android.search.verification.client;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Base64;
import com.google.android.gms.common.internal.GmsIntents;
import com.google.android.search.verification.p800a.C32079a;
import com.google.android.search.verification.p800a.C32079a.C8724a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class SearchActionVerificationClientService extends IntentService {
    private final boolean bun = m52185uq();
    private final long buo = 1000;
    private final Intent bup = new Intent("com.google.android.googlequicksearchbox.SEARCH_ACTION_VERIFICATION_SERVICE").setPackage(GmsIntents.GOOGLE_NOW_PACKAGE_NAME);
    private C8726a buq;
    private C32079a bur = null;

    /* renamed from: com.google.android.search.verification.client.SearchActionVerificationClientService$a */
    class C8726a implements ServiceConnection {
        C8726a() {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.m2504i(94131);
            SearchActionVerificationClientService.this.bun;
            SearchActionVerificationClientService.this.bur = C8724a.m15530g(iBinder);
            AppMethodBeat.m2505o(94131);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.m2504i(94132);
            SearchActionVerificationClientService.this.bur = null;
            SearchActionVerificationClientService.this.bun;
            AppMethodBeat.m2505o(94132);
        }
    }

    /* renamed from: a */
    public abstract boolean mo21263a(Intent intent, boolean z);

    /* renamed from: uq */
    private static boolean m52185uq() {
        return !"user".equals(Build.TYPE);
    }

    public SearchActionVerificationClientService() {
        super("SearchActionVerificationClientService");
    }

    private boolean isConnected() {
        return this.bur != null;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onHandleIntent(Intent intent) {
        String valueOf;
        boolean z = true;
        if (intent != null) {
            boolean z2 = m52185uq() || m52186ur();
            long nanoTime = System.nanoTime();
            while (!isConnected() && System.nanoTime() - nanoTime < this.buo * 1000000) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    if (this.bun) {
                        valueOf = String.valueOf(e);
                        new StringBuilder(String.valueOf(valueOf).length() + 33).append("Unexpected InterruptedException: ").append(valueOf);
                    }
                }
            }
            if (!isConnected()) {
                valueOf = String.valueOf(intent);
                new StringBuilder(String.valueOf(valueOf).length() + 62).append("VerificationService is not connected, unable to check intent: ").append(valueOf);
            } else if (intent.hasExtra("SearchActionVerificationClientExtraIntent")) {
                Intent intent2 = (Intent) intent.getParcelableExtra("SearchActionVerificationClientExtraIntent");
                if (this.bun) {
                    m52184e(intent2);
                }
                try {
                    new StringBuilder(24).append("API version: ").append(this.bur.getVersion());
                    Bundle bundle = new Bundle();
                    if (!(z2 && this.bur.mo19731a(intent2, bundle))) {
                        z = false;
                    }
                    mo21263a(intent2, z);
                } catch (RemoteException e2) {
                    String str = "Remote exception: ";
                    valueOf = String.valueOf(e2.getMessage());
                    if (valueOf.length() != 0) {
                        str.concat(valueOf);
                    } else {
                        valueOf = new String(str);
                    }
                }
            } else if (this.bun) {
                valueOf = String.valueOf(intent);
                new StringBuilder(String.valueOf(valueOf).length() + 28).append("No extra, nothing to check: ").append(valueOf);
            }
        }
    }

    public final void onCreate() {
        super.onCreate();
        this.buq = new C8726a();
        bindService(this.bup, this.buq, 1);
    }

    public final void onDestroy() {
        super.onDestroy();
        unbindService(this.buq);
    }

    /* renamed from: ur */
    private boolean m52186ur() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(GmsIntents.GOOGLE_NOW_PACKAGE_NAME, 64);
            if (packageInfo.signatures == null || packageInfo.signatures.length != 1) {
                return false;
            }
            return Base64.encodeToString(packageInfo.signatures[0].toByteArray(), 2).equals("MIIEQzCCAyugAwIBAgIJAMLgh0ZkSjCNMA0GCSqGSIb3DQEBBAUAMHQxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1Nb3VudGFpbiBWaWV3MRQwEgYDVQQKEwtHb29nbGUgSW5jLjEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDAeFw0wODA4MjEyMzEzMzRaFw0zNjAxMDcyMzEzMzRaMHQxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1Nb3VudGFpbiBWaWV3MRQwEgYDVQQKEwtHb29nbGUgSW5jLjEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDCCASAwDQYJKoZIhvcNAQEBBQADggENADCCAQgCggEBAKtWLgDYO6IIrgqWbxJOKdoR8qtW0I9Y4sypEwPpt1TTcvZApxsdyxMJZ2JORland2qSGT2y5b+3JKkedxiLDmpHpDsz2WCbdxgxRczfey5YZnTJ4VZbH0xqWVW/8lGmPav5xVwnIiJS6HXk+BVKZF+JcWjAsb/GEuq/eFdpuzSqeYTcfi6idkyugwfYwXFU1+5fZKUaRKYCwkkFQVfcAs1fXA5V+++FGfvjJ/CxURaSxaBvGdGDhfXE28LWuT9ozCl5xw4Yq5OGazvV24mZVSoOO0yZ31j7kYvtwYK6NeADwbSxDdJEqO4k//0zOHKrUiGYXtqw/A0LFFtqoZKFjnkCAQOjgdkwgdYwHQYDVR0OBBYEFMd9jMIhF1Ylmn/Tgt9r45jk14alMIGmBgNVHSMEgZ4wgZuAFMd9jMIhF1Ylmn/Tgt9r45jk14aloXikdjB0MQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEUMBIGA1UEChMLR29vZ2xlIEluYy4xEDAOBgNVBAsTB0FuZHJvaWQxEDAOBgNVBAMTB0FuZHJvaWSCCQDC4IdGZEowjTAMBgNVHRMEBTADAQH/MA0GCSqGSIb3DQEBBAUAA4IBAQBt0lLO74UwLDYKqs6Tm8/yzKkEu116FmH4rkaymUIE0P9KaMftGlMexFlaYjzmB2OxZyl6euNXEsQH8gjwyxCUKRJNexBiGcCEyj6z+a1fuHHvkiaai+KL8W1EyNmgjmyy8AW7P+LLlkR+ho5zEHatRbM/YAnqGcFh5iZBqpknHf1SKMXFh4dd239FJ1jWYfbMDMy3NS5CTMQ2XFI1MvcyUTdZPErjQfTbQe3aDQsQcafEQPD+nqActifKZ0Np0IS9L9kR/wbNvyz6ENwPiTrjV2KRkEjH78ZMcUQXg0L3BYHJ3lc69Vs5Ddf9uUGGMYldX3WfMBEmh/9iFBDAaTCK");
        } catch (NameNotFoundException e) {
            if (!this.bun) {
                return false;
            }
            String valueOf = String.valueOf(e);
            new StringBuilder(String.valueOf(valueOf).length() + 34).append("Unexpected NameNotFoundException: ").append(valueOf);
            return false;
        }
    }

    /* renamed from: e */
    private static void m52184e(Intent intent) {
        String valueOf = String.valueOf(intent);
        new StringBuilder(String.valueOf(valueOf).length() + 1).append("\t").append(valueOf);
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String valueOf2 : extras.keySet()) {
                String.format("\t%s: %s", new Object[]{valueOf2, extras.get(valueOf2)});
            }
        }
    }
}
