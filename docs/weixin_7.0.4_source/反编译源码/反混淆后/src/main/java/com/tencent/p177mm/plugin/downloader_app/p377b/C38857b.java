package com.tencent.p177mm.plugin.downloader_app.p377b;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.p057v4.app.C0363v.C0358c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadPendingReceive;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadService;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p939a.C11498a;
import com.tencent.p177mm.plugin.downloader_app.p380ui.DownloadMainUI;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.downloader_app.b.b */
public final class C38857b {
    private static Map<String, Long> kOE = new HashMap();
    private static Map<String, Integer> kOF = new HashMap();
    private static Object lock = new Object();

    static {
        AppMethodBeat.m2504i(136084);
        AppMethodBeat.m2505o(136084);
    }

    /* renamed from: h */
    public static void m65925h(C42911a c42911a) {
        boolean z = false;
        AppMethodBeat.m2504i(136081);
        if (c42911a == null) {
            C4990ab.m7412e("MicroMsg.DownloadNotificationManager", "updateNotification failed: null task info");
            AppMethodBeat.m2505o(136081);
        } else if (c42911a.field_fromDownloadApp) {
            int i;
            if (c42911a.field_totalSize > 0) {
                i = (int) ((c42911a.field_downloadedSize * 100) / c42911a.field_totalSize);
            } else {
                i = 0;
            }
            C0358c bt = C45186a.m83262bt(C4996ah.getContext(), "reminder_channel_id");
            Long l = (Long) kOE.get(c42911a.field_downloadUrl);
            if (l == null) {
                l = Long.valueOf(System.currentTimeMillis());
                kOE.put(c42911a.field_downloadUrl, l);
            }
            bt.mo626j(l.longValue());
            bt.mo621d(c42911a.field_fileName);
            switch (c42911a.field_status) {
                case 1:
                    bt.mo616as(C45186a.bWV());
                    if (i == 0) {
                        i = 1;
                    }
                    if (i == 0) {
                        z = true;
                    }
                    bt.mo618b(100, i, z);
                    if (c42911a.field_reserveInWifi) {
                        bt.mo623e(C4996ah.getContext().getString(C25738R.string.bsr) + "·" + C4996ah.getContext().getString(C25738R.string.bsp));
                    } else {
                        bt.mo623e(C4996ah.getContext().getString(C25738R.string.bsp));
                    }
                    bt.mo627k(2, true);
                    bt.f362EI = C38857b.m65924ID(c42911a.field_appId);
                    break;
                case 2:
                    C38857b.cancelNotification(c42911a.field_downloadUrl);
                    AppMethodBeat.m2505o(136081);
                    return;
                case 3:
                    C38857b.cancelNotification(c42911a.field_downloadUrl);
                    Context context = C4996ah.getContext();
                    C0358c bt2 = C45186a.m83262bt(context, "reminder_channel_id");
                    bt2.mo621d(c42911a.field_fileName);
                    bt2.mo616as(C45186a.bWV());
                    bt2.mo628z(true);
                    Intent intent = new Intent();
                    Context context2 = C4996ah.getContext();
                    intent.setClass(context2, FileDownloadPendingReceive.class);
                    intent.putExtra(FileDownloadService.kNn, 3);
                    intent.putExtra(FileDownloadService.kNo, c42911a.field_filePath);
                    intent.putExtra(FileDownloadService.kNp, c42911a.field_md5);
                    intent.putExtra("downloadId", c42911a.field_downloadId);
                    bt2.f362EI = PendingIntent.getBroadcast(context2, (int) System.currentTimeMillis(), intent, 0);
                    if (c42911a.field_reserveInWifi) {
                        bt2.mo623e(context.getString(C25738R.string.g71));
                    } else {
                        bt2.mo623e(context.getString(C25738R.string.bso));
                    }
                    ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41577c(bt2.build());
                    AppMethodBeat.m2505o(136081);
                    return;
                case 4:
                    bt.mo616as(C45186a.bWV());
                    bt.mo628z(true);
                    bt.f362EI = C38857b.m65924ID(c42911a.field_appId);
                    if (c42911a.field_errCode != C11498a.kKa && c42911a.field_errCode != C11498a.kJW) {
                        bt.mo623e(C4996ah.getContext().getString(C25738R.string.d8z));
                        break;
                    } else {
                        bt.mo623e(C4996ah.getContext().getString(C25738R.string.d90));
                        break;
                    }
                    break;
                case 5:
                    C38857b.cancelNotification(c42911a.field_downloadUrl);
                    AppMethodBeat.m2505o(136081);
                    return;
                default:
                    C38857b.cancelNotification(c42911a.field_downloadUrl);
                    AppMethodBeat.m2505o(136081);
                    return;
            }
            synchronized (lock) {
                try {
                    Integer num = (Integer) kOF.get(c42911a.field_downloadUrl);
                    if (num == null) {
                        kOF.put(c42911a.field_downloadUrl, Integer.valueOf(((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41577c(bt.build())));
                    } else {
                        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().notify(num.intValue(), bt.build());
                    }
                    if (c42911a.field_status == 4) {
                        kOF.remove(c42911a.field_downloadUrl);
                        kOE.remove(c42911a.field_downloadUrl);
                    }
                } finally {
                    AppMethodBeat.m2505o(136081);
                }
            }
        } else {
            C4990ab.m7416i("MicroMsg.DownloadNotificationManager", "updateNotification not from download app");
            AppMethodBeat.m2505o(136081);
        }
    }

    private static void cancelNotification(String str) {
        AppMethodBeat.m2504i(136082);
        synchronized (lock) {
            try {
                Integer num = (Integer) kOF.get(str);
                if (num == null) {
                    C4990ab.m7416i("MicroMsg.DownloadNotificationManager", "No notification id found");
                } else {
                    ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(num.intValue());
                    C4990ab.m7416i("MicroMsg.DownloadNotificationManager", "cancelNotification, id = ".concat(String.valueOf(num)));
                    kOF.remove(str);
                    kOE.remove(str);
                    AppMethodBeat.m2505o(136082);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(136082);
            }
        }
    }

    /* renamed from: ID */
    private static PendingIntent m65924ID(String str) {
        AppMethodBeat.m2504i(136083);
        Intent intent = new Intent(C4996ah.getContext(), DownloadMainUI.class);
        intent.putExtra("appId", str);
        intent.putExtra("view_task", true);
        PendingIntent activity = PendingIntent.getActivity(C4996ah.getContext(), (int) System.currentTimeMillis(), intent, 0);
        AppMethodBeat.m2505o(136083);
        return activity;
    }
}
