package com.tencent.p177mm.emoji.p228d;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.HashMap;
import java.util.HashSet;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\tJ\u0016\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000RJ\u0010\u0005\u001a>\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n0\u0006j\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/emoji/upload/EmojiCaptureCallbackDispatcher;", "", "()V", "TAG", "", "callbackMap", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureCallback;", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "broadcastResult", "", "timeEnter", "success", "", "md5", "dispatch", "registerCallback", "callback", "unregisterCallback", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.d.b */
public final class C41949b {
    private static final String TAG = TAG;
    private static final HashMap<Long, HashSet<C26074a>> ezU = new HashMap();
    public static final C41949b ezV = new C41949b();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.d.b$a */
    static final class C1512a extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ boolean eyb;
        final /* synthetic */ long ezW;
        final /* synthetic */ String ezX;

        C1512a(long j, boolean z, String str) {
            this.ezW = j;
            this.eyb = z;
            this.ezX = str;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(63288);
            C41949b c41949b = C41949b.ezV;
            HashSet<C26074a> hashSet = (HashSet) C41949b.ezU.get(Long.valueOf(this.ezW));
            if (hashSet != null) {
                for (C26074a a : hashSet) {
                    a.mo43943a(this.ezW, this.eyb, this.ezX);
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63288);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.d.b$c */
    static final class C1513c extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ long ezW;
        final /* synthetic */ C26074a ezY;

        C1513c(long j, C26074a c26074a) {
            this.ezW = j;
            this.ezY = c26074a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(63290);
            C41949b c41949b = C41949b.ezV;
            HashSet hashSet = (HashSet) C41949b.ezU.get(Long.valueOf(this.ezW));
            if (hashSet != null) {
                hashSet.remove(this.ezY);
                if (hashSet.isEmpty()) {
                    c41949b = C41949b.ezV;
                    C41949b.ezU.remove(Long.valueOf(this.ezW));
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63290);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.d.b$b */
    static final class C9271b extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ long ezW;
        final /* synthetic */ C26074a ezY;

        C9271b(long j, C26074a c26074a) {
            this.ezW = j;
            this.ezY = c26074a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(63289);
            C41949b c41949b = C41949b.ezV;
            HashSet hashSet = (HashSet) C41949b.ezU.get(Long.valueOf(this.ezW));
            if (hashSet == null) {
                HashSet hashSet2 = new HashSet();
                c41949b = C41949b.ezV;
                C41949b.ezU.put(Long.valueOf(this.ezW), hashSet2);
                hashSet = hashSet2;
            }
            hashSet.add(this.ezY);
            C41949b c41949b2 = C41949b.ezV;
            C4990ab.m7416i(C41949b.TAG, "registerCallback: " + hashSet.size());
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63289);
            return c37091y;
        }
    }

    static {
        AppMethodBeat.m2504i(63294);
        AppMethodBeat.m2505o(63294);
    }

    private C41949b() {
    }

    /* renamed from: a */
    public static void m74082a(long j, C26074a c26074a) {
        AppMethodBeat.m2504i(63291);
        C25052j.m39376p(c26074a, "callback");
        C8902b.m16042a(new C9271b(j, c26074a));
        AppMethodBeat.m2505o(63291);
    }

    /* renamed from: b */
    public static void m74083b(long j, C26074a c26074a) {
        AppMethodBeat.m2504i(63292);
        C25052j.m39376p(c26074a, "callback");
        C8902b.m16042a(new C1513c(j, c26074a));
        AppMethodBeat.m2505o(63292);
    }

    /* renamed from: b */
    public static void m74084b(long j, boolean z, String str) {
        AppMethodBeat.m2504i(63293);
        C4990ab.m7416i(TAG, "dispatch: " + j + ", " + z + ", " + str);
        C8902b.m16042a(new C1512a(j, z, str));
        C1681g Rn = C1720g.m3533RM().mo5224Rn();
        C25052j.m39375o(Rn, "MMKernel.process().current()");
        if (((C6624h) Rn).mo5181SG()) {
            Intent intent = new Intent("com.tencent.mm.Emoji_Capture_Upload");
            intent.putExtra("upload_time_enter", j);
            intent.putExtra("upload_success", z);
            intent.putExtra("upload_md5", str);
            C4996ah.getContext().sendBroadcast(intent);
        }
        AppMethodBeat.m2505o(63293);
    }
}
