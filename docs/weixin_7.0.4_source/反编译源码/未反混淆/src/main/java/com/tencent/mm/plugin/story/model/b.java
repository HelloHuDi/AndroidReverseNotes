package com.tencent.mm.plugin.story.model;

import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.c;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\u0006\u0010\u0014\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u0018\u0010\u001a\u001a\u00020\u00122\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R2\u0010\u0005\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00040\u0004 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000RJ\u0010\u000b\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\r \u0007*\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f \u0007*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\r \u0007*\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f\u0018\u00010\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R2\u0010\u0010\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00040\u0004 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/story/model/FavourUserChecker;", "Lcom/tencent/mm/plugin/story/api/IFavourUserChecker;", "()V", "TAG", "", "mFavourUserList", "", "kotlin.jvm.PlatformType", "", "mIsChecking", "", "mListeners", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/story/api/IFavourUserNotifyListener;", "mStoryStatus", "", "mValidUserList", "addNotifyListener", "", "listener", "checkFavourUserStory", "getStoryStatus", "getValidUserList", "isStoryExist", "username", "setFavourStoryRead", "updateFavourUserList", "userList", "plugin-story_release"})
public final class b implements com.tencent.mm.plugin.story.api.b {
    private static final String TAG = TAG;
    private static final List<WeakReference<c>> mq = Collections.synchronizedList(new ArrayList());
    private static final List<String> rRW = Collections.synchronizedList(new ArrayList());
    private static final List<String> rRX = Collections.synchronizedList(new ArrayList());
    private static int rRY;
    private static boolean rRZ;
    public static final b rSa = new b();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        public static final a rSb = new a();

        static {
            AppMethodBeat.i(109002);
            AppMethodBeat.o(109002);
        }

        a() {
        }

        public final void run() {
            AppMethodBeat.i(109001);
            b bVar = b.rSa;
            if (b.rRZ) {
                AppMethodBeat.o(109001);
                return;
            }
            int i;
            y yVar;
            bVar = b.rSa;
            b.rRZ = true;
            bVar = b.rSa;
            b.rRX.clear();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            bVar = b.rSa;
            List cxw = b.rRW;
            j.o(cxw, "mFavourUserList");
            Iterable<String> iterable = cxw;
            synchronized (iterable) {
                try {
                    i = 0;
                    for (String str : iterable) {
                        com.tencent.mm.plugin.story.model.f.a aVar = f.rSp;
                        b bVar2;
                        if (com.tencent.mm.plugin.story.model.f.a.isStoryUnread(str)) {
                            bVar2 = b.rSa;
                            ab.d(b.TAG, "%s has new story", str);
                            i |= 1;
                            arrayList2.add(str);
                        } else {
                            bVar2 = b.rSa;
                            j.o(str, "username");
                            if (b.aal(str)) {
                                bVar2 = b.rSa;
                                ab.d(b.TAG, "%s has story", str);
                                i |= 2;
                                arrayList.add(str);
                            }
                            i = i;
                        }
                    }
                    yVar = y.AUy;
                } finally {
                    AppMethodBeat.o(109001);
                }
            }
            bVar = b.rSa;
            if (b.rRY != i) {
                bVar = b.rSa;
                b.rRY = i;
            }
            bVar = b.rSa;
            b.rRX.addAll(arrayList2);
            bVar = b.rSa;
            b.rRX.addAll(arrayList);
            arrayList = new ArrayList();
            bVar = b.rSa;
            cxw = b.mq;
            j.o(cxw, "mListeners");
            Iterable<WeakReference> iterable2 = cxw;
            synchronized (iterable2) {
                try {
                    for (WeakReference weakReference : iterable2) {
                        if (((c) weakReference.get()) == null) {
                            arrayList.add(weakReference);
                        } else {
                            c cVar = (c) weakReference.get();
                            if (cVar != null) {
                                b bVar3 = b.rSa;
                                cVar.EH(b.rRY);
                            }
                        }
                    }
                    yVar = y.AUy;
                } catch (Throwable th) {
                    AppMethodBeat.o(109001);
                }
            }
            bVar = b.rSa;
            b.mq.removeAll(arrayList);
            bVar = b.rSa;
            b.rRZ = false;
            bVar = b.rSa;
            r3 = new Object[2];
            b bVar4 = b.rSa;
            r3[0] = Integer.valueOf(b.rRY);
            r3[1] = Integer.valueOf(i);
            ab.i(b.TAG, "checkStoryStatus:%s nowState:%s", r3);
        }
    }

    static {
        AppMethodBeat.i(109008);
        AppMethodBeat.o(109008);
    }

    private b() {
    }

    public static void cxt() {
        AppMethodBeat.i(109003);
        d.post(a.rSb, "FavourUserChecker_StoryStateChecker");
        AppMethodBeat.o(109003);
    }

    public final void dE(List<String> list) {
        AppMethodBeat.i(109004);
        rRW.clear();
        rRW.addAll(list);
        cxt();
        AppMethodBeat.o(109004);
    }

    public final int cwR() {
        return rRY;
    }

    public final void cwS() {
        AppMethodBeat.i(109005);
        ab.i(TAG, "setFavourStoryRead:%s", Integer.valueOf(rRY));
        if (rRY != 0) {
            rRY = 2;
        }
        AppMethodBeat.o(109005);
    }

    public final List<String> cwT() {
        AppMethodBeat.i(109006);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(rRX);
        List list = arrayList;
        AppMethodBeat.o(109006);
        return list;
    }

    public final void b(WeakReference<c> weakReference) {
        AppMethodBeat.i(109007);
        if (!mq.contains(weakReference)) {
            mq.add(weakReference);
        }
        AppMethodBeat.o(109007);
    }

    public static final /* synthetic */ boolean aal(String str) {
        AppMethodBeat.i(109009);
        if (!n.isShowStoryCheck()) {
            AppMethodBeat.o(109009);
            return false;
        } else if (str == null) {
            AppMethodBeat.o(109009);
            return false;
        } else {
            com.tencent.mm.plugin.story.model.n.a aVar = n.rTi;
            boolean dl = com.tencent.mm.plugin.story.model.n.a.dl(str, ((int) bo.anT()) - 86400);
            AppMethodBeat.o(109009);
            return dl;
        }
    }
}
