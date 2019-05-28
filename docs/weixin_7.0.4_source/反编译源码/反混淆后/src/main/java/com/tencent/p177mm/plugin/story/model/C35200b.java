package com.tencent.p177mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.story.api.C4107b;
import com.tencent.p177mm.plugin.story.api.C4108c;
import com.tencent.p177mm.plugin.story.api.C46270n;
import com.tencent.p177mm.plugin.story.model.C13785f.C13786a;
import com.tencent.p177mm.plugin.story.model.C29310n.C29311a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\u0006\u0010\u0014\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u0018\u0010\u001a\u001a\u00020\u00122\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R2\u0010\u0005\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00040\u0004 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000RJ\u0010\u000b\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\r \u0007*\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f \u0007*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\r \u0007*\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f\u0018\u00010\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R2\u0010\u0010\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00040\u0004 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/story/model/FavourUserChecker;", "Lcom/tencent/mm/plugin/story/api/IFavourUserChecker;", "()V", "TAG", "", "mFavourUserList", "", "kotlin.jvm.PlatformType", "", "mIsChecking", "", "mListeners", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/story/api/IFavourUserNotifyListener;", "mStoryStatus", "", "mValidUserList", "addNotifyListener", "", "listener", "checkFavourUserStory", "getStoryStatus", "getValidUserList", "isStoryExist", "username", "setFavourStoryRead", "updateFavourUserList", "userList", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.b */
public final class C35200b implements C4107b {
    private static final String TAG = TAG;
    /* renamed from: mq */
    private static final List<WeakReference<C4108c>> f15067mq = Collections.synchronizedList(new ArrayList());
    private static final List<String> rRW = Collections.synchronizedList(new ArrayList());
    private static final List<String> rRX = Collections.synchronizedList(new ArrayList());
    private static int rRY;
    private static boolean rRZ;
    public static final C35200b rSa = new C35200b();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.model.b$a */
    static final class C29302a implements Runnable {
        public static final C29302a rSb = new C29302a();

        static {
            AppMethodBeat.m2504i(109002);
            AppMethodBeat.m2505o(109002);
        }

        C29302a() {
        }

        public final void run() {
            AppMethodBeat.m2504i(109001);
            C35200b c35200b = C35200b.rSa;
            if (C35200b.rRZ) {
                AppMethodBeat.m2505o(109001);
                return;
            }
            int i;
            C37091y c37091y;
            c35200b = C35200b.rSa;
            C35200b.rRZ = true;
            c35200b = C35200b.rSa;
            C35200b.rRX.clear();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            c35200b = C35200b.rSa;
            List cxw = C35200b.rRW;
            C25052j.m39375o(cxw, "mFavourUserList");
            Iterable<String> iterable = cxw;
            synchronized (iterable) {
                try {
                    i = 0;
                    for (String str : iterable) {
                        C13786a c13786a = C13785f.rSp;
                        C35200b c35200b2;
                        if (C13786a.isStoryUnread(str)) {
                            c35200b2 = C35200b.rSa;
                            C4990ab.m7411d(C35200b.TAG, "%s has new story", str);
                            i |= 1;
                            arrayList2.add(str);
                        } else {
                            c35200b2 = C35200b.rSa;
                            C25052j.m39375o(str, "username");
                            if (C35200b.aal(str)) {
                                c35200b2 = C35200b.rSa;
                                C4990ab.m7411d(C35200b.TAG, "%s has story", str);
                                i |= 2;
                                arrayList.add(str);
                            }
                            i = i;
                        }
                    }
                    c37091y = C37091y.AUy;
                } finally {
                    AppMethodBeat.m2505o(109001);
                }
            }
            c35200b = C35200b.rSa;
            if (C35200b.rRY != i) {
                c35200b = C35200b.rSa;
                C35200b.rRY = i;
            }
            c35200b = C35200b.rSa;
            C35200b.rRX.addAll(arrayList2);
            c35200b = C35200b.rSa;
            C35200b.rRX.addAll(arrayList);
            arrayList = new ArrayList();
            c35200b = C35200b.rSa;
            cxw = C35200b.f15067mq;
            C25052j.m39375o(cxw, "mListeners");
            Iterable<WeakReference> iterable2 = cxw;
            synchronized (iterable2) {
                try {
                    for (WeakReference weakReference : iterable2) {
                        if (((C4108c) weakReference.get()) == null) {
                            arrayList.add(weakReference);
                        } else {
                            C4108c c4108c = (C4108c) weakReference.get();
                            if (c4108c != null) {
                                C35200b c35200b3 = C35200b.rSa;
                                c4108c.mo8984EH(C35200b.rRY);
                            }
                        }
                    }
                    c37091y = C37091y.AUy;
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(109001);
                }
            }
            c35200b = C35200b.rSa;
            C35200b.f15067mq.removeAll(arrayList);
            c35200b = C35200b.rSa;
            C35200b.rRZ = false;
            c35200b = C35200b.rSa;
            r3 = new Object[2];
            C35200b c35200b4 = C35200b.rSa;
            r3[0] = Integer.valueOf(C35200b.rRY);
            r3[1] = Integer.valueOf(i);
            C4990ab.m7417i(C35200b.TAG, "checkStoryStatus:%s nowState:%s", r3);
        }
    }

    static {
        AppMethodBeat.m2504i(109008);
        AppMethodBeat.m2505o(109008);
    }

    private C35200b() {
    }

    public static void cxt() {
        AppMethodBeat.m2504i(109003);
        C7305d.post(C29302a.rSb, "FavourUserChecker_StoryStateChecker");
        AppMethodBeat.m2505o(109003);
    }

    /* renamed from: dE */
    public final void mo8983dE(List<String> list) {
        AppMethodBeat.m2504i(109004);
        rRW.clear();
        rRW.addAll(list);
        C35200b.cxt();
        AppMethodBeat.m2505o(109004);
    }

    public final int cwR() {
        return rRY;
    }

    public final void cwS() {
        AppMethodBeat.m2504i(109005);
        C4990ab.m7417i(TAG, "setFavourStoryRead:%s", Integer.valueOf(rRY));
        if (rRY != 0) {
            rRY = 2;
        }
        AppMethodBeat.m2505o(109005);
    }

    public final List<String> cwT() {
        AppMethodBeat.m2504i(109006);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(rRX);
        List list = arrayList;
        AppMethodBeat.m2505o(109006);
        return list;
    }

    /* renamed from: b */
    public final void mo8979b(WeakReference<C4108c> weakReference) {
        AppMethodBeat.m2504i(109007);
        if (!f15067mq.contains(weakReference)) {
            f15067mq.add(weakReference);
        }
        AppMethodBeat.m2505o(109007);
    }

    public static final /* synthetic */ boolean aal(String str) {
        AppMethodBeat.m2504i(109009);
        if (!C46270n.isShowStoryCheck()) {
            AppMethodBeat.m2505o(109009);
            return false;
        } else if (str == null) {
            AppMethodBeat.m2505o(109009);
            return false;
        } else {
            C29311a c29311a = C29310n.rTi;
            boolean dl = C29311a.m46536dl(str, ((int) C5046bo.anT()) - 86400);
            AppMethodBeat.m2505o(109009);
            return dl;
        }
    }
}
