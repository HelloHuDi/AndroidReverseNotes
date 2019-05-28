package com.tencent.mm.emoji.d;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import java.util.HashSet;

@l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\tJ\u0016\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000RJ\u0010\u0005\u001a>\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n0\u0006j\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/emoji/upload/EmojiCaptureCallbackDispatcher;", "", "()V", "TAG", "", "callbackMap", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureCallback;", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "broadcastResult", "", "timeEnter", "success", "", "md5", "dispatch", "registerCallback", "callback", "unregisterCallback", "plugin-emojisdk_release"})
public final class b {
    private static final String TAG = TAG;
    private static final HashMap<Long, HashSet<a>> ezU = new HashMap();
    public static final b ezV = new b();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class a extends k implements a.f.a.a<y> {
        final /* synthetic */ boolean eyb;
        final /* synthetic */ long ezW;
        final /* synthetic */ String ezX;

        a(long j, boolean z, String str) {
            this.ezW = j;
            this.eyb = z;
            this.ezX = str;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(63288);
            b bVar = b.ezV;
            HashSet<a> hashSet = (HashSet) b.ezU.get(Long.valueOf(this.ezW));
            if (hashSet != null) {
                for (a a : hashSet) {
                    a.a(this.ezW, this.eyb, this.ezX);
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(63288);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class c extends k implements a.f.a.a<y> {
        final /* synthetic */ long ezW;
        final /* synthetic */ a ezY;

        c(long j, a aVar) {
            this.ezW = j;
            this.ezY = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(63290);
            b bVar = b.ezV;
            HashSet hashSet = (HashSet) b.ezU.get(Long.valueOf(this.ezW));
            if (hashSet != null) {
                hashSet.remove(this.ezY);
                if (hashSet.isEmpty()) {
                    bVar = b.ezV;
                    b.ezU.remove(Long.valueOf(this.ezW));
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(63290);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class b extends k implements a.f.a.a<y> {
        final /* synthetic */ long ezW;
        final /* synthetic */ a ezY;

        b(long j, a aVar) {
            this.ezW = j;
            this.ezY = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(63289);
            b bVar = b.ezV;
            HashSet hashSet = (HashSet) b.ezU.get(Long.valueOf(this.ezW));
            if (hashSet == null) {
                HashSet hashSet2 = new HashSet();
                bVar = b.ezV;
                b.ezU.put(Long.valueOf(this.ezW), hashSet2);
                hashSet = hashSet2;
            }
            hashSet.add(this.ezY);
            b bVar2 = b.ezV;
            ab.i(b.TAG, "registerCallback: " + hashSet.size());
            y yVar = y.AUy;
            AppMethodBeat.o(63289);
            return yVar;
        }
    }

    static {
        AppMethodBeat.i(63294);
        AppMethodBeat.o(63294);
    }

    private b() {
    }

    public static void a(long j, a aVar) {
        AppMethodBeat.i(63291);
        j.p(aVar, "callback");
        com.tencent.mm.ab.b.a(new b(j, aVar));
        AppMethodBeat.o(63291);
    }

    public static void b(long j, a aVar) {
        AppMethodBeat.i(63292);
        j.p(aVar, "callback");
        com.tencent.mm.ab.b.a(new c(j, aVar));
        AppMethodBeat.o(63292);
    }

    public static void b(long j, boolean z, String str) {
        AppMethodBeat.i(63293);
        ab.i(TAG, "dispatch: " + j + ", " + z + ", " + str);
        com.tencent.mm.ab.b.a(new a(j, z, str));
        g Rn = com.tencent.mm.kernel.g.RM().Rn();
        j.o(Rn, "MMKernel.process().current()");
        if (((h) Rn).SG()) {
            Intent intent = new Intent("com.tencent.mm.Emoji_Capture_Upload");
            intent.putExtra("upload_time_enter", j);
            intent.putExtra("upload_success", z);
            intent.putExtra("upload_md5", str);
            ah.getContext().sendBroadcast(intent);
        }
        AppMethodBeat.o(63293);
    }
}
