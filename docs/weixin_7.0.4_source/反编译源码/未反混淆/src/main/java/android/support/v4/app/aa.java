package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

public final class aa {
    final String FU;
    final CharSequence FV;
    final CharSequence[] FW;
    final boolean FX;
    final Set<String> FY;
    final Bundle mExtras;

    public static final class a {
        public final String FU;
        public CharSequence FV;
        public CharSequence[] FW;
        public boolean FX = true;
        public final Set<String> FY = new HashSet();
        public Bundle mExtras = new Bundle();

        public a(String str) {
            this.FU = str;
        }
    }

    public aa(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle, Set<String> set) {
        this.FU = str;
        this.FV = charSequence;
        this.FW = charSequenceArr;
        this.FX = z;
        this.mExtras = bundle;
        this.FY = set;
    }

    static RemoteInput[] b(aa[] aaVarArr) {
        if (aaVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[aaVarArr.length];
        for (int i = 0; i < aaVarArr.length; i++) {
            aa aaVar = aaVarArr[i];
            remoteInputArr[i] = new Builder(aaVar.FU).setLabel(aaVar.FV).setChoices(aaVar.FW).setAllowFreeFormInput(aaVar.FX).addExtras(aaVar.mExtras).build();
        }
        return remoteInputArr;
    }
}
