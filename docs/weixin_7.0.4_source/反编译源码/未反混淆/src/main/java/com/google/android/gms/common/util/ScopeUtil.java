package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class ScopeUtil {
    private ScopeUtil() {
    }

    public static Set<Scope> fromScopeString(Collection<String> collection) {
        AppMethodBeat.i(90263);
        Preconditions.checkNotNull(collection, "scopeStrings can't be null.");
        Set fromScopeString = fromScopeString((String[]) collection.toArray(new String[collection.size()]));
        AppMethodBeat.o(90263);
        return fromScopeString;
    }

    public static Set<Scope> fromScopeString(String... strArr) {
        AppMethodBeat.i(90264);
        Preconditions.checkNotNull(strArr, "scopeStrings can't be null.");
        HashSet hashSet = new HashSet(strArr.length);
        for (CharSequence charSequence : strArr) {
            if (!TextUtils.isEmpty(charSequence)) {
                hashSet.add(new Scope(charSequence));
            }
        }
        AppMethodBeat.o(90264);
        return hashSet;
    }

    public static String[] toScopeString(Set<Scope> set) {
        AppMethodBeat.i(90266);
        Preconditions.checkNotNull(set, "scopes can't be null.");
        String[] toScopeString = toScopeString((Scope[]) set.toArray(new Scope[set.size()]));
        AppMethodBeat.o(90266);
        return toScopeString;
    }

    public static String[] toScopeString(Scope[] scopeArr) {
        AppMethodBeat.i(90265);
        Preconditions.checkNotNull(scopeArr, "scopes can't be null.");
        String[] strArr = new String[scopeArr.length];
        for (int i = 0; i < scopeArr.length; i++) {
            strArr[i] = scopeArr[i].getScopeUri();
        }
        AppMethodBeat.o(90265);
        return strArr;
    }
}
