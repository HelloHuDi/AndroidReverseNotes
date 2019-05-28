package com.tencent.p177mm.platformtools;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.BluetoothReceiver;
import com.tencent.p177mm.booter.BluetoothStateReceiver;
import com.tencent.p177mm.booter.CoreService.C9177a;
import com.tencent.p177mm.booter.InstallReceiver;
import com.tencent.p177mm.booter.MMReceivers.ConnectionReceiver;
import com.tencent.p177mm.booter.MountReceiver;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadReceiver;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.platformtools.BroadcastHelper */
public class BroadcastHelper implements C9177a {
    private static final String TAG = "MicroMsg.BroadcastHelper";
    private static HashMap<String, BroadcastReceiver> broadcastReceiverHashMap = new HashMap();

    static {
        AppMethodBeat.m2504i(16668);
        AppMethodBeat.m2505o(16668);
    }

    public static void registerBroadcast(BroadcastReceiver broadcastReceiver, String str) {
        AppMethodBeat.m2504i(16660);
        BroadcastHelper.registerBroadcast(broadcastReceiver, new String[]{str}, new String[0]);
        AppMethodBeat.m2505o(16660);
    }

    public static void registerBroadcast(BroadcastReceiver broadcastReceiver, String str, String str2) {
        AppMethodBeat.m2504i(16661);
        BroadcastHelper.registerBroadcast(broadcastReceiver, new String[]{str}, new String[]{str2});
        AppMethodBeat.m2505o(16661);
    }

    public static void registerBroadcast(BroadcastReceiver broadcastReceiver, String[] strArr) {
        AppMethodBeat.m2504i(16662);
        BroadcastHelper.registerBroadcast(broadcastReceiver, strArr, new String[0]);
        AppMethodBeat.m2505o(16662);
    }

    public static void registerBroadcast(BroadcastReceiver broadcastReceiver, String[] strArr, String str) {
        AppMethodBeat.m2504i(16663);
        BroadcastHelper.registerBroadcast(broadcastReceiver, strArr, new String[]{str});
        AppMethodBeat.m2505o(16663);
    }

    public static void registerBroadcast(BroadcastReceiver broadcastReceiver, String[] strArr, String[] strArr2) {
        int length;
        int i = 0;
        AppMethodBeat.m2504i(16664);
        C4990ab.m7416i(TAG, "registerBroadcast: " + broadcastReceiver.getClass().getSimpleName());
        IntentFilter intentFilter = new IntentFilter();
        if (!C5046bo.m7510Q(strArr)) {
            for (String addAction : strArr) {
                intentFilter.addAction(addAction);
            }
        }
        if (!C5046bo.m7510Q(strArr2)) {
            length = strArr2.length;
            while (i < length) {
                intentFilter.addCategory(strArr2[i]);
                i++;
            }
        }
        C4996ah.getContext().registerReceiver(broadcastReceiver, intentFilter);
        AppMethodBeat.m2505o(16664);
    }

    public static void unRegisterBroadcast(BroadcastReceiver broadcastReceiver) {
        AppMethodBeat.m2504i(16665);
        C4990ab.m7416i(TAG, "unRegisterBroadcast: " + broadcastReceiver.getClass().getSimpleName());
        if (broadcastReceiver != null) {
            C4996ah.getContext().unregisterReceiver(broadcastReceiver);
        }
        AppMethodBeat.m2505o(16665);
    }

    public void registerBroadcasts() {
        BroadcastReceiver connectionReceiver;
        AppMethodBeat.m2504i(16666);
        C4990ab.m7416i(TAG, "registerBroadcasts()");
        if (C4996ah.doE() && C1443d.m3068iW(24)) {
            connectionReceiver = new ConnectionReceiver();
            broadcastReceiverHashMap.put(ConnectionReceiver.class.getSimpleName(), connectionReceiver);
            BroadcastHelper.registerBroadcast(connectionReceiver, "android.net.conn.CONNECTIVITY_CHANGE");
        }
        if (C4996ah.bqo() && C1443d.m3068iW(26)) {
            connectionReceiver = new FileDownloadReceiver();
            broadcastReceiverHashMap.put(FileDownloadReceiver.class.getSimpleName(), connectionReceiver);
            BroadcastHelper.registerBroadcast(connectionReceiver, "android.intent.action.DOWNLOAD_COMPLETE");
            connectionReceiver = new InstallReceiver();
            broadcastReceiverHashMap.put(InstallReceiver.class.getSimpleName(), connectionReceiver);
            BroadcastHelper.registerBroadcast(connectionReceiver, "com.android.vending.INSTALL_REFERRER");
            connectionReceiver = new BluetoothReceiver();
            broadcastReceiverHashMap.put(BluetoothReceiver.class.getSimpleName(), connectionReceiver);
            BroadcastHelper.registerBroadcast(connectionReceiver, new String[]{"android.media.SCO_AUDIO_STATE_CHANGED", "android.media.ACTION_SCO_AUDIO_STATE_UPDATED"});
            connectionReceiver = new BluetoothStateReceiver();
            broadcastReceiverHashMap.put(BluetoothStateReceiver.class.getSimpleName(), connectionReceiver);
            BroadcastHelper.registerBroadcast(connectionReceiver, "android.bluetooth.adapter.action.STATE_CHANGED");
            connectionReceiver = new MountReceiver();
            broadcastReceiverHashMap.put(MountReceiver.class.getSimpleName(), connectionReceiver);
            BroadcastHelper.registerBroadcast(connectionReceiver, new String[]{"android.intent.action.MEDIA_MOUNTED", "android.intent.action.MEDIA_EJECT", "android.intent.action.MEDIA_UNMOUNTED", "android.intent.action.MEDIA_SHARED", "android.intent.action.MEDIA_SCANNER_STARTED", "android.intent.action.MEDIA_SCANNER_FINISHED", "android.intent.action.MEDIA_REMOVED", "android.intent.action.MEDIA_BAD_REMOVAL"});
        }
        AppMethodBeat.m2505o(16666);
    }

    public void unRegisterBroadcasts() {
        AppMethodBeat.m2504i(16667);
        C4990ab.m7416i(TAG, "unRegisterBroadcasts()");
        try {
            if (C4996ah.doE() && C1443d.m3068iW(24)) {
                BroadcastHelper.unRegisterBroadcast((ConnectionReceiver) broadcastReceiverHashMap.get(ConnectionReceiver.class.getSimpleName()));
            }
            if (C4996ah.bqo() && C1443d.m3068iW(26)) {
                BroadcastHelper.unRegisterBroadcast((FileDownloadReceiver) broadcastReceiverHashMap.get(FileDownloadReceiver.class.getSimpleName()));
                BroadcastHelper.unRegisterBroadcast((InstallReceiver) broadcastReceiverHashMap.get(InstallReceiver.class.getSimpleName()));
                BroadcastHelper.unRegisterBroadcast((BluetoothReceiver) broadcastReceiverHashMap.get(BluetoothReceiver.class.getSimpleName()));
                BroadcastHelper.unRegisterBroadcast((BluetoothStateReceiver) broadcastReceiverHashMap.get(BluetoothStateReceiver.class.getSimpleName()));
                BroadcastHelper.unRegisterBroadcast((MountReceiver) broadcastReceiverHashMap.get(MountReceiver.class.getSimpleName()));
            }
            AppMethodBeat.m2505o(16667);
        } catch (Exception e) {
            C4990ab.m7413e(TAG, "unRegisterBroadcasts() Exception = %s ", e.getMessage());
            AppMethodBeat.m2505o(16667);
        }
    }
}
