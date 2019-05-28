package com.tencent.mm.plugin.sns.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a {
    private static boolean bZi = false;
    private static c<ro> ecA = new c<ro>() {
        {
            AppMethodBeat.i(35864);
            this.xxI = ro.class.getName().hashCode();
            AppMethodBeat.o(35864);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(35865);
            ro roVar = (ro) bVar;
            if (roVar.cNw == null || !roVar.cNw.cNx || TextUtils.isEmpty(roVar.cNw.username)) {
                AppMethodBeat.o(35865);
            } else {
                if (roVar.cNw.cNz) {
                    a.qGk.add(roVar.cNw.username);
                } else {
                    a.qGk.remove(roVar.cNw.username);
                }
                AppMethodBeat.o(35865);
            }
            return false;
        }
    };
    private static final List<String> qGk = Collections.synchronizedList(new LinkedList());

    static {
        AppMethodBeat.i(35872);
        AppMethodBeat.o(35872);
    }

    public static void init() {
        AppMethodBeat.i(35866);
        ecA.dnU();
        AppMethodBeat.o(35866);
    }

    public static void destroy() {
        AppMethodBeat.i(35867);
        ecA.dead();
        AppMethodBeat.o(35867);
    }

    public static boolean Xt(String str) {
        AppMethodBeat.i(35868);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(35868);
            return false;
        } else if (str.equals(g.RP().Ry().get(2, null))) {
            AppMethodBeat.o(35868);
            return false;
        } else if (Xv(str)) {
            AppMethodBeat.o(35868);
            return false;
        } else {
            boolean isStoryUnread = ((e) g.M(e.class)).isStoryUnread(str);
            AppMethodBeat.o(35868);
            return isStoryUnread;
        }
    }

    public static boolean Xu(String str) {
        AppMethodBeat.i(35869);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(35869);
            return false;
        } else if (Xv(str)) {
            AppMethodBeat.o(35869);
            return false;
        } else if (((e) g.M(e.class)).isStoryExist(str) || ((e) g.M(e.class)).isStoryUnread(str)) {
            AppMethodBeat.o(35869);
            return true;
        } else {
            AppMethodBeat.o(35869);
            return false;
        }
    }

    public static boolean Xv(String str) {
        AppMethodBeat.i(35870);
        boolean contains = cmt().contains(str);
        AppMethodBeat.o(35870);
        return contains;
    }

    public static List<String> cmt() {
        AppMethodBeat.i(35871);
        if (bZi) {
            List list = qGk;
            AppMethodBeat.o(35871);
            return list;
        }
        t kF = af.cnL().kF(5);
        List<String> linkedList;
        if (bo.isNullOrNil(kF.field_memberList)) {
            linkedList = new LinkedList();
            AppMethodBeat.o(35871);
            return linkedList;
        }
        ArrayList P = bo.P(kF.field_memberList.split(","));
        if (P == null) {
            linkedList = new LinkedList();
            AppMethodBeat.o(35871);
            return linkedList;
        }
        qGk.addAll(P);
        bZi = true;
        linkedList = qGk;
        AppMethodBeat.o(35871);
        return linkedList;
    }
}
