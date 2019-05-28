package android.support.p057v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.os.Bundle;
import android.support.p057v4.app.C0363v.C0357a;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* renamed from: android.support.v4.app.x */
final class C0366x {
    /* renamed from: FC */
    private static final Object f412FC = new Object();
    /* renamed from: FD */
    private static Field f413FD;
    /* renamed from: FE */
    private static boolean f414FE;
    /* renamed from: FF */
    private static final Object f415FF = new Object();

    /* renamed from: i */
    public static SparseArray<Bundle> m617i(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    /* renamed from: a */
    public static Bundle m615a(Notification notification) {
        synchronized (f412FC) {
            if (f414FE) {
                return null;
            }
            try {
                if (f413FD == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        f413FD = declaredField;
                    } else {
                        f414FE = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) f413FD.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f413FD.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException | NoSuchFieldException e) {
                f414FE = true;
                return null;
            }
        }
    }

    /* renamed from: a */
    private static Bundle[] m616a(C0320aa[] c0320aaArr) {
        if (c0320aaArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[c0320aaArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= c0320aaArr.length) {
                return bundleArr;
            }
            C0320aa c0320aa = c0320aaArr[i2];
            Bundle bundle = new Bundle();
            bundle.putString("resultKey", c0320aa.f271FU);
            bundle.putCharSequence("label", c0320aa.f272FV);
            bundle.putCharSequenceArray("choices", c0320aa.f273FW);
            bundle.putBoolean("allowFreeFormInput", c0320aa.f274FX);
            bundle.putBundle("extras", c0320aa.mExtras);
            Set<String> set = c0320aa.f275FY;
            if (!(set == null || set.isEmpty())) {
                ArrayList arrayList = new ArrayList(set.size());
                for (String add : set) {
                    arrayList.add(add);
                }
                bundle.putStringArrayList("allowedDataTypes", arrayList);
            }
            bundleArr[i2] = bundle;
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    public static Bundle m614a(Builder builder, C0357a c0357a) {
        builder.addAction(c0357a.icon, c0357a.title, c0357a.actionIntent);
        Bundle bundle = new Bundle(c0357a.mExtras);
        if (c0357a.f356EB != null) {
            bundle.putParcelableArray("android.support.remoteInputs", C0366x.m616a(c0357a.f356EB));
        }
        if (c0357a.f357EC != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", C0366x.m616a(c0357a.f357EC));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", c0357a.f358ED);
        return bundle;
    }
}
