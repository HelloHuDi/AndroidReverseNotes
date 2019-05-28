package kotlinx.coroutines.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016*\u00020\u0001H\u0001\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"\u0016\u0010\t\u001a\u00020\n8\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003\"\u001c\u0010\f\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u0005\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0010\u001a\u00020\n8\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0003\"\u0016\u0010\u0012\u001a\u00020\n8\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0003*\n\u0010\u0017\"\u00020\u00182\u00020\u0018*\u001c\u0010\u0019\u001a\u0004\b\u0000\u0010\u001a\"\b\u0012\u0004\u0012\u0002H\u001a0\u001b2\b\u0012\u0004\u0012\u0002H\u001a0\u001b*\f\b\u0002\u0010\u001c\"\u00020\u00152\u00020\u0015*\u001c\u0010\u001d\u001a\u0004\b\u0000\u0010\u001a\"\b\u0012\u0004\u0012\u0002H\u001a0\u001e2\b\u0012\u0004\u0012\u0002H\u001a0\u001e¨\u0006\u001f"}, dWq = {"ALREADY_REMOVED", "", "ALREADY_REMOVED$annotations", "()V", "getALREADY_REMOVED", "()Ljava/lang/Object;", "CONDITION_FALSE", "CONDITION_FALSE$annotations", "getCONDITION_FALSE", "FAILURE", "", "FAILURE$annotations", "LIST_EMPTY", "LIST_EMPTY$annotations", "getLIST_EMPTY", "REMOVE_PREPARED", "SUCCESS", "SUCCESS$annotations", "UNDECIDED", "UNDECIDED$annotations", "unwrap", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "AbstractAtomicDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "AddLastDesc", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Node", "RemoveFirstDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "kotlinx-coroutines-core"})
public final class g {
    private static final Object BRl = new m("CONDITION_FALSE");
    private static final Object BRm = new m("ALREADY_REMOVED");
    private static final Object BRn = new m("LIST_EMPTY");
    private static final Object BRo = new m("REMOVE_PREPARED");

    static {
        AppMethodBeat.i(118436);
        AppMethodBeat.o(118436);
    }

    public static final Object elH() {
        return BRl;
    }

    public static final h em(Object obj) {
        h hVar;
        AppMethodBeat.i(118435);
        j.p(obj, "receiver$0");
        l lVar = (l) (!(obj instanceof l) ? null : obj);
        if (lVar != null) {
            h hVar2 = lVar.BRF;
            if (hVar2 != null) {
                hVar = hVar2;
                AppMethodBeat.o(118435);
                return hVar;
            }
        }
        hVar = (h) obj;
        AppMethodBeat.o(118435);
        return hVar;
    }
}
