package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.p057v4.app.Fragment;
import com.google.android.gms.common.api.internal.LifecycleFragment;

public abstract class DialogRedirect implements OnClickListener {
    public static DialogRedirect getInstance(Activity activity, Intent intent, int i) {
        return new zzb(intent, activity, i);
    }

    public static DialogRedirect getInstance(Fragment fragment, Intent intent, int i) {
        return new zzc(intent, fragment, i);
    }

    public static DialogRedirect getInstance(LifecycleFragment lifecycleFragment, Intent intent, int i) {
        return new zzd(intent, lifecycleFragment, i);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            redirect();
        } catch (ActivityNotFoundException e) {
        } finally {
            dialogInterface.dismiss();
        }
    }

    public abstract void redirect();
}
