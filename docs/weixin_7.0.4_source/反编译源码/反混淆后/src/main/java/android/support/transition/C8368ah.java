package android.support.transition;

import android.view.View;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: android.support.transition.ah */
public final class C8368ah {
    /* renamed from: AD */
    final ArrayList<Transition> f2315AD = new ArrayList();
    public final Map<String, Object> values = new HashMap();
    public View view;

    public final boolean equals(Object obj) {
        if ((obj instanceof C8368ah) && this.view == ((C8368ah) obj).view && this.values.equals(((C8368ah) obj).values)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.view.hashCode() * 31) + this.values.hashCode();
    }

    public final String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.view + IOUtils.LINE_SEPARATOR_UNIX) + "    values:";
        Iterator it = this.values.keySet().iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            str = (String) it.next();
            str = str2 + "    " + str + ": " + this.values.get(str) + IOUtils.LINE_SEPARATOR_UNIX;
        }
    }
}
