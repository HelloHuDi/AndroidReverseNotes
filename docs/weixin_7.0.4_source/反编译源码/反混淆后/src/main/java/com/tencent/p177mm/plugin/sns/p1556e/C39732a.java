package com.tencent.p177mm.plugin.sns.p1556e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C18384ro;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.storage.C13479t;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.e.a */
public final class C39732a {
    private static boolean bZi = false;
    private static C4884c<C18384ro> ecA = new C397331();
    private static final List<String> qGk = Collections.synchronizedList(new LinkedList());

    /* renamed from: com.tencent.mm.plugin.sns.e.a$1 */
    static class C397331 extends C4884c<C18384ro> {
        C397331() {
            AppMethodBeat.m2504i(35864);
            this.xxI = C18384ro.class.getName().hashCode();
            AppMethodBeat.m2505o(35864);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(35865);
            C18384ro c18384ro = (C18384ro) c4883b;
            if (c18384ro.cNw == null || !c18384ro.cNw.cNx || TextUtils.isEmpty(c18384ro.cNw.username)) {
                AppMethodBeat.m2505o(35865);
            } else {
                if (c18384ro.cNw.cNz) {
                    C39732a.qGk.add(c18384ro.cNw.username);
                } else {
                    C39732a.qGk.remove(c18384ro.cNw.username);
                }
                AppMethodBeat.m2505o(35865);
            }
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(35872);
        AppMethodBeat.m2505o(35872);
    }

    public static void init() {
        AppMethodBeat.m2504i(35866);
        ecA.dnU();
        AppMethodBeat.m2505o(35866);
    }

    public static void destroy() {
        AppMethodBeat.m2504i(35867);
        ecA.dead();
        AppMethodBeat.m2505o(35867);
    }

    /* renamed from: Xt */
    public static boolean m67943Xt(String str) {
        AppMethodBeat.m2504i(35868);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(35868);
            return false;
        } else if (str.equals(C1720g.m3536RP().mo5239Ry().get(2, null))) {
            AppMethodBeat.m2505o(35868);
            return false;
        } else if (C39732a.m67945Xv(str)) {
            AppMethodBeat.m2505o(35868);
            return false;
        } else {
            boolean isStoryUnread = ((C35168e) C1720g.m3530M(C35168e.class)).isStoryUnread(str);
            AppMethodBeat.m2505o(35868);
            return isStoryUnread;
        }
    }

    /* renamed from: Xu */
    public static boolean m67944Xu(String str) {
        AppMethodBeat.m2504i(35869);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(35869);
            return false;
        } else if (C39732a.m67945Xv(str)) {
            AppMethodBeat.m2505o(35869);
            return false;
        } else if (((C35168e) C1720g.m3530M(C35168e.class)).isStoryExist(str) || ((C35168e) C1720g.m3530M(C35168e.class)).isStoryUnread(str)) {
            AppMethodBeat.m2505o(35869);
            return true;
        } else {
            AppMethodBeat.m2505o(35869);
            return false;
        }
    }

    /* renamed from: Xv */
    public static boolean m67945Xv(String str) {
        AppMethodBeat.m2504i(35870);
        boolean contains = C39732a.cmt().contains(str);
        AppMethodBeat.m2505o(35870);
        return contains;
    }

    public static List<String> cmt() {
        AppMethodBeat.m2504i(35871);
        if (bZi) {
            List list = qGk;
            AppMethodBeat.m2505o(35871);
            return list;
        }
        C13479t kF = C13373af.cnL().mo55579kF(5);
        List<String> linkedList;
        if (C5046bo.isNullOrNil(kF.field_memberList)) {
            linkedList = new LinkedList();
            AppMethodBeat.m2505o(35871);
            return linkedList;
        }
        ArrayList P = C5046bo.m7508P(kF.field_memberList.split(","));
        if (P == null) {
            linkedList = new LinkedList();
            AppMethodBeat.m2505o(35871);
            return linkedList;
        }
        qGk.addAll(P);
        bZi = true;
        linkedList = qGk;
        AppMethodBeat.m2505o(35871);
        return linkedList;
    }
}
