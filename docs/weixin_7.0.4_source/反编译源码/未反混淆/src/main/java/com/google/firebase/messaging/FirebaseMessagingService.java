package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.google.firebase.analytics.connector.a;
import com.google.firebase.iid.ai;
import com.google.firebase.iid.o;
import com.google.firebase.iid.zzb;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FirebaseMessagingService extends zzb {
    private static final Queue<String> bxc = new ArrayDeque(10);

    static {
        AppMethodBeat.i(77214);
        AppMethodBeat.o(77214);
    }

    static void i(Bundle bundle) {
        AppMethodBeat.i(77212);
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null && str.startsWith("google.c.")) {
                it.remove();
            }
        }
        AppMethodBeat.o(77212);
    }

    static boolean j(Bundle bundle) {
        AppMethodBeat.i(77213);
        if (bundle == null) {
            AppMethodBeat.o(77213);
            return false;
        }
        boolean equals = "1".equals(bundle.getString("google.c.a.e"));
        AppMethodBeat.o(77213);
        return equals;
    }

    public void a(RemoteMessage remoteMessage) {
    }

    public void a(String str, Exception exception) {
    }

    public void onDeletedMessages() {
    }

    public final Intent f(Intent intent) {
        AppMethodBeat.i(77209);
        Intent intent2 = (Intent) o.uS().bvZ.poll();
        AppMethodBeat.o(77209);
        return intent2;
    }

    public final boolean i(Intent intent) {
        AppMethodBeat.i(77210);
        if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
            if (pendingIntent != null) {
                try {
                    pendingIntent.send();
                } catch (CanceledException e) {
                }
            }
            if (j(intent.getExtras())) {
                if (intent != null) {
                    if ("1".equals(intent.getStringExtra("google.c.a.tc"))) {
                        a aVar = (a) com.google.firebase.a.ut().x(a.class);
                        Log.isLoggable("FirebaseMessaging", 3);
                        if (aVar != null) {
                            String stringExtra = intent.getStringExtra("google.c.a.c_id");
                            aVar.setUserProperty(AppMeasurement.FCM_ORIGIN, UserProperty.FIREBASE_LAST_NOTIFICATION, stringExtra);
                            Bundle bundle = new Bundle();
                            bundle.putString("source", "Firebase");
                            bundle.putString(b.MEDIUM, "notification");
                            bundle.putString(b.CAMPAIGN, stringExtra);
                            aVar.logEvent(AppMeasurement.FCM_ORIGIN, "_cmp", bundle);
                        }
                    } else {
                        Log.isLoggable("FirebaseMessaging", 3);
                    }
                }
                d.a("_no", intent);
            }
            AppMethodBeat.o(77210);
            return true;
        }
        AppMethodBeat.o(77210);
        return false;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(Intent intent) {
        Object obj;
        int i = -1;
        Object obj2 = null;
        AppMethodBeat.i(77211);
        String action = intent.getAction();
        if (action == null) {
            action = "";
        }
        switch (action.hashCode()) {
            case 75300319:
                if (action.equals("com.google.firebase.messaging.NOTIFICATION_DISMISS")) {
                    int obj3 = 1;
                    break;
                }
            case 366519424:
                if (action.equals("com.google.android.c2dm.intent.RECEIVE")) {
                    obj3 = null;
                    break;
                }
            default:
                obj3 = -1;
                break;
        }
        String stringExtra;
        switch (obj3) {
            case null:
                Task forResult;
                Object obj4;
                stringExtra = intent.getStringExtra("google.message_id");
                if (TextUtils.isEmpty(stringExtra)) {
                    forResult = Tasks.forResult(null);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("google.message_id", stringExtra);
                    ai ar = ai.ar(this);
                    forResult = ar.a(new com.google.firebase.iid.b(ar.uX(), bundle));
                }
                if (TextUtils.isEmpty(stringExtra)) {
                    obj4 = null;
                } else if (bxc.contains(stringExtra)) {
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        String str = "Received duplicate message: ";
                        stringExtra = String.valueOf(stringExtra);
                        if (stringExtra.length() != 0) {
                            str.concat(stringExtra);
                        } else {
                            stringExtra = new String(str);
                        }
                    }
                    int obj42 = 1;
                } else {
                    if (bxc.size() >= 10) {
                        bxc.remove();
                    }
                    bxc.add(stringExtra);
                    obj42 = null;
                }
                if (obj42 == null) {
                    stringExtra = intent.getStringExtra("message_type");
                    if (stringExtra == null) {
                        stringExtra = GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE;
                    }
                    switch (stringExtra.hashCode()) {
                        case -2062414158:
                            if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_DELETED)) {
                                i = 1;
                                break;
                            }
                            break;
                        case 102161:
                            if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE)) {
                                i = 0;
                                break;
                            }
                            break;
                        case 814694033:
                            if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR)) {
                                i = 3;
                                break;
                            }
                            break;
                        case 814800675:
                            if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_EVENT)) {
                                i = 2;
                                break;
                            }
                            break;
                    }
                    switch (i) {
                        case 0:
                            if (j(intent.getExtras())) {
                                d.a("_nr", intent);
                            }
                            Bundle extras = intent.getExtras();
                            if (extras == null) {
                                extras = new Bundle();
                            }
                            extras.remove("android.support.content.wakelockid");
                            if ("1".equals(c.d(extras, "gcm.n.e")) || c.d(extras, "gcm.n.icon") != null) {
                                obj2 = 1;
                            }
                            if (obj2 != null) {
                                if (!c.as(this).k(extras)) {
                                    if (j(extras)) {
                                        d.a("_nf", intent);
                                    }
                                }
                            }
                            a(new RemoteMessage(extras));
                            break;
                        case 1:
                            onDeletedMessages();
                            break;
                        case 2:
                            intent.getStringExtra("google.message_id");
                            break;
                        case 3:
                            stringExtra = intent.getStringExtra("google.message_id");
                            if (stringExtra == null) {
                                stringExtra = intent.getStringExtra("message_id");
                            }
                            a(stringExtra, new b(intent.getStringExtra("error")));
                            break;
                        default:
                            String str2 = "Received message with unknown type: ";
                            stringExtra = String.valueOf(stringExtra);
                            if (stringExtra.length() == 0) {
                                stringExtra = new String(str2);
                                break;
                            } else {
                                str2.concat(stringExtra);
                                break;
                            }
                    }
                }
                try {
                    Tasks.await(forResult, 1, TimeUnit.SECONDS);
                    AppMethodBeat.o(77211);
                    return;
                } catch (InterruptedException | ExecutionException | TimeoutException e) {
                    action = String.valueOf(e);
                    new StringBuilder(String.valueOf(action).length() + 20).append("Message ack failed: ").append(action);
                    AppMethodBeat.o(77211);
                    return;
                }
            case 1:
                if (j(intent.getExtras())) {
                    d.a("_nd", intent);
                    AppMethodBeat.o(77211);
                    return;
                }
                break;
            default:
                action = "Unknown intent action: ";
                stringExtra = String.valueOf(intent.getAction());
                if (stringExtra.length() == 0) {
                    stringExtra = new String(action);
                    break;
                }
                action.concat(stringExtra);
                AppMethodBeat.o(77211);
                return;
        }
        AppMethodBeat.o(77211);
    }
}
