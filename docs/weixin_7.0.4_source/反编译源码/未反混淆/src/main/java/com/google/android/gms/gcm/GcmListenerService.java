package com.google.android.gms.gcm;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.google.android.gms.iid.zze;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

@Deprecated
public class GcmListenerService extends zze {
    static void zzd(Bundle bundle) {
        AppMethodBeat.i(69934);
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null && str.startsWith("google.c.")) {
                it.remove();
            }
        }
        AppMethodBeat.o(69934);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleIntent(Intent intent) {
        AppMethodBeat.i(69933);
        String stringExtra;
        String str;
        if ("com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            stringExtra = intent.getStringExtra("message_type");
            if (stringExtra == null) {
                stringExtra = GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE;
            }
            Object obj = -1;
            switch (stringExtra.hashCode()) {
                case -2062414158:
                    if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_DELETED)) {
                        int obj2 = 1;
                        break;
                    }
                    break;
                case 102161:
                    if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE)) {
                        obj2 = null;
                        break;
                    }
                    break;
                case 814694033:
                    if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR)) {
                        obj2 = 3;
                        break;
                    }
                    break;
                case 814800675:
                    if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_EVENT)) {
                        obj2 = 2;
                        break;
                    }
                    break;
            }
            switch (obj2) {
                case null:
                    Bundle extras = intent.getExtras();
                    extras.remove("message_type");
                    extras.remove("android.support.content.wakelockid");
                    Object obj3 = ("1".equals(zzd.zzd(extras, "gcm.n.e")) || zzd.zzd(extras, "gcm.n.icon") != null) ? 1 : null;
                    if (obj3 != null) {
                        if (!((KeyguardManager) getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
                            int myPid = Process.myPid();
                            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) getSystemService("activity")).getRunningAppProcesses();
                            if (runningAppProcesses != null) {
                                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                                    if (runningAppProcessInfo.pid == myPid) {
                                        obj3 = runningAppProcessInfo.importance == 100 ? 1 : null;
                                        if (obj3 != null) {
                                            zzd.zzd(this).zze(extras);
                                            AppMethodBeat.o(69933);
                                            return;
                                        }
                                        Bundle bundle = new Bundle();
                                        Iterator it = extras.keySet().iterator();
                                        while (it.hasNext()) {
                                            stringExtra = (String) it.next();
                                            String string = extras.getString(stringExtra);
                                            if (stringExtra.startsWith("gcm.notification.")) {
                                                stringExtra = stringExtra.replace("gcm.notification.", "gcm.n.");
                                            }
                                            if (stringExtra.startsWith("gcm.n.")) {
                                                if (!"gcm.n.e".equals(stringExtra)) {
                                                    bundle.putString(stringExtra.substring(6), string);
                                                }
                                                it.remove();
                                            }
                                        }
                                        stringExtra = bundle.getString("sound2");
                                        if (stringExtra != null) {
                                            bundle.remove("sound2");
                                            bundle.putString("sound", stringExtra);
                                        }
                                        if (!bundle.isEmpty()) {
                                            extras.putBundle("notification", bundle);
                                        }
                                    }
                                }
                            }
                        }
                        obj3 = null;
                        if (obj3 != null) {
                        }
                    }
                    stringExtra = extras.getString("from");
                    extras.remove("from");
                    zzd(extras);
                    onMessageReceived(stringExtra, extras);
                    AppMethodBeat.o(69933);
                    return;
                case 1:
                    onDeletedMessages();
                    AppMethodBeat.o(69933);
                    return;
                case 2:
                    onMessageSent(intent.getStringExtra("google.message_id"));
                    AppMethodBeat.o(69933);
                    return;
                case 3:
                    stringExtra = intent.getStringExtra("google.message_id");
                    if (stringExtra == null) {
                        stringExtra = intent.getStringExtra("message_id");
                    }
                    onSendError(stringExtra, intent.getStringExtra("error"));
                    AppMethodBeat.o(69933);
                    return;
                default:
                    str = "Received message with unknown type: ";
                    stringExtra = String.valueOf(stringExtra);
                    if (stringExtra.length() != 0) {
                        str.concat(stringExtra);
                        AppMethodBeat.o(69933);
                        return;
                    }
                    stringExtra = new String(str);
                    AppMethodBeat.o(69933);
                    return;
            }
        }
        stringExtra = "Unknown intent action: ";
        str = String.valueOf(intent.getAction());
        if (str.length() != 0) {
            stringExtra.concat(str);
            AppMethodBeat.o(69933);
            return;
        }
        str = new String(stringExtra);
        AppMethodBeat.o(69933);
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(String str, Bundle bundle) {
    }

    public void onMessageSent(String str) {
    }

    public void onSendError(String str, String str2) {
    }
}
