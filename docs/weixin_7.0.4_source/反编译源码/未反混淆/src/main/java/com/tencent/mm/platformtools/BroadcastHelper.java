package com.tencent.mm.platformtools;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.BluetoothReceiver;
import com.tencent.mm.booter.BluetoothStateReceiver;
import com.tencent.mm.booter.CoreService.a;
import com.tencent.mm.booter.InstallReceiver;
import com.tencent.mm.booter.MMReceivers.ConnectionReceiver;
import com.tencent.mm.booter.MountReceiver;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.downloader.model.FileDownloadReceiver;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public class BroadcastHelper implements a {
    private static final String TAG = "MicroMsg.BroadcastHelper";
    private static HashMap<String, BroadcastReceiver> broadcastReceiverHashMap = new HashMap();

    static {
        AppMethodBeat.i(16668);
        AppMethodBeat.o(16668);
    }

    public static void registerBroadcast(BroadcastReceiver broadcastReceiver, String str) {
        AppMethodBeat.i(16660);
        registerBroadcast(broadcastReceiver, new String[]{str}, new String[0]);
        AppMethodBeat.o(16660);
    }

    public static void registerBroadcast(BroadcastReceiver broadcastReceiver, String str, String str2) {
        AppMethodBeat.i(16661);
        registerBroadcast(broadcastReceiver, new String[]{str}, new String[]{str2});
        AppMethodBeat.o(16661);
    }

    public static void registerBroadcast(BroadcastReceiver broadcastReceiver, String[] strArr) {
        AppMethodBeat.i(16662);
        registerBroadcast(broadcastReceiver, strArr, new String[0]);
        AppMethodBeat.o(16662);
    }

    public static void registerBroadcast(BroadcastReceiver broadcastReceiver, String[] strArr, String str) {
        AppMethodBeat.i(16663);
        registerBroadcast(broadcastReceiver, strArr, new String[]{str});
        AppMethodBeat.o(16663);
    }

    public static void registerBroadcast(BroadcastReceiver broadcastReceiver, String[] strArr, String[] strArr2) {
        int length;
        int i = 0;
        AppMethodBeat.i(16664);
        ab.i(TAG, "registerBroadcast: " + broadcastReceiver.getClass().getSimpleName());
        IntentFilter intentFilter = new IntentFilter();
        if (!bo.Q(strArr)) {
            for (String addAction : strArr) {
                intentFilter.addAction(addAction);
            }
        }
        if (!bo.Q(strArr2)) {
            length = strArr2.length;
            while (i < length) {
                intentFilter.addCategory(strArr2[i]);
                i++;
            }
        }
        ah.getContext().registerReceiver(broadcastReceiver, intentFilter);
        AppMethodBeat.o(16664);
    }

    public static void unRegisterBroadcast(BroadcastReceiver broadcastReceiver) {
        AppMethodBeat.i(16665);
        ab.i(TAG, "unRegisterBroadcast: " + broadcastReceiver.getClass().getSimpleName());
        if (broadcastReceiver != null) {
            ah.getContext().unregisterReceiver(broadcastReceiver);
        }
        AppMethodBeat.o(16665);
    }

    public void registerBroadcasts() {
        BroadcastReceiver connectionReceiver;
        AppMethodBeat.i(16666);
        ab.i(TAG, "registerBroadcasts()");
        if (ah.doE() && d.iW(24)) {
            connectionReceiver = new ConnectionReceiver();
            broadcastReceiverHashMap.put(ConnectionReceiver.class.getSimpleName(), connectionReceiver);
            registerBroadcast(connectionReceiver, "android.net.conn.CONNECTIVITY_CHANGE");
        }
        if (ah.bqo() && d.iW(26)) {
            connectionReceiver = new FileDownloadReceiver();
            broadcastReceiverHashMap.put(FileDownloadReceiver.class.getSimpleName(), connectionReceiver);
            registerBroadcast(connectionReceiver, "android.intent.action.DOWNLOAD_COMPLETE");
            connectionReceiver = new InstallReceiver();
            broadcastReceiverHashMap.put(InstallReceiver.class.getSimpleName(), connectionReceiver);
            registerBroadcast(connectionReceiver, "com.android.vending.INSTALL_REFERRER");
            connectionReceiver = new BluetoothReceiver();
            broadcastReceiverHashMap.put(BluetoothReceiver.class.getSimpleName(), connectionReceiver);
            registerBroadcast(connectionReceiver, new String[]{"android.media.SCO_AUDIO_STATE_CHANGED", "android.media.ACTION_SCO_AUDIO_STATE_UPDATED"});
            connectionReceiver = new BluetoothStateReceiver();
            broadcastReceiverHashMap.put(BluetoothStateReceiver.class.getSimpleName(), connectionReceiver);
            registerBroadcast(connectionReceiver, "android.bluetooth.adapter.action.STATE_CHANGED");
            connectionReceiver = new MountReceiver();
            broadcastReceiverHashMap.put(MountReceiver.class.getSimpleName(), connectionReceiver);
            registerBroadcast(connectionReceiver, new String[]{"android.intent.action.MEDIA_MOUNTED", "android.intent.action.MEDIA_EJECT", "android.intent.action.MEDIA_UNMOUNTED", "android.intent.action.MEDIA_SHARED", "android.intent.action.MEDIA_SCANNER_STARTED", "android.intent.action.MEDIA_SCANNER_FINISHED", "android.intent.action.MEDIA_REMOVED", "android.intent.action.MEDIA_BAD_REMOVAL"});
        }
        AppMethodBeat.o(16666);
    }

    public void unRegisterBroadcasts() {
        AppMethodBeat.i(16667);
        ab.i(TAG, "unRegisterBroadcasts()");
        try {
            if (ah.doE() && d.iW(24)) {
                unRegisterBroadcast((ConnectionReceiver) broadcastReceiverHashMap.get(ConnectionReceiver.class.getSimpleName()));
            }
            if (ah.bqo() && d.iW(26)) {
                unRegisterBroadcast((FileDownloadReceiver) broadcastReceiverHashMap.get(FileDownloadReceiver.class.getSimpleName()));
                unRegisterBroadcast((InstallReceiver) broadcastReceiverHashMap.get(InstallReceiver.class.getSimpleName()));
                unRegisterBroadcast((BluetoothReceiver) broadcastReceiverHashMap.get(BluetoothReceiver.class.getSimpleName()));
                unRegisterBroadcast((BluetoothStateReceiver) broadcastReceiverHashMap.get(BluetoothStateReceiver.class.getSimpleName()));
                unRegisterBroadcast((MountReceiver) broadcastReceiverHashMap.get(MountReceiver.class.getSimpleName()));
            }
            AppMethodBeat.o(16667);
        } catch (Exception e) {
            ab.e(TAG, "unRegisterBroadcasts() Exception = %s ", e.getMessage());
            AppMethodBeat.o(16667);
        }
    }
}
