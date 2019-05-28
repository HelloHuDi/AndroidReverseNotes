package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
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
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.appbrand.wxawidget.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public class ConsolePanel extends FrameLayout implements a {
    MRecyclerView iIE;
    final List<LogInfo> jpE = new LinkedList();
    EditText jpK;
    Button[] jpL;
    Button jpM;
    Button jpN;
    a jpO;
    int jpP;
    String jpQ;

    public ConsolePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(11146);
        initialize();
        AppMethodBeat.o(11146);
    }

    public ConsolePanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(11147);
        initialize();
        AppMethodBeat.o(11147);
    }

    private void initialize() {
        AppMethodBeat.i(11148);
        LayoutInflater.from(getContext()).inflate(R.layout.py, this, true);
        this.jpK = (EditText) findViewById(R.id.b15);
        this.jpK.clearFocus();
        this.jpL = new Button[5];
        dx(0, R.id.b19);
        dx(1, R.id.b1_);
        dx(2, R.id.b1a);
        dx(3, R.id.b1b);
        dx(4, R.id.b1c);
        this.jpL[0].setSelected(true);
        this.jpP = 0;
        this.jpM = (Button) findViewById(R.id.b17);
        this.jpN = (Button) findViewById(R.id.b18);
        this.jpN.setEnabled(false);
        this.jpM.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(11139);
                ConsolePanel.this.jpE.clear();
                ConsolePanel.this.jpO.jpE.clear();
                ConsolePanel.this.jpO.aop.notifyChanged();
                AppMethodBeat.o(11139);
            }
        });
        this.jpN.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
            }
        });
        this.jpK.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.jpK.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(11140);
                if (i == 66) {
                    ConsolePanel.this.jpQ = ConsolePanel.this.jpK.getText().toString();
                    ConsolePanel.a(ConsolePanel.this);
                    f.cX(view);
                    AppMethodBeat.o(11140);
                    return true;
                }
                AppMethodBeat.o(11140);
                return false;
            }
        });
        this.jpK.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(11141);
                if (!z) {
                    f.cX(view);
                }
                AppMethodBeat.o(11141);
            }
        });
        findViewById(R.id.b16).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(11142);
                ConsolePanel.this.jpQ = ConsolePanel.this.jpK.getText().toString();
                ConsolePanel.a(ConsolePanel.this);
                AppMethodBeat.o(11142);
            }
        });
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(11143);
                f.cX(view);
                AppMethodBeat.o(11143);
                return false;
            }
        });
        this.iIE = (MRecyclerView) findViewById(R.id.b1d);
        this.jpO = new a(getContext());
        MRecyclerView mRecyclerView = this.iIE;
        getContext();
        mRecyclerView.setLayoutManager(new LinearLayoutManager());
        this.iIE.setItemAnimator(null);
        this.iIE.setAdapter(this.jpO);
        AppMethodBeat.o(11148);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(11149);
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
                        f.cX(currentFocus);
                    }
                }
            }
            i = 0;
            if (i != 0) {
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(11149);
        return dispatchTouchEvent;
    }

    private void dx(int i, int i2) {
        AppMethodBeat.i(11150);
        Button button = (Button) findViewById(i2);
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(11144);
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
                        ConsolePanel.a(ConsolePanel.this);
                    }
                    i++;
                }
                AppMethodBeat.o(11144);
            }
        });
        this.jpL[i] = button;
        AppMethodBeat.o(11150);
    }

    public final void aS(List<LogInfo> list) {
        AppMethodBeat.i(11151);
        if (list == null) {
            AppMethodBeat.o(11151);
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
            if ((logInfo.level == this.jpP || this.jpP == 0) && !EX(logInfo.message)) {
                linkedList.add(logInfo);
            }
            i = i2 + 1;
        }
        if (!linkedList.isEmpty()) {
            com.tencent.mm.ce.a.q(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(11145);
                    int itemCount = ConsolePanel.this.jpO.getItemCount();
                    ConsolePanel.this.jpO.jpE.addAll(linkedList);
                    ConsolePanel.this.jpO.at(itemCount, linkedList.size());
                    if (((LinearLayoutManager) ConsolePanel.this.iIE.getLayoutManager()).iS() == itemCount - 1) {
                        ConsolePanel.this.iIE.smoothScrollToPosition(ConsolePanel.this.jpO.getItemCount() - 1);
                    }
                    AppMethodBeat.o(11145);
                }
            });
        }
        AppMethodBeat.o(11151);
    }

    private boolean EX(String str) {
        AppMethodBeat.i(11152);
        if (bo.isNullOrNil(this.jpQ) || (str != null && str.toLowerCase().contains(this.jpQ.toLowerCase()))) {
            AppMethodBeat.o(11152);
            return false;
        }
        AppMethodBeat.o(11152);
        return true;
    }

    static /* synthetic */ void a(ConsolePanel consolePanel) {
        AppMethodBeat.i(11153);
        consolePanel.jpO.jpE.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < consolePanel.jpE.size()) {
                LogInfo logInfo = (LogInfo) consolePanel.jpE.get(i2);
                if ((consolePanel.jpP <= 0 || logInfo.level == consolePanel.jpP) && !consolePanel.EX(logInfo.message)) {
                    consolePanel.jpO.jpE.add(logInfo);
                }
                i = i2 + 1;
            } else {
                consolePanel.jpO.aop.notifyChanged();
                AppMethodBeat.o(11153);
                return;
            }
        }
    }
}
