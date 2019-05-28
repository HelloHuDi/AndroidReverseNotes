package kotlinx.coroutines;

import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.C41157bc.C16454a;
import kotlinx.coroutines.p700a.C24580l;
import kotlinx.coroutines.p700a.C31179h;
import kotlinx.coroutines.p700a.C31179h.C6095a;
import kotlinx.coroutines.p700a.C31184k;
import kotlinx.coroutines.p700a.C41150g;
import kotlinx.coroutines.p700a.C44607e;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.C7993b;
import p000a.p002c.C41366e;
import p000a.p002c.C41366e.C36928c;
import p000a.p002c.C41366e.C41367b;
import p000a.p002c.C41366e.C41367b.C17124a;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0006¤\u0001¥\u0001¦\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u0002002\n\u00101\u001a\u0006\u0012\u0002\b\u000302H\u0002J\u000e\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\u0002J\u0015\u00105\u001a\u0004\u0018\u00010\nH@ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u0013\u00108\u001a\u0004\u0018\u00010\nH@ø\u0001\u0000¢\u0006\u0002\u00107J\b\u00109\u001a\u00020:H\u0016J\u0012\u00109\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010<\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010=\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010>\u001a\u00020\u00062\u0006\u0010;\u001a\u00020'H\u0002J\u0010\u0010?\u001a\u00020\u00062\u0006\u0010;\u001a\u00020'H\u0016J*\u0010@\u001a\u00020:2\u0006\u0010#\u001a\u00020+2\b\u0010A\u001a\u0004\u0018\u00010\n2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0006H\u0002J\"\u0010E\u001a\u00020:2\u0006\u0010#\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010J\u001a\u00020'2\b\u0010;\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010K\u001a\u00020LH\u0002J\u0012\u0010M\u001a\u0004\u0018\u00010H2\u0006\u0010#\u001a\u00020+H\u0002J\n\u0010N\u001a\u00060Oj\u0002`PJ\b\u0010Q\u001a\u00020'H\u0016J\u000f\u0010R\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\bSJ\n\u0010T\u001a\u0004\u0018\u00010'H\u0004J\b\u0010U\u001a\u0004\u0018\u00010'J \u0010V\u001a\u0004\u0018\u00010'2\u0006\u0010#\u001a\u00020F2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020'0XH\u0002J\u0012\u0010Y\u001a\u0004\u0018\u0001002\u0006\u0010#\u001a\u00020+H\u0002J\u0010\u0010Z\u001a\u00020:2\u0006\u0010[\u001a\u00020'H\u0014J\u0015\u0010\\\u001a\u00020:2\u0006\u0010[\u001a\u00020'H\u0010¢\u0006\u0002\b]J\u0017\u0010^\u001a\u00020:2\b\u0010_\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\b`J?\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u00062\u0006\u0010d\u001a\u00020\u00062'\u0010e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\bg\u0012\b\bh\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020:0fj\u0002`iJ/\u0010a\u001a\u00020b2'\u0010e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\bg\u0012\b\bh\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020:0fj\u0002`iJ\u0011\u0010j\u001a\u00020:H@ø\u0001\u0000¢\u0006\u0002\u00107J\b\u0010k\u001a\u00020\u0006H\u0002J\u0011\u0010l\u001a\u00020:H@ø\u0001\u0000¢\u0006\u0002\u00107J\u001f\u0010m\u001a\u00020n2\u0014\u0010o\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020:0fH\bJ\u0012\u0010p\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010\nH\u0002J\u0017\u0010q\u001a\u00020\u00062\b\u0010I\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\brJ\u001f\u0010s\u001a\u00020\u00062\b\u0010I\u001a\u0004\u0018\u00010\n2\u0006\u0010B\u001a\u00020CH\u0000¢\u0006\u0002\btJ=\u0010u\u001a\u0006\u0012\u0002\b\u0003022'\u0010e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\bg\u0012\b\bh\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020:0fj\u0002`i2\u0006\u0010c\u001a\u00020\u0006H\u0002J\r\u0010v\u001a\u00020wH\u0010¢\u0006\u0002\bxJ\u0018\u0010y\u001a\u00020:2\u0006\u0010/\u001a\u0002002\u0006\u0010;\u001a\u00020'H\u0002J+\u0010z\u001a\u00020:\"\u000e\b\u0000\u0010{\u0018\u0001*\u0006\u0012\u0002\b\u0003022\u0006\u0010/\u001a\u0002002\b\u0010;\u001a\u0004\u0018\u00010'H\bJ\u0012\u0010|\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010'H\u0014J'\u0010}\u001a\u00020:2\b\u0010#\u001a\u0004\u0018\u00010\n2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0006H\u0010¢\u0006\u0002\b~J\u000e\u0010\u001a\u00020:H\u0010¢\u0006\u0003\b\u0001J\u0010\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020\u0003J\u0012\u0010\u0001\u001a\u00020:2\u0007\u0010#\u001a\u00030\u0001H\u0002J\u0015\u0010\u0001\u001a\u00020:2\n\u0010#\u001a\u0006\u0012\u0002\b\u000302H\u0002JH\u0010\u0001\u001a\u00020:\"\u0005\b\u0000\u0010\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010\u00012\u001e\u0010o\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u0003H\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\n0fø\u0001\u0000¢\u0006\u0003\u0010\u0001JZ\u0010\u0001\u001a\u00020:\"\u0004\b\u0000\u0010{\"\u0005\b\u0001\u0010\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010\u00012%\u0010o\u001a!\b\u0001\u0012\u0004\u0012\u0002H{\u0012\f\u0012\n\u0012\u0005\u0012\u0003H\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020:2\n\u00101\u001a\u0006\u0012\u0002\b\u000302H\u0000¢\u0006\u0003\b\u0001JZ\u0010\u0001\u001a\u00020:\"\u0004\b\u0000\u0010{\"\u0005\b\u0001\u0010\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010\u00012%\u0010o\u001a!\b\u0001\u0012\u0004\u0012\u0002H{\u0012\f\u0012\n\u0012\u0005\u0012\u0003H\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0007\u0010\u0001\u001a\u00020\u0006J\u0013\u0010\u0001\u001a\u00020C2\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002J\u0013\u0010\u0001\u001a\u00020w2\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002J \u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020'2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020'0XH\u0002J\t\u0010\u0001\u001a\u00020wH\u0016J#\u0010\u0001\u001a\u00020\u00062\u0006\u0010#\u001a\u00020F2\b\u0010I\u001a\u0004\u0018\u00010\n2\u0006\u0010B\u001a\u00020CH\u0002J#\u0010\u0001\u001a\u00020\u00062\u0006\u0010#\u001a\u00020+2\b\u0010A\u001a\u0004\u0018\u00010\n2\u0006\u0010B\u001a\u00020CH\u0002J\u001a\u0010\u0001\u001a\u00020\u00062\u0006\u0010#\u001a\u00020+2\u0007\u0010\u0001\u001a\u00020'H\u0002J%\u0010\u0001\u001a\u00020C2\b\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010I\u001a\u0004\u0018\u00010\n2\u0006\u0010B\u001a\u00020CH\u0002J$\u0010\u0001\u001a\u00020\u00062\u0006\u0010#\u001a\u00020F2\u0006\u00104\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\nH\u0010J\u0010\u0010\u0001\u001a\u0004\u0018\u00010H*\u00030 \u0001H\u0002J\u0017\u0010¡\u0001\u001a\u00020:*\u0002002\b\u0010;\u001a\u0004\u0018\u00010'H\u0002J\u001a\u0010¢\u0001\u001a\u00060Oj\u0002`P*\u00020'2\u0007\u0010£\u0001\u001a\u00020wH\u0002R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00068TX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00068TX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\u0015\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0016\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\rR\u0011\u0010\u0017\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0015\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00068PX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\rR\u0011\u0010\u001e\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\u0004\u0018\u00010\n8@X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'*\u0004\u0018\u00010\n8BX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0018\u0010*\u001a\u00020\u0006*\u00020+8BX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010,\u0002\u0004\n\u0002\b\u0019¨\u0006§\u0001"}, dWq = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "Lkotlinx/coroutines/selects/SelectClause0;", "active", "", "(Z)V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "", "cancelsParent", "getCancelsParent", "()Z", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "handlesException", "getHandlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "onJoin", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "parentHandle", "Lkotlinx/coroutines/ChildHandle;", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "exceptionOrNull", "", "getExceptionOrNull", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "isCancelling", "Lkotlinx/coroutines/Incomplete;", "(Lkotlinx/coroutines/Incomplete;)Z", "addLastAtomic", "expect", "list", "Lkotlinx/coroutines/NodeList;", "node", "Lkotlinx/coroutines/JobNode;", "attachChild", "child", "awaitInternal", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSuspend", "cancel", "", "cause", "cancelImpl", "cancelMakeCompleting", "cancelParent", "childCancelled", "completeStateFinalization", "update", "mode", "", "suppressed", "continueCompleting", "Lkotlinx/coroutines/JobSupport$Finishing;", "lastChild", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "createCauseException", "createJobCancellationException", "Lkotlinx/coroutines/JobCancellationException;", "firstChild", "getCancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal", "getCompletedInternal$kotlinx_coroutines_core", "getCompletionCause", "getCompletionExceptionOrNull", "getFinalRootCause", "exceptions", "", "getOrPromoteCancellingList", "handleJobException", "exception", "handleOnCompletionException", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJobInternal", "parent", "initParentJobInternal$kotlinx_coroutines_core", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "joinInternal", "joinSuspend", "loopOnState", "", "block", "makeCancelling", "makeCompleting", "makeCompleting$kotlinx_coroutines_core", "makeCompletingOnce", "makeCompletingOnce$kotlinx_coroutines_core", "makeNode", "nameString", "", "nameString$kotlinx_coroutines_core", "notifyCancelling", "notifyHandlers", "T", "onCancellation", "onCompletionInternal", "onCompletionInternal$kotlinx_coroutines_core", "onStartInternal", "onStartInternal$kotlinx_coroutines_core", "parentCancelled", "parentJob", "promoteEmptyToNodeList", "Lkotlinx/coroutines/Empty;", "promoteSingleToNodeList", "registerSelectClause0", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "registerSelectClause1Internal", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "removeNode", "removeNode$kotlinx_coroutines_core", "selectAwaitCompletion", "selectAwaitCompletion$kotlinx_coroutines_core", "start", "startInternal", "stateString", "suppressExceptions", "rootCause", "toString", "tryFinalizeFinishingState", "tryFinalizeSimpleState", "tryMakeCancelling", "tryMakeCompleting", "tryWaitForChild", "nextChild", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "notifyCompletion", "toCancellationException", "message", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.bg */
public class C16456bg implements C41157bc, C6101bn, C31194o {
    static final AtomicReferenceFieldUpdater BPt = AtomicReferenceFieldUpdater.newUpdater(C16456bg.class, Object.class, "BPs");
    private volatile Object BPs;
    volatile C44622m BQA;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
    /* renamed from: kotlinx.coroutines.bg$a */
    static final class C16457a extends C31189bf<C41157bc> {
        private final C16456bg BQB;
        private final C16458b BQC;
        private final C24595n BQD;
        private final Object BQE;

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(118571);
            mo30347v((Throwable) obj);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(118571);
            return c37091y;
        }

        public C16457a(C16456bg c16456bg, C16458b c16458b, C24595n c24595n, Object obj) {
            C25052j.m39376p(c16456bg, "parent");
            C25052j.m39376p(c16458b, "state");
            C25052j.m39376p(c24595n, "child");
            super(c24595n.BPA);
            AppMethodBeat.m2504i(118573);
            this.BQB = c16456bg;
            this.BQC = c16458b;
            this.BQD = c24595n;
            this.BQE = obj;
            AppMethodBeat.m2505o(118573);
        }

        /* renamed from: v */
        public final void mo30347v(Throwable th) {
            AppMethodBeat.m2504i(118570);
            C16456bg.m25244a(this.BQB, this.BQC, this.BQD, this.BQE);
            AppMethodBeat.m2505o(118570);
        }

        public final String toString() {
            AppMethodBeat.m2504i(118572);
            String str = "ChildCompletion[" + this.BQD + ", " + this.BQE + ']';
            AppMethodBeat.m2505o(118572);
            return str;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tJ\u0018\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0016j\b\u0012\u0004\u0012\u00020\t`\u0017H\u0002J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\tJ\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, dWq = {"Lkotlinx/coroutines/JobSupport$Finishing;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "isCompleting", "", "rootCause", "", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "_exceptionsHolder", "isActive", "()Z", "isCancelling", "isSealed", "getList", "()Lkotlinx/coroutines/NodeList;", "addExceptionLocked", "", "exception", "allocateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sealLocked", "", "proposedException", "toString", "", "kotlinx-coroutines-core"})
    /* renamed from: kotlinx.coroutines.bg$b */
    static final class C16458b implements C44612ay {
        volatile Object BQF;
        public volatile boolean BQG = false;
        public volatile Throwable BQH;
        final C36628bk BQt;

        public final C36628bk ell() {
            return this.BQt;
        }

        public C16458b(C36628bk c36628bk, Throwable th) {
            C25052j.m39376p(c36628bk, "list");
            AppMethodBeat.m2504i(118538);
            this.BQt = c36628bk;
            this.BQH = th;
            AppMethodBeat.m2505o(118538);
        }

        public final boolean isSealed() {
            AppMethodBeat.m2504i(118534);
            if (this.BQF == C16460bh.BQL) {
                AppMethodBeat.m2505o(118534);
                return true;
            }
            AppMethodBeat.m2505o(118534);
            return false;
        }

        public final boolean elx() {
            return this.BQH != null;
        }

        public final boolean isActive() {
            return this.BQH == null;
        }

        /* renamed from: B */
        public final void mo30348B(Throwable th) {
            AppMethodBeat.m2504i(118535);
            C25052j.m39376p(th, "exception");
            Throwable th2 = this.BQH;
            if (th2 == null) {
                this.BQH = th;
                AppMethodBeat.m2505o(118535);
            } else if (th == th2) {
                AppMethodBeat.m2505o(118535);
            } else {
                th2 = this.BQF;
                if (th2 == null) {
                    this.BQF = th;
                    AppMethodBeat.m2505o(118535);
                } else if (th2 instanceof Throwable) {
                    if (th == th2) {
                        AppMethodBeat.m2505o(118535);
                        return;
                    }
                    ArrayList ely = C16458b.ely();
                    ely.add(th2);
                    ely.add(th);
                    this.BQF = ely;
                    AppMethodBeat.m2505o(118535);
                } else if (!(th2 instanceof ArrayList)) {
                    th2 = new IllegalStateException("State is ".concat(String.valueOf(th2)).toString());
                    AppMethodBeat.m2505o(118535);
                    throw th2;
                } else if (th2 == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Throwable> /* = java.util.ArrayList<kotlin.Throwable> */");
                    AppMethodBeat.m2505o(118535);
                    throw c44941v;
                } else {
                    ((ArrayList) th2).add(th);
                    AppMethodBeat.m2505o(118535);
                }
            }
        }

        static ArrayList<Throwable> ely() {
            AppMethodBeat.m2504i(118536);
            ArrayList arrayList = new ArrayList(4);
            AppMethodBeat.m2505o(118536);
            return arrayList;
        }

        public final String toString() {
            AppMethodBeat.m2504i(118537);
            String str = "Finishing[cancelling=" + elx() + ", completing=" + this.BQG + ", rootCause=" + this.BQH + ", exceptions=" + this.BQF + ", list=" + this.BQt + ']';
            AppMethodBeat.m2505o(118537);
            return str;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, dWq = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"})
    /* renamed from: kotlinx.coroutines.bg$c */
    public static final class C16459c extends C6095a {
        final /* synthetic */ C31179h BQI;
        final /* synthetic */ C16456bg BQJ;
        final /* synthetic */ Object BQK;

        public C16459c(C31179h c31179h, C31179h c31179h2, C16456bg c16456bg, Object obj) {
            this.BQI = c31179h;
            this.BQJ = c16456bg;
            this.BQK = obj;
            super(c31179h2);
        }

        /* renamed from: ek */
        public final /* synthetic */ Object mo30354ek(Object obj) {
            AppMethodBeat.m2504i(118366);
            C25052j.m39376p((C31179h) obj, "affected");
            if ((this.BQJ.elt() == this.BQK ? 1 : null) != null) {
                AppMethodBeat.m2505o(118366);
                return null;
            }
            Object elH = C41150g.elH();
            AppMethodBeat.m2505o(118366);
            return elH;
        }
    }

    static {
        AppMethodBeat.m2504i(118623);
        AppMethodBeat.m2505o(118623);
    }

    public C16456bg(boolean z) {
        AppMethodBeat.m2504i(118617);
        this.BPs = z ? C16460bh.BQN : C16460bh.BQM;
        AppMethodBeat.m2505o(118617);
    }

    public final C36928c<?> getKey() {
        return C41157bc.BQx;
    }

    public boolean isActive() {
        AppMethodBeat.m2504i(118585);
        Object elt = elt();
        if ((elt instanceof C44612ay) && ((C44612ay) elt).isActive()) {
            AppMethodBeat.m2505o(118585);
            return true;
        }
        AppMethodBeat.m2505o(118585);
        return false;
    }

    /* renamed from: a */
    private final boolean m25248a(C16458b c16458b, Object obj) {
        Throwable th = null;
        boolean z = false;
        AppMethodBeat.m2504i(118586);
        Throwable illegalArgumentException;
        if (!(obj instanceof C44612ay)) {
            if (elt() == c16458b) {
                if (!c16458b.isSealed()) {
                    z = true;
                }
                if (!z) {
                    illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
                    AppMethodBeat.m2505o(118586);
                    throw illegalArgumentException;
                } else if (c16458b.BQG) {
                    Object obj2;
                    Throwable th2;
                    if (obj instanceof C31195q) {
                        obj2 = obj;
                    } else {
                        obj2 = null;
                    }
                    C31195q c31195q = (C31195q) obj2;
                    if (c31195q != null) {
                        th = c31195q.cause;
                    }
                    synchronized (c16458b) {
                        try {
                            ArrayList ely;
                            obj2 = c16458b.BQF;
                            if (obj2 == null) {
                                ely = C16458b.ely();
                            } else if (obj2 instanceof Throwable) {
                                ArrayList ely2 = C16458b.ely();
                                ely2.add(obj2);
                                ely = ely2;
                            } else if (!(obj2 instanceof ArrayList)) {
                                illegalArgumentException = new IllegalStateException("State is ".concat(String.valueOf(obj2)).toString());
                                AppMethodBeat.m2505o(118586);
                                throw illegalArgumentException;
                            } else if (obj2 == null) {
                                C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Throwable> /* = java.util.ArrayList<kotlin.Throwable> */");
                                AppMethodBeat.m2505o(118586);
                                throw c44941v;
                            } else {
                                ely = (ArrayList) obj2;
                            }
                            th2 = c16458b.BQH;
                            if (th2 != null) {
                                ely.add(0, th2);
                            }
                            if (!(th == null || (C25052j.m39373j(th, th2) ^ 1) == 0)) {
                                ely.add(th);
                            }
                            c16458b.BQF = C16460bh.BQL;
                            List list = ely;
                            th2 = m25239a(c16458b, list);
                            if (!(th2 == null || C16456bg.m25252b(th2, list))) {
                                illegalArgumentException = c16458b.BQH;
                            }
                        } finally {
                            AppMethodBeat.m2505o(118586);
                        }
                    }
                    if (!(th2 == null || th2 == th)) {
                        obj = new C31195q(th2);
                    }
                    if (!(th2 == null || m25238A(th2))) {
                        mo30345z(th2);
                    }
                    if (BPt.compareAndSet(this, c16458b, obj)) {
                        m25250b((C44612ay) c16458b, obj);
                        AppMethodBeat.m2505o(118586);
                        return true;
                    }
                    illegalArgumentException = new IllegalArgumentException(("Unexpected state: " + this.BPs + ", expected: " + c16458b + ", update: " + obj).toString());
                    throw illegalArgumentException;
                } else {
                    illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
                    AppMethodBeat.m2505o(118586);
                    throw illegalArgumentException;
                }
            }
            illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
            AppMethodBeat.m2505o(118586);
            throw illegalArgumentException;
        }
        illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
        AppMethodBeat.m2505o(118586);
        throw illegalArgumentException;
    }

    /* renamed from: a */
    private final Throwable m25239a(C16458b c16458b, List<? extends Throwable> list) {
        AppMethodBeat.m2504i(118587);
        Throwable th;
        if (!list.isEmpty()) {
            Object obj;
            for (Object next : list) {
                int i;
                if (((Throwable) next) instanceof CancellationException) {
                    i = 0;
                    continue;
                } else {
                    i = 1;
                    continue;
                }
                if (i != 0) {
                    obj = next;
                    break;
                }
            }
            obj = null;
            th = (Throwable) obj;
            if (th == null) {
                th = (Throwable) list.get(0);
            }
            AppMethodBeat.m2505o(118587);
            return th;
        } else if (c16458b.elx()) {
            th = elu();
            AppMethodBeat.m2505o(118587);
            return th;
        } else {
            AppMethodBeat.m2505o(118587);
            return null;
        }
    }

    /* renamed from: b */
    private static boolean m25252b(Throwable th, List<? extends Throwable> list) {
        boolean z = false;
        AppMethodBeat.m2504i(118588);
        if (list.size() <= 1) {
            AppMethodBeat.m2505o(118588);
        } else {
            Set UZ = C44607e.m81026UZ(list.size());
            for (Throwable th2 : list) {
                boolean z2;
                if (th2 == th || (th2 instanceof CancellationException) || !UZ.add(th2)) {
                    z2 = z;
                } else {
                    C7993b.m14177a(th, th2);
                    z2 = true;
                }
                z = z2;
            }
            AppMethodBeat.m2505o(118588);
        }
        return z;
    }

    /* renamed from: a */
    private final boolean m25247a(C44612ay c44612ay, Object obj) {
        AppMethodBeat.m2504i(118589);
        boolean z = (c44612ay instanceof C41156ar) || (c44612ay instanceof C31189bf);
        Throwable illegalStateException;
        if (z) {
            if (!(!(obj instanceof C31195q))) {
                illegalStateException = new IllegalStateException("Check failed.".toString());
                AppMethodBeat.m2505o(118589);
                throw illegalStateException;
            } else if (BPt.compareAndSet(this, c44612ay, obj)) {
                m25250b(c44612ay, obj);
                AppMethodBeat.m2505o(118589);
                return true;
            } else {
                AppMethodBeat.m2505o(118589);
                return false;
            }
        }
        illegalStateException = new IllegalStateException("Check failed.".toString());
        AppMethodBeat.m2505o(118589);
        throw illegalStateException;
    }

    /* renamed from: b */
    private final void m25250b(C44612ay c44612ay, Object obj) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.m2504i(118590);
        C44622m c44622m = this.BQA;
        if (c44622m != null) {
            c44622m.dispose();
            this.BQA = C41361bl.BQP;
        }
        if (obj instanceof C31195q) {
            th = obj;
        } else {
            th = null;
        }
        C31195q c31195q = (C31195q) th;
        if (c31195q != null) {
            th2 = c31195q.cause;
        }
        if (c44612ay instanceof C31189bf) {
            try {
                ((C31189bf) c44612ay).mo30347v(th2);
            } catch (Throwable th3) {
                mo30343u(new C41164u("Exception in completion handler " + c44612ay + " for " + this, th3));
            }
        } else {
            C36628bk ell = c44612ay.ell();
            if (ell != null) {
                m25251b(ell, th2);
            }
        }
        mo30332eb(obj);
        AppMethodBeat.m2505o(118590);
    }

    public void ekU() {
    }

    /* JADX WARNING: Missing block: B:5:0x001b, code skipped:
            if (r0 == null) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final CancellationException els() {
        CancellationException c;
        AppMethodBeat.m2504i(118594);
        Object elt = elt();
        Throwable th;
        if (elt instanceof C16458b) {
            th = ((C16458b) elt).BQH;
            if (th != null) {
                c = m25253c(th, "Job is cancelling");
            }
            th = new IllegalStateException("Job is still new or active: ".concat(String.valueOf(this)).toString());
            AppMethodBeat.m2505o(118594);
            throw th;
        } else if (elt instanceof C44612ay) {
            th = new IllegalStateException("Job is still new or active: ".concat(String.valueOf(this)).toString());
            AppMethodBeat.m2505o(118594);
            throw th;
        } else if (elt instanceof C31195q) {
            c = m25253c(((C31195q) elt).cause, "Job was cancelled");
            AppMethodBeat.m2505o(118594);
            return c;
        } else {
            c = new C44616bd("Job has completed normally", null, this);
        }
        AppMethodBeat.m2505o(118594);
        return c;
    }

    /* renamed from: c */
    private final CancellationException m25253c(Throwable th, String str) {
        AppMethodBeat.m2504i(118595);
        CancellationException cancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (cancellationException == null) {
            cancellationException = new C44616bd(str, th, this);
        }
        AppMethodBeat.m2505o(118595);
        return cancellationException;
    }

    /* JADX WARNING: Missing block: B:28:0x006f, code skipped:
            if (r0 == null) goto L_0x0071;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final C31189bf<?> m25240a(C17126b<? super Throwable, C37091y> c17126b, boolean z) {
        C17126b<? super Throwable, C37091y> c17126b2 = null;
        Object obj = 1;
        AppMethodBeat.m2504i(118597);
        Throwable illegalArgumentException;
        C31189bf<?> c44615ba;
        if (z) {
            if (c17126b instanceof C16455be) {
                c17126b2 = c17126b;
            }
            C16455be c16455be = (C16455be) c17126b2;
            if (c16455be != null) {
                if (c16455be.BQz != this) {
                    obj = null;
                }
                if (obj == null) {
                    illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
                    AppMethodBeat.m2505o(118597);
                    throw illegalArgumentException;
                } else if (c16455be != null) {
                    C31189bf c31189bf = c16455be;
                    AppMethodBeat.m2505o(118597);
                    return c31189bf;
                }
            }
            c44615ba = new C44615ba(this, c17126b);
            AppMethodBeat.m2505o(118597);
            return c44615ba;
        }
        if (c17126b instanceof C31189bf) {
            c17126b2 = c17126b;
        }
        c44615ba = (C31189bf) c17126b2;
        if (c44615ba != null) {
            Object obj2 = (c44615ba.BQz != ((C16456bg) this) || (c44615ba instanceof C16455be)) ? null : 1;
            if (obj2 == null) {
                illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
                AppMethodBeat.m2505o(118597);
                throw illegalArgumentException;
            }
        }
        c44615ba = new C46848bb(this, c17126b);
        AppMethodBeat.m2505o(118597);
        return c44615ba;
    }

    /* renamed from: a */
    private final void m25243a(C31189bf<?> c31189bf) {
        AppMethodBeat.m2504i(118599);
        c31189bf.mo50939b(new C36628bk());
        BPt.compareAndSet(this, c31189bf, C41150g.m71584em(c31189bf.elJ()));
        AppMethodBeat.m2505o(118599);
    }

    private final C44616bd elu() {
        AppMethodBeat.m2504i(118602);
        C44616bd c44616bd = new C44616bd("Job was cancelled", null, this);
        AppMethodBeat.m2505o(118602);
        return c44616bd;
    }

    public final Throwable elv() {
        Throwable th;
        Throwable illegalStateException;
        AppMethodBeat.m2504i(118603);
        Object elt = elt();
        if (elt instanceof C16458b) {
            th = ((C16458b) elt).BQH;
        } else if (elt instanceof C44612ay) {
            illegalStateException = new IllegalStateException("Cannot be cancelling child in this state: ".concat(String.valueOf(elt)).toString());
            AppMethodBeat.m2505o(118603);
            throw illegalStateException;
        } else if (elt instanceof C31195q) {
            th = ((C31195q) elt).cause;
        } else {
            th = null;
        }
        if (th == null || !(th instanceof CancellationException)) {
            illegalStateException = new C44616bd("Parent job is " + C16456bg.m25255ej(elt), th, this);
            AppMethodBeat.m2505o(118603);
            return illegalStateException;
        }
        AppMethodBeat.m2505o(118603);
        return th;
    }

    /* renamed from: eh */
    private final Throwable m25254eh(Object obj) {
        AppMethodBeat.m2504i(118604);
        Throwable th;
        if (obj != null ? obj instanceof Throwable : true) {
            if (obj != null) {
                th = (Throwable) obj;
                AppMethodBeat.m2505o(118604);
                return th;
            }
            Throwable elu = elu();
            AppMethodBeat.m2505o(118604);
            return elu;
        } else if (obj == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
            AppMethodBeat.m2505o(118604);
            throw c44941v;
        } else {
            th = ((C6101bn) obj).elv();
            AppMethodBeat.m2505o(118604);
            return th;
        }
    }

    /* renamed from: a */
    private final C36628bk m25241a(C44612ay c44612ay) {
        AppMethodBeat.m2504i(118606);
        C36628bk ell = c44612ay.ell();
        if (ell != null) {
            AppMethodBeat.m2505o(118606);
            return ell;
        } else if (c44612ay instanceof C41156ar) {
            ell = new C36628bk();
            AppMethodBeat.m2505o(118606);
            return ell;
        } else if (c44612ay instanceof C31189bf) {
            m25243a((C31189bf) c44612ay);
            AppMethodBeat.m2505o(118606);
            return null;
        } else {
            Throwable illegalStateException = new IllegalStateException("State should have list: ".concat(String.valueOf(c44612ay)).toString());
            AppMethodBeat.m2505o(118606);
            throw illegalStateException;
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Missing block: B:60:0x00b2, code skipped:
            if (r0 == null) goto L_0x00b7;
     */
    /* JADX WARNING: Missing block: B:61:0x00b4, code skipped:
            m25245a(r6, r0);
     */
    /* JADX WARNING: Missing block: B:62:0x00b7, code skipped:
            r9 = (kotlinx.coroutines.C44612ay) r9;
     */
    /* JADX WARNING: Missing block: B:63:0x00bb, code skipped:
            if ((r9 instanceof kotlinx.coroutines.C24595n) != false) goto L_0x00e9;
     */
    /* JADX WARNING: Missing block: B:64:0x00bd, code skipped:
            r0 = null;
     */
    /* JADX WARNING: Missing block: B:65:0x00be, code skipped:
            r0 = r0;
     */
    /* JADX WARNING: Missing block: B:66:0x00c0, code skipped:
            if (r0 != null) goto L_0x00e7;
     */
    /* JADX WARNING: Missing block: B:67:0x00c2, code skipped:
            r0 = r9.ell();
     */
    /* JADX WARNING: Missing block: B:68:0x00c6, code skipped:
            if (r0 == null) goto L_0x00ce;
     */
    /* JADX WARNING: Missing block: B:69:0x00c8, code skipped:
            r1 = kotlinx.coroutines.C16456bg.m25242a((kotlinx.coroutines.p700a.C31179h) r0);
     */
    /* JADX WARNING: Missing block: B:70:0x00ce, code skipped:
            if (r1 == null) goto L_0x00de;
     */
    /* JADX WARNING: Missing block: B:72:0x00d4, code skipped:
            if (m25249a(r2, r1, r10) == false) goto L_0x00de;
     */
    /* JADX WARNING: Missing block: B:73:0x00d6, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(118607);
     */
    /* JADX WARNING: Missing block: B:75:0x00de, code skipped:
            m25248a(r2, r10);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(118607);
     */
    /* JADX WARNING: Missing block: B:76:0x00e7, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:77:0x00e9, code skipped:
            r0 = r9;
     */
    /* JADX WARNING: Missing block: B:87:?, code skipped:
            return 2;
     */
    /* JADX WARNING: Missing block: B:88:?, code skipped:
            return 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: L */
    public final int mo30328L(Object obj, Object obj2) {
        Object obj3 = null;
        C24595n c24595n = null;
        AppMethodBeat.m2504i(118607);
        if (!(obj instanceof C44612ay)) {
            AppMethodBeat.m2505o(118607);
            return 0;
        } else if ((!(obj instanceof C41156ar) && !(obj instanceof C31189bf)) || (obj instanceof C24595n) || (obj2 instanceof C31195q)) {
            C36628bk a = m25241a((C44612ay) obj);
            if (a == null) {
                AppMethodBeat.m2505o(118607);
                return 3;
            }
            C24595n c24595n2;
            C16458b c16458b;
            if (obj instanceof C16458b) {
                c24595n2 = obj;
            } else {
                c24595n2 = null;
            }
            C16458b c16458b2 = (C16458b) c24595n2;
            if (c16458b2 == null) {
                c16458b = new C16458b(a, null);
            } else {
                c16458b = c16458b2;
            }
            synchronized (c16458b) {
                try {
                    if (c16458b.BQG) {
                    } else {
                        c16458b.BQG = true;
                        if (c16458b == obj || BPt.compareAndSet(this, obj, c16458b)) {
                            Throwable illegalArgumentException;
                            if ((!c16458b.isSealed() ? 1 : null) == null) {
                                illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
                                AppMethodBeat.m2505o(118607);
                                throw illegalArgumentException;
                            }
                            boolean elx = c16458b.elx();
                            if (obj2 instanceof C31195q) {
                                c24595n2 = obj2;
                            } else {
                                c24595n2 = null;
                            }
                            C31195q c31195q = (C31195q) c24595n2;
                            if (c31195q != null) {
                                c16458b.mo30348B(c31195q.cause);
                            }
                            illegalArgumentException = c16458b.BQH;
                            if (!elx) {
                                obj3 = 1;
                            }
                            if (obj3 == null) {
                                illegalArgumentException = null;
                            }
                            C37091y c37091y = C37091y.AUy;
                        } else {
                            AppMethodBeat.m2505o(118607);
                            return 3;
                        }
                    }
                } finally {
                    AppMethodBeat.m2505o(118607);
                }
            }
        } else if (m25247a((C44612ay) obj, obj2)) {
            AppMethodBeat.m2505o(118607);
            return 1;
        } else {
            AppMethodBeat.m2505o(118607);
            return 3;
        }
        return 0;
    }

    /* renamed from: a */
    private final boolean m25249a(C16458b c16458b, C24595n c24595n, Object obj) {
        AppMethodBeat.m2504i(118608);
        C24595n c24595n2 = c24595n;
        while (C16454a.m25237a(c24595n2.BPA, false, false, new C16457a(this, c16458b, c24595n2, obj), 1) == C41361bl.BQP) {
            c24595n2 = C16456bg.m25242a((C31179h) c24595n2);
            if (c24595n2 == null) {
                AppMethodBeat.m2505o(118608);
                return false;
            }
        }
        AppMethodBeat.m2505o(118608);
        return true;
    }

    /* renamed from: a */
    public final C44622m mo30330a(C31194o c31194o) {
        AppMethodBeat.m2504i(118610);
        C25052j.m39376p(c31194o, "child");
        C41155ap a = C16454a.m25237a(this, true, false, new C24595n(this, c31194o), 2);
        if (a == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
            AppMethodBeat.m2505o(118610);
            throw c44941v;
        }
        C44622m c44622m = (C44622m) a;
        AppMethodBeat.m2505o(118610);
        return c44622m;
    }

    /* renamed from: u */
    public void mo30343u(Throwable th) {
        AppMethodBeat.m2504i(118611);
        C25052j.m39376p(th, "exception");
        AppMethodBeat.m2505o(118611);
        throw th;
    }

    /* Access modifiers changed, original: protected */
    public boolean elw() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: z */
    public void mo30345z(Throwable th) {
        AppMethodBeat.m2504i(118612);
        C25052j.m39376p(th, "exception");
        AppMethodBeat.m2505o(118612);
    }

    /* renamed from: A */
    private final boolean m25238A(Throwable th) {
        AppMethodBeat.m2504i(118613);
        if (th instanceof CancellationException) {
            AppMethodBeat.m2505o(118613);
            return true;
        } else if (elw()) {
            C44622m c44622m = this.BQA;
            if (c44622m == null || !c44622m.mo41384x(th)) {
                AppMethodBeat.m2505o(118613);
                return false;
            }
            AppMethodBeat.m2505o(118613);
            return true;
        } else {
            AppMethodBeat.m2505o(118613);
            return false;
        }
    }

    /* renamed from: eb */
    public void mo30332eb(Object obj) {
    }

    public String toString() {
        AppMethodBeat.m2504i(118614);
        String str = ekV() + '{' + C16456bg.m25255ej(elt()) + "}@" + C36623af.m60717ee(this);
        AppMethodBeat.m2505o(118614);
        return str;
    }

    public String ekV() {
        AppMethodBeat.m2504i(118615);
        String ef = C36623af.m60718ef(this);
        AppMethodBeat.m2505o(118615);
        return ef;
    }

    /* renamed from: ej */
    private static String m25255ej(Object obj) {
        AppMethodBeat.m2504i(118616);
        String str;
        if (obj instanceof C16458b) {
            if (((C16458b) obj).elx()) {
                str = "Cancelling";
                AppMethodBeat.m2505o(118616);
                return str;
            } else if (((C16458b) obj).BQG) {
                str = "Completing";
                AppMethodBeat.m2505o(118616);
                return str;
            } else {
                str = "Active";
                AppMethodBeat.m2505o(118616);
                return str;
            }
        } else if (obj instanceof C44612ay) {
            if (((C44612ay) obj).isActive()) {
                str = "Active";
                AppMethodBeat.m2505o(118616);
                return str;
            }
            str = "New";
            AppMethodBeat.m2505o(118616);
            return str;
        } else if (obj instanceof C31195q) {
            str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED;
            AppMethodBeat.m2505o(118616);
            return str;
        } else {
            str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
            AppMethodBeat.m2505o(118616);
            return str;
        }
    }

    public final Object elt() {
        AppMethodBeat.m2504i(118584);
        while (true) {
            Object obj = this.BPs;
            if (obj instanceof C31184k) {
                ((C31184k) obj).mo50949el(this);
            } else {
                AppMethodBeat.m2505o(118584);
                return obj;
            }
        }
    }

    /* JADX WARNING: Missing block: B:17:0x003e, code skipped:
            if (r2 == null) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final void m25245a(C36628bk c36628bk, Throwable th) {
        AppMethodBeat.m2504i(118591);
        Throwable th2 = null;
        Object elJ = c36628bk.elJ();
        if (elJ == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            AppMethodBeat.m2505o(118591);
            throw c44941v;
        }
        Object obj = (C31179h) elJ;
        while ((C25052j.m39373j(obj, c36628bk) ^ 1) != 0) {
            Throwable th3;
            if (obj instanceof C16455be) {
                C31189bf c31189bf = (C31189bf) obj;
                try {
                    c31189bf.mo30347v(th);
                    th3 = th2;
                } catch (Throwable th4) {
                    if (th2 != null) {
                        C7993b.m14177a(th2, th4);
                    }
                    th3 = new C41164u("Exception in completion handler " + c31189bf + " for " + this, th4);
                    C37091y c37091y = C37091y.AUy;
                }
                obj = obj.elK();
                th2 = th3;
            }
            th3 = th2;
            obj = obj.elK();
            th2 = th3;
        }
        if (th2 != null) {
            mo30343u(th2);
        }
        m25238A(th);
        AppMethodBeat.m2505o(118591);
    }

    /* JADX WARNING: Missing block: B:17:0x003e, code skipped:
            if (r2 == null) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private final void m25251b(C36628bk c36628bk, Throwable th) {
        AppMethodBeat.m2504i(118592);
        Throwable th2 = null;
        Object elJ = c36628bk.elJ();
        if (elJ == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            AppMethodBeat.m2505o(118592);
            throw c44941v;
        }
        Object obj = (C31179h) elJ;
        while ((C25052j.m39373j(obj, c36628bk) ^ 1) != 0) {
            Throwable th3;
            if (obj instanceof C31189bf) {
                C31189bf c31189bf = (C31189bf) obj;
                try {
                    c31189bf.mo30347v(th);
                    th3 = th2;
                } catch (Throwable th4) {
                    if (th2 != null) {
                        C7993b.m14177a(th2, th4);
                    }
                    th3 = new C41164u("Exception in completion handler " + c31189bf + " for " + this, th4);
                    C37091y c37091y = C37091y.AUy;
                }
                obj = obj.elK();
                th2 = th3;
            }
            th3 = th2;
            obj = obj.elK();
            th2 = th3;
        }
        if (th2 != null) {
            mo30343u(th2);
            AppMethodBeat.m2505o(118592);
            return;
        }
        AppMethodBeat.m2505o(118592);
    }

    public final boolean start() {
        AppMethodBeat.m2504i(118593);
        while (true) {
            Object obj;
            Object elt = elt();
            int obj2;
            if (elt instanceof C41156ar) {
                if (!((C41156ar) elt).csi) {
                    if (BPt.compareAndSet(this, elt, C16460bh.BQN)) {
                        ekU();
                        obj2 = 1;
                    } else {
                        obj2 = -1;
                    }
                }
                obj2 = null;
            } else {
                if (elt instanceof C44832ax) {
                    if (BPt.compareAndSet(this, elt, ((C44832ax) elt).BQt)) {
                        ekU();
                        obj2 = 1;
                    } else {
                        obj2 = -1;
                    }
                }
                obj2 = null;
            }
            switch (obj2) {
                case null:
                    AppMethodBeat.m2505o(118593);
                    return false;
                case 1:
                    AppMethodBeat.m2505o(118593);
                    return true;
                default:
            }
        }
    }

    /* JADX WARNING: Missing block: B:39:0x009e, code skipped:
            r4 = r5;
     */
    /* JADX WARNING: Missing block: B:42:?, code skipped:
            r1 = r1;
     */
    /* JADX WARNING: Missing block: B:48:0x00b0, code skipped:
            r5 = r7;
            r3 = r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final C41155ap mo30329a(boolean z, boolean z2, C17126b<? super Throwable, C37091y> c17126b) {
        C41155ap c41155ap;
        Object obj = null;
        AppMethodBeat.m2504i(118596);
        C25052j.m39376p(c17126b, "handler");
        Object obj2 = null;
        while (true) {
            Object elt = elt();
            C31189bf a;
            Object obj3;
            C31189bf c31189bf;
            C31189bf obj32;
            if (elt instanceof C41156ar) {
                if (((C41156ar) elt).csi) {
                    if (obj2 == null) {
                        a = m25240a((C17126b) c17126b, z);
                        obj32 = a;
                        c31189bf = a;
                    } else {
                        obj32 = obj2;
                        c31189bf = obj2;
                    }
                    if (BPt.compareAndSet(this, elt, obj32)) {
                        c41155ap = (C41155ap) obj32;
                        AppMethodBeat.m2505o(118596);
                        return c41155ap;
                    }
                    obj2 = c31189bf;
                } else {
                    C41156ar c41156ar = (C41156ar) elt;
                    C36628bk c36628bk = new C36628bk();
                    if (!c41156ar.csi) {
                        obj32 = new C44832ax(c36628bk);
                    }
                    BPt.compareAndSet(this, c41156ar, c36628bk);
                }
            } else if (elt instanceof C44612ay) {
                C36628bk ell = ((C44612ay) elt).ell();
                if (ell != null) {
                    C31189bf a2;
                    Object obj4;
                    c41155ap = C41361bl.BQP;
                    if (z && (elt instanceof C16458b)) {
                        synchronized (elt) {
                            try {
                                Throwable th = ((C16458b) elt).BQH;
                                if (th == null || ((c17126b instanceof C24595n) && !((C16458b) elt).BQG)) {
                                    if (obj2 == null) {
                                        a2 = m25240a((C17126b) c17126b, z);
                                        obj32 = a2;
                                        c31189bf = a2;
                                    } else {
                                        obj32 = obj2;
                                        c31189bf = obj2;
                                    }
                                    if (!m25246a(elt, ell, obj32)) {
                                    } else if (th == null) {
                                        break;
                                    } else {
                                        c41155ap = obj32;
                                        a2 = c31189bf;
                                    }
                                }
                                C37091y c37091y = C37091y.AUy;
                            } finally {
                                AppMethodBeat.m2505o(118596);
                            }
                        }
                    } else {
                        obj4 = null;
                        a = obj2;
                    }
                    if (obj4 != null) {
                        if (z2) {
                            c17126b.mo50am(obj4);
                        }
                        AppMethodBeat.m2505o(118596);
                        return c41155ap;
                    }
                    if (a == null) {
                        a = m25240a((C17126b) c17126b, z);
                        obj32 = a;
                        obj2 = a;
                    } else {
                        obj32 = a;
                        a2 = a;
                    }
                    if (m25246a(elt, ell, obj32)) {
                        c41155ap = obj32;
                        AppMethodBeat.m2505o(118596);
                        return c41155ap;
                    }
                } else if (elt == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                    AppMethodBeat.m2505o(118596);
                    throw c44941v;
                } else {
                    m25243a((C31189bf) elt);
                }
            } else {
                if (z2) {
                    if (elt instanceof C31195q) {
                        obj32 = elt;
                    } else {
                        obj32 = null;
                    }
                    C31195q c31195q = (C31195q) obj32;
                    if (c31195q != null) {
                        obj = c31195q.cause;
                    }
                    c17126b.mo50am(obj);
                }
                c41155ap = C41361bl.BQP;
                AppMethodBeat.m2505o(118596);
                return c41155ap;
            }
        }
        return c41155ap;
    }

    /* renamed from: a */
    private final boolean m25246a(Object obj, C36628bk c36628bk, C31189bf<?> c31189bf) {
        AppMethodBeat.m2504i(118598);
        C6095a c16459c = new C16459c(c31189bf, c31189bf, this, obj);
        while (true) {
            Object elL = c36628bk.elL();
            if (elL == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                AppMethodBeat.m2505o(118598);
                throw c44941v;
            }
            switch (((C31179h) elL).mo50937a(c31189bf, c36628bk, c16459c)) {
                case 1:
                    AppMethodBeat.m2505o(118598);
                    return true;
                case 2:
                    AppMethodBeat.m2505o(118598);
                    return false;
                default:
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Missing block: B:21:0x0049, code skipped:
            if (r6 == null) goto L_0x0052;
     */
    /* JADX WARNING: Missing block: B:22:0x004b, code skipped:
            m25245a(((kotlinx.coroutines.C16456bg.C16458b) r2).BQt, r6);
     */
    /* JADX WARNING: Missing block: B:23:0x0052, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(118605);
     */
    /* JADX WARNING: Missing block: B:75:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: ei */
    public final boolean mo30333ei(Object obj) {
        Throwable th = null;
        Object obj2 = null;
        AppMethodBeat.m2504i(118605);
        Throwable th2 = null;
        while (true) {
            Object elt = elt();
            Throwable th3;
            if (elt instanceof C16458b) {
                synchronized (elt) {
                    try {
                        if (((C16458b) elt).isSealed()) {
                        } else {
                            boolean elx = ((C16458b) elt).elx();
                            if (!(obj == null && elx)) {
                                if (th2 == null) {
                                    th2 = m25254eh(obj);
                                }
                                ((C16458b) elt).mo30348B(th2);
                            }
                            th3 = ((C16458b) elt).BQH;
                            if (!elx) {
                                obj2 = 1;
                            }
                            if (obj2 != null) {
                                th = th3;
                            }
                        }
                    } finally {
                        AppMethodBeat.m2505o(118605);
                    }
                }
            } else if (elt instanceof C44612ay) {
                Throwable th4;
                Throwable th5;
                if (th2 == null) {
                    th3 = m25254eh(obj);
                    th4 = th3;
                    th5 = th3;
                } else {
                    th4 = th2;
                    th5 = th2;
                }
                if (((C44612ay) elt).isActive()) {
                    C44612ay c44612ay = (C44612ay) elt;
                    if ((!(c44612ay instanceof C16458b) ? 1 : null) == null) {
                        th3 = new IllegalStateException("Check failed.".toString());
                        AppMethodBeat.m2505o(118605);
                        throw th3;
                    } else if (c44612ay.isActive()) {
                        Object obj3;
                        C36628bk a = m25241a(c44612ay);
                        if (a == null) {
                            obj3 = null;
                        } else {
                            if (BPt.compareAndSet(this, c44612ay, new C16458b(a, th4))) {
                                m25245a(a, th4);
                                int obj32 = 1;
                            } else {
                                obj32 = null;
                            }
                        }
                        if (obj32 != null) {
                            AppMethodBeat.m2505o(118605);
                            return true;
                        }
                        th2 = th5;
                    } else {
                        th3 = new IllegalStateException("Check failed.".toString());
                        AppMethodBeat.m2505o(118605);
                        throw th3;
                    }
                }
                switch (mo30328L(elt, new C31195q(th4))) {
                    case 0:
                        th3 = new IllegalStateException("Cannot happen in ".concat(String.valueOf(elt)).toString());
                        AppMethodBeat.m2505o(118605);
                        throw th3;
                    case 1:
                    case 2:
                        AppMethodBeat.m2505o(118605);
                        return true;
                    case 3:
                        th2 = th5;
                        break;
                    default:
                        th3 = new IllegalStateException("unexpected result".toString());
                        AppMethodBeat.m2505o(118605);
                        throw th3;
                }
            } else {
                AppMethodBeat.m2505o(118605);
                return false;
            }
        }
        return false;
    }

    /* renamed from: y */
    public final boolean mo30344y(Throwable th) {
        AppMethodBeat.m2504i(118600);
        if (mo30333ei(th)) {
            AppMethodBeat.m2505o(118600);
            return true;
        }
        AppMethodBeat.m2505o(118600);
        return false;
    }

    /* renamed from: a */
    public final void mo30331a(C6101bn c6101bn) {
        AppMethodBeat.m2504i(118601);
        C25052j.m39376p(c6101bn, "parentJob");
        mo30333ei(c6101bn);
        AppMethodBeat.m2505o(118601);
    }

    /* renamed from: a */
    private static C24595n m25242a(C31179h c31179h) {
        AppMethodBeat.m2504i(118609);
        while (c31179h.elJ() instanceof C24580l) {
            c31179h = C41150g.m71584em(c31179h.elL());
        }
        C31179h c31179h2 = c31179h;
        while (true) {
            c31179h2 = C41150g.m71584em(c31179h2.elJ());
            if (!(c31179h2.elJ() instanceof C24580l)) {
                if (c31179h2 instanceof C24595n) {
                    C24595n c24595n = (C24595n) c31179h2;
                    AppMethodBeat.m2505o(118609);
                    return c24595n;
                } else if (c31179h2 instanceof C36628bk) {
                    AppMethodBeat.m2505o(118609);
                    return null;
                }
            }
        }
    }

    public C41366e plus(C41366e c41366e) {
        AppMethodBeat.m2504i(118618);
        C25052j.m39376p(c41366e, "context");
        C25052j.m39376p(c41366e, "context");
        C41366e a = C17124a.m26496a((C41367b) this, c41366e);
        AppMethodBeat.m2505o(118618);
        return a;
    }

    public <R> R fold(R r, C31591m<? super R, ? super C41367b, ? extends R> c31591m) {
        AppMethodBeat.m2504i(118619);
        C25052j.m39376p(c31591m, "operation");
        C25052j.m39376p(c31591m, "operation");
        Object a = C17124a.m26497a(this, r, c31591m);
        AppMethodBeat.m2505o(118619);
        return a;
    }

    public <E extends C41367b> E get(C36928c<E> c36928c) {
        AppMethodBeat.m2504i(118620);
        C25052j.m39376p(c36928c, "key");
        C25052j.m39376p(c36928c, "key");
        C41367b a = C17124a.m26495a((C41367b) this, (C36928c) c36928c);
        AppMethodBeat.m2505o(118620);
        return a;
    }

    public C41366e minusKey(C36928c<?> c36928c) {
        AppMethodBeat.m2504i(118621);
        C25052j.m39376p(c36928c, "key");
        C25052j.m39376p(c36928c, "key");
        C41366e b = C17124a.m26498b(this, c36928c);
        AppMethodBeat.m2505o(118621);
        return b;
    }

    /* renamed from: a */
    public static final /* synthetic */ void m25244a(C16456bg c16456bg, C16458b c16458b, C24595n c24595n, Object obj) {
        AppMethodBeat.m2504i(118622);
        if ((c16456bg.elt() == c16458b ? 1 : null) == null) {
            Throwable illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
            AppMethodBeat.m2505o(118622);
            throw illegalArgumentException;
        }
        C24595n a = C16456bg.m25242a((C31179h) c24595n);
        if (a == null || !c16456bg.m25249a(c16458b, a, obj)) {
            c16456bg.m25248a(c16458b, obj);
        }
        AppMethodBeat.m2505o(118622);
    }
}
