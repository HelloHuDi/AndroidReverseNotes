package com.tencent.p177mm.pluginsdk.p597ui.p598e;

import android.content.Context;
import android.os.Looper;
import android.text.Layout;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kiss.widget.textview.StaticTextView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.pluginsdk.ui.e.m */
public final class C30132m implements OnTouchListener {
    private static boolean DEBUG = false;
    /* renamed from: LO */
    private static int f13731LO = ViewConfiguration.getTapTimeout();
    private static int vso;
    String hcl;
    private boolean iYA = false;
    private View view;
    private C23322n vsl = null;
    private boolean vsm = false;
    private View vsn = null;
    private Context vsp = null;
    private C7306ak vsq = new C7306ak(Looper.getMainLooper());
    private C30134b vsr = new C30134b(this, (byte) 0);
    private C30133a vss = new C30133a();

    /* renamed from: com.tencent.mm.pluginsdk.ui.e.m$a */
    class C30133a implements Runnable {
        C30133a() {
        }

        public final void run() {
            AppMethodBeat.m2504i(79868);
            if (C30132m.this.view != null && C30132m.this.view.isPressed()) {
                C4990ab.m7410d("MicroMsg.PressSpanTouchListener", "long pressed timeout");
                C30132m.this.iYA = true;
                C30132m.this.bHM();
            }
            AppMethodBeat.m2505o(79868);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.e.m$b */
    class C30134b implements Runnable {
        private C30134b() {
        }

        /* synthetic */ C30134b(C30132m c30132m, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(79869);
            C30132m.m47704a(C30132m.this, C30132m.f13731LO);
            AppMethodBeat.m2505o(79869);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m47704a(C30132m c30132m, int i) {
        AppMethodBeat.m2504i(79876);
        c30132m.m47702Lo(i);
        AppMethodBeat.m2505o(79876);
    }

    static {
        AppMethodBeat.m2504i(79877);
        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
        vso = longPressTimeout;
        if (longPressTimeout > f13731LO * 2) {
            vso -= f13731LO;
        }
        C4990ab.m7411d("MicroMsg.PressSpanTouchListener", "long press timeout:%d", Integer.valueOf(vso));
        AppMethodBeat.m2505o(79877);
    }

    public C30132m() {
        AppMethodBeat.m2504i(79870);
        AppMethodBeat.m2505o(79870);
    }

    public C30132m(Context context) {
        AppMethodBeat.m2504i(79871);
        this.vsp = context;
        AppMethodBeat.m2505o(79871);
    }

    /* JADX WARNING: Missing block: B:44:0x016f, code skipped:
            if (r6 > (((com.tencent.p177mm.kiss.widget.textview.StaticTextView) r12).getVerticalDrawOffset() + r3.getHeight())) goto L_0x0171;
     */
    /* JADX WARNING: Missing block: B:56:0x01ab, code skipped:
            if (r6 > (((android.widget.TextView) r12).getTotalPaddingTop() + r3.getHeight())) goto L_0x01ad;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(79872);
        if ((view instanceof TextView) || (view instanceof StaticTextView)) {
            CharSequence text;
            Object obj;
            if (motionEvent.getAction() == 0) {
                view.setTag(2131820679, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
            }
            this.view = view;
            Layout layout;
            if (view instanceof TextView) {
                layout = ((TextView) view).getLayout();
                text = ((TextView) view).getText();
                obj = layout;
            } else {
                layout = ((StaticTextView) view).getTvLayout();
                text = ((StaticTextView) view).getText();
                Layout obj2 = layout;
            }
            if (DEBUG) {
                C4990ab.m7411d("MicroMsg.PressSpanTouchListener", "ontouch action: %d, isLongPress:%b " + obj2 + " " + (text instanceof Spanned) + " " + C5046bo.dpG().toString(), Integer.valueOf(motionEvent.getAction()), Boolean.valueOf(this.iYA));
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            if ((text instanceof Spanned) && obj2 != null) {
                Spanned spanned = (Spanned) text;
                int action = obtain.getAction();
                view.invalidate();
                if (view == null || spanned == null || !C23305e.m35789a(view, spanned)) {
                    if (action == 1 || action == 0 || action == 2 || action == 3) {
                        int x = (int) obtain.getX();
                        int y = (int) obtain.getY();
                        if (view instanceof StaticTextView) {
                            if (x >= ((StaticTextView) view).getHorizontalDrawOffset()) {
                                if (x <= ((StaticTextView) view).getHorizontalDrawOffset() + obj2.getWidth()) {
                                    if (y >= ((StaticTextView) view).getVerticalDrawOffset()) {
                                    }
                                    m47701L(obtain);
                                }
                            }
                            m47701L(obtain);
                        } else if (view instanceof TextView) {
                            if (x >= ((TextView) view).getTotalPaddingLeft()) {
                                if (x <= ((TextView) view).getTotalPaddingLeft() + obj2.getWidth()) {
                                    if (y >= ((TextView) view).getTotalPaddingTop()) {
                                    }
                                    m47701L(obtain);
                                }
                            }
                            m47701L(obtain);
                        }
                        if (view instanceof TextView) {
                            x -= ((TextView) view).getTotalPaddingLeft();
                            action = y - ((TextView) view).getTotalPaddingTop();
                        } else if (view instanceof StaticTextView) {
                            x -= ((StaticTextView) view).getHorizontalDrawOffset();
                            action = y - ((StaticTextView) view).getVerticalDrawOffset();
                        } else {
                            x -= view.getPaddingLeft();
                            action = y - view.getPaddingTop();
                        }
                        action = obj2.getOffsetForHorizontal(obj2.getLineForVertical(action + view.getScrollY()), (float) (x + view.getScrollX()));
                        if ((view instanceof TextView) && action < spanned.length()) {
                            action++;
                        }
                        x = obtain.getAction();
                        C23322n[] c23322nArr = (C23322n[]) spanned.getSpans(action, action, C23322n.class);
                        action = c23322nArr.length - 1;
                        if (DEBUG) {
                            C4990ab.m7411d("MicroMsg.PressSpanTouchListener", "processPress action: %d, isLongPress:%b " + c23322nArr.length + " " + this.vsl + " " + C5046bo.dpG().toString(), Integer.valueOf(obtain.getAction()), Boolean.valueOf(this.iYA));
                        }
                        if (c23322nArr.length == 0) {
                            bHM();
                        } else if (x == 1) {
                            this.vsq.removeCallbacks(this.vsr);
                            this.vsq.removeCallbacks(this.vss);
                            if (this.iYA) {
                                bHM();
                                this.iYA = false;
                                view.setClickable(this.vsm);
                                if (DEBUG) {
                                    C4990ab.m7416i("MicroMsg.PressSpanTouchListener", "processPress action1 " + obtain.getAction());
                                }
                            } else {
                                this.iYA = false;
                                if (this.vsl != null) {
                                    this.vsl.setSessionId(this.hcl);
                                    if (this.vsp != null) {
                                        this.vsl.setContext(this.vsp);
                                    }
                                    this.vsl.onClick(view);
                                } else {
                                    C4990ab.m7412e("MicroMsg.PressSpanTouchListener", "ACTION_UP error, lastClickSpan is null");
                                }
                                view.setClickable(this.vsm);
                                bHM();
                                if (DEBUG) {
                                    C4990ab.m7416i("MicroMsg.PressSpanTouchListener", "processPress action2 " + obtain.getAction());
                                }
                            }
                        } else if (x == 0 || x == 2) {
                            if (x == 0 && vso > 0) {
                                m47702Lo(0);
                            }
                            if (x == 0) {
                                this.vsm = view.isClickable();
                            }
                            bHM();
                            this.vsl = c23322nArr[action];
                            this.vsn = view;
                            c23322nArr[action].setContext(null);
                            c23322nArr[action].ozq = true;
                            c23322nArr[action].mEnable = true;
                            view.invalidate();
                            if (this.iYA) {
                                c23322nArr[action].ozq = false;
                                c23322nArr[action].mEnable = false;
                                view.setClickable(this.vsm);
                                if (DEBUG) {
                                    C4990ab.m7416i("MicroMsg.PressSpanTouchListener", "processPress action3 " + obtain.getAction());
                                }
                            } else if (DEBUG) {
                                C4990ab.m7416i("MicroMsg.PressSpanTouchListener", "processPress action4 " + obtain.getAction());
                            }
                        } else if (x == 3) {
                            this.vsq.removeCallbacks(this.vsr);
                            this.vsq.removeCallbacks(this.vss);
                            view.setClickable(this.vsm);
                            bHM();
                            if (DEBUG) {
                                C4990ab.m7416i("MicroMsg.PressSpanTouchListener", "processPress action5 " + obtain.getAction());
                            }
                        }
                        if (x == 1) {
                            this.iYA = false;
                        }
                        if (DEBUG) {
                            C4990ab.m7416i("MicroMsg.PressSpanTouchListener", "processPress action6 " + obtain.getAction());
                        }
                    }
                    if (DEBUG) {
                        C4990ab.m7416i("MicroMsg.PressSpanTouchListener", "processTouch action2 " + obtain.getAction());
                    }
                }
            }
            obtain.recycle();
            if (DEBUG) {
                C4990ab.m7411d("MicroMsg.PressSpanTouchListener", "ontouch action2: %d, isLongPress:%b " + obj2 + " " + (text instanceof Spanned) + " processResult: false " + C5046bo.dpG().toString(), Integer.valueOf(motionEvent.getAction()), Boolean.valueOf(this.iYA));
            }
            AppMethodBeat.m2505o(79872);
            return false;
        }
        AppMethodBeat.m2505o(79872);
        return false;
    }

    /* renamed from: L */
    private void m47701L(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(79873);
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            bHM();
        }
        AppMethodBeat.m2505o(79873);
    }

    public final void bHM() {
        AppMethodBeat.m2504i(79874);
        if (this.vsl != null) {
            this.vsl.ozq = false;
            this.vsl.setContext(null);
            this.vsn.invalidate();
            this.vsn = null;
            this.vsl = null;
        }
        AppMethodBeat.m2505o(79874);
    }

    /* renamed from: Lo */
    private void m47702Lo(int i) {
        AppMethodBeat.m2504i(79875);
        if (this.view != null) {
            this.vsq.postDelayed(this.vss, (long) (vso - i));
        }
        AppMethodBeat.m2505o(79875);
    }
}
