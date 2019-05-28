package com.tencent.p177mm.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;

/* renamed from: com.tencent.mm.model.an */
public interface C24672an extends C18610ap {
    /* renamed from: BV */
    void mo41566BV();

    /* renamed from: IG */
    String mo41567IG();

    /* renamed from: IH */
    void mo41568IH();

    /* renamed from: II */
    void mo41569II();

    /* renamed from: a */
    int mo41570a(Notification notification, boolean z);

    /* renamed from: a */
    Notification mo41571a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4);

    /* renamed from: a */
    Notification mo41572a(Notification notification, int i, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4, PendingIntent pendingIntent2, String str5, PendingIntent pendingIntent3, String str6);

    /* renamed from: a */
    Notification mo41573a(PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4);

    /* renamed from: a */
    void mo41574a(int i, Notification notification, boolean z);

    /* renamed from: bv */
    void mo41575bv(boolean z);

    /* renamed from: bw */
    void mo41576bw(boolean z);

    /* renamed from: c */
    int mo41577c(Notification notification);

    void cancel(int i);

    void cancelNotification(String str);

    /* renamed from: ik */
    void mo41580ik(int i);

    /* renamed from: il */
    void mo41581il(int i);

    /* renamed from: jO */
    void mo41582jO(String str);

    /* renamed from: k */
    void mo41583k(int i, String str);

    void notify(int i, Notification notification);

    /* renamed from: y */
    void mo41584y(String str, int i);
}
