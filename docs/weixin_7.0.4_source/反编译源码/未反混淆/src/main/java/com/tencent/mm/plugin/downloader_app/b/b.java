package com.tencent.mm.plugin.downloader_app.b;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.v.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadPendingReceive;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private static Map<String, Long> kOE = new HashMap();
    private static Map<String, Integer> kOF = new HashMap();
    private static Object lock = new Object();

    static {
        AppMethodBeat.i(136084);
        AppMethodBeat.o(136084);
    }

    public static void h(a aVar) {
        boolean z = false;
        AppMethodBeat.i(136081);
        if (aVar == null) {
            ab.e("MicroMsg.DownloadNotificationManager", "updateNotification failed: null task info");
            AppMethodBeat.o(136081);
        } else if (aVar.field_fromDownloadApp) {
            int i;
            if (aVar.field_totalSize > 0) {
                i = (int) ((aVar.field_downloadedSize * 100) / aVar.field_totalSize);
            } else {
                i = 0;
            }
            c bt = com.tencent.mm.bo.a.bt(ah.getContext(), "reminder_channel_id");
            Long l = (Long) kOE.get(aVar.field_downloadUrl);
            if (l == null) {
                l = Long.valueOf(System.currentTimeMillis());
                kOE.put(aVar.field_downloadUrl, l);
            }
            bt.j(l.longValue());
            bt.d(aVar.field_fileName);
            switch (aVar.field_status) {
                case 1:
                    bt.as(com.tencent.mm.bo.a.bWV());
                    if (i == 0) {
                        i = 1;
                    }
                    if (i == 0) {
                        z = true;
                    }
                    bt.b(100, i, z);
                    if (aVar.field_reserveInWifi) {
                        bt.e(ah.getContext().getString(R.string.bsr) + "·" + ah.getContext().getString(R.string.bsp));
                    } else {
                        bt.e(ah.getContext().getString(R.string.bsp));
                    }
                    bt.k(2, true);
                    bt.EI = ID(aVar.field_appId);
                    break;
                case 2:
                    cancelNotification(aVar.field_downloadUrl);
                    AppMethodBeat.o(136081);
                    return;
                case 3:
                    cancelNotification(aVar.field_downloadUrl);
                    Context context = ah.getContext();
                    c bt2 = com.tencent.mm.bo.a.bt(context, "reminder_channel_id");
                    bt2.d(aVar.field_fileName);
                    bt2.as(com.tencent.mm.bo.a.bWV());
                    bt2.z(true);
                    Intent intent = new Intent();
                    Context context2 = ah.getContext();
                    intent.setClass(context2, FileDownloadPendingReceive.class);
                    intent.putExtra(FileDownloadService.kNn, 3);
                    intent.putExtra(FileDownloadService.kNo, aVar.field_filePath);
                    intent.putExtra(FileDownloadService.kNp, aVar.field_md5);
                    intent.putExtra("downloadId", aVar.field_downloadId);
                    bt2.EI = PendingIntent.getBroadcast(context2, (int) System.currentTimeMillis(), intent, 0);
                    if (aVar.field_reserveInWifi) {
                        bt2.e(context.getString(R.string.g71));
                    } else {
                        bt2.e(context.getString(R.string.bso));
                    }
                    ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(bt2.build());
                    AppMethodBeat.o(136081);
                    return;
                case 4:
                    bt.as(com.tencent.mm.bo.a.bWV());
                    bt.z(true);
                    bt.EI = ID(aVar.field_appId);
                    if (aVar.field_errCode != com.tencent.mm.plugin.downloader.a.a.kKa && aVar.field_errCode != com.tencent.mm.plugin.downloader.a.a.kJW) {
                        bt.e(ah.getContext().getString(R.string.d8z));
                        break;
                    } else {
                        bt.e(ah.getContext().getString(R.string.d90));
                        break;
                    }
                    break;
                case 5:
                    cancelNotification(aVar.field_downloadUrl);
                    AppMethodBeat.o(136081);
                    return;
                default:
                    cancelNotification(aVar.field_downloadUrl);
                    AppMethodBeat.o(136081);
                    return;
            }
            synchronized (lock) {
                try {
                    Integer num = (Integer) kOF.get(aVar.field_downloadUrl);
                    if (num == null) {
                        kOF.put(aVar.field_downloadUrl, Integer.valueOf(((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(bt.build())));
                    } else {
                        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().notify(num.intValue(), bt.build());
                    }
                    if (aVar.field_status == 4) {
                        kOF.remove(aVar.field_downloadUrl);
                        kOE.remove(aVar.field_downloadUrl);
                    }
                } finally {
                    AppMethodBeat.o(136081);
                }
            }
        } else {
            ab.i("MicroMsg.DownloadNotificationManager", "updateNotification not from download app");
            AppMethodBeat.o(136081);
        }
    }

    private static void cancelNotification(String str) {
        AppMethodBeat.i(136082);
        synchronized (lock) {
            try {
                Integer num = (Integer) kOF.get(str);
                if (num == null) {
                    ab.i("MicroMsg.DownloadNotificationManager", "No notification id found");
                } else {
                    ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(num.intValue());
                    ab.i("MicroMsg.DownloadNotificationManager", "cancelNotification, id = ".concat(String.valueOf(num)));
                    kOF.remove(str);
                    kOE.remove(str);
                    AppMethodBeat.o(136082);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(136082);
            }
        }
    }

    private static PendingIntent ID(String str) {
        AppMethodBeat.i(136083);
        Intent intent = new Intent(ah.getContext(), DownloadMainUI.class);
        intent.putExtra("appId", str);
        intent.putExtra("view_task", true);
        PendingIntent activity = PendingIntent.getActivity(ah.getContext(), (int) System.currentTimeMillis(), intent, 0);
        AppMethodBeat.o(136083);
        return activity;
    }
}
