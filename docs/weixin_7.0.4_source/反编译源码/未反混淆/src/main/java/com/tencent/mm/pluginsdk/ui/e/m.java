package com.tencent.mm.pluginsdk.ui.e;

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
import com.tencent.mm.R;
import com.tencent.mm.kiss.widget.textview.StaticTextView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class m implements OnTouchListener {
    private static boolean DEBUG = false;
    private static int LO = ViewConfiguration.getTapTimeout();
    private static int vso;
    String hcl;
    private boolean iYA = false;
    private View view;
    private n vsl = null;
    private boolean vsm = false;
    private View vsn = null;
    private Context vsp = null;
    private ak vsq = new ak(Looper.getMainLooper());
    private b vsr = new b(this, (byte) 0);
    private a vss = new a();

    class a implements Runnable {
        a() {
        }

        public final void run() {
            AppMethodBeat.i(79868);
            if (m.this.view != null && m.this.view.isPressed()) {
                ab.d("MicroMsg.PressSpanTouchListener", "long pressed timeout");
                m.this.iYA = true;
                m.this.bHM();
            }
            AppMethodBeat.o(79868);
        }
    }

    class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(m mVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(79869);
            m.a(m.this, m.LO);
            AppMethodBeat.o(79869);
        }
    }

    static /* synthetic */ void a(m mVar, int i) {
        AppMethodBeat.i(79876);
        mVar.Lo(i);
        AppMethodBeat.o(79876);
    }

    static {
        AppMethodBeat.i(79877);
        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
        vso = longPressTimeout;
        if (longPressTimeout > LO * 2) {
            vso -= LO;
        }
        ab.d("MicroMsg.PressSpanTouchListener", "long press timeout:%d", Integer.valueOf(vso));
        AppMethodBeat.o(79877);
    }

    public m() {
        AppMethodBeat.i(79870);
        AppMethodBeat.o(79870);
    }

    public m(Context context) {
        AppMethodBeat.i(79871);
        this.vsp = context;
        AppMethodBeat.o(79871);
    }

    /* JADX WARNING: Missing block: B:44:0x016f, code skipped:
            if (r6 > (((com.tencent.mm.kiss.widget.textview.StaticTextView) r12).getVerticalDrawOffset() + r3.getHeight())) goto L_0x0171;
     */
    /* JADX WARNING: Missing block: B:56:0x01ab, code skipped:
            if (r6 > (((android.widget.TextView) r12).getTotalPaddingTop() + r3.getHeight())) goto L_0x01ad;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(79872);
        if ((view instanceof TextView) || (view instanceof StaticTextView)) {
            CharSequence text;
            Object obj;
            if (motionEvent.getAction() == 0) {
                view.setTag(R.id.cy, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
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
                ab.d("MicroMsg.PressSpanTouchListener", "ontouch action: %d, isLongPress:%b " + obj2 + " " + (text instanceof Spanned) + " " + bo.dpG().toString(), Integer.valueOf(motionEvent.getAction()), Boolean.valueOf(this.iYA));
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            if ((text instanceof Spanned) && obj2 != null) {
                Spanned spanned = (Spanned) text;
                int action = obtain.getAction();
                view.invalidate();
                if (view == null || spanned == null || !e.a(view, spanned)) {
                    if (action == 1 || action == 0 || action == 2 || action == 3) {
                        int x = (int) obtain.getX();
                        int y = (int) obtain.getY();
                        if (view instanceof StaticTextView) {
                            if (x >= ((StaticTextView) view).getHorizontalDrawOffset()) {
                                if (x <= ((StaticTextView) view).getHorizontalDrawOffset() + obj2.getWidth()) {
                                    if (y >= ((StaticTextView) view).getVerticalDrawOffset()) {
                                    }
                                    L(obtain);
                                }
                            }
                            L(obtain);
                        } else if (view instanceof TextView) {
                            if (x >= ((TextView) view).getTotalPaddingLeft()) {
                                if (x <= ((TextView) view).getTotalPaddingLeft() + obj2.getWidth()) {
                                    if (y >= ((TextView) view).getTotalPaddingTop()) {
                                    }
                                    L(obtain);
                                }
                            }
                            L(obtain);
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
                        n[] nVarArr = (n[]) spanned.getSpans(action, action, n.class);
                        action = nVarArr.length - 1;
                        if (DEBUG) {
                            ab.d("MicroMsg.PressSpanTouchListener", "processPress action: %d, isLongPress:%b " + nVarArr.length + " " + this.vsl + " " + bo.dpG().toString(), Integer.valueOf(obtain.getAction()), Boolean.valueOf(this.iYA));
                        }
                        if (nVarArr.length == 0) {
                            bHM();
                        } else if (x == 1) {
                            this.vsq.removeCallbacks(this.vsr);
                            this.vsq.removeCallbacks(this.vss);
                            if (this.iYA) {
                                bHM();
                                this.iYA = false;
                                view.setClickable(this.vsm);
                                if (DEBUG) {
                                    ab.i("MicroMsg.PressSpanTouchListener", "processPress action1 " + obtain.getAction());
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
                                    ab.e("MicroMsg.PressSpanTouchListener", "ACTION_UP error, lastClickSpan is null");
                                }
                                view.setClickable(this.vsm);
                                bHM();
                                if (DEBUG) {
                                    ab.i("MicroMsg.PressSpanTouchListener", "processPress action2 " + obtain.getAction());
                                }
                            }
                        } else if (x == 0 || x == 2) {
                            if (x == 0 && vso > 0) {
                                Lo(0);
                            }
                            if (x == 0) {
                                this.vsm = view.isClickable();
                            }
                            bHM();
                            this.vsl = nVarArr[action];
                            this.vsn = view;
                            nVarArr[action].setContext(null);
                            nVarArr[action].ozq = true;
                            nVarArr[action].mEnable = true;
                            view.invalidate();
                            if (this.iYA) {
                                nVarArr[action].ozq = false;
                                nVarArr[action].mEnable = false;
                                view.setClickable(this.vsm);
                                if (DEBUG) {
                                    ab.i("MicroMsg.PressSpanTouchListener", "processPress action3 " + obtain.getAction());
                                }
                            } else if (DEBUG) {
                                ab.i("MicroMsg.PressSpanTouchListener", "processPress action4 " + obtain.getAction());
                            }
                        } else if (x == 3) {
                            this.vsq.removeCallbacks(this.vsr);
                            this.vsq.removeCallbacks(this.vss);
                            view.setClickable(this.vsm);
                            bHM();
                            if (DEBUG) {
                                ab.i("MicroMsg.PressSpanTouchListener", "processPress action5 " + obtain.getAction());
                            }
                        }
                        if (x == 1) {
                            this.iYA = false;
                        }
                        if (DEBUG) {
                            ab.i("MicroMsg.PressSpanTouchListener", "processPress action6 " + obtain.getAction());
                        }
                    }
                    if (DEBUG) {
                        ab.i("MicroMsg.PressSpanTouchListener", "processTouch action2 " + obtain.getAction());
                    }
                }
            }
            obtain.recycle();
            if (DEBUG) {
                ab.d("MicroMsg.PressSpanTouchListener", "ontouch action2: %d, isLongPress:%b " + obj2 + " " + (text instanceof Spanned) + " processResult: false " + bo.dpG().toString(), Integer.valueOf(motionEvent.getAction()), Boolean.valueOf(this.iYA));
            }
            AppMethodBeat.o(79872);
            return false;
        }
        AppMethodBeat.o(79872);
        return false;
    }

    private void L(MotionEvent motionEvent) {
        AppMethodBeat.i(79873);
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            bHM();
        }
        AppMethodBeat.o(79873);
    }

    public final void bHM() {
        AppMethodBeat.i(79874);
        if (this.vsl != null) {
            this.vsl.ozq = false;
            this.vsl.setContext(null);
            this.vsn.invalidate();
            this.vsn = null;
            this.vsl = null;
        }
        AppMethodBeat.o(79874);
    }

    private void Lo(int i) {
        AppMethodBeat.i(79875);
        if (this.view != null) {
            this.vsq.postDelayed(this.vss, (long) (vso - i));
        }
        AppMethodBeat.o(79875);
    }
}
