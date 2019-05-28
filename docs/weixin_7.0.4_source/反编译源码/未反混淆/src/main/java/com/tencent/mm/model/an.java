package com.tencent.mm.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;

public interface an extends ap {
    void BV();

    String IG();

    void IH();

    void II();

    int a(Notification notification, boolean z);

    Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4);

    Notification a(Notification notification, int i, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4, PendingIntent pendingIntent2, String str5, PendingIntent pendingIntent3, String str6);

    Notification a(PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4);

    void a(int i, Notification notification, boolean z);

    void bv(boolean z);

    void bw(boolean z);

    int c(Notification notification);

    void cancel(int i);

    void cancelNotification(String str);

    void ik(int i);

    void il(int i);

    void jO(String str);

    void k(int i, String str);

    void notify(int i, Notification notification);

    void y(String str, int i);
}
