package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.os.Bundle;
import android.support.v4.app.v.a;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

final class x {
    private static final Object FC = new Object();
    private static Field FD;
    private static boolean FE;
    private static final Object FF = new Object();

    public static SparseArray<Bundle> i(List<Bundle> list) {
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

    public static Bundle a(Notification notification) {
        synchronized (FC) {
            if (FE) {
                return null;
            }
            try {
                if (FD == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        FD = declaredField;
                    } else {
                        FE = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) FD.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    FD.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException | NoSuchFieldException e) {
                FE = true;
                return null;
            }
        }
    }

    private static Bundle[] a(aa[] aaVarArr) {
        if (aaVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[aaVarArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aaVarArr.length) {
                return bundleArr;
            }
            aa aaVar = aaVarArr[i2];
            Bundle bundle = new Bundle();
            bundle.putString("resultKey", aaVar.FU);
            bundle.putCharSequence("label", aaVar.FV);
            bundle.putCharSequenceArray("choices", aaVar.FW);
            bundle.putBoolean("allowFreeFormInput", aaVar.FX);
            bundle.putBundle("extras", aaVar.mExtras);
            Set<String> set = aaVar.FY;
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

    public static Bundle a(Builder builder, a aVar) {
        builder.addAction(aVar.icon, aVar.title, aVar.actionIntent);
        Bundle bundle = new Bundle(aVar.mExtras);
        if (aVar.EB != null) {
            bundle.putParcelableArray("android.support.remoteInputs", a(aVar.EB));
        }
        if (aVar.EC != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", a(aVar.EC));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.ED);
        return bundle;
    }
}
