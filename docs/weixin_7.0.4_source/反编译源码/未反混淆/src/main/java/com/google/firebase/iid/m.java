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
import android.util.Log;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzi.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

final class m {
    private static int bvC = 0;
    private static PendingIntent bvP;
    private final Context bvF;
    @GuardedBy("responseCallbacks")
    private final android.support.v4.f.m<String, TaskCompletionSource<Bundle>> bvQ = new android.support.v4.f.m();
    private Messenger bvR;
    private Messenger bvS;
    private zzi bvT;
    private final f bvt;

    public m(Context context, f fVar) {
        AppMethodBeat.i(108735);
        this.bvF = context;
        this.bvt = fVar;
        this.bvR = new Messenger(new n(this, Looper.getMainLooper()));
        AppMethodBeat.o(108735);
    }

    private static synchronized void b(Context context, Intent intent) {
        synchronized (m.class) {
            AppMethodBeat.i(108736);
            if (bvP == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                bvP = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", bvP);
            AppMethodBeat.o(108736);
        }
    }

    private final void f(String str, Bundle bundle) {
        AppMethodBeat.i(108737);
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
                    AppMethodBeat.o(108737);
                }
            } finally {
                AppMethodBeat.o(108737);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00da A:{SYNTHETIC, Splitter:B:32:0x00da} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final Bundle g(Bundle bundle) {
        AppMethodBeat.i(108741);
        String uR = uR();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.bvQ) {
            try {
                this.bvQ.put(uR, taskCompletionSource);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(108741);
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
        b(this.bvF, intent);
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
                    AppMethodBeat.o(108741);
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
            AppMethodBeat.o(108741);
            throw iOException2;
        } catch (ExecutionException e3) {
            IOException iOException3 = new IOException(e3);
            AppMethodBeat.o(108741);
            throw iOException3;
        } catch (Throwable th) {
            synchronized (this.bvQ) {
                try {
                    this.bvQ.remove(uR);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(108741);
                }
            }
        }
    }

    private static synchronized String uR() {
        String num;
        synchronized (m.class) {
            AppMethodBeat.i(108740);
            int i = bvC;
            bvC = i + 1;
            num = Integer.toString(i);
            AppMethodBeat.o(108740);
        }
        return num;
    }

    private final Bundle zzd(Bundle bundle) {
        AppMethodBeat.i(108739);
        Bundle g = g(bundle);
        if (g != null && g.containsKey("google.messenger")) {
            g = g(bundle);
            if (g != null && g.containsKey("google.messenger")) {
                g = null;
            }
        }
        AppMethodBeat.o(108739);
        return g;
    }

    /* Access modifiers changed, original: final */
    public final Bundle f(Bundle bundle) {
        AppMethodBeat.i(108738);
        Bundle bundle2;
        if (this.bvt.uQ() >= 12000000) {
            ai ar = ai.ar(this.bvF);
            try {
                bundle2 = (Bundle) Tasks.await(ar.a(new e(ar.uX(), bundle)));
                AppMethodBeat.o(108738);
                return bundle2;
            } catch (InterruptedException | ExecutionException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e);
                    new StringBuilder(String.valueOf(valueOf).length() + 22).append("Error making request: ").append(valueOf);
                }
                if ((e.getCause() instanceof d) && ((d) e.getCause()).errorCode == 4) {
                    bundle2 = zzd(bundle);
                    AppMethodBeat.o(108738);
                    return bundle2;
                }
                AppMethodBeat.o(108738);
                return null;
            }
        }
        bundle2 = zzd(bundle);
        AppMethodBeat.o(108738);
        return bundle2;
    }

    static /* synthetic */ void a(m mVar, Message message) {
        AppMethodBeat.i(108742);
        if (message != null && (message.obj instanceof Intent)) {
            Intent intent = (Intent) message.obj;
            intent.setExtrasClassLoader(new a());
            if (intent.hasExtra("google.messenger")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                if (parcelableExtra instanceof zzi) {
                    mVar.bvT = (zzi) parcelableExtra;
                }
                if (parcelableExtra instanceof Messenger) {
                    mVar.bvS = (Messenger) parcelableExtra;
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
                        AppMethodBeat.o(108742);
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
                                AppMethodBeat.o(108742);
                                return;
                            }
                            action = new String(valueOf);
                            AppMethodBeat.o(108742);
                            return;
                        }
                        valueOf2 = split[2];
                        action = split[3];
                        if (action.startsWith(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
                            action = action.substring(1);
                        }
                        mVar.f(valueOf2, intent.putExtra("error", action).getExtras());
                        AppMethodBeat.o(108742);
                        return;
                    }
                    synchronized (mVar.bvQ) {
                        int i = 0;
                        while (i < mVar.bvQ.size()) {
                            try {
                                mVar.f((String) mVar.bvQ.keyAt(i), intent.getExtras());
                                i++;
                            } finally {
                                while (true) {
                                }
                                AppMethodBeat.o(108742);
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
                    mVar.f(action, extras);
                } else {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        valueOf = "Unexpected response string: ";
                        action = String.valueOf(stringExtra);
                        if (action.length() != 0) {
                            valueOf.concat(action);
                            AppMethodBeat.o(108742);
                            return;
                        }
                        action = new String(valueOf);
                    }
                    AppMethodBeat.o(108742);
                    return;
                }
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                valueOf = "Unexpected response action: ";
                action = String.valueOf(action);
                if (action.length() != 0) {
                    valueOf.concat(action);
                    AppMethodBeat.o(108742);
                    return;
                }
                action = new String(valueOf);
            }
            AppMethodBeat.o(108742);
            return;
        }
        AppMethodBeat.o(108742);
    }
}
