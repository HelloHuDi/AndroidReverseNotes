package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.p057v4.p065f.C0417m;
import android.util.Log;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzi.C25588a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.firebase.iid.m */
final class C25586m {
    private static int bvC = 0;
    private static PendingIntent bvP;
    private final Context bvF;
    @GuardedBy("responseCallbacks")
    private final C0417m<String, TaskCompletionSource<Bundle>> bvQ = new C0417m();
    private Messenger bvR;
    private Messenger bvS;
    private zzi bvT;
    private final C32099f bvt;

    public C25586m(Context context, C32099f c32099f) {
        AppMethodBeat.m2504i(108735);
        this.bvF = context;
        this.bvt = c32099f;
        this.bvR = new Messenger(new C17708n(this, Looper.getMainLooper()));
        AppMethodBeat.m2505o(108735);
    }

    /* renamed from: b */
    private static synchronized void m40582b(Context context, Intent intent) {
        synchronized (C25586m.class) {
            AppMethodBeat.m2504i(108736);
            if (bvP == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                bvP = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", bvP);
            AppMethodBeat.m2505o(108736);
        }
    }

    /* renamed from: f */
    private final void m40583f(String str, Bundle bundle) {
        AppMethodBeat.m2504i(108737);
        synchronized (this.bvQ) {
            try {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.bvQ.remove(str);
                if (taskCompletionSource == null) {
                    String str2 = "Missing callback for ";
                    String valueOf = String.valueOf(str);
                    if (valueOf.length() != 0) {
                        str2.concat(valueOf);
                    } else {
                        valueOf = new String(str2);
                    }
                } else {
                    taskCompletionSource.setResult(bundle);
                    AppMethodBeat.m2505o(108737);
                }
            } finally {
                AppMethodBeat.m2505o(108737);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00da A:{SYNTHETIC, Splitter:B:32:0x00da} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    private final Bundle m40584g(Bundle bundle) {
        AppMethodBeat.m2504i(108741);
        String uR = C25586m.m40585uR();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.bvQ) {
            try {
                this.bvQ.put(uR, taskCompletionSource);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(108741);
            }
        }
        if (this.bvt.zzx() == 0) {
            Object iOException = new IOException(InstanceID.ERROR_MISSING_INSTANCEID_SERVICE);
            throw iOException;
        }
        Bundle bundle2;
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.bvt.zzx() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        C25586m.m40582b(this.bvF, intent);
        intent.putExtra("kid", new StringBuilder(String.valueOf(uR).length() + 5).append("|ID|").append(uR).append("|").toString());
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            new StringBuilder(String.valueOf(valueOf).length() + 8).append("Sending ").append(valueOf);
        }
        intent.putExtra("google.messenger", this.bvR);
        if (!(this.bvS == null && this.bvT == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                if (this.bvS != null) {
                    this.bvS.send(obtain);
                } else {
                    this.bvT.send(obtain);
                }
            } catch (RemoteException e) {
                Log.isLoggable("FirebaseInstanceId", 3);
            }
            bundle2 = (Bundle) Tasks.await(taskCompletionSource.getTask(), 30000, TimeUnit.MILLISECONDS);
            synchronized (this.bvQ) {
                try {
                    this.bvQ.remove(uR);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(108741);
                }
            }
            return bundle2;
        }
        if (this.bvt.zzx() == 2) {
            this.bvF.sendBroadcast(intent);
        } else {
            this.bvF.startService(intent);
        }
        try {
            bundle2 = (Bundle) Tasks.await(taskCompletionSource.getTask(), 30000, TimeUnit.MILLISECONDS);
            synchronized (this.bvQ) {
            }
            return bundle2;
        } catch (InterruptedException | TimeoutException e2) {
            IOException iOException2 = new IOException(InstanceID.ERROR_TIMEOUT);
            AppMethodBeat.m2505o(108741);
            throw iOException2;
        } catch (ExecutionException e3) {
            IOException iOException3 = new IOException(e3);
            AppMethodBeat.m2505o(108741);
            throw iOException3;
        } catch (Throwable th) {
            synchronized (this.bvQ) {
                try {
                    this.bvQ.remove(uR);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(108741);
                }
            }
        }
    }

    /* renamed from: uR */
    private static synchronized String m40585uR() {
        String num;
        synchronized (C25586m.class) {
            AppMethodBeat.m2504i(108740);
            int i = bvC;
            bvC = i + 1;
            num = Integer.toString(i);
            AppMethodBeat.m2505o(108740);
        }
        return num;
    }

    private final Bundle zzd(Bundle bundle) {
        AppMethodBeat.m2504i(108739);
        Bundle g = m40584g(bundle);
        if (g != null && g.containsKey("google.messenger")) {
            g = m40584g(bundle);
            if (g != null && g.containsKey("google.messenger")) {
                g = null;
            }
        }
        AppMethodBeat.m2505o(108739);
        return g;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: f */
    public final Bundle mo43246f(Bundle bundle) {
        AppMethodBeat.m2504i(108738);
        Bundle bundle2;
        if (this.bvt.mo52666uQ() >= 12000000) {
            C25584ai ar = C25584ai.m40578ar(this.bvF);
            try {
                bundle2 = (Bundle) Tasks.await(ar.mo43243a(new C0909e(ar.mo43244uX(), bundle)));
                AppMethodBeat.m2505o(108738);
                return bundle2;
            } catch (InterruptedException | ExecutionException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e);
                    new StringBuilder(String.valueOf(valueOf).length() + 22).append("Error making request: ").append(valueOf);
                }
                if ((e.getCause() instanceof C0908d) && ((C0908d) e.getCause()).errorCode == 4) {
                    bundle2 = zzd(bundle);
                    AppMethodBeat.m2505o(108738);
                    return bundle2;
                }
                AppMethodBeat.m2505o(108738);
                return null;
            }
        }
        bundle2 = zzd(bundle);
        AppMethodBeat.m2505o(108738);
        return bundle2;
    }

    /* renamed from: a */
    static /* synthetic */ void m40581a(C25586m c25586m, Message message) {
        AppMethodBeat.m2504i(108742);
        if (message != null && (message.obj instanceof Intent)) {
            Intent intent = (Intent) message.obj;
            intent.setExtrasClassLoader(new C25588a());
            if (intent.hasExtra("google.messenger")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                if (parcelableExtra instanceof zzi) {
                    c25586m.bvT = (zzi) parcelableExtra;
                }
                if (parcelableExtra instanceof Messenger) {
                    c25586m.bvS = (Messenger) parcelableExtra;
                }
            }
            intent = (Intent) message.obj;
            String action = intent.getAction();
            String valueOf;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                CharSequence stringExtra = intent.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent.getStringExtra("unregistered");
                }
                String str;
                if (stringExtra == null) {
                    action = intent.getStringExtra("error");
                    if (action == null) {
                        valueOf = String.valueOf(intent.getExtras());
                        new StringBuilder(String.valueOf(valueOf).length() + 49).append("Unexpected response, no error or registration id ").append(valueOf);
                        AppMethodBeat.m2505o(108742);
                        return;
                    }
                    String valueOf2;
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        str = "Received InstanceID error ";
                        valueOf2 = String.valueOf(action);
                        if (valueOf2.length() != 0) {
                            str.concat(valueOf2);
                        } else {
                            valueOf2 = new String(str);
                        }
                    }
                    if (action.startsWith("|")) {
                        String[] split = action.split("\\|");
                        if (split.length <= 2 || !"ID".equals(split[1])) {
                            valueOf = "Unexpected structured response ";
                            action = String.valueOf(action);
                            if (action.length() != 0) {
                                valueOf.concat(action);
                                AppMethodBeat.m2505o(108742);
                                return;
                            }
                            action = new String(valueOf);
                            AppMethodBeat.m2505o(108742);
                            return;
                        }
                        valueOf2 = split[2];
                        action = split[3];
                        if (action.startsWith(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
                            action = action.substring(1);
                        }
                        c25586m.m40583f(valueOf2, intent.putExtra("error", action).getExtras());
                        AppMethodBeat.m2505o(108742);
                        return;
                    }
                    synchronized (c25586m.bvQ) {
                        int i = 0;
                        while (i < c25586m.bvQ.size()) {
                            try {
                                c25586m.m40583f((String) c25586m.bvQ.keyAt(i), intent.getExtras());
                                i++;
                            } finally {
                                while (true) {
                                }
                                AppMethodBeat.m2505o(108742);
                            }
                        }
                    }
                    return;
                }
                Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                if (matcher.matches()) {
                    action = matcher.group(1);
                    str = matcher.group(2);
                    Bundle extras = intent.getExtras();
                    extras.putString("registration_id", str);
                    c25586m.m40583f(action, extras);
                } else {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        valueOf = "Unexpected response string: ";
                        action = String.valueOf(stringExtra);
                        if (action.length() != 0) {
                            valueOf.concat(action);
                            AppMethodBeat.m2505o(108742);
                            return;
                        }
                        action = new String(valueOf);
                    }
                    AppMethodBeat.m2505o(108742);
                    return;
                }
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                valueOf = "Unexpected response action: ";
                action = String.valueOf(action);
                if (action.length() != 0) {
                    valueOf.concat(action);
                    AppMethodBeat.m2505o(108742);
                    return;
                }
                action = new String(valueOf);
            }
            AppMethodBeat.m2505o(108742);
            return;
        }
        AppMethodBeat.m2505o(108742);
    }
}
