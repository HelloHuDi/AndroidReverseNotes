package android.support.p057v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* renamed from: android.support.v4.app.aa */
public final class C0320aa {
    /* renamed from: FU */
    final String f271FU;
    /* renamed from: FV */
    final CharSequence f272FV;
    /* renamed from: FW */
    final CharSequence[] f273FW;
    /* renamed from: FX */
    final boolean f274FX;
    /* renamed from: FY */
    final Set<String> f275FY;
    final Bundle mExtras;

    /* renamed from: android.support.v4.app.aa$a */
    public static final class C0319a {
        /* renamed from: FU */
        public final String f266FU;
        /* renamed from: FV */
        public CharSequence f267FV;
        /* renamed from: FW */
        public CharSequence[] f268FW;
        /* renamed from: FX */
        public boolean f269FX = true;
        /* renamed from: FY */
        public final Set<String> f270FY = new HashSet();
        public Bundle mExtras = new Bundle();

        public C0319a(String str) {
            this.f266FU = str;
        }
    }

    public C0320aa(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle, Set<String> set) {
        this.f271FU = str;
        this.f272FV = charSequence;
        this.f273FW = charSequenceArr;
        this.f274FX = z;
        this.mExtras = bundle;
        this.f275FY = set;
    }

    /* renamed from: b */
    static RemoteInput[] m514b(C0320aa[] c0320aaArr) {
        if (c0320aaArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[c0320aaArr.length];
        for (int i = 0; i < c0320aaArr.length; i++) {
            C0320aa c0320aa = c0320aaArr[i];
            remoteInputArr[i] = new Builder(c0320aa.f271FU).setLabel(c0320aa.f272FV).setChoices(c0320aa.f273FW).setAllowFreeFormInput(c0320aa.f274FX).addExtras(c0320aa.mExtras).build();
        }
        return remoteInputArr;
    }
}
