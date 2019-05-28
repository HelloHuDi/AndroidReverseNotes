package kotlinx.coroutines;

import a.f.a.m;
import a.f.b.j;
import a.l;
import a.v;
import a.y;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.a.e;
import kotlinx.coroutines.a.g;
import kotlinx.coroutines.a.h;
import kotlinx.coroutines.a.k;

@l(dWo = {1, 1, 13}, dWp = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0006¤\u0001¥\u0001¦\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u0002002\n\u00101\u001a\u0006\u0012\u0002\b\u000302H\u0002J\u000e\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\u0002J\u0015\u00105\u001a\u0004\u0018\u00010\nH@ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u0013\u00108\u001a\u0004\u0018\u00010\nH@ø\u0001\u0000¢\u0006\u0002\u00107J\b\u00109\u001a\u00020:H\u0016J\u0012\u00109\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010<\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010=\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010>\u001a\u00020\u00062\u0006\u0010;\u001a\u00020'H\u0002J\u0010\u0010?\u001a\u00020\u00062\u0006\u0010;\u001a\u00020'H\u0016J*\u0010@\u001a\u00020:2\u0006\u0010#\u001a\u00020+2\b\u0010A\u001a\u0004\u0018\u00010\n2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0006H\u0002J\"\u0010E\u001a\u00020:2\u0006\u0010#\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010J\u001a\u00020'2\b\u0010;\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010K\u001a\u00020LH\u0002J\u0012\u0010M\u001a\u0004\u0018\u00010H2\u0006\u0010#\u001a\u00020+H\u0002J\n\u0010N\u001a\u00060Oj\u0002`PJ\b\u0010Q\u001a\u00020'H\u0016J\u000f\u0010R\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\bSJ\n\u0010T\u001a\u0004\u0018\u00010'H\u0004J\b\u0010U\u001a\u0004\u0018\u00010'J \u0010V\u001a\u0004\u0018\u00010'2\u0006\u0010#\u001a\u00020F2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020'0XH\u0002J\u0012\u0010Y\u001a\u0004\u0018\u0001002\u0006\u0010#\u001a\u00020+H\u0002J\u0010\u0010Z\u001a\u00020:2\u0006\u0010[\u001a\u00020'H\u0014J\u0015\u0010\\\u001a\u00020:2\u0006\u0010[\u001a\u00020'H\u0010¢\u0006\u0002\b]J\u0017\u0010^\u001a\u00020:2\b\u0010_\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\b`J?\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u00062\u0006\u0010d\u001a\u00020\u00062'\u0010e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\bg\u0012\b\bh\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020:0fj\u0002`iJ/\u0010a\u001a\u00020b2'\u0010e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\bg\u0012\b\bh\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020:0fj\u0002`iJ\u0011\u0010j\u001a\u00020:H@ø\u0001\u0000¢\u0006\u0002\u00107J\b\u0010k\u001a\u00020\u0006H\u0002J\u0011\u0010l\u001a\u00020:H@ø\u0001\u0000¢\u0006\u0002\u00107J\u001f\u0010m\u001a\u00020n2\u0014\u0010o\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020:0fH\bJ\u0012\u0010p\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010\nH\u0002J\u0017\u0010q\u001a\u00020\u00062\b\u0010I\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\brJ\u001f\u0010s\u001a\u00020\u00062\b\u0010I\u001a\u0004\u0018\u00010\n2\u0006\u0010B\u001a\u00020CH\u0000¢\u0006\u0002\btJ=\u0010u\u001a\u0006\u0012\u0002\b\u0003022'\u0010e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\bg\u0012\b\bh\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020:0fj\u0002`i2\u0006\u0010c\u001a\u00020\u0006H\u0002J\r\u0010v\u001a\u00020wH\u0010¢\u0006\u0002\bxJ\u0018\u0010y\u001a\u00020:2\u0006\u0010/\u001a\u0002002\u0006\u0010;\u001a\u00020'H\u0002J+\u0010z\u001a\u00020:\"\u000e\b\u0000\u0010{\u0018\u0001*\u0006\u0012\u0002\b\u0003022\u0006\u0010/\u001a\u0002002\b\u0010;\u001a\u0004\u0018\u00010'H\bJ\u0012\u0010|\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010'H\u0014J'\u0010}\u001a\u00020:2\b\u0010#\u001a\u0004\u0018\u00010\n2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0006H\u0010¢\u0006\u0002\b~J\u000e\u0010\u001a\u00020:H\u0010¢\u0006\u0003\b\u0001J\u0010\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020\u0003J\u0012\u0010\u0001\u001a\u00020:2\u0007\u0010#\u001a\u00030\u0001H\u0002J\u0015\u0010\u0001\u001a\u00020:2\n\u0010#\u001a\u0006\u0012\u0002\b\u000302H\u0002JH\u0010\u0001\u001a\u00020:\"\u0005\b\u0000\u0010\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010\u00012\u001e\u0010o\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u0003H\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\n0fø\u0001\u0000¢\u0006\u0003\u0010\u0001JZ\u0010\u0001\u001a\u00020:\"\u0004\b\u0000\u0010{\"\u0005\b\u0001\u0010\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010\u00012%\u0010o\u001a!\b\u0001\u0012\u0004\u0012\u0002H{\u0012\f\u0012\n\u0012\u0005\u0012\u0003H\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020:2\n\u00101\u001a\u0006\u0012\u0002\b\u000302H\u0000¢\u0006\u0003\b\u0001JZ\u0010\u0001\u001a\u00020:\"\u0004\b\u0000\u0010{\"\u0005\b\u0001\u0010\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010\u00012%\u0010o\u001a!\b\u0001\u0012\u0004\u0012\u0002H{\u0012\f\u0012\n\u0012\u0005\u0012\u0003H\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0007\u0010\u0001\u001a\u00020\u0006J\u0013\u0010\u0001\u001a\u00020C2\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002J\u0013\u0010\u0001\u001a\u00020w2\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002J \u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020'2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020'0XH\u0002J\t\u0010\u0001\u001a\u00020wH\u0016J#\u0010\u0001\u001a\u00020\u00062\u0006\u0010#\u001a\u00020F2\b\u0010I\u001a\u0004\u0018\u00010\n2\u0006\u0010B\u001a\u00020CH\u0002J#\u0010\u0001\u001a\u00020\u00062\u0006\u0010#\u001a\u00020+2\b\u0010A\u001a\u0004\u0018\u00010\n2\u0006\u0010B\u001a\u00020CH\u0002J\u001a\u0010\u0001\u001a\u00020\u00062\u0006\u0010#\u001a\u00020+2\u0007\u0010\u0001\u001a\u00020'H\u0002J%\u0010\u0001\u001a\u00020C2\b\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010I\u001a\u0004\u0018\u00010\n2\u0006\u0010B\u001a\u00020CH\u0002J$\u0010\u0001\u001a\u00020\u00062\u0006\u0010#\u001a\u00020F2\u0006\u00104\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\nH\u0010J\u0010\u0010\u0001\u001a\u0004\u0018\u00010H*\u00030 \u0001H\u0002J\u0017\u0010¡\u0001\u001a\u00020:*\u0002002\b\u0010;\u001a\u0004\u0018\u00010'H\u0002J\u001a\u0010¢\u0001\u001a\u00060Oj\u0002`P*\u00020'2\u0007\u0010£\u0001\u001a\u00020wH\u0002R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00068TX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00068TX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\u0015\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0016\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\rR\u0011\u0010\u0017\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0015\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00068PX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\rR\u0011\u0010\u001e\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\u0004\u0018\u00010\n8@X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'*\u0004\u0018\u00010\n8BX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0018\u0010*\u001a\u00020\u0006*\u00020+8BX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010,\u0002\u0004\n\u0002\b\u0019¨\u0006§\u0001"}, dWq = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "Lkotlinx/coroutines/selects/SelectClause0;", "active", "", "(Z)V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "", "cancelsParent", "getCancelsParent", "()Z", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "handlesException", "getHandlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "onJoin", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "parentHandle", "Lkotlinx/coroutines/ChildHandle;", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "exceptionOrNull", "", "getExceptionOrNull", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "isCancelling", "Lkotlinx/coroutines/Incomplete;", "(Lkotlinx/coroutines/Incomplete;)Z", "addLastAtomic", "expect", "list", "Lkotlinx/coroutines/NodeList;", "node", "Lkotlinx/coroutines/JobNode;", "attachChild", "child", "awaitInternal", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSuspend", "cancel", "", "cause", "cancelImpl", "cancelMakeCompleting", "cancelParent", "childCancelled", "completeStateFinalization", "update", "mode", "", "suppressed", "continueCompleting", "Lkotlinx/coroutines/JobSupport$Finishing;", "lastChild", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "createCauseException", "createJobCancellationException", "Lkotlinx/coroutines/JobCancellationException;", "firstChild", "getCancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal", "getCompletedInternal$kotlinx_coroutines_core", "getCompletionCause", "getCompletionExceptionOrNull", "getFinalRootCause", "exceptions", "", "getOrPromoteCancellingList", "handleJobException", "exception", "handleOnCompletionException", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJobInternal", "parent", "initParentJobInternal$kotlinx_coroutines_core", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "joinInternal", "joinSuspend", "loopOnState", "", "block", "makeCancelling", "makeCompleting", "makeCompleting$kotlinx_coroutines_core", "makeCompletingOnce", "makeCompletingOnce$kotlinx_coroutines_core", "makeNode", "nameString", "", "nameString$kotlinx_coroutines_core", "notifyCancelling", "notifyHandlers", "T", "onCancellation", "onCompletionInternal", "onCompletionInternal$kotlinx_coroutines_core", "onStartInternal", "onStartInternal$kotlinx_coroutines_core", "parentCancelled", "parentJob", "promoteEmptyToNodeList", "Lkotlinx/coroutines/Empty;", "promoteSingleToNodeList", "registerSelectClause0", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "registerSelectClause1Internal", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "removeNode", "removeNode$kotlinx_coroutines_core", "selectAwaitCompletion", "selectAwaitCompletion$kotlinx_coroutines_core", "start", "startInternal", "stateString", "suppressExceptions", "rootCause", "toString", "tryFinalizeFinishingState", "tryFinalizeSimpleState", "tryMakeCancelling", "tryMakeCompleting", "tryWaitForChild", "nextChild", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "notifyCompletion", "toCancellationException", "message", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"})
public class bg implements bc, bn, o {
    static final AtomicReferenceFieldUpdater BPt = AtomicReferenceFieldUpdater.newUpdater(bg.class, Object.class, "BPs");
    private volatile Object BPs;
    volatile m BQA;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
    static final class a extends bf<bc> {
        private final bg BQB;
        private final b BQC;
        private final n BQD;
        private final Object BQE;

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(118571);
            v((Throwable) obj);
            y yVar = y.AUy;
            AppMethodBeat.o(118571);
            return yVar;
        }

        public a(bg bgVar, b bVar, n nVar, Object obj) {
            j.p(bgVar, "parent");
            j.p(bVar, "state");
            j.p(nVar, "child");
            super(nVar.BPA);
            AppMethodBeat.i(118573);
            this.BQB = bgVar;
            this.BQC = bVar;
            this.BQD = nVar;
            this.BQE = obj;
            AppMethodBeat.o(118573);
        }

        public final void v(Throwable th) {
            AppMethodBeat.i(118570);
            bg.a(this.BQB, this.BQC, this.BQD, this.BQE);
            AppMethodBeat.o(118570);
        }

        public final String toString() {
            AppMethodBeat.i(118572);
            String str = "ChildCompletion[" + this.BQD + ", " + this.BQE + ']';
            AppMethodBeat.o(118572);
            return str;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tJ\u0018\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0016j\b\u0012\u0004\u0012\u00020\t`\u0017H\u0002J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\tJ\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, dWq = {"Lkotlinx/coroutines/JobSupport$Finishing;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "isCompleting", "", "rootCause", "", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "_exceptionsHolder", "isActive", "()Z", "isCancelling", "isSealed", "getList", "()Lkotlinx/coroutines/NodeList;", "addExceptionLocked", "", "exception", "allocateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sealLocked", "", "proposedException", "toString", "", "kotlinx-coroutines-core"})
    static final class b implements ay {
        volatile Object BQF;
        public volatile boolean BQG = false;
        public volatile Throwable BQH;
        final bk BQt;

        public final bk ell() {
            return this.BQt;
        }

        public b(bk bkVar, Throwable th) {
            j.p(bkVar, "list");
            AppMethodBeat.i(118538);
            this.BQt = bkVar;
            this.BQH = th;
            AppMethodBeat.o(118538);
        }

        public final boolean isSealed() {
            AppMethodBeat.i(118534);
            if (this.BQF == bh.BQL) {
                AppMethodBeat.o(118534);
                return true;
            }
            AppMethodBeat.o(118534);
            return false;
        }

        public final boolean elx() {
            return this.BQH != null;
        }

        public final boolean isActive() {
            return this.BQH == null;
        }

        public final void B(Throwable th) {
            AppMethodBeat.i(118535);
            j.p(th, "exception");
            Throwable th2 = this.BQH;
            if (th2 == null) {
                this.BQH = th;
                AppMethodBeat.o(118535);
            } else if (th == th2) {
                AppMethodBeat.o(118535);
            } else {
                th2 = this.BQF;
                if (th2 == null) {
                    this.BQF = th;
                    AppMethodBeat.o(118535);
                } else if (th2 instanceof Throwable) {
                    if (th == th2) {
                        AppMethodBeat.o(118535);
                        return;
                    }
                    ArrayList ely = ely();
                    ely.add(th2);
                    ely.add(th);
                    this.BQF = ely;
                    AppMethodBeat.o(118535);
                } else if (!(th2 instanceof ArrayList)) {
                    th2 = new IllegalStateException("State is ".concat(String.valueOf(th2)).toString());
                    AppMethodBeat.o(118535);
                    throw th2;
                } else if (th2 == null) {
                    v vVar = new v("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Throwable> /* = java.util.ArrayList<kotlin.Throwable> */");
                    AppMethodBeat.o(118535);
                    throw vVar;
                } else {
                    ((ArrayList) th2).add(th);
                    AppMethodBeat.o(118535);
                }
            }
        }

        static ArrayList<Throwable> ely() {
            AppMethodBeat.i(118536);
            ArrayList arrayList = new ArrayList(4);
            AppMethodBeat.o(118536);
            return arrayList;
        }

        public final String toString() {
            AppMethodBeat.i(118537);
            String str = "Finishing[cancelling=" + elx() + ", completing=" + this.BQG + ", rootCause=" + this.BQH + ", exceptions=" + this.BQF + ", list=" + this.BQt + ']';
            AppMethodBeat.o(118537);
            return str;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, dWq = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"})
    public static final class c extends kotlinx.coroutines.a.h.a {
        final /* synthetic */ h BQI;
        final /* synthetic */ bg BQJ;
        final /* synthetic */ Object BQK;

        public c(h hVar, h hVar2, bg bgVar, Object obj) {
            this.BQI = hVar;
            this.BQJ = bgVar;
            this.BQK = obj;
            super(hVar2);
        }

        public final /* synthetic */ Object ek(Object obj) {
            AppMethodBeat.i(118366);
            j.p((h) obj, "affected");
            if ((this.BQJ.elt() == this.BQK ? 1 : null) != null) {
                AppMethodBeat.o(118366);
                return null;
            }
            Object elH = g.elH();
            AppMethodBeat.o(118366);
            return elH;
        }
    }

    static {
        AppMethodBeat.i(118623);
        AppMethodBeat.o(118623);
    }

    public bg(boolean z) {
        AppMethodBeat.i(118617);
        this.BPs = z ? bh.BQN : bh.BQM;
        AppMethodBeat.o(118617);
    }

    public final a.c.e.c<?> getKey() {
        return bc.BQx;
    }

    public boolean isActive() {
        AppMethodBeat.i(118585);
        Object elt = elt();
        if ((elt instanceof ay) && ((ay) elt).isActive()) {
            AppMethodBeat.o(118585);
            return true;
        }
        AppMethodBeat.o(118585);
        return false;
    }

    private final boolean a(b bVar, Object obj) {
        Throwable th = null;
        boolean z = false;
        AppMethodBeat.i(118586);
        Throwable illegalArgumentException;
        if (!(obj instanceof ay)) {
            if (elt() == bVar) {
                if (!bVar.isSealed()) {
                    z = true;
                }
                if (!z) {
                    illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
                    AppMethodBeat.o(118586);
                    throw illegalArgumentException;
                } else if (bVar.BQG) {
                    Object obj2;
                    Throwable th2;
                    if (obj instanceof q) {
                        obj2 = obj;
                    } else {
                        obj2 = null;
                    }
                    q qVar = (q) obj2;
                    if (qVar != null) {
                        th = qVar.cause;
                    }
                    synchronized (bVar) {
                        try {
                            ArrayList ely;
                            obj2 = bVar.BQF;
                            if (obj2 == null) {
                                ely = b.ely();
                            } else if (obj2 instanceof Throwable) {
                                ArrayList ely2 = b.ely();
                                ely2.add(obj2);
                                ely = ely2;
                            } else if (!(obj2 instanceof ArrayList)) {
                                illegalArgumentException = new IllegalStateException("State is ".concat(String.valueOf(obj2)).toString());
                                AppMethodBeat.o(118586);
                                throw illegalArgumentException;
                            } else if (obj2 == null) {
                                v vVar = new v("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Throwable> /* = java.util.ArrayList<kotlin.Throwable> */");
                                AppMethodBeat.o(118586);
                                throw vVar;
                            } else {
                                ely = (ArrayList) obj2;
                            }
                            th2 = bVar.BQH;
                            if (th2 != null) {
                                ely.add(0, th2);
                            }
                            if (!(th == null || (j.j(th, th2) ^ 1) == 0)) {
                                ely.add(th);
                            }
                            bVar.BQF = bh.BQL;
                            List list = ely;
                            th2 = a(bVar, list);
                            if (!(th2 == null || b(th2, list))) {
                                illegalArgumentException = bVar.BQH;
                            }
                        } finally {
                            AppMethodBeat.o(118586);
                        }
                    }
                    if (!(th2 == null || th2 == th)) {
                        obj = new q(th2);
                    }
                    if (!(th2 == null || A(th2))) {
                        z(th2);
                    }
                    if (BPt.compareAndSet(this, bVar, obj)) {
                        b((ay) bVar, obj);
                        AppMethodBeat.o(118586);
                        return true;
                    }
                    illegalArgumentException = new IllegalArgumentException(("Unexpected state: " + this.BPs + ", expected: " + bVar + ", update: " + obj).toString());
                    throw illegalArgumentException;
                } else {
                    illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
                    AppMethodBeat.o(118586);
                    throw illegalArgumentException;
                }
            }
            illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
            AppMethodBeat.o(118586);
            throw illegalArgumentException;
        }
        illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
        AppMethodBeat.o(118586);
        throw illegalArgumentException;
    }

    private final Throwable a(b bVar, List<? extends Throwable> list) {
        AppMethodBeat.i(118587);
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
            AppMethodBeat.o(118587);
            return th;
        } else if (bVar.elx()) {
            th = elu();
            AppMethodBeat.o(118587);
            return th;
        } else {
            AppMethodBeat.o(118587);
            return null;
        }
    }

    private static boolean b(Throwable th, List<? extends Throwable> list) {
        boolean z = false;
        AppMethodBeat.i(118588);
        if (list.size() <= 1) {
            AppMethodBeat.o(118588);
        } else {
            Set UZ = e.UZ(list.size());
            for (Throwable th2 : list) {
                boolean z2;
                if (th2 == th || (th2 instanceof CancellationException) || !UZ.add(th2)) {
                    z2 = z;
                } else {
                    a.b.a(th, th2);
                    z2 = true;
                }
                z = z2;
            }
            AppMethodBeat.o(118588);
        }
        return z;
    }

    private final boolean a(ay ayVar, Object obj) {
        AppMethodBeat.i(118589);
        boolean z = (ayVar instanceof ar) || (ayVar instanceof bf);
        Throwable illegalStateException;
        if (z) {
            if (!(!(obj instanceof q))) {
                illegalStateException = new IllegalStateException("Check failed.".toString());
                AppMethodBeat.o(118589);
                throw illegalStateException;
            } else if (BPt.compareAndSet(this, ayVar, obj)) {
                b(ayVar, obj);
                AppMethodBeat.o(118589);
                return true;
            } else {
                AppMethodBeat.o(118589);
                return false;
            }
        }
        illegalStateException = new IllegalStateException("Check failed.".toString());
        AppMethodBeat.o(118589);
        throw illegalStateException;
    }

    private final void b(ay ayVar, Object obj) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(118590);
        m mVar = this.BQA;
        if (mVar != null) {
            mVar.dispose();
            this.BQA = bl.BQP;
        }
        if (obj instanceof q) {
            th = obj;
        } else {
            th = null;
        }
        q qVar = (q) th;
        if (qVar != null) {
            th2 = qVar.cause;
        }
        if (ayVar instanceof bf) {
            try {
                ((bf) ayVar).v(th2);
            } catch (Throwable th3) {
                u(new u("Exception in completion handler " + ayVar + " for " + this, th3));
            }
        } else {
            bk ell = ayVar.ell();
            if (ell != null) {
                b(ell, th2);
            }
        }
        eb(obj);
        AppMethodBeat.o(118590);
    }

    public void ekU() {
    }

    /* JADX WARNING: Missing block: B:5:0x001b, code skipped:
            if (r0 == null) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final CancellationException els() {
        CancellationException c;
        AppMethodBeat.i(118594);
        Object elt = elt();
        Throwable th;
        if (elt instanceof b) {
            th = ((b) elt).BQH;
            if (th != null) {
                c = c(th, "Job is cancelling");
            }
            th = new IllegalStateException("Job is still new or active: ".concat(String.valueOf(this)).toString());
            AppMethodBeat.o(118594);
            throw th;
        } else if (elt instanceof ay) {
            th = new IllegalStateException("Job is still new or active: ".concat(String.valueOf(this)).toString());
            AppMethodBeat.o(118594);
            throw th;
        } else if (elt instanceof q) {
            c = c(((q) elt).cause, "Job was cancelled");
            AppMethodBeat.o(118594);
            return c;
        } else {
            c = new bd("Job has completed normally", null, this);
        }
        AppMethodBeat.o(118594);
        return c;
    }

    private final CancellationException c(Throwable th, String str) {
        AppMethodBeat.i(118595);
        CancellationException cancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (cancellationException == null) {
            cancellationException = new bd(str, th, this);
        }
        AppMethodBeat.o(118595);
        return cancellationException;
    }

    /* JADX WARNING: Missing block: B:28:0x006f, code skipped:
            if (r0 == null) goto L_0x0071;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final bf<?> a(a.f.a.b<? super Throwable, y> bVar, boolean z) {
        a.f.a.b<? super Throwable, y> bVar2 = null;
        Object obj = 1;
        AppMethodBeat.i(118597);
        Throwable illegalArgumentException;
        bf<?> baVar;
        if (z) {
            if (bVar instanceof be) {
                bVar2 = bVar;
            }
            be beVar = (be) bVar2;
            if (beVar != null) {
                if (beVar.BQz != this) {
                    obj = null;
                }
                if (obj == null) {
                    illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
                    AppMethodBeat.o(118597);
                    throw illegalArgumentException;
                } else if (beVar != null) {
                    bf bfVar = beVar;
                    AppMethodBeat.o(118597);
                    return bfVar;
                }
            }
            baVar = new ba(this, bVar);
            AppMethodBeat.o(118597);
            return baVar;
        }
        if (bVar instanceof bf) {
            bVar2 = bVar;
        }
        baVar = (bf) bVar2;
        if (baVar != null) {
            Object obj2 = (baVar.BQz != ((bg) this) || (baVar instanceof be)) ? null : 1;
            if (obj2 == null) {
                illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
                AppMethodBeat.o(118597);
                throw illegalArgumentException;
            }
        }
        baVar = new bb(this, bVar);
        AppMethodBeat.o(118597);
        return baVar;
    }

    private final void a(bf<?> bfVar) {
        AppMethodBeat.i(118599);
        bfVar.b(new bk());
        BPt.compareAndSet(this, bfVar, g.em(bfVar.elJ()));
        AppMethodBeat.o(118599);
    }

    private final bd elu() {
        AppMethodBeat.i(118602);
        bd bdVar = new bd("Job was cancelled", null, this);
        AppMethodBeat.o(118602);
        return bdVar;
    }

    public final Throwable elv() {
        Throwable th;
        Throwable illegalStateException;
        AppMethodBeat.i(118603);
        Object elt = elt();
        if (elt instanceof b) {
            th = ((b) elt).BQH;
        } else if (elt instanceof ay) {
            illegalStateException = new IllegalStateException("Cannot be cancelling child in this state: ".concat(String.valueOf(elt)).toString());
            AppMethodBeat.o(118603);
            throw illegalStateException;
        } else if (elt instanceof q) {
            th = ((q) elt).cause;
        } else {
            th = null;
        }
        if (th == null || !(th instanceof CancellationException)) {
            illegalStateException = new bd("Parent job is " + ej(elt), th, this);
            AppMethodBeat.o(118603);
            return illegalStateException;
        }
        AppMethodBeat.o(118603);
        return th;
    }

    private final Throwable eh(Object obj) {
        AppMethodBeat.i(118604);
        Throwable th;
        if (obj != null ? obj instanceof Throwable : true) {
            if (obj != null) {
                th = (Throwable) obj;
                AppMethodBeat.o(118604);
                return th;
            }
            Throwable elu = elu();
            AppMethodBeat.o(118604);
            return elu;
        } else if (obj == null) {
            v vVar = new v("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
            AppMethodBeat.o(118604);
            throw vVar;
        } else {
            th = ((bn) obj).elv();
            AppMethodBeat.o(118604);
            return th;
        }
    }

    private final bk a(ay ayVar) {
        AppMethodBeat.i(118606);
        bk ell = ayVar.ell();
        if (ell != null) {
            AppMethodBeat.o(118606);
            return ell;
        } else if (ayVar instanceof ar) {
            ell = new bk();
            AppMethodBeat.o(118606);
            return ell;
        } else if (ayVar instanceof bf) {
            a((bf) ayVar);
            AppMethodBeat.o(118606);
            return null;
        } else {
            Throwable illegalStateException = new IllegalStateException("State should have list: ".concat(String.valueOf(ayVar)).toString());
            AppMethodBeat.o(118606);
            throw illegalStateException;
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Missing block: B:60:0x00b2, code skipped:
            if (r0 == null) goto L_0x00b7;
     */
    /* JADX WARNING: Missing block: B:61:0x00b4, code skipped:
            a(r6, r0);
     */
    /* JADX WARNING: Missing block: B:62:0x00b7, code skipped:
            r9 = (kotlinx.coroutines.ay) r9;
     */
    /* JADX WARNING: Missing block: B:63:0x00bb, code skipped:
            if ((r9 instanceof kotlinx.coroutines.n) != false) goto L_0x00e9;
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
            r1 = a((kotlinx.coroutines.a.h) r0);
     */
    /* JADX WARNING: Missing block: B:70:0x00ce, code skipped:
            if (r1 == null) goto L_0x00de;
     */
    /* JADX WARNING: Missing block: B:72:0x00d4, code skipped:
            if (a(r2, r1, r10) == false) goto L_0x00de;
     */
    /* JADX WARNING: Missing block: B:73:0x00d6, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(118607);
     */
    /* JADX WARNING: Missing block: B:75:0x00de, code skipped:
            a(r2, r10);
            com.tencent.matrix.trace.core.AppMethodBeat.o(118607);
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
    public final int L(Object obj, Object obj2) {
        Object obj3 = null;
        n nVar = null;
        AppMethodBeat.i(118607);
        if (!(obj instanceof ay)) {
            AppMethodBeat.o(118607);
            return 0;
        } else if ((!(obj instanceof ar) && !(obj instanceof bf)) || (obj instanceof n) || (obj2 instanceof q)) {
            bk a = a((ay) obj);
            if (a == null) {
                AppMethodBeat.o(118607);
                return 3;
            }
            n nVar2;
            b bVar;
            if (obj instanceof b) {
                nVar2 = obj;
            } else {
                nVar2 = null;
            }
            b bVar2 = (b) nVar2;
            if (bVar2 == null) {
                bVar = new b(a, null);
            } else {
                bVar = bVar2;
            }
            synchronized (bVar) {
                try {
                    if (bVar.BQG) {
                    } else {
                        bVar.BQG = true;
                        if (bVar == obj || BPt.compareAndSet(this, obj, bVar)) {
                            Throwable illegalArgumentException;
                            if ((!bVar.isSealed() ? 1 : null) == null) {
                                illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
                                AppMethodBeat.o(118607);
                                throw illegalArgumentException;
                            }
                            boolean elx = bVar.elx();
                            if (obj2 instanceof q) {
                                nVar2 = obj2;
                            } else {
                                nVar2 = null;
                            }
                            q qVar = (q) nVar2;
                            if (qVar != null) {
                                bVar.B(qVar.cause);
                            }
                            illegalArgumentException = bVar.BQH;
                            if (!elx) {
                                obj3 = 1;
                            }
                            if (obj3 == null) {
                                illegalArgumentException = null;
                            }
                            y yVar = y.AUy;
                        } else {
                            AppMethodBeat.o(118607);
                            return 3;
                        }
                    }
                } finally {
                    AppMethodBeat.o(118607);
                }
            }
        } else if (a((ay) obj, obj2)) {
            AppMethodBeat.o(118607);
            return 1;
        } else {
            AppMethodBeat.o(118607);
            return 3;
        }
        return 0;
    }

    private final boolean a(b bVar, n nVar, Object obj) {
        AppMethodBeat.i(118608);
        n nVar2 = nVar;
        while (kotlinx.coroutines.bc.a.a(nVar2.BPA, false, false, new a(this, bVar, nVar2, obj), 1) == bl.BQP) {
            nVar2 = a((h) nVar2);
            if (nVar2 == null) {
                AppMethodBeat.o(118608);
                return false;
            }
        }
        AppMethodBeat.o(118608);
        return true;
    }

    public final m a(o oVar) {
        AppMethodBeat.i(118610);
        j.p(oVar, "child");
        ap a = kotlinx.coroutines.bc.a.a(this, true, false, new n(this, oVar), 2);
        if (a == null) {
            v vVar = new v("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
            AppMethodBeat.o(118610);
            throw vVar;
        }
        m mVar = (m) a;
        AppMethodBeat.o(118610);
        return mVar;
    }

    public void u(Throwable th) {
        AppMethodBeat.i(118611);
        j.p(th, "exception");
        AppMethodBeat.o(118611);
        throw th;
    }

    /* Access modifiers changed, original: protected */
    public boolean elw() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void z(Throwable th) {
        AppMethodBeat.i(118612);
        j.p(th, "exception");
        AppMethodBeat.o(118612);
    }

    private final boolean A(Throwable th) {
        AppMethodBeat.i(118613);
        if (th instanceof CancellationException) {
            AppMethodBeat.o(118613);
            return true;
        } else if (elw()) {
            m mVar = this.BQA;
            if (mVar == null || !mVar.x(th)) {
                AppMethodBeat.o(118613);
                return false;
            }
            AppMethodBeat.o(118613);
            return true;
        } else {
            AppMethodBeat.o(118613);
            return false;
        }
    }

    public void eb(Object obj) {
    }

    public String toString() {
        AppMethodBeat.i(118614);
        String str = ekV() + '{' + ej(elt()) + "}@" + af.ee(this);
        AppMethodBeat.o(118614);
        return str;
    }

    public String ekV() {
        AppMethodBeat.i(118615);
        String ef = af.ef(this);
        AppMethodBeat.o(118615);
        return ef;
    }

    private static String ej(Object obj) {
        AppMethodBeat.i(118616);
        String str;
        if (obj instanceof b) {
            if (((b) obj).elx()) {
                str = "Cancelling";
                AppMethodBeat.o(118616);
                return str;
            } else if (((b) obj).BQG) {
                str = "Completing";
                AppMethodBeat.o(118616);
                return str;
            } else {
                str = "Active";
                AppMethodBeat.o(118616);
                return str;
            }
        } else if (obj instanceof ay) {
            if (((ay) obj).isActive()) {
                str = "Active";
                AppMethodBeat.o(118616);
                return str;
            }
            str = "New";
            AppMethodBeat.o(118616);
            return str;
        } else if (obj instanceof q) {
            str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED;
            AppMethodBeat.o(118616);
            return str;
        } else {
            str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
            AppMethodBeat.o(118616);
            return str;
        }
    }

    public final Object elt() {
        AppMethodBeat.i(118584);
        while (true) {
            Object obj = this.BPs;
            if (obj instanceof k) {
                ((k) obj).el(this);
            } else {
                AppMethodBeat.o(118584);
                return obj;
            }
        }
    }

    /* JADX WARNING: Missing block: B:17:0x003e, code skipped:
            if (r2 == null) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(bk bkVar, Throwable th) {
        AppMethodBeat.i(118591);
        Throwable th2 = null;
        Object elJ = bkVar.elJ();
        if (elJ == null) {
            v vVar = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            AppMethodBeat.o(118591);
            throw vVar;
        }
        Object obj = (h) elJ;
        while ((j.j(obj, bkVar) ^ 1) != 0) {
            Throwable th3;
            if (obj instanceof be) {
                bf bfVar = (bf) obj;
                try {
                    bfVar.v(th);
                    th3 = th2;
                } catch (Throwable th4) {
                    if (th2 != null) {
                        a.b.a(th2, th4);
                    }
                    th3 = new u("Exception in completion handler " + bfVar + " for " + this, th4);
                    y yVar = y.AUy;
                }
                obj = obj.elK();
                th2 = th3;
            }
            th3 = th2;
            obj = obj.elK();
            th2 = th3;
        }
        if (th2 != null) {
            u(th2);
        }
        A(th);
        AppMethodBeat.o(118591);
    }

    /* JADX WARNING: Missing block: B:17:0x003e, code skipped:
            if (r2 == null) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(bk bkVar, Throwable th) {
        AppMethodBeat.i(118592);
        Throwable th2 = null;
        Object elJ = bkVar.elJ();
        if (elJ == null) {
            v vVar = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            AppMethodBeat.o(118592);
            throw vVar;
        }
        Object obj = (h) elJ;
        while ((j.j(obj, bkVar) ^ 1) != 0) {
            Throwable th3;
            if (obj instanceof bf) {
                bf bfVar = (bf) obj;
                try {
                    bfVar.v(th);
                    th3 = th2;
                } catch (Throwable th4) {
                    if (th2 != null) {
                        a.b.a(th2, th4);
                    }
                    th3 = new u("Exception in completion handler " + bfVar + " for " + this, th4);
                    y yVar = y.AUy;
                }
                obj = obj.elK();
                th2 = th3;
            }
            th3 = th2;
            obj = obj.elK();
            th2 = th3;
        }
        if (th2 != null) {
            u(th2);
            AppMethodBeat.o(118592);
            return;
        }
        AppMethodBeat.o(118592);
    }

    public final boolean start() {
        AppMethodBeat.i(118593);
        while (true) {
            Object obj;
            Object elt = elt();
            int obj2;
            if (elt instanceof ar) {
                if (!((ar) elt).csi) {
                    if (BPt.compareAndSet(this, elt, bh.BQN)) {
                        ekU();
                        obj2 = 1;
                    } else {
                        obj2 = -1;
                    }
                }
                obj2 = null;
            } else {
                if (elt instanceof ax) {
                    if (BPt.compareAndSet(this, elt, ((ax) elt).BQt)) {
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
                    AppMethodBeat.o(118593);
                    return false;
                case 1:
                    AppMethodBeat.o(118593);
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
    public final ap a(boolean z, boolean z2, a.f.a.b<? super Throwable, y> bVar) {
        ap apVar;
        Object obj = null;
        AppMethodBeat.i(118596);
        j.p(bVar, "handler");
        Object obj2 = null;
        while (true) {
            Object elt = elt();
            bf a;
            Object obj3;
            bf bfVar;
            bf obj32;
            if (elt instanceof ar) {
                if (((ar) elt).csi) {
                    if (obj2 == null) {
                        a = a((a.f.a.b) bVar, z);
                        obj32 = a;
                        bfVar = a;
                    } else {
                        obj32 = obj2;
                        bfVar = obj2;
                    }
                    if (BPt.compareAndSet(this, elt, obj32)) {
                        apVar = (ap) obj32;
                        AppMethodBeat.o(118596);
                        return apVar;
                    }
                    obj2 = bfVar;
                } else {
                    ar arVar = (ar) elt;
                    bk bkVar = new bk();
                    if (!arVar.csi) {
                        obj32 = new ax(bkVar);
                    }
                    BPt.compareAndSet(this, arVar, bkVar);
                }
            } else if (elt instanceof ay) {
                bk ell = ((ay) elt).ell();
                if (ell != null) {
                    bf a2;
                    Object obj4;
                    apVar = bl.BQP;
                    if (z && (elt instanceof b)) {
                        synchronized (elt) {
                            try {
                                Throwable th = ((b) elt).BQH;
                                if (th == null || ((bVar instanceof n) && !((b) elt).BQG)) {
                                    if (obj2 == null) {
                                        a2 = a((a.f.a.b) bVar, z);
                                        obj32 = a2;
                                        bfVar = a2;
                                    } else {
                                        obj32 = obj2;
                                        bfVar = obj2;
                                    }
                                    if (!a(elt, ell, obj32)) {
                                    } else if (th == null) {
                                        break;
                                    } else {
                                        apVar = obj32;
                                        a2 = bfVar;
                                    }
                                }
                                y yVar = y.AUy;
                            } finally {
                                AppMethodBeat.o(118596);
                            }
                        }
                    } else {
                        obj4 = null;
                        a = obj2;
                    }
                    if (obj4 != null) {
                        if (z2) {
                            bVar.am(obj4);
                        }
                        AppMethodBeat.o(118596);
                        return apVar;
                    }
                    if (a == null) {
                        a = a((a.f.a.b) bVar, z);
                        obj32 = a;
                        obj2 = a;
                    } else {
                        obj32 = a;
                        a2 = a;
                    }
                    if (a(elt, ell, obj32)) {
                        apVar = obj32;
                        AppMethodBeat.o(118596);
                        return apVar;
                    }
                } else if (elt == null) {
                    v vVar = new v("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                    AppMethodBeat.o(118596);
                    throw vVar;
                } else {
                    a((bf) elt);
                }
            } else {
                if (z2) {
                    if (elt instanceof q) {
                        obj32 = elt;
                    } else {
                        obj32 = null;
                    }
                    q qVar = (q) obj32;
                    if (qVar != null) {
                        obj = qVar.cause;
                    }
                    bVar.am(obj);
                }
                apVar = bl.BQP;
                AppMethodBeat.o(118596);
                return apVar;
            }
        }
        return apVar;
    }

    private final boolean a(Object obj, bk bkVar, bf<?> bfVar) {
        AppMethodBeat.i(118598);
        kotlinx.coroutines.a.h.a cVar = new c(bfVar, bfVar, this, obj);
        while (true) {
            Object elL = bkVar.elL();
            if (elL == null) {
                v vVar = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                AppMethodBeat.o(118598);
                throw vVar;
            }
            switch (((h) elL).a(bfVar, bkVar, cVar)) {
                case 1:
                    AppMethodBeat.o(118598);
                    return true;
                case 2:
                    AppMethodBeat.o(118598);
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
            a(((kotlinx.coroutines.bg.b) r2).BQt, r6);
     */
    /* JADX WARNING: Missing block: B:23:0x0052, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(118605);
     */
    /* JADX WARNING: Missing block: B:75:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean ei(Object obj) {
        Throwable th = null;
        Object obj2 = null;
        AppMethodBeat.i(118605);
        Throwable th2 = null;
        while (true) {
            Object elt = elt();
            Throwable th3;
            if (elt instanceof b) {
                synchronized (elt) {
                    try {
                        if (((b) elt).isSealed()) {
                        } else {
                            boolean elx = ((b) elt).elx();
                            if (!(obj == null && elx)) {
                                if (th2 == null) {
                                    th2 = eh(obj);
                                }
                                ((b) elt).B(th2);
                            }
                            th3 = ((b) elt).BQH;
                            if (!elx) {
                                obj2 = 1;
                            }
                            if (obj2 != null) {
                                th = th3;
                            }
                        }
                    } finally {
                        AppMethodBeat.o(118605);
                    }
                }
            } else if (elt instanceof ay) {
                Throwable th4;
                Throwable th5;
                if (th2 == null) {
                    th3 = eh(obj);
                    th4 = th3;
                    th5 = th3;
                } else {
                    th4 = th2;
                    th5 = th2;
                }
                if (((ay) elt).isActive()) {
                    ay ayVar = (ay) elt;
                    if ((!(ayVar instanceof b) ? 1 : null) == null) {
                        th3 = new IllegalStateException("Check failed.".toString());
                        AppMethodBeat.o(118605);
                        throw th3;
                    } else if (ayVar.isActive()) {
                        Object obj3;
                        bk a = a(ayVar);
                        if (a == null) {
                            obj3 = null;
                        } else {
                            if (BPt.compareAndSet(this, ayVar, new b(a, th4))) {
                                a(a, th4);
                                int obj32 = 1;
                            } else {
                                obj32 = null;
                            }
                        }
                        if (obj32 != null) {
                            AppMethodBeat.o(118605);
                            return true;
                        }
                        th2 = th5;
                    } else {
                        th3 = new IllegalStateException("Check failed.".toString());
                        AppMethodBeat.o(118605);
                        throw th3;
                    }
                }
                switch (L(elt, new q(th4))) {
                    case 0:
                        th3 = new IllegalStateException("Cannot happen in ".concat(String.valueOf(elt)).toString());
                        AppMethodBeat.o(118605);
                        throw th3;
                    case 1:
                    case 2:
                        AppMethodBeat.o(118605);
                        return true;
                    case 3:
                        th2 = th5;
                        break;
                    default:
                        th3 = new IllegalStateException("unexpected result".toString());
                        AppMethodBeat.o(118605);
                        throw th3;
                }
            } else {
                AppMethodBeat.o(118605);
                return false;
            }
        }
        return false;
    }

    public final boolean y(Throwable th) {
        AppMethodBeat.i(118600);
        if (ei(th)) {
            AppMethodBeat.o(118600);
            return true;
        }
        AppMethodBeat.o(118600);
        return false;
    }

    public final void a(bn bnVar) {
        AppMethodBeat.i(118601);
        j.p(bnVar, "parentJob");
        ei(bnVar);
        AppMethodBeat.o(118601);
    }

    private static n a(h hVar) {
        AppMethodBeat.i(118609);
        while (hVar.elJ() instanceof kotlinx.coroutines.a.l) {
            hVar = g.em(hVar.elL());
        }
        h hVar2 = hVar;
        while (true) {
            hVar2 = g.em(hVar2.elJ());
            if (!(hVar2.elJ() instanceof kotlinx.coroutines.a.l)) {
                if (hVar2 instanceof n) {
                    n nVar = (n) hVar2;
                    AppMethodBeat.o(118609);
                    return nVar;
                } else if (hVar2 instanceof bk) {
                    AppMethodBeat.o(118609);
                    return null;
                }
            }
        }
    }

    public a.c.e plus(a.c.e eVar) {
        AppMethodBeat.i(118618);
        j.p(eVar, "context");
        j.p(eVar, "context");
        a.c.e a = a.c.e.b.a.a((a.c.e.b) this, eVar);
        AppMethodBeat.o(118618);
        return a;
    }

    public <R> R fold(R r, m<? super R, ? super a.c.e.b, ? extends R> mVar) {
        AppMethodBeat.i(118619);
        j.p(mVar, "operation");
        j.p(mVar, "operation");
        Object a = a.c.e.b.a.a(this, r, mVar);
        AppMethodBeat.o(118619);
        return a;
    }

    public <E extends a.c.e.b> E get(a.c.e.c<E> cVar) {
        AppMethodBeat.i(118620);
        j.p(cVar, "key");
        j.p(cVar, "key");
        a.c.e.b a = a.c.e.b.a.a((a.c.e.b) this, (a.c.e.c) cVar);
        AppMethodBeat.o(118620);
        return a;
    }

    public a.c.e minusKey(a.c.e.c<?> cVar) {
        AppMethodBeat.i(118621);
        j.p(cVar, "key");
        j.p(cVar, "key");
        a.c.e b = a.c.e.b.a.b(this, cVar);
        AppMethodBeat.o(118621);
        return b;
    }

    public static final /* synthetic */ void a(bg bgVar, b bVar, n nVar, Object obj) {
        AppMethodBeat.i(118622);
        if ((bgVar.elt() == bVar ? 1 : null) == null) {
            Throwable illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
            AppMethodBeat.o(118622);
            throw illegalArgumentException;
        }
        n a = a((h) nVar);
        if (a == null || !bgVar.a(bVar, a, obj)) {
            bgVar.a(bVar, obj);
        }
        AppMethodBeat.o(118622);
    }
}
