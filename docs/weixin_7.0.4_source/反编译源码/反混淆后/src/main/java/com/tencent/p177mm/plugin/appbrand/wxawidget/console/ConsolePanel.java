package com.tencent.p177mm.plugin.appbrand.wxawidget.console;

import android.app.Activity;
import android.content.Context;
import android.support.p069v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.LogInfo;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.p177mm.plugin.appbrand.wxawidget.C38625a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel */
public class ConsolePanel extends FrameLayout implements C38625a {
    MRecyclerView iIE;
    final List<LogInfo> jpE = new LinkedList();
    EditText jpK;
    Button[] jpL;
    Button jpM;
    Button jpN;
    C2598a jpO;
    int jpP;
    String jpQ;

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel$5 */
    class C110555 implements OnFocusChangeListener {
        C110555() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(11141);
            if (!z) {
                C42750f.m75786cX(view);
            }
            AppMethodBeat.m2505o(11141);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel$3 */
    class C274323 implements TextWatcher {
        C274323() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel$4 */
    class C274334 implements OnKeyListener {
        C274334() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(11140);
            if (i == 66) {
                ConsolePanel.this.jpQ = ConsolePanel.this.jpK.getText().toString();
                ConsolePanel.m84493a(ConsolePanel.this);
                C42750f.m75786cX(view);
                AppMethodBeat.m2505o(11140);
                return true;
            }
            AppMethodBeat.m2505o(11140);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel$6 */
    class C274346 implements OnClickListener {
        C274346() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(11142);
            ConsolePanel.this.jpQ = ConsolePanel.this.jpK.getText().toString();
            ConsolePanel.m84493a(ConsolePanel.this);
            AppMethodBeat.m2505o(11142);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel$7 */
    class C386267 implements OnTouchListener {
        C386267() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(11143);
            C42750f.m75786cX(view);
            AppMethodBeat.m2505o(11143);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel$2 */
    class C427492 implements OnClickListener {
        C427492() {
        }

        public final void onClick(View view) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel$1 */
    class C457271 implements OnClickListener {
        C457271() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(11139);
            ConsolePanel.this.jpE.clear();
            ConsolePanel.this.jpO.jpE.clear();
            ConsolePanel.this.jpO.aop.notifyChanged();
            AppMethodBeat.m2505o(11139);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel$8 */
    class C457288 implements OnClickListener {
        C457288() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(11144);
            int i = 0;
            while (i < ConsolePanel.this.jpL.length) {
                boolean z;
                View view2 = ConsolePanel.this.jpL[i];
                if (view2 == view) {
                    z = true;
                } else {
                    z = false;
                }
                view2.setSelected(z);
                if (z && ConsolePanel.this.jpP != i) {
                    ConsolePanel.this.jpP = i;
                    ConsolePanel.m84493a(ConsolePanel.this);
                }
                i++;
            }
            AppMethodBeat.m2505o(11144);
        }
    }

    public ConsolePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(11146);
        initialize();
        AppMethodBeat.m2505o(11146);
    }

    public ConsolePanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(11147);
        initialize();
        AppMethodBeat.m2505o(11147);
    }

    private void initialize() {
        AppMethodBeat.m2504i(11148);
        LayoutInflater.from(getContext()).inflate(2130969194, this, true);
        this.jpK = (EditText) findViewById(2131822954);
        this.jpK.clearFocus();
        this.jpL = new Button[5];
        m84494dx(0, 2131822958);
        m84494dx(1, 2131822959);
        m84494dx(2, 2131822960);
        m84494dx(3, 2131822961);
        m84494dx(4, 2131822962);
        this.jpL[0].setSelected(true);
        this.jpP = 0;
        this.jpM = (Button) findViewById(2131822956);
        this.jpN = (Button) findViewById(2131822957);
        this.jpN.setEnabled(false);
        this.jpM.setOnClickListener(new C457271());
        this.jpN.setOnClickListener(new C427492());
        this.jpK.addTextChangedListener(new C274323());
        this.jpK.setOnKeyListener(new C274334());
        this.jpK.setOnFocusChangeListener(new C110555());
        findViewById(2131822955).setOnClickListener(new C274346());
        setOnTouchListener(new C386267());
        this.iIE = (MRecyclerView) findViewById(2131822963);
        this.jpO = new C2598a(getContext());
        MRecyclerView mRecyclerView = this.iIE;
        getContext();
        mRecyclerView.setLayoutManager(new LinearLayoutManager());
        this.iIE.setItemAnimator(null);
        this.iIE.setAdapter(this.jpO);
        AppMethodBeat.m2505o(11148);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(11149);
        if (motionEvent.getAction() == 0) {
            int i;
            View currentFocus = ((Activity) getContext()).getCurrentFocus();
            if (currentFocus != null && (currentFocus instanceof EditText)) {
                int[] iArr = new int[]{0, 0};
                currentFocus.getLocationInWindow(iArr);
                int i2 = iArr[0];
                i = iArr[1];
                int height = currentFocus.getHeight() + i;
                int width = currentFocus.getWidth() + i2;
                if (motionEvent.getX() <= ((float) i2) || motionEvent.getX() >= ((float) width) || motionEvent.getY() <= ((float) i) || motionEvent.getY() >= ((float) height)) {
                    i = 1;
                    if (i != 0) {
                        C42750f.m75786cX(currentFocus);
                    }
                }
            }
            i = 0;
            if (i != 0) {
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(11149);
        return dispatchTouchEvent;
    }

    /* renamed from: dx */
    private void m84494dx(int i, int i2) {
        AppMethodBeat.m2504i(11150);
        Button button = (Button) findViewById(i2);
        button.setOnClickListener(new C457288());
        this.jpL[i] = button;
        AppMethodBeat.m2505o(11150);
    }

    /* renamed from: aS */
    public final void mo61472aS(List<LogInfo> list) {
        AppMethodBeat.m2504i(11151);
        if (list == null) {
            AppMethodBeat.m2505o(11151);
            return;
        }
        final LinkedList linkedList = new LinkedList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            LogInfo logInfo = (LogInfo) list.get(i2);
            this.jpE.add(logInfo);
            if ((logInfo.level == this.jpP || this.jpP == 0) && !m84492EX(logInfo.message)) {
                linkedList.add(logInfo);
            }
            i = i2 + 1;
        }
        if (!linkedList.isEmpty()) {
            C26006a.m41506q(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(11145);
                    int itemCount = ConsolePanel.this.jpO.getItemCount();
                    ConsolePanel.this.jpO.jpE.addAll(linkedList);
                    ConsolePanel.this.jpO.mo66310at(itemCount, linkedList.size());
                    if (((LinearLayoutManager) ConsolePanel.this.iIE.getLayoutManager()).mo1782iS() == itemCount - 1) {
                        ConsolePanel.this.iIE.smoothScrollToPosition(ConsolePanel.this.jpO.getItemCount() - 1);
                    }
                    AppMethodBeat.m2505o(11145);
                }
            });
        }
        AppMethodBeat.m2505o(11151);
    }

    /* renamed from: EX */
    private boolean m84492EX(String str) {
        AppMethodBeat.m2504i(11152);
        if (C5046bo.isNullOrNil(this.jpQ) || (str != null && str.toLowerCase().contains(this.jpQ.toLowerCase()))) {
            AppMethodBeat.m2505o(11152);
            return false;
        }
        AppMethodBeat.m2505o(11152);
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ void m84493a(ConsolePanel consolePanel) {
        AppMethodBeat.m2504i(11153);
        consolePanel.jpO.jpE.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < consolePanel.jpE.size()) {
                LogInfo logInfo = (LogInfo) consolePanel.jpE.get(i2);
                if ((consolePanel.jpP <= 0 || logInfo.level == consolePanel.jpP) && !consolePanel.m84492EX(logInfo.message)) {
                    consolePanel.jpO.jpE.add(logInfo);
                }
                i = i2 + 1;
            } else {
                consolePanel.jpO.aop.notifyChanged();
                AppMethodBeat.m2505o(11153);
                return;
            }
        }
    }
}
